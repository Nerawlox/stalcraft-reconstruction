/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.relauncher;

import java.lang.reflect.Method;

public class ServerLaunchWrapper {
    public static void main(String[] stringArray) {
        new ServerLaunchWrapper().run(stringArray);
    }

    private ServerLaunchWrapper() {
    }

    private void run(String[] stringArray) {
        Class<?> clazz = null;
        try {
            clazz = Class.forName("net.minecraft.launchwrapper.Launch", true, this.getClass().getClassLoader());
            Class.forName("org.objectweb.asm.Type", true, this.getClass().getClassLoader());
        }
        catch (Exception exception) {
            System.err.printf("We appear to be missing one or more essential library files.\nYou will need to add them to your server before FML and Forge will run successfully.", new Object[0]);
            exception.printStackTrace(System.err);
            System.exit(1);
        }
        try {
            Method method = clazz.getMethod("main", String[].class);
            String[] stringArray2 = new String[stringArray.length + 2];
            stringArray2[0] = "--tweakClass";
            stringArray2[1] = "cpw.mods.fml.common.launcher.FMLServerTweaker";
            System.arraycopy(stringArray, 0, stringArray2, 2, stringArray.length);
            method.invoke(null, new Object[]{stringArray2});
        }
        catch (Exception exception) {
            System.err.printf("A problem occurred running the Server launcher.", new Object[0]);
            exception.printStackTrace(System.err);
            System.exit(1);
        }
    }
}

