/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedFunctionEnhancementInfo;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementInfo;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import org.jetbrains.annotations.NotNull;

final class SignatureEnhancementBuilder {
    private final Map<String, PredefinedFunctionEnhancementInfo> signatures;

    public final void forClass(@NotNull String internalName, @NotNull Function1<? super ClassEnhancementBuilder, Unit> block) {
        Intrinsics.checkParameterIsNotNull(internalName, "internalName");
        Intrinsics.checkParameterIsNotNull(block, "block");
        block.invoke(new ClassEnhancementBuilder(internalName));
    }

    @NotNull
    public final Map<String, PredefinedFunctionEnhancementInfo> build() {
        return this.signatures;
    }

    public SignatureEnhancementBuilder() {
        Map map2;
        SignatureEnhancementBuilder signatureEnhancementBuilder = this;
        signatureEnhancementBuilder.signatures = map2 = (Map)new LinkedHashMap();
    }

    public final class ClassEnhancementBuilder {
        @NotNull
        private final String className;

        public final void function(@NotNull String name2, @NotNull Function1<? super FunctionEnhancementBuilder, Unit> block) {
            Intrinsics.checkParameterIsNotNull(name2, "name");
            Intrinsics.checkParameterIsNotNull(block, "block");
            Map map2 = SignatureEnhancementBuilder.this.signatures;
            Object object = new FunctionEnhancementBuilder(name2);
            block.invoke((FunctionEnhancementBuilder)object);
            object = ((FunctionEnhancementBuilder)object).build();
            map2.put(((Pair)object).getFirst(), ((Pair)object).getSecond());
        }

        @NotNull
        public final String getClassName() {
            return this.className;
        }

        public ClassEnhancementBuilder(String className) {
            Intrinsics.checkParameterIsNotNull(className, "className");
            this.className = className;
        }

        public final class FunctionEnhancementBuilder {
            private final List<Pair<String, TypeEnhancementInfo>> parameters;
            private Pair<String, TypeEnhancementInfo> returnType;
            @NotNull
            private final String functionName;

            public final void parameter(@NotNull String type2, Pair<Integer, JavaTypeQualifiers> ... pairs) {
                Intrinsics.checkParameterIsNotNull(type2, "type");
                Intrinsics.checkParameterIsNotNull(pairs, "pairs");
                Collection collection = this.parameters;
                Object object = pairs;
                String string = type2;
                boolean bl = ((Object[])object).length == 0;
                object = TuplesKt.to(string, bl ? null : new TypeEnhancementInfo(Arrays.copyOf(pairs, pairs.length)));
                collection.add(object);
            }

            /*
             * WARNING - void declaration
             */
            public final void parameter(@NotNull String type2, JavaTypeQualifiers ... qualifiers) {
                TypeEnhancementInfo typeEnhancementInfo;
                Intrinsics.checkParameterIsNotNull(type2, "type");
                Intrinsics.checkParameterIsNotNull(qualifiers, "qualifiers");
                Collection collection = this.parameters;
                Object object = qualifiers;
                String string = type2;
                boolean bl = ((Object[])object).length == 0;
                String string2 = string;
                if (bl) {
                    typeEnhancementInfo = null;
                } else {
                    Map map2;
                    void $receiver$iv$iv;
                    void $receiver$iv;
                    TypeEnhancementInfo typeEnhancementInfo2;
                    object = ArraysKt.withIndex((Object[])qualifiers);
                    TypeEnhancementInfo typeEnhancementInfo3 = typeEnhancementInfo2;
                    TypeEnhancementInfo typeEnhancementInfo4 = typeEnhancementInfo2;
                    string = string2;
                    int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10)), 16);
                    void var9_10 = $receiver$iv;
                    Map destination$iv$iv = new LinkedHashMap(capacity$iv);
                    for (Object element$iv$iv : $receiver$iv$iv) {
                        IndexedValue it;
                        IndexedValue indexedValue = (IndexedValue)element$iv$iv;
                        map2 = destination$iv$iv;
                        Integer n = it.getIndex();
                        it = (IndexedValue)element$iv$iv;
                        JavaTypeQualifiers javaTypeQualifiers = (JavaTypeQualifiers)it.getValue();
                        map2.put(n, javaTypeQualifiers);
                    }
                    map2 = destination$iv$iv;
                    string2 = string;
                    typeEnhancementInfo = typeEnhancementInfo4;
                    typeEnhancementInfo3(map2);
                }
                object = TuplesKt.to(string2, typeEnhancementInfo);
                collection.add(object);
            }

            public final void returns(@NotNull String type2, Pair<Integer, JavaTypeQualifiers> ... pairs) {
                Intrinsics.checkParameterIsNotNull(type2, "type");
                Intrinsics.checkParameterIsNotNull(pairs, "pairs");
                this.returnType = TuplesKt.to(type2, new TypeEnhancementInfo(Arrays.copyOf(pairs, pairs.length)));
            }

            /*
             * WARNING - void declaration
             */
            public final void returns(@NotNull String type2, JavaTypeQualifiers ... qualifiers) {
                Map map2;
                void $receiver$iv$iv;
                void $receiver$iv;
                TypeEnhancementInfo typeEnhancementInfo;
                Intrinsics.checkParameterIsNotNull(type2, "type");
                Intrinsics.checkParameterIsNotNull(qualifiers, "qualifiers");
                Iterable<IndexedValue<Object>> iterable = ArraysKt.withIndex((Object[])qualifiers);
                TypeEnhancementInfo typeEnhancementInfo2 = typeEnhancementInfo;
                TypeEnhancementInfo typeEnhancementInfo3 = typeEnhancementInfo;
                String string = type2;
                FunctionEnhancementBuilder functionEnhancementBuilder = this;
                int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10)), 16);
                void var9_9 = $receiver$iv;
                Map destination$iv$iv = new LinkedHashMap(capacity$iv);
                for (Object element$iv$iv : $receiver$iv$iv) {
                    IndexedValue it;
                    IndexedValue indexedValue = (IndexedValue)element$iv$iv;
                    map2 = destination$iv$iv;
                    Integer n = it.getIndex();
                    it = (IndexedValue)element$iv$iv;
                    JavaTypeQualifiers javaTypeQualifiers = (JavaTypeQualifiers)it.getValue();
                    map2.put(n, javaTypeQualifiers);
                }
                map2 = destination$iv$iv;
                typeEnhancementInfo2(map2);
                functionEnhancementBuilder.returnType = TuplesKt.to(string, typeEnhancementInfo3);
            }

            public final void returns(@NotNull JvmPrimitiveType type2) {
                Intrinsics.checkParameterIsNotNull((Object)type2, "type");
                this.returnType = TuplesKt.to(type2.getDesc(), null);
            }

            @NotNull
            public final Pair<String, PredefinedFunctionEnhancementInfo> build() {
                PredefinedFunctionEnhancementInfo predefinedFunctionEnhancementInfo;
                Object object;
                Pair it;
                Collection<Object> collection;
                Iterable $receiver$iv$iv;
                Iterable $receiver$iv;
                SignatureBuildingComponents signatureBuildingComponents;
                SignatureBuildingComponents $receiver = signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
                Iterable iterable = this.parameters;
                Object object2 = this.functionName;
                Object object3 = $receiver;
                Object object4 = ClassEnhancementBuilder.this.getClassName();
                Object object5 = $receiver;
                void var8_8 = $receiver$iv;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
                for (Object item$iv$iv : $receiver$iv$iv) {
                    Pair pair = (Pair)item$iv$iv;
                    collection = destination$iv$iv;
                    object = (String)it.getFirst();
                    collection.add(object);
                }
                collection = (List)destination$iv$iv;
                String string = ((SignatureBuildingComponents)object5).signature((String)object4, ((SignatureBuildingComponents)object3).jvmDescriptor((String)object2, (List<String>)collection, this.returnType.getFirst()));
                $receiver$iv = this.parameters;
                object2 = this.returnType.getSecond();
                object3 = predefinedFunctionEnhancementInfo;
                object4 = predefinedFunctionEnhancementInfo;
                object5 = string;
                $receiver$iv$iv = $receiver$iv;
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
                for (Object item$iv$iv : $receiver$iv$iv) {
                    it = (Pair)item$iv$iv;
                    collection = destination$iv$iv;
                    object = (TypeEnhancementInfo)it.getSecond();
                    collection.add(object);
                }
                collection = (List)destination$iv$iv;
                ((PredefinedFunctionEnhancementInfo)object3)((TypeEnhancementInfo)object2, (List<TypeEnhancementInfo>)collection);
                return TuplesKt.to(object5, object4);
            }

            @NotNull
            public final String getFunctionName() {
                return this.functionName;
            }

            public FunctionEnhancementBuilder(String functionName) {
                List list;
                Intrinsics.checkParameterIsNotNull(functionName, "functionName");
                this.functionName = functionName;
                FunctionEnhancementBuilder functionEnhancementBuilder = this;
                functionEnhancementBuilder.parameters = list = (List)new ArrayList();
                this.returnType = TuplesKt.to("V", null);
            }
        }
    }
}

