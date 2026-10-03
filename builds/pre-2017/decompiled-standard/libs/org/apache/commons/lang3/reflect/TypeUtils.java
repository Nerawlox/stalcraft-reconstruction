/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.reflect;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.ClassUtils;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class TypeUtils {
    public static boolean isAssignable(Type type2, Type toType) {
        return TypeUtils.isAssignable(type2, toType, null);
    }

    private static boolean isAssignable(Type type2, Type toType, Map<TypeVariable<?>, Type> typeVarAssigns) {
        if (toType == null || toType instanceof Class) {
            return TypeUtils.isAssignable(type2, (Class)toType);
        }
        if (toType instanceof ParameterizedType) {
            return TypeUtils.isAssignable(type2, (ParameterizedType)toType, typeVarAssigns);
        }
        if (toType instanceof GenericArrayType) {
            return TypeUtils.isAssignable(type2, (GenericArrayType)toType, typeVarAssigns);
        }
        if (toType instanceof WildcardType) {
            return TypeUtils.isAssignable(type2, (WildcardType)toType, typeVarAssigns);
        }
        if (toType instanceof TypeVariable) {
            return TypeUtils.isAssignable(type2, (TypeVariable)toType, typeVarAssigns);
        }
        throw new IllegalStateException("found an unhandled type: " + toType);
    }

    private static boolean isAssignable(Type type2, Class<?> toClass) {
        if (type2 == null) {
            return toClass == null || !toClass.isPrimitive();
        }
        if (toClass == null) {
            return false;
        }
        if (toClass.equals(type2)) {
            return true;
        }
        if (type2 instanceof Class) {
            return ClassUtils.isAssignable((Class)type2, toClass);
        }
        if (type2 instanceof ParameterizedType) {
            return TypeUtils.isAssignable(TypeUtils.getRawType((ParameterizedType)type2), toClass);
        }
        if (type2 instanceof TypeVariable) {
            for (Type bound : ((TypeVariable)type2).getBounds()) {
                if (!TypeUtils.isAssignable(bound, toClass)) continue;
                return true;
            }
            return false;
        }
        if (type2 instanceof GenericArrayType) {
            return toClass.equals(Object.class) || toClass.isArray() && TypeUtils.isAssignable(((GenericArrayType)type2).getGenericComponentType(), toClass.getComponentType());
        }
        if (type2 instanceof WildcardType) {
            return false;
        }
        throw new IllegalStateException("found an unhandled type: " + type2);
    }

    private static boolean isAssignable(Type type2, ParameterizedType toParameterizedType, Map<TypeVariable<?>, Type> typeVarAssigns) {
        if (type2 == null) {
            return true;
        }
        if (toParameterizedType == null) {
            return false;
        }
        if (toParameterizedType.equals(type2)) {
            return true;
        }
        Class<?> toClass = TypeUtils.getRawType(toParameterizedType);
        Map<TypeVariable<?>, Type> fromTypeVarAssigns = TypeUtils.getTypeArguments(type2, toClass, null);
        if (fromTypeVarAssigns == null) {
            return false;
        }
        if (fromTypeVarAssigns.isEmpty()) {
            return true;
        }
        Map<TypeVariable<?>, Type> toTypeVarAssigns = TypeUtils.getTypeArguments(toParameterizedType, toClass, typeVarAssigns);
        for (Map.Entry<TypeVariable<?>, Type> entry : toTypeVarAssigns.entrySet()) {
            Type toTypeArg = entry.getValue();
            Type fromTypeArg = fromTypeVarAssigns.get(entry.getKey());
            if (fromTypeArg == null || toTypeArg.equals(fromTypeArg) || toTypeArg instanceof WildcardType && TypeUtils.isAssignable(fromTypeArg, toTypeArg, typeVarAssigns)) continue;
            return false;
        }
        return true;
    }

    private static boolean isAssignable(Type type2, GenericArrayType toGenericArrayType, Map<TypeVariable<?>, Type> typeVarAssigns) {
        if (type2 == null) {
            return true;
        }
        if (toGenericArrayType == null) {
            return false;
        }
        if (toGenericArrayType.equals(type2)) {
            return true;
        }
        Type toComponentType = toGenericArrayType.getGenericComponentType();
        if (type2 instanceof Class) {
            Class cls = (Class)type2;
            return cls.isArray() && TypeUtils.isAssignable(cls.getComponentType(), toComponentType, typeVarAssigns);
        }
        if (type2 instanceof GenericArrayType) {
            return TypeUtils.isAssignable(((GenericArrayType)type2).getGenericComponentType(), toComponentType, typeVarAssigns);
        }
        if (type2 instanceof WildcardType) {
            for (Type bound : TypeUtils.getImplicitUpperBounds((WildcardType)type2)) {
                if (!TypeUtils.isAssignable(bound, toGenericArrayType)) continue;
                return true;
            }
            return false;
        }
        if (type2 instanceof TypeVariable) {
            for (Type bound : TypeUtils.getImplicitBounds((TypeVariable)type2)) {
                if (!TypeUtils.isAssignable(bound, toGenericArrayType)) continue;
                return true;
            }
            return false;
        }
        if (type2 instanceof ParameterizedType) {
            return false;
        }
        throw new IllegalStateException("found an unhandled type: " + type2);
    }

    private static boolean isAssignable(Type type2, WildcardType toWildcardType, Map<TypeVariable<?>, Type> typeVarAssigns) {
        if (type2 == null) {
            return true;
        }
        if (toWildcardType == null) {
            return false;
        }
        if (toWildcardType.equals(type2)) {
            return true;
        }
        Type[] toUpperBounds = TypeUtils.getImplicitUpperBounds(toWildcardType);
        Type[] toLowerBounds = TypeUtils.getImplicitLowerBounds(toWildcardType);
        if (type2 instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType)type2;
            Type[] upperBounds2 = TypeUtils.getImplicitUpperBounds(wildcardType);
            Type[] lowerBounds = TypeUtils.getImplicitLowerBounds(wildcardType);
            for (Type toBound : toUpperBounds) {
                toBound = TypeUtils.substituteTypeVariables(toBound, typeVarAssigns);
                for (Type bound : upperBounds2) {
                    if (TypeUtils.isAssignable(bound, toBound, typeVarAssigns)) continue;
                    return false;
                }
            }
            for (Type toBound : toLowerBounds) {
                toBound = TypeUtils.substituteTypeVariables(toBound, typeVarAssigns);
                for (Type bound : lowerBounds) {
                    if (TypeUtils.isAssignable(toBound, bound, typeVarAssigns)) continue;
                    return false;
                }
            }
            return true;
        }
        for (Type toBound : toUpperBounds) {
            if (TypeUtils.isAssignable(type2, TypeUtils.substituteTypeVariables(toBound, typeVarAssigns), typeVarAssigns)) continue;
            return false;
        }
        for (Type toBound : toLowerBounds) {
            if (TypeUtils.isAssignable(TypeUtils.substituteTypeVariables(toBound, typeVarAssigns), type2, typeVarAssigns)) continue;
            return false;
        }
        return true;
    }

    private static boolean isAssignable(Type type2, TypeVariable<?> toTypeVariable, Map<TypeVariable<?>, Type> typeVarAssigns) {
        if (type2 == null) {
            return true;
        }
        if (toTypeVariable == null) {
            return false;
        }
        if (toTypeVariable.equals(type2)) {
            return true;
        }
        if (type2 instanceof TypeVariable) {
            Type[] bounds;
            for (Type bound : bounds = TypeUtils.getImplicitBounds((TypeVariable)type2)) {
                if (!TypeUtils.isAssignable(bound, toTypeVariable, typeVarAssigns)) continue;
                return true;
            }
        }
        if (type2 instanceof Class || type2 instanceof ParameterizedType || type2 instanceof GenericArrayType || type2 instanceof WildcardType) {
            return false;
        }
        throw new IllegalStateException("found an unhandled type: " + type2);
    }

    private static Type substituteTypeVariables(Type type2, Map<TypeVariable<?>, Type> typeVarAssigns) {
        if (type2 instanceof TypeVariable && typeVarAssigns != null) {
            Type replacementType = typeVarAssigns.get(type2);
            if (replacementType == null) {
                throw new IllegalArgumentException("missing assignment type for type variable " + type2);
            }
            return replacementType;
        }
        return type2;
    }

    public static Map<TypeVariable<?>, Type> getTypeArguments(ParameterizedType type2) {
        return TypeUtils.getTypeArguments(type2, TypeUtils.getRawType(type2), null);
    }

    public static Map<TypeVariable<?>, Type> getTypeArguments(Type type2, Class<?> toClass) {
        return TypeUtils.getTypeArguments(type2, toClass, null);
    }

    private static Map<TypeVariable<?>, Type> getTypeArguments(Type type2, Class<?> toClass, Map<TypeVariable<?>, Type> subtypeVarAssigns) {
        if (type2 instanceof Class) {
            return TypeUtils.getTypeArguments((Class)type2, toClass, subtypeVarAssigns);
        }
        if (type2 instanceof ParameterizedType) {
            return TypeUtils.getTypeArguments((ParameterizedType)type2, toClass, subtypeVarAssigns);
        }
        if (type2 instanceof GenericArrayType) {
            return TypeUtils.getTypeArguments(((GenericArrayType)type2).getGenericComponentType(), toClass.isArray() ? toClass.getComponentType() : toClass, subtypeVarAssigns);
        }
        if (type2 instanceof WildcardType) {
            for (Type bound : TypeUtils.getImplicitUpperBounds((WildcardType)type2)) {
                if (!TypeUtils.isAssignable(bound, toClass)) continue;
                return TypeUtils.getTypeArguments(bound, toClass, subtypeVarAssigns);
            }
            return null;
        }
        if (type2 instanceof TypeVariable) {
            for (Type bound : TypeUtils.getImplicitBounds((TypeVariable)type2)) {
                if (!TypeUtils.isAssignable(bound, toClass)) continue;
                return TypeUtils.getTypeArguments(bound, toClass, subtypeVarAssigns);
            }
            return null;
        }
        throw new IllegalStateException("found an unhandled type: " + type2);
    }

    private static Map<TypeVariable<?>, Type> getTypeArguments(ParameterizedType parameterizedType, Class<?> toClass, Map<TypeVariable<?>, Type> subtypeVarAssigns) {
        HashMap<TypeVariable<?>, Type> typeVarAssigns;
        Class<?> cls = TypeUtils.getRawType(parameterizedType);
        if (!TypeUtils.isAssignable(cls, toClass)) {
            return null;
        }
        Type ownerType = parameterizedType.getOwnerType();
        if (ownerType instanceof ParameterizedType) {
            ParameterizedType parameterizedOwnerType = (ParameterizedType)ownerType;
            typeVarAssigns = TypeUtils.getTypeArguments(parameterizedOwnerType, TypeUtils.getRawType(parameterizedOwnerType), subtypeVarAssigns);
        } else {
            typeVarAssigns = subtypeVarAssigns == null ? new HashMap() : new HashMap(subtypeVarAssigns);
        }
        Type[] typeArgs = parameterizedType.getActualTypeArguments();
        TypeVariable<Class<?>>[] typeParams = cls.getTypeParameters();
        for (int i = 0; i < typeParams.length; ++i) {
            Type typeArg = typeArgs[i];
            typeVarAssigns.put(typeParams[i], typeVarAssigns.containsKey(typeArg) ? (Type)typeVarAssigns.get(typeArg) : typeArg);
        }
        if (toClass.equals(cls)) {
            return typeVarAssigns;
        }
        return TypeUtils.getTypeArguments(TypeUtils.getClosestParentType(cls, toClass), toClass, typeVarAssigns);
    }

    private static Map<TypeVariable<?>, Type> getTypeArguments(Class<?> cls, Class<?> toClass, Map<TypeVariable<?>, Type> subtypeVarAssigns) {
        HashMap typeVarAssigns;
        if (!TypeUtils.isAssignable(cls, toClass)) {
            return null;
        }
        if (cls.isPrimitive()) {
            if (toClass.isPrimitive()) {
                return new HashMap();
            }
            cls = ClassUtils.primitiveToWrapper(cls);
        }
        HashMap hashMap = typeVarAssigns = subtypeVarAssigns == null ? new HashMap() : new HashMap(subtypeVarAssigns);
        if (cls.getTypeParameters().length > 0 || toClass.equals(cls)) {
            return typeVarAssigns;
        }
        return TypeUtils.getTypeArguments(TypeUtils.getClosestParentType(cls, toClass), toClass, typeVarAssigns);
    }

    public static Map<TypeVariable<?>, Type> determineTypeArguments(Class<?> cls, ParameterizedType superType) {
        Class<?> superClass = TypeUtils.getRawType(superType);
        if (!TypeUtils.isAssignable(cls, superClass)) {
            return null;
        }
        if (cls.equals(superClass)) {
            return TypeUtils.getTypeArguments(superType, superClass, null);
        }
        Type midType = TypeUtils.getClosestParentType(cls, superClass);
        if (midType instanceof Class) {
            return TypeUtils.determineTypeArguments((Class)midType, superType);
        }
        ParameterizedType midParameterizedType = (ParameterizedType)midType;
        Class<?> midClass = TypeUtils.getRawType(midParameterizedType);
        Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.determineTypeArguments(midClass, superType);
        TypeUtils.mapTypeVariablesToArguments(cls, midParameterizedType, typeVarAssigns);
        return typeVarAssigns;
    }

    private static <T> void mapTypeVariablesToArguments(Class<T> cls, ParameterizedType parameterizedType, Map<TypeVariable<?>, Type> typeVarAssigns) {
        Type ownerType = parameterizedType.getOwnerType();
        if (ownerType instanceof ParameterizedType) {
            TypeUtils.mapTypeVariablesToArguments(cls, (ParameterizedType)ownerType, typeVarAssigns);
        }
        Type[] typeArgs = parameterizedType.getActualTypeArguments();
        TypeVariable<Class<?>>[] typeVars = TypeUtils.getRawType(parameterizedType).getTypeParameters();
        List<TypeVariable<Class<T>>> typeVarList = Arrays.asList(cls.getTypeParameters());
        for (int i = 0; i < typeArgs.length; ++i) {
            TypeVariable<Class<?>> typeVar = typeVars[i];
            Type typeArg = typeArgs[i];
            if (!typeVarList.contains(typeArg) || !typeVarAssigns.containsKey(typeVar)) continue;
            typeVarAssigns.put((TypeVariable)typeArg, typeVarAssigns.get(typeVar));
        }
    }

    private static Type getClosestParentType(Class<?> cls, Class<?> superClass) {
        if (superClass.isInterface()) {
            Type[] interfaceTypes = cls.getGenericInterfaces();
            Type genericInterface = null;
            for (Type midType : interfaceTypes) {
                Class midClass = null;
                if (midType instanceof ParameterizedType) {
                    midClass = TypeUtils.getRawType((ParameterizedType)midType);
                } else if (midType instanceof Class) {
                    midClass = (Class)midType;
                } else {
                    throw new IllegalStateException("Unexpected generic interface type found: " + midType);
                }
                if (!TypeUtils.isAssignable((Type)midClass, superClass) || !TypeUtils.isAssignable(genericInterface, (Type)midClass)) continue;
                genericInterface = midType;
            }
            if (genericInterface != null) {
                return genericInterface;
            }
        }
        return cls.getGenericSuperclass();
    }

    public static boolean isInstance(Object value, Type type2) {
        if (type2 == null) {
            return false;
        }
        return value == null ? !(type2 instanceof Class) || !((Class)type2).isPrimitive() : TypeUtils.isAssignable(value.getClass(), type2, null);
    }

    public static Type[] normalizeUpperBounds(Type[] bounds) {
        if (bounds.length < 2) {
            return bounds;
        }
        HashSet<Type> types = new HashSet<Type>(bounds.length);
        for (Type type1 : bounds) {
            boolean subtypeFound = false;
            for (Type type2 : bounds) {
                if (type1 == type2 || !TypeUtils.isAssignable(type2, type1, null)) continue;
                subtypeFound = true;
                break;
            }
            if (subtypeFound) continue;
            types.add(type1);
        }
        return types.toArray(new Type[types.size()]);
    }

    public static Type[] getImplicitBounds(TypeVariable<?> typeVariable) {
        Type[] typeArray;
        Type[] bounds = typeVariable.getBounds();
        if (bounds.length == 0) {
            Type[] typeArray2 = new Type[1];
            typeArray = typeArray2;
            typeArray2[0] = Object.class;
        } else {
            typeArray = TypeUtils.normalizeUpperBounds(bounds);
        }
        return typeArray;
    }

    public static Type[] getImplicitUpperBounds(WildcardType wildcardType) {
        Type[] typeArray;
        Type[] bounds = wildcardType.getUpperBounds();
        if (bounds.length == 0) {
            Type[] typeArray2 = new Type[1];
            typeArray = typeArray2;
            typeArray2[0] = Object.class;
        } else {
            typeArray = TypeUtils.normalizeUpperBounds(bounds);
        }
        return typeArray;
    }

    public static Type[] getImplicitLowerBounds(WildcardType wildcardType) {
        Type[] typeArray;
        Type[] bounds = wildcardType.getLowerBounds();
        if (bounds.length == 0) {
            Type[] typeArray2 = new Type[1];
            typeArray = typeArray2;
            typeArray2[0] = null;
        } else {
            typeArray = bounds;
        }
        return typeArray;
    }

    public static boolean typesSatisfyVariables(Map<TypeVariable<?>, Type> typeVarAssigns) {
        for (Map.Entry<TypeVariable<?>, Type> entry : typeVarAssigns.entrySet()) {
            TypeVariable<?> typeVar = entry.getKey();
            Type type2 = entry.getValue();
            for (Type bound : TypeUtils.getImplicitBounds(typeVar)) {
                if (TypeUtils.isAssignable(type2, TypeUtils.substituteTypeVariables(bound, typeVarAssigns), typeVarAssigns)) continue;
                return false;
            }
        }
        return true;
    }

    private static Class<?> getRawType(ParameterizedType parameterizedType) {
        Type rawType = parameterizedType.getRawType();
        if (!(rawType instanceof Class)) {
            throw new IllegalStateException("Wait... What!? Type of rawType: " + rawType);
        }
        return (Class)rawType;
    }

    public static Class<?> getRawType(Type type2, Type assigningType) {
        if (type2 instanceof Class) {
            return (Class)type2;
        }
        if (type2 instanceof ParameterizedType) {
            return TypeUtils.getRawType((ParameterizedType)type2);
        }
        if (type2 instanceof TypeVariable) {
            if (assigningType == null) {
                return null;
            }
            Object genericDeclaration = ((TypeVariable)type2).getGenericDeclaration();
            if (!(genericDeclaration instanceof Class)) {
                return null;
            }
            Map<TypeVariable<?>, Type> typeVarAssigns = TypeUtils.getTypeArguments(assigningType, (Class)genericDeclaration);
            if (typeVarAssigns == null) {
                return null;
            }
            Type typeArgument = typeVarAssigns.get(type2);
            if (typeArgument == null) {
                return null;
            }
            return TypeUtils.getRawType(typeArgument, assigningType);
        }
        if (type2 instanceof GenericArrayType) {
            Class<?> rawComponentType = TypeUtils.getRawType(((GenericArrayType)type2).getGenericComponentType(), assigningType);
            return Array.newInstance(rawComponentType, 0).getClass();
        }
        if (type2 instanceof WildcardType) {
            return null;
        }
        throw new IllegalArgumentException("unknown type: " + type2);
    }

    public static boolean isArrayType(Type type2) {
        return type2 instanceof GenericArrayType || type2 instanceof Class && ((Class)type2).isArray();
    }

    public static Type getArrayComponentType(Type type2) {
        if (type2 instanceof Class) {
            Class clazz = (Class)type2;
            return clazz.isArray() ? clazz.getComponentType() : null;
        }
        if (type2 instanceof GenericArrayType) {
            return ((GenericArrayType)type2).getGenericComponentType();
        }
        return null;
    }
}

