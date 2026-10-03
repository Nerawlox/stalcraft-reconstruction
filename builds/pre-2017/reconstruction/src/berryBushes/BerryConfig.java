/*
 * Decompiled with CFR 0.152.
 */
package berryBushes;

import java.io.File;
import net.minecraftforge.common.Configuration;

public class BerryConfig {
    public static BerryConfig instance = new BerryConfig();
    public int berryI;
    public int berryII;
    public int berryIII;
    public int berryIV;

    private BerryConfig() {
    }

    public void loadConfig(File file) {
        Configuration configuration = new Configuration(file);
        configuration.load();
        this.loadSettings(configuration);
        configuration.save();
    }

    private void loadSettings(Configuration configuration) {
        this.berryI = configuration.getItem("berryI", 7542).getInt(7542);
        this.berryII = configuration.getItem("berryII", 7543).getInt(7543);
        this.berryIII = configuration.getItem("berryIII", 7544).getInt(7544);
        this.berryIV = configuration.getItem("berryIV", 7545).getInt(7545);
    }
}

