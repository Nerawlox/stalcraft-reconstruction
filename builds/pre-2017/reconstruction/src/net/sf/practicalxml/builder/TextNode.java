/*
 * Decompiled with CFR 0.152.
 */
package net.sf.practicalxml.builder;

import net.sf.practicalxml.DomUtil;
import net.sf.practicalxml.builder.Node;
import org.w3c.dom.Element;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

public class TextNode
extends Node {
    private static final long serialVersionUID = 1L;
    private String _content;

    public TextNode(String string) {
        this._content = string;
    }

    protected void appendToElement(Element element) {
        DomUtil.appendText(element, this._content);
    }

    protected void toSAX(ContentHandler contentHandler) throws SAXException {
        contentHandler.characters(this._content.toCharArray(), 0, this._content.length());
    }
}

