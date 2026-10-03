/*
 * Decompiled with CFR 0.152.
 */
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=2, d1={"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a9\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u0002H\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0006\u00a2\u0006\u0002\b\u0007H\u0086\b\u00a2\u0006\u0002\u0010\b\u00a8\u0006\t"}, d2={"profileSection", "", "T", "type", "", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "NetworkBase_main"})
public final class hrvs {
    public static final <T> void _a(T t, @NotNull String string, @NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(string, "type");
        Intrinsics.checkParameterIsNotNull(function1, "block");
        if (ugzk._a._a()) {
            ugzk._a._c().push(string);
            long l = System.nanoTime();
            function1.invoke(t);
            ugzk.kjui kjui2 = ugzk._a._a(string);
            kjui2._b(System.nanoTime() - l);
            ugzk._a._c().pop();
            kjui2._c();
        } else {
            function1.invoke(t);
        }
    }
}

