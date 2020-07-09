package ultimatemod.client.models;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.Hand;
import net.minecraft.util.HandSide;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import ultimatemod.entities.DwarfEntity;



@OnlyIn(Dist.CLIENT)
public class DwarfEntityModel<T extends DwarfEntity> extends BipedModel<T> {

	private static float modelSize;


	public DwarfEntityModel() {
		super(modelSize);
		textureWidth = 64;
		textureHeight = 64;

		bipedBody = new ModelRenderer(this);
		bipedBody.setRotationPoint(0.0F, 24.0F, 0.0F);
		bipedBody.setTextureOffset(0, 32).addBox(-4.0F, -20.0F, -2.0F, 8.0F, 11.0F, 4.0F, 0.0F, false);

		bipedLeftLeg = new ModelRenderer(this);
		bipedLeftLeg.setRotationPoint(2.0F, 15.0F, 0.0F);
		bipedLeftLeg.setTextureOffset(16, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 9.0F, 4.0F, 0.0F, false);

		bipedRightLeg = new ModelRenderer(this);
		bipedRightLeg.setRotationPoint(-2.0F, 15.0F, 0.0F);
		bipedRightLeg.setTextureOffset(0, 49).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 9.0F, 4.0F, 0.0F, false);

		bipedRightArm = new ModelRenderer(this);
		bipedRightArm.setRotationPoint(-6.0F, 4.0F, 0.0F);
		bipedRightArm.setTextureOffset(16, 49).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 11.0F, 4.0F, 0.0F, false);

		bipedLeftArm = new ModelRenderer(this);
		bipedLeftArm.setRotationPoint(6.0F, 4.0F, 0.0F);
		bipedLeftArm.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 11.0F, 4.0F, 0.0F, false);

		bipedHead = new ModelRenderer(this);
		bipedHead.setRotationPoint(0.0F, 4.0F, 0.0F);
		bipedHead.setTextureOffset(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
		
	}
	
	
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
    
	public void setVisible(boolean visible) {
	      this.bipedHead.showModel = visible;
	      this.bipedHeadwear.showModel = visible;
	      this.bipedBody.showModel = visible;
	      this.bipedRightArm.showModel = visible;
	      this.bipedLeftArm.showModel = visible;
	      this.bipedRightLeg.showModel = visible;
	      this.bipedLeftLeg.showModel = visible;
	   }
	
	@Override
	public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netbipedHeadYaw, float bipedHeadPitch){
		//super.setRotationAngles(entity, limbSwing, limbSwingAmount, ageInTicks, netbipedHeadYaw, bipedHeadPitch);
		
		this.bipedHead.rotateAngleY = netbipedHeadYaw * ((float)Math.PI / 180F);
	    this.bipedHead.rotateAngleX = bipedHeadPitch * ((float)Math.PI / 180F);
		
        this.bipedRightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / 1.0F;
        this.bipedLeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount / 1.0F;
        this.bipedRightArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.6F * limbSwingAmount / 1.0F;
        this.bipedLeftArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 0.5F * limbSwingAmount / 1.0F;
	}

	

	
	
	public ModelRenderer getbipedBody() {
		return bipedBody;
	}
	
	public ModelRenderer getbipedHead() {
		return bipedHead;
	}
	
	

	public ModelRenderer getRightArm() {
		return bipedRightArm;
	}
	
	public ModelRenderer getLeftArm() {
		return bipedLeftArm;
	}
	
	
	
	public ModelRenderer getRightLeg() {
		return bipedRightLeg;
	}
	
	public ModelRenderer getLeftLeg() {
		return bipedLeftLeg;
	}

	@Override
	public void translateHand(HandSide sideIn, MatrixStack matrixStackIn) {
		float f = sideIn == HandSide.RIGHT ? 1F : -1F;
	      ModelRenderer modelrenderer = this.getArmForSide(sideIn);
	      modelrenderer.rotationPointX += f;
	      modelrenderer.translateRotate(matrixStackIn);
	      modelrenderer.rotationPointX -= f;
	   }


	   public ModelRenderer getModelbipedHead() {
	      return this.bipedHead;
	   }

	   protected HandSide getMainHand(T entityIn) {
	      HandSide handside = entityIn.getPrimaryHand();
	      return entityIn.swingingHand == Hand.MAIN_HAND ? handside : handside.opposite();
	   }
}
