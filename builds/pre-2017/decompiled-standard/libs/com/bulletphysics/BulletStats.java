/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics;

import com.bulletphysics.linearmath.CProfileManager;
import com.bulletphysics.linearmath.Clock;
import javax.vecmath.Vector3f;

public class BulletStats {
    public static int gTotalContactPoints;
    public static int gNumDeepPenetrationChecks;
    public static int gNumGjkChecks;
    public static int gNumSplitImpulseRecoveries;
    public static int gNumAlignedAllocs;
    public static int gNumAlignedFree;
    public static int gTotalBytesAlignedAllocs;
    public static int gPickingConstraintId;
    public static final Vector3f gOldPickingPos;
    public static float gOldPickingDist;
    public static int gOverlappingPairs;
    public static int gRemovePairs;
    public static int gAddedPairs;
    public static int gFindPairs;
    public static final Clock gProfileClock;
    public static int gNumClampedCcdMotions;
    public static long stepSimulationTime;
    public static long updateTime;
    private static boolean enableProfile;

    public static boolean isProfileEnabled() {
        return enableProfile;
    }

    public static void setProfileEnabled(boolean b) {
        enableProfile = b;
    }

    public static long profileGetTicks() {
        long ticks = gProfileClock.getTimeMicroseconds();
        return ticks;
    }

    public static float profileGetTickRate() {
        return 1000.0f;
    }

    public static void pushProfile(String name2) {
        if (enableProfile) {
            CProfileManager.startProfile(name2);
        }
    }

    public static void popProfile() {
        if (enableProfile) {
            CProfileManager.stopProfile();
        }
    }

    static {
        gNumDeepPenetrationChecks = 0;
        gNumGjkChecks = 0;
        gNumSplitImpulseRecoveries = 0;
        gPickingConstraintId = 0;
        gOldPickingPos = new Vector3f();
        gOldPickingDist = 0.0f;
        gOverlappingPairs = 0;
        gRemovePairs = 0;
        gAddedPairs = 0;
        gFindPairs = 0;
        gProfileClock = new Clock();
        gNumClampedCcdMotions = 0;
        enableProfile = false;
    }
}

