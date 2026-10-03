/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import org.apache.commons.lang3.ArrayUtils;

public class dwly {
    private NBTTagCompound _a = new NBTTagCompound();

    public dwly() {
    }

    public dwly(NBTTagCompound nBTTagCompound) {
        this._a = (NBTTagCompound)nBTTagCompound._c();
    }

    public dwly(Object ... objectArray) {
        if (objectArray.length % 2 != 0) {
            throw new IllegalArgumentException("Amount of keys must equal amount of values");
        }
        for (int i = 0; i < objectArray.length; i += 2) {
            String string = (String)objectArray[i];
            Object object = objectArray[i + 1];
            if (object instanceof Integer) {
                this._a(string, (Integer)object);
                continue;
            }
            if (object instanceof String) {
                this._a(string, (String)object);
                continue;
            }
            if (object instanceof NBTTagCompound) {
                this._a(string, (NBTTagCompound)object);
                continue;
            }
            if (object instanceof NBTTagList) {
                this._a._a(string, (NBTBase)object);
                continue;
            }
            if (object instanceof Boolean) {
                this._a(string, (Boolean)object);
                continue;
            }
            if (!(object instanceof Integer[])) continue;
            this._a(string, ArrayUtils.toPrimitive((Integer[])object));
        }
    }

    public dwly _a(String string, int n) {
        this._a._a(string, n);
        return this;
    }

    public dwly _a(String string, double d) {
        this._a._a(string, d);
        return this;
    }

    public dwly _a(String string, String string2) {
        this._a._a(string, string2);
        return this;
    }

    public dwly _a(String string, byte[] byArray) {
        this._a._a(string, byArray);
        return this;
    }

    public dwly _a(String string, int[] nArray) {
        this._a._a(string, nArray);
        return this;
    }

    public dwly _a(String string, NBTTagCompound nBTTagCompound) {
        this._a._a(string, nBTTagCompound);
        return this;
    }

    public dwly _a(String string, float f) {
        this._a._a(string, f);
        return this;
    }

    public dwly _a(String string, boolean bl) {
        this._a._a(string, bl);
        return this;
    }

    public NBTTagCompound _a() {
        return this._a;
    }
}

