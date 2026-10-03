/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableAsList;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Map;
import javax.annotation.Nullable;

@GwtCompatible(serializable=true)
class RegularImmutableMultiset<E>
extends ImmutableMultiset<E> {
    private final transient ImmutableMap<E, Integer> map;
    private final transient int size;

    RegularImmutableMultiset(ImmutableMap<E, Integer> map2, int size) {
        this.map = map2;
        this.size = size;
    }

    @Override
    boolean isPartialView() {
        return this.map.isPartialView();
    }

    @Override
    public int count(@Nullable Object element) {
        Integer value = this.map.get(element);
        return value == null ? 0 : value;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean contains(@Nullable Object element) {
        return this.map.containsKey(element);
    }

    @Override
    public ImmutableSet<E> elementSet() {
        return this.map.keySet();
    }

    private static <E> Multiset.Entry<E> entryFromMapEntry(Map.Entry<E, Integer> entry) {
        return Multisets.immutableEntry(entry.getKey(), entry.getValue());
    }

    @Override
    ImmutableSet<Multiset.Entry<E>> createEntrySet() {
        return new EntrySet();
    }

    @Override
    public int hashCode() {
        return this.map.hashCode();
    }

    private class EntrySet
    extends ImmutableMultiset.EntrySet {
        private EntrySet() {
            super(RegularImmutableMultiset.this);
        }

        @Override
        public int size() {
            return RegularImmutableMultiset.this.map.size();
        }

        @Override
        public UnmodifiableIterator<Multiset.Entry<E>> iterator() {
            return this.asList().iterator();
        }

        @Override
        ImmutableList<Multiset.Entry<E>> createAsList() {
            final ImmutableList entryList = ((ImmutableCollection)((Object)RegularImmutableMultiset.this.map.entrySet())).asList();
            return new ImmutableAsList<Multiset.Entry<E>>(){

                @Override
                public Multiset.Entry<E> get(int index) {
                    return RegularImmutableMultiset.entryFromMapEntry((Map.Entry)entryList.get(index));
                }

                @Override
                ImmutableCollection<Multiset.Entry<E>> delegateCollection() {
                    return EntrySet.this;
                }
            };
        }
    }
}

