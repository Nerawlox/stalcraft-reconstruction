/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.mc.haddon.litemod;

import eu.ha3.mc.haddon.Haddon;
import eu.ha3.mc.haddon.OperatorCaster;
import eu.ha3.mc.haddon.SupportsFrameEvents;
import eu.ha3.mc.haddon.SupportsTickEvents;
import eu.ha3.mc.haddon.Utility;
import eu.ha3.mc.haddon.implem.HaddonUtilityImpl;

public class LiteBase
implements OperatorCaster {
    private Utility utility;
    protected final Haddon haddon;
    protected final boolean shouldTick;
    protected final boolean suTick;
    protected final boolean suFrame;
    protected int tickCounter;
    protected boolean enableTick;
    protected boolean enableFrame;
    private long ticksRan;

    public LiteBase(Haddon haddon) {
        this.haddon = haddon;
        this.suTick = haddon instanceof SupportsTickEvents;
        this.suFrame = haddon instanceof SupportsFrameEvents;
        this.shouldTick = this.suTick || this.suFrame;
        this.haddon.setUtility(new HaddonUtilityImpl(){

            @Override
            public long getClientTick() {
                return LiteBase.this.getTicks();
            }
        });
        this.haddon.setOperator(this);
    }

    public Utility getUtility() {
        return this.utility;
    }

    public long bridgeTicksRan() {
        return this.ticksRan;
    }

    @Override
    public void setTickEnabled(boolean bl) {
        this.enableTick = bl;
    }

    @Override
    public void setFrameEnabled(boolean bl) {
        this.enableFrame = bl;
    }

    @Override
    public int getTicks() {
        return this.tickCounter;
    }
}

