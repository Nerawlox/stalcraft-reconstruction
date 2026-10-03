/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.hooklib.minecraft;

import cpw.mods.fml.relauncher.CoreModManager;
import cpw.mods.fml.relauncher.FMLRelaunchLog;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
import gloomyfolken.hooklib.minecraft.PrimaryClassTransformer;
import java.lang.reflect.Field;
import java.util.Map;

public class HookLibPlugin
implements IFMLLoadingPlugin {
    private static boolean obf;
    private static boolean checked;

    @Override
    public String[] getLibraryRequestClass() {
        return null;
    }

    public String getAccessTransformerClass() {
        return null;
    }

    @Override
    public String[] getASMTransformerClass() {
        return new String[]{PrimaryClassTransformer.class.getName()};
    }

    @Override
    public String getModContainerClass() {
        return null;
    }

    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> map) {
    }

    public static boolean getObfuscated() {
        if (!checked) {
            try {
                Field field = CoreModManager.class.getDeclaredField("deobfuscatedEnvironment");
                field.setAccessible(true);
                obf = !field.getBoolean(null);
                FMLRelaunchLog.info("[HOOKLIB]  Obfuscated: " + obf, new Object[0]);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
            checked = true;
        }
        return obf;
    }
}

