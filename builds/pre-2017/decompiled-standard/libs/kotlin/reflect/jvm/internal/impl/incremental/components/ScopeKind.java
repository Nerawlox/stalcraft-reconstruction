/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.incremental.components;

public final class ScopeKind
extends Enum<ScopeKind> {
    public static final /* enum */ ScopeKind PACKAGE;
    public static final /* enum */ ScopeKind CLASSIFIER;
    private static final /* synthetic */ ScopeKind[] $VALUES;

    static {
        ScopeKind[] scopeKindArray = new ScopeKind[2];
        ScopeKind[] scopeKindArray2 = scopeKindArray;
        scopeKindArray[0] = PACKAGE = new ScopeKind();
        scopeKindArray[1] = CLASSIFIER = new ScopeKind();
        $VALUES = scopeKindArray;
    }

    public static ScopeKind[] values() {
        return (ScopeKind[])$VALUES.clone();
    }

    public static ScopeKind valueOf(String string) {
        return Enum.valueOf(ScopeKind.class, string);
    }
}

