package net.nimbax.modpippo;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "modpippo", value = Dist.CLIENT)
public class CustomExperienceBarRenderer {

    // Specifica la texture per la barra esperienza personalizzata
    private static final ResourceLocation CUSTOM_BAR_TEXTURE =
            new ResourceLocation("modpippo", "textures/gui/custom_experience_bar1.png");

    @SubscribeEvent
    public static void onRenderGuiOverlay(RenderGuiOverlayEvent.Post event) {
        // Controlla che l'evento sia legato alla barra esperienza
        if (!event.getOverlay().id().toString().equals("minecraft:experience_bar")) {
            return;
        }

        Minecraft minecraft = Minecraft.getInstance();
        Player player = minecraft.player;

        // Verifica che il giocatore sia disponibile
        if (player == null) return;

        // --- Valori barra esperienza personalizzata ---
        int customExperienceBar = CustomExperienceManager.getCustomExperience(); // Esperienza attuale
        int maxExperience = CustomExperienceManager.getXPRequiredForNextLevel(CustomExperienceManager.getLevel()); // Massima esperienza
        int level = CustomExperienceManager.getLevel(); // Livello attuale

        // --- Calcolo della posizione e dimensioni della barra ---
        int screenWidth = minecraft.getWindow().getGuiScaledWidth(); // Larghezza schermo
        int screenHeight = minecraft.getWindow().getGuiScaledHeight(); // Altezza schermo

        // Imposta la larghezza e altezza della barra
        int barWidth = 80; // Larghezza standard della barra
        int barHeight = 5; // Altezza ridotta a metà

        // Posizione della barra rispetto allo schermo
        int x = (screenWidth / 2 - 91); // Centrare orizzontalmente
        int y = screenHeight - 60; // Posizionare sopra l'HUD standard

        // Calcola il progresso dall'esperienza attuale rispetto a quella massima
        float progress = maxExperience > 0 ? (float) customExperienceBar / maxExperience : 0;

        // Disegna la barra esperienza
        renderExperienceBar(event.getGuiGraphics(), x, y, barWidth, barHeight, progress);

        // Disegna il testo (esempio: "100 / 200 Lv: 3")
        String expText = " Lv: " + level;
        event.getGuiGraphics().drawString(
                minecraft.font,
                expText,
                x + (barWidth / 2) - (minecraft.font.width(expText) / 2), // Centrare il testo nella barra
                y - 10, // Posiziona sopra la barra
                0xFFFFFF // Colore bianco
        );
    }

    /**
     * Metodo per disegnare la barra esperienza personalizzata usando una texture specifica.
     *
     * @param guiGraphics     Grafica GUI fornita dall'evento.
     * @param x               Coordinata X del disegno sullo schermo.
     * @param y               Coordinata Y del disegno sullo schermo.
     * @param width           Larghezza della barra.
     * @param height          Altezza della barra (ora 5 px).
     * @param progress        Progresso della barra (da 0.0 a 1.0).
     */
    private static void renderExperienceBar(GuiGraphics guiGraphics, int x, int y, int width, int height, float progress) {
        // Dimensioni della tua texture specificata (deve corrispondere alla vera dimensione della texture)
        int textureWidth = 80; // Larghezza della texture reale
        int textureHeight = 20; // Altezza totale della texture reale

        // Disegna lo sfondo della barra (zona vuota della texture)
        guiGraphics.blit(CUSTOM_BAR_TEXTURE, x, y, 0, 0, width, height + 5, textureWidth, textureHeight);

        // Disegna la parte riempita della barra (progresso)
        int progressWidth = (int) (progress * width); // Calcola la larghezza del riempimento
        if (progressWidth > 0) {
            guiGraphics.blit(CUSTOM_BAR_TEXTURE, x, y, 0, 10, progressWidth, height + 5, textureWidth, textureHeight);
        }
    }
}