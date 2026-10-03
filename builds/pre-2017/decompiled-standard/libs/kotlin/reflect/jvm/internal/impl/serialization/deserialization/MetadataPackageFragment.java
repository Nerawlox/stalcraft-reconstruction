/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInSerializerProtocol;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsBinaryVersion;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackagePartProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ChainedMemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.ClassData;
import kotlin.reflect.jvm.internal.impl.serialization.ClassDataWithSource;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.builtins.BuiltInsProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragment;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.KotlinMetadataFinder;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MetadataPackageFragment;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverImpl;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPackageMemberScope;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class MetadataPackageFragment
extends DeserializedPackageFragment {
    @NotNull
    private final ClassDataFinder classDataFinder;
    private final PackagePartProvider packagePartProvider;
    private final KotlinMetadataFinder finder;
    @NotNull
    private static final String DOT_METADATA_FILE_EXTENSION = ".kotlin_metadata";
    @NotNull
    private static final String METADATA_FILE_EXTENSION = "kotlin_metadata";
    public static final Companion Companion = new Companion(null);

    @Override
    @NotNull
    public ClassDataFinder getClassDataFinder() {
        return this.classDataFinder;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    protected MemberScope computeMemberScope() {
        String string = this.getFqName().asString();
        Intrinsics.checkExpressionValueIsNotNull(string, "fqName.asString()");
        List<String> packageParts = this.packagePartProvider.findMetadataPackageParts(string);
        ArrayList<DeserializedPackageMemberScope> scopes = new ArrayList<DeserializedPackageMemberScope>();
        for (String partName : packageParts) {
            void nameResolver;
            void proto;
            InputStream stream;
            if (this.finder.findMetadata(new ClassId(this.getFqName(), Name.identifier(partName))) == null) {
                continue;
            }
            Pair<BuiltInsProtoBuf.BuiltIns, NameResolverImpl> pair = this.readProto(stream);
            BuiltInsProtoBuf.BuiltIns builtIns = pair.component1();
            NameResolverImpl nameResolverImpl = pair.component2();
            pair = null;
            PackageFragmentDescriptor packageFragmentDescriptor = this;
            ProtoBuf.Package package_ = proto.getPackage();
            Intrinsics.checkExpressionValueIsNotNull(package_, "proto.`package`");
            scopes.add(new DeserializedPackageMemberScope(packageFragmentDescriptor, package_, (NameResolver)nameResolver, null, this.getComponents(), computeMemberScope.1.INSTANCE));
        }
        PackageFragmentDescriptor packageFragmentDescriptor = this;
        ProtoBuf.Package package_ = ProtoBuf.Package.getDefaultInstance();
        Intrinsics.checkExpressionValueIsNotNull(package_, "ProtoBuf.Package.getDefaultInstance()");
        ProtoBuf.StringTable stringTable = ProtoBuf.StringTable.getDefaultInstance();
        Intrinsics.checkExpressionValueIsNotNull(stringTable, "ProtoBuf.StringTable.getDefaultInstance()");
        ProtoBuf.QualifiedNameTable qualifiedNameTable = ProtoBuf.QualifiedNameTable.getDefaultInstance();
        Intrinsics.checkExpressionValueIsNotNull(qualifiedNameTable, "ProtoBuf.QualifiedNameTable.getDefaultInstance()");
        scopes.add(new DeserializedPackageMemberScope(this, packageFragmentDescriptor, package_, new NameResolverImpl(stringTable, qualifiedNameTable), null, this.getComponents(), computeMemberScope.3.INSTANCE){
            final /* synthetic */ MetadataPackageFragment this$0;

            protected boolean hasClass(@NotNull Name name2) {
                Intrinsics.checkParameterIsNotNull(name2, "name");
                return this.this$0.hasTopLevelClass(name2);
            }
            {
                this.this$0 = $outer;
                super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4, $super_call_param$5, $super_call_param$6);
            }
        });
        return ChainedMemberScope.Companion.create("Metadata scope", (List<? extends MemberScope>)scopes);
    }

    @Override
    public boolean hasTopLevelClass(@NotNull Name name2) {
        Intrinsics.checkParameterIsNotNull(name2, "name");
        return true;
    }

    private final Pair<BuiltInsProtoBuf.BuiltIns, NameResolverImpl> readProto(InputStream stream) {
        BuiltInsBinaryVersion version = BuiltInsBinaryVersion.Companion.readFrom(stream);
        if (!version.isCompatible()) {
            throw (Throwable)new UnsupportedOperationException("Kotlin metadata definition format version is not supported: " + ("expected " + BuiltInsBinaryVersion.INSTANCE + ", actual " + version + ". ") + "Please update Kotlin");
        }
        BuiltInsProtoBuf.BuiltIns message = BuiltInsProtoBuf.BuiltIns.parseFrom(stream, BuiltInSerializerProtocol.INSTANCE.getExtensionRegistry());
        ProtoBuf.StringTable stringTable = message.getStrings();
        Intrinsics.checkExpressionValueIsNotNull(stringTable, "message.strings");
        ProtoBuf.QualifiedNameTable qualifiedNameTable = message.getQualifiedNames();
        Intrinsics.checkExpressionValueIsNotNull(qualifiedNameTable, "message.qualifiedNames");
        NameResolverImpl nameResolver = new NameResolverImpl(stringTable, qualifiedNameTable);
        return new Pair<BuiltInsProtoBuf.BuiltIns, NameResolverImpl>(message, nameResolver);
    }

    public MetadataPackageFragment(@NotNull FqName fqName2, @NotNull StorageManager storageManager, @NotNull ModuleDescriptor module, @NotNull PackagePartProvider packagePartProvider, @NotNull KotlinMetadataFinder finder) {
        Intrinsics.checkParameterIsNotNull(fqName2, "fqName");
        Intrinsics.checkParameterIsNotNull(storageManager, "storageManager");
        Intrinsics.checkParameterIsNotNull(module, "module");
        Intrinsics.checkParameterIsNotNull(packagePartProvider, "packagePartProvider");
        Intrinsics.checkParameterIsNotNull(finder, "finder");
        super(fqName2, storageManager, module);
        this.packagePartProvider = packagePartProvider;
        this.finder = finder;
        this.classDataFinder = new ClassDataFinder(this){
            final /* synthetic */ MetadataPackageFragment this$0;

            /*
             * WARNING - void declaration
             */
            @Nullable
            public final ClassDataWithSource findClassData(@NotNull ClassId classId) {
                ClassDataWithSource classDataWithSource;
                Object v1;
                void nameResolver;
                Serializable serializable;
                block4: {
                    void message;
                    Intrinsics.checkParameterIsNotNull(classId, "classId");
                    ClassId topLevelClassId2 = SequencesKt.last(SequencesKt.generateSequence(classId, (Function1)classDataFinder.topLevelClassId.1.INSTANCE));
                    InputStream inputStream = MetadataPackageFragment.access$getFinder$p(this.this$0).findMetadata(topLevelClassId2);
                    if (inputStream == null) {
                        return null;
                    }
                    InputStream stream = inputStream;
                    serializable = MetadataPackageFragment.access$readProto(this.this$0, stream);
                    BuiltInsProtoBuf.BuiltIns builtIns = (BuiltInsProtoBuf.BuiltIns)serializable.component1();
                    NameResolverImpl nameResolverImpl = (NameResolverImpl)serializable.component2();
                    serializable = null;
                    Iterable $receiver$iv = message.getClass_List();
                    for (T element$iv : $receiver$iv) {
                        ProtoBuf.Class classProto = (ProtoBuf.Class)element$iv;
                        if (!Intrinsics.areEqual(nameResolver.getClassId(classProto.getFqName()), classId)) continue;
                        v1 = element$iv;
                        break block4;
                    }
                    v1 = null;
                }
                ProtoBuf.Class clazz = v1;
                if (clazz != null) {
                    serializable = clazz;
                    ProtoBuf.Class classProto = (ProtoBuf.Class)serializable;
                    ClassData classData = new ClassData((NameResolver)nameResolver, classProto);
                    SourceElement sourceElement = SourceElement.NO_SOURCE;
                    Intrinsics.checkExpressionValueIsNotNull(sourceElement, "SourceElement.NO_SOURCE");
                    classDataWithSource = new ClassDataWithSource(classData, sourceElement);
                } else {
                    classDataWithSource = null;
                }
                return classDataWithSource;
            }
            {
                this.this$0 = metadataPackageFragment;
            }
        };
    }

    static {
        DOT_METADATA_FILE_EXTENSION = DOT_METADATA_FILE_EXTENSION;
        METADATA_FILE_EXTENSION = METADATA_FILE_EXTENSION;
    }

    @NotNull
    public static final /* synthetic */ KotlinMetadataFinder access$getFinder$p(MetadataPackageFragment $this) {
        return $this.finder;
    }

    @NotNull
    public static final /* synthetic */ Pair access$readProto(MetadataPackageFragment $this, @NotNull InputStream stream) {
        return $this.readProto(stream);
    }

    public static final class Companion {
        @NotNull
        public final String getDOT_METADATA_FILE_EXTENSION() {
            return DOT_METADATA_FILE_EXTENSION;
        }

        @NotNull
        public final String getMETADATA_FILE_EXTENSION() {
            return METADATA_FILE_EXTENSION;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

