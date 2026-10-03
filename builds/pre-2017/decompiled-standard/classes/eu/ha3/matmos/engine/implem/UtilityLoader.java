/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.matmos.engine.implem;

import eu.ha3.matmos.engine.implem.Condition;
import eu.ha3.matmos.engine.implem.ConditionSet;
import eu.ha3.matmos.engine.implem.Descriptible;
import eu.ha3.matmos.engine.implem.Dynamic;
import eu.ha3.matmos.engine.implem.Event;
import eu.ha3.matmos.engine.implem.Knowledge;
import eu.ha3.matmos.engine.implem.MAtmosException;
import eu.ha3.matmos.engine.implem.Machine;
import eu.ha3.matmos.engine.implem.Stream;
import eu.ha3.matmos.engine.implem.SugarList;
import eu.ha3.matmos.engine.implem.TimedEvent;
import javax.xml.xpath.XPathExpressionException;
import net.sf.practicalxml.DomUtil;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class UtilityLoader {
    Knowledge knowledgeWorkstation;
    static final String NAME = "name";
    static final String DESCRIPTIBLE = "descriptible";
    static final String NICKNAME = "nickname";
    static final String DESCRIPTION = "description";
    static final String ICON = "icon";
    static final String META = "meta";
    static final String LIST = "list";
    static final String CONDITION = "condition";
    static final String SHEET = "sheet";
    static final String KEY = "key";
    static final String DYNAMICKEY = "dynamickey";
    static final String SYMBOL = "symbol";
    static final String CONSTANT = "constant";
    static final String SET = "set";
    static final String TRUEPART = "truepart";
    static final String FALSEPART = "falsepart";
    static final String EVENT = "event";
    static final String VOLMIN = "volmin";
    static final String VOLMAX = "volmax";
    static final String PITCHMIN = "pitchmin";
    static final String PITCHMAX = "pitchmax";
    static final String METASOUND = "metasound";
    static final String PATH = "path";
    static final String MACHINE = "machine";
    static final String ALLOW = "allow";
    static final String RESTRICT = "restrict";
    static final String DYNAMIC = "dynamic";
    static final String ENTRY = "entry";
    static final String EVENTTIMED = "eventtimed";
    static final String EVENTNAME = "eventname";
    static final String VOLMOD = "volmod";
    static final String PITCHMOD = "pitchmod";
    static final String DELAYSTART = "delaystart";
    static final String DELAYMIN = "delaymin";
    static final String DELAYMAX = "delaymax";
    static final String STREAM = "stream";
    static final String VOLUME = "volume";
    static final String PITCH = "pitch";
    static final String FADEINTIME = "fadeintime";
    static final String FADEOUTTIME = "fadeouttime";
    static final String DELAYBEFOREFADEIN = "delaybeforefadein";
    static final String DELAYBEFOREFADEOUT = "delaybeforefadeout";
    static final String ISLOOPING = "islooping";
    static final String ISUSINGPAUSE = "isusingpause";

    private UtilityLoader() {
    }

    public static UtilityLoader getInstance() {
        return MAtmosUtilityLoaderSingletonHolder.instance;
    }

    public boolean loadKnowledge(Knowledge knowledge, Document document, boolean bl) throws MAtmosException {
        try {
            this.parseXML(knowledge, document, bl);
            return true;
        }
        catch (XPathExpressionException xPathExpressionException) {
            xPathExpressionException.printStackTrace();
            return false;
        }
        catch (NumberFormatException numberFormatException) {
            numberFormatException.printStackTrace();
            return false;
        }
    }

    private int toInt(String string) {
        try {
            return Integer.parseInt(string);
        }
        catch (NumberFormatException numberFormatException) {
            return (int)Float.parseFloat(string);
        }
    }

    private void extractXMLdescriptible(Knowledge knowledge, Element element, Descriptible descriptible) throws XPathExpressionException {
        Element element2 = DomUtil.getChild(element, DESCRIPTIBLE);
        if (element2 != null) {
            this.parseXMLdescriptible(knowledge, element2, descriptible);
        }
    }

    private void parseXMLdescriptible(Knowledge knowledge, Element element, Descriptible descriptible) throws XPathExpressionException {
        if (element == null) {
            return;
        }
        String string = this.eltString(NICKNAME, element);
        String string2 = this.eltString(DESCRIPTION, element);
        String string3 = this.eltString(ICON, element);
        String string4 = this.eltString(META, element);
        if (string != null) {
            descriptible.nickname = string;
        }
        if (string2 != null) {
            descriptible.description = string2;
        }
        if (string3 != null) {
            descriptible.icon = string3;
        }
        if (string4 != null) {
            descriptible.meta = string4;
        }
    }

    private void parseXMLdynamic(Knowledge knowledge, Element element, String string, boolean bl) throws XPathExpressionException {
        boolean bl2;
        boolean bl3 = bl2 = knowledge.getDynamic(string) != null;
        if (bl2 && !bl) {
            return;
        }
        if (!bl2) {
            knowledge.addDynamic(string);
        }
        Dynamic dynamic = knowledge.getDynamic(string);
        this.extractXMLdescriptible(knowledge, element, dynamic);
        for (Element element2 : DomUtil.getChildren(element, ENTRY)) {
            Node node = element2.getAttributes().getNamedItem(SHEET);
            if (node == null) continue;
            dynamic.addCouple(node.getNodeValue(), Integer.parseInt(element2.getTextContent()));
        }
    }

    private void parseXMLlist(Knowledge knowledge, Element element, String string, boolean bl) throws XPathExpressionException {
        boolean bl2;
        boolean bl3 = bl2 = knowledge.getList(string) != null;
        if (bl2 && !bl) {
            return;
        }
        if (!bl2) {
            knowledge.addList(string);
        }
        SugarList sugarList = knowledge.getList(string);
        this.extractXMLdescriptible(knowledge, element, sugarList);
        for (Element element2 : DomUtil.getChildren(element, CONSTANT)) {
            String string2 = this.textOf(element2);
            sugarList.add(this.toInt(string2));
        }
    }

    private void parseXMLcondition(Knowledge knowledge, Element element, String string, boolean bl) throws XPathExpressionException {
        boolean bl2;
        boolean bl3 = bl2 = knowledge.getCondition(string) != null;
        if (bl2 && !bl) {
            return;
        }
        if (!bl2) {
            knowledge.addCondition(string);
        }
        Condition condition = knowledge.getCondition(string);
        this.extractXMLdescriptible(knowledge, element, condition);
        String string2 = this.eltString(SHEET, element);
        String string3 = this.eltString(KEY, element);
        String string4 = this.eltString(DYNAMICKEY, element);
        String string5 = this.eltString(SYMBOL, element);
        String string6 = this.eltString(CONSTANT, element);
        String string7 = this.eltString(LIST, element);
        if (string2 != null) {
            condition.setSheet(string2);
        }
        if (string3 != null) {
            condition.setKey(this.toInt(string3));
        }
        if (string4 != null && !string4.equals("")) {
            condition.setDynamic(string4);
        }
        if (string5 != null) {
            condition.setSymbol(string5);
        }
        if (string6 != null) {
            condition.setConstant(this.toInt(string6));
        }
        if (string7 != null) {
            condition.setList(string7);
        }
    }

    private void parseXMLset(Knowledge knowledge, Element element, String string, boolean bl) throws XPathExpressionException {
        String string2;
        boolean bl2;
        boolean bl3 = bl2 = knowledge.getConditionSet(string) != null;
        if (bl2 && !bl) {
            return;
        }
        if (!bl2) {
            knowledge.addConditionSet(string);
        }
        ConditionSet conditionSet = knowledge.getConditionSet(string);
        this.extractXMLdescriptible(knowledge, element, conditionSet);
        for (Element element2 : DomUtil.getChildren(element, TRUEPART)) {
            string2 = this.textOf(element2);
            conditionSet.addCondition(string2, true);
        }
        for (Element element2 : DomUtil.getChildren(element, FALSEPART)) {
            string2 = this.textOf(element2);
            conditionSet.addCondition(string2, false);
        }
    }

    private void parseXMLevent(Knowledge knowledge, Element element, String string, boolean bl) throws XPathExpressionException {
        boolean bl2;
        boolean bl3 = bl2 = knowledge.getEvent(string) != null;
        if (bl2 && !bl) {
            return;
        }
        if (!bl2) {
            knowledge.addEvent(string);
        }
        Event event = knowledge.getEvent(string);
        this.extractXMLdescriptible(knowledge, element, event);
        String string2 = this.eltString(VOLMIN, element);
        String string3 = this.eltString(VOLMAX, element);
        String string4 = this.eltString(PITCHMIN, element);
        String string5 = this.eltString(PITCHMAX, element);
        String string6 = this.eltString(METASOUND, element);
        if (string2 != null) {
            event.volMin = Float.parseFloat(string2);
        }
        if (string3 != null) {
            event.volMax = Float.parseFloat(string3);
        }
        if (string4 != null) {
            event.pitchMin = Float.parseFloat(string4);
        }
        if (string5 != null) {
            event.pitchMax = Float.parseFloat(string5);
        }
        if (string6 != null) {
            event.metaSound = this.toInt(string6);
        }
        for (Element element2 : DomUtil.getChildren(element, PATH)) {
            String string7 = this.textOf(element2);
            event.paths.add(string7);
        }
    }

    private void parseXMLmachine(Knowledge knowledge, Element element, String string, boolean bl) throws XPathExpressionException {
        int n;
        boolean bl2;
        boolean bl3 = bl2 = knowledge.getMachine(string) != null;
        if (bl2 && !bl) {
            return;
        }
        if (!bl2) {
            knowledge.addMachine(string);
        }
        Machine machine = knowledge.getMachine(string);
        this.extractXMLdescriptible(knowledge, element, machine);
        for (Element element2 : DomUtil.getChildren(element, EVENTTIMED)) {
            n = machine.addEventTimed();
            this.inscriptXMLeventTimed(machine.getEventTimed(n - 1), element2);
        }
        for (Element element2 : DomUtil.getChildren(element, STREAM)) {
            n = machine.addStream();
            this.inscriptXMLstream(machine.getStream(n - 1), element2);
        }
        for (Element element2 : DomUtil.getChildren(element, ALLOW)) {
            machine.addAllow(this.textOf(element2));
        }
        for (Element element2 : DomUtil.getChildren(element, RESTRICT)) {
            machine.addRestrict(this.textOf(element2));
        }
    }

    private void inscriptXMLeventTimed(TimedEvent timedEvent, Element element) throws XPathExpressionException {
        String string = this.eltString(EVENTNAME, element);
        String string2 = this.eltString(VOLMOD, element);
        String string3 = this.eltString(PITCHMOD, element);
        String string4 = this.eltString(DELAYSTART, element);
        String string5 = this.eltString(DELAYMIN, element);
        String string6 = this.eltString(DELAYMAX, element);
        if (string != null) {
            timedEvent.event = string;
        }
        if (string2 != null) {
            timedEvent.volMod = Float.parseFloat(string2);
        }
        if (string3 != null) {
            timedEvent.pitchMod = Float.parseFloat(string3);
        }
        if (string4 != null) {
            timedEvent.delayStart = Float.parseFloat(string4);
        }
        if (string5 != null) {
            timedEvent.delayMin = Float.parseFloat(string5);
        }
        if (string6 != null) {
            timedEvent.delayMax = Float.parseFloat(string6);
        }
    }

    private void inscriptXMLstream(Stream stream, Element element) throws XPathExpressionException {
        String string = this.eltString(PATH, element);
        String string2 = this.eltString(VOLUME, element);
        String string3 = this.eltString(PITCH, element);
        String string4 = this.eltString(FADEINTIME, element);
        String string5 = this.eltString(FADEOUTTIME, element);
        String string6 = this.eltString(DELAYBEFOREFADEIN, element);
        String string7 = this.eltString(DELAYBEFOREFADEOUT, element);
        String string8 = this.eltString(ISLOOPING, element);
        String string9 = this.eltString(ISUSINGPAUSE, element);
        if (string != null) {
            stream.path = string;
        }
        if (string2 != null) {
            stream.volume = Float.parseFloat(string2);
        }
        if (string3 != null) {
            stream.pitch = Float.parseFloat(string3);
        }
        if (string4 != null) {
            stream.fadeInTime = Float.parseFloat(string4);
        }
        if (string5 != null) {
            stream.fadeOutTime = Float.parseFloat(string5);
        }
        if (string6 != null) {
            stream.delayBeforeFadeIn = Float.parseFloat(string6);
        }
        if (string7 != null) {
            stream.delayBeforeFadeOut = Float.parseFloat(string7);
        }
        if (string8 != null) {
            boolean bl = stream.isLooping = this.toInt(string8) == 1;
        }
        if (string9 != null) {
            stream.isUsingPause = this.toInt(string9) == 1;
        }
    }

    private void parseXML(Knowledge knowledge, Document document, boolean bl) throws XPathExpressionException, DOMException {
        Node node;
        Node node2;
        int n;
        Element element = document.getDocumentElement();
        DomUtil.removeEmptyTextRecursive(element);
        Object object = element.getElementsByTagName(DYNAMIC);
        for (n = 0; n < object.getLength(); ++n) {
            node2 = (Element)object.item(n);
            node = node2.getAttributes().getNamedItem(NAME);
            if (node == null) continue;
            this.parseXMLdynamic(knowledge, (Element)node2, node.getNodeValue(), bl);
        }
        object = element.getElementsByTagName(LIST);
        for (n = 0; n < object.getLength(); ++n) {
            node2 = (Element)object.item(n);
            node = node2.getAttributes().getNamedItem(NAME);
            if (node == null) continue;
            this.parseXMLlist(knowledge, (Element)node2, node.getNodeValue(), bl);
        }
        for (Element element2 : DomUtil.getChildren(element, CONDITION)) {
            node2 = element2.getAttributes().getNamedItem(NAME);
            if (node2 == null) continue;
            this.parseXMLcondition(knowledge, element2, node2.getNodeValue(), bl);
        }
        object = element.getElementsByTagName(SET);
        for (n = 0; n < object.getLength(); ++n) {
            node2 = (Element)object.item(n);
            node = node2.getAttributes().getNamedItem(NAME);
            if (node == null) continue;
            this.parseXMLset(knowledge, (Element)node2, node.getNodeValue(), bl);
        }
        object = element.getElementsByTagName(EVENT);
        for (n = 0; n < object.getLength(); ++n) {
            node2 = (Element)object.item(n);
            node = node2.getAttributes().getNamedItem(NAME);
            if (node == null) continue;
            this.parseXMLevent(knowledge, (Element)node2, node.getNodeValue(), bl);
        }
        object = element.getElementsByTagName(MACHINE);
        for (n = 0; n < object.getLength(); ++n) {
            node2 = (Element)object.item(n);
            node = node2.getAttributes().getNamedItem(NAME);
            if (node == null) continue;
            this.parseXMLmachine(knowledge, (Element)node2, node.getNodeValue(), bl);
        }
    }

    private String eltString(String string, Element element) {
        return this.textOf(DomUtil.getChild(element, string));
    }

    private String textOf(Element element) {
        if (element == null || element.getFirstChild() == null) {
            return null;
        }
        return element.getFirstChild().getNodeValue();
    }

    private static class MAtmosUtilityLoaderSingletonHolder {
        public static final UtilityLoader instance = new UtilityLoader();

        private MAtmosUtilityLoaderSingletonHolder() {
        }
    }
}

