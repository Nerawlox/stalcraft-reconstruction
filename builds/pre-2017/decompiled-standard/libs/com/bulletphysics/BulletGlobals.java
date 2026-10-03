/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics;

import com.bulletphysics.$Stack;
import com.bulletphysics.ContactAddedCallback;
import com.bulletphysics.ContactDestroyedCallback;
import com.bulletphysics.ContactProcessedCallback;
import com.bulletphysics.util.ArrayPool;
import com.bulletphysics.util.ObjectPool;

public class BulletGlobals {
    public static final boolean DEBUG = false;
    public static final float CONVEX_DISTANCE_MARGIN = 0.04f;
    public static final float FLT_EPSILON = 1.1920929E-7f;
    public static final float SIMD_EPSILON = 1.1920929E-7f;
    public static final float SIMD_2_PI = (float)Math.PI * 2;
    public static final float SIMD_PI = (float)Math.PI;
    public static final float SIMD_HALF_PI = 1.5707964f;
    public static final float SIMD_RADS_PER_DEG = (float)Math.PI / 180;
    public static final float SIMD_DEGS_PER_RAD = 57.295776f;
    public static final float SIMD_INFINITY = Float.MAX_VALUE;
    private static ThreadLocal<BulletGlobals> threadLocal = new ThreadLocal<BulletGlobals>(){

        @Override
        protected BulletGlobals initialValue() {
            return new BulletGlobals();
        }
    };
    private ContactDestroyedCallback gContactDestroyedCallback;
    private ContactAddedCallback gContactAddedCallback;
    private ContactProcessedCallback gContactProcessedCallback;
    private float contactBreakingThreshold = 0.02f;
    private float deactivationTime = 2.0f;
    private boolean disableDeactivation = false;

    public static ContactAddedCallback getContactAddedCallback() {
        return BulletGlobals.threadLocal.get().gContactAddedCallback;
    }

    public static void setContactAddedCallback(ContactAddedCallback callback) {
        BulletGlobals.threadLocal.get().gContactAddedCallback = callback;
    }

    public static ContactDestroyedCallback getContactDestroyedCallback() {
        return BulletGlobals.threadLocal.get().gContactDestroyedCallback;
    }

    public static void setContactDestroyedCallback(ContactDestroyedCallback callback) {
        BulletGlobals.threadLocal.get().gContactDestroyedCallback = callback;
    }

    public static ContactProcessedCallback getContactProcessedCallback() {
        return BulletGlobals.threadLocal.get().gContactProcessedCallback;
    }

    public static void setContactProcessedCallback(ContactProcessedCallback callback) {
        BulletGlobals.threadLocal.get().gContactProcessedCallback = callback;
    }

    public static float getContactBreakingThreshold() {
        return BulletGlobals.threadLocal.get().contactBreakingThreshold;
    }

    public static void setContactBreakingThreshold(float threshold) {
        BulletGlobals.threadLocal.get().contactBreakingThreshold = threshold;
    }

    public static float getDeactivationTime() {
        return BulletGlobals.threadLocal.get().deactivationTime;
    }

    public static void setDeactivationTime(float time) {
        BulletGlobals.threadLocal.get().deactivationTime = time;
    }

    public static boolean isDeactivationDisabled() {
        return BulletGlobals.threadLocal.get().disableDeactivation;
    }

    public static void setDeactivationDisabled(boolean disable) {
        BulletGlobals.threadLocal.get().disableDeactivation = disable;
    }

    public static void cleanCurrentThread() {
        threadLocal.remove();
        $Stack.threadLocal.remove();
        ObjectPool.cleanCurrentThread();
        ArrayPool.cleanCurrentThread();
    }
}

