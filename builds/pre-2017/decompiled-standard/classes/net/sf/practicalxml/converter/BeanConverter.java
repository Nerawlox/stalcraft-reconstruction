/*
 * Decompiled with CFR 0.152.
 */
package net.sf.practicalxml.converter;

import net.sf.practicalxml.converter.bean.Bean2XmlConverter;
import net.sf.practicalxml.converter.bean.Bean2XmlOptions;
import net.sf.practicalxml.converter.bean.Xml2BeanConverter;
import net.sf.practicalxml.converter.bean.Xml2BeanOptions;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class BeanConverter {
    public static Document convertToXml(Object object, String string, String string2, Bean2XmlOptions ... bean2XmlOptionsArray) {
        return new Bean2XmlConverter(bean2XmlOptionsArray).convert(object, string, string2).getOwnerDocument();
    }

    public static Document convertToXml(Object object, String string, Bean2XmlOptions ... bean2XmlOptionsArray) {
        return new Bean2XmlConverter(bean2XmlOptionsArray).convert(object, string).getOwnerDocument();
    }

    public static <T> T convertToJava(Document document, Class<T> clazz, Xml2BeanOptions ... xml2BeanOptionsArray) {
        return BeanConverter.convertToJava(document.getDocumentElement(), clazz, xml2BeanOptionsArray);
    }

    public static <T> T convertToJava(Element element, Class<T> clazz, Xml2BeanOptions ... xml2BeanOptionsArray) {
        return new Xml2BeanConverter(xml2BeanOptionsArray).convert(element, clazz);
    }
}

