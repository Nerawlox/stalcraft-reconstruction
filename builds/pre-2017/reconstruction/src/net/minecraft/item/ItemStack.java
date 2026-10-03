/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.item;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gloomyfolken.mods.asm.GloomyHooks;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentDurability;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.sajz;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.Icon;
import net.minecraft.util.tdpx;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;

public final class ItemStack {
    public static final DecimalFormat _a = new DecimalFormat("#.###");
    public int _b;
    public int _c;
    public int _d;
    public NBTTagCompound _e;
    public int _f;
    public EntityItemFrame _g;

    public ItemStack(Block block) {
        this(block, 1);
    }

    public ItemStack(Block block, int n) {
        this(block.blockID, n, 0);
    }

    public ItemStack(Block block, int n, int n2) {
        this(block.blockID, n, n2);
    }

    public ItemStack(Item item) {
        this(item.itemID, 1, 0);
    }

    public ItemStack(Item item, int n) {
        this(item.itemID, n, 0);
    }

    public ItemStack(Item item, int n, int n2) {
        this(item.itemID, n, n2);
    }

    public ItemStack(int n, int n2, int n3) {
        this._d = n;
        this._b = n2;
        this._f = n3;
        if (this._f < 0) {
            this._f = 0;
        }
    }

    public static ItemStack _a(NBTTagCompound nBTTagCompound) {
        ItemStack itemStack = new ItemStack();
        itemStack._c(nBTTagCompound);
        return itemStack._a() != null ? itemStack : null;
    }

    public ItemStack() {
    }

    public ItemStack _a(int n) {
        ItemStack itemStack = new ItemStack(this._d, n, this._f);
        if (this._e != null) {
            itemStack._e = (NBTTagCompound)this._e._c();
        }
        this._b -= n;
        return itemStack;
    }

    public Item _a() {
        return Item.itemsList[this._d];
    }

    @SideOnly(value=Side.CLIENT)
    public Icon _b() {
        return this._a().getIconIndex(this);
    }

    @SideOnly(value=Side.CLIENT)
    public int _c() {
        return this._a().getSpriteNumber();
    }

    public boolean _a(EntityPlayer entityPlayer, World world, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        boolean bl = this._a().onItemUse(this, entityPlayer, world, n, n2, n3, n4, f, f2, f3);
        if (bl) {
            entityPlayer.addStat(dzif._E[this._d], 1);
        }
        return bl;
    }

    public float _a(Block block) {
        return this._a().getStrVsBlock(this, block);
    }

    public ItemStack _a(World world, EntityPlayer entityPlayer) {
        return this._a().onItemRightClick(this, world, entityPlayer);
    }

    public ItemStack _b(World world, EntityPlayer entityPlayer) {
        return this._a().onEaten(this, world, entityPlayer);
    }

    public NBTTagCompound _b(NBTTagCompound nBTTagCompound) {
        nBTTagCompound._a("id", (short)this._d);
        nBTTagCompound._a("Count", (byte)this._b);
        nBTTagCompound._a("Damage", (short)this._f);
        if (this._e != null) {
            nBTTagCompound._a("tag", (NBTBase)this._e);
        }
        owtc._a(this, nBTTagCompound);
        return nBTTagCompound;
    }

    public void _c(NBTTagCompound nBTTagCompound) {
        this._d = nBTTagCompound._e("id");
        this._b = nBTTagCompound._d("Count");
        this._f = nBTTagCompound._e("Damage");
        if (this._f < 0) {
            this._f = 0;
        }
        if (nBTTagCompound._c("tag")) {
            this._e = nBTTagCompound._m("tag");
        }
        owtc._b(this, nBTTagCompound);
    }

    public int _d() {
        return this._a().getItemStackLimit(this);
    }

    public boolean _e() {
        return this._d() > 1 && (!this._f() || !this._h());
    }

    public boolean _f() {
        return Item.itemsList[this._d].getMaxDamage(this) > 0;
    }

    public boolean _g() {
        return Item.itemsList[this._d].getHasSubtypes();
    }

    public boolean _h() {
        boolean bl;
        boolean bl2 = bl = this._f > 0;
        if (this._a() != null) {
            bl = this._a().isDamaged(this);
        }
        return this._f() && bl;
    }

    public int _i() {
        if (this._a() != null) {
            return this._a().getDisplayDamage(this);
        }
        return this._f;
    }

    public int _j() {
        if (this._a() != null) {
            return this._a().getDamage(this);
        }
        return this._f;
    }

    public void _b(int n) {
        if (this._a() != null) {
            this._a().setDamage(this, n);
            return;
        }
        this._f = n;
        if (this._f < 0) {
            this._f = 0;
        }
    }

    public int _k() {
        return this._a().getMaxDamage(this);
    }

    public boolean _a(int n, Random random) {
        if (!this._f()) {
            return false;
        }
        if (n > 0) {
            int n2 = zhty._a(Enchantment._s._y, this);
            int n3 = 0;
            for (int i = 0; n2 > 0 && i < n; ++i) {
                if (!EnchantmentDurability._a(this, n2, random)) continue;
                ++n3;
            }
            if ((n -= n3) <= 0) {
                return false;
            }
        }
        this._b(this._j() + n);
        return this._j() > this._k();
    }

    public void _a(int n, EntityLivingBase entityLivingBase) {
        if ((!(entityLivingBase instanceof EntityPlayer) || !((EntityPlayer)entityLivingBase).capabilities._d) && this._f() && this._a(n, entityLivingBase.getRNG())) {
            entityLivingBase.renderBrokenItemStack(this);
            --this._b;
            if (entityLivingBase instanceof EntityPlayer) {
                EntityPlayer entityPlayer = (EntityPlayer)entityLivingBase;
                entityPlayer.addStat(dzif._F[this._d], 1);
                if (this._b == 0 && this._a() instanceof ItemBow) {
                    entityPlayer.destroyCurrentEquippedItem();
                }
            }
            if (this._b < 0) {
                this._b = 0;
            }
            this._f = 0;
        }
    }

    public void _a(EntityLivingBase entityLivingBase, EntityPlayer entityPlayer) {
        boolean bl = Item.itemsList[this._d].hitEntity(this, entityLivingBase, entityPlayer);
        if (bl) {
            entityPlayer.addStat(dzif._E[this._d], 1);
        }
    }

    public void _a(World world, int n, int n2, int n3, int n4, EntityPlayer entityPlayer) {
        boolean bl = Item.itemsList[this._d].onBlockDestroyed(this, world, n, n2, n3, n4, entityPlayer);
        if (bl) {
            entityPlayer.addStat(dzif._E[this._d], 1);
        }
    }

    public boolean _b(Block block) {
        return Item.itemsList[this._d].canHarvestBlock(block, this);
    }

    public boolean _a(EntityPlayer entityPlayer, EntityLivingBase entityLivingBase) {
        return Item.itemsList[this._d].itemInteractionForEntity(this, entityPlayer, entityLivingBase);
    }

    public ItemStack _l() {
        ItemStack itemStack = new ItemStack(this._d, this._b, this._f);
        if (this._e != null) {
            itemStack._e = (NBTTagCompound)this._e._c();
        }
        return itemStack;
    }

    public static boolean _a(ItemStack itemStack, ItemStack itemStack2) {
        return itemStack == null && itemStack2 == null ? true : (itemStack != null && itemStack2 != null ? (itemStack._e == null && itemStack2._e != null ? false : itemStack._e == null || itemStack._e.equals(itemStack2._e)) : false);
    }

    public static boolean _b(ItemStack itemStack, ItemStack itemStack2) {
        return itemStack == null && itemStack2 == null ? true : (itemStack != null && itemStack2 != null ? itemStack._a(itemStack2) : false);
    }

    public boolean _a(ItemStack itemStack) {
        return this._b != itemStack._b ? false : (this._d != itemStack._d ? false : (this._f != itemStack._f ? false : (this._e == null && itemStack._e != null ? false : this._e == null || this._e.equals(itemStack._e))));
    }

    public boolean _b(ItemStack itemStack) {
        return this._d == itemStack._d && this._f == itemStack._f;
    }

    public String _m() {
        return Item.itemsList[this._d].getUnlocalizedName(this);
    }

    public static ItemStack _c(ItemStack itemStack) {
        return itemStack == null ? null : itemStack._l();
    }

    public String toString() {
        return this._b + "x" + Item.itemsList[this._d].getUnlocalizedName() + "@" + this._f;
    }

    public void _a(World world, Entity entity, int n, boolean bl) {
        if (this._c > 0) {
            --this._c;
        }
        Item.itemsList[this._d].onUpdate(this, world, entity, n, bl);
    }

    public void _a(World world, EntityPlayer entityPlayer, int n) {
        entityPlayer.addStat(dzif._D[this._d], n);
        Item.itemsList[this._d].onCreated(this, world, entityPlayer);
    }

    public int _n() {
        return this._a().getMaxItemUseDuration(this);
    }

    public EnumAction _o() {
        return this._a().getItemUseAction(this);
    }

    public void _b(World world, EntityPlayer entityPlayer, int n) {
        this._a().onPlayerStoppedUsing(this, world, entityPlayer, n);
    }

    public boolean _p() {
        return this._e != null;
    }

    public NBTTagCompound _q() {
        return this._e;
    }

    public NBTTagList _r() {
        return this._e == null ? null : (NBTTagList)this._e._b("ench");
    }

    public void _d(NBTTagCompound nBTTagCompound) {
        this._e = nBTTagCompound;
    }

    public String _s() {
        NBTTagCompound nBTTagCompound;
        String string = this._a().getItemDisplayName(this);
        if (this._e != null && this._e._c("display") && (nBTTagCompound = this._e._m("display"))._c("Name")) {
            string = nBTTagCompound._j("Name");
        }
        String string2 = string;
        String string3 = GloomyHooks.getDisplayName(this, string2);
        return string3;
    }

    public void _a(String string) {
        if (this._e == null) {
            this._e = new NBTTagCompound("tag");
        }
        if (!this._e._c("display")) {
            this._e._a("display", new NBTTagCompound());
        }
        this._e._m("display")._a("Name", string);
    }

    public void _t() {
        if (this._e != null && this._e._c("display")) {
            NBTTagCompound nBTTagCompound = this._e._m("display");
            nBTTagCompound._p("Name");
            if (nBTTagCompound._e()) {
                this._e._p("display");
                if (this._e._e()) {
                    this._d(null);
                }
            }
        }
    }

    public boolean _u() {
        return this._e == null ? false : (!this._e._c("display") ? false : this._e._m("display")._c("Name"));
    }

    @SideOnly(value=Side.CLIENT)
    public List _a(EntityPlayer entityPlayer, boolean bl) {
        Object object;
        ArrayList<String> arrayList = new ArrayList<String>();
        Item item = Item.itemsList[this._d];
        String string = this._s();
        if (this._u()) {
            string = (Object)((Object)EnumChatFormatting._u) + string + (Object)((Object)EnumChatFormatting._v);
        }
        if (bl) {
            object = "";
            if (string.length() > 0) {
                string = string + " (";
                object = ")";
            }
            string = this._g() ? string + String.format("#%04d/%d%s", this._d, this._f, object) : string + String.format("#%04d%s", this._d, object);
        } else if (!this._u() && this._d == Item.map.itemID) {
            string = string + " #" + this._f;
        }
        arrayList.add(string);
        item.addInformation(this, entityPlayer, arrayList, bl);
        if (this._p()) {
            int n;
            object = this._r();
            if (object != null) {
                for (int i = 0; i < ((NBTTagList)object)._d(); ++i) {
                    short s = ((NBTTagCompound)((NBTTagList)object)._b(i))._e("id");
                    n = ((NBTTagCompound)((NBTTagList)object)._b(i))._e("lvl");
                    if (Enchantment._a[s] == null) continue;
                    arrayList.add(Enchantment._a[s]._c(n));
                }
            }
            if (this._e._c("display")) {
                NBTTagList nBTTagList;
                NBTTagCompound nBTTagCompound = this._e._m("display");
                if (nBTTagCompound._c("color")) {
                    if (bl) {
                        arrayList.add("Color: #" + Integer.toHexString(nBTTagCompound._f("color")).toUpperCase());
                    } else {
                        arrayList.add((Object)((Object)EnumChatFormatting._u) + tdpx._a("item.dyed"));
                    }
                }
                if (nBTTagCompound._c("Lore") && (nBTTagList = nBTTagCompound._n("Lore"))._d() > 0) {
                    for (n = 0; n < nBTTagList._d(); ++n) {
                        arrayList.add((Object)((Object)EnumChatFormatting._f) + "" + (Object)((Object)EnumChatFormatting._u) + ((NBTTagString)nBTTagList._b((int)n))._c);
                    }
                }
            }
        }
        if (!(object = this._D()).isEmpty()) {
            arrayList.add("");
            for (Map.Entry entry : object.entries()) {
                AttributeModifier attributeModifier = (AttributeModifier)entry.getValue();
                double d = attributeModifier._d();
                double d2 = attributeModifier._c() != 1 && attributeModifier._c() != 2 ? attributeModifier._d() : attributeModifier._d() * 100.0;
                if (d > 0.0) {
                    arrayList.add((Object)((Object)EnumChatFormatting._j) + tdpx._a("attribute.modifier.plus." + attributeModifier._c(), _a.format(d2), tdpx._a("attribute.name." + (String)entry.getKey())));
                    continue;
                }
                if (!(d < 0.0)) continue;
                arrayList.add((Object)((Object)EnumChatFormatting._m) + tdpx._a("attribute.modifier.take." + attributeModifier._c(), _a.format(d2 *= -1.0), tdpx._a("attribute.name." + (String)entry.getKey())));
            }
        }
        if (bl && this._h()) {
            arrayList.add("Durability: " + (this._k() - this._i()) + " / " + this._k());
        }
        ForgeEventFactory.onItemTooltip(this, entityPlayer, arrayList, bl);
        return arrayList;
    }

    @Deprecated
    @SideOnly(value=Side.CLIENT)
    public boolean _v() {
        return this._c(0);
    }

    @SideOnly(value=Side.CLIENT)
    public boolean _c(int n) {
        return this._a().hasEffect(this, n);
    }

    @SideOnly(value=Side.CLIENT)
    public EnumRarity _w() {
        return this._a().getRarity(this);
    }

    public boolean _x() {
        return !this._a().isItemTool(this) ? false : !this._y();
    }

    public void _a(Enchantment enchantment, int n) {
        if (this._e == null) {
            this._d(new NBTTagCompound());
        }
        if (!this._e._c("ench")) {
            this._e._a("ench", new NBTTagList("ench"));
        }
        NBTTagList nBTTagList = (NBTTagList)this._e._b("ench");
        NBTTagCompound nBTTagCompound = new NBTTagCompound();
        nBTTagCompound._a("id", (short)enchantment._y);
        nBTTagCompound._a("lvl", (short)((byte)n));
        nBTTagList._a(nBTTagCompound);
    }

    public boolean _y() {
        return this._e != null && this._e._c("ench");
    }

    public void _a(String string, NBTBase nBTBase) {
        if (this._e == null) {
            this._d(new NBTTagCompound());
        }
        this._e._a(string, nBTBase);
    }

    public boolean _z() {
        return this._a().canItemEditBlocks();
    }

    public boolean _A() {
        return this._g != null;
    }

    public void _a(EntityItemFrame entityItemFrame) {
        this._g = entityItemFrame;
    }

    public EntityItemFrame _B() {
        return this._g;
    }

    public int _C() {
        return this._p() && this._e._c("RepairCost") ? this._e._f("RepairCost") : 0;
    }

    public void _d(int n) {
        if (!this._p()) {
            this._e = new NBTTagCompound("tag");
        }
        this._e._a("RepairCost", n);
    }

    public Multimap _D() {
        HashMultimap hashMultimap;
        if (this._p() && this._e._c("AttributeModifiers")) {
            hashMultimap = HashMultimap.create();
            NBTTagList nBTTagList = this._e._n("AttributeModifiers");
            for (int i = 0; i < nBTTagList._d(); ++i) {
                NBTTagCompound nBTTagCompound = (NBTTagCompound)nBTTagList._b(i);
                AttributeModifier attributeModifier = sajz._a(nBTTagCompound);
                if (attributeModifier._a().getLeastSignificantBits() == 0L || attributeModifier._a().getMostSignificantBits() == 0L) continue;
                ((Multimap)hashMultimap).put(nBTTagCompound._j("AttributeName"), attributeModifier);
            }
        } else {
            hashMultimap = this._a().getItemAttributeModifiers();
        }
        return hashMultimap;
    }
}

