package ultimatemod.structure;

import ultimatemod.Main;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Main.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class featureRegister {
    public static final Structure<NoFeatureConfig> BIRCH_HOUSE_STRUCTURE = new BirchHouseStructure(NoFeatureConfig.field_236558_a_);

    public static final StructureFeature<NoFeatureConfig, ? extends Structure<NoFeatureConfig>> HUNTER_HOUSE = BIRCH_HOUSE_STRUCTURE.func_236391_a_(NoFeatureConfig.field_236559_b_);

    public static final IStructurePieceType BIRCH_HOUSE_STRUCTURE_PIECE = registerStructurePiece(new ResourceLocation(Main.MOD_ID, "birch_house"), BirchHousePieces.Piece::new);

    public static <C extends IFeatureConfig> IStructurePieceType registerStructurePiece(ResourceLocation key, IStructurePieceType pieceType) {
        return Registry.register(Registry.STRUCTURE_PIECE, key, pieceType);
    }

    @SubscribeEvent
    public static void registerStructure(RegistryEvent.Register<Structure<?>> registry) {
        registry.getRegistry().register(BIRCH_HOUSE_STRUCTURE.setRegistryName(Main.MOD_ID, "birchhouse"));
        Structure.field_236365_a_.put(prefix("hunterhouse"), BIRCH_HOUSE_STRUCTURE);
    }

    private static String prefix(String path) {
        return Main.MOD_ID + ":" + path;
    }
}