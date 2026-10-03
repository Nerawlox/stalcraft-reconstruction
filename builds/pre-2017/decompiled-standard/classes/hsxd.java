/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import net.minecraft.client.xpzm;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@ezey(_a={eidj.CLIENT})
public class hsxd
extends lpaq {
    private float _d;
    private float _e;
    private static final int _f = 227;
    private static final int _g = 181;
    public static final ResourceLocation _a = new ResourceLocation("stalker", "textures/gui/inventory.png");
    public static final ResourceLocation _b = new ResourceLocation("stalker", "textures/gui/backpack.png");
    public jzak _c;

    public hsxd(jzak jzak2) {
        super(jzak2);
        this._c = jzak2;
        this.field_73885_j = true;
    }

    @Override
    public void func_73876_c() {
        super.func_73876_c();
    }

    @Override
    public void func_73866_w_() {
        this.field_73887_h.clear();
        this.field_74194_b = 227;
        this.field_74195_c = 181;
        this.field_74198_m = this.field_73880_f / 2 - this.field_74194_b / 2;
        this.field_74197_n = this.field_73881_g / 2 - this.field_74195_c / 2;
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        super.func_73863_a(n, n2, f);
        this._d = n;
        this._e = n2;
    }

    @Override
    protected void func_74185_a(float f, int n, int n2) {
        int n3;
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glDisable(2896);
        xpzm._E()._h._a(_a);
        this.func_73729_b(this.field_73880_f / 2 - 113, this.field_73881_g / 2 - 90, 0, 0, 227, 181);
        if (this._c.hasBackpack()) {
            this.func_73729_b(this.field_73880_f / 2 - 113 + 199, this.field_73881_g / 2 - 90 + 14, 228, 0, 20, 153);
        }
        for (int i = n3 = this._c.getArtefaktSlots(); i < 5; ++i) {
            this.func_73729_b(this.field_73880_f / 2 - 113 + 7 + i * 18, this.field_73881_g / 2 - 90 + 107, 228, 154, 18, 18);
        }
        this.func_73732_a(this.field_73886_k, "\u0427\u0442\u043e\u0431\u044b \u0437\u0430\u0431\u0440\u0430\u0442\u044c \u043f\u0440\u0435\u0434\u043c\u0435\u0442, \u043a\u043b\u0438\u043a\u043d\u0438\u0442\u0435 \u043f\u043e \u043d\u0435\u043c\u0443 \u041f\u041a\u041c", this.field_73880_f / 2, this.field_73881_g / 2 - 90 - 20, 0xFFFFFF);
    }

    @Override
    protected void func_74189_g(int n, int n2) {
    }

    @Override
    protected void func_73875_a(jiok jiok2) {
        if (jiok2.field_73741_f == 0) {
            this.field_73882_e._a(new ohbq(this.field_73882_e._X));
        }
        if (jiok2.field_73741_f == 1) {
            this.field_73882_e._a(new uzta(this, this.field_73882_e._X));
        }
    }
}

