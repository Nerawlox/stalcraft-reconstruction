/*
 * Decompiled with CFR 0.152.
 */
package net.sf.practicalxml.util;

import java.io.IOException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import net.sf.practicalxml.XmlException;
import net.sf.practicalxml.util.XMLFilterImplBridge;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLFilterImpl;

public class SimpleXMLReader
extends XMLFilterImpl {
    private SAXParser _parser;

    public SimpleXMLReader() {
        try {
            this._parser = SAXParserFactory.newInstance().newSAXParser();
        }
        catch (Exception exception) {
            throw new XmlException(exception);
        }
    }

    public SimpleXMLReader(SAXParser sAXParser) {
        this._parser = sAXParser;
    }

    public void parse(InputSource inputSource) throws IOException, SAXException {
        this._parser.parse(inputSource, (DefaultHandler)new XMLFilterImplBridge(this));
    }

    public void parse(String string) throws IOException, SAXException {
        this._parser.parse(string, (DefaultHandler)new XMLFilterImplBridge(this));
    }
}

