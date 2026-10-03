/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.dwan;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.IShearable;

public class brvf
extends aorr
implements IShearable {
    public static final String[] _a = new String[]{"deadbush", "tallgrass", "fern"};
    @SideOnly(value=Side.CLIENT)
    public dwan[] _b;

    public brvf(int n) {
        super(n, tflj._l);
        float f = 0.4f;
        this.func_71905_a(0.5f - f, 0.0f, 0.5f - f, 0.5f + f, 0.8f, 0.5f + f);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public dwan func_71858_a(int n, int n2) {
        if (n2 >= this._b.length) {
            n2 = 0;
        }
        return this._b[n2];
    }

    @Override
    public int func_71885_a(int n, Random random, int n2) {
        return -1;
    }

    @Override
    public int func_71910_a(int n, Random random) {
        return 1 + random.nextInt(n * 2 + 1);
    }

    @Override
    public void func_71893_a(ozlu ozlu2, EntityPlayer entityPlayer, int n, int n2, int n3, int n4) {
        super.func_71893_a(ozlu2, entityPlayer, n, n2, n3, n4);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int func_71933_m() {
        double d = 0.5;
        double d2 = 1.0;
        return gapq._a(d, d2);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int func_71889_f_(int n) {
        return n == 0 ? 0xFFFFFF : igvq._c();
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int func_71920_b(sdrg sdrg2, int n, int n2, int n3) {
        int n4 = sdrg2.func_72805_g(n, n2, n3);
        return n4 == 0 ? 0xFFFFFF : sdrg2.func_72807_a(n, n3)._l();
    }

    @Override
    public int func_71873_h(ozlu ozlu2, int n, int n2, int n3) {
        return ozlu2.func_72805_g(n, n2, n3);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_71879_a(int n, tgbl tgbl2, List list2) {
        for (int i = 1; i < 3; ++i) {
            list2.add(new cvzo(n, 1, i));
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_94332_a(nege nege2) {
        this._b = new dwan[_a.length];
        for (int i = 0; i < this._b.length; ++i) {
            this._b[i] = nege2._b(_a[i]);
        }
    }

    @Override
    public ArrayList<cvzo> getBlockDropped(ozlu ozlu2, int n, int n2, int n3, int n4, int n5) {
        ArrayList<cvzo> arrayList = new ArrayList<cvzo>();
        if (ozlu2.field_73012_v.nextInt(8) != 0) {
            return arrayList;
        }
        cvzo cvzo2 = ForgeHooks.getGrassSeed(ozlu2);
        if (cvzo2 != null) {
            arrayList.add(cvzo2);
        }
        return arrayList;
    }

    @Override
    public boolean isShearable(cvzo cvzo2, ozlu ozlu2, int n, int n2, int n3) {
        return true;
    }

    @Override
    public ArrayList<cvzo> onSheared(cvzo cvzo2, ozlu ozlu2, int n, int n2, int n3, int n4) {
        ArrayList<cvzo> arrayList = new ArrayList<cvzo>();
        arrayList.add(new cvzo(this, 1, ozlu2.func_72805_g(n, n2, n3)));
        return arrayList;
    }
}

