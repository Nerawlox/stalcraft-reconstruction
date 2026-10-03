/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;

public class wpso
extends tgdv {
    public wpso(int n) {
        super(n);
        this.field_77777_bU = 16;
        this.func_77637_a(tgbl.field_78026_f);
    }

    @Override
    public cvzo func_77659_a(cvzo cvzo2, ozlu ozlu2, EntityPlayer entityPlayer) {
        if (!entityPlayer.field_71075_bZ._d) {
            --cvzo2._b;
        }
        ozlu2.func_72956_a(entityPlayer, "random.bow", 0.5f, 0.4f / (field_77697_d.nextFloat() * 0.4f + 0.8f));
        if (!ozlu2.field_72995_K) {
            ozlu2.func_72838_d(new EntitySnowball(ozlu2, entityPlayer));
        }
        return cvzo2;
    }
}

