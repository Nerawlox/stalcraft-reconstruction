/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.util.collectionUtils;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ScopeUtilsKt {
    @Nullable
    public static final <T> Collection<T> concat(@Nullable Collection<? extends T> $receiver, @NotNull Collection<? extends T> collection) {
        Intrinsics.checkParameterIsNotNull(collection, "collection");
        if (collection.isEmpty()) {
            return $receiver;
        }
        if ($receiver == null) {
            return collection;
        }
        if ($receiver instanceof LinkedHashSet) {
            ((LinkedHashSet)$receiver).addAll(collection);
            return $receiver;
        }
        LinkedHashSet<T> result2 = new LinkedHashSet<T>($receiver);
        result2.addAll(collection);
        return result2;
    }

    @NotNull
    public static final <T> Collection<T> concatInOrder(@Nullable Collection<? extends T> c1, @Nullable Collection<? extends T> c2) {
        Collection result2;
        Collection collection;
        Collection collection2;
        if (c1 == null || c1.isEmpty()) {
            collection2 = c2;
        } else if (c2 == null || c2.isEmpty()) {
            collection2 = c1;
        } else {
            LinkedHashSet<T> result3 = new LinkedHashSet<T>();
            result3.addAll(c1);
            result3.addAll(c2);
            collection2 = result3;
        }
        if ((collection = (result2 = collection2)) == null) {
            collection = SetsKt.emptySet();
        }
        return collection;
    }

    @NotNull
    public static final <Scope, T> Collection<T> getFromAllScopes(@NotNull List<? extends Scope> scopes, @NotNull Function1<? super Scope, ? extends Collection<? extends T>> callback) {
        Intrinsics.checkParameterIsNotNull(scopes, "scopes");
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        if (scopes.isEmpty()) {
            return SetsKt.emptySet();
        }
        Collection<T> result2 = null;
        for (Scope scope : scopes) {
            result2 = ScopeUtilsKt.concat(result2, callback.invoke(scope));
        }
        Collection<T> collection = result2;
        if (collection == null) {
            collection = SetsKt.emptySet();
        }
        return collection;
    }

    @NotNull
    public static final <Scope, T> Collection<T> getFromAllScopes(Scope firstScope, @NotNull List<? extends Scope> restScopes, @NotNull Function1<? super Scope, ? extends Collection<? extends T>> callback) {
        Intrinsics.checkParameterIsNotNull(restScopes, "restScopes");
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        Collection<T> result2 = callback.invoke(firstScope);
        for (Scope scope : restScopes) {
            result2 = ScopeUtilsKt.concat(result2, callback.invoke(scope));
        }
        Collection<T> collection = result2;
        if (collection == null) {
            collection = SetsKt.emptySet();
        }
        return collection;
    }

    @Nullable
    public static final <Scope, T extends ClassifierDescriptor> T getFirstClassifierDiscriminateHeaders(@NotNull List<? extends Scope> scopes, @NotNull Function1<? super Scope, ? extends T> callback) {
        Intrinsics.checkParameterIsNotNull(scopes, "scopes");
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        ClassifierDescriptor result2 = null;
        for (Scope scope : scopes) {
            ClassifierDescriptor newResult = (ClassifierDescriptor)callback.invoke(scope);
            if (newResult == null) continue;
            if (newResult instanceof ClassifierDescriptorWithTypeParameters && ((ClassifierDescriptorWithTypeParameters)newResult).isHeader()) {
                if (result2 != null) continue;
                result2 = newResult;
                continue;
            }
            return (T)newResult;
        }
        return (T)result2;
    }
}

