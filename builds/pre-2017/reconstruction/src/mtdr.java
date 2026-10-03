/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class mtdr
extends TileEntity {
    public int _a;
    public float _b;
    public float _c;
    public float _d;
    public float _e;
    public float _f;
    public float _g;
    public float _h;
    public float _i;
    public float _j;
    public static Random _k = new Random();
    public String _l;

    @Override
    public void writeToNBT(NBTTagCompound nBTTagCompound) {
        super.writeToNBT(nBTTagCompound);
        if (this._b()) {
            nBTTagCompound._a("CustomName", this._l);
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound nBTTagCompound) {
        super.readFromNBT(nBTTagCompound);
        if (nBTTagCompound._c("CustomName")) {
            this._l = nBTTagCompound._j("CustomName");
        }
    }

    @Override
    public void updateEntity() {
        float f;
        super.updateEntity();
        this._g = this._f;
        this._i = this._h;
        EntityPlayer entityPlayer = this.worldObj.getClosestPlayer((float)this.xCoord + 0.5f, (float)this.yCoord + 0.5f, (float)this.zCoord + 0.5f, 3.0);
        if (entityPlayer != null) {
            double d = entityPlayer.posX - (double)((float)this.xCoord + 0.5f);
            double d2 = entityPlayer.posZ - (double)((float)this.zCoord + 0.5f);
            this._j = (float)Math.atan2(d2, d);
            this._f += 0.1f;
            if (this._f < 0.5f || _k.nextInt(40) == 0) {
                float f2 = this._d;
                do {
                    this._d += (float)(_k.nextInt(4) - _k.nextInt(4));
                } while (f2 == this._d);
            }
        } else {
            this._j += 0.02f;
            this._f -= 0.1f;
        }
        while (this._h >= (float)Math.PI) {
            this._h -= (float)Math.PI * 2;
        }
        while (this._h < (float)(-Math.PI)) {
            this._h += (float)Math.PI * 2;
        }
        while (this._j >= (float)Math.PI) {
            this._j -= (float)Math.PI * 2;
        }
        while (this._j < (float)(-Math.PI)) {
            this._j += (float)Math.PI * 2;
        }
        for (f = this._j - this._h; f >= (float)Math.PI; f -= (float)Math.PI * 2) {
        }
        while (f < (float)(-Math.PI)) {
            f += (float)Math.PI * 2;
        }
        this._h += f * 0.4f;
        if (this._f < 0.0f) {
            this._f = 0.0f;
        }
        if (this._f > 1.0f) {
            this._f = 1.0f;
        }
        ++this._a;
        this._c = this._b;
        float f3 = (this._d - this._b) * 0.4f;
        float f4 = 0.2f;
        if (f3 < -f4) {
            f3 = -f4;
        }
        if (f3 > f4) {
            f3 = f4;
        }
        this._e += (f3 - this._e) * 0.9f;
        this._b += this._e;
    }

    public String _a() {
        return this._b() ? this._l : "container.enchant";
    }

    public boolean _b() {
        return this._l != null && this._l.length() > 0;
    }

    public void _a(String string) {
        this._l = string;
    }
}

