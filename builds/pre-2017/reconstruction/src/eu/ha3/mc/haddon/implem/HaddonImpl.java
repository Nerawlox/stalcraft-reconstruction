/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.mc.haddon.implem;

import eu.ha3.mc.haddon.Haddon;
import eu.ha3.mc.haddon.Operator;
import eu.ha3.mc.haddon.Utility;

public abstract class HaddonImpl
implements Haddon {
    private Utility utility;
    private Operator operator;

    @Override
    public Utility getUtility() {
        return this.utility;
    }

    @Override
    public void setUtility(Utility utility) {
        this.utility = utility;
    }

    @Override
    public Operator getOperator() {
        return this.operator;
    }

    @Override
    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public Utility util() {
        return this.getUtility();
    }

    public Operator op() {
        return this.getOperator();
    }
}

