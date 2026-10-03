/*
 * Decompiled with CFR 0.152.
 */
package net.smart.moving;

import net.smart.moving.Orientation;

public class ClimbGap {
    public int BlockId;
    public int Meta;
    public boolean CanStand;
    public boolean MustCrawl;
    public Orientation Direction;
    public boolean SkipGaps;

    public ClimbGap() {
        this.reset();
    }

    public void reset() {
        this.BlockId = -1;
        this.Meta = -1;
        this.CanStand = false;
        this.MustCrawl = false;
        this.Direction = null;
        this.SkipGaps = false;
    }
}

