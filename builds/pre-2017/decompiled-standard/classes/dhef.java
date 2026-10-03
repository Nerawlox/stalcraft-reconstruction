/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class dhef
extends zybc {
    public static final ResourceLocation _a = new ResourceLocation("textures/gui/container/horse.png");
    public mssh _b;
    public mssh _c;
    public EntityHorse _d;
    public float _e;
    public float _f;

    public dhef(mssh mssh2, mssh mssh3, EntityHorse entityHorse) {
        super(new qnzl(mssh2, mssh3, entityHorse));
        this._b = mssh2;
        this._c = mssh3;
        this._d = entityHorse;
        this.field_73885_j = false;
    }

    @Override
    public void func_74189_g(int n, int n2) {
        this.field_73886_k._b(this._c.func_94042_c() ? this._c.func_70303_b() : wpcz._a(this._c.func_70303_b()), 8, 6, 0x404040);
        this.field_73886_k._b(this._b.func_94042_c() ? this._b.func_70303_b() : wpcz._a(this._b.func_70303_b()), 8, this.field_74195_c - 96 + 2, 0x404040);
    }

    @Override
    public void func_74185_a(float f, int n, int n2) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.field_73882_e._R()._a(_a);
        int n3 = (this.field_73880_f - this.field_74194_b) / 2;
        int n4 = (this.field_73881_g - this.field_74195_c) / 2;
        this.func_73729_b(n3, n4, 0, 0, this.field_74194_b, this.field_74195_c);
        if (this._d.func_110261_ca()) {
            this.func_73729_b(n3 + 79, n4 + 17, 0, this.field_74195_c, 90, 54);
        }
        if (this._d.func_110259_cr()) {
            this.func_73729_b(n3 + 7, n4 + 35, 0, this.field_74195_c + 54, 18, 18);
        }
        cebg._a(n3 + 51, n4 + 60, 17, (float)(n3 + 51) - this._e, (float)(n4 + 75 - 50) - this._f, this._d);
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        this._e = n;
        this._f = n2;
        super.func_73863_a(n, n2, f);
    }
}

