/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.player.EntityPlayer;

public class ssyj
extends jjgc {
    public ofxb _a;
    public yeso _b;
    private final EntityPlayer _c;

    public ssyj(EntityPlayer entityPlayer) {
        int n;
        this._c = entityPlayer;
        for (n = 0; n < 3; ++n) {
            for (int i = 0; i < 9; ++i) {
                this.func_75146_a(new yeso(entityPlayer.field_71071_by, i + n * 9 + 9, 8 + i * 18, 70 + n * 18));
            }
        }
        for (n = 0; n < 9; ++n) {
            this.func_75146_a(new yeso(entityPlayer.field_71071_by, n, 8 + n * 18, 127));
        }
        this._a = new dgmn(1);
        this._b = new yeso(this._a, 0, 80, 29){

            @Override
            public boolean func_75214_a(cvzo cvzo2) {
                return cvzo2 == null || cvzo2._a() instanceof oxnm;
            }
        };
        this.func_75146_a(this._b);
    }

    @Override
    public cvzo func_82846_b(EntityPlayer entityPlayer, int n) {
        cvzo cvzo2 = null;
        yeso yeso2 = (yeso)this.field_75151_b.get(n);
        if (yeso2 != null && yeso2.func_75216_d()) {
            cvzo cvzo3 = yeso2.func_75211_c();
            cvzo2 = cvzo3._l();
            if (n == 36) {
                if (!this.func_75135_a(cvzo3, 0, 36, false)) {
                    return null;
                }
            } else if (cvzo2._a() instanceof oxnm && !this._b.func_75216_d()) {
                cvzo cvzo4 = cvzo3._l();
                cvzo4._b = 1;
                --cvzo3._b;
                this._b.func_75215_d(cvzo4);
            }
            if (cvzo3._b == 0) {
                yeso2.func_75215_d(null);
            }
            if (cvzo3._b == cvzo2._b) {
                return null;
            }
            yeso2.func_82870_a(this._c, cvzo3);
        }
        return cvzo2;
    }

    @Override
    public boolean func_75145_c(EntityPlayer entityPlayer) {
        return true;
    }
}

