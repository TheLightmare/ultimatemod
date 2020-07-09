package ultimatemod;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import ultimatemod.lists.ItemList;

public class UltimateModGroup extends ItemGroup{
	
	public UltimateModGroup() {
		super("ultimate");
	}

	@Override
	public ItemStack createIcon() 
	{
		
		return new ItemStack(ItemList.vodka);
	}

}
