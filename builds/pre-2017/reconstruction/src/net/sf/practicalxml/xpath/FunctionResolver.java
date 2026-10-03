/*
 * Decompiled with CFR 0.152.
 */
package net.sf.practicalxml.xpath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import javax.xml.namespace.QName;
import javax.xml.xpath.XPathFunction;
import javax.xml.xpath.XPathFunctionException;
import javax.xml.xpath.XPathFunctionResolver;
import net.sf.practicalxml.xpath.AbstractFunction;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class FunctionResolver
implements Cloneable,
XPathFunctionResolver {
    private Map<QName, FunctionHolder> _table = new HashMap<QName, FunctionHolder>();

    public FunctionResolver addFunction(AbstractFunction<?> abstractFunction) {
        FunctionHolder functionHolder = this._table.get(abstractFunction.getQName());
        if (functionHolder == null) {
            functionHolder = new FunctionHolder(abstractFunction);
            this._table.put(abstractFunction.getQName(), functionHolder);
        } else {
            functionHolder.put(abstractFunction);
        }
        return this;
    }

    public FunctionResolver addFunction(XPathFunction xPathFunction, QName qName) {
        return this.addFunction(xPathFunction, qName, 0, Integer.MAX_VALUE);
    }

    public FunctionResolver addFunction(XPathFunction xPathFunction, QName qName, int n) {
        return this.addFunction(xPathFunction, qName, n, n);
    }

    public FunctionResolver addFunction(XPathFunction xPathFunction, QName qName, int n, int n2) {
        return this.addFunction(new StandardFunctionAdapter(xPathFunction, qName, n, n2));
    }

    @Override
    public XPathFunction resolveFunction(QName qName, int n) {
        FunctionHolder functionHolder = this._table.get(qName);
        return functionHolder != null ? functionHolder.get(n) : null;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof FunctionResolver) {
            return ((Object)this._table).equals(((FunctionResolver)object)._table);
        }
        return false;
    }

    public final int hashCode() {
        return ((Object)this._table.keySet()).hashCode();
    }

    public String toString() {
        ArrayList<String> arrayList = new ArrayList<String>();
        for (Map.Entry<QName, FunctionHolder> entry : this._table.entrySet()) {
            QName qName = entry.getKey();
            FunctionHolder functionHolder = entry.getValue();
            StringBuilder stringBuilder = new StringBuilder(64);
            for (AbstractFunction<?> abstractFunction : functionHolder.getAll()) {
                stringBuilder.append("{").append(qName.getNamespaceURI()).append("}").append(qName.getLocalPart()).append("(").append(abstractFunction.getMinArgCount()).append(":").append(abstractFunction.getMaxArgCount()).append(")");
                arrayList.add(stringBuilder.toString());
            }
        }
        return ((Object)arrayList).toString();
    }

    public FunctionResolver clone() {
        try {
            FunctionResolver functionResolver = (FunctionResolver)super.clone();
            functionResolver._table = new HashMap<QName, FunctionHolder>(this._table);
            return functionResolver;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new RuntimeException("should never be thrown unless class hierarchy is changed", cloneNotSupportedException);
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    private static class StandardFunctionAdapter
    extends AbstractFunction<Object> {
        final XPathFunction _func;

        public StandardFunctionAdapter(XPathFunction xPathFunction, QName qName, int n, int n2) {
            super(qName, n, n2);
            this._func = xPathFunction;
        }

        @Override
        public Object evaluate(List list2) throws XPathFunctionException {
            return this._func.evaluate(list2);
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    private static class FunctionHolder {
        private AbstractFunction<?> _onlyOne;
        private TreeSet<AbstractFunction<?>> _hasMany;

        public FunctionHolder(AbstractFunction<?> abstractFunction) {
            this._onlyOne = abstractFunction;
        }

        public void put(AbstractFunction<?> abstractFunction) {
            if (this._hasMany != null) {
                this._hasMany.remove(abstractFunction);
                this._hasMany.add(abstractFunction);
            } else if (this._onlyOne.equals(abstractFunction)) {
                this._onlyOne = abstractFunction;
            } else {
                this._hasMany = new TreeSet();
                this._hasMany.add(abstractFunction);
                this._hasMany.add(this._onlyOne);
                this._onlyOne = null;
            }
        }

        public AbstractFunction<?> get(int n) {
            if (this._onlyOne != null) {
                return this._onlyOne.isArityMatch(n) ? this._onlyOne : null;
            }
            for (AbstractFunction<?> abstractFunction : this._hasMany) {
                if (!abstractFunction.isArityMatch(n)) continue;
                return abstractFunction;
            }
            return null;
        }

        public Set<AbstractFunction<?>> getAll() {
            if (this._onlyOne != null) {
                return new TreeSet(Arrays.asList(this._onlyOne));
            }
            return this._hasMany;
        }

        public boolean equals(Object object) {
            if (object instanceof FunctionHolder) {
                FunctionHolder functionHolder = (FunctionHolder)object;
                return this._onlyOne != null ? this._onlyOne.equals(functionHolder._onlyOne) : this._hasMany.equals(functionHolder._hasMany);
            }
            return false;
        }

        public int hashCode() {
            return 0;
        }
    }
}

