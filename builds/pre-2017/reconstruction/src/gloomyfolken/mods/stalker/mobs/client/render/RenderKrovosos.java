/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.client.render;

import gloomyfolken.mods.effects.client.mcsa.ezfa;
import gloomyfolken.mods.effects.client.mcsa.kjui;
import gloomyfolken.mods.effects.client.mcsa.qlgf;
import gloomyfolken.mods.effects.client.mcsa.ugqx;
import gloomyfolken.mods.stalker.mobs.client.render.RenderMutant;
import gloomyfolken.mods.stalker.mobs.entity.EntityMutant;
import gloomyfolken.mods.stalker.mobs.entity.mutants.EntityKrovosos;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.opengl.GL20;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0014\u00a8\u0006\r"}, d2={"Lgloomyfolken/mods/stalker/mobs/client/render/RenderKrovosos;", "Lgloomyfolken/mods/stalker/mobs/client/render/RenderMutant;", "Lgloomyfolken/mods/stalker/mobs/entity/mutants/EntityKrovosos;", "()V", "renderMutant", "", "mcsaRenderer", "Lgloomyfolken/mods/effects/client/mcsa/DynamicMcsaRenderer;", "mutant", "frame", "", "pass", "", "minecraft"})
public final class RenderKrovosos
extends RenderMutant<EntityKrovosos> {
    @Override
    protected void renderMutant(@NotNull kjui kjui2, @NotNull EntityKrovosos entityKrovosos, float f, int n) {
        Intrinsics.checkParameterIsNotNull(kjui2, "mcsaRenderer");
        Intrinsics.checkParameterIsNotNull(entityKrovosos, "mutant");
        if (n > 0) {
            Iterable iterable = CollectionsKt.reversed(kjui2._a().getMeshes());
            for (Object t : iterable) {
                qlgf qlgf2 = (qlgf)t;
                ezfa.kjui kjui3 = new ezfa.kjui(n, entityKrovosos, kjui2){
                    final /* synthetic */ int $pass$inlined;
                    final /* synthetic */ EntityKrovosos $mutant$inlined;
                    final /* synthetic */ kjui $mcsaRenderer$inlined;
                    {
                        this.$pass$inlined = n;
                        this.$mutant$inlined = entityKrovosos;
                        this.$mcsaRenderer$inlined = kjui2;
                    }

                    protected void render(float f) {
                        float f2 = Intrinsics.areEqual(this.renderer._c._l, "eyes") ? 0.15f : 0.04f;
                        float f3 = this.$pass$inlined == 2 ? this.$mutant$inlined.getRenderChameleon(f) * 0.25f + 1.0f : owkq._d(1.0f - this.$mutant$inlined.getRenderChameleon(f), f2);
                        GL20.glUniform1f(this.renderer._e._a("chameleon"), f3);
                        super.render(f);
                    }

                    public void load(ugqx.kjui kjui2, cucv cucv2) {
                        super.load(kjui2, cucv2);
                    }
                };
                ugqx.kjui kjui4 = ((ugqx)kjui2._u_())._a(qlgf2._l);
                Intrinsics.checkExpressionValueIsNotNull(kjui4, "mcsaRenderer.get().getMeshRenderer(it.name)");
                ogej ogej2 = entityKrovosos.getAnimationHandler().ctx;
                Intrinsics.checkExpressionValueIsNotNull(ogej2, "mutant.getAnimationHandler().ctx");
                kjui3.load(kjui4, ogej2);
                ezfa._a._a(kjui3);
            }
        } else {
            super.renderMutant(kjui2, (EntityMutant)entityKrovosos, f, n);
        }
    }
}

