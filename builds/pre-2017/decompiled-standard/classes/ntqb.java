/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.brushedit.eidj;
import gloomyfolken.mods.brushedit.pidb;
import java.util.Map;
import net.minecraft.entity.player.EntityPlayer;

public class ntqb
extends ohnk {
    @Override
    public String func_71517_b() {
        return "brushlist";
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
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, eidj> entry : pidb2._b.entrySet()) {
            stringBuffer.append(entry.getKey()).append(", ");
        }
        entityPlayer.func_71035_c("\u0421\u043e\u0437\u0434\u0430\u043d\u043d\u044b\u0435 \u043a\u0438\u0441\u0442\u0438:");
        entityPlayer.func_71035_c(stringBuffer.toString());
    }
}

