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

public class ConfigSet {
    private File nbtFile;
    public qoac nbt;
    public ConfigTagParent config;

    public ConfigSet(File file, ConfigTagParent configTagParent) {
        this.nbtFile = file;
        this.config = configTagParent;
        this.loadNBT();
    }

    public void loadNBT() {
        this.nbt = new qoac();
        try {
            if (!this.nbtFile.getParentFile().exists()) {
                this.nbtFile.getParentFile().mkdirs();
            }
            if (!this.nbtFile.exists()) {
                this.nbtFile.createNewFile();
            }
            if (this.nbtFile.length() > 0L) {
                DataInputStream dataInputStream = new DataInputStream(new FileInputStream(this.nbtFile));
                this.nbt = (qoac)huhy._a(dataInputStream);
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
            huhy._a(this.nbt, dataOutputStream);
            dataOutputStream.close();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}

