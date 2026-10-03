/*
 * Decompiled with CFR 0.152.
 */
package net.sf.practicalxml.xpath.function;

import net.sf.practicalxml.xpath.AbstractFunction;
import org.w3c.dom.Node;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class Lowercase
extends AbstractFunction<String> {
    public Lowercase() {
        super("http://practicalxml.sourceforge.net/", "lowercase", 1);
    }

    @Override
    protected String processArg(int n, Node node, String string) throws Exception {
        return node != null ? this.processArg(n, node.getTextContent(), string) : "";
    }

    @Override
    protected String processArg(int n, String string, String string2) throws Exception {
        return string.toLowerCase();
    }

    @Override
    protected String processNullArg(int n, String string) throws Exception {
        return "";
    }
}

