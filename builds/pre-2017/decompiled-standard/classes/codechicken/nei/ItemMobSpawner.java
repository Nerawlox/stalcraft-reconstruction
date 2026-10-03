/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import codechicken.nei.NEICPH;
import codechicken.nei.NEIClientUtils;
import codechicken.nei.api.API;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.jgro;
import net.minecraft.entity.monster.ezey;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.dwan;

public class ItemMobSpawner
extends mbpd {
    private static Map<Integer, EntityLiving> entityHashMap;
    private static Map<Integer, String> IDtoNameMap;
    public static int idPig;
    private static boolean loaded;
    public static int placedX;
    public static int placedY;
    public static int placedZ;

    public ItemMobSpawner(ozlu ozlu2) {
        super(twgu.field_72065_as.field_71990_ca - 256);
        tgdv.field_77698_e[this.field_77779_bT] = this;
        this.field_77787_bX = true;
        entityHashMap = new HashMap<Integer, EntityLiving>();
        IDtoNameMap = new HashMap<Integer, String>();
        ItemMobSpawner.loadSpawners(ozlu2);
    }

    @Override
    public dwan func_77617_a(int n) {
        return twgu.field_72065_as.func_71851_a(0);
    }

    @Override
    public boolean func_77648_a(cvzo cvzo2, EntityPlayer entityPlayer, ozlu ozlu2, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        if (super.func_77648_a(cvzo2, entityPlayer, ozlu2, n, n2, n3, n4, f, f2, f3) && ozlu2.field_72995_K) {
            xtcq xtcq2 = (xtcq)ozlu2.func_72796_p(placedX, placedY, placedZ);
            if (xtcq2 != null) {
                this.setDefaultTag(cvzo2);
                String string = IDtoNameMap.get(cvzo2._j());
                if (string != null) {
                    NEICPH.sendMobSpawnerID(placedX, placedY, placedZ, string);
                    xtcq2._a()._a(string);
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public void func_77624_a(cvzo cvzo2, EntityPlayer entityPlayer, List list2, boolean bl) {
        EntityLiving entityLiving;
        this.setDefaultTag(cvzo2);
        int n = cvzo2._j();
        if (n == 0) {
            n = idPig;
        }
        if ((entityLiving = ItemMobSpawner.getEntity(n)) == null) {
            return;
        }
        list2.add("\u00a7" + (entityLiving instanceof ezey ? "4" : "3") + IDtoNameMap.get(n));
    }

    public static EntityLiving getEntity(int n) {
        EntityLiving entityLiving = entityHashMap.get(n);
        if (entityLiving == null) {
            pkix pkix2 = NEIClientUtils.mc()._r;
            ItemMobSpawner.loadSpawners(pkix2);
            try {
                Class clazz = (Class)jgro._c.get(n);
                if (clazz != null && EntityLiving.class.isAssignableFrom(clazz)) {
                    entityLiving = (EntityLiving)clazz.getConstructor(ozlu.class).newInstance(pkix2);
                }
            }
            catch (Throwable throwable) {
                throwable.printStackTrace();
            }
            entityHashMap.put(n, entityLiving);
        }
        return entityLiving;
    }

    private void setDefaultTag(cvzo cvzo2) {
        if (!IDtoNameMap.containsKey(cvzo2._j())) {
            cvzo2._b(idPig);
        }
    }

    public static void loadSpawners(ozlu ozlu2) {
        if (loaded) {
            return;
        }
        loaded = true;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        try {
            HashMap hashMap = (HashMap)jgro._b;
            HashMap hashMap2 = (HashMap)jgro._d;
            for (Class clazz : hashMap.keySet()) {
                if (!EntityLiving.class.isAssignableFrom(clazz)) continue;
                try {
                    EntityLiving entityLiving = (EntityLiving)clazz.getConstructor(ozlu.class).newInstance(ozlu2);
                    entityLiving.func_70631_g_();
                    int n = (Integer)hashMap2.get(clazz);
                    String string = (String)hashMap.get(clazz);
                    if (string.equals("EnderDragon")) continue;
                    IDtoNameMap.put(n, string);
                    arrayList.add(n);
                    if (!string.equals("Pig")) continue;
                    idPig = n;
                }
                catch (Throwable throwable) {}
            }
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        API.setItemDamageVariants(twgu.field_72065_as.field_71990_ca, arrayList);
    }
}

