package net.nimbax.modpippo.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.nimbax.modpippo.ModPippo;
import net.nimbax.modpippo.block.PippoBlocks;
import net.nimbax.modpippo.util.PippoTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, ModPippo.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(PippoBlocks.GARNET_BLOCK.get(),
                        PippoBlocks.GARNET_ORE.get(),
                        PippoBlocks.DEEPSLATE_GARNET_ORE.get(),
                        PippoBlocks.NETHER_ELDURITE_ORE.get(),
                        PippoBlocks.END_ELDURITE_ORE.get(),
                        PippoBlocks.DEEPSLATE_CHAROITE_ORE.get(),
                        PippoBlocks.CHAROITE_BLOCK.get());


        this.tag(BlockTags.NEEDS_IRON_TOOL).add(PippoBlocks.GARNET_BLOCK.get(), PippoBlocks.GARNET_ORE.get(), PippoBlocks.DEEPSLATE_GARNET_ORE.get(),
                PippoBlocks.CHAROITE_BLOCK.get(), PippoBlocks.DEEPSLATE_CHAROITE_ORE.get());

        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL).add(PippoBlocks.END_ELDURITE_ORE.get());
        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL).add(PippoBlocks.NETHER_ELDURITE_ORE.get());




    }
}