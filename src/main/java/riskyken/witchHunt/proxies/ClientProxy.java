package riskyken.witchHunt.proxies;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import riskyken.witchHunt.WitchHunt;
import riskyken.witchHunt.client.render.TileEntitySpecialRendererWrapper;

public class ClientProxy extends CommonProxy {

    @Override
    public void preInit() {
        super.preInit();
    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void postInit() {
        super.postInit();
        wrapTileEntityRenderer();
    }

    private void wrapTileEntityRenderer() {
        WitchHunt.logger.info("Wrapping tile entity renderers.");
        TileEntityRendererDispatcher rendererDispatcher = TileEntityRendererDispatcher.instance;
        Map mapSpecialRenderers = rendererDispatcher.mapSpecialRenderers;
        Set keys = mapSpecialRenderers.keySet();

        Map newRenderMap = new HashMap();

        Iterator iterator = keys.iterator();
        while (iterator.hasNext()) {
            Class keyClass = (Class) iterator.next();
            TileEntitySpecialRenderer tileentityspecialrenderer = (TileEntitySpecialRenderer) mapSpecialRenderers.get(keyClass);
            TileEntitySpecialRendererWrapper wrapper = new TileEntitySpecialRendererWrapper();
            wrapper.func_147497_a(rendererDispatcher);
            wrapper.setBaseRenderer(tileentityspecialrenderer);
            newRenderMap.put(keyClass, wrapper);
        }
        rendererDispatcher.mapSpecialRenderers = newRenderMap;
    }
}
