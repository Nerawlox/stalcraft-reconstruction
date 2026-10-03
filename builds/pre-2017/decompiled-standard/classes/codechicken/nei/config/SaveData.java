/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei.config;

import codechicken.lib.config.ConfigTagParent;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class SaveData {
    public ConfigTagParent config;
    public qoac nbt;
    private File nbtFile;

    public SaveData(ConfigTagParent configTagParent, File file) {
        this.config = configTagParent;
        this.nbtFile = file;
        this.loadNBT();
    }

    public void loadNBT() {
        try {
            if (!this.nbtFile.exists()) {
                this.nbtFile.createNewFile();
            }
            if (this.nbtFile.length() == 0L) {
                return;
            }
            DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(this.nbtFile)));
            this.nbt = (qoac)huhy._a(dataInputStream);
            dataInputStream.close();
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    public void saveNBT() {
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(this.nbtFile)));
            huhy._a(this.nbt, dataOutputStream);
            dataOutputStream.close();
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }
}

