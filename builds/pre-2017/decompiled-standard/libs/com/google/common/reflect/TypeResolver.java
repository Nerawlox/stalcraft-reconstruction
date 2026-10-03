/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.reflect;

import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.reflect.Types;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;

class TypeResolver {
    private final ImmutableMap<TypeVariable<?>, Type> typeTable;

    public TypeResolver() {
        this.typeTable = ImmutableMap.of();
    }

    private TypeResolver(ImmutableMap<TypeVariable<?>, Type> typeTable) {
        this.typeTable = typeTable;
    }

    static TypeResolver accordingTo(Type type2) {
        return new TypeResolver().where(TypeMappingIntrospector.getTypeMappings(type2));
    }

    public final TypeResolver where(Type formal, Type actual) {
        HashMap<TypeVariable<?>, Type> mappings = Maps.newHashMap();
        TypeResolver.populateTypeMappings(mappings, Preconditions.checkNotNull(formal), Preconditions.checkNotNull(actual));
        return this.where(mappings);
    }

    final TypeResolver where(Map<? extends TypeVariable<?>, ? extends Type> mappings) {
        ImmutableMap.Builder<TypeVariable<?>, Type> builder = ImmutableMap.builder();
        builder.putAll(this.typeTable);
        for (Map.Entry<TypeVariable<?>, Type> mapping : mappings.entrySet()) {
            Type type2;
            TypeVariable<?> variable = mapping.getKey();
            Preconditions.checkArgument(!variable.equals(type2 = mapping.getValue()), "Type variable %s bound to itself", variable);
            builder.put(variable, type2);
        }
        return new TypeResolver(builder.build());
    }

    private static void populateTypeMappings(Map<TypeVariable<?>, Type> mappings, Type from, Type to) {
        if (from.equals(to)) {
            return;
        }
        if (from instanceof TypeVariable) {
            mappings.put((TypeVariable)from, to);
        } else if (from instanceof GenericArrayType) {
            TypeResolver.populateTypeMappings(mappings, ((GenericArrayType)from).getGenericComponentType(), TypeResolver.checkNonNullArgument(Types.getComponentType(to), "%s is not an array type.", to));
        } else if (from instanceof ParameterizedType) {
            ParameterizedType fromParameterizedType = (ParameterizedType)from;
            ParameterizedType toParameterizedType = TypeResolver.expectArgument(ParameterizedType.class, to);
            Preconditions.checkArgument(fromParameterizedType.getRawType().equals(toParameterizedType.getRawType()), "Inconsistent raw type: %s vs. %s", from, to);
            Type[] fromArgs = fromParameterizedType.getActualTypeArguments();
            Type[] toArgs = toParameterizedType.getActualTypeArguments();
            Preconditions.checkArgument(fromArgs.length == toArgs.length);
            for (int i = 0; i < fromArgs.length; ++i) {
                TypeResolver.populateTypeMappings(mappings, fromArgs[i], toArgs[i]);
            }
        } else if (from instanceof WildcardType) {
            int i;
            WildcardType fromWildcardType = (WildcardType)from;
            WildcardType toWildcardType = TypeResolver.expectArgument(WildcardType.class, to);
            Type[] fromUpperBounds = fromWildcardType.getUpperBounds();
            Type[] toUpperBounds = toWildcardType.getUpperBounds();
            Type[] fromLowerBounds = fromWildcardType.getLowerBounds();
            Type[] toLowerBounds = toWildcardType.getLowerBounds();
            Preconditions.checkArgument(fromUpperBounds.length == toUpperBounds.length && fromLowerBounds.length == toLowerBounds.length, "Incompatible type: %s vs. %s", from, to);
            for (i = 0; i < fromUpperBounds.length; ++i) {
                TypeResolver.populateTypeMappings(mappings, fromUpperBounds[i], toUpperBounds[i]);
            }
            for (i = 0; i < fromLowerBounds.length; ++i) {
                TypeResolver.populateTypeMappings(mappings, fromLowerBounds[i], toLowerBounds[i]);
            }
        } else {
            throw new IllegalArgumentException("No type mapping from " + from);
        }
    }

    public final Type resolveType(Type type2) {
        Preconditions.checkNotNull(type2);
        if (type2 instanceof TypeVariable) {
            return this.resolveTypeVariable((TypeVariable)type2);
        }
        if (type2 instanceof ParameterizedType) {
            return this.resolveParameterizedType((ParameterizedType)type2);
        }
        if (type2 instanceof GenericArrayType) {
            return this.resolveGenericArrayType((GenericArrayType)type2);
        }
        if (type2 instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType)type2;
            return new Types.WildcardTypeImpl(this.resolveTypes(wildcardType.getLowerBounds()), this.resolveTypes(wildcardType.getUpperBounds()));
        }
        return type2;
    }

    private Type[] resolveTypes(Type[] types) {
        Type[] result2 = new Type[types.length];
        for (int i = 0; i < types.length; ++i) {
            result2[i] = this.resolveType(types[i]);
        }
        return result2;
    }

    private Type resolveGenericArrayType(GenericArrayType type2) {
        Type componentType = this.resolveType(type2.getGenericComponentType());
        return Types.newArrayType(componentType);
    }

    private Type resolveTypeVariable(final TypeVariable<?> var) {
        final TypeResolver unguarded = this;
        TypeResolver guarded = new TypeResolver(this.typeTable){

            @Override
            Type resolveTypeVariable(TypeVariable<?> intermediateVar, TypeResolver guardedResolver) {
                if (intermediateVar.getGenericDeclaration().equals(var.getGenericDeclaration())) {
                    return intermediateVar;
                }
                return unguarded.resolveTypeVariable(intermediateVar, guardedResolver);
            }
        };
        return this.resolveTypeVariable(var, guarded);
    }

    Type resolveTypeVariable(TypeVariable<?> var, TypeResolver guardedResolver) {
        Preconditions.checkNotNull(guardedResolver);
        Type type2 = this.typeTable.get(var);
        if (type2 == null) {
            Type[] bounds = var.getBounds();
            if (bounds.length == 0) {
                return var;
            }
            return Types.newTypeVariable(var.getGenericDeclaration(), var.getName(), guardedResolver.resolveTypes(bounds));
        }
        return guardedResolver.resolveType(type2);
    }

    private ParameterizedType resolveParameterizedType(ParameterizedType type2) {
        Type owner = type2.getOwnerType();
        Type resolvedOwner = owner == null ? null : this.resolveType(owner);
        Type resolvedRawType = this.resolveType(type2.getRawType());
        Type[] vars = type2.getActualTypeArguments();
        Type[] resolvedArgs = new Type[vars.length];
        for (int i = 0; i < vars.length; ++i) {
            resolvedArgs[i] = this.resolveType(vars[i]);
        }
        return Types.newParameterizedTypeWithOwner(resolvedOwner, (Class)resolvedRawType, resolvedArgs);
    }

    private static <T> T checkNonNullArgument(T arg, String format, Object ... messageParams) {
        Preconditions.checkArgument(arg != null, format, messageParams);
        return arg;
    }

    private static <T> T expectArgument(Class<T> type2, Object arg) {
        try {
            return type2.cast(arg);
        }
        catch (ClassCastException e) {
            throw new IllegalArgumentException(arg + " is not a " + type2.getSimpleName());
        }
    }

    private static final class WildcardCapturer {
        private final AtomicInteger id = new AtomicInteger();

        private WildcardCapturer() {
        }

        Type capture(Type type2) {
            Preconditions.checkNotNull(type2);
            if (type2 instanceof Class) {
                return type2;
            }
            if (type2 instanceof TypeVariable) {
                return type2;
            }
            if (type2 instanceof GenericArrayType) {
                GenericArrayType arrayType = (GenericArrayType)type2;
                return Types.newArrayType(this.capture(arrayType.getGenericComponentType()));
            }
            if (type2 instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType)type2;
                return Types.newParameterizedTypeWithOwner(this.captureNullable(parameterizedType.getOwnerType()), (Class)parameterizedType.getRawType(), this.capture(parameterizedType.getActualTypeArguments()));
            }
            if (type2 instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType)type2;
                Type[] lowerBounds = wildcardType.getLowerBounds();
                if (lowerBounds.length == 0) {
                    Object[] upperBounds2 = wildcardType.getUpperBounds();
                    String name2 = "capture#" + this.id.incrementAndGet() + "-of ? extends " + Joiner.on('&').join(upperBounds2);
                    return Types.newTypeVariable(WildcardCapturer.class, name2, wildcardType.getUpperBounds());
                }
                return type2;
            }
            throw new AssertionError((Object)"must have been one of the known types");
        }

        private Type captureNullable(@Nullable Type type2) {
            if (type2 == null) {
                return null;
            }
            return this.capture(type2);
        }

        private Type[] capture(Type[] types) {
            Type[] result2 = new Type[types.length];
            for (int i = 0; i < types.length; ++i) {
                result2[i] = this.capture(types[i]);
            }
            return result2;
        }
    }

    private static final class TypeMappingIntrospector {
        private static final WildcardCapturer wildcardCapturer = new WildcardCapturer();
        private final Map<TypeVariable<?>, Type> mappings = Maps.newHashMap();
        private final Set<Type> introspectedTypes = Sets.newHashSet();

        private TypeMappingIntrospector() {
        }

        static ImmutableMap<TypeVariable<?>, Type> getTypeMappings(Type contextType) {
            TypeMappingIntrospector introspector = new TypeMappingIntrospector();
            introspector.introspect(wildcardCapturer.capture(contextType));
            return ImmutableMap.copyOf(introspector.mappings);
        }

        private void introspect(Type type2) {
            block4: {
                block6: {
                    block5: {
                        block3: {
                            if (!this.introspectedTypes.add(type2)) {
                                return;
                            }
                            if (!(type2 instanceof ParameterizedType)) break block3;
                            this.introspectParameterizedType((ParameterizedType)type2);
                            break block4;
                        }
                        if (!(type2 instanceof Class)) break block5;
                        this.introspectClass((Class)type2);
                        break block4;
                    }
                    if (!(type2 instanceof TypeVariable)) break block6;
                    for (Type bound : ((TypeVariable)type2).getBounds()) {
                        this.introspect(bound);
                    }
                    break block4;
                }
                if (!(type2 instanceof WildcardType)) break block4;
                for (Type bound : ((WildcardType)type2).getUpperBounds()) {
                    this.introspect(bound);
                }
            }
        }

        private void introspectClass(Class<?> clazz) {
            this.introspect(clazz.getGenericSuperclass());
            for (Type interfaceType : clazz.getGenericInterfaces()) {
                this.introspect(interfaceType);
            }
        }

        private void introspectParameterizedType(ParameterizedType parameterizedType) {
            Type[] typeArgs;
            Class rawClass = (Class)parameterizedType.getRawType();
            TypeVariable<Class<T>>[] vars = rawClass.getTypeParameters();
            Preconditions.checkState(vars.length == (typeArgs = parameterizedType.getActualTypeArguments()).length);
            for (int i = 0; i < vars.length; ++i) {
                this.map(vars[i], typeArgs[i]);
            }
            this.introspectClass(rawClass);
            this.introspect(parameterizedType.getOwnerType());
        }

        private void map(TypeVariable<?> var, Type arg) {
            if (this.mappings.containsKey(var)) {
                return;
            }
            Type t = arg;
            while (t != null) {
                if (var.equals(t)) {
                    Type x = arg;
                    while (x != null) {
                        x = this.mappings.remove(x);
                    }
                    return;
                }
                t = this.mappings.get(t);
            }
            this.mappings.put(var, arg);
        }
    }
}

