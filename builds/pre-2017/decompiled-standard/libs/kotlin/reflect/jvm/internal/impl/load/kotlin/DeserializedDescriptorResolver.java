/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.Set;
import kotlin.Deprecated;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.javax.inject.Inject;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializationComponentsForJava;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmPackagePartSource;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinarySourceElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.ClassData;
import kotlin.reflect.jvm.internal.impl.serialization.ClassDataWithSource;
import kotlin.reflect.jvm.internal.impl.serialization.PackageData;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.IncompatibleVersionErrorData;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPackageMemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.jvm.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.utils.addToStdlib.AddToStdlibKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class DeserializedDescriptorResolver {
    @NotNull
    public DeserializationComponents components;
    @NotNull
    private static final Set<KotlinClassHeader.Kind> KOTLIN_CLASS;
    private static final Set<KotlinClassHeader.Kind> KOTLIN_FILE_FACADE_OR_MULTIFILE_CLASS_PART;
    private static final JvmMetadataVersion KOTLIN_1_1_EAP_METADATA_VERSION;
    private static boolean IS_PRE_RELEASE;
    @NotNull
    public static final String TEST_IS_PRE_RELEASE_SYSTEM_PROPERTY = "kotlin.test.is.pre.release";
    public static final Companion Companion;

    @NotNull
    public final DeserializationComponents getComponents() {
        DeserializationComponents deserializationComponents = this.components;
        if (deserializationComponents == null) {
            Intrinsics.throwUninitializedPropertyAccessException("components");
        }
        return deserializationComponents;
    }

    public final void setComponents(@NotNull DeserializationComponents deserializationComponents) {
        Intrinsics.checkParameterIsNotNull(deserializationComponents, "<set-?>");
        this.components = deserializationComponents;
    }

    @Inject
    public final void setComponents(@NotNull DeserializationComponentsForJava components) {
        Intrinsics.checkParameterIsNotNull(components, "components");
        this.components = components.getComponents();
    }

    @Nullable
    public final ClassDescriptor resolveClass(@NotNull KotlinJvmBinaryClass kotlinClass) {
        Intrinsics.checkParameterIsNotNull(kotlinClass, "kotlinClass");
        ClassDataWithSource classDataWithSource = this.readClassData$kotlin_core(kotlinClass);
        if (classDataWithSource == null) {
            return null;
        }
        ClassDataWithSource classData = classDataWithSource;
        DeserializationComponents deserializationComponents = this.components;
        if (deserializationComponents == null) {
            Intrinsics.throwUninitializedPropertyAccessException("components");
        }
        return deserializationComponents.getClassDeserializer().deserializeClass(kotlinClass.getClassId(), classData);
    }

    @Nullable
    public final ClassDataWithSource readClassData$kotlin_core(@NotNull KotlinJvmBinaryClass kotlinClass) {
        ClassData classData;
        Intrinsics.checkParameterIsNotNull(kotlinClass, "kotlinClass");
        String[] stringArray = this.readData$kotlin_core(kotlinClass, Companion.getKOTLIN_CLASS$kotlin_core());
        if (stringArray == null) {
            return null;
        }
        String[] data2 = stringArray;
        String[] stringArray2 = kotlinClass.getClassHeader().getStrings();
        if (stringArray2 == null) {
            return null;
        }
        String[] strings = stringArray2;
        DeserializedDescriptorResolver this_$iv = this;
        try {
            try {
                classData = JvmProtoBufUtil.readClassDataFrom(data2, strings);
            }
            catch (InvalidProtocolBufferException e$iv) {
                throw (Throwable)new IllegalStateException("Could not read data from " + kotlinClass.getLocation(), e$iv);
            }
        }
        catch (Throwable e$iv) {
            if (!kotlinClass.getClassHeader().getMetadataVersion().isCompatible()) {
                classData = null;
            }
            throw e$iv;
        }
        if (classData == null) {
            return null;
        }
        ClassData classData2 = classData;
        KotlinJvmBinarySourceElement source = new KotlinJvmBinarySourceElement(kotlinClass, this.getIncompatibility(kotlinClass), this.isPreReleaseInvisible(kotlinClass));
        return new ClassDataWithSource(classData2, source);
    }

    /*
     * WARNING - void declaration
     */
    @Nullable
    public final MemberScope createKotlinPackagePartScope(@NotNull PackageFragmentDescriptor descriptor2, @NotNull KotlinJvmBinaryClass kotlinClass) {
        void nameResolver;
        void packageProto;
        PackageData packageData;
        Intrinsics.checkParameterIsNotNull(descriptor2, "descriptor");
        Intrinsics.checkParameterIsNotNull(kotlinClass, "kotlinClass");
        String[] stringArray = this.readData$kotlin_core(kotlinClass, DeserializedDescriptorResolver.Companion.getKOTLIN_FILE_FACADE_OR_MULTIFILE_CLASS_PART());
        if (stringArray == null) {
            return null;
        }
        String[] data2 = stringArray;
        String[] stringArray2 = kotlinClass.getClassHeader().getStrings();
        if (stringArray2 == null) {
            return null;
        }
        String[] strings = stringArray2;
        DeserializedDescriptorResolver this_$iv = this;
        try {
            try {
                packageData = JvmProtoBufUtil.readPackageDataFrom(data2, strings);
            }
            catch (InvalidProtocolBufferException e$iv) {
                throw (Throwable)new IllegalStateException("Could not read data from " + kotlinClass.getLocation(), e$iv);
            }
        }
        catch (Throwable e$iv) {
            if (!kotlinClass.getClassHeader().getMetadataVersion().isCompatible()) {
                packageData = null;
            }
            throw e$iv;
        }
        if (packageData == null) {
            return null;
        }
        PackageData packageData2 = packageData;
        NameResolver nameResolver2 = packageData2.component1();
        ProtoBuf.Package package_ = packageData2.component2();
        packageData2 = null;
        JvmPackagePartSource source = new JvmPackagePartSource(kotlinClass, this.getIncompatibility(kotlinClass), this.isPreReleaseInvisible(kotlinClass));
        DeserializedContainerSource deserializedContainerSource = source;
        DeserializationComponents deserializationComponents = this.components;
        if (deserializationComponents == null) {
            Intrinsics.throwUninitializedPropertyAccessException("components");
        }
        return new DeserializedPackageMemberScope(descriptor2, (ProtoBuf.Package)packageProto, (NameResolver)nameResolver, deserializedContainerSource, deserializationComponents, createKotlinPackagePartScope.2.INSTANCE);
    }

    private final IncompatibleVersionErrorData<JvmMetadataVersion> getIncompatibility(@NotNull KotlinJvmBinaryClass $receiver) {
        if ($receiver.getClassHeader().getMetadataVersion().isCompatible()) {
            return null;
        }
        return new IncompatibleVersionErrorData<BinaryVersion>($receiver.getClassHeader().getMetadataVersion(), JvmMetadataVersion.INSTANCE, $receiver.getLocation(), $receiver.getClassId());
    }

    private final boolean isPreReleaseInvisible(@NotNull KotlinJvmBinaryClass $receiver) {
        return !JvmMetadataVersion.Companion.getSkipCheck() && !Companion.getIS_PRE_RELEASE() && ($receiver.getClassHeader().isPreRelease() || Intrinsics.areEqual($receiver.getClassHeader().getMetadataVersion(), DeserializedDescriptorResolver.Companion.getKOTLIN_1_1_EAP_METADATA_VERSION()));
    }

    @Nullable
    public final String[] readData$kotlin_core(@NotNull KotlinJvmBinaryClass kotlinClass, @NotNull Set<? extends KotlinClassHeader.Kind> expectedKinds) {
        Intrinsics.checkParameterIsNotNull(kotlinClass, "kotlinClass");
        Intrinsics.checkParameterIsNotNull(expectedKinds, "expectedKinds");
        KotlinClassHeader header = kotlinClass.getClassHeader();
        String[] stringArray = header.getData();
        if (stringArray == null) {
            stringArray = header.getIncompatibleData();
        }
        return stringArray != null ? AddToStdlibKt.check(stringArray, (Function1)new Function1<String[], Boolean>(expectedKinds, header){
            final /* synthetic */ Set $expectedKinds;
            final /* synthetic */ KotlinClassHeader $header;

            public final boolean invoke(@NotNull String[] it) {
                Intrinsics.checkParameterIsNotNull(it, "it");
                return this.$expectedKinds.contains((Object)((Object)this.$header.getKind()));
            }
            {
                this.$expectedKinds = set;
                this.$header = kotlinClassHeader;
                super(1);
            }
        }) : null;
    }

    private final <T> T parseProto(KotlinJvmBinaryClass klass, Function0<? extends T> block) {
        try {
            try {
                return block.invoke();
            }
            catch (InvalidProtocolBufferException e) {
                throw (Throwable)new IllegalStateException("Could not read data from " + klass.getLocation(), e);
            }
        }
        catch (Throwable e) {
            if (!klass.getClassHeader().getMetadataVersion().isCompatible()) {
                return null;
            }
            throw e;
        }
    }

    static {
        Companion = new Companion(null);
        KOTLIN_CLASS = SetsKt.setOf(KotlinClassHeader.Kind.CLASS);
        KOTLIN_FILE_FACADE_OR_MULTIFILE_CLASS_PART = SetsKt.setOf(new KotlinClassHeader.Kind[]{KotlinClassHeader.Kind.FILE_FACADE, KotlinClassHeader.Kind.MULTIFILE_CLASS_PART});
        KOTLIN_1_1_EAP_METADATA_VERSION = new JvmMetadataVersion(1, 1, 2);
    }

    public static final class Companion {
        @NotNull
        public final Set<KotlinClassHeader.Kind> getKOTLIN_CLASS$kotlin_core() {
            return KOTLIN_CLASS;
        }

        private final Set<KotlinClassHeader.Kind> getKOTLIN_FILE_FACADE_OR_MULTIFILE_CLASS_PART() {
            return KOTLIN_FILE_FACADE_OR_MULTIFILE_CLASS_PART;
        }

        private final JvmMetadataVersion getKOTLIN_1_1_EAP_METADATA_VERSION() {
            return KOTLIN_1_1_EAP_METADATA_VERSION;
        }

        public final boolean getIS_PRE_RELEASE() {
            boolean bl;
            String testOverrideValue;
            String string = testOverrideValue = System.getProperty(DeserializedDescriptorResolver.TEST_IS_PRE_RELEASE_SYSTEM_PROPERTY);
            if (string != null) {
                String string2 = string;
                bl = Boolean.parseBoolean(string2);
            } else {
                bl = IS_PRE_RELEASE;
            }
            return bl;
        }

        @Deprecated(message="Should only be used in tests")
        public final void setIS_PRE_RELEASE(boolean bl) {
            IS_PRE_RELEASE = bl;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

