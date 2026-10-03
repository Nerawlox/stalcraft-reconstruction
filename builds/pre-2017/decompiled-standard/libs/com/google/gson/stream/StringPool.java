/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.stream;

final class StringPool {
    private final String[] pool = new String[512];

    StringPool() {
    }

    public String get(char[] array, int start, int length) {
        int index;
        String pooled;
        int hashCode2 = 0;
        for (int i = start; i < start + length; ++i) {
            hashCode2 = hashCode2 * 31 + array[i];
        }
        hashCode2 ^= hashCode2 >>> 20 ^ hashCode2 >>> 12;
        if ((pooled = this.pool[index = (hashCode2 ^= hashCode2 >>> 7 ^ hashCode2 >>> 4) & this.pool.length - 1]) == null || pooled.length() != length) {
            String result2;
            this.pool[index] = result2 = new String(array, start, length);
            return result2;
        }
        for (int i = 0; i < length; ++i) {
            String result3;
            if (pooled.charAt(i) == array[start + i]) continue;
            this.pool[index] = result3 = new String(array, start, length);
            return result3;
        }
        return pooled;
    }
}

