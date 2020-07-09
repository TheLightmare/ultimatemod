package ultimatemod.entities;

import javax.annotation.Nullable;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.MoveTowardsTargetGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Hand;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import ultimatemod.lists.EntityList;
import ultimatemod.lists.ItemList;

public class DwarfEntity extends CreatureEntity
{

	@SuppressWarnings("unchecked")
	public DwarfEntity(EntityType<? extends CreatureEntity> type, World worldIn) 
	{
		super((EntityType<? extends CreatureEntity>) EntityList.DWARF_ENTITY, worldIn);
		
	}

	@Override
	protected void registerGoals()
	{
		this.goalSelector.addGoal(3, new SwimGoal(this));
		this.goalSelector.addGoal(3, new RandomWalkingGoal(this, 0.5D));
		this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
		this.goalSelector.addGoal(3, new LookAtGoal(this, PlayerEntity.class, 80.0F));
		this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 0.6D, true));
	    this.goalSelector.addGoal(2, new MoveTowardsTargetGoal(this, 0.5D, 32.0F));
	    this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, MobEntity.class, 5, false, false, (p_213619_0_) -> {
	         return p_213619_0_ instanceof IMob;
	      }));
		
		
	}
	
	
	
	
	
	
	@Override
    protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
        super.setEquipmentBasedOnDifficulty(difficulty);
        this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(ItemList.dwarven_axe));
        this.setItemStackToSlot(EquipmentSlotType.OFFHAND, new ItemStack(Items.SHIELD));
        this.setActiveHand(Hand.MAIN_HAND);
    }
	
	
	


    public static AttributeModifierMap.MutableAttribute getAttributeMap() {
        return MobEntity.func_233666_p_()
        		.func_233815_a_(Attributes.field_233821_d_, (double) 0.5D)
        		.func_233815_a_(Attributes.field_233818_a_, 24.0D)
        		.func_233815_a_(Attributes.field_233819_b_, 22.0D)
        		.func_233815_a_(Attributes.field_233823_f_, 2.0D);
    }
	

	
	 @Nullable
	    @Override
	    public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
		 	
	        this.setEquipmentBasedOnDifficulty(difficultyIn);
	   
	        return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	 }
	
	
	
	
}
