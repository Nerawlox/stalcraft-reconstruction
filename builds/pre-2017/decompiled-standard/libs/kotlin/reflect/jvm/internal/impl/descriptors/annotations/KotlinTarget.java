/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinTarget$Companion$WhenMappings;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class KotlinTarget
extends Enum<KotlinTarget> {
    public static final /* enum */ KotlinTarget CLASS;
    public static final /* enum */ KotlinTarget ANNOTATION_CLASS;
    public static final /* enum */ KotlinTarget TYPE_PARAMETER;
    public static final /* enum */ KotlinTarget PROPERTY;
    public static final /* enum */ KotlinTarget FIELD;
    public static final /* enum */ KotlinTarget LOCAL_VARIABLE;
    public static final /* enum */ KotlinTarget VALUE_PARAMETER;
    public static final /* enum */ KotlinTarget CONSTRUCTOR;
    public static final /* enum */ KotlinTarget FUNCTION;
    public static final /* enum */ KotlinTarget PROPERTY_GETTER;
    public static final /* enum */ KotlinTarget PROPERTY_SETTER;
    public static final /* enum */ KotlinTarget TYPE;
    public static final /* enum */ KotlinTarget EXPRESSION;
    public static final /* enum */ KotlinTarget FILE;
    public static final /* enum */ KotlinTarget TYPEALIAS;
    public static final /* enum */ KotlinTarget TYPE_PROJECTION;
    public static final /* enum */ KotlinTarget STAR_PROJECTION;
    public static final /* enum */ KotlinTarget PROPERTY_PARAMETER;
    public static final /* enum */ KotlinTarget CLASS_ONLY;
    public static final /* enum */ KotlinTarget OBJECT;
    public static final /* enum */ KotlinTarget COMPANION_OBJECT;
    public static final /* enum */ KotlinTarget INTERFACE;
    public static final /* enum */ KotlinTarget ENUM_CLASS;
    public static final /* enum */ KotlinTarget ENUM_ENTRY;
    public static final /* enum */ KotlinTarget INNER_CLASS;
    public static final /* enum */ KotlinTarget LOCAL_CLASS;
    public static final /* enum */ KotlinTarget LOCAL_FUNCTION;
    public static final /* enum */ KotlinTarget MEMBER_FUNCTION;
    public static final /* enum */ KotlinTarget TOP_LEVEL_FUNCTION;
    public static final /* enum */ KotlinTarget MEMBER_PROPERTY;
    public static final /* enum */ KotlinTarget MEMBER_PROPERTY_WITH_BACKING_FIELD;
    public static final /* enum */ KotlinTarget MEMBER_PROPERTY_WITH_DELEGATE;
    public static final /* enum */ KotlinTarget MEMBER_PROPERTY_WITHOUT_FIELD_OR_DELEGATE;
    public static final /* enum */ KotlinTarget TOP_LEVEL_PROPERTY;
    public static final /* enum */ KotlinTarget TOP_LEVEL_PROPERTY_WITH_BACKING_FIELD;
    public static final /* enum */ KotlinTarget TOP_LEVEL_PROPERTY_WITH_DELEGATE;
    public static final /* enum */ KotlinTarget TOP_LEVEL_PROPERTY_WITHOUT_FIELD_OR_DELEGATE;
    public static final /* enum */ KotlinTarget INITIALIZER;
    public static final /* enum */ KotlinTarget DESTRUCTURING_DECLARATION;
    public static final /* enum */ KotlinTarget LAMBDA_EXPRESSION;
    public static final /* enum */ KotlinTarget ANONYMOUS_FUNCTION;
    public static final /* enum */ KotlinTarget OBJECT_LITERAL;
    private static final /* synthetic */ KotlinTarget[] $VALUES;
    @NotNull
    private final String description;
    private final boolean isDefault;
    private static final HashMap<String, KotlinTarget> map;
    @NotNull
    private static final Set<KotlinTarget> DEFAULT_TARGET_SET;
    @NotNull
    private static final Set<KotlinTarget> ALL_TARGET_SET;
    @NotNull
    private static final Map<AnnotationUseSiteTarget, KotlinTarget> USE_SITE_MAPPING;
    public static final Companion Companion;

    /*
     * WARNING - void declaration
     */
    static {
        void $receiver$iv$iv;
        void $receiver$iv;
        KotlinTarget[] kotlinTargetArray;
        Object target;
        KotlinTarget[] kotlinTargetArray2 = new KotlinTarget[42];
        KotlinTarget[] kotlinTargetArray3 = kotlinTargetArray2;
        kotlinTargetArray2[0] = CLASS = new KotlinTarget("CLASS", 0, "class", false, 2, null);
        kotlinTargetArray2[1] = ANNOTATION_CLASS = new KotlinTarget("ANNOTATION_CLASS", 1, "annotation class", false, 2, null);
        kotlinTargetArray2[2] = TYPE_PARAMETER = new KotlinTarget("type parameter", false);
        kotlinTargetArray2[3] = PROPERTY = new KotlinTarget("PROPERTY", 3, "property", false, 2, null);
        kotlinTargetArray2[4] = FIELD = new KotlinTarget("FIELD", 4, "field", false, 2, null);
        kotlinTargetArray2[5] = LOCAL_VARIABLE = new KotlinTarget("LOCAL_VARIABLE", 5, "local variable", false, 2, null);
        kotlinTargetArray2[6] = VALUE_PARAMETER = new KotlinTarget("VALUE_PARAMETER", 6, "value parameter", false, 2, null);
        kotlinTargetArray2[7] = CONSTRUCTOR = new KotlinTarget("CONSTRUCTOR", 7, "constructor", false, 2, null);
        kotlinTargetArray2[8] = FUNCTION = new KotlinTarget("FUNCTION", 8, "function", false, 2, null);
        kotlinTargetArray2[9] = PROPERTY_GETTER = new KotlinTarget("PROPERTY_GETTER", 9, "getter", false, 2, null);
        kotlinTargetArray2[10] = PROPERTY_SETTER = new KotlinTarget("PROPERTY_SETTER", 10, "setter", false, 2, null);
        kotlinTargetArray2[11] = TYPE = new KotlinTarget("type usage", false);
        kotlinTargetArray2[12] = EXPRESSION = new KotlinTarget("expression", false);
        kotlinTargetArray2[13] = FILE = new KotlinTarget("file", false);
        kotlinTargetArray2[14] = TYPEALIAS = new KotlinTarget("typealias", false);
        kotlinTargetArray2[15] = TYPE_PROJECTION = new KotlinTarget("type projection", false);
        kotlinTargetArray2[16] = STAR_PROJECTION = new KotlinTarget("star projection", false);
        kotlinTargetArray2[17] = PROPERTY_PARAMETER = new KotlinTarget("property constructor parameter", false);
        kotlinTargetArray2[18] = CLASS_ONLY = new KotlinTarget("class", false);
        kotlinTargetArray2[19] = OBJECT = new KotlinTarget("object", false);
        kotlinTargetArray2[20] = COMPANION_OBJECT = new KotlinTarget("companion object", false);
        kotlinTargetArray2[21] = INTERFACE = new KotlinTarget("interface", false);
        kotlinTargetArray2[22] = ENUM_CLASS = new KotlinTarget("enum class", false);
        kotlinTargetArray2[23] = ENUM_ENTRY = new KotlinTarget("enum entry", false);
        kotlinTargetArray2[24] = INNER_CLASS = new KotlinTarget("inner class", false);
        kotlinTargetArray2[25] = LOCAL_CLASS = new KotlinTarget("local class", false);
        kotlinTargetArray2[26] = LOCAL_FUNCTION = new KotlinTarget("local function", false);
        kotlinTargetArray2[27] = MEMBER_FUNCTION = new KotlinTarget("member function", false);
        kotlinTargetArray2[28] = TOP_LEVEL_FUNCTION = new KotlinTarget("top level function", false);
        kotlinTargetArray2[29] = MEMBER_PROPERTY = new KotlinTarget("member property", false);
        kotlinTargetArray2[30] = MEMBER_PROPERTY_WITH_BACKING_FIELD = new KotlinTarget("member property with backing field", false);
        kotlinTargetArray2[31] = MEMBER_PROPERTY_WITH_DELEGATE = new KotlinTarget("member property with delegate", false);
        kotlinTargetArray2[32] = MEMBER_PROPERTY_WITHOUT_FIELD_OR_DELEGATE = new KotlinTarget("member property without backing field or delegate", false);
        kotlinTargetArray2[33] = TOP_LEVEL_PROPERTY = new KotlinTarget("top level property", false);
        kotlinTargetArray2[34] = TOP_LEVEL_PROPERTY_WITH_BACKING_FIELD = new KotlinTarget("top level property with backing field", false);
        kotlinTargetArray2[35] = TOP_LEVEL_PROPERTY_WITH_DELEGATE = new KotlinTarget("top level property with delegate", false);
        kotlinTargetArray2[36] = TOP_LEVEL_PROPERTY_WITHOUT_FIELD_OR_DELEGATE = new KotlinTarget("top level property without backing field or delegate", false);
        kotlinTargetArray2[37] = INITIALIZER = new KotlinTarget("initializer", false);
        kotlinTargetArray2[38] = DESTRUCTURING_DECLARATION = new KotlinTarget("destructuring declaration", false);
        kotlinTargetArray2[39] = LAMBDA_EXPRESSION = new KotlinTarget("lambda expression", false);
        kotlinTargetArray2[40] = ANONYMOUS_FUNCTION = new KotlinTarget("anonymous function", false);
        kotlinTargetArray2[41] = OBJECT_LITERAL = new KotlinTarget("object literal", false);
        $VALUES = kotlinTargetArray2;
        Companion = new Companion(null);
        map = new HashMap();
        KotlinTarget[] kotlinTargetArray4 = KotlinTarget.values();
        for (int i = 0; i < kotlinTargetArray4.length; ++i) {
            target = kotlinTargetArray4[i];
            Map map2 = KotlinTarget.Companion.getMap();
            String string = ((Enum)target).name();
            Object object = target;
            kotlinTargetArray = kotlinTargetArray3;
            map2.put(string, object);
            kotlinTargetArray3 = kotlinTargetArray;
        }
        target = (Object[])KotlinTarget.values();
        kotlinTargetArray = kotlinTargetArray3;
        void var1_2 = $receiver$iv;
        Collection destination$iv$iv = new ArrayList();
        for (int i = 0; i < ((void)$receiver$iv$iv).length; ++i) {
            void element$iv$iv = $receiver$iv$iv[i];
            KotlinTarget it = (KotlinTarget)element$iv$iv;
            if (!it.isDefault) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        List list = (List)kotlinTargetArray4;
        KotlinTarget[] kotlinTargetArray5 = kotlinTargetArray;
        DEFAULT_TARGET_SET = CollectionsKt.toSet(list);
        ALL_TARGET_SET = ArraysKt.toSet((Object[])KotlinTarget.values());
        USE_SITE_MAPPING = MapsKt.mapOf(TuplesKt.to(AnnotationUseSiteTarget.CONSTRUCTOR_PARAMETER, VALUE_PARAMETER), TuplesKt.to(AnnotationUseSiteTarget.FIELD, FIELD), TuplesKt.to(AnnotationUseSiteTarget.PROPERTY, PROPERTY), TuplesKt.to(AnnotationUseSiteTarget.FILE, FILE), TuplesKt.to(AnnotationUseSiteTarget.PROPERTY_GETTER, PROPERTY_GETTER), TuplesKt.to(AnnotationUseSiteTarget.PROPERTY_SETTER, PROPERTY_SETTER), TuplesKt.to(AnnotationUseSiteTarget.RECEIVER, VALUE_PARAMETER), TuplesKt.to(AnnotationUseSiteTarget.SETTER_PARAMETER, VALUE_PARAMETER), TuplesKt.to(AnnotationUseSiteTarget.PROPERTY_DELEGATE_FIELD, FIELD));
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    public final boolean isDefault() {
        return this.isDefault;
    }

    protected KotlinTarget(String description, boolean isDefault) {
        Intrinsics.checkParameterIsNotNull(description, "description");
        this.description = description;
        this.isDefault = isDefault;
    }

    /* synthetic */ KotlinTarget(String string, int n, String string2, boolean bl, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 2) != 0) {
            bl = true;
        }
        this(string2, bl);
    }

    public static KotlinTarget[] values() {
        return (KotlinTarget[])$VALUES.clone();
    }

    public static KotlinTarget valueOf(String string) {
        return Enum.valueOf(KotlinTarget.class, string);
    }

    public static final class Companion {
        private final HashMap<String, KotlinTarget> getMap() {
            return map;
        }

        @Nullable
        public final KotlinTarget valueOrNull(@NotNull String name2) {
            Intrinsics.checkParameterIsNotNull(name2, "name");
            return this.getMap().get(name2);
        }

        @NotNull
        public final Set<KotlinTarget> getDEFAULT_TARGET_SET() {
            return DEFAULT_TARGET_SET;
        }

        @NotNull
        public final Set<KotlinTarget> getALL_TARGET_SET() {
            return ALL_TARGET_SET;
        }

        @NotNull
        public final List<KotlinTarget> classActualTargets(@NotNull ClassDescriptor descriptor2) {
            List<KotlinTarget[]> list;
            Intrinsics.checkParameterIsNotNull(descriptor2, "descriptor");
            switch (KotlinTarget$Companion$WhenMappings.$EnumSwitchMapping$0[descriptor2.getKind().ordinal()]) {
                case 1: {
                    list = CollectionsKt.listOf(new KotlinTarget[]{ANNOTATION_CLASS, CLASS});
                    break;
                }
                case 2: {
                    if (descriptor2.isInner()) {
                        list = CollectionsKt.listOf(new KotlinTarget[]{INNER_CLASS, CLASS});
                        break;
                    }
                    if (DescriptorUtils.isLocal(descriptor2)) {
                        list = CollectionsKt.listOf(new KotlinTarget[]{LOCAL_CLASS, CLASS});
                        break;
                    }
                    list = CollectionsKt.listOf(new KotlinTarget[]{CLASS_ONLY, CLASS});
                    break;
                }
                case 3: {
                    if (descriptor2.isCompanionObject()) {
                        list = CollectionsKt.listOf(new KotlinTarget[]{COMPANION_OBJECT, OBJECT, CLASS});
                        break;
                    }
                    list = CollectionsKt.listOf(new KotlinTarget[]{OBJECT, CLASS});
                    break;
                }
                case 4: {
                    list = CollectionsKt.listOf(new KotlinTarget[]{INTERFACE, CLASS});
                    break;
                }
                case 5: {
                    if (DescriptorUtils.isLocal(descriptor2)) {
                        list = CollectionsKt.listOf(new KotlinTarget[]{LOCAL_CLASS, CLASS});
                        break;
                    }
                    list = CollectionsKt.listOf(new KotlinTarget[]{ENUM_CLASS, CLASS});
                    break;
                }
                case 6: {
                    list = CollectionsKt.listOf(new KotlinTarget[]{ENUM_ENTRY, PROPERTY, FIELD});
                    break;
                }
                default: {
                    throw new NoWhenBranchMatchedException();
                }
            }
            return list;
        }

        @NotNull
        public final Map<AnnotationUseSiteTarget, KotlinTarget> getUSE_SITE_MAPPING() {
            return USE_SITE_MAPPING;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

