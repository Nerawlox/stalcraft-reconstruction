/*
 * Decompiled with CFR 0.152.
 */
package net.sf.practicalxml.converter.json;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.sf.practicalxml.DomUtil;
import net.sf.practicalxml.converter.internal.JsonUtils;
import net.sf.practicalxml.converter.internal.TypeUtils;
import net.sf.practicalxml.converter.json.Xml2JsonOptions;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class Xml2JsonConverter {
    private static Set<String> _unquotedXsd = new HashSet<String>();
    private EnumSet<Xml2JsonOptions> _options = EnumSet.noneOf(Xml2JsonOptions.class);

    public Xml2JsonConverter(Xml2JsonOptions ... xml2JsonOptionsArray) {
        for (Xml2JsonOptions xml2JsonOptions : xml2JsonOptionsArray) {
            this._options.add(xml2JsonOptions);
        }
    }

    public String convert(Element element) {
        return this.convert(element, new StringBuilder(256)).toString();
    }

    public StringBuilder convert(Element element, StringBuilder stringBuilder) {
        if (this._options.contains((Object)Xml2JsonOptions.WRAP_WITH_PARENS)) {
            stringBuilder.append("(");
            this.append(stringBuilder, element);
            stringBuilder.append(")");
        } else {
            this.append(stringBuilder, element);
        }
        return stringBuilder;
    }

    private StringBuilder append(StringBuilder stringBuilder, Element element) {
        if (this.isSimple(element)) {
            if (stringBuilder.length() == 0) {
                stringBuilder.append("{}");
            } else {
                this.appendText(stringBuilder, element);
            }
        } else {
            stringBuilder.append("{");
            this.appendAttributes(stringBuilder, element);
            this.appendChildren(stringBuilder, element);
            stringBuilder.append("}");
        }
        return stringBuilder;
    }

    private void appendText(StringBuilder stringBuilder, Element element) {
        String string = DomUtil.getText(element);
        String string2 = TypeUtils.getTypeValue(element);
        String string3 = "\"";
        if (this._options.contains((Object)Xml2JsonOptions.USE_XSI_TYPE) && _unquotedXsd.contains(string2)) {
            string3 = "";
        }
        stringBuilder.append(string3).append(JsonUtils.escape(string)).append(string3);
    }

    private void appendAttributes(StringBuilder stringBuilder, Element element) {
        if (!this._options.contains((Object)Xml2JsonOptions.CONVERT_ATTRIBUTES) && !this._options.contains((Object)Xml2JsonOptions.CONVERT_ATTRIBUTES_MATCH_NAMESPACE)) {
            return;
        }
        NamedNodeMap namedNodeMap = element.getAttributes();
        if (namedNodeMap == null) {
            return;
        }
        for (int i = 0; i < namedNodeMap.getLength(); ++i) {
            Attr attr = (Attr)namedNodeMap.item(i);
            if (!this.isConvertableAttribute(element, attr)) continue;
            this.appendCommaIfNeeded(stringBuilder);
            this.appendFieldName(stringBuilder, DomUtil.getLocalName(attr));
            stringBuilder.append("\"").append(JsonUtils.escape(attr.getValue())).append("\"");
        }
    }

    private void appendChildren(StringBuilder stringBuilder, Element element) {
        ArrayList<String> arrayList = new ArrayList<String>();
        HashMap<String, List<Element>> hashMap = new HashMap<String, List<Element>>();
        HashMap<String, Element> hashMap2 = new HashMap<String, Element>();
        this.categorizeChildren(element, arrayList, hashMap, hashMap2);
        Iterator iterator2 = arrayList.iterator();
        while (iterator2.hasNext()) {
            this.appendCommaIfNeeded(stringBuilder);
            String string = (String)iterator2.next();
            this.appendFieldName(stringBuilder, string);
            if (hashMap.containsKey(string)) {
                this.appendArray(stringBuilder, (List)hashMap.get(string));
                continue;
            }
            this.append(stringBuilder, (Element)hashMap2.get(string));
        }
    }

    private void appendArray(StringBuilder stringBuilder, List<Element> list) {
        stringBuilder.append("[");
        Iterator<Element> iterator2 = list.iterator();
        while (iterator2.hasNext()) {
            Element element = iterator2.next();
            this.append(stringBuilder, element);
            if (!iterator2.hasNext()) continue;
            stringBuilder.append(", ");
        }
        stringBuilder.append("]");
    }

    private void appendFieldName(StringBuilder stringBuilder, String string) {
        if (this._options.contains((Object)Xml2JsonOptions.UNQUOTED_FIELD_NAMES)) {
            stringBuilder.append(string);
        } else {
            stringBuilder.append('\"').append(string).append('\"');
        }
        stringBuilder.append(": ");
    }

    private void appendCommaIfNeeded(StringBuilder stringBuilder) {
        for (int i = stringBuilder.length() - 1; i >= 0; --i) {
            char c = stringBuilder.charAt(i);
            if (c == '{') {
                return;
            }
            if (c == ' ') continue;
            stringBuilder.append(", ");
            return;
        }
    }

    private void categorizeChildren(Element element, List<String> list, Map<String, List<Element>> map, Map<String, Element> map2) {
        for (Element element2 : DomUtil.getChildren(element)) {
            List<Element> list2;
            String string = DomUtil.getLocalName(element2);
            if (!map.containsKey(string) && !map2.containsKey(string)) {
                list.add(string);
            }
            if (map.containsKey(string)) {
                this.getArray(string, map).add(element2);
                continue;
            }
            if (map2.containsKey(string)) {
                list2 = this.getArray(string, map);
                Element element3 = map2.remove(string);
                list2.add(element3);
                list2.add(element2);
                continue;
            }
            if (this.isArrayParent(element2)) {
                list2 = this.getArray(string, map);
                for (Element element4 : DomUtil.getChildren(element2)) {
                    list2.add(element4);
                }
                continue;
            }
            map2.put(string, element2);
        }
    }

    private List<Element> getArray(String string, Map<String, List<Element>> map) {
        List<Element> list = map.get(string);
        if (list == null) {
            list = new ArrayList<Element>();
            map.put(string, list);
        }
        return list;
    }

    private boolean isSimple(Element element) {
        Object object;
        if (this._options.contains((Object)Xml2JsonOptions.CONVERT_ATTRIBUTES) && (object = element.getAttributes()) != null && object.getLength() > 0) {
            return false;
        }
        for (object = element.getFirstChild(); object != null; object = object.getNextSibling()) {
            if (!(object instanceof Element)) continue;
            return false;
        }
        return true;
    }

    private boolean isArrayParent(Element element) {
        if (!this._options.contains((Object)Xml2JsonOptions.USE_XSI_TYPE)) {
            return false;
        }
        Class<?> clazz = TypeUtils.getType(element, false);
        if (clazz == null) {
            return false;
        }
        if (clazz.isArray()) {
            return true;
        }
        if (List.class.isAssignableFrom(clazz)) {
            return true;
        }
        return Set.class.isAssignableFrom(clazz);
    }

    private boolean isConvertableAttribute(Element element, Attr attr) {
        String string;
        String string2 = element.getNamespaceURI() != null ? element.getNamespaceURI() : "";
        String string3 = string = attr.getNamespaceURI() != null ? attr.getNamespaceURI() : "";
        if (this._options.contains((Object)Xml2JsonOptions.CONVERT_ATTRIBUTES_MATCH_NAMESPACE) && !string2.equals(string)) {
            return false;
        }
        return !string.equals("http://www.w3.org/2001/XMLSchema-instance") && !string.equals("http://practicalxml.sourceforge.net/Converter");
    }

    static {
        _unquotedXsd.add("xsd:boolean");
        _unquotedXsd.add("xsd:byte");
        _unquotedXsd.add("xsd:decimal");
        _unquotedXsd.add("xsd:double");
        _unquotedXsd.add("xsd:float");
        _unquotedXsd.add("xsd:int");
        _unquotedXsd.add("xsd:integer");
        _unquotedXsd.add("xsd:long");
        _unquotedXsd.add("xsd:negativeInteger");
        _unquotedXsd.add("xsd:nonNegativeInteger");
        _unquotedXsd.add("xsd:nonPositiveInteger");
        _unquotedXsd.add("xsd:positiveInteger");
        _unquotedXsd.add("xsd:short");
        _unquotedXsd.add("xsd:unsignedByte");
        _unquotedXsd.add("xsd:unsignedInt");
        _unquotedXsd.add("xsd:unsignedLong");
        _unquotedXsd.add("xsd:unsignedShort");
    }
}

