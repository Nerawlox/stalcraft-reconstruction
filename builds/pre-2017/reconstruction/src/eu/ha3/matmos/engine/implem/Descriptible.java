/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.matmos.engine.implem;

import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.DTD;

public abstract class Descriptible {
    public String nickname = "";
    public String description = "";
    public String icon = "";
    public String meta = "";

    public abstract String serialize(XMLEventWriter var1) throws XMLStreamException;

    public String toString() {
        return "[(" + this.getClass().toString() + ") " + this.nickname + "]";
    }

    protected void buildDescriptibleSerialized(XMLEventWriter xMLEventWriter) throws XMLStreamException {
        XMLEventFactory xMLEventFactory = XMLEventFactory.newInstance();
        DTD dTD = xMLEventFactory.createDTD("\n");
        DTD dTD2 = xMLEventFactory.createDTD("\t");
        xMLEventWriter.add(dTD2);
        xMLEventWriter.add(xMLEventFactory.createStartElement("", "", "descriptible"));
        xMLEventWriter.add(dTD);
        this.createNode(xMLEventWriter, "nickname", this.nickname, 2);
        this.createNode(xMLEventWriter, "description", this.description, 2);
        this.createNode(xMLEventWriter, "icon", this.icon, 2);
        this.createNode(xMLEventWriter, "meta", this.meta, 2);
        xMLEventWriter.add(dTD2);
        xMLEventWriter.add(xMLEventFactory.createEndElement("", "", "descriptible"));
        xMLEventWriter.add(dTD);
    }

    protected void createNode(XMLEventWriter xMLEventWriter, String string, String string2, int n) throws XMLStreamException {
        XMLEventFactory xMLEventFactory = XMLEventFactory.newInstance();
        DTD dTD = xMLEventFactory.createDTD("\t");
        DTD dTD2 = xMLEventFactory.createDTD("\n");
        for (int i = 0; i < n; ++i) {
            xMLEventWriter.add(dTD);
        }
        xMLEventWriter.add(xMLEventFactory.createStartElement("", "", string));
        xMLEventWriter.add(xMLEventFactory.createCharacters(string2));
        xMLEventWriter.add(xMLEventFactory.createEndElement("", "", string));
        xMLEventWriter.add(dTD2);
    }

    protected void createNode(XMLEventWriter xMLEventWriter, String string, String string2) throws XMLStreamException {
        this.createNode(xMLEventWriter, string, string2, 1);
    }
}

