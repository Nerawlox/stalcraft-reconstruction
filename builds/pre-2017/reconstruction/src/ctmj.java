/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.anomaly.qlgf;
import gloomyfolken.mods.core.main.GloomyCore;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class ctmj
extends yckl {
    public ctmj(int n, qlgf qlgf2) {
        super(n, GloomyCore.fakeAir, qlgf2, "anomalies:trampoline", 0.05f);
        this.setUnlocalizedName("tramp");
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new hsai();
    }
}

