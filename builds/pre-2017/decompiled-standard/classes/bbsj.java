/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.Random;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.IShearable;

public class bbsj
extends tgdv {
    public bbsj(int n) {
        super(n);
        this.func_77625_d(1);
        this.func_77656_e(238);
        this.func_77637_a(tgbl.field_78040_i);
    }

    @Override
    public boolean func_77660_a(cvzo cvzo2, ozlu ozlu2, int n, int n2, int n3, int n4, EntityLivingBase entityLivingBase) {
        if (n != twgu.field_71952_K.field_71990_ca && n != twgu.field_71955_W.field_71990_ca && n != twgu.field_71962_X.field_71990_ca && n != twgu.field_71998_bu.field_71990_ca && n != twgu.field_72062_bU.field_71990_ca && !(twgu.field_71973_m[n] instanceof IShearable)) {
            return super.func_77660_a(cvzo2, ozlu2, n, n2, n3, n4, entityLivingBase);
        }
        return true;
    }

    @Override
    public boolean func_77641_a(twgu twgu2) {
        return twgu2.field_71990_ca == twgu.field_71955_W.field_71990_ca || twgu2.field_71990_ca == twgu.field_72075_av.field_71990_ca || twgu2.field_71990_ca == twgu.field_72062_bU.field_71990_ca;
    }

    @Override
    public float func_77638_a(cvzo cvzo2, twgu twgu2) {
        return twgu2.field_71990_ca != twgu.field_71955_W.field_71990_ca && twgu2.field_71990_ca != twgu.field_71952_K.field_71990_ca ? (twgu2.field_71990_ca == twgu.field_72101_ab.field_71990_ca ? 5.0f : super.func_77638_a(cvzo2, twgu2)) : 15.0f;
    }

    @Override
    public boolean func_111207_a(cvzo cvzo2, EntityPlayer entityPlayer, EntityLivingBase entityLivingBase) {
        if (entityLivingBase.field_70170_p.field_72995_K) {
            return false;
        }
        if (entityLivingBase instanceof IShearable) {
            IShearable iShearable = (IShearable)((Object)entityLivingBase);
            if (iShearable.isShearable(cvzo2, entityLivingBase.field_70170_p, (int)entityLivingBase.field_70165_t, (int)entityLivingBase.field_70163_u, (int)entityLivingBase.field_70161_v)) {
                ArrayList<cvzo> arrayList = iShearable.onSheared(cvzo2, entityLivingBase.field_70170_p, (int)entityLivingBase.field_70165_t, (int)entityLivingBase.field_70163_u, (int)entityLivingBase.field_70161_v, zhty._a(zhqo._t._y, cvzo2));
                Random random = new Random();
                for (cvzo cvzo3 : arrayList) {
                    EntityItem entityItem = entityLivingBase.func_70099_a(cvzo3, 1.0f);
                    entityItem.field_70181_x += (double)(random.nextFloat() * 0.05f);
                    entityItem.field_70159_w += (double)((random.nextFloat() - random.nextFloat()) * 0.1f);
                    entityItem.field_70179_y += (double)((random.nextFloat() - random.nextFloat()) * 0.1f);
                }
                cvzo2._a(1, entityLivingBase);
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean onBlockStartBreak(cvzo cvzo2, int n, int n2, int n3, EntityPlayer entityPlayer) {
        IShearable iShearable;
        if (entityPlayer.field_70170_p.field_72995_K) {
            return false;
        }
        int n4 = entityPlayer.field_70170_p.func_72798_a(n, n2, n3);
        if (twgu.field_71973_m[n4] instanceof IShearable && (iShearable = (IShearable)((Object)twgu.field_71973_m[n4])).isShearable(cvzo2, entityPlayer.field_70170_p, n, n2, n3)) {
            ArrayList<cvzo> arrayList = iShearable.onSheared(cvzo2, entityPlayer.field_70170_p, n, n2, n3, zhty._a(zhqo._t._y, cvzo2));
            Random random = new Random();
            for (cvzo cvzo3 : arrayList) {
                float f = 0.7f;
                double d = (double)(random.nextFloat() * f) + (double)(1.0f - f) * 0.5;
                double d2 = (double)(random.nextFloat() * f) + (double)(1.0f - f) * 0.5;
                double d3 = (double)(random.nextFloat() * f) + (double)(1.0f - f) * 0.5;
                EntityItem entityItem = new EntityItem(entityPlayer.field_70170_p, (double)n + d, (double)n2 + d2, (double)n3 + d3, cvzo3);
                entityItem.field_70293_c = 10;
                entityPlayer.field_70170_p.func_72838_d(entityItem);
            }
            cvzo2._a(1, (EntityLivingBase)entityPlayer);
            entityPlayer.func_71064_a(dzif._C[n4], 1);
        }
        return false;
    }
}

