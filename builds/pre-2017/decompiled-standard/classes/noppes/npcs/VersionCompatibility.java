/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs;

import java.util.Collection;
import java.util.List;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.ICompatibilty;
import noppes.npcs.NBTTags;
import noppes.npcs.controllers.Line;
import noppes.npcs.controllers.Lines;

public class VersionCompatibility {
    public static int ModRev = 12;

    public static void CheckNpcCompatibility(EntityNPCInterface entityNPCInterface, qoac qoac2) {
        if (entityNPCInterface.npcVersion != ModRev) {
            Object object;
            VersionCompatibility.CompatabilityFix(qoac2, entityNPCInterface.advanced.writeToNBT(new qoac()));
            VersionCompatibility.CompatabilityFix(qoac2, entityNPCInterface.aiData.writeToNBT(new qoac()));
            VersionCompatibility.CompatabilityFix(qoac2, entityNPCInterface.stats.writeToNBT(new qoac()));
            VersionCompatibility.CompatabilityFix(qoac2, entityNPCInterface.display.writeToNBT(new qoac()));
            VersionCompatibility.CompatabilityFix(qoac2, entityNPCInterface.inventory.writeEntityToNBT(new qoac()));
            if (entityNPCInterface.npcVersion < 5) {
                object = qoac2._j("Texture");
                object = ((String)object).replace("/mob/customnpcs/", "customnpcs:textures/entity/");
                object = ((String)object).replace("/mob/", "customnpcs:textures/entity/");
                qoac2._a("Texture", (String)object);
            }
            if (entityNPCInterface.npcVersion < 6 && qoac2._b("NpcInteractLines") instanceof bsyv) {
                object = NBTTags.getStringList(qoac2._n("NpcInteractLines"));
                Lines lines = new Lines();
                for (int i = 0; i < object.size(); ++i) {
                    Line line = new Line();
                    line.text = (String)object.toArray()[i];
                    lines.lines.put(i, line);
                }
                qoac2._a("NpcInteractLines", lines.writeToNBT());
                List list = NBTTags.getStringList(qoac2._n("NpcLines"));
                lines = new Lines();
                for (int i = 0; i < list.size(); ++i) {
                    Line line = new Line();
                    line.text = (String)list.toArray()[i];
                    lines.lines.put(i, line);
                }
                qoac2._a("NpcLines", lines.writeToNBT());
                List list2 = NBTTags.getStringList(qoac2._n("NpcAttackLines"));
                lines = new Lines();
                for (int i = 0; i < list2.size(); ++i) {
                    Line line = new Line();
                    line.text = (String)list2.toArray()[i];
                    lines.lines.put(i, line);
                }
                qoac2._a("NpcAttackLines", lines.writeToNBT());
                List list3 = NBTTags.getStringList(qoac2._n("NpcKilledLines"));
                lines = new Lines();
                for (int i = 0; i < list3.size(); ++i) {
                    Line line = new Line();
                    line.text = (String)list3.toArray()[i];
                    lines.lines.put(i, line);
                }
                qoac2._a("NpcKilledLines", lines.writeToNBT());
            }
            entityNPCInterface.npcVersion = ModRev;
        }
    }

    public static void CheckAvailabilityCompatibility(ICompatibilty iCompatibilty, qoac qoac2) {
        if (iCompatibilty.getVersion() != ModRev) {
            VersionCompatibility.CompatabilityFix(qoac2, iCompatibilty.writeToNBT(new qoac()));
            iCompatibilty.setVersion(ModRev);
        }
    }

    public static void CompatabilityFix(qoac qoac2, qoac qoac3) {
        Collection collection = qoac3._d();
        for (huhy huhy2 : collection) {
            if (!qoac2._c(huhy2._b())) {
                qoac2._a(huhy2._b(), huhy2);
                continue;
            }
            if (!(huhy2 instanceof qoac) || !(qoac2._b(huhy2._b()) instanceof qoac)) continue;
            VersionCompatibility.CompatabilityFix(qoac2._m(huhy2._b()), (qoac)huhy2);
        }
    }
}

