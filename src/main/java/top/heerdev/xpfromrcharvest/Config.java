package top.heerdev.xpfromrcharvest;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Mod.EventBusSubscriber(modid = XPFromRightClickHarvestMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config
{
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();


    private static final ForgeConfigSpec.IntValue MIN_PER_XP = BUILDER
            .comment("Minimum number of XP per right-click harvest")
            .defineInRange("xp_min", 1, 0, Integer.MAX_VALUE);

    private static final ForgeConfigSpec.IntValue MAX_PER_XP = BUILDER
            .comment("Maximum number of XP per right-click harvest")
            .defineInRange("xp_max", 2, 0, Integer.MAX_VALUE);

    static final ForgeConfigSpec SPEC = BUILDER.build();

    public static int min;
    public static int max;


    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        min = MIN_PER_XP.get();
        max = MAX_PER_XP.get();
    }
}
