/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.full;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KCallable;
import kotlin.reflect.KParameter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=2, d1={"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\u001a\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u0001*\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0010\u001a\u00020\u0011H\u0007\"$\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"$\u0010\u0007\u001a\u0004\u0018\u00010\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006\"(\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2={"extensionReceiverParameter", "Lkotlin/reflect/KParameter;", "Lkotlin/reflect/KCallable;", "extensionReceiverParameter$annotations", "(Lkotlin/reflect/KCallable;)V", "getExtensionReceiverParameter", "(Lkotlin/reflect/KCallable;)Lkotlin/reflect/KParameter;", "instanceParameter", "instanceParameter$annotations", "getInstanceParameter", "valueParameters", "", "valueParameters$annotations", "getValueParameters", "(Lkotlin/reflect/KCallable;)Ljava/util/List;", "findParameterByName", "name", "", "kotlin-reflection"})
@JvmName(name="KCallables")
public final class KCallables {
    @SinceKotlin(version="1.1")
    private static /* synthetic */ void instanceParameter$annotations(KCallable kCallable) {
    }

    /*
     * WARNING - void declaration
     */
    @Nullable
    public static final KParameter getInstanceParameter(@NotNull KCallable<?> $receiver) {
        Object object;
        block2: {
            void var2_2;
            Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
            Iterable $receiver$iv = $receiver.getParameters();
            Object single$iv = null;
            boolean found$iv = false;
            for (Object element$iv : $receiver$iv) {
                KParameter it = (KParameter)element$iv;
                if (!Intrinsics.areEqual((Object)it.getKind(), (Object)KParameter.Kind.INSTANCE)) continue;
                if (found$iv) {
                    object = null;
                    break block2;
                }
                single$iv = element$iv;
                found$iv = true;
            }
            object = !found$iv ? null : var2_2;
        }
        return (KParameter)object;
    }

    @SinceKotlin(version="1.1")
    private static /* synthetic */ void extensionReceiverParameter$annotations(KCallable kCallable) {
    }

    /*
     * WARNING - void declaration
     */
    @Nullable
    public static final KParameter getExtensionReceiverParameter(@NotNull KCallable<?> $receiver) {
        Object object;
        block2: {
            void var2_2;
            Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
            Iterable $receiver$iv = $receiver.getParameters();
            Object single$iv = null;
            boolean found$iv = false;
            for (Object element$iv : $receiver$iv) {
                KParameter it = (KParameter)element$iv;
                if (!Intrinsics.areEqual((Object)it.getKind(), (Object)KParameter.Kind.EXTENSION_RECEIVER)) continue;
                if (found$iv) {
                    object = null;
                    break block2;
                }
                single$iv = element$iv;
                found$iv = true;
            }
            object = !found$iv ? null : var2_2;
        }
        return (KParameter)object;
    }

    @SinceKotlin(version="1.1")
    private static /* synthetic */ void valueParameters$annotations(KCallable kCallable) {
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final List<KParameter> getValueParameters(@NotNull KCallable<?> $receiver) {
        void var3_3;
        void $receiver$iv$iv;
        Iterable $receiver$iv;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Iterable iterable = $receiver$iv = (Iterable)$receiver.getParameters();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $receiver$iv$iv) {
            KParameter it = (KParameter)element$iv$iv;
            if (!Intrinsics.areEqual((Object)it.getKind(), (Object)KParameter.Kind.VALUE)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        return (List)var3_3;
    }

    /*
     * WARNING - void declaration
     */
    @SinceKotlin(version="1.1")
    @Nullable
    public static final KParameter findParameterByName(@NotNull KCallable<?> $receiver, @NotNull String name2) {
        Object object;
        block2: {
            void var3_3;
            Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
            Intrinsics.checkParameterIsNotNull(name2, "name");
            Iterable $receiver$iv = $receiver.getParameters();
            Object single$iv = null;
            boolean found$iv = false;
            for (Object element$iv : $receiver$iv) {
                KParameter it = (KParameter)element$iv;
                if (!Intrinsics.areEqual(it.getName(), name2)) continue;
                if (found$iv) {
                    object = null;
                    break block2;
                }
                single$iv = element$iv;
                found$iv = true;
            }
            object = !found$iv ? null : var3_3;
        }
        return (KParameter)object;
    }
}

