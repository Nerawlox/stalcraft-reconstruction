/*
 * Decompiled with CFR 0.152.
 */
package net.smart.utilities;

import java.lang.reflect.Field;
import net.smart.utilities.Install;
import net.smart.utilities.Reflect;

public class Interface {
    private static Class ropesPlusClient = Reflect.LoadClass(Install.class, Install.RopesPlusClient, false);
    private static Field onZipLine = ropesPlusClient != null ? Reflect.GetField(ropesPlusClient, Install.RopesPlusClient_onZipLine, false) : null;

    public static boolean isRopeSliding() {
        return onZipLine != null && Reflect.GetField(onZipLine, null) != null;
    }
}

