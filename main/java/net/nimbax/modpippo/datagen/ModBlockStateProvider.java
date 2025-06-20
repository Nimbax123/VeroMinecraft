package net.nimbax.modpippo.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.nimbax.modpippo.ModPippo;
import net.nimbax.modpippo.block.PippoBlocks;


public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, ModPippo.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(PippoBlocks.GARNET_BLOCK);
        blockWithItem(PippoBlocks.DEEPSLATE_GARNET_ORE);
        blockWithItem(PippoBlocks.GARNET_ORE);
        blockWithItem(PippoBlocks.NETHER_ELDURITE_ORE);
        blockWithItem(PippoBlocks.DEEPSLATE_CHAROITE_ORE);
        blockWithItem(PippoBlocks.CHAROITE_BLOCK);


    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
