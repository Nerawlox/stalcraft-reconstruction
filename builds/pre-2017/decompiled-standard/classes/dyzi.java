/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;

public class dyzi
extends tgdv {
    public dyzi(int n) {
        super(n);
        this.func_77637_a(tgbl.field_78040_i);
    }

    @Override
    public boolean func_111207_a(cvzo cvzo2, EntityPlayer entityPlayer, EntityLivingBase entityLivingBase) {
        if (!cvzo2._u()) {
            return false;
        }
        if (entityLivingBase instanceof EntityLiving) {
            EntityLiving entityLiving = (EntityLiving)entityLivingBase;
            entityLiving.func_94058_c(cvzo2._s());
            entityLiving.func_110163_bv();
            --cvzo2._b;
            return true;
        }
        return super.func_111207_a(cvzo2, entityPlayer, entityLivingBase);
    }
}

