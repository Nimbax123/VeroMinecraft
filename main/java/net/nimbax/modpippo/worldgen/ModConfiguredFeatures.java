package net.nimbax.modpippo.worldgen;

import net.nimbax.modpippo.ModPippo;
import net.nimbax.modpippo.block.PippoBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_GARNET_ORE_KEY = registerKey("garnet_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_CHAROITE_ORE_KEY = registerKey("charoite_pre");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ELDURITE_ORE_KEY = registerKey("eldurite_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_ELDURITE_ORE_KEY = registerKey("end_eldurite_ore");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceable = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplacables = new BlockMatchTest(Blocks.NETHERRACK);
        RuleTest endReplaceables = new BlockMatchTest(Blocks.END_STONE);

        List<OreConfiguration.TargetBlockState> overworldGarnetOres = List.of(OreConfiguration.target(stoneReplaceable,
                PippoBlocks.GARNET_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, PippoBlocks.DEEPSLATE_GARNET_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, PippoBlocks.DEEPSLATE_CHAROITE_ORE.get().defaultBlockState()));


        register(context, OVERWORLD_GARNET_ORE_KEY, Feature.ORE, new OreConfiguration(overworldGarnetOres, 3));
        register(context, OVERWORLD_CHAROITE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldGarnetOres, 3));
        register(context, ELDURITE_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplacables,
                PippoBlocks.NETHER_ELDURITE_ORE.get().defaultBlockState(), 1));
        register(context, END_ELDURITE_ORE_KEY, Feature.ORE, new OreConfiguration(endReplaceables,
                PippoBlocks.END_ELDURITE_ORE.get().defaultBlockState(), 3));
    }


    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(ModPippo.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
