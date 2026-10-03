/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.effects.client.main.pidb;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class ssnu {
    private static final int _h = GL11.glGetInteger(34047);
    public boolean _a;
    public boolean _b;
    public boolean _c;
    public boolean _d;
    public boolean _e;
    public boolean _f;
    public int _g;

    public void _a(ResourceLocation resourceLocation, tvoe tvoe2) {
        anxd anxd2 = pidb._c();
        if (resourceLocation.getResourceDomain().equals("minecraft") || resourceLocation.getResourcePath().contains("gui") || resourceLocation.getResourcePath().contains("textures/items")) {
            anxd2 = anxd._a;
        }
        this._c = false;
        this._b = anxd2._h;
        this._e = anxd2._i;
        this._d = anxd2._i;
        this._g = anxd2._j;
        if (tvoe2 != null) {
            try {
                this._b = tvoe2._e();
                this._c = tvoe2._f();
                this._e = tvoe2._a();
                this._d = tvoe2._b();
                this._f = tvoe2._d();
                this._g = tvoe2._c();
                this._a = true;
            }
            catch (RuntimeException runtimeException) {
                gpmu._b("Failed reading metadata of: " + resourceLocation, new Object[0]);
                runtimeException.printStackTrace();
            }
        }
    }

    public void _a(int n, int n2) {
        boolean bl;
        boolean bl2 = this._e && this._a;
        boolean bl3 = n2 > 1;
        boolean bl4 = bl = bl2 || bl3;
        if (this._g > 1 && bl) {
            if (this._g > _h) {
                gpmu._b("Max anisotropy level is %d, using it instead of %d", _h, this._g);
                if (_h > 1) {
                    GL11.glTexParameteri(n, 34046, _h);
                }
            } else {
                GL11.glTexParameteri(n, 34046, this._g);
            }
        }
        int n3 = bl ? (this._b && this._d ? 9987 : (this._b && !this._d ? 9985 : (!this._b && this._d ? 9986 : 9984))) : (this._b ? 9729 : 9728);
        GL11.glTexParameteri(n, 10240, this._b ? 9729 : 9728);
        GL11.glTexParameteri(n, 10241, n3);
        GL11.glTexParameteri(n, 10242, this._c ? 33071 : 10497);
        GL11.glTexParameteri(n, 10243, this._c ? 33071 : 10497);
        if (n == 34067) {
            GL11.glTexParameteri(n, 32882, this._c ? 33071 : 10497);
        }
        if (bl2 && !bl3) {
            GL11.glTexParameteri(n, 33169, 1);
            gpmu._b("Generating mipmap for " + this + " in runtime. This is really really bad.", new Object[0]);
        }
    }
}

