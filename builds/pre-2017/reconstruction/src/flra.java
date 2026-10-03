/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;

public class flra {
    public static final String _a = "ForgeData";
    public static final String _b = "PlayerPersisted";
    public static final String _c = "cerf";
    public static final String _d = "Dimension";
    public static final String _e = "Pos";
    public static final String _f = "Rotation";
    public static final String _g = "LastPlayed";
    public static final String _h = "instance_id";
    public static final String _i = "worldLeavePos";
    public static final String _j = "newPos";
    public static final String _k = "instant_leave";

    public static NBTTagCompound _a(NBTTagCompound nBTTagCompound) {
        return flra._b(flra._a(nBTTagCompound, _a));
    }

    public static NBTTagCompound _b(NBTTagCompound nBTTagCompound) {
        return flra._a(nBTTagCompound, _b);
    }

    public static NBTTagCompound _a(NBTTagCompound nBTTagCompound, String string) {
        if (!nBTTagCompound._c(string)) {
            nBTTagCompound._a(string, (NBTBase)new NBTTagCompound());
        }
        return nBTTagCompound._m(string);
    }
}

