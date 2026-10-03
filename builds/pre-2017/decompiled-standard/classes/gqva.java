/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.util.List;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class gqva
extends wovy {
    public final pknz _a;
    public ResourceLocation _b;
    public final /* synthetic */ ekou _c;

    public gqva(ekou ekou2, pknz pknz2) {
        this._c = ekou2;
        super(ekou._a(ekou2), ekou2.field_73880_f, ekou2.field_73881_g, 32, ekou2.field_73881_g - 55 + 4, 36);
        this._a = pknz2;
        pknz2._c();
    }

    @Override
    public int func_77217_a() {
        return 1 + this._a._d().size();
    }

    @Override
    public void func_77213_a(int n, boolean bl) {
        List list = this._a._d();
        try {
            if (n == 0) {
                throw new RuntimeException("This is so horrible ;D");
            }
            this._a._a((yehh)list.get(n - 1));
            ekou._b(this._c)._c();
        }
        catch (Exception exception) {
            this._a._a(new yehh[0]);
            ekou._c(this._c)._c();
        }
        ekou._d((ekou)this._c)._M.field_74346_m = this._a._f();
        ekou._e((ekou)this._c)._M.func_74303_b();
    }

    @Override
    public boolean func_77218_a(int n) {
        List list = this._a._e();
        if (n == 0) {
            return list.isEmpty();
        }
        return list.contains(this._a._d().get(n - 1));
    }

    @Override
    public int func_77212_b() {
        return this.func_77217_a() * 36;
    }

    @Override
    public void func_77221_c() {
        this._c.func_73873_v_();
    }

    @Override
    public void func_77214_a(int n, int n2, int n3, int n4, htvf htvf2) {
        apbu apbu2 = ekou._f(this._c)._R();
        if (n == 0) {
            try {
                fnrl fnrl2 = this._a._c;
                yekc yekc2 = (yekc)fnrl2.func_135058_a(this._a._d, "pack");
                if (this._b == null) {
                    this._b = apbu2._a("texturepackicon", new sctt(fnrl2.func_110586_a()));
                }
                apbu2._a(this._b);
                GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                htvf2.func_78382_b();
                htvf2.func_78378_d(0xFFFFFF);
                htvf2.func_78374_a(n2, n3 + n4, 0.0, 0.0, 1.0);
                htvf2.func_78374_a(n2 + 32, n3 + n4, 0.0, 1.0, 1.0);
                htvf2.func_78374_a(n2 + 32, n3, 0.0, 1.0, 0.0);
                htvf2.func_78374_a(n2, n3, 0.0, 0.0, 0.0);
                htvf2.func_78381_a();
                this._c.func_73731_b(ekou._g(this._c), "Default", n2 + 32 + 2, n3 + 1, 0xFFFFFF);
                this._c.func_73731_b(ekou._h(this._c), yekc2._a(), n2 + 32 + 2, n3 + 12 + 10, 0x808080);
            }
            catch (IOException iOException) {
                // empty catch block
            }
            return;
        }
        yehh yehh2 = (yehh)this._a._d().get(n - 1);
        yehh2._a(apbu2);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        htvf2.func_78382_b();
        htvf2.func_78378_d(0xFFFFFF);
        htvf2.func_78374_a(n2, n3 + n4, 0.0, 0.0, 1.0);
        htvf2.func_78374_a(n2 + 32, n3 + n4, 0.0, 1.0, 1.0);
        htvf2.func_78374_a(n2 + 32, n3, 0.0, 1.0, 0.0);
        htvf2.func_78374_a(n2, n3, 0.0, 0.0, 0.0);
        htvf2.func_78381_a();
        String string = yehh2._d();
        if (string.length() > 32) {
            string = string.substring(0, 32).trim() + "...";
        }
        this._c.func_73731_b(ekou._i(this._c), string, n2 + 32 + 2, n3 + 1, 0xFFFFFF);
        List list = ekou._j(this._c)._c(yehh2._e(), 183);
        for (int i = 0; i < 2 && i < list.size(); ++i) {
            this._c.func_73731_b(ekou._k(this._c), (String)list.get(i), n2 + 32 + 2, n3 + 12 + 10 * i, 0x808080);
        }
    }

    public static /* synthetic */ pknz _a(gqva gqva2) {
        return gqva2._a;
    }
}

