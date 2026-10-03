/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal;

import java.lang.reflect.Field;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty2;
import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0006\b\u0002\u0010\u0003 \u00012\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\b\u0012\u0004\u0012\u0002H\u00030\u0005:\u0001!B\u001f\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0002\u0010\u000bB\u0017\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eJ\u001d\u0010\u001a\u001a\u00028\u00022\u0006\u0010\u001b\u001a\u00028\u00002\u0006\u0010\u001c\u001a\u00028\u0001H\u0016\u00a2\u0006\u0002\u0010\u001dJ\u001f\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u001b\u001a\u00028\u00002\u0006\u0010\u001c\u001a\u00028\u0001H\u0016\u00a2\u0006\u0002\u0010\u001dJ\u001e\u0010 \u001a\u00028\u00022\u0006\u0010\u001b\u001a\u00028\u00002\u0006\u0010\u001c\u001a\u00028\u0001H\u0096\u0002\u00a2\u0006\u0002\u0010\u001dR\u0016\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R&\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00138VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015RE\u0010\u0016\u001a9\u00120\u0012.\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002 \u0018*\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u00130\u00130\u0017\u00a2\u0006\u0002\b\u0019X\u0088\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2={"Lkotlin/reflect/jvm/internal/KProperty2Impl;", "D", "E", "R", "Lkotlin/reflect/KProperty2;", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "name", "", "signature", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;)V", "descriptor", "Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "delegateField", "Lkotlin/Lazy;", "Ljava/lang/reflect/Field;", "getter", "Lkotlin/reflect/jvm/internal/KProperty2Impl$Getter;", "getGetter", "()Lkotlin/reflect/jvm/internal/KProperty2Impl$Getter;", "getter_", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "kotlin.jvm.PlatformType", "Lorg/jetbrains/annotations/NotNull;", "get", "receiver1", "receiver2", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "getDelegate", "", "invoke", "Getter", "kotlin-reflection"})
public class KProperty2Impl<D, E, R>
extends KPropertyImpl<R>
implements KProperty2<D, E, R> {
    private final ReflectProperties.LazyVal<Getter<D, E, R>> getter_;
    private final Lazy<Field> delegateField;

    @Override
    @NotNull
    public Getter<D, E, R> getGetter() {
        Getter<D, E, R> getter = this.getter_.invoke();
        Intrinsics.checkExpressionValueIsNotNull(getter, "getter_()");
        return getter;
    }

    @Override
    public R get(D receiver1, E receiver2) {
        return ((KCallableImpl)((Object)this.getGetter())).call(receiver1, receiver2);
    }

    @Override
    @Nullable
    public Object getDelegate(D receiver1, E receiver2) {
        return this.getDelegate((D)this.delegateField.getValue(), (E)receiver1);
    }

    @Override
    public R invoke(D receiver1, E receiver2) {
        return this.get(receiver1, receiver2);
    }

    public KProperty2Impl(@NotNull KDeclarationContainerImpl container, @NotNull String name2, @NotNull String signature2) {
        Intrinsics.checkParameterIsNotNull(container, "container");
        Intrinsics.checkParameterIsNotNull(name2, "name");
        Intrinsics.checkParameterIsNotNull(signature2, "signature");
        super(container, name2, signature2, CallableReference.NO_RECEIVER);
        this.getter_ = ReflectProperties.lazy(new Function0<Getter<D, E, ? extends R>>(this){
            final /* synthetic */ KProperty2Impl this$0;

            @NotNull
            public final Getter<D, E, R> invoke() {
                return new Getter<D, E, R>(this.this$0);
            }
            {
                this.this$0 = kProperty2Impl;
                super(0);
            }
        });
        this.delegateField = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0)new Function0<Field>(this){
            final /* synthetic */ KProperty2Impl this$0;

            @Nullable
            public final Field invoke() {
                return this.this$0.computeDelegateField();
            }
            {
                this.this$0 = kProperty2Impl;
                super(0);
            }
        });
    }

    public KProperty2Impl(@NotNull KDeclarationContainerImpl container, @NotNull PropertyDescriptor descriptor2) {
        Intrinsics.checkParameterIsNotNull(container, "container");
        Intrinsics.checkParameterIsNotNull(descriptor2, "descriptor");
        super(container, descriptor2);
        this.getter_ = ReflectProperties.lazy(new /* invalid duplicate definition of identical inner class */);
        this.delegateField = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0)new /* invalid duplicate definition of identical inner class */);
    }

    @Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\u0004\b\u0003\u0010\u0001*\u0004\b\u0004\u0010\u0002*\u0006\b\u0005\u0010\u0003 \u00012\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0005B\u001f\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u0007\u00a2\u0006\u0002\u0010\bJ\u001e\u0010\u000b\u001a\u00028\u00052\u0006\u0010\f\u001a\u00028\u00032\u0006\u0010\r\u001a\u00028\u0004H\u0096\u0002\u00a2\u0006\u0002\u0010\u000eR&\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000f"}, d2={"Lkotlin/reflect/jvm/internal/KProperty2Impl$Getter;", "D", "E", "R", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "Lkotlin/reflect/KProperty2$Getter;", "property", "Lkotlin/reflect/jvm/internal/KProperty2Impl;", "(Lkotlin/reflect/jvm/internal/KProperty2Impl;)V", "getProperty", "()Lkotlin/reflect/jvm/internal/KProperty2Impl;", "invoke", "receiver1", "receiver2", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
    public static final class Getter<D, E, R>
    extends KPropertyImpl.Getter<R>
    implements KProperty2.Getter<D, E, R> {
        @NotNull
        private final KProperty2Impl<D, E, R> property;

        @Override
        public R invoke(D receiver1, E receiver2) {
            return ((KProperty2Impl)this.getProperty()).get(receiver1, receiver2);
        }

        @NotNull
        public KProperty2Impl<D, E, R> getProperty() {
            return this.property;
        }

        public Getter(@NotNull KProperty2Impl<D, E, ? extends R> property) {
            Intrinsics.checkParameterIsNotNull(property, "property");
            this.property = property;
        }
    }
}

