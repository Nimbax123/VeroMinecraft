package net.nimbax.modpippo;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.server.ServerStartedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "modpippo")
public class WorldDataHandler {

    // Evento chiamato quando il server (e i mondi) vengono caricati
    @SubscribeEvent
    public static void onServerStarted(ServerStartedEvent event) {
        ServerLevel overworld = event.getServer().overworld(); // Ottieni il mondo principale (Overworld)
        WorldData worldData = getWorldData(overworld); // Ottieni o crea i dati del mondo

        // Se il mondo non è stato inizializzato, lo inizializza
        if (!worldData.isInitialized()) {
            worldData.setInitialized(true);

            // Resetta i dati al primo avvio
            resetWorldData();
        }
    }

    private static WorldData getWorldData(ServerLevel serverLevel) {
        return serverLevel.getDataStorage()
                .computeIfAbsent(WorldData::load, WorldData::new, WorldData.DATA_NAME);
    }

    // Reset dei dati globali relativi al mondo
    private static void resetWorldData() {
        CustomExperienceManager.setCustomExperience(0); // Reset esperienza
        CustomExperienceManager.setLevel(0); // Reset livello
        CustomExperienceManager.setMaxCustomExperience(7); // Reimposta max XP al valore iniziale
    }

    // Evento chiamato quando un giocatore entra in gioco
    @SubscribeEvent
    public static void onPlayerJoin(PlayerEvent.PlayerLoggedInEvent event) {
        if (event.getEntity() instanceof ServerPlayer) {

        }
    }

}