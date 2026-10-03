/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;

public class xsse
extends tgdv {
    public xsse(int n) {
        super(n);
        this.field_77777_bU = 1;
        this.func_77637_a(tgbl.field_78029_e);
    }

    @Override
    public boolean func_111207_a(cvzo cvzo2, EntityPlayer entityPlayer, EntityLivingBase entityLivingBase) {
        if (entityLivingBase instanceof EntityPig) {
            EntityPig entityPig = (EntityPig)entityLivingBase;
            if (!entityPig.func_70901_n() && !entityPig.func_70631_g_()) {
                entityPig.func_70900_e(true);
                --cvzo2._b;
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean func_77644_a(cvzo cvzo2, EntityLivingBase entityLivingBase, EntityLivingBase entityLivingBase2) {
        this.func_111207_a(cvzo2, null, entityLivingBase);
        return true;
    }
}

