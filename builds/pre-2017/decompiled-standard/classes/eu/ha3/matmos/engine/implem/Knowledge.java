/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.matmos.engine.implem;

import eu.ha3.matmos.engine.implem.Condition;
import eu.ha3.matmos.engine.implem.ConditionSet;
import eu.ha3.matmos.engine.implem.Dynamic;
import eu.ha3.matmos.engine.implem.Event;
import eu.ha3.matmos.engine.implem.IntegerData;
import eu.ha3.matmos.engine.implem.Machine;
import eu.ha3.matmos.engine.implem.RunningClock;
import eu.ha3.matmos.engine.implem.SugarList;
import eu.ha3.matmos.engine.implem.TimedEvent;
import eu.ha3.matmos.engine.interfaces.Data;
import eu.ha3.matmos.engine.interfaces.SoundRelay;
import eu.ha3.matmos.requirem.FlatRequirements;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.DTD;
import javax.xml.transform.stream.StreamResult;

public class Knowledge {
    private Map<String, Dynamic> dynamics;
    private Map<String, SugarList> lists;
    private Map<String, Condition> conditions;
    private Map<String, ConditionSet> sets;
    private Map<String, Machine> machines;
    private Map<String, Event> events;
    private Data data = new IntegerData(new FlatRequirements());
    private SoundRelay soundManager = null;
    private RunningClock clock;
    private boolean isRunning = false;
    private int dataLastVersion = 0;
    private Random random = new Random(System.currentTimeMillis());

    public Knowledge() {
        this.clock = new RunningClock();
        this.patchKnowledge();
    }

    public Random getRNG() {
        return this.random;
    }

    public void patchKnowledge() {
        this.turnOff();
        this.dynamics = new LinkedHashMap<String, Dynamic>();
        this.lists = new LinkedHashMap<String, SugarList>();
        this.conditions = new LinkedHashMap<String, Condition>();
        this.sets = new LinkedHashMap<String, ConditionSet>();
        this.machines = new LinkedHashMap<String, Machine>();
        this.events = new LinkedHashMap<String, Event>();
    }

    public void turnOn() {
        if (this.soundManager == null) {
            return;
        }
        if (this.isRunning) {
            return;
        }
        this.ensureChildrenBound();
        this.isRunning = true;
        for (Machine machine : this.machines.values()) {
            machine.powerOn();
        }
    }

    public void turnOff() {
        if (!this.isRunning) {
            return;
        }
        this.isRunning = false;
        for (Machine machine : this.machines.values()) {
            machine.powerOff();
        }
    }

    public boolean isTurnedOn() {
        return this.isRunning;
    }

    public Set<String> getDynamicsKeySet() {
        return this.dynamics.keySet();
    }

    public Set<String> getListsKeySet() {
        return this.lists.keySet();
    }

    public Set<String> getConditionsKeySet() {
        return this.conditions.keySet();
    }

    public Set<String> getConditionSetsKeySet() {
        return this.sets.keySet();
    }

    public Set<String> getMachinesKeySet() {
        return this.machines.keySet();
    }

    public Set<String> getEventsKeySet() {
        return this.events.keySet();
    }

    private void ensureChildrenBound() {
        this.turnOff();
        for (Dynamic descriptible : this.dynamics.values()) {
            descriptible.setKnowledge(this);
        }
        for (Condition condition : this.conditions.values()) {
            condition.setKnowledge(this);
        }
        for (ConditionSet conditionSet : this.sets.values()) {
            conditionSet.setKnowledge(this);
        }
        for (Machine machine : this.machines.values()) {
            machine.setKnowledge(this);
        }
        for (Event event : this.events.values()) {
            event.setKnowledge(this);
        }
    }

    public int purgeUnused() {
        int n = 0;
        HashSet<String> hashSet = new HashSet<String>();
        hashSet.clear();
        for (String object : this.sets.keySet()) {
            hashSet.add(object);
        }
        for (Machine machine : this.machines.values()) {
            for (String string : machine.getAllows()) {
                hashSet.remove(string);
            }
            for (String string : machine.getRestricts()) {
                hashSet.remove(string);
            }
        }
        for (String string : hashSet) {
            ++n;
            this.removeConditionSet(string);
        }
        hashSet.clear();
        for (String string : this.conditions.keySet()) {
            hashSet.add(string);
        }
        for (ConditionSet conditionSet : this.sets.values()) {
            for (String string : conditionSet.getSet().keySet()) {
                hashSet.remove(string);
            }
        }
        for (String string : hashSet) {
            ++n;
            this.removeCondition(string);
        }
        hashSet.clear();
        for (String string : this.lists.keySet()) {
            hashSet.add(string);
        }
        for (Condition condition : this.conditions.values()) {
            if (condition.getList() == null || condition.getList() == "") continue;
            hashSet.remove(condition.getList());
        }
        for (String string : hashSet) {
            ++n;
            this.removeList(string);
        }
        return n;
    }

    public void setSoundManager(SoundRelay soundRelay) {
        this.soundManager = soundRelay;
    }

    public SoundRelay getSoundManager() {
        return this.soundManager;
    }

    public void cacheSounds() {
        for (Event event : this.events.values()) {
            event.cacheSounds();
        }
    }

    public void setClock(RunningClock runningClock) {
        this.clock = runningClock;
    }

    public void setData(Data data) {
        this.data = data;
        this.applySheetFlagNeedsTesting();
    }

    public Data getData() {
        return this.data;
    }

    public long getTimeMillis() {
        return this.clock.getMilliseconds();
    }

    void applySheetFlagNeedsTesting() {
        for (Condition switchable : this.conditions.values()) {
            switchable.flagNeedsTesting();
        }
        for (Dynamic dynamic : this.dynamics.values()) {
            dynamic.flagNeedsTesting();
        }
    }

    public Event getEvent(String string) {
        return this.events.get(string);
    }

    public boolean addEvent(String string) {
        if (this.events.containsKey(string)) {
            return false;
        }
        this.events.put(string, new Event(this));
        this.events.get((Object)string).nickname = string;
        return true;
    }

    public boolean removeEvent(String string) {
        if (!this.events.containsKey(string)) {
            return false;
        }
        this.events.remove(string);
        return true;
    }

    public boolean renameEvent(String string, String string2) {
        if (!this.events.containsKey(string)) {
            return false;
        }
        if (this.events.containsKey(string2)) {
            return false;
        }
        this.events.put(string2, this.events.get(string));
        this.events.remove(string);
        this.events.get((Object)string2).nickname = string2;
        for (Machine machine : this.machines.values()) {
            for (TimedEvent timedEvent : machine.getTimedEvents()) {
                if (!timedEvent.event.equals(string)) continue;
                timedEvent.event = string2;
            }
        }
        return true;
    }

    void applyDynamicFlagNeedsTesting() {
        for (Condition condition : this.conditions.values()) {
            condition.flagNeedsTesting();
        }
    }

    public Dynamic getDynamic(String string) {
        return this.dynamics.get(string);
    }

    public boolean addDynamic(String string) {
        if (this.dynamics.containsKey(string)) {
            return false;
        }
        this.dynamics.put(string, new Dynamic(this));
        this.dynamics.get((Object)string).nickname = string;
        this.applyDynamicFlagNeedsTesting();
        return true;
    }

    public boolean removeDynamic(String string) {
        if (!this.dynamics.containsKey(string)) {
            return false;
        }
        this.dynamics.remove(string);
        this.applyDynamicFlagNeedsTesting();
        return true;
    }

    public boolean renameDynamic(String string, String string2) {
        if (!this.dynamics.containsKey(string)) {
            return false;
        }
        if (this.dynamics.containsKey(string2)) {
            return false;
        }
        this.dynamics.put(string2, this.dynamics.get(string));
        this.dynamics.remove(string);
        this.dynamics.get((Object)string2).nickname = string2;
        for (Condition condition : this.conditions.values()) {
            condition.replaceDynamicName(string, string2);
        }
        return true;
    }

    void applyListFlagNeedsTesting() {
        for (Condition condition : this.conditions.values()) {
            condition.flagNeedsTesting();
        }
    }

    public SugarList getList(String string) {
        return this.lists.get(string);
    }

    public boolean addList(String string) {
        if (this.lists.containsKey(string)) {
            return false;
        }
        this.lists.put(string, new SugarList());
        this.lists.get((Object)string).nickname = string;
        this.applyDynamicFlagNeedsTesting();
        return true;
    }

    public boolean removeList(String string) {
        if (!this.lists.containsKey(string)) {
            return false;
        }
        this.lists.remove(string);
        this.applyDynamicFlagNeedsTesting();
        return true;
    }

    public boolean renameList(String string, String string2) {
        if (!this.lists.containsKey(string)) {
            return false;
        }
        if (this.lists.containsKey(string2)) {
            return false;
        }
        this.lists.put(string2, this.lists.get(string));
        this.lists.remove(string);
        this.lists.get((Object)string2).nickname = string2;
        for (Condition condition : this.conditions.values()) {
            condition.replaceListName(string, string2);
        }
        return true;
    }

    void applyConditionNeedsTesting() {
        for (ConditionSet conditionSet : this.sets.values()) {
            conditionSet.flagNeedsTesting();
        }
    }

    public Condition getCondition(String string) {
        return this.conditions.get(string);
    }

    public boolean addCondition(String string) {
        if (this.conditions.containsKey(string)) {
            return false;
        }
        this.conditions.put(string, new Condition(this));
        this.conditions.get((Object)string).nickname = string;
        this.applyConditionNeedsTesting();
        return true;
    }

    public boolean renameCondition(String string, String string2) {
        if (!this.conditions.containsKey(string)) {
            return false;
        }
        if (this.conditions.containsKey(string2)) {
            return false;
        }
        this.conditions.put(string2, this.conditions.get(string));
        this.conditions.remove(string);
        this.conditions.get((Object)string2).nickname = string2;
        for (ConditionSet conditionSet : this.sets.values()) {
            conditionSet.replaceConditionName(string, string2);
        }
        this.applyConditionNeedsTesting();
        return true;
    }

    public boolean removeCondition(String string) {
        if (!this.conditions.containsKey(string)) {
            return false;
        }
        this.conditions.remove(string);
        this.applyConditionNeedsTesting();
        return true;
    }

    void applyConditionSetNeedsTesting() {
        for (Machine machine : this.machines.values()) {
            machine.flagNeedsTesting();
        }
    }

    public ConditionSet getConditionSet(String string) {
        return this.sets.get(string);
    }

    public boolean addConditionSet(String string) {
        if (this.sets.containsKey(string)) {
            return false;
        }
        this.sets.put(string, new ConditionSet(this));
        this.sets.get((Object)string).nickname = string;
        this.applyConditionSetNeedsTesting();
        return true;
    }

    public boolean renameConditionSet(String string, String string2) {
        if (!this.sets.containsKey(string)) {
            return false;
        }
        if (this.sets.containsKey(string2)) {
            return false;
        }
        this.sets.put(string2, this.sets.get(string));
        this.sets.remove(string);
        this.sets.get((Object)string2).nickname = string2;
        for (Machine machine : this.machines.values()) {
            machine.replaceSetName(string, string2);
        }
        this.applyConditionSetNeedsTesting();
        return true;
    }

    public boolean removeConditionSet(String string) {
        if (!this.sets.containsKey(string)) {
            return false;
        }
        this.sets.remove(string);
        this.applyConditionSetNeedsTesting();
        return true;
    }

    void applyMachineNeedsTesting() {
    }

    public Machine getMachine(String string) {
        return this.machines.get(string);
    }

    public boolean addMachine(String string) {
        if (this.machines.containsKey(string)) {
            return false;
        }
        this.machines.put(string, new Machine(this));
        this.machines.get((Object)string).nickname = string;
        this.applyMachineNeedsTesting();
        return true;
    }

    public boolean removeMachine(String string) {
        if (!this.machines.containsKey(string)) {
            return false;
        }
        this.machines.remove(string);
        this.applyMachineNeedsTesting();
        return true;
    }

    public boolean renameMachine(String string, String string2) {
        if (!this.machines.containsKey(string)) {
            return false;
        }
        if (this.machines.containsKey(string2)) {
            return false;
        }
        this.machines.put(string2, this.machines.get(string));
        this.machines.remove(string);
        this.machines.get((Object)string2).nickname = string2;
        this.applyConditionSetNeedsTesting();
        return true;
    }

    public void soundRoutine() {
        if (!this.isRunning) {
            return;
        }
        this.soundManager.routine();
        Iterator<Machine> iterator2 = this.machines.values().iterator();
        while (iterator2.hasNext()) {
            iterator2.next().routine();
        }
    }

    public void dataRoutine() {
        if (!this.isRunning) {
            return;
        }
        if (this.dataLastVersion != this.data.getVersion()) {
            this.evaluate();
            this.dataLastVersion = this.data.getVersion();
        }
    }

    void evaluate() {
        if (!this.isRunning) {
            return;
        }
        for (Dynamic switchable : this.dynamics.values()) {
            switchable.evaluate();
        }
        for (Condition condition : this.conditions.values()) {
            condition.evaluate();
        }
        for (ConditionSet conditionSet : this.sets.values()) {
            conditionSet.evaluate();
        }
        for (Machine machine : this.machines.values()) {
            machine.evaluate();
        }
    }

    public String createXML() throws XMLStreamException {
        String string;
        int n;
        StreamResult streamResult = new StreamResult(new StringWriter());
        XMLOutputFactory xMLOutputFactory = XMLOutputFactory.newInstance();
        XMLEventFactory xMLEventFactory = XMLEventFactory.newInstance();
        XMLEventWriter xMLEventWriter = xMLOutputFactory.createXMLEventWriter(streamResult);
        DTD dTD = xMLEventFactory.createDTD("\n");
        DTD dTD2 = xMLEventFactory.createDTD("\n");
        xMLEventWriter.add(xMLEventFactory.createStartDocument());
        xMLEventWriter.add(dTD);
        xMLEventWriter.add(xMLEventFactory.createStartElement("", "", "contents"));
        Object[] objectArray = this.dynamics.keySet().toArray();
        Arrays.sort(objectArray);
        for (n = 0; n < objectArray.length; ++n) {
            string = objectArray[n].toString();
            xMLEventWriter.add(dTD);
            xMLEventWriter.add(xMLEventFactory.createStartElement("", "", "dynamic"));
            xMLEventWriter.add(xMLEventFactory.createAttribute("name", string));
            xMLEventWriter.add(dTD);
            this.dynamics.get(string).serialize(xMLEventWriter);
            xMLEventWriter.add(xMLEventFactory.createEndElement("", "", "dynamic"));
        }
        objectArray = this.lists.keySet().toArray();
        Arrays.sort(objectArray);
        for (n = 0; n < objectArray.length; ++n) {
            string = objectArray[n].toString();
            xMLEventWriter.add(dTD);
            xMLEventWriter.add(xMLEventFactory.createStartElement("", "", "list"));
            xMLEventWriter.add(xMLEventFactory.createAttribute("name", string));
            xMLEventWriter.add(dTD);
            this.lists.get(string).serialize(xMLEventWriter);
            xMLEventWriter.add(xMLEventFactory.createEndElement("", "", "list"));
        }
        objectArray = this.conditions.keySet().toArray();
        Arrays.sort(objectArray);
        for (n = 0; n < objectArray.length; ++n) {
            string = objectArray[n].toString();
            xMLEventWriter.add(dTD);
            xMLEventWriter.add(xMLEventFactory.createStartElement("", "", "condition"));
            xMLEventWriter.add(xMLEventFactory.createAttribute("name", string));
            xMLEventWriter.add(dTD);
            this.conditions.get(string).serialize(xMLEventWriter);
            xMLEventWriter.add(xMLEventFactory.createEndElement("", "", "condition"));
        }
        objectArray = this.sets.keySet().toArray();
        Arrays.sort(objectArray);
        for (n = 0; n < objectArray.length; ++n) {
            string = objectArray[n].toString();
            xMLEventWriter.add(dTD);
            xMLEventWriter.add(xMLEventFactory.createStartElement("", "", "set"));
            xMLEventWriter.add(xMLEventFactory.createAttribute("name", string));
            xMLEventWriter.add(dTD);
            this.sets.get(string).serialize(xMLEventWriter);
            xMLEventWriter.add(xMLEventFactory.createEndElement("", "", "set"));
        }
        objectArray = this.events.keySet().toArray();
        Arrays.sort(objectArray);
        for (n = 0; n < objectArray.length; ++n) {
            string = objectArray[n].toString();
            xMLEventWriter.add(dTD);
            xMLEventWriter.add(xMLEventFactory.createStartElement("", "", "event"));
            xMLEventWriter.add(xMLEventFactory.createAttribute("name", string));
            xMLEventWriter.add(dTD);
            this.events.get(string).serialize(xMLEventWriter);
            xMLEventWriter.add(xMLEventFactory.createEndElement("", "", "event"));
        }
        objectArray = this.machines.keySet().toArray();
        Arrays.sort(objectArray);
        for (n = 0; n < objectArray.length; ++n) {
            string = objectArray[n].toString();
            xMLEventWriter.add(dTD);
            xMLEventWriter.add(xMLEventFactory.createStartElement("", "", "machine"));
            xMLEventWriter.add(xMLEventFactory.createAttribute("name", string));
            xMLEventWriter.add(dTD);
            this.machines.get(string).serialize(xMLEventWriter);
            xMLEventWriter.add(xMLEventFactory.createEndElement("", "", "machine"));
        }
        xMLEventWriter.add(dTD);
        xMLEventWriter.add(xMLEventFactory.createEndElement("", "", "contents"));
        xMLEventWriter.add(dTD2);
        xMLEventWriter.add(xMLEventFactory.createEndDocument());
        xMLEventWriter.close();
        return streamResult.getWriter().toString();
    }
}

