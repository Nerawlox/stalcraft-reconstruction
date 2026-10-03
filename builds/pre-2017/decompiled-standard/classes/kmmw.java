/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.dwan;
import net.minecraft.util.sajh;
import net.minecraft.util.tdpx;

public class kmmw
extends tgdv {
    public static final String[] _a = new String[]{"skeleton", "wither", "zombie", "char", "creeper"};
    public static final String[] _b = new String[]{"skeleton", "wither", "zombie", "steve", "creeper"};
    public dwan[] _c;

    public kmmw(int n) {
        super(n);
        this.func_77637_a(tgbl.field_78031_c);
        this.func_77656_e(0);
        this.func_77627_a(true);
    }

    @Override
    public boolean func_77648_a(cvzo cvzo2, EntityPlayer entityPlayer, ozlu ozlu2, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        hurg hurg2;
        if (n4 == 0) {
            return false;
        }
        if (!ozlu2.func_72803_f(n, n2, n3)._a()) {
            return false;
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
        if (!entityPlayer.func_82247_a(n, n2, n3, n4, cvzo2)) {
            return false;
        }
        if (!twgu.field_82512_cj.func_71930_b(ozlu2, n, n2, n3)) {
            return false;
        }
        ozlu2.func_72832_d(n, n2, n3, twgu.field_82512_cj.field_71990_ca, n4, 2);
        int n5 = 0;
        if (n4 == 1) {
            n5 = sajh._c((double)(entityPlayer.field_70177_z * 16.0f / 360.0f) + 0.5) & 0xF;
        }
        if ((hurg2 = ozlu2.func_72796_p(n, n2, n3)) != null && hurg2 instanceof fool) {
            String string = "";
            if (cvzo2._p() && cvzo2._q()._c("SkullOwner")) {
                string = cvzo2._q()._j("SkullOwner");
            }
            ((fool)hurg2)._a(cvzo2._j(), string);
            ((fool)hurg2)._a(n5);
            ((uznu)twgu.field_82512_cj)._a(ozlu2, n, n2, n3, (fool)hurg2);
        }
        --cvzo2._b;
        return true;
    }

    @Override
    public void func_77633_a(int n, tgbl tgbl2, List list2) {
        for (int i = 0; i < _a.length; ++i) {
            list2.add(new cvzo(n, 1, i));
        }
    }

    @Override
    public dwan func_77617_a(int n) {
        if (n < 0 || n >= _a.length) {
            n = 0;
        }
        return this._c[n];
    }

    @Override
    public int func_77647_b(int n) {
        return n;
    }

    @Override
    public String func_77667_c(cvzo cvzo2) {
        int n = cvzo2._j();
        if (n < 0 || n >= _a.length) {
            n = 0;
        }
        return super.func_77658_a() + "." + _a[n];
    }

    @Override
    public String func_77628_j(cvzo cvzo2) {
        if (cvzo2._j() == 3 && cvzo2._p() && cvzo2._q()._c("SkullOwner")) {
            return tdpx._a("item.skull.player.name", cvzo2._q()._j("SkullOwner"));
        }
        return super.func_77628_j(cvzo2);
    }

    @Override
    public void func_94581_a(nege nege2) {
        this._c = new dwan[_b.length];
        for (int i = 0; i < _b.length; ++i) {
            this._c[i] = nege2._b(this.func_111208_A() + "_" + _b[i]);
        }
    }
}

