/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.physics.core.client.world;

import com.bulletphysics.collision.broadphase.HashedOverlappingPairCache;
import com.bulletphysics.collision.dispatch.DefaultCollisionConfiguration;
import com.bulletphysics.dynamics.constraintsolver.SequentialImpulseConstraintSolver;
import gloomyfolken.mods.physics.core.client.bulletoverride.JAxisSweep3;
import gloomyfolken.mods.physics.core.client.world.DefaultCollisionManager;
import gloomyfolken.mods.physics.core.client.world.DiscreteCcdWorld;
import gloomyfolken.mods.physics.core.client.world.DynamicsWorldRef;
import gloomyfolken.mods.physics.core.client.world.PhysicsWorldSettings;
import javax.vecmath.Vector3f;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0013\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0096\u0002J\b\u0010\t\u001a\u00020\nH\u0016\u00a8\u0006\u000b"}, d2={"Lgloomyfolken/mods/physics/core/client/world/DefaultWorldSettings;", "Lgloomyfolken/mods/physics/core/client/world/PhysicsWorldSettings;", "()V", "createNewWorld", "Lgloomyfolken/mods/physics/core/client/world/DynamicsWorldRef;", "equals", "", "other", "", "hashCode", "", "minecraft"})
public final class DefaultWorldSettings
extends PhysicsWorldSettings {
    @Override
    @NotNull
    public DynamicsWorldRef createNewWorld() {
        DefaultCollisionConfiguration defaultCollisionConfiguration = new DefaultCollisionConfiguration();
        DefaultCollisionManager defaultCollisionManager = new DefaultCollisionManager(defaultCollisionConfiguration);
        JAxisSweep3 jAxisSweep3 = new JAxisSweep3(new Vector3f(-20.0f, -128.0f, -20.0f), new Vector3f(20.0f, 10.0f, 20.0f), 16384, new HashedOverlappingPairCache());
        SequentialImpulseConstraintSolver sequentialImpulseConstraintSolver = new SequentialImpulseConstraintSolver();
        DiscreteCcdWorld discreteCcdWorld = new DiscreteCcdWorld(defaultCollisionManager, jAxisSweep3, sequentialImpulseConstraintSolver, defaultCollisionConfiguration);
        discreteCcdWorld.getDispatchInfo().useContinuous = true;
        discreteCcdWorld.getDispatchInfo().allowedCcdPenetration = 0.001f;
        return new DynamicsWorldRef(this, discreteCcdWorld);
    }

    public int hashCode() {
        return 0;
    }

    public boolean equals(@Nullable Object object) {
        return object instanceof DefaultWorldSettings;
    }
}

