/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.creativetab;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CreativeTabs {
    public static CreativeTabs[] creativeTabArray = new CreativeTabs[12];
    public static final CreativeTabs tabBlock = new jjev(0, "buildingBlocks");
    public static final CreativeTabs tabDecorations = new yela(1, "decorations");
    public static final CreativeTabs tabRedstone = new cvrk(2, "redstone");
    public static final CreativeTabs tabTransport = new bsof(3, "transportation");
    public static final CreativeTabs tabMisc = new ixdp(4, "misc").func_111229_a(EnumEnchantmentType._a);
    public static final CreativeTabs tabAllSearch = new qnyl(5, "search").setBackgroundImageName("item_search.png");
    public static final CreativeTabs tabFood = new wpkb(6, "food");
    public static final CreativeTabs tabTools = new xsnm(7, "tools").func_111229_a(EnumEnchantmentType._h);
    public static final CreativeTabs tabCombat = new oyug(8, "combat").func_111229_a(EnumEnchantmentType._b, EnumEnchantmentType._c, EnumEnchantmentType._f, EnumEnchantmentType._d, EnumEnchantmentType._e, EnumEnchantmentType._i, EnumEnchantmentType._g);
    public static final CreativeTabs tabBrewing = new pkse(9, "brewing");
    public static final CreativeTabs tabMaterials = new bsok(10, "materials");
    public static final CreativeTabs tabInventory = new oyub(11, "inventory").setBackgroundImageName("inventory.png").setNoScrollbar().setNoTitle();
    public final int tabIndex;
    public final String tabLabel;
    public String field_78043_p = "items.png";
    public boolean hasScrollbar = true;
    public boolean drawTitle = true;
    public EnumEnchantmentType[] field_111230_s;

    public CreativeTabs(String string) {
        this(CreativeTabs.getNextID(), string);
    }

    public CreativeTabs(int n, String string) {
        if (n >= creativeTabArray.length) {
            CreativeTabs[] creativeTabsArray = new CreativeTabs[n + 1];
            for (int i = 0; i < creativeTabArray.length; ++i) {
                creativeTabsArray[i] = creativeTabArray[i];
            }
            creativeTabArray = creativeTabsArray;
        }
        this.tabIndex = n;
        this.tabLabel = string;
        CreativeTabs.creativeTabArray[n] = this;
    }

    @SideOnly(value=Side.CLIENT)
    public int getTabIndex() {
        return this.tabIndex;
    }

    public CreativeTabs setBackgroundImageName(String string) {
        this.field_78043_p = string;
        return this;
    }

    @SideOnly(value=Side.CLIENT)
    public String getTabLabel() {
        return this.tabLabel;
    }

    @SideOnly(value=Side.CLIENT)
    public String getTranslatedTabLabel() {
        return "itemGroup." + this.getTabLabel();
    }

    @SideOnly(value=Side.CLIENT)
    public Item getTabIconItem() {
        return Item.itemsList[this.getTabIconItemIndex()];
    }

    @SideOnly(value=Side.CLIENT)
    public int getTabIconItemIndex() {
        return 1;
    }

    @SideOnly(value=Side.CLIENT)
    public String getBackgroundImageName() {
        return this.field_78043_p;
    }

    @SideOnly(value=Side.CLIENT)
    public boolean drawInForegroundOfTab() {
        return this.drawTitle;
    }

    public CreativeTabs setNoTitle() {
        this.drawTitle = false;
        return this;
    }

    @SideOnly(value=Side.CLIENT)
    public boolean shouldHidePlayerInventory() {
        return this.hasScrollbar;
    }

    public CreativeTabs setNoScrollbar() {
        this.hasScrollbar = false;
        return this;
    }

    @SideOnly(value=Side.CLIENT)
    public int getTabColumn() {
        if (this.tabIndex > 11) {
            return (this.tabIndex - 12) % 10 % 5;
        }
        return this.tabIndex % 6;
    }

    @SideOnly(value=Side.CLIENT)
    public boolean isTabInFirstRow() {
        if (this.tabIndex > 11) {
            return (this.tabIndex - 12) % 10 < 5;
        }
        return this.tabIndex < 6;
    }

    @SideOnly(value=Side.CLIENT)
    public EnumEnchantmentType[] func_111225_m() {
        return this.field_111230_s;
    }

    public CreativeTabs func_111229_a(EnumEnchantmentType ... enumEnchantmentTypeArray) {
        this.field_111230_s = enumEnchantmentTypeArray;
        return this;
    }

    @SideOnly(value=Side.CLIENT)
    public boolean func_111226_a(EnumEnchantmentType enumEnchantmentType) {
        if (this.field_111230_s == null) {
            return false;
        }
        for (EnumEnchantmentType enumEnchantmentType2 : this.field_111230_s) {
            if (enumEnchantmentType2 != enumEnchantmentType) continue;
            return true;
        }
        return false;
    }

    @SideOnly(value=Side.CLIENT)
    public void displayAllReleventItems(List list2) {
        for (Item item : Item.itemsList) {
            if (item == null) continue;
            for (CreativeTabs creativeTabs : item.getCreativeTabs()) {
                if (creativeTabs != this) continue;
                item.getSubItems(item.itemID, this, list2);
            }
        }
        if (this.func_111225_m() != null) {
            this.addEnchantmentBooksToList(list2, this.func_111225_m());
        }
    }

    @SideOnly(value=Side.CLIENT)
    public void addEnchantmentBooksToList(List list2, EnumEnchantmentType ... enumEnchantmentTypeArray) {
        for (Enchantment enchantment : Enchantment._a) {
            if (enchantment == null || enchantment._A == null) continue;
            boolean bl = false;
            for (int i = 0; i < enumEnchantmentTypeArray.length && !bl; ++i) {
                if (enchantment._A != enumEnchantmentTypeArray[i]) continue;
                bl = true;
            }
            if (!bl) continue;
            list2.add(Item.enchantedBook._a(new ixcc(enchantment, enchantment._c())));
        }
    }

    public int getTabPage() {
        if (this.tabIndex > 11) {
            return (this.tabIndex - 12) / 10 + 1;
        }
        return 0;
    }

    public static int getNextID() {
        return creativeTabArray.length;
    }

    public ItemStack getIconItemStack() {
        return new ItemStack(this.getTabIconItem());
    }

    public boolean hasSearchBar() {
        return this.tabIndex == CreativeTabs.tabAllSearch.tabIndex;
    }
}

