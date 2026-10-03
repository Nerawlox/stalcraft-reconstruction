/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.block.Block;
import net.minecraft.tileentity.MobSpawnerBaseLogic;
import net.minecraft.tileentity.WeightedRandomMinecart;
import net.minecraft.world.World;

public class zzis
extends MobSpawnerBaseLogic {
    public final /* synthetic */ xtcq _a;

    public zzis(xtcq xtcq2) {
        this._a = xtcq2;
    }

    @Override
    public void _a(int n) {
        this._a.worldObj.addBlockEvent(this._a.xCoord, this._a.yCoord, this._a.zCoord, Block.mobSpawner.blockID, n, 0);
    }

    @Override
    public World _a() {
        return this._a.worldObj;
    }

    @Override
    public int _b() {
        return this._a.xCoord;
    }

    @Override
    public int _c() {
        return this._a.yCoord;
    }

    @Override
    public int _d() {
        return this._a.zCoord;
    }

    @Override
    public void _a(WeightedRandomMinecart weightedRandomMinecart) {
        super._a(weightedRandomMinecart);
        if (this._a() != null) {
            this._a().markBlockForUpdate(this._a.xCoord, this._a.yCoord, this._a.zCoord);
        }
    }
}

