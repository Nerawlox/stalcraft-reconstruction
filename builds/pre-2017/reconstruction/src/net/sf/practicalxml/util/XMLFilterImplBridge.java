/*
 * Decompiled with CFR 0.152.
 */
package net.sf.practicalxml.util;

import java.io.IOException;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLFilterImpl;

public class XMLFilterImplBridge
extends DefaultHandler {
    private XMLFilterImpl _filter;

    public XMLFilterImplBridge(XMLFilterImpl xMLFilterImpl) {
        this._filter = xMLFilterImpl;
    }

    public void characters(char[] cArray, int n, int n2) throws SAXException {
        this._filter.characters(cArray, n, n2);
    }

    public void endDocument() throws SAXException {
        this._filter.endDocument();
    }

    public void endElement(String string, String string2, String string3) throws SAXException {
        this._filter.endElement(string, string2, string3);
    }

    public void endPrefixMapping(String string) throws SAXException {
        this._filter.endPrefixMapping(string);
    }

    public void error(SAXParseException sAXParseException) throws SAXException {
        this._filter.error(sAXParseException);
    }

    public void fatalError(SAXParseException sAXParseException) throws SAXException {
        this._filter.fatalError(sAXParseException);
    }

    public void ignorableWhitespace(char[] cArray, int n, int n2) throws SAXException {
        this._filter.ignorableWhitespace(cArray, n, n2);
    }

    public void notationDecl(String string, String string2, String string3) throws SAXException {
        this._filter.notationDecl(string, string2, string3);
    }

    public void processingInstruction(String string, String string2) throws SAXException {
        this._filter.processingInstruction(string, string2);
    }

    public InputSource resolveEntity(String string, String string2) throws IOException, SAXException {
        return this._filter.resolveEntity(string, string2);
    }

    public void setDocumentLocator(Locator locator) {
        this._filter.setDocumentLocator(locator);
    }

    public void skippedEntity(String string) throws SAXException {
        this._filter.skippedEntity(string);
    }

    public void startDocument() throws SAXException {
        this._filter.startDocument();
    }

    public void startElement(String string, String string2, String string3, Attributes attributes) throws SAXException {
        this._filter.startElement(string, string2, string3, attributes);
    }

    public void startPrefixMapping(String string, String string2) throws SAXException {
        this._filter.startPrefixMapping(string, string2);
    }

    public void unparsedEntityDecl(String string, String string2, String string3, String string4) throws SAXException {
        this._filter.unparsedEntityDecl(string, string2, string3, string4);
    }

    public void warning(SAXParseException sAXParseException) throws SAXException {
        this._filter.warning(sAXParseException);
    }
}

