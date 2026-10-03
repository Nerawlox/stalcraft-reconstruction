/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs;

import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.zwat;
import gloomyfolken.mods.asm.FileWriteBlocker;
import gloomyfolken.mods.core.misc.vjsq;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import net.minecraft.client.xpzm;
import net.minecraft.entity.Entity;
import net.minecraft.entity.jgro;
import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.CustomNpcs;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.NoppesUtilServer;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.gui.GuiDupliNpc;
import org.jetbrains.annotations.NotNull;

public class NpcSynchronizer {
    public static NpcSynchronizer instance;
    private HashMap<Integer, NpcSharedData> dataMap = new HashMap();
    private HashSet<Integer> entitiesToRemove = new HashSet();
    private int nextId = 1;

    public NpcSynchronizer() {
        instance = this;
        this.load();
    }

    private void load() {
        File file = CustomNpcs.getWorldSaveDirectory();
        try {
            File file2 = new File(file, "shared_data.dat");
            if (file2.exists()) {
                this.readFromNBT(bsvf._a(new FileInputStream(file2)));
            }
        }
        catch (Exception exception) {
            try {
                File file3 = new File(file, "shared_data.dat_old");
                if (file3.exists()) {
                    this.readFromNBT(bsvf._a(new FileInputStream(file3)));
                }
            }
            catch (Exception exception2) {
                exception2.printStackTrace();
            }
        }
    }

    public void save() {
        if (FileWriteBlocker._a) {
            return;
        }
        try {
            File file = CustomNpcs.getWorldSaveDirectory();
            qoac qoac2 = new qoac();
            this.writeToNBT(qoac2);
            File file2 = new File(file, "shared_data.dat_new");
            File file3 = new File(file, "shared_data.dat_old");
            File file4 = new File(file, "shared_data.dat");
            bsvf._a(qoac2, new FileOutputStream(file2));
            if (file3.exists()) {
                file3.delete();
            }
            file4.renameTo(file3);
            if (file4.exists()) {
                file4.delete();
            }
            file2.renameTo(file4);
            if (file2.exists()) {
                file2.delete();
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void readFromNBT(qoac qoac2) {
        this.dataMap.clear();
        bsyv bsyv2 = qoac2._n("list");
        for (int i = 0; i < bsyv2._d(); ++i) {
            qoac qoac3 = (qoac)bsyv2._b(i);
            NpcSharedData npcSharedData = new NpcSharedData(qoac3);
            this.dataMap.put(qoac3._f("id"), npcSharedData);
        }
        this.entitiesToRemove.clear();
        bsyv bsyv3 = qoac2._n("remove_list");
        for (int i = 0; i < bsyv3._d(); ++i) {
            this.entitiesToRemove.add(((hdfw)bsyv3._b((int)i))._c);
        }
        this.nextId = qoac2._f("next_id");
    }

    private void writeToNBT(qoac qoac2) {
        bsyv bsyv2 = new bsyv();
        for (Map.Entry<Integer, NpcSharedData> object : this.dataMap.entrySet()) {
            qoac qoac3 = new qoac();
            qoac3._a("id", (int)object.getKey());
            object.getValue().writeToNBT(qoac3);
            bsyv2._a(qoac3);
        }
        qoac2._a("list", bsyv2);
        bsyv bsyv3 = new bsyv();
        for (Integer n : this.entitiesToRemove) {
            bsyv3._a(new hdfw("", n));
        }
        qoac2._a("remove_list", bsyv3);
        qoac2._a("next_id", this.nextId);
    }

    public boolean loadSharedData(EntityNPCInterface entityNPCInterface) {
        NpcSharedData npcSharedData = this.dataMap.get(entityNPCInterface.sharedDataId);
        if (npcSharedData == null) {
            if (this.entitiesToRemove.contains(entityNPCInterface.sharedDataId)) {
                entityNPCInterface.delete();
                return false;
            }
            entityNPCInterface.sharedDataId = 0;
            return true;
        }
        npcSharedData.applyToEntity(entityNPCInterface);
        return false;
    }

    public boolean isShared(EntityNPCInterface entityNPCInterface) {
        return this.dataMap.containsKey(entityNPCInterface.sharedDataId);
    }

    public void onEntityUpdate(EntityNPCInterface entityNPCInterface) {
        this.onEntityUpdate(entityNPCInterface, true);
    }

    public void onEntityUpdate(EntityNPCInterface entityNPCInterface, boolean bl) {
        if (this.dataMap.containsKey(entityNPCInterface.sharedDataId)) {
            NpcSharedData npcSharedData = this.dataMap.get(entityNPCInterface.sharedDataId);
            npcSharedData.loadFromEntity(entityNPCInterface);
            for (yfgy yfgy2 : dzfd._I()._j) {
                for (Entity entity : yfgy2.field_72996_f) {
                    if (!(entity instanceof EntityNPCInterface) || entity == entityNPCInterface) continue;
                    EntityNPCInterface entityNPCInterface2 = (EntityNPCInterface)entity;
                    if (entityNPCInterface2.sharedDataId != entityNPCInterface.sharedDataId) continue;
                    npcSharedData.applyToEntity(entityNPCInterface2);
                    if (!bl) continue;
                    entityNPCInterface2.sync();
                }
            }
            this.save();
        }
    }

    public void onEntityDelete(EntityNPCInterface entityNPCInterface) {
        if (this.dataMap.containsKey(entityNPCInterface.sharedDataId)) {
            --this.dataMap.get((Object)Integer.valueOf((int)entityNPCInterface.sharedDataId)).numUsingEntities;
            this.save();
        }
    }

    public void requestDuplicate(EntityPlayer entityPlayer, EntityNPCInterface entityNPCInterface) {
        if (!this.dataMap.containsKey(entityNPCInterface.sharedDataId)) {
            if (this.checkNoPerm(entityPlayer)) {
                return;
            }
            this.dataMap.put(this.nextId, new NpcSharedData(entityNPCInterface));
            entityNPCInterface.sharedDataId = this.nextId++;
            this.save();
        }
        this.setDupliEntity(entityPlayer, entityNPCInterface.sharedDataId);
        this.openEditGui(entityPlayer);
    }

    public void setDupliEntity(EntityPlayer entityPlayer, int n) {
        ncwh._c(entityPlayer)._a("duplicated_entity", n);
    }

    public void openEditGui(EntityPlayer entityPlayer) {
        int n = ncwh._c(entityPlayer)._f("duplicated_entity");
        InvokeSideOnly.frontend(() -> {});
    }

    public void renameGroup(EntityPlayer entityPlayer, int n, String string) {
        if (this.checkNoPerm(entityPlayer)) {
            return;
        }
        NpcSharedData npcSharedData = this.dataMap.get(n);
        if (npcSharedData != null) {
            npcSharedData.name = string;
        }
        this.save();
    }

    public NpcSharedData getSharedData(int n) {
        return this.dataMap.get(n);
    }

    public void createDupliEntity(EntityPlayer entityPlayer, int n, int n2, int n3) {
        int n4 = ncwh._c(entityPlayer)._f("duplicated_entity");
        NpcSharedData npcSharedData = this.dataMap.get(n4);
        if (npcSharedData == null) {
            entityPlayer.func_71035_c("NPC \u0434\u043b\u044f \u043a\u043b\u043e\u043d\u0438\u0440\u043e\u0432\u0430\u043d\u0438\u044f \u043d\u0435 \u0432\u044b\u0431\u0440\u0430\u043d");
            return;
        }
        EntityNPCInterface entityNPCInterface = (EntityNPCInterface)jgro._a(npcSharedData.entityType, entityPlayer.field_70170_p);
        entityNPCInterface.startPos = new int[]{n, n2, n3};
        entityNPCInterface.func_70012_b((double)n + 0.5, entityNPCInterface.getStartYPos(), (double)n3 + 0.5, entityPlayer.field_70177_z, entityPlayer.field_70125_A);
        npcSharedData.applyToEntity(entityNPCInterface);
        ++npcSharedData.numUsingEntities;
        entityNPCInterface.func_70606_j(entityNPCInterface.func_110138_aP());
        entityNPCInterface.sharedDataId = n4;
        entityNPCInterface.status.onCreation(entityPlayer);
        entityNPCInterface.shuffleEquipment();
        entityPlayer.field_70170_p.func_72838_d(entityNPCInterface);
        this.save();
    }

    public void removeGroup(EntityPlayer entityPlayer, int n) {
        if (this.checkNoPerm(entityPlayer)) {
            return;
        }
        this.dataMap.remove(n);
        this.save();
    }

    public void removeGroupWithNpc(EntityPlayer entityPlayer, int n) {
        if (this.checkNoPerm(entityPlayer)) {
            return;
        }
        this.dataMap.remove(n);
        this.entitiesToRemove.add(n);
        for (yfgy yfgy2 : dzfd._I()._j) {
            for (Entity entity : yfgy2.field_72996_f) {
                if (!(entity instanceof EntityNPCInterface)) continue;
                EntityNPCInterface entityNPCInterface = (EntityNPCInterface)entity;
                if (entityNPCInterface.sharedDataId != n) continue;
                entityNPCInterface.delete();
                NoppesUtilServer.deleteNpc(entityNPCInterface);
            }
        }
        this.save();
    }

    private boolean checkNoPerm(EntityPlayer entityPlayer) {
        if (!ncwh._a(entityPlayer.field_71092_bJ)) {
            entityPlayer.func_71035_c("\u0412\u044b \u043d\u0435 \u043c\u043e\u0436\u0435\u0442\u0435 \u0440\u0435\u0434\u0430\u043a\u0442\u0438\u0440\u043e\u0432\u0430\u0442\u044c \u0433\u0440\u0443\u043f\u043f\u044b");
            return true;
        }
        return false;
    }

    static /* synthetic */ HashMap access$000(NpcSynchronizer npcSynchronizer) {
        return npcSynchronizer.dataMap;
    }

    public static class NpcSharedData {
        String name;
        public int entityType;
        qoac displayTag;
        qoac statsTag;
        qoac aiTag;
        qoac advancedTag;
        qoac inventoryTag;
        bsyv dialogsList;
        int numUsingEntities;

        public NpcSharedData(EntityNPCInterface entityNPCInterface) {
            this.loadFromEntity(entityNPCInterface);
            this.numUsingEntities = 1;
            this.name = entityNPCInterface.func_70023_ak();
            this.entityType = jgro._a(entityNPCInterface);
        }

        public NpcSharedData(qoac qoac2) {
            this.readFromNBT(qoac2);
        }

        public void readFromNBT(qoac qoac2) {
            this.displayTag = qoac2._m("display");
            this.statsTag = qoac2._m("stats");
            this.aiTag = qoac2._m("ai");
            this.advancedTag = qoac2._m("advanced");
            this.inventoryTag = qoac2._m("inventory");
            this.dialogsList = qoac2._n("dialogs");
            this.numUsingEntities = qoac2._f("numUsingEntities");
            this.name = qoac2._j("name");
            this.entityType = qoac2._f("type");
        }

        public void writeToNBT(qoac qoac2) {
            qoac2._a("display", (huhy)this.displayTag);
            qoac2._a("stats", (huhy)this.statsTag);
            qoac2._a("ai", (huhy)this.aiTag);
            qoac2._a("advanced", (huhy)this.advancedTag);
            qoac2._a("inventory", (huhy)this.inventoryTag);
            qoac2._a("dialogs", this.dialogsList);
            qoac2._a("numUsingEntities", this.numUsingEntities);
            qoac2._a("name", this.name);
            qoac2._a("type", this.entityType);
        }

        public void loadFromEntity(EntityNPCInterface entityNPCInterface) {
            this.displayTag = new qoac();
            this.statsTag = new qoac();
            this.aiTag = new qoac();
            this.advancedTag = new qoac();
            this.inventoryTag = new qoac();
            entityNPCInterface.display.writeToNBT(this.displayTag);
            entityNPCInterface.stats.writeToNBT(this.statsTag);
            entityNPCInterface.aiData.writeData(this.aiTag);
            entityNPCInterface.advanced.writeToNBT(this.advancedTag);
            entityNPCInterface.inventory.writeEntityToNBT(this.inventoryTag);
            if (entityNPCInterface.roleInterface != null && !entityNPCInterface.roleInterface.syncBetweenClones()) {
                this.advancedTag._p("RoleData");
            }
            this.dialogsList = entityNPCInterface.nbtDialogs(entityNPCInterface.dialogs);
        }

        public void applyToEntity(EntityNPCInterface entityNPCInterface) {
            entityNPCInterface.display.readToNBT(this.displayTag);
            entityNPCInterface.stats.readToNBT(this.statsTag);
            entityNPCInterface.aiData.readData(this.aiTag);
            entityNPCInterface.advanced.readToNBT(this.advancedTag);
            entityNPCInterface.inventory.readEntityFromNBT(this.inventoryTag);
            entityNPCInterface.dialogs = entityNPCInterface.getDialogs(this.dialogsList);
        }
    }

    public static class DupliNpcEntry
    implements vjsq,
    Comparable<DupliNpcEntry> {
        public int id;
        public String name;
        public int numUsingEntities;

        public DupliNpcEntry(int n, String string, int n2) {
            this.id = n;
            this.name = string;
            this.numUsingEntities = n2;
        }

        @Override
        public String getString() {
            return this.name;
        }

        @Override
        public int getColor() {
            return 0xFFFFFF;
        }

        @Override
        public int compareTo(DupliNpcEntry dupliNpcEntry) {
            return this.name.compareTo(dupliNpcEntry.name);
        }
    }

    public static class PacketLastNpc
    extends zwat {
        private qoac npcData;

        public PacketLastNpc(qoac qoac2) {
            this.npcData = qoac2;
        }

        @Override
        public void write(DataOutput dataOutput) throws IOException {
            bsvf._a(this.npcData, dataOutput);
        }

        @Override
        public void read(DataInput dataInput) throws IOException {
            this.npcData = bsvf._a(dataInput);
        }

        @Override
        public void processClient(boolean bl) {
            Entity entity = jgro._a(this.npcData, (ozlu)xpzm._E()._r);
            if (entity instanceof EntityNPCInterface) {
                NoppesUtil.setLastNpc((EntityNPCInterface)entity);
            }
        }

        public PacketLastNpc() {
        }
    }

    public static class PacketDupliNpc
    extends zwat {
        public int duplicatedEntityId;

        public PacketDupliNpc(int n) {
            this.duplicatedEntityId = n;
        }

        @Override
        public void processClient(boolean bl) {
            xpzm._E()._a(new GuiDupliNpc(null, this.duplicatedEntityId, false));
        }

        public PacketDupliNpc() {
        }

        @Override
        public void read(DataInput dataInput) throws IOException {
            this.duplicatedEntityId = dataInput.readInt();
        }

        @Override
        public void write(DataOutput dataOutput) throws IOException {
            dataOutput.writeInt(this.duplicatedEntityId);
        }
    }

    public static interface DupliNpcsConsumer {
        public void update(List<DupliNpcEntry> var1);
    }

    public static class PacketDupliNpcsList
    extends zwat {
        public List<DupliNpcEntry> dupliNpcs;

        public PacketDupliNpcsList() {
            this.dupliNpcs = new ArrayList<DupliNpcEntry>();
        }

        public PacketDupliNpcsList(HashMap<Integer, NpcSharedData> hashMap) {
            this.dupliNpcs = new ArrayList<DupliNpcEntry>(hashMap.size());
            for (Map.Entry<Integer, NpcSharedData> entry : hashMap.entrySet()) {
                NpcSharedData npcSharedData = entry.getValue();
                this.dupliNpcs.add(new DupliNpcEntry(entry.getKey(), npcSharedData.name, npcSharedData.numUsingEntities));
            }
        }

        @Override
        public void write(@NotNull DataOutput dataOutput) throws IOException {
            if (dataOutput == null) {
                PacketDupliNpcsList.$$$reportNull$$$0(0);
            }
            dataOutput.writeInt(this.dupliNpcs.size());
            for (DupliNpcEntry dupliNpcEntry : this.dupliNpcs) {
                dataOutput.writeInt(dupliNpcEntry.id);
                dataOutput.writeUTF(dupliNpcEntry.name);
                dataOutput.writeInt(dupliNpcEntry.numUsingEntities);
            }
        }

        @Override
        public void read(@NotNull DataInput dataInput) throws IOException {
            if (dataInput == null) {
                PacketDupliNpcsList.$$$reportNull$$$0(1);
            }
            int n = dataInput.readInt();
            this.dupliNpcs = new ArrayList<DupliNpcEntry>(n);
            for (int i = 0; i < n; ++i) {
                this.dupliNpcs.add(new DupliNpcEntry(dataInput.readInt(), dataInput.readUTF(), dataInput.readInt()));
            }
        }

        @Override
        public void processClient(boolean bl) {
            gqjz gqjz2 = xpzm._E()._B;
            if (gqjz2 instanceof DupliNpcsConsumer) {
                ((DupliNpcsConsumer)((Object)gqjz2)).update(this.dupliNpcs);
            }
        }

        private static /* synthetic */ void $$$reportNull$$$0(int n) {
            Object[] objectArray;
            Object[] objectArray2;
            Object[] objectArray3 = new Object[3];
            switch (n) {
                default: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "output";
                    break;
                }
                case 1: {
                    objectArray2 = objectArray3;
                    objectArray3[0] = "input";
                    break;
                }
            }
            objectArray2[1] = "noppes/npcs/NpcSynchronizer$PacketDupliNpcsList";
            switch (n) {
                default: {
                    objectArray = objectArray2;
                    objectArray2[2] = "write";
                    break;
                }
                case 1: {
                    objectArray = objectArray2;
                    objectArray2[2] = "read";
                    break;
                }
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objectArray));
        }
    }
}

