/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei.config;

import codechicken.lib.config.ConfigTagParent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;

public class ConfigSet {
    private File nbtFile;
    public NBTTagCompound nbt;
    public ConfigTagParent config;

    public ConfigSet(File file, ConfigTagParent configTagParent) {
        this.nbtFile = file;
        this.config = configTagParent;
        this.loadNBT();
    }

    public void loadNBT() {
        this.nbt = new NBTTagCompound();
        try {
            if (!this.nbtFile.getParentFile().exists()) {
                this.nbtFile.getParentFile().mkdirs();
            }
            if (!this.nbtFile.exists()) {
                this.nbtFile.createNewFile();
            }
            if (this.nbtFile.length() > 0L) {
                DataInputStream dataInputStream = new DataInputStream(new FileInputStream(this.nbtFile));
                this.nbt = (NBTTagCompound)NBTBase._a(dataInputStream);
                dataInputStream.close();
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void saveNBT() {
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(this.nbtFile));
            NBTBase._a(this.nbt, dataOutputStream);
            dataOutputStream.close();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}

