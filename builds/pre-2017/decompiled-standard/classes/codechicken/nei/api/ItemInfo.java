/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei.api;

import codechicken.core.CommonUtils;
import codechicken.lib.inventory.ItemKey;
import codechicken.lib.lang.LangUtil;
import codechicken.nei.InfiniteStackSizeHandler;
import codechicken.nei.InfiniteToolHandler;
import codechicken.nei.MultiItemRange;
import codechicken.nei.PopupInputHandler;
import codechicken.nei.api.API;
import codechicken.nei.api.IHighlightHandler;
import codechicken.nei.api.IInfiniteItemHandler;
import codechicken.nei.config.ArrayDumper;
import codechicken.nei.config.ItemPanelDumper;
import codechicken.nei.forge.GuiContainerManager;
import codechicken.nei.recipe.BrewingRecipeHandler;
import codechicken.nei.recipe.RecipeItemInputHandler;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.ItemData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import net.minecraft.entity.jgro;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityMooshroom;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.zwaw;
import net.minecraft.util.hank;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.IShearable;

public class ItemInfo {
    public static final HashMap<Layout, ArrayList<IHighlightHandler>> highlightHandlers = new HashMap();
    public static final HashMap<ItemKey, String> fallbackNames = new HashMap();
    public static final HashSet<Integer> excludeIds = new HashSet();
    public static final HashSet<Integer> nonUnlimitedIds = new HashSet();
    public static final HashMap<Integer, ArrayList<int[]>> damageVariants = new HashMap();
    public static final ArrayList<int[]> defaultDamageRange = new ArrayList();
    public static final HashMap<Integer, ArrayList<cvzo>> itemcompounds = new HashMap();
    public static final LinkedList<IInfiniteItemHandler> infiniteHandlers = new LinkedList();
    public static final HashMap<Integer, ArrayList<IHighlightHandler>> highlightIdentifiers = new HashMap();
    public static final HashSet<Class<? extends yeso>> fastTransferExemptions = new HashSet();
    public static final String[] itemOwners = new String[tgdv.field_77698_e.length];

    public static boolean isHidden(int n) {
        return excludeIds.contains(n);
    }

    public static ArrayList<int[]> getItemDamageVariants(int n) {
        ArrayList<int[]> arrayList = damageVariants.get(n);
        return arrayList == null ? defaultDamageRange : arrayList;
    }

    public static String getOverrideName(int n, int n2) {
        ItemKey itemKey = new ItemKey(n, n2);
        return fallbackNames.get(itemKey);
    }

    public static boolean canItemBeUnlimited(int n) {
        return !nonUnlimitedIds.contains(n);
    }

    public static ArrayList<cvzo> getItemCompounds(int n) {
        return itemcompounds.get(n);
    }

    public static void load(ozlu ozlu2) {
        defaultDamageRange.add(new int[]{0, 15});
        ItemInfo.addVanillaBlockProperties();
        ItemInfo.addDefaultDropDowns();
        ItemInfo.searchItems();
        ItemInfo.parseModItems();
        ItemInfo.addSpawnEggs();
        new BrewingRecipeHandler().searchPotions();
        ItemInfo.addInfiniteHandlers();
        ItemInfo.addInputHandlers();
        ItemInfo.addIDDumps();
    }

    private static void addIDDumps() {
        API.addOption(new ArrayDumper<tgdv>("tools.dump.item"){

            @Override
            public String[] header() {
                return new String[]{"ID", "Block/Item", "Mod", "Unlocalised name", "Class"};
            }

            @Override
            public String[] dump(int n, tgdv tgdv2) {
                twgu twgu2 = n < twgu.field_71973_m.length ? twgu.field_71973_m[n] : null;
                return new String[]{Integer.toString(n), twgu2 != null ? "Block" : "Item", itemOwners[n], twgu2 != null ? twgu2.func_71917_a() : tgdv2.func_77658_a(), (twgu2 != null ? twgu2 : tgdv2).getClass().getCanonicalName()};
            }

            public tgdv[] array() {
                return tgdv.field_77698_e;
            }
        });
        API.addOption(new ArrayDumper<hdpq>("tools.dump.potion"){

            @Override
            public String[] header() {
                return new String[]{"ID", "Unlocalised name", "Class"};
            }

            @Override
            public String[] dump(int n, hdpq hdpq2) {
                return new String[]{Integer.toString(n), hdpq2._c(), hdpq2.getClass().getCanonicalName()};
            }

            public hdpq[] array() {
                return hdpq._a;
            }
        });
        API.addOption(new ArrayDumper<zhqo>("tools.dump.enchantment"){

            @Override
            public String[] header() {
                return new String[]{"ID", "Unlocalised name", "Type", "Min Level", "Max Level", "Class"};
            }

            @Override
            public String[] dump(int n, zhqo zhqo2) {
                return new String[]{Integer.toString(n), zhqo2._d(), zhqo2._A.toString(), Integer.toString(zhqo2._b()), Integer.toString(zhqo2._c()), zhqo2.getClass().getCanonicalName()};
            }

            public zhqo[] array() {
                return zhqo._a;
            }
        });
        API.addOption(new ArrayDumper<foqh>("tools.dump.biome"){

            @Override
            public String[] header() {
                return new String[]{"ID", "Name", "Temperature", "Rainfall", "Spawn Chance", "Min Height", "Max Height", "Types", "Class"};
            }

            @Override
            public String[] dump(int n, foqh foqh2) {
                BiomeDictionary.Type[] typeArray = BiomeDictionary.getTypesForBiome(foqh2);
                StringBuilder stringBuilder = new StringBuilder();
                for (BiomeDictionary.Type type : typeArray) {
                    if (stringBuilder.length() > 0) {
                        stringBuilder.append(", ");
                    }
                    stringBuilder.append(type.name());
                }
                return new String[]{Integer.toString(n), foqh2._y, Float.toString(foqh2._k()), Float.toString(foqh2._j()), Float.toString(foqh2._g()), Float.toString(foqh2._D), Float.toString(foqh2._E), stringBuilder.toString(), foqh2.getClass().getCanonicalName()};
            }

            public foqh[] array() {
                return foqh._a;
            }
        });
        API.addOption(new ItemPanelDumper("tools.dump.itempanel"));
    }

    private static void parseModItems() {
        Object object;
        bsyv bsyv2 = new bsyv();
        GameData.writeItemData(bsyv2);
        HashMap<String, MultiItemRange> hashMap = new HashMap<String, MultiItemRange>();
        for (int i = 0; i < bsyv2._d(); ++i) {
            Map.Entry entry = new ItemData((qoac)bsyv2._b(i));
            object = (MultiItemRange)hashMap.get(((ItemData)((Object)entry)).getModId());
            if (object == null) {
                object = new MultiItemRange();
                hashMap.put(((ItemData)((Object)entry)).getModId(), (MultiItemRange)object);
            }
            ItemInfo.itemOwners[((ItemData)((Object)entry)).getItemId()] = ((ItemData)((Object)entry)).getModId();
            ((MultiItemRange)object).add(((ItemData)((Object)entry)).getItemId());
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            object = (String)entry.getKey();
            ModContainer modContainer = CommonUtils.findModContainer((String)object);
            Object object2 = modContainer == null ? object : modContainer.getName();
            API.addSetRange("Mod." + (String)object2, (MultiItemRange)entry.getValue());
        }
    }

    private static void addInputHandlers() {
        GuiContainerManager.addInputHandler(new RecipeItemInputHandler());
        GuiContainerManager.addInputHandler(new PopupInputHandler());
    }

    private static void addInfiniteHandlers() {
        API.addInfiniteItemHandler(new InfiniteStackSizeHandler());
        API.addInfiniteItemHandler(new InfiniteToolHandler());
    }

    private static void addVanillaBlockProperties() {
        API.setOverrideName(twgu.field_71942_A.field_71990_ca, 0, "Water Source");
        API.setMaxDamageException(twgu.field_71942_A.field_71990_ca, 0);
        API.setOverrideName(twgu.field_71943_B.field_71990_ca, 0, "Water Still");
        API.setMaxDamageException(twgu.field_71943_B.field_71990_ca, 0);
        API.setOverrideName(twgu.field_71944_C.field_71990_ca, 0, "Lava Source");
        API.setMaxDamageException(twgu.field_71944_C.field_71990_ca, 0);
        API.setOverrideName(twgu.field_71938_D.field_71990_ca, 0, "Lava Still");
        API.setMaxDamageException(twgu.field_71938_D.field_71990_ca, 0);
        API.setOverrideName(twgu.field_72006_bl.field_71990_ca, 0, "Silverfish Stone");
        API.setOverrideName(twgu.field_72102_bH.field_71990_ca, 0, "End Portal");
        API.setOverrideName(twgu.field_72104_bI.field_71990_ca, 0, "End Portal Frame");
        API.hideItem(twgu.field_72099_aa.field_71990_ca);
        API.hideItem(twgu.field_72095_ac.field_71990_ca);
        API.hideItem(twgu.field_71999_bt.field_71990_ca);
        API.hideItem(twgu.field_71996_bs.field_71990_ca);
        API.hideItem(twgu.field_71959_S.field_71990_ca);
        API.hideItem(twgu.field_72075_av.field_71990_ca);
        API.hideItem(twgu.field_72058_az.field_71990_ca);
        API.hideItem(twgu.field_72053_aD.field_71990_ca);
        API.hideItem(twgu.field_72054_aE.field_71990_ca);
        API.hideItem(twgu.field_72042_aI.field_71990_ca);
        API.hideItem(twgu.field_72045_aL.field_71990_ca);
        API.hideItem(twgu.field_72048_aO.field_71990_ca);
        API.hideItem(twgu.field_72049_aP.field_71990_ca);
        API.hideItem(twgu.field_72040_aX.field_71990_ca);
        API.hideItem(twgu.field_72010_bh.field_71990_ca);
        API.hideItem(twgu.field_72011_bi.field_71990_ca);
        API.hideItem(twgu.field_72108_bG.field_71990_ca);
        API.hideItem(twgu.field_72094_bD.field_71990_ca);
        API.hideItem(twgu.field_72106_bF.field_71990_ca);
        API.hideItem(twgu.field_72052_aC.field_71990_ca);
        API.hideItem(twgu.field_72080_bM.field_71990_ca);
        API.hideItem(twgu.field_82516_cf.field_71990_ca);
        API.hideItem(twgu.field_82513_cg.field_71990_ca);
        API.hideItem(twgu.field_82514_ch.field_71990_ca);
        API.hideItem(twgu.field_82512_cj.field_71990_ca);
        API.hideItem(twgu.field_72062_bU.field_71990_ca);
    }

    private static void addDefaultDropDowns() {
        API.addSetRange("Blocks", new MultiItemRange("[0-32000]"){

            @Override
            public void addItemIfInRange(int n, int n2, qoac qoac2) {
                if (n < twgu.field_71973_m.length && twgu.field_71973_m[n] != null && twgu.field_71973_m[n].field_72018_cp != tflj._a) {
                    super.addItemIfInRange(n, n2, qoac2);
                }
            }
        });
        API.addSetRange("Items", new MultiItemRange("[0-32000]"){

            @Override
            public void addItemIfInRange(int n, int n2, qoac qoac2) {
                if (n >= twgu.field_71973_m.length || twgu.field_71973_m[n] == null || twgu.field_71973_m[n].field_72018_cp == tflj._a) {
                    super.addItemIfInRange(n, n2, qoac2);
                }
            }
        });
        API.addSetRange("Blocks.MobSpawners", new MultiItemRange("[52]"));
    }

    private static void searchItems() {
        MultiItemRange multiItemRange = new MultiItemRange();
        MultiItemRange multiItemRange2 = new MultiItemRange();
        MultiItemRange multiItemRange3 = new MultiItemRange();
        MultiItemRange multiItemRange4 = new MultiItemRange();
        MultiItemRange multiItemRange5 = new MultiItemRange();
        MultiItemRange multiItemRange6 = new MultiItemRange();
        MultiItemRange multiItemRange7 = new MultiItemRange();
        MultiItemRange multiItemRange8 = new MultiItemRange();
        MultiItemRange multiItemRange9 = new MultiItemRange();
        MultiItemRange multiItemRange10 = new MultiItemRange();
        MultiItemRange multiItemRange11 = new MultiItemRange();
        MultiItemRange multiItemRange12 = new MultiItemRange();
        MultiItemRange multiItemRange13 = new MultiItemRange();
        MultiItemRange multiItemRange14 = new MultiItemRange();
        MultiItemRange[] multiItemRangeArray = new MultiItemRange[tgbl.field_78032_a.length];
        for (tgbl object : tgbl.field_78032_a) {
            multiItemRangeArray[object.func_78021_a()] = new MultiItemRange();
        }
        for (tgdv tgdv2 : tgdv.field_77698_e) {
            if (tgdv2 == null) continue;
            tgbl tgbl2 = tgdv2.func_77640_w();
            if (tgbl2 != null) {
                multiItemRangeArray[tgbl2.func_78021_a()].add(tgdv2);
            }
            if (tgdv2.func_77645_m()) {
                multiItemRange.add(tgdv2);
                if (tgdv2 instanceof hufu) {
                    multiItemRange2.add(tgdv2);
                } else if (tgdv2 instanceof bsws) {
                    multiItemRange3.add(tgdv2);
                } else if (tgdv2 instanceof bsrw) {
                    multiItemRange4.add(tgdv2);
                } else if (tgdv2 instanceof zhxn) {
                    multiItemRange5.add(tgdv2);
                } else if (tgdv2 instanceof vmpw) {
                    multiItemRange6.add(tgdv2);
                } else if (tgdv2 instanceof lpno) {
                    switch (((lpno)tgdv2).field_77881_a) {
                        case 0: {
                            multiItemRange8.add(tgdv2);
                            break;
                        }
                        case 1: {
                            multiItemRange7.add(tgdv2);
                            break;
                        }
                        case 2: {
                            multiItemRange9.add(tgdv2);
                            break;
                        }
                        case 3: {
                            multiItemRange10.add(tgdv2);
                        }
                    }
                } else if (tgdv2 == tgdv.field_77704_l || tgdv2 == tgdv.field_77707_k) {
                    multiItemRange12.add(tgdv2);
                } else if (tgdv2 == tgdv.field_77749_aR || tgdv2 == tgdv.field_77709_i || tgdv2 == tgdv.field_77745_be) {
                    multiItemRange11.add(tgdv2);
                }
            }
            if (tgdv2 instanceof tgha) {
                multiItemRange13.add(tgdv2);
            }
            if (!tgdv2.func_77632_u()) continue;
            BrewingRecipeHandler.ingredientIDs.add(tgdv2.field_77779_bT);
            multiItemRange14.add(tgdv2);
        }
        API.addSetRange("Items.Tools.Pickaxes", multiItemRange2);
        API.addSetRange("Items.Tools.Shovels", multiItemRange3);
        API.addSetRange("Items.Tools.Axes", multiItemRange4);
        API.addSetRange("Items.Tools.Hoes", multiItemRange5);
        API.addSetRange("Items.Tools.Other", multiItemRange11);
        API.addSetRange("Items.Weapons.Swords", multiItemRange6);
        API.addSetRange("Items.Weapons.Ranged", multiItemRange12);
        API.addSetRange("Items.Armor.ChestPlates", multiItemRange7);
        API.addSetRange("Items.Armor.Leggings", multiItemRange9);
        API.addSetRange("Items.Armor.Helmets", multiItemRange8);
        API.addSetRange("Items.Armor.Boots", multiItemRange10);
        API.addSetRange("Items.Food", multiItemRange13);
        API.addSetRange("Items.Potions.Ingredients", multiItemRange14);
        for (tgbl tgbl3 : tgbl.field_78032_a) {
            if (multiItemRangeArray[tgbl3.func_78021_a()].ranges.size() <= 0) continue;
            API.addSetRange("CreativeTabs." + LangUtil.translateG(tgbl3.func_78024_c(), new Object[0]), multiItemRangeArray[tgbl3.func_78021_a()]);
        }
    }

    private static void addSpawnEggs() {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        try {
            HashMap hashMap = (HashMap)jgro._d;
            arrayList.add((Integer)hashMap.get(EntityMooshroom.class));
            arrayList.add((Integer)hashMap.get(EntitySkeleton.class));
            arrayList.add((Integer)hashMap.get(EntityCreeper.class));
            arrayList.add((Integer)hashMap.get(EntitySlime.class));
            arrayList.add((Integer)hashMap.get(EntityZombie.class));
            arrayList.add((Integer)hashMap.get(EntitySpider.class));
            arrayList.add((Integer)hashMap.get(EntityChicken.class));
            arrayList.add((Integer)hashMap.get(EntityCaveSpider.class));
            arrayList.add((Integer)hashMap.get(EntityCow.class));
            arrayList.add((Integer)hashMap.get(EntityEnderman.class));
            arrayList.add((Integer)hashMap.get(EntityWolf.class));
            arrayList.add((Integer)hashMap.get(EntityPigZombie.class));
            arrayList.add((Integer)hashMap.get(EntitySquid.class));
            arrayList.add((Integer)hashMap.get(EntityGhast.class));
            arrayList.add((Integer)hashMap.get(EntityMagmaCube.class));
            arrayList.add((Integer)hashMap.get(EntitySheep.class));
            arrayList.add((Integer)hashMap.get(EntityBlaze.class));
            arrayList.add((Integer)hashMap.get(EntityVillager.class));
            arrayList.add((Integer)hashMap.get(EntitySilverfish.class));
            arrayList.add((Integer)hashMap.get(EntityPig.class));
            arrayList.add((Integer)hashMap.get(EntityOcelot.class));
            ItemInfo.addEntityEgg(arrayList, (Integer)hashMap.get(EntitySnowman.class), 0xEEFFFF, 16753185);
            ItemInfo.addEntityEgg(arrayList, (Integer)hashMap.get(EntityIronGolem.class), 12960449, 16769484);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        API.setItemDamageVariants(tgdv.field_77815_bC.field_77779_bT, arrayList);
    }

    private static void addEntityEgg(ArrayList<Integer> arrayList, Integer n, int n2, int n3) {
        arrayList.add(n);
        jgro._f.put(n, new zwaw(n, n2, n3));
    }

    public static ArrayList<cvzo> getIdentifierItems(ozlu ozlu2, EntityPlayer entityPlayer, hank hank2) {
        Object object2;
        int n = hank2._d;
        int n2 = hank2._e;
        int n3 = hank2._f;
        twgu twgu2 = twgu.field_71973_m[ozlu2.func_72798_a(n, n2, n3)];
        ArrayList<cvzo> arrayList = new ArrayList<cvzo>();
        ArrayList arrayList2 = new ArrayList();
        if (highlightIdentifiers.get(0) != null) {
            arrayList2.addAll(highlightIdentifiers.get(0));
        }
        if (highlightIdentifiers.get(twgu2.field_71990_ca) != null) {
            arrayList2.addAll(highlightIdentifiers.get(twgu2.field_71990_ca));
        }
        for (Object object2 : arrayList2) {
            cvzo cvzo2 = object2.identifyHighlight(ozlu2, entityPlayer, hank2);
            if (cvzo2 == null) continue;
            arrayList.add(cvzo2);
        }
        if (arrayList.size() > 0) {
            return arrayList;
        }
        cvzo cvzo3 = twgu2.getPickBlock(hank2, ozlu2, n, n2, n3);
        if (cvzo3 != null) {
            arrayList.add(cvzo3);
        }
        try {
            arrayList.addAll(twgu2.getBlockDropped(ozlu2, n, n2, n3, ozlu2.func_72805_g(n, n2, n3), 0));
        }
        catch (Exception exception) {
            // empty catch block
        }
        if (twgu2 instanceof IShearable && (object2 = (IShearable)((Object)twgu2)).isShearable(new cvzo(tgdv.field_77745_be), ozlu2, n, n2, n3)) {
            arrayList.addAll(object2.onSheared(new cvzo(tgdv.field_77745_be), ozlu2, n, n2, n3, 0));
        }
        if (arrayList.size() == 0) {
            arrayList.add(0, new cvzo(twgu2, 1, ozlu2.func_72805_g(n, n2, n3)));
        }
        return arrayList;
    }

    public static void registerHighlightHandler(IHighlightHandler iHighlightHandler, Layout ... layoutArray) {
        for (Layout layout : layoutArray) {
            highlightHandlers.get((Object)layout).add(iHighlightHandler);
        }
    }

    public static List<String> getText(cvzo cvzo2, ozlu ozlu2, EntityPlayer entityPlayer, hank hank2) {
        List<String> list = new ArrayList<String>();
        for (Layout layout : Layout.values()) {
            for (IHighlightHandler iHighlightHandler : highlightHandlers.get((Object)layout)) {
                list = iHighlightHandler.handleTextData(cvzo2, ozlu2, entityPlayer, hank2, list, layout);
            }
        }
        return list;
    }

    static {
        for (Layout layout : Layout.values()) {
            highlightHandlers.put(layout, new ArrayList());
        }
    }

    public static enum Layout {
        HEADER,
        BODY,
        FOOTER;

    }
}

