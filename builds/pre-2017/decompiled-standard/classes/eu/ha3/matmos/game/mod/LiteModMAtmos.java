/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.matmos.game.mod;

import eu.ha3.matmos.game.system.MAtMod;
import eu.ha3.mc.haddon.SupportsFrameEvents;
import eu.ha3.mc.haddon.SupportsTickEvents;
import eu.ha3.mc.haddon.litemod.LiteBase;

public class LiteModMAtmos
extends LiteBase {
    public static LiteModMAtmos instance;

    public LiteModMAtmos() {
        super(new MAtMod());
        instance = this;
    }

    public void onLoad() {
        this.haddon.onLoad();
    }

    public void onTick(float f, boolean bl, boolean bl2) {
        if (!this.shouldTick) {
            return;
        }
        if (!bl) {
            return;
        }
        if (this.enableTick && bl2) {
            if (this.suTick) {
                ((SupportsTickEvents)((Object)this.haddon)).onTick();
            }
            ++this.tickCounter;
        }
        if (this.enableFrame && this.suFrame) {
            ((SupportsFrameEvents)((Object)this.haddon)).onFrame(f);
        }
    }
}

