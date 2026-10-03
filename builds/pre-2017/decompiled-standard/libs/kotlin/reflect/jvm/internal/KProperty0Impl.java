/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty0;
import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0010\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u001dB\u0017\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bB)\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0002\u0010\u000eJ\r\u0010\u0019\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u001aJ\n\u0010\u001b\u001a\u0004\u0018\u00010\rH\u0016J\u000e\u0010\u001c\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0002\u0010\u001aR\u0016\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00128VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R-\u0010\u0015\u001a!\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00028\u0000 \u0017*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00120\u00120\u0016\u00a2\u0006\u0002\b\u0018X\u0088\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2={"Lkotlin/reflect/jvm/internal/KProperty0Impl;", "R", "Lkotlin/reflect/KProperty0;", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "descriptor", "Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "name", "", "signature", "boundReceiver", "", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "delegateFieldValue", "Lkotlin/Lazy;", "getter", "Lkotlin/reflect/jvm/internal/KProperty0Impl$Getter;", "getGetter", "()Lkotlin/reflect/jvm/internal/KProperty0Impl$Getter;", "getter_", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "kotlin.jvm.PlatformType", "Lorg/jetbrains/annotations/NotNull;", "get", "()Ljava/lang/Object;", "getDelegate", "invoke", "Getter", "kotlin-reflection"})
public class KProperty0Impl<R>
extends KPropertyImpl<R>
implements KProperty0<R> {
    private final ReflectProperties.LazyVal<Getter<R>> getter_;
    private final Lazy<Object> delegateFieldValue;

    @Override
    @NotNull
    public Getter<R> getGetter() {
        Getter<R> getter = this.getter_.invoke();
        Intrinsics.checkExpressionValueIsNotNull(getter, "getter_()");
        return getter;
    }

    @Override
    public R get() {
        return ((KCallableImpl)((Object)this.getGetter())).call(new Object[0]);
    }

    @Override
    @Nullable
    public Object getDelegate() {
        return this.delegateFieldValue.getValue();
    }

    @Override
    public R invoke() {
        return this.get();
    }

    public KProperty0Impl(@NotNull KDeclarationContainerImpl container, @NotNull PropertyDescriptor descriptor2) {
        Intrinsics.checkParameterIsNotNull(container, "container");
        Intrinsics.checkParameterIsNotNull(descriptor2, "descriptor");
        super(container, descriptor2);
        this.getter_ = ReflectProperties.lazy(new Function0<Getter<? extends R>>(this){
            final /* synthetic */ KProperty0Impl this$0;

            @NotNull
            public final Getter<R> invoke() {
                return new Getter<R>(this.this$0);
            }
            {
                this.this$0 = kProperty0Impl;
                super(0);
            }
        });
        this.delegateFieldValue = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0)new Function0<Object>(this){
            final /* synthetic */ KProperty0Impl this$0;

            @Nullable
            public final Object invoke() {
                return this.this$0.getDelegate(this.this$0.computeDelegateField(), this.this$0.getBoundReceiver());
            }
            {
                this.this$0 = kProperty0Impl;
                super(0);
            }
        });
    }

    public KProperty0Impl(@NotNull KDeclarationContainerImpl container, @NotNull String name2, @NotNull String signature2, @Nullable Object boundReceiver) {
        Intrinsics.checkParameterIsNotNull(container, "container");
        Intrinsics.checkParameterIsNotNull(name2, "name");
        Intrinsics.checkParameterIsNotNull(signature2, "signature");
        super(container, name2, signature2, boundReceiver);
        this.getter_ = ReflectProperties.lazy(new /* invalid duplicate definition of identical inner class */);
        this.delegateFieldValue = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0)new /* invalid duplicate definition of identical inner class */);
    }

    @Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\t\u001a\u00028\u0001H\u0096\u0002\u00a2\u0006\u0002\u0010\nR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2={"Lkotlin/reflect/jvm/internal/KProperty0Impl$Getter;", "R", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "Lkotlin/reflect/KProperty0$Getter;", "property", "Lkotlin/reflect/jvm/internal/KProperty0Impl;", "(Lkotlin/reflect/jvm/internal/KProperty0Impl;)V", "getProperty", "()Lkotlin/reflect/jvm/internal/KProperty0Impl;", "invoke", "()Ljava/lang/Object;", "kotlin-reflection"})
    public static final class Getter<R>
    extends KPropertyImpl.Getter<R>
    implements KProperty0.Getter<R> {
        @NotNull
        private final KProperty0Impl<R> property;

        @Override
        public R invoke() {
            return ((KProperty0Impl)this.getProperty()).get();
        }

        @Override
        @NotNull
        public KProperty0Impl<R> getProperty() {
            return this.property;
        }

        public Getter(@NotNull KProperty0Impl<? extends R> property) {
            Intrinsics.checkParameterIsNotNull(property, "property");
            this.property = property;
        }
    }
}

