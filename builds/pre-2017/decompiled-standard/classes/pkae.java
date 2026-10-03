/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.xpzm;
import org.lwjgl.opengl.GL11;

public class pkae
extends jiok {
    public final boolean _a;

    public pkae(int n, int n2, int n3, boolean bl) {
        super(n, n2, n3, 12, 19, "");
        this._a = bl;
    }

    @Override
    public void func_73737_a(xpzm xpzm2, int n, int n2) {
        if (!this.field_73748_h) {
            return;
        }
        xpzm2._R()._a(xayk._b());
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        boolean bl = n >= this.field_73746_c && n2 >= this.field_73743_d && n < this.field_73746_c + this.field_73747_a && n2 < this.field_73743_d + this.field_73745_b;
        int n3 = 0;
        int n4 = 176;
        if (!this.field_73742_g) {
            n4 += this.field_73747_a * 2;
        } else if (bl) {
            n4 += this.field_73747_a;
        }
        if (!this._a) {
            n3 += this.field_73745_b;
        }
        this.func_73729_b(this.field_73746_c, this.field_73743_d, n4, n3, this.field_73747_a, this.field_73745_b);
    }
}

