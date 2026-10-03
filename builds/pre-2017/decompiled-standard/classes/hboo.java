/*
 * Decompiled with CFR 0.152.
 */
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

public final class hboo {
    private static final long _b;
    private static final Method _c;
    private static final boolean _d;

    public static void _a(ByteBuffer byteBuffer) {
        if (_b == -1L || !byteBuffer.isDirect()) {
            return;
        }
        assert (_c != null || _d) : "CLEANER_FIELD_OFFSET != -1 implies CLEAN_METHOD != null or CLEANER_IS_RUNNABLE == true";
        try {
            Object object = rpmm._a((Object)byteBuffer, _b);
            if (object != null) {
                if (_d) {
                    ((Runnable)object).run();
                } else {
                    _c.invoke(object, new Object[0]);
                }
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    private hboo() {
    }

    static {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1);
        long l = -1L;
        Method method = null;
        boolean bl = false;
        if (rpmm._a()) {
            try {
                Field field = byteBuffer.getClass().getDeclaredField("cleaner");
                field.setAccessible(true);
                l = rpmm._a(field);
                Object object = field.get(byteBuffer);
                try {
                    Runnable runnable = (Runnable)object;
                    runnable.run();
                    bl = true;
                }
                catch (ClassCastException classCastException) {
                    method = object.getClass().getDeclaredMethod("clean", new Class[0]);
                    method.invoke(object, new Object[0]);
                }
            }
            catch (Throwable throwable) {
                l = -1L;
                method = null;
                bl = false;
            }
        }
        gpmu._d("java.nio.ByteBuffer.cleaner(): " + (l != -1L ? "available" : "unavailable"), new Object[0]);
        _b = l;
        _c = method;
        _d = bl;
        hboo._a(byteBuffer);
    }
}

