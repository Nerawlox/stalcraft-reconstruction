/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.matmos.game.data;

import eu.ha3.matmos.engine.interfaces.Data;
import eu.ha3.matmos.requirem.Collation;
import eu.ha3.matmos.requirem.Requirements;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class MAtCatchAllRequirements
implements Collation {
    private Data data;
    private Map<String, Set<Integer>> sheetCache = new HashMap<String, Set<Integer>>();

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public Set<String> getRegisteredSheets() {
        return this.data.getSheetNames();
    }

    @Override
    public Set<Integer> getRequirementsFor(String string) {
        if (this.sheetCache.containsKey(string)) {
            return this.sheetCache.get(string);
        }
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<Integer>();
        for (int i = 0; i < this.data.getSheet(string).getSize(); ++i) {
            linkedHashSet.add(i);
        }
        this.sheetCache.put(string, linkedHashSet);
        return this.sheetCache.get(string);
    }

    @Override
    public boolean isRequired(String string) {
        return true;
    }

    @Override
    public void addRequirements(String string, Requirements requirements) {
    }

    @Override
    public void removeRequirements(String string) {
    }
}

