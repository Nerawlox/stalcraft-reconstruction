/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.linearmath;

import com.bulletphysics.BulletStats;
import com.bulletphysics.linearmath.CProfileIterator;
import com.bulletphysics.linearmath.CProfileNode;

public class CProfileManager {
    private static CProfileNode root;
    private static CProfileNode currentNode;
    private static int frameCounter;
    private static long resetTime;

    public static void startProfile(String name2) {
        if (name2 != currentNode.getName()) {
            currentNode = currentNode.getSubNode(name2);
        }
        currentNode.call();
    }

    public static void stopProfile() {
        if (currentNode.Return()) {
            currentNode = currentNode.getParent();
        }
    }

    public static void cleanupMemory() {
        root.cleanupMemory();
    }

    public static void reset() {
        root.reset();
        root.call();
        frameCounter = 0;
        resetTime = BulletStats.profileGetTicks();
    }

    public static void incrementFrameCounter() {
        ++frameCounter;
    }

    public static int getFrameCountSinceReset() {
        return frameCounter;
    }

    public static float getTimeSinceReset() {
        long time = BulletStats.profileGetTicks();
        return (float)(time -= resetTime) / BulletStats.profileGetTickRate();
    }

    public static CProfileIterator getIterator() {
        return new CProfileIterator(root);
    }

    public static void releaseIterator(CProfileIterator iterator2) {
    }

    static {
        currentNode = root = new CProfileNode("Root", null);
        frameCounter = 0;
        resetTime = 0L;
    }
}

