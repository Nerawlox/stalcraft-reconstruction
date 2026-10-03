/*
 * Decompiled with CFR 0.152.
 */
package net.sf.kdgcommons.lang;

public class ThreadUtil {
    public static long sleepQuietly(long l) {
        long l2 = System.currentTimeMillis();
        try {
            Thread.sleep(l);
        }
        catch (InterruptedException interruptedException) {
            // empty catch block
        }
        return System.currentTimeMillis() - l2;
    }
}

