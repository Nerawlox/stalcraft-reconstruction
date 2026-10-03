/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.util.handler;

import carpentersblocks.util.handler.BedDesignHandler;
import carpentersblocks.util.handler.PatternHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.dwan;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.event.ForgeSubscribe;

public class IconHandler {
    @SideOnly(value=Side.CLIENT)
    public static dwan icon_generic;
    public static dwan icon_slope_oblique_pt_high;
    public static dwan icon_slope_oblique_pt_low;
    public static dwan icon_overlay_fast_grass_side;
    public static dwan icon_overlay_hay_side;
    public static dwan icon_overlay_snow_side;
    public static dwan icon_overlay_mycelium_side;
    public static dwan icon_slope;
    public static dwan icon_stairs;
    public static dwan icon_lever;
    public static dwan icon_door_screen_tall;
    public static dwan icon_door_glass_tall_top;
    public static dwan icon_door_glass_tall_bottom;
    public static dwan icon_door_glass_top;
    public static dwan icon_door_french_glass_top;
    public static dwan icon_door_french_glass_bottom;
    public static dwan icon_hatch_french_glass;
    public static dwan icon_hatch_glass;
    public static dwan icon_hatch_screen;
    public static dwan icon_bed_pillow;
    @SideOnly(value=Side.CLIENT)
    public static dwan[] icon_pattern;
    @SideOnly(value=Side.CLIENT)
    public static dwan[] icon_bed_pillow_custom;

    @ForgeSubscribe
    @SideOnly(value=Side.CLIENT)
    public void loadTextures(TextureStitchEvent.Pre pre) {
        if (pre.map._m == 0) {
            int n;
            icon_generic = pre.map._b("carpentersblocks:general/generic");
            icon_slope_oblique_pt_low = pre.map._b("carpentersblocks:slope/oblique_pt_low");
            icon_slope_oblique_pt_high = pre.map._b("carpentersblocks:slope/oblique_pt_high");
            icon_slope = pre.map._b("carpentersblocks:slope/slope");
            icon_stairs = pre.map._b("carpentersblocks:stairs/stairs");
            icon_lever = pre.map._b("carpentersblocks:lever/lever");
            icon_overlay_fast_grass_side = pre.map._b("carpentersblocks:overlay/overlay_fast_grass_side");
            icon_overlay_hay_side = pre.map._b("carpentersblocks:overlay/overlay_hay_side");
            icon_overlay_snow_side = pre.map._b("carpentersblocks:overlay/overlay_snow_side");
            icon_overlay_mycelium_side = pre.map._b("carpentersblocks:overlay/overlay_mycelium_side");
            for (n = 0; n < PatternHandler.maxNum; ++n) {
                if (!PatternHandler.hasPattern[n]) continue;
                IconHandler.icon_pattern[n] = pre.map._b("carpentersblocks:pattern/pattern_" + n);
            }
            for (n = 0; n < BedDesignHandler.maxNum; ++n) {
                if (!BedDesignHandler.hasPillow[n]) continue;
                IconHandler.icon_bed_pillow_custom[n] = pre.map._b("carpentersblocks:bed/design_" + n + "/pillow");
            }
            icon_door_screen_tall = pre.map._b("carpentersblocks:door/door_screen_tall");
            icon_door_glass_tall_top = pre.map._b("carpentersblocks:door/door_glass_tall_top");
            icon_door_glass_tall_bottom = pre.map._b("carpentersblocks:door/door_glass_tall_bottom");
            icon_door_glass_top = pre.map._b("carpentersblocks:door/door_glass_top");
            icon_door_french_glass_top = pre.map._b("carpentersblocks:door/door_french_glass_top");
            icon_door_french_glass_bottom = pre.map._b("carpentersblocks:door/door_french_glass_bottom");
            icon_hatch_glass = pre.map._b("carpentersblocks:hatch/hatch_glass");
            icon_hatch_french_glass = pre.map._b("carpentersblocks:hatch/hatch_french_glass");
            icon_hatch_screen = pre.map._b("carpentersblocks:hatch/hatch_screen");
            icon_bed_pillow = pre.map._b("carpentersblocks:bed/bed_pillow");
        }
    }

    static {
        icon_pattern = new dwan[PatternHandler.maxNum];
        icon_bed_pillow_custom = new dwan[BedDesignHandler.maxNum];
    }
}

