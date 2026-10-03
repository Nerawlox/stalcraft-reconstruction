/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.bettergrassandleaves.renderer;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import poersch.minecraft.bettergrassandleaves.BetterGrassAndLeavesMod;
import poersch.minecraft.bettergrassandleaves.entity.EntityBloodDropsFX;
import poersch.minecraft.bettergrassandleaves.interfaces.IBetterBlood;
import poersch.minecraft.bettergrassandleaves.renderer.BlockRenderer;

public class BetterBloodRenderer
extends BlockRenderer {
    public static Icon[] iconBloodDrops;
    public static Icon[] iconBloodStains;
    protected static Map<Class, Integer> colorMap;

    @Override
    public void onRegisterIcons(IconRegister iconRegister) {
        iconBloodDrops = BetterBloodRenderer.registerBlockIcons("blood_drops");
        iconBloodStains = BetterBloodRenderer.registerBlockIcons("blood_stains");
    }

    @Override
    public boolean onSpawnParticle(String string, World world, double d, double d2, double d3, double d4, double d5, double d6, Entity entity) {
        if (((Boolean)BetterGrassAndLeavesMod.bloodFX.value).booleanValue() && entity != null && entity instanceof IBetterBlood) {
            int n = ((IBetterBlood)entity).getColorBetterBlood();
            if (n == -1) {
                return true;
            }
            Icon icon = iconBloodDrops[(int)(Math.random() * (double)(iconBloodDrops.length - 1) + 0.5)];
            Icon icon2 = iconBloodStains[(int)(Math.random() * (double)(iconBloodStains.length - 1) + 0.5)];
            if (icon != null && icon2 != null) {
                Minecraft minecraft = this.minecraft;
                this.minecraft._w._a(new EntityBloodDropsFX((World)Minecraft._E()._r, d, d2 + 0.5, d3, n, icon, icon2));
                return true;
            }
            return true;
        }
        return false;
    }

    public static void resetBloodColors() {
        colorMap.clear();
    }

    public static void setColorBetterBlood(Class clazz, int n) {
        colorMap.put(clazz, n);
    }

    public static int getColorBetterBlood(Class clazz) {
        Integer n = colorMap.get(clazz);
        return n != null ? n : 0xFF0000;
    }

    static {
        colorMap = new HashMap<Class, Integer>();
    }
}

