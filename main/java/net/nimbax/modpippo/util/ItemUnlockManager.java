package net.nimbax.modpippo.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.nimbax.modpippo.CustomExperienceManager;
import net.nimbax.modpippo.ModPippo;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

@Mod.EventBusSubscriber(modid = ModPippo.MOD_ID)
public class ItemUnlockManager {
    private static final Gson GSON = new Gson();
    private static final Map<String, Integer> patternUnlockLevels = new HashMap<>(); // Per "wood", "stone", ecc.

    static {
        try {
            ResourceLocation jsonFile = new ResourceLocation(ModPippo.MOD_ID, "levels/unlockable_items.json");
            try (InputStreamReader reader = new InputStreamReader(
                    ItemUnlockManager.class.getResourceAsStream("/data/" + jsonFile.getNamespace() + "/" + jsonFile.getPath()))) {
                Type type = new TypeToken<Map<String, Integer>>() {}.getType();
                patternUnlockLevels.putAll(GSON.fromJson(reader, type));

                System.out.println("[ItemUnlockManager] Livelli di sblocco caricati: " + patternUnlockLevels);
            }
        } catch (Exception e) {
            System.err.println("[ItemUnlockManager] Errore durante il caricamento del file unlockable_items.json: " + e.getMessage());
        }

        // Configura i pattern di sblocco direttamente nel codice come fallback
        setupDefaultPatternUnlockLevels();
    }

    private static void setupDefaultPatternUnlockLevels() {

        patternUnlockLevels.put("wood", 0);
        patternUnlockLevels.put("stone", 5);
        patternUnlockLevels.put("copper", 10);
        patternUnlockLevels.put("gold", 16);
        patternUnlockLevels.put("iron", 20);
        patternUnlockLevels.put("garnet", 25);
        patternUnlockLevels.put("charoite", 30);
        patternUnlockLevels.put("diamond", 35);
        patternUnlockLevels.put("netherite", 40);
        patternUnlockLevels.put("eldurite", 45);
        patternUnlockLevels.put("dragonsteel", 50);
    }
    
    public static boolean isUnlocked(String name, int level) {
        for (Map.Entry<String, Integer> entry : patternUnlockLevels.entrySet()) {
            if (name.contains(entry.getKey())) { // Verifica se il nome contiene il pattern
                return level >= entry.getValue(); // Controlla il livello rispetto al requisito
            }
        }
        return true; // Se non c'è corrispondenza, è sbloccabile per default
    }

    public static int getRequiredLevel(String name) {
        for (Map.Entry<String, Integer> entry : patternUnlockLevels.entrySet()) {
            if (name.contains(entry.getKey())) {
                return entry.getValue(); // Ritorna il livello richiesto dal pattern
            }
        }
        return -1; // Nessun livello richiesto
    }

    // --- EVENTS ---



    @SubscribeEvent
    public static void onLeftClickBlock(PlayerInteractEvent.LeftClickBlock event) {
        Player player = event.getEntity();
        Item item = event.getItemStack().getItem();

        ResourceLocation itemKey = ForgeRegistries.ITEMS.getKey(item);
        if (itemKey == null) return;

        String blockName = itemKey.getPath();
        int playerLevel = CustomExperienceManager.getLevel();

        if (!isUnlocked(blockName, playerLevel)) {
            event.setCanceled(true); // Blocca l'interazione del left-click
            player.displayClientMessage(Component.literal("Need level: " +
                    getRequiredLevel(blockName)), true);
        }
    }

    @SubscribeEvent
    public static void onPlayerAttackEntity(net.minecraftforge.event.entity.player.AttackEntityEvent event) {
        // Il giocatore che attacca
        Player player = event.getEntity();
        int playerLevel = CustomExperienceManager.getLevel(); // Ottieni il livello del giocatore

        // Il bersaglio dell'attacco deve essere un'entità vivente
        if (!(event.getTarget() instanceof LivingEntity)) {
            return;
        }

        LivingEntity target = (LivingEntity) event.getTarget(); // Bersaglio

        // Ottieni lo strumento o l'arma nelle mani del giocatore
        Item itemInHand = player.getMainHandItem().getItem();
        ResourceLocation itemKey = ForgeRegistries.ITEMS.getKey(itemInHand); // Recupera la chiave dell'oggetto
        String itemName = (itemKey != null) ? itemKey.getPath() : "hands"; // Rinomina "hands" per mani nude

        // Caso 1: Il giocatore sta attaccando a mani nude
        if (itemKey == null) {
            int requiredLevel = 0; // Livello minimo per attaccare a mani nude
            if (playerLevel < requiredLevel) {
                event.setCanceled(true); // Blocco dell'evento
                player.displayClientMessage(Component.literal("Need level: "+ requiredLevel), true);
            }
            return;
        }

        // Caso 2: Il giocatore sta usando un'arma o uno strumento
        if (!isUnlocked(itemName, playerLevel)) {
            event.setCanceled(true); // Blocco dell'attacco
            player.displayClientMessage(Component.literal("Need level: " +
                    getRequiredLevel(itemName)), true);
        }
    }

    @SubscribeEvent
    public static void onBlockPlace(PlayerInteractEvent.RightClickBlock event) {
        Player player = event.getEntity();
        Item item = event.getItemStack().getItem();

        ResourceLocation itemKey = ForgeRegistries.ITEMS.getKey(item);
        if (itemKey == null) return;

        String itemName = itemKey.getPath();
        int playerLevel = CustomExperienceManager.getLevel();

        if (!isUnlocked(itemName, playerLevel)) {
            event.setCanceled(true);
            player.displayClientMessage(Component.literal("Need level: " +
                    getRequiredLevel(itemName)), true);
        }
    }

    @SubscribeEvent
    public static void onItemUse(PlayerInteractEvent.RightClickItem event) {
        Player player = event.getEntity();
        Item item = event.getItemStack().getItem();

        ResourceLocation itemKey = ForgeRegistries.ITEMS.getKey(item);
        if (itemKey == null) return;

        String itemName = itemKey.getPath();
        int playerLevel = CustomExperienceManager.getLevel();

        if (!isUnlocked(itemName, playerLevel)) {
            event.setCanceled(true);
            player.displayClientMessage(Component.literal("Need level: " +
                    getRequiredLevel(itemName)), true);
        }
    }
}