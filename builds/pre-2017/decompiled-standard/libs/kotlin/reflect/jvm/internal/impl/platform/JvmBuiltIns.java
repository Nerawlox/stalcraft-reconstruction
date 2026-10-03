/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.platform;

import java.util.List;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.builtins.JvmBuiltInClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmBuiltInsSettings;
import kotlin.reflect.jvm.internal.impl.platform.JvmBuiltIns;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class JvmBuiltIns
extends KotlinBuiltIns {
    private ModuleDescriptor ownerModuleDescriptor;
    private boolean isAdditionalBuiltInsFeatureSupported;
    @NotNull
    private final NotNullLazyValue settings$delegate;
    static final /* synthetic */ KProperty[] $$delegatedProperties;

    public final void initialize(@NotNull ModuleDescriptor moduleDescriptor, boolean isAdditionalBuiltInsFeatureSupported) {
        boolean bl;
        Intrinsics.checkParameterIsNotNull(moduleDescriptor, "moduleDescriptor");
        boolean bl2 = bl = this.ownerModuleDescriptor == null;
        if (_Assertions.ENABLED && !bl) {
            String string = "JvmBuiltins repeated initialization";
            throw (Throwable)((Object)new AssertionError((Object)string));
        }
        this.ownerModuleDescriptor = moduleDescriptor;
        this.isAdditionalBuiltInsFeatureSupported = isAdditionalBuiltInsFeatureSupported;
    }

    @NotNull
    public final JvmBuiltInsSettings getSettings() {
        return (JvmBuiltInsSettings)StorageKt.getValue(this.settings$delegate, (Object)this, $$delegatedProperties[0]);
    }

    @Override
    @NotNull
    protected PlatformDependentDeclarationFilter getPlatformDependentDeclarationFilter() {
        return this.getSettings();
    }

    @Override
    @NotNull
    protected AdditionalClassPartsProvider getAdditionalClassPartsProvider() {
        return this.getSettings();
    }

    @NotNull
    protected List<ClassDescriptorFactory> getClassDescriptorFactories() {
        Iterable<ClassDescriptorFactory> iterable = super.getClassDescriptorFactories();
        StorageManager storageManager = this.getStorageManager();
        Intrinsics.checkExpressionValueIsNotNull(storageManager, "storageManager");
        ModuleDescriptorImpl moduleDescriptorImpl = this.getBuiltInsModule();
        Intrinsics.checkExpressionValueIsNotNull(moduleDescriptorImpl, "builtInsModule");
        return CollectionsKt.plus(iterable, new JvmBuiltInClassDescriptorFactory(storageManager, moduleDescriptorImpl, null, 4, null));
    }

    @JvmOverloads
    public JvmBuiltIns(@NotNull StorageManager storageManager, boolean loadBuiltInsFromCurrentClassLoader) {
        Intrinsics.checkParameterIsNotNull(storageManager, "storageManager");
        super(storageManager);
        this.isAdditionalBuiltInsFeatureSupported = true;
        this.settings$delegate = storageManager.createLazyValue((Function0)new Function0<JvmBuiltInsSettings>(this, storageManager){
            final /* synthetic */ JvmBuiltIns this$0;
            final /* synthetic */ StorageManager $storageManager;

            @NotNull
            public final JvmBuiltInsSettings invoke() {
                ModuleDescriptorImpl moduleDescriptorImpl = this.this$0.getBuiltInsModule();
                Intrinsics.checkExpressionValueIsNotNull(moduleDescriptorImpl, "builtInsModule");
                return new JvmBuiltInsSettings(moduleDescriptorImpl, this.$storageManager, (Function0<? extends ModuleDescriptor>)new Function0<ModuleDescriptor>(this){
                    final /* synthetic */ settings.2 this$0;

                    @NotNull
                    public final ModuleDescriptor invoke() {
                        ModuleDescriptor $receiver$iv;
                        ModuleDescriptor moduleDescriptor = $receiver$iv = JvmBuiltIns.access$getOwnerModuleDescriptor$p(this.this$0.this$0);
                        if (moduleDescriptor == null) {
                            AssertionError assertionError;
                            AssertionError assertionError2 = assertionError;
                            AssertionError assertionError3 = assertionError;
                            String string = "JvmBuiltins has not been initialized properly";
                            assertionError2((Object)string);
                            throw (Throwable)((Object)assertionError3);
                        }
                        return moduleDescriptor;
                    }
                    {
                        this.this$0 = var1_1;
                        super(0);
                    }
                }, new Function0<Boolean>(this){
                    final /* synthetic */ settings.2 this$0;

                    public final boolean invoke() {
                        ModuleDescriptor $receiver$iv = JvmBuiltIns.access$getOwnerModuleDescriptor$p(this.this$0.this$0);
                        if ($receiver$iv == null) {
                            AssertionError assertionError;
                            AssertionError assertionError2 = assertionError;
                            AssertionError assertionError3 = assertionError;
                            String string = "JvmBuiltins has not been initialized properly";
                            assertionError2((Object)string);
                            throw (Throwable)((Object)assertionError3);
                        }
                        return JvmBuiltIns.access$isAdditionalBuiltInsFeatureSupported$p(this.this$0.this$0);
                    }
                    {
                        this.this$0 = var1_1;
                        super(0);
                    }
                });
            }
            {
                this.this$0 = jvmBuiltIns;
                this.$storageManager = storageManager;
                super(0);
            }
        });
        if (loadBuiltInsFromCurrentClassLoader) {
            this.createBuiltInsModule();
        }
    }

    @JvmOverloads
    public /* synthetic */ JvmBuiltIns(StorageManager storageManager, boolean bl, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            bl = true;
        }
        this(storageManager, bl);
    }

    @JvmOverloads
    public JvmBuiltIns(@NotNull StorageManager storageManager) {
        this(storageManager, false, 2, null);
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(JvmBuiltIns.class), "settings", "getSettings()Lorg/jetbrains/kotlin/load/kotlin/JvmBuiltInsSettings;"))};
    }

    @Nullable
    public static final /* synthetic */ ModuleDescriptor access$getOwnerModuleDescriptor$p(JvmBuiltIns $this) {
        return $this.ownerModuleDescriptor;
    }

    public static final /* synthetic */ void access$setOwnerModuleDescriptor$p(JvmBuiltIns $this, @Nullable ModuleDescriptor moduleDescriptor) {
        $this.ownerModuleDescriptor = moduleDescriptor;
    }

    public static final /* synthetic */ boolean access$isAdditionalBuiltInsFeatureSupported$p(JvmBuiltIns $this) {
        return $this.isAdditionalBuiltInsFeatureSupported;
    }

    public static final /* synthetic */ void access$setAdditionalBuiltInsFeatureSupported$p(JvmBuiltIns $this, boolean bl) {
        $this.isAdditionalBuiltInsFeatureSupported = bl;
    }
}

