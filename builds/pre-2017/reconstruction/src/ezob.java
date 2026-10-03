/*
 * Decompiled with CFR 0.152.
 */
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.lang.reflect.Type;
import net.minecraft.nbt.NBTTagCompound;

public class ezob {
    public static Gson _a = new GsonBuilder().registerTypeAdapter((Type)((Object)NBTTagCompound.class), new tdxg()).registerTypeAdapter((Type)((Object)NBTTagCompound.class), new anbv()).create();

    public static String _a(NBTTagCompound nBTTagCompound) {
        if (nBTTagCompound == null || nBTTagCompound._e()) {
            return "";
        }
        return _a.toJson(nBTTagCompound);
    }

    public static NBTTagCompound _a(String string) {
        if (string == null || string.isEmpty()) {
            return new NBTTagCompound();
        }
        return _a.fromJson(string, NBTTagCompound.class);
    }
}

