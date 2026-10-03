/*
 * Decompiled with CFR 0.152.
 */
package net.sf.practicalxml.xpath;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.namespace.QName;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPathFunction;
import javax.xml.xpath.XPathVariableResolver;
import net.sf.practicalxml.DomUtil;
import net.sf.practicalxml.XmlException;
import net.sf.practicalxml.xpath.AbstractFunction;
import net.sf.practicalxml.xpath.FunctionResolver;
import net.sf.practicalxml.xpath.NamespaceResolver;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class XPathWrapper
implements Cloneable {
    private final String _expr;
    private final NamespaceResolver _nsResolver = new NamespaceResolver();
    private Map<QName, Object> _variables = new HashMap<QName, Object>();
    private FunctionResolver _functions = new FunctionResolver();
    private XPathExpression _compiled;

    public XPathWrapper(String string) {
        this._expr = string;
    }

    public XPathWrapper bindNamespace(String string, String string2) {
        this._nsResolver.addNamespace(string, string2);
        return this;
    }

    @Deprecated
    public XPathWrapper bindDefaultNamespace(String string) {
        this._nsResolver.setDefaultNamespace(string);
        return this;
    }

    public XPathWrapper bindVariable(String string, Object object) {
        return this.bindVariable(new QName(string), object);
    }

    public XPathWrapper bindVariable(QName qName, Object object) {
        this._variables.put(qName, object);
        return this;
    }

    public XPathWrapper bindFunction(AbstractFunction<?> abstractFunction) {
        this._functions.addFunction(abstractFunction);
        return this;
    }

    public XPathWrapper bindFunction(AbstractFunction<?> abstractFunction, String string) {
        this._functions.addFunction(abstractFunction);
        return this.bindNamespace(string, abstractFunction.getNamespaceUri());
    }

    public XPathWrapper bindFunction(QName qName, XPathFunction xPathFunction) {
        return this.bindFunction(qName, xPathFunction, 0, Integer.MAX_VALUE);
    }

    public XPathWrapper bindFunction(QName qName, XPathFunction xPathFunction, int n) {
        return this.bindFunction(qName, xPathFunction, n, n);
    }

    public XPathWrapper bindFunction(QName qName, XPathFunction xPathFunction, int n, int n2) {
        this._functions.addFunction(xPathFunction, qName, n, n2);
        if (!"".equals(qName.getPrefix())) {
            this.bindNamespace(qName.getPrefix(), qName.getNamespaceURI());
        }
        return this;
    }

    public XPathWrapper setFunctionResolver(FunctionResolver functionResolver) {
        this._functions = functionResolver;
        return this;
    }

    public List<Node> evaluate(Node node) {
        return DomUtil.asList(this.evaluate(node, XPathConstants.NODESET, NodeList.class), Node.class);
    }

    public <T> List<T> evaluate(Node node, Class<T> clazz) {
        return DomUtil.filter(this.evaluate(node, XPathConstants.NODESET, NodeList.class), clazz);
    }

    public Element evaluateAsElement(Node node) {
        NodeList nodeList = this.evaluate(node, XPathConstants.NODESET, NodeList.class);
        int n = nodeList.getLength();
        for (int i = 0; i < n; ++i) {
            Node node2 = nodeList.item(i);
            if (!(node2 instanceof Element)) continue;
            return (Element)node2;
        }
        return null;
    }

    public String evaluateAsString(Node node) {
        return this.evaluate(node, XPathConstants.STRING, String.class);
    }

    public List<String> evaluateAsStringList(Node node) {
        List<Node> list = this.evaluate(node);
        ArrayList<String> arrayList = new ArrayList<String>(list.size());
        for (Node node2 : list) {
            arrayList.add(node2.getTextContent());
        }
        return arrayList;
    }

    public Number evaluateAsNumber(Node node) {
        return this.evaluate(node, XPathConstants.NUMBER, Number.class);
    }

    public Boolean evaluateAsBoolean(Node node) {
        return this.evaluate(node, XPathConstants.BOOLEAN, Boolean.class);
    }

    public final boolean equals(Object object) {
        if (object instanceof XPathWrapper) {
            XPathWrapper xPathWrapper = (XPathWrapper)object;
            return this._expr.equals(xPathWrapper._expr) && this._nsResolver.equals(xPathWrapper._nsResolver) && ((Object)this._variables).equals(xPathWrapper._variables) && this._functions.equals(xPathWrapper._functions);
        }
        return false;
    }

    public int hashCode() {
        return this._expr.hashCode();
    }

    public String toString() {
        return this._expr;
    }

    protected XPathWrapper clone() throws CloneNotSupportedException {
        XPathWrapper xPathWrapper = (XPathWrapper)super.clone();
        xPathWrapper._compiled = null;
        return xPathWrapper;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void compileIfNeeded() {
        if (this._compiled != null) {
            return;
        }
        try {
            XPathFactory xPathFactory = null;
            Object object = XPathFactory.class;
            synchronized (XPathFactory.class) {
                xPathFactory = XPathFactory.newInstance();
                // ** MonitorExit[var2_3] (shouldn't be in output)
                object = xPathFactory.newXPath();
                object.setNamespaceContext(this._nsResolver);
                object.setXPathVariableResolver(new MyVariableResolver());
                object.setXPathFunctionResolver(this._functions);
                this._compiled = object.compile(this._expr);
            }
        }
        catch (XPathExpressionException xPathExpressionException) {
            throw new XmlException("unable to compile: " + this._expr, xPathExpressionException);
        }
    }

    private <T> T evaluate(Node node, QName qName, Class<T> clazz) {
        this.compileIfNeeded();
        try {
            return clazz.cast(this._compiled.evaluate(node, qName));
        }
        catch (Exception exception) {
            throw new XmlException("unable to evaluate: " + this._expr, exception);
        }
    }

    private class MyVariableResolver
    implements XPathVariableResolver {
        private MyVariableResolver() {
        }

        public Object resolveVariable(QName qName) {
            return XPathWrapper.this._variables.get(qName);
        }
    }
}

