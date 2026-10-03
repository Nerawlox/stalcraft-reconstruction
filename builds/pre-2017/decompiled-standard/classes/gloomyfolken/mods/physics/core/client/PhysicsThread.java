/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.physics.core.client;

import gloomyfolken.mods.physics.core.client.world.PhysicsManager;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import net.minecraft.client.xpzm;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0004J\b\u0010\u0015\u001a\u00020\u0013H\u0016J\u0006\u0010\u0016\u001a\u00020\u0013R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0006X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\b\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2={"Lgloomyfolken/mods/physics/core/client/PhysicsThread;", "Ljava/lang/Thread;", "()V", "MAX_PHYS_TICK_TIME", "", "MULTITHREAD", "", "getMULTITHREAD", "()Z", "RENDER", "getRENDER", "lockObject", "Ljava/lang/Object;", "stopping", "getStopping", "setStopping", "(Z)V", "tickTimeLeft", "renderTickBullet", "", "partialTickTime", "run", "updateMcClientState", "minecraft"})
public final class PhysicsThread
extends Thread {
    private static final float MAX_PHYS_TICK_TIME = 35.0f;
    private static final boolean MULTITHREAD = true;
    private static final boolean RENDER = false;
    private static boolean stopping;
    private static final Object lockObject;
    private static float tickTimeLeft;
    public static final PhysicsThread INSTANCE;

    public final boolean getMULTITHREAD() {
        return MULTITHREAD;
    }

    public final boolean getRENDER() {
        return RENDER;
    }

    public final boolean getStopping() {
        return stopping;
    }

    public final void setStopping(boolean bl) {
        stopping = bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        while (!stopping) {
            Object object = lockObject;
            synchronized (object) {
                try {
                    tickTimeLeft = PhysicsManager.INSTANCE.physicsTick(tickTimeLeft);
                    try {
                        lockObject.wait(1L);
                    }
                    catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                    tickTimeLeft = 0.0f;
                    lockObject.wait(50L);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void renderTickBullet(float f) {
        if (xpzm._E()._M.field_74330_P) {
            Object object = lockObject;
            synchronized (object) {
                PhysicsManager.INSTANCE.renderTick(f);
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void updateMcClientState() {
        xpzm._E().__ah._a("physics");
        Object object = lockObject;
        synchronized (object) {
            if (MULTITHREAD) {
                PhysicsManager.INSTANCE.clientTick();
                tickTimeLeft = MAX_PHYS_TICK_TIME;
                lockObject.notify();
            }
            Unit unit = Unit.INSTANCE;
        }
        xpzm._E().__ah._b();
    }

    private PhysicsThread() {
        super("Physics Thread");
        INSTANCE = this;
        MAX_PHYS_TICK_TIME = 35.0f;
        MULTITHREAD = true;
        PhysicsThread physicsThread = this;
        if (physicsThread == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
        }
        lockObject = physicsThread;
        tickTimeLeft = MAX_PHYS_TICK_TIME;
    }

    static {
        new PhysicsThread();
    }
}

