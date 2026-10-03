/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.mc.convenience;

import eu.ha3.mc.convenience.Ha3KeyActions;
import net.minecraft.client.settings.KeyBinding;

class Ha3KeyBinding {
    final int tolerence = 2;
    private int time;
    private int diffKey;
    private boolean pending;
    private KeyBinding mckeybinding;
    private Ha3KeyActions keyactions;

    Ha3KeyBinding(KeyBinding keyBinding, Ha3KeyActions ha3KeyActions) {
        this.mckeybinding = keyBinding;
        this.keyactions = ha3KeyActions;
        this.time = 0;
        this.diffKey = 0;
        this.pending = false;
    }

    KeyBinding getKeyBinding() {
        return this.mckeybinding;
    }

    void handleBefore() {
        if (this.time == 0) {
            this.keyactions.doBefore();
        }
        this.pending = true;
        this.diffKey = 0;
        ++this.time;
    }

    void handle() {
        if (!this.pending) {
            return;
        }
        ++this.diffKey;
        if (this.diffKey > this.tolerence) {
            this.keyactions.doAfter(this.time);
            this.pending = false;
            this.time = 0;
        } else {
            this.keyactions.doDuring(this.time);
        }
    }
}

