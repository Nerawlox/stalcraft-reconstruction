/*
 * Decompiled with CFR 0.152.
 */
package ru.stalcraft.blocks;

import java.util.ArrayList;
import ru.stalcraft.AnomalyDrop;
import ru.stalcraft.StalkerMain;
import ru.stalcraft.blocks.BlockAnomaly;
import ru.stalcraft.tile.TileEntityCoach;

public class BlockCoach
extends BlockAnomaly {
    private ArrayList targets = new ArrayList();

    public BlockCoach(int par1, AnomalyDrop drop) {
        super(par1, StalkerMain.fakeAir, drop, "stalker:coach", 0.05f);
    }

    @Override
    public void a(abw par1World, int par2, int par3, int par4, nn par5Entity) {
        if (!par1World.I && par5Entity instanceof uf) {
            uf entity = (uf)par5Entity;
            entity.am();
            ((TileEntityCoach)par1World.r(par2, par3, par4)).addTarget(entity);
        }
    }

    public asp b(abw world) {
        return new TileEntityCoach();
    }
}

