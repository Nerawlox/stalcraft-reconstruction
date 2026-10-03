/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.Collection;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.builtins.CloneableClassScope;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class JvmBuiltInClassDescriptorFactory
implements ClassDescriptorFactory {
    private final NotNullLazyValue cloneable$delegate;
    private final ModuleDescriptor moduleDescriptor;
    private final Function1<ModuleDescriptor, DeclarationDescriptor> computeContainingDeclaration;
    private static final FqName KOTLIN_FQ_NAME;
    private static final Name CLONEABLE_NAME;
    @NotNull
    private static final ClassId CLONEABLE_CLASS_ID;
    static final /* synthetic */ KProperty[] $$delegatedProperties;
    public static final Companion Companion;

    private final ClassDescriptorImpl getCloneable() {
        return (ClassDescriptorImpl)StorageKt.getValue(this.cloneable$delegate, (Object)this, $$delegatedProperties[0]);
    }

    @Override
    public boolean shouldCreateClass(@NotNull FqName packageFqName, @NotNull Name name2) {
        Intrinsics.checkParameterIsNotNull(packageFqName, "packageFqName");
        Intrinsics.checkParameterIsNotNull(name2, "name");
        return Intrinsics.areEqual(name2, JvmBuiltInClassDescriptorFactory.Companion.getCLONEABLE_NAME()) && Intrinsics.areEqual(packageFqName, JvmBuiltInClassDescriptorFactory.Companion.getKOTLIN_FQ_NAME());
    }

    @Override
    @Nullable
    public ClassDescriptor createClass(@NotNull ClassId classId) {
        Intrinsics.checkParameterIsNotNull(classId, "classId");
        ClassId classId2 = classId;
        return Intrinsics.areEqual(classId2, Companion.getCLONEABLE_CLASS_ID()) ? (ClassDescriptor)this.getCloneable() : null;
    }

    @Override
    @NotNull
    public Collection<ClassDescriptor> getAllContributedClassesIfPossible(@NotNull FqName packageFqName) {
        Intrinsics.checkParameterIsNotNull(packageFqName, "packageFqName");
        FqName fqName2 = packageFqName;
        return Intrinsics.areEqual(fqName2, JvmBuiltInClassDescriptorFactory.Companion.getKOTLIN_FQ_NAME()) ? (Collection)SetsKt.setOf(this.getCloneable()) : (Collection)SetsKt.emptySet();
    }

    public JvmBuiltInClassDescriptorFactory(@NotNull StorageManager storageManager, @NotNull ModuleDescriptor moduleDescriptor, @NotNull Function1<? super ModuleDescriptor, ? extends DeclarationDescriptor> computeContainingDeclaration) {
        Intrinsics.checkParameterIsNotNull(storageManager, "storageManager");
        Intrinsics.checkParameterIsNotNull(moduleDescriptor, "moduleDescriptor");
        Intrinsics.checkParameterIsNotNull(computeContainingDeclaration, "computeContainingDeclaration");
        this.moduleDescriptor = moduleDescriptor;
        this.computeContainingDeclaration = computeContainingDeclaration;
        this.cloneable$delegate = storageManager.createLazyValue((Function0)new Function0<ClassDescriptorImpl>(this, storageManager){
            final /* synthetic */ JvmBuiltInClassDescriptorFactory this$0;
            final /* synthetic */ StorageManager $storageManager;

            @NotNull
            public final ClassDescriptorImpl invoke() {
                ClassDescriptorImpl classDescriptorImpl;
                ClassDescriptorImpl $receiver = classDescriptorImpl = new ClassDescriptorImpl((DeclarationDescriptor)JvmBuiltInClassDescriptorFactory.access$getComputeContainingDeclaration$p(this.this$0).invoke(JvmBuiltInClassDescriptorFactory.access$getModuleDescriptor$p(this.this$0)), kotlin.reflect.jvm.internal.impl.builtins.JvmBuiltInClassDescriptorFactory$Companion.access$getCLONEABLE_NAME$p(JvmBuiltInClassDescriptorFactory.Companion), Modality.ABSTRACT, ClassKind.INTERFACE, (Collection<KotlinType>)CollectionsKt.listOf(JvmBuiltInClassDescriptorFactory.access$getModuleDescriptor$p(this.this$0).getBuiltIns().getAnyType()), SourceElement.NO_SOURCE, false);
                $receiver.initialize(new CloneableClassScope(this.$storageManager, $receiver), SetsKt.<ClassConstructorDescriptor>emptySet(), null);
                return classDescriptorImpl;
            }
            {
                this.this$0 = jvmBuiltInClassDescriptorFactory;
                this.$storageManager = storageManager;
                super(0);
            }
        });
    }

    public /* synthetic */ JvmBuiltInClassDescriptorFactory(StorageManager storageManager, ModuleDescriptor moduleDescriptor, Function1 function1, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 4) != 0) {
            function1 = 1.INSTANCE;
        }
        this(storageManager, moduleDescriptor, function1);
    }

    static {
        Companion = new Companion(null);
        KOTLIN_FQ_NAME = KotlinBuiltIns.BUILT_INS_PACKAGE_FQ_NAME;
        CLONEABLE_NAME = KotlinBuiltIns.FQ_NAMES.cloneable.shortName();
        CLONEABLE_CLASS_ID = ClassId.topLevel(KotlinBuiltIns.FQ_NAMES.cloneable.toSafe());
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(JvmBuiltInClassDescriptorFactory.class), "cloneable", "getCloneable()Lorg/jetbrains/kotlin/descriptors/impl/ClassDescriptorImpl;"))};
    }

    @NotNull
    public static final /* synthetic */ Function1 access$getComputeContainingDeclaration$p(JvmBuiltInClassDescriptorFactory $this) {
        return $this.computeContainingDeclaration;
    }

    @NotNull
    public static final /* synthetic */ ModuleDescriptor access$getModuleDescriptor$p(JvmBuiltInClassDescriptorFactory $this) {
        return $this.moduleDescriptor;
    }

    public static final class Companion {
        private final FqName getKOTLIN_FQ_NAME() {
            return KOTLIN_FQ_NAME;
        }

        private final Name getCLONEABLE_NAME() {
            return CLONEABLE_NAME;
        }

        @NotNull
        public final ClassId getCLONEABLE_CLASS_ID() {
            return CLONEABLE_CLASS_ID;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

