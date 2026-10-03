/*
 * Decompiled with CFR 0.152.
 */
package net.sf.practicalxml.builder;

import net.sf.practicalxml.builder.AttributeNode;
import net.sf.practicalxml.builder.CommentNode;
import net.sf.practicalxml.builder.ElementNode;
import net.sf.practicalxml.builder.Node;
import net.sf.practicalxml.builder.PINode;
import net.sf.practicalxml.builder.TextNode;

public class XmlBuilder {
    public static ElementNode element(String string, String string2, Node ... nodeArray) {
        return new ElementNode(string, string2, nodeArray);
    }

    public static ElementNode element(String string, Node ... nodeArray) {
        return XmlBuilder.element(null, string, nodeArray);
    }

    public static Node text(String string) {
        return new TextNode(string);
    }

    public static Node attribute(String string, String string2, String string3) {
        return new AttributeNode(string, string2, string3);
    }

    public static Node attribute(String string, String string2) {
        return new AttributeNode(null, string, string2);
    }

    public static Node comment(String string) {
        return new CommentNode(string);
    }

    public static Node processingInstruction(String string, String string2) {
        return new PINode(string, string2);
    }
}

