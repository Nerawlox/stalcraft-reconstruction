/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.hooklib.minecraft;

import cpw.mods.fml.common.Loader;
import gloomyfolken.hooklib.asm.Hook;
import gloomyfolken.hooklib.minecraft.MinecraftClassTransformer;
import net.minecraft.launchwrapper.LaunchClassLoader;

public class SecondaryTransformerHook {
    @Hook
    public static void injectData(Loader loader, Object ... objectArray) {
        ClassLoader classLoader = SecondaryTransformerHook.class.getClassLoader();
        if (classLoader instanceof LaunchClassLoader) {
            ((LaunchClassLoader)classLoader).registerTransformer(MinecraftClassTransformer.class.getName());
        } else {
            System.out.println("HookLib was not loaded by LaunchClassLoader. Hooks will not be injected.");
        }
    }
}

