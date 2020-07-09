package ultimatemod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import net.minecraft.item.ItemGroup;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import ultimatemod.client.renders.UltimateRenderRegistry;
import ultimatemod.structure.featureRegister;



@Mod(Main.MOD_ID)
public class Main 
{
	public static Main instance;
	public static final String MOD_ID = "ultimatemod";
	public static final Logger LOGGER = (Logger) LogManager.getLogger();
	
	
	public static final ItemGroup ultimate_mod = new UltimateModGroup();
	public Main()
	{
		instance = this;
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
		
	}
	
	
	
	private void setup(final FMLCommonSetupEvent event)
	{
		Main.addFeatures();
	}
	
	private static void addFeatures() {
        for (Biome biome : ForgeRegistries.BIOMES.getValues()) {

            if (!BiomeDictionary.hasType(biome, BiomeDictionary.Type.NETHER)
                    && !BiomeDictionary.hasType(biome, BiomeDictionary.Type.END)
                    && !BiomeDictionary.hasType(biome, BiomeDictionary.Type.VOID)
                    && !BiomeDictionary.hasType(biome, BiomeDictionary.Type.OCEAN)
                    && !BiomeDictionary.hasType(biome, BiomeDictionary.Type.RIVER)
                    && !BiomeDictionary.hasType(biome, BiomeDictionary.Type.MUSHROOM)
                    && !BiomeDictionary.hasType(biome, BiomeDictionary.Type.SANDY)
                    && (biome.getRegistryName().getNamespace().equals("minecraft")
                    || biome.getRegistryName().getNamespace().equals("biomesoplenty")
                    || biome.getRegistryName().getNamespace().equals("terraforged"))
                    && (BiomeDictionary.hasType(biome, BiomeDictionary.Type.PLAINS)
                    || BiomeDictionary.hasType(biome, BiomeDictionary.Type.FOREST))
            ) {
                biome.func_235063_a_(featureRegister.BIRCH_HOUSE_STRUCTURE.func_236391_a_(NoFeatureConfig.field_236559_b_));
            }
        }
    }

	
	private void clientSetup(final FMLClientSetupEvent event) 
	{
		UltimateRenderRegistry.registryEntityRenders();
	}
	
	public void onServerStarting(FMLServerStartingEvent event)
	{
		
	}
}
