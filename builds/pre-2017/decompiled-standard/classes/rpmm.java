/*
 * Decompiled with CFR 0.152.
 */
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.security.AccessController;
import java.security.PrivilegedAction;
import sun.misc.Unsafe;

final class rpmm {
    private static final Unsafe _a;
    private static final long _b;
    private static final long _c;
    private static final Constructor<?> _d;
    private static final long _e = 0x100000L;

    static boolean _a() {
        return _a != null;
    }

    static boolean _b() {
        return _d != null;
    }

    static ByteBuffer _a(ByteBuffer byteBuffer, int n) {
        return rpmm._a(_a.reallocateMemory(rpmm._b(byteBuffer), n), n);
    }

    static ByteBuffer _a(int n) {
        return rpmm._a(_a.allocateMemory(n), n);
    }

    static ByteBuffer _a(long l, int n) {
        try {
            return (ByteBuffer)_d.newInstance(l, n);
        }
        catch (Throwable throwable) {
            if (throwable instanceof Error) {
                throw (Error)throwable;
            }
            throw new Error(throwable);
        }
    }

    static void _a(ByteBuffer byteBuffer) {
        hboo._a(byteBuffer);
    }

    static long _b(ByteBuffer byteBuffer) {
        return rpmm._d(byteBuffer, _b);
    }

    static long _c() {
        return _c;
    }

    static Object _a(Object object, long l) {
        return _a.getObject(object, l);
    }

    static Object _b(Object object, long l) {
        return _a.getObjectVolatile(object, l);
    }

    static int _c(Object object, long l) {
        return _a.getInt(object, l);
    }

    private static long _d(Object object, long l) {
        return _a.getLong(object, l);
    }

    static long _a(Field field) {
        return _a.objectFieldOffset(field);
    }

    static byte _a(long l) {
        return _a.getByte(l);
    }

    static short _b(long l) {
        return _a.getShort(l);
    }

    static int _c(long l) {
        return _a.getInt(l);
    }

    static long _d(long l) {
        return _a.getLong(l);
    }

    static byte _a(byte[] byArray, int n) {
        return _a.getByte(byArray, _c + (long)n);
    }

    static short _b(byte[] byArray, int n) {
        return _a.getShort(byArray, _c + (long)n);
    }

    static int _c(byte[] byArray, int n) {
        return _a.getInt(byArray, _c + (long)n);
    }

    static long _d(byte[] byArray, int n) {
        return _a.getLong(byArray, _c + (long)n);
    }

    static void _a(long l, byte by) {
        _a.putByte(l, by);
    }

    static void _a(long l, short s) {
        _a.putShort(l, s);
    }

    static void _b(long l, int n) {
        _a.putInt(l, n);
    }

    static void _a(long l, long l2) {
        _a.putLong(l, l2);
    }

    static void _a(byte[] byArray, int n, byte by) {
        _a.putByte(byArray, _c + (long)n, by);
    }

    static void _a(byte[] byArray, int n, short s) {
        _a.putShort(byArray, _c + (long)n, s);
    }

    static void _a(byte[] byArray, int n, int n2) {
        _a.putInt(byArray, _c + (long)n, n2);
    }

    static void _a(byte[] byArray, int n, long l) {
        _a.putLong(byArray, _c + (long)n, l);
    }

    static void _a(long l, long l2, long l3) {
        while (l3 > 0L) {
            long l4 = Math.min(l3, 0x100000L);
            _a.copyMemory(l, l2, l4);
            l3 -= l4;
            l += l4;
            l2 += l4;
        }
    }

    static void _a(Object object, long l, Object object2, long l2, long l3) {
        while (l3 > 0L) {
            long l4 = Math.min(l3, 0x100000L);
            _a.copyMemory(object, l, object2, l2, l4);
            l3 -= l4;
            l += l4;
            l2 += l4;
        }
    }

    static void _a(long l, long l2, byte by) {
        _a.setMemory(l, l2, by);
    }

    static void _a(Object object, long l, long l2, byte by) {
        _a.setMemory(object, l, l2, by);
    }

    static ClassLoader _a(final Class<?> clazz) {
        if (System.getSecurityManager() == null) {
            return clazz.getClassLoader();
        }
        return AccessController.doPrivileged(new PrivilegedAction<ClassLoader>(){

            public ClassLoader _a() {
                return clazz.getClassLoader();
            }

            @Override
            public /* synthetic */ Object run() {
                return this._a();
            }
        });
    }

    static ClassLoader _d() {
        if (System.getSecurityManager() == null) {
            return Thread.currentThread().getContextClassLoader();
        }
        return AccessController.doPrivileged(new PrivilegedAction<ClassLoader>(){

            public ClassLoader _a() {
                return Thread.currentThread().getContextClassLoader();
            }

            @Override
            public /* synthetic */ Object run() {
                return this._a();
            }
        });
    }

    static ClassLoader _e() {
        if (System.getSecurityManager() == null) {
            return ClassLoader.getSystemClassLoader();
        }
        return AccessController.doPrivileged(new PrivilegedAction<ClassLoader>(){

            public ClassLoader _a() {
                return ClassLoader.getSystemClassLoader();
            }

            @Override
            public /* synthetic */ Object run() {
                return this._a();
            }
        });
    }

    static int _f() {
        return _a.addressSize();
    }

    static long _e(long l) {
        return _a.allocateMemory(l);
    }

    static void _f(long l) {
        _a.freeMemory(l);
    }

    private rpmm() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    static {
        Object object;
        Object object2;
        Unsafe unsafe;
        Field field = null;
        final ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1);
        Object object3 = AccessController.doPrivileged(new PrivilegedAction<Object>(){

            @Override
            public Object run() {
                try {
                    Field field = Unsafe.class.getDeclaredField("theUnsafe");
                    Throwable throwable = cubr._a(field);
                    if (throwable != null) {
                        return throwable;
                    }
                    return field.get(null);
                }
                catch (NoSuchFieldException noSuchFieldException) {
                    return noSuchFieldException;
                }
                catch (SecurityException securityException) {
                    return securityException;
                }
                catch (IllegalAccessException illegalAccessException) {
                    return illegalAccessException;
                }
            }
        });
        if (object3 instanceof Exception) {
            unsafe = null;
            gpmu._d("sun.misc.Unsafe.theUnsafe: unavailable", (Exception)object3);
        } else {
            unsafe = (Unsafe)object3;
            gpmu._d("sun.misc.Unsafe.theUnsafe: available", new Object[0]);
        }
        if (unsafe != null) {
            object2 = unsafe;
            object = AccessController.doPrivileged(new PrivilegedAction<Object>((Unsafe)object2){
                final /* synthetic */ Unsafe _a;
                {
                    this._a = unsafe;
                }

                @Override
                public Object run() {
                    try {
                        this._a.getClass().getDeclaredMethod("copyMemory", Object.class, Long.TYPE, Object.class, Long.TYPE, Long.TYPE);
                        return null;
                    }
                    catch (NoSuchMethodException noSuchMethodException) {
                        return noSuchMethodException;
                    }
                    catch (SecurityException securityException) {
                        return securityException;
                    }
                }
            });
            if (object == null) {
                gpmu._d("sun.misc.Unsafe.copyMemory: available", new Object[0]);
            } else {
                unsafe = null;
                gpmu._d("sun.misc.Unsafe.copyMemory: unavailable", (Throwable)object);
            }
        }
        if (unsafe != null) {
            object2 = unsafe;
            object = AccessController.doPrivileged(new PrivilegedAction<Object>((Unsafe)object2, byteBuffer){
                final /* synthetic */ Unsafe _a;
                final /* synthetic */ ByteBuffer _b;
                {
                    this._a = unsafe;
                    this._b = byteBuffer;
                }

                @Override
                public Object run() {
                    try {
                        Field field = Buffer.class.getDeclaredField("address");
                        long l = this._a.objectFieldOffset(field);
                        long l2 = this._a.getLong(this._b, l);
                        if (l2 == 0L) {
                            return null;
                        }
                        return field;
                    }
                    catch (NoSuchFieldException noSuchFieldException) {
                        return noSuchFieldException;
                    }
                    catch (SecurityException securityException) {
                        return securityException;
                    }
                }
            });
            if (object instanceof Field) {
                field = (Field)object;
                gpmu._d("java.nio.Buffer.address: available", new Object[0]);
            } else {
                gpmu._d("java.nio.Buffer.address: unavailable", (Throwable)object);
                unsafe = null;
            }
        }
        _a = unsafe;
        if (unsafe == null) {
            _b = -1L;
            _c = -1L;
            _d = null;
        } else {
            long l = -1L;
            try {
                Object object4 = AccessController.doPrivileged(new PrivilegedAction<Object>(){

                    @Override
                    public Object run() {
                        try {
                            Constructor<?> constructor = byteBuffer.getClass().getDeclaredConstructor(Long.TYPE, Integer.TYPE);
                            Throwable throwable = cubr._a(constructor);
                            if (throwable != null) {
                                return throwable;
                            }
                            return constructor;
                        }
                        catch (NoSuchMethodException noSuchMethodException) {
                            return noSuchMethodException;
                        }
                        catch (SecurityException securityException) {
                            return securityException;
                        }
                    }
                });
                if (object4 instanceof Constructor) {
                    l = _a.allocateMemory(1L);
                    try {
                        ((Constructor)object4).newInstance(l, 1);
                        object2 = (Constructor)object4;
                        gpmu._d("direct buffer constructor: available", new Object[0]);
                    }
                    catch (InstantiationException instantiationException) {
                        object2 = null;
                    }
                    catch (IllegalAccessException illegalAccessException) {
                        object2 = null;
                    }
                    catch (InvocationTargetException invocationTargetException) {
                        object2 = null;
                    }
                } else {
                    gpmu._d("direct buffer constructor: unavailable", (Throwable)object4);
                    object2 = null;
                }
            }
            finally {
                if (l != -1L) {
                    _a.freeMemory(l);
                }
            }
            _d = object2;
            _b = rpmm._a(field);
            _c = _a.arrayBaseOffset(byte[].class);
        }
        gpmu._d("java.nio.DirectByteBuffer.<init>(long, int): " + (_d != null ? "available" : "unavailable"), new Object[0]);
    }
}

