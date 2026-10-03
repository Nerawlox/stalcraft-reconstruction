/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.matmos.engine.implem;

import eu.ha3.matmos.engine.implem.Descriptible;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

public class SugarList
extends Descriptible {
    private List<Integer> list = new ArrayList<Integer>();

    SugarList() {
    }

    public List<Integer> getList() {
        return this.list;
    }

    public boolean contains(int n) {
        return this.list.contains(n);
    }

    public void add(int n) {
        if (this.list.contains(n)) {
            return;
        }
        this.list.add(n);
        Collections.sort(this.list);
    }

    public void remove(int n) {
        this.list.remove(n);
    }

    public void clear() {
        this.list.clear();
    }

    @Override
    public String serialize(XMLEventWriter xMLEventWriter) throws XMLStreamException {
        this.buildDescriptibleSerialized(xMLEventWriter);
        Iterator<Integer> iterator2 = this.list.iterator();
        while (iterator2.hasNext()) {
            this.createNode(xMLEventWriter, "constant", iterator2.next().toString());
        }
        return null;
    }
}

