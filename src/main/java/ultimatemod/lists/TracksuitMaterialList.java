package ultimatemod.lists;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import ultimatemod.Main;

public enum TracksuitMaterialList implements IArmorMaterial
{
	ultimatemod("tracksuit", 400, new int[] {8, 10, 9, 7}, 25, ItemList.vodka, "entity.ender_dragon_growl", 0.0f),
	ultimatemod_1("crown", 000, new int[] {1, 1, 1, 1}, 25, ItemList.vodka, null, 0.0f);
	
	private static final int[] max_damage_array = new int[] {13, 15, 16, 11};
	
	private String name, equipSound;
	private int durability, enchantability;
	private Item repairItem;
	private int[] damageReductionAmounts;
	private float toughness;
	
	private TracksuitMaterialList(String name, int durability, int[] damageReductionAmounts, int enchantability, Item repairItem, String equipSound, float toughness ) 
	{
		this.name = name;
		this.durability = durability;
		this.damageReductionAmounts = damageReductionAmounts;
		this.enchantability = enchantability;
		this.repairItem = repairItem;
		this.equipSound = equipSound;
		this.toughness = toughness;
	}

	

	@Override
	public int getDurability(EquipmentSlotType slotIn) {
		
		return max_damage_array[slotIn.getIndex()]* this.durability;
	}


	@Override
	public int getEnchantability() {
		
		return this.enchantability;
	}

	@Override
	public SoundEvent getSoundEvent() {
		
		return new SoundEvent(new ResourceLocation(this.equipSound));
	}

	@Override
	public Ingredient getRepairMaterial() {
		
		return Ingredient.fromItems(this.repairItem);
	}

	@Override
	public String getName() {
		
		return Main.MOD_ID + ":" + this.name;
	}

	@Override
	public float getToughness() {
		
		return this.toughness;
	}
	
	public int getDamageReductionAmounts(EquipmentSlotType slotIn) {
	
		return this.damageReductionAmounts[slotIn.getIndex()];
	}



	@Override
	public int getDamageReductionAmount(EquipmentSlotType slotIn) {
		
		return this.damageReductionAmounts[slotIn.getIndex()];
	}



	@Override
	public float func_230304_f_() {
		// TODO Auto-generated method stub
		return 0;
	}


	

}
