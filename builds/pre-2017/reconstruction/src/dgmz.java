/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.client.gui.screens.GuiItem;
import gloomyfolken.mods.core.main.GloomyCore;
import gloomyfolken.mods.core.misc.eifc;
import gloomyfolken.mods.core.misc.ezfa;
import gloomyfolken.mods.core.misc.jgro;
import gloomyfolken.mods.core.misc.jxsn;
import gloomyfolken.mods.core.misc.tdmn;
import gloomyfolken.mods.core.misc.vjta;
import gloomyfolken.mods.stalker.misc.tupg;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.src.ModLoader;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.ISpecialArmor;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

public class dgmz
extends ItemArmor
implements aofo,
culm,
ezfa,
jxsn,
tdmn,
vjta,
ISpecialArmor,
oxnm,
tezq,
tfdj {
    static final String _b = "DURABILITY_FACTOR";
    public String _c = "";
    public String _d = "";
    public String _e;
    public String _f;
    public String _g;
    public int _h = 0;
    public boolean _i;
    public boolean _j;
    public xafi _k = new xafi();
    public List<String> _l = new ArrayList<String>();
    public boolean _m;
    public int _n;
    public EnumRarity _o;
    public pjov _p = new pjov();
    public int[] _q;
    public float _r = 0.0f;
    public final boolean _s;
    private static final String _t = "upgrades";
    private static final String _u = "id";
    private static final String _v = "level";
    private static final xafi _w = new xafi();

    public dgmz(int n, String string, EnumArmorMaterial enumArmorMaterial, int n2, int n3) {
        super(n - 256, enumArmorMaterial, dgmz._a(enumArmorMaterial.name().toLowerCase() + dgmz._a(n2)), n2);
        this.setCreativeTab(GloomyCore.tab);
        this.setUnlocalizedName(eifc._a(string) + "_" + this.itemID);
        LanguageRegistry.addName(this, string);
        this._s = n2 == 1;
        this.setMaxDamage(n3);
    }

    @Override
    public EnumRarity getRarity(ItemStack itemStack) {
        return this._o == null ? Item.sugar.getRarity(itemStack) : this._o;
    }

    @Override
    public void _a(ItemStack itemStack, EntityPlayer entityPlayer, List<String> list2) {
        if (!this._m) {
            if (this._q == null) {
                list2.add((Object)((Object)EnumChatFormatting._c) + "\u0421\u043e\u0432\u043c\u0435\u0441\u0442\u0438\u043c\u043e \u0441 \u043b\u044e\u0431\u044b\u043c \u0440\u044e\u043a\u0437\u0430\u043a\u043e\u043c");
            } else if (this._q.length == 0) {
                list2.add((Object)((Object)EnumChatFormatting._e) + "\u041d\u0435\u0432\u043e\u0437\u043c\u043e\u0436\u043d\u043e \u043d\u043e\u0441\u0438\u0442\u044c \u0441 \u0440\u044e\u043a\u0437\u0430\u043a\u043e\u043c");
            } else {
                list2.add((Object)((Object)EnumChatFormatting._o) + "\u0421\u043e\u0432\u043c\u0435\u0441\u0442\u0438\u043c\u043e \u0441 \u043d\u0435\u043a\u043e\u0442\u043e\u0440\u044b\u043c\u0438 \u0440\u044e\u043a\u0437\u0430\u043a\u0430\u043c\u0438");
            }
            if (this._i) {
                list2.add((Object)((Object)EnumChatFormatting._c) + "\u041d\u0430\u043b\u043e\u0431\u043d\u044b\u0439 \u0444\u043e\u043d\u0430\u0440\u044c");
            }
            if (this._j) {
                list2.add((Object)((Object)EnumChatFormatting._c) + "\u041f\u0440\u0438\u0431\u043e\u0440 \u043d\u043e\u0447\u043d\u043e\u0433\u043e \u0432\u0438\u0434\u0435\u043d\u0438\u044f");
            }
            if (this._n != 0) {
                list2.add((Object)((Object)EnumChatFormatting._c) + "\u0421\u043b\u043e\u0442\u043e\u0432 \u0434\u043b\u044f \u0430\u0440\u0442\u0435\u0444\u0430\u043a\u0442\u043e\u0432: " + this._n);
            }
            if (itemStack._e != null) {
                NBTTagList nBTTagList = itemStack._e._n(_t);
                for (int i = 0; i < nBTTagList._d(); ++i) {
                    NBTTagCompound nBTTagCompound = (NBTTagCompound)nBTTagList._b(i);
                    int n = nBTTagCompound._f(_u);
                    int n2 = nBTTagCompound._f(_v);
                    if (n <= 0 || n >= 32000 || !(Item.itemsList[n] instanceof bafv)) continue;
                    bafv bafv2 = (bafv)Item.itemsList[n];
                    list2.add((Object)((Object)EnumChatFormatting._c) + bafv2.getItemDisplayName(null) + " " + n2);
                }
            }
            list2.addAll(this._g_(itemStack)._a());
            this._a(itemStack, list2);
        }
    }

    private void _a(ItemStack itemStack, List<String> list2) {
        float f;
        if (itemStack._e != null && itemStack._e._c(_b) && (double)Math.abs(f = jgro._a(itemStack._e._h(_b))) >= 0.01) {
            list2.add(" ");
            list2.add((Object)((Object)EnumChatFormatting._j) + "\u041f\u0440\u043e\u0447\u043d\u043e\u0441\u0442\u044c \u0431\u0440\u043e\u043d\u0438: " + jgro._g(f));
        }
    }

    @Override
    public void _b(ItemStack itemStack, EntityPlayer entityPlayer, List<String> list2) {
        if (this._q != null && this._q.length > 0) {
            ArrayList<String> arrayList = new ArrayList<String>(this._q.length);
            for (int i = 0; i < this._q.length; ++i) {
                Item item = Item.itemsList[this._q[i]];
                if (!(item instanceof brhe)) continue;
                arrayList.add(item.getItemDisplayName(null));
            }
            list2.add("\u0421\u043e\u0432\u043c\u0435\u0441\u0442\u0438\u043c\u044b\u0435 \u0440\u044e\u043a\u0437\u0430\u043a\u0438: " + StringUtils.join(arrayList, ", ") + ".");
        }
        list2.addAll(this._l);
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public boolean requiresMultipleRenderPasses() {
        return false;
    }

    @Override
    public boolean hasColor(ItemStack itemStack) {
        return false;
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public String getArmorTexture(ItemStack itemStack, Entity entity, int n, int n2) {
        return "stalker:textures/armor/empty.png";
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public void registerIcons(IconRegister iconRegister) {
        this.itemIcon = iconRegister._b("stalker:" + this._c);
    }

    public static String _a(int n) {
        if (n == 0) {
            return "_helm";
        }
        if (n == 1) {
            return "_chest";
        }
        if (n == 2) {
            return "_legs";
        }
        if (n == 3) {
            return "_boots";
        }
        return "";
    }

    public static int _a(String string) {
        if (GloomyCore.side == Side.CLIENT) {
            return ModLoader.addArmor(string);
        }
        return 1;
    }

    @Override
    public int getEntityLifespan(ItemStack itemStack, World world) {
        return 288000;
    }

    @Override
    public boolean _j(ItemStack itemStack) {
        return this._i;
    }

    @Override
    public boolean _b() {
        return false;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
        if (this.armorType == 1 && !this._k(tupg._a((EntityPlayer)entityPlayer)._c._e())) {
            return itemStack;
        }
        return super.onItemRightClick(itemStack, world, entityPlayer);
    }

    public boolean _k(ItemStack itemStack) {
        return this._q == null || itemStack == null || ArrayUtils.contains(this._q, itemStack._d);
    }

    @Override
    public xafi _g_(ItemStack itemStack) {
        if (itemStack._f() && itemStack._j() >= itemStack._k()) {
            return _w;
        }
        if (itemStack._e == null && !this.isDamageable()) {
            return this._k;
        }
        xafi xafi2 = this._k._c();
        NBTTagCompound nBTTagCompound = ncwh._c(itemStack);
        if (nBTTagCompound._c(_t)) {
            NBTTagList nBTTagList = nBTTagCompound._n(_t);
            for (int i = 0; i < nBTTagList._d(); ++i) {
                NBTTagCompound nBTTagCompound2 = (NBTTagCompound)nBTTagList._b(i);
                int n = nBTTagCompound2._f(_u);
                int n2 = nBTTagCompound2._f(_v);
                if (n <= 0 || n >= 32000 || !(Item.itemsList[n] instanceof bafv)) continue;
                bafv bafv2 = (bafv)Item.itemsList[n];
                bafv2._b._a(xafi2, n2);
            }
        }
        xafi2._f(this._c_(itemStack));
        return xafi2;
    }

    public static int _a(ItemStack itemStack, bafv bafv2) {
        if (itemStack._e == null) {
            return 0;
        }
        NBTTagCompound nBTTagCompound = ncwh._c(itemStack);
        NBTTagList nBTTagList = nBTTagCompound._n(_t);
        for (int i = 0; i < nBTTagList._d(); ++i) {
            NBTTagCompound nBTTagCompound2 = (NBTTagCompound)nBTTagList._b(i);
            int n = nBTTagCompound2._f(_u);
            if (n != bafv2.itemID) continue;
            return nBTTagCompound2._f(_v);
        }
        return 0;
    }

    public static void _a(ItemStack itemStack, bafv bafv2, int n) {
        NBTTagCompound nBTTagCompound = ncwh._b(itemStack);
        if (!nBTTagCompound._c(_t)) {
            nBTTagCompound._a(_t, new NBTTagList());
        }
        NBTTagList nBTTagList = nBTTagCompound._n(_t);
        for (int i = 0; i < nBTTagList._d(); ++i) {
            NBTTagCompound nBTTagCompound2 = (NBTTagCompound)nBTTagList._b(i);
            int n2 = nBTTagCompound2._f(_u);
            if (n2 != bafv2.itemID) continue;
            if (n > 0) {
                nBTTagCompound2._a(_v, n);
            } else {
                nBTTagList._a(i);
            }
            return;
        }
        if (n > 0) {
            NBTTagCompound nBTTagCompound3 = new NBTTagCompound();
            nBTTagCompound3._a(_u, bafv2.itemID);
            nBTTagCompound3._a(_v, n);
            nBTTagList._a(nBTTagCompound3);
        }
    }

    @Override
    public ISpecialArmor.ArmorProperties getProperties(EntityLivingBase entityLivingBase, ItemStack itemStack, DamageSource damageSource, double d, int n) {
        return new ISpecialArmor.ArmorProperties(0, 0.0, 0);
    }

    @Override
    public int getArmorDisplay(EntityPlayer entityPlayer, ItemStack itemStack, int n) {
        return 0;
    }

    @Override
    public pjov _i(ItemStack itemStack) {
        return this._p;
    }

    @Override
    public void damageArmor(EntityLivingBase entityLivingBase, ItemStack itemStack, DamageSource damageSource, int n, int n2) {
    }

    @Override
    public int getDamage(ItemStack itemStack) {
        return (int)this._h(itemStack);
    }

    @Override
    public int getMaxDamage(ItemStack itemStack) {
        if (itemStack._e != null && itemStack._e._o("unbreakable")) {
            return 0;
        }
        float f = super.getMaxDamage(itemStack);
        if (itemStack._e != null && itemStack._q()._c(_b)) {
            f *= itemStack._e._h(_b);
        }
        return (int)(f *= this._e_(itemStack));
    }

    @Override
    public void setDamage(ItemStack itemStack, int n) {
        this._a(itemStack, (double)n);
    }

    @Override
    public int getDisplayDamage(ItemStack itemStack) {
        return this.getDamage(itemStack);
    }

    @Override
    public boolean isDamaged(ItemStack itemStack) {
        return this.getDamage(itemStack) > 0;
    }

    @Override
    public int _h_(ItemStack itemStack) {
        return this._h;
    }

    @Override
    public String _a() {
        return "stalker:disassembly_armor";
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public boolean _l_(ItemStack itemStack) {
        return this._s;
    }

    @ezey(_a={eidj.CLIENT})
    public GuiItem _b(GuiScreen guiScreen, EntityPlayer entityPlayer, ItemStack itemStack, int n) {
        return n < 0 ? new gpqn(guiScreen, itemStack) : new ievb(guiScreen, entityPlayer, n);
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public /* synthetic */ GuiScreen _a(GuiScreen guiScreen, EntityPlayer entityPlayer, ItemStack itemStack, int n) {
        return this._b(guiScreen, entityPlayer, itemStack, n);
    }
}

