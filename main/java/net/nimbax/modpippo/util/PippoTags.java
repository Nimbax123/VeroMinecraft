package net.nimbax.modpippo.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.nimbax.modpippo.ModPippo;

public class PippoTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_GARNET_TOOL = tag("needs_garnet_tool");
        public static final TagKey<Block> NEEDS_CHAROITE_TOOL = tag("needs_chariote_tool");
        public static final TagKey<Block> NEEDS_ELDURITE_TOOL = tag("needs_eldurite_tool");
        public static final TagKey<Block> NEEDS_COPPER_TOOL = tag("needs_copper_tool");

    }

    private static TagKey<Block> tag(String name) {
        return BlockTags.create(new ResourceLocation(ModPippo.MOD_ID, name));
    }

    public static class Items {

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(ModPippo.MOD_ID, name));
        }
    }
}
