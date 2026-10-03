/*
 * Decompiled with CFR 0.152.
 */
package net.sf.practicalxml.builder;

import net.sf.practicalxml.builder.Node;
import org.w3c.dom.Comment;
import org.w3c.dom.Element;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.ext.LexicalHandler;

public class CommentNode
extends Node {
    private static final long serialVersionUID = 1L;
    private String _content;

    public CommentNode(String string) {
        this._content = string;
    }

    protected void appendToElement(Element element) {
        Comment comment = element.getOwnerDocument().createComment(this._content);
        element.appendChild(comment);
    }

    protected void toSAX(ContentHandler contentHandler) throws SAXException {
        if (contentHandler instanceof LexicalHandler) {
            ((LexicalHandler)((Object)contentHandler)).comment(this._content.toCharArray(), 0, this._content.length());
        }
    }
}

