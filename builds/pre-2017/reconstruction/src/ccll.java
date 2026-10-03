/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.anomaly.qlgf;
import gloomyfolken.mods.core.main.GloomyCore;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class ccll
extends kkdx {
    public ccll(int n, qlgf qlgf2) {
        super(n, GloomyCore.fakeAir, qlgf2, "anomalies:coach", 0.05f);
        this.setUnlocalizedName("newCoach");
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new yclw();
    }
}

