/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

public interface DeserializationConfiguration {
    public boolean getTypeAliasesAllowed();

    public static final class Default
    implements DeserializationConfiguration {
        public static final Default INSTANCE;

        private Default() {
            INSTANCE = this;
        }

        static {
            new Default();
        }

        @Override
        public boolean getTypeAliasesAllowed() {
            return DefaultImpls.getTypeAliasesAllowed(this);
        }
    }

    public static final class DefaultImpls {
        public static boolean getTypeAliasesAllowed(DeserializationConfiguration $this) {
            return true;
        }
    }
}

