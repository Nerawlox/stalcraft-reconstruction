/*
 * Decompiled with CFR 0.152.
 */
package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.TypeCastException;
import kotlin.collections.AbstractCollection;
import kotlin.collections.AbstractSet;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010&\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\b'\u0018\u0000 **\u0004\b\u0000\u0010\u0001*\u0006\b\u0001\u0010\u0002 \u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003:\u0001*B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0004J\u001f\u0010\u0013\u001a\u00020\u00142\u0010\u0010\u0015\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0016H\u0000\u00a2\u0006\u0002\b\u0017J\u0015\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u001aJ\u001a\u0010\u001b\u001a\u00020\u00142\u000b\u0010\u001c\u001a\u00078\u0001\u00a2\u0006\u0002\b\u001dH\u0016\u00a2\u0006\u0002\u0010\u001aJ\u0013\u0010\u001e\u001a\u00020\u00142\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0096\u0002J\u0018\u0010!\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0019\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0002\u0010\"J\b\u0010#\u001a\u00020\rH\u0016J#\u0010$\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00162\u0006\u0010\u0019\u001a\u00028\u0000H\u0002\u00a2\u0006\u0002\u0010%J\b\u0010&\u001a\u00020\u0014H\u0016J\b\u0010'\u001a\u00020(H\u0016J\u0012\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010 H\u0002J\u001c\u0010'\u001a\u00020(2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0016H\bR\u001a\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00068\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\b8\b@\bX\u0089\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006+"}, d2={"Lkotlin/collections/AbstractMap;", "K", "V", "", "()V", "_keys", "", "_values", "", "keys", "getKeys", "()Ljava/util/Set;", "size", "", "getSize", "()I", "values", "getValues", "()Ljava/util/Collection;", "containsEntry", "", "entry", "", "containsEntry$kotlin_stdlib", "containsKey", "key", "(Ljava/lang/Object;)Z", "containsValue", "value", "Lkotlin/UnsafeVariance;", "equals", "other", "", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "hashCode", "implFindEntry", "(Ljava/lang/Object;)Ljava/util/Map$Entry;", "isEmpty", "toString", "", "o", "Companion", "kotlin-stdlib"})
@SinceKotlin(version="1.1")
public abstract class AbstractMap<K, V>
implements Map<K, V>,
KMappedMarker {
    private volatile Set<? extends K> _keys;
    private volatile Collection<? extends V> _values;
    public static final Companion Companion = new Companion(null);

    @Override
    public boolean containsKey(Object key) {
        return this.implFindEntry(key) != null;
    }

    @Override
    public boolean containsValue(Object value) {
        boolean bl;
        block1: {
            Iterable $receiver$iv = this.entrySet();
            for (Object element$iv : $receiver$iv) {
                Map.Entry it = (Map.Entry)element$iv;
                if (!Intrinsics.areEqual(it.getValue(), value)) continue;
                bl = true;
                break block1;
            }
            bl = false;
        }
        return bl;
    }

    public final boolean containsEntry$kotlin_stdlib(@Nullable Map.Entry<?, ?> entry) {
        AbstractMap abstractMap;
        if (!(entry instanceof Map.Entry)) {
            return false;
        }
        Object key = entry.getKey();
        Object value = entry.getValue();
        AbstractMap abstractMap2 = abstractMap = this;
        if (abstractMap2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<K, V>");
        }
        Object ourValue = ((Map)abstractMap2).get(key);
        if (Intrinsics.areEqual(value, ourValue) ^ true) {
            return false;
        }
        if (ourValue == null) {
            AbstractMap abstractMap3 = abstractMap = this;
            if (abstractMap3 == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
            }
            if (!((Map)abstractMap3).containsKey(key)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean equals(@Nullable Object other) {
        boolean bl;
        block4: {
            if (other == this) {
                return true;
            }
            if (!(other instanceof Map)) {
                return false;
            }
            if (this.size() != ((Map)other).size()) {
                return false;
            }
            Iterable $receiver$iv = ((Map)other).entrySet();
            for (Object element$iv : $receiver$iv) {
                Map.Entry it = (Map.Entry)element$iv;
                if (this.containsEntry$kotlin_stdlib(it)) continue;
                bl = false;
                break block4;
            }
            bl = true;
        }
        return bl;
    }

    @Override
    @Nullable
    public V get(Object key) {
        Map.Entry<Object, V> entry = this.implFindEntry(key);
        return (V)(entry != null ? entry.getValue() : null);
    }

    @Override
    public int hashCode() {
        return ((Object)this.entrySet()).hashCode();
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    public int getSize() {
        return this.entrySet().size();
    }

    @NotNull
    public Set<K> getKeys() {
        if (this._keys == null) {
            this._keys = new AbstractSet<K>(this){
                final /* synthetic */ AbstractMap this$0;

                public boolean contains(Object element) {
                    return this.this$0.containsKey(element);
                }

                @NotNull
                public Iterator<K> iterator() {
                    Iterator<E> entryIterator = this.this$0.entrySet().iterator();
                    return new Iterator<K>(entryIterator){
                        final /* synthetic */ Iterator $entryIterator;

                        public boolean hasNext() {
                            return this.$entryIterator.hasNext();
                        }

                        public K next() {
                            return ((Map.Entry)this.$entryIterator.next()).getKey();
                        }
                        {
                            this.$entryIterator = $captured_local_variable$0;
                        }

                        public void remove() {
                            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
                        }
                    };
                }

                public int getSize() {
                    return this.this$0.size();
                }
                {
                    this.this$0 = $outer;
                }
            };
        }
        Set<? extends K> set = this._keys;
        if (set == null) {
            Intrinsics.throwNpe();
        }
        return set;
    }

    @NotNull
    public String toString() {
        return CollectionsKt.joinToString$default(this.entrySet(), ", ", "{", "}", 0, null, new Function1<Map.Entry<? extends K, ? extends V>, String>(this){
            final /* synthetic */ AbstractMap this$0;

            @NotNull
            public final String invoke(@NotNull Map.Entry<? extends K, ? extends V> it) {
                Intrinsics.checkParameterIsNotNull(it, "it");
                return AbstractMap.access$toString(this.this$0, it);
            }
            {
                this.this$0 = abstractMap;
                super(1);
            }
        }, 24, null);
    }

    private final String toString(Map.Entry<? extends K, ? extends V> entry) {
        return this.toString(entry.getKey()) + "=" + this.toString(entry.getValue());
    }

    private final String toString(Object o) {
        return o == this ? "(this Map)" : String.valueOf(o);
    }

    @NotNull
    public Collection<V> getValues() {
        if (this._values == null) {
            this._values = new AbstractCollection<V>(this){
                final /* synthetic */ AbstractMap this$0;

                public boolean contains(Object element) {
                    return this.this$0.containsValue(element);
                }

                @NotNull
                public Iterator<V> iterator() {
                    Iterator<E> entryIterator = this.this$0.entrySet().iterator();
                    return new Iterator<V>(entryIterator){
                        final /* synthetic */ Iterator $entryIterator;

                        public boolean hasNext() {
                            return this.$entryIterator.hasNext();
                        }

                        public V next() {
                            return ((Map.Entry)this.$entryIterator.next()).getValue();
                        }
                        {
                            this.$entryIterator = $captured_local_variable$0;
                        }

                        public void remove() {
                            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
                        }
                    };
                }

                public int getSize() {
                    return this.this$0.size();
                }
                {
                    this.this$0 = $outer;
                }
            };
        }
        Collection<? extends V> collection = this._values;
        if (collection == null) {
            Intrinsics.throwNpe();
        }
        return collection;
    }

    private final Map.Entry<K, V> implFindEntry(K key) {
        Object v0;
        block1: {
            Iterable $receiver$iv = this.entrySet();
            for (Object element$iv : $receiver$iv) {
                Map.Entry it = (Map.Entry)element$iv;
                if (!Intrinsics.areEqual(it.getKey(), key)) continue;
                v0 = element$iv;
                break block1;
            }
            v0 = null;
        }
        return v0;
    }

    protected AbstractMap() {
    }

    public abstract Set getEntries();

    @NotNull
    public static final /* synthetic */ String access$toString(AbstractMap $this, @NotNull Map.Entry entry) {
        return $this.toString(entry);
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> map2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public V put(K k, V v) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public V remove(Object object) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010&\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J'\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u0000\u00a2\u0006\u0002\b\bJ\u001d\u0010\t\u001a\u00020\n2\u000e\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0006H\u0000\u00a2\u0006\u0002\b\u000bJ\u001d\u0010\f\u001a\u00020\r2\u000e\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0006H\u0000\u00a2\u0006\u0002\b\u000e\u00a8\u0006\u000f"}, d2={"Lkotlin/collections/AbstractMap$Companion;", "", "()V", "entryEquals", "", "e", "", "other", "entryEquals$kotlin_stdlib", "entryHashCode", "", "entryHashCode$kotlin_stdlib", "entryToString", "", "entryToString$kotlin_stdlib", "kotlin-stdlib"})
    public static final class Companion {
        public final int entryHashCode$kotlin_stdlib(@NotNull Map.Entry<?, ?> e) {
            Intrinsics.checkParameterIsNotNull(e, "e");
            Map.Entry<?, ?> $receiver = e;
            Object obj = $receiver.getKey();
            Object obj2 = $receiver.getValue();
            return (obj != null ? obj.hashCode() : 0) ^ (obj2 != null ? obj2.hashCode() : 0);
        }

        @NotNull
        public final String entryToString$kotlin_stdlib(@NotNull Map.Entry<?, ?> e) {
            Intrinsics.checkParameterIsNotNull(e, "e");
            Map.Entry<?, ?> $receiver = e;
            return $receiver.getKey() + "=" + $receiver.getValue();
        }

        public final boolean entryEquals$kotlin_stdlib(@NotNull Map.Entry<?, ?> e, @Nullable Object other) {
            Intrinsics.checkParameterIsNotNull(e, "e");
            if (!(other instanceof Map.Entry)) {
                return false;
            }
            return Intrinsics.areEqual(e.getKey(), ((Map.Entry)other).getKey()) && Intrinsics.areEqual(e.getValue(), ((Map.Entry)other).getValue());
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

