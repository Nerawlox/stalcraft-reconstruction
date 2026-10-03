/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.EntityLivingBase;

public class hdps
extends hdpq {
    public hdps(int n, boolean bl, int n2) {
        super(n, bl, n2);
    }

    @Override
    public void _a(EntityLivingBase entityLivingBase, mbno mbno2, int n) {
        entityLivingBase.func_110149_m(entityLivingBase.func_110139_bj() - (float)(4 * (n + 1)));
        super._a(entityLivingBase, mbno2, n);
    }

    @Override
    public void _b(EntityLivingBase entityLivingBase, mbno mbno2, int n) {
        entityLivingBase.func_110149_m(entityLivingBase.func_110139_bj() + (float)(4 * (n + 1)));
        super._b(entityLivingBase, mbno2, n);
    }
}

