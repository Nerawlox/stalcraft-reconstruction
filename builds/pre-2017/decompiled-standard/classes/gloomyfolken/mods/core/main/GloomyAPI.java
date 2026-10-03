/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.main;

import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.asm.PathModifier;
import gloomyfolken.mods.core.client.gui.screens.GuiModGameOptions;
import gloomyfolken.mods.core.client.gui.screens.GuiModPerformanceOptions;
import gloomyfolken.mods.core.client.gui.screens.GuiModSoundOptions;
import gloomyfolken.mods.core.client.gui.screens.GuiModVideoOptions;
import gloomyfolken.mods.core.main.ClientProxy;
import gloomyfolken.mods.core.main.GloomyCore;

public class GloomyAPI {
    public static void registerItemType(mqrl mqrl2) {
        GloomyCore.instance.itemsLoader._a(mqrl2);
    }

    public static void registerItemTypes(mqrl ... mqrlArray) {
        for (mqrl mqrl2 : mqrlArray) {
            GloomyCore.instance.itemsLoader._a(mqrl2);
        }
    }

    public static void registerAssetsDir(String string, Class clazz) {
        GloomyCore.instance.assetDirs.put(string, clazz);
        PathModifier._a.put(string, clazz);
    }

    public static void setContainerFactory(yctv yctv2) {
        GloomyCore.instance.containerFactory = yctv2;
    }

    @ezey(_a={eidj.CLIENT})
    public static void registerGameHandler(nttf nttf2) {
        ((ClientProxy)GloomyCore.proxy).registerGameHandler(nttf2);
    }

    @ezey(_a={eidj.CLIENT})
    public static net.minecraft.client.settings.eidj registerKeyBinding(net.minecraft.client.settings.eidj eidj2, ofux ofux2) {
        return ((ClientProxy)GloomyCore.proxy).addKeyBinding(eidj2, ofux2);
    }

    @ezey(_a={eidj.CLIENT})
    public static void registerOption(anpn anpn2) {
        anpn2.load(GloomyCore.mcconfig);
        GuiModGameOptions.options.add(anpn2);
    }

    @ezey(_a={eidj.CLIENT})
    public static void registerVideoOption(anpn anpn2) {
        anpn2.load(GloomyCore.mcconfig);
        GuiModVideoOptions.options.add(anpn2);
    }

    @ezey(_a={eidj.CLIENT})
    public static void registerPerformanceOption(anpn anpn2) {
        anpn2.load(GloomyCore.mcconfig);
        GuiModPerformanceOptions.options.add(anpn2);
    }

    @ezey(_a={eidj.CLIENT})
    public static void registerSoundOption(anpn anpn2) {
        anpn2.load(GloomyCore.mcconfig);
        GuiModSoundOptions.options.add(anpn2);
    }
}

