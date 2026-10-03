/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;

public class wnbr {
    public static NBTTagList _a(double ... dArray) {
        NBTTagList nBTTagList = new NBTTagList();
        for (double d : dArray) {
            nBTTagList._a(new qoae(null, d));
        }
        return nBTTagList;
    }

    public static NBTTagList _a(float ... fArray) {
        NBTTagList nBTTagList = new NBTTagList();
        for (float f : fArray) {
            nBTTagList._a(new jjly(null, f));
        }
        return nBTTagList;
    }

    public static NBTTagList _a(Collection<String> collection) {
        NBTTagList nBTTagList = new NBTTagList();
        for (String string : collection) {
            nBTTagList._a(new NBTTagString(null, string));
        }
        return nBTTagList;
    }

    public static List<String> _a(NBTTagList nBTTagList) {
        ArrayList<String> arrayList = new ArrayList<String>();
        for (int i = 0; i < nBTTagList._d(); ++i) {
            arrayList.add(((NBTTagString)nBTTagList._b((int)i))._c);
        }
        return arrayList;
    }

    public static void _a(NBTTagCompound nBTTagCompound, String string, UUID uUID) {
        if (uUID != null) {
            nBTTagCompound._a(string + "M", uUID.getMostSignificantBits());
            nBTTagCompound._a(string + "L", uUID.getLeastSignificantBits());
        }
    }

    public static UUID _a(NBTTagCompound nBTTagCompound, String string) {
        if (nBTTagCompound._c(string + "M")) {
            return new UUID(nBTTagCompound._g(string + "M"), nBTTagCompound._g(string + "L"));
        }
        return null;
    }
}

