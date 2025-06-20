package net.nimbax.modpippo;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.saveddata.SavedData;

public class WorldData extends SavedData {

    // Nome del file di salvataggio per WorldData
    public static final String DATA_NAME = "modpippo_data";

    private boolean initialized = false; // Flag per verificare se il mondo è già stato inizializzato

    // Costruttore vuoto
    public WorldData() {}

    // Getter per verificare se il mondo è inizializzato
    public boolean isInitialized() {
        return initialized;
    }

    // Setter per contrassegnare il mondo come inizializzato
    public void setInitialized(boolean initialized) {
        this.initialized = initialized;
        this.setDirty(); // Segnala a Forge che i dati sono stati modificati
    }

    // Salvataggio dei dati nel file (dati persistenti del mondo)
    @Override
    public CompoundTag save(CompoundTag tag) {
        tag.putBoolean("initialized", initialized);
        return tag;
    }

    // Metodo statico per caricare i dati dal file persistente
    public static WorldData load(CompoundTag tag) {
        WorldData data = new WorldData();
        data.initialized = tag.getBoolean("initialized");
        return data;
    }
}