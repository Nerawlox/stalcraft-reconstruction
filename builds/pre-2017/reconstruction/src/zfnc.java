/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.anomaly.qlgf;
import gloomyfolken.mods.core.main.GloomyCore;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class zfnc
extends zwpb {
    public zfnc(int n, qlgf qlgf2) {
        super(n, GloomyCore.fakeAir, qlgf2, "anomalies:lighter", 0.0f);
        this.setUnlocalizedName("lighter");
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new ivaa();
    }
}

