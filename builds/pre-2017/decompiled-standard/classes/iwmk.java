/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.player.eidj;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class iwmk
extends zybc {
    public static final ResourceLocation _a = new ResourceLocation("textures/gui/container/hopper.png");
    public mssh _b;
    public mssh _c;

    public iwmk(eidj eidj2, mssh mssh2) {
        super(new xsns(eidj2, mssh2));
        this._b = eidj2;
        this._c = mssh2;
        this.field_73885_j = false;
        this.field_74195_c = 133;
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
    }
}

