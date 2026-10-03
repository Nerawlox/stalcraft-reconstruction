/*
 * Decompiled with CFR 0.152.
 */
package net.sf.practicalxml;

import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamResult;
import net.sf.practicalxml.DomUtil;
import net.sf.practicalxml.XmlException;
import net.sf.practicalxml.internal.TransformerFactoryHelper;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.XMLReader;

public class OutputUtil {
    public static String elementToString(Element element) {
        return OutputUtil.appendElementString(new StringBuilder(256), element).toString();
    }

    public static String treeToString(Element element, int n) {
        return OutputUtil.appendTreeString(new StringBuilder(1024), element, n, 0).toString();
    }

    public static void compact(Source source, Result result) {
        TransformerFactoryHelper transformerFactoryHelper = new TransformerFactoryHelper();
        OutputUtil.transform(transformerFactoryHelper, source, result);
    }

    public static void indented(Source source, Result result, int n) {
        TransformerFactoryHelper transformerFactoryHelper = new TransformerFactoryHelper().setIndent(n);
        OutputUtil.transform(transformerFactoryHelper, source, result);
    }

    public static String compactString(Document document) {
        StringWriter stringWriter = new StringWriter();
        OutputUtil.compact(new DOMSource(document), new StreamResult(stringWriter));
        return stringWriter.toString();
    }

    public static String compactString(XMLReader xMLReader) {
        StringWriter stringWriter = new StringWriter();
        OutputUtil.compact(new SAXSource(xMLReader, null), new StreamResult(stringWriter));
        return stringWriter.toString();
    }

    public static String indentedString(Document document, int n) {
        StringWriter stringWriter = new StringWriter();
        OutputUtil.indented(new DOMSource(document), new StreamResult(stringWriter), n);
        return stringWriter.toString();
    }

    public static String indentedString(XMLReader xMLReader, int n) {
        StringWriter stringWriter = new StringWriter();
        OutputUtil.indented(new SAXSource(xMLReader, null), new StreamResult(stringWriter), n);
        return stringWriter.toString();
    }

    public static void compactStream(Document document, OutputStream outputStream) {
        OutputUtil.compact(new DOMSource(document), new StreamResult(outputStream));
        OutputUtil.flushStream(outputStream);
    }

    public static void compactStream(XMLReader xMLReader, OutputStream outputStream) {
        OutputUtil.compact(new SAXSource(xMLReader, null), new StreamResult(outputStream));
        OutputUtil.flushStream(outputStream);
    }

    public static void compactStream(Document document, OutputStream outputStream, String string) {
        TransformerFactoryHelper transformerFactoryHelper = new TransformerFactoryHelper().setPrologue(string);
        OutputUtil.transform(transformerFactoryHelper, new DOMSource(document), new StreamResult(outputStream));
        OutputUtil.flushStream(outputStream);
    }

    public static void compactStream(XMLReader xMLReader, OutputStream outputStream, String string) {
        TransformerFactoryHelper transformerFactoryHelper = new TransformerFactoryHelper().setPrologue(string);
        OutputUtil.transform(transformerFactoryHelper, new SAXSource(xMLReader, null), new StreamResult(outputStream));
        OutputUtil.flushStream(outputStream);
    }

    private static StringBuilder appendElementString(StringBuilder stringBuilder, Element element) {
        String string = element.getNamespaceURI();
        String string2 = DomUtil.getLocalName(element);
        return stringBuilder.append("{").append(string != null ? string : "").append("}").append(string2);
    }

    private static StringBuilder appendTreeString(StringBuilder stringBuilder, Element element, int n, int n2) {
        if (stringBuilder.length() > 0) {
            stringBuilder.append("\n");
        }
        for (int i = 0; i < n2; ++i) {
            stringBuilder.append(" ");
        }
        OutputUtil.appendElementString(stringBuilder, element);
        for (Element element2 : DomUtil.getChildren(element)) {
            OutputUtil.appendTreeString(stringBuilder, element2, n, n2 + n);
        }
        return stringBuilder;
    }

    private static void flushStream(OutputStream outputStream) {
        try {
            outputStream.flush();
        }
        catch (IOException iOException) {
            throw new XmlException("unable to generate output", iOException);
        }
    }

    private static void transform(TransformerFactoryHelper transformerFactoryHelper, Source source, Result result) {
        Transformer transformer = transformerFactoryHelper.newTransformer();
        try {
            transformer.transform(source, result);
        }
        catch (TransformerException transformerException) {
            throw new XmlException("unable to generate output", transformerException);
        }
    }
}

