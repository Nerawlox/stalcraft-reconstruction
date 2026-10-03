/*
 * Decompiled with CFR 0.152.
 */
package net.sf.practicalxml.xpath;

import java.util.HashMap;
import java.util.Map;
import javax.xml.namespace.QName;
import javax.xml.xpath.XPathFunction;
import net.sf.practicalxml.xpath.AbstractFunction;
import net.sf.practicalxml.xpath.FunctionResolver;
import net.sf.practicalxml.xpath.XPathWrapper;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class XPathWrapperFactory
implements Cloneable {
    private Map<String, XPathWrapper> _simpleCache;
    private ThreadLocal<Map<String, XPathWrapper>> _threadsafeCache;
    private Map<String, String> _namespaces = new HashMap<String, String>();
    private Map<QName, Object> _variables = new HashMap<QName, Object>();
    private FunctionResolver _functions = new FunctionResolver();

    public XPathWrapperFactory() {
        this(CacheType.NONE);
    }

    public XPathWrapperFactory(CacheType cacheType) {
        switch (cacheType) {
            case SIMPLE: {
                this._simpleCache = new HashMap<String, XPathWrapper>();
                break;
            }
            case THREADSAFE: {
                this._threadsafeCache = new ThreadLocal<Map<String, XPathWrapper>>(){

                    @Override
                    protected Map<String, XPathWrapper> initialValue() {
                        return new HashMap<String, XPathWrapper>();
                    }
                };
                break;
            }
        }
    }

    public XPathWrapperFactory bindNamespace(String string, String string2) {
        this._namespaces.put(string, string2);
        return this;
    }

    public XPathWrapperFactory bindVariable(String string, Object object) {
        return this.bindVariable(new QName(string), object);
    }

    public XPathWrapperFactory bindVariable(QName qName, Object object) {
        this._variables.put(qName, object);
        return this;
    }

    public XPathWrapperFactory bindFunction(AbstractFunction<?> abstractFunction) {
        this._functions.addFunction(abstractFunction);
        return this;
    }

    public XPathWrapperFactory bindFunction(AbstractFunction<?> abstractFunction, String string) {
        this._functions.addFunction(abstractFunction);
        this.bindNamespace(string, abstractFunction.getNamespaceUri());
        return this;
    }

    public XPathWrapperFactory bindFunction(QName qName, XPathFunction xPathFunction) {
        this._functions.addFunction(xPathFunction, qName);
        return this;
    }

    public XPathWrapperFactory bindFunction(QName qName, XPathFunction xPathFunction, int n) {
        this._functions.addFunction(xPathFunction, qName, n);
        return this;
    }

    public XPathWrapperFactory bindFunction(QName qName, XPathFunction xPathFunction, int n, int n2) {
        this._functions.addFunction(xPathFunction, qName, n, n2);
        return this;
    }

    public XPathWrapper newXPath(String string) {
        XPathWrapper xPathWrapper = this.retrieveFromCache(string);
        if (xPathWrapper != null) {
            return xPathWrapper;
        }
        xPathWrapper = new XPathWrapper(string);
        for (Map.Entry<String, String> entry : this._namespaces.entrySet()) {
            xPathWrapper.bindNamespace(entry.getKey(), entry.getValue());
        }
        for (Map.Entry<Object, Object> entry : this._variables.entrySet()) {
            xPathWrapper.bindVariable((QName)entry.getKey(), entry.getValue());
        }
        xPathWrapper.setFunctionResolver(this._functions.clone());
        this.addToCache(string, xPathWrapper);
        return xPathWrapper;
    }

    private XPathWrapper retrieveFromCache(String string) {
        if (this._simpleCache != null) {
            return this._simpleCache.get(string);
        }
        if (this._threadsafeCache != null) {
            return this._threadsafeCache.get().get(string);
        }
        return null;
    }

    private void addToCache(String string, XPathWrapper xPathWrapper) {
        if (this._simpleCache != null) {
            this._simpleCache.put(string, xPathWrapper);
        } else if (this._threadsafeCache != null) {
            this._threadsafeCache.get().put(string, xPathWrapper);
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static enum CacheType {
        NONE,
        SIMPLE,
        THREADSAFE;

    }
}

