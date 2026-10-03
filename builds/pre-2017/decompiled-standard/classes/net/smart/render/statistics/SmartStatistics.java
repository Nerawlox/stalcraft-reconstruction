/*
 * Decompiled with CFR 0.152.
 */
package net.smart.render.statistics;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.sajh;
import net.smart.render.statistics.SmartStatisticsContext;
import net.smart.render.statistics.SmartStatisticsDatas;

public class SmartStatistics
extends SmartStatisticsContext {
    private final EntityPlayer sp;
    private float tickDistance;
    public int ticksRiding;
    public float prevHorizontalAngle = Float.NaN;
    private static final SmartStatisticsDatas dummy = new SmartStatisticsDatas();
    private final SmartStatisticsDatas[] datas = new SmartStatisticsDatas[10];
    private int currentDataIndex = -1;

    public SmartStatistics(EntityPlayer entityPlayer) {
        this.sp = entityPlayer;
    }

    public void calculateAllStats() {
        SmartStatisticsDatas smartStatisticsDatas;
        double d = this.sp.field_70165_t - this.sp.field_70169_q;
        double d2 = this.sp.field_70163_u - this.sp.field_70167_r;
        double d3 = this.sp.field_70161_v - this.sp.field_70166_s;
        SmartStatisticsDatas smartStatisticsDatas2 = this.get();
        ++this.currentDataIndex;
        if (this.currentDataIndex >= this.datas.length) {
            this.currentDataIndex = 0;
        }
        if ((smartStatisticsDatas = this.datas[this.currentDataIndex]) == null) {
            smartStatisticsDatas = this.datas[this.currentDataIndex] = new SmartStatisticsDatas();
        }
        smartStatisticsDatas.initialize(smartStatisticsDatas2);
        smartStatisticsDatas.horizontal.calcualte(sajh._a(d * d + d3 * d3));
        smartStatisticsDatas.vertical.calcualte((float)Math.abs(d2));
        this.tickDistance = smartStatisticsDatas.all.calcualte(sajh._a(d * d + d2 * d2 + d3 * d3));
        if (SmartStatisticsContext.calculateHorizontalStats) {
            smartStatisticsDatas.horizontal.apply(this.sp);
        }
    }

    public void calculateRiddenStats() {
        ++this.ticksRiding;
    }

    public float getHorizontalPrevLegYaw() {
        return this.sp.field_70722_aY;
    }

    public float getHorizontalLegYaw() {
        return this.sp.field_70721_aZ;
    }

    public float getHorizontalTotal() {
        return this.sp.field_70754_ba;
    }

    public float getVerticalPrevLegYaw() {
        return this.datas[this.currentDataIndex].vertical.prevLegYaw;
    }

    public float getVerticalLegYaw() {
        return this.datas[this.currentDataIndex].vertical.legYaw;
    }

    public float getVerticalTotal() {
        return this.datas[this.currentDataIndex].vertical.total;
    }

    public float getAllPrevLegYaw() {
        return this.datas[this.currentDataIndex].all.prevLegYaw;
    }

    public float getAllLegYaw() {
        return this.datas[this.currentDataIndex].all.legYaw;
    }

    public float getAllTotal() {
        return this.datas[this.currentDataIndex].all.total;
    }

    public float getTickDistance() {
        return this.tickDistance;
    }

    public float getTotalHorizontalDistance(float f) {
        return this.get(f).getTotalHorizontalDistance();
    }

    public float getTotalVerticalDistance(float f) {
        return this.get(f).getTotalVerticalDistance();
    }

    public float getTotalDistance(float f) {
        return this.get(f).getTotalDistance();
    }

    public float getCurrentHorizontalSpeed(float f) {
        return this.get(f).getCurrentHorizontalSpeed();
    }

    public float getCurrentVerticalSpeed(float f) {
        return this.get(f).getCurrentVerticalSpeed();
    }

    public float getCurrentSpeed(float f) {
        return this.get(f).getCurrentSpeed();
    }

    private SmartStatisticsDatas get() {
        return this.currentDataIndex == -1 ? dummy : this.datas[this.currentDataIndex];
    }

    private SmartStatisticsDatas get(float f) {
        SmartStatisticsDatas smartStatisticsDatas = this.get();
        smartStatisticsDatas.setReady(f);
        return smartStatisticsDatas;
    }

    public float getCurrentHorizontalSpeedFlattened(float f, int n) {
        if ((n = Math.min(n, this.datas.length)) < 0) {
            n = this.datas.length;
        }
        this.get(f);
        float f2 = 0.0f;
        int n2 = 0;
        int n3 = 0;
        int n4 = this.currentDataIndex;
        while (n3 < n) {
            SmartStatisticsDatas smartStatisticsDatas;
            if (n4 < 0) {
                n4 = this.datas.length - 1;
            }
            if ((smartStatisticsDatas = this.datas[n4]) == null || !smartStatisticsDatas.isReady()) break;
            f2 += smartStatisticsDatas.getCurrentHorizontalSpeed();
            ++n2;
            ++n3;
            --n4;
        }
        return f2 / (float)n2;
    }

    public float getCurrentVerticalSpeedFlattened(float f, int n) {
        if ((n = Math.min(n, this.datas.length)) < 0) {
            n = this.datas.length;
        }
        this.get(f);
        float f2 = 0.0f;
        int n2 = 0;
        int n3 = 0;
        int n4 = this.currentDataIndex;
        while (n3 < n) {
            SmartStatisticsDatas smartStatisticsDatas;
            if (n4 < 0) {
                n4 = this.datas.length - 1;
            }
            if ((smartStatisticsDatas = this.datas[n4]) == null || !smartStatisticsDatas.isReady()) break;
            f2 += smartStatisticsDatas.getCurrentVerticalSpeed();
            ++n2;
            ++n3;
            --n4;
        }
        return f2 / (float)n2;
    }

    public float getCurrentSpeedFlattened(float f, int n) {
        if ((n = Math.min(n, this.datas.length)) < 0) {
            n = this.datas.length;
        }
        this.get(f);
        float f2 = 0.0f;
        int n2 = 0;
        int n3 = 0;
        int n4 = this.currentDataIndex;
        while (n3 < n) {
            SmartStatisticsDatas smartStatisticsDatas;
            if (n4 < 0) {
                n4 = this.datas.length - 1;
            }
            if ((smartStatisticsDatas = this.datas[n4]) == null || !smartStatisticsDatas.isReady()) break;
            f2 += smartStatisticsDatas.getCurrentSpeed();
            ++n2;
            ++n3;
            --n4;
        }
        return f2 / (float)n2;
    }
}

