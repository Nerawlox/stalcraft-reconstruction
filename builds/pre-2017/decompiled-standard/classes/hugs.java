/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.dwan;
import net.minecraft.util.sajh;
import net.minecraftforge.common.FakePlayerFactory;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.entity.player.BonemealEvent;

public class hugs
extends tgdv {
    public static final String[] _a = new String[]{"black", "red", "green", "brown", "blue", "purple", "cyan", "silver", "gray", "pink", "lime", "yellow", "lightBlue", "magenta", "orange", "white"};
    public static final String[] _b = new String[]{"black", "red", "green", "brown", "blue", "purple", "cyan", "silver", "gray", "pink", "lime", "yellow", "light_blue", "magenta", "orange", "white"};
    public static final int[] _c = new int[]{0x1E1B1B, 11743532, 3887386, 5320730, 2437522, 8073150, 2651799, 0xABABAB, 0x434343, 14188952, 4312372, 14602026, 6719955, 12801229, 15435844, 0xF0F0F0};
    @SideOnly(value=Side.CLIENT)
    public dwan[] _d;

    public hugs(int n) {
        super(n);
        this.func_77627_a(true);
        this.func_77656_e(0);
        this.func_77637_a(tgbl.field_78035_l);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public dwan func_77617_a(int n) {
        int n2 = sajh._a(n, 0, 15);
        return this._d[n2];
    }

    @Override
    public String func_77667_c(cvzo cvzo2) {
        int n = sajh._a(cvzo2._j(), 0, 15);
        return super.func_77658_a() + "." + _a[n];
    }

    @Override
    public boolean func_77648_a(cvzo cvzo2, EntityPlayer entityPlayer, ozlu ozlu2, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        if (!entityPlayer.func_82247_a(n, n2, n3, n4, cvzo2)) {
            return false;
        }
        if (cvzo2._j() == 15) {
            if (hugs._a(cvzo2, ozlu2, n, n2, n3, entityPlayer)) {
                if (!ozlu2.field_72995_K) {
                    ozlu2.func_72926_e(2005, n, n2, n3, 0);
                }
                return true;
            }
        } else if (cvzo2._j() == 3) {
            int n5 = ozlu2.func_72798_a(n, n2, n3);
            int n6 = ozlu2.func_72805_g(n, n2, n3);
            if (n5 == twgu.field_71951_J.field_71990_ca && zxyw._c(n6) == 3) {
                if (n4 == 0) {
                    return false;
                }
                if (n4 == 1) {
                    return false;
                }
                if (n4 == 2) {
                    --n3;
                }
                if (n4 == 3) {
                    ++n3;
                }
                if (n4 == 4) {
                    --n;
                }
                if (n4 == 5) {
                    ++n;
                }
                if (ozlu2.func_72799_c(n, n2, n3)) {
                    int n7 = twgu.field_71973_m[twgu.field_72086_bP.field_71990_ca].func_85104_a(ozlu2, n, n2, n3, n4, f, f2, f3, 0);
                    ozlu2.func_72832_d(n, n2, n3, twgu.field_72086_bP.field_71990_ca, n7, 2);
                    if (!entityPlayer.field_71075_bZ._d) {
                        --cvzo2._b;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static boolean _a(cvzo cvzo2, ozlu ozlu2, int n, int n2, int n3) {
        return hugs._a(cvzo2, ozlu2, n, n2, n3, FakePlayerFactory.getMinecraft(ozlu2));
    }

    public static boolean _a(cvzo cvzo2, ozlu ozlu2, int n, int n2, int n3, EntityPlayer entityPlayer) {
        int n4 = ozlu2.func_72798_a(n, n2, n3);
        BonemealEvent bonemealEvent = new BonemealEvent(entityPlayer, ozlu2, n4, n, n2, n3);
        if (MinecraftForge.EVENT_BUS.post(bonemealEvent)) {
            return false;
        }
        if (bonemealEvent.getResult() == Event.Result.ALLOW) {
            if (!ozlu2.field_72995_K) {
                --cvzo2._b;
            }
            return true;
        }
        if (n4 == twgu.field_71987_y.field_71990_ca) {
            if (!ozlu2.field_72995_K) {
                if ((double)ozlu2.field_73012_v.nextFloat() < 0.45) {
                    ((rqeh)twgu.field_71987_y)._a(ozlu2, n, n2, n3, ozlu2.field_73012_v);
                }
                --cvzo2._b;
            }
            return true;
        }
        if (n4 != twgu.field_72109_af.field_71990_ca && n4 != twgu.field_72103_ag.field_71990_ca) {
            if (n4 != twgu.field_71999_bt.field_71990_ca && n4 != twgu.field_71996_bs.field_71990_ca) {
                if (n4 > 0 && twgu.field_71973_m[n4] instanceof nuuf) {
                    if (ozlu2.func_72805_g(n, n2, n3) == 7) {
                        return false;
                    }
                    if (!ozlu2.field_72995_K) {
                        ((nuuf)twgu.field_71973_m[n4])._a(ozlu2, n, n2, n3);
                        --cvzo2._b;
                    }
                    return true;
                }
                if (n4 == twgu.field_72086_bP.field_71990_ca) {
                    int n5 = ozlu2.func_72805_g(n, n2, n3);
                    int n6 = gqau._d(n5);
                    int n7 = woni._b(n5);
                    if (n7 >= 2) {
                        return false;
                    }
                    if (!ozlu2.field_72995_K) {
                        ozlu2.func_72921_c(n, n2, n3, ++n7 << 2 | n6, 2);
                        --cvzo2._b;
                    }
                    return true;
                }
                if (n4 != twgu.field_71980_u.field_71990_ca) {
                    return false;
                }
                if (!ozlu2.field_72995_K) {
                    --cvzo2._b;
                    block0: for (int i = 0; i < 128; ++i) {
                        int n8 = n;
                        int n9 = n2 + 1;
                        int n10 = n3;
                        for (int j = 0; j < i / 16; ++j) {
                            if (ozlu2.func_72798_a(n8 += field_77697_d.nextInt(3) - 1, (n9 += (field_77697_d.nextInt(3) - 1) * field_77697_d.nextInt(3) / 2) - 1, n10 += field_77697_d.nextInt(3) - 1) != twgu.field_71980_u.field_71990_ca || ozlu2.func_72809_s(n8, n9, n10)) continue block0;
                        }
                        if (ozlu2.func_72798_a(n8, n9, n10) != 0) continue;
                        if (field_77697_d.nextInt(10) != 0) {
                            if (!twgu.field_71962_X.func_71854_d(ozlu2, n8, n9, n10)) continue;
                            ozlu2.func_72832_d(n8, n9, n10, twgu.field_71962_X.field_71990_ca, 1, 3);
                            continue;
                        }
                        ForgeHooks.plantGrass(ozlu2, n8, n9, n10);
                    }
                }
                return true;
            }
            if (ozlu2.func_72805_g(n, n2, n3) == 7) {
                return false;
            }
            if (!ozlu2.field_72995_K) {
                ((xati)twgu.field_71973_m[n4])._a(ozlu2, n, n2, n3);
                --cvzo2._b;
            }
            return true;
        }
        if (!ozlu2.field_72995_K) {
            if ((double)ozlu2.field_73012_v.nextFloat() < 0.4) {
                ((rqca)twgu.field_71973_m[n4])._a(ozlu2, n, n2, n3, ozlu2.field_73012_v);
            }
            --cvzo2._b;
        }
        return true;
    }

    @SideOnly(value=Side.CLIENT)
    public static void _a(ozlu ozlu2, int n, int n2, int n3, int n4) {
        twgu twgu2;
        int n5 = ozlu2.func_72798_a(n, n2, n3);
        if (n4 == 0) {
            n4 = 15;
        }
        twgu twgu3 = twgu2 = n5 > 0 && n5 < twgu.field_71973_m.length ? twgu.field_71973_m[n5] : null;
        if (twgu2 != null) {
            twgu2.func_71902_a(ozlu2, n, n2, n3);
            for (int i = 0; i < n4; ++i) {
                double d = field_77697_d.nextGaussian() * 0.02;
                double d2 = field_77697_d.nextGaussian() * 0.02;
                double d3 = field_77697_d.nextGaussian() * 0.02;
                ozlu2.func_72869_a("happyVillager", (float)n + field_77697_d.nextFloat(), (double)n2 + (double)field_77697_d.nextFloat() * twgu2.func_83010_y(), (float)n3 + field_77697_d.nextFloat(), d, d2, d3);
            }
        } else {
            for (int i = 0; i < n4; ++i) {
                double d = field_77697_d.nextGaussian() * 0.02;
                double d4 = field_77697_d.nextGaussian() * 0.02;
                double d5 = field_77697_d.nextGaussian() * 0.02;
                ozlu2.func_72869_a("happyVillager", (float)n + field_77697_d.nextFloat(), (double)n2 + (double)field_77697_d.nextFloat() * 1.0, (float)n3 + field_77697_d.nextFloat(), d, d4, d5);
            }
        }
    }

    @Override
    public boolean func_111207_a(cvzo cvzo2, EntityPlayer entityPlayer, EntityLivingBase entityLivingBase) {
        if (entityLivingBase instanceof EntitySheep) {
            EntitySheep entitySheep = (EntitySheep)entityLivingBase;
            int n = uziv._a(cvzo2._j());
            if (!entitySheep.func_70892_o() && entitySheep.func_70896_n() != n) {
                entitySheep.func_70891_b(n);
                --cvzo2._b;
            }
            return true;
        }
        return false;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_77633_a(int n, tgbl tgbl2, List list2) {
        for (int i = 0; i < 16; ++i) {
            list2.add(new cvzo(n, 1, i));
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_94581_a(nege nege2) {
        this._d = new dwan[_b.length];
        for (int i = 0; i < _b.length; ++i) {
            this._d[i] = nege2._b(this.func_111208_A() + "_" + _b[i]);
        }
    }
}

