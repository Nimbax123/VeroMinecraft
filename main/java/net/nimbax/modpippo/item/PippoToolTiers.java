package net.nimbax.modpippo.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;
import net.minecraftforge.common.Tags;
import net.nimbax.modpippo.ModPippo;
import net.nimbax.modpippo.util.PippoTags;

import java.util.List;

public class PippoToolTiers {

    // Dichiarazione dei livelli di mining
    public static final Tier GARNET;
    public static final Tier CHAROITE;
    public static final Tier ELDURITE;
    public static final Tier COPPER;


    static {
        COPPER = TierSortingRegistry.registerTier(
                new ForgeTier(2, 750, 7.0F, 2.5F, 20,
                        PippoTags.Blocks.NEEDS_COPPER_TOOL, () -> Ingredient.of(Items.COPPER_INGOT)),
                new ResourceLocation(ModPippo.MOD_ID, "copper"), List.of(Tiers.STONE), List.of(Tiers.IRON));

        GARNET = TierSortingRegistry.registerTier(
                new ForgeTier(2, 750, 7.0F, 2.5F, 20,
                        PippoTags.Blocks.NEEDS_GARNET_TOOL, () -> Ingredient.of(PippoItems.GARNET.get())),
                new ResourceLocation(ModPippo.MOD_ID, "garnet"), List.of(Tiers.IRON), List.of(Tiers.DIAMOND));

        CHAROITE = TierSortingRegistry.registerTier(
                new ForgeTier(2, 1250, 8.0F, 3.0F, 25,
                        PippoTags.Blocks.NEEDS_CHAROITE_TOOL, () -> Ingredient.of(PippoItems.CHAROITE.get())),
                new ResourceLocation(ModPippo.MOD_ID, "charoite"), List.of(Tiers.IRON), List.of(Tiers.DIAMOND));

        ELDURITE = TierSortingRegistry.registerTier(
                new ForgeTier(5, 3000, 10.0F, 4.0F, 30,
                        PippoTags.Blocks.NEEDS_ELDURITE_TOOL, () -> Ingredient.of(PippoItems.ELDURITE.get())),
                new ResourceLocation(ModPippo.MOD_ID, "eldurite"), List.of(Tiers.NETHERITE), List.of());

    }
}