/*
 * Decompiled with CFR 0.152.
 */
package kotlin.text;

import kotlin.Metadata;
import kotlin.internal.InlineOnly;
import kotlin.text.CharsKt;
import kotlin.text.CharsKt__CharJVMKt;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=5, xi=1, d1={"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0001\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0002\u001a\u0015\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0007H\u0087\n\u00a8\u0006\b"}, d2={"equals", "", "", "other", "ignoreCase", "isSurrogate", "plus", "", "kotlin-stdlib"}, xs="kotlin/text/CharsKt")
class CharsKt__CharKt
extends CharsKt__CharJVMKt {
    @InlineOnly
    private static final String plus(char $receiver, String other) {
        return String.valueOf($receiver) + other;
    }

    public static final boolean equals(char $receiver, char other, boolean ignoreCase) {
        char c;
        if ($receiver == other) {
            return true;
        }
        if (!ignoreCase) {
            return false;
        }
        char c2 = $receiver;
        char c3 = Character.toUpperCase(c2);
        if (c3 == (c = Character.toUpperCase(c2 = other))) {
            return true;
        }
        c2 = $receiver;
        c3 = Character.toLowerCase(c2);
        return c3 == (c = Character.toLowerCase(c2 = other));
    }

    public static /* bridge */ /* synthetic */ boolean equals$default(char c, char c2, boolean bl, int n, Object object) {
        if ((n & 2) != 0) {
            bl = false;
        }
        return CharsKt.equals(c, c2, bl);
    }

    public static final boolean isSurrogate(char $receiver) {
        char c = $receiver;
        return '\ud800' <= c && c <= '\udfff';
    }
}

