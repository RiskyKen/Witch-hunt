package riskyken.witchHunt.client.handler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.profiler.Profiler;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.common.MinecraftForge;

public class RenderHandler {

    Profiler profiler;

    public RenderHandler() {
        MinecraftForge.EVENT_BUS.register(this);
        profiler = Minecraft.getMinecraft().mcProfiler;
    }

    @SubscribeEvent
    public void onPreRenderLivingEvent(RenderLivingEvent.Pre event) {
        profiler.startSection(event.entity.getClass().getSimpleName());
    }

    @SubscribeEvent
    public void onPostRenderLivingEvent(RenderLivingEvent.Post event) {
        profiler.endSection();
    }
}
