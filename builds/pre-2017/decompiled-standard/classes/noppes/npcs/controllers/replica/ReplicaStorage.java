/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers.replica;

import java.util.HashMap;
import java.util.Map;
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

    public void writeToNbt(qoac qoac2) {
        bsyv bsyv2 = new bsyv();
        for (Map.Entry<String, Float> entry : this.sounds.entrySet()) {
            bsyv2._a(new dwly()._a("Sound", entry.getKey())._a("Weight", entry.getValue().floatValue())._a());
        }
        qoac2._a("Sounds", bsyv2);
        qoac2._a("SilenceTime", this.silenceTime);
        qoac2._a("SilenceWeight", this.silenceWeight);
        qoac2._a("ReplicaDelay", this.replicaDelay);
        qoac2._a("RandomDelay", this.randomDelay);
    }

    public void readFromNbt(qoac qoac2) {
        this.sounds.clear();
        bsyv bsyv2 = qoac2._n("Sounds");
        for (int i = 0; i < bsyv2._d(); ++i) {
            qoac qoac3 = (qoac)bsyv2._b(i);
            String string = qoac3._j("Sound");
            float f = qoac3._h("Weight");
            this.sounds.put(string, Float.valueOf(f));
        }
        this.silenceTime = qoac2._g("SilenceTime");
        this.silenceWeight = qoac2._h("SilenceWeight");
        this.replicaDelay = qoac2._g("ReplicaDelay");
        this.randomDelay = qoac2._g("RandomDelay");
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

