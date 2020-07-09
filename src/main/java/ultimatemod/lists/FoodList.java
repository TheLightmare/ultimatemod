package ultimatemod.lists;

import net.minecraft.item.Food;
import net.minecraft.item.Food.Builder;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class FoodList {
	
	public static final Food BEER = (new Food.Builder().hunger(1).saturation(0.2f).effect(new EffectInstance(Effects.NAUSEA, 60,1), 0.1f).setAlwaysEdible()).build();
	
}
