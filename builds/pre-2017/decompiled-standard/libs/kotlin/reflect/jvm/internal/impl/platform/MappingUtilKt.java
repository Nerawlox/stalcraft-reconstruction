/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.platform;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;

public final class MappingUtilKt {
    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final TypeConstructorSubstitution createMappedTypeParametersSubstitution(@NotNull ClassDescriptor from, @NotNull ClassDescriptor to) {
        void var3_5;
        Object object;
        TypeParameterDescriptor p1;
        Iterable<TypeConstructor> iterable;
        Iterable $receiver$iv$iv;
        Iterable $receiver$iv;
        boolean bl;
        Intrinsics.checkParameterIsNotNull(from, "from");
        Intrinsics.checkParameterIsNotNull(to, "to");
        boolean bl2 = bl = from.getDeclaredTypeParameters().size() == to.getDeclaredTypeParameters().size();
        if (_Assertions.ENABLED && !bl) {
            String string = from + " and " + to + " should have same number of type parameters, " + ("but " + from.getDeclaredTypeParameters().size() + " / " + to.getDeclaredTypeParameters().size() + " found");
            throw (Throwable)((Object)new AssertionError((Object)string));
        }
        Iterable iterable2 = from.getDeclaredTypeParameters();
        TypeConstructorSubstitution.Companion companion = TypeConstructorSubstitution.Companion;
        void $i$a$1$assert = $receiver$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        for (Object item$iv$iv : $receiver$iv$iv) {
            TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor)item$iv$iv;
            iterable = destination$iv$iv;
            object = p1.getTypeConstructor();
            iterable.add(object);
        }
        iterable = (List)destination$iv$iv;
        $receiver$iv = to.getDeclaredTypeParameters();
        iterable = iterable;
        $receiver$iv$iv = $receiver$iv;
        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        for (Object item$iv$iv : $receiver$iv$iv) {
            void it;
            p1 = (TypeParameterDescriptor)item$iv$iv;
            object = destination$iv$iv;
            TypeProjection typeProjection = TypeUtilsKt.asTypeProjection(it.getDefaultType());
            object.add(typeProjection);
        }
        object = (List)var3_5;
        return TypeConstructorSubstitution.Companion.createByConstructorsMap$default(companion, MapsKt.toMap(CollectionsKt.zip(iterable, (Iterable)object)), false, 2, null);
    }
}

