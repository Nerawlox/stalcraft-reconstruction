/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.dwan;

public class mbpd
extends tgdv {
    public int field_77885_a;
    @SideOnly(value=Side.CLIENT)
    public dwan field_94588_b;

    public mbpd(int n) {
        super(n);
        this.field_77885_a = n + 256;
    }

    public int func_77883_f() {
        return this.field_77885_a;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int func_94901_k() {
        return twgu.field_71973_m[this.field_77885_a].func_94327_t_() != null ? 1 : 0;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public dwan func_77617_a(int n) {
        return this.field_94588_b != null ? this.field_94588_b : twgu.field_71973_m[this.field_77885_a].func_71851_a(1);
    }

    @Override
    public boolean func_77648_a(cvzo cvzo2, EntityPlayer entityPlayer, ozlu ozlu2, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        int n5 = ozlu2.func_72798_a(n, n2, n3);
        if (n5 == twgu.field_72037_aS.field_71990_ca && (ozlu2.func_72805_g(n, n2, n3) & 7) < 1) {
            n4 = 1;
        } else if (!(n5 == twgu.field_71998_bu.field_71990_ca || n5 == twgu.field_71962_X.field_71990_ca || n5 == twgu.field_71961_Y.field_71990_ca || twgu.field_71973_m[n5] != null && twgu.field_71973_m[n5].isBlockReplaceable(ozlu2, n, n2, n3))) {
            if (n4 == 0) {
                --n2;
            }
            if (n4 == 1) {
                ++n2;
            }
            if (n4 == 2) {
                --n3;
            }
            if (n4 == 3) {
                ++n3;
            }
            if (n4 == 4) {
                --n;
            }
            if (n4 == 5) {
                ++n;
            }
        }
        if (cvzo2._b == 0) {
            return false;
        }
        if (!entityPlayer.func_82247_a(n, n2, n3, n4, cvzo2)) {
            return false;
        }
        if (n2 == 255 && twgu.field_71973_m[this.field_77885_a].field_72018_cp._a()) {
            return false;
        }
        if (ozlu2.func_72931_a(this.field_77885_a, n, n2, n3, false, n4, entityPlayer, cvzo2)) {
            twgu twgu2 = twgu.field_71973_m[this.field_77885_a];
            int n6 = this.func_77647_b(cvzo2._j());
            int n7 = twgu.field_71973_m[this.field_77885_a].func_85104_a(ozlu2, n, n2, n3, n4, f, f2, f3, n6);
            if (this.placeBlockAt(cvzo2, entityPlayer, ozlu2, n, n2, n3, n4, f, f2, f3, n7)) {
                ozlu2.func_72908_a((float)n + 0.5f, (float)n2 + 0.5f, (float)n3 + 0.5f, twgu2.field_72020_cn._e(), (twgu2.field_72020_cn._a() + 1.0f) / 2.0f, twgu2.field_72020_cn._b() * 0.8f);
                --cvzo2._b;
            }
            return true;
        }
        return false;
    }

    @SideOnly(value=Side.CLIENT)
    public boolean func_77884_a(ozlu ozlu2, int n, int n2, int n3, int n4, EntityPlayer entityPlayer, cvzo cvzo2) {
        int n5 = ozlu2.func_72798_a(n, n2, n3);
        if (n5 == twgu.field_72037_aS.field_71990_ca) {
            n4 = 1;
        } else if (!(n5 == twgu.field_71998_bu.field_71990_ca || n5 == twgu.field_71962_X.field_71990_ca || n5 == twgu.field_71961_Y.field_71990_ca || twgu.field_71973_m[n5] != null && twgu.field_71973_m[n5].isBlockReplaceable(ozlu2, n, n2, n3))) {
            if (n4 == 0) {
                --n2;
            }
            if (n4 == 1) {
                ++n2;
            }
            if (n4 == 2) {
                --n3;
            }
            if (n4 == 3) {
                ++n3;
            }
            if (n4 == 4) {
                --n;
            }
            if (n4 == 5) {
                ++n;
            }
        }
        return ozlu2.func_72931_a(this.func_77883_f(), n, n2, n3, false, n4, null, cvzo2);
    }

    @Override
    public String func_77667_c(cvzo cvzo2) {
        return twgu.field_71973_m[this.field_77885_a].func_71917_a();
    }

    @Override
    public String func_77658_a() {
        return twgu.field_71973_m[this.field_77885_a].func_71917_a();
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public tgbl func_77640_w() {
        return twgu.field_71973_m[this.field_77885_a].func_71882_w();
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_77633_a(int n, tgbl tgbl2, List list2) {
        twgu.field_71973_m[this.field_77885_a].func_71879_a(n, tgbl2, list2);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_94581_a(nege nege2) {
        String string = twgu.field_71973_m[this.field_77885_a].func_94327_t_();
        if (string != null) {
            this.field_94588_b = nege2._b(string);
        }
    }

    public boolean placeBlockAt(cvzo cvzo2, EntityPlayer entityPlayer, ozlu ozlu2, int n, int n2, int n3, int n4, float f, float f2, float f3, int n5) {
        if (!ozlu2.func_72832_d(n, n2, n3, this.field_77885_a, n5, 3)) {
            return false;
        }
        if (ozlu2.func_72798_a(n, n2, n3) == this.field_77885_a) {
            twgu.field_71973_m[this.field_77885_a].func_71860_a(ozlu2, n, n2, n3, entityPlayer, cvzo2);
            twgu.field_71973_m[this.field_77885_a].func_85105_g(ozlu2, n, n2, n3, n5);
        }
        return true;
    }
}

