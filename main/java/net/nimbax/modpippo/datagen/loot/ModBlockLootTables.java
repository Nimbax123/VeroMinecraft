package net.nimbax.modpippo.datagen.loot;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import net.nimbax.modpippo.block.PippoBlocks;
import net.nimbax.modpippo.item.PippoItems;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(PippoBlocks.GARNET_BLOCK .get());
        this.dropSelf(PippoBlocks.CHAROITE_BLOCK.get());
        this.dropSelf(PippoBlocks.ELDURITE_BLOCK.get());


        this.add(PippoBlocks.DEEPSLATE_GARNET_ORE.get(),
                block -> createCopperLikeOreDrops(PippoBlocks.DEEPSLATE_GARNET_ORE.get(), PippoItems.RAW_GARNET.get()));
        this.add(PippoBlocks.GARNET_ORE.get(),
                block -> createCopperLikeOreDrops(PippoBlocks.GARNET_ORE.get(), PippoItems.GARNET.get()));
        this.add(PippoBlocks.DEEPSLATE_CHAROITE_ORE.get(),
                block -> createCopperLikeOreDrops(PippoBlocks.DEEPSLATE_GARNET_ORE.get(), PippoItems.CHAROITE.get()));
        this.add(PippoBlocks.NETHER_ELDURITE_ORE.get(),
                block -> createCopperLikeOreDrops(PippoBlocks.NETHER_ELDURITE_ORE.get(), PippoItems.RAW_ELDURITE.get()));
        this.add(PippoBlocks.END_ELDURITE_ORE.get(),
                block -> createCopperLikeOreDrops(PippoBlocks.END_ELDURITE_ORE.get(), PippoItems.RAW_ELDURITE.get()));
    }

    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return PippoBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
