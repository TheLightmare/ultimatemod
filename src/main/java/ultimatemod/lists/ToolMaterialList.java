package ultimatemod.lists;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;

public enum ToolMaterialList implements IItemTier
{
	ultimatemod(10.0f, 9.0f, 000, 3, 25, ItemList.vodka),
	ultimatemod_1(20.0f, 5.0f, 000, 1, 25, ItemList.vodka),
	ultimatemod_2(10.0f, 2.0f, 000, 1, 25, ItemList.vodka),
	ultimatemod_3(10.0f, 9.0f, 000, 3, 25, ItemList.vodka);
	
	private float attackDamage, efficiency;
	private int durability, harvestLevel, enchantability;
	private Item repairItem;
	
	private ToolMaterialList(float attackDamage, float efficiency, int durability, int harvestLevel, int enchantability, Item repairItem) 
	{
		this.efficiency = efficiency;
		this.attackDamage = attackDamage;
		this.durability = durability;
		this.harvestLevel = harvestLevel;
		this.enchantability = enchantability;
		this.repairItem = repairItem;
		
		
	}

	@Override
	public int getMaxUses() 
	{
		// TODO Auto-generated method stub
		return this.durability;
	}

	@Override
	public float getEfficiency() {
		// TODO Auto-generated method stub
		return this.efficiency;
	}

	@Override
	public float getAttackDamage() 
	{
		return this.attackDamage;
	}

	@Override
	public int getHarvestLevel() {
		// TODO Auto-generated method stub
		return this.harvestLevel;
	}

	@Override
	public int getEnchantability() {
		// TODO Auto-generated method stub
		return this.enchantability;
	}

	@Override
	public Ingredient getRepairMaterial() 
	{
		// TODO Auto-generated method stub
		return Ingredient.fromItems(this.repairItem);
	}
}
