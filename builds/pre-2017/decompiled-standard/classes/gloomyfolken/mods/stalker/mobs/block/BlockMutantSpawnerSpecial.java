/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.block;

import gloomyfolken.mods.stalker.mobs.block.BlockMutantSpawnerCommon;
import gloomyfolken.mods.stalker.mobs.player.MutantPlayerData;
import gloomyfolken.mods.stalker.mobs.tile.TileEntityMutantSpawnerSpecial;
import net.minecraft.entity.player.EntityPlayer;

public class BlockMutantSpawnerSpecial
extends BlockMutantSpawnerCommon
implements stgn {
    public BlockMutantSpawnerSpecial(int n) {
        super(n);
    }

    @Override
    public void func_94332_a(nege nege2) {
        this.field_94336_cN = nege2._b("stalker:transparent");
        this.setCreativeIcon(nege2._b("stalkermobs:spawnerspecial"));
    }

    @Override
    public boolean func_71903_a(ozlu ozlu2, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        MutantPlayerData mutantPlayerData;
        super.func_71903_a(ozlu2, n, n2, n3, entityPlayer, n4, f, f2, f3);
        if (this.hasEditPermissions(entityPlayer) && !ozlu2.field_72995_K && (mutantPlayerData = MutantPlayerData.get(entityPlayer)) != null) {
            mutantPlayerData.onActivatedSpawner(ozlu2.func_72796_p(n, n2, n3));
        }
        return true;
    }

    @Override
    protected bqyt createSpawnerTileEntity() {
        return new TileEntityMutantSpawnerSpecial();
    }
}

