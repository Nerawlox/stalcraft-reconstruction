/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.util.dwan;

public class jjkq
extends tgdv {
    public dwan _a;

    public jjkq(int n) {
        super(n);
        this.func_77656_e(64);
        this.func_77625_d(1);
        this.func_77637_a(tgbl.field_78040_i);
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
        if (entityPlayer.field_71104_cf != null) {
            int n = entityPlayer.field_71104_cf.func_70198_d();
            cvzo2._a(n, (EntityLivingBase)entityPlayer);
            entityPlayer.func_71038_i();
        } else {
            ozlu2.func_72956_a(entityPlayer, "random.bow", 0.5f, 0.4f / (field_77697_d.nextFloat() * 0.4f + 0.8f));
            if (!ozlu2.field_72995_K) {
                ozlu2.func_72838_d(new EntityFishHook(ozlu2, entityPlayer));
            }
            entityPlayer.func_71038_i();
        }
        return cvzo2;
    }

    @Override
    public void func_94581_a(nege nege2) {
        this.field_77791_bV = nege2._b(this.func_111208_A() + "_uncast");
        this._a = nege2._b(this.func_111208_A() + "_cast");
    }

    public dwan _a() {
        return this._a;
    }
}

