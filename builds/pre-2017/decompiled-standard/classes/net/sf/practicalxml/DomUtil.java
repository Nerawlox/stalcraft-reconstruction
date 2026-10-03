/*
 * Decompiled with CFR 0.152.
 */
package net.sf.practicalxml;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.NamespaceContext;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import net.sf.kdgcommons.lang.StringUtil;
import net.sf.practicalxml.XmlException;
import net.sf.practicalxml.util.NodeListIterator;
import net.sf.practicalxml.xpath.NamespaceResolver;
import org.w3c.dom.Attr;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class DomUtil {
    private static volatile DocumentBuilder _docBuilder;

    public static Document newDocument() {
        return DomUtil.getDocumentBuilder().newDocument();
    }

    public static Element newDocument(String string, String string2) {
        Document document = DomUtil.getDocumentBuilder().newDocument();
        Element element = document.createElementNS(string, string2);
        document.appendChild(element);
        return element;
    }

    public static Element newDocument(String string) {
        return DomUtil.newDocument(null, string);
    }

    public static Element newDocument(QName qName) {
        String string;
        String string2 = qName.getNamespaceURI();
        if ("".equals(string2) || "".equals(string2)) {
            string2 = null;
        }
        if ("".equals(string = qName.getPrefix()) || "".equals(string)) {
            string = null;
        }
        String string3 = qName.getLocalPart();
        if (string != null) {
            string3 = string + ":" + string3;
        }
        return DomUtil.newDocument(string2, string3);
    }

    public static Element appendChild(Element element, String string) {
        return DomUtil.appendChild(element, null, string);
    }

    public static Element appendChild(Element element, String string, String string2) {
        Element element2 = element.getOwnerDocument().createElementNS(string, string2);
        element.appendChild(element2);
        return element2;
    }

    public static Element appendChildInheritNamespace(Element element, String string) {
        String string2 = element.getNamespaceURI();
        String string3 = element.getPrefix();
        if (string2 != null && string3 != null && string.indexOf(58) < 0) {
            string = string3 + ":" + string;
        }
        return DomUtil.appendChild(element, string2, string);
    }

    public static List<Element> getSiblings(Element element) {
        if (element.getParentNode() instanceof Element) {
            return DomUtil.getChildren((Element)element.getParentNode());
        }
        ArrayList<Element> arrayList = new ArrayList<Element>();
        arrayList.add(element);
        return arrayList;
    }

    public static List<Element> getSiblings(Element element, String string) {
        if (element.getParentNode() instanceof Element) {
            return DomUtil.getChildren((Element)element.getParentNode(), string);
        }
        return new ArrayList<Element>();
    }

    public static List<Element> getSiblings(Element element, String string, String string2) {
        if (element.getParentNode() instanceof Element) {
            return DomUtil.getChildren((Element)element.getParentNode(), string, string2);
        }
        return new ArrayList<Element>();
    }

    public static boolean hasChildren(Element element) {
        return element.getFirstChild() != null;
    }

    public static boolean hasElementChildren(Element element) {
        for (Node node = element.getFirstChild(); node != null; node = node.getNextSibling()) {
            if (!(node instanceof Element)) continue;
            return true;
        }
        return false;
    }

    public static boolean hasTextChildren(Element element) {
        for (Node node = element.getFirstChild(); node != null; node = node.getNextSibling()) {
            if (!(node instanceof Text) && !(node instanceof CDATASection)) continue;
            return true;
        }
        return false;
    }

    public static List<Element> getChildren(Node node) {
        return DomUtil.filter(node.getChildNodes(), Element.class);
    }

    public static List<Element> getChildren(Node node, String string) {
        ArrayList<Element> arrayList = new ArrayList<Element>();
        NodeListIterator nodeListIterator = new NodeListIterator(node.getChildNodes(), Element.class);
        while (nodeListIterator.hasNext()) {
            Element element = (Element)nodeListIterator.next();
            if (!string.equals(DomUtil.getLocalName(element))) continue;
            arrayList.add(element);
        }
        return arrayList;
    }

    public static List<Element> getChildren(Node node, String string, String string2) {
        ArrayList<Element> arrayList = new ArrayList<Element>();
        NodeListIterator nodeListIterator = new NodeListIterator(node.getChildNodes(), Element.class);
        while (nodeListIterator.hasNext()) {
            Element element = (Element)nodeListIterator.next();
            if (!DomUtil.isNamed(element, string, string2)) continue;
            arrayList.add(element);
        }
        return arrayList;
    }

    public static Element getChild(Node node, String string) {
        List<Element> list = DomUtil.getChildren(node, string);
        return list.size() > 0 ? list.get(0) : null;
    }

    public static Element getChild(Node node, String string, String string2) {
        List<Element> list = DomUtil.getChildren(node, string, string2);
        return list.size() > 0 ? list.get(0) : null;
    }

    public static List<Attr> getAttributes(Element element) {
        ArrayList<Attr> arrayList = new ArrayList<Attr>();
        NamedNodeMap namedNodeMap = element.getAttributes();
        for (int i = 0; i < namedNodeMap.getLength(); ++i) {
            arrayList.add((Attr)namedNodeMap.item(i));
        }
        return arrayList;
    }

    public static String getText(Element element) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean bl = false;
        NodeList nodeList = element.getChildNodes();
        block3: for (int i = 0; i < nodeList.getLength(); ++i) {
            Node node = nodeList.item(i);
            switch (node.getNodeType()) {
                case 3: 
                case 4: {
                    stringBuilder.append(node.getTextContent());
                    bl = true;
                    continue block3;
                }
            }
        }
        return bl ? stringBuilder.toString() : null;
    }

    public static Text appendText(Element element, String string) {
        Text text = element.getOwnerDocument().createTextNode(string);
        element.appendChild(text);
        return text;
    }

    public static void setText(Element element, String string) {
        NodeList nodeList = element.getChildNodes();
        block3: for (int i = nodeList.getLength() - 1; i >= 0; --i) {
            Node node = nodeList.item(i);
            switch (node.getNodeType()) {
                case 3: 
                case 4: {
                    element.removeChild(node);
                    continue block3;
                }
            }
        }
        DomUtil.appendText(element, string);
    }

    public static void trimTextRecursive(Node node) {
        NodeListIterator nodeListIterator = new NodeListIterator(node.getChildNodes());
        while (nodeListIterator.hasNext()) {
            Node node2 = (Node)nodeListIterator.next();
            switch (node2.getNodeType()) {
                case 1: {
                    DomUtil.trimTextRecursive((Element)node2);
                    break;
                }
                case 3: 
                case 4: {
                    String string = StringUtil.trim(((Text)node2).getData());
                    if (StringUtil.isEmpty(string)) {
                        nodeListIterator.remove();
                        break;
                    }
                    ((Text)node2).setData(string);
                    break;
                }
            }
        }
    }

    public static void removeEmptyTextRecursive(Node node) {
        NodeListIterator nodeListIterator = new NodeListIterator(node.getChildNodes());
        while (nodeListIterator.hasNext()) {
            Node node2 = (Node)nodeListIterator.next();
            switch (node2.getNodeType()) {
                case 1: {
                    DomUtil.removeEmptyTextRecursive((Element)node2);
                    break;
                }
                case 3: 
                case 4: {
                    if (!StringUtil.isBlank(node2.getNodeValue())) break;
                    nodeListIterator.remove();
                    break;
                }
            }
        }
    }

    public static void removeAllChildren(Node node) {
        Node node2 = node.getFirstChild();
        while (node2 != null) {
            Node node3 = node2.getNextSibling();
            node.removeChild(node2);
            node2 = node3;
        }
    }

    public static String getLocalName(Element element) {
        return element.getNamespaceURI() == null ? element.getTagName() : element.getLocalName();
    }

    public static String getLocalName(Attr attr) {
        return attr.getNamespaceURI() == null ? attr.getName() : attr.getLocalName();
    }

    public static boolean isNamed(Element element, String string, String string2) {
        if (string2 == null) {
            throw new IllegalArgumentException("localName must have a value");
        }
        if (string == null) {
            return element.getNamespaceURI() == null ? string2.equals(element.getTagName()) : false;
        }
        return string.equals(element.getNamespaceURI()) && string2.equals(element.getLocalName());
    }

    public static <T> List<T> asList(NodeList nodeList, Class<T> clazz) {
        int n = nodeList.getLength();
        ArrayList<T> arrayList = new ArrayList<T>(n);
        for (int i = 0; i < n; ++i) {
            arrayList.add(clazz.cast(nodeList.item(i)));
        }
        return arrayList;
    }

    public static <T> List<T> filter(NodeList nodeList, Class<T> clazz) {
        ArrayList<T> arrayList = new ArrayList<T>(nodeList.getLength());
        NodeListIterator nodeListIterator = new NodeListIterator(nodeList);
        while (nodeListIterator.hasNext()) {
            Node node = (Node)nodeListIterator.next();
            if (!clazz.isInstance(node)) continue;
            arrayList.add(clazz.cast(node));
        }
        return arrayList;
    }

    public static String getPath(Element element, String ... stringArray) {
        StringBuilder stringBuilder = new StringBuilder();
        DomUtil.buildPath(element, stringBuilder, stringArray);
        return stringBuilder.toString();
    }

    public static String getAbsolutePath(Element element) {
        StringBuilder stringBuilder = new StringBuilder();
        DomUtil.buildAbsolutePath(element, stringBuilder, null, null, null);
        return stringBuilder.toString();
    }

    public static String getAbsolutePath(Element element, NamespaceContext namespaceContext) {
        StringBuilder stringBuilder = new StringBuilder();
        DomUtil.buildAbsolutePath(element, stringBuilder, namespaceContext, new NamespaceResolver(), new int[]{0});
        return stringBuilder.toString();
    }

    public static String getAbsolutePath(Element element, NamespaceResolver namespaceResolver) {
        StringBuilder stringBuilder = new StringBuilder();
        DomUtil.buildAbsolutePath(element, stringBuilder, namespaceResolver, namespaceResolver, new int[]{0});
        return stringBuilder.toString();
    }

    private static DocumentBuilder getDocumentBuilder() {
        try {
            if (_docBuilder == null) {
                DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
                documentBuilderFactory.setNamespaceAware(true);
                _docBuilder = documentBuilderFactory.newDocumentBuilder();
            }
            return _docBuilder;
        }
        catch (ParserConfigurationException parserConfigurationException) {
            throw new XmlException("unable to configure DocumentBuilder", parserConfigurationException);
        }
    }

    private static void buildPath(Element element, StringBuilder stringBuilder, String[] stringArray) {
        Node node = element.getParentNode();
        if (node instanceof Element) {
            DomUtil.buildPath((Element)node, stringBuilder, stringArray);
        }
        stringBuilder.append("/").append(element.getNodeName());
        for (String string : stringArray) {
            String string2 = element.getAttribute(string);
            if (StringUtil.isEmpty(string2)) continue;
            stringBuilder.append("[").append(string).append("='").append(string2).append("']");
        }
    }

    private static void buildAbsolutePath(Element element, StringBuilder stringBuilder, NamespaceContext namespaceContext, NamespaceResolver namespaceResolver, int[] nArray) {
        Node node = element.getParentNode();
        if (node instanceof Element) {
            DomUtil.buildAbsolutePath((Element)node, stringBuilder, namespaceContext, namespaceResolver, nArray);
        }
        String string = DomUtil.getPrefix(element, namespaceContext, namespaceResolver, nArray);
        String string2 = DomUtil.getLocalName(element);
        List<Element> list = namespaceContext == null ? DomUtil.getSiblings(element, DomUtil.getLocalName(element)) : DomUtil.getSiblings(element, element.getNamespaceURI(), DomUtil.getLocalName(element));
        stringBuilder.append("/");
        if (string != null) {
            stringBuilder.append(string).append(":");
        }
        stringBuilder.append(string2);
        if (list.size() > 1) {
            stringBuilder.append("[").append(DomUtil.getIndex(element, list)).append("]");
        }
    }

    private static String getPrefix(Element element, NamespaceContext namespaceContext, NamespaceResolver namespaceResolver, int[] nArray) {
        if (namespaceContext == null) {
            return null;
        }
        String string = element.getNamespaceURI();
        if (string == null) {
            return null;
        }
        String string2 = namespaceContext.getPrefix(string);
        if (string2 != null) {
            return string2;
        }
        string2 = namespaceResolver.getPrefix(string);
        if (string2 != null) {
            return string2;
        }
        while (string2 == null) {
            int n = nArray[0];
            nArray[0] = n + 1;
            string2 = "NS" + n;
            if (namespaceContext.getNamespaceURI(string2) == null && namespaceResolver.getNamespaceURI(string2) == null) continue;
            string2 = null;
        }
        namespaceResolver.addNamespace(string2, string);
        return string2;
    }

    private static int getIndex(Element element, List<Element> list) {
        int n = 0;
        for (Element element2 : list) {
            ++n;
            if (element2 != element) continue;
            return n;
        }
        throw new IllegalArgumentException("element not amongst its siblings");
    }
}

