/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.common;

import java.util.ArrayList;
import java.util.Random;
import net.minecraft.util.iurq;
import net.minecraft.util.piet;

public class DungeonHooks {
    private static ArrayList<DungeonMob> dungeonMobs = new ArrayList();

    public static float addDungeonMob(String string, int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Rarity must be greater then zero");
        }
        for (DungeonMob dungeonMob : dungeonMobs) {
            if (!string.equals(dungeonMob.type)) continue;
            return dungeonMob.itemWeight += n;
        }
        dungeonMobs.add(new DungeonMob(n, string));
        return n;
    }

    public static int removeDungeonMob(String string) {
        for (DungeonMob dungeonMob : dungeonMobs) {
            if (!string.equals(dungeonMob.type)) continue;
            dungeonMobs.remove(dungeonMob);
            return dungeonMob.itemWeight;
        }
        return 0;
    }

    public static String getRandomDungeonMob(Random random) {
        DungeonMob dungeonMob = (DungeonMob)iurq._a(random, dungeonMobs);
        if (dungeonMob == null) {
            return "";
        }
        return dungeonMob.type;
    }

    static {
        DungeonHooks.addDungeonMob("Skeleton", 100);
        DungeonHooks.addDungeonMob("Zombie", 200);
        DungeonHooks.addDungeonMob("Spider", 100);
    }

    public static class DungeonMob
    extends piet {
        public String type;

        public DungeonMob(int n, String string) {
            super(n);
            this.type = string;
        }

        public boolean equals(Object object) {
            return object instanceof DungeonMob && this.type.equals(((DungeonMob)object).type);
        }
    }
}

