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
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.Entity;
import net.minecraft.entity.jgro;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
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
            NBTTagCompound nBTTagCompound = new NBTTagCompound();
            this.writeToNBT(nBTTagCompound);
            File file2 = new File(file, "shared_data.dat_new");
            File file3 = new File(file, "shared_data.dat_old");
            File file4 = new File(file, "shared_data.dat");
            bsvf._a(nBTTagCompound, new FileOutputStream(file2));
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

    private void readFromNBT(NBTTagCompound nBTTagCompound) {
        this.dataMap.clear();
        NBTTagList nBTTagList = nBTTagCompound._n("list");
        for (int i = 0; i < nBTTagList._d(); ++i) {
            NBTTagCompound nBTTagCompound2 = (NBTTagCompound)nBTTagList._b(i);
            NpcSharedData npcSharedData = new NpcSharedData(nBTTagCompound2);
            this.dataMap.put(nBTTagCompound2._f("id"), npcSharedData);
        }
        this.entitiesToRemove.clear();
        NBTTagList nBTTagList2 = nBTTagCompound._n("remove_list");
        for (int i = 0; i < nBTTagList2._d(); ++i) {
            this.entitiesToRemove.add(((hdfw)nBTTagList2._b((int)i))._c);
        }
        this.nextId = nBTTagCompound._f("next_id");
    }

    private void writeToNBT(NBTTagCompound nBTTagCompound) {
        NBTTagList nBTTagList = new NBTTagList();
        for (Map.Entry<Integer, NpcSharedData> object : this.dataMap.entrySet()) {
            NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
            nBTTagCompound2._a("id", (int)object.getKey());
            object.getValue().writeToNBT(nBTTagCompound2);
            nBTTagList._a(nBTTagCompound2);
        }
        nBTTagCompound._a("list", nBTTagList);
        NBTTagList nBTTagList2 = new NBTTagList();
        for (Integer n : this.entitiesToRemove) {
            nBTTagList2._a(new hdfw("", n));
        }
        nBTTagCompound._a("remove_list", nBTTagList2);
        nBTTagCompound._a("next_id", this.nextId);
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
            for (WorldServer worldServer : MinecraftServer._I()._j) {
                for (Entity entity : worldServer.loadedEntityList) {
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
            entityPlayer.addChatMessage("NPC \u0434\u043b\u044f \u043a\u043b\u043e\u043d\u0438\u0440\u043e\u0432\u0430\u043d\u0438\u044f \u043d\u0435 \u0432\u044b\u0431\u0440\u0430\u043d");
            return;
        }
        EntityNPCInterface entityNPCInterface = (EntityNPCInterface)jgro._a(npcSharedData.entityType, entityPlayer.worldObj);
        entityNPCInterface.startPos = new int[]{n, n2, n3};
        entityNPCInterface.setLocationAndAngles((double)n + 0.5, entityNPCInterface.getStartYPos(), (double)n3 + 0.5, entityPlayer.rotationYaw, entityPlayer.rotationPitch);
        npcSharedData.applyToEntity(entityNPCInterface);
        ++npcSharedData.numUsingEntities;
        entityNPCInterface.setHealth(entityNPCInterface.getMaxHealth());
        entityNPCInterface.sharedDataId = n4;
        entityNPCInterface.status.onCreation(entityPlayer);
        entityNPCInterface.shuffleEquipment();
        entityPlayer.worldObj.spawnEntityInWorld(entityNPCInterface);
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
        for (WorldServer worldServer : MinecraftServer._I()._j) {
            for (Entity entity : worldServer.loadedEntityList) {
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
        if (!ncwh._a(entityPlayer.username)) {
            entityPlayer.addChatMessage("\u0412\u044b \u043d\u0435 \u043c\u043e\u0436\u0435\u0442\u0435 \u0440\u0435\u0434\u0430\u043a\u0442\u0438\u0440\u043e\u0432\u0430\u0442\u044c \u0433\u0440\u0443\u043f\u043f\u044b");
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
        NBTTagCompound displayTag;
        NBTTagCompound statsTag;
        NBTTagCompound aiTag;
        NBTTagCompound advancedTag;
        NBTTagCompound inventoryTag;
        NBTTagList dialogsList;
        int numUsingEntities;

        public NpcSharedData(EntityNPCInterface entityNPCInterface) {
            this.loadFromEntity(entityNPCInterface);
            this.numUsingEntities = 1;
            this.name = entityNPCInterface.getEntityName();
            this.entityType = jgro._a(entityNPCInterface);
        }

        public NpcSharedData(NBTTagCompound nBTTagCompound) {
            this.readFromNBT(nBTTagCompound);
        }

        public void readFromNBT(NBTTagCompound nBTTagCompound) {
            this.displayTag = nBTTagCompound._m("display");
            this.statsTag = nBTTagCompound._m("stats");
            this.aiTag = nBTTagCompound._m("ai");
            this.advancedTag = nBTTagCompound._m("advanced");
            this.inventoryTag = nBTTagCompound._m("inventory");
            this.dialogsList = nBTTagCompound._n("dialogs");
            this.numUsingEntities = nBTTagCompound._f("numUsingEntities");
            this.name = nBTTagCompound._j("name");
            this.entityType = nBTTagCompound._f("type");
        }

        public void writeToNBT(NBTTagCompound nBTTagCompound) {
            nBTTagCompound._a("display", (NBTBase)this.displayTag);
            nBTTagCompound._a("stats", (NBTBase)this.statsTag);
            nBTTagCompound._a("ai", (NBTBase)this.aiTag);
            nBTTagCompound._a("advanced", (NBTBase)this.advancedTag);
            nBTTagCompound._a("inventory", (NBTBase)this.inventoryTag);
            nBTTagCompound._a("dialogs", this.dialogsList);
            nBTTagCompound._a("numUsingEntities", this.numUsingEntities);
            nBTTagCompound._a("name", this.name);
            nBTTagCompound._a("type", this.entityType);
        }

        public void loadFromEntity(EntityNPCInterface entityNPCInterface) {
            this.displayTag = new NBTTagCompound();
            this.statsTag = new NBTTagCompound();
            this.aiTag = new NBTTagCompound();
            this.advancedTag = new NBTTagCompound();
            this.inventoryTag = new NBTTagCompound();
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
        private NBTTagCompound npcData;

        public PacketLastNpc(NBTTagCompound nBTTagCompound) {
            this.npcData = nBTTagCompound;
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
            Entity entity = jgro._a(this.npcData, (World)Minecraft._E()._r);
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
            Minecraft._E()._a(new GuiDupliNpc(null, this.duplicatedEntityId, false));
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
            GuiScreen guiScreen = Minecraft._E()._B;
            if (guiScreen instanceof DupliNpcsConsumer) {
                ((DupliNpcsConsumer)((Object)guiScreen)).update(this.dupliNpcs);
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

