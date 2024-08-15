package top.heerdev.xpfromrcharvest;

import com.mojang.logging.LogUtils;
import io.github.jamalam360.rightclickharvest.RightClickHarvestCallbacks;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;

import java.util.Random;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(XPFromRightClickHarvestMod.MODID)
public class XPFromRightClickHarvestMod
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "xp_from_rightclick_harvest";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public XPFromRightClickHarvestMod()
    {
        MinecraftForge.EVENT_BUS.register(this);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }


    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    void onAfterHarvest(RightClickHarvestCallbacks.AfterHarvest event) {
        if (!event.getPlayer().level().isClientSide()) {

            Random rand = new Random();

            int random = rand.nextInt(Config.min,Config.max);

            event.getPlayer().giveExperiencePoints(random);
        }

    }

}
