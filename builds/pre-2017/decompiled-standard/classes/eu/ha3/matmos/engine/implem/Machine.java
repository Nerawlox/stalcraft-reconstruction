/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.matmos.engine.implem;

import eu.ha3.matmos.conv.MAtmosConvLogger;
import eu.ha3.matmos.engine.implem.Descriptible;
import eu.ha3.matmos.engine.implem.Knowledge;
import eu.ha3.matmos.engine.implem.Stream;
import eu.ha3.matmos.engine.implem.Switchable;
import eu.ha3.matmos.engine.implem.TimedEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

public class Machine
extends Switchable {
    private List<String> anyallows;
    private List<String> anyrestricts;
    private List<TimedEvent> etimes = new ArrayList<TimedEvent>();
    private List<Stream> streams = new ArrayList<Stream>();
    private boolean powered = false;
    private boolean switchedOn = false;

    Machine(Knowledge knowledge) {
        super(knowledge);
        this.anyallows = new ArrayList<String>();
        this.anyrestricts = new ArrayList<String>();
    }

    public void routine() {
        if (this.switchedOn) {
            for (TimedEvent timedEvent : this.etimes) {
                timedEvent.routine();
            }
        }
        if (this.powered && !this.streams.isEmpty()) {
            Iterator<Descriptible> iterator2 = this.streams.iterator();
            while (iterator2.hasNext()) {
                ((Stream)iterator2.next()).routine();
            }
        }
    }

    public void turnOn() {
        if (!this.powered) {
            return;
        }
        if (this.switchedOn) {
            return;
        }
        this.switchedOn = true;
        Iterator<Descriptible> iterator2 = this.etimes.iterator();
        while (iterator2.hasNext()) {
            iterator2.next().restart();
        }
        iterator2 = this.streams.iterator();
        while (iterator2.hasNext()) {
            ((Stream)iterator2.next()).signalPlayable();
        }
    }

    public void turnOff() {
        if (!this.powered) {
            return;
        }
        if (!this.switchedOn) {
            return;
        }
        this.switchedOn = false;
        Iterator<Stream> iterator2 = this.streams.iterator();
        while (iterator2.hasNext()) {
            iterator2.next().signalStoppable();
        }
    }

    public void powerOn() {
        this.powered = true;
    }

    public void powerOff() {
        Iterator<Stream> iterator2 = this.streams.iterator();
        while (iterator2.hasNext()) {
            iterator2.next().clearToken();
        }
        this.turnOff();
        this.powered = false;
    }

    public boolean isPowered() {
        return this.powered;
    }

    public boolean isOn() {
        return this.switchedOn;
    }

    public List<String> getAllows() {
        return this.anyallows;
    }

    public List<String> getRestricts() {
        return this.anyrestricts;
    }

    public void addAllow(String string) {
        this.anyallows.add(string);
        this.flagNeedsTesting();
    }

    public void addRestrict(String string) {
        this.anyrestricts.add(string);
        this.flagNeedsTesting();
    }

    public void removeSet(String string) {
        this.anyallows.remove(string);
        this.anyrestricts.remove(string);
        this.flagNeedsTesting();
    }

    public void replaceSetName(String string, String string2) {
        if (this.anyallows.contains(string)) {
            this.anyallows.add(string2);
            this.anyallows.remove(string);
        }
        if (this.anyrestricts.contains(string)) {
            this.anyrestricts.add(string2);
            this.anyrestricts.remove(string);
        }
        this.flagNeedsTesting();
    }

    public List<TimedEvent> getEventsTimed() {
        return this.etimes;
    }

    public int addEventTimed() {
        this.etimes.add(new TimedEvent(this));
        return this.etimes.size();
    }

    public int removeEventTimed(int n) {
        this.etimes.remove(n);
        return this.etimes.size();
    }

    public TimedEvent getEventTimed(int n) {
        return this.etimes.get(n);
    }

    public List<Stream> getStreams() {
        return this.streams;
    }

    public int addStream() {
        this.streams.add(new Stream(this));
        return this.streams.size();
    }

    public int removeStream(int n) {
        this.streams.remove(n);
        return this.streams.size();
    }

    public Stream getStream(int n) {
        return this.streams.get(n);
    }

    @Override
    protected boolean testIfValid() {
        if (this.anyallows.size() == 0) {
            return false;
        }
        for (String object : this.anyallows) {
            if (this.knowledge.getConditionSetsKeySet().contains(object)) continue;
            return false;
        }
        for (String string : this.anyrestricts) {
            if (this.knowledge.getConditionSetsKeySet().contains(string)) continue;
            return false;
        }
        return true;
    }

    public boolean evaluate() {
        if (!this.isValid()) {
            return false;
        }
        if (!this.powered) {
            return false;
        }
        boolean bl = this.switchedOn;
        boolean bl2 = this.testIfTrue();
        if (bl != bl2) {
            if (bl2) {
                this.turnOn();
            } else {
                this.turnOff();
            }
            MAtmosConvLogger.fine("M:" + this.nickname + (this.switchedOn ? " now On." : " now Off."));
        }
        return this.switchedOn;
    }

    @Override
    public boolean isActive() {
        return this.isTrue();
    }

    public boolean isTrue() {
        return this.switchedOn;
    }

    public boolean testIfTrue() {
        Object object;
        if (!this.isValid()) {
            return false;
        }
        boolean bl = false;
        Iterator<String> iterator2 = this.anyallows.iterator();
        while (!bl && iterator2.hasNext()) {
            object = iterator2.next();
            if (!this.knowledge.getConditionSet((String)object).isTrue()) continue;
            bl = true;
        }
        object = this.anyrestricts.iterator();
        while (bl && object.hasNext()) {
            String string = (String)object.next();
            if (!this.knowledge.getConditionSet(string).isTrue()) continue;
            bl = false;
        }
        return bl;
    }

    @Override
    public String serialize(XMLEventWriter xMLEventWriter) throws XMLStreamException {
        this.buildDescriptibleSerialized(xMLEventWriter);
        Iterator<Object> iterator2 = this.anyallows.iterator();
        while (iterator2.hasNext()) {
            this.createNode(xMLEventWriter, "allow", iterator2.next());
        }
        iterator2 = this.anyrestricts.iterator();
        while (iterator2.hasNext()) {
            this.createNode(xMLEventWriter, "restrict", iterator2.next());
        }
        iterator2 = this.etimes.iterator();
        while (iterator2.hasNext()) {
            ((TimedEvent)iterator2.next()).serialize(xMLEventWriter);
        }
        iterator2 = this.streams.iterator();
        while (iterator2.hasNext()) {
            ((Stream)iterator2.next()).serialize(xMLEventWriter);
        }
        return "";
    }

    public List<TimedEvent> getTimedEvents() {
        return this.etimes;
    }
}

