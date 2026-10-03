/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.collect.HashMultimap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.util.dwan;
import net.minecraft.util.ezfc;
import net.minecraft.util.tdpx;

public class zyyc
extends tgdv {
    public HashMap _a = new HashMap();
    public static final Map _b = new LinkedHashMap();
    public dwan _c;
    public dwan _d;
    public dwan _e;

    public zyyc(int n) {
        super(n);
        this.func_77625_d(1);
        this.func_77627_a(true);
        this.func_77656_e(0);
        this.func_77637_a(tgbl.field_78038_k);
    }

    public List _a(cvzo cvzo2) {
        if (!cvzo2._p() || !cvzo2._q()._c("CustomPotionEffects")) {
            List list2 = (List)this._a.get(cvzo2._j());
            if (list2 == null) {
                list2 = hdoy._b(cvzo2._j(), false);
                this._a.put(cvzo2._j(), list2);
            }
            return list2;
        }
        ArrayList<supr> arrayList = new ArrayList<supr>();
        bsyv bsyv2 = cvzo2._q()._n("CustomPotionEffects");
        for (int i = 0; i < bsyv2._d(); ++i) {
            qoac qoac2 = (qoac)bsyv2._b(i);
            arrayList.add(supr._b(qoac2));
        }
        return arrayList;
    }

    public List _a(int n) {
        List list2 = (List)this._a.get(n);
        if (list2 == null) {
            list2 = hdoy._b(n, false);
            this._a.put(n, list2);
        }
        return list2;
    }

    @Override
    public cvzo func_77654_b(cvzo cvzo2, ozlu ozlu2, EntityPlayer entityPlayer) {
        List list2;
        if (!entityPlayer.field_71075_bZ._d) {
            --cvzo2._b;
        }
        if (!ozlu2.field_72995_K && (list2 = this._a(cvzo2)) != null) {
            for (supr supr2 : list2) {
                entityPlayer.func_70690_d(new supr(supr2));
            }
        }
        if (!entityPlayer.field_71075_bZ._d) {
            if (cvzo2._b <= 0) {
                return new cvzo(tgdv.field_77729_bt);
            }
            entityPlayer.field_71071_by._c(new cvzo(tgdv.field_77729_bt));
        }
        return cvzo2;
    }

    @Override
    public int func_77626_a(cvzo cvzo2) {
        return 32;
    }

    @Override
    public bsre func_77661_b(cvzo cvzo2) {
        return bsre._c;
    }

    @Override
    public cvzo func_77659_a(cvzo cvzo2, ozlu ozlu2, EntityPlayer entityPlayer) {
        if (zyyc._b(cvzo2._j())) {
            if (!entityPlayer.field_71075_bZ._d) {
                --cvzo2._b;
            }
            ozlu2.func_72956_a(entityPlayer, "random.bow", 0.5f, 0.4f / (field_77697_d.nextFloat() * 0.4f + 0.8f));
            if (!ozlu2.field_72995_K) {
                ozlu2.func_72838_d(new EntityPotion(ozlu2, (EntityLivingBase)entityPlayer, cvzo2));
            }
            return cvzo2;
        }
        entityPlayer.func_71008_a(cvzo2, this.func_77626_a(cvzo2));
        return cvzo2;
    }

    @Override
    public boolean func_77648_a(cvzo cvzo2, EntityPlayer entityPlayer, ozlu ozlu2, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        return false;
    }

    @Override
    public dwan func_77617_a(int n) {
        if (zyyc._b(n)) {
            return this._c;
        }
        return this._d;
    }

    @Override
    public dwan func_77618_c(int n, int n2) {
        if (n2 == 0) {
            return this._e;
        }
        return super.func_77618_c(n, n2);
    }

    public static boolean _b(int n) {
        return (n & 0x4000) != 0;
    }

    public int _c(int n) {
        return hdoy._a(n, false);
    }

    @Override
    public int func_82790_a(cvzo cvzo2, int n) {
        if (n > 0) {
            return 0xFFFFFF;
        }
        return this._c(cvzo2._j());
    }

    @Override
    public boolean func_77623_v() {
        return true;
    }

    public boolean _d(int n) {
        List list2 = this._a(n);
        if (list2 == null || list2.isEmpty()) {
            return false;
        }
        for (supr supr2 : list2) {
            if (!hdpq._a[supr2._a()]._b()) continue;
            return true;
        }
        return false;
    }

    @Override
    public String func_77628_j(cvzo cvzo2) {
        List list2;
        if (cvzo2._j() == 0) {
            return tdpx._a("item.emptyPotion.name").trim();
        }
        String string = "";
        if (zyyc._b(cvzo2._j())) {
            string = tdpx._a("potion.prefix.grenade").trim() + " ";
        }
        if ((list2 = tgdv.field_77726_bs._a(cvzo2)) != null && !list2.isEmpty()) {
            String string2 = ((supr)list2.get(0))._g();
            string2 = string2 + ".postfix";
            return string + tdpx._a(string2).trim();
        }
        String string3 = hdoy._b(cvzo2._j());
        return tdpx._a(string3).trim() + " " + super.func_77628_j(cvzo2);
    }

    @Override
    public void func_77624_a(cvzo cvzo2, EntityPlayer entityPlayer, List list2, boolean bl) {
        Object object;
        if (cvzo2._j() == 0) {
            return;
        }
        List list3 = tgdv.field_77726_bs._a(cvzo2);
        HashMultimap<String, xson> hashMultimap = HashMultimap.create();
        if (list3 != null && !list3.isEmpty()) {
            for (supr object2 : list3) {
                object = tdpx._a(object2._g()).trim();
                hdpq hdpq2 = hdpq._a[object2._a()];
                Map map = hdpq2._j();
                if (map != null && map.size() > 0) {
                    for (Map.Entry entry : map.entrySet()) {
                        xson xson2 = (xson)entry.getValue();
                        xson xson3 = new xson(xson2._b(), hdpq2._a(object2._c(), xson2), xson2._c());
                        hashMultimap.put(((txei)entry.getKey())._a(), xson3);
                    }
                }
                if (object2._c() > 0) {
                    object = (String)object + " " + tdpx._a("potion.potency." + object2._c()).trim();
                }
                if (object2._b() > 20) {
                    object = (String)object + " (" + hdpq._a(object2) + ")";
                }
                if (hdpq2._f()) {
                    list2.add((Object)((Object)ezfc._m) + (String)object);
                    continue;
                }
                list2.add((Object)((Object)ezfc._h) + (String)object);
            }
        } else {
            Iterator iterator2 = tdpx._a("potion.empty").trim();
            list2.add((Object)((Object)ezfc._h) + (String)((Object)iterator2));
        }
        if (!hashMultimap.isEmpty()) {
            list2.add("");
            list2.add((Object)((Object)ezfc._f) + tdpx._a("potion.effects.whenDrank"));
            for (Map.Entry entry : hashMultimap.entries()) {
                object = (xson)entry.getValue();
                double d = ((xson)object)._d();
                double d2 = ((xson)object)._c() == 1 || ((xson)object)._c() == 2 ? ((xson)object)._d() * 100.0 : ((xson)object)._d();
                if (d > 0.0) {
                    list2.add((Object)((Object)ezfc._j) + tdpx._a("attribute.modifier.plus." + ((xson)object)._c(), cvzo._a.format(d2), tdpx._a("attribute.name." + (String)entry.getKey())));
                    continue;
                }
                if (!(d < 0.0)) continue;
                list2.add((Object)((Object)ezfc._m) + tdpx._a("attribute.modifier.take." + ((xson)object)._c(), cvzo._a.format(d2 *= -1.0), tdpx._a("attribute.name." + (String)entry.getKey())));
            }
        }
    }

    @Override
    public boolean func_77636_d(cvzo cvzo2) {
        List list2 = this._a(cvzo2);
        return list2 != null && !list2.isEmpty();
    }

    @Override
    public void func_77633_a(int n, tgbl tgbl2, List list2) {
        int n2;
        super.func_77633_a(n, tgbl2, list2);
        if (_b.isEmpty()) {
            for (int i = 0; i <= 15; ++i) {
                for (n2 = 0; n2 <= 1; ++n2) {
                    int n3 = i;
                    n3 = n2 == 0 ? (n3 |= 0x2000) : (n3 |= 0x4000);
                    for (int j = 0; j <= 2; ++j) {
                        List list3;
                        int n4 = n3;
                        if (j != 0) {
                            if (j == 1) {
                                n4 |= 0x20;
                            } else if (j == 2) {
                                n4 |= 0x40;
                            }
                        }
                        if ((list3 = hdoy._b(n4, false)) == null || list3.isEmpty()) continue;
                        _b.put(list3, n4);
                    }
                }
            }
        }
        Iterator iterator2 = _b.values().iterator();
        while (iterator2.hasNext()) {
            n2 = (Integer)iterator2.next();
            list2.add(new cvzo(n, 1, n2));
        }
    }

    @Override
    public void func_94581_a(nege nege2) {
        this._d = nege2._b(this.func_111208_A() + "_" + "bottle_drinkable");
        this._c = nege2._b(this.func_111208_A() + "_" + "bottle_splash");
        this._e = nege2._b(this.func_111208_A() + "_" + "overlay");
    }

    public static dwan _a(String string) {
        if (string.equals("bottle_drinkable")) {
            return tgdv.field_77726_bs._d;
        }
        if (string.equals("bottle_splash")) {
            return tgdv.field_77726_bs._c;
        }
        if (string.equals("overlay")) {
            return tgdv.field_77726_bs._e;
        }
        return null;
    }
}

