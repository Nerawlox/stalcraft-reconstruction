/*
 * Decompiled with CFR 0.152.
 */
package net.sf.practicalxml.util;

import java.util.ArrayList;
import java.util.List;
import net.sf.practicalxml.XmlException;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class ExceptionErrorHandler
implements ErrorHandler {
    private List<SAXParseException> _warnings = new ArrayList<SAXParseException>();

    @Override
    public void error(SAXParseException sAXParseException) throws SAXException {
        throw new XmlException("unable to parse", sAXParseException);
    }

    @Override
    public void fatalError(SAXParseException sAXParseException) throws SAXException {
        throw new XmlException("unable to parse", sAXParseException);
    }

    @Override
    public void warning(SAXParseException sAXParseException) throws SAXException {
        this._warnings.add(sAXParseException);
    }

    public List<SAXParseException> getWarnings() {
        return this._warnings;
    }
}

