/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.builtins;

import java.io.Closeable;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInSerializerProtocol;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsBinaryVersion;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsClassDataFinder;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.builtins.BuiltInsProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragment;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverImpl;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPackageMemberScope;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;

public final class BuiltInsPackageFragment
extends DeserializedPackageFragment {
    private final BuiltInsProtoBuf.BuiltIns proto;
    private final NameResolverImpl nameResolver;
    @NotNull
    private final BuiltInsClassDataFinder classDataFinder;

    @Override
    @NotNull
    public BuiltInsClassDataFinder getClassDataFinder() {
        return this.classDataFinder;
    }

    @Override
    @NotNull
    protected DeserializedPackageMemberScope computeMemberScope() {
        PackageFragmentDescriptor packageFragmentDescriptor = this;
        ProtoBuf.Package package_ = this.proto.getPackage();
        Intrinsics.checkExpressionValueIsNotNull(package_, "proto.`package`");
        return new DeserializedPackageMemberScope(packageFragmentDescriptor, package_, this.nameResolver, null, this.getComponents(), (Function0<? extends Collection<Name>>)new Function0<List<? extends Name>>(this){
            final /* synthetic */ BuiltInsPackageFragment this$0;

            /*
             * WARNING - void declaration
             */
            @NotNull
            public final List<Name> invoke() {
                void var3_3;
                ClassId classId;
                Iterable $receiver$iv$iv;
                Iterable $receiver$iv;
                Iterable iterable = $receiver$iv = (Iterable)this.this$0.getClassDataFinder().getAllClassIds$kotlin_core();
                Collection destination$iv$iv = new ArrayList<E>();
                for (T element$iv$iv : $receiver$iv$iv) {
                    classId = (ClassId)element$iv$iv;
                    if (!(!classId.isNestedClass() && ClassDeserializer.Companion.getBLACK_LIST().contains(classId) ^ true)) continue;
                    destination$iv$iv.add(element$iv$iv);
                }
                $receiver$iv = (List)destination$iv$iv;
                $receiver$iv$iv = $receiver$iv;
                destination$iv$iv = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
                for (T item$iv$iv : $receiver$iv$iv) {
                    void it;
                    classId = (ClassId)item$iv$iv;
                    Collection collection = destination$iv$iv;
                    Name name2 = it.getShortClassName();
                    collection.add(name2);
                }
                return (List)var3_3;
            }
            {
                this.this$0 = builtInsPackageFragment;
                super(0);
            }
        });
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public BuiltInsPackageFragment(@NotNull FqName fqName2, @NotNull StorageManager storageManager, @NotNull ModuleDescriptor module, @NotNull InputStream inputStream) {
        BuiltInsProtoBuf.BuiltIns builtIns;
        BuiltInsProtoBuf.BuiltIns builtIns2;
        Intrinsics.checkParameterIsNotNull(fqName2, "fqName");
        Intrinsics.checkParameterIsNotNull(storageManager, "storageManager");
        Intrinsics.checkParameterIsNotNull(module, "module");
        Intrinsics.checkParameterIsNotNull(inputStream, "inputStream");
        super(fqName2, storageManager, module);
        Closeable closeable = inputStream;
        BuiltInsPackageFragment builtInsPackageFragment = this;
        boolean bl = false;
        try {
            InputStream stream = (InputStream)closeable;
            BuiltInsBinaryVersion version = BuiltInsBinaryVersion.Companion.readFrom(stream);
            if (!version.isCompatible()) {
                throw (Throwable)new UnsupportedOperationException("Kotlin built-in definition format version is not supported: " + ("expected " + BuiltInsBinaryVersion.INSTANCE + ", actual " + version + ". ") + "Please update Kotlin");
            }
            builtIns2 = BuiltInsProtoBuf.BuiltIns.parseFrom(stream, BuiltInSerializerProtocol.INSTANCE.getExtensionRegistry());
        }
        catch (Exception exception) {
            bl = true;
            try {
                Closeable closeable2 = closeable;
                if (closeable2 != null) {
                    closeable2.close();
                }
            }
            catch (Exception exception2) {
                // empty catch block
            }
            throw (Throwable)exception;
        }
        finally {
            if (!bl) {
                Closeable closeable3 = closeable;
                if (closeable3 != null) {
                    closeable3.close();
                }
            }
        }
        builtInsPackageFragment.proto = builtIns = builtIns2;
        ProtoBuf.StringTable stringTable = this.proto.getStrings();
        Intrinsics.checkExpressionValueIsNotNull(stringTable, "proto.strings");
        ProtoBuf.QualifiedNameTable qualifiedNameTable = this.proto.getQualifiedNames();
        Intrinsics.checkExpressionValueIsNotNull(qualifiedNameTable, "proto.qualifiedNames");
        this.nameResolver = new NameResolverImpl(stringTable, qualifiedNameTable);
        BuiltInsProtoBuf.BuiltIns builtIns3 = this.proto;
        Intrinsics.checkExpressionValueIsNotNull(builtIns3, "proto");
        this.classDataFinder = new BuiltInsClassDataFinder(builtIns3, this.nameResolver);
    }
}

