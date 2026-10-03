/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.matmos.game.data;

import eu.ha3.matmos.engine.implem.IntegerData;
import eu.ha3.matmos.game.data.MAtScanCoordsOps;
import eu.ha3.matmos.game.system.MAtMod;

public abstract class MAtScanCoordsPipeline
implements MAtScanCoordsOps {
    private MAtMod mod;
    private IntegerData data;
    private MAtScanCoordsPipeline next;

    MAtScanCoordsPipeline(MAtMod mAtMod, IntegerData integerData) {
        this.mod = mAtMod;
        this.data = integerData;
        this.next = null;
    }

    public MAtMod mod() {
        return this.mod;
    }

    public IntegerData data() {
        return this.data;
    }

    abstract void doBegin();

    abstract void doInput(long var1, long var3, long var5);

    abstract void doFinish();

    public void append(MAtScanCoordsPipeline mAtScanCoordsPipeline) {
        if (this.next == null) {
            this.next = mAtScanCoordsPipeline;
        } else {
            this.next.append(mAtScanCoordsPipeline);
        }
    }

    @Override
    public void begin() {
        this.doBegin();
        if (this.next != null) {
            this.next.begin();
        }
    }

    @Override
    public void finish() {
        this.doFinish();
        if (this.next != null) {
            this.next.finish();
        }
    }

    @Override
    public void input(long l, long l2, long l3) {
        this.doInput(l, l2, l3);
        if (this.next != null) {
            this.next.input(l, l2, l3);
        }
    }
}

