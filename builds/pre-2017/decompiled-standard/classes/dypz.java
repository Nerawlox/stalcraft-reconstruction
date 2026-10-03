/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class dypz
extends ohnk {
    @Override
    public String func_71517_b() {
        return "give";
    }

    @Override
    public int func_82362_a() {
        return 2;
    }

    @Override
    public String func_71518_a(nemo nemo2) {
        return "commands.give.usage";
    }

    @Override
    public void func_71515_b(nemo nemo2, String[] stringArray) {
        if (stringArray.length >= 2) {
            EntityPlayerMP entityPlayerMP = dypz.func_82359_c(nemo2, stringArray[0]);
            int n = dypz.func_71528_a(nemo2, stringArray[1], 1);
            int n2 = 1;
            int n3 = 0;
            if (tgdv.field_77698_e[n] == null) {
                throw new jjcb("commands.give.notFound", n);
            }
            if (stringArray.length >= 3) {
                n2 = dypz.func_71532_a(nemo2, stringArray[2], 1, 64);
            }
            if (stringArray.length >= 4) {
                n3 = dypz.func_71526_a(nemo2, stringArray[3]);
            }
            cvzo cvzo2 = new cvzo(n, n2, n3);
            EntityItem entityItem = ((EntityPlayer)entityPlayerMP).func_71021_b(cvzo2);
            entityItem.field_70293_c = 0;
            dypz.func_71522_a(nemo2, "commands.give.success", tgdv.field_77698_e[n].func_77653_i(cvzo2), n, n2, entityPlayerMP.func_70023_ak());
            return;
        }
        throw new pksd("commands.give.usage", new Object[0]);
    }

    @Override
    public List func_71516_a(nemo nemo2, String[] stringArray) {
        if (stringArray.length == 1) {
            return dypz.func_71530_a(stringArray, this._a());
        }
        return null;
    }

    public String[] _a() {
        return dzfd._I()._i();
    }

    @Override
    public boolean func_82358_a(String[] stringArray, int n) {
        return n == 0;
    }
}

