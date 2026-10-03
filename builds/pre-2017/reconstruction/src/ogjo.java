/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.effects.client.main.pidb;
import gloomyfolken.mods.ktcore.VecExtensionsKt;
import java.util.concurrent.ThreadLocalRandom;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2={"Lgloomyfolken/mods/stalker/misc/client/particle/explosion/ExplosionParticleEmitter;", "Lgloomyfolken/mods/effects/client/particle/ParticleEmitter;", "world", "Lnet/minecraft/world/World;", "pos", "Lnet/minecraft/util/Vec3;", "(Lnet/minecraft/world/World;Lnet/minecraft/util/Vec3;)V", "flashEmitter", "Lgloomyfolken/mods/stalker/misc/client/particle/explosion/ExplosionStageFlash;", "getPos", "()Lnet/minecraft/util/Vec3;", "isValid", "", "minecraft"})
public final class ogjo
extends iekw {
    private final cdhe _a;
    @NotNull
    private final Vec3 _b;

    @Override
    public boolean isValid() {
        return false;
    }

    @NotNull
    public final Vec3 _a() {
        return this._b;
    }

    public ogjo(@NotNull World world, @NotNull Vec3 vec3) {
        Intrinsics.checkParameterIsNotNull(world, "world");
        Intrinsics.checkParameterIsNotNull(vec3, "pos");
        super(world, null);
        this._b = vec3;
        this._a = new cdhe(world, this._b);
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        double d = 0.15;
        Vec3 vec32 = VecExtensionsKt.vec3(this._b);
        pidb._a(new cdhe(world, VecExtensionsKt.add(vec32, threadLocalRandom.nextGaussian() * d, 0.0, threadLocalRandom.nextGaussian() * d)));
    }
}

