/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import net.minecraft.entity.player.EntityPlayerMP;

public class xbga
extends ohnk {
    @Override
    public String func_71517_b() {
        return "ban";
    }

    @Override
    public int func_82362_a() {
        return 3;
    }

    @Override
    public String func_71518_a(nemo nemo2) {
        return "commands.ban.usage";
    }

    @Override
    public boolean func_71519_b(nemo nemo2) {
        return dzfd._I().__ag()._l()._a() && super.func_71519_b(nemo2);
    }

    @Override
    public void func_71515_b(nemo nemo2, String[] stringArray) {
        if (stringArray.length >= 1 && stringArray[0].length() > 0) {
            EntityPlayerMP entityPlayerMP = dzfd._I().__ag()._h(stringArray[0]);
            eljf eljf2 = new eljf(stringArray[0]);
            eljf2._a(nemo2.func_70005_c_());
            if (stringArray.length >= 2) {
                eljf2._b(xbga.func_82360_a(nemo2, stringArray, 1));
            }
            dzfd._I().__ag()._l()._a(eljf2);
            if (entityPlayerMP != null) {
                entityPlayerMP.field_71135_a.func_72565_c("You are banned from this server.");
            }
            xbga.func_71522_a(nemo2, "commands.ban.success", stringArray[0]);
            return;
        }
        throw new pksd("commands.ban.usage", new Object[0]);
    }

    @Override
    public List func_71516_a(nemo nemo2, String[] stringArray) {
        if (stringArray.length >= 1) {
            return xbga.func_71530_a(stringArray, dzfd._I()._i());
        }
        return null;
    }
}

