/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.DiscreteDomain;

@Deprecated
@GwtCompatible
public final class DiscreteDomains {
    private DiscreteDomains() {
    }

    public static DiscreteDomain<Integer> integers() {
        return DiscreteDomain.integers();
    }

    public static DiscreteDomain<Long> longs() {
        return DiscreteDomain.longs();
    }
}

