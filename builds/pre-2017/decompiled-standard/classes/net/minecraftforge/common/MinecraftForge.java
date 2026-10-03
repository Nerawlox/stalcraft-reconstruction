/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.common;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Arrays;
import java.util.List;
import net.minecraft.crash.CrashReport;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.ForgeInternalHandler;
import net.minecraftforge.common.ForgeVersion;
import net.minecraftforge.event.EventBus;
import net.minecraftforge.oredict.OreDictionary;

public class MinecraftForge {
    public static final EventBus EVENT_BUS = new EventBus();
    public static final EventBus TERRAIN_GEN_BUS = new EventBus();
    public static final EventBus ORE_GEN_BUS = new EventBus();
    private static final ForgeInternalHandler INTERNAL_HANDLER = new ForgeInternalHandler();

    public static void addGrassPlant(twgu twgu2, int n, int n2) {
        ForgeHooks.grassList.add(new ForgeHooks.GrassEntry(twgu2, n, n2));
    }

    public static void addGrassSeed(cvzo cvzo2, int n) {
        ForgeHooks.seedList.add(new ForgeHooks.SeedEntry(cvzo2, n));
    }

    public static void setToolClass(tgdv tgdv2, String string, int n) {
        ForgeHooks.toolClasses.put(tgdv2, Arrays.asList(string, n));
    }

    public static void setBlockHarvestLevel(twgu twgu2, int n, String string, int n2) {
        List<Object> list = Arrays.asList(twgu2, n, string);
        ForgeHooks.toolHarvestLevels.put(list, n2);
        ForgeHooks.toolEffectiveness.add(list);
    }

    public static void removeBlockEffectiveness(twgu twgu2, int n, String string) {
        List<Object> list = Arrays.asList(twgu2, n, string);
        ForgeHooks.toolEffectiveness.remove(list);
    }

    public static void setBlockHarvestLevel(twgu twgu2, String string, int n) {
        for (int i = 0; i < 16; ++i) {
            List<Object> list = Arrays.asList(twgu2, i, string);
            ForgeHooks.toolHarvestLevels.put(list, n);
            ForgeHooks.toolEffectiveness.add(list);
        }
    }

    public static int getBlockHarvestLevel(twgu twgu2, int n, String string) {
        ForgeHooks.initTools();
        List<Object> list = Arrays.asList(twgu2, n, string);
        Integer n2 = ForgeHooks.toolHarvestLevels.get(list);
        return n2 == null ? -1 : n2;
    }

    public static void removeBlockEffectiveness(twgu twgu2, String string) {
        for (int i = 0; i < 16; ++i) {
            List<Object> list = Arrays.asList(twgu2, i, string);
            ForgeHooks.toolEffectiveness.remove(list);
        }
    }

    public static void initialize() {
        System.out.printf("MinecraftForge v%s Initialized\n", ForgeVersion.getVersion());
        FMLLog.info("MinecraftForge v%s Initialized", ForgeVersion.getVersion());
        twgu twgu2 = new twgu(0, tflj._a){

            @Override
            @SideOnly(value=Side.CLIENT)
            public void func_94332_a(nege nege2) {
            }
        };
        twgu.field_71973_m[0] = null;
        twgu.field_71970_n[0] = false;
        twgu.field_71971_o[0] = 0;
        twgu2.func_71864_b("ForgeFiller");
        for (int i = 256; i < 4096; ++i) {
            if (tgdv.field_77698_e[i] == null) continue;
            twgu.field_71973_m[i] = twgu2;
        }
        boolean[] blArray = new boolean[4096];
        System.arraycopy(EntityEnderman.field_70827_d, 0, blArray, 0, EntityEnderman.field_70827_d.length);
        EntityEnderman.field_70827_d = blArray;
        EVENT_BUS.register(INTERNAL_HANDLER);
        OreDictionary.getOreName(0);
        new CrashReport("ThisIsFake", new Exception("Not real"));
    }

    public static String getBrandingVersion() {
        return "Minecraft Forge " + ForgeVersion.getVersion();
    }
}

