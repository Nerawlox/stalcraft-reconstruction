/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.zwat;

public class cvpo
extends ohnk {
    @Override
    public boolean func_71519_b(nemo nemo2) {
        return dzfd._I()._N() || super.func_71519_b(nemo2);
    }

    @Override
    public String func_71517_b() {
        return "seed";
    }

    @Override
    public int func_82362_a() {
        return 2;
    }

    @Override
    public String func_71518_a(nemo nemo2) {
        return "commands.seed.usage";
    }

    @Override
    public void func_71515_b(nemo nemo2, String[] stringArray) {
        ozlu ozlu2 = nemo2 instanceof EntityPlayer ? ((EntityPlayer)nemo2).field_70170_p : dzfd._I()._a(0);
        nemo2.func_70006_a(zwat._b("commands.seed.success", ozlu2.func_72905_C()));
    }
}

