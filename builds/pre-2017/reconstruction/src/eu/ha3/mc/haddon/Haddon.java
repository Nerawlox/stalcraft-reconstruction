/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.mc.haddon;

import eu.ha3.mc.haddon.Identity;
import eu.ha3.mc.haddon.Operator;
import eu.ha3.mc.haddon.Utility;

public interface Haddon {
    public void onLoad();

    public Utility getUtility();

    public void setUtility(Utility var1);

    public Operator getOperator();

    public void setOperator(Operator var1);

    public Identity getIdentity();
}

