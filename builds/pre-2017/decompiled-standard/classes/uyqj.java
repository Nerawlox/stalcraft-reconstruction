/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.InvokeWithResult;
import gloomyfolken.mods.core.main.GloomyCore;
import java.util.Random;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;

public class uyqj
extends gphy {
    public int _h;
    private satl _k;
    private Random _l = new Random();
    public String _i = "";
    public String _j = "";

    public uyqj(int n, int n2, boolean bl) {
        super(n, bl);
        this._h = n2;
    }

    @Override
    public boolean hasTileEntity(int n) {
        return true;
    }

    @Override
    public hurg func_72274_a(ozlu ozlu2) {
        return new hbio(this);
    }

    public satl _a() {
        if (this._k != null) {
            return this._k;
        }
        if (GloomyCore.side.isServer()) {
            return InvokeWithResult.frontend(() -> null);
        }
        return null;
    }

    public uyqj _a(satl satl2) {
        this._k = satl2;
        return this;
    }

    @Override
    public void func_71927_h(ozlu ozlu2, int n, int n2, int n3, int n4) {
        super.func_71927_h(ozlu2, n, n2, n3, n4);
        if (!ozlu2.field_72995_K) {
            InvokeSideOnly.frontend(() -> {});
        }
    }

    @Override
    public void func_71852_a(ozlu ozlu2, int n, int n2, int n3, int n4, int n5) {
        yfav yfav2 = (yfav)ozlu2.func_72796_p(n, n2, n3);
        if (yfav2 != null) {
            for (int i = 0; i < yfav2.func_70302_i_(); ++i) {
                cvzo cvzo2 = yfav2.func_70301_a(i);
                if (cvzo2 == null) continue;
                float f = this._l.nextFloat() * 0.8f + 0.1f;
                float f2 = this._l.nextFloat() * 0.8f + 0.1f;
                float f3 = this._l.nextFloat() * 0.8f + 0.1f;
                while (cvzo2._b > 0) {
                    int n6 = this._l.nextInt(21) + 10;
                    if (n6 > cvzo2._b) {
                        n6 = cvzo2._b;
                    }
                    cvzo2._b -= n6;
                    EntityItem entityItem = new EntityItem(ozlu2, (float)n + f, (float)n2 + f2, (float)n3 + f3, new cvzo(cvzo2._d, n6, cvzo2._j()));
                    float f4 = 0.05f;
                    entityItem.field_70159_w = (float)this._l.nextGaussian() * f4;
                    entityItem.field_70181_x = (float)this._l.nextGaussian() * f4 + 0.2f;
                    entityItem.field_70179_y = (float)this._l.nextGaussian() * f4;
                    if (cvzo2._p()) {
                        entityItem.func_92059_d()._d((qoac)cvzo2._q()._c());
                    }
                    ozlu2.func_72838_d(entityItem);
                }
            }
            ozlu2.func_96440_m(n, n2, n3, n4);
        }
        super.func_71852_a(ozlu2, n, n2, n3, n4, n5);
    }

    @Override
    public boolean func_71903_a(ozlu ozlu2, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        if (ozlu2.field_72995_K) {
            return true;
        }
        mssh mssh2 = this._a(ozlu2, n, n2, n3);
        if (mssh2 != null) {
            entityPlayer.func_71007_a(mssh2);
        }
        return true;
    }

    public mssh _a(ozlu ozlu2, int n, int n2, int n3) {
        hurg hurg2 = ozlu2.func_72796_p(n, n2, n3);
        if (hurg2 != null && !(hurg2 instanceof hbio)) {
            hurg2.func_70313_j();
        }
        return (mssh)((Object)ozlu2.func_72796_p(n, n2, n3));
    }
}

