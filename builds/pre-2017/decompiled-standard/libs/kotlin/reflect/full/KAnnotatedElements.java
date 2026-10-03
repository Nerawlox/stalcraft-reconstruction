/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.full;

import java.lang.annotation.Annotation;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KAnnotatedElement;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=2, d1={"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0010\u001b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u0003H\u0087\b\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2={"findAnnotation", "T", "", "Lkotlin/reflect/KAnnotatedElement;", "(Lkotlin/reflect/KAnnotatedElement;)Ljava/lang/annotation/Annotation;", "kotlin-reflection"})
@JvmName(name="KAnnotatedElements")
public final class KAnnotatedElements {
    @SinceKotlin(version="1.1")
    private static final <T extends Annotation> T findAnnotation(@NotNull KAnnotatedElement $receiver) {
        Object v0;
        block1: {
            Iterable $receiver$iv = $receiver.getAnnotations();
            for (Object element$iv : $receiver$iv) {
                Annotation it = (Annotation)element$iv;
                Intrinsics.reifiedOperationMarker(3, "T");
                if (!(it instanceof Annotation)) continue;
                v0 = element$iv;
                break block1;
            }
            v0 = null;
        }
        Intrinsics.reifiedOperationMarker(1, "T?");
        return (T)((Annotation)v0);
    }
}

