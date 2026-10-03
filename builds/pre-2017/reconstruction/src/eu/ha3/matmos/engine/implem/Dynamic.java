/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.matmos.engine.implem;

import eu.ha3.matmos.engine.implem.Knowledge;
import eu.ha3.matmos.engine.implem.Switchable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.DTD;

public class Dynamic
extends Switchable {
    private List<String> sheets = new ArrayList<String>();
    private List<Integer> keys = new ArrayList<Integer>();
    public int value = 0;

    public Dynamic(Knowledge knowledge) {
        super(knowledge);
    }

    public void addCouple(String string, int n) {
        this.sheets.add(string);
        this.keys.add(n);
        this.flagNeedsTesting();
    }

    public void removeCouple(int n) {
        this.sheets.remove(n);
        this.keys.remove(n);
        this.flagNeedsTesting();
    }

    public void setSheet(int n, String string) {
        this.sheets.set(n, string);
        this.flagNeedsTesting();
    }

    public void setKey(int n, int n2) {
        this.keys.set(n, n2);
        this.flagNeedsTesting();
    }

    public List<String> getSheets() {
        return this.sheets;
    }

    public List<Integer> getKeys() {
        return this.keys;
    }

    public String getSheet(int n) {
        return this.sheets.get(n);
    }

    public int getKey(int n) {
        return this.keys.get(n);
    }

    @Override
    public boolean isActive() {
        return false;
    }

    public void evaluate() {
        this.value = 0;
        if (!this.isValid()) {
            return;
        }
        Iterator<String> iterator2 = this.sheets.iterator();
        Iterator<Integer> iterator3 = this.keys.iterator();
        while (iterator2.hasNext()) {
            String string = iterator2.next();
            Integer n = iterator3.next();
            this.value += this.knowledge.getData().getSheet(string).get(n).intValue();
        }
    }

    @Override
    protected boolean testIfValid() {
        Iterator<String> iterator2 = this.sheets.iterator();
        Iterator<Integer> iterator3 = this.keys.iterator();
        while (iterator2.hasNext()) {
            String string = iterator2.next();
            Integer n = iterator3.next();
            if (this.knowledge.getData().getSheet(string) != null) {
                if (n >= 0 && n < this.knowledge.getData().getSheet(string).getSize()) continue;
                return false;
            }
            return false;
        }
        return true;
    }

    @Override
    public String serialize(XMLEventWriter xMLEventWriter) throws XMLStreamException {
        this.buildDescriptibleSerialized(xMLEventWriter);
        XMLEventFactory xMLEventFactory = XMLEventFactory.newInstance();
        DTD dTD = xMLEventFactory.createDTD("\t");
        DTD dTD2 = xMLEventFactory.createDTD("\n");
        for (int i = 0; i < this.sheets.size(); ++i) {
            xMLEventWriter.add(dTD);
            xMLEventWriter.add(xMLEventFactory.createStartElement("", "", "entry"));
            xMLEventWriter.add(xMLEventFactory.createAttribute("sheet", this.sheets.get(i)));
            xMLEventWriter.add(xMLEventFactory.createCharacters(this.keys.get(i) + ""));
            xMLEventWriter.add(xMLEventFactory.createEndElement("", "", "entry"));
            xMLEventWriter.add(dTD2);
        }
        return null;
    }
}

