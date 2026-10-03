/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.asm.Logger;
import gloomyfolken.mods.core.misc.kjwj;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import org.apache.commons.lang3.StringUtils;

public class jyqh
extends kjwj {
    public final List<String> _b;

    public jyqh(int n, String string, String string2, List<String> list2, int n2, int n3, List<String> list3) {
        super(n, string, string2, list2, n2);
        this._b = list3;
        this.func_77656_e(n3);
    }

    @Override
    public cvzo func_77659_a(cvzo cvzo2, ozlu ozlu2, EntityPlayer entityPlayer) {
        if (!ozlu2.field_72995_K) {
            for (String string : this._b) {
                string = StringUtils.replace(string, "@p", entityPlayer.field_71092_bJ);
                if (cvzo2._e != null && cvzo2._e._c("buyer")) {
                    string = StringUtils.replace(string, "@b", cvzo2._e._j("buyer"));
                }
                Logger.info("Player " + entityPlayer.field_71092_bJ + " used item " + this.field_77779_bT + " to execute command: " + string, new Object[0]);
                dzfd dzfd2 = dzfd._I();
                if (dzfd2 instanceof ujth) {
                    ((ujth)dzfd2)._a(string, dzfd2);
                    continue;
                }
                dzfd2._a(string);
            }
        }
        if (cvzo2._k() > 0) {
            cvzo2._b(cvzo2._j() + 1);
            if (cvzo2._j() >= cvzo2._k()) {
                --cvzo2._b;
            }
        }
        return cvzo2;
    }
}

