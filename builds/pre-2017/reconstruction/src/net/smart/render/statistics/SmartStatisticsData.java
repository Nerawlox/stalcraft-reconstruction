/*
 * Decompiled with CFR 0.152.
 */
package net.smart.render.statistics;

import net.minecraft.entity.player.EntityPlayer;

public class SmartStatisticsData {
    public float prevLegYaw;
    public float legYaw;
    public float total;

    public float getCurrentSpeed(float f) {
        return Math.min(1.0f, this.prevLegYaw + (this.legYaw - this.prevLegYaw) * f);
    }

    public float getTotalDistance(float f) {
        return this.total - this.legYaw * (1.0f - f);
    }

    public void initialize(SmartStatisticsData smartStatisticsData) {
        this.prevLegYaw = smartStatisticsData.legYaw;
        this.legYaw = smartStatisticsData.legYaw;
        this.total = smartStatisticsData.total;
    }

    public float calcualte(float f) {
        this.legYaw += ((f *= 4.0f) - this.legYaw) * 0.4f;
        this.total += this.legYaw;
        if (this.legYaw < 1.0E-6f) {
            this.legYaw = 0.0f;
        }
        return f;
    }

    public void apply(EntityPlayer entityPlayer) {
        entityPlayer.prevLimbSwingAmount = this.prevLegYaw;
        entityPlayer.limbSwingAmount = this.legYaw;
        entityPlayer.limbSwing = this.total;
    }
}

