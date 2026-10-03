/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ForwardingSet;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import com.google.common.reflect.Invokable;
import com.google.common.reflect.TypeCapture;
import com.google.common.reflect.TypeParameter;
import com.google.common.reflect.TypeResolver;
import com.google.common.reflect.Types;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@Beta
public abstract class TypeToken<T>
extends TypeCapture<T>
implements Serializable {
    private final Type runtimeType;
    private transient TypeResolver typeResolver;

    protected TypeToken() {
        this.runtimeType = this.capture();
        Preconditions.checkState(!(this.runtimeType instanceof TypeVariable), "Cannot construct a TypeToken for a type variable.\nYou probably meant to call new TypeToken<%s>(getClass()) that can resolve the type variable for you.\nIf you do need to create a TypeToken of a type variable, please use TypeToken.of() instead.", this.runtimeType);
    }

    protected TypeToken(Class<?> declaringClass) {
        Type captured = super.capture();
        this.runtimeType = captured instanceof Class ? captured : TypeToken.of(declaringClass).resolveType((Type)captured).runtimeType;
    }

    private TypeToken(Type type2) {
        this.runtimeType = Preconditions.checkNotNull(type2);
    }

    public static <T> TypeToken<T> of(Class<T> type2) {
        return new SimpleTypeToken((Type)type2);
    }

    public static TypeToken<?> of(Type type2) {
        return new SimpleTypeToken(type2);
    }

    public final Class<? super T> getRawType() {
        Class<?> rawType;
        Class<?> result2 = rawType = TypeToken.getRawType(this.runtimeType);
        return result2;
    }

    private ImmutableSet<Class<? super T>> getImmediateRawTypes() {
        ImmutableSet<Class<? super T>> result2 = TypeToken.getRawTypes(this.runtimeType);
        return result2;
    }

    public final Type getType() {
        return this.runtimeType;
    }

    public final <X> TypeToken<T> where(TypeParameter<X> typeParam, TypeToken<X> typeArg) {
        TypeResolver resolver = new TypeResolver().where(ImmutableMap.of(typeParam.typeVariable, typeArg.runtimeType));
        return new SimpleTypeToken(resolver.resolveType(this.runtimeType));
    }

    public final <X> TypeToken<T> where(TypeParameter<X> typeParam, Class<X> typeArg) {
        return this.where(typeParam, TypeToken.of(typeArg));
    }

    public final TypeToken<?> resolveType(Type type2) {
        Preconditions.checkNotNull(type2);
        TypeResolver resolver = this.typeResolver;
        if (resolver == null) {
            resolver = this.typeResolver = TypeResolver.accordingTo(this.runtimeType);
        }
        return TypeToken.of(resolver.resolveType(type2));
    }

    private Type[] resolveInPlace(Type[] types) {
        for (int i = 0; i < types.length; ++i) {
            types[i] = this.resolveType(types[i]).getType();
        }
        return types;
    }

    private TypeToken<?> resolveSupertype(Type type2) {
        TypeToken<?> supertype = this.resolveType(type2);
        supertype.typeResolver = this.typeResolver;
        return supertype;
    }

    @Nullable
    final TypeToken<? super T> getGenericSuperclass() {
        if (this.runtimeType instanceof TypeVariable) {
            return this.boundAsSuperclass(((TypeVariable)this.runtimeType).getBounds()[0]);
        }
        if (this.runtimeType instanceof WildcardType) {
            return this.boundAsSuperclass(((WildcardType)this.runtimeType).getUpperBounds()[0]);
        }
        Type superclass = this.getRawType().getGenericSuperclass();
        if (superclass == null) {
            return null;
        }
        TypeToken<?> superToken = this.resolveSupertype(superclass);
        return superToken;
    }

    @Nullable
    private TypeToken<? super T> boundAsSuperclass(Type bound) {
        TypeToken<?> token = TypeToken.of(bound);
        if (token.getRawType().isInterface()) {
            return null;
        }
        TypeToken<?> superclass = token;
        return superclass;
    }

    final ImmutableList<TypeToken<? super T>> getGenericInterfaces() {
        if (this.runtimeType instanceof TypeVariable) {
            return this.boundsAsInterfaces(((TypeVariable)this.runtimeType).getBounds());
        }
        if (this.runtimeType instanceof WildcardType) {
            return this.boundsAsInterfaces(((WildcardType)this.runtimeType).getUpperBounds());
        }
        ImmutableList.Builder builder = ImmutableList.builder();
        for (Type interfaceType : this.getRawType().getGenericInterfaces()) {
            TypeToken<?> resolvedInterface = this.resolveSupertype(interfaceType);
            builder.add(resolvedInterface);
        }
        return builder.build();
    }

    private ImmutableList<TypeToken<? super T>> boundsAsInterfaces(Type[] bounds) {
        ImmutableList.Builder builder = ImmutableList.builder();
        for (Type bound : bounds) {
            TypeToken<?> boundType = TypeToken.of(bound);
            if (!boundType.getRawType().isInterface()) continue;
            builder.add(boundType);
        }
        return builder.build();
    }

    public final TypeSet getTypes() {
        return new TypeSet();
    }

    public final TypeToken<? super T> getSupertype(Class<? super T> superclass) {
        Preconditions.checkArgument(superclass.isAssignableFrom(this.getRawType()), "%s is not a super class of %s", superclass, this);
        if (this.runtimeType instanceof TypeVariable) {
            return this.getSupertypeFromUpperBounds(superclass, ((TypeVariable)this.runtimeType).getBounds());
        }
        if (this.runtimeType instanceof WildcardType) {
            return this.getSupertypeFromUpperBounds(superclass, ((WildcardType)this.runtimeType).getUpperBounds());
        }
        if (superclass.isArray()) {
            return this.getArraySupertype(superclass);
        }
        TypeToken<?> supertype = this.resolveSupertype(TypeToken.toGenericType(superclass).runtimeType);
        return supertype;
    }

    public final TypeToken<? extends T> getSubtype(Class<?> subclass) {
        Preconditions.checkArgument(!(this.runtimeType instanceof TypeVariable), "Cannot get subtype of type variable <%s>", this);
        if (this.runtimeType instanceof WildcardType) {
            return this.getSubtypeFromLowerBounds(subclass, ((WildcardType)this.runtimeType).getLowerBounds());
        }
        Preconditions.checkArgument(this.getRawType().isAssignableFrom(subclass), "%s isn't a subclass of %s", subclass, this);
        if (this.isArray()) {
            return this.getArraySubtype(subclass);
        }
        TypeToken<?> subtype = TypeToken.of(this.resolveTypeArgsForSubclass(subclass));
        return subtype;
    }

    public final boolean isAssignableFrom(TypeToken<?> type2) {
        return this.isAssignableFrom(type2.runtimeType);
    }

    public final boolean isAssignableFrom(Type type2) {
        return TypeToken.isAssignable(Preconditions.checkNotNull(type2), this.runtimeType);
    }

    public final boolean isArray() {
        return this.getComponentType() != null;
    }

    @Nullable
    public final TypeToken<?> getComponentType() {
        Type componentType = Types.getComponentType(this.runtimeType);
        if (componentType == null) {
            return null;
        }
        return TypeToken.of(componentType);
    }

    public final Invokable<T, Object> method(Method method) {
        Preconditions.checkArgument(TypeToken.of(method.getDeclaringClass()).isAssignableFrom(this), "%s not declared by %s", method, this);
        return new Invokable.MethodInvokable<T>(method){

            @Override
            Type getGenericReturnType() {
                return TypeToken.this.resolveType(super.getGenericReturnType()).getType();
            }

            @Override
            Type[] getGenericParameterTypes() {
                return TypeToken.this.resolveInPlace(super.getGenericParameterTypes());
            }

            @Override
            Type[] getGenericExceptionTypes() {
                return TypeToken.this.resolveInPlace(super.getGenericExceptionTypes());
            }

            @Override
            public TypeToken<T> getOwnerType() {
                return TypeToken.this;
            }
        };
    }

    public final Invokable<T, T> constructor(Constructor<?> constructor) {
        Preconditions.checkArgument(constructor.getDeclaringClass() == this.getRawType(), "%s not declared by %s", constructor, this.getRawType());
        return new Invokable.ConstructorInvokable<T>(constructor){

            @Override
            Type getGenericReturnType() {
                return TypeToken.this.resolveType(super.getGenericReturnType()).getType();
            }

            @Override
            Type[] getGenericParameterTypes() {
                return TypeToken.this.resolveInPlace(super.getGenericParameterTypes());
            }

            @Override
            Type[] getGenericExceptionTypes() {
                return TypeToken.this.resolveInPlace(super.getGenericExceptionTypes());
            }

            @Override
            public TypeToken<T> getOwnerType() {
                return TypeToken.this;
            }
        };
    }

    public boolean equals(@Nullable Object o) {
        if (o instanceof TypeToken) {
            TypeToken that = (TypeToken)o;
            return this.runtimeType.equals(that.runtimeType);
        }
        return false;
    }

    public int hashCode() {
        return this.runtimeType.hashCode();
    }

    public String toString() {
        return Types.toString(this.runtimeType);
    }

    protected Object writeReplace() {
        return TypeToken.of(new TypeResolver().resolveType(this.runtimeType));
    }

    final TypeToken<T> rejectTypeVariables() {
        Preconditions.checkArgument(!Types.containsTypeVariable(this.runtimeType), "%s contains a type variable and is not safe for the operation");
        return this;
    }

    private static boolean isAssignable(Type from, Type to) {
        if (to.equals(from)) {
            return true;
        }
        if (to instanceof WildcardType) {
            return TypeToken.isAssignableToWildcardType(from, (WildcardType)to);
        }
        if (from instanceof TypeVariable) {
            return TypeToken.isAssignableFromAny(((TypeVariable)from).getBounds(), to);
        }
        if (from instanceof WildcardType) {
            return TypeToken.isAssignableFromAny(((WildcardType)from).getUpperBounds(), to);
        }
        if (from instanceof GenericArrayType) {
            return TypeToken.isAssignableFromGenericArrayType((GenericArrayType)from, to);
        }
        if (to instanceof Class) {
            return TypeToken.isAssignableToClass(from, (Class)to);
        }
        if (to instanceof ParameterizedType) {
            return TypeToken.isAssignableToParameterizedType(from, (ParameterizedType)to);
        }
        if (to instanceof GenericArrayType) {
            return TypeToken.isAssignableToGenericArrayType(from, (GenericArrayType)to);
        }
        return false;
    }

    private static boolean isAssignableFromAny(Type[] fromTypes, Type to) {
        for (Type from : fromTypes) {
            if (!TypeToken.isAssignable(from, to)) continue;
            return true;
        }
        return false;
    }

    private static boolean isAssignableToClass(Type from, Class<?> to) {
        return to.isAssignableFrom(TypeToken.getRawType(from));
    }

    private static boolean isAssignableToWildcardType(Type from, WildcardType to) {
        return TypeToken.isAssignable(from, TypeToken.supertypeBound(to)) && TypeToken.isAssignableBySubtypeBound(from, to);
    }

    private static boolean isAssignableBySubtypeBound(Type from, WildcardType to) {
        Type toSubtypeBound = TypeToken.subtypeBound(to);
        if (toSubtypeBound == null) {
            return true;
        }
        Type fromSubtypeBound = TypeToken.subtypeBound(from);
        if (fromSubtypeBound == null) {
            return false;
        }
        return TypeToken.isAssignable(toSubtypeBound, fromSubtypeBound);
    }

    private static boolean isAssignableToParameterizedType(Type from, ParameterizedType to) {
        Class<?> matchedClass = TypeToken.getRawType(to);
        if (!matchedClass.isAssignableFrom(TypeToken.getRawType(from))) {
            return false;
        }
        TypeVariable<Class<?>>[] typeParams = matchedClass.getTypeParameters();
        Type[] toTypeArgs = to.getActualTypeArguments();
        TypeToken<?> fromTypeToken = TypeToken.of(from);
        for (int i = 0; i < typeParams.length; ++i) {
            Type fromTypeArg = fromTypeToken.resolveType(typeParams[i]).runtimeType;
            if (TypeToken.matchTypeArgument(fromTypeArg, toTypeArgs[i])) continue;
            return false;
        }
        return true;
    }

    private static boolean isAssignableToGenericArrayType(Type from, GenericArrayType to) {
        if (from instanceof Class) {
            Class fromClass = (Class)from;
            if (!fromClass.isArray()) {
                return false;
            }
            return TypeToken.isAssignable(fromClass.getComponentType(), to.getGenericComponentType());
        }
        if (from instanceof GenericArrayType) {
            GenericArrayType fromArrayType = (GenericArrayType)from;
            return TypeToken.isAssignable(fromArrayType.getGenericComponentType(), to.getGenericComponentType());
        }
        return false;
    }

    private static boolean isAssignableFromGenericArrayType(GenericArrayType from, Type to) {
        if (to instanceof Class) {
            Class toClass = (Class)to;
            if (!toClass.isArray()) {
                return toClass == Object.class;
            }
            return TypeToken.isAssignable(from.getGenericComponentType(), toClass.getComponentType());
        }
        if (to instanceof GenericArrayType) {
            GenericArrayType toArrayType = (GenericArrayType)to;
            return TypeToken.isAssignable(from.getGenericComponentType(), toArrayType.getGenericComponentType());
        }
        return false;
    }

    private static boolean matchTypeArgument(Type from, Type to) {
        if (from.equals(to)) {
            return true;
        }
        if (to instanceof WildcardType) {
            return TypeToken.isAssignableToWildcardType(from, (WildcardType)to);
        }
        return false;
    }

    private static Type supertypeBound(Type type2) {
        if (type2 instanceof WildcardType) {
            return TypeToken.supertypeBound((WildcardType)type2);
        }
        return type2;
    }

    private static Type supertypeBound(WildcardType type2) {
        Type[] upperBounds2 = type2.getUpperBounds();
        if (upperBounds2.length == 1) {
            return TypeToken.supertypeBound(upperBounds2[0]);
        }
        if (upperBounds2.length == 0) {
            return Object.class;
        }
        throw new AssertionError((Object)("There should be at most one upper bound for wildcard type: " + type2));
    }

    @Nullable
    private static Type subtypeBound(Type type2) {
        if (type2 instanceof WildcardType) {
            return TypeToken.subtypeBound((WildcardType)type2);
        }
        return type2;
    }

    @Nullable
    private static Type subtypeBound(WildcardType type2) {
        Type[] lowerBounds = type2.getLowerBounds();
        if (lowerBounds.length == 1) {
            return TypeToken.subtypeBound(lowerBounds[0]);
        }
        if (lowerBounds.length == 0) {
            return null;
        }
        throw new AssertionError((Object)("Wildcard should have at most one lower bound: " + type2));
    }

    @VisibleForTesting
    static Class<?> getRawType(Type type2) {
        return (Class)TypeToken.getRawTypes(type2).iterator().next();
    }

    @VisibleForTesting
    static ImmutableSet<Class<?>> getRawTypes(Type type2) {
        if (type2 instanceof Class) {
            return ImmutableSet.of((Class)type2);
        }
        if (type2 instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType)type2;
            return ImmutableSet.of((Class)parameterizedType.getRawType());
        }
        if (type2 instanceof GenericArrayType) {
            GenericArrayType genericArrayType = (GenericArrayType)type2;
            return ImmutableSet.of(Types.getArrayClass(TypeToken.getRawType(genericArrayType.getGenericComponentType())));
        }
        if (type2 instanceof TypeVariable) {
            return TypeToken.getRawTypes(((TypeVariable)type2).getBounds());
        }
        if (type2 instanceof WildcardType) {
            return TypeToken.getRawTypes(((WildcardType)type2).getUpperBounds());
        }
        throw new AssertionError((Object)(type2 + " unsupported"));
    }

    private static ImmutableSet<Class<?>> getRawTypes(Type[] types) {
        ImmutableSet.Builder builder = ImmutableSet.builder();
        for (Type type2 : types) {
            builder.addAll(TypeToken.getRawTypes(type2));
        }
        return builder.build();
    }

    @VisibleForTesting
    static <T> TypeToken<? extends T> toGenericType(Class<T> cls) {
        if (cls.isArray()) {
            Type arrayOfGenericType = Types.newArrayType(TypeToken.toGenericType(cls.getComponentType()).runtimeType);
            TypeToken<?> result2 = TypeToken.of(arrayOfGenericType);
            return result2;
        }
        Type[] typeParams = cls.getTypeParameters();
        if (typeParams.length > 0) {
            TypeToken<?> type2 = TypeToken.of(Types.newParameterizedType(cls, typeParams));
            return type2;
        }
        return TypeToken.of(cls);
    }

    private TypeToken<? super T> getSupertypeFromUpperBounds(Class<? super T> supertype, Type[] upperBounds2) {
        for (Type upperBound : upperBounds2) {
            TypeToken<?> bound = TypeToken.of(upperBound);
            if (!TypeToken.of(supertype).isAssignableFrom(bound)) continue;
            TypeToken<? super T> result2 = bound.getSupertype(supertype);
            return result2;
        }
        throw new IllegalArgumentException(supertype + " isn't a super type of " + this);
    }

    private TypeToken<? extends T> getSubtypeFromLowerBounds(Class<?> subclass, Type[] lowerBounds) {
        int i$ = 0;
        Type[] arr$ = lowerBounds;
        int len$ = arr$.length;
        if (i$ < len$) {
            Type lowerBound = arr$[i$];
            TypeToken<?> bound = TypeToken.of(lowerBound);
            return bound.getSubtype(subclass);
        }
        throw new IllegalArgumentException(subclass + " isn't a subclass of " + this);
    }

    private TypeToken<? super T> getArraySupertype(Class<? super T> supertype) {
        TypeToken<?> componentType = Preconditions.checkNotNull(this.getComponentType(), "%s isn't a super type of %s", supertype, this);
        TypeToken<?> componentSupertype = componentType.getSupertype(supertype.getComponentType());
        TypeToken<?> result2 = TypeToken.of(TypeToken.newArrayClassOrGenericArrayType(componentSupertype.runtimeType));
        return result2;
    }

    private TypeToken<? extends T> getArraySubtype(Class<?> subclass) {
        TypeToken<?> componentSubtype = this.getComponentType().getSubtype(subclass.getComponentType());
        TypeToken<?> result2 = TypeToken.of(TypeToken.newArrayClassOrGenericArrayType(componentSubtype.runtimeType));
        return result2;
    }

    private Type resolveTypeArgsForSubclass(Class<?> subclass) {
        if (this.runtimeType instanceof Class) {
            return subclass;
        }
        TypeToken<?> genericSubtype = TypeToken.toGenericType(subclass);
        Type supertypeWithArgsFromSubtype = genericSubtype.getSupertype(this.getRawType()).runtimeType;
        return new TypeResolver().where(supertypeWithArgsFromSubtype, this.runtimeType).resolveType(genericSubtype.runtimeType);
    }

    private static Type newArrayClassOrGenericArrayType(Type componentType) {
        return Types.JavaVersion.JAVA7.newArrayType(componentType);
    }

    private static abstract class TypeCollector<K> {
        static final TypeCollector<TypeToken<?>> FOR_GENERIC_TYPE = new TypeCollector<TypeToken<?>>(){

            @Override
            Class<?> getRawType(TypeToken<?> type2) {
                return type2.getRawType();
            }

            @Override
            Iterable<? extends TypeToken<?>> getInterfaces(TypeToken<?> type2) {
                return type2.getGenericInterfaces();
            }

            @Override
            @Nullable
            TypeToken<?> getSuperclass(TypeToken<?> type2) {
                return type2.getGenericSuperclass();
            }
        };
        static final TypeCollector<Class<?>> FOR_RAW_TYPE = new TypeCollector<Class<?>>(){

            @Override
            Class<?> getRawType(Class<?> type2) {
                return type2;
            }

            @Override
            Iterable<? extends Class<?>> getInterfaces(Class<?> type2) {
                return Arrays.asList(type2.getInterfaces());
            }

            @Override
            @Nullable
            Class<?> getSuperclass(Class<?> type2) {
                return type2.getSuperclass();
            }
        };

        private TypeCollector() {
        }

        final TypeCollector<K> classesOnly() {
            return new ForwardingTypeCollector<K>(this){

                @Override
                Iterable<? extends K> getInterfaces(K type2) {
                    return ImmutableSet.of();
                }

                @Override
                ImmutableList<K> collectTypes(Iterable<? extends K> types) {
                    ImmutableList.Builder builder = ImmutableList.builder();
                    for (Object type2 : types) {
                        if (this.getRawType(type2).isInterface()) continue;
                        builder.add(type2);
                    }
                    return super.collectTypes(builder.build());
                }
            };
        }

        final ImmutableList<K> collectTypes(K type2) {
            return this.collectTypes((Iterable<? extends K>)ImmutableList.of(type2));
        }

        ImmutableList<K> collectTypes(Iterable<? extends K> types) {
            HashMap map2 = Maps.newHashMap();
            for (K type2 : types) {
                this.collectTypes(type2, map2);
            }
            return TypeCollector.sortKeysByValue(map2, Ordering.natural().reverse());
        }

        private int collectTypes(K type2, Map<? super K, Integer> map2) {
            Integer existing = map2.get(this);
            if (existing != null) {
                return existing;
            }
            int aboveMe = this.getRawType(type2).isInterface() ? 1 : 0;
            for (K interfaceType : this.getInterfaces(type2)) {
                aboveMe = Math.max(aboveMe, this.collectTypes(interfaceType, map2));
            }
            K superclass = this.getSuperclass(type2);
            if (superclass != null) {
                aboveMe = Math.max(aboveMe, this.collectTypes(superclass, map2));
            }
            map2.put(type2, aboveMe + 1);
            return aboveMe + 1;
        }

        private static <K, V> ImmutableList<K> sortKeysByValue(final Map<K, V> map2, final Comparator<? super V> valueComparator) {
            Ordering keyOrdering = new Ordering<K>(){

                @Override
                public int compare(K left, K right) {
                    return valueComparator.compare(map2.get(left), map2.get(right));
                }
            };
            return keyOrdering.immutableSortedCopy(map2.keySet());
        }

        abstract Class<?> getRawType(K var1);

        abstract Iterable<? extends K> getInterfaces(K var1);

        @Nullable
        abstract K getSuperclass(K var1);

        private static class ForwardingTypeCollector<K>
        extends TypeCollector<K> {
            private final TypeCollector<K> delegate;

            ForwardingTypeCollector(TypeCollector<K> delegate) {
                this.delegate = delegate;
            }

            @Override
            Class<?> getRawType(K type2) {
                return this.delegate.getRawType(type2);
            }

            @Override
            Iterable<? extends K> getInterfaces(K type2) {
                return this.delegate.getInterfaces(type2);
            }

            @Override
            K getSuperclass(K type2) {
                return this.delegate.getSuperclass(type2);
            }
        }
    }

    private static final class SimpleTypeToken<T>
    extends TypeToken<T> {
        private static final long serialVersionUID = 0L;

        SimpleTypeToken(Type type2) {
            super(type2);
        }
    }

    private static enum TypeFilter implements Predicate<TypeToken<?>>
    {
        IGNORE_TYPE_VARIABLE_OR_WILDCARD{

            @Override
            public boolean apply(TypeToken<?> type2) {
                return !(((TypeToken)type2).runtimeType instanceof TypeVariable) && !(((TypeToken)type2).runtimeType instanceof WildcardType);
            }
        }
        ,
        INTERFACE_ONLY{

            @Override
            public boolean apply(TypeToken<?> type2) {
                return type2.getRawType().isInterface();
            }
        };

    }

    private final class ClassSet
    extends TypeSet {
        private transient ImmutableSet<TypeToken<? super T>> classes;
        private static final long serialVersionUID = 0L;

        private ClassSet() {
        }

        @Override
        protected Set<TypeToken<? super T>> delegate() {
            ImmutableSet result2 = this.classes;
            if (result2 == null) {
                ImmutableList<TypeToken> collectedTypes = TypeCollector.FOR_GENERIC_TYPE.classesOnly().collectTypes(TypeToken.this);
                this.classes = FluentIterable.from(collectedTypes).filter(TypeFilter.IGNORE_TYPE_VARIABLE_OR_WILDCARD).toSet();
                return this.classes;
            }
            return result2;
        }

        @Override
        public TypeSet classes() {
            return this;
        }

        @Override
        public Set<Class<? super T>> rawTypes() {
            ImmutableList<Class<?>> collectedTypes = TypeCollector.FOR_RAW_TYPE.classesOnly().collectTypes(TypeToken.this.getImmediateRawTypes());
            return ImmutableSet.copyOf(collectedTypes);
        }

        @Override
        public TypeSet interfaces() {
            throw new UnsupportedOperationException("classes().interfaces() not supported.");
        }

        private Object readResolve() {
            return TypeToken.this.getTypes().classes();
        }
    }

    private final class InterfaceSet
    extends TypeSet {
        private final transient TypeSet allTypes;
        private transient ImmutableSet<TypeToken<? super T>> interfaces;
        private static final long serialVersionUID = 0L;

        InterfaceSet(TypeSet allTypes) {
            this.allTypes = allTypes;
        }

        @Override
        protected Set<TypeToken<? super T>> delegate() {
            ImmutableSet result2 = this.interfaces;
            if (result2 == null) {
                this.interfaces = FluentIterable.from(this.allTypes).filter(TypeFilter.INTERFACE_ONLY).toSet();
                return this.interfaces;
            }
            return result2;
        }

        @Override
        public TypeSet interfaces() {
            return this;
        }

        @Override
        public Set<Class<? super T>> rawTypes() {
            ImmutableList<Class<?>> collectedTypes = TypeCollector.FOR_RAW_TYPE.collectTypes(TypeToken.this.getImmediateRawTypes());
            return FluentIterable.from(collectedTypes).filter(new Predicate<Class<?>>(){

                @Override
                public boolean apply(Class<?> type2) {
                    return type2.isInterface();
                }
            }).toSet();
        }

        @Override
        public TypeSet classes() {
            throw new UnsupportedOperationException("interfaces().classes() not supported.");
        }

        private Object readResolve() {
            return TypeToken.this.getTypes().interfaces();
        }
    }

    public class TypeSet
    extends ForwardingSet<TypeToken<? super T>>
    implements Serializable {
        private transient ImmutableSet<TypeToken<? super T>> types;
        private static final long serialVersionUID = 0L;

        TypeSet() {
        }

        public TypeSet interfaces() {
            return new InterfaceSet(this);
        }

        public TypeSet classes() {
            return new ClassSet();
        }

        @Override
        protected Set<TypeToken<? super T>> delegate() {
            ImmutableSet filteredTypes = this.types;
            if (filteredTypes == null) {
                ImmutableList<TypeToken> collectedTypes = TypeCollector.FOR_GENERIC_TYPE.collectTypes(TypeToken.this);
                this.types = FluentIterable.from(collectedTypes).filter(TypeFilter.IGNORE_TYPE_VARIABLE_OR_WILDCARD).toSet();
                return this.types;
            }
            return filteredTypes;
        }

        public Set<Class<? super T>> rawTypes() {
            ImmutableList<Class<?>> collectedTypes = TypeCollector.FOR_RAW_TYPE.collectTypes(TypeToken.this.getImmediateRawTypes());
            return ImmutableSet.copyOf(collectedTypes);
        }
    }
}

