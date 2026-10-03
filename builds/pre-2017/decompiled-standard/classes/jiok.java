/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.xpzm;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class jiok
extends bawa {
    public static final ResourceLocation field_110332_a = new ResourceLocation("textures/gui/widgets.png");
    public int field_73747_a = 200;
    public int field_73745_b = 20;
    public int field_73746_c;
    public int field_73743_d;
    public String field_73744_e;
    public int field_73741_f;
    public boolean field_73742_g = true;
    public boolean field_73748_h = true;
    public boolean field_82253_i;

    public jiok(int n, int n2, int n3, String string) {
        this(n, n2, n3, 200, 20, string);
    }

    public jiok(int n, int n2, int n3, int n4, int n5, String string) {
        this.field_73741_f = n;
        this.field_73746_c = n2;
        this.field_73743_d = n3;
        this.field_73747_a = n4;
        this.field_73745_b = n5;
        this.field_73744_e = string;
    }

    public int func_73738_a(boolean bl) {
        int n = 1;
        if (!this.field_73742_g) {
            n = 0;
        } else if (bl) {
            n = 2;
        }
        return n;
    }

    public void func_73737_a(xpzm xpzm2, int n, int n2) {
        if (!this.field_73748_h) {
            return;
        }
        qncw qncw2 = xpzm2._z;
        xpzm2._R()._a(field_110332_a);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.field_82253_i = n >= this.field_73746_c && n2 >= this.field_73743_d && n < this.field_73746_c + this.field_73747_a && n2 < this.field_73743_d + this.field_73745_b;
        int n3 = this.func_73738_a(this.field_82253_i);
        this.func_73729_b(this.field_73746_c, this.field_73743_d, 0, 46 + n3 * 20, this.field_73747_a / 2, this.field_73745_b);
        this.func_73729_b(this.field_73746_c + this.field_73747_a / 2, this.field_73743_d, 200 - this.field_73747_a / 2, 46 + n3 * 20, this.field_73747_a / 2, this.field_73745_b);
        this.func_73739_b(xpzm2, n, n2);
        int n4 = 0xE0E0E0;
        if (!this.field_73742_g) {
            n4 = -6250336;
        } else if (this.field_82253_i) {
            n4 = 0xFFFFA0;
        }
        this.func_73732_a(qncw2, this.field_73744_e, this.field_73746_c + this.field_73747_a / 2, this.field_73743_d + (this.field_73745_b - 8) / 2, n4);
    }

    public void func_73739_b(xpzm xpzm2, int n, int n2) {
    }

    public void func_73740_a(int n, int n2) {
    }

    public boolean func_73736_c(xpzm xpzm2, int n, int n2) {
        return this.field_73742_g && this.field_73748_h && n >= this.field_73746_c && n2 >= this.field_73743_d && n < this.field_73746_c + this.field_73747_a && n2 < this.field_73743_d + this.field_73745_b;
    }

    public boolean func_82252_a() {
        return this.field_82253_i;
    }

    public void func_82251_b(int n, int n2) {
    }
}

