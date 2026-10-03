/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckerContext;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;
import kotlin.reflect.jvm.internal.impl.utils.addToStdlib.AddToStdlibKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TypeCheckerContext {
    private int argumentsDepth;
    private boolean supertypesLocked;
    private ArrayDeque<SimpleType> supertypesDeque;
    private Set<SimpleType> supertypesSet;
    private final boolean errorTypeEqualsToAnything;

    protected final int getArgumentsDepth() {
        return this.argumentsDepth;
    }

    protected final void setArgumentsDepth(int n) {
        this.argumentsDepth = n;
    }

    @Nullable
    public Boolean addSubtypeConstraint(@NotNull UnwrappedType subType, @NotNull UnwrappedType superType) {
        Intrinsics.checkParameterIsNotNull(subType, "subType");
        Intrinsics.checkParameterIsNotNull(superType, "superType");
        return null;
    }

    public final <T> T runWithArgumentsSettings(@NotNull UnwrappedType subArgument, @NotNull Function1<? super TypeCheckerContext, ? extends T> f) {
        Intrinsics.checkParameterIsNotNull(subArgument, "subArgument");
        Intrinsics.checkParameterIsNotNull(f, "f");
        if (this.argumentsDepth > 100) {
            String string = "Arguments depth is too high. Some related argument: " + subArgument;
            throw (Throwable)new IllegalStateException(string.toString());
        }
        TypeCheckerContext typeCheckerContext = this;
        int n = typeCheckerContext.argumentsDepth;
        typeCheckerContext.argumentsDepth = n + 1;
        T result2 = f.invoke(this);
        TypeCheckerContext typeCheckerContext2 = this;
        int n2 = typeCheckerContext2.argumentsDepth;
        typeCheckerContext2.argumentsDepth = n2 + -1;
        return result2;
    }

    private final void initialize() {
        boolean bl;
        boolean bl2 = bl = !this.supertypesLocked;
        if (_Assertions.ENABLED && !bl) {
            String string = "Assertion failed";
            throw (Throwable)((Object)new AssertionError((Object)string));
        }
        this.supertypesLocked = true;
        if (this.supertypesDeque == null) {
            this.supertypesDeque = new ArrayDeque();
        }
        if (this.supertypesSet == null) {
            this.supertypesSet = SmartSet.Companion.create();
        }
    }

    private final void clear() {
        ArrayDeque<SimpleType> arrayDeque = this.supertypesDeque;
        if (arrayDeque == null) {
            Intrinsics.throwNpe();
        }
        arrayDeque.clear();
        Set<SimpleType> set = this.supertypesSet;
        if (set == null) {
            Intrinsics.throwNpe();
        }
        set.clear();
        this.supertypesLocked = false;
    }

    public final boolean anySupertype$kotlin_core(@NotNull SimpleType start, @NotNull Function1<? super SimpleType, Boolean> predicate, @NotNull Function1<? super SimpleType, ? extends SupertypesPolicy> supertypesPolicy) {
        Object object;
        Intrinsics.checkParameterIsNotNull(start, "start");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        Intrinsics.checkParameterIsNotNull(supertypesPolicy, "supertypesPolicy");
        this.initialize();
        ArrayDeque<SimpleType> arrayDeque = this.supertypesDeque;
        if (arrayDeque == null) {
            Intrinsics.throwNpe();
        }
        ArrayDeque<SimpleType> deque = arrayDeque;
        Set<SimpleType> set = this.supertypesSet;
        if (set == null) {
            Intrinsics.throwNpe();
        }
        Set<SimpleType> visitedSupertypes = set;
        deque.push(start);
        while (!(object = (Collection)deque).isEmpty()) {
            SimpleType current;
            if (visitedSupertypes.size() > 1000) {
                object = "Too many supertypes for type: " + start + ". Supertypes = " + CollectionsKt.joinToString$default(visitedSupertypes, null, null, null, 0, null, null, 63, null);
                throw (Throwable)new IllegalStateException(object.toString());
            }
            SimpleType simpleType2 = current = deque.pop();
            Intrinsics.checkExpressionValueIsNotNull(simpleType2, "current");
            if (!visitedSupertypes.add(simpleType2)) continue;
            SimpleType simpleType3 = current;
            Intrinsics.checkExpressionValueIsNotNull(simpleType3, "current");
            if (predicate.invoke(simpleType3).booleanValue()) {
                this.clear();
                return true;
            }
            SimpleType simpleType4 = current;
            Intrinsics.checkExpressionValueIsNotNull(simpleType4, "current");
            if (AddToStdlibKt.check(supertypesPolicy.invoke(simpleType4), anySupertype.policy.1.INSTANCE) == null) {
                continue;
            }
            Iterator<KotlinType> iterator2 = current.getConstructor().getSupertypes().iterator();
            while (iterator2.hasNext()) {
                SupertypesPolicy policy2;
                KotlinType supertype;
                KotlinType kotlinType = supertype = iterator2.next();
                Intrinsics.checkExpressionValueIsNotNull(kotlinType, "supertype");
                deque.add(policy2.transformType(kotlinType));
            }
        }
        this.clear();
        return false;
    }

    public final boolean getErrorTypeEqualsToAnything() {
        return this.errorTypeEqualsToAnything;
    }

    public TypeCheckerContext(boolean errorTypeEqualsToAnything) {
        this.errorTypeEqualsToAnything = errorTypeEqualsToAnything;
    }

    public static abstract class SupertypesPolicy {
        @NotNull
        public abstract SimpleType transformType(@NotNull KotlinType var1);

        private SupertypesPolicy() {
        }

        public /* synthetic */ SupertypesPolicy(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        public static final class None
        extends SupertypesPolicy {
            public static final None INSTANCE;

            @NotNull
            public Void transformType(@NotNull KotlinType type2) {
                Intrinsics.checkParameterIsNotNull(type2, "type");
                throw (Throwable)new UnsupportedOperationException("Should not be called");
            }

            private None() {
                super(null);
                INSTANCE = this;
            }

            static {
                new None();
            }
        }

        public static final class UpperIfFlexible
        extends SupertypesPolicy {
            public static final UpperIfFlexible INSTANCE;

            @Override
            @NotNull
            public SimpleType transformType(@NotNull KotlinType type2) {
                Intrinsics.checkParameterIsNotNull(type2, "type");
                return FlexibleTypesKt.upperIfFlexible(type2);
            }

            private UpperIfFlexible() {
                super(null);
                INSTANCE = this;
            }

            static {
                new UpperIfFlexible();
            }
        }

        public static final class LowerIfFlexible
        extends SupertypesPolicy {
            public static final LowerIfFlexible INSTANCE;

            @Override
            @NotNull
            public SimpleType transformType(@NotNull KotlinType type2) {
                Intrinsics.checkParameterIsNotNull(type2, "type");
                return FlexibleTypesKt.lowerIfFlexible(type2);
            }

            private LowerIfFlexible() {
                super(null);
                INSTANCE = this;
            }

            static {
                new LowerIfFlexible();
            }
        }

        public static final class LowerIfFlexibleWithCustomSubstitutor
        extends SupertypesPolicy {
            @NotNull
            private final TypeSubstitutor substitutor;

            @Override
            @NotNull
            public SimpleType transformType(@NotNull KotlinType type2) {
                Intrinsics.checkParameterIsNotNull(type2, "type");
                return TypeSubstitutionKt.asSimpleType(this.substitutor.safeSubstitute(FlexibleTypesKt.lowerIfFlexible(type2), Variance.INVARIANT));
            }

            @NotNull
            public final TypeSubstitutor getSubstitutor() {
                return this.substitutor;
            }

            public LowerIfFlexibleWithCustomSubstitutor(@NotNull TypeSubstitutor substitutor) {
                Intrinsics.checkParameterIsNotNull(substitutor, "substitutor");
                super(null);
                this.substitutor = substitutor;
            }
        }
    }
}

