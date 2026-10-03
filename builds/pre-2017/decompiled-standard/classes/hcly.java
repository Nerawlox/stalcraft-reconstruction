/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class hcly
extends zybc {
    public static final ResourceLocation _a = new ResourceLocation("textures/gui/container/generic_54.png");
    public mssh _b;
    public mssh _c;
    public int _d;

    public hcly(mssh mssh2, mssh mssh3) {
        super(new wpkx(mssh2, mssh3));
        this._b = mssh2;
        this._c = mssh3;
        this.field_73885_j = false;
        int n = 222;
        int n2 = n - 108;
        this._d = mssh3.func_70302_i_() / 9;
        this.field_74195_c = n2 + this._d * 18;
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
        this.func_73729_b(n3, n4, 0, 0, this.field_74194_b, this._d * 18 + 17);
        this.func_73729_b(n3, n4 + this._d * 18 + 17, 0, 126, this.field_74194_b, 96);
    }
}

