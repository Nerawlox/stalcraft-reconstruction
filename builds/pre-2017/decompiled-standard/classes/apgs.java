/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.jxtc;
import net.minecraft.util.zwat;

public class apgs
extends ohnk {
    @Override
    public String func_71517_b() {
        return "kill";
    }

    @Override
    public int func_82362_a() {
        return 0;
    }

    @Override
    public String func_71518_a(nemo nemo2) {
        return "commands.kill.usage";
    }

    @Override
    public void func_71515_b(nemo nemo2, String[] stringArray) {
        EntityPlayerMP entityPlayerMP = apgs.func_71521_c(nemo2);
        ((EntityPlayer)entityPlayerMP).func_70097_a(jxtc.field_76380_i, Float.MAX_VALUE);
        nemo2.func_70006_a(zwat._e("commands.kill.success"));
    }
}

