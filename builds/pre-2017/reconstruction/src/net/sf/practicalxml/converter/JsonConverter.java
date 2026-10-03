/*
 * Decompiled with CFR 0.152.
 */
package net.sf.practicalxml.converter;

import net.sf.practicalxml.converter.json.Json2XmlConverter;
import net.sf.practicalxml.converter.json.Json2XmlOptions;
import net.sf.practicalxml.converter.json.Xml2JsonConverter;
import net.sf.practicalxml.converter.json.Xml2JsonOptions;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class JsonConverter {
    public static Document convertToXml(String string, String string2, String string3, Json2XmlOptions ... json2XmlOptionsArray) {
        return new Json2XmlConverter(string, json2XmlOptionsArray).convert().getOwnerDocument();
    }

    public static Document convertToXml(String string, String string2, Json2XmlOptions ... json2XmlOptionsArray) {
        return new Json2XmlConverter(string, json2XmlOptionsArray).convert().getOwnerDocument();
    }

    public static void convertToXml(String string, Element element, Json2XmlOptions ... json2XmlOptionsArray) {
        new Json2XmlConverter(string, json2XmlOptionsArray).convert(element);
    }

    public static String convertToJson(Document document, Xml2JsonOptions ... xml2JsonOptionsArray) {
        return JsonConverter.convertToJson(document.getDocumentElement(), xml2JsonOptionsArray);
    }

    public static String convertToJson(Element element, Xml2JsonOptions ... xml2JsonOptionsArray) {
        return JsonConverter.convertToJson(element, new StringBuilder(256), xml2JsonOptionsArray).toString();
    }

    public static StringBuilder convertToJson(Element element, StringBuilder stringBuilder, Xml2JsonOptions ... xml2JsonOptionsArray) {
        return new Xml2JsonConverter(xml2JsonOptionsArray).convert(element, stringBuilder);
    }
}

