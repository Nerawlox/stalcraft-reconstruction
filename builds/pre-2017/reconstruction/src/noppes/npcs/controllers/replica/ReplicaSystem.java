/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers.replica;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import noppes.npcs.controllers.replica.ReplicaStorage;

public class ReplicaSystem {
    private Map<ReplicaType, ReplicaStorage> replicas = new HashMap<ReplicaType, ReplicaStorage>();

    public ReplicaSystem() {
        for (ReplicaType replicaType : ReplicaType.values()) {
            this.add(new ReplicaStorage(replicaType));
        }
    }

    public ReplicaStorage getReplicas(ReplicaType replicaType) {
        return this.replicas.get((Object)replicaType);
    }

    public Map<String, Float> getSounds(ReplicaType replicaType) {
        return this.replicas.get((Object)replicaType).getSounds();
    }

    public Map<ReplicaType, ReplicaStorage> getAllReplicas() {
        return this.replicas;
    }

    private void add(ReplicaStorage replicaStorage) {
        this.replicas.put(replicaStorage.getType(), replicaStorage);
    }

    public NBTTagCompound writeToNbt(NBTTagCompound nBTTagCompound) {
        NBTTagList nBTTagList = new NBTTagList();
        for (Map.Entry<ReplicaType, ReplicaStorage> entry : this.replicas.entrySet()) {
            NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
            nBTTagCompound2._a("Type", entry.getKey().ordinal());
            entry.getValue().writeToNbt(nBTTagCompound2);
            nBTTagList._a(nBTTagCompound2);
        }
        nBTTagCompound._a("Replicas", nBTTagList);
        return nBTTagCompound;
    }

    public void readFromNbt(NBTTagCompound nBTTagCompound) {
        NBTTagList nBTTagList = nBTTagCompound._n("Replicas");
        for (int i = 0; i < nBTTagList._d(); ++i) {
            NBTTagCompound nBTTagCompound2 = (NBTTagCompound)nBTTagList._b(i);
            ReplicaType replicaType = ReplicaType.values()[nBTTagCompound2._f("Type")];
            ReplicaStorage replicaStorage = new ReplicaStorage(replicaType);
            replicaStorage.readFromNbt(nBTTagCompound2);
            this.add(replicaStorage);
        }
    }

    public static enum ReplicaType {
        GENERAL("\u041e\u0431\u0449\u0438\u0435", 0, 10.0f),
        INTERACT("\u0412\u0437\u0430\u0438\u043c\u043e\u0434\u0435\u0439\u0441\u0442\u0432\u0438\u0435", 1, 10.0f),
        ATTACK("\u0410\u0442\u0430\u043a\u0430", 2, 30.0f),
        DEATH("\u0421\u043c\u0435\u0440\u0442\u044c", 3, 10.0f),
        INTERACT_WEAPON("\u0412\u0437\u0430\u0438\u043c\u043e\u0434\u0435\u0439\u0441\u0442\u0432\u0438\u0435 (\u043e\u0440\u0443\u0436\u0438\u0435)", 1, 10.0f);

        public final String title;
        public final int priority;
        public final float soundRange;

        private ReplicaType(String string2, int n2, float f) {
            this.title = string2;
            this.priority = n2;
            this.soundRange = f;
        }
    }
}

