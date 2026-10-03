/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.item;

import com.google.common.collect.HashMultimap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionHelper;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.Icon;
import net.minecraft.util.tdpx;
import net.minecraft.world.World;

public class ItemPotion
extends Item {
    public HashMap _a = new HashMap();
    public static final Map _b = new LinkedHashMap();
    public Icon _c;
    public Icon _d;
    public Icon _e;

    public ItemPotion(int n) {
        super(n);
        this.setMaxStackSize(1);
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
        this.setCreativeTab(CreativeTabs.tabBrewing);
    }

    public List _a(ItemStack itemStack) {
        if (!itemStack._p() || !itemStack._q()._c("CustomPotionEffects")) {
            List list2 = (List)this._a.get(itemStack._j());
            if (list2 == null) {
                list2 = PotionHelper._b(itemStack._j(), false);
                this._a.put(itemStack._j(), list2);
            }
            return list2;
        }
        ArrayList<PotionEffect> arrayList = new ArrayList<PotionEffect>();
        NBTTagList nBTTagList = itemStack._q()._n("CustomPotionEffects");
        for (int i = 0; i < nBTTagList._d(); ++i) {
            NBTTagCompound nBTTagCompound = (NBTTagCompound)nBTTagList._b(i);
            arrayList.add(PotionEffect._b(nBTTagCompound));
        }
        return arrayList;
    }

    public List _a(int n) {
        List list2 = (List)this._a.get(n);
        if (list2 == null) {
            list2 = PotionHelper._b(n, false);
            this._a.put(n, list2);
        }
        return list2;
    }

    @Override
    public ItemStack onEaten(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
        List list2;
        if (!entityPlayer.capabilities._d) {
            --itemStack._b;
        }
        if (!world.isRemote && (list2 = this._a(itemStack)) != null) {
            for (PotionEffect potionEffect : list2) {
                entityPlayer.addPotionEffect(new PotionEffect(potionEffect));
            }
        }
        if (!entityPlayer.capabilities._d) {
            if (itemStack._b <= 0) {
                return new ItemStack(Item.glassBottle);
            }
            entityPlayer.inventory._c(new ItemStack(Item.glassBottle));
        }
        return itemStack;
    }

    @Override
    public int getMaxItemUseDuration(ItemStack itemStack) {
        return 32;
    }

    @Override
    public EnumAction getItemUseAction(ItemStack itemStack) {
        return EnumAction._c;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
        if (ItemPotion._b(itemStack._j())) {
            if (!entityPlayer.capabilities._d) {
                --itemStack._b;
            }
            world.playSoundAtEntity(entityPlayer, "random.bow", 0.5f, 0.4f / (itemRand.nextFloat() * 0.4f + 0.8f));
            if (!world.isRemote) {
                world.spawnEntityInWorld(new EntityPotion(world, (EntityLivingBase)entityPlayer, itemStack));
            }
            return itemStack;
        }
        entityPlayer.setItemInUse(itemStack, this.getMaxItemUseDuration(itemStack));
        return itemStack;
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        return false;
    }

    @Override
    public Icon getIconFromDamage(int n) {
        if (ItemPotion._b(n)) {
            return this._c;
        }
        return this._d;
    }

    @Override
    public Icon getIconFromDamageForRenderPass(int n, int n2) {
        if (n2 == 0) {
            return this._e;
        }
        return super.getIconFromDamageForRenderPass(n, n2);
    }

    public static boolean _b(int n) {
        return (n & 0x4000) != 0;
    }

    public int _c(int n) {
        return PotionHelper._a(n, false);
    }

    @Override
    public int getColorFromItemStack(ItemStack itemStack, int n) {
        if (n > 0) {
            return 0xFFFFFF;
        }
        return this._c(itemStack._j());
    }

    @Override
    public boolean requiresMultipleRenderPasses() {
        return true;
    }

    public boolean _d(int n) {
        List list2 = this._a(n);
        if (list2 == null || list2.isEmpty()) {
            return false;
        }
        for (PotionEffect potionEffect : list2) {
            if (!Potion._a[potionEffect._a()]._b()) continue;
            return true;
        }
        return false;
    }

    @Override
    public String getItemDisplayName(ItemStack itemStack) {
        List list2;
        if (itemStack._j() == 0) {
            return tdpx._a("item.emptyPotion.name").trim();
        }
        String string = "";
        if (ItemPotion._b(itemStack._j())) {
            string = tdpx._a("potion.prefix.grenade").trim() + " ";
        }
        if ((list2 = Item.potion._a(itemStack)) != null && !list2.isEmpty()) {
            String string2 = ((PotionEffect)list2.get(0))._g();
            string2 = string2 + ".postfix";
            return string + tdpx._a(string2).trim();
        }
        String string3 = PotionHelper._b(itemStack._j());
        return tdpx._a(string3).trim() + " " + super.getItemDisplayName(itemStack);
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List list2, boolean bl) {
        Object object;
        if (itemStack._j() == 0) {
            return;
        }
        List list3 = Item.potion._a(itemStack);
        HashMultimap<String, AttributeModifier> hashMultimap = HashMultimap.create();
        if (list3 != null && !list3.isEmpty()) {
            for (PotionEffect object2 : list3) {
                object = tdpx._a(object2._g()).trim();
                Potion potion = Potion._a[object2._a()];
                Map map = potion._j();
                if (map != null && map.size() > 0) {
                    for (Map.Entry entry : map.entrySet()) {
                        AttributeModifier attributeModifier = (AttributeModifier)entry.getValue();
                        AttributeModifier attributeModifier2 = new AttributeModifier(attributeModifier._b(), potion._a(object2._c(), attributeModifier), attributeModifier._c());
                        hashMultimap.put(((Attribute)entry.getKey())._a(), attributeModifier2);
                    }
                }
                if (object2._c() > 0) {
                    object = (String)object + " " + tdpx._a("potion.potency." + object2._c()).trim();
                }
                if (object2._b() > 20) {
                    object = (String)object + " (" + Potion._a(object2) + ")";
                }
                if (potion._f()) {
                    list2.add((Object)((Object)EnumChatFormatting._m) + (String)object);
                    continue;
                }
                list2.add((Object)((Object)EnumChatFormatting._h) + (String)object);
            }
        } else {
            Iterator iterator2 = tdpx._a("potion.empty").trim();
            list2.add((Object)((Object)EnumChatFormatting._h) + (String)((Object)iterator2));
        }
        if (!hashMultimap.isEmpty()) {
            list2.add("");
            list2.add((Object)((Object)EnumChatFormatting._f) + tdpx._a("potion.effects.whenDrank"));
            for (Map.Entry entry : hashMultimap.entries()) {
                object = (AttributeModifier)entry.getValue();
                double d = ((AttributeModifier)object)._d();
                double d2 = ((AttributeModifier)object)._c() == 1 || ((AttributeModifier)object)._c() == 2 ? ((AttributeModifier)object)._d() * 100.0 : ((AttributeModifier)object)._d();
                if (d > 0.0) {
                    list2.add((Object)((Object)EnumChatFormatting._j) + tdpx._a("attribute.modifier.plus." + ((AttributeModifier)object)._c(), ItemStack._a.format(d2), tdpx._a("attribute.name." + (String)entry.getKey())));
                    continue;
                }
                if (!(d < 0.0)) continue;
                list2.add((Object)((Object)EnumChatFormatting._m) + tdpx._a("attribute.modifier.take." + ((AttributeModifier)object)._c(), ItemStack._a.format(d2 *= -1.0), tdpx._a("attribute.name." + (String)entry.getKey())));
            }
        }
    }

    @Override
    public boolean hasEffect(ItemStack itemStack) {
        List list2 = this._a(itemStack);
        return list2 != null && !list2.isEmpty();
    }

    @Override
    public void getSubItems(int n, CreativeTabs creativeTabs, List list2) {
        int n2;
        super.getSubItems(n, creativeTabs, list2);
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
                        if ((list3 = PotionHelper._b(n4, false)) == null || list3.isEmpty()) continue;
                        _b.put(list3, n4);
                    }
                }
            }
        }
        Iterator iterator2 = _b.values().iterator();
        while (iterator2.hasNext()) {
            n2 = (Integer)iterator2.next();
            list2.add(new ItemStack(n, 1, n2));
        }
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        this._d = iconRegister._b(this.getIconString() + "_" + "bottle_drinkable");
        this._c = iconRegister._b(this.getIconString() + "_" + "bottle_splash");
        this._e = iconRegister._b(this.getIconString() + "_" + "overlay");
    }

    public static Icon _a(String string) {
        if (string.equals("bottle_drinkable")) {
            return Item.potion._d;
        }
        if (string.equals("bottle_splash")) {
            return Item.potion._c;
        }
        if (string.equals("overlay")) {
            return Item.potion._e;
        }
        return null;
    }
}

