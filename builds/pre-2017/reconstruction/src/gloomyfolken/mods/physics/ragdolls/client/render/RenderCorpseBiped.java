/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.physics.ragdolls.client.render;

import gloomyfolken.mods.effects.client.mcsa.ugqx;
import gloomyfolken.mods.effects.client.mcsa.vjsq;
import gloomyfolken.mods.physics.ragdolls.client.render.CorpseAnimationHandler;
import gloomyfolken.mods.physics.ragdolls.client.render.RenderCorpse;
import gloomyfolken.mods.physics.ragdolls.entity.EntityCorpseBiped;
import gloomyfolken.mods.physics.ragdolls.entity.EntityRagdollCorpse;
import gloomyfolken.mods.stalker.player.tupg;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\t"}, d2={"Lgloomyfolken/mods/physics/ragdolls/client/render/RenderCorpseBiped;", "Lgloomyfolken/mods/physics/ragdolls/client/render/RenderCorpse;", "()V", "prepareRenderCorpse", "", "entityRagdollCorpse", "Lgloomyfolken/mods/physics/ragdolls/entity/EntityRagdollCorpse;", "frame", "", "minecraft"})
public final class RenderCorpseBiped
extends RenderCorpse {
    @Override
    public void prepareRenderCorpse(@NotNull EntityRagdollCorpse entityRagdollCorpse, float f) {
        block2: {
            Item item;
            Intrinsics.checkParameterIsNotNull(entityRagdollCorpse, "entityRagdollCorpse");
            EntityCorpseBiped entityCorpseBiped = (EntityCorpseBiped)entityRagdollCorpse;
            ugqx ugqx2 = tupg._a(entityCorpseBiped.getSkin());
            CorpseAnimationHandler corpseAnimationHandler = entityCorpseBiped.getAnimationHandler();
            if (corpseAnimationHandler == null || ugqx2 == null) break block2;
            this.renderCorpseInternal(entityCorpseBiped, corpseAnimationHandler, ugqx2, 0.9375f);
            ItemStack itemStack = entityCorpseBiped.getArmorStack();
            Item item2 = item = itemStack != null ? itemStack._a() : null;
            if (item instanceof dgmz) {
                tewl tewl2;
                tewl tewl3 = tewl2 = tewl._a((dgmz)item);
                if (tewl3 != null) {
                    tewl3._a(entityCorpseBiped.getArmorStack(), vjsq._a(corpseAnimationHandler.getCtx()));
                }
            }
        }
    }
}

