/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.matmos.requirem;

import java.util.Set;

public interface Requirements {
    public Set<String> getRegisteredSheets();

    public Set<Integer> getRequirementsFor(String var1);

    public boolean isRequired(String var1);
}

