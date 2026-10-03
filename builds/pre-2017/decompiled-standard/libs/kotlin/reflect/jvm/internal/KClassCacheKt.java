/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal;

import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.KClassImpl;
import kotlin.reflect.jvm.internal.pcollections.HashPMap;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=2, d1={"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a&\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\b\b\u0000\u0010\b*\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\nH\u0000\"/\u0010\u0000\u001a#\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00040\u00040\u0001\u00a2\u0006\u0002\b\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2={"K_CLASS_CACHE", "Lkotlin/reflect/jvm/internal/pcollections/HashPMap;", "", "kotlin.jvm.PlatformType", "", "Lorg/jetbrains/annotations/NotNull;", "getOrCreateKotlinClass", "Lkotlin/reflect/jvm/internal/KClassImpl;", "T", "jClass", "Ljava/lang/Class;", "kotlin-reflection"})
public final class KClassCacheKt {
    private static HashPMap<String, Object> K_CLASS_CACHE = HashPMap.empty();

    @NotNull
    public static final <T> KClassImpl<T> getOrCreateKotlinClass(@NotNull Class<T> jClass) {
        Intrinsics.checkParameterIsNotNull(jClass, "jClass");
        String name2 = jClass.getName();
        Object cached = K_CLASS_CACHE.get(name2);
        if (cached instanceof WeakReference) {
            KClassImpl kClass;
            KClassImpl kClassImpl = kClass = (KClassImpl)((WeakReference)cached).get();
            if (Intrinsics.areEqual(kClassImpl != null ? kClassImpl.getJClass() : null, jClass)) {
                return kClass;
            }
        } else if (cached != null) {
            Object object = cached;
            if (object == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<java.lang.ref.WeakReference<kotlin.reflect.jvm.internal.KClassImpl<T>>>");
            }
            WeakReference[] cfr_ignored_0 = (WeakReference[])object;
            WeakReference[] weakReferenceArray = (WeakReference[])cached;
            for (int i = 0; i < weakReferenceArray.length; ++i) {
                KClassImpl kClass;
                WeakReference ref = weakReferenceArray[i];
                KClassImpl kClassImpl = kClass = (KClassImpl)ref.get();
                if (!Intrinsics.areEqual(kClassImpl != null ? kClassImpl.getJClass() : null, jClass)) continue;
                return kClass;
            }
            int size = ((Object[])cached).length;
            WeakReference[] newArray = new WeakReference[size + 1];
            System.arraycopy(cached, 0, newArray, 0, size);
            KClassImpl<T> newKClass = new KClassImpl<T>(jClass);
            newArray[size] = new WeakReference<KClassImpl<T>>(newKClass);
            K_CLASS_CACHE = K_CLASS_CACHE.plus(name2, newArray);
            return newKClass;
        }
        KClassImpl<T> newKClass = new KClassImpl<T>(jClass);
        K_CLASS_CACHE = K_CLASS_CACHE.plus(name2, new WeakReference<KClassImpl<T>>(newKClass));
        return newKClass;
    }
}

