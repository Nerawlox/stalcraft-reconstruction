/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.commands;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.entity.Entity;
import noppes.npcs.EntityNPCInterface;

public class NpcListHelper {
    public static List<EntityNPCInterface> getAllNPCs() {
        yfgy yfgy2 = dzfd._I()._j[0];
        ArrayList<EntityNPCInterface> arrayList = new ArrayList<EntityNPCInterface>();
        for (ixzi ixzi2 : yfgy2.field_73059_b._g) {
            for (List list2 : ixzi2._m) {
                for (Entity entity : list2) {
                    if (!(entity instanceof EntityNPCInterface)) continue;
                    arrayList.add((EntityNPCInterface)entity);
                }
            }
        }
        return arrayList;
    }
}

