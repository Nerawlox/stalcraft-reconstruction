/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class ywqz {
    private static final int _b = 1;
    private static final int _c = 2;
    private static final int _d = 4;
    private static final int _e = 8;
    private static final boolean _f = false;
    private static final int _g = 12;
    private static final int[][] _h = new int[25][25];
    public static ResourceLocation _a = new ResourceLocation("stalkerguide", "blank.png");
    private Minecraft _i = Minecraft._E();
    private pkix _j;
    private int _k = 0;
    private int _l = -1;

    public ywqz(pkix pkix2) {
        this._j = pkix2;
        this._l = GL11.glGenLists(1);
        this._i._h._a(_a, new qmgc(_a));
    }

    private void _a(ResourceLocation resourceLocation) {
        this._i._h._a(resourceLocation);
        GL11.glViewport(0, 0, this._i._n, this._i._o);
        GL11.glCopyTexImage2D(3553, 0, 6408, 0, 0, this._i._n, this._i._o, 0);
    }

    public void _a(float f) {
    }

    private int _a(int n, int n2) {
        int n3 = 1;
        for (int i = -12; i <= 12; ++i) {
            for (int j = -12; j <= 12; ++j) {
                int n4 = this._j.getPrecipitationHeight(n + i, n2 + j);
                int n5 = 0;
                if (this._j.getPrecipitationHeight(n + i, n2 + j + 1) >= n4) {
                    n5 |= 1;
                }
                if (this._j.getPrecipitationHeight(n + i + 1, n2 + j) >= n4) {
                    n5 |= 2;
                }
                if (this._j.getPrecipitationHeight(n + i, n2 + j - 1) >= n4) {
                    n5 |= 4;
                }
                if (this._j.getPrecipitationHeight(n + i - 1, n2 + j) >= n4) {
                    n5 |= 8;
                }
                n4 = n4 << 4 | n5;
                n3 = 31 * n3 + n4;
                ywqz._h[i + 12][j + 12] = n4;
            }
        }
        return n3;
    }

    private void _a(int[][] nArray) {
        GL11.glNewList(this._l, 4864);
        for (int i = 0; i < nArray.length; ++i) {
            int[] nArray2 = nArray[i];
            GL11.glBegin(7);
            for (int j = 0; j < nArray2.length; ++j) {
                int n = nArray[i][j] >> 4 & 0xFF;
                int n2 = nArray[i][j] & 0xF;
                if (n < 0) continue;
                GL11.glVertex3d(i, n, j);
                GL11.glVertex3d(i, n, j + 1);
                GL11.glVertex3d(i + 1, n, j + 1);
                GL11.glVertex3d(i + 1, n, j);
            }
            GL11.glEnd();
        }
        GL11.glEndList();
    }
}

