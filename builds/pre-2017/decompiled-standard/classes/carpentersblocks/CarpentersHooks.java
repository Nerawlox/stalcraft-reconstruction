/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks;

import carpentersblocks.tileentity.TECarpentersBlock;
import carpentersblocks.util.PacketCarpenterMapChunks;
import gloomyfolken.hooklib.asm.Hook;
import gloomyfolken.hooklib.asm.ReturnCondition;
import java.util.ArrayList;
import java.util.Iterator;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.ChunkWatchEvent;

public class CarpentersHooks {
    @Hook(returnCondition=ReturnCondition.ALWAYS)
    public static void onUpdate(EntityPlayerMP entityPlayerMP) {
        Object object;
        Object object2;
        entityPlayerMP.field_71134_c._c();
        --entityPlayerMP.field_71145_cl;
        entityPlayerMP.field_71070_bA.func_75142_b();
        if (!entityPlayerMP.field_70170_p.field_72995_K && !entityPlayerMP.field_71070_bA.func_75145_c(entityPlayerMP)) {
            entityPlayerMP.func_71053_j();
            entityPlayerMP.field_71070_bA = entityPlayerMP.field_71069_bz;
        }
        if (entityPlayerMP.field_70172_ad > 0) {
            --entityPlayerMP.field_70172_ad;
        }
        while (!entityPlayerMP.field_71130_g.isEmpty()) {
            int n = Math.min(entityPlayerMP.field_71130_g.size(), 127);
            object2 = new int[n];
            object = entityPlayerMP.field_71130_g.iterator();
            int n2 = 0;
            while (object.hasNext() && n2 < n) {
                object2[n2++] = (Integer)object.next();
                object.remove();
            }
            entityPlayerMP.field_71135_a.func_72567_b(new ixod((int[])object2));
        }
        if (!entityPlayerMP.field_71129_f.isEmpty()) {
            Object object3;
            ArrayList<ixzi> arrayList = new ArrayList<ixzi>();
            object2 = entityPlayerMP.field_71129_f.iterator();
            object = new ArrayList();
            ArrayList<TECarpentersBlock> arrayList2 = new ArrayList<TECarpentersBlock>();
            while (object2.hasNext() && arrayList.size() < 5) {
                jjym jjym2 = (jjym)object2.next();
                object2.remove();
                if (jjym2 == null || !entityPlayerMP.field_70170_p.func_72899_e(jjym2._a << 4, 0, jjym2._b << 4)) continue;
                object3 = entityPlayerMP.field_70170_p.func_72964_e(jjym2._a, jjym2._b);
                arrayList.add((ixzi)object3);
                for (Object object4 : ((ixzi)object3)._l.values()) {
                    hurg hurg2 = (hurg)object4;
                    if (hurg2.func_70320_p()) continue;
                    if (hurg2 instanceof TECarpentersBlock) {
                        arrayList2.add((TECarpentersBlock)hurg2);
                        continue;
                    }
                    ((ArrayList)object).add(hurg2);
                }
            }
            if (!arrayList.isEmpty()) {
                boolean bl = entityPlayerMP.field_71135_a.field_72575_b instanceof tgls;
                object3 = new PacketCarpenterMapChunks(arrayList, arrayList2, bl);
                entityPlayerMP.field_71135_a.func_72567_b((cezg)object3);
                Iterator<Object> iterator2 = ((ArrayList)object).iterator();
                while (iterator2.hasNext()) {
                    hurg hurg3 = (hurg)iterator2.next();
                    entityPlayerMP.func_71119_a(hurg3);
                }
                for (ixzi ixzi2 : arrayList) {
                    entityPlayerMP.func_71121_q().func_73039_n()._a(entityPlayerMP, ixzi2);
                    MinecraftForge.EVENT_BUS.post(new ChunkWatchEvent.Watch(ixzi2._k(), entityPlayerMP));
                }
            }
        }
        if (entityPlayerMP.field_143005_bX > 0L && entityPlayerMP.field_71133_b.__ar() > 0 && dzfd.__aq() - entityPlayerMP.field_143005_bX > (long)(entityPlayerMP.field_71133_b.__ar() * 1000 * 60)) {
            entityPlayerMP.field_71135_a.func_72565_c("You have been idle for too long!");
        }
    }
}

