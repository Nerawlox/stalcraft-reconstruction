/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.anomaly.qlgf;
import gloomyfolken.mods.core.main.GloomyCore;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class flvk
extends yckl {
    public flvk(int n, qlgf qlgf2) {
        super(n, GloomyCore.fakeAir, qlgf2, "anomalies:carousel", 0.05f);
        this.setUnlocalizedName("carousel");
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new ncmp();
    }
}

