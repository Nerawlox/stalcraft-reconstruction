/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bu
 *  com.google.common.collect.HashMultimap
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  ms
 *  mt
 *  ni
 *  or
 *  ot
 *  zp
 */
import com.google.common.collect.HashMultimap;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class yp
extends yc {
    private HashMap a = new HashMap();
    private static final Map b = new LinkedHashMap();
    @SideOnly(value=Side.CLIENT)
    private ms c;
    @SideOnly(value=Side.CLIENT)
    private ms d;
    @SideOnly(value=Side.CLIENT)
    private ms cB;

    public yp(int par1) {
        super(par1);
        this.d(1);
        this.a(true);
        this.e(0);
        this.a(ww.k);
    }

    public List g(ye par1ItemStack) {
        if (par1ItemStack.p() && par1ItemStack.q().b("CustomPotionEffects")) {
            ArrayList<nj> arraylist = new ArrayList<nj>();
            cg nbttaglist = par1ItemStack.q().m("CustomPotionEffects");
            for (int i2 = 0; i2 < nbttaglist.c(); ++i2) {
                by nbttagcompound = (by)nbttaglist.b(i2);
                arraylist.add(nj.b(nbttagcompound));
            }
            return arraylist;
        }
        List list = (List)this.a.get(par1ItemStack.k());
        if (list == null) {
            list = zp.b((int)par1ItemStack.k(), (boolean)false);
            this.a.put(par1ItemStack.k(), list);
        }
        return list;
    }

    public List c(int par1) {
        List list = (List)this.a.get(par1);
        if (list == null) {
            list = zp.b((int)par1, (boolean)false);
            this.a.put(par1, list);
        }
        return list;
    }

    @Override
    public ye b(ye par1ItemStack, abw par2World, uf par3EntityPlayer) {
        List list;
        if (!par3EntityPlayer.bG.d) {
            --par1ItemStack.b;
        }
        if (!par2World.I && (list = this.g(par1ItemStack)) != null) {
            for (nj potioneffect : list) {
                par3EntityPlayer.c(new nj(potioneffect));
            }
        }
        if (!par3EntityPlayer.bG.d) {
            if (par1ItemStack.b <= 0) {
                return new ye(yc.bv);
            }
            par3EntityPlayer.bn.a(new ye(yc.bv));
        }
        return par1ItemStack;
    }

    @Override
    public int d_(ye par1ItemStack) {
        return 32;
    }

    @Override
    public zj c_(ye par1ItemStack) {
        return zj.c;
    }

    @Override
    public ye a(ye par1ItemStack, abw par2World, uf par3EntityPlayer) {
        if (yp.f(par1ItemStack.k())) {
            if (!par3EntityPlayer.bG.d) {
                --par1ItemStack.b;
            }
            par2World.a((nn)par3EntityPlayer, "random.bow", 0.5f, 0.4f / (f.nextFloat() * 0.4f + 0.8f));
            if (!par2World.I) {
                par2World.d(new uu(par2World, (of)par3EntityPlayer, par1ItemStack));
            }
            return par1ItemStack;
        }
        par3EntityPlayer.a(par1ItemStack, this.d_(par1ItemStack));
        return par1ItemStack;
    }

    @Override
    public boolean a(ye par1ItemStack, uf par2EntityPlayer, abw par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
        return false;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public ms b_(int par1) {
        return yp.f(par1) ? this.c : this.d;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public ms a(int par1, int par2) {
        return par2 == 0 ? this.cB : super.a(par1, par2);
    }

    public static boolean f(int par0) {
        return (par0 & 0x4000) != 0;
    }

    @SideOnly(value=Side.CLIENT)
    public int g(int par1) {
        return zp.a((int)par1, (boolean)false);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int a(ye par1ItemStack, int par2) {
        return par2 > 0 ? 0xFFFFFF : this.g(par1ItemStack.k());
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public boolean b() {
        return true;
    }

    @SideOnly(value=Side.CLIENT)
    public boolean h(int par1) {
        List list = this.c(par1);
        if (list != null && !list.isEmpty()) {
            nj potioneffect;
            Iterator iterator = list.iterator();
            do {
                if (iterator.hasNext()) continue;
                return false;
            } while (!ni.a[(potioneffect = (nj)iterator.next()).a()].b());
            return true;
        }
        return false;
    }

    @Override
    public String l(ye par1ItemStack) {
        List list;
        if (par1ItemStack.k() == 0) {
            return bu.a((String)"item.emptyPotion.name").trim();
        }
        String s2 = "";
        if (yp.f(par1ItemStack.k())) {
            s2 = bu.a((String)"potion.prefix.grenade").trim() + " ";
        }
        if ((list = yc.bu.g(par1ItemStack)) != null && !list.isEmpty()) {
            String s1 = ((nj)list.get(0)).f();
            s1 = s1 + ".postfix";
            return s2 + bu.a((String)s1).trim();
        }
        String s1 = zp.c((int)par1ItemStack.k());
        return bu.a((String)s1).trim() + " " + super.l(par1ItemStack);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void a(ye par1ItemStack, uf par2EntityPlayer, List par3List, boolean par4) {
        if (par1ItemStack.k() != 0) {
            List list1 = yc.bu.g(par1ItemStack);
            HashMultimap hashmultimap = HashMultimap.create();
            if (list1 != null && !list1.isEmpty()) {
                for (nj potioneffect : list1) {
                    String s2 = bu.a((String)potioneffect.f()).trim();
                    ni potion = ni.a[potioneffect.a()];
                    Map map = potion.k();
                    if (map != null && map.size() > 0) {
                        for (Map.Entry entry : map.entrySet()) {
                            ot attributemodifier = (ot)entry.getValue();
                            ot attributemodifier1 = new ot(attributemodifier.b(), potion.a(potioneffect.c(), attributemodifier), attributemodifier.c());
                            hashmultimap.put((Object)((or)entry.getKey()).a(), (Object)attributemodifier1);
                        }
                    }
                    if (potioneffect.c() > 0) {
                        s2 = s2 + " " + bu.a((String)("potion.potency." + potioneffect.c())).trim();
                    }
                    if (potioneffect.b() > 20) {
                        s2 = s2 + " (" + ni.a((nj)potioneffect) + ")";
                    }
                    if (potion.f()) {
                        par3List.add((Object)((Object)a.m) + s2);
                        continue;
                    }
                    par3List.add((Object)((Object)a.h) + s2);
                }
            } else {
                String s1 = bu.a((String)"potion.empty").trim();
                par3List.add((Object)((Object)a.h) + s1);
            }
            if (!hashmultimap.isEmpty()) {
                par3List.add("");
                par3List.add((Object)((Object)a.f) + bu.a((String)"potion.effects.whenDrank"));
                for (Map.Entry entry1 : hashmultimap.entries()) {
                    ot attributemodifier2 = (ot)entry1.getValue();
                    double d0 = attributemodifier2.d();
                    double d1 = attributemodifier2.c() != 1 && attributemodifier2.c() != 2 ? attributemodifier2.d() : attributemodifier2.d() * 100.0;
                    if (d0 > 0.0) {
                        par3List.add((Object)((Object)a.j) + bu.a((String)("attribute.modifier.plus." + attributemodifier2.c()), (Object[])new Object[]{ye.a.format(d1), bu.a((String)("attribute.name." + (String)entry1.getKey()))}));
                        continue;
                    }
                    if (!(d0 < 0.0)) continue;
                    par3List.add((Object)((Object)a.m) + bu.a((String)("attribute.modifier.take." + attributemodifier2.c()), (Object[])new Object[]{ye.a.format(d1 *= -1.0), bu.a((String)("attribute.name." + (String)entry1.getKey()))}));
                }
            }
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public boolean e(ye par1ItemStack) {
        List list = this.g(par1ItemStack);
        return list != null && !list.isEmpty();
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void a(int par1, ww par2CreativeTabs, List par3List) {
        int j2;
        super.a(par1, par2CreativeTabs, par3List);
        if (b.isEmpty()) {
            for (int k2 = 0; k2 <= 15; ++k2) {
                for (j2 = 0; j2 <= 1; ++j2) {
                    int l2 = j2 == 0 ? k2 | 0x2000 : k2 | 0x4000;
                    for (int i1 = 0; i1 <= 2; ++i1) {
                        List list1;
                        int j1 = l2;
                        if (i1 != 0) {
                            if (i1 == 1) {
                                j1 = l2 | 0x20;
                            } else if (i1 == 2) {
                                j1 = l2 | 0x40;
                            }
                        }
                        if ((list1 = zp.b((int)j1, (boolean)false)) == null || list1.isEmpty()) continue;
                        b.put(list1, j1);
                    }
                }
            }
        }
        Iterator iterator = b.values().iterator();
        while (iterator.hasNext()) {
            j2 = (Integer)iterator.next();
            par3List.add(new ye(par1, 1, j2));
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void a(mt par1IconRegister) {
        this.d = par1IconRegister.a(this.A() + "_bottle_drinkable");
        this.c = par1IconRegister.a(this.A() + "_bottle_splash");
        this.cB = par1IconRegister.a(this.A() + "_overlay");
    }

    @SideOnly(value=Side.CLIENT)
    public static ms e(String par0Str) {
        return par0Str.equals("bottle_drinkable") ? yc.bu.d : (par0Str.equals("bottle_splash") ? yc.bu.c : (par0Str.equals("overlay") ? yc.bu.cB : null));
    }
}

