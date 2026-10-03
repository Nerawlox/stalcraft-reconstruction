/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.xpzm;
import net.minecraft.util.sajz;
import net.minecraft.util.uxqz;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

public class uzug
implements sajz {
    public String _a = "";
    public xpzm _b;
    public String _c = "";
    public long _d = xpzm._M();
    public boolean _e;

    public uzug(xpzm xpzm2) {
        this._b = xpzm2;
    }

    public void _a(String string) {
        this._e = false;
        this._c(string);
    }

    @Override
    public void _b(String string) {
        this._e = true;
        this._c(string);
    }

    public void _c(String string) {
        this._c = string;
        if (!this._b.__ap) {
            if (this._e) {
                return;
            }
            throw new uxqz();
        }
        htou htou2 = new htou(this._b._M, this._b._n, this._b._o);
        GL11.glClear(256);
        GL11.glMatrixMode(5889);
        GL11.glLoadIdentity();
        GL11.glOrtho(0.0, htou2._c(), htou2._d(), 0.0, 100.0, 300.0);
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        GL11.glTranslatef(0.0f, 0.0f, -200.0f);
    }

    @Override
    public void _d(String string) {
        if (!this._b.__ap) {
            if (this._e) {
                return;
            }
            throw new uxqz();
        }
        this._d = 0L;
        this._a = string;
        this._a(-1);
        this._d = 0L;
    }

    @Override
    public void _a(int n) {
        if (!this._b.__ap) {
            if (this._e) {
                return;
            }
            throw new uxqz();
        }
        long l = xpzm._M();
        if (l - this._d < 100L) {
            return;
        }
        this._d = l;
        htou htou2 = new htou(this._b._M, this._b._n, this._b._o);
        int n2 = htou2._a();
        int n3 = htou2._b();
        GL11.glClear(256);
        GL11.glMatrixMode(5889);
        GL11.glLoadIdentity();
        GL11.glOrtho(0.0, htou2._c(), htou2._d(), 0.0, 100.0, 300.0);
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        GL11.glTranslatef(0.0f, 0.0f, -200.0f);
        GL11.glClear(16640);
        htvf htvf2 = htvf.field_78398_a;
        this._b._R()._a(bawa.field_110325_k);
        float f = 32.0f;
        htvf2.func_78382_b();
        htvf2.func_78378_d(0x404040);
        htvf2.func_78374_a(0.0, n3, 0.0, 0.0, (float)n3 / f);
        htvf2.func_78374_a(n2, n3, 0.0, (float)n2 / f, (float)n3 / f);
        htvf2.func_78374_a(n2, 0.0, 0.0, (float)n2 / f, 0.0);
        htvf2.func_78374_a(0.0, 0.0, 0.0, 0.0, 0.0);
        htvf2.func_78381_a();
        if (n >= 0) {
            int n4 = 100;
            int n5 = 2;
            int n6 = n2 / 2 - n4 / 2;
            int n7 = n3 / 2 + 16;
            GL11.glDisable(3553);
            htvf2.func_78382_b();
            htvf2.func_78378_d(0x808080);
            htvf2.func_78377_a(n6, n7, 0.0);
            htvf2.func_78377_a(n6, n7 + n5, 0.0);
            htvf2.func_78377_a(n6 + n4, n7 + n5, 0.0);
            htvf2.func_78377_a(n6 + n4, n7, 0.0);
            htvf2.func_78378_d(0x80FF80);
            htvf2.func_78377_a(n6, n7, 0.0);
            htvf2.func_78377_a(n6, n7 + n5, 0.0);
            htvf2.func_78377_a(n6 + n, n7 + n5, 0.0);
            htvf2.func_78377_a(n6 + n, n7, 0.0);
            htvf2.func_78381_a();
            GL11.glEnable(3553);
        }
        this._b._z._a(this._c, (n2 - this._b._z._b(this._c)) / 2, n3 / 2 - 4 - 16, 0xFFFFFF);
        this._b._z._a(this._a, (n2 - this._b._z._b(this._a)) / 2, n3 / 2 - 4 + 8, 0xFFFFFF);
        Display.update();
        try {
            Thread.yield();
        }
        catch (Exception exception) {
            // empty catch block
        }
    }
}

