/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.structure.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.LightClassOriginKind;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaAnnotationOwner;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaConstructor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaElement;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaModifierListOwner;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ReflectJavaClass
extends ReflectJavaElement
implements ReflectJavaAnnotationOwner,
ReflectJavaModifierListOwner,
JavaClass {
    private final Class<?> klass;

    @Override
    @NotNull
    public Class<?> getElement() {
        return this.klass;
    }

    @Override
    public int getModifiers() {
        return this.klass.getModifiers();
    }

    @NotNull
    public List<ReflectJavaClass> getInnerClasses() {
        return SequencesKt.toList(SequencesKt.map(SequencesKt.filterNot(ArraysKt.asSequence((Object[])this.klass.getDeclaredClasses()), innerClasses.1.INSTANCE), innerClasses.2.INSTANCE));
    }

    @Override
    @NotNull
    public FqName getFqName() {
        FqName fqName2 = ReflectClassUtilKt.getClassId(this.klass).asSingleFqName();
        Intrinsics.checkExpressionValueIsNotNull(fqName2, "klass.classId.asSingleFqName()");
        return fqName2;
    }

    @Override
    @Nullable
    public ReflectJavaClass getOuterClass() {
        ReflectJavaClass reflectJavaClass;
        Class<?> clazz = this.klass.getDeclaringClass();
        if (clazz != null) {
            Class<?> clazz2;
            Class<?> p1 = clazz2 = clazz;
            reflectJavaClass = new ReflectJavaClass(p1);
        } else {
            reflectJavaClass = null;
        }
        return reflectJavaClass;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public Collection<JavaClassifierType> getSupertypes() {
        void var3_3;
        void $receiver$iv$iv;
        Iterable $receiver$iv;
        if (Intrinsics.areEqual(this.klass, Object.class)) {
            return CollectionsKt.emptyList();
        }
        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
        Type type2 = this.klass.getGenericSuperclass();
        if (type2 == null) {
            type2 = (Type)((Object)Object.class);
        }
        spreadBuilder.add(type2);
        Type[] typeArray = this.klass.getGenericInterfaces();
        Intrinsics.checkExpressionValueIsNotNull(typeArray, "klass.genericInterfaces");
        spreadBuilder.addSpread(typeArray);
        Iterable iterable = $receiver$iv = (Iterable)CollectionsKt.listOf((Type[])spreadBuilder.toArray(new Type[spreadBuilder.size()]));
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        for (Object item$iv$iv : $receiver$iv$iv) {
            void p1;
            Type type3 = (Type)item$iv$iv;
            Collection collection = destination$iv$iv;
            ReflectJavaClassifierType reflectJavaClassifierType = new ReflectJavaClassifierType((Type)p1);
            collection.add(reflectJavaClassifierType);
        }
        return (List)var3_3;
    }

    @NotNull
    public List<ReflectJavaMethod> getMethods() {
        return SequencesKt.toList(SequencesKt.map(SequencesKt.filter(ArraysKt.asSequence((Object[])this.klass.getDeclaredMethods()), (Function1)new Function1<Method, Boolean>(this){
            final /* synthetic */ ReflectJavaClass this$0;

            public final boolean invoke(Method method) {
                boolean bl;
                if (method.isSynthetic()) {
                    bl = false;
                } else if (this.this$0.isEnum()) {
                    Method method2 = method;
                    Intrinsics.checkExpressionValueIsNotNull(method2, "method");
                    bl = !ReflectJavaClass.access$isEnumValuesOrValueOf(this.this$0, method2);
                } else {
                    bl = true;
                }
                return bl;
            }
            {
                this.this$0 = reflectJavaClass;
                super(1);
            }
        }), methods.2.INSTANCE));
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    private final boolean isEnumValuesOrValueOf(Method method) {
        block4: {
            void elements$iv;
            block5: {
                String string;
                String string2 = string = method.getName();
                if (string2 == null) break block4;
                switch (string2.hashCode()) {
                    case -823812830: {
                        if (!string.equals("values")) return false;
                        break;
                    }
                    case 231605032: {
                        if (!string.equals("valueOf")) return false;
                        break block5;
                    }
                }
                Object[] objectArray = method.getParameterTypes();
                if (objectArray.length != 0) return false;
                return true;
            }
            Class[] classArray = new Class[]{String.class};
            Object[] objectArray = method.getParameterTypes();
            Object[] objectArray2 = (Object[])elements$iv;
            boolean bl = Arrays.equals(objectArray, objectArray2);
            return bl;
        }
        return false;
    }

    @NotNull
    public List<ReflectJavaField> getFields() {
        return SequencesKt.toList(SequencesKt.map(SequencesKt.filter(ArraysKt.asSequence((Object[])this.klass.getDeclaredFields()), fields.1.INSTANCE), fields.2.INSTANCE));
    }

    @NotNull
    public List<ReflectJavaConstructor> getConstructors() {
        return SequencesKt.toList(SequencesKt.map(SequencesKt.filter(ArraysKt.asSequence((Object[])this.klass.getDeclaredConstructors()), constructors.1.INSTANCE), constructors.2.INSTANCE));
    }

    @Override
    @Nullable
    public LightClassOriginKind getLightClassOriginKind() {
        return null;
    }

    @Override
    @NotNull
    public Name getName() {
        Name name2 = Name.identifier(this.klass.getSimpleName());
        Intrinsics.checkExpressionValueIsNotNull(name2, "Name.identifier(klass.simpleName)");
        return name2;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public List<ReflectJavaTypeParameter> getTypeParameters() {
        void var3_3;
        void $receiver$iv$iv;
        Object[] $receiver$iv;
        Object[] objectArray = $receiver$iv = (Object[])this.klass.getTypeParameters();
        Collection destination$iv$iv = new ArrayList($receiver$iv.length);
        for (int i = 0; i < ((void)$receiver$iv$iv).length; ++i) {
            void it;
            void item$iv$iv = $receiver$iv$iv[i];
            TypeVariable typeVariable = (TypeVariable)item$iv$iv;
            Collection collection = destination$iv$iv;
            void v0 = it;
            Intrinsics.checkExpressionValueIsNotNull(v0, "it");
            ReflectJavaTypeParameter reflectJavaTypeParameter = new ReflectJavaTypeParameter((TypeVariable<?>)v0);
            collection.add(reflectJavaTypeParameter);
        }
        return (List)var3_3;
    }

    @Override
    public boolean isInterface() {
        return this.klass.isInterface();
    }

    @Override
    public boolean isAnnotationType() {
        return this.klass.isAnnotation();
    }

    @Override
    public boolean isEnum() {
        return this.klass.isEnum();
    }

    public boolean equals(@Nullable Object other) {
        return other instanceof ReflectJavaClass && Intrinsics.areEqual(this.klass, ((ReflectJavaClass)other).klass);
    }

    public int hashCode() {
        return this.klass.hashCode();
    }

    @NotNull
    public String toString() {
        return this.getClass().getName() + ": " + this.klass;
    }

    public ReflectJavaClass(@NotNull Class<?> klass) {
        Intrinsics.checkParameterIsNotNull(klass, "klass");
        this.klass = klass;
    }

    @Override
    @NotNull
    public List<ReflectJavaAnnotation> getAnnotations() {
        return ReflectJavaAnnotationOwner.DefaultImpls.getAnnotations(this);
    }

    @Override
    @Nullable
    public ReflectJavaAnnotation findAnnotation(@NotNull FqName fqName2) {
        Intrinsics.checkParameterIsNotNull(fqName2, "fqName");
        return ReflectJavaAnnotationOwner.DefaultImpls.findAnnotation(this, fqName2);
    }

    @Override
    public boolean isDeprecatedInJavaDoc() {
        return ReflectJavaAnnotationOwner.DefaultImpls.isDeprecatedInJavaDoc(this);
    }

    @Override
    public boolean isAbstract() {
        return ReflectJavaModifierListOwner.DefaultImpls.isAbstract(this);
    }

    @Override
    public boolean isStatic() {
        return ReflectJavaModifierListOwner.DefaultImpls.isStatic(this);
    }

    @Override
    public boolean isFinal() {
        return ReflectJavaModifierListOwner.DefaultImpls.isFinal(this);
    }

    @Override
    @NotNull
    public Visibility getVisibility() {
        return ReflectJavaModifierListOwner.DefaultImpls.getVisibility(this);
    }

    public static final /* synthetic */ boolean access$isEnumValuesOrValueOf(ReflectJavaClass $this, @NotNull Method method) {
        return $this.isEnumValuesOrValueOf(method);
    }
}

