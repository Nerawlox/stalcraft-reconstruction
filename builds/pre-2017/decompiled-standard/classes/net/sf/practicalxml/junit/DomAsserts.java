/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  junit.framework.Assert
 */
package net.sf.practicalxml.junit;

import java.util.List;
import junit.framework.Assert;
import net.sf.practicalxml.DomUtil;
import net.sf.practicalxml.xpath.XPathWrapper;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class DomAsserts {
    public static void assertName(String string, Element element) {
        Assert.assertEquals((String)string, (String)DomUtil.getLocalName(element));
    }

    public static void assertName(String string, String string2, Element element) {
        Assert.assertEquals((String)string, (String)string2, (String)DomUtil.getLocalName(element));
    }

    public static void assertNamespaceAndName(String string, String string2, Element element) {
        Assert.assertEquals((String)"invalid namespace", (String)string, (String)element.getNamespaceURI());
        Assert.assertEquals((String)"invalid localname", (String)string2, (String)DomUtil.getLocalName(element));
    }

    public static void assertNamespaceAndName(String string, String string2, String string3, Element element) {
        Assert.assertEquals((String)string, (String)string2, (String)element.getNamespaceURI());
        Assert.assertEquals((String)string, (String)string3, (String)DomUtil.getLocalName(element));
    }

    public static void assertExists(Node node, String string) {
        DomAsserts.assertExists(string, node, string);
    }

    public static void assertExists(String string, Node node, String string2) {
        DomAsserts.assertExists(string, node, new XPathWrapper(string2));
    }

    public static void assertExists(Node node, XPathWrapper xPathWrapper) {
        DomAsserts.assertExists(xPathWrapper.toString(), node, xPathWrapper);
    }

    public static void assertExists(String string, Node node, XPathWrapper xPathWrapper) {
        List<Node> list = xPathWrapper.evaluate(node);
        Assert.assertTrue((String)string, (list.size() > 0 ? 1 : 0) != 0);
    }

    public static void assertCount(int n, Node node, String string) {
        DomAsserts.assertCount(string, n, node, string);
    }

    public static void assertCount(String string, int n, Node node, String string2) {
        DomAsserts.assertCount(string, n, node, new XPathWrapper(string2));
    }

    public static void assertCount(int n, Node node, XPathWrapper xPathWrapper) {
        DomAsserts.assertCount(xPathWrapper.toString(), n, node, xPathWrapper);
    }

    public static void assertCount(String string, int n, Node node, XPathWrapper xPathWrapper) {
        List<Node> list = xPathWrapper.evaluate(node);
        Assert.assertEquals((String)string, (int)n, (int)list.size());
    }

    public static void assertEquals(String string, Node node, String string2) {
        DomAsserts.assertEquals(string2, string, node, new XPathWrapper(string2));
    }

    public static void assertEquals(String string, String string2, Node node, String string3) {
        DomAsserts.assertEquals(string, string2, node, new XPathWrapper(string3));
    }

    public static void assertEquals(String string, Node node, XPathWrapper xPathWrapper) {
        DomAsserts.assertEquals(xPathWrapper.toString(), string, node, xPathWrapper);
    }

    public static void assertEquals(String string, String string2, Node node, XPathWrapper xPathWrapper) {
        Assert.assertEquals((String)string, (String)string2, (String)xPathWrapper.evaluateAsString(node));
    }
}

