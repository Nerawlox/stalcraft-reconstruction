/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import net.minecraft.entity.player.EntityPlayerMP;

public class xbgx
extends ohnk {
    @Override
    public String func_71517_b() {
        return "clear";
    }

    @Override
    public String func_71518_a(nemo nemo2) {
        return "commands.clear.usage";
    }

    @Override
    public int func_82362_a() {
        return 2;
    }

    @Override
    public void func_71515_b(nemo nemo2, String[] stringArray) {
        EntityPlayerMP entityPlayerMP = stringArray.length == 0 ? xbgx.func_71521_c(nemo2) : xbgx.func_82359_c(nemo2, stringArray[0]);
        int n = stringArray.length >= 2 ? xbgx.func_71528_a(nemo2, stringArray[1], 1) : -1;
        int n2 = stringArray.length >= 3 ? xbgx.func_71528_a(nemo2, stringArray[2], 0) : -1;
        int n3 = entityPlayerMP.field_71071_by._b(n, n2);
        entityPlayerMP.field_71069_bz.func_75142_b();
        if (!entityPlayerMP.field_71075_bZ._d) {
            entityPlayerMP.func_71113_k();
        }
        if (n3 == 0) {
            throw new cekk("commands.clear.failure", entityPlayerMP.func_70023_ak());
        }
        xbgx.func_71522_a(nemo2, "commands.clear.success", entityPlayerMP.func_70023_ak(), n3);
    }

    @Override
    public List func_71516_a(nemo nemo2, String[] stringArray) {
        if (stringArray.length == 1) {
            return xbgx.func_71530_a(stringArray, this._a());
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

