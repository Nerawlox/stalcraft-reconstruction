/*
 * Decompiled with CFR 0.152.
 */
package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010(\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b'\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0003J\u001b\u0010\b\u001a\u00020\t2\u000b\u0010\n\u001a\u00078\u0000\u00a2\u0006\u0002\b\u000bH\u0096\u0002\u00a2\u0006\u0002\u0010\fJ\u001b\u0010\r\u001a\u00020\t2\u0011\u0010\u000e\u001a\r\u0012\t\u0012\u00078\u0000\u00a2\u0006\u0002\b\u000b0\u0002H\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u00a6\u0002J\u0015\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0013H\u0014\u00a2\u0006\u0002\u0010\u0015J'\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0013\"\u0004\b\u0001\u0010\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0013H\u0014\u00a2\u0006\u0002\u0010\u0018J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u0012\u0010\u0004\u001a\u00020\u0005X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u001b"}, d2={"Lkotlin/collections/AbstractCollection;", "E", "", "()V", "size", "", "getSize", "()I", "contains", "", "element", "Lkotlin/UnsafeVariance;", "(Ljava/lang/Object;)Z", "containsAll", "elements", "isEmpty", "iterator", "", "toArray", "", "", "()[Ljava/lang/Object;", "T", "array", "([Ljava/lang/Object;)[Ljava/lang/Object;", "toString", "", "kotlin-stdlib"})
@SinceKotlin(version="1.1")
public abstract class AbstractCollection<E>
implements Collection<E>,
KMappedMarker {
    public abstract int getSize();

    @Override
    @NotNull
    public abstract Iterator<E> iterator();

    @Override
    public boolean contains(Object element) {
        boolean bl;
        block1: {
            AbstractCollection $receiver$iv = this;
            for (Object element$iv : $receiver$iv) {
                Object it = element$iv;
                if (!Intrinsics.areEqual(it, element)) continue;
                bl = true;
                break block1;
            }
            bl = false;
        }
        return bl;
    }

    @Override
    public boolean containsAll(@NotNull Collection<? extends Object> elements) {
        boolean bl;
        block1: {
            Intrinsics.checkParameterIsNotNull(elements, "elements");
            Iterable $receiver$iv = elements;
            for (Object element$iv : $receiver$iv) {
                Object it = element$iv;
                if (this.contains(it)) continue;
                bl = false;
                break block1;
            }
            bl = true;
        }
        return bl;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @NotNull
    public String toString() {
        return CollectionsKt.joinToString$default(this, ", ", "[", "]", 0, null, new Function1<E, CharSequence>(this){
            final /* synthetic */ AbstractCollection this$0;

            @NotNull
            public final CharSequence invoke(E it) {
                return it == this.this$0 ? (CharSequence)"(this Collection)" : (CharSequence)String.valueOf(it);
            }
            {
                this.this$0 = abstractCollection;
                super(1);
            }
        }, 24, null);
    }

    @Override
    @NotNull
    public Object[] toArray() {
        Collection collection = this;
        Object[] objectArray = CollectionToArray.toArray(collection);
        Intrinsics.checkExpressionValueIsNotNull(objectArray, "kotlin.jvm.internal.Coll\u2026Array.toArray(collection)");
        return objectArray;
    }

    @Override
    @NotNull
    public <T> T[] toArray(@NotNull T[] array) {
        Intrinsics.checkParameterIsNotNull(array, "array");
        Collection collection = this;
        T[] TArray = CollectionToArray.toArray(collection, array);
        Intrinsics.checkExpressionValueIsNotNull(TArray, "kotlin.jvm.internal.Coll\u2026oArray(collection, array)");
        return TArray;
    }

    protected AbstractCollection() {
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean add(E e) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean remove(Object object) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

