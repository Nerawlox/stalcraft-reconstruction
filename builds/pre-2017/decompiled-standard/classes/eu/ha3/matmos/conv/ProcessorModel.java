/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.matmos.conv;

import eu.ha3.matmos.conv.Processor;
import eu.ha3.matmos.engine.implem.IntegerData;
import eu.ha3.matmos.engine.interfaces.Sheet;
import java.util.HashSet;
import java.util.Set;

public abstract class ProcessorModel
implements Processor {
    private IntegerData data;
    private String normalName;
    private String deltaName;
    private Sheet<Integer> normalSheet;
    private Sheet<Integer> deltaSheet;
    private boolean normalRequired = false;
    private boolean deltaRequired = false;
    private HashSet<Integer> requirementsSet;

    public ProcessorModel(IntegerData integerData, String string, String string2) {
        this.data = integerData;
        this.normalName = string;
        this.deltaName = string2;
        this.requirementsSet = new HashSet();
    }

    public IntegerData data() {
        return this.data;
    }

    protected abstract void doProcess();

    @Override
    public void process() {
        this.normalRequired = this.data.getRequirements().isRequired(this.normalName);
        boolean bl = this.deltaRequired = this.deltaName != null && this.data.getRequirements().isRequired(this.deltaName);
        if (!this.isRequired()) {
            return;
        }
        this.normalSheet = this.data().getSheet(this.normalName);
        if (this.deltaName != null) {
            this.deltaSheet = this.data().getSheet(this.deltaName);
        }
        this.doProcess();
    }

    public void setValue(int n, int n2) {
        int n3 = this.normalSheet.get(n);
        this.normalSheet.set(n, n2);
        if (this.deltaName != null) {
            this.deltaSheet.set(n, n2 - n3);
        }
    }

    public boolean isRequired() {
        return this.normalRequired || this.deltaRequired;
    }

    public Set<Integer> getRequired() {
        if (this.deltaName == null) {
            return this.data.getRequirements().getRequirementsFor(this.normalName);
        }
        this.requirementsSet.clear();
        this.requirementsSet.addAll(this.data.getRequirements().getRequirementsFor(this.normalName));
        this.requirementsSet.addAll(this.data.getRequirements().getRequirementsFor(this.deltaName));
        return this.requirementsSet;
    }
}

