/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.zwat;

public class yejn
extends stzt {
    @Override
    public String func_71517_b() {
        return "defaultgamemode";
    }

    @Override
    public String func_71518_a(nemo nemo2) {
        return "commands.defaultgamemode.usage";
    }

    @Override
    public void func_71515_b(nemo nemo2, String[] stringArray) {
        if (stringArray.length > 0) {
            xtby xtby2 = this._a(nemo2, stringArray[0]);
            this._a(xtby2);
            yejn.func_71522_a(nemo2, "commands.defaultgamemode.success", zwat._e("gameMode." + xtby2._b()));
            return;
        }
        throw new pksd("commands.defaultgamemode.usage", new Object[0]);
    }

    public void _a(xtby xtby2) {
        dzfd dzfd2 = dzfd._I();
        dzfd2._a(xtby2);
        if (dzfd2.__ao()) {
            for (EntityPlayerMP entityPlayerMP : dzfd._I().__ag()._e) {
                entityPlayerMP.func_71033_a(xtby2);
                entityPlayerMP.field_70143_R = 0.0f;
            }
        }
    }
}

