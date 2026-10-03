/*
 * Decompiled with CFR 0.152.
 */
package net.sf.practicalxml;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.validation.Schema;
import net.sf.kdgcommons.io.IOUtil;
import net.sf.practicalxml.XmlException;
import net.sf.practicalxml.util.ExceptionErrorHandler;
import org.w3c.dom.Document;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class ParseUtil {
    public static Document parse(InputSource inputSource, ErrorHandler errorHandler) {
        DocumentBuilder documentBuilder = ParseUtil.newNVDocumentBuilder();
        if (errorHandler != null) {
            documentBuilder.setErrorHandler(errorHandler);
        }
        try {
            return documentBuilder.parse(inputSource);
        }
        catch (IOException iOException) {
            throw new XmlException("unable to parse", iOException);
        }
        catch (SAXException sAXException) {
            throw new XmlException("unable to parse", sAXException);
        }
    }

    public static Document parse(InputSource inputSource) {
        return ParseUtil.parse(inputSource, new ExceptionErrorHandler());
    }

    public static Document parse(String string) {
        return ParseUtil.parse(new InputSource(new StringReader(string)));
    }

    public static Document parse(File file) {
        Document document;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            document = ParseUtil.parse(new InputSource(fileInputStream));
        }
        catch (IOException iOException) {
            try {
                throw new XmlException("unable to parse: " + file, iOException);
            }
            catch (Throwable throwable) {
                IOUtil.closeQuietly(fileInputStream);
                throw throwable;
            }
        }
        IOUtil.closeQuietly(fileInputStream);
        return document;
    }

    public static Document validatingParse(InputSource inputSource, EntityResolver entityResolver, ErrorHandler errorHandler) {
        DocumentBuilder documentBuilder = ParseUtil.newDTDDocumentBuilder();
        if (entityResolver != null) {
            documentBuilder.setEntityResolver(entityResolver);
        }
        if (errorHandler != null) {
            documentBuilder.setErrorHandler(errorHandler);
        }
        try {
            return documentBuilder.parse(inputSource);
        }
        catch (IOException iOException) {
            throw new XmlException("unable to parse", iOException);
        }
        catch (SAXException sAXException) {
            throw new XmlException("unable to parse", sAXException);
        }
    }

    public static Document validatingParse(InputSource inputSource, ErrorHandler errorHandler) {
        return ParseUtil.validatingParse(inputSource, (EntityResolver)null, errorHandler);
    }

    public static Document validatingParse(InputSource inputSource, Schema schema, ErrorHandler errorHandler) {
        DocumentBuilder documentBuilder = ParseUtil.newXSDDocumentBuilder(schema);
        if (errorHandler != null) {
            documentBuilder.setErrorHandler(errorHandler);
        }
        try {
            return documentBuilder.parse(inputSource);
        }
        catch (IOException iOException) {
            throw new XmlException("unable to parse", iOException);
        }
        catch (SAXException sAXException) {
            throw new XmlException("unable to parse", sAXException);
        }
    }

    public static Document parseFromClasspath(String string) {
        return ParseUtil.parseFromClasspath(string, ParseUtil.class);
    }

    public static Document parseFromClasspath(String string, Class<?> clazz) {
        return ParseUtil.parseFromClasspath(string, clazz, new ExceptionErrorHandler());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static Document parseFromClasspath(String string, Class<?> clazz, ErrorHandler errorHandler) {
        Document document;
        InputStream inputStream = null;
        try {
            ClassLoader classLoader = clazz.getClassLoader();
            inputStream = classLoader.getResourceAsStream(string);
            document = ParseUtil.parse(new InputSource(inputStream), errorHandler);
        }
        catch (Throwable throwable) {
            IOUtil.closeQuietly(inputStream);
            throw throwable;
        }
        IOUtil.closeQuietly(inputStream);
        return document;
    }

    private static synchronized DocumentBuilder newNVDocumentBuilder() {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilderFactory.setNamespaceAware(true);
        documentBuilderFactory.setCoalescing(true);
        documentBuilderFactory.setValidating(false);
        try {
            return documentBuilderFactory.newDocumentBuilder();
        }
        catch (ParserConfigurationException parserConfigurationException) {
            throw new XmlException("unable to confiure parser", parserConfigurationException);
        }
    }

    private static synchronized DocumentBuilder newDTDDocumentBuilder() {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilderFactory.setNamespaceAware(true);
        documentBuilderFactory.setValidating(true);
        documentBuilderFactory.setCoalescing(true);
        try {
            return documentBuilderFactory.newDocumentBuilder();
        }
        catch (ParserConfigurationException parserConfigurationException) {
            throw new XmlException("unable to confiure parser", parserConfigurationException);
        }
    }

    private static synchronized DocumentBuilder newXSDDocumentBuilder(Schema schema) {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilderFactory.setNamespaceAware(true);
        documentBuilderFactory.setCoalescing(true);
        documentBuilderFactory.setValidating(false);
        documentBuilderFactory.setSchema(schema);
        try {
            return documentBuilderFactory.newDocumentBuilder();
        }
        catch (ParserConfigurationException parserConfigurationException) {
            throw new XmlException("unable to configure parser", parserConfigurationException);
        }
    }
}

