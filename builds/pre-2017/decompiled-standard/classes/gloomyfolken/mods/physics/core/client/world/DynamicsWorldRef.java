/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.physics.core.client.world;

import com.bulletphysics.dynamics.DynamicsWorld;
import gloomyfolken.mods.physics.core.client.world.PhysicsWorldSettings;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0011"}, d2={"Lgloomyfolken/mods/physics/core/client/world/DynamicsWorldRef;", "", "worldSettings", "Lgloomyfolken/mods/physics/core/client/world/PhysicsWorldSettings;", "dynamicsWorld", "Lcom/bulletphysics/dynamics/DynamicsWorld;", "(Lgloomyfolken/mods/physics/core/client/world/PhysicsWorldSettings;Lcom/bulletphysics/dynamics/DynamicsWorld;)V", "getDynamicsWorld", "()Lcom/bulletphysics/dynamics/DynamicsWorld;", "lastPhysicsUpdated", "", "getLastPhysicsUpdated", "()J", "setLastPhysicsUpdated", "(J)V", "getWorldSettings", "()Lgloomyfolken/mods/physics/core/client/world/PhysicsWorldSettings;", "minecraft"})
public final class DynamicsWorldRef {
    private long lastPhysicsUpdated;
    @NotNull
    private final PhysicsWorldSettings worldSettings;
    @NotNull
    private final DynamicsWorld dynamicsWorld;

    public final long getLastPhysicsUpdated() {
        return this.lastPhysicsUpdated;
    }

    public final void setLastPhysicsUpdated(long l) {
        this.lastPhysicsUpdated = l;
    }

    @NotNull
    public final PhysicsWorldSettings getWorldSettings() {
        return this.worldSettings;
    }

    @NotNull
    public final DynamicsWorld getDynamicsWorld() {
        return this.dynamicsWorld;
    }

    public DynamicsWorldRef(@NotNull PhysicsWorldSettings physicsWorldSettings, @NotNull DynamicsWorld dynamicsWorld) {
        Intrinsics.checkParameterIsNotNull(physicsWorldSettings, "worldSettings");
        Intrinsics.checkParameterIsNotNull(dynamicsWorld, "dynamicsWorld");
        this.worldSettings = physicsWorldSettings;
        this.dynamicsWorld = dynamicsWorld;
        this.lastPhysicsUpdated = System.currentTimeMillis();
    }
}

