/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import codechicken.core.CommonUtils;
import codechicken.core.ServerUtils;
import codechicken.lib.config.ConfigFile;
import codechicken.lib.config.ConfigTag;
import codechicken.lib.inventory.ItemKey;
import codechicken.lib.packet.PacketCustom;
import codechicken.nei.NEIActions;
import codechicken.nei.NEISPH;
import codechicken.nei.PlayerSave;
import gloomyfolken.mods.asm.FileWriteBlocker;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.common.DimensionManager;

public class NEIServerConfig {
    private static dzfd server;
    public static ConfigFile serverConfig;
    public static File worldSaveFile;
    public static File worldSaveDir;
    public static qoac worldCompound;
    public static HashMap<String, PlayerSave> playerSaves;
    public static HashMap<ItemKey, HashSet<String>> bannedblocks;

    public static void load(ozlu ozlu2) {
        if (dzfd._I() == server) {
            return;
        }
        System.out.println("Loading NEI");
        server = dzfd._I();
        NEIServerConfig.initDefaults();
        NEIServerConfig.loadBannedBlocks();
        NEIServerConfig.loadSavedConfig(ozlu2);
    }

    private static void loadSavedConfig(ozlu ozlu2) {
        try {
            worldSaveDir = DimensionManager.getCurrentSaveRootDirectory();
            worldSaveFile = new File(worldSaveDir, "NEI.dat");
            if (!worldSaveFile.getParentFile().exists()) {
                worldSaveFile.getParentFile().mkdirs();
            }
            if (!worldSaveFile.exists()) {
                worldSaveFile.createNewFile();
            }
            if (worldSaveFile.length() == 0L) {
                worldCompound = new qoac();
            } else {
                DataInputStream dataInputStream = new DataInputStream(new FileInputStream(worldSaveFile));
                worldCompound = (qoac)huhy._a(dataInputStream);
                dataInputStream.close();
            }
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    private static void initDefaults() {
        serverConfig.setNewLineMode(1);
        serverConfig.getTag("permissions").useBraces();
        serverConfig.getTag("permissions").setComment("List of players who can use these features. :Eg. time=CodeChicken, Friend1");
        serverConfig.getTag("BannedBlocks").useBraces();
        serverConfig.getTag("BannedBlocks").setComment("List of players who can use these blocks. :Anyone not listed here will not have these blocks appear in their item panel.:format is {itemID}::{itemDamage}:Eg. 12::5=CodeChicken, Friend1");
        NEIServerConfig.setDefaultFeature("time", new String[0]);
        NEIServerConfig.setDefaultFeature("rain", new String[0]);
        NEIServerConfig.setDefaultFeature("heal", new String[0]);
        NEIServerConfig.setDefaultFeature("magnet", new String[0]);
        NEIServerConfig.setDefaultFeature("creative", new String[0]);
        NEIServerConfig.setDefaultFeature("creative+", new String[0]);
        NEIServerConfig.setDefaultFeature("adventure", new String[0]);
        NEIServerConfig.setDefaultFeature("enchant", new String[0]);
        NEIServerConfig.setDefaultFeature("potion", new String[0]);
        NEIServerConfig.setDefaultFeature("save-state", new String[0]);
        NEIServerConfig.setDefaultFeature("item", new String[0]);
        NEIServerConfig.setDefaultFeature("delete", new String[0]);
        NEIServerConfig.setDefaultFeature("notify-item", "CONSOLE, OP");
        serverConfig.getTag("BannedBlocks." + twgu.field_71986_z.field_71990_ca + ":0").setDefaultValue("NONE");
    }

    private static void setDefaultFeature(String string, String ... stringArray) {
        if (stringArray.length == 0) {
            stringArray = new String[]{"OP"};
        }
        String string2 = "";
        for (int i = 0; i < stringArray.length; ++i) {
            if (i >= 1) {
                string2 = string2 + ", ";
            }
            string2 = string2 + stringArray[i];
        }
        serverConfig.getTag("permissions." + string).setDefaultValue(string2);
    }

    private static void saveWorldCompound() {
        boolean bl = FileWriteBlocker.getBlockFileWrite();
        if (bl) {
            return;
        }
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(worldSaveFile));
            huhy._a(worldCompound, dataOutputStream);
            dataOutputStream.close();
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    private static qoac getDimCompound(int n) {
        if (!worldCompound._c("dim" + n)) {
            worldCompound._a("dim" + n, new qoac());
        }
        return worldCompound._m("dim" + n);
    }

    public static boolean canPlayerPerformAction(String string, String string2) {
        return NEIServerConfig.isPlayerInList(string, NEIServerConfig.getPlayerList("permissions." + NEIActions.base(string2)), true);
    }

    public static boolean isPlayerInList(String string, HashSet<String> hashSet, boolean bl) {
        if (string.equals("CONSOLE")) {
            return hashSet.contains(string);
        }
        string = string.toLowerCase();
        if (bl) {
            if (hashSet.contains("ALL")) {
                return true;
            }
            if ((ServerUtils.isPlayerOP(string) || ServerUtils.isPlayerOwner(string)) && hashSet.contains("OP")) {
                return true;
            }
        }
        return hashSet.contains(string);
    }

    public static boolean isActionDisabled(int n, String string) {
        return NEIServerConfig.getDimCompound(n)._o("disabled" + string);
    }

    public static void disableAction(int n, String string, boolean bl) {
        NEIServerConfig.getDimCompound(n)._a("disabled" + string, bl);
        NEISPH.sendActionDisabled(n, string, bl);
        NEIServerConfig.saveWorldCompound();
    }

    public static HashSet<String> getPlayerList(String string) {
        String[] stringArray = serverConfig.getTag(string).getValue("").replace(" ", "").split(",");
        return new HashSet<String>(Arrays.asList(stringArray));
    }

    public static void addPlayerToList(String string, String string2) {
        HashSet<String> hashSet = NEIServerConfig.getPlayerList(string2);
        if (!(string.equals("CONSOLE") || string.equals("ALL") || string.equals("OP"))) {
            string = string.toLowerCase();
        }
        hashSet.add(string);
        NEIServerConfig.savePlayerList(string2, hashSet);
    }

    public static void remPlayerFromList(String string, String string2) {
        HashSet<String> hashSet = NEIServerConfig.getPlayerList(string2);
        if (!(string.equals("CONSOLE") || string.equals("ALL") || string.equals("OP"))) {
            string = string.toLowerCase();
        }
        hashSet.remove(string);
        NEIServerConfig.savePlayerList(string2, hashSet);
    }

    private static void savePlayerList(String string, Collection<String> collection) {
        StringBuilder stringBuilder = new StringBuilder();
        int n = 0;
        Iterator<String> iterator2 = collection.iterator();
        while (iterator2.hasNext()) {
            if (n != 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(iterator2.next());
            ++n;
        }
        serverConfig.getTag(string).setValue(stringBuilder.toString());
    }

    private static void loadBannedBlocks() {
        ConfigTag configTag = serverConfig.getTag("BannedBlocks");
        for (Map.Entry<String, ConfigTag> entry : configTag.childTagMap().entrySet()) {
            String string = entry.getKey();
            String[] stringArray = string.split(":");
            ItemKey itemKey = stringArray.length == 1 ? new ItemKey(Integer.parseInt(stringArray[0]), -1) : new ItemKey(Integer.parseInt(stringArray[0]), Integer.parseInt(stringArray[1]));
            bannedblocks.put(itemKey, NEIServerConfig.getPlayerList(entry.getValue().qualifiedname));
        }
    }

    public static PlayerSave forPlayer(String string) {
        return playerSaves.get(string);
    }

    public static void loadPlayer(EntityPlayer entityPlayer) {
        System.out.println("Loading Player: " + entityPlayer.field_71092_bJ);
        playerSaves.put(entityPlayer.field_71092_bJ, new PlayerSave(entityPlayer.field_71092_bJ, new File(worldSaveDir, "NEI/players")));
    }

    public static void unloadPlayer(EntityPlayer entityPlayer) {
        System.out.println("Unloading Player: " + entityPlayer.field_71092_bJ);
        PlayerSave playerSave = playerSaves.remove(entityPlayer.field_71092_bJ);
        if (playerSave != null) {
            playerSave.save();
        }
    }

    public static boolean authenticatePacket(EntityPlayerMP entityPlayerMP, PacketCustom packetCustom) {
        switch (packetCustom.getType()) {
            case 1: {
                return NEIServerConfig.canPlayerPerformAction(entityPlayerMP.field_71092_bJ, "item");
            }
            case 4: {
                return NEIServerConfig.canPlayerPerformAction(entityPlayerMP.field_71092_bJ, "delete");
            }
            case 6: {
                return NEIServerConfig.canPlayerPerformAction(entityPlayerMP.field_71092_bJ, "magnet");
            }
            case 7: {
                return NEIServerConfig.canPlayerPerformAction(entityPlayerMP.field_71092_bJ, "time");
            }
            case 8: {
                return NEIServerConfig.canPlayerPerformAction(entityPlayerMP.field_71092_bJ, "heal");
            }
            case 9: {
                return NEIServerConfig.canPlayerPerformAction(entityPlayerMP.field_71092_bJ, "rain");
            }
            case 14: 
            case 23: {
                return NEIServerConfig.canPlayerPerformAction(entityPlayerMP.field_71092_bJ, "creative+");
            }
            case 21: 
            case 22: {
                return NEIServerConfig.canPlayerPerformAction(entityPlayerMP.field_71092_bJ, "enchant");
            }
            case 24: {
                return NEIServerConfig.canPlayerPerformAction(entityPlayerMP.field_71092_bJ, "potion");
            }
        }
        return true;
    }

    static {
        serverConfig = new ConfigFile(new File(CommonUtils.getMinecraftDir(), "config/NEIServer.cfg")).setComment("NEI Server Permissions \n Names are Comma (,) separated \n ALL, OP and NONE are special names");
        playerSaves = new HashMap();
        bannedblocks = new HashMap();
    }
}

