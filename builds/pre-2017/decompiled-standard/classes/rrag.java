/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.player.EntityPlayer;

public class rrag
extends yeso {
    public EntityPlayer _a;

    public rrag(EntityPlayer entityPlayer, mssh mssh2, int n, int n2, int n3) {
        super(mssh2, n, n2, n3);
        this._a = entityPlayer;
    }

    @Override
    public boolean func_75214_a(cvzo cvzo2) {
        return rrag._a(cvzo2);
    }

    @Override
    public int func_75219_a() {
        return 1;
    }

    @Override
    public void func_82870_a(EntityPlayer entityPlayer, cvzo cvzo2) {
        if (cvzo2._a() instanceof zyyc && cvzo2._j() > 0) {
            this._a.func_71064_a(sdqa._A, 1);
        }
        super.func_82870_a(entityPlayer, cvzo2);
    }

    public static boolean _a(cvzo cvzo2) {
        return cvzo2 != null && (cvzo2._a() instanceof zyyc || cvzo2._d == tgdv.field_77729_bt.field_77779_bT);
    }
}

