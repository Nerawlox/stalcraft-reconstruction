/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.AnnotationConstructorCallerKt;
import kotlin.reflect.jvm.internal.FunctionCaller;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectClassUtilKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0004\b\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0002\u0016\u0017B?\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0006\u00a2\u0006\u0002\u0010\u000eJ\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00102\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0014H\u0016\u00a2\u0006\u0002\u0010\u0015R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2={"Lkotlin/reflect/jvm/internal/AnnotationConstructorCaller;", "Lkotlin/reflect/jvm/internal/FunctionCaller;", "", "jClass", "Ljava/lang/Class;", "parameterNames", "", "", "callMode", "Lkotlin/reflect/jvm/internal/AnnotationConstructorCaller$CallMode;", "origin", "Lkotlin/reflect/jvm/internal/AnnotationConstructorCaller$Origin;", "methods", "Ljava/lang/reflect/Method;", "(Ljava/lang/Class;Ljava/util/List;Lkotlin/reflect/jvm/internal/AnnotationConstructorCaller$CallMode;Lkotlin/reflect/jvm/internal/AnnotationConstructorCaller$Origin;Ljava/util/List;)V", "defaultValues", "", "erasedParameterTypes", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "CallMode", "Origin", "kotlin-reflection"})
public final class AnnotationConstructorCaller
extends FunctionCaller {
    private final List<Class<?>> erasedParameterTypes;
    private final List<Object> defaultValues;
    private final Class<?> jClass;
    private final List<String> parameterNames;
    private final CallMode callMode;
    private final List<Method> methods;

    /*
     * WARNING - void declaration
     */
    @Override
    @Nullable
    public Object call(@NotNull Object[] args) {
        void $receiver$iv$iv;
        Object[] $receiver$iv;
        Intrinsics.checkParameterIsNotNull(args, "args");
        this.checkArguments(args);
        Object[] objectArray = $receiver$iv = args;
        Collection destination$iv$iv = new ArrayList($receiver$iv.length);
        int index$iv$iv = 0;
        for (int i = 0; i < ((void)$receiver$iv$iv).length; ++i) {
            Object object;
            void index;
            void arg;
            Object value;
            void item$iv$iv = $receiver$iv$iv[i];
            int n = index$iv$iv++;
            void var8_8 = item$iv$iv;
            int n2 = n;
            Collection collection = destination$iv$iv;
            Object object2 = value = arg == null && Intrinsics.areEqual((Object)this.callMode, (Object)CallMode.CALL_BY_NAME) ? this.defaultValues.get((int)index) : AnnotationConstructorCallerKt.access$transformKotlinToJvm(arg, this.erasedParameterTypes.get((int)index));
            if (value == null) {
                Void void_ = AnnotationConstructorCallerKt.access$throwIllegalArgumentType((int)index, this.parameterNames.get((int)index), this.erasedParameterTypes.get((int)index));
                throw null;
            }
            collection.add(object);
        }
        List values2 = (List)destination$iv$iv;
        return AnnotationConstructorCallerKt.access$createAnnotationInstance(this.jClass, this.methods, MapsKt.toMap(CollectionsKt.zip((Iterable)this.parameterNames, values2)));
    }

    public AnnotationConstructorCaller(@NotNull Class<?> jClass, @NotNull List<String> parameterNames, @NotNull CallMode callMode, @NotNull Origin origin, @NotNull List<Method> methods2) {
        Method method;
        Method it;
        Collection<Type> collection;
        Iterable $receiver$iv$iv;
        Iterable $receiver$iv;
        Intrinsics.checkParameterIsNotNull(jClass, "jClass");
        Intrinsics.checkParameterIsNotNull(parameterNames, "parameterNames");
        Intrinsics.checkParameterIsNotNull((Object)callMode, "callMode");
        Intrinsics.checkParameterIsNotNull((Object)origin, "origin");
        Intrinsics.checkParameterIsNotNull(methods2, "methods");
        Iterable iterable = methods2;
        Class<?> clazz = null;
        Object object = jClass;
        Collection<Object> collection2 = null;
        AnnotationConstructorCaller annotationConstructorCaller = this;
        void var11_11 = $receiver$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        for (Object item$iv$iv : $receiver$iv$iv) {
            Method method2 = (Method)item$iv$iv;
            collection = destination$iv$iv;
            Type type2 = it.getGenericReturnType();
            collection.add(type2);
        }
        collection = (List)destination$iv$iv;
        $receiver$iv = collection;
        Collection thisCollection$iv = $receiver$iv;
        Type[] typeArray = thisCollection$iv.toArray(new Type[thisCollection$iv.size()]);
        if (typeArray == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        collection = typeArray;
        super(collection2, (Type)object, clazz, (Type[])collection);
        this.jClass = jClass;
        this.parameterNames = parameterNames;
        this.callMode = callMode;
        this.methods = methods2;
        $receiver$iv = this.methods;
        annotationConstructorCaller = this;
        thisCollection$iv = $receiver$iv;
        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        for (Object item$iv$iv : $receiver$iv$iv) {
            it = (Method)item$iv$iv;
            collection2 = destination$iv$iv;
            Class<?> $i$a$2$map = method.getReturnType();
            Class<?> it2 = $i$a$2$map;
            Class<?> clazz2 = ReflectClassUtilKt.getWrapperByPrimitive(it2);
            if (clazz2 == null) {
                clazz2 = it2;
            }
            object = clazz2;
            collection2.add(object);
        }
        collection2 = (List)destination$iv$iv;
        annotationConstructorCaller.erasedParameterTypes = collection2;
        $receiver$iv = this.methods;
        annotationConstructorCaller = this;
        $receiver$iv$iv = $receiver$iv;
        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        for (Object item$iv$iv : $receiver$iv$iv) {
            method = (Method)item$iv$iv;
            collection2 = destination$iv$iv;
            object = method.getDefaultValue();
            collection2.add(object);
        }
        collection2 = (List)destination$iv$iv;
        annotationConstructorCaller.defaultValues = collection2;
        if (Intrinsics.areEqual((Object)this.callMode, (Object)CallMode.POSITIONAL_CALL) && Intrinsics.areEqual((Object)origin, (Object)Origin.JAVA) && !(iterable = (Collection)CollectionsKt.minus((Iterable)this.parameterNames, "value")).isEmpty()) {
            throw (Throwable)new UnsupportedOperationException("Positional call of a Java annotation constructor is allowed only if there are no parameters or one parameter named \"value\". This restriction exists because Java annotations (in contrast to Kotlin)do not impose any order on their arguments. Use KCallable#callBy instead.");
        }
    }

    /*
     * WARNING - void declaration
     */
    public /* synthetic */ AnnotationConstructorCaller(Class clazz, List list, CallMode callMode, Origin origin, List list2, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 0x10) != 0) {
            void $receiver$iv$iv;
            Iterable $receiver$iv;
            Iterable iterable = $receiver$iv = (Iterable)list;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
            for (Object item$iv$iv : $receiver$iv$iv) {
                void name2;
                String string = (String)item$iv$iv;
                Collection collection = destination$iv$iv;
                Method method = clazz.getDeclaredMethod((String)name2, new Class[0]);
                collection.add(method);
            }
            list2 = (List)destination$iv$iv;
        }
        this(clazz, list, callMode, origin, list2);
    }

    @Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2={"Lkotlin/reflect/jvm/internal/AnnotationConstructorCaller$CallMode;", "", "(Ljava/lang/String;I)V", "CALL_BY_NAME", "POSITIONAL_CALL", "kotlin-reflection"})
    public static final class CallMode
    extends Enum<CallMode> {
        public static final /* enum */ CallMode CALL_BY_NAME;
        public static final /* enum */ CallMode POSITIONAL_CALL;
        private static final /* synthetic */ CallMode[] $VALUES;

        static {
            CallMode[] callModeArray = new CallMode[2];
            CallMode[] callModeArray2 = callModeArray;
            callModeArray[0] = CALL_BY_NAME = new CallMode();
            callModeArray[1] = POSITIONAL_CALL = new CallMode();
            $VALUES = callModeArray;
        }

        public static CallMode[] values() {
            return (CallMode[])$VALUES.clone();
        }

        public static CallMode valueOf(String string) {
            return Enum.valueOf(CallMode.class, string);
        }
    }

    @Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2={"Lkotlin/reflect/jvm/internal/AnnotationConstructorCaller$Origin;", "", "(Ljava/lang/String;I)V", "JAVA", "KOTLIN", "kotlin-reflection"})
    public static final class Origin
    extends Enum<Origin> {
        public static final /* enum */ Origin JAVA;
        public static final /* enum */ Origin KOTLIN;
        private static final /* synthetic */ Origin[] $VALUES;

        static {
            Origin[] originArray = new Origin[2];
            Origin[] originArray2 = originArray;
            originArray[0] = JAVA = new Origin();
            originArray[1] = KOTLIN = new Origin();
            $VALUES = originArray;
        }

        public static Origin[] values() {
            return (Origin[])$VALUES.clone();
        }

        public static Origin valueOf(String string) {
            return Enum.valueOf(Origin.class, string);
        }
    }
}

