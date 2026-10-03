/*
 * Decompiled with CFR 0.152.
 */
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gloomyfolken.mods.core.misc.dwbf;
import gloomyfolken.mods.core.misc.pzdf;
import java.lang.reflect.Type;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class sval {
    private static Gson _a = new GsonBuilder().registerTypeAdapter((Type)((Object)ItemStack.class), new pzdf()).registerTypeAdapter((Type)((Object)ItemStack.class), new dwbf()).registerTypeAdapter((Type)((Object)NBTTagCompound.class), new tdxg()).registerTypeAdapter((Type)((Object)NBTTagCompound.class), new anbv()).create();

    public static String _a(ItemStack itemStack) {
        if (itemStack == null || itemStack._a() == null) {
            return "";
        }
        return _a.toJson(itemStack);
    }

    public static ItemStack _a(String string) {
        if (string == null || string.isEmpty()) {
            return null;
        }
        return _a.fromJson(string, ItemStack.class);
    }
}

