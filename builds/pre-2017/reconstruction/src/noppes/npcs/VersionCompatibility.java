/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs;

import java.util.Collection;
import java.util.List;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.ICompatibilty;
import noppes.npcs.NBTTags;
import noppes.npcs.controllers.Line;
import noppes.npcs.controllers.Lines;

public class VersionCompatibility {
    public static int ModRev = 12;

    public static void CheckNpcCompatibility(EntityNPCInterface entityNPCInterface, NBTTagCompound nBTTagCompound) {
        if (entityNPCInterface.npcVersion != ModRev) {
            Object object;
            VersionCompatibility.CompatabilityFix(nBTTagCompound, entityNPCInterface.advanced.writeToNBT(new NBTTagCompound()));
            VersionCompatibility.CompatabilityFix(nBTTagCompound, entityNPCInterface.aiData.writeToNBT(new NBTTagCompound()));
            VersionCompatibility.CompatabilityFix(nBTTagCompound, entityNPCInterface.stats.writeToNBT(new NBTTagCompound()));
            VersionCompatibility.CompatabilityFix(nBTTagCompound, entityNPCInterface.display.writeToNBT(new NBTTagCompound()));
            VersionCompatibility.CompatabilityFix(nBTTagCompound, entityNPCInterface.inventory.writeEntityToNBT(new NBTTagCompound()));
            if (entityNPCInterface.npcVersion < 5) {
                object = nBTTagCompound._j("Texture");
                object = ((String)object).replace("/mob/customnpcs/", "customnpcs:textures/entity/");
                object = ((String)object).replace("/mob/", "customnpcs:textures/entity/");
                nBTTagCompound._a("Texture", (String)object);
            }
            if (entityNPCInterface.npcVersion < 6 && nBTTagCompound._b("NpcInteractLines") instanceof NBTTagList) {
                object = NBTTags.getStringList(nBTTagCompound._n("NpcInteractLines"));
                Lines lines = new Lines();
                for (int i = 0; i < object.size(); ++i) {
                    Line line = new Line();
                    line.text = (String)object.toArray()[i];
                    lines.lines.put(i, line);
                }
                nBTTagCompound._a("NpcInteractLines", lines.writeToNBT());
                List list = NBTTags.getStringList(nBTTagCompound._n("NpcLines"));
                lines = new Lines();
                for (int i = 0; i < list.size(); ++i) {
                    Line line = new Line();
                    line.text = (String)list.toArray()[i];
                    lines.lines.put(i, line);
                }
                nBTTagCompound._a("NpcLines", lines.writeToNBT());
                List list2 = NBTTags.getStringList(nBTTagCompound._n("NpcAttackLines"));
                lines = new Lines();
                for (int i = 0; i < list2.size(); ++i) {
                    Line line = new Line();
                    line.text = (String)list2.toArray()[i];
                    lines.lines.put(i, line);
                }
                nBTTagCompound._a("NpcAttackLines", lines.writeToNBT());
                List list3 = NBTTags.getStringList(nBTTagCompound._n("NpcKilledLines"));
                lines = new Lines();
                for (int i = 0; i < list3.size(); ++i) {
                    Line line = new Line();
                    line.text = (String)list3.toArray()[i];
                    lines.lines.put(i, line);
                }
                nBTTagCompound._a("NpcKilledLines", lines.writeToNBT());
            }
            entityNPCInterface.npcVersion = ModRev;
        }
    }

    public static void CheckAvailabilityCompatibility(ICompatibilty iCompatibilty, NBTTagCompound nBTTagCompound) {
        if (iCompatibilty.getVersion() != ModRev) {
            VersionCompatibility.CompatabilityFix(nBTTagCompound, iCompatibilty.writeToNBT(new NBTTagCompound()));
            iCompatibilty.setVersion(ModRev);
        }
    }

    public static void CompatabilityFix(NBTTagCompound nBTTagCompound, NBTTagCompound nBTTagCompound2) {
        Collection collection = nBTTagCompound2._d();
        for (NBTBase nBTBase : collection) {
            if (!nBTTagCompound._c(nBTBase._b())) {
                nBTTagCompound._a(nBTBase._b(), nBTBase);
                continue;
            }
            if (!(nBTBase instanceof NBTTagCompound) || !(nBTTagCompound._b(nBTBase._b()) instanceof NBTTagCompound)) continue;
            VersionCompatibility.CompatabilityFix(nBTTagCompound._m(nBTBase._b()), (NBTTagCompound)nBTBase);
        }
    }
}

