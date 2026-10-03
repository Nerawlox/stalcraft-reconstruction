/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.registry.LanguageRegistry
 */
package ru.stalcraft.items;

import cpw.mods.fml.common.registry.LanguageRegistry;
import java.util.HashSet;
import ru.stalcraft.StalkerMain;
import ru.stalcraft.entity.EntityExplosive;

public class ItemExplosive
extends yc {
    private static HashSet canExplode = new HashSet();

    public ItemExplosive(int par1) {
        super(par1);
        this.a(StalkerMain.tab);
        this.b("stalker_explosive");
        this.d("stalker:explosive");
        LanguageRegistry.addName((Object)this, (String)"\u0412\u0437\u0440\u044b\u0432\u0447\u0430\u0442\u043a\u0430");
    }

    public void applyExplosibleBlocks(HashSet blocks) {
        canExplode = blocks;
    }

    public static boolean isBlockExplosible(int id) {
        return canExplode.contains(id);
    }

    @Override
    public boolean a(ye stack, uf player, abw world, int x2, int y2, int z2, int side, float x1, float y1, float z1) {
        if (!canExplode.contains(world.a(x2, y2, z2))) {
            return false;
        }
        if (!(world.I || StalkerMain.flagManager.getLand(player.ar, x2, z2) == null && StalkerMain.flagManager.getFlagNearby(player.ar, x2, z2) == null)) {
            EntityExplosive entity = new EntityExplosive(world);
            entity.applyAttributes(side, x2, y2, z2);
            if (side == 0) {
                y1 = (float)((double)y1 - 0.0225);
            }
            if (side == 1) {
                y1 = (float)((double)y1 + 0.0225);
            }
            if (side == 2) {
                z1 = (float)((double)z1 - 0.0225);
            }
            if (side == 3) {
                z1 = (float)((double)z1 + 0.0225);
            }
            if (side == 4) {
                x1 = (float)((double)x1 - 0.0225);
            }
            if (side == 5) {
                x1 = (float)((double)x1 + 0.0225);
            }
            entity.b((float)x2 + x1, (float)y2 + y1, (float)z2 + z1);
            world.d(entity);
            --stack.b;
            return true;
        }
        return false;
    }
}

