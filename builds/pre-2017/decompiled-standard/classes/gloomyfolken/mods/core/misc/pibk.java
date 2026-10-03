/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.misc;

import gloomyfolken.mods.core.misc.ugqx;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005B\u000f\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010!\u001a\u00020\nH\u0016J\b\u0010\"\u001a\u00020\u0010H\u0016J\b\u0010#\u001a\u00020\u0003H\u0016J\n\u0010$\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010%\u001a\u00020\u0003H\u0016J\b\u0010&\u001a\u00020\nH\u0016J\u000e\u0010'\u001a\u00020(2\u0006\u0010\u0006\u001a\u00020\u0007R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0019\"\u0004\b \u0010\u001b\u00a8\u0006)"}, d2={"Lgloomyfolken/mods/core/misc/ItemFpSettings;", "Lgloomyfolken/mods/core/misc/IAnimatedItem;", "_renderModelName", "", "_renderConfigName", "(Ljava/lang/String;Ljava/lang/String;)V", "item", "Lgloomyfolken/mods/core/configuration/ItemToAdd;", "(Lgloomyfolken/mods/core/configuration/ItemToAdd;)V", "_animateOnGround", "", "get_animateOnGround", "()Z", "set_animateOnGround", "(Z)V", "_fov", "", "get_fov", "()F", "set_fov", "(F)V", "_hasDistortions", "get_hasDistortions", "set_hasDistortions", "get_renderConfigName", "()Ljava/lang/String;", "set_renderConfigName", "(Ljava/lang/String;)V", "_renderMaterialName", "get_renderMaterialName", "set_renderMaterialName", "get_renderModelName", "set_renderModelName", "animateOnGround", "getFov", "getRenderConfigName", "getRenderMaterialName", "getRenderModelName", "hasDistortions", "setup", "", "minecraft"})
public final class pibk
implements ugqx {
    @NotNull
    private String _a;
    @NotNull
    private String _b;
    @Nullable
    private String _c;
    private boolean _d;
    private boolean _e;
    private float _f;

    @NotNull
    public final String _g() {
        return this._a;
    }

    public final void _a(@NotNull String string) {
        Intrinsics.checkParameterIsNotNull(string, "<set-?>");
        this._a = string;
    }

    @NotNull
    public final String _h() {
        return this._b;
    }

    public final void _b(@NotNull String string) {
        Intrinsics.checkParameterIsNotNull(string, "<set-?>");
        this._b = string;
    }

    @Nullable
    public final String _i() {
        return this._c;
    }

    public final void _c(@Nullable String string) {
        this._c = string;
    }

    public final boolean _j() {
        return this._d;
    }

    public final void _a(boolean bl) {
        this._d = bl;
    }

    public final boolean _k() {
        return this._e;
    }

    public final void _b(boolean bl) {
        this._e = bl;
    }

    public final float _l() {
        return this._f;
    }

    public final void _a(float f) {
        this._f = f;
    }

    public final void _a(@NotNull rpaa rpaa2) {
        Intrinsics.checkParameterIsNotNull(rpaa2, "item");
        this._f = rpaa2._a("fov", 40.0f);
        this._e = rpaa2._a("has_distortions", false);
        this._d = rpaa2._a("animate_on_ground", true);
        this._c = rpaa2._a("material", (String)null);
    }

    @Override
    @NotNull
    public String _a() {
        return this._a;
    }

    @Override
    @NotNull
    public String _c() {
        return this._b;
    }

    @Override
    @Nullable
    public String _b() {
        return this._c;
    }

    @Override
    public boolean _d() {
        return this._d;
    }

    @Override
    public boolean _e() {
        return this._e;
    }

    @Override
    public float _f() {
        return this._f;
    }

    public pibk(@NotNull String string, @NotNull String string2) {
        Intrinsics.checkParameterIsNotNull(string, "_renderModelName");
        Intrinsics.checkParameterIsNotNull(string2, "_renderConfigName");
        this._f = 40.0f;
        this._a = string;
        this._b = string2;
    }

    public pibk(@NotNull rpaa rpaa2) {
        Intrinsics.checkParameterIsNotNull(rpaa2, "item");
        this._f = 40.0f;
        String string = rpaa2._h("model");
        Intrinsics.checkExpressionValueIsNotNull(string, "item.getString(\"model\")");
        this._a = string;
        String string2 = rpaa2._h("anim_name");
        Intrinsics.checkExpressionValueIsNotNull(string2, "item.getString(\"anim_name\")");
        this._b = string2;
        this._a(rpaa2);
    }
}

