/*
 * Decompiled with CFR 0.152.
 */
package net.sf.practicalxml.builder;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import net.sf.practicalxml.DomUtil;
import net.sf.practicalxml.OutputUtil;
import net.sf.practicalxml.builder.AttributeNode;
import net.sf.practicalxml.builder.Node;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;
import org.xml.sax.helpers.XMLFilterImpl;

public final class ElementNode
extends Node {
    private static final long serialVersionUID = 2L;
    private String _nsUri;
    private String _qname;
    private String _lclName;
    private List<AttributeNode> _attribs = new ArrayList<AttributeNode>();
    private List<Node> _children = new ArrayList<Node>();

    ElementNode(String string, String string2, Node ... nodeArray) {
        this._nsUri = string;
        this._qname = string2;
        this._lclName = ElementNode.getLocalName(string2);
        for (Node node : nodeArray) {
            this.addChild(node);
        }
    }

    public ElementNode addChild(Node node) {
        if (node instanceof AttributeNode) {
            this._attribs.add((AttributeNode)node);
        } else if (node != null) {
            this._children.add(node);
        }
        return this;
    }

    public Document toDOM() {
        Element element = DomUtil.newDocument(this._nsUri, this._qname);
        this.appendChildren(element);
        return element.getOwnerDocument();
    }

    protected void toSAX(ContentHandler contentHandler) throws SAXException {
        contentHandler.startElement(this._nsUri, this._lclName, this._qname, this.getAttributes());
        for (Node node : this._children) {
            node.toSAX(contentHandler);
        }
        contentHandler.endElement(this._nsUri, this._lclName, this._qname);
    }

    public String toString() {
        return OutputUtil.compactString(new SerializationHelper());
    }

    public String toString(int n) {
        return OutputUtil.indentedString(new SerializationHelper(), n);
    }

    public void toStream(OutputStream outputStream) {
        OutputUtil.compactStream(new SerializationHelper(), outputStream);
    }

    public void toStream(OutputStream outputStream, String string) {
        OutputUtil.compactStream(this.toDOM(), outputStream, string);
    }

    protected void appendToElement(Element element) {
        this.appendChildren(DomUtil.appendChild(element, this._nsUri, this._qname));
    }

    private void appendChildren(Element element) {
        for (AttributeNode node : this._attribs) {
            ((Node)node).appendToElement(element);
        }
        for (Node node : this._children) {
            node.appendToElement(element);
        }
    }

    private Attributes getAttributes() {
        AttributesImpl attributesImpl = new AttributesImpl();
        for (AttributeNode attributeNode : this._attribs) {
            attributeNode.appendToAttributes(attributesImpl);
        }
        return attributesImpl;
    }

    private class SerializationHelper
    extends XMLFilterImpl {
        private SerializationHelper() {
        }

        public void parse(InputSource inputSource) throws IOException, SAXException {
            this.startDocument();
            ElementNode.this.toSAX(this.getContentHandler());
            this.endDocument();
        }
    }
}

