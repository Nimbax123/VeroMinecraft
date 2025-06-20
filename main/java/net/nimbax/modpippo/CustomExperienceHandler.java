package net.nimbax.modpippo;

import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingExperienceDropEvent;
import net.minecraftforge.event.entity.player.PlayerXpEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "modpippo")
public class CustomExperienceHandler {

    @SubscribeEvent
    public static void onXpChange(PlayerXpEvent.XpChange event) {
        int originalXP = event.getAmount();
        int customXPChange = (int) (originalXP * 0.75); // Moltiplicatore 75%
        CustomExperienceManager.setCustomExperience(CustomExperienceManager.getCustomExperience() + customXPChange);
    }

    @SubscribeEvent
    public static void onXpPickup(PlayerXpEvent.PickupXp event) {
        int originalXP = event.getOrb().getValue();
        int customXPChange = (int) (originalXP * 0.75);
        CustomExperienceManager.setCustomExperience(CustomExperienceManager.getCustomExperience() + customXPChange);

    }
    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event) {
        if (!event.getPlayer().level().isClientSide) {
            int xp = event.getState().getExpDrop(event.getLevel(), event.getPlayer().level().getRandom(), event.getPos(), 0, 0);
            if (xp > 0) {
                int customXP = (int)(xp * 0.75);
                CustomExperienceManager.setCustomExperience(CustomExperienceManager.getCustomExperience() + customXP);
            }
        }
    }
    @SubscribeEvent
    public static void onPlayerDeath(LivingExperienceDropEvent event) {
        if (event.getEntity() instanceof Player){
            event.setDroppedExperience(0);
        }
    }
}