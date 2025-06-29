package net.nimbax.modpippo.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nimbax.modpippo.ModPippo;
import net.nimbax.modpippo.item.PippoItems;

import java.util.LinkedHashMap;

public class ModItemModelProvider extends ItemModelProvider {
    private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ModPippo.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        handheldItem(PippoItems.GARNET_SWORD);
        handheldItem(PippoItems.GARNET_AXE);
        handheldItem(PippoItems.GARNET_HOE);
        handheldItem(PippoItems.GARNET_SHOVEL);
        handheldItem(PippoItems.GARNET_PICKAXE);

        handheldItem(PippoItems.CHAROITE_SWORD);
        handheldItem(PippoItems.CHAROITE_AXE);
        handheldItem(PippoItems.CHAROITE_HOE);
        handheldItem(PippoItems.CHAROITE_SHOVEL);
        handheldItem(PippoItems.CHAROITE_PICKAXE);

        handheldItem(PippoItems.ELDURITE_SWORD);
        handheldItem(PippoItems.ELDURITE_AXE);
        handheldItem(PippoItems.ELDURITE_HOE);
        handheldItem(PippoItems.ELDURITE_SHOVEL);
        handheldItem(PippoItems.ELDURITE_PICKAXE);

        handheldItem(PippoItems.DIAMOND_SWORD);
        handheldItem(PippoItems.DIAMOND_AXE);
        handheldItem(PippoItems.DIAMOND_HOE);
        handheldItem(PippoItems.DIAMOND_SHOVEL);
        handheldItem(PippoItems.DIAMOND_PICKAXE);

        handheldItem(PippoItems.COPPER_SWORD);
        handheldItem(PippoItems.COPPER_AXE);
        handheldItem(PippoItems.COPPER_HOE);
        handheldItem(PippoItems.COPPER_SHOVEL);
        handheldItem(PippoItems.COPPER_PICKAXE);

        handheldItem(PippoItems.IRON_SWORD);
        handheldItem(PippoItems.IRON_AXE);
        handheldItem(PippoItems.IRON_HOE);
        handheldItem(PippoItems.IRON_SHOVEL);
        handheldItem(PippoItems.IRON_PICKAXE);

        simpleItem(PippoItems.GARNET);
        simpleItem(PippoItems.CHAROITE);
        simpleItem(PippoItems.ELDURITE);
        simpleItem(PippoItems.RAW_GARNET);
        simpleItem(PippoItems.RAW_ELDURITE);
        simpleItem(PippoItems.IRON_HANDLE);
        simpleItem(PippoItems.IRON_TOOL_HANDLE);
        simpleItem(PippoItems.COPPER_HANDLE);
        simpleItem(PippoItems.COPPER_TOOL_HANDLE);

        trimmedArmorItem(PippoItems.GARNET_HELMET);
        trimmedArmorItem(PippoItems.GARNET_CHESTPLATE);
        trimmedArmorItem(PippoItems.GARNET_LEGGINGS);
        trimmedArmorItem(PippoItems.GARNET_BOOTS);

        trimmedArmorItem(PippoItems.CHAROITE_HELMET);
        trimmedArmorItem(PippoItems.CHAROITE_CHESTPLATE);
        trimmedArmorItem(PippoItems.CHAROITE_LEGGINGS);
        trimmedArmorItem(PippoItems.CHAROITE_BOOTS);
    }

    // Shoutout to El_Redstoniano for making this
    private void trimmedArmorItem(RegistryObject<Item> itemRegistryObject) {
        final String MOD_ID = ModPippo.MOD_ID; // Change this to your mod id

        if(itemRegistryObject.get() instanceof ArmorItem armorItem) {
            trimMaterials.entrySet().forEach(entry -> {

                ResourceKey<TrimMaterial> trimMaterial = entry.getKey();
                float trimValue = entry.getValue();

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = "item/" + armorItem;
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = new ResourceLocation(MOD_ID, armorItemPath);
                ResourceLocation trimResLoc = new ResourceLocation(trimPath); // minecraft namespace
                ResourceLocation trimNameResLoc = new ResourceLocation(MOD_ID, currentTrimName);

                // This is used for making the ExistingFileHelper acknowledge that this texture exist, so this will
                // avoid an IllegalArgumentException
                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                // Trimmed armorItem files
                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc)
                        .texture("layer1", trimResLoc);

                // Non-trimmed armorItem file (normal variant)
                this.withExistingParent(itemRegistryObject.getId().getPath(),
                                mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                new ResourceLocation(MOD_ID,
                                        "item/" + itemRegistryObject.getId().getPath()));
            });
        }
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(ModPippo.MOD_ID,"item/" + item.getId().getPath()));
    }

    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(ModPippo.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    public void trapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  new ResourceLocation(ModPippo.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  new ResourceLocation(ModPippo.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  new ResourceLocation(ModPippo.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(ModPippo.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(ModPippo.MOD_ID,"item/" + item.getId().getPath()));
    }
}
