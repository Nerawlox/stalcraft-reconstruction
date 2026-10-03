/*
 * Decompiled with CFR 0.152.
 */
package net.sf.practicalxml.xpath;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.xml.namespace.NamespaceContext;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class SimpleNamespaceResolver
implements NamespaceContext {
    private final String _prefix;
    private final String _nsURI;
    private final List<String> _prefixes;

    public SimpleNamespaceResolver(String string, String string2) {
        if (string == null) {
            throw new IllegalArgumentException("prefix may not be null");
        }
        if (string2 == null) {
            throw new IllegalArgumentException("nsURI may not be null");
        }
        this._prefix = string;
        this._nsURI = string2;
        this._prefixes = Arrays.asList(string);
    }

    @Override
    public String getNamespaceURI(String string) {
        if (string == null) {
            throw new IllegalArgumentException("prefix may not be null");
        }
        if (this._prefix.equals(string)) {
            return this._nsURI;
        }
        if ("xml".equals(string)) {
            return "http://www.w3.org/XML/1998/namespace";
        }
        if ("xmlns".equals(string)) {
            return "http://www.w3.org/2000/xmlns/";
        }
        return null;
    }

    @Override
    public String getPrefix(String string) {
        if (string == null) {
            throw new IllegalArgumentException("nsURI may not be null");
        }
        if (string.equals(this._nsURI)) {
            return this._prefix;
        }
        if (string.equals("http://www.w3.org/XML/1998/namespace")) {
            return "xml";
        }
        if (string.equals("http://www.w3.org/2000/xmlns/")) {
            return "xmlns";
        }
        return null;
    }

    @Override
    public Iterator<String> getPrefixes(String string) {
        String string2 = this.getPrefix(string);
        if (this._prefix.equals(string2)) {
            return this._prefixes.iterator();
        }
        if (string2 == null) {
            return Collections.emptyList().iterator();
        }
        return Arrays.asList(string2).iterator();
    }

    public final boolean equals(Object object) {
        if (object instanceof SimpleNamespaceResolver) {
            SimpleNamespaceResolver simpleNamespaceResolver = (SimpleNamespaceResolver)object;
            return this._prefix.equals(simpleNamespaceResolver._prefix) && this._nsURI.equals(simpleNamespaceResolver._nsURI);
        }
        return false;
    }

    public int hashCode() {
        return this._prefix.hashCode() ^ this._nsURI.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(this._prefix.length() + this._nsURI.length() + 10);
        if ("".equals(this._prefix)) {
            stringBuilder.append("xmlns=\"").append(this._nsURI).append("\"");
        } else {
            stringBuilder.append("xmlns:").append(this._prefix).append("=\"").append(this._nsURI).append("\"");
        }
        return stringBuilder.toString();
    }
}

