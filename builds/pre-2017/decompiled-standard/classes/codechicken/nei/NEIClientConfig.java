/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import codechicken.core.ClientUtils;
import codechicken.core.CommonUtils;
import codechicken.lib.config.ConfigFile;
import codechicken.lib.config.ConfigTag;
import codechicken.lib.config.ConfigTagParent;
import codechicken.lib.inventory.ItemKey;
import codechicken.nei.ItemVisibilityHash;
import codechicken.nei.LayoutManager;
import codechicken.nei.NEIActions;
import codechicken.nei.NEIClientUtils;
import codechicken.nei.NEIController;
import codechicken.nei.api.API;
import codechicken.nei.api.GuiInfo;
import codechicken.nei.api.INEIGuiHandler;
import codechicken.nei.api.ItemInfo;
import codechicken.nei.api.LayoutStyle;
import codechicken.nei.api.NEIInfo;
import codechicken.nei.api.TaggedInventoryArea;
import codechicken.nei.config.ConfigSet;
import codechicken.nei.config.IConfigSetHolder;
import codechicken.nei.config.OptionCycled;
import codechicken.nei.config.OptionGamemodes;
import codechicken.nei.config.OptionHighlightTips;
import codechicken.nei.config.OptionList;
import codechicken.nei.config.OptionTextField;
import codechicken.nei.config.OptionToggleButton;
import codechicken.nei.config.OptionUtilities;
import codechicken.nei.recipe.RecipeInfo;
import codechicken.obfuscator.ObfuscationRun;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import net.minecraft.client.kjui;
import net.minecraft.client.xpzm;

public class NEIClientConfig {
    private static boolean configLoaded;
    private static boolean enabledOverride;
    public static ConfigSet global;
    public static ConfigSet world;
    public static ItemVisibilityHash vishash;
    public static cvzo[] creativeInv;
    private static boolean[] statesSaved;
    public static boolean hasSMPCounterpart;
    public static HashSet<String> permissableActions;
    public static HashSet<String> disabledActions;
    public static HashSet<String> enabledActions;
    public static HashSet<ItemKey> bannedBlocks;

    private static File moveGlobalDat() {
        File file = new File(CommonUtils.getMinecraftDir(), "saves/NEI.dat");
        File file2 = new File(CommonUtils.getMinecraftDir(), "saves/NEI/NEI.dat");
        if (file.exists()) {
            file.renameTo(file2);
        }
        return file2;
    }

    private static void setDefaults() {
        ConfigTagParent configTagParent = NEIClientConfig.global.config;
        configTagParent.setComment("Main configuration of NEI.\nMost of these options can be changed ingame.\nDeleting any element will restore it to it's default value");
        configTagParent.getTag("command").useBraces().setComment("Change these options if you have a different mod installed on the server that handles the commands differently, Eg. Bukkit Essentials");
        configTagParent.setNewLineMode(1);
        configTagParent.getTag("inventory.widgetsenabled").getBooleanValue(true);
        API.addOption(new OptionToggleButton("inventory.widgetsenabled"));
        configTagParent.getTag("inventory.hidden").getBooleanValue(false);
        configTagParent.getTag("inventory.cheatmode").getIntValue(2);
        configTagParent.getTag("inventory.lockmode").setComment("For those who can't help themselves.\nSet this to a mode and you will be unable to change it ingame").getIntValue(-1);
        API.addOption(new OptionCycled("inventory.cheatmode", 3){

            @Override
            public boolean optionValid(int n) {
                return NEIClientConfig.getLockedMode() == -1 || NEIClientConfig.getLockedMode() == n && NEIInfo.isValidMode(n);
            }
        });
        NEIClientConfig.checkCheatMode();
        configTagParent.getTag("inventory.utilities").setDefaultValue("delete, magnet");
        API.addOption(new OptionUtilities("inventory.utilities"));
        configTagParent.getTag("inventory.gamemodes").setDefaultValue("creative, creative+, adventure");
        API.addOption(new OptionGamemodes("inventory.gamemodes"));
        configTagParent.getTag("inventory.layoutstyle").getIntValue(0);
        API.addOption(new OptionCycled("inventory.layoutstyle", 0){

            @Override
            public String getPrefix() {
                return this.translateN(this.name, new Object[0]);
            }

            @Override
            public String getButtonText() {
                return NEIClientUtils.translate("layoutstyle." + LayoutManager.getLayoutStyle(this.renderTag().getIntValue()).getName(), new Object[0]);
            }

            @Override
            public boolean cycle() {
                LinkedList<Integer> linkedList = new LinkedList<Integer>();
                for (Map.Entry<Integer, LayoutStyle> object : LayoutManager.layoutStyles.entrySet()) {
                    linkedList.add(object.getKey());
                }
                Collections.sort(linkedList);
                int n = this.getTag().getIntValue();
                if (n == (Integer)linkedList.getLast()) {
                    n = -1;
                }
                for (Integer n2 : linkedList) {
                    if (n2 <= n) continue;
                    n = n2;
                    break;
                }
                this.getTag().setIntValue(n);
                return true;
            }
        });
        configTagParent.getTag("options.edge-align buttons").setPosition(7).getBooleanValue(false);
        configTagParent.getTag("inventory.itemIDs").getIntValue(1);
        API.addOption(new OptionCycled("inventory.itemIDs", 3, true));
        configTagParent.getTag("world.highlight_tips").getBooleanValue(false);
        configTagParent.getTag("world.highlight_tips.x").getIntValue(5000);
        configTagParent.getTag("world.highlight_tips.y").getIntValue(100);
        API.addOption(new OptionHighlightTips("world.highlight_tips"));
        configTagParent.getTag("inventory.profileRecipes").getBooleanValue(false);
        API.addOption(new OptionToggleButton("inventory.profileRecipes", true));
        configTagParent.getTag("command.creative").setDefaultValue("/gamemode {0} {1}");
        API.addOption(new OptionTextField("command.creative"));
        configTagParent.getTag("command.item").setDefaultValue("/give {0} {1} {2} {3}");
        API.addOption(new OptionTextField("command.item"));
        configTagParent.getTag("command.time").setDefaultValue("/time set {0}");
        API.addOption(new OptionTextField("command.time"));
        configTagParent.getTag("command.rain").setDefaultValue("/toggledownfall");
        API.addOption(new OptionTextField("command.rain"));
        configTagParent.getTag("command.heal").setDefaultValue("");
        API.addOption(new OptionTextField("command.heal"));
        NEIClientConfig.setDefaultKeyBindings();
    }

    private static void linkOptionList() {
        NEIClientConfig.getOptionList().bindConfig(new IConfigSetHolder(){

            @Override
            public ConfigSet worldConfigSet() {
                return world;
            }

            @Override
            public ConfigSet globalConfigSet() {
                return global;
            }
        });
    }

    private static void setDefaultKeyBindings() {
        API.addKeyBind("gui.recipe", 19);
        API.addKeyBind("gui.usage", 22);
        API.addKeyBind("gui.back", 14);
        API.addKeyBind("gui.enchant", 45);
        API.addKeyBind("gui.potion", 25);
        API.addKeyBind("gui.prev", 201);
        API.addKeyBind("gui.next", 209);
        API.addKeyBind("gui.hide", 24);
        API.addKeyBind("gui.search", 33);
        API.addKeyBind("world.chunkoverlay", 67);
        API.addKeyBind("world.moboverlay", 65);
        API.addKeyBind("world.highlight_tips", 82);
        API.addKeyBind("world.dawn", 0);
        API.addKeyBind("world.noon", 0);
        API.addKeyBind("world.dusk", 0);
        API.addKeyBind("world.midnight", 0);
        API.addKeyBind("world.rain", 0);
        API.addKeyBind("world.heal", 0);
        API.addKeyBind("world.creative", 0);
    }

    public static OptionList getOptionList() {
        return OptionList.getOptionList("nei.options");
    }

    public static void loadWorld(String string) {
        boolean bl;
        NEIClientConfig.setInternalEnabled(true);
        System.out.println("Loading World: " + string);
        NEIClientConfig.bootNEI(ClientUtils.getWorld());
        File file = new File(CommonUtils.getMinecraftDir(), "saves/NEI/" + string);
        boolean bl2 = bl = !file.exists();
        if (bl) {
            file.mkdirs();
        }
        world = new ConfigSet(new File(file, "NEI.dat"), new ConfigFile(new File(file, "NEI.cfg")));
        NEIClientConfig.onWorldLoad(bl);
    }

    private static void onWorldLoad(boolean bl) {
        NEIClientConfig.world.config.setComment("World based configuration of NEI.\nMost of these options can be changed ingame.\nDeleting any element will restore it to it's default value");
        NEIClientConfig.setWorldDefaults();
        creativeInv = new cvzo[54];
        LayoutManager.searchField.setText(NEIClientConfig.getSearchExpression());
        LayoutManager.quantity.setText(Integer.toString(NEIClientConfig.getItemQuantity()));
        if (bl && ClientUtils.isLocal()) {
            NEIClientConfig.world.config.getTag("inventory.cheatmode").setIntValue(NEIClientUtils.getGamemode() == 1 ? 2 : 0);
        }
        NEIInfo.load(ClientUtils.getWorld());
    }

    private static void setWorldDefaults() {
        qoac qoac2 = NEIClientConfig.world.nbt;
        if (!qoac2._c("search")) {
            qoac2._a("search", "");
        }
        if (!qoac2._c("quantity")) {
            qoac2._a("quantity", 0);
        }
        if (!qoac2._c("validateenchantments")) {
            qoac2._a("validateenchantments", false);
        }
        world.saveNBT();
    }

    public static int getKeyBinding(String string) {
        return NEIClientConfig.getSetting("keys." + string).getIntValue();
    }

    public static void setDefaultKeyBinding(String string, int n) {
        NEIClientConfig.getSetting("keys." + string).getIntValue(n);
    }

    public static void bootNEI(ozlu ozlu2) {
        if (configLoaded) {
            return;
        }
        NEIClientConfig.loadStates();
        ItemVisibilityHash.loadStates();
        vishash = new ItemVisibilityHash();
        ItemInfo.load(ozlu2);
        GuiInfo.load();
        RecipeInfo.load();
        LayoutManager.load();
        NEIController.load();
        configLoaded = true;
    }

    public static void loadStates() {
        for (int i = 0; i < 7; ++i) {
            NEIClientConfig.statesSaved[i] = !NEIClientConfig.global.nbt._m("save" + i)._e();
        }
    }

    public static boolean isWorldSpecific(String string) {
        return world != null && NEIClientConfig.world.config.containsTag(string);
    }

    public static boolean isStateSaved(int n) {
        return statesSaved[n];
    }

    public static ConfigTag getSetting(String string) {
        return NEIClientConfig.isWorldSpecific(string) ? NEIClientConfig.world.config.getTag(string) : NEIClientConfig.global.config.getTag(string);
    }

    public static boolean getBooleanSetting(String string) {
        return NEIClientConfig.getSetting(string).getBooleanValue();
    }

    public static boolean isHidden() {
        return !enabledOverride || NEIClientConfig.getBooleanSetting("inventory.hidden");
    }

    public static boolean isEnabled() {
        return enabledOverride && NEIClientConfig.getBooleanSetting("inventory.widgetsenabled");
    }

    public static void setEnabled(boolean bl) {
        NEIClientConfig.getSetting("inventory.widgetsenabled").setBooleanValue(bl);
    }

    public static int getItemQuantity() {
        return NEIClientConfig.world.nbt._f("quantity");
    }

    public static int getCheatMode() {
        return NEIClientConfig.getIntSetting("inventory.cheatmode");
    }

    private static void checkCheatMode() {
        if (NEIClientConfig.getLockedMode() != -1) {
            NEIClientConfig.setIntSetting("inventory.cheatmode", NEIClientConfig.getLockedMode());
        }
    }

    public static int getLockedMode() {
        return NEIClientConfig.getIntSetting("inventory.lockmode");
    }

    public static int getLayoutStyle() {
        return NEIClientConfig.getIntSetting("inventory.layoutstyle");
    }

    public static String getStringSetting(String string) {
        return NEIClientConfig.getSetting(string).getValue();
    }

    public static boolean canDump() {
        return NEIClientConfig.getBooleanSetting("ID dump.itemIDs") || NEIClientConfig.getBooleanSetting("ID dump.blockIDs") || NEIClientConfig.getBooleanSetting("ID dump.unused itemIDs") || NEIClientConfig.getBooleanSetting("ID dump.unused blockIDs");
    }

    public static boolean showIDs() {
        int n = NEIClientConfig.getIntSetting("inventory.itemIDs");
        return n == 2 || n == 1 && NEIClientConfig.isEnabled() && !NEIClientConfig.isHidden();
    }

    public static void toggleBooleanSetting(String string) {
        ConfigTag configTag;
        configTag.setBooleanValue(!(configTag = NEIClientConfig.getSetting(string)).getBooleanValue());
    }

    public static void cycleSetting(String string, int n) {
        ConfigTag configTag = NEIClientConfig.getSetting(string);
        configTag.setIntValue((configTag.getIntValue() + 1) % n);
    }

    public static int getIntSetting(String string) {
        return NEIClientConfig.getSetting(string).getIntValue();
    }

    public static void setIntSetting(String string, int n) {
        NEIClientConfig.getSetting(string).setIntValue(n);
    }

    public static String getSearchExpression() {
        return NEIClientConfig.world.nbt._j("search");
    }

    public static void setSearchExpression(String string) {
        NEIClientConfig.world.nbt._a("search", string);
        world.saveNBT();
    }

    public static boolean getMagnetMode() {
        return enabledActions.contains("magnet");
    }

    public static boolean invCreativeMode() {
        return enabledActions.contains("creative+") && NEIClientConfig.canPerformAction("creative+");
    }

    public static boolean areDamageVariantsShown() {
        return NEIClientConfig.hasSMPCounterPart() || NEIClientConfig.getSetting("command.item").getValue().contains("{3}");
    }

    public static void clearState(int n) {
        NEIClientConfig.statesSaved[n] = false;
        NEIClientConfig.global.nbt._a("save" + n, (huhy)new qoac());
        global.saveNBT();
    }

    public static void loadState(int n) {
        List<TaggedInventoryArea> list2;
        if (!statesSaved[n]) {
            return;
        }
        qoac qoac2 = NEIClientConfig.global.nbt._m("save" + n);
        zybc zybc2 = NEIClientUtils.getGuiContainer();
        LinkedList<TaggedInventoryArea> linkedList = new LinkedList<TaggedInventoryArea>();
        linkedList.add(new TaggedInventoryArea(NEIClientUtils.mc()._t.field_71071_by));
        for (INEIGuiHandler object : GuiInfo.guiHandlers) {
            list2 = object.getInventoryAreas(zybc2);
            if (list2 == null) continue;
            linkedList.addAll(list2);
        }
        for (TaggedInventoryArea taggedInventoryArea : linkedList) {
            int n2;
            if (!qoac2._c(taggedInventoryArea.tag)) continue;
            list2 = taggedInventoryArea.slots.iterator();
            while (list2.hasNext()) {
                n2 = (Integer)list2.next();
                NEIClientUtils.setSlotContents(n2, null, taggedInventoryArea.isContainer());
            }
            list2 = qoac2._n(taggedInventoryArea.tag);
            for (n2 = 0; n2 < ((bsyv)((Object)list2))._d(); ++n2) {
                qoac qoac3 = (qoac)((bsyv)((Object)list2))._b(n2);
                int n3 = qoac3._d("Slot") & 0xFF;
                if (!taggedInventoryArea.slots.contains(n3)) continue;
                NEIClientUtils.setSlotContents(n3, cvzo._a(qoac3), taggedInventoryArea.isContainer());
            }
        }
    }

    public static void saveState(int n) {
        List<TaggedInventoryArea> list2;
        qoac qoac2 = NEIClientConfig.global.nbt._m("save" + n);
        zybc zybc2 = NEIClientUtils.getGuiContainer();
        LinkedList<TaggedInventoryArea> linkedList = new LinkedList<TaggedInventoryArea>();
        linkedList.add(new TaggedInventoryArea(NEIClientUtils.mc()._t.field_71071_by));
        for (INEIGuiHandler object : GuiInfo.guiHandlers) {
            list2 = object.getInventoryAreas(zybc2);
            if (list2 == null) continue;
            linkedList.addAll(list2);
        }
        for (TaggedInventoryArea taggedInventoryArea : linkedList) {
            list2 = new bsyv(taggedInventoryArea.tag);
            for (int n2 : taggedInventoryArea.slots) {
                cvzo cvzo2 = taggedInventoryArea.getStackInSlot(n2);
                if (cvzo2 == null) continue;
                qoac qoac3 = new qoac();
                qoac3._a("Slot", (byte)n2);
                cvzo2._b(qoac3);
                ((bsyv)((Object)list2))._a(qoac3);
            }
            qoac2._a(taggedInventoryArea.tag, (huhy)((Object)list2));
        }
        NEIClientConfig.global.nbt._a("save" + n, (huhy)qoac2);
        global.saveNBT();
        NEIClientConfig.statesSaved[n] = true;
    }

    public static boolean hasSMPCounterPart() {
        return hasSMPCounterpart;
    }

    public static void setHasSMPCounterPart(boolean bl) {
        hasSMPCounterpart = bl;
        permissableActions.clear();
        bannedBlocks.clear();
        disabledActions.clear();
        enabledActions.clear();
    }

    public static boolean canPerformAction(String string) {
        if (!NEIClientConfig.isEnabled()) {
            return false;
        }
        if (!NEIClientConfig.modePermitsAction(string)) {
            return false;
        }
        String string2 = NEIActions.base(string);
        if (hasSMPCounterpart) {
            return permissableActions.contains(string2);
        }
        if (NEIActions.smpRequired(string)) {
            return false;
        }
        String string3 = NEIClientConfig.getStringSetting("command." + string2);
        return string3 != null && string3.startsWith("/");
    }

    private static boolean modePermitsAction(String string) {
        String[] stringArray;
        if (NEIClientConfig.getCheatMode() == 0) {
            return false;
        }
        if (NEIClientConfig.getCheatMode() == 2) {
            return true;
        }
        for (String string2 : stringArray = NEIClientConfig.getStringArrSetting("inventory.utilities")) {
            if (!string2.equalsIgnoreCase(string)) continue;
            return true;
        }
        return false;
    }

    public static String[] getStringArrSetting(String string) {
        return NEIClientConfig.getStringSetting(string).replace(" ", "").split(",");
    }

    public static void setBannedBlocks(ArrayList<ItemKey> arrayList) {
        bannedBlocks.clear();
        for (ItemKey itemKey : arrayList) {
            bannedBlocks.add(itemKey);
        }
    }

    public static boolean canGetItem(ItemKey itemKey) {
        return !bannedBlocks.contains(itemKey);
    }

    public static void setInternalEnabled(boolean bl) {
        enabledOverride = bl;
    }

    public static void reloadSaves() {
        File file = new File(CommonUtils.getMinecraftDir(), "saves/NEI/local");
        if (!file.exists()) {
            return;
        }
        List list2 = null;
        try {
            list2 = xpzm._E()._g()._a();
            HashSet<String> hashSet = new HashSet<String>();
            for (cfrv cfrv2 : list2) {
                hashSet.add(cfrv2._a());
            }
            for (File file2 : file.listFiles()) {
                if (!file2.isDirectory() || hashSet.contains(file2.getName())) continue;
                ObfuscationRun.deleteDir(file2, true);
            }
        }
        catch (kjui kjui2) {
            kjui2.printStackTrace();
        }
    }

    static {
        global = new ConfigSet(NEIClientConfig.moveGlobalDat(), new ConfigFile(new File(CommonUtils.getMinecraftDir(), "config/NEI.cfg")));
        statesSaved = new boolean[7];
        permissableActions = new HashSet();
        disabledActions = new HashSet();
        enabledActions = new HashSet();
        bannedBlocks = new HashSet();
        NEIClientConfig.linkOptionList();
        NEIClientConfig.setDefaults();
    }
}

