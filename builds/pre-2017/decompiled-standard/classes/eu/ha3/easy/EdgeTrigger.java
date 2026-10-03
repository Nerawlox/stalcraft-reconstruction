/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.easy;

import eu.ha3.easy.EdgeModel;

public class EdgeTrigger {
    private boolean currentState;
    private EdgeModel triggerModel;

    public EdgeTrigger(EdgeModel edgeModel) {
        this(edgeModel, false);
    }

    public EdgeTrigger(EdgeModel edgeModel, boolean bl) {
        this.triggerModel = edgeModel;
        this.currentState = bl;
    }

    public boolean getCurrentState() {
        return this.currentState;
    }

    public boolean signalState(boolean bl) {
        if (bl != this.currentState) {
            this.currentState = bl;
            if (bl) {
                this.triggerModel.onTrueEdge();
            } else {
                this.triggerModel.onFalseEdge();
            }
            return true;
        }
        return false;
    }
}

