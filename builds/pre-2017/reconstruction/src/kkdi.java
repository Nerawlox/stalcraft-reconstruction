/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.anomaly.qlgf;
import gloomyfolken.mods.core.main.GloomyCore;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class kkdi
extends kkdx {
    public kkdi(int n, qlgf qlgf2) {
        super(n, GloomyCore.fakeAir, qlgf2, "anomalies:blackhole", 0.01f);
        GloomyCore.instance.airBlocks.add(this.blockID);
        this.setUnlocalizedName("hole");
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new mqkr();
    }
}

