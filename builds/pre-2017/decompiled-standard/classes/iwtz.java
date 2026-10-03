/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.player.eidj;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class iwtz
extends zybc {
    public static final ResourceLocation _a = new ResourceLocation("textures/gui/container/furnace.png");
    public nwgz _b;

    public iwtz(eidj eidj2, nwgz nwgz2) {
        super(new lplm(eidj2, nwgz2));
        this._b = nwgz2;
    }

    @Override
    public void func_74189_g(int n, int n2) {
        String string = this._b.func_94042_c() ? this._b.func_70303_b() : wpcz._a(this._b.func_70303_b());
        this.field_73886_k._b(string, this.field_74194_b / 2 - this.field_73886_k._b(string) / 2, 6, 0x404040);
        this.field_73886_k._b(wpcz._a("container.inventory"), 8, this.field_74195_c - 96 + 2, 0x404040);
    }

    @Override
    public void func_74185_a(float f, int n, int n2) {
        int n3;
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.field_73882_e._R()._a(_a);
        int n4 = (this.field_73880_f - this.field_74194_b) / 2;
        int n5 = (this.field_73881_g - this.field_74195_c) / 2;
        this.func_73729_b(n4, n5, 0, 0, this.field_74194_b, this.field_74195_c);
        if (this._b._a()) {
            n3 = this._b._c(12);
            this.func_73729_b(n4 + 56, n5 + 36 + 12 - n3, 176, 12 - n3, 14, n3 + 2);
        }
        n3 = this._b._b(24);
        this.func_73729_b(n4 + 79, n5 + 34, 176, 14, n3 + 1, 16);
    }
}

