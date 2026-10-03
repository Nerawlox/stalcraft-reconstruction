/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;

public class ixjm
extends tgdv {
    public ixjm(int n) {
        super(n);
        this.func_77637_a(tgbl.field_78029_e);
        this.func_77625_d(1);
        this.func_77656_e(25);
    }

    @Override
    public boolean func_77662_d() {
        return true;
    }

    @Override
    public boolean func_77629_n_() {
        return true;
    }

    @Override
    public cvzo func_77659_a(cvzo cvzo2, ozlu ozlu2, EntityPlayer entityPlayer) {
        EntityPig entityPig;
        if (entityPlayer.func_70115_ae() && entityPlayer.field_70154_o instanceof EntityPig && (entityPig = (EntityPig)entityPlayer.field_70154_o).func_82183_n()._c() && cvzo2._k() - cvzo2._j() >= 7) {
            entityPig.func_82183_n()._b();
            cvzo2._a(7, (EntityLivingBase)entityPlayer);
            if (cvzo2._b == 0) {
                cvzo cvzo3 = new cvzo(tgdv.field_77749_aR);
                cvzo3._d(cvzo2._e);
                return cvzo3;
            }
        }
        return cvzo2;
    }
}

