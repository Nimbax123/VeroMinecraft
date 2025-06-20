package net.nimbax.modpippo.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.nimbax.modpippo.ModPippo;
import net.nimbax.modpippo.block.PippoBlocks;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ModPippo.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TUTORIAL_TAB = CREATIVE_MODE_TABS.register("tutorial_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(PippoItems.GARNET.get()))
                    .title(Component.translatable("creativetab.tutorial_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(PippoItems.GARNET.get());
                        pOutput.accept(PippoItems.RAW_GARNET.get());
                        pOutput.accept(PippoItems.CHAROITE.get());
                        pOutput.accept(PippoItems.RAW_ELDURITE.get());
                        pOutput.accept(PippoItems.ELDURITE.get());
                        pOutput.accept(PippoItems.IRON_HANDLE.get());
                        pOutput.accept(PippoItems.IRON_TOOL_HANDLE.get());


                        pOutput.accept(PippoItems.GARNET_SWORD.get());
                        pOutput.accept(PippoItems.GARNET_PICKAXE.get());
                        pOutput.accept(PippoItems.GARNET_AXE.get());
                        pOutput.accept(PippoItems.GARNET_SHOVEL.get());
                        pOutput.accept(PippoItems.GARNET_HOE.get());

                        pOutput.accept(PippoItems.CHAROITE_SWORD.get());
                        pOutput.accept(PippoItems.CHAROITE_PICKAXE.get());
                        pOutput.accept(PippoItems.CHAROITE_AXE.get());
                        pOutput.accept(PippoItems.CHAROITE_SHOVEL.get());
                        pOutput.accept(PippoItems.CHAROITE_HOE.get());

                        pOutput.accept(PippoItems.ELDURITE_SWORD.get());
                        pOutput.accept(PippoItems.ELDURITE_PICKAXE.get());
                        pOutput.accept(PippoItems.ELDURITE_AXE.get());
                        pOutput.accept(PippoItems.ELDURITE_SHOVEL.get());
                        pOutput.accept(PippoItems.ELDURITE_HOE.get());

                        pOutput.accept(PippoItems.GARNET_HELMET.get());
                        pOutput.accept(PippoItems.GARNET_CHESTPLATE.get());
                        pOutput.accept(PippoItems.GARNET_LEGGINGS.get());
                        pOutput.accept(PippoItems.GARNET_BOOTS.get());

                        pOutput.accept(PippoItems.CHAROITE_HELMET.get());
                        pOutput.accept(PippoItems.CHAROITE_CHESTPLATE.get());
                        pOutput.accept(PippoItems.CHAROITE_LEGGINGS.get());
                        pOutput.accept(PippoItems.CHAROITE_BOOTS.get());

                        pOutput.accept(PippoBlocks.GARNET_BLOCK.get());
                        pOutput.accept(PippoBlocks.GARNET_ORE.get());
                        pOutput.accept(PippoBlocks.CHAROITE_BLOCK.get());
                        pOutput.accept(PippoBlocks.DEEPSLATE_CHAROITE_ORE.get());
                        pOutput.accept(PippoBlocks.DEEPSLATE_GARNET_ORE.get());
                        pOutput.accept(PippoBlocks.NETHER_ELDURITE_ORE.get());
                        pOutput.accept(PippoBlocks.END_ELDURITE_ORE.get());






                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
