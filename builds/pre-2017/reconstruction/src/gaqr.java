/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;

public class gaqr
extends TileEntity {
    public float _a;
    public float _b;
    public int _c;
    public int _d;

    @Override
    public void updateEntity() {
        double d;
        super.updateEntity();
        if (++this._d % 20 * 4 == 0) {
            this.worldObj.addBlockEvent(this.xCoord, this.yCoord, this.zCoord, Block.enderChest.blockID, 1, this._c);
        }
        this._b = this._a;
        float f = 0.1f;
        if (this._c > 0 && this._a == 0.0f) {
            double d2 = (double)this.xCoord + 0.5;
            d = (double)this.zCoord + 0.5;
            this.worldObj.playSoundEffect(d2, (double)this.yCoord + 0.5, d, "random.chestopen", 0.5f, this.worldObj.rand.nextFloat() * 0.1f + 0.9f);
        }
        if (this._c == 0 && this._a > 0.0f || this._c > 0 && this._a < 1.0f) {
            float f2;
            float f3 = this._a;
            this._a = this._c > 0 ? (this._a += f) : (this._a -= f);
            if (this._a > 1.0f) {
                this._a = 1.0f;
            }
            if (this._a < (f2 = 0.5f) && f3 >= f2) {
                d = (double)this.xCoord + 0.5;
                double d3 = (double)this.zCoord + 0.5;
                this.worldObj.playSoundEffect(d, (double)this.yCoord + 0.5, d3, "random.chestclosed", 0.5f, this.worldObj.rand.nextFloat() * 0.1f + 0.9f);
            }
            if (this._a < 0.0f) {
                this._a = 0.0f;
            }
        }
    }

    @Override
    public boolean receiveClientEvent(int n, int n2) {
        if (n == 1) {
            this._c = n2;
            return true;
        }
        return super.receiveClientEvent(n, n2);
    }

    @Override
    public void invalidate() {
        this.updateContainingBlockInfo();
        super.invalidate();
    }

    public void _a() {
        ++this._c;
        this.worldObj.addBlockEvent(this.xCoord, this.yCoord, this.zCoord, Block.enderChest.blockID, 1, this._c);
    }

    public void _b() {
        --this._c;
        this.worldObj.addBlockEvent(this.xCoord, this.yCoord, this.zCoord, Block.enderChest.blockID, 1, this._c);
    }

    public boolean _a(EntityPlayer entityPlayer) {
        if (this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) != this) {
            return false;
        }
        return !(entityPlayer.getDistanceSq((double)this.xCoord + 0.5, (double)this.yCoord + 0.5, (double)this.zCoord + 0.5) > 64.0);
    }
}

