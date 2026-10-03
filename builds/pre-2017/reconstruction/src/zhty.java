/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.asm.GloomyHooks;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.DamageSource;
import net.minecraft.util.iurq;

public class zhty {
    public static final Random _a = new Random();
    public static final xspi _b = new xspi(null);
    public static final pkxv _c = new pkxv(null);

    public static int _a(int n, ItemStack itemStack) {
        if (itemStack == null) {
            return 0;
        }
        NBTTagList nBTTagList = itemStack._r();
        if (nBTTagList == null) {
            return 0;
        }
        for (int i = 0; i < nBTTagList._d(); ++i) {
            short s = ((NBTTagCompound)nBTTagList._b(i))._e("id");
            short s2 = ((NBTTagCompound)nBTTagList._b(i))._e("lvl");
            if (s != n) continue;
            return s2;
        }
        return 0;
    }

    public static Map _a(ItemStack itemStack) {
        NBTTagList nBTTagList;
        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<Integer, Integer>();
        NBTTagList nBTTagList2 = nBTTagList = itemStack._d == Item.enchantedBook.itemID ? Item.enchantedBook._a(itemStack) : itemStack._r();
        if (nBTTagList != null) {
            for (int i = 0; i < nBTTagList._d(); ++i) {
                short s = ((NBTTagCompound)nBTTagList._b(i))._e("id");
                short s2 = ((NBTTagCompound)nBTTagList._b(i))._e("lvl");
                linkedHashMap.put(Integer.valueOf(s), Integer.valueOf(s2));
            }
        }
        return linkedHashMap;
    }

    public static void _a(Map map, ItemStack itemStack) {
        NBTTagList nBTTagList = new NBTTagList();
        Iterator iterator2 = map.keySet().iterator();
        while (iterator2.hasNext()) {
            int n = (Integer)iterator2.next();
            NBTTagCompound nBTTagCompound = new NBTTagCompound();
            nBTTagCompound._a("id", (short)n);
            nBTTagCompound._a("lvl", (short)((Integer)map.get(n)).intValue());
            nBTTagList._a(nBTTagCompound);
            if (itemStack._d != Item.enchantedBook.itemID) continue;
            Item.enchantedBook._a(itemStack, new ixcc(n, (int)((Integer)map.get(n))));
        }
        if (nBTTagList._d() > 0) {
            if (itemStack._d != Item.enchantedBook.itemID) {
                itemStack._a("ench", nBTTagList);
            }
        } else if (itemStack._p()) {
            itemStack._q()._p("ench");
        }
    }

    public static int _a(int n, ItemStack[] itemStackArray) {
        if (itemStackArray == null) {
            return 0;
        }
        int n2 = 0;
        ItemStack[] itemStackArray2 = itemStackArray;
        int n3 = itemStackArray.length;
        for (int i = 0; i < n3; ++i) {
            ItemStack itemStack = itemStackArray2[i];
            int n4 = zhty._a(n, itemStack);
            if (n4 <= n2) continue;
            n2 = n4;
        }
        return n2;
    }

    public static void _a(dywt dywt2, ItemStack itemStack) {
        NBTTagList nBTTagList;
        if (itemStack != null && (nBTTagList = itemStack._r()) != null) {
            for (int i = 0; i < nBTTagList._d(); ++i) {
                short s = ((NBTTagCompound)nBTTagList._b(i))._e("id");
                short s2 = ((NBTTagCompound)nBTTagList._b(i))._e("lvl");
                if (Enchantment._a[s] == null) continue;
                dywt2._a(Enchantment._a[s], s2);
            }
        }
    }

    public static void _a(dywt dywt2, ItemStack[] itemStackArray) {
        ItemStack[] itemStackArray2 = itemStackArray;
        int n = itemStackArray.length;
        for (int i = 0; i < n; ++i) {
            ItemStack itemStack = itemStackArray2[i];
            zhty._a(dywt2, itemStack);
        }
    }

    public static int _a(ItemStack[] itemStackArray, DamageSource damageSource) {
        zhty._b._a = 0;
        zhty._b._b = damageSource;
        zhty._a((dywt)_b, itemStackArray);
        if (zhty._b._a > 25) {
            zhty._b._a = 25;
        }
        int n = (zhty._b._a + 1 >> 1) + _a.nextInt((zhty._b._a >> 1) + 1);
        GloomyHooks.getEnchantmentModifierDamage(null, itemStackArray, damageSource);
        return n;
    }

    public static float _a(EntityLivingBase entityLivingBase, EntityLivingBase entityLivingBase2) {
        zhty._c._a = 0.0f;
        zhty._c._b = entityLivingBase2;
        zhty._a((dywt)_c, entityLivingBase.getHeldItem());
        float f = zhty._c._a;
        GloomyHooks.getEnchantmentModifierLiving(null, entityLivingBase, entityLivingBase2);
        return f;
    }

    public static int _b(EntityLivingBase entityLivingBase, EntityLivingBase entityLivingBase2) {
        return zhty._a(Enchantment._n._y, entityLivingBase.getHeldItem());
    }

    public static int _a(EntityLivingBase entityLivingBase) {
        return zhty._a(Enchantment._o._y, entityLivingBase.getHeldItem());
    }

    public static int _b(EntityLivingBase entityLivingBase) {
        return zhty._a(Enchantment._h._y, entityLivingBase.func_70035_c());
    }

    public static int _c(EntityLivingBase entityLivingBase) {
        return zhty._a(Enchantment._q._y, entityLivingBase.getHeldItem());
    }

    public static boolean _d(EntityLivingBase entityLivingBase) {
        return zhty._a(Enchantment._r._y, entityLivingBase.getHeldItem()) > 0;
    }

    public static int _e(EntityLivingBase entityLivingBase) {
        return zhty._a(Enchantment._t._y, entityLivingBase.getHeldItem());
    }

    public static int _f(EntityLivingBase entityLivingBase) {
        return zhty._a(Enchantment._p._y, entityLivingBase.getHeldItem());
    }

    public static boolean _g(EntityLivingBase entityLivingBase) {
        return zhty._a(Enchantment._i._y, entityLivingBase.func_70035_c()) > 0;
    }

    public static int _h(EntityLivingBase entityLivingBase) {
        return zhty._a(Enchantment._j._y, entityLivingBase.func_70035_c());
    }

    public static ItemStack _a(Enchantment enchantment, EntityLivingBase entityLivingBase) {
        for (ItemStack itemStack : entityLivingBase.func_70035_c()) {
            if (itemStack == null || zhty._a(enchantment._y, itemStack) <= 0) continue;
            return itemStack;
        }
        return null;
    }

    public static int _a(Random random, int n, int n2, ItemStack itemStack) {
        Item item = itemStack._a();
        int n3 = item.getItemEnchantability();
        if (n3 <= 0) {
            return 0;
        }
        if (n2 > 15) {
            n2 = 15;
        }
        int n4 = random.nextInt(8) + 1 + (n2 >> 1) + random.nextInt(n2 + 1);
        return n == 0 ? Math.max(n4 / 3, 1) : (n == 1 ? n4 * 2 / 3 + 1 : Math.max(n4, n2 * 2));
    }

    public static ItemStack _a(Random random, ItemStack itemStack, int n) {
        boolean bl;
        List list = zhty._b(random, itemStack, n);
        boolean bl2 = bl = itemStack._d == Item.book.itemID;
        if (bl) {
            itemStack._d = Item.enchantedBook.itemID;
        }
        if (list != null) {
            for (ixcc ixcc2 : list) {
                if (bl) {
                    Item.enchantedBook._a(itemStack, ixcc2);
                    continue;
                }
                itemStack._a(ixcc2._a, ixcc2._b);
            }
        }
        return itemStack;
    }

    public static List _b(Random random, ItemStack itemStack, int n) {
        ixcc ixcc2;
        float f;
        Item item = itemStack._a();
        int n2 = item.getItemEnchantability();
        if (n2 <= 0) {
            return null;
        }
        n2 /= 2;
        int n3 = (n2 = 1 + random.nextInt((n2 >> 1) + 1) + random.nextInt((n2 >> 1) + 1)) + n;
        int n4 = (int)((float)n3 * (1.0f + (f = (random.nextFloat() + random.nextFloat() - 1.0f) * 0.15f)) + 0.5f);
        if (n4 < 1) {
            n4 = 1;
        }
        ArrayList<Object> arrayList = null;
        Map map = zhty._b(n4, itemStack);
        if (map != null && !map.isEmpty() && (ixcc2 = (ixcc)iurq._a(random, map.values())) != null) {
            arrayList = new ArrayList<Object>();
            arrayList.add(ixcc2);
            for (int i = n4; random.nextInt(50) <= i; i >>= 1) {
                Object object;
                Iterator iterator2 = map.keySet().iterator();
                while (iterator2.hasNext()) {
                    object = (Integer)iterator2.next();
                    boolean bl = true;
                    for (ixcc ixcc3 : arrayList) {
                        if (ixcc3._a._a(Enchantment._a[(Integer)object])) continue;
                        bl = false;
                        break;
                    }
                    if (bl) continue;
                    iterator2.remove();
                }
                if (map.isEmpty()) continue;
                object = (ixcc)iurq._a(random, map.values());
                arrayList.add(object);
            }
        }
        return arrayList;
    }

    public static Map _b(int n, ItemStack itemStack) {
        Item item = itemStack._a();
        HashMap<Integer, ixcc> hashMap = null;
        boolean bl = itemStack._d == Item.book.itemID;
        for (Enchantment enchantment : Enchantment._a) {
            if (enchantment == null) continue;
            boolean bl2 = bl = itemStack._d == Item.book.itemID && enchantment._e();
            if (!enchantment._b(itemStack) && !bl) continue;
            for (int i = enchantment._b(); i <= enchantment._c(); ++i) {
                if (n < enchantment._a(i) || n > enchantment._b(i)) continue;
                if (hashMap == null) {
                    hashMap = new HashMap<Integer, ixcc>();
                }
                hashMap.put(enchantment._y, new ixcc(enchantment, i));
            }
        }
        return hashMap;
    }
}

