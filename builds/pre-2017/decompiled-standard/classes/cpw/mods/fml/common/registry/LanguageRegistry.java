/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.registry;

import com.google.common.base.Charsets;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.ModContainer;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;

public class LanguageRegistry {
    private static final LanguageRegistry INSTANCE = new LanguageRegistry();
    private Map<String, Properties> modLanguageData = new HashMap<String, Properties>();

    public static LanguageRegistry instance() {
        return INSTANCE;
    }

    public String getStringLocalization(String string) {
        return this.getStringLocalization(string, FMLCommonHandler.instance().getCurrentLanguage());
    }

    public String getStringLocalization(String string, String string2) {
        String string3 = "";
        Properties properties = this.modLanguageData.get(string2);
        if (properties != null && properties.getProperty(string) != null) {
            string3 = properties.getProperty(string);
        }
        return string3;
    }

    public void addStringLocalization(String string, String string2) {
        this.addStringLocalization(string, "en_US", string2);
    }

    public void addStringLocalization(String string, String string2, String string3) {
        Properties properties = this.modLanguageData.get(string2);
        if (properties == null) {
            properties = new Properties();
            this.modLanguageData.put(string2, properties);
        }
        properties.put(string, string3);
    }

    public void addStringLocalization(Properties properties) {
        this.addStringLocalization(properties, "en_US");
    }

    public void addStringLocalization(Properties properties, String string) {
        Properties properties2 = this.modLanguageData.get(string);
        if (properties2 == null) {
            properties2 = new Properties();
            this.modLanguageData.put(string, properties2);
        }
        if (properties != null) {
            properties2.putAll((Map<?, ?>)properties);
        }
    }

    public static void reloadLanguageTable() {
    }

    public void addNameForObject(Object object, String string, String string2) {
        String string3;
        if (object instanceof tgdv) {
            string3 = ((tgdv)object).func_77658_a();
        } else if (object instanceof twgu) {
            string3 = ((twgu)object).func_71917_a();
        } else if (object instanceof cvzo) {
            string3 = ((cvzo)object)._a().func_77667_c((cvzo)object);
        } else {
            throw new IllegalArgumentException(String.format("Illegal object for naming %s", object));
        }
        string3 = string3 + ".name";
        this.addStringLocalization(string3, string, string2);
    }

    public static void addName(Object object, String string) {
        LanguageRegistry.instance().addNameForObject(object, "en_US", string);
    }

    public void loadLanguageTable(Map map, String string) {
        Properties properties;
        Properties properties2 = this.modLanguageData.get("en_US");
        if (properties2 != null) {
            map.putAll(properties2);
        }
        if ((properties = this.modLanguageData.get(string)) == null) {
            return;
        }
        map.putAll(properties);
    }

    public void loadLocalization(String string, String string2, boolean bl) {
        URL uRL = this.getClass().getResource(string);
        if (uRL != null) {
            this.loadLocalization(uRL, string2, bl);
        } else {
            ModContainer modContainer = Loader.instance().activeModContainer();
            if (modContainer != null) {
                FMLLog.log(modContainer.getModId(), Level.SEVERE, "The language resource %s cannot be located on the classpath. This is a programming error.", string);
            } else {
                FMLLog.log(Level.SEVERE, "The language resource %s cannot be located on the classpath. This is a programming error.", string);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void loadLocalization(URL uRL, String string, boolean bl) {
        InputStream inputStream = null;
        Properties properties = new Properties();
        try {
            inputStream = uRL.openStream();
            if (bl) {
                properties.loadFromXML(inputStream);
            } else {
                properties.load(new InputStreamReader(inputStream, Charsets.UTF_8));
            }
            this.addStringLocalization(properties, string);
        }
        catch (IOException iOException) {
            FMLLog.log(Level.SEVERE, iOException, "Unable to load localization from file %s", uRL);
        }
        finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            }
            catch (IOException iOException) {}
        }
    }
}

