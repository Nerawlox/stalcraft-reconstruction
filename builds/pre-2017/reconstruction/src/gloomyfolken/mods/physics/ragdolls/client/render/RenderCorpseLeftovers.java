/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.physics.ragdolls.client.render;

import gloomyfolken.mods.effects.client.mcsa.ezfc;
import gloomyfolken.mods.effects.client.mcsa.kjui;
import gloomyfolken.mods.physics.ragdolls.client.render.ModelGenericPlaceholder;
import gloomyfolken.mods.physics.ragdolls.entity.ILeftoversRenderInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0002J8\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014J\u0018\u0010\u0016\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u0012H\u0004R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006\u00a8\u0006\u0019"}, d2={"Lgloomyfolken/mods/physics/ragdolls/client/render/RenderCorpseLeftovers;", "Lnet/minecraft/client/renderer/entity/RenderLiving;", "()V", "animalLeftoversRenderer", "Lgloomyfolken/mods/core/client/render/RenderCustomMaterial;", "getAnimalLeftoversRenderer", "()Lgloomyfolken/mods/core/client/render/RenderCustomMaterial;", "bipedLeftoversRenderer", "getBipedLeftoversRenderer", "doRender", "", "entity", "Lnet/minecraft/entity/Entity;", "translateX", "", "translateY", "translateZ", "f", "", "frame", "getEntityTexture", "Lnet/minecraft/util/ResourceLocation;", "renderCorpseInternal", "Lgloomyfolken/mods/physics/ragdolls/entity/ILeftoversRenderInfo;", "Companion", "minecraft"})
public final class RenderCorpseLeftovers
extends RenderLiving {
    @NotNull
    private final iefv bipedLeftoversRenderer;
    @NotNull
    private final iefv animalLeftoversRenderer;
    @NotNull
    public static RenderCorpseLeftovers instance;
    public static final Companion Companion;

    @NotNull
    public final iefv getBipedLeftoversRenderer() {
        return this.bipedLeftoversRenderer;
    }

    @NotNull
    public final iefv getAnimalLeftoversRenderer() {
        return this.animalLeftoversRenderer;
    }

    @Override
    @Nullable
    protected ResourceLocation getEntityTexture(@Nullable Entity entity) {
        return null;
    }

    @Override
    public void doRender(@NotNull Entity entity, double d, double d2, double d3, float f, float f2) {
        Intrinsics.checkParameterIsNotNull(entity, "entity");
        ezfc._a();
        ezfc._a((float)d, (float)d2, (float)d3);
        ezfc._a(-entity.rotationYaw, 0.0f, 1.0f, 0.0f);
        this.renderCorpseInternal((ILeftoversRenderInfo)((Object)entity), f2);
        ezfc._b();
    }

    protected final void renderCorpseInternal(@NotNull ILeftoversRenderInfo iLeftoversRenderInfo, float f) {
        Intrinsics.checkParameterIsNotNull(iLeftoversRenderInfo, "entity");
        kjui kjui2 = iLeftoversRenderInfo.getLeftoverRenderer(this, iLeftoversRenderInfo);
        if (Intrinsics.areEqual(kjui2, this.animalLeftoversRenderer._b())) {
            ezfc._b(2.0f, 2.0f, 2.0f);
        }
        kjui2._c.renderAll();
    }

    public RenderCorpseLeftovers() {
        super(new ModelGenericPlaceholder(), 0.0f);
        Companion.setInstance(this);
        this.bipedLeftoversRenderer = new iefv("/assets/ragdolls/models/corpse_bag.mcsa", "/assets/ragdolls/models/corpse_bag_0.mcmtl");
        this.animalLeftoversRenderer = new iefv("/assets/ragdolls/models/corpse_pile.mcsa");
    }

    static {
        Companion = new Companion(null);
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2={"Lgloomyfolken/mods/physics/ragdolls/client/render/RenderCorpseLeftovers$Companion;", "", "()V", "instance", "Lgloomyfolken/mods/physics/ragdolls/client/render/RenderCorpseLeftovers;", "getInstance", "()Lgloomyfolken/mods/physics/ragdolls/client/render/RenderCorpseLeftovers;", "setInstance", "(Lgloomyfolken/mods/physics/ragdolls/client/render/RenderCorpseLeftovers;)V", "minecraft"})
    public static final class Companion {
        @NotNull
        public final RenderCorpseLeftovers getInstance() {
            RenderCorpseLeftovers renderCorpseLeftovers = instance;
            if (renderCorpseLeftovers == null) {
                Intrinsics.throwUninitializedPropertyAccessException("instance");
            }
            return renderCorpseLeftovers;
        }

        public final void setInstance(@NotNull RenderCorpseLeftovers renderCorpseLeftovers) {
            Intrinsics.checkParameterIsNotNull(renderCorpseLeftovers, "<set-?>");
            instance = renderCorpseLeftovers;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

