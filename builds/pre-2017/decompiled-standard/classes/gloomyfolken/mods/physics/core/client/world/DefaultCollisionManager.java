/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.physics.core.client.world;

import com.bulletphysics.collision.dispatch.CollisionConfiguration;
import com.bulletphysics.collision.dispatch.CollisionDispatcher;
import com.bulletphysics.collision.dispatch.CollisionObject;
import gloomyfolken.mods.physics.core.client.SkeletonBody;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\n"}, d2={"Lgloomyfolken/mods/physics/core/client/world/DefaultCollisionManager;", "Lcom/bulletphysics/collision/dispatch/CollisionDispatcher;", "collisionConfiguration", "Lcom/bulletphysics/collision/dispatch/CollisionConfiguration;", "(Lcom/bulletphysics/collision/dispatch/CollisionConfiguration;)V", "needsCollision", "", "body0", "Lcom/bulletphysics/collision/dispatch/CollisionObject;", "body1", "minecraft"})
public final class DefaultCollisionManager
extends CollisionDispatcher {
    /*
     * Unable to fully structure code
     */
    @Override
    public boolean needsCollision(@NotNull CollisionObject var1_1, @NotNull CollisionObject var2_2) {
        Intrinsics.checkParameterIsNotNull(var1_1, "body0");
        Intrinsics.checkParameterIsNotNull(var2_2, "body1");
        if (var1_1.getUserPointer() instanceof SkeletonBody) ** GOTO lbl-1000
        v0 = var1_1.getUserPointer();
        if (!(v0 instanceof Integer)) {
            v0 = null;
        }
        if (Intrinsics.areEqual((Integer)v0, (Object)0)) lbl-1000:
        // 2 sources

        {
            v1 = true;
        } else {
            v1 = var3_3 = false;
        }
        if (var2_2.getUserPointer() instanceof SkeletonBody) ** GOTO lbl-1000
        v2 = var1_1.getUserPointer();
        if (!(v2 instanceof Integer)) {
            v2 = null;
        }
        if (Intrinsics.areEqual((Integer)v2, (Object)0)) lbl-1000:
        // 2 sources

        {
            v3 = true;
        } else {
            v3 = var4_4 = false;
        }
        if (!((v4 = var1_1.getUserPointer()) instanceof SkeletonBody)) {
            v4 = null;
        }
        var5_5 = (SkeletonBody)v4;
        v5 = var2_2.getUserPointer();
        if (!(v5 instanceof SkeletonBody)) {
            v5 = null;
        }
        var6_6 = (SkeletonBody)v5;
        return super.needsCollision(var1_1, var2_2) != false && (var3_3 == false || var4_4 == false);
    }

    public DefaultCollisionManager(@Nullable CollisionConfiguration collisionConfiguration) {
        super(collisionConfiguration);
    }
}

