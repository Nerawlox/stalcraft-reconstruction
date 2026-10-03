/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Random;
import net.minecraft.util.dwan;
import net.minecraftforge.common.ForgeDirection;

public class dgxw
extends aorr {
    @SideOnly(value=Side.CLIENT)
    public dwan[] _a;

    public dgxw(int n) {
        super(n);
        this.func_71907_b(true);
        float f = 0.5f;
        this.func_71905_a(0.5f - f, 0.0f, 0.5f - f, 0.5f + f, 0.25f, 0.5f + f);
        this.func_71849_a(null);
    }

    @Override
    public boolean _a(int n) {
        return n == twgu.field_72013_bc.field_71990_ca;
    }

    @Override
    public boolean func_71854_d(ozlu ozlu2, int n, int n2, int n3) {
        twgu twgu2 = twgu.field_71973_m[ozlu2.func_72798_a(n, n2 - 1, n3)];
        return twgu2 != null && twgu2.canSustainPlant(ozlu2, n, n2 - 1, n3, ForgeDirection.UP, this);
    }

    @Override
    public void func_71847_b(ozlu ozlu2, int n, int n2, int n3, Random random) {
        int n4 = ozlu2.func_72805_g(n, n2, n3);
        if (n4 < 3 && random.nextInt(10) == 0) {
            ozlu2.func_72921_c(n, n2, n3, ++n4, 2);
        }
        super.func_71847_b(ozlu2, n, n2, n3, random);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public dwan func_71858_a(int n, int n2) {
        return n2 >= 3 ? this._a[2] : (n2 > 0 ? this._a[1] : this._a[0]);
    }

    @Override
    public int func_71857_b() {
        return 6;
    }

    @Override
    public void func_71914_a(ozlu ozlu2, int n, int n2, int n3, int n4, float f, int n5) {
        super.func_71914_a(ozlu2, n, n2, n3, n4, f, n5);
    }

    @Override
    public int func_71885_a(int n, Random random, int n2) {
        return 0;
    }

    @Override
    public int func_71925_a(Random random) {
        return 0;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int func_71922_a(ozlu ozlu2, int n, int n2, int n3) {
        return tgdv.field_77727_br.field_77779_bT;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_94332_a(nege nege2) {
        this._a = new dwan[3];
        for (int i = 0; i < this._a.length; ++i) {
            this._a[i] = nege2._b(this.func_111023_E() + "_stage_" + i);
        }
    }

    @Override
    public ArrayList<cvzo> getBlockDropped(ozlu ozlu2, int n, int n2, int n3, int n4, int n5) {
        ArrayList<cvzo> arrayList = new ArrayList<cvzo>();
        int n6 = 1;
        if (n4 >= 3) {
            n6 = 2 + ozlu2.field_73012_v.nextInt(3) + (n5 > 0 ? ozlu2.field_73012_v.nextInt(n5 + 1) : 0);
        }
        for (int i = 0; i < n6; ++i) {
            arrayList.add(new cvzo(tgdv.field_77727_br));
        }
        return arrayList;
    }
}

