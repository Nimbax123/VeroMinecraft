package net.nimbax.modpippo;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.nimbax.modpippo.CustomExperienceManager;

@Mod.EventBusSubscriber(modid = "modpippo")
public class PlayerDataHandler {

    private static final String EXPERIENCE_TAG = "CustomExperience";
    private static final String LEVEL_TAG = "CustomLevel";

    // Salva i dati del giocatore nel NBT persistente
    public static void savePlayerData(Player player) {
        if (player != null && !player.getCommandSenderWorld().isClientSide) { // Solo lato server
            CompoundTag playerData = player.getPersistentData();
            playerData.putInt(EXPERIENCE_TAG, CustomExperienceManager.getCustomExperience());
            playerData.putInt(LEVEL_TAG, CustomExperienceManager.getLevel());
        }
    }

    // Carica i dati del giocatore dal NBT persistente
    public static void loadPlayerData(Player player) {
        if (player != null && !player.getCommandSenderWorld().isClientSide) { // Solo lato server
            CompoundTag playerData = player.getPersistentData();

            if (playerData.contains(EXPERIENCE_TAG)) {
                CustomExperienceManager.setCustomExperience(playerData.getInt(EXPERIENCE_TAG));
            }
            if (playerData.contains(LEVEL_TAG)) {
                CustomExperienceManager.setLevel(playerData.getInt(LEVEL_TAG));
            }
        }
    }

    // Evento chiamato al login del giocatore
    @SubscribeEvent
    public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        if (event.getEntity() instanceof ServerPlayer player) {
            loadPlayerData(player); // Carica i dati salvati nel gestore
        }
    }

    // Evento chiamato al logout del giocatore
    @SubscribeEvent
    public static void onPlayerLoggedOut(PlayerEvent.PlayerLoggedOutEvent event) {
        if (event.getEntity() instanceof ServerPlayer player) {
            savePlayerData(player); // Salva i dati del giocatore
        }
    }

    // Salvataggio dati periodico nel tick finale
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END && !event.player.getCommandSenderWorld().isClientSide) {
            savePlayerData(event.player);
        }
    }
}