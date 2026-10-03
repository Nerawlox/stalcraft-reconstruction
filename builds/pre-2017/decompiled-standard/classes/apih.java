/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class apih
extends ohnk {
    @Override
    public String func_71517_b() {
        return "xp";
    }

    @Override
    public int func_82362_a() {
        return 2;
    }

    @Override
    public String func_71518_a(nemo nemo2) {
        return "commands.xp.usage";
    }

    @Override
    public void func_71515_b(nemo nemo2, String[] stringArray) {
        if (stringArray.length > 0) {
            int n;
            boolean bl;
            boolean bl2;
            String string = stringArray[0];
            boolean bl3 = bl2 = string.endsWith("l") || string.endsWith("L");
            if (bl2 && string.length() > 1) {
                string = string.substring(0, string.length() - 1);
            }
            boolean bl4 = bl = (n = apih.func_71526_a(nemo2, string)) < 0;
            if (bl) {
                n *= -1;
            }
            EntityPlayerMP entityPlayerMP = stringArray.length > 1 ? apih.func_82359_c(nemo2, stringArray[1]) : apih.func_71521_c(nemo2);
            if (bl2) {
                if (bl) {
                    ((EntityPlayer)entityPlayerMP).func_82242_a(-n);
                    apih.func_71522_a(nemo2, "commands.xp.success.negative.levels", n, entityPlayerMP.func_70023_ak());
                } else {
                    ((EntityPlayer)entityPlayerMP).func_82242_a(n);
                    apih.func_71522_a(nemo2, "commands.xp.success.levels", n, entityPlayerMP.func_70023_ak());
                }
            } else {
                if (bl) {
                    throw new pksd("commands.xp.failure.widthdrawXp", new Object[0]);
                }
                ((EntityPlayer)entityPlayerMP).func_71023_q(n);
                apih.func_71522_a(nemo2, "commands.xp.success", n, entityPlayerMP.func_70023_ak());
            }
            return;
        }
        throw new pksd("commands.xp.usage", new Object[0]);
    }

    @Override
    public List func_71516_a(nemo nemo2, String[] stringArray) {
        if (stringArray.length == 2) {
            return apih.func_71530_a(stringArray, this._a());
        }
        return null;
    }

    public String[] _a() {
        return dzfd._I()._i();
    }

    @Override
    public boolean func_82358_a(String[] stringArray, int n) {
        return n == 1;
    }
}

