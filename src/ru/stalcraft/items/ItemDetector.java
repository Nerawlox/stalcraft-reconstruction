/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.registry.LanguageRegistry
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  mt
 */
package ru.stalcraft.items;

import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ru.stalcraft.StalkerMain;

public class ItemDetector
extends yc {
    private int[] blockIds;
    private final int radius = 5;
    private String textureName;
    private static final int R = 15;

    public ItemDetector(int id, int[] blockIds, String textureName, String localizedName) {
        super(id);
        this.blockIds = blockIds;
        this.textureName = textureName;
        this.a(StalkerMain.tab);
        this.b(textureName);
        LanguageRegistry.addName((Object)this, (String)localizedName);
    }

    public float detectLevel(abw world, double x2, double y2, double z2) {
        float currentLevel = 0.0f;
        int posX = (int)x2;
        int posY = (int)y2;
        int posZ = (int)z2;
        for (int curX = posX - 15; curX <= posX + 15; ++curX) {
            for (int curY = posY - 15; curY <= posY + 15; ++curY) {
                for (int curZ = posZ - 15; curZ <= posZ + 15; ++curZ) {
                    currentLevel = (float)((double)currentLevel + (double)this.getBlockLevel(world, curX, curY, curZ) / Math.max(1.0, this.distance(x2, y2, z2, curX, curY, curZ)));
                }
            }
        }
        return currentLevel;
    }

    private double distance(double xPlayer, double yPlayer, double zPlayer, int xBlock, int yBlock, int zBlock) {
        double deltaX = (double)xBlock - xPlayer;
        double deltaY = (double)yBlock - yPlayer;
        double deltaZ = (double)zBlock - zPlayer;
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY + deltaZ * deltaZ);
    }

    private int getBlockLevel(abw world, int posX, int posY, int posZ) {
        int blockId = world.a(posX, posY, posZ);
        for (int i2 = 0; i2 < this.blockIds.length; ++i2) {
            if (blockId != this.blockIds[i2]) continue;
            return i2 + 1;
        }
        return 0;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void a(mt par1IconRegister) {
        this.cz = par1IconRegister.a("stalker:" + this.textureName);
    }
}

