/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.xpzm;
import org.lwjgl.opengl.GL11;

public class iflj
extends jiok {
    public iflj(int n, int n2, int n3) {
        super(n, n2, n3, 20, 20, "");
    }

    @Override
    public void func_73737_a(xpzm xpzm2, int n, int n2) {
        if (!this.field_73748_h) {
            return;
        }
        xpzm2._R()._a(jiok.field_110332_a);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        boolean bl = n >= this.field_73746_c && n2 >= this.field_73743_d && n < this.field_73746_c + this.field_73747_a && n2 < this.field_73743_d + this.field_73745_b;
        int n3 = 106;
        if (bl) {
            n3 += this.field_73745_b;
        }
        this.func_73729_b(this.field_73746_c, this.field_73743_d, 0, n3, this.field_73747_a, this.field_73745_b);
    }
}

