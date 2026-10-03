/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.client.render;

import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\b"}, d2={"Lgloomyfolken/mods/stalker/mobs/client/render/MutantsIconList;", "Lgloomyfolken/mods/effects/client/texture/IIconList;", "()V", "registerIcons", "", "ir", "Lnet/minecraft/client/renderer/texture/IconRegister;", "Companion", "minecraft"})
public final class MutantsIconList
implements rplk {
    @NotNull
    public static ejcz funnelDistortionIcon;
    @NotNull
    public static ejcz funnelEyeIcon;
    @NotNull
    public static ejcz roflanEbaloIcon;
    public static final Companion Companion;

    @Override
    public void registerIcons(@NotNull IconRegister iconRegister) {
        Intrinsics.checkParameterIsNotNull(iconRegister, "ir");
        Icon icon = iconRegister._b("stalkermobs:funnel_eye");
        if (icon == null) {
            throw new TypeCastException("null cannot be cast to non-null type gloomyfolken.mods.effects.client.texture.EffectIcon");
        }
        Companion.setFunnelEyeIcon((ejcz)icon);
        Icon icon2 = iconRegister._b("stalkermobs:distortion");
        if (icon2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type gloomyfolken.mods.effects.client.texture.EffectIcon");
        }
        Companion.setFunnelDistortionIcon((ejcz)icon2);
        Icon icon3 = iconRegister._b("stalkermobs:roflanebalo");
        if (icon3 == null) {
            throw new TypeCastException("null cannot be cast to non-null type gloomyfolken.mods.effects.client.texture.EffectIcon");
        }
        Companion.setRoflanEbaloIcon((ejcz)icon3);
    }

    static {
        Companion = new Companion(null);
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b\u00a8\u0006\u000f"}, d2={"Lgloomyfolken/mods/stalker/mobs/client/render/MutantsIconList$Companion;", "", "()V", "funnelDistortionIcon", "Lgloomyfolken/mods/effects/client/texture/EffectIcon;", "getFunnelDistortionIcon", "()Lgloomyfolken/mods/effects/client/texture/EffectIcon;", "setFunnelDistortionIcon", "(Lgloomyfolken/mods/effects/client/texture/EffectIcon;)V", "funnelEyeIcon", "getFunnelEyeIcon", "setFunnelEyeIcon", "roflanEbaloIcon", "getRoflanEbaloIcon", "setRoflanEbaloIcon", "minecraft"})
    public static final class Companion {
        @NotNull
        public final ejcz getFunnelDistortionIcon() {
            ejcz ejcz2 = funnelDistortionIcon;
            if (ejcz2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("funnelDistortionIcon");
            }
            return ejcz2;
        }

        public final void setFunnelDistortionIcon(@NotNull ejcz ejcz2) {
            Intrinsics.checkParameterIsNotNull(ejcz2, "<set-?>");
            funnelDistortionIcon = ejcz2;
        }

        @NotNull
        public final ejcz getFunnelEyeIcon() {
            ejcz ejcz2 = funnelEyeIcon;
            if (ejcz2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("funnelEyeIcon");
            }
            return ejcz2;
        }

        public final void setFunnelEyeIcon(@NotNull ejcz ejcz2) {
            Intrinsics.checkParameterIsNotNull(ejcz2, "<set-?>");
            funnelEyeIcon = ejcz2;
        }

        @NotNull
        public final ejcz getRoflanEbaloIcon() {
            ejcz ejcz2 = roflanEbaloIcon;
            if (ejcz2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("roflanEbaloIcon");
            }
            return ejcz2;
        }

        public final void setRoflanEbaloIcon(@NotNull ejcz ejcz2) {
            Intrinsics.checkParameterIsNotNull(ejcz2, "<set-?>");
            roflanEbaloIcon = ejcz2;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

