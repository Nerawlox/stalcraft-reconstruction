/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.entity.player.EntityPlayerMP;

public class bsjk
extends ohnk {
    public static final Pattern _a = Pattern.compile("^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");

    @Override
    public String func_71517_b() {
        return "ban-ip";
    }

    @Override
    public int func_82362_a() {
        return 3;
    }

    @Override
    public boolean func_71519_b(nemo nemo2) {
        return dzfd._I().__ag()._m()._a() && super.func_71519_b(nemo2);
    }

    @Override
    public String func_71518_a(nemo nemo2) {
        return "commands.banip.usage";
    }

    @Override
    public void func_71515_b(nemo nemo2, String[] stringArray) {
        if (stringArray.length >= 1 && stringArray[0].length() > 1) {
            Matcher matcher = _a.matcher(stringArray[0]);
            String string = null;
            if (stringArray.length >= 2) {
                string = bsjk.func_82360_a(nemo2, stringArray, 1);
            }
            if (matcher.matches()) {
                this._a(nemo2, stringArray[0], string);
            } else {
                EntityPlayerMP entityPlayerMP = dzfd._I().__ag()._h(stringArray[0]);
                if (entityPlayerMP == null) {
                    throw new mskk("commands.banip.invalid", new Object[0]);
                }
                this._a(nemo2, entityPlayerMP.func_71114_r(), string);
            }
            return;
        }
        throw new pksd("commands.banip.usage", new Object[0]);
    }

    @Override
    public List func_71516_a(nemo nemo2, String[] stringArray) {
        if (stringArray.length == 1) {
            return bsjk.func_71530_a(stringArray, dzfd._I()._i());
        }
        return null;
    }

    public void _a(nemo nemo2, String string, String string2) {
        eljf eljf2 = new eljf(string);
        eljf2._a(nemo2.func_70005_c_());
        if (string2 != null) {
            eljf2._b(string2);
        }
        dzfd._I().__ag()._m()._a(eljf2);
        List list = dzfd._I().__ag()._i(string);
        Object[] objectArray = new String[list.size()];
        int n = 0;
        for (EntityPlayerMP entityPlayerMP : list) {
            entityPlayerMP.field_71135_a.func_72565_c("You have been IP banned.");
            objectArray[n++] = entityPlayerMP.func_70023_ak();
        }
        if (list.isEmpty()) {
            bsjk.func_71522_a(nemo2, "commands.banip.success", string);
        } else {
            bsjk.func_71522_a(nemo2, "commands.banip.success.players", string, bsjk.func_71527_a(objectArray));
        }
    }
}

