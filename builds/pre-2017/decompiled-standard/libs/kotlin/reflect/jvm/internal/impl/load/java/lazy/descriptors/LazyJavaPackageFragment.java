/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackagePartProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageFragmentDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.JvmPackageScope;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment$WhenMappings;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryPackageSourceElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class LazyJavaPackageFragment
extends PackageFragmentDescriptorImpl {
    @NotNull
    private final NotNullLazyValue binaryClasses$delegate;
    private final JvmPackageScope scope;
    private final NotNullLazyValue<List<FqName>> subPackages;
    private final NotNullLazyValue partToFacade$delegate;
    private final LazyJavaResolverContext c;
    private final JavaPackage jPackage;
    static final /* synthetic */ KProperty[] $$delegatedProperties;

    @NotNull
    public final Map<String, KotlinJvmBinaryClass> getBinaryClasses$kotlin_core() {
        return (Map)StorageKt.getValue(this.binaryClasses$delegate, (Object)this, $$delegatedProperties[0]);
    }

    @NotNull
    public final List<FqName> getSubPackageFqNames$kotlin_core() {
        return (List)this.subPackages.invoke();
    }

    @Nullable
    public final ClassDescriptor findClassifierByJavaClass$kotlin_core(@NotNull JavaClass jClass) {
        Intrinsics.checkParameterIsNotNull(jClass, "jClass");
        return this.scope.getJavaScope$kotlin_core().findClassifierByJavaClass$kotlin_core(jClass);
    }

    private final HashMap<String, String> getPartToFacade() {
        return (HashMap)StorageKt.getValue(this.partToFacade$delegate, (Object)this, $$delegatedProperties[1]);
    }

    @Nullable
    public final String getFacadeSimpleNameForPartSimpleName(@NotNull String partName) {
        Intrinsics.checkParameterIsNotNull(partName, "partName");
        return this.getPartToFacade().get(partName);
    }

    @Override
    @NotNull
    public JvmPackageScope getMemberScope() {
        return this.scope;
    }

    @Override
    @NotNull
    public String toString() {
        return "Lazy Java package fragment: " + this.getFqName();
    }

    @Override
    @NotNull
    public SourceElement getSource() {
        return new KotlinJvmBinaryPackageSourceElement(this);
    }

    public LazyJavaPackageFragment(@NotNull LazyJavaResolverContext c, @NotNull JavaPackage jPackage) {
        Intrinsics.checkParameterIsNotNull(c, "c");
        Intrinsics.checkParameterIsNotNull(jPackage, "jPackage");
        super(c.getModule(), jPackage.getFqName());
        this.c = c;
        this.jPackage = jPackage;
        this.binaryClasses$delegate = this.c.getStorageManager().createLazyValue((Function0)new Function0<Map<String, ? extends KotlinJvmBinaryClass>>(this){
            final /* synthetic */ LazyJavaPackageFragment this$0;

            /*
             * WARNING - void declaration
             */
            @NotNull
            public final Map<String, KotlinJvmBinaryClass> invoke() {
                void var3_3;
                void $receiver$iv$iv;
                Iterable $receiver$iv;
                PackagePartProvider packagePartProvider = LazyJavaPackageFragment.access$getC$p(this.this$0).getComponents().getPackageMapper();
                String string = this.this$0.getFqName().asString();
                Intrinsics.checkExpressionValueIsNotNull(string, "fqName.asString()");
                Iterable iterable = $receiver$iv = (Iterable)packagePartProvider.findPackageParts(string);
                Collection destination$iv$iv = new ArrayList<E>();
                void $receiver$iv$iv$iv = $receiver$iv$iv;
                Iterator<T> iterator2 = $receiver$iv$iv$iv.iterator();
                while (iterator2.hasNext()) {
                    Pair<String, KotlinJvmBinaryClass> pair;
                    Pair<String, KotlinJvmBinaryClass> pair2;
                    T element$iv$iv$iv;
                    T element$iv$iv = element$iv$iv$iv = iterator2.next();
                    String partName = (String)element$iv$iv;
                    ClassId classId = new ClassId(this.this$0.getFqName(), Name.identifier(partName));
                    if (LazyJavaPackageFragment.access$getC$p(this.this$0).getComponents().getKotlinClassFinder().findKotlinClass(classId) != null) {
                        KotlinJvmBinaryClass kotlinJvmBinaryClass;
                        KotlinJvmBinaryClass it = kotlinJvmBinaryClass;
                        pair2 = TuplesKt.to(partName, it);
                    } else {
                        pair2 = null;
                    }
                    if (pair2 == null) continue;
                    Pair<String, KotlinJvmBinaryClass> it$iv$iv = pair = pair2;
                    destination$iv$iv.add(it$iv$iv);
                }
                return MapsKt.toMap((List)var3_3);
            }
            {
                this.this$0 = lazyJavaPackageFragment;
                super(0);
            }
        });
        this.scope = new JvmPackageScope(this.c, this.jPackage, this);
        Function0 function0 = new Function0<List<? extends FqName>>(this){
            final /* synthetic */ LazyJavaPackageFragment this$0;

            /*
             * WARNING - void declaration
             */
            @NotNull
            public final List<FqName> invoke() {
                void var3_3;
                void $receiver$iv$iv;
                Iterable $receiver$iv;
                Iterable iterable = $receiver$iv = (Iterable)LazyJavaPackageFragment.access$getJPackage$p(this.this$0).getSubPackages();
                Collection destination$iv$iv = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
                Iterator<T> iterator2 = $receiver$iv$iv.iterator();
                while (iterator2.hasNext()) {
                    void receiver;
                    T item$iv$iv;
                    T t = item$iv$iv = iterator2.next();
                    Collection collection = destination$iv$iv;
                    FqName fqName2 = ((JavaPackage)receiver).getFqName();
                    collection.add(fqName2);
                }
                return (List)var3_3;
            }
            {
                this.this$0 = lazyJavaPackageFragment;
                super(0);
            }
        };
        StorageManager storageManager = this.c.getStorageManager();
        LazyJavaPackageFragment lazyJavaPackageFragment = this;
        List list = CollectionsKt.emptyList();
        lazyJavaPackageFragment.subPackages = storageManager.createRecursionTolerantLazyValue(function0, list);
        this.partToFacade$delegate = this.c.getStorageManager().createLazyValue((Function0)new Function0<HashMap<String, String>>(this){
            final /* synthetic */ LazyJavaPackageFragment this$0;

            /*
             * WARNING - void declaration
             */
            @NotNull
            public final HashMap<String, String> invoke() {
                void var1_1;
                HashMap<K, V> result2 = new HashMap<K, V>();
                Map<String, KotlinJvmBinaryClass> map2 = this.this$0.getBinaryClasses$kotlin_core();
                Iterator<Map.Entry<String, KotlinJvmBinaryClass>> iterator2 = map2.entrySet().iterator();
                while (iterator2.hasNext()) {
                    Map.Entry<String, KotlinJvmBinaryClass> entry;
                    Map.Entry<String, KotlinJvmBinaryClass> entry2 = entry = iterator2.next();
                    String partName = entry2.getKey();
                    entry2 = entry;
                    KotlinJvmBinaryClass kotlinClass = entry2.getValue();
                    KotlinClassHeader header = kotlinClass.getClassHeader();
                    switch (LazyJavaPackageFragment$WhenMappings.$EnumSwitchMapping$0[header.getKind().ordinal()]) {
                        case 1: {
                            String facadeName;
                            if (header.getMultifileClassName() == null) {
                                break;
                            }
                            Object object = result2;
                            String string = StringsKt.substringAfterLast$default(facadeName, '/', null, 2, null);
                            object.put(partName, string);
                            break;
                        }
                        case 2: {
                            Map map3 = result2;
                            Object object = partName;
                            map3.put(partName, object);
                        }
                    }
                }
                return var1_1;
            }
            {
                this.this$0 = lazyJavaPackageFragment;
                super(0);
            }
        });
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LazyJavaPackageFragment.class), "binaryClasses", "getBinaryClasses$kotlin_core()Ljava/util/Map;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LazyJavaPackageFragment.class), "partToFacade", "getPartToFacade()Ljava/util/HashMap;"))};
    }

    @NotNull
    public static final /* synthetic */ LazyJavaResolverContext access$getC$p(LazyJavaPackageFragment $this) {
        return $this.c;
    }

    @NotNull
    public static final /* synthetic */ JavaPackage access$getJPackage$p(LazyJavaPackageFragment $this) {
        return $this.jPackage;
    }
}

