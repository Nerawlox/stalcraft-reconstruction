/*
 * Decompiled with CFR 0.152.
 */
package kotlin.internal;

import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.internal.PlatformImplementations;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=2, d1={"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\b\u0010\u0002\u001a\u00020\u0003H\u0002\"\u0010\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0004"}, d2={"IMPLEMENTATIONS", "Lkotlin/internal/PlatformImplementations;", "getJavaVersion", "", "kotlin-stdlib"})
public final class PlatformImplementationsKt {
    @JvmField
    @NotNull
    public static final PlatformImplementations IMPLEMENTATIONS;

    private static final int getJavaVersion() {
        int n;
        int n2 = 65542;
        String string = System.getProperty("java.specification.version");
        if (string == null) {
            return n2;
        }
        String version = string;
        int firstDot = StringsKt.indexOf$default((CharSequence)version, '.', 0, false, 6, null);
        if (firstDot < 0) {
            int n3;
            try {
                String string2 = version;
                n3 = Integer.parseInt(string2) * 65536;
            }
            catch (NumberFormatException e) {
                n3 = n2;
            }
            return n3;
        }
        int secondDot = StringsKt.indexOf$default((CharSequence)version, '.', firstDot + 1, false, 4, null);
        if (secondDot < 0) {
            secondDot = version.length();
        }
        String string3 = version;
        int n4 = 0;
        String string4 = string3;
        if (string4 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String string5 = string4.substring(n4, firstDot);
        Intrinsics.checkExpressionValueIsNotNull(string5, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        String firstPart = string5;
        String string6 = version;
        int n5 = firstDot + 1;
        String string7 = string6;
        if (string7 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String string8 = string7.substring(n5, secondDot);
        Intrinsics.checkExpressionValueIsNotNull(string8, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        String secondPart = string8;
        try {
            string6 = firstPart;
            int n6 = Integer.parseInt(string6) * 65536;
            string6 = secondPart;
            int n7 = n6;
            int n8 = Integer.parseInt(string6);
            n = n7 + n8;
        }
        catch (NumberFormatException e) {
            n = n2;
        }
        return n;
    }

    static {
        PlatformImplementations platformImplementations;
        block7: {
            block8: {
                int version;
                block6: {
                    version = PlatformImplementationsKt.getJavaVersion();
                    try {
                        if (version < 65544) break block6;
                        Object obj = Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();
                        if (obj == null) {
                            throw new TypeCastException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                        }
                        platformImplementations = (PlatformImplementations)obj;
                        break block7;
                    }
                    catch (ClassNotFoundException classNotFoundException) {
                        // empty catch block
                    }
                }
                try {
                    if (version < 65543) break block8;
                    Object obj = Class.forName("kotlin.internal.JRE7PlatformImplementations").newInstance();
                    if (obj == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                    }
                    platformImplementations = (PlatformImplementations)obj;
                    break block7;
                }
                catch (ClassNotFoundException classNotFoundException) {
                    // empty catch block
                }
            }
            platformImplementations = new PlatformImplementations();
        }
        IMPLEMENTATIONS = platformImplementations;
    }
}

