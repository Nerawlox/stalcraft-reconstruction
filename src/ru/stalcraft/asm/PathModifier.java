/*
 * Decompiled with CFR 0.152.
 */
package ru.stalcraft.asm;

public class PathModifier {
    public static String modifyPath(String oldPath, String domain) {
        return !domain.equals("minecraft") && !domain.equals("stalker") ? oldPath : (oldPath.endsWith(".png") && !oldPath.equals("pack.png") ? oldPath.substring(0, oldPath.length() - 4) + ".mic" : oldPath);
    }
}

