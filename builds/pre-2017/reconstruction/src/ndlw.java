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

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000eB\u0005\u00a2\u0006\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0012\u0010\u000b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\r\u001a\u00020\bH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0002X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2={"Lgloomyfolken/mods/weapon/client/MeleeWeaponAnimationHandler;", "Lgloomyfolken/mods/core/client/render/FirstPersonAnimationHandler;", "Lgloomyfolken/mods/weapon/client/render/RenderFpAnimatedItem;", "()V", "drawPlayed", "", "prevContextOwner", "executeAttackAnimation", "", "actionType", "", "setContextOwner", "render", "updatePlayingAnimation", "Companion", "minecraft"})
public final class ndlw
extends ctve<ejwe> {
    private boolean _g;
    private ejwe _h;
    public static final kjui _f = new kjui(null);

    @Override
    protected void _b() {
        boolean bl = false;
        Iterator<uhrn> iterator2 = this._c._a(ndlw._f()).iterator();
        while (iterator2.hasNext()) {
            uhrn uhrn2;
            uhrn uhrn3 = uhrn2 = iterator2.next();
            if (uhrn3 == null) {
                throw new TypeCastException("null cannot be cast to non-null type gloomyfolken.mods.effects.common.mcsa.animation.AnimationEntryClip");
            }
            jytp jytp2 = (jytp)uhrn3;
            bl |= jytp2._a();
        }
        if (!bl) {
            if (!this._g) {
                this._g = true;
                this._a("draw", false, true, false);
            } else {
                this._a("idle", false, true, false);
            }
        }
    }

    @Override
    public boolean _a(@Nullable ejwe ejwe2) {
        if (Intrinsics.areEqual(this._h, ejwe2) ^ true) {
            this._g = false;
        }
        this._h = ejwe2;
        return super._a((hbcv)ejwe2);
    }

    public final void _a(int n) {
        String string = n == 1 ? "pkm_hit" : "lkm_hit";
        this._a(string, false, true, false);
    }

    public ndlw() {
        this._e = 1.0f;
    }

    public static final /* synthetic */ nuco _f() {
        return ctve._d;
    }

    public static final /* synthetic */ void _a(nuco nuco2) {
        ctve._d = nuco2;
    }

    @JvmStatic
    @NotNull
    public static final ndlw _g() {
        return _f._a();
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007\u00a8\u0006\u0005"}, d2={"Lgloomyfolken/mods/weapon/client/MeleeWeaponAnimationHandler$Companion;", "", "()V", "getHandler", "Lgloomyfolken/mods/weapon/client/MeleeWeaponAnimationHandler;", "minecraft"})
    public static final class kjui {
        @JvmStatic
        @NotNull
        public final ndlw _a() {
            ndlw ndlw2 = sbzn._m;
            Intrinsics.checkExpressionValueIsNotNull(ndlw2, "WeaponGameHandler.meleeWeaponAnimationHandler");
            return ndlw2;
        }

        private kjui() {
        }

        public /* synthetic */ kjui(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

