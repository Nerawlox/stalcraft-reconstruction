/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  k
 */
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Vector;
import java.util.concurrent.Callable;

class j
implements Callable {
    final b a;

    j(b par1CrashReport) {
        this.a = par1CrashReport;
    }

    public String a() throws SecurityException, NoSuchFieldException, IllegalAccessException, IllegalArgumentException {
        ArrayList arraylist;
        StringBuilder stringbuilder = new StringBuilder();
        try {
            Field field = ClassLoader.class.getDeclaredField("classes");
            field.setAccessible(true);
            arraylist = new ArrayList((Vector)field.get(b.class.getClassLoader()));
        }
        catch (Exception ex2) {
            return "";
        }
        boolean flag = true;
        boolean flag1 = !b.class.getCanonicalName().equals("net.minecraft.CrashReport");
        HashMap<String, Integer> hashmap = new HashMap<String, Integer>();
        String s2 = "";
        Collections.sort(arraylist, new k(this));
        for (Class oclass : arraylist) {
            String s22;
            String s1;
            if (oclass == null || (s1 = oclass.getCanonicalName()) == null || s1.startsWith("org.lwjgl.") || s1.startsWith("paulscode.") || s1.startsWith("org.bouncycastle.") || s1.startsWith("argo.") || s1.startsWith("com.jcraft.") || s1.startsWith("com.fasterxml.") || s1.startsWith("com.google.") || s1.startsWith("joptsimple.") || s1.startsWith("org.apache.") || s1.equals("util.GLX") || (!flag1 ? s1.startsWith("net.minecraft") : s1.length() <= 3 || s1.equals("net.minecraft.client.main.Main") || s1.equals("net.minecraft.client.Minecraft") || s1.equals("net.minecraft.client.ClientBrandRetriever") || s1.equals("net.minecraft.server.MinecraftServer"))) continue;
            Package opackage = oclass.getPackage();
            String string = s22 = opackage == null ? "" : opackage.getName();
            if (hashmap.containsKey(s22)) {
                int i2 = (Integer)hashmap.get(s22);
                hashmap.put(s22, i2 + 1);
                if (i2 == 3) {
                    if (!flag) {
                        stringbuilder.append(", ");
                    }
                    stringbuilder.append("...");
                    flag = false;
                    continue;
                }
                if (i2 > 3) {
                    continue;
                }
            } else {
                hashmap.put(s22, 1);
            }
            if (!s2.equals(s22) && s2.length() > 0) {
                stringbuilder.append("], ");
            }
            if (!flag && s2.equals(s22)) {
                stringbuilder.append(", ");
            }
            if (!s2.equals(s22)) {
                stringbuilder.append("[");
                stringbuilder.append(s22);
                stringbuilder.append(".");
            }
            stringbuilder.append(oclass.getSimpleName());
            s2 = s22;
            flag = false;
        }
        if (flag) {
            stringbuilder.append("No suspicious classes found.");
        } else {
            stringbuilder.append("]");
        }
        return stringbuilder.toString();
    }

    public Object call() {
        return "FML and Forge are installed";
    }
}

