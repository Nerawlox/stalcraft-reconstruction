/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.asm.Logger;
import gloomyfolken.mods.core.main.GloomyCore;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.List;

public class zwrx {
    public static void _a() {
        String string = "50, 63, 65, 68, 75, 76, 78, 85, 106, 107, 132";
        Object object = GloomyCore.instance.airBlocks.iterator();
        while (object.hasNext()) {
            int n = object.next();
            string = string + ", " + n;
        }
        try {
            object = Class.forName("poersch.minecraft.bettergrassandleaves.BetterGrassAndLeavesMod");
            Class<?> clazz = Class.forName("poersch.minecraft.util.options.OptionBitList");
            Constructor<?> constructor = clazz.getConstructor(List.class, String.class, String.class, String.class, String.class, Boolean.TYPE, Integer.TYPE);
            Field field = ((Class)object).getDeclaredField("modOptions");
            Object obj = constructor.newInstance(field.get(null), "allowBetterGrass", "Allow Better Grass", "The listed block IDs will allow Better Grass to render under them. (e.g. allowBetterGrass=0, 10, 20)", string, false, 4096);
            Field field2 = ((Class)object).getDeclaredField("allowBetterGrass");
            field2.set(null, obj);
            Logger.finest("BetterGrass found", new Object[0]);
        }
        catch (Exception exception) {
            Logger.finest("BetterGrass not found", new Object[0]);
        }
    }
}

