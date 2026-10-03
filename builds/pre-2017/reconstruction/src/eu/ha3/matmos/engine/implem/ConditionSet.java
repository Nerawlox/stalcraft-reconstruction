/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.matmos.engine.implem;

import eu.ha3.matmos.conv.MAtmosConvLogger;
import eu.ha3.matmos.engine.implem.Knowledge;
import eu.ha3.matmos.engine.implem.Switchable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

public class ConditionSet
extends Switchable {
    private Map<String, Boolean> conditions = new LinkedHashMap<String, Boolean>();
    private boolean isTrueEvaluated = false;

    public ConditionSet(Knowledge knowledge) {
        super(knowledge);
    }

    @Override
    protected boolean testIfValid() {
        if (this.conditions.size() == 0) {
            return false;
        }
        for (String string : this.conditions.keySet()) {
            if (this.knowledge.getConditionsKeySet().contains(string)) continue;
            return false;
        }
        return true;
    }

    public void replaceConditionName(String string, String string2) {
        this.flagNeedsTesting();
        if (this.conditions.containsKey(string)) {
            this.conditions.put(string2, this.conditions.get(string));
            this.conditions.remove(string);
        }
    }

    public void setSet(Object ... objectArray) throws IllegalArgumentException {
        this.flagNeedsTesting();
        if (objectArray.length % 2 == 0) {
            this.conditions.clear();
            for (int i = 0; i < objectArray.length / 2; ++i) {
                this.conditions.put((String)objectArray[i], (Boolean)objectArray[i + 1]);
            }
        } else {
            this.conditions.clear();
            throw new IllegalArgumentException();
        }
    }

    public void addCondition(String string, boolean bl) throws IllegalArgumentException {
        this.flagNeedsTesting();
        this.conditions.put(string, bl);
    }

    public void removeCondition(String string) {
        this.flagNeedsTesting();
        this.conditions.remove(string);
    }

    public Map<String, Boolean> getSet() {
        return this.conditions;
    }

    public boolean evaluate() {
        if (!this.isValid()) {
            return false;
        }
        boolean bl = this.isTrueEvaluated;
        this.isTrueEvaluated = this.testIfTrue();
        if (bl != this.isTrueEvaluated) {
            MAtmosConvLogger.fine("S:" + this.nickname + (this.isTrueEvaluated ? " now On." : " now Off."));
        }
        return this.isTrueEvaluated;
    }

    @Override
    public boolean isActive() {
        return this.isTrue();
    }

    public boolean isTrue() {
        return this.isTrueEvaluated;
    }

    public boolean testIfTrue() {
        if (!this.isValid()) {
            return false;
        }
        boolean bl = true;
        Iterator<Map.Entry<String, Boolean>> iterator2 = this.conditions.entrySet().iterator();
        while (bl && iterator2.hasNext()) {
            Map.Entry<String, Boolean> entry = iterator2.next();
            if (entry.getValue().booleanValue() == this.knowledge.getCondition(entry.getKey()).isTrue()) continue;
            bl = false;
        }
        return bl;
    }

    @Override
    public String serialize(XMLEventWriter xMLEventWriter) throws XMLStreamException {
        this.buildDescriptibleSerialized(xMLEventWriter);
        for (Map.Entry<String, Boolean> entry : this.conditions.entrySet()) {
            if (entry.getValue().booleanValue()) {
                this.createNode(xMLEventWriter, "truepart", entry.getKey());
                continue;
            }
            this.createNode(xMLEventWriter, "falsepart", entry.getKey());
        }
        return "";
    }
}

