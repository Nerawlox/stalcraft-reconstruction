/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.quests;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.NpcMiscInventory;
import noppes.npcs.quests.QuestInterface;

public class QuestItem
extends QuestInterface {
    public NpcMiscInventory items = new NpcMiscInventory(3);

    @Override
    public void readEntityFromNBT(qoac qoac2) {
        this.items.setFromNBT(qoac2._m("Items"));
    }

    @Override
    public void writeEntityToNBT(qoac qoac2) {
        qoac2._a("Items", this.items.getToNBT());
    }

    @Override
    public boolean isCompleted(EntityPlayer entityPlayer) {
        HashMap hashMap = this.getProcessSet(entityPlayer);
        for (cvzo cvzo2 : this.items.items.values()) {
            boolean bl = false;
            for (cvzo cvzo3 : hashMap.values()) {
                if (!ncwh._a(cvzo2, cvzo3, false, true) || cvzo3._b < cvzo2._b) continue;
                bl = true;
                break;
            }
            if (bl) continue;
            return false;
        }
        return true;
    }

    public HashMap getProcessSet(EntityPlayer entityPlayer) {
        HashMap<Integer, cvzo> hashMap = new HashMap<Integer, cvzo>();
        for (int n : this.items.items.keySet()) {
            cvzo cvzo2 = this.items.items.get(n);
            if (cvzo2 == null) continue;
            cvzo cvzo3 = cvzo2._l();
            cvzo3._b = 0;
            hashMap.put(n, cvzo3);
        }
        for (cvzo cvzo3 : entityPlayer.field_71071_by._a) {
            if (cvzo3 == null) continue;
            for (cvzo cvzo4 : hashMap.values()) {
                if (!ncwh._a(cvzo4, cvzo3, false, true)) continue;
                cvzo4._b += cvzo3._b;
            }
        }
        return hashMap;
    }

    @Override
    public void handleComplete(EntityPlayer entityPlayer) {
        block0: for (cvzo cvzo2 : this.items.items.values()) {
            int n = cvzo2._b;
            for (int i = 0; i < entityPlayer.field_71071_by._a.length; ++i) {
                cvzo cvzo3 = entityPlayer.field_71071_by._a[i];
                if (cvzo3 == null || !ncwh._a(cvzo3, cvzo2, false, true)) continue;
                int n2 = cvzo3._b;
                if (n - n2 >= 0) {
                    entityPlayer.field_71071_by.func_70299_a(i, null);
                    cvzo3._a(n2);
                } else {
                    cvzo3._a(n);
                }
                if ((n -= n2) <= 0) continue block0;
            }
        }
    }

    @Override
    public Vector getQuestLogStatus(EntityPlayer entityPlayer) {
        Vector<String> vector = new Vector<String>();
        HashMap hashMap = this.getProcessSet(entityPlayer);
        Iterator iterator2 = hashMap.keySet().iterator();
        while (iterator2.hasNext()) {
            int n = (Integer)iterator2.next();
            cvzo cvzo2 = (cvzo)hashMap.get(n);
            cvzo cvzo3 = this.items.items.get(n);
            if (cvzo2 == null) continue;
            String string = cvzo2._b + "";
            if (cvzo2._b > cvzo3._b) {
                string = cvzo3._b + "";
            }
            string = string + "/" + cvzo3._b + "";
            String string2 = cvzo2._u() ? cvzo2._s() : String.format("{%s.name}", cvzo2._a().func_77657_g(cvzo2));
            vector.add(string2.trim() + ": " + string);
        }
        return vector;
    }
}

