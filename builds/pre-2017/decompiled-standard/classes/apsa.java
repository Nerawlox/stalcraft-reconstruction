/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.player.EntityPlayer;

public class apsa
extends tgdv {
    public apsa(int n) {
        super(n);
        this.field_77777_bU = 16;
        this.func_77637_a(tgbl.field_78026_f);
    }

    @Override
    public cvzo func_77659_a(cvzo cvzo2, ozlu ozlu2, EntityPlayer entityPlayer) {
        if (entityPlayer.field_71075_bZ._d) {
            return cvzo2;
        }
        --cvzo2._b;
        ozlu2.func_72956_a(entityPlayer, "random.bow", 0.5f, 0.4f / (field_77697_d.nextFloat() * 0.4f + 0.8f));
        if (!ozlu2.field_72995_K) {
            ozlu2.func_72838_d(new EntityEnderPearl(ozlu2, entityPlayer));
        }
        return cvzo2;
    }
}

