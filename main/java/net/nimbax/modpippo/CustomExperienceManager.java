package net.nimbax.modpippo;

public class CustomExperienceManager {
    private static final int MAX_LEVEL = 50; // Livello massimo
    private static int customExperience = 0; // Esperienza personalizzata attuale
    private static int maxCustomExperience = 7; // Esperienza massima iniziale
    private static int level = 0; // Livello attuale

    // Restituisce l'esperienza personalizzata
    public static int getCustomExperience() {
        return customExperience;
    }

    // Calcola l'XP necessario per passare al livello successivo
    public static int getXPRequiredForNextLevel(int currentLevel) {
        if (currentLevel < 10) {
            return 2 * (currentLevel + 1) +8; // +1 perché è il livello successivo
        } else if (currentLevel < 16) {
            return 4 * (currentLevel + 1 - 10) + 20;
        } else if (currentLevel < 25) {
            return 6 * (currentLevel + 1 - 16) + 44;
        } else if (currentLevel < 35) {
            return 8 * (currentLevel + 1 - 25) + 98;
        } else if (currentLevel < 45) {
            return 10 * (currentLevel + 1 - 35) + 178;
        } else if (currentLevel < MAX_LEVEL) {
            return 12 * (currentLevel + 1 - 45) + 278;
        } else {
            return Integer.MAX_VALUE; // Se sei già al livello massimo
        }
    }

    // Imposta l'esperienza personalizzata
    public static void setCustomExperience(int experience) {
        customExperience = experience;

        // Gestisce il sistema di livelli
        while (customExperience >= getXPRequiredForNextLevel(level) && level < MAX_LEVEL) {
            customExperience -= getXPRequiredForNextLevel(level); // Rimuovi l'XP richiesto
            incrementLevel(); // Incrementa il livello
        }

        // Ferma l'XP massimo
        if (level >= MAX_LEVEL) {
            customExperience = Math.min(customExperience, getXPRequiredForNextLevel(level - 1));
        }
    }

    // Restituisce quanto manca per il livello successivo
    public static int getXpToNextLevel() {
        if (level >= MAX_LEVEL) {
            return 0; // Se sei al livello massimo, non manca nessuna esperienza
        }
        return getXPRequiredForNextLevel(level) - customExperience;
    }

    // Restituisce il livello massimo consentito
    public static int getMaxLevel() {
        return MAX_LEVEL;
    }

    // Restituisce il livello attuale
    public static int getLevel() {
        return level;
    }

    // Imposta un livello specifico
    public static void setLevel(int newLevel) {
        if (newLevel <= MAX_LEVEL) {
            level = newLevel;
        }
    }

    // Incrementa il livello di uno
    public static void incrementLevel() {
        if (level < MAX_LEVEL) {
            level++;
        }
    }

    // Restituisce l'esperienza massima
    public static int getMaxCustomExperience() {
        return maxCustomExperience;
    }

    // Imposta un nuovo valore massimo per l'esperienza
    public static void setMaxCustomExperience(int maxXP) {
        if (maxXP > 0) {
            maxCustomExperience = maxXP;
        }
    }
}