/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.xpzm;
import org.lwjgl.opengl.GL11;

public class rqga
extends jiok {
    public final boolean _a;

    public rqga(int n, int n2, int n3, boolean bl) {
        super(n, n2, n3, 23, 13, "");
        this._a = bl;
    }

    @Override
    public void func_73737_a(xpzm xpzm2, int n, int n2) {
        if (!this.field_73748_h) {
            return;
        }
        boolean bl = n >= this.field_73746_c && n2 >= this.field_73743_d && n < this.field_73746_c + this.field_73747_a && n2 < this.field_73743_d + this.field_73745_b;
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        xpzm2._R()._a(htmc._d());
        int n3 = 0;
        int n4 = 192;
        if (bl) {
            n3 += 23;
        }
        if (!this._a) {
            n4 += 13;
        }
        this.func_73729_b(this.field_73746_c, this.field_73743_d, n3, n4, 23, 13);
    }
}

