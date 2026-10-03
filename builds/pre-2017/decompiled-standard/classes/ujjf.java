/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.player.EntityPlayer;

public class ujjf
extends tgdv {
    public static final vmgb _a = new ixgp();
    public int _b;

    public ujjf(int n, int n2) {
        super(n);
        this.field_77777_bU = 1;
        this._b = n2;
        this.func_77637_a(tgbl.field_78029_e);
        ejzs._a._a(this, _a);
    }

    @Override
    public boolean func_77648_a(cvzo cvzo2, EntityPlayer entityPlayer, ozlu ozlu2, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        int n5 = ozlu2.func_72798_a(n, n2, n3);
        if (scgt._a(n5)) {
            if (!ozlu2.field_72995_K) {
                EntityMinecart entityMinecart = EntityMinecart.func_94090_a(ozlu2, (float)n + 0.5f, (float)n2 + 0.5f, (float)n3 + 0.5f, this._b);
                if (cvzo2._u()) {
                    entityMinecart.func_96094_a(cvzo2._s());
                }
                ozlu2.func_72838_d(entityMinecart);
            }
            --cvzo2._b;
            return true;
        }
        return false;
    }
}

