/*
 * Decompiled with CFR 0.152.
 */
package net.sf.practicalxml;

import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeSet;
import javax.xml.transform.dom.DOMSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import net.sf.practicalxml.DomUtil;
import net.sf.practicalxml.ParseUtil;
import net.sf.practicalxml.XmlException;
import net.sf.practicalxml.util.ExceptionErrorHandler;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class SchemaUtil {
    private static final String NS_SCHEMA = "http://www.w3.org/2001/XMLSchema";
    private static final String EL_SCHEMA = "schema";
    private static final String EL_IMPORT = "import";
    private static final String ATTR_TARGET_NS = "targetNamespace";
    private static final String ATTR_IMPORT_NS = "namespace";
    private static final String ATTR_IMPORT_LOC = "schemaLocation";

    public static synchronized SchemaFactory newFactory(ErrorHandler errorHandler) {
        SchemaFactory schemaFactory = SchemaFactory.newInstance(NS_SCHEMA);
        schemaFactory.setErrorHandler(errorHandler);
        return schemaFactory;
    }

    public static Schema newSchema(InputSource ... inputSourceArray) {
        return SchemaUtil.newSchema(SchemaUtil.newFactory(new ExceptionErrorHandler()), inputSourceArray);
    }

    public static Schema newSchema(SchemaFactory schemaFactory, InputSource ... inputSourceArray) {
        return SchemaUtil.newSchema(schemaFactory, SchemaUtil.parseSources(inputSourceArray));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static Schema newSchema(SchemaFactory schemaFactory, Document ... documentArray) {
        try {
            SchemaFactory schemaFactory2 = schemaFactory;
            synchronized (schemaFactory2) {
                return schemaFactory.newSchema(SchemaUtil.toDOMSources(documentArray));
            }
        }
        catch (SAXException sAXException) {
            throw new XmlException("unable to generate schema", sAXException);
        }
    }

    public static Document[] combineSchemas(InputSource ... inputSourceArray) {
        return new SchemaManager(SchemaUtil.parseSources(inputSourceArray)).buildOutput();
    }

    public static Document[] parseSources(InputSource[] inputSourceArray) {
        int n;
        if (inputSourceArray.length == 0) {
            throw new IllegalArgumentException("must specify at least one source");
        }
        Document[] documentArray = new Document[inputSourceArray.length];
        for (n = 0; n < inputSourceArray.length; ++n) {
            try {
                documentArray[n] = ParseUtil.parse(inputSourceArray[n]);
                continue;
            }
            catch (XmlException xmlException) {
                throw new XmlException("unable to parse source " + n, xmlException.getCause());
            }
        }
        for (n = 0; n < documentArray.length; ++n) {
            if (DomUtil.isNamed(documentArray[n].getDocumentElement(), NS_SCHEMA, EL_SCHEMA)) continue;
            throw new XmlException("source " + n + " does not appear to be an XSD");
        }
        return documentArray;
    }

    private static DOMSource[] toDOMSources(Document[] documentArray) {
        DOMSource[] dOMSourceArray = new DOMSource[documentArray.length];
        for (int i = 0; i < documentArray.length; ++i) {
            dOMSourceArray[i] = new DOMSource(documentArray[i]);
        }
        return dOMSourceArray;
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    static class SchemaComparator
    implements Serializable,
    Comparator<Document> {
        private static final long serialVersionUID = 1L;

        SchemaComparator() {
        }

        @Override
        public int compare(Document document, Document document2) {
            Element element;
            String string;
            if (document == document2) {
                return 0;
            }
            Element element2 = document.getDocumentElement();
            String string2 = element2.getAttribute(SchemaUtil.ATTR_TARGET_NS);
            if (string2.equals(string = (element = document2.getDocumentElement()).getAttribute(SchemaUtil.ATTR_TARGET_NS))) {
                return 0;
            }
            if ("".equals(string2)) {
                return 1;
            }
            if ("".equals(string)) {
                return -1;
            }
            if (this.isImportedBy(string2, element)) {
                return -1;
            }
            if (this.isImportedBy(string, element2)) {
                return 1;
            }
            return string2.compareTo(string);
        }

        private boolean isImportedBy(String string, Element element) {
            for (Element element2 : DomUtil.getChildren(element, SchemaUtil.NS_SCHEMA, SchemaUtil.EL_IMPORT)) {
                if (!string.equals(element2.getAttribute(SchemaUtil.ATTR_IMPORT_NS))) continue;
                return true;
            }
            return false;
        }
    }

    static class SchemaManager {
        private HashMap<String, Document> _documents = new HashMap();

        public SchemaManager(Document[] documentArray) {
            for (int i = 0; i < documentArray.length; ++i) {
                String string = documentArray[i].getDocumentElement().getAttribute(SchemaUtil.ATTR_TARGET_NS);
                Document document = this._documents.get(string);
                if (document != null) {
                    this.merge(document, documentArray[i]);
                    continue;
                }
                this._documents.put(string, documentArray[i]);
            }
        }

        public Document[] buildOutput() {
            TreeSet<Document> treeSet = new TreeSet<Document>(new SchemaComparator());
            for (Document document : this._documents.values()) {
                treeSet.add(this.rebuildImports(document));
            }
            return treeSet.toArray(new Document[treeSet.size()]);
        }

        protected void merge(Document document, Document document2) {
            Element element = document.getDocumentElement();
            Element element2 = document2.getDocumentElement();
            for (Element element3 : DomUtil.getChildren(element2)) {
                Node node = document.importNode(element3, true);
                element.appendChild(node);
            }
        }

        protected Document rebuildImports(Document document) {
            Object object;
            String string;
            HashMap<String, String> hashMap = new HashMap<String, String>();
            Element element = document.getDocumentElement();
            for (Element object2 : DomUtil.getChildren(element, SchemaUtil.NS_SCHEMA, SchemaUtil.EL_IMPORT)) {
                string = object2.getAttribute(SchemaUtil.ATTR_IMPORT_NS);
                object = object2.getAttribute(SchemaUtil.ATTR_IMPORT_LOC);
                if (this._documents.containsKey(string)) {
                    object = null;
                }
                hashMap.put(string, (String)object);
                element.removeChild(object2);
            }
            for (String string2 : hashMap.keySet()) {
                string = (String)hashMap.get(string2);
                object = document.createElementNS(SchemaUtil.NS_SCHEMA, SchemaUtil.EL_IMPORT);
                object.setAttribute(SchemaUtil.ATTR_IMPORT_NS, string2);
                if (string != null) {
                    object.setAttribute(SchemaUtil.ATTR_IMPORT_LOC, string);
                }
                element.insertBefore((Node)object, element.getFirstChild());
            }
            return document;
        }
    }
}

