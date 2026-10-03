/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  ake
 *  ali
 *  alj
 *  all
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  dr
 *  wv
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;

public class yh
extends wv {
    protected yh(int par1) {
        super(par1);
        this.a(true);
    }

    @SideOnly(value=Side.CLIENT)
    public static ali a(short par0, abw par1World) {
        String s2 = "map_" + par0;
        ali mapdata = (ali)par1World.a(ali.class, s2);
        if (mapdata == null) {
            mapdata = new ali(s2);
            par1World.a(s2, (all)mapdata);
        }
        return mapdata;
    }

    public ali a(ye par1ItemStack, abw par2World) {
        String s2 = "map_" + par1ItemStack.k();
        ali mapdata = (ali)par2World.a(ali.class, s2);
        if (mapdata == null && !par2World.I) {
            par1ItemStack.b(par2World.b("map"));
            s2 = "map_" + par1ItemStack.k();
            mapdata = new ali(s2);
            mapdata.d = (byte)3;
            int i2 = 128 * (1 << mapdata.d);
            mapdata.a = Math.round((float)par2World.N().c() / (float)i2) * i2;
            mapdata.b = Math.round(par2World.N().e() / i2) * i2;
            mapdata.c = par2World.t.i;
            mapdata.c();
            par2World.a(s2, (all)mapdata);
        }
        return mapdata;
    }

    public void a(abw par1World, nn par2Entity, ali par3MapData) {
        if (par1World.t.i == par3MapData.c && par2Entity instanceof uf) {
            int short1 = 128;
            int short2 = 128;
            int i2 = 1 << par3MapData.d;
            int j2 = par3MapData.a;
            int k2 = par3MapData.b;
            int l2 = ls.c(par2Entity.u - (double)j2) / i2 + short1 / 2;
            int i1 = ls.c(par2Entity.w - (double)k2) / i2 + short2 / 2;
            int j1 = 128 / i2;
            if (par1World.t.g) {
                j1 /= 2;
            }
            alj mapinfo = par3MapData.a((uf)par2Entity);
            ++mapinfo.d;
            for (int k1 = l2 - j1 + 1; k1 < l2 + j1; ++k1) {
                if ((k1 & 0xF) != (mapinfo.d & 0xF)) continue;
                int l1 = 255;
                int i22 = 0;
                double d0 = 0.0;
                for (int j22 = i1 - j1 - 1; j22 < i1 + j1; ++j22) {
                    byte b2;
                    byte b1;
                    int i5;
                    int l4;
                    int k4;
                    int j4;
                    if (k1 < 0 || j22 < -1 || k1 >= short1 || j22 >= short2) continue;
                    int k22 = k1 - l2;
                    int l22 = j22 - i1;
                    boolean flag = k22 * k22 + l22 * l22 > (j1 - 2) * (j1 - 2);
                    int i3 = (j2 / i2 + k1 - short1 / 2) * i2;
                    int j3 = (k2 / i2 + j22 - short2 / 2) * i2;
                    int[] aint = new int[aqz.s.length];
                    adr chunk = par1World.d(i3, j3);
                    if (chunk.g()) continue;
                    int k3 = i3 & 0xF;
                    int l3 = j3 & 0xF;
                    int i4 = 0;
                    double d1 = 0.0;
                    if (par1World.t.g) {
                        j4 = i3 + j3 * 231871;
                        if (((j4 = j4 * j4 * 31287121 + j4 * 11) >> 20 & 1) == 0) {
                            int n2 = aqz.A.cF;
                            aint[n2] = aint[n2] + 10;
                        } else {
                            int n3 = aqz.y.cF;
                            aint[n3] = aint[n3] + 10;
                        }
                        d1 = 100.0;
                    } else {
                        for (j4 = 0; j4 < i2; ++j4) {
                            for (k4 = 0; k4 < i2; ++k4) {
                                l4 = chunk.b(j4 + k3, k4 + l3) + 1;
                                int j5 = 0;
                                if (l4 > 1) {
                                    boolean flag1;
                                    do {
                                        flag1 = true;
                                        j5 = chunk.a(j4 + k3, l4 - 1, k4 + l3);
                                        if (j5 == 0) {
                                            flag1 = false;
                                        } else if (l4 > 0 && j5 > 0 && aqz.s[j5].cU.H == ake.b) {
                                            flag1 = false;
                                        }
                                        if (flag1) continue;
                                        if (--l4 <= 0) break;
                                        j5 = chunk.a(j4 + k3, l4 - 1, k4 + l3);
                                    } while (l4 > 0 && !flag1);
                                    if (l4 > 0 && j5 != 0 && aqz.s[j5].cU.d()) {
                                        int k5;
                                        i5 = l4 - 1;
                                        boolean flag2 = false;
                                        do {
                                            k5 = chunk.a(j4 + k3, i5--, k4 + l3);
                                            ++i4;
                                        } while (i5 > 0 && k5 != 0 && aqz.s[k5].cU.d());
                                    }
                                }
                                d1 += (double)l4 / (double)(i2 * i2);
                                int n4 = j5;
                                aint[n4] = aint[n4] + 1;
                            }
                        }
                    }
                    i4 /= i2 * i2;
                    j4 = 0;
                    k4 = 0;
                    for (l4 = 0; l4 < aqz.s.length; ++l4) {
                        if (aint[l4] <= j4) continue;
                        k4 = l4;
                        j4 = aint[l4];
                    }
                    double d2 = (d1 - d0) * 4.0 / (double)(i2 + 4) + ((double)(k1 + j22 & 1) - 0.5) * 0.4;
                    int b0 = 1;
                    if (d2 > 0.6) {
                        b0 = 2;
                    }
                    if (d2 < -0.6) {
                        b0 = 0;
                    }
                    i5 = 0;
                    if (k4 > 0) {
                        ake mapcolor = aqz.s[k4].cU.H;
                        if (mapcolor == ake.n) {
                            d2 = (double)i4 * 0.1 + (double)(k1 + j22 & 1) * 0.2;
                            b0 = 1;
                            if (d2 < 0.5) {
                                b0 = 2;
                            }
                            if (d2 > 0.9) {
                                b0 = 0;
                            }
                        }
                        i5 = mapcolor.q;
                    }
                    d0 = d1;
                    if (j22 < 0 || k22 * k22 + l22 * l22 >= j1 * j1 || flag && (k1 + j22 & 1) == 0 || (b1 = par3MapData.e[k1 + j22 * short1]) == (b2 = (byte)(i5 * 4 + b0))) continue;
                    if (l1 > j22) {
                        l1 = j22;
                    }
                    if (i22 < j22) {
                        i22 = j22;
                    }
                    par3MapData.e[k1 + j22 * short1] = b2;
                }
                if (l1 > i22) continue;
                par3MapData.a(k1, l1, i22);
            }
        }
    }

    public void a(ye par1ItemStack, abw par2World, nn par3Entity, int par4, boolean par5) {
        if (!par2World.I) {
            ali mapdata = this.a(par1ItemStack, par2World);
            if (par3Entity instanceof uf) {
                uf entityplayer = (uf)par3Entity;
                mapdata.a(entityplayer, par1ItemStack);
            }
            if (par5) {
                this.a(par2World, par3Entity, mapdata);
            }
        }
    }

    public ey c(ye par1ItemStack, abw par2World, uf par3EntityPlayer) {
        byte[] abyte = this.a(par1ItemStack, par2World).a(par1ItemStack, par2World, par3EntityPlayer);
        return abyte == null ? null : new dr((short)yc.bf.cv, (short)par1ItemStack.k(), abyte);
    }

    public void d(ye par1ItemStack, abw par2World, uf par3EntityPlayer) {
        if (par1ItemStack.p() && par1ItemStack.q().n("map_is_scaling")) {
            ali mapdata = yc.bf.a(par1ItemStack, par2World);
            par1ItemStack.b(par2World.b("map"));
            ali mapdata1 = new ali("map_" + par1ItemStack.k());
            mapdata1.d = (byte)(mapdata.d + 1);
            if (mapdata1.d > 4) {
                mapdata1.d = (byte)4;
            }
            mapdata1.a = mapdata.a;
            mapdata1.b = mapdata.b;
            mapdata1.c = mapdata.c;
            mapdata1.c();
            par2World.a("map_" + par1ItemStack.k(), (all)mapdata1);
        }
    }

    @SideOnly(value=Side.CLIENT)
    public void a(ye par1ItemStack, uf par2EntityPlayer, List par3List, boolean par4) {
        ali mapdata = this.a(par1ItemStack, par2EntityPlayer.q);
        if (par4) {
            if (mapdata == null) {
                par3List.add("Unknown map");
            } else {
                par3List.add("Scaling at 1:" + (1 << mapdata.d));
                par3List.add("(Level " + mapdata.d + "/" + 4 + ")");
            }
        }
    }
}

