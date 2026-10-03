/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.demos.applet;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;

public class LookUtil {
    private static Object oldAA = null;

    public static void pushAntialias(Graphics2D g2) {
        oldAA = g2.getRenderingHint(RenderingHints.KEY_ANTIALIASING);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }

    public static void popAntialias(Graphics2D g2) {
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, oldAA);
        oldAA = null;
    }

    public static boolean isXP() {
        Boolean b;
        return LookUtil.isWindows() && (b = (Boolean)Toolkit.getDefaultToolkit().getDesktopProperty("win.xpstyle.themeActive")) != null && b != false;
    }

    public static boolean isWindows() {
        LookAndFeel laf = UIManager.getLookAndFeel();
        return laf.getClass().getName().equals("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
    }
}

