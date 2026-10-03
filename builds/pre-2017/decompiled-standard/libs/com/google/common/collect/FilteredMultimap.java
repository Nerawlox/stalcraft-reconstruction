/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.AbstractMultimap;
import com.google.common.collect.Multimap;
import java.util.Map;

@GwtCompatible
abstract class FilteredMultimap<K, V>
extends AbstractMultimap<K, V> {
    final Multimap<K, V> unfiltered;

    FilteredMultimap(Multimap<K, V> unfiltered) {
        this.unfiltered = Preconditions.checkNotNull(unfiltered);
    }

    abstract Predicate<? super Map.Entry<K, V>> entryPredicate();
}

