package net.nimbax.modpippo.item;

import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nimbax.modpippo.ModPippo;

public class PippoItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ModPippo.MOD_ID);

    public static final RegistryObject<Item> GARNET = ITEMS.register("garnet",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_GARNET = ITEMS.register("raw_garnet",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CHAROITE = ITEMS.register("charoite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ELDURITE = ITEMS.register("eldurite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_ELDURITE = ITEMS.register("raw_eldurite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> IRON_HANDLE = ITEMS.register("iron_handle",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> IRON_TOOL_HANDLE = ITEMS.register("iron_tool_handle",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COPPER_HANDLE = ITEMS.register("copper_handle",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COPPER_TOOL_HANDLE = ITEMS.register("copper_tool_handle",
            () -> new Item(new Item.Properties()));

    //Sword
    public static final RegistryObject<Item> GARNET_SWORD = ITEMS.register("garnet_sword",
            () -> new SwordItem(PippoToolTiers.GARNET, 6, -2.4f, new Item.Properties()));
    public static final RegistryObject<Item> CHAROITE_SWORD = ITEMS.register("charoite_sword",
            () -> new SwordItem(PippoToolTiers.CHAROITE, 7, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> DIAMOND_SWORD = ITEMS.register("diamond_sword",
            () -> new SwordItem(Tiers.DIAMOND, 8, -2.4f, new Item.Properties()));
    public static final RegistryObject<Item> ELDURITE_SWORD = ITEMS.register("eldurite_sword",
            () -> new SwordItem(PippoToolTiers.ELDURITE, 10, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> COPPER_SWORD = ITEMS.register("copper_sword",
            () -> new ShovelItem(PippoToolTiers.COPPER, 3.5f, -3, new Item.Properties()));
    public static final RegistryObject<Item> IRON_SWORD = ITEMS.register("iron_sword",
            () -> new ShovelItem(Tiers.IRON, 3.5f, -3, new Item.Properties()));

//pickaxe
    public static final RegistryObject<Item> GARNET_PICKAXE = ITEMS.register("garnet_pickaxe",
            () -> new PickaxeItem(PippoToolTiers.GARNET, 4, -2.8f, new Item.Properties()));
    public static final RegistryObject<Item> CHAROITE_PICKAXE = ITEMS.register("charoite_pickaxe",
            () -> new PickaxeItem(PippoToolTiers.CHAROITE, 4, -2.8f, new Item.Properties()));
    public static final RegistryObject<Item> ELDURITE_PICKAXE = ITEMS.register("eldurite_pickaxe",
            () -> new PickaxeItem(PippoToolTiers.ELDURITE, 4, -2.8f, new Item.Properties()));
    public static final RegistryObject<Item> DIAMOND_PICKAXE = ITEMS.register("diamond_pickaxe",
            () -> new PickaxeItem(Tiers.DIAMOND, 4, -2.8f, new Item.Properties()));
    public static final RegistryObject<Item> COPPER_PICKAXE = ITEMS.register("copper_pickaxe",
            () -> new ShovelItem(PippoToolTiers.COPPER, 3.5f, -3, new Item.Properties()));
    public static final RegistryObject<Item> IRON_PICKAXE = ITEMS.register("iron_pickaxe",
            () -> new ShovelItem(Tiers.IRON, 3.5f, -3, new Item.Properties()));
    //axe
    public static final RegistryObject<Item> GARNET_AXE = ITEMS.register("garnet_axe",
            () -> new AxeItem(PippoToolTiers.GARNET, 7, -3, new Item.Properties()));
    public static final RegistryObject<Item> CHAROITE_AXE = ITEMS.register("charoite_axe",
            () -> new AxeItem(PippoToolTiers.GARNET, 7, -3, new Item.Properties()));
    public static final RegistryObject<Item> ELDURITE_AXE = ITEMS.register("eldurite_axe",
            () -> new AxeItem(PippoToolTiers.GARNET, 7, -3, new Item.Properties()));
    public static final RegistryObject<Item> DIAMOND_AXE = ITEMS.register("diamond_axe",
            () -> new AxeItem(Tiers.DIAMOND, 7, -3, new Item.Properties()));
    public static final RegistryObject<Item> COPPER_AXE = ITEMS.register("copper_axe",
            () -> new ShovelItem(PippoToolTiers.COPPER, 3.5f, -3, new Item.Properties()));
    public static final RegistryObject<Item> IRON_AXE = ITEMS.register("iron_axe",
            () -> new ShovelItem(Tiers.IRON, 3.5f, -3, new Item.Properties()));
    //Shovel
    public static final RegistryObject<Item> GARNET_SHOVEL = ITEMS.register("garnet_shovel",
            () -> new ShovelItem(PippoToolTiers.GARNET, 3.5f, -3, new Item.Properties()));
    public static final RegistryObject<Item> CHAROITE_SHOVEL = ITEMS.register("charoite_shovel",
            () -> new ShovelItem(PippoToolTiers.CHAROITE, 3.5f, -3, new Item.Properties()));
    public static final RegistryObject<Item> ELDURITE_SHOVEL = ITEMS.register("eldurite_shovel",
            () -> new ShovelItem(PippoToolTiers.ELDURITE, 3.5f, -3, new Item.Properties()));
    public static final RegistryObject<Item> DIAMOND_SHOVEL = ITEMS.register("diamond_shovel",
            () -> new ShovelItem(Tiers.DIAMOND, 3.5f, -3, new Item.Properties()));
    public static final RegistryObject<Item> COPPER_SHOVEL = ITEMS.register("copper_shovel",
            () -> new ShovelItem(PippoToolTiers.COPPER, 3.5f, -3, new Item.Properties()));
    public static final RegistryObject<Item> IRON_SHOVEL = ITEMS.register("iron_shovel",
            () -> new ShovelItem(Tiers.IRON, 3.5f, -3, new Item.Properties()));
    //hoe
    public static final RegistryObject<Item> GARNET_HOE = ITEMS.register("garnet_hoe",
            () -> new HoeItem(PippoToolTiers.GARNET, 0, 0, new Item.Properties()));
    public static final RegistryObject<Item> CHAROITE_HOE = ITEMS.register("charoite_hoe",
            () -> new HoeItem(PippoToolTiers.GARNET, 0, 0, new Item.Properties()));
    public static final RegistryObject<Item> ELDURITE_HOE = ITEMS.register("eldurite_hoe",
            () -> new HoeItem(PippoToolTiers.GARNET, 0, 0, new Item.Properties()));
    public static final RegistryObject<Item> DIAMOND_HOE = ITEMS.register("diamond_hoe",
            () -> new HoeItem(Tiers.DIAMOND, 0, 0, new Item.Properties()));
    public static final RegistryObject<Item> COPPER_HOE = ITEMS.register("copper_hoe",
            () -> new ShovelItem(PippoToolTiers.COPPER, 3.5f, -3, new Item.Properties()));
    public static final RegistryObject<Item> IRON_HOE = ITEMS.register("iron_hoe",
            () -> new ShovelItem(Tiers.IRON, 3.5f, -3, new Item.Properties()));


    public static final RegistryObject<Item> GARNET_HELMET = ITEMS.register("garnet_helmet",
            () -> new ModArmorItem(PippoArmorMaterials.GARNET, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> GARNET_CHESTPLATE = ITEMS.register("garnet_chestplate",
            () -> new ArmorItem(PippoArmorMaterials.GARNET, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> GARNET_LEGGINGS = ITEMS.register("garnet_leggings",
            () -> new ArmorItem(PippoArmorMaterials.GARNET, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> GARNET_BOOTS = ITEMS.register("garnet_boots",
            () -> new ArmorItem(PippoArmorMaterials.GARNET, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> CHAROITE_HELMET = ITEMS.register("charoite_helmet",
            () -> new ModArmorItem(PippoArmorMaterials.CHAROITE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> CHAROITE_CHESTPLATE = ITEMS.register("charoite_chestplate",
            () -> new ArmorItem(PippoArmorMaterials.CHAROITE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> CHAROITE_LEGGINGS = ITEMS.register("charoite_leggings",
            () -> new ArmorItem(PippoArmorMaterials.CHAROITE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> CHAROITE_BOOTS = ITEMS.register("charoite_boots",
            () -> new ArmorItem(PippoArmorMaterials.CHAROITE, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> ELDURITE_HELMET = ITEMS.register("eldurite_helmet",
            () -> new ModArmorItem(PippoArmorMaterials.ELDURITE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> ELDURITE_CHESTPLATE = ITEMS.register("eldurite_chestplate",
            () -> new ArmorItem(PippoArmorMaterials.ELDURITE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> ELDURITE_LEGGINGS = ITEMS.register("eldurite_leggings",
            () -> new ArmorItem(PippoArmorMaterials.ELDURITE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> ELDURITE_BOOTS = ITEMS.register("eldurite_boots",
            () -> new ArmorItem(PippoArmorMaterials.ELDURITE, ArmorItem.Type.BOOTS, new Item.Properties()));





    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
