/*
 * Decompiled with CFR 0.152.
 */
package codechicken.core;

import codechicken.core.ReflectionManager;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.ModContainer;
import java.io.File;
import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatAllowedCharacters;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;

public class CommonUtils {
    private static File minecraftDir;
    private static byte[] charWidth;

    public static boolean isClient() {
        return FMLCommonHandler.instance().getSide().isClient();
    }

    public static File getWorldSaveLocation(World world, int n) {
        File file = DimensionManager.getCurrentSaveRootDirectory();
        if (n != 0) {
            return new File(file, world.provider._m());
        }
        return file;
    }

    public static String getWorldName(World world) {
        return world.getWorldInfo()._k();
    }

    public static int getDimension(World world) {
        return world.provider._i;
    }

    public static File getModsFolder() {
        return new File(CommonUtils.getMinecraftDir(), "mods");
    }

    public static File getMinecraftDir() {
        if (minecraftDir == null) {
            minecraftDir = ReflectionManager.getField(Loader.class, File.class, (Object)Loader.instance(), "minecraftDir");
        }
        return minecraftDir;
    }

    public static String getRelativePath(File file, File file2) {
        if (file.isFile() || !file2.getPath().startsWith(file.getPath())) {
            return null;
        }
        return file2.getPath().substring(file.getPath().length() + 1);
    }

    public static int getFreeBlockID(int n) {
        int n2;
        for (n2 = n; n2 < 255; ++n2) {
            if (Block.blocksList[n2] != null) continue;
            return n2;
        }
        for (n2 = n - 1; n2 > 0; --n2) {
            if (Block.blocksList[n2] != null) continue;
            return n2;
        }
        return -1;
    }

    public static <T> T[] subArray(T[] TArray, int n) {
        if (n > TArray.length) {
            return (Object[])Array.newInstance(TArray.getClass().getComponentType(), 0);
        }
        Object[] objectArray = (Object[])Array.newInstance(TArray.getClass().getComponentType(), TArray.length - n);
        System.arraycopy(TArray, n, objectArray, 0, objectArray.length);
        return objectArray;
    }

    public static int getCharWidth(char c) {
        if (c == '\u00a7') {
            return -1;
        }
        int n = ChatAllowedCharacters._a.indexOf(c);
        if (n + 32 > charWidth.length || n < 0) {
            return 0;
        }
        return charWidth[n + 32];
    }

    public static int getStringWidth(String string) {
        if (string == null) {
            return 0;
        }
        int n = 0;
        boolean bl = false;
        for (int i = 0; i < string.length(); ++i) {
            char c = string.charAt(i);
            int n2 = CommonUtils.getCharWidth(c);
            if (n2 < 0 && i < string.length() - 1) {
                if ((c = string.charAt(++i)) != 'l' && c != 'L') {
                    if (c == 'r' || c == 'R') {
                        bl = false;
                    }
                } else {
                    bl = true;
                }
                n2 = CommonUtils.getCharWidth(c);
            }
            n += n2;
            if (!bl) continue;
            ++n;
        }
        return n;
    }

    public static List<String> splitChat(String string) {
        LinkedList<String> linkedList = new LinkedList<String>();
        String[] stringArray = string.split(" ");
        String string2 = "";
        int n = 7;
        for (int i = 0; i < stringArray.length; ++i) {
            String string3;
            String string4 = string3 = string2.length() == 0 ? stringArray[i] : string2 + " " + stringArray[i];
            if (CommonUtils.getStringWidth(string3) > 377) {
                linkedList.add(CommonUtils.colourPrefix(n) + string2);
                for (int j = 0; j < string2.length(); ++j) {
                    while (string2.length() > j + 1 && string2.charAt(j) == '\u00a7') {
                        char c = string2.toLowerCase().charAt(j + 1);
                        if (c != 'k' && ((n = "0123456789abcdef".indexOf(c)) < 0 || n > 15)) {
                            n = 15;
                        }
                        ++j;
                    }
                }
                string2 = stringArray[i];
                continue;
            }
            string2 = string3;
        }
        linkedList.add(CommonUtils.colourPrefix(n) + string2);
        return linkedList;
    }

    public static String colourPrefix(int n) {
        if (n == -1) {
            return "";
        }
        return "\u00a7" + "0123456789abcdef".charAt(n);
    }

    public static boolean isBlock(int n) {
        return n < Block.blocksList.length && Block.blocksList[n] != null && Block.blocksList[n].blockID != 0;
    }

    public static ModContainer findModContainer(String string) {
        for (ModContainer modContainer : Loader.instance().getModList()) {
            if (!string.equals(modContainer.getModId())) continue;
            return modContainer;
        }
        return null;
    }

    public static ItemStack consumeItem(ItemStack itemStack) {
        if (itemStack._a().hasContainerItem()) {
            return itemStack._a().getContainerItemStack(itemStack);
        }
        if (itemStack._b == 1) {
            return null;
        }
        --itemStack._b;
        return itemStack;
    }

    public static String filterText(String string) {
        return ChatAllowedCharacters._a(string.replaceAll("\u00a7.", ""));
    }

    static {
        charWidth = new byte[]{4, 2, 5, 6, 6, 6, 6, 3, 5, 5, 5, 6, 2, 6, 2, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 2, 2, 5, 6, 5, 6, 7, 6, 6, 6, 6, 6, 6, 6, 6, 4, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 4, 6, 4, 6, 6, 3, 6, 6, 6, 6, 6, 5, 6, 6, 2, 6, 5, 3, 6, 6, 6, 6, 6, 6, 6, 4, 6, 6, 6, 6, 6, 6, 5, 2, 5, 7, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 4, 6, 3, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 4, 6, 6, 3, 6, 6, 6, 6, 6, 6, 6, 7, 6, 6, 6, 2, 6, 6};
    }
}

