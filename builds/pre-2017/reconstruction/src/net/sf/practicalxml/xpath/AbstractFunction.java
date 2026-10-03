/*
 * Decompiled with CFR 0.152.
 */
package net.sf.practicalxml.xpath;

import java.util.Collections;
import java.util.List;
import javax.xml.namespace.QName;
import javax.xml.xpath.XPathFunction;
import javax.xml.xpath.XPathFunctionException;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class AbstractFunction<T>
implements Comparable<AbstractFunction<?>>,
XPathFunction {
    private final QName _qname;
    private final int _minArgCount;
    private final int _maxArgCount;

    protected AbstractFunction(String string, String string2) {
        this(string, string2, 0, Integer.MAX_VALUE);
    }

    protected AbstractFunction(String string, String string2, int n) {
        this(string, string2, n, n);
    }

    protected AbstractFunction(String string, String string2, int n, int n2) {
        this(new QName(string, string2), n, n2);
    }

    protected AbstractFunction(QName qName, int n, int n2) {
        this._qname = qName;
        this._minArgCount = n;
        this._maxArgCount = n2;
    }

    public QName getQName() {
        return this._qname;
    }

    public String getNamespaceUri() {
        return this._qname.getNamespaceURI();
    }

    public String getName() {
        return this._qname.getLocalPart();
    }

    public int getMinArgCount() {
        return this._minArgCount;
    }

    public int getMaxArgCount() {
        return this._maxArgCount;
    }

    public boolean isMatch(QName qName, int n) {
        return this._qname.equals(qName) && n >= this._minArgCount && n <= this._maxArgCount;
    }

    public boolean isArityMatch(int n) {
        return n >= this._minArgCount && n <= this._maxArgCount;
    }

    @Override
    public int compareTo(AbstractFunction<?> abstractFunction) {
        int n = this._qname.getNamespaceURI().compareTo(abstractFunction._qname.getNamespaceURI());
        if (n != 0) {
            return n < 0 ? -1 : 1;
        }
        n = this._qname.getLocalPart().compareTo(abstractFunction._qname.getLocalPart());
        if (n != 0) {
            return n < 0 ? -1 : 1;
        }
        n = this._maxArgCount - this._minArgCount - (abstractFunction._maxArgCount - abstractFunction._minArgCount);
        if (n != 0) {
            return n < 0 ? -1 : 1;
        }
        n = this._minArgCount - abstractFunction._minArgCount;
        if (n != 0) {
            return n < 0 ? -1 : 1;
        }
        return n;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof AbstractFunction) {
            AbstractFunction abstractFunction = (AbstractFunction)object;
            return this._qname.equals(abstractFunction._qname) && this._minArgCount == abstractFunction._minArgCount && this._maxArgCount == abstractFunction._maxArgCount;
        }
        return false;
    }

    public final int hashCode() {
        return this._qname.hashCode();
    }

    @Override
    public Object evaluate(List list) throws XPathFunctionException {
        if (list == null) {
            list = Collections.EMPTY_LIST;
        }
        if (list.size() < this._minArgCount || list.size() > this._maxArgCount) {
            throw new XPathFunctionException("illegal argument count: " + list.size());
        }
        try {
            T t = this.init();
            int n = 0;
            for (Object e : list) {
                t = e instanceof String ? this.processArg(n, (String)e, t) : (e instanceof Number ? this.processArg(n, (Number)e, t) : (e instanceof NodeList ? this.processArg(n, (NodeList)e, t) : (e instanceof Node ? this.processArg(n, (Node)e, t) : (e == null ? this.processNullArg(n, t) : this.processUnexpectedArg(n, e, t)))));
                ++n;
            }
            return this.getResult(t);
        }
        catch (Exception exception) {
            throw new XPathFunctionException(exception);
        }
    }

    protected T init() throws Exception {
        return null;
    }

    protected T processArg(int n, String string, T t) throws Exception {
        return t;
    }

    protected T processArg(int n, Number number, T t) throws Exception {
        return t;
    }

    protected T processArg(int n, Boolean bl, T t) throws Exception {
        return t;
    }

    protected T processArg(int n, Node node, T t) throws Exception {
        return t;
    }

    protected T processArg(int n, NodeList nodeList, T t) throws Exception {
        return this.processArg(n, nodeList.item(0), t);
    }

    protected T processNullArg(int n, T t) throws Exception {
        throw new IllegalArgumentException("null argument: " + n);
    }

    protected T processUnexpectedArg(int n, Object object, T t) throws Exception {
        throw new IllegalArgumentException("unexpected argument: " + n + " (" + object.getClass().getName() + ")");
    }

    protected Object getResult(T t) throws Exception {
        return t;
    }
}

