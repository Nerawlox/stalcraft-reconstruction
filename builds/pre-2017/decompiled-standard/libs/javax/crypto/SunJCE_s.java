/*
 * Decompiled with CFR 0.152.
 */
package javax.crypto;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.io.StreamCorruptedException;

class SunJCE_s
extends ObjectInputStream {
    private static ClassLoader a;

    SunJCE_s(InputStream inputStream) throws IOException, StreamCorruptedException {
        super(inputStream);
    }

    protected Class resolveClass(ObjectStreamClass objectStreamClass) throws IOException, ClassNotFoundException {
        try {
            return super.resolveClass(objectStreamClass);
        }
        catch (ClassNotFoundException classNotFoundException) {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            if (classLoader == null) {
                if (a == null) {
                    a = ClassLoader.getSystemClassLoader();
                }
                if ((classLoader = a) == null) {
                    throw new ClassNotFoundException(objectStreamClass.getName());
                }
            }
            return Class.forName(objectStreamClass.getName(), false, classLoader);
        }
    }
}

