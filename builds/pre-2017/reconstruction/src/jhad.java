/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.anomaly.qlgf;
import gloomyfolken.mods.core.main.GloomyCore;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class jhad
extends yckl {
    public jhad(int n, qlgf qlgf2) {
        super(n, GloomyCore.fakeAir, qlgf2, "anomalies:electra", 0.07f);
        GloomyCore.instance.airBlocks.add(this.blockID);
        this.setUnlocalizedName("electra");
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new wnhj();
    }

    @Override
    public int getLightValue(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        return 10;
    }
}

