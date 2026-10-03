/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import java.util.Set;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.serialization.ClassData;
import kotlin.reflect.jvm.internal.impl.serialization.ClassDataWithSource;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragment;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.SinceKotlinInfoTable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ClassDeserializer {
    private final Function1<ClassKey, ClassDescriptor> classes;
    private final DeserializationComponents components;
    @NotNull
    private static final Set<ClassId> BLACK_LIST;
    public static final Companion Companion;

    @Nullable
    public final ClassDescriptor deserializeClass(@NotNull ClassId classId, @Nullable ClassDataWithSource classDataWithSource) {
        Intrinsics.checkParameterIsNotNull(classId, "classId");
        return this.classes.invoke(new ClassKey(classId, classDataWithSource));
    }

    @Nullable
    public static /* bridge */ /* synthetic */ ClassDescriptor deserializeClass$default(ClassDeserializer classDeserializer, ClassId classId, ClassDataWithSource classDataWithSource, int n, Object object) {
        if ((n & 2) != 0) {
            classDataWithSource = null;
        }
        return classDeserializer.deserializeClass(classId, classDataWithSource);
    }

    /*
     * WARNING - void declaration
     */
    private final ClassDescriptor createClass(ClassKey key) {
        void sourceElement;
        void nameResolver;
        void classProto;
        DeserializationContext deserializationContext;
        ClassId classId = key.getClassId();
        for (ClassDescriptorFactory classDescriptorFactory : this.components.getFictitiousClassDescriptorFactories()) {
            ClassDescriptor object;
            ClassDescriptor classDescriptor = classDescriptorFactory.createClass(classId);
            if (classDescriptor == null) continue;
            ClassDescriptor it = object = classDescriptor;
            return it;
        }
        if (Companion.getBLACK_LIST().contains(classId)) {
            return null;
        }
        ClassDataWithSource classDataWithSource = key.getClassDataWithSource();
        if (classDataWithSource == null) {
            classDataWithSource = this.components.getClassDataFinder().findClassData(classId);
        }
        if (classDataWithSource == null) {
            return null;
        }
        Object object = classDataWithSource;
        ClassData classData = ((ClassDataWithSource)object).component1();
        SourceElement sourceElement2 = ((ClassDataWithSource)object).component2();
        object = null;
        ClassData $i$a$1$let = classData;
        object = $i$a$1$let.component1();
        ProtoBuf.Class it = $i$a$1$let.component2();
        $i$a$1$let = null;
        if (classId.isNestedClass()) {
            ClassId classId2 = classId.getOuterClassId();
            Intrinsics.checkExpressionValueIsNotNull(classId2, "classId.outerClassId");
            ClassDescriptor classDescriptor = ClassDeserializer.deserializeClass$default(this, classId2, null, 2, null);
            if (!(classDescriptor instanceof DeserializedClassDescriptor)) {
                classDescriptor = null;
            }
            DeserializedClassDescriptor deserializedClassDescriptor = (DeserializedClassDescriptor)classDescriptor;
            if (deserializedClassDescriptor == null) {
                return null;
            }
            DeserializedClassDescriptor outerClass = deserializedClassDescriptor;
            Name name2 = classId.getShortClassName();
            Intrinsics.checkExpressionValueIsNotNull(name2, "classId.shortClassName");
            if (!outerClass.hasNestedClass$kotlin_core(name2)) {
                return null;
            }
            deserializationContext = outerClass.getC();
        } else {
            boolean bl;
            PackageFragmentProvider packageFragmentProvider = this.components.getPackageFragmentProvider();
            FqName fqName2 = classId.getPackageFqName();
            Intrinsics.checkExpressionValueIsNotNull(fqName2, "classId.packageFqName");
            List<PackageFragmentDescriptor> fragments2 = packageFragmentProvider.getPackageFragments(fqName2);
            boolean bl2 = bl = fragments2.size() == 1;
            if (_Assertions.ENABLED && !bl) {
                String string = "There should be exactly one package: " + fragments2 + ", class id is " + classId;
                throw (Throwable)((Object)new AssertionError((Object)string));
            }
            PackageFragmentDescriptor fragment = CollectionsKt.single(fragments2);
            if (fragment instanceof DeserializedPackageFragment) {
                DeserializedPackageFragment deserializedPackageFragment = (DeserializedPackageFragment)fragment;
                Name name3 = classId.getShortClassName();
                Intrinsics.checkExpressionValueIsNotNull(name3, "classId.shortClassName");
                if (!deserializedPackageFragment.hasTopLevelClass(name3)) {
                    return null;
                }
            }
            ProtoBuf.TypeTable typeTable = classProto.getTypeTable();
            Intrinsics.checkExpressionValueIsNotNull(typeTable, "classProto.typeTable");
            TypeTable typeTable2 = new TypeTable(typeTable);
            ProtoBuf.SinceKotlinInfoTable sinceKotlinInfoTable = classProto.getSinceKotlinInfoTable();
            Intrinsics.checkExpressionValueIsNotNull(sinceKotlinInfoTable, "classProto.sinceKotlinInfoTable");
            deserializationContext = this.components.createContext(fragment, (NameResolver)nameResolver, typeTable2, SinceKotlinInfoTable.Companion.create(sinceKotlinInfoTable), null);
        }
        DeserializationContext outerContext = deserializationContext;
        return new DeserializedClassDescriptor(outerContext, (ProtoBuf.Class)classProto, (NameResolver)nameResolver, (SourceElement)sourceElement);
    }

    public ClassDeserializer(@NotNull DeserializationComponents components) {
        Intrinsics.checkParameterIsNotNull(components, "components");
        this.components = components;
        this.classes = this.components.getStorageManager().createMemoizedFunctionWithNullableValues((Function1)new Function1<ClassKey, ClassDescriptor>(this){
            final /* synthetic */ ClassDeserializer this$0;

            @Nullable
            public final ClassDescriptor invoke(@NotNull ClassKey key) {
                Intrinsics.checkParameterIsNotNull(key, "key");
                return ClassDeserializer.access$createClass(this.this$0, key);
            }
            {
                this.this$0 = classDeserializer;
                super(1);
            }
        });
    }

    static {
        Companion = new Companion(null);
        BLACK_LIST = SetsKt.setOf(ClassId.topLevel(KotlinBuiltIns.FQ_NAMES.cloneable.toSafe()));
    }

    @Nullable
    public static final /* synthetic */ ClassDescriptor access$createClass(ClassDeserializer $this, @NotNull ClassKey key) {
        return $this.createClass(key);
    }

    private static final class ClassKey {
        @NotNull
        private final ClassId classId;
        @Nullable
        private final ClassDataWithSource classDataWithSource;

        public boolean equals(@Nullable Object other) {
            return other instanceof ClassKey && Intrinsics.areEqual(this.classId, ((ClassKey)other).classId);
        }

        public int hashCode() {
            return this.classId.hashCode();
        }

        @NotNull
        public final ClassId getClassId() {
            return this.classId;
        }

        @Nullable
        public final ClassDataWithSource getClassDataWithSource() {
            return this.classDataWithSource;
        }

        public ClassKey(@NotNull ClassId classId, @Nullable ClassDataWithSource classDataWithSource) {
            Intrinsics.checkParameterIsNotNull(classId, "classId");
            this.classId = classId;
            this.classDataWithSource = classDataWithSource;
        }
    }

    public static final class Companion {
        @NotNull
        public final Set<ClassId> getBLACK_LIST() {
            return BLACK_LIST;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

