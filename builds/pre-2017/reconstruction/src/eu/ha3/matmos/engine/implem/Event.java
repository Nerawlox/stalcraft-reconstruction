/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.matmos.engine.implem;

import eu.ha3.matmos.engine.implem.Descriptible;
import eu.ha3.matmos.engine.implem.Knowledge;
import java.util.ArrayList;
import java.util.Iterator;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

public class Event
extends Descriptible {
    private Knowledge knowledge;
    public ArrayList<String> paths = new ArrayList();
    public float volMin;
    public float volMax;
    public float pitchMin;
    public float pitchMax;
    public int metaSound;

    public Event(Knowledge knowledge) {
        this.knowledge = knowledge;
        this.volMin = 1.0f;
        this.volMax = 1.0f;
        this.pitchMin = 1.0f;
        this.pitchMax = 1.0f;
        this.metaSound = 0;
    }

    void setKnowledge(Knowledge knowledge) {
        this.knowledge = knowledge;
    }

    public void cacheSounds() {
        Iterator<String> iterator2 = this.paths.iterator();
        while (iterator2.hasNext()) {
            this.knowledge.getSoundManager().cacheSound(iterator2.next());
        }
    }

    public void playSound(float f, float f2) {
        if (this.paths.isEmpty()) {
            return;
        }
        float f3 = this.volMax - this.volMin;
        float f4 = this.pitchMax - this.pitchMin;
        f3 = this.volMin + (f3 > 0.0f ? this.knowledge.getRNG().nextFloat() * f3 : 0.0f);
        f4 = this.pitchMin + (f4 > 0.0f ? this.knowledge.getRNG().nextFloat() * f4 : 0.0f);
        String string = this.paths.get(this.knowledge.getRNG().nextInt(this.paths.size()));
        this.knowledge.getSoundManager().playSound(string, f3 *= f, f4 *= f2, this.metaSound);
    }

    @Override
    public String serialize(XMLEventWriter xMLEventWriter) throws XMLStreamException {
        this.buildDescriptibleSerialized(xMLEventWriter);
        Iterator<String> iterator2 = this.paths.iterator();
        while (iterator2.hasNext()) {
            this.createNode(xMLEventWriter, "path", iterator2.next());
        }
        this.createNode(xMLEventWriter, "volmin", this.volMin + "");
        this.createNode(xMLEventWriter, "volmax", this.volMax + "");
        this.createNode(xMLEventWriter, "pitchmin", this.pitchMin + "");
        this.createNode(xMLEventWriter, "pitchmax", this.pitchMax + "");
        this.createNode(xMLEventWriter, "metasound", this.metaSound + "");
        return "";
    }
}

