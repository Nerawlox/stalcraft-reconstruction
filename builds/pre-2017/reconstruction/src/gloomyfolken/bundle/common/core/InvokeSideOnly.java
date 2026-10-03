/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.bundle.common.core;

public class InvokeSideOnly {
    public static void backend(InvokeBackendOnly invokeBackendOnly) {
        invokeBackendOnly.run();
    }

    public static void backend(boolean bl, InvokeBackendOnly invokeBackendOnly) {
        if (bl) {
            invokeBackendOnly.run();
        }
    }

    public static void frontend(InvokeFrontendOnly invokeFrontendOnly) {
        invokeFrontendOnly.run();
    }

    public static void frontend(boolean bl, InvokeFrontendOnly invokeFrontendOnly) {
        if (bl) {
            invokeFrontendOnly.run();
        }
    }

    public static void client(InvokeClientOnly invokeClientOnly) {
        invokeClientOnly.run();
    }

    public static void client(boolean bl, InvokeClientOnly invokeClientOnly) {
        if (bl) {
            invokeClientOnly.run();
        }
    }

    public static interface InvokeClientOnly {
        public void run();
    }

    public static interface InvokeFrontendOnly {
        public void run();
    }

    public static interface InvokeBackendOnly {
        public void run();
    }
}

