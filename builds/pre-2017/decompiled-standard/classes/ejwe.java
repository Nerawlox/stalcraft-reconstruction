/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.misc.ugqx;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraftforge.client.IItemRenderer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\u00070\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00000\u0007H\u0016J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J$\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0014R\u001e\u0010\u000b\u001a\u0012 \u000e*\b\u0018\u00010\fR\u00020\r0\fR\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001d"}, d2={"Lgloomyfolken/mods/weapon/client/render/RenderFpAnimatedItem;", "Lgloomyfolken/mods/core/client/render/IFirstPersonRenderer;", "Lgloomyfolken/mods/core/client/render/RenderSimpleCustomItem;", "weapon", "Lgloomyfolken/mods/core/misc/IAnimatedItem;", "fpAnimationHandlerSupplier", "Lkotlin/Function0;", "Lgloomyfolken/mods/core/client/render/FirstPersonAnimationHandler;", "modelDir", "", "(Lgloomyfolken/mods/core/misc/IAnimatedItem;Lkotlin/jvm/functions/Function0;Ljava/lang/String;)V", "cachedFpMeshSelector", "Lgloomyfolken/mods/core/client/render/RenderAbstractCustomItem$CachedMeshSelector;", "Lgloomyfolken/mods/core/client/render/RenderAbstractCustomItem;", "kotlin.jvm.PlatformType", "getFpAnimationHandlerSupplier", "()Lkotlin/jvm/functions/Function0;", "getAnimationHandler", "getFirstPersonFOV", "", "item", "Lnet/minecraft/item/ItemStack;", "renderModel", "", "stack", "stateGenerator", "Lgloomyfolken/mods/effects/common/mcsa/animation/ISkeletonStateGenerator;", "renderType", "Lnet/minecraftforge/client/IItemRenderer$ItemRenderType;", "minecraft"})
public final class ejwe
extends anoq
implements ycss {
    private final hbcv.kjui _q;
    @NotNull
    private final Function0<ctve<ejwe>> _r;

    @NotNull
    public ctve<ejwe> _a() {
        return this._r.invoke();
    }

    @Override
    protected float _b(@Nullable cvzo cvzo2) {
        cvzo cvzo3 = cvzo2;
        tgdv tgdv2 = cvzo3 != null ? cvzo3._a() : null;
        if (!(tgdv2 instanceof ugqx)) {
            tgdv2 = null;
        }
        ugqx ugqx2 = (ugqx)((Object)tgdv2);
        return ugqx2 != null ? ugqx2._f() : 40.0f;
    }

    @Override
    protected void _a(@Nullable cvzo cvzo2, @Nullable cucv cucv2, @NotNull IItemRenderer.ItemRenderType itemRenderType) {
        Intrinsics.checkParameterIsNotNull((Object)itemRenderType, "renderType");
        gloomyfolken.mods.effects.client.mcsa.kjui kjui2 = this._e(cvzo2);
        if (kjui2 == null) {
            return;
        }
        gloomyfolken.mods.effects.client.mcsa.kjui kjui3 = kjui2;
        if (!kjui3._i()) {
            return;
        }
        zxbe zxbe2 = null;
        switch (ifbt._a[itemRenderType.ordinal()]) {
            case 1: {
                this._r.invoke()._a((ejwe)((hbcv)this));
                zxbe zxbe3 = this._r.invoke()._e();
                if (zxbe3 == null) {
                    return;
                }
                zxbe2 = zxbe3;
                ivhj._a._a(zxbe2, kjui3._a().getSkeleton());
            }
        }
        zxbe zxbe4 = zxbe2;
        this._q._a(zxbe4 != null ? (cucv)zxbe4 : cucv2, kjui3);
    }

    @NotNull
    public final Function0<ctve<ejwe>> _c() {
        return this._r;
    }

    public ejwe(@NotNull ugqx ugqx2, @NotNull Function0<? extends ctve<ejwe>> function0, @NotNull String string) {
        Intrinsics.checkParameterIsNotNull(ugqx2, "weapon");
        Intrinsics.checkParameterIsNotNull(function0, "fpAnimationHandlerSupplier");
        Intrinsics.checkParameterIsNotNull(string, "modelDir");
        super("/assets/" + string, ugqx2._a(), ugqx2._b(), new anpy(uyvo._a(ugqx2._c())), ugqx2._d(), true, ugqx2._e());
        this._r = function0;
        this._q = this._a(kjui._a);
    }

    public /* synthetic */ ejwe(ugqx ugqx2, Function0 function0, String string, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 4) != 0) {
            string = "";
        }
        this(ugqx2, function0, string);
    }
}

