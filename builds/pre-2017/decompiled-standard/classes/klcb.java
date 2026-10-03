/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.misc.ezey;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.util.jxtc;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001cB?\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u00a2\u0006\u0002\u0010\u000bR\u001d\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001b\u00a8\u0006\u001d"}, d2={"Lgloomyfolken/mods/stalker/misc/sickness/SicknessType;", "", "stringId", "", "damageSource", "Lnet/minecraft/util/DamageSource;", "protection", "Lkotlin/Function1;", "Lgloomyfolken/mods/stalker/misc/item/ArtefaktProperties;", "", "accumulation", "(Ljava/lang/String;ILjava/lang/String;Lnet/minecraft/util/DamageSource;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getAccumulation", "()Lkotlin/jvm/functions/Function1;", "getDamageSource", "()Lnet/minecraft/util/DamageSource;", "props", "Lgloomyfolken/mods/stalker/misc/sickness/Sickness$Props;", "getProps", "()Lgloomyfolken/mods/stalker/misc/sickness/Sickness$Props;", "getProtection", "getStringId", "()Ljava/lang/String;", "RADIATION", "THERMAL", "BIOLOGICAL", "PSYCHO", "BLEEDING", "Companion", "minecraft"})
public final class klcb
extends Enum<klcb> {
    public static final /* enum */ klcb _a;
    public static final /* enum */ klcb _b;
    public static final /* enum */ klcb _c;
    public static final /* enum */ klcb _d;
    public static final /* enum */ klcb _e;
    private static final /* synthetic */ klcb[] $VALUES;
    @NotNull
    private final ejqm.kjui _g;
    @NotNull
    private final String _h;
    @NotNull
    private final jxtc _i;
    @NotNull
    private final Function1<xafi, Float> _j;
    @NotNull
    private final Function1<xafi, Float> _k;
    @NotNull
    private static final klcb[] _l;
    public static final kjui _f;

    static {
        klcb[] klcbArray = new klcb[5];
        klcb[] klcbArray2 = klcbArray;
        jxtc jxtc2 = ezey._l;
        Intrinsics.checkExpressionValueIsNotNull(jxtc2, "radiation");
        klcbArray[0] = _a = new klcb("rad", jxtc2, 1._a, 3._a);
        jxtc jxtc3 = ezey._p;
        Intrinsics.checkExpressionValueIsNotNull(jxtc3, "thermal");
        klcbArray[1] = _b = new klcb("thr", jxtc3, 4._a, 5._a);
        jxtc jxtc4 = ezey._m;
        Intrinsics.checkExpressionValueIsNotNull(jxtc4, "biological");
        klcbArray[2] = _c = new klcb("bio", jxtc4, 6._a, 7._a);
        jxtc jxtc5 = ezey._n;
        Intrinsics.checkExpressionValueIsNotNull(jxtc5, "psycho");
        klcbArray[3] = _d = new klcb("psy", jxtc5, 8._a, 9._a);
        jxtc jxtc6 = ezey._o;
        Intrinsics.checkExpressionValueIsNotNull(jxtc6, "bleeding");
        klcbArray[4] = _e = new klcb("bld", jxtc6, 10._a, 2._a);
        $VALUES = klcbArray;
        _f = new kjui(null);
        _l = klcb.values();
    }

    @NotNull
    public final ejqm.kjui _a() {
        return this._g;
    }

    @NotNull
    public final String _b() {
        return this._h;
    }

    @NotNull
    public final jxtc _c() {
        return this._i;
    }

    @NotNull
    public final Function1<xafi, Float> _d() {
        return this._j;
    }

    @NotNull
    public final Function1<xafi, Float> _e() {
        return this._k;
    }

    protected klcb(@NotNull String string2, @NotNull jxtc jxtc2, @NotNull Function1<? super xafi, Float> function1, @NotNull Function1<? super xafi, Float> function12) {
        Intrinsics.checkParameterIsNotNull(string2, "stringId");
        Intrinsics.checkParameterIsNotNull(jxtc2, "damageSource");
        Intrinsics.checkParameterIsNotNull(function1, "protection");
        Intrinsics.checkParameterIsNotNull(function12, "accumulation");
        this._h = string2;
        this._i = jxtc2;
        this._j = function1;
        this._k = function12;
        this._g = rpws._a._c(this._h);
    }

    public static klcb[] values() {
        return (klcb[])$VALUES.clone();
    }

    public static klcb valueOf(String string) {
        return Enum.valueOf(klcb.class, string);
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bR\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\f"}, d2={"Lgloomyfolken/mods/stalker/misc/sickness/SicknessType$Companion;", "", "()V", "types", "", "Lgloomyfolken/mods/stalker/misc/sickness/SicknessType;", "getTypes", "()[Lgloomyfolken/mods/stalker/misc/sickness/SicknessType;", "[Lgloomyfolken/mods/stalker/misc/sickness/SicknessType;", "get", "stringId", "", "minecraft"})
    public static final class kjui {
        @NotNull
        public final klcb[] _a() {
            return _l;
        }

        @NotNull
        public final klcb _a(@NotNull String string) {
            Object object;
            block2: {
                Object[] objectArray;
                Intrinsics.checkParameterIsNotNull(string, "stringId");
                Object[] objectArray2 = objectArray = (Object[])this._a();
                for (int i = 0; i < objectArray2.length; ++i) {
                    Object object2 = objectArray2[i];
                    klcb klcb2 = (klcb)((Object)object2);
                    if (!Intrinsics.areEqual(klcb2._b(), string)) continue;
                    object = object2;
                    break block2;
                }
                object = null;
            }
            klcb klcb3 = (klcb)((Object)object);
            if (klcb3 == null) {
                throw (Throwable)new IllegalArgumentException();
            }
            return klcb3;
        }

        private kjui() {
        }

        public /* synthetic */ kjui(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

