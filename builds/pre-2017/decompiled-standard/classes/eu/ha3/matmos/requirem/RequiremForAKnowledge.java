/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.matmos.requirem;

import eu.ha3.matmos.engine.implem.Condition;
import eu.ha3.matmos.engine.implem.Dynamic;
import eu.ha3.matmos.engine.implem.Knowledge;
import eu.ha3.matmos.engine.implem.Switchable;
import eu.ha3.matmos.requirem.FlatRequirements;

public class RequiremForAKnowledge
extends FlatRequirements {
    public RequiremForAKnowledge(Knowledge knowledge) {
        Switchable switchable;
        for (String string : knowledge.getConditionsKeySet()) {
            switchable = knowledge.getCondition(string);
            if (((Condition)switchable).isDynamic()) continue;
            String string2 = ((Condition)switchable).getSheet();
            this.ensureSheetExists(string2);
            this.sheets.get(string2).add(((Condition)switchable).getKey());
        }
        for (String string : knowledge.getDynamicsKeySet()) {
            switchable = knowledge.getDynamic(string);
            int n = ((Dynamic)switchable).getSheets().size();
            for (int i = 0; i < n; ++i) {
                String string3 = ((Dynamic)switchable).getSheet(i);
                this.ensureSheetExists(string3);
                this.sheets.get(string3).add(((Dynamic)switchable).getKey(i));
            }
        }
    }
}

