/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import net.minecraft.entity.player.EntityPlayerMP;

public class qnwp
extends ohnk {
    @Override
    public String func_71517_b() {
        return "kick";
    }

    @Override
    public int func_82362_a() {
        return 3;
    }

    @Override
    public String func_71518_a(nemo nemo2) {
        return "commands.kick.usage";
    }

    @Override
    public void func_71515_b(nemo nemo2, String[] stringArray) {
        if (stringArray.length > 0 && stringArray[0].length() > 1) {
            EntityPlayerMP entityPlayerMP = dzfd._I().__ag()._h(stringArray[0]);
            String string = "Kicked by an operator.";
            boolean bl = false;
            if (entityPlayerMP == null) {
                throw new mskk();
            }
            if (stringArray.length >= 2) {
                string = qnwp.func_82360_a(nemo2, stringArray, 1);
                bl = true;
            }
            entityPlayerMP.field_71135_a.func_72565_c(string);
            if (bl) {
                qnwp.func_71522_a(nemo2, "commands.kick.success.reason", entityPlayerMP.func_70023_ak(), string);
            } else {
                qnwp.func_71522_a(nemo2, "commands.kick.success", entityPlayerMP.func_70023_ak());
            }
            return;
        }
        throw new pksd("commands.kick.usage", new Object[0]);
    }

    @Override
    public List func_71516_a(nemo nemo2, String[] stringArray) {
        if (stringArray.length >= 1) {
            return qnwp.func_71530_a(stringArray, dzfd._I()._i());
        }
        return null;
    }
}

