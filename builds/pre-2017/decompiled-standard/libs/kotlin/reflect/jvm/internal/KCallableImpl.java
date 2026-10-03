/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KCallable;
import kotlin.reflect.KParameter;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVisibility;
import kotlin.reflect.full.IllegalCallableAccessException;
import kotlin.reflect.jvm.ReflectJvmMapping;
import kotlin.reflect.jvm.internal.FunctionCaller;
import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;
import kotlin.reflect.jvm.internal.KParameterImpl;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.KTypeParameterImpl;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.UtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J%\u00106\u001a\u00028\u00002\u0016\u00107\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010908\"\u0004\u0018\u000109H\u0017\u00a2\u0006\u0002\u0010:J#\u0010;\u001a\u00028\u00002\u0014\u00107\u001a\u0010\u0012\u0004\u0012\u00020#\u0012\u0006\u0012\u0004\u0018\u0001090<H\u0002\u00a2\u0006\u0002\u0010=J#\u0010>\u001a\u00028\u00002\u0014\u00107\u001a\u0010\u0012\u0004\u0012\u00020#\u0012\u0006\u0012\u0004\u0018\u0001090<H\u0016\u00a2\u0006\u0002\u0010=J#\u0010?\u001a\u00028\u00002\u0014\u00107\u001a\u0010\u0012\u0004\u0012\u00020#\u0012\u0006\u0012\u0004\u0018\u0001090<H\u0002\u00a2\u0006\u0002\u0010=J\u0012\u0010@\u001a\u0004\u0018\u0001092\u0006\u0010A\u001a\u00020BH\u0002R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR-\u0010\t\u001a!\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0006 \u000b*\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00050\u00050\n\u00a2\u0006\u0002\b\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000eX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\u0012X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0015\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000eX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0010R\u0012\u0010\u0017\u001a\u00020\u0018X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u001c8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u001c8DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u001dR\u0012\u0010\u001f\u001a\u00020\u001cX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010\u001dR\u0014\u0010 \u001a\u00020\u001c8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b \u0010\u001dR\u0014\u0010!\u001a\u00020\u001c8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b!\u0010\u001dR\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u00058VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b$\u0010\bR-\u0010%\u001a!\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020# \u000b*\n\u0012\u0004\u0012\u00020#\u0018\u00010&0&0\n\u00a2\u0006\u0002\b\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010'\u001a\u00020(8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b)\u0010*R!\u0010+\u001a\u0015\u0012\f\u0012\n \u000b*\u0004\u0018\u00010,0,0\n\u00a2\u0006\u0002\b\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020.0\u00058VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b/\u0010\bR-\u00100\u001a!\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u000201 \u000b*\n\u0012\u0004\u0012\u000201\u0018\u00010\u00050\u00050\n\u00a2\u0006\u0002\b\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u00102\u001a\u0004\u0018\u0001038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b4\u00105\u00a8\u0006C"}, d2={"Lkotlin/reflect/jvm/internal/KCallableImpl;", "R", "Lkotlin/reflect/KCallable;", "()V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "annotations_", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "kotlin.jvm.PlatformType", "Lorg/jetbrains/annotations/NotNull;", "caller", "Lkotlin/reflect/jvm/internal/FunctionCaller;", "getCaller", "()Lkotlin/reflect/jvm/internal/FunctionCaller;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "getDefaultCaller", "descriptor", "Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;", "isAbstract", "", "()Z", "isAnnotationConstructor", "isBound", "isFinal", "isOpen", "parameters", "Lkotlin/reflect/KParameter;", "getParameters", "parameters_", "Ljava/util/ArrayList;", "returnType", "Lkotlin/reflect/KType;", "getReturnType", "()Lkotlin/reflect/KType;", "returnType_", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "typeParameters_", "Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "visibility", "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", "call", "args", "", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "callAnnotationConstructor", "", "(Ljava/util/Map;)Ljava/lang/Object;", "callBy", "callDefaultMethod", "defaultPrimitiveValue", "type", "Ljava/lang/reflect/Type;", "kotlin-reflection"})
public abstract class KCallableImpl<R>
implements KCallable<R> {
    private final ReflectProperties.LazySoftVal<List<Annotation>> annotations_ = ReflectProperties.lazySoft((Function0)new Function0<List<? extends Annotation>>(this){
        final /* synthetic */ KCallableImpl this$0;

        @NotNull
        public final List<Annotation> invoke() {
            return UtilKt.computeAnnotations(this.this$0.getDescriptor());
        }
        {
            this.this$0 = kCallableImpl;
            super(0);
        }
    });
    private final ReflectProperties.LazySoftVal<ArrayList<KParameter>> parameters_ = ReflectProperties.lazySoft((Function0)new Function0<ArrayList<KParameter>>(this){
        final /* synthetic */ KCallableImpl this$0;

        /*
         * WARNING - void declaration
         */
        @NotNull
        public final ArrayList<KParameter> invoke() {
            void var2_2;
            List $receiver$iv;
            int n;
            int n2;
            CallableMemberDescriptor descriptor2 = this.this$0.getDescriptor();
            ArrayList<KParameterImpl> result2 = new ArrayList<KParameterImpl>();
            int index = 0;
            if (descriptor2.getDispatchReceiverParameter() != null && !this.this$0.isBound()) {
                result2.add(new KParameterImpl(this.this$0, index++, KParameter.Kind.INSTANCE, (Function0<? extends ParameterDescriptor>)new Function0<ReceiverParameterDescriptor>(descriptor2){
                    final /* synthetic */ CallableMemberDescriptor $descriptor;

                    @NotNull
                    public final ReceiverParameterDescriptor invoke() {
                        ReceiverParameterDescriptor receiverParameterDescriptor = this.$descriptor.getDispatchReceiverParameter();
                        if (receiverParameterDescriptor == null) {
                            Intrinsics.throwNpe();
                        }
                        return receiverParameterDescriptor;
                    }
                    {
                        this.$descriptor = callableMemberDescriptor;
                        super(0);
                    }
                }));
            }
            if (descriptor2.getExtensionReceiverParameter() != null && !this.this$0.isBound()) {
                result2.add(new KParameterImpl(this.this$0, index++, KParameter.Kind.EXTENSION_RECEIVER, (Function0<? extends ParameterDescriptor>)new Function0<ReceiverParameterDescriptor>(descriptor2){
                    final /* synthetic */ CallableMemberDescriptor $descriptor;

                    @NotNull
                    public final ReceiverParameterDescriptor invoke() {
                        ReceiverParameterDescriptor receiverParameterDescriptor = this.$descriptor.getExtensionReceiverParameter();
                        if (receiverParameterDescriptor == null) {
                            Intrinsics.throwNpe();
                        }
                        return receiverParameterDescriptor;
                    }
                    {
                        this.$descriptor = callableMemberDescriptor;
                        super(0);
                    }
                }));
            }
            if ((n2 = 0) <= (n = ((Collection)descriptor2.getValueParameters()).size() - 1)) {
                while (true) {
                    void i;
                    result2.add(new KParameterImpl(this.this$0, index++, KParameter.Kind.VALUE, (Function0<? extends ParameterDescriptor>)new Function0<ValueParameterDescriptor>(descriptor2, (int)i){
                        final /* synthetic */ CallableMemberDescriptor $descriptor;
                        final /* synthetic */ int $i;

                        public final ValueParameterDescriptor invoke() {
                            ValueParameterDescriptor valueParameterDescriptor = this.$descriptor.getValueParameters().get(this.$i);
                            Intrinsics.checkExpressionValueIsNotNull(valueParameterDescriptor, "descriptor.valueParameters[i]");
                            return valueParameterDescriptor;
                        }
                        {
                            this.$descriptor = callableMemberDescriptor;
                            this.$i = n;
                            super(0);
                        }
                    }));
                    if (i == n) break;
                    ++i;
                }
            }
            if (this.this$0.isAnnotationConstructor() && descriptor2 instanceof JavaCallableMemberDescriptor && ($receiver$iv = (List)result2).size() > 1) {
                List list = $receiver$iv;
                Comparator comparator = new Comparator<KParameter>(){

                    /*
                     * Ignored method signature, as it can't be verified against descriptor
                     */
                    public int compare(Object a, Object b) {
                        KParameter it = (KParameter)a;
                        Comparable comparable = (Comparable)((Object)it.getName());
                        it = (KParameter)b;
                        Comparable comparable2 = comparable;
                        String string = it.getName();
                        return ComparisonsKt.compareValues(comparable2, (Comparable)((Object)string));
                    }
                };
                CollectionsKt.sortWith(list, comparator);
            }
            result2.trimToSize();
            return var2_2;
        }
        {
            this.this$0 = kCallableImpl;
            super(0);
        }
    });
    private final ReflectProperties.LazySoftVal<KTypeImpl> returnType_ = ReflectProperties.lazySoft((Function0)new Function0<KTypeImpl>(this){
        final /* synthetic */ KCallableImpl this$0;

        @NotNull
        public final KTypeImpl invoke() {
            KotlinType kotlinType = this.this$0.getDescriptor().getReturnType();
            if (kotlinType == null) {
                Intrinsics.throwNpe();
            }
            Intrinsics.checkExpressionValueIsNotNull(kotlinType, "descriptor.returnType!!");
            return new KTypeImpl(kotlinType, (Function0<? extends Type>)new Function0<Type>(this){
                final /* synthetic */ returnType_.1 this$0;

                @NotNull
                public final Type invoke() {
                    return this.this$0.this$0.getCaller().getReturnType$kotlin_reflection();
                }
                {
                    this.this$0 = var1_1;
                    super(0);
                }
            });
        }
        {
            this.this$0 = kCallableImpl;
            super(0);
        }
    });
    private final ReflectProperties.LazySoftVal<List<KTypeParameterImpl>> typeParameters_ = ReflectProperties.lazySoft((Function0)new Function0<List<? extends KTypeParameterImpl>>(this){
        final /* synthetic */ KCallableImpl this$0;

        /*
         * WARNING - void declaration
         */
        @NotNull
        public final List<KTypeParameterImpl> invoke() {
            void var3_3;
            void $receiver$iv$iv;
            Iterable $receiver$iv;
            Iterable iterable = $receiver$iv = (Iterable)this.this$0.getDescriptor().getTypeParameters();
            Collection destination$iv$iv = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
            for (T item$iv$iv : $receiver$iv$iv) {
                void p1;
                TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor)item$iv$iv;
                Collection collection = destination$iv$iv;
                KTypeParameterImpl kTypeParameterImpl = new KTypeParameterImpl((TypeParameterDescriptor)p1);
                collection.add(kTypeParameterImpl);
            }
            return (List)var3_3;
        }
        {
            this.this$0 = kCallableImpl;
            super(0);
        }
    });

    @NotNull
    public abstract CallableMemberDescriptor getDescriptor();

    @NotNull
    public abstract FunctionCaller<?> getCaller();

    @Nullable
    public abstract FunctionCaller<?> getDefaultCaller();

    @NotNull
    public abstract KDeclarationContainerImpl getContainer();

    public abstract boolean isBound();

    @Override
    @NotNull
    public List<Annotation> getAnnotations() {
        List<Annotation> list = this.annotations_.invoke();
        Intrinsics.checkExpressionValueIsNotNull(list, "annotations_()");
        return list;
    }

    @Override
    @NotNull
    public List<KParameter> getParameters() {
        ArrayList<KParameter> arrayList = this.parameters_.invoke();
        Intrinsics.checkExpressionValueIsNotNull(arrayList, "parameters_()");
        return arrayList;
    }

    @Override
    @NotNull
    public KType getReturnType() {
        KTypeImpl kTypeImpl = this.returnType_.invoke();
        Intrinsics.checkExpressionValueIsNotNull(kTypeImpl, "returnType_()");
        return kTypeImpl;
    }

    @Override
    @NotNull
    public List<KTypeParameter> getTypeParameters() {
        List<KTypeParameter> list = this.typeParameters_.invoke();
        Intrinsics.checkExpressionValueIsNotNull(list, "typeParameters_()");
        return list;
    }

    @Override
    @Nullable
    public KVisibility getVisibility() {
        return UtilKt.toKVisibility(this.getDescriptor().getVisibility());
    }

    @Override
    public boolean isFinal() {
        return Intrinsics.areEqual((Object)this.getDescriptor().getModality(), (Object)Modality.FINAL);
    }

    @Override
    public boolean isOpen() {
        return Intrinsics.areEqual((Object)this.getDescriptor().getModality(), (Object)Modality.OPEN);
    }

    @Override
    public boolean isAbstract() {
        return Intrinsics.areEqual((Object)this.getDescriptor().getModality(), (Object)Modality.ABSTRACT);
    }

    protected final boolean isAnnotationConstructor() {
        return Intrinsics.areEqual(this.getName(), "<init>") && this.getContainer().getJClass().isAnnotation();
    }

    @Override
    public R call(Object ... args) {
        Intrinsics.checkParameterIsNotNull(args, "args");
        try {
            return (R)this.getCaller().call(args);
        }
        catch (IllegalAccessException e$iv) {
            throw (Throwable)new IllegalCallableAccessException(e$iv);
        }
    }

    @Override
    public R callBy(@NotNull Map<KParameter, ? extends Object> args) {
        Intrinsics.checkParameterIsNotNull(args, "args");
        return this.isAnnotationConstructor() ? this.callAnnotationConstructor(args) : this.callDefaultMethod(args);
    }

    /*
     * WARNING - void declaration
     */
    private final R callDefaultMethod(Map<KParameter, ? extends Object> args) {
        Object object;
        Collection thisCollection$iv;
        List<KParameter> parameters2 = this.getParameters();
        ArrayList<Object> arguments2 = new ArrayList<Object>(parameters2.size());
        int mask = 0;
        ArrayList<Integer> masks = new ArrayList<Integer>(1);
        int index = 0;
        for (KParameter kParameter : parameters2) {
            if (index != 0 && index % 32 == 0) {
                masks.add(mask);
                mask = 0;
            }
            if (args.containsKey(kParameter)) {
                arguments2.add(args.get(kParameter));
            } else if (kParameter.isOptional()) {
                arguments2.add(this.defaultPrimitiveValue(ReflectJvmMapping.getJavaType(kParameter.getType())));
                mask |= 1 << index % 32;
            } else {
                throw (Throwable)new IllegalArgumentException("No argument provided for a required parameter: " + kParameter);
            }
            if (!Intrinsics.areEqual((Object)kParameter.getKind(), (Object)KParameter.Kind.VALUE)) continue;
            ++index;
        }
        if (mask == 0 && masks.isEmpty()) {
            Collection collection = arguments2;
            KCallableImpl kCallableImpl = this;
            thisCollection$iv = collection;
            Object[] objectArray = thisCollection$iv.toArray(new Object[thisCollection$iv.size()]);
            if (objectArray == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            Object[] objectArray2 = objectArray;
            return kCallableImpl.call(Arrays.copyOf(objectArray2, objectArray2.length));
        }
        masks.add(mask);
        FunctionCaller<?> functionCaller = this.getDefaultCaller();
        if (functionCaller == null) {
            throw (Throwable)new KotlinReflectionInternalError("This callable does not support a default call: " + this.getDescriptor());
        }
        FunctionCaller<?> functionCaller2 = functionCaller;
        arguments2.addAll((Collection)masks);
        arguments2.add(null);
        try {
            void $receiver$iv;
            thisCollection$iv = arguments2;
            FunctionCaller<?> functionCaller3 = functionCaller2;
            Collection thisCollection$iv2 = (Collection)$receiver$iv;
            Object[] objectArray = thisCollection$iv2.toArray(new Object[thisCollection$iv2.size()]);
            if (objectArray == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            Object[] objectArray3 = objectArray;
            object = functionCaller3.call(objectArray3);
        }
        catch (IllegalAccessException e$iv) {
            throw (Throwable)new IllegalCallableAccessException(e$iv);
        }
        return (R)object;
    }

    /*
     * WARNING - void declaration
     */
    private final R callAnnotationConstructor(Map<KParameter, ? extends Object> args) {
        Object object;
        Collection $receiver$iv$iv;
        Iterable $receiver$iv;
        Iterable iterable = $receiver$iv = (Iterable)this.getParameters();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        for (Object item$iv$iv : $receiver$iv$iv) {
            Object object2;
            void parameter;
            KParameter kParameter = (KParameter)item$iv$iv;
            Collection collection = destination$iv$iv;
            if (args.containsKey(parameter)) {
                object2 = args.get(parameter);
                if (object2 == null) {
                    throw (Throwable)new IllegalArgumentException("Annotation argument value cannot be null (" + parameter + ")");
                }
            } else if (parameter.isOptional()) {
                object2 = null;
            } else {
                throw (Throwable)new IllegalArgumentException("No argument provided for a required parameter: " + parameter);
            }
            Object object3 = object2;
            collection.add(object3);
        }
        List arguments2 = (List)destination$iv$iv;
        FunctionCaller<?> functionCaller = this.getDefaultCaller();
        if (functionCaller == null) {
            throw (Throwable)new KotlinReflectionInternalError("This callable does not support a default call: " + this.getDescriptor());
        }
        FunctionCaller<?> caller2 = functionCaller;
        try {
            void $receiver$iv2;
            $receiver$iv$iv = arguments2;
            FunctionCaller<?> functionCaller2 = caller2;
            Collection thisCollection$iv = (Collection)$receiver$iv2;
            Object[] objectArray = thisCollection$iv.toArray(new Object[thisCollection$iv.size()]);
            if (objectArray == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            Object[] objectArray2 = objectArray;
            object = functionCaller2.call(objectArray2);
        }
        catch (IllegalAccessException e$iv) {
            throw (Throwable)new IllegalCallableAccessException(e$iv);
        }
        return (R)object;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final Object defaultPrimitiveValue(Type type2) {
        Comparable<Boolean> comparable;
        if (!(type2 instanceof Class)) return null;
        if (!((Class)type2).isPrimitive()) return null;
        Type type3 = type2;
        if (Intrinsics.areEqual(type3, Boolean.TYPE)) {
            comparable = false;
            return comparable;
        } else if (Intrinsics.areEqual(type3, Character.TYPE)) {
            comparable = Character.valueOf((char)0);
            return comparable;
        } else if (Intrinsics.areEqual(type3, Byte.TYPE)) {
            comparable = (byte)0;
            return comparable;
        } else if (Intrinsics.areEqual(type3, Short.TYPE)) {
            comparable = (short)0;
            return comparable;
        } else if (Intrinsics.areEqual(type3, Integer.TYPE)) {
            comparable = 0;
            return comparable;
        } else if (Intrinsics.areEqual(type3, Float.TYPE)) {
            comparable = Float.valueOf(0.0f);
            return comparable;
        } else if (Intrinsics.areEqual(type3, Long.TYPE)) {
            comparable = 0L;
            return comparable;
        } else if (Intrinsics.areEqual(type3, Double.TYPE)) {
            comparable = 0.0;
            return comparable;
        } else {
            if (!Intrinsics.areEqual(type3, Void.TYPE)) throw (Throwable)new UnsupportedOperationException("Unknown primitive: " + type2);
            throw (Throwable)new IllegalStateException("Parameter with void type is illegal");
        }
    }
}

