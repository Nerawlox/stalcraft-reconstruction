/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.zwat;

public class stzt
extends ohnk {
    @Override
    public String func_71517_b() {
        return "gamemode";
    }

    @Override
    public int func_82362_a() {
        return 2;
    }

    @Override
    public String func_71518_a(nemo nemo2) {
        return "commands.gamemode.usage";
    }

    @Override
    public void func_71515_b(nemo nemo2, String[] stringArray) {
        if (stringArray.length > 0) {
            xtby xtby2 = this._a(nemo2, stringArray[0]);
            EntityPlayerMP entityPlayerMP = stringArray.length >= 2 ? stzt.func_82359_c(nemo2, stringArray[1]) : stzt.func_71521_c(nemo2);
            ((EntityPlayer)entityPlayerMP).func_71033_a(xtby2);
            entityPlayerMP.field_70143_R = 0.0f;
            zwat zwat2 = zwat._e("gameMode." + xtby2._b());
            if (entityPlayerMP != nemo2) {
                stzt.func_71524_a(nemo2, 1, "commands.gamemode.success.other", entityPlayerMP.func_70023_ak(), zwat2);
            } else {
                stzt.func_71524_a(nemo2, 1, "commands.gamemode.success.self", zwat2);
            }
            return;
        }
        throw new pksd("commands.gamemode.usage", new Object[0]);
    }

    public xtby _a(nemo nemo2, String string) {
        if (string.equalsIgnoreCase(xtby._b._b()) || string.equalsIgnoreCase("s")) {
            return xtby._b;
        }
        if (string.equalsIgnoreCase(xtby._c._b()) || string.equalsIgnoreCase("c")) {
            return xtby._c;
        }
        if (string.equalsIgnoreCase(xtby._d._b()) || string.equalsIgnoreCase("a")) {
            return xtby._d;
        }
        return nfhj._a(stzt.func_71532_a(nemo2, string, 0, xtby.values().length - 2));
    }

    @Override
    public List func_71516_a(nemo nemo2, String[] stringArray) {
        if (stringArray.length == 1) {
            return stzt.func_71530_a(stringArray, "survival", "creative", "adventure");
        }
        if (stringArray.length == 2) {
            return stzt.func_71530_a(stringArray, this._a());
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

