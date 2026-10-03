/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.WorldSavedData;

public class thdd
extends WorldSavedData {
    public int _a;
    public int _b;
    public int _c;
    public byte _d;
    public byte[] _e = new byte[16384];
    public List _f = new ArrayList();
    public Map _g = new HashMap();
    public Map _h = new LinkedHashMap();

    public thdd(String string) {
        super(string);
    }

    @Override
    public void readFromNBT(NBTTagCompound nBTTagCompound) {
        NBTBase nBTBase = nBTTagCompound._b("dimension");
        this._c = nBTBase instanceof xsub ? (int)((xsub)nBTBase)._c : ((hdfw)nBTBase)._c;
        this._a = nBTTagCompound._f("xCenter");
        this._b = nBTTagCompound._f("zCenter");
        this._d = nBTTagCompound._d("scale");
        if (this._d < 0) {
            this._d = 0;
        }
        if (this._d > 4) {
            this._d = (byte)4;
        }
        int n = nBTTagCompound._e("width");
        int n2 = nBTTagCompound._e("height");
        if (n == 128 && n2 == 128) {
            this._e = nBTTagCompound._k("colors");
        } else {
            byte[] byArray = nBTTagCompound._k("colors");
            this._e = new byte[16384];
            int n3 = (128 - n) / 2;
            int n4 = (128 - n2) / 2;
            for (int i = 0; i < n2; ++i) {
                int n5 = i + n4;
                if (n5 < 0 && n5 >= 128) continue;
                for (int j = 0; j < n; ++j) {
                    int n6 = j + n3;
                    if (n6 < 0 && n6 >= 128) continue;
                    this._e[n6 + n5 * 128] = byArray[j + i * n];
                }
            }
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound nBTTagCompound) {
        nBTTagCompound._a("dimension", this._c);
        nBTTagCompound._a("xCenter", this._a);
        nBTTagCompound._a("zCenter", this._b);
        nBTTagCompound._a("scale", this._d);
        nBTTagCompound._a("width", (short)128);
        nBTTagCompound._a("height", (short)128);
        nBTTagCompound._a("colors", this._e);
    }

    public void _a(EntityPlayer entityPlayer, ItemStack itemStack) {
        if (!this._g.containsKey(entityPlayer)) {
            ihdx ihdx2 = new ihdx(this, entityPlayer);
            this._g.put(entityPlayer, ihdx2);
            this._f.add(ihdx2);
        }
        if (!entityPlayer.inventory._e(itemStack)) {
            this._h.remove(entityPlayer.getCommandSenderName());
        }
        for (int i = 0; i < this._f.size(); ++i) {
            ihdx ihdx3 = (ihdx)this._f.get(i);
            if (!ihdx3._a.isDead && (ihdx3._a.inventory._e(itemStack) || itemStack._A())) {
                if (itemStack._A() || ihdx3._a.dimension != this._c) continue;
                this._a(0, ihdx3._a.worldObj, ihdx3._a.getCommandSenderName(), ihdx3._a.posX, ihdx3._a.posZ, ihdx3._a.rotationYaw);
                continue;
            }
            this._g.remove(ihdx3._a);
            this._f.remove(ihdx3);
        }
        if (itemStack._A()) {
            this._a(1, entityPlayer.worldObj, "frame-" + itemStack._B().entityId, itemStack._B().xPosition, itemStack._B().zPosition, itemStack._B().hangingDirection * 90);
        }
    }

    public void _a(int n, World world, String string, double d, double d2, double d3) {
        byte by;
        int n2 = 1 << this._d;
        float f = (float)(d - (double)this._a) / (float)n2;
        float f2 = (float)(d2 - (double)this._b) / (float)n2;
        byte by2 = (byte)((double)(f * 2.0f) + 0.5);
        byte by3 = (byte)((double)(f2 * 2.0f) + 0.5);
        int n3 = 63;
        if (f >= (float)(-n3) && f2 >= (float)(-n3) && f <= (float)n3 && f2 <= (float)n3) {
            by = (byte)((d3 += d3 < 0.0 ? -8.0 : 8.0) * 16.0 / 360.0);
            if (world.provider._a(string, d, d2, d3)) {
                int n4 = (int)(world.getWorldInfo()._g() / 10L);
                by = (byte)(n4 * n4 * 34187121 + n4 * 121 >> 15 & 0xF);
            }
        } else {
            if (Math.abs(f) >= 320.0f || Math.abs(f2) >= 320.0f) {
                this._h.remove(string);
                return;
            }
            n = 6;
            by = 0;
            if (f <= (float)(-n3)) {
                by2 = (byte)((double)(n3 * 2) + 2.5);
            }
            if (f2 <= (float)(-n3)) {
                by3 = (byte)((double)(n3 * 2) + 2.5);
            }
            if (f >= (float)n3) {
                by2 = (byte)(n3 * 2 + 1);
            }
            if (f2 >= (float)n3) {
                by3 = (byte)(n3 * 2 + 1);
            }
        }
        this._h.put(string, new ozsr(this, (byte)n, by2, by3, by));
    }

    public byte[] _a(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
        ihdx ihdx2 = (ihdx)this._g.get(entityPlayer);
        return ihdx2 == null ? null : ihdx2._a(itemStack);
    }

    public void _a(int n, int n2, int n3) {
        super.markDirty();
        for (int i = 0; i < this._f.size(); ++i) {
            ihdx ihdx2 = (ihdx)this._f.get(i);
            if (ihdx2._b[n] < 0 || ihdx2._b[n] > n2) {
                ihdx2._b[n] = n2;
            }
            if (ihdx2._c[n] >= 0 && ihdx2._c[n] >= n3) continue;
            ihdx2._c[n] = n3;
        }
    }

    @SideOnly(value=Side.CLIENT)
    public void _a(byte[] byArray) {
        if (byArray[0] == 0) {
            int n = byArray[1] & 0xFF;
            int n2 = byArray[2] & 0xFF;
            for (int i = 0; i < byArray.length - 3; ++i) {
                this._e[(i + n2) * 128 + n] = byArray[i + 3];
            }
            this.markDirty();
        } else if (byArray[0] == 1) {
            this._h.clear();
            for (int i = 0; i < (byArray.length - 1) / 3; ++i) {
                byte by = (byte)(byArray[i * 3 + 1] >> 4);
                byte by2 = byArray[i * 3 + 2];
                byte by3 = byArray[i * 3 + 3];
                byte by4 = (byte)(byArray[i * 3 + 1] & 0xF);
                this._h.put("icon-" + i, new ozsr(this, by, by2, by3, by4));
            }
        } else if (byArray[0] == 2) {
            this._d = byArray[1];
        }
    }

    public ihdx _a(EntityPlayer entityPlayer) {
        ihdx ihdx2 = (ihdx)this._g.get(entityPlayer);
        if (ihdx2 == null) {
            ihdx2 = new ihdx(this, entityPlayer);
            this._g.put(entityPlayer, ihdx2);
            this._f.add(ihdx2);
        }
        return ihdx2;
    }
}

