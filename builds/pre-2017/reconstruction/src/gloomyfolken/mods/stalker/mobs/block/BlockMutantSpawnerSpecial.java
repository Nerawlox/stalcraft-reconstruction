/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.block;

import gloomyfolken.mods.stalker.mobs.block.BlockMutantSpawnerCommon;
import gloomyfolken.mods.stalker.mobs.player.MutantPlayerData;
import gloomyfolken.mods.stalker.mobs.tile.TileEntityMutantSpawnerSpecial;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class BlockMutantSpawnerSpecial
extends BlockMutantSpawnerCommon
implements stgn {
    public BlockMutantSpawnerSpecial(int n) {
        super(n);
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        this.blockIcon = iconRegister._b("stalker:transparent");
        this.setCreativeIcon(iconRegister._b("stalkermobs:spawnerspecial"));
    }

    @Override
    public boolean onBlockActivated(World world, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        MutantPlayerData mutantPlayerData;
        super.onBlockActivated(world, n, n2, n3, entityPlayer, n4, f, f2, f3);
        if (this.hasEditPermissions(entityPlayer) && !world.isRemote && (mutantPlayerData = MutantPlayerData.get(entityPlayer)) != null) {
            mutantPlayerData.onActivatedSpawner(world.getBlockTileEntity(n, n2, n3));
        }
        return true;
    }

    @Override
    protected bqyt createSpawnerTileEntity() {
        return new TileEntityMutantSpawnerSpecial();
    }
}

