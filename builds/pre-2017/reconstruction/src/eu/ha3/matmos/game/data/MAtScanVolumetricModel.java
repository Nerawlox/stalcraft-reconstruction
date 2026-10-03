/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.matmos.game.data;

import eu.ha3.matmos.game.data.MAtScanCoordsOps;
import eu.ha3.matmos.game.system.MAtMod;
import eu.ha3.mc.convenience.Ha3Signal;

public class MAtScanVolumetricModel {
    private MAtMod mod;
    private MAtScanCoordsOps pipeline;
    private long xstart;
    private long ystart;
    private long zstart;
    private long xsize;
    private long ysize;
    private long zsize;
    private long opspercall;
    private boolean isScanning;
    private long finality;
    private long progress;
    private Ha3Signal onDone;

    public MAtScanVolumetricModel(MAtMod mAtMod) {
        this.mod = mAtMod;
        this.pipeline = null;
        this.isScanning = false;
    }

    public void setPipeline(MAtScanCoordsOps mAtScanCoordsOps) {
        this.pipeline = mAtScanCoordsOps;
    }

    public void startScan(long l, long l2, long l3, long l4, long l5, long l6, long l7, Ha3Signal ha3Signal) {
        if (this.isScanning) {
            return;
        }
        if (this.pipeline == null) {
            return;
        }
        if (l7 <= 0L) {
            throw new IllegalArgumentException();
        }
        int n = this.mod.util().getWorldHeight();
        if (l5 > (long)n) {
            l5 = n;
        }
        this.xsize = l4;
        this.ysize = l5;
        this.zsize = l6;
        if ((l2 -= this.ysize / 2L) < 0L) {
            l2 = 0L;
        } else if (l2 > (long)n - this.ysize) {
            l2 = (long)n - this.ysize;
        }
        this.xstart = l - this.xsize / 2L;
        this.ystart = l2;
        this.zstart = l3 - this.zsize / 2L;
        this.opspercall = l7;
        this.progress = 0L;
        this.finality = this.xsize * this.ysize * this.zsize;
        this.pipeline.begin();
        this.isScanning = true;
    }

    public boolean routine() {
        if (!this.isScanning) {
            return false;
        }
        long l = 0L;
        while (l < this.opspercall && this.progress < this.finality) {
            long l2 = this.xstart + this.progress % this.xsize;
            long l3 = this.zstart + this.progress / this.xsize % this.zsize;
            long l4 = this.ystart + this.progress / this.xsize / this.zsize;
            this.pipeline.input(l2, l4, l3);
            ++l;
            ++this.progress;
        }
        if (this.progress >= this.finality) {
            this.scanDoneEvent();
        }
        return true;
    }

    public void stopScan() {
        this.isScanning = false;
    }

    private void scanDoneEvent() {
        if (!this.isScanning) {
            return;
        }
        this.pipeline.finish();
        this.stopScan();
        if (this.onDone != null) {
            this.onDone.signal();
        }
    }
}

