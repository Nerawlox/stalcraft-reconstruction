// 
// Decompiled by Procyon v0.6.0
// 

package gloomyfolken.mods.physics.core.client.world;

import org.jetbrains.annotations.Nullable;
import com.bulletphysics.collision.dispatch.CollisionConfiguration;
import gloomyfolken.mods.physics.core.client.SkeletonBody;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import com.bulletphysics.collision.dispatch.CollisionObject;
import kotlin.Metadata;
import com.bulletphysics.collision.dispatch.CollisionDispatcher;

@Metadata(mv = { 1, 1, 7 }, bv = { 1, 0, 2 }, k = 1, d1 = { "\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003?\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016?\u0006\n" }, d2 = { "Lgloomyfolken/mods/physics/core/client/world/DefaultCollisionManager;", "Lcom/bulletphysics/collision/dispatch/CollisionDispatcher;", "collisionConfiguration", "Lcom/bulletphysics/collision/dispatch/CollisionConfiguration;", "(Lcom/bulletphysics/collision/dispatch/CollisionConfiguration;)V", "needsCollision", "", "body0", "Lcom/bulletphysics/collision/dispatch/CollisionObject;", "body1", "minecraft" })
public final class DefaultCollisionManager extends CollisionDispatcher
{
    public boolean needsCollision(@NotNull final CollisionObject collisionObject, @NotNull final CollisionObject collisionObject2) {
        Intrinsics.checkParameterIsNotNull((Object)collisionObject, "body0");
        Intrinsics.checkParameterIsNotNull((Object)collisionObject2, "body1");
        boolean b = false;
        Label_0053: {
            if (!(collisionObject.getUserPointer() instanceof SkeletonBody)) {
                Object userPointer;
                if (!((userPointer = collisionObject.getUserPointer()) instanceof Integer)) {
                    userPointer = null;
                }
                if (!Intrinsics.areEqual((Object)userPointer, (Object)0)) {
                    b = false;
                    break Label_0053;
                }
            }
            b = true;
        }
        final boolean b2 = b;
        boolean b3 = false;
        Label_0095: {
            if (!(collisionObject2.getUserPointer() instanceof SkeletonBody)) {
                Object userPointer2;
                if (!((userPointer2 = collisionObject.getUserPointer()) instanceof Integer)) {
                    userPointer2 = null;
                }
                if (!Intrinsics.areEqual((Object)userPointer2, (Object)0)) {
                    b3 = false;
                    break Label_0095;
                }
            }
            b3 = true;
        }
        final boolean b4 = b3;
        Object userPointer3;
        if (!((userPointer3 = collisionObject.getUserPointer()) instanceof SkeletonBody)) {
            userPointer3 = null;
        }
        final SkeletonBody skeletonBody = (SkeletonBody)userPointer3;
        Object userPointer4;
        if (!((userPointer4 = collisionObject2.getUserPointer()) instanceof SkeletonBody)) {
            userPointer4 = null;
        }
        final SkeletonBody skeletonBody2 = (SkeletonBody)userPointer4;
        return super.needsCollision(collisionObject, collisionObject2) && (!b2 || !b4);
    }
    
    public DefaultCollisionManager(@Nullable final CollisionConfiguration collisionConfiguration) {
        super(collisionConfiguration);
    }
}
