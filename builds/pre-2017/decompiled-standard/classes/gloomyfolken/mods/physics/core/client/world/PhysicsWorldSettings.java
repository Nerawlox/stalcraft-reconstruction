/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.physics.core.client.world;

import gloomyfolken.mods.physics.core.client.world.DynamicsWorldRef;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0005"}, d2={"Lgloomyfolken/mods/physics/core/client/world/PhysicsWorldSettings;", "", "()V", "createNewWorld", "Lgloomyfolken/mods/physics/core/client/world/DynamicsWorldRef;", "minecraft"})
public abstract class PhysicsWorldSettings {
    @NotNull
    public abstract DynamicsWorldRef createNewWorld();
}

