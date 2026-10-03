/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.effects.client.mcsa.ezfc;
import java.util.HashMap;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class fmea
extends TileEntitySpecialRenderer {
    public static fmea _a;
    public static int _b;
    public float _c;
    private HashMap<Block, kjui> _d = new HashMap();

    public fmea() {
        _a = this;
    }

    public void _a(gphy gphy2, String string, String string2, String string3, float f) {
        this._d.put(gphy2, new kjui(string, string2, string3, f));
    }

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double d, double d2, double d3, float f) {
        boolean bl;
        boolean bl2 = bl = uhoc._a._b && tileEntity instanceof hbio;
        if (bl) {
            int n = ((hbio)tileEntity)._a() ? -26368 : -16711681;
            this._a(d, d2, d3, n);
            GL11.glDisable(2929);
        }
        this._a(tileEntity, d, d2, d3, !bl);
        if (bl) {
            GL11.glEnable(2929);
        }
    }

    private void _a(double d, double d2, double d3, int n) {
        float f = (float)(d + RenderManager._d);
        float f2 = (float)(d2 + RenderManager._e);
        float f3 = (float)(d3 + RenderManager._f);
        owxf._a((double)f - 0.5, (double)f2 - 0.5, (double)f3 - 0.5, (double)f + 0.5, (double)f2 + 0.5, (double)f3 + 0.5, n, 1.0f);
    }

    private void _a(TileEntity tileEntity, double d, double d2, double d3, boolean bl) {
        gphy gphy2 = (gphy)tileEntity.blockType;
        if (gphy2 == null) {
            return;
        }
        gloomyfolken.mods.effects.client.mcsa.kjui kjui2 = this._d.get((Object)gphy2)._a;
        ezfc._a();
        if (kjui2 != null) {
            ezfc._a((float)d + 0.5f, (float)d2, (float)d3 + 0.5f);
            if (gphy2._e) {
                int n = tileEntity.worldObj.getBlockMetadata(tileEntity.xCoord, tileEntity.yCoord, tileEntity.zCoord);
                ezfc._a(90.0f * (float)n, 0.0f, 1.0f, 0.0f);
            }
            (bl ? kjui2._c : kjui2._d).renderAll();
        }
        ezfc._b();
        ++_b;
    }

    public float _a(Block block) {
        kjui kjui2 = this._d.get(block);
        if (kjui2 == null) {
            return 0.0f;
        }
        return kjui2._b;
    }

    private static class kjui {
        final gloomyfolken.mods.effects.client.mcsa.kjui _a;
        final float _b;

        public kjui(String string, String string2, String string3, float f) {
            ResourceLocation resourceLocation = new ResourceLocation(string);
            if (string3 == null) {
                if (string2 == null) {
                    this._a = new gloomyfolken.mods.effects.client.mcsa.kjui(resourceLocation);
                } else {
                    ResourceLocation resourceLocation2 = new ResourceLocation(string2);
                    this._a = new gloomyfolken.mods.effects.client.mcsa.kjui(resourceLocation, resourceLocation2);
                }
            } else {
                ResourceLocation resourceLocation3 = new ResourceLocation(string3);
                this._a = gloomyfolken.mods.effects.client.mcsa.kjui._a(resourceLocation, resourceLocation3);
            }
            this._b = f * f;
        }
    }
}

