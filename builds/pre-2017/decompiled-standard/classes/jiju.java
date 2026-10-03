/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;

public class jiju
extends hter {
    public ogzk _b;

    public jiju(int n, String string, tflj tflj2, ogzk ogzk2) {
        super(n, string, tflj2);
        this._b = ogzk2;
    }

    @Override
    public int _c(int n) {
        return n > 0 ? 1 : 0;
    }

    @Override
    public int _b(int n) {
        return n == 1 ? 15 : 0;
    }

    @Override
    public int _b(ozlu ozlu2, int n, int n2, int n3) {
        List list2 = null;
        if (this._b == ogzk._a) {
            list2 = ozlu2.func_72839_b(null, this._a(n, n2, n3));
        }
        if (this._b == ogzk._b) {
            list2 = ozlu2.func_72872_a(EntityLivingBase.class, this._a(n, n2, n3));
        }
        if (this._b == ogzk._c) {
            list2 = ozlu2.func_72872_a(EntityPlayer.class, this._a(n, n2, n3));
        }
        if (list2 != null && !list2.isEmpty()) {
            for (Entity entity : list2) {
                if (entity.func_82144_au()) continue;
                return 15;
            }
        }
        return 0;
    }
}

