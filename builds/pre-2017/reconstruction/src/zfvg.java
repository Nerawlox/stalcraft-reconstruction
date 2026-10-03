/*
 * Decompiled with CFR 0.152.
 */
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bH\u0002J\u0006\u0010\u0010\u001a\u00020\rJ\u0012\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0016J\u0006\u0010\u0013\u001a\u00020\rJ\b\u0010\u0014\u001a\u00020\rH\u0016J\b\u0010\u0015\u001a\u00020\rH\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2={"Lgloomyfolken/mods/core/client/render/ThrowableAnimationHandler;", "Lgloomyfolken/mods/core/client/render/FirstPersonAnimationHandler;", "Lgloomyfolken/mods/weapon/client/render/RenderFpAnimatedItem;", "()V", "blockNewAnimations", "", "getBlockNewAnimations", "()Z", "setBlockNewAnimations", "(Z)V", "lastPlayedAnim", "", "onAnimEnded", "", "animName", "playAnim", "prepareThrowItem", "setContextOwner", "render", "throwItem", "tick", "updatePlayingAnimation", "Companion", "minecraft"})
public final class zfvg
extends ctve<ejwe> {
    private boolean _g;
    private String _h;
    public static final kjui _f = new kjui(null);

    public final boolean _f() {
        return this._g;
    }

    public final void _a(boolean bl) {
        this._g = bl;
    }

    @Override
    public void _a() {
        if (this._c()) {
            return;
        }
        this._c._b();
        this._b();
    }

    @Override
    protected void _b() {
        boolean bl = false;
        Iterator<uhrn> iterator2 = this._c._a(ctve._d).iterator();
        while (iterator2.hasNext()) {
            uhrn uhrn2;
            uhrn uhrn3 = uhrn2 = iterator2.next();
            if (uhrn3 == null) {
                throw new TypeCastException("null cannot be cast to non-null type gloomyfolken.mods.effects.common.mcsa.animation.AnimationEntryClip");
            }
            jytp jytp2 = (jytp)uhrn3;
            bl |= jytp2._a();
        }
        if (!bl || Intrinsics.areEqual(this._h, "")) {
            this._c(this._h);
        }
    }

    private final void _b(String string) {
        boolean bl = Intrinsics.areEqual(string, "throw_released");
        this._a(string, false, true, bl);
        this._h = string;
        this._e = 1.0f;
    }

    private final void _c(String string) {
        if (Intrinsics.areEqual(string, "throw")) {
            this._b("throw_released");
        } else if (!this._g) {
            this._e = 5.0f;
            this._b("idle");
        }
    }

    @Override
    public boolean _a(@Nullable ejwe ejwe2) {
        if (Intrinsics.areEqual(this._a, ejwe2) ^ true) {
            this._g = false;
        }
        return super._a((hbcv)ejwe2);
    }

    public final void _g() {
        this._g = true;
        this._b("throw_prepare");
    }

    public final void _h() {
        this._g = false;
        this._b("throw");
    }

    public zfvg() {
        this._e = 1.0f;
        this._h = "";
    }

    @JvmStatic
    @NotNull
    public static final zfvg _i() {
        return _f._a();
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007\u00a8\u0006\u0005"}, d2={"Lgloomyfolken/mods/core/client/render/ThrowableAnimationHandler$Companion;", "", "()V", "getHandler", "Lgloomyfolken/mods/core/client/render/ThrowableAnimationHandler;", "minecraft"})
    public static final class kjui {
        @JvmStatic
        @NotNull
        public final zfvg _a() {
            zfvg zfvg2 = sbzn._n;
            Intrinsics.checkExpressionValueIsNotNull(zfvg2, "WeaponGameHandler.throwableAnimationHandler");
            return zfvg2;
        }

        private kjui() {
        }

        public /* synthetic */ kjui(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

