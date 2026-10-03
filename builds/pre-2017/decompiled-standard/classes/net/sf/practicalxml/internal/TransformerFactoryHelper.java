/*
 * Decompiled with CFR 0.152.
 */
package net.sf.practicalxml.internal;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import net.sf.practicalxml.XmlException;

public class TransformerFactoryHelper {
    private TransformerFactory _factory;
    private boolean _usePrologue;
    private String _encoding;
    private boolean _indent;
    private int _indentLevel;

    public TransformerFactoryHelper setPrologue() {
        this._factory = null;
        this._usePrologue = true;
        return this;
    }

    public TransformerFactoryHelper setPrologue(String string) {
        this._factory = null;
        this._usePrologue = true;
        this._encoding = string;
        return this;
    }

    public TransformerFactoryHelper setIndent(int n) {
        this._factory = null;
        this._indent = true;
        this._indentLevel = n;
        return this;
    }

    public Transformer newTransformer() {
        try {
            if (this._factory == null) {
                this._factory = TransformerFactory.newInstance();
                this.configIndent(this._factory);
            }
            Transformer transformer = this._factory.newTransformer();
            this.configIndent(transformer);
            this.configPrologue(transformer);
            return transformer;
        }
        catch (Exception exception) {
            throw new XmlException("unable to configure transformer", exception);
        }
    }

    private void configPrologue(Transformer transformer) {
        transformer.setOutputProperty("omit-xml-declaration", this._usePrologue ? "no" : "yes");
        if (this._encoding != null) {
            transformer.setOutputProperty("encoding", this._encoding);
        }
    }

    private void configIndent(TransformerFactory transformerFactory) {
        if (!this._indent) {
            return;
        }
        transformerFactory.setAttribute("indent-number", this._indentLevel);
    }

    private void configIndent(Transformer transformer) {
        transformer.setOutputProperty("indent", this._indent ? "yes" : "no");
    }
}

