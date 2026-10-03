/*
 * Decompiled with CFR 0.152.
 */
package net.sf.practicalxml.xpath.function;

import net.sf.practicalxml.xpath.AbstractFunction;
import org.w3c.dom.Node;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class XsiBoolean
extends AbstractFunction<Boolean> {
    public XsiBoolean() {
        super("http://practicalxml.sourceforge.net/", "boolean", 1);
    }

    @Override
    protected Boolean processArg(int n, Node node, Boolean bl) throws Exception {
        return node != null ? this.processArg(n, node.getTextContent(), bl) : Boolean.FALSE;
    }

    @Override
    protected Boolean processArg(int n, String string, Boolean bl) throws Exception {
        return "true".equals(string.toLowerCase()) || "1".equals(string);
    }

    @Override
    protected Boolean processArg(int n, Boolean bl, Boolean bl2) throws Exception {
        return bl;
    }

    @Override
    protected Boolean processArg(int n, Number number, Boolean bl) throws Exception {
        return number.intValue() == 1;
    }

    @Override
    protected Boolean processNullArg(int n, Boolean bl) throws Exception {
        return Boolean.FALSE;
    }
}

