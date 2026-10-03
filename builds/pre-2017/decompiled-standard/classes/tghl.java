/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.amww;
import net.minecraft.util.hank;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.entity.player.FillBucketEvent;

public class tghl
extends tgdv {
    public int _a;

    public tghl(int n, int n2) {
        super(n);
        this.field_77777_bU = 1;
        this._a = n2;
        this.func_77637_a(tgbl.field_78026_f);
    }

    @Override
    public cvzo func_77659_a(cvzo cvzo2, ozlu ozlu2, EntityPlayer entityPlayer) {
        boolean bl = this._a == 0;
        hank hank2 = this.func_77621_a(ozlu2, entityPlayer, bl);
        if (hank2 == null) {
            return cvzo2;
        }
        FillBucketEvent fillBucketEvent = new FillBucketEvent(entityPlayer, cvzo2, ozlu2, hank2);
        if (MinecraftForge.EVENT_BUS.post(fillBucketEvent)) {
            return cvzo2;
        }
        if (fillBucketEvent.getResult() == Event.Result.ALLOW) {
            if (entityPlayer.field_71075_bZ._d) {
                return cvzo2;
            }
            if (--cvzo2._b <= 0) {
                return fillBucketEvent.result;
            }
            if (!entityPlayer.field_71071_by._c(fillBucketEvent.result)) {
                entityPlayer.func_71021_b(fillBucketEvent.result);
            }
            return cvzo2;
        }
        if (hank2._c == amww._a) {
            int n = hank2._d;
            int n2 = hank2._e;
            int n3 = hank2._f;
            if (!ozlu2.func_72962_a(entityPlayer, n, n2, n3)) {
                return cvzo2;
            }
            if (this._a == 0) {
                if (!entityPlayer.func_82247_a(n, n2, n3, hank2._g, cvzo2)) {
                    return cvzo2;
                }
                if (ozlu2.func_72803_f(n, n2, n3) == tflj._h && ozlu2.func_72805_g(n, n2, n3) == 0) {
                    ozlu2.func_94571_i(n, n2, n3);
                    if (entityPlayer.field_71075_bZ._d) {
                        return cvzo2;
                    }
                    if (--cvzo2._b <= 0) {
                        return new cvzo(tgdv.field_77786_ax);
                    }
                    if (!entityPlayer.field_71071_by._c(new cvzo(tgdv.field_77786_ax))) {
                        entityPlayer.func_71021_b(new cvzo(tgdv.field_77786_ax.field_77779_bT, 1, 0));
                    }
                    return cvzo2;
                }
                if (ozlu2.func_72803_f(n, n2, n3) == tflj._i && ozlu2.func_72805_g(n, n2, n3) == 0) {
                    ozlu2.func_94571_i(n, n2, n3);
                    if (entityPlayer.field_71075_bZ._d) {
                        return cvzo2;
                    }
                    if (--cvzo2._b <= 0) {
                        return new cvzo(tgdv.field_77775_ay);
                    }
                    if (!entityPlayer.field_71071_by._c(new cvzo(tgdv.field_77775_ay))) {
                        entityPlayer.func_71021_b(new cvzo(tgdv.field_77775_ay.field_77779_bT, 1, 0));
                    }
                    return cvzo2;
                }
            } else {
                if (this._a < 0) {
                    return new cvzo(tgdv.field_77788_aw);
                }
                if (hank2._g == 0) {
                    --n2;
                }
                if (hank2._g == 1) {
                    ++n2;
                }
                if (hank2._g == 2) {
                    --n3;
                }
                if (hank2._g == 3) {
                    ++n3;
                }
                if (hank2._g == 4) {
                    --n;
                }
                if (hank2._g == 5) {
                    ++n;
                }
                if (!entityPlayer.func_82247_a(n, n2, n3, hank2._g, cvzo2)) {
                    return cvzo2;
                }
                if (this._a(ozlu2, n, n2, n3) && !entityPlayer.field_71075_bZ._d) {
                    return new cvzo(tgdv.field_77788_aw);
                }
            }
        }
        return cvzo2;
    }

    public boolean _a(ozlu ozlu2, int n, int n2, int n3) {
        boolean bl;
        if (this._a <= 0) {
            return false;
        }
        tflj tflj2 = ozlu2.func_72803_f(n, n2, n3);
        boolean bl2 = bl = !tflj2._a();
        if (!ozlu2.func_72799_c(n, n2, n3) && !bl) {
            return false;
        }
        if (ozlu2.field_73011_w._f && this._a == twgu.field_71942_A.field_71990_ca) {
            ozlu2.func_72908_a((float)n + 0.5f, (float)n2 + 0.5f, (float)n3 + 0.5f, "random.fizz", 0.5f, 2.6f + (ozlu2.field_73012_v.nextFloat() - ozlu2.field_73012_v.nextFloat()) * 0.8f);
            for (int i = 0; i < 8; ++i) {
                ozlu2.func_72869_a("largesmoke", (double)n + Math.random(), (double)n2 + Math.random(), (double)n3 + Math.random(), 0.0, 0.0, 0.0);
            }
        } else {
            if (!ozlu2.field_72995_K && bl && !tflj2._d()) {
                ozlu2.func_94578_a(n, n2, n3, true);
            }
            ozlu2.func_72832_d(n, n2, n3, this._a, 0, 3);
        }
        return true;
    }
}

