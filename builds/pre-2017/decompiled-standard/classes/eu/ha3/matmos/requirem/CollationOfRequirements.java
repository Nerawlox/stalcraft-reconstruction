/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.matmos.requirem;

import eu.ha3.matmos.conv.MAtmosConvLogger;
import eu.ha3.matmos.requirem.Collation;
import eu.ha3.matmos.requirem.FlatRequirements;
import eu.ha3.matmos.requirem.Requirements;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CollationOfRequirements
extends FlatRequirements
implements Collation {
    private final Map<String, Requirements> collation = new HashMap<String, Requirements>();

    @Override
    public void addRequirements(String string, Requirements requirements) {
        this.collation.put(string, requirements);
        this.recomputeRequirements();
        MAtmosConvLogger.info("Adding requirements: " + string);
    }

    @Override
    public void removeRequirements(String string) {
        if (!this.collation.containsKey(string)) {
            return;
        }
        this.collation.remove(string);
        this.recomputeRequirements();
        MAtmosConvLogger.info("Removing requirements: " + string);
    }

    private void recomputeRequirements() {
        this.sheets.clear();
        for (Requirements requirements : this.collation.values()) {
            Set<String> set = requirements.getRegisteredSheets();
            for (String string : set) {
                this.ensureSheetExists(string);
                this.sheets.get(string).addAll(requirements.getRequirementsFor(string));
            }
        }
    }
}

