/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  akc
 */
package ru.stalcraft.blocks;

import java.util.HashSet;
import ru.stalcraft.AnomalyDrop;
import ru.stalcraft.blocks.BlockAnomaly;

public abstract class BlockExtendedAnomaly
extends BlockAnomaly {
    public static HashSet extendedAnomalies = new HashSet();

    public BlockExtendedAnomaly(int par1, akc par2Material, AnomalyDrop drop, String soundName, float soundChance) {
        super(par1, par2Material, drop, soundName, soundChance);
        extendedAnomalies.add(par1);
    }

    public static boolean isExtendedAnomaly(int blockID) {
        return extendedAnomalies.contains(blockID);
    }

    public static double getDistanceSq(int x2, int y2, int z2, nn entity) {
        return entity.e((double)x2 + 0.5, y2, (double)z2 + 0.5);
    }
}

