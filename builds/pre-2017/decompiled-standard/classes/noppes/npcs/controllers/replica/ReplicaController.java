/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers.replica;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.NoppesUtilServer;
import noppes.npcs.constants.EnumPacketType;
import noppes.npcs.controllers.SoundPresetsController;
import noppes.npcs.controllers.replica.ReplicaStorage;
import noppes.npcs.controllers.replica.ReplicaSystem;

public class ReplicaController {
    private EntityNPCInterface npc;
    public boolean includeFactionReplicas = true;
    public ReplicaSystem npcReplicas = new ReplicaSystem();
    private long cooldownFinish = -1L;
    private ReplicaSystem.ReplicaType lastType = null;
    public int presetId = 0;

    public ReplicaController(EntityNPCInterface entityNPCInterface) {
        this.npc = entityNPCInterface;
    }

    public void writeToNbt(qoac qoac2) {
        this.npcReplicas.writeToNbt(qoac2);
        qoac2._a("FactionReplicas", this.includeFactionReplicas);
        qoac2._a("PresetId", this.presetId);
    }

    public void readFromNbt(qoac qoac2) {
        this.npcReplicas.readFromNbt(qoac2);
        this.includeFactionReplicas = qoac2._o("FactionReplicas");
        this.presetId = qoac2._f("PresetId");
    }

    public ReplicaSystem getNpcReplicas() {
        if (this.presetId > 0) {
            SoundPresetsController.SoundPreset soundPreset = SoundPresetsController.instance.getReplicas().get(this.presetId);
            return soundPreset != null ? soundPreset.replicas : this.npcReplicas;
        }
        return this.npcReplicas;
    }

    public boolean hasAntiWeaponSounds() {
        ReplicaSystem.ReplicaType replicaType = ReplicaSystem.ReplicaType.INTERACT_WEAPON;
        return !this.getNpcReplicas().getSounds(replicaType).isEmpty() || this.includeFactionReplicas && !this.npc.getFaction().getFactionReplicas().getSounds(replicaType).isEmpty();
    }

    public void perform(ReplicaSystem.ReplicaType replicaType) {
        long l = System.currentTimeMillis();
        if (replicaType == ReplicaSystem.ReplicaType.INTERACT_WEAPON && !this.hasAntiWeaponSounds()) {
            replicaType = ReplicaSystem.ReplicaType.INTERACT;
        }
        if (this.lastType != null && this.cooldownFinish > 0L && l < this.cooldownFinish && replicaType.priority <= this.lastType.priority) {
            return;
        }
        ReplicaStorage replicaStorage = this.getNpcReplicas().getReplicas(replicaType);
        HashMap<String, Float> hashMap = new HashMap<String, Float>(replicaStorage.getSounds());
        long l2 = replicaStorage.getSilenceTime();
        float f = replicaStorage.getSilenceWeight();
        long l3 = replicaStorage.getReplicaDelay();
        long l4 = replicaStorage.getRandomDelay();
        if (this.includeFactionReplicas) {
            ReplicaStorage replicaStorage2 = this.npc.getFaction().getFactionReplicas().getReplicas(replicaType);
            for (Map.Entry<String, Float> entry : replicaStorage2.getSounds().entrySet()) {
                hashMap.put(entry.getKey(), Float.valueOf(hashMap.getOrDefault(entry.getKey(), Float.valueOf(0.0f)).floatValue() + entry.getValue().floatValue()));
            }
            f += replicaStorage2.getSilenceWeight();
            l2 += replicaStorage2.getSilenceTime();
            l3 = replicaStorage2.getReplicaDelay();
            l4 = replicaStorage2.getRandomDelay();
        }
        long l5 = this.chooseAndPerform(hashMap, l2, f, l3, l4, replicaType.soundRange);
        this.lastType = replicaType;
        this.cooldownFinish = l + l5;
    }

    private long chooseAndPerform(Map<String, Float> map, long l, float f, long l2, long l3, float f2) {
        long l4 = 0L;
        if (!map.isEmpty()) {
            float f3 = 0.0f;
            Iterator<Object> iterator2 = map.values().iterator();
            while (iterator2.hasNext()) {
                float f4 = iterator2.next().floatValue();
                f3 += f4;
            }
            f3 += f;
            f3 *= this.npc.field_70146_Z.nextFloat();
            if ((f3 -= f) <= 0.0f) {
                l4 = l;
            } else {
                for (Map.Entry entry : map.entrySet()) {
                    if (!((f3 -= ((Float)entry.getValue()).floatValue()) <= 0.0f)) continue;
                    this.playAround((String)entry.getKey(), this.npc, f2);
                    l4 = (long)((float)l2 + this.npc.field_70146_Z.nextFloat() * (float)l3);
                    break;
                }
            }
        }
        return l4 * 1000L;
    }

    private void playAround(String string, EntityNPCInterface entityNPCInterface, float f) {
        List list2 = entityNPCInterface.field_70170_p.func_72872_a(EntityPlayer.class, entityNPCInterface.field_70121_D._b(f, f, f));
        for (EntityPlayer entityPlayer : list2) {
            String string2 = string.replace("/", ".");
            if (string2.endsWith("ogg") || string2.endsWith("wav")) {
                string2 = string2.substring(0, string2.lastIndexOf("."));
            }
            string2 = "customnpcs:" + string2;
            NoppesUtilServer.sendData(entityPlayer, EnumPacketType.PlaySound, string2, Float.valueOf((float)entityNPCInterface.field_70165_t), Float.valueOf((float)entityNPCInterface.field_70163_u + entityNPCInterface.func_70047_e()), Float.valueOf((float)entityNPCInterface.field_70161_v));
        }
    }
}

