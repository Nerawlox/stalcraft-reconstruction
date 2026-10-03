/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.server.management;

import gloomyfolken.mods.asm.FileWriteBlocker;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.BanEntry;
import net.minecraft.server.management.LowerStringMap;

public class BanList {
    public final LowerStringMap _a = new LowerStringMap();
    public final File _b;
    public boolean _c = true;

    public BanList(File file) {
        this._b = file;
    }

    public boolean _a() {
        return this._c;
    }

    public void _a(boolean bl) {
        this._c = bl;
    }

    public Map _b() {
        this._c();
        return this._a;
    }

    public boolean _a(String string) {
        if (!this._a()) {
            return false;
        }
        this._c();
        return this._a.containsKey(string);
    }

    public void _a(BanEntry banEntry) {
        this._a._a(banEntry._a(), banEntry);
        this._e();
    }

    public void _b(String string) {
        this._a.remove(string);
        this._e();
    }

    public void _c() {
        Iterator iterator2 = this._a.values().iterator();
        while (iterator2.hasNext()) {
            BanEntry banEntry = (BanEntry)iterator2.next();
            if (!banEntry._e()) continue;
            iterator2.remove();
        }
    }

    public void _d() {
        BufferedReader bufferedReader;
        if (!this._b.isFile()) {
            return;
        }
        try {
            bufferedReader = new BufferedReader(new FileReader(this._b));
        }
        catch (FileNotFoundException fileNotFoundException) {
            throw new Error();
        }
        try {
            String string;
            while ((string = bufferedReader.readLine()) != null) {
                BanEntry banEntry;
                if (string.startsWith("#") || (banEntry = BanEntry._c(string)) == null) continue;
                this._a._a(banEntry._a(), banEntry);
            }
        }
        catch (IOException iOException) {
            MinecraftServer._I()._O()._b("Could not load ban list", iOException);
        }
    }

    public void _e() {
        this._b(true);
    }

    public void _b(boolean bl) {
        boolean bl2 = FileWriteBlocker.saveToFile(this, bl);
        if (bl2) {
            boolean bl3 = bl2;
            return;
        }
        this._c();
        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter(this._b, false));
            if (bl) {
                printWriter.println("# Updated " + new SimpleDateFormat().format(new Date()) + " by Minecraft " + "1.6.4");
                printWriter.println("# victim name | ban date | banned by | banned until | reason");
                printWriter.println();
            }
            for (BanEntry banEntry : this._a.values()) {
                printWriter.println(banEntry._g());
            }
            printWriter.close();
        }
        catch (IOException iOException) {
            MinecraftServer._I()._O()._b("Could not save ban list", iOException);
        }
    }
}

