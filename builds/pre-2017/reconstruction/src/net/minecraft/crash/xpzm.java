/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.crash;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Vector;
import java.util.concurrent.Callable;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.vjta;

public class xpzm
implements Callable {
    public final CrashReport _a;

    public xpzm(CrashReport crashReport) {
        this._a = crashReport;
    }

    public String _a() throws SecurityException, NoSuchFieldException, IllegalAccessException, IllegalArgumentException {
        ArrayList arrayList;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            Field field = ClassLoader.class.getDeclaredField("classes");
            field.setAccessible(true);
            arrayList = new ArrayList((Vector)field.get(CrashReport.class.getClassLoader()));
        }
        catch (Exception exception) {
            return "";
        }
        boolean bl = true;
        boolean bl2 = !CrashReport.class.getCanonicalName().equals("net.minecraft.CrashReport");
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        String string = "";
        Collections.sort(arrayList, new vjta(this));
        for (Class clazz : arrayList) {
            String string2;
            String string3;
            if (clazz == null || (string3 = clazz.getCanonicalName()) == null || string3.startsWith("org.lwjgl.") || string3.startsWith("paulscode.") || string3.startsWith("org.bouncycastle.") || string3.startsWith("argo.") || string3.startsWith("com.jcraft.") || string3.startsWith("com.fasterxml.") || string3.startsWith("com.google.") || string3.startsWith("joptsimple.") || string3.startsWith("org.apache.") || string3.equals("util.GLX") || (!bl2 ? string3.startsWith("net.minecraft") : string3.length() <= 3 || string3.equals("net.minecraft.client.main.Main") || string3.equals("net.minecraft.client.Minecraft") || string3.equals("net.minecraft.client.ClientBrandRetriever") || string3.equals("net.minecraft.server.MinecraftServer"))) continue;
            Package package_ = clazz.getPackage();
            String string4 = string2 = package_ == null ? "" : package_.getName();
            if (hashMap.containsKey(string2)) {
                int n = (Integer)hashMap.get(string2);
                hashMap.put(string2, n + 1);
                if (n == 3) {
                    if (!bl) {
                        stringBuilder.append(", ");
                    }
                    stringBuilder.append("...");
                    bl = false;
                    continue;
                }
                if (n > 3) {
                    continue;
                }
            } else {
                hashMap.put(string2, 1);
            }
            if (!string.equals(string2) && string.length() > 0) {
                stringBuilder.append("], ");
            }
            if (!bl && string.equals(string2)) {
                stringBuilder.append(", ");
            }
            if (!string.equals(string2)) {
                stringBuilder.append("[");
                stringBuilder.append(string2);
                stringBuilder.append(".");
            }
            stringBuilder.append(clazz.getSimpleName());
            string = string2;
            bl = false;
        }
        if (bl) {
            stringBuilder.append("No suspicious classes found.");
        } else {
            stringBuilder.append("]");
        }
        return stringBuilder.toString();
    }

    public Object call() {
        return "FML and Forge are installed";
    }
}

