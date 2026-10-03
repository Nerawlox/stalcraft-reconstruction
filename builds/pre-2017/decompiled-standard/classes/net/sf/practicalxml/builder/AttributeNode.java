/*
 * Decompiled with CFR 0.152.
 */
package net.sf.practicalxml.builder;

import java.io.Serializable;
import net.sf.practicalxml.builder.Node;
import org.w3c.dom.Element;
import org.xml.sax.helpers.AttributesImpl;

public class AttributeNode
extends Node
implements Serializable {
    private static final long serialVersionUID = 2L;
    private String _nsUri;
    private String _qname;
    private String _lclName;
    private String _value;

    public AttributeNode(String string, String string2, String string3) {
        this._nsUri = string;
        this._qname = string2;
        this._lclName = AttributeNode.getLocalName(string2);
        this._value = string3;
    }

    protected void appendToElement(Element element) {
        if (this._nsUri == null) {
            element.setAttribute(this._qname, this._value);
        } else {
            element.setAttributeNS(this._nsUri, this._qname, this._value);
        }
    }

    protected void appendToAttributes(AttributesImpl attributesImpl) {
        attributesImpl.addAttribute(this._nsUri, this._lclName, this._qname, "", this._value);
    }
}

