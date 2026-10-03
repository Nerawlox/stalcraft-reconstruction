/*
 * Decompiled with CFR 0.152.
 */
package net.sf.practicalxml.xpath;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import javax.xml.namespace.NamespaceContext;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class NamespaceResolver
implements NamespaceContext {
    private static final SortedSet<String> DEFAULT_PREFIXES = new TreeSet<String>();
    private static final SortedSet<String> XML_NS_URI_PREFIXES = new TreeSet<String>();
    private static final SortedSet<String> XML_NS_ATTR_PREFIXES = new TreeSet<String>();
    private TreeMap<String, String> _prefix2ns = new TreeMap();
    private Map<String, SortedSet<String>> _ns2prefix = new HashMap<String, SortedSet<String>>();
    private String _defaultNS = "";

    public NamespaceResolver addNamespace(String string, String string2) {
        if (string == null) {
            throw new IllegalArgumentException("prefix may not be null");
        }
        if (string2 == null) {
            throw new IllegalArgumentException("nsURI may not be null");
        }
        this._prefix2ns.put(string, string2);
        this.getPrefixSet(string2).add(string);
        return this;
    }

    public NamespaceResolver setDefaultNamespace(String string) {
        if (string == null) {
            throw new IllegalArgumentException("nsURI may not be null");
        }
        this._defaultNS = string;
        return this;
    }

    public String getDefaultNamespace() {
        return this._defaultNS;
    }

    public List<String> getAllPrefixes() {
        return new ArrayList<String>(this._prefix2ns.keySet());
    }

    @Override
    public String getNamespaceURI(String string) {
        if (string == null) {
            throw new IllegalArgumentException("prefix may not be null");
        }
        if ("".equals(string)) {
            return this._defaultNS;
        }
        if ("xml".equals(string)) {
            return "http://www.w3.org/XML/1998/namespace";
        }
        if ("xmlns".equals(string)) {
            return "http://www.w3.org/2000/xmlns/";
        }
        return this._prefix2ns.get(string);
    }

    @Override
    public String getPrefix(String string) {
        Iterator<String> iterator2 = this.getPrefixes(string);
        return iterator2.hasNext() ? iterator2.next() : null;
    }

    @Override
    public Iterator<String> getPrefixes(String string) {
        if (string == null) {
            throw new IllegalArgumentException("nsURI may not be null");
        }
        if (this._defaultNS.equals(string)) {
            return DEFAULT_PREFIXES.iterator();
        }
        if ("http://www.w3.org/XML/1998/namespace".equals(string)) {
            return XML_NS_URI_PREFIXES.iterator();
        }
        if ("http://www.w3.org/2000/xmlns/".equals(string)) {
            return XML_NS_ATTR_PREFIXES.iterator();
        }
        return this.getPrefixSet(string).iterator();
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof NamespaceResolver) {
            NamespaceResolver namespaceResolver = (NamespaceResolver)object;
            return this._prefix2ns.equals(namespaceResolver._prefix2ns) && this._defaultNS.equals(namespaceResolver._defaultNS);
        }
        return false;
    }

    public int hashCode() {
        return this._prefix2ns.hashCode() ^ this._defaultNS.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(50 * this._prefix2ns.size());
        if (!"".equals(this._defaultNS)) {
            stringBuilder.append("xmlns=\"").append(this._defaultNS).append("\"");
        }
        for (String string : this.getAllPrefixes()) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(" ");
            }
            stringBuilder.append("xmlns:").append(string).append("=\"").append(this._prefix2ns.get(string)).append("\"");
        }
        return stringBuilder.toString();
    }

    protected NamespaceResolver clone() {
        NamespaceResolver namespaceResolver = new NamespaceResolver().setDefaultNamespace(this.getDefaultNamespace());
        for (String string : this.getAllPrefixes()) {
            namespaceResolver.addNamespace(string, this.getNamespaceURI(string));
        }
        return namespaceResolver;
    }

    private SortedSet<String> getPrefixSet(String string) {
        SortedSet<String> sortedSet = this._ns2prefix.get(string);
        if (sortedSet == null) {
            sortedSet = new TreeSet<String>();
            this._ns2prefix.put(string, sortedSet);
        }
        return sortedSet;
    }

    static {
        DEFAULT_PREFIXES.add("");
        XML_NS_URI_PREFIXES.add("xml");
        XML_NS_ATTR_PREFIXES.add("xmlns");
    }
}

