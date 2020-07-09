package ultimatemod.events;



import org.apache.logging.log4j.Logger;

import net.minecraft.block.Block;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.WallBlock;
import net.minecraft.block.material.Material;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import ultimatemod.Main;
import ultimatemod.entities.DwarfEntity;
import ultimatemod.lists.BlockList;
import ultimatemod.lists.EntityList;
import ultimatemod.lists.FoodList;
import ultimatemod.lists.ItemList;
import ultimatemod.lists.ToolMaterialList;
import ultimatemod.lists.TracksuitMaterialList;
import ultimatemod.objects.blocks.CustomStairsBlock;


@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class RegistryEvents 
{
	public static final Logger LOGGER = Main.LOGGER;
	public static final String MOD_ID = Main.MOD_ID;

	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll
		(
				ItemList.vodka = new Item(new Item.Properties().group(Main.ultimate_mod)).setRegistryName(location("vodka")),
				ItemList.chicken_block = new BlockItem(BlockList.chicken_block, new Item.Properties().group(Main.ultimate_mod)).setRegistryName(BlockList.chicken_block.getRegistryName()),
				ItemList.chicken_slab = new BlockItem(BlockList.chicken_slab, new Item.Properties().group(Main.ultimate_mod)).setRegistryName(BlockList.chicken_slab.getRegistryName()),
				ItemList.chicken_stair = new BlockItem(BlockList.chicken_stair, new Item.Properties().group(Main.ultimate_mod)).setRegistryName(BlockList.chicken_stair.getRegistryName()),
				ItemList.chicken_wall = new BlockItem(BlockList.chicken_wall, new Item.Properties().group(Main.ultimate_mod)).setRegistryName(BlockList.chicken_wall.getRegistryName()),
				
				ItemList.uchanka = new ArmorItem(TracksuitMaterialList.ultimatemod, EquipmentSlotType.HEAD, new Item.Properties().group(Main.ultimate_mod)).setRegistryName(location("uchanka")),
				ItemList.tracksuit_top = new ArmorItem(TracksuitMaterialList.ultimatemod, EquipmentSlotType.CHEST, new Item.Properties().group(Main.ultimate_mod)).setRegistryName(location("tracksuit_top")),
				ItemList.tracksuit_bottom = new ArmorItem(TracksuitMaterialList.ultimatemod, EquipmentSlotType.LEGS, new Item.Properties().group(Main.ultimate_mod)).setRegistryName(location("tracksuit_bottom")),
				ItemList.baskets = new ArmorItem(TracksuitMaterialList.ultimatemod, EquipmentSlotType.FEET, new Item.Properties().group(Main.ultimate_mod)).setRegistryName(location("baskets")),
				
				ItemList.kalashnikov = new AxeItem(ToolMaterialList.ultimatemod, -1.0f, 6.0f, new Item.Properties().group(Main.ultimate_mod)).setRegistryName(location("kalashnikov")),
				ItemList.alexei_sword = new SwordItem(ToolMaterialList.ultimatemod_1, -5, 6.0f, new Item.Properties().group(Main.ultimate_mod)).setRegistryName(location("alexei_sword")),
				ItemList.karisa_dagger = new SwordItem(ToolMaterialList.ultimatemod_2, -2, 6.0f, new Item.Properties().group(Main.ultimate_mod)).setRegistryName(location("karisa_dagger")),
				ItemList.dwarven_axe = new SwordItem(ToolMaterialList.ultimatemod_3, -2, 6.0f, new Item.Properties().group(Main.ultimate_mod)).setRegistryName(location("dwarven_axe")),

				ItemList.crown = new ArmorItem(TracksuitMaterialList.ultimatemod_1, EquipmentSlotType.HEAD, new Item.Properties().group(Main.ultimate_mod)).setRegistryName(location("crown")),
				
				ItemList.beer = new Item(new Item.Properties().group(Main.ultimate_mod).food(FoodList.BEER)).setRegistryName(location("beer"))
		);
	
		EntityList.registerEntitySpawnEggs(event);
	}
	
	

	
	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event)
	{
		event.getRegistry().registerAll
		(
				BlockList.chicken_block = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(1).sound(SoundType.CLOTH)).setRegistryName(location("chicken_block")),
				BlockList.chicken_slab = new SlabBlock(Block.Properties.from(BlockList.chicken_block)).setRegistryName(location("chicken_slab")),
				BlockList.chicken_stair = new CustomStairsBlock(BlockList.chicken_block.getDefaultState(), Block.Properties.from(BlockList.chicken_block)).setRegistryName(location("chicken_stair")),
				BlockList.chicken_wall = new WallBlock(Block.Properties.from(BlockList.chicken_block)).setRegistryName(location("chicken_wall"))
		);
	}
	

	

	
	
	@SuppressWarnings("unchecked")
	@SubscribeEvent
	public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event) 
	{
		
		GlobalEntityTypeAttributes.put((EntityType<? extends LivingEntity>) EntityList.DWARF_ENTITY, DwarfEntity.getAttributeMap().func_233813_a_());
		event.getRegistry().registerAll(
				
				EntityList.DWARF_ENTITY
		);
		
		EntityList.registerEntityWorldSpawns();
	}
	
	public static ResourceLocation location(String name)
	{
		return new ResourceLocation(MOD_ID, name);
	}
}
