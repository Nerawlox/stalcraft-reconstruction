/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.matmos.requirem;

import eu.ha3.matmos.requirem.Requirements;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FlatRequirements
implements Requirements {
    protected final Map<String, Set<Integer>> sheets = new HashMap<String, Set<Integer>>();
    protected final Set<Integer> emptySet = new HashSet<Integer>();

    @Override
    public Set<Integer> getRequirementsFor(String string) {
        if (this.sheets.containsKey(string)) {
            return this.sheets.get(string);
        }
        return this.emptySet;
    }

    @Override
    public boolean isRequired(String string) {
        return this.sheets.containsKey(string);
    }

    @Override
    public Set<String> getRegisteredSheets() {
        return this.sheets.keySet();
    }

    protected void ensureSheetExists(String string) {
        if (!this.sheets.containsKey(string)) {
            this.sheets.put(string, new HashSet());
        }
    }
}

