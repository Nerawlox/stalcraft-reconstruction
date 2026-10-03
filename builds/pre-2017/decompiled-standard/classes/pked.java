/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.xpzm;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class pked
extends jiok {
    public final ResourceLocation _a;
    public final int _b;
    public final int _c;
    public boolean _d;

    public pked(int n, int n2, int n3, ResourceLocation resourceLocation, int n4, int n5) {
        super(n, n2, n3, 22, 22, "");
        this._a = resourceLocation;
        this._b = n4;
        this._c = n5;
    }

    @Override
    public void func_73737_a(xpzm xpzm2, int n, int n2) {
        if (!this.field_73748_h) {
            return;
        }
        xpzm2._R()._a(tfow._a());
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.field_82253_i = n >= this.field_73746_c && n2 >= this.field_73743_d && n < this.field_73746_c + this.field_73747_a && n2 < this.field_73743_d + this.field_73745_b;
        int n3 = 219;
        int n4 = 0;
        if (!this.field_73742_g) {
            n4 += this.field_73747_a * 2;
        } else if (this._d) {
            n4 += this.field_73747_a * 1;
        } else if (this.field_82253_i) {
            n4 += this.field_73747_a * 3;
        }
        this.func_73729_b(this.field_73746_c, this.field_73743_d, n4, n3, this.field_73747_a, this.field_73745_b);
        if (!tfow._a().equals(this._a)) {
            xpzm2._R()._a(this._a);
        }
        this.func_73729_b(this.field_73746_c + 2, this.field_73743_d + 2, this._b, this._c, 18, 18);
    }

    public boolean _a() {
        return this._d;
    }

    public void _a(boolean bl) {
        this._d = bl;
    }
}

