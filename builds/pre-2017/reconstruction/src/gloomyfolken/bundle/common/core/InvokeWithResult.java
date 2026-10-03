/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.bundle.common.core;

public interface InvokeWithResult<T> {
    public static <T> T backend(InvokeBackendOnly<T> invokeBackendOnly) {
        return invokeBackendOnly.run();
    }

    public static <T> T frontend(InvokeFrontendOnly<T> invokeFrontendOnly) {
        return invokeFrontendOnly.run();
    }

    public static <T> T client(InvokeClientOnly<T> invokeClientOnly) {
        return invokeClientOnly.run();
    }

    public static interface InvokeClientOnly<T> {
        public T run();
    }

    public static interface InvokeFrontendOnly<T> {
        public T run();
    }

    public static interface InvokeBackendOnly<T> {
        public T run();
    }
}

