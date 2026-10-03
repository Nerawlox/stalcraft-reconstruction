/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractTypeConstructor
implements TypeConstructor {
    private final NotNullLazyValue<Supertypes> supertypes;

    @NotNull
    public List<KotlinType> getSupertypes() {
        return ((Supertypes)this.supertypes.invoke()).getSupertypesWithoutCycles();
    }

    /*
     * Enabled aggressive block sorting
     */
    private final Collection<KotlinType> computeNeighbours(@NotNull TypeConstructor $receiver) {
        Collection collection;
        List<KotlinType> list;
        TypeConstructor typeConstructor2 = $receiver;
        if (!(typeConstructor2 instanceof AbstractTypeConstructor)) {
            typeConstructor2 = null;
        }
        if ((list = (AbstractTypeConstructor)typeConstructor2) != null) {
            AbstractTypeConstructor abstractTypeConstructor;
            AbstractTypeConstructor abstractClassifierDescriptor = abstractTypeConstructor = list;
            list = CollectionsKt.plus(((Supertypes)abstractClassifierDescriptor.supertypes.invoke()).getAllSupertypes(), (Iterable)abstractClassifierDescriptor.getAdditionalNeighboursInSupertypeGraph());
            if (list != null) {
                collection = list;
                return collection;
            }
        }
        Collection collection2 = $receiver.getSupertypes();
        collection = collection2;
        Intrinsics.checkExpressionValueIsNotNull(collection2, "supertypes");
        return collection;
    }

    @NotNull
    protected abstract Collection<KotlinType> computeSupertypes();

    @NotNull
    protected abstract SupertypeLoopChecker getSupertypeLoopChecker();

    protected void reportSupertypeLoopError(@NotNull KotlinType type2) {
        Intrinsics.checkParameterIsNotNull(type2, "type");
    }

    @NotNull
    protected Collection<KotlinType> getAdditionalNeighboursInSupertypeGraph() {
        return CollectionsKt.emptyList();
    }

    @Nullable
    protected KotlinType defaultSupertypeIfEmpty() {
        return null;
    }

    public AbstractTypeConstructor(@NotNull StorageManager storageManager) {
        Intrinsics.checkParameterIsNotNull(storageManager, "storageManager");
        this.supertypes = storageManager.createLazyValueWithPostCompute((Function0)new Function0<Supertypes>(this){
            final /* synthetic */ AbstractTypeConstructor this$0;

            @NotNull
            public final Supertypes invoke() {
                return new Supertypes(this.this$0.computeSupertypes());
            }
            {
                this.this$0 = abstractTypeConstructor;
                super(0);
            }
        }, supertypes.2.INSTANCE, (Function1)new Function1<Supertypes, Unit>(this){
            final /* synthetic */ AbstractTypeConstructor this$0;

            public final void invoke(@NotNull Supertypes supertypes2) {
                List<T> list;
                Collection collection;
                Intrinsics.checkParameterIsNotNull(supertypes2, "supertypes");
                Collection resultWithoutCycles2 = this.this$0.getSupertypeLoopChecker().findLoopsInSupertypesAndDisconnect(this.this$0, supertypes2.getAllSupertypes(), (Function1<? super TypeConstructor, ? extends Iterable<? extends KotlinType>>)new Function1<TypeConstructor, Collection<? extends KotlinType>>(this){
                    final /* synthetic */ supertypes.3 this$0;

                    @NotNull
                    public final Collection<KotlinType> invoke(@NotNull TypeConstructor it) {
                        Intrinsics.checkParameterIsNotNull(it, "it");
                        return AbstractTypeConstructor.access$computeNeighbours(this.this$0.this$0, it);
                    }
                    {
                        this.this$0 = var1_1;
                        super(1);
                    }
                }, (Function1<? super KotlinType, Unit>)new Function1<KotlinType, Unit>(this){
                    final /* synthetic */ supertypes.3 this$0;

                    public final void invoke(@NotNull KotlinType it) {
                        Intrinsics.checkParameterIsNotNull(it, "it");
                        this.this$0.this$0.reportSupertypeLoopError(it);
                    }
                    {
                        this.this$0 = var1_1;
                        super(1);
                    }
                });
                if (resultWithoutCycles2.isEmpty()) {
                    Object object;
                    List<KotlinType> list2;
                    KotlinType kotlinType;
                    KotlinType kotlinType2 = this.this$0.defaultSupertypeIfEmpty();
                    if (kotlinType2 != null) {
                        KotlinType it = kotlinType = kotlinType2;
                        list2 = CollectionsKt.listOf(it);
                    } else {
                        list2 = null;
                    }
                    if ((object = (kotlinType = list2)) == null) {
                        object = CollectionsKt.emptyList();
                    }
                    resultWithoutCycles2 = (Collection)object;
                }
                if (!((collection = resultWithoutCycles2) instanceof List)) {
                    collection = null;
                }
                if ((list = (List<T>)collection) == null) {
                    list = CollectionsKt.toList(resultWithoutCycles2);
                }
                supertypes2.setSupertypesWithoutCycles((List<? extends KotlinType>)list);
            }
            {
                this.this$0 = abstractTypeConstructor;
                super(1);
            }
        });
    }

    @NotNull
    public static final /* synthetic */ Collection access$computeNeighbours(AbstractTypeConstructor $this, @NotNull TypeConstructor $receiver) {
        return $this.computeNeighbours($receiver);
    }

    private static final class Supertypes {
        @NotNull
        private List<? extends KotlinType> supertypesWithoutCycles;
        @NotNull
        private final Collection<KotlinType> allSupertypes;

        @NotNull
        public final List<KotlinType> getSupertypesWithoutCycles() {
            return this.supertypesWithoutCycles;
        }

        public final void setSupertypesWithoutCycles(@NotNull List<? extends KotlinType> list) {
            Intrinsics.checkParameterIsNotNull(list, "<set-?>");
            this.supertypesWithoutCycles = list;
        }

        @NotNull
        public final Collection<KotlinType> getAllSupertypes() {
            return this.allSupertypes;
        }

        public Supertypes(@NotNull Collection<? extends KotlinType> allSupertypes2) {
            Intrinsics.checkParameterIsNotNull(allSupertypes2, "allSupertypes");
            this.allSupertypes = allSupertypes2;
            this.supertypesWithoutCycles = CollectionsKt.listOf(ErrorUtils.ERROR_TYPE_FOR_LOOP_IN_SUPERTYPES);
        }
    }
}

