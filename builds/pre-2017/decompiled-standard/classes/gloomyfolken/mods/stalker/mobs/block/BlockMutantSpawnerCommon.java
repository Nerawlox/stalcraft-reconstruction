/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.block;

import gloomyfolken.mods.stalker.mobs.client.gui.GuiMutantSpawnerSettings;
import gloomyfolken.mods.stalker.mobs.tile.TileEntityMutantSpawner;
import net.minecraft.client.xpzm;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;

public class BlockMutantSpawnerCommon
extends ieal {
    public BlockMutantSpawnerCommon(int n) {
        super(n);
    }

    @Override
    protected bqyt createSpawnerTileEntity() {
        return new TileEntityMutantSpawner();
    }

    @Override
    protected void openEditGui(ozlu ozlu2, int n, int n2, int n3) {
        xpzm._E()._a(new GuiMutantSpawnerSettings(ozlu2, n, n2, n3));
    }

    @Override
    public void func_94332_a(nege nege2) {
        this.field_94336_cN = nege2._b("stalker:transparent");
        this.setCreativeIcon(nege2._b("stalkermobs:spawner"));
    }

    @Override
    public void func_71860_a(ozlu ozlu2, int n, int n2, int n3, EntityLivingBase entityLivingBase, cvzo cvzo2) {
        hurg hurg2 = ozlu2.func_72796_p(n, n2, n3);
        if (hurg2 instanceof TileEntityMutantSpawner && entityLivingBase instanceof EntityPlayerMP) {
            ((TileEntityMutantSpawner)hurg2).placeTile(n, n2, n3);
            if (((TileEntityMutantSpawner)hurg2).getAuthor() == null) {
                ((TileEntityMutantSpawner)hurg2).setAuthor(((EntityPlayerMP)entityLivingBase).func_70005_c_());
            }
        }
    }
}

