/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.block.Block;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityPiston;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class dhnh
extends TileEntitySpecialRenderer {
    public RenderBlocks _a;

    public void _a(TileEntityPiston tileEntityPiston, double d, double d2, double d3, float f) {
        Block block = Block.blocksList[tileEntityPiston._a()];
        if (block != null && tileEntityPiston._a(f) < 1.0f) {
            Tessellator tessellator = Tessellator.instance;
            this.bindTexture(sctd._c);
            qnon._a();
            GL11.glBlendFunc(770, 771);
            GL11.glEnable(3042);
            GL11.glDisable(2884);
            if (Minecraft._C()) {
                GL11.glShadeModel(7425);
            } else {
                GL11.glShadeModel(7424);
            }
            tessellator.startDrawingQuads();
            tessellator.setTranslation((float)d - (float)tileEntityPiston.xCoord + tileEntityPiston._b(f), (float)d2 - (float)tileEntityPiston.yCoord + tileEntityPiston._c(f), (float)d3 - (float)tileEntityPiston.zCoord + tileEntityPiston._d(f));
            tessellator.setColorOpaque(1, 1, 1);
            if (block == Block.pistonExtension && tileEntityPiston._a(f) < 0.5f) {
                this._a._b(block, tileEntityPiston.xCoord, tileEntityPiston.yCoord, tileEntityPiston.zCoord, false);
            } else if (tileEntityPiston._d() && !tileEntityPiston._b()) {
                Block.pistonExtension._a(((BlockPistonBase)block)._a());
                this._a._b((Block)Block.pistonExtension, tileEntityPiston.xCoord, tileEntityPiston.yCoord, tileEntityPiston.zCoord, tileEntityPiston._a(f) < 0.5f);
                Block.pistonExtension._a();
                tessellator.setTranslation((float)d - (float)tileEntityPiston.xCoord, (float)d2 - (float)tileEntityPiston.yCoord, (float)d3 - (float)tileEntityPiston.zCoord);
                this._a._e(block, tileEntityPiston.xCoord, tileEntityPiston.yCoord, tileEntityPiston.zCoord);
            } else {
                this._a._a(block, tileEntityPiston.xCoord, tileEntityPiston.yCoord, tileEntityPiston.zCoord);
            }
            tessellator.setTranslation(0.0, 0.0, 0.0);
            tessellator.draw();
            qnon._b();
        }
    }

    @Override
    public void onWorldChange(World world) {
        this._a = new RenderBlocks(world);
    }

    @Override
    public /* synthetic */ void renderTileEntityAt(TileEntity tileEntity, double d, double d2, double d3, float f) {
        this._a((TileEntityPiston)tileEntity, d, d2, d3, f);
    }
}

