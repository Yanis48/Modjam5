package team.thegoldenhoe.cameraobscura;

import net.fabricmc.api.ModInitializer;
import team.thegoldenhoe.cameraobscura.init.*;

public class CameraObscura implements ModInitializer {

	@Override
	public void onInitialize() {
		new COBlocks();
		new COBlockEntities();
		new COItems();
		new COItemGroups();
		new COScreenHandlers();
		new COSounds();
	}


    @SidedProxy(clientSide = Info.CLIENT_PROXY, serverSide = Info.SERVER_PROXY)
    public static CommonProxy proxy;

    public static Block blockProps;
    public static Block blockFake;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        proxy.preInit();

        ForgeRegistries.BLOCKS.register(blockProps = new BlockProps().setRegistryName("blockProps"));
        ForgeRegistries.BLOCKS.register(blockFake = new BlockFake().setRegistryName("blockFake"));

        CameraCapabilities.register();
        
        TileTypeMap.register();
        ModelHandler.loadModels();
        
        NetworkRegistry.INSTANCE.registerGuiHandler(this, new COGuiHandler());
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        CONetworkHandler.init();
        proxy.init();
        MinecraftForge.EVENT_BUS.register(new CommonEvents());
    }

}
