package riskyken.witchHunt.client.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

public class TileEntitySpecialRendererWrapper extends TileEntitySpecialRenderer {

    private TileEntitySpecialRenderer baseRenderer;
    private String rendererName;

    public void setBaseRenderer(TileEntitySpecialRenderer baseRenderer) {
        this.baseRenderer = baseRenderer;
        this.rendererName = baseRenderer.getClass().getSimpleName();
    }

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float partialTickTime) {
        Minecraft.getMinecraft().mcProfiler.startSection(rendererName);
        this.baseRenderer.renderTileEntityAt(tileEntity, x, y, z, partialTickTime);
        Minecraft.getMinecraft().mcProfiler.endSection();
    }
}
