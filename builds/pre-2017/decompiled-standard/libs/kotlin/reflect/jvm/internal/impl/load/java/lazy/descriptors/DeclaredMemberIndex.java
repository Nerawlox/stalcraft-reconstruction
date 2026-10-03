/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface DeclaredMemberIndex {
    @NotNull
    public Collection<JavaMethod> findMethodsByName(@NotNull Name var1);

    @NotNull
    public Set<Name> getMethodNames();

    @Nullable
    public JavaField findFieldByName(@NotNull Name var1);

    @NotNull
    public Set<Name> getFieldNames();

    public static final class Empty
    implements DeclaredMemberIndex {
        public static final Empty INSTANCE;

        @NotNull
        public List<JavaMethod> findMethodsByName(@NotNull Name name2) {
            Intrinsics.checkParameterIsNotNull(name2, "name");
            return CollectionsKt.emptyList();
        }

        @Override
        @NotNull
        public Set<Name> getMethodNames() {
            return SetsKt.emptySet();
        }

        @Override
        @Nullable
        public JavaField findFieldByName(@NotNull Name name2) {
            Intrinsics.checkParameterIsNotNull(name2, "name");
            return null;
        }

        @Override
        @NotNull
        public Set<Name> getFieldNames() {
            return SetsKt.emptySet();
        }

        private Empty() {
            INSTANCE = this;
        }

        static {
            new Empty();
        }
    }
}

