/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization.jvm;

import java.util.ArrayList;
import java.util.Collection;
import kotlin.TypeCastException;
import kotlin._Assertions;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class UtfEncodingKt {
    public static final int MAX_UTF8_INFO_LENGTH = 65535;
    public static final char UTF8_MODE_MARKER = '\u0000';

    @NotNull
    public static final String[] bytesToStrings(@NotNull byte[] bytes) {
        Collection $receiver$iv;
        Intrinsics.checkParameterIsNotNull(bytes, "bytes");
        ArrayList<String> result2 = new ArrayList<String>(1);
        StringBuilder buffer = new StringBuilder();
        int bytesInBuffer = 0;
        buffer.append('\u0000');
        bytesInBuffer += 2;
        for (int i = 0; i < bytes.length; ++i) {
            byte b = bytes[i];
            int c = b & 0xFF;
            buffer.append((char)c);
            bytesInBuffer = 0 < b && b <= 127 ? ++bytesInBuffer : (bytesInBuffer += 2);
            if (bytesInBuffer < 65534) continue;
            result2.add(buffer.toString());
            buffer.setLength(0);
            bytesInBuffer = 0;
        }
        CharSequence b = buffer;
        if (!(b.length() == 0)) {
            result2.add(buffer.toString());
        }
        Collection thisCollection$iv = $receiver$iv = (Collection)result2;
        String[] stringArray = thisCollection$iv.toArray(new String[thisCollection$iv.size()]);
        if (stringArray == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        return (String[])((Object[])stringArray);
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final byte[] stringsToBytes(@NotNull String[] strings) {
        int n;
        Intrinsics.checkParameterIsNotNull(strings, "strings");
        Object[] $receiver$iv = strings;
        int sum$iv = 0;
        for (n = 0; n < $receiver$iv.length; ++n) {
            void it;
            Object element$iv = $receiver$iv[n];
            String string = (String)element$iv;
            int n2 = sum$iv;
            int n3 = it.length();
            sum$iv = n2 + n3;
        }
        int resultLength = sum$iv;
        byte[] result2 = new byte[resultLength];
        int i = 0;
        block1: for (int element$iv = 0; element$iv < strings.length; ++element$iv) {
            int it = 0;
            String s = strings[element$iv];
            int n4 = s.length() - 1;
            if (it > n4) continue;
            while (true) {
                void si;
                result2[i++] = (byte)s.charAt((int)si);
                if (si == n4) continue block1;
                ++si;
            }
        }
        int n5 = n = i == result2.length ? 1 : 0;
        if (_Assertions.ENABLED && n == 0) {
            String string = "Should have reached the end";
            throw (Throwable)((Object)new AssertionError((Object)string));
        }
        return result2;
    }
}

