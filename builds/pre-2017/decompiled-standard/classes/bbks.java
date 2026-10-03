/*
 * Decompiled with CFR 0.152.
 */
import java.util.Arrays;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ezfc;
import net.minecraft.util.zwat;

public class bbks
extends ohnk {
    @Override
    public List func_71514_a() {
        return Arrays.asList("w", "msg");
    }

    @Override
    public String func_71517_b() {
        return "tell";
    }

    @Override
    public int func_82362_a() {
        return 0;
    }

    @Override
    public String func_71518_a(nemo nemo2) {
        return "commands.message.usage";
    }

    @Override
    public void func_71515_b(nemo nemo2, String[] stringArray) {
        if (stringArray.length < 2) {
            throw new pksd("commands.message.usage", new Object[0]);
        }
        EntityPlayerMP entityPlayerMP = bbks.func_82359_c(nemo2, stringArray[0]);
        if (entityPlayerMP == null) {
            throw new mskk();
        }
        if (entityPlayerMP == nemo2) {
            throw new mskk("commands.message.sameTarget", new Object[0]);
        }
        String string = bbks.func_82361_a(nemo2, stringArray, 1, !(nemo2 instanceof EntityPlayer));
        entityPlayerMP.func_70006_a(zwat._b("commands.message.display.incoming", nemo2.func_70005_c_(), string)._a(ezfc._h)._b(true));
        nemo2.func_70006_a(zwat._b("commands.message.display.outgoing", entityPlayerMP.func_70005_c_(), string)._a(ezfc._h)._b(true));
    }

    @Override
    public List func_71516_a(nemo nemo2, String[] stringArray) {
        return bbks.func_71530_a(stringArray, dzfd._I()._i());
    }

    @Override
    public boolean func_82358_a(String[] stringArray, int n) {
        return n == 0;
    }
}

