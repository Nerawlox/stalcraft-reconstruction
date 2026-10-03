/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.matmos.engine.implem;

import eu.ha3.matmos.engine.implem.Descriptible;
import eu.ha3.matmos.engine.implem.Knowledge;

public abstract class Switchable
extends Descriptible {
    Knowledge knowledge;
    boolean needsTesting;
    boolean isValid;

    Switchable(Knowledge knowledge) {
        this.knowledge = knowledge;
        this.isValid = false;
        this.needsTesting = true;
    }

    public abstract boolean isActive();

    public void flagNeedsTesting() {
        this.needsTesting = true;
    }

    public void setKnowledge(Knowledge knowledge) {
        this.knowledge = knowledge;
        this.flagNeedsTesting();
    }

    public boolean isValid() {
        this.validateUsability();
        return this.isValid;
    }

    private void validateUsability() {
        if (!this.needsTesting) {
            return;
        }
        this.isValid = this.testIfValid();
        this.needsTesting = false;
    }

    protected abstract boolean testIfValid();
}

