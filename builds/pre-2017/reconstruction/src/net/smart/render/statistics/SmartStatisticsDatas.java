/*
 * Decompiled with CFR 0.152.
 */
package net.smart.render.statistics;

import net.smart.render.statistics.SmartStatisticsData;

public class SmartStatisticsDatas {
    public final SmartStatisticsData horizontal = new SmartStatisticsData();
    public final SmartStatisticsData vertical = new SmartStatisticsData();
    public final SmartStatisticsData all = new SmartStatisticsData();
    private float renderPartialTicks;

    public float getTotalHorizontalDistance() {
        return this.horizontal.getTotalDistance(this.renderPartialTicks);
    }

    public float getTotalVerticalDistance() {
        return this.vertical.getTotalDistance(this.renderPartialTicks);
    }

    public float getTotalDistance() {
        return this.all.getTotalDistance(this.renderPartialTicks);
    }

    public float getCurrentHorizontalSpeed() {
        return this.horizontal.getCurrentSpeed(this.renderPartialTicks);
    }

    public float getCurrentVerticalSpeed() {
        return this.vertical.getCurrentSpeed(this.renderPartialTicks);
    }

    public float getCurrentSpeed() {
        return this.all.getCurrentSpeed(this.renderPartialTicks);
    }

    public void setReady(float f) {
        this.renderPartialTicks = f;
    }

    public boolean isReady() {
        return !Float.isNaN(this.renderPartialTicks);
    }

    public void initialize(SmartStatisticsDatas smartStatisticsDatas) {
        this.renderPartialTicks = Float.NaN;
        this.horizontal.initialize(smartStatisticsDatas.horizontal);
        this.vertical.initialize(smartStatisticsDatas.vertical);
        this.all.initialize(smartStatisticsDatas.all);
    }
}

