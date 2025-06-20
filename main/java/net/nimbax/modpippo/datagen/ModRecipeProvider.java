package net.nimbax.modpippo.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.nimbax.modpippo.ModPippo;
import net.nimbax.modpippo.block.PippoBlocks;
import net.nimbax.modpippo.item.PippoItems;
import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> GARNET_SMELTABLES = List.of(PippoItems.RAW_GARNET.get(),
            PippoBlocks.DEEPSLATE_GARNET_ORE.get(), PippoBlocks.NETHER_ELDURITE_ORE.get(), PippoBlocks.END_ELDURITE_ORE.get());



    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreSmelting(pWriter, GARNET_SMELTABLES, RecipeCategory.MISC, PippoItems.GARNET.get(), 0.25f, 200, "garnet");
        oreBlasting(pWriter, GARNET_SMELTABLES, RecipeCategory.MISC, PippoItems.GARNET.get(), 0.25f, 100, "garnet");
        //blocks
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, PippoBlocks.GARNET_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', PippoItems.GARNET.get())
                .unlockedBy(getHasName(PippoItems.GARNET.get()), has(PippoItems.GARNET.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, PippoBlocks.CHAROITE_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', PippoItems.CHAROITE.get())
                .unlockedBy(getHasName(PippoItems.CHAROITE.get()), has(PippoItems.CHAROITE.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, PippoBlocks.ELDURITE_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', PippoItems.ELDURITE.get())
                .unlockedBy(getHasName(PippoItems.ELDURITE.get()), has(PippoItems.ELDURITE.get()))
                .save(pWriter);
        //misc
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, PippoItems.IRON_HANDLE.get())
                .pattern("   ")
                .pattern("SSS")
                .pattern(" S ")
                .define('S', Items.IRON_INGOT)
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, PippoItems.COPPER_HANDLE.get())
                .pattern("   ")
                .pattern("SSS")
                .pattern(" S ")
                .define('S', Items.COPPER_INGOT)
                .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, PippoItems.IRON_TOOL_HANDLE.get())
                .pattern("   ")
                .pattern(" S ")
                .pattern(" S ")
                .define('S', Items.IRON_INGOT)
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, PippoItems.COPPER_TOOL_HANDLE.get())
                .pattern("   ")
                .pattern(" S ")
                .pattern(" S ")
                .define('S', Items.COPPER_INGOT)
                .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                .save(pWriter);
        //Pickaxe
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, PippoItems.CHAROITE_PICKAXE.get())
                .pattern("CCC")
                .pattern(" H ")
                .pattern(" H ")
                .define('H', PippoItems.IRON_TOOL_HANDLE.get())
                .define('C', PippoItems.CHAROITE.get())
                .unlockedBy(getHasName(PippoItems.CHAROITE.get()), has(PippoItems.CHAROITE.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, PippoItems.ELDURITE_PICKAXE.get())
                .pattern("CCC")
                .pattern(" H ")
                .pattern(" H ")
                .define('H', PippoItems.IRON_TOOL_HANDLE.get())
                .define('C', PippoItems.ELDURITE.get())
                .unlockedBy(getHasName(PippoItems.ELDURITE.get()), has(PippoItems.ELDURITE.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, PippoItems.GARNET_PICKAXE.get())
                .pattern("CCC")
                .pattern(" H ")
                .pattern(" H ")
                .define('H', PippoItems.IRON_TOOL_HANDLE.get())
                .define('C', PippoItems.GARNET.get())
                .unlockedBy(getHasName(PippoItems.GARNET.get()), has(PippoItems.GARNET.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, PippoItems.DIAMOND_PICKAXE.get())
                .pattern("CCC")
                .pattern(" H ")
                .pattern(" H ")
                .define('H', PippoItems.IRON_TOOL_HANDLE.get())
                .define('C', Items.DIAMOND)
                .unlockedBy(getHasName(Items.DIAMOND), has(Items.DIAMOND));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, PippoItems.COPPER_PICKAXE.get())
                .pattern("CCC")
                .pattern(" H ")
                .pattern(" H ")
                .define('H', Items.STICK)
                .define('C', Items.COPPER_INGOT)
                .unlockedBy(getHasName(Items.COPPER_ORE), has(Items.COPPER_ORE))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, Items.AIR)
                .pattern("###")
                .pattern(" x ")
                .pattern(" x ")
                .define('#', Items.DIAMOND)
                .define('x', Items.STICK)
                .unlockedBy("has_diamond", has(Items.DIAMOND))
                .save(pWriter, new ResourceLocation("minecraft", "diamond_pickaxe"));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, Items.AIR)
                .pattern("###")
                .pattern(" x ")
                .pattern(" x ")
                .define('#', Items.IRON_INGOT)
                .define('x', Items.STICK)
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .save(pWriter, new ResourceLocation("minecraft", "iron_pickaxe"));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, PippoItems.IRON_PICKAXE.get())
                .pattern("CCC")
                .pattern(" H ")
                .pattern(" H ")
                .define('H', PippoItems.COPPER_TOOL_HANDLE.get())
                .define('C', Items.IRON_INGOT)
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .save(pWriter);
        //Axe
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, PippoItems.GARNET_AXE.get())
                .pattern("CC")
                .pattern("CH")
                .pattern(" H")
                .define('H', PippoItems.IRON_TOOL_HANDLE.get())
                .define('C', PippoItems.GARNET.get())
                .unlockedBy(getHasName(PippoItems.GARNET.get()), has(PippoItems.GARNET.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, PippoItems.CHAROITE_AXE.get())
                .pattern("CC")
                .pattern("CH")
                .pattern(" H")
                .define('H', PippoItems.IRON_TOOL_HANDLE.get())
                .define('C', PippoItems.CHAROITE.get())
                .unlockedBy(getHasName(PippoItems.CHAROITE.get()), has(PippoItems.CHAROITE.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, PippoItems.ELDURITE_AXE.get())
                .pattern("CC")
                .pattern("CH")
                .pattern(" H")
                .define('H', PippoItems.IRON_TOOL_HANDLE.get())
                .define('C', PippoItems.ELDURITE.get())
                .unlockedBy(getHasName(PippoItems.ELDURITE.get()), has(PippoItems.ELDURITE.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, PippoItems.DIAMOND_AXE.get())
                .pattern("CC")
                .pattern("CH")
                .pattern(" H")
                .define('H', PippoItems.IRON_TOOL_HANDLE.get())
                .define('C', Items.DIAMOND)
                .unlockedBy(getHasName(Items.DIAMOND), has(Items.DIAMOND))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, PippoItems.COPPER_AXE.get())
                .pattern("CC")
                .pattern("CH")
                .pattern(" H")
                .define('H', Items.STICK)
                .define('C', Items.COPPER_INGOT)
                .unlockedBy(getHasName(Items.COPPER_ORE), has(Items.COPPER_ORE))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, Items.AIR)
                .pattern("##")
                .pattern("#x")
                .pattern(" x")
                .define('#', Items.DIAMOND)
                .define('x', Items.STICK)
                .unlockedBy("has_diamond", has(Items.DIAMOND))
                .save(pWriter, new ResourceLocation("minecraft", "diamond_axe"));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, Items.AIR)
                .pattern("###")
                .pattern("#x ")
                .pattern(" x ")
                .define('#', Items.IRON_INGOT)
                .define('x', Items.STICK)
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .save(pWriter, new ResourceLocation("minecraft", "iron_axe"));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, PippoItems.IRON_AXE.get())
                .pattern("CC")
                .pattern("CH")
                .pattern(" H")
                .define('H', PippoItems.COPPER_TOOL_HANDLE.get())
                .define('C', Items.IRON_INGOT)
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .save(pWriter);
        //Shovel
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, PippoItems.ELDURITE_SHOVEL.get())
                .pattern("C")
                .pattern("H")
                .pattern("H")
                .define('H', PippoItems.IRON_TOOL_HANDLE.get())
                .define('C', PippoItems.ELDURITE.get())
                .unlockedBy(getHasName(PippoItems.ELDURITE.get()), has(PippoItems.ELDURITE.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, PippoItems.CHAROITE_SHOVEL.get())
                .pattern("C")
                .pattern("H")
                .pattern("H")
                .define('H', PippoItems.IRON_TOOL_HANDLE.get())
                .define('C', PippoItems.CHAROITE.get())
                .unlockedBy(getHasName(PippoItems.CHAROITE.get()), has(PippoItems.CHAROITE.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, PippoItems.GARNET_SHOVEL.get())
                .pattern("C")
                .pattern("H")
                .pattern("H")
                .define('H', PippoItems.IRON_TOOL_HANDLE.get())
                .define('C', PippoItems.GARNET.get())
                .unlockedBy(getHasName(PippoItems.GARNET.get()), has(PippoItems.GARNET.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, PippoItems.DIAMOND_SHOVEL.get())
                .pattern("C")
                .pattern("H")
                .pattern("H")
                .define('H', PippoItems.IRON_TOOL_HANDLE.get())
                .define('C', Items.DIAMOND)
                .unlockedBy(getHasName(Items.DIAMOND), has(Items.DIAMOND))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, PippoItems.COPPER_SHOVEL.get())
                .pattern("C")
                .pattern("H")
                .pattern("H")
                .define('H', Items.STICK)
                .define('C', Items.COPPER_INGOT)
                .unlockedBy(getHasName(Items.COPPER_ORE), has(Items.COPPER_ORE))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, Items.AIR)
                .pattern("#")
                .pattern("x")
                .pattern("x")
                .define('#', Items.DIAMOND)
                .define('x', Items.STICK)
                .unlockedBy("has_diamond", has(Items.DIAMOND))
                .save(pWriter, new ResourceLocation("minecraft", "diamond_shovel"));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, Items.AIR)
                .pattern("#")
                .pattern("x")
                .pattern("x")
                .define('#', Items.IRON_INGOT)
                .define('x', Items.STICK)
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .save(pWriter, new ResourceLocation("minecraft", "iron_shovel"));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, PippoItems.IRON_SHOVEL.get())
                .pattern("C")
                .pattern("H")
                .pattern("H")
                .define('H', PippoItems.COPPER_TOOL_HANDLE.get())
                .define('C', Items.IRON_INGOT)
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .save(pWriter);
        //hoe
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, PippoItems.GARNET_HOE.get())
                .pattern("CC")
                .pattern("H ")
                .pattern("H ")
                .define('H', PippoItems.IRON_TOOL_HANDLE.get())
                .define('C', PippoItems.GARNET.get())
                .unlockedBy(getHasName(PippoItems.GARNET.get()), has(PippoItems.GARNET.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, PippoItems.CHAROITE_HOE.get())
                .pattern("CC")
                .pattern("H ")
                .pattern("H ")
                .define('H', PippoItems.IRON_TOOL_HANDLE.get())
                .define('C', PippoItems.CHAROITE.get())
                .unlockedBy(getHasName(PippoItems.CHAROITE.get()), has(PippoItems.CHAROITE.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, PippoItems.ELDURITE_HOE.get())
                .pattern("CC")
                .pattern("H ")
                .pattern("H ")
                .define('H', PippoItems.IRON_TOOL_HANDLE.get())
                .define('C', PippoItems.ELDURITE.get())
                .unlockedBy(getHasName(PippoItems.ELDURITE.get()), has(PippoItems.ELDURITE.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, PippoItems.DIAMOND_HOE.get())
                .pattern("CC")
                .pattern("H ")
                .pattern("H ")
                .define('H', PippoItems.IRON_TOOL_HANDLE.get())
                .define('C', Items.DIAMOND)
                .unlockedBy(getHasName(Items.DIAMOND), has(Items.DIAMOND))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, PippoItems.COPPER_HOE.get())
                .pattern("CC")
                .pattern("H ")
                .pattern("H ")
                .define('H', Items.STICK)
                .define('C', Items.COPPER_INGOT)
                .unlockedBy(getHasName(Items.COPPER_ORE), has(Items.COPPER_ORE))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, Items.AIR)
                .pattern("##")
                .pattern(" x")
                .pattern(" x")
                .define('#', Items.DIAMOND)
                .define('x', Items.STICK)
                .unlockedBy("has_diamond", has(Items.DIAMOND))
                .save(pWriter, new ResourceLocation("minecraft", "diamond_hoe"));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, Items.AIR)
                .pattern("##")
                .pattern(" x")
                .pattern(" x")
                .define('#', Items.IRON_INGOT)
                .define('x', Items.STICK)
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .save(pWriter, new ResourceLocation("minecraft", "iron_hoe"));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, PippoItems.IRON_HOE.get())
                .pattern("CC")
                .pattern(" H")
                .pattern(" H")
                .define('H', PippoItems.COPPER_TOOL_HANDLE.get())
                .define('C', Items.IRON_INGOT)
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .save(pWriter);
        //sword
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, PippoItems.CHAROITE_SWORD.get())
                .pattern("C")
                .pattern("C")
                .pattern("H")
                .define('H', PippoItems.IRON_HANDLE.get())
                .define('C', PippoItems.CHAROITE.get())
                .unlockedBy(getHasName(PippoItems.CHAROITE.get()), has(PippoItems.CHAROITE.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, PippoItems.ELDURITE_SWORD.get())
                .pattern("C")
                .pattern("C")
                .pattern("H")
                .define('H', PippoItems.IRON_HANDLE.get())
                .define('C', PippoItems.ELDURITE.get())
                .unlockedBy(getHasName(PippoItems.ELDURITE.get()), has(PippoItems.ELDURITE.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, PippoItems.GARNET_SWORD.get())
                .pattern("C")
                .pattern("C")
                .pattern("H")
                .define('H', PippoItems.IRON_HANDLE.get())
                .define('C', PippoItems.GARNET.get())
                .unlockedBy(getHasName(PippoItems.GARNET.get()), has(PippoItems.GARNET.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, PippoItems.DIAMOND_SWORD.get())
                .pattern("C")
                .pattern("C")
                .pattern("H")
                .define('H', PippoItems.IRON_HANDLE.get())
                .define('C', Items.DIAMOND)
                .unlockedBy(getHasName(Items.DIAMOND), has(Items.DIAMOND))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, PippoItems.COPPER_SWORD.get())
                .pattern("C")
                .pattern("C")
                .pattern("H")
                .define('H', Items.STICK)
                .define('C', Items.COPPER_INGOT)
                .unlockedBy(getHasName(Items.COPPER_ORE), has(Items.COPPER_ORE))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, PippoItems.IRON_SWORD.get())
                .pattern("C")
                .pattern("C")
                .pattern("H")
                .define('H', PippoItems.COPPER_HANDLE.get())
                .define('C', Items.IRON_INGOT)
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, Items.AIR)
                .pattern("###")     // Top row: diamonds
                .pattern(" # ")     // Middle row: handle
                .pattern(" x ")     // Bottom row: empty
                .define('#', Items.DIAMOND)
                .define('x', Items.STICK)
                .unlockedBy("has_diamond", has(Items.DIAMOND))
                .save(pWriter, new ResourceLocation("minecraft", "diamond_sword"));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, Items.AIR)
                .pattern("###")
                .pattern(" # ")
                .pattern(" x ")
                .define('#', Items.IRON_INGOT)
                .define('x', Items.STICK)
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .save(pWriter, new ResourceLocation("minecraft", "iron_sword"));
        //helmet
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, PippoItems.GARNET_HELMET.get())
                .pattern("CCC")
                .pattern("C C")
                .pattern("   ")
                .define('C', PippoItems.GARNET.get())
                .unlockedBy(getHasName(PippoItems.GARNET.get()), has(PippoItems.GARNET.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, PippoItems.CHAROITE_HELMET.get())
                .pattern("CCC")
                .pattern("C C")
                .pattern("   ")
                .define('C', PippoItems.CHAROITE.get())
                .unlockedBy(getHasName(PippoItems.CHAROITE.get()), has(PippoItems.CHAROITE.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, PippoItems.ELDURITE_HELMET.get())
                .pattern("CCC")
                .pattern("C C")
                .pattern("   ")
                .define('C', PippoItems.ELDURITE.get())
                .unlockedBy(getHasName(PippoItems.ELDURITE.get()), has(PippoItems.ELDURITE.get()))
                .save(pWriter);
        //Chestplate
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, PippoItems.GARNET_CHESTPLATE.get())
                .pattern("C C")
                .pattern("CCC")
                .pattern("CCC")
                .define('C', PippoItems.GARNET.get())
                .unlockedBy(getHasName(PippoItems.GARNET.get()), has(PippoItems.GARNET.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, PippoItems.CHAROITE_CHESTPLATE.get())
                .pattern("C C")
                .pattern("CCC")
                .pattern("CCC")
                .define('C', PippoItems.CHAROITE.get())
                .unlockedBy(getHasName(PippoItems.CHAROITE.get()), has(PippoItems.CHAROITE.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, PippoItems.ELDURITE_CHESTPLATE.get())
                .pattern("C C")
                .pattern("CCC")
                .pattern("CCC")
                .define('C', PippoItems.ELDURITE.get())
                .unlockedBy(getHasName(PippoItems.ELDURITE.get()), has(PippoItems.ELDURITE.get()))
                .save(pWriter);
        //leggings
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, PippoItems.ELDURITE_LEGGINGS.get())
                .pattern("CCC")
                .pattern("C C")
                .pattern("C C")
                .define('C', PippoItems.ELDURITE.get())
                .unlockedBy(getHasName(PippoItems.ELDURITE.get()), has(PippoItems.ELDURITE.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, PippoItems.CHAROITE_LEGGINGS.get())
                .pattern("CCC")
                .pattern("C C")
                .pattern("C C")
                .define('C', PippoItems.CHAROITE.get())
                .unlockedBy(getHasName(PippoItems.CHAROITE.get()), has(PippoItems.CHAROITE.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, PippoItems.GARNET_LEGGINGS.get())
                .pattern("CCC")
                .pattern("C C")
                .pattern("C C")
                .define('C', PippoItems.GARNET.get())
                .unlockedBy(getHasName(PippoItems.GARNET.get()), has(PippoItems.GARNET.get()))
                .save(pWriter);
        //boots
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, PippoItems.GARNET_BOOTS.get())
                .pattern("   ")
                .pattern("C C")
                .pattern("C C")
                .define('C', PippoItems.GARNET.get())
                .unlockedBy(getHasName(PippoItems.GARNET.get()), has(PippoItems.GARNET.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, PippoItems.CHAROITE_BOOTS.get())
                .pattern("   ")
                .pattern("C C")
                .pattern("C C")
                .define('C', PippoItems.CHAROITE.get())
                .unlockedBy(getHasName(PippoItems.CHAROITE.get()), has(PippoItems.CHAROITE.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, PippoItems.ELDURITE_BOOTS.get())
                .pattern("   ")
                .pattern("C C")
                .pattern("C C")
                .define('C', PippoItems.ELDURITE.get())
                .unlockedBy(getHasName(PippoItems.ELDURITE.get()), has(PippoItems.ELDURITE.get()))
                .save(pWriter);

    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                    pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer,  ModPippo.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
