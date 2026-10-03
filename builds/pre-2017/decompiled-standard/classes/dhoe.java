/*
 * Decompiled with CFR 0.152.
 */
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ezfc;
import net.minecraft.util.zwat;

public class dhoe
extends ohnk {
    @Override
    public String func_71517_b() {
        return "help";
    }

    @Override
    public int func_82362_a() {
        return 0;
    }

    @Override
    public String func_71518_a(nemo nemo2) {
        return "commands.help.usage";
    }

    @Override
    public List func_71514_a() {
        return Arrays.asList("?");
    }

    @Override
    public void func_71515_b(nemo nemo2, String[] stringArray) {
        List list = this._a(nemo2);
        int n = 7;
        int n2 = (list.size() - 1) / n;
        int n3 = 0;
        try {
            n3 = stringArray.length == 0 ? 0 : dhoe.func_71532_a(nemo2, stringArray[0], 1, n2 + 1) - 1;
        }
        catch (jjcb jjcb2) {
            Map map = this._a();
            kmew kmew2 = (kmew)map.get(stringArray[0]);
            if (kmew2 != null) {
                throw new pksd(kmew2.func_71518_a(nemo2), new Object[0]);
            }
            throw new dhob();
        }
        int n4 = Math.min((n3 + 1) * n, list.size());
        nemo2.func_70006_a(zwat._b("commands.help.header", n3 + 1, n2 + 1)._a(ezfc._c));
        for (int i = n3 * n; i < n4; ++i) {
            kmew kmew3 = (kmew)list.get(i);
            nemo2.func_70006_a(zwat._e(kmew3.func_71518_a(nemo2)));
        }
        if (n3 == 0 && nemo2 instanceof EntityPlayer) {
            nemo2.func_70006_a(zwat._e("commands.help.footer")._a(ezfc._k));
        }
    }

    public List _a(nemo nemo2) {
        List list = dzfd._I()._J().func_71557_a(nemo2);
        Collections.sort(list);
        return list;
    }

    public Map _a() {
        return dzfd._I()._J().func_71555_a();
    }
}

