/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.matmos.engine.implem;

import eu.ha3.matmos.engine.implem.Descriptible;
import eu.ha3.matmos.engine.implem.Machine;
import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.DTD;

public class TimedEvent
extends Descriptible {
    Machine machine;
    public String event = "";
    public float volMod;
    public float pitchMod;
    public float delayMin;
    public float delayMax;
    public float delayStart;
    public long nextPlayTime;

    TimedEvent(Machine machine) {
        this.machine = machine;
        this.volMod = 1.0f;
        this.pitchMod = 1.0f;
        this.delayMin = 10.0f;
        this.delayMax = 10.0f;
        this.delayStart = 0.0f;
    }

    void setMachine(Machine machine) {
        this.machine = machine;
    }

    public void routine() {
        if (this.machine.knowledge.getTimeMillis() < this.nextPlayTime) {
            return;
        }
        if (this.machine.knowledge.getEventsKeySet().contains(this.event)) {
            this.machine.knowledge.getEvent(this.event).playSound(this.volMod, this.pitchMod);
        }
        if (this.delayMin == this.delayMax && this.delayMin > 0.0f) {
            while (this.nextPlayTime < this.machine.knowledge.getTimeMillis()) {
                this.nextPlayTime += (long)(this.delayMin * 1000.0f);
            }
        } else {
            this.nextPlayTime = this.machine.knowledge.getTimeMillis() + (long)((this.delayMin + this.machine.knowledge.getRNG().nextFloat() * (this.delayMax - this.delayMin)) * 1000.0f);
        }
    }

    public void restart() {
        this.nextPlayTime = this.delayStart == 0.0f ? this.machine.knowledge.getTimeMillis() + (long)(this.machine.knowledge.getRNG().nextFloat() * this.delayMax * 1000.0f) : this.machine.knowledge.getTimeMillis() + (long)(this.delayStart * 1000.0f);
    }

    @Override
    public String serialize(XMLEventWriter xMLEventWriter) throws XMLStreamException {
        XMLEventFactory xMLEventFactory = XMLEventFactory.newInstance();
        DTD dTD = xMLEventFactory.createDTD("\n");
        DTD dTD2 = xMLEventFactory.createDTD("\t");
        xMLEventWriter.add(dTD2);
        xMLEventWriter.add(xMLEventFactory.createStartElement("", "", "eventtimed"));
        xMLEventWriter.add(dTD);
        this.createNode(xMLEventWriter, "eventname", this.event, 2);
        this.createNode(xMLEventWriter, "delaymin", "" + this.delayMin, 2);
        this.createNode(xMLEventWriter, "delaymax", "" + this.delayMax, 2);
        this.createNode(xMLEventWriter, "delaystart", "" + this.delayStart, 2);
        this.createNode(xMLEventWriter, "volmod", "" + this.volMod, 2);
        this.createNode(xMLEventWriter, "pitchmod", "" + this.pitchMod, 2);
        xMLEventWriter.add(dTD2);
        xMLEventWriter.add(xMLEventFactory.createEndElement("", "", "eventtimed"));
        xMLEventWriter.add(dTD);
        return "";
    }
}

