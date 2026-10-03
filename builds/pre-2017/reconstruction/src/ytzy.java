/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.effects.client.main.eidj;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class ytzy {
    public static int _a = -1;
    private Minecraft _b = Minecraft._E();
    private Tessellator _c = Tessellator.instance;
    private TileEntityRenderer _d = TileEntityRenderer._b;
    private ArrayList<kjui> _e = new ArrayList();
    private HashSet<Integer> _f = new HashSet();
    private int _g;
    private static final int _h = (int)Math.pow(2.0, 18.0) - 1;

    public void _a(List<xqwz> list, float f) {
        Minecraft._E().__ah._a("customlights");
        GL11.glPushMatrix();
        Tessellator tessellator = Tessellator.instance;
        this._b._D.disableLightmap(f);
        double d = this._b._u.lastTickPosX + (this._b._u.posX - this._b._u.lastTickPosX) * (double)f;
        double d2 = this._b._u.lastTickPosY + (this._b._u.posY - this._b._u.lastTickPosY) * (double)f;
        double d3 = this._b._u.lastTickPosZ + (this._b._u.posZ - this._b._u.lastTickPosZ) * (double)f;
        tessellator.setTranslation(-d, -d2, -d3);
        for (xqwz xqwz2 : list) {
            if (this._b._u.getDistanceSq(xqwz2._b, xqwz2._c, xqwz2._d) > (double)eidj._a._j || !eidj._a._r._a(xqwz2._n)) continue;
            this._b._h._a(sctd._c);
            GL11.glEnable(3042);
            xqwz2._c();
            GL11.glDisable(3008);
            GL11.glPolygonOffset(-3.0f, -3.0f);
            GL11.glEnable(32823);
            GL11.glEnable(3008);
            for (int i = 0; i < xqwz2._j; ++i) {
                this._g = xqwz2._i[i];
                byte by = (byte)(this._g >> 18 & 0x3F);
                int n = xqwz2._e + (this._g >> 12 & 0x3F);
                int n2 = xqwz2._f + (this._g >> 6 & 0x3F);
                int n3 = xqwz2._g + (this._g & 0x3F);
                xqwz2._a((int)by);
                for (int j = 0; j < 7; ++j) {
                    if ((this._g >> 24 + j & 1) != 1) continue;
                    this._a(xqwz2._a, n, n2, n3, j);
                }
            }
            GL11.glDisable(3008);
            GL11.glPolygonOffset(0.0f, 0.0f);
            GL11.glDisable(32823);
            GL11.glEnable(3008);
            this._f.clear();
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        }
        tessellator.setTranslation(0.0, 0.0, 0.0);
        GL11.glPopMatrix();
        Minecraft._E().__ah._b();
    }

    private void _a(World world, int n, int n2, int n3, int n4) {
        this._c.startDrawingQuads();
        this._c.disableColor();
        boolean bl = false;
        if (n4 == 0) {
            int n5 = this._g & _h;
            if (this._f.contains(n5)) {
                ivms._a._a();
                bl = true;
            } else {
                this._f.add(n5);
            }
            Block block = Block.blocksList[world.getBlockId(n, n2, n3)];
            if (block != null) {
                this._b._s._s._a(block, n, n2, n3, (Icon)null);
            }
            if (bl) {
                ivms._a._b();
            }
        } else {
            switch (n4) {
                case 1: {
                    --n2;
                    break;
                }
                case 2: {
                    ++n2;
                    break;
                }
                case 3: {
                    ++n3;
                    break;
                }
                case 4: {
                    --n3;
                    break;
                }
                case 5: {
                    ++n;
                    break;
                }
                case 6: {
                    --n;
                }
            }
            Block block = Block.blocksList[world.getBlockId(n, n2, n3)];
            if (block == null) {
                block = Block.stone;
            }
            if (--n4 == 0) {
                n4 = 1;
            } else if (n4 == 1) {
                n4 = 0;
            }
            _a = n4;
            int n6 = this._g & _h;
            if (this._f.contains(n6)) {
                ivms._a._a();
                bl = true;
            } else {
                this._f.add(n6);
            }
            this._b._s._s._a(block, n, n2, n3, (Icon)null);
            if (bl) {
                ivms._a._b();
            }
            _a = -1;
        }
        this._c.hasBrightness = false;
        this._c.draw();
    }

    private class kjui {
        public final TileEntity _a;
        public final xqwz _b;
        public final byte _c;

        public kjui(TileEntity tileEntity, xqwz xqwz2, byte by) {
            this._a = tileEntity;
            this._b = xqwz2;
            this._c = by;
        }
    }
}

