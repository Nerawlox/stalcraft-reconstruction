/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.brushedit.pidb;
import net.minecraft.entity.player.EntityPlayer;

public class ctqj
extends ohnk {
    @Override
    public String func_71517_b() {
        return "deletebrush";
    }

    @Override
    public String func_71518_a(nemo nemo2) {
        return "";
    }

    @Override
    public void func_71515_b(nemo nemo2, String[] stringArray) {
        if (!(nemo2 instanceof EntityPlayer)) {
            return;
        }
        EntityPlayer entityPlayer = (EntityPlayer)nemo2;
        pidb pidb2 = pidb._a(entityPlayer);
        if (stringArray.length != 1) {
            entityPlayer.func_71035_c("Usage: /deletebrush <brush_name>");
            return;
        }
        String string = stringArray[0];
        if (!pidb2._b.containsKey(string)) {
            entityPlayer.func_71035_c("\u041a\u0438\u0441\u0442\u0438 \u0441 \u0442\u0430\u043a\u0438\u043c \u043d\u0430\u0437\u0432\u0430\u043d\u0438\u0435\u043c \u043d\u0435 \u0441\u0443\u0449\u0435\u0441\u0442\u0432\u0443\u0435\u0442!");
            return;
        }
        pidb2._b.remove(string);
        entityPlayer.func_71035_c("\u041a\u0438\u0441\u0442\u044c \u0443\u0434\u0430\u043b\u0435\u043d\u0430.");
    }
}

