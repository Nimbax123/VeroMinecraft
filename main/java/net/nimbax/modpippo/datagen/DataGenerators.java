package net.nimbax.modpippo.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.nimbax.modpippo.ModPippo;
import java.io.IOException;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = ModPippo.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();


        // Registrazione dei generatori di Server
        generator.addProvider(event.includeServer(), new ModRecipeProvider(packOutput)); // Ricette
        generator.addProvider(event.includeServer(), ModLootTableProvider.create(packOutput)); // Loot Tables

        // Registrazione dei generatori di Client
        generator.addProvider(event.includeClient(), new ModBlockStateProvider(packOutput, existingFileHelper)); // Blocchi
        generator.addProvider(event.includeClient(), new ModItemModelProvider(packOutput, existingFileHelper)); // Modelli Item

        // Generator per Tag
        ModBlockTagGenerator blockTagGenerator = generator.addProvider(event.includeServer(),
                new ModBlockTagGenerator(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(),
                new ModItemTagGenerator(packOutput, lookupProvider, blockTagGenerator.contentsGetter(), existingFileHelper));

        generator.addProvider(event.includeServer(), new ModWorldGenProvider(packOutput, lookupProvider));
    }
}