package ultimatemod.lists;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.ObjectHolder;

public class BlockList 
{
	public static Block chicken_block;
	public static Block chicken_slab;
	public static Block chicken_stair;
	public static Block chicken_wall;

	  @ObjectHolder("vanillaextended:storage_controller")
	    public static Block storageController;

	    @ObjectHolder("vanillaextended:storage_connector")
	    public static Block storageConnector;

	    //TileEntity Types
	    public static TileEntityType<?> storageControllerTileType;
	    public static TileEntityType<?> storageConnectorTileType;
}
