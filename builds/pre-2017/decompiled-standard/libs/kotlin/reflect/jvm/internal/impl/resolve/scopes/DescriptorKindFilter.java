/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindExclude;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class DescriptorKindFilter {
    private final int kindMask;
    @NotNull
    private final List<DescriptorKindExclude> excludes;
    private static int nextMaskValue;
    private static final int NON_SINGLETON_CLASSIFIERS_MASK;
    private static final int SINGLETON_CLASSIFIERS_MASK;
    private static final int TYPE_ALIASES_MASK;
    private static final int PACKAGES_MASK;
    private static final int FUNCTIONS_MASK;
    private static final int VARIABLES_MASK;
    private static final int ALL_KINDS_MASK;
    private static final int CLASSIFIERS_MASK;
    private static final int VALUES_MASK;
    private static final int CALLABLES_MASK;
    @JvmField
    @NotNull
    public static final DescriptorKindFilter ALL;
    @JvmField
    @NotNull
    public static final DescriptorKindFilter CALLABLES;
    @JvmField
    @NotNull
    public static final DescriptorKindFilter NON_SINGLETON_CLASSIFIERS;
    @JvmField
    @NotNull
    public static final DescriptorKindFilter SINGLETON_CLASSIFIERS;
    @JvmField
    @NotNull
    public static final DescriptorKindFilter TYPE_ALIASES;
    @JvmField
    @NotNull
    public static final DescriptorKindFilter CLASSIFIERS;
    @JvmField
    @NotNull
    public static final DescriptorKindFilter PACKAGES;
    @JvmField
    @NotNull
    public static final DescriptorKindFilter FUNCTIONS;
    @JvmField
    @NotNull
    public static final DescriptorKindFilter VARIABLES;
    @JvmField
    @NotNull
    public static final DescriptorKindFilter VALUES;
    private static final List<Companion.MaskToName> DEBUG_PREDEFINED_FILTERS_MASK_NAMES;
    private static final List<Companion.MaskToName> DEBUG_MASK_BIT_NAMES;
    public static final Companion Companion;

    public final int getKindMask() {
        return this.kindMask;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final boolean accepts(@NotNull DeclarationDescriptor descriptor2) {
        boolean bl;
        Intrinsics.checkParameterIsNotNull(descriptor2, "descriptor");
        if ((this.kindMask & this.kind(descriptor2)) == 0) return false;
        Iterable $receiver$iv = this.excludes;
        Iterator iterator2 = $receiver$iv.iterator();
        do {
            if (!iterator2.hasNext()) return true;
            Object element$iv = iterator2.next();
            DescriptorKindExclude it = (DescriptorKindExclude)element$iv;
            if (it.excludes(descriptor2)) return false;
            bl = true;
        } while (bl);
        return false;
    }

    public final boolean acceptsKinds(int kinds) {
        return (this.kindMask & kinds) != 0;
    }

    @NotNull
    public final DescriptorKindFilter exclude(@NotNull DescriptorKindExclude exclude) {
        Intrinsics.checkParameterIsNotNull(exclude, "exclude");
        return new DescriptorKindFilter(this.kindMask, CollectionsKt.plus((Collection)this.excludes, (Iterable)CollectionsKt.listOf(exclude)));
    }

    @NotNull
    public final DescriptorKindFilter withoutKinds(int kinds) {
        return new DescriptorKindFilter(this.kindMask & ~kinds, this.excludes);
    }

    @NotNull
    public final DescriptorKindFilter withKinds(int kinds) {
        return new DescriptorKindFilter(this.kindMask | kinds, this.excludes);
    }

    @NotNull
    public final DescriptorKindFilter restrictedToKinds(int kinds) {
        return new DescriptorKindFilter(this.kindMask & kinds, this.excludes);
    }

    @Nullable
    public final DescriptorKindFilter restrictedToKindsOrNull(int kinds) {
        int mask = this.kindMask & kinds;
        if (mask == 0) {
            return null;
        }
        return new DescriptorKindFilter(mask, this.excludes);
    }

    @NotNull
    public final DescriptorKindFilter intersect(@NotNull DescriptorKindFilter other) {
        Intrinsics.checkParameterIsNotNull(other, "other");
        return new DescriptorKindFilter(this.kindMask & other.kindMask, CollectionsKt.plus((Collection)this.excludes, (Iterable)other.excludes));
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public String toString() {
        Object v0;
        block3: {
            Iterable $receiver$iv = DescriptorKindFilter.Companion.getDEBUG_PREDEFINED_FILTERS_MASK_NAMES();
            for (Object element$iv : $receiver$iv) {
                Companion.MaskToName it = (Companion.MaskToName)element$iv;
                if (!(it.getMask() == this.kindMask)) continue;
                v0 = element$iv;
                break block3;
            }
            v0 = null;
        }
        Companion.MaskToName maskToName = v0;
        String predefinedFilterName = maskToName != null ? maskToName.getName() : null;
        String string = predefinedFilterName;
        if (string == null) {
            void $receiver$iv$iv;
            Object element$iv;
            Iterable $receiver$iv = DescriptorKindFilter.Companion.getDEBUG_MASK_BIT_NAMES();
            element$iv = $receiver$iv;
            Collection destination$iv$iv = new ArrayList();
            void $receiver$iv$iv$iv = $receiver$iv$iv;
            for (Object element$iv$iv$iv : $receiver$iv$iv$iv) {
                String string2;
                Object element$iv$iv = element$iv$iv$iv;
                Companion.MaskToName it = (Companion.MaskToName)element$iv$iv;
                String string3 = this.acceptsKinds(it.getMask()) ? it.getName() : null;
                if (string3 == null) continue;
                String it$iv$iv = string2 = string3;
                destination$iv$iv.add(it$iv$iv);
            }
            string = CollectionsKt.joinToString$default((List)destination$iv$iv, " | ", null, null, 0, null, null, 62, null);
        }
        String kindString = string;
        return "DescriptorKindFilter(" + kindString + ", " + this.excludes + ")";
    }

    private final int kind(@NotNull DeclarationDescriptor $receiver) {
        DeclarationDescriptor declarationDescriptor = $receiver;
        return declarationDescriptor instanceof ClassDescriptor ? (((ClassDescriptor)$receiver).getKind().isSingleton() ? Companion.getSINGLETON_CLASSIFIERS_MASK() : Companion.getNON_SINGLETON_CLASSIFIERS_MASK()) : (declarationDescriptor instanceof TypeAliasDescriptor ? Companion.getTYPE_ALIASES_MASK() : (declarationDescriptor instanceof ClassifierDescriptor ? Companion.getNON_SINGLETON_CLASSIFIERS_MASK() : (declarationDescriptor instanceof PackageFragmentDescriptor || declarationDescriptor instanceof PackageViewDescriptor ? Companion.getPACKAGES_MASK() : (declarationDescriptor instanceof FunctionDescriptor ? Companion.getFUNCTIONS_MASK() : (declarationDescriptor instanceof VariableDescriptor ? Companion.getVARIABLES_MASK() : 0)))));
    }

    @NotNull
    public final List<DescriptorKindExclude> getExcludes() {
        return this.excludes;
    }

    /*
     * WARNING - void declaration
     */
    public DescriptorKindFilter(int kindMask, @NotNull List<? extends DescriptorKindExclude> excludes) {
        void mask;
        Intrinsics.checkParameterIsNotNull(excludes, "excludes");
        this.excludes = excludes;
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = kindMask;
        Iterable $receiver$iv = this.excludes;
        for (Object element$iv : $receiver$iv) {
            DescriptorKindExclude it = (DescriptorKindExclude)element$iv;
            mask.element &= ~it.getFullyExcludedDescriptorKinds();
        }
        this.kindMask = mask.element;
        intRef = null;
    }

    public /* synthetic */ DescriptorKindFilter(int n, List list, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 2) != 0) {
            list = CollectionsKt.emptyList();
        }
        this(n, list);
    }

    /*
     * WARNING - void declaration
     */
    static {
        Field field;
        Object element$iv$iv;
        Field it$iv;
        Object element$iv$iv$iv;
        void $receiver$iv$iv$iv;
        Companion = new Companion(null);
        nextMaskValue = 1;
        NON_SINGLETON_CLASSIFIERS_MASK = DescriptorKindFilter.Companion.nextMask();
        SINGLETON_CLASSIFIERS_MASK = DescriptorKindFilter.Companion.nextMask();
        TYPE_ALIASES_MASK = DescriptorKindFilter.Companion.nextMask();
        PACKAGES_MASK = DescriptorKindFilter.Companion.nextMask();
        FUNCTIONS_MASK = DescriptorKindFilter.Companion.nextMask();
        VARIABLES_MASK = DescriptorKindFilter.Companion.nextMask();
        ALL_KINDS_MASK = DescriptorKindFilter.Companion.nextMask() - 1;
        CLASSIFIERS_MASK = Companion.getNON_SINGLETON_CLASSIFIERS_MASK() | Companion.getSINGLETON_CLASSIFIERS_MASK() | Companion.getTYPE_ALIASES_MASK();
        VALUES_MASK = Companion.getSINGLETON_CLASSIFIERS_MASK() | Companion.getFUNCTIONS_MASK() | Companion.getVARIABLES_MASK();
        CALLABLES_MASK = Companion.getFUNCTIONS_MASK() | Companion.getVARIABLES_MASK();
        ALL = new DescriptorKindFilter(Companion.getALL_KINDS_MASK(), null, 2, null);
        CALLABLES = new DescriptorKindFilter(Companion.getCALLABLES_MASK(), null, 2, null);
        NON_SINGLETON_CLASSIFIERS = new DescriptorKindFilter(Companion.getNON_SINGLETON_CLASSIFIERS_MASK(), null, 2, null);
        SINGLETON_CLASSIFIERS = new DescriptorKindFilter(Companion.getSINGLETON_CLASSIFIERS_MASK(), null, 2, null);
        TYPE_ALIASES = new DescriptorKindFilter(Companion.getTYPE_ALIASES_MASK(), null, 2, null);
        CLASSIFIERS = new DescriptorKindFilter(Companion.getCLASSIFIERS_MASK(), null, 2, null);
        PACKAGES = new DescriptorKindFilter(Companion.getPACKAGES_MASK(), null, 2, null);
        FUNCTIONS = new DescriptorKindFilter(Companion.getFUNCTIONS_MASK(), null, 2, null);
        VARIABLES = new DescriptorKindFilter(Companion.getVARIABLES_MASK(), null, 2, null);
        VALUES = new DescriptorKindFilter(Companion.getVALUES_MASK(), null, 2, null);
        Companion this_$iv = Companion;
        Object $receiver$iv$iv = DescriptorKindFilter.class.getFields();
        Object[] objectArray = $receiver$iv$iv;
        Object destination$iv$iv$iv = new ArrayList();
        for (int i = 0; i < ((void)$receiver$iv$iv$iv).length; ++i) {
            element$iv$iv$iv = $receiver$iv$iv$iv[i];
            it$iv = (Field)element$iv$iv$iv;
            if (!Modifier.isStatic(it$iv.getModifiers())) continue;
            destination$iv$iv$iv.add(element$iv$iv$iv);
        }
        Iterable $receiver$iv = (List)destination$iv$iv$iv;
        $receiver$iv$iv = $receiver$iv;
        Object destination$iv$iv = new ArrayList();
        Object $receiver$iv$iv$iv2 = $receiver$iv$iv;
        Iterator iterator2 = $receiver$iv$iv$iv2.iterator();
        while (iterator2.hasNext()) {
            Companion.MaskToName $i$f$staticFields;
            Companion.MaskToName maskToName;
            DescriptorKindFilter filter;
            element$iv$iv$iv = iterator2.next();
            element$iv$iv = element$iv$iv$iv;
            field = (Field)element$iv$iv;
            Object object = field.get(null);
            if (!(object instanceof DescriptorKindFilter)) {
                object = null;
            }
            if ((filter = (DescriptorKindFilter)object) != null) {
                int n = filter.kindMask;
                String string = field.getName();
                Intrinsics.checkExpressionValueIsNotNull(string, "field.name");
                maskToName = new Companion.MaskToName(n, string);
            } else {
                maskToName = null;
            }
            if (maskToName == null) continue;
            Companion.MaskToName it$iv$iv = $i$f$staticFields = maskToName;
            destination$iv$iv.add(it$iv$iv);
        }
        DEBUG_PREDEFINED_FILTERS_MASK_NAMES = kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.toReadOnlyList((List)destination$iv$iv);
        this_$iv = Companion;
        destination$iv$iv = $receiver$iv$iv = (Object[])DescriptorKindFilter.class.getFields();
        destination$iv$iv$iv = new ArrayList();
        for (int i = 0; i < ((void)$receiver$iv$iv$iv).length; ++i) {
            element$iv$iv$iv = $receiver$iv$iv$iv[i];
            it$iv = (Field)element$iv$iv$iv;
            if (!Modifier.isStatic(it$iv.getModifiers())) continue;
            destination$iv$iv$iv.add(element$iv$iv$iv);
        }
        $receiver$iv = (List)destination$iv$iv$iv;
        $receiver$iv$iv = $receiver$iv;
        destination$iv$iv = new ArrayList();
        destination$iv$iv$iv = $receiver$iv$iv.iterator();
        while (destination$iv$iv$iv.hasNext()) {
            Object element$iv$iv2 = destination$iv$iv$iv.next();
            Field it = (Field)element$iv$iv2;
            if (!Intrinsics.areEqual(it.getType(), Integer.TYPE)) continue;
            destination$iv$iv.add(element$iv$iv2);
        }
        $receiver$iv = (List)destination$iv$iv;
        $receiver$iv$iv = $receiver$iv;
        destination$iv$iv = new ArrayList();
        $receiver$iv$iv$iv2 = $receiver$iv$iv;
        Iterator iterator3 = $receiver$iv$iv$iv2.iterator();
        while (iterator3.hasNext()) {
            Companion.MaskToName maskToName;
            Companion.MaskToName maskToName2;
            boolean isOneBitMask;
            element$iv$iv = element$iv$iv$iv = iterator3.next();
            field = (Field)element$iv$iv;
            Object object = field.get(null);
            if (object == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
            }
            int mask = (Integer)object;
            boolean bl = isOneBitMask = mask == (mask & -mask);
            if (isOneBitMask) {
                String string = field.getName();
                Intrinsics.checkExpressionValueIsNotNull(string, "field.name");
                maskToName2 = new Companion.MaskToName(mask, string);
            } else {
                maskToName2 = null;
            }
            if (maskToName2 == null) continue;
            Companion.MaskToName it$iv$iv = maskToName = maskToName2;
            destination$iv$iv.add(it$iv$iv);
        }
        DEBUG_MASK_BIT_NAMES = kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.toReadOnlyList((List)objectArray);
    }

    public static final class Companion {
        private final int getNextMaskValue() {
            return nextMaskValue;
        }

        private final void setNextMaskValue(int n) {
            nextMaskValue = n;
        }

        private final int nextMask() {
            int n;
            int $receiver = n = this.getNextMaskValue();
            Companion.setNextMaskValue(Companion.getNextMaskValue() << 1);
            return n;
        }

        public final int getNON_SINGLETON_CLASSIFIERS_MASK() {
            return NON_SINGLETON_CLASSIFIERS_MASK;
        }

        public final int getSINGLETON_CLASSIFIERS_MASK() {
            return SINGLETON_CLASSIFIERS_MASK;
        }

        public final int getTYPE_ALIASES_MASK() {
            return TYPE_ALIASES_MASK;
        }

        public final int getPACKAGES_MASK() {
            return PACKAGES_MASK;
        }

        public final int getFUNCTIONS_MASK() {
            return FUNCTIONS_MASK;
        }

        public final int getVARIABLES_MASK() {
            return VARIABLES_MASK;
        }

        public final int getALL_KINDS_MASK() {
            return ALL_KINDS_MASK;
        }

        public final int getCLASSIFIERS_MASK() {
            return CLASSIFIERS_MASK;
        }

        public final int getVALUES_MASK() {
            return VALUES_MASK;
        }

        public final int getCALLABLES_MASK() {
            return CALLABLES_MASK;
        }

        private final List<MaskToName> getDEBUG_PREDEFINED_FILTERS_MASK_NAMES() {
            return DEBUG_PREDEFINED_FILTERS_MASK_NAMES;
        }

        private final List<MaskToName> getDEBUG_MASK_BIT_NAMES() {
            return DEBUG_MASK_BIT_NAMES;
        }

        /*
         * WARNING - void declaration
         */
        private final <T> List<Field> staticFields() {
            void var3_3;
            void $receiver$iv$iv;
            Object[] $receiver$iv;
            Intrinsics.reifiedOperationMarker(4, "T");
            Object[] objectArray = $receiver$iv = (Object[])Object.class.getFields();
            Collection destination$iv$iv = new ArrayList();
            for (int i = 0; i < ((void)$receiver$iv$iv).length; ++i) {
                void element$iv$iv = $receiver$iv$iv[i];
                Field it = (Field)element$iv$iv;
                if (!Modifier.isStatic(it.getModifiers())) continue;
                destination$iv$iv.add(element$iv$iv);
            }
            return (List)var3_3;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private static final class MaskToName {
            private final int mask;
            @NotNull
            private final String name;

            public final int getMask() {
                return this.mask;
            }

            @NotNull
            public final String getName() {
                return this.name;
            }

            public MaskToName(int mask, @NotNull String name2) {
                Intrinsics.checkParameterIsNotNull(name2, "name");
                this.mask = mask;
                this.name = name2;
            }
        }
    }
}

