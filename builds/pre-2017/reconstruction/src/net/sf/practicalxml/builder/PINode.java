/*
 * Decompiled with CFR 0.152.
 */
package net.sf.practicalxml.builder;

import net.sf.practicalxml.builder.Node;
import org.w3c.dom.Element;
import org.w3c.dom.ProcessingInstruction;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

public class PINode
extends Node {
    private static final long serialVersionUID = 1L;
    private String _target;
    private String _data;

    public PINode(String string, String string2) {
        this._target = string;
        this._data = string2;
    }

    protected void appendToElement(Element element) {
        ProcessingInstruction processingInstruction = element.getOwnerDocument().createProcessingInstruction(this._target, this._data);
        element.appendChild(processingInstruction);
    }

    protected void toSAX(ContentHandler contentHandler) throws SAXException {
        contentHandler.processingInstruction(this._target, this._data);
    }
}

