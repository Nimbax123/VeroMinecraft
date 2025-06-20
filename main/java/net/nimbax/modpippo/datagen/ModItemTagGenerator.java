package net.nimbax.modpippo.datagen;

import net.nimbax.modpippo.ModPippo;
import net.nimbax.modpippo.item.PippoItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_,
                               CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, ModPippo.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(PippoItems.GARNET_HELMET.get(),
                        PippoItems.GARNET_CHESTPLATE.get(),
                        PippoItems.GARNET_LEGGINGS.get(),
                        PippoItems.GARNET_BOOTS.get(),
                        PippoItems.CHAROITE_HELMET.get(),
                        PippoItems.CHAROITE_CHESTPLATE.get(),
                        PippoItems.CHAROITE_LEGGINGS.get(),
                        PippoItems.CHAROITE_BOOTS.get());
    }
}
