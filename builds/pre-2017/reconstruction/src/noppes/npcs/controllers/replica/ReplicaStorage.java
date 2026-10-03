/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers.replica;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import noppes.npcs.controllers.replica.ReplicaSystem;

public class ReplicaStorage {
    private Map<String, Float> sounds = new HashMap<String, Float>();
    private long silenceTime = 0L;
    private float silenceWeight = 0.0f;
    private long replicaDelay = 60L;
    private long randomDelay = 15L;
    private ReplicaSystem.ReplicaType type;

    public ReplicaStorage(ReplicaSystem.ReplicaType replicaType) {
        this.type = replicaType;
    }

    public void writeToNbt(NBTTagCompound nBTTagCompound) {
        NBTTagList nBTTagList = new NBTTagList();
        for (Map.Entry<String, Float> entry : this.sounds.entrySet()) {
            nBTTagList._a(new dwly()._a("Sound", entry.getKey())._a("Weight", entry.getValue().floatValue())._a());
        }
        nBTTagCompound._a("Sounds", nBTTagList);
        nBTTagCompound._a("SilenceTime", this.silenceTime);
        nBTTagCompound._a("SilenceWeight", this.silenceWeight);
        nBTTagCompound._a("ReplicaDelay", this.replicaDelay);
        nBTTagCompound._a("RandomDelay", this.randomDelay);
    }

    public void readFromNbt(NBTTagCompound nBTTagCompound) {
        this.sounds.clear();
        NBTTagList nBTTagList = nBTTagCompound._n("Sounds");
        for (int i = 0; i < nBTTagList._d(); ++i) {
            NBTTagCompound nBTTagCompound2 = (NBTTagCompound)nBTTagList._b(i);
            String string = nBTTagCompound2._j("Sound");
            float f = nBTTagCompound2._h("Weight");
            this.sounds.put(string, Float.valueOf(f));
        }
        this.silenceTime = nBTTagCompound._g("SilenceTime");
        this.silenceWeight = nBTTagCompound._h("SilenceWeight");
        this.replicaDelay = nBTTagCompound._g("ReplicaDelay");
        this.randomDelay = nBTTagCompound._g("RandomDelay");
    }

    public Map<String, Float> getSounds() {
        return this.sounds;
    }

    public ReplicaStorage setSounds(Map<String, Float> map) {
        this.sounds = map;
        return this;
    }

    public long getSilenceTime() {
        return this.silenceTime;
    }

    public void setSilenceTime(long l) {
        this.silenceTime = l;
    }

    public float getSilenceWeight() {
        return this.silenceWeight;
    }

    public void setSilenceWeight(float f) {
        this.silenceWeight = f;
    }

    public long getReplicaDelay() {
        return this.replicaDelay;
    }

    public void setReplicaDelay(long l) {
        this.replicaDelay = l;
    }

    public long getRandomDelay() {
        return this.randomDelay;
    }

    public void setRandomDelay(long l) {
        this.randomDelay = l;
    }

    public ReplicaSystem.ReplicaType getType() {
        return this.type;
    }
}

