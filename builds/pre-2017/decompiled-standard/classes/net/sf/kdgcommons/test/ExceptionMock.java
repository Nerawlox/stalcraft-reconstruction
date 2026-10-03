/*
 * Decompiled with CFR 0.152.
 */
package net.sf.kdgcommons.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class ExceptionMock
implements InvocationHandler {
    private Throwable _specific;
    private Class<? extends Throwable> _generic;

    public ExceptionMock(Throwable throwable) {
        this._specific = throwable;
    }

    public ExceptionMock(Class<? extends Throwable> clazz) {
        this._generic = clazz;
    }

    public <T> T getInstance(Class<T> clazz) {
        return clazz.cast(Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{clazz}, (InvocationHandler)this));
    }

    @Override
    public Object invoke(Object object, Method method, Object[] objectArray) throws Throwable {
        if (this._specific != null) {
            throw this._specific;
        }
        throw this._generic.newInstance();
    }
}

