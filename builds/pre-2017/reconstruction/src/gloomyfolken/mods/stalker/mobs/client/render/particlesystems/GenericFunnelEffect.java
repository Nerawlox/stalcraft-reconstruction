/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.client.render.particlesystems;

import gloomyfolken.mods.ktcore.VecExtensionsKt;
import gloomyfolken.mods.stalker.mobs.client.render.MutantsIconList;
import gloomyfolken.mods.stalker.mobs.client.render.particle.GenericDistortionParticle;
import gloomyfolken.mods.stalker.mobs.client.render.particle.GenericFunnelParticle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0013"}, d2={"Lgloomyfolken/mods/stalker/mobs/client/render/particlesystems/GenericFunnelEffect;", "Lgloomyfolken/mods/effects/client/particle/ParticleEmitter;", "world", "Lnet/minecraft/world/World;", "origin", "Lnet/minecraft/util/Vec3;", "(Lnet/minecraft/world/World;Lnet/minecraft/util/Vec3;)V", "ageLeft", "", "getAgeLeft", "()I", "setAgeLeft", "(I)V", "getOrigin", "()Lnet/minecraft/util/Vec3;", "isValid", "", "tick", "", "minecraft"})
public final class GenericFunnelEffect
extends iekw {
    private int ageLeft;
    @NotNull
    private final Vec3 origin;

    public final int getAgeLeft() {
        return this.ageLeft;
    }

    public final void setAgeLeft(int n) {
        this.ageLeft = n;
    }

    @Override
    public void tick() {
        super.tick();
        Iterable iterable = this.particles;
        for (Object t : iterable) {
            ncyh ncyh2 = (ncyh)t;
            ncyh2.textureSize *= 0.8f;
        }
        int n = this.ageLeft;
        this.ageLeft = n + -1;
    }

    @Override
    public boolean isValid() {
        return this.ageLeft >= 0;
    }

    @NotNull
    public final Vec3 getOrigin() {
        return this.origin;
    }

    public GenericFunnelEffect(@NotNull World world, @NotNull Vec3 vec3) {
        Intrinsics.checkParameterIsNotNull(world, "world");
        Intrinsics.checkParameterIsNotNull(vec3, "origin");
        super(world, null);
        this.origin = vec3;
        this.ageLeft = 10;
        this.setCenter(VecExtensionsKt.getX(this.origin), VecExtensionsKt.getY(this.origin), VecExtensionsKt.getZ(this.origin));
        this.setSize(2.0, 2.0, 2.0);
        this.particles.add(new GenericDistortionParticle(this, MutantsIconList.Companion.getFunnelDistortionIcon()));
        this.particles.add(new GenericFunnelParticle(this, MutantsIconList.Companion.getFunnelEyeIcon()));
    }
}

