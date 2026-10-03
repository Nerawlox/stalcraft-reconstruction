/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.physics.ragdolls.entity;

import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.effects.client.mcsa.kjui;
import gloomyfolken.mods.physics.ragdolls.client.render.RenderCorpseLeftovers;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0000H'J\b\u0010\u0007\u001a\u00020\bH\u0017\u00a8\u0006\t"}, d2={"Lgloomyfolken/mods/physics/ragdolls/entity/ILeftoversRenderInfo;", "", "getLeftoverRenderer", "Lgloomyfolken/mods/effects/client/mcsa/DynamicMcsaRenderer;", "render", "Lgloomyfolken/mods/physics/ragdolls/client/render/RenderCorpseLeftovers;", "entity", "shouldUseLeftoversRenderer", "", "minecraft"})
public interface ILeftoversRenderInfo {
    @ezey(_a={eidj.CLIENT})
    @NotNull
    public kjui getLeftoverRenderer(@NotNull RenderCorpseLeftovers var1, @NotNull ILeftoversRenderInfo var2);

    @ezey(_a={eidj.CLIENT})
    public boolean shouldUseLeftoversRenderer();

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=3)
    public static final class DefaultImpls {
        @ezey(_a={eidj.CLIENT})
        public static boolean shouldUseLeftoversRenderer(ILeftoversRenderInfo iLeftoversRenderInfo) {
            return false;
        }
    }
}

