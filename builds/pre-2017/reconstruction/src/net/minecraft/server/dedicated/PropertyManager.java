/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.server.dedicated;

import gloomyfolken.mods.asm.FileWriteBlocker;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import net.minecraft.logging.ILogAgent;

public class PropertyManager {
    public final Properties _a = new Properties();
    public final ILogAgent _b;
    public final File _c;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PropertyManager(File file, ILogAgent iLogAgent) {
        this._c = file;
        this._b = iLogAgent;
        if (file.exists()) {
            FileInputStream fileInputStream = null;
            try {
                fileInputStream = new FileInputStream(file);
                this._a.load(fileInputStream);
            }
            catch (Exception exception) {
                iLogAgent._a("Failed to load " + file, exception);
                this._a();
            }
            finally {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    }
                    catch (IOException iOException) {}
                }
            }
        } else {
            iLogAgent._b(file + " does not exist");
            this._a();
        }
    }

    public void _a() {
        this._b._a("Generating new properties file");
        this._b();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void _b() {
        boolean bl = FileWriteBlocker.saveProperties(this);
        if (bl) {
            boolean bl2 = bl;
            return;
        }
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(this._c);
            this._a.store(fileOutputStream, "Minecraft server properties");
        }
        catch (Exception exception) {
            this._b._a("Failed to save " + this._c, exception);
            this._a();
        }
        finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                }
                catch (IOException iOException) {}
            }
        }
    }

    public File _c() {
        return this._c;
    }

    public String _a(String string, String string2) {
        if (!this._a.containsKey(string)) {
            this._a.setProperty(string, string2);
            this._b();
        }
        return this._a.getProperty(string, string2);
    }

    public int _a(String string, int n) {
        try {
            return Integer.parseInt(this._a(string, "" + n));
        }
        catch (Exception exception) {
            this._a.setProperty(string, "" + n);
            return n;
        }
    }

    public boolean _a(String string, boolean bl) {
        try {
            return Boolean.parseBoolean(this._a(string, "" + bl));
        }
        catch (Exception exception) {
            this._a.setProperty(string, "" + bl);
            return bl;
        }
    }

    public void _a(String string, Object object) {
        this._a.setProperty(string, "" + object);
    }
}

