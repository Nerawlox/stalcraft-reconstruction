/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
final class Hashing {
    private static final int C1 = -862048943;
    private static final int C2 = 461845907;
    static int MAX_TABLE_SIZE = 0x40000000;

    private Hashing() {
    }

    static int smear(int hashCode2) {
        return 461845907 * Integer.rotateLeft(hashCode2 * -862048943, 15);
    }

    static int closedTableSize(int expectedEntries, double loadFactor) {
        int tableSize;
        if ((double)(expectedEntries = Math.max(expectedEntries, 2)) / (double)(tableSize = Integer.highestOneBit(expectedEntries)) > loadFactor) {
            return (tableSize <<= 1) > 0 ? tableSize : MAX_TABLE_SIZE;
        }
        return tableSize;
    }

    static boolean needsResizing(int size, int tableSize, double loadFactor) {
        return (double)size > loadFactor * (double)tableSize && tableSize < MAX_TABLE_SIZE;
    }
}

