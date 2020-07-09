package ultimatemod.client.renders;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.HeldItemLayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import ultimatemod.client.models.DwarfEntityModel;
import ultimatemod.entities.DwarfEntity;
import ultimatemod.events.RegistryEvents;



@OnlyIn(Dist.CLIENT)
public class DwarfEntityRender extends MobRenderer<DwarfEntity, DwarfEntityModel<DwarfEntity>>
{
	
	public DwarfEntityRender(EntityRendererManager manager) {
		super(manager, new DwarfEntityModel<DwarfEntity>(), 0.5F);
		this.addLayer(new HeldItemLayer<DwarfEntity, DwarfEntityModel<DwarfEntity>>(this));

	}

	@Override
	public ResourceLocation getEntityTexture(DwarfEntity entity) {
		
		return RegistryEvents.location("textures/entity/dwarf.png");
	}

	
	public static class RenderFactory implements IRenderFactory<DwarfEntity>
	{

		@Override
		public EntityRenderer<? super DwarfEntity> createRenderFor(EntityRendererManager manager)
		{
			
			return new DwarfEntityRender(manager);
		}
		
	}
}

