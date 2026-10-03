/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.mc.convenience;

import eu.ha3.mc.convenience.Ha3HoldActions;
import eu.ha3.mc.convenience.Ha3KeyActions;

public class Ha3KeyHolding
implements Ha3KeyActions {
    private final Ha3HoldActions holdActions;
    private final int tippingPoint;
    private boolean isHolding;

    public Ha3KeyHolding(Ha3HoldActions ha3HoldActions, int n) {
        this.holdActions = ha3HoldActions;
        this.tippingPoint = n;
    }

    @Override
    public void doBefore() {
        this.holdActions.beginPress();
    }

    @Override
    public void doDuring(int n) {
        if (n >= this.tippingPoint && !this.isHolding) {
            this.isHolding = true;
            this.holdActions.beginHold();
        }
    }

    @Override
    public void doAfter(int n) {
        if (n < this.tippingPoint) {
            this.holdActions.shortPress();
        } else if (this.isHolding) {
            this.isHolding = false;
            this.holdActions.endHold();
        }
        this.holdActions.endPress();
    }
}

