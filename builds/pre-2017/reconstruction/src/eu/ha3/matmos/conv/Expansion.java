/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.matmos.conv;

import eu.ha3.easy.TimeStatistic;
import eu.ha3.matmos.conv.CustomVolume;
import eu.ha3.matmos.conv.ExpansionError;
import eu.ha3.matmos.conv.MAtmosConvLogger;
import eu.ha3.matmos.engine.implem.Event;
import eu.ha3.matmos.engine.implem.Knowledge;
import eu.ha3.matmos.engine.implem.MAtmosException;
import eu.ha3.matmos.engine.implem.UtilityLoader;
import eu.ha3.matmos.engine.interfaces.Data;
import eu.ha3.matmos.engine.interfaces.SoundRelay;
import eu.ha3.matmos.requirem.Collation;
import eu.ha3.matmos.requirem.RequiremForAKnowledge;
import eu.ha3.matmos.requirem.Requirements;
import eu.ha3.util.property.simple.ConfigProperty;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.Locale;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import net.sf.practicalxml.DomUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Expansion
implements CustomVolume {
    private DocumentBuilder documentBuilder;
    private Document document;
    private Knowledge knowledge;
    private String userDefinedIdentifier;
    private String docName;
    private String docDescription;
    private boolean isReady;
    private ExpansionError error;
    private boolean hasStructure;
    private int dataFrequency;
    private int dataCyclic;
    private SoundRelay soundManager;
    private ConfigProperty myConfiguration;
    private String friendlyName;
    private boolean isBuilding;
    private Requirements requirements;
    private Collation collation;

    public Expansion(String string, File file) {
        this.userDefinedIdentifier = string;
        this.isReady = false;
        this.hasStructure = false;
        this.error = ExpansionError.NO_DOCUMENT;
        this.docName = string;
        this.docDescription = "";
        this.knowledge = new Knowledge();
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        this.dataFrequency = 1;
        this.dataCyclic = 0;
        this.myConfiguration = new ConfigProperty();
        this.myConfiguration.setProperty("volume", Float.valueOf(1.0f));
        this.myConfiguration.setProperty("friendlyname", "");
        this.myConfiguration.commit();
        try {
            this.myConfiguration.setSource(file.getCanonicalPath());
            this.myConfiguration.load();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        this.friendlyName = this.myConfiguration.getString("friendlyname");
        if (this.friendlyName.equals("")) {
            this.friendlyName = string;
        }
        try {
            this.documentBuilder = documentBuilderFactory.newDocumentBuilder();
        }
        catch (ParserConfigurationException parserConfigurationException) {
            parserConfigurationException.printStackTrace();
            throw new RuntimeException();
        }
    }

    public String getFriendlyName() {
        return this.friendlyName;
    }

    public void setSoundManager(SoundRelay soundRelay) {
        this.knowledge.setSoundManager(soundRelay);
        this.soundManager = soundRelay;
        this.setVolume(this.myConfiguration.getFloat("volume"));
    }

    public void setData(Data data) {
        this.knowledge.setData(data);
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

    public void inputStructure(InputStream inputStream) {
        this.hasStructure = false;
        try {
            this.document = this.documentBuilder.parse(inputStream);
            NodeList nodeList = this.document.getElementsByTagName("expansion");
            if (nodeList.getLength() == 1) {
                Element element = (Element)nodeList.item(0);
                String string = this.eltString("name", element);
                String string2 = this.eltString("description", element);
                String string3 = this.eltString("data", element);
                if (string != null) {
                    this.docName = string;
                }
                if (string2 != null) {
                    this.docDescription = string2;
                }
                if (string3 != null) {
                    try {
                        this.dataFrequency = Integer.parseInt(string3);
                        if (this.dataFrequency < 1) {
                            this.dataFrequency = 1;
                        }
                        MAtmosConvLogger.fine("Set " + this.userDefinedIdentifier + " frequency to " + this.dataFrequency);
                    }
                    catch (NumberFormatException numberFormatException) {
                        // empty catch block
                    }
                }
            }
            this.hasStructure = true;
        }
        catch (SAXException sAXException) {
            this.error = ExpansionError.COULD_NOT_PARSE_XML;
            sAXException.printStackTrace();
        }
        catch (IOException iOException) {
            this.error = ExpansionError.COULD_NOT_PARSE_XML;
            iOException.printStackTrace();
        }
    }

    public void buildKnowledge() {
        if (this.document == null) {
            return;
        }
        if (!this.hasStructure) {
            return;
        }
        try {
            this.knowledge.patchKnowledge();
            this.isReady = UtilityLoader.getInstance().loadKnowledge(this.knowledge, this.document, false);
            this.requirements = new RequiremForAKnowledge(this.knowledge);
        }
        catch (MAtmosException mAtmosException) {
            this.error = ExpansionError.COULD_NOT_MAKE_KNOWLEDGE;
            mAtmosException.printStackTrace();
        }
    }

    public void soundRoutine() {
        if (this.isReady) {
            this.knowledge.soundRoutine();
            this.soundManager.routine();
        }
    }

    public void dataRoutine() {
        if (this.isReady) {
            if (this.dataFrequency > 1) {
                if (this.dataCyclic == 0) {
                    this.knowledge.dataRoutine();
                }
                this.dataCyclic = (this.dataCyclic + 1) % this.dataFrequency;
            } else {
                this.knowledge.dataRoutine();
            }
        }
    }

    public void playSample() {
        if (!this.isRunning()) {
            return;
        }
        Event event = this.knowledge.getEvent("__SAMPLE");
        if (event != null) {
            event.playSound(1.0f, 1.0f);
        }
    }

    public ExpansionError getError() {
        return this.error;
    }

    public String getUserDefinedName() {
        return this.userDefinedIdentifier;
    }

    public String getName() {
        return this.docName;
    }

    public String getDescription() {
        return this.docDescription;
    }

    public boolean isRunning() {
        return this.knowledge.isTurnedOn();
    }

    public void saveConfig() {
        if (this.myConfiguration.commit()) {
            this.myConfiguration.save();
        }
    }

    public boolean isReady() {
        return this.isReady;
    }

    public boolean hasStructure() {
        return this.hasStructure;
    }

    public void turnOn() {
        if (this.isRunning()) {
            return;
        }
        if (this.getVolume() <= 0.0f) {
            return;
        }
        if (this.isBuilding) {
            return;
        }
        if (!this.isReady && this.hasStructure) {
            this.isBuilding = true;
            TimeStatistic timeStatistic = new TimeStatistic(Locale.ENGLISH);
            this.buildKnowledge();
            this.knowledge.cacheSounds();
            MAtmosConvLogger.info("Expansion " + this.getUserDefinedName() + " loaded (" + timeStatistic.getSecondsAsString(3) + "s).");
            this.isBuilding = false;
        }
        if (this.isReady) {
            this.knowledge.turnOn();
            this.collation.addRequirements(this.userDefinedIdentifier, this.requirements);
        }
    }

    public void turnOff() {
        if (!this.isReady || !this.isRunning()) {
            return;
        }
        this.knowledge.turnOff();
        this.collation.removeRequirements(this.userDefinedIdentifier);
    }

    @Override
    public float getVolume() {
        if (this.soundManager instanceof CustomVolume) {
            return ((CustomVolume)((Object)this.soundManager)).getVolume();
        }
        return 1.0f;
    }

    @Override
    public void setVolume(float f) {
        if (this.soundManager instanceof CustomVolume) {
            ((CustomVolume)((Object)this.soundManager)).setVolume(f);
            this.myConfiguration.setProperty("volume", Float.valueOf(this.getVolume()));
        }
    }

    public String getDocumentStringForm() {
        if (this.document == null) {
            return null;
        }
        StringWriter stringWriter = new StringWriter();
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(new DOMSource(this.document), new StreamResult(stringWriter));
        }
        catch (TransformerConfigurationException transformerConfigurationException) {
            transformerConfigurationException.printStackTrace();
        }
        catch (TransformerFactoryConfigurationError transformerFactoryConfigurationError) {
            transformerFactoryConfigurationError.printStackTrace();
        }
        catch (TransformerException transformerException) {
            transformerException.printStackTrace();
        }
        return stringWriter.toString();
    }

    public void clear() {
        this.turnOff();
        this.knowledge.patchKnowledge();
        this.collation.removeRequirements(this.userDefinedIdentifier);
        this.isReady = false;
    }

    public void setCollation(Collation collation) {
        this.collation = collation;
    }
}

