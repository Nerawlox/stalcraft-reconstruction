/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  nb
 */
package ru.stalcraft.server;

import ru.stalcraft.Contamination;
import ru.stalcraft.StalkerDamage;
import ru.stalcraft.player.PlayerInfo;
import ru.stalcraft.player.PlayerUtils;
import ru.stalcraft.server.network.ServerPacketSender;

public class ServerContamination
extends Contamination {
    private int[] maxTimes = new int[]{Integer.MAX_VALUE, 3, Integer.MAX_VALUE, 1200};
    private int[] radiationDamage = new int[]{1, 3, 4, 5};
    private int[] chemicalDamage = new int[]{2, 4, 5, 6};
    private int[] biologicalDamage = new int[]{2, 4, 6};
    private int[] psyDamage = new int[]{0, 3, 4, 6};
    private int[] attackTicks = new int[]{0, 0, 0, 0};
    private int[] timeToDamage = new int[]{0, 0, 0, 0};
    private float[] protectionLenght = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
    private nb[] dmgSources = new nb[]{StalkerDamage.radiation, StalkerDamage.chemical, StalkerDamage.biological, StalkerDamage.psy};
    private int[][] damageValues = new int[][]{this.radiationDamage, this.chemicalDamage, this.biologicalDamage, this.psyDamage};
    private final int commonPause;
    private int tickEffect;
    private boolean sendPacket;

    public ServerContamination(uf par1) {
        super(par1);
        this.commonPause = 100;
    }

    private int calculatePause(int effectID) {
        return (int)(100.0f * (float)PlayerUtils.getInfo(this.player).getProtection(effectID) / 100.0f + 1.0f);
    }

    private int calculateRealPsychoTicks() {
        return (int)((float)this.attackTicks[3] / ((float)PlayerUtils.getInfo(this.player).getProtection(3) / 100.0f + 1.0f));
    }

    @Override
    public void addEffect(int id, int ticksTime, int level) {
        PlayerInfo playerInfo = PlayerUtils.getInfo(this.player);
        if (!playerInfo.getImmunity(id)) {
            if ((ticksTime -= (int)((float)ticksTime * ((float)playerInfo.getProtection(id) / 100.0f))) > 0 && level > this.attackLevels[id]) {
                this.attackLevels[id] = level;
                this.sendPacket = true;
            }
            int n2 = id;
            this.attackTicks[n2] = this.attackTicks[n2] + (ticksTime + this.attackTicks[id] > this.maxTimes[id] ? this.maxTimes[id] : ticksTime) * this.attackLevels[id];
        }
    }

    @Override
    public void removeEffect(int id, int levels) {
        this.attackTicks[id] = this.attackLevels[id] > levels ? this.attackTicks[id] : 0;
    }

    public void removeEffects() {
        this.attackLevels = new int[]{0, 0, 0, 0};
        this.attackTicks = new int[]{0, 0, 0, 0};
        this.tickEffect = 0;
        ServerPacketSender.syncContamination(this.player, this.attackLevels);
    }

    @Override
    public void tick() {
        if (this.tickEffect % 10 == 0 && this.sendPacket) {
            ServerPacketSender.syncContamination(this.player, this.attackLevels);
            this.sendPacket = false;
        }
        for (int i2 = 0; i2 < this.attackLevels.length; ++i2) {
            if (this.attackLevels[i2] <= 0 || this.dmgSources[i2] == null) continue;
            if (this.attackTicks[i2] > 0) {
                if (!this.player.bG.d && this.tickEffect % 50 == 0) {
                    this.player.a(this.dmgSources[i2], (float)this.damageValues[i2][this.attackLevels[i2] - 1]);
                }
                int n2 = i2;
                this.attackTicks[n2] = this.attackTicks[n2] - 1;
                continue;
            }
            if (this.attackLevels[i2] <= 0) continue;
            this.attackTicks[i2] = 0;
            this.attackLevels[i2] = 0;
            this.tickEffect = 0;
            this.sendPacket = true;
        }
        ++this.tickEffect;
    }

    public void writeNBT(by tag) {
        tag.a("radiationLevel", this.attackLevels[0]);
        tag.a("chemicallLevel", this.attackLevels[1]);
        tag.a("biologicalLevel", this.attackLevels[2]);
        tag.a("psychoLevel", this.attackLevels[3]);
        tag.a("radiationTicks", this.attackTicks[0]);
        tag.a("chemicalTicks", this.attackTicks[1]);
        tag.a("biologicalTicks", this.attackTicks[2]);
        tag.a("psychoTicks", this.attackTicks[3]);
        tag.a("radiationPause", this.timeToDamage[0]);
        tag.a("chemicalPause", this.timeToDamage[1]);
        tag.a("biologicalPause", this.timeToDamage[2]);
        tag.a("psychoPause", this.timeToDamage[3]);
    }

    public void readNBT(by tag) {
        this.attackLevels[0] = tag.e("radiationLevel");
        this.attackLevels[1] = tag.e("chemicallLevel");
        this.attackLevels[2] = tag.e("biologicalLevel");
        this.attackLevels[3] = tag.e("psychoLevel");
        this.attackTicks[0] = tag.e("radiationTicks");
        this.attackTicks[1] = tag.e("chemicalTicks");
        this.attackTicks[2] = tag.e("biologicalTicks");
        this.attackTicks[3] = tag.e("psychoTicks");
        this.timeToDamage[0] = tag.e("radiationPause");
        this.timeToDamage[1] = tag.e("chemicalPause");
        this.timeToDamage[2] = tag.e("biologicalPause");
        this.timeToDamage[3] = tag.e("psychoPause");
    }

    @Override
    public void setAttackLevels(int[] par1) {
        this.attackLevels = par1;
    }
}

