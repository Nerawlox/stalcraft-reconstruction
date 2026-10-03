/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.physics.core.client.world;

import com.bulletphysics.collision.dispatch.CollisionObject;
import com.bulletphysics.demos.opengl.GLDebugDrawer;
import com.bulletphysics.demos.opengl.GLShapeDrawer;
import com.bulletphysics.demos.opengl.IGL;
import com.bulletphysics.demos.opengl.LWJGL;
import com.bulletphysics.dynamics.DynamicsWorld;
import com.bulletphysics.dynamics.RigidBody;
import com.bulletphysics.linearmath.DefaultMotionState;
import com.bulletphysics.linearmath.MotionState;
import com.bulletphysics.linearmath.Transform;
import gloomyfolken.mods.ktcore.VecExtensionsKt;
import gloomyfolken.mods.physics.core.client.world.PhysicsWorldContext;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2={"Lgloomyfolken/mods/physics/core/client/world/PhysicsWorldRenderer;", "", "physicsWorldContext", "Lgloomyfolken/mods/physics/core/client/world/PhysicsWorldContext;", "(Lgloomyfolken/mods/physics/core/client/world/PhysicsWorldContext;)V", "DEBUG_DRAW_WORLD", "", "getPhysicsWorldContext", "()Lgloomyfolken/mods/physics/core/client/world/PhysicsWorldContext;", "transform", "Lcom/bulletphysics/linearmath/Transform;", "wireColor", "Ljavax/vecmath/Vector3f;", "renderme", "", "physicsWorld", "Lcom/bulletphysics/dynamics/DynamicsWorld;", "Companion", "minecraft"})
public final class PhysicsWorldRenderer {
    private final Transform transform;
    private final javax.vecmath.Vector3f wireColor;
    private final boolean DEBUG_DRAW_WORLD = false;
    @NotNull
    private final PhysicsWorldContext physicsWorldContext;
    private static final IGL gl;
    public static final Companion Companion;

    public final void renderme(@NotNull DynamicsWorld dynamicsWorld) {
        DefaultMotionState defaultMotionState;
        RigidBody rigidBody;
        CollisionObject collisionObject;
        Intrinsics.checkParameterIsNotNull(dynamicsWorld, "physicsWorld");
        GL11.glPushMatrix();
        if (this.DEBUG_DRAW_WORLD) {
            if (dynamicsWorld.getDebugDrawer() == null) {
                dynamicsWorld.setDebugDrawer(new GLDebugDrawer(PhysicsWorldRenderer.Companion.getGl()));
            }
            dynamicsWorld.getDebugDrawer().setDebugMode(3);
            dynamicsWorld.debugDrawWorld();
        }
        int n = dynamicsWorld.getNumCollisionObjects();
        this.wireColor.set(1.0f, 0.0f, 0.0f);
        int n2 = 0;
        int n3 = n - 1;
        if (n2 <= n3) {
            while (true) {
                collisionObject = dynamicsWorld.getCollisionObjectArray().getQuick(n2);
                qnon._b();
                rigidBody = RigidBody.upcast(collisionObject);
                if (rigidBody != null && rigidBody.getMotionState() != null) {
                    MotionState motionState = rigidBody.getMotionState();
                    if (motionState == null) {
                        throw new TypeCastException("null cannot be cast to non-null type com.bulletphysics.linearmath.DefaultMotionState");
                    }
                    defaultMotionState = (DefaultMotionState)motionState;
                    this.transform.set(defaultMotionState.graphicsWorldTrans);
                } else {
                    collisionObject.getWorldTransform(this.transform);
                }
                this.wireColor.set(1.0f, 1.0f, 0.5f);
                if ((n2 & 1) != 0) {
                    this.wireColor.set(0.0f, 0.0f, 1.0f);
                }
                if (collisionObject.getActivationState() == 1) {
                    this.wireColor.x = (n2 & 1) != 0 ? (this.wireColor.x += 1.0f) : (this.wireColor.x += 0.5f);
                }
                if (collisionObject.getActivationState() == 2) {
                    this.wireColor.y = (n2 & 1) != 0 ? (this.wireColor.y += 1.0f) : (this.wireColor.y += 0.5f);
                }
                GLShapeDrawer.drawOpenGL(PhysicsWorldRenderer.Companion.getGl(), this.transform, collisionObject.getCollisionShape(), this.wireColor, 0);
                if (n2 == n3) break;
                ++n2;
            }
        }
        GL11.glDisable(2929);
        n2 = 0;
        n3 = n - 1;
        if (n2 <= n3) {
            while (true) {
                collisionObject = dynamicsWorld.getCollisionObjectArray().getQuick(n2);
                qnon._b();
                rigidBody = RigidBody.upcast(collisionObject);
                if (rigidBody.getUserPointer() instanceof String && !(StringsKt.contains$default((CharSequence)rigidBody.getUserPointer().toString(), "magic", false, 2, null) ^ true)) {
                    if (rigidBody != null && rigidBody.getMotionState() != null) {
                        MotionState motionState = rigidBody.getMotionState();
                        if (motionState == null) {
                            throw new TypeCastException("null cannot be cast to non-null type com.bulletphysics.linearmath.DefaultMotionState");
                        }
                        defaultMotionState = (DefaultMotionState)motionState;
                        this.transform.set(defaultMotionState.graphicsWorldTrans);
                    } else {
                        collisionObject.getWorldTransform(this.transform);
                    }
                    this.wireColor.set(1.0f, 1.0f, 0.5f);
                    if ((n2 & 1) != 0) {
                        this.wireColor.set(0.0f, 0.0f, 1.0f);
                    }
                    if (collisionObject.getActivationState() == 1) {
                        this.wireColor.x = (n2 & 1) != 0 ? (this.wireColor.x += 1.0f) : (this.wireColor.x += 0.5f);
                    }
                    if (collisionObject.getActivationState() == 2) {
                        this.wireColor.y = (n2 & 1) != 0 ? (this.wireColor.y += 1.0f) : (this.wireColor.y += 0.5f);
                    }
                    this.wireColor.x = 1.0f;
                    this.wireColor.y = StringsKt.contains$default((CharSequence)rigidBody.getUserPointer().toString(), "magic1", false, 2, null) ? 1.0f : 0.0f;
                    this.wireColor.z = StringsKt.contains$default((CharSequence)rigidBody.getUserPointer().toString(), "magic2", false, 2, null) ? 1.0f : 0.0f;
                    GLShapeDrawer.drawOpenGL(PhysicsWorldRenderer.Companion.getGl(), this.transform, collisionObject.getCollisionShape(), this.wireColor, 0);
                }
                if (n2 == n3) break;
                ++n2;
            }
        }
        GL11.glEnable(2929);
        GL11.glPopMatrix();
    }

    @NotNull
    public final PhysicsWorldContext getPhysicsWorldContext() {
        return this.physicsWorldContext;
    }

    public PhysicsWorldRenderer(@NotNull PhysicsWorldContext physicsWorldContext) {
        Intrinsics.checkParameterIsNotNull(physicsWorldContext, "physicsWorldContext");
        this.physicsWorldContext = physicsWorldContext;
        this.transform = new Transform();
        this.wireColor = new javax.vecmath.Vector3f();
    }

    static {
        Companion = new Companion(null);
        gl = LWJGL.getGL();
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bJ\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\rR\u001c\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000e"}, d2={"Lgloomyfolken/mods/physics/core/client/world/PhysicsWorldRenderer$Companion;", "", "()V", "gl", "Lcom/bulletphysics/demos/opengl/IGL;", "kotlin.jvm.PlatformType", "getGl", "()Lcom/bulletphysics/demos/opengl/IGL;", "renderAabb", "", "aabbMin", "Ljavax/vecmath/Vector3f;", "aabbMax", "Lorg/lwjgl/util/vector/Vector3f;", "minecraft"})
    public static final class Companion {
        private final IGL getGl() {
            return gl;
        }

        public final void renderAabb(@NotNull javax.vecmath.Vector3f vector3f, @NotNull javax.vecmath.Vector3f vector3f2) {
            Intrinsics.checkParameterIsNotNull(vector3f, "aabbMin");
            Intrinsics.checkParameterIsNotNull(vector3f2, "aabbMax");
            this.renderAabb(VecExtensionsKt.toGl(vector3f), VecExtensionsKt.toGl(vector3f2));
        }

        public final void renderAabb(@NotNull Vector3f vector3f, @NotNull Vector3f vector3f2) {
            Intrinsics.checkParameterIsNotNull(vector3f, "aabbMin");
            Intrinsics.checkParameterIsNotNull(vector3f2, "aabbMax");
            GL11.glColor3f(0.0f, 1.0f, 0.0f);
            GL11.glBegin(1);
            GL11.glVertex3f(vector3f.x, vector3f.y, vector3f.z);
            GL11.glVertex3f(vector3f2.x, vector3f.y, vector3f.z);
            GL11.glVertex3f(vector3f.x, vector3f.y, vector3f.z);
            GL11.glVertex3f(vector3f.x, vector3f2.y, vector3f.z);
            GL11.glVertex3f(vector3f.x, vector3f.y, vector3f.z);
            GL11.glVertex3f(vector3f.x, vector3f.y, vector3f2.z);
            GL11.glVertex3f(vector3f2.x, vector3f2.y, vector3f2.z);
            GL11.glVertex3f(vector3f.x, vector3f2.y, vector3f2.z);
            GL11.glVertex3f(vector3f2.x, vector3f2.y, vector3f2.z);
            GL11.glVertex3f(vector3f2.x, vector3f.y, vector3f2.z);
            GL11.glVertex3f(vector3f2.x, vector3f2.y, vector3f.z);
            GL11.glVertex3f(vector3f2.x, vector3f.y, vector3f.z);
            GL11.glVertex3f(vector3f.x, vector3f2.y, vector3f2.z);
            GL11.glVertex3f(vector3f.x, vector3f.y, vector3f2.z);
            GL11.glVertex3f(vector3f2.x, vector3f2.y, vector3f2.z);
            GL11.glVertex3f(vector3f2.x, vector3f2.y, vector3f.z);
            GL11.glVertex3f(vector3f.x, vector3f2.y, vector3f2.z);
            GL11.glVertex3f(vector3f.x, vector3f2.y, vector3f.z);
            GL11.glVertex3f(vector3f2.x, vector3f2.y, vector3f.z);
            GL11.glVertex3f(vector3f.x, vector3f2.y, vector3f.z);
            GL11.glVertex3f(vector3f2.x, vector3f.y, vector3f2.z);
            GL11.glVertex3f(vector3f.x, vector3f.y, vector3f2.z);
            GL11.glVertex3f(vector3f2.x, vector3f.y, vector3f2.z);
            GL11.glVertex3f(vector3f2.x, vector3f.y, vector3f.z);
            GL11.glEnd();
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

