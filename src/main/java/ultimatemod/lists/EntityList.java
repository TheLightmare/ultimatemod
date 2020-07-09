package ultimatemod.lists;

import ultimatemod.Main;
import ultimatemod.entities.DwarfEntity;
import ultimatemod.events.RegistryEvents;
import net.minecraftforge.event.RegistryEvent;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.biome.Biomes;

public class EntityList {
	
	public static EntityType<?> DWARF_ENTITY = EntityType.Builder.create(DwarfEntity::new, EntityClassification.CREATURE).build(Main.MOD_ID + ":dwarf_entity").setRegistryName(RegistryEvents.location("dwarf_entity"));
	
	public static void registerEntitySpawnEggs(final RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll(
		
				ItemList.dwarf_entity_egg = registerEntitySpawnEgg(DWARF_ENTITY, 0x734234, 0x000000, "dwarf_entity_egg")
				);
	}
	
	
	
	public static void registerEntityWorldSpawns()
	{
		registerEntityWorldSpawn(DWARF_ENTITY, EntityClassification.CREATURE, Biomes.PLAINS, Biomes.BEACH);
	}
	
	
	public static Item registerEntitySpawnEgg(EntityType<?> type, int color1, int color2, String name)
	{
		SpawnEggItem item = new SpawnEggItem(type, color1, color2, new Item.Properties().group(Main.ultimate_mod));
		item.setRegistryName(RegistryEvents.location(name));
		return item;
	}
	
	public static void registerEntityWorldSpawn(EntityType<?> entity, EntityClassification classification, Biome... biomes)
	{
		for(Biome biome : biomes)
		{
			if (biome != null)
			{
				biome.getSpawns(classification).add(new SpawnListEntry(entity, 10, 1, 100));
			}
		}
	}
	// public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.ENTITIES, Main.MOD_ID);

	// public static final RegistryObject<EntityType<Dwarf_entity>> DWARF_ENTITY = ENTITY_TYPES.register("Dwarf_entity", () -> EntityType.Builder<Dwarf_entity>create(Dwarf_entity::new, EntityClassification.CREATURE).size(0.5f, 1.5f).build(new ResourceLocation(Main.MOD_ID, "Dwarf_entity").toString()));
}
