package ultimatemod.client.renders;

import net.minecraft.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import ultimatemod.entities.DwarfEntity;
import ultimatemod.lists.EntityList;


@OnlyIn(Dist.CLIENT)
public class UltimateRenderRegistry 
{
	@SuppressWarnings("unchecked")
	public static void registryEntityRenders()
	{
		RenderingRegistry.registerEntityRenderingHandler((EntityType<DwarfEntity>) EntityList.DWARF_ENTITY, new DwarfEntityRender.RenderFactory());
	}
}
