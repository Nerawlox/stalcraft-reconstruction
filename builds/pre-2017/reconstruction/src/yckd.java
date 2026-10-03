/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.anomaly.qlgf;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class yckd
extends uybl {
    public yckd(int n, qlgf qlgf2) {
        super(n, qlgf2, "teleport_bubble");
    }

    @Override
    public jydd _a(World world) {
        return new ivab();
    }

    @Override
    public /* synthetic */ TileEntity createNewTileEntity(World world) {
        return this._a(world);
    }
}

