/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.matmos.engine.implem;

import eu.ha3.matmos.engine.interfaces.Data;
import eu.ha3.matmos.engine.interfaces.Sheet;
import eu.ha3.matmos.requirem.Requestable;
import eu.ha3.matmos.requirem.Requirements;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class IntegerData
implements Data,
Requestable {
    private Map<String, Sheet<Integer>> sheets = new LinkedHashMap<String, Sheet<Integer>>();
    private int updateVersion = 0;
    private Requirements requirements;

    public IntegerData(Requirements requirements) {
        this.requirements = requirements;
    }

    @Override
    public void flagUpdate() {
        ++this.updateVersion;
    }

    @Override
    public int getVersion() {
        return this.updateVersion;
    }

    @Override
    public Sheet<Integer> getSheet(String string) {
        return this.sheets.get(string);
    }

    @Override
    public void setSheet(String string, Sheet<Integer> sheet) {
        this.sheets.put(string, sheet);
    }

    @Override
    public Requirements getRequirements() {
        return this.requirements;
    }

    @Override
    public Set<String> getSheetNames() {
        return this.sheets.keySet();
    }
}

