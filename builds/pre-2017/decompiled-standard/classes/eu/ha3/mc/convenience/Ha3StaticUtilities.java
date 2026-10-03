/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.mc.convenience;

public class Ha3StaticUtilities {
    public static boolean classExists(String string, Object object) {
        boolean bl = false;
        try {
            bl = Class.forName(string, false, object.getClass().getClassLoader()) != null;
        }
        catch (Exception exception) {
            // empty catch block
        }
        return bl;
    }
}

