package ultimatemod.structure;

import com.mojang.serialization.Codec;

import ultimatemod.Main;
import net.minecraft.util.Rotation;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructureStart;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class BirchHouseStructure extends Structure<NoFeatureConfig> {
    public BirchHouseStructure(Codec<NoFeatureConfig> p_i51440_1_) {
        super(p_i51440_1_);
    }

    public String getStructureName() {
        return Main.MOD_ID + ":birchhouse";
    }

    protected boolean func_230363_a_(ChunkGenerator p_230363_1_, BiomeProvider p_230363_2_, long p_230363_3_, SharedSeedRandom p_230363_5_, int p_230363_6_, int p_230363_7_, Biome p_230363_8_, ChunkPos p_230363_9_, NoFeatureConfig p_230363_10_) {
        int i = p_230363_6_ >> 4;
        int j = p_230363_7_ >> 4;
        p_230363_5_.setSeed((long) (i ^ j << 4) ^ p_230363_3_);
        p_230363_5_.nextInt();
        for (int k = p_230363_6_ - 20; k <= p_230363_6_ + 20; ++k) {
            for (int l = p_230363_7_ - 20; l <= p_230363_7_ + 20; ++l) {
                ChunkPos chunkpos = Structure.field_236381_q_.func_236392_a_(p_230363_1_.func_235957_b_().func_236197_a_(Structure.field_236381_q_), p_230363_3_, p_230363_5_, k, l);
                if (k == chunkpos.x && l == chunkpos.z) {
                    return false;
                }
            }
        }

        return true;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
	public Structure.IStartFactory getStartFactory() {
        return BirchHouseStructure.Start::new;
    }

    public GenerationStage.Decoration func_236396_f_() {
        return GenerationStage.Decoration.SURFACE_STRUCTURES;
    }


    public static class Start extends StructureStart<NoFeatureConfig> {
        public Start(Structure<NoFeatureConfig> p_i225806_1_, int p_i225806_2_, int p_i225806_3_, MutableBoundingBox p_i225806_4_, int p_i225806_5_, long p_i225806_6_) {
            super(p_i225806_1_, p_i225806_2_, p_i225806_3_, p_i225806_4_, p_i225806_5_, p_i225806_6_);
        }

        public void func_230364_a_(ChunkGenerator generator, TemplateManager templateManagerIn, int chunkX, int chunkZ, Biome biomeIn, NoFeatureConfig p_230364_6_) {
            BlockPos blockpos = new BlockPos(chunkX * 16, 90, chunkZ * 16);

            Rotation rotation = Rotation.values()[this.rand.nextInt(Rotation.values().length)];
            BirchHousePieces.addStructure(templateManagerIn, blockpos, rotation, this.components, this.rand, biomeIn);
            this.recalculateStructureSize();
        }
    }
}