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

public class Stream
extends Descriptible {
    Machine machine;
    private int token;
    public String path = "";
    public float volume = 1.0f;
    public float pitch = 1.0f;
    public float delayBeforeFadeIn = 0.0f;
    public float delayBeforeFadeOut = 0.0f;
    public float fadeInTime = 0.0f;
    public float fadeOutTime = 0.0f;
    public boolean isLooping = true;
    public boolean isUsingPause = false;
    private boolean isTurnedOn;
    private boolean isPlaying;
    private long startTime;
    private long stopTime;
    private boolean firstCall;

    Stream(Machine machine) {
        this.machine = machine;
        this.firstCall = true;
        this.token = -1;
        this.startTime = 0L;
        this.stopTime = 0L;
    }

    void setMachine(Machine machine) {
        this.machine = machine;
    }

    public void signalPlayable() {
        if (this.isTurnedOn) {
            return;
        }
        this.startTime = this.machine.knowledge.getTimeMillis() + (long)(this.delayBeforeFadeIn * 1000.0f);
        this.isTurnedOn = true;
    }

    public void signalStoppable() {
        if (!this.isTurnedOn) {
            return;
        }
        this.stopTime = this.machine.knowledge.getTimeMillis() + (long)(this.delayBeforeFadeOut * 1000.0f);
        this.isTurnedOn = false;
    }

    public void clearToken() {
        if (this.firstCall) {
            return;
        }
        this.machine.knowledge.getSoundManager().eraseStreamingToken(this.token);
        this.isPlaying = false;
        this.token = -1;
        this.firstCall = true;
    }

    public void routine() {
        if (!this.isLooping && this.isUsingPause) {
            return;
        }
        if (this.isTurnedOn && !this.isPlaying) {
            if (this.machine.knowledge.getTimeMillis() > this.startTime) {
                this.isPlaying = true;
                if (this.firstCall) {
                    this.token = this.machine.knowledge.getSoundManager().getNewStreamingToken();
                    if (this.machine.knowledge.getSoundManager().setupStreamingToken(this.token, this.path, this.volume, this.pitch)) {
                        this.firstCall = false;
                        this.machine.knowledge.getSoundManager().startStreaming(this.token, this.fadeInTime, this.isLooping ? 0 : 1);
                    }
                } else {
                    this.machine.knowledge.getSoundManager().startStreaming(this.token, this.fadeInTime, this.isLooping ? 0 : 1);
                }
            }
        } else if (!this.isTurnedOn && this.isPlaying && this.machine.knowledge.getTimeMillis() > this.stopTime) {
            this.isPlaying = false;
            if (!this.isUsingPause) {
                this.machine.knowledge.getSoundManager().stopStreaming(this.token, this.fadeOutTime);
            } else {
                this.machine.knowledge.getSoundManager().pauseStreaming(this.token, this.fadeOutTime);
            }
        }
    }

    @Override
    public String serialize(XMLEventWriter xMLEventWriter) throws XMLStreamException {
        XMLEventFactory xMLEventFactory = XMLEventFactory.newInstance();
        DTD dTD = xMLEventFactory.createDTD("\n");
        DTD dTD2 = xMLEventFactory.createDTD("\t");
        xMLEventWriter.add(dTD2);
        xMLEventWriter.add(xMLEventFactory.createStartElement("", "", "stream"));
        xMLEventWriter.add(dTD);
        this.createNode(xMLEventWriter, "path", this.path, 2);
        this.createNode(xMLEventWriter, "volume", "" + this.volume, 2);
        this.createNode(xMLEventWriter, "pitch", "" + this.pitch, 2);
        this.createNode(xMLEventWriter, "fadeintime", "" + this.fadeInTime, 2);
        this.createNode(xMLEventWriter, "fadeouttime", "" + this.fadeOutTime, 2);
        this.createNode(xMLEventWriter, "delaybeforefadein", "" + this.delayBeforeFadeIn, 2);
        this.createNode(xMLEventWriter, "delaybeforefadeout", "" + this.delayBeforeFadeOut, 2);
        this.createNode(xMLEventWriter, "islooping", this.isLooping ? "1" : "0", 2);
        this.createNode(xMLEventWriter, "isusingpause", this.isUsingPause ? "1" : "0", 2);
        xMLEventWriter.add(dTD2);
        xMLEventWriter.add(xMLEventFactory.createEndElement("", "", "stream"));
        xMLEventWriter.add(dTD);
        return "";
    }
}

