/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.item.EntityItem;
import net.minecraft.util.sajh;

public class dxzw
extends hter {
    public final int _b;

    public dxzw(int n, String string, tflj tflj2, int n2) {
        super(n, string, tflj2);
        this._b = n2;
    }

    @Override
    public int _b(ozlu ozlu2, int n, int n2, int n3) {
        int n4 = 0;
        for (EntityItem entityItem : ozlu2.func_72872_a(EntityItem.class, this._a(n, n2, n3))) {
            if ((n4 += entityItem.func_92059_d()._b) < this._b) continue;
            break;
        }
        if (n4 <= 0) {
            return 0;
        }
        float f = (float)Math.min(this._b, n4) / (float)this._b;
        return sajh._f(f * 15.0f);
    }

    @Override
    public int _b(int n) {
        return n;
    }

    @Override
    public int _c(int n) {
        return n;
    }

    @Override
    public int func_71859_p_(ozlu ozlu2) {
        return 10;
    }
}

