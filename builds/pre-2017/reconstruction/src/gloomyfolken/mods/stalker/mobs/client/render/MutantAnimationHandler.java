/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.client.render;

import gloomyfolken.mods.stalker.mobs.client.render.RenderMutant;
import gloomyfolken.mods.stalker.mobs.entity.EntityMutant;
import gloomyfolken.mods.stalker.mobs.entity.animation.AnimationProperty;
import gloomyfolken.mods.stalker.mobs.entity.animation.EnumPlayMode;
import gloomyfolken.mods.stalker.mobs.entity.animation.state.CustomAnimationState;
import org.jetbrains.annotations.Nullable;

public class MutantAnimationHandler {
    public static nuco clipLayer = new nuco();
    private final EntityMutant entity;
    public final ogej ctx;
    private CustomAnimationState clientAnimationState;

    public MutantAnimationHandler(EntityMutant entityMutant) {
        this.entity = entityMutant;
        jytp jytp2 = new jytp(clipLayer, "idle_stand");
        this.ctx = new ogej(RenderMutant.Companion.getMobToRendererMap().get(entityMutant.getClass())._a, new hsnd[0]);
        this.ctx._b(jytp2);
    }

    public void tick() {
        this.ctx._b();
    }

    @Nullable
    public jytp playAnimation(AnimationProperty animationProperty, EnumPlayMode enumPlayMode, float f, boolean bl) {
        return this.playAnimation(enumPlayMode, Float.valueOf(animationProperty.getAnimationSpeed() * f), animationProperty.getAnimName(), bl);
    }

    @Nullable
    private jytp playAnimation(EnumPlayMode enumPlayMode, Float f, String string, boolean bl) {
        if (this.entity.isEntityAlive()) {
            jytp jytp2 = new jytp(clipLayer, string);
            jytp2._b = bl ? gpnw._d : gpnw._b;
            jytp2.speedFactor = f.floatValue();
            if (enumPlayMode == EnumPlayMode.BLEND_IN) {
                this.ctx._b(jytp2, 3.0f);
            } else {
                this.ctx._b(jytp2);
            }
            return jytp2;
        }
        return null;
    }
}

