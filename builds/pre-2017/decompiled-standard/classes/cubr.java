/*
 * Decompiled with CFR 0.152.
 */
import java.lang.reflect.AccessibleObject;

public final class cubr {
    private cubr() {
    }

    public static Throwable _a(AccessibleObject accessibleObject) {
        try {
            accessibleObject.setAccessible(true);
            return null;
        }
        catch (SecurityException securityException) {
            return securityException;
        }
        catch (RuntimeException runtimeException) {
            return cubr._a(runtimeException);
        }
    }

    private static RuntimeException _a(RuntimeException runtimeException) {
        if ("java.lang.reflect.InaccessibleObjectException".equals(runtimeException.getClass().getName())) {
            return runtimeException;
        }
        throw runtimeException;
    }
}

