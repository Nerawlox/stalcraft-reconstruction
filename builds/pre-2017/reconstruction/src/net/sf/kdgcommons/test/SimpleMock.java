/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  junit.framework.Assert
 */
package net.sf.kdgcommons.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import junit.framework.Assert;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class SimpleMock
implements InvocationHandler {
    private ArrayList<String> _calls = new ArrayList();
    private ArrayList<Object[]> _args = new ArrayList();

    public <T> T getInstance(Class<T> clazz) {
        return clazz.cast(Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{clazz}, (InvocationHandler)this));
    }

    @Override
    public Object invoke(Object object, Method method, Object[] objectArray) throws Throwable {
        this._calls.add(method.getName());
        if (objectArray == null) {
            objectArray = new Object[]{};
        }
        this._args.add(objectArray);
        return null;
    }

    public void assertCallCount(int n) {
        Assert.assertEquals((String)"call count", (int)n, (int)this._calls.size());
    }

    public void assertCall(int n, String string, Object ... objectArray) {
        Assert.assertEquals((String)"incorrect method", (String)string, (String)this._calls.get(n));
        Assert.assertEquals((String)"argument count", (int)objectArray.length, (int)this._args.get(n).length);
        for (int i = 0; i < objectArray.length; ++i) {
            Assert.assertEquals((String)("argument " + i), (Object)objectArray[i], (Object)this._args.get(n)[i]);
        }
    }
}

