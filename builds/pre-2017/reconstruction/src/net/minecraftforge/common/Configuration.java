/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.common;

import com.google.common.base.CharMatcher;
import com.google.common.collect.ImmutableSet;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.relauncher.FMLInjectionData;
import gloomyfolken.mods.asm.FileWriteBlocker;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PushbackInputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.ConfigCategory;
import net.minecraftforge.common.Property;

public class Configuration {
    private static boolean[] configMarkers = new boolean[Item.itemsList.length];
    private static final int ITEM_SHIFT = 256;
    private static final int MAX_BLOCKS = 4096;
    public static final String CATEGORY_GENERAL = "general";
    public static final String CATEGORY_BLOCK = "block";
    public static final String CATEGORY_ITEM = "item";
    public static final String ALLOWED_CHARS = "._-";
    public static final String DEFAULT_ENCODING = "UTF-8";
    public static final String CATEGORY_SPLITTER = ".";
    public static final String NEW_LINE;
    private static final Pattern CONFIG_START;
    private static final Pattern CONFIG_END;
    public static final CharMatcher allowedProperties;
    private static Configuration PARENT;
    File file;
    private Map<String, ConfigCategory> categories = new TreeMap<String, ConfigCategory>();
    private Map<String, Configuration> children = new TreeMap<String, Configuration>();
    private boolean caseSensitiveCustomCategories;
    public String defaultEncoding = "UTF-8";
    private String fileName = null;
    public boolean isChild = false;
    private boolean changed = false;

    public Configuration() {
    }

    public Configuration(File file) {
        this.file = file;
        String string = ((File)FMLInjectionData.data()[6]).getAbsolutePath().replace(File.separatorChar, '/').replace("/.", "");
        String string2 = file.getAbsolutePath().replace(File.separatorChar, '/').replace("/./", "/").replace(string, "");
        if (PARENT != null) {
            PARENT.setChild(string2, this);
            this.isChild = true;
        } else {
            this.fileName = string2;
            this.load();
        }
    }

    public Configuration(File file, boolean bl) {
        this(file);
        this.caseSensitiveCustomCategories = bl;
    }

    public Property getBlock(String string, int n) {
        return this.getBlock(CATEGORY_BLOCK, string, n, null);
    }

    public Property getBlock(String string, int n, String string2) {
        return this.getBlock(CATEGORY_BLOCK, string, n, string2);
    }

    public Property getBlock(String string, String string2, int n) {
        return this.getBlockInternal(string, string2, n, null, 256, Block.blocksList.length);
    }

    public Property getBlock(String string, String string2, int n, String string3) {
        return this.getBlockInternal(string, string2, n, string3, 256, Block.blocksList.length);
    }

    public Property getTerrainBlock(String string, String string2, int n, String string3) {
        return this.getBlockInternal(string, string2, n, string3, 0, 256);
    }

    private Property getBlockInternal(String string, String string2, int n, String string3, int n2, int n3) {
        Property property = this.get(string, string2, -1, string3);
        if (property.getInt() != -1) {
            Configuration.configMarkers[property.getInt()] = true;
            return property;
        }
        if (n < n2) {
            FMLLog.warning("Mod attempted to get a block ID with a default in the Terrain Generation section, mod authors should make sure there defaults are above 256 unless explicitly needed for terrain generation. Most ores do not need to be below 256.", new Object[0]);
            FMLLog.warning("Config \"%s\" Category: \"%s\" Key: \"%s\" Default: %d", this.fileName, string, string2, n);
            n = n3 - 1;
        }
        if (Block.blocksList[n] == null && !configMarkers[n]) {
            property.set(n);
            Configuration.configMarkers[n] = true;
            return property;
        }
        for (int i = n3 - 1; i > 0; --i) {
            if (Block.blocksList[i] != null || configMarkers[i]) continue;
            property.set(i);
            Configuration.configMarkers[i] = true;
            return property;
        }
        throw new RuntimeException("No more block ids available for " + string2);
    }

    public Property getItem(String string, int n) {
        return this.getItem(CATEGORY_ITEM, string, n, null);
    }

    public Property getItem(String string, int n, String string2) {
        return this.getItem(CATEGORY_ITEM, string, n, string2);
    }

    public Property getItem(String string, String string2, int n) {
        return this.getItem(string, string2, n, null);
    }

    public Property getItem(String string, String string2, int n, String string3) {
        Property property = this.get(string, string2, -1, string3);
        int n2 = n + 256;
        if (property.getInt() != -1) {
            Configuration.configMarkers[property.getInt() + 256] = true;
            return property;
        }
        if (n < 3840) {
            FMLLog.warning("Mod attempted to get a item ID with a default value in the block ID section, mod authors should make sure there defaults are above %d unless explicitly needed so that all block ids are free to store blocks.", 3840);
            FMLLog.warning("Config \"%s\" Category: \"%s\" Key: \"%s\" Default: %d", this.fileName, string, string2, n);
        }
        if (Item.itemsList[n2] == null && !configMarkers[n2] && n2 >= Block.blocksList.length) {
            property.set(n);
            Configuration.configMarkers[n2] = true;
            return property;
        }
        for (int i = Item.itemsList.length - 1; i >= 256; --i) {
            if (Item.itemsList[i] != null || configMarkers[i]) continue;
            property.set(i - 256);
            Configuration.configMarkers[i] = true;
            return property;
        }
        throw new RuntimeException("No more item ids available for " + string2);
    }

    public Property get(String string, String string2, int n) {
        return this.get(string, string2, n, (String)null);
    }

    public Property get(String string, String string2, int n, String string3) {
        Property property = this.get(string, string2, Integer.toString(n), string3, Property.Type.INTEGER);
        if (!property.isIntValue()) {
            property.set(n);
        }
        return property;
    }

    public Property get(String string, String string2, boolean bl) {
        return this.get(string, string2, bl, null);
    }

    public Property get(String string, String string2, boolean bl, String string3) {
        Property property = this.get(string, string2, Boolean.toString(bl), string3, Property.Type.BOOLEAN);
        if (!property.isBooleanValue()) {
            property.set(bl);
        }
        return property;
    }

    public Property get(String string, String string2, double d) {
        return this.get(string, string2, d, null);
    }

    public Property get(String string, String string2, double d, String string3) {
        Property property = this.get(string, string2, Double.toString(d), string3, Property.Type.DOUBLE);
        if (!property.isDoubleValue()) {
            property.set(d);
        }
        return property;
    }

    public Property get(String string, String string2, String string3) {
        return this.get(string, string2, string3, null);
    }

    public Property get(String string, String string2, String string3, String string4) {
        return this.get(string, string2, string3, string4, Property.Type.STRING);
    }

    public Property get(String string, String string2, String[] stringArray) {
        return this.get(string, string2, stringArray, null);
    }

    public Property get(String string, String string2, String[] stringArray, String string3) {
        return this.get(string, string2, stringArray, string3, Property.Type.STRING);
    }

    public Property get(String string, String string2, int[] nArray) {
        return this.get(string, string2, nArray, (String)null);
    }

    public Property get(String string, String string2, int[] nArray, String string3) {
        String[] stringArray = new String[nArray.length];
        for (int i = 0; i < nArray.length; ++i) {
            stringArray[i] = Integer.toString(nArray[i]);
        }
        Property property = this.get(string, string2, stringArray, string3, Property.Type.INTEGER);
        if (!property.isIntList()) {
            property.set(stringArray);
        }
        return property;
    }

    public Property get(String string, String string2, double[] dArray) {
        return this.get(string, string2, dArray, null);
    }

    public Property get(String string, String string2, double[] dArray, String string3) {
        String[] stringArray = new String[dArray.length];
        for (int i = 0; i < dArray.length; ++i) {
            stringArray[i] = Double.toString(dArray[i]);
        }
        Property property = this.get(string, string2, stringArray, string3, Property.Type.DOUBLE);
        if (!property.isDoubleList()) {
            property.set(stringArray);
        }
        return property;
    }

    public Property get(String string, String string2, boolean[] blArray) {
        return this.get(string, string2, blArray, null);
    }

    public Property get(String string, String string2, boolean[] blArray, String string3) {
        String[] stringArray = new String[blArray.length];
        for (int i = 0; i < blArray.length; ++i) {
            stringArray[i] = Boolean.toString(blArray[i]);
        }
        Property property = this.get(string, string2, stringArray, string3, Property.Type.BOOLEAN);
        if (!property.isBooleanList()) {
            property.set(stringArray);
        }
        return property;
    }

    public Property get(String string, String string2, String string3, String string4, Property.Type type) {
        ConfigCategory configCategory;
        if (!this.caseSensitiveCustomCategories) {
            string = string.toLowerCase(Locale.ENGLISH);
        }
        if ((configCategory = this.getCategory(string)).containsKey(string2)) {
            Property property = configCategory.get(string2);
            if (property.getType() == null) {
                property = new Property(property.getName(), property.getString(), type);
                configCategory.put(string2, property);
            }
            property.comment = string4;
            return property;
        }
        if (string3 != null) {
            Property property = new Property(string2, string3, type);
            property.set(string3);
            configCategory.put(string2, property);
            property.comment = string4;
            return property;
        }
        return null;
    }

    public Property get(String string, String string2, String[] stringArray, String string3, Property.Type type) {
        ConfigCategory configCategory;
        if (!this.caseSensitiveCustomCategories) {
            string = string.toLowerCase(Locale.ENGLISH);
        }
        if ((configCategory = this.getCategory(string)).containsKey(string2)) {
            Property property = configCategory.get(string2);
            if (property.getType() == null) {
                property = new Property(property.getName(), property.getString(), type);
                configCategory.put(string2, property);
            }
            property.comment = string3;
            return property;
        }
        if (stringArray != null) {
            Property property = new Property(string2, stringArray, type);
            property.comment = string3;
            configCategory.put(string2, property);
            return property;
        }
        return null;
    }

    public boolean hasCategory(String string) {
        return this.categories.get(string) != null;
    }

    public boolean hasKey(String string, String string2) {
        ConfigCategory configCategory = this.categories.get(string);
        return configCategory != null && configCategory.containsKey(string2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void load() {
        block53: {
            if (PARENT != null && PARENT != this) {
                return;
            }
            BufferedReader bufferedReader = null;
            UnicodeInputStreamReader unicodeInputStreamReader = null;
            try {
                if (this.file.getParentFile() != null) {
                    this.file.getParentFile().mkdirs();
                }
                if (!this.file.exists() && !this.file.createNewFile()) {
                    return;
                }
                if (!this.file.canRead()) break block53;
                unicodeInputStreamReader = new UnicodeInputStreamReader(new FileInputStream(this.file), this.defaultEncoding);
                this.defaultEncoding = unicodeInputStreamReader.getEncoding();
                bufferedReader = new BufferedReader(unicodeInputStreamReader);
                ConfigCategory configCategory = null;
                Property.Type type = null;
                ArrayList<String> arrayList = null;
                int n = 0;
                String string = null;
                while (true) {
                    ++n;
                    String string2 = bufferedReader.readLine();
                    if (string2 == null) {
                        break;
                    }
                    Matcher matcher = CONFIG_START.matcher(string2);
                    Matcher matcher2 = CONFIG_END.matcher(string2);
                    if (matcher.matches()) {
                        this.fileName = matcher.group(1);
                        this.categories = new TreeMap<String, ConfigCategory>();
                        continue;
                    }
                    if (matcher2.matches()) {
                        this.fileName = matcher2.group(1);
                        Configuration configuration = new Configuration();
                        configuration.categories = this.categories;
                        this.children.put(this.fileName, configuration);
                        continue;
                    }
                    int n2 = -1;
                    int n3 = -1;
                    boolean bl = false;
                    boolean bl2 = false;
                    block33: for (int i = 0; i < string2.length() && !bl; ++i) {
                        if (Character.isLetterOrDigit(string2.charAt(i)) || ALLOWED_CHARS.indexOf(string2.charAt(i)) != -1 || bl2 && string2.charAt(i) != '\"') {
                            if (n2 == -1) {
                                n2 = i;
                            }
                            n3 = i;
                            continue;
                        }
                        if (Character.isWhitespace(string2.charAt(i))) continue;
                        switch (string2.charAt(i)) {
                            case '#': {
                                bl = true;
                                continue block33;
                            }
                            case '\"': {
                                if (bl2) {
                                    bl2 = false;
                                }
                                if (bl2 || n2 != -1) continue block33;
                                bl2 = true;
                                continue block33;
                            }
                            case '{': {
                                string = string2.substring(n2, n3 + 1);
                                String string3 = ConfigCategory.getQualifiedName(string, configCategory);
                                ConfigCategory configCategory2 = this.categories.get(string3);
                                if (configCategory2 == null) {
                                    configCategory = new ConfigCategory(string, configCategory);
                                    this.categories.put(string3, configCategory);
                                } else {
                                    configCategory = configCategory2;
                                }
                                string = null;
                                continue block33;
                            }
                            case '}': {
                                if (configCategory == null) {
                                    throw new RuntimeException(String.format("Config file corrupt, attepted to close to many categories '%s:%d'", this.fileName, n));
                                }
                                configCategory = configCategory.parent;
                                continue block33;
                            }
                            case '=': {
                                string = string2.substring(n2, n3 + 1);
                                if (configCategory == null) {
                                    throw new RuntimeException(String.format("'%s' has no scope in '%s:%d'", string, this.fileName, n));
                                }
                                Property property = new Property(string, string2.substring(i + 1), type, true);
                                i = string2.length();
                                configCategory.put(string, property);
                                continue block33;
                            }
                            case ':': {
                                type = Property.Type.tryParse(string2.substring(n2, n3 + 1).charAt(0));
                                n3 = -1;
                                n2 = -1;
                                continue block33;
                            }
                            case '<': {
                                if (arrayList != null) {
                                    throw new RuntimeException(String.format("Malformed list property \"%s:%d\"", this.fileName, n));
                                }
                                string = string2.substring(n2, n3 + 1);
                                if (configCategory == null) {
                                    throw new RuntimeException(String.format("'%s' has no scope in '%s:%d'", string, this.fileName, n));
                                }
                                arrayList = new ArrayList<String>();
                                bl = true;
                                continue block33;
                            }
                            case '>': {
                                if (arrayList == null) {
                                    throw new RuntimeException(String.format("Malformed list property \"%s:%d\"", this.fileName, n));
                                }
                                configCategory.put(string, new Property(string, arrayList.toArray(new String[arrayList.size()]), type));
                                string = null;
                                arrayList = null;
                                type = null;
                                continue block33;
                            }
                            default: {
                                throw new RuntimeException(String.format("Unknown character '%s' in '%s:%d'", Character.valueOf(string2.charAt(i)), this.fileName, n));
                            }
                        }
                    }
                    if (bl2) {
                        throw new RuntimeException(String.format("Unmatched quote in '%s:%d'", this.fileName, n));
                    }
                    if (arrayList == null || bl) continue;
                    arrayList.add(string2.trim());
                }
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
            finally {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    }
                    catch (IOException iOException) {}
                }
                if (unicodeInputStreamReader != null) {
                    try {
                        unicodeInputStreamReader.close();
                    }
                    catch (IOException iOException) {}
                }
            }
        }
        this.resetChangedState();
    }

    public void save() {
        boolean bl = FileWriteBlocker.save(this);
        if (bl) {
            boolean bl2 = bl;
            return;
        }
        if (PARENT != null && PARENT != this) {
            PARENT.save();
            return;
        }
        try {
            if (this.file.getParentFile() != null) {
                this.file.getParentFile().mkdirs();
            }
            if (!this.file.exists() && !this.file.createNewFile()) {
                return;
            }
            if (this.file.canWrite()) {
                FileOutputStream fileOutputStream = new FileOutputStream(this.file);
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter((OutputStream)fileOutputStream, this.defaultEncoding));
                bufferedWriter.write("# Configuration file" + NEW_LINE + NEW_LINE);
                if (this.children.isEmpty()) {
                    this.save(bufferedWriter);
                } else {
                    for (Map.Entry<String, Configuration> entry : this.children.entrySet()) {
                        bufferedWriter.write("START: \"" + entry.getKey() + "\"" + NEW_LINE);
                        entry.getValue().save(bufferedWriter);
                        bufferedWriter.write("END: \"" + entry.getKey() + "\"" + NEW_LINE + NEW_LINE);
                    }
                }
                bufferedWriter.close();
                fileOutputStream.close();
            }
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    private void save(BufferedWriter bufferedWriter) throws IOException {
        for (ConfigCategory configCategory : this.categories.values()) {
            if (configCategory.isChild()) continue;
            configCategory.write(bufferedWriter, 0);
            bufferedWriter.newLine();
        }
    }

    public ConfigCategory getCategory(String string) {
        ConfigCategory configCategory = this.categories.get(string);
        if (configCategory == null) {
            if (string.contains(CATEGORY_SPLITTER)) {
                String[] stringArray = string.split("\\.");
                ConfigCategory configCategory2 = this.categories.get(stringArray[0]);
                if (configCategory2 == null) {
                    configCategory2 = new ConfigCategory(stringArray[0]);
                    this.categories.put(configCategory2.getQualifiedName(), configCategory2);
                    this.changed = true;
                }
                for (int i = 1; i < stringArray.length; ++i) {
                    String string2 = ConfigCategory.getQualifiedName(stringArray[i], configCategory2);
                    ConfigCategory configCategory3 = this.categories.get(string2);
                    if (configCategory3 == null) {
                        configCategory3 = new ConfigCategory(stringArray[i], configCategory2);
                        this.categories.put(string2, configCategory3);
                        this.changed = true;
                    }
                    configCategory = configCategory3;
                    configCategory2 = configCategory3;
                }
            } else {
                configCategory = new ConfigCategory(string);
                this.categories.put(string, configCategory);
                this.changed = true;
            }
        }
        return configCategory;
    }

    public void removeCategory(ConfigCategory configCategory) {
        for (ConfigCategory configCategory2 : configCategory.getChildren()) {
            this.removeCategory(configCategory2);
        }
        if (this.categories.containsKey(configCategory.getQualifiedName())) {
            this.categories.remove(configCategory.getQualifiedName());
            if (configCategory.parent != null) {
                configCategory.parent.removeChild(configCategory);
            }
            this.changed = true;
        }
    }

    public void addCustomCategoryComment(String string, String string2) {
        if (!this.caseSensitiveCustomCategories) {
            string = string.toLowerCase(Locale.ENGLISH);
        }
        this.getCategory(string).setComment(string2);
    }

    private void setChild(String string, Configuration configuration) {
        if (!this.children.containsKey(string)) {
            this.children.put(string, configuration);
            this.changed = true;
        } else {
            Configuration configuration2 = this.children.get(string);
            configuration.categories = configuration2.categories;
            configuration.fileName = configuration2.fileName;
            configuration2.changed = true;
        }
    }

    public static void enableGlobalConfig() {
        PARENT = new Configuration(new File(Loader.instance().getConfigDir(), "global.cfg"));
        PARENT.load();
    }

    public boolean hasChanged() {
        if (this.changed) {
            return true;
        }
        for (ConfigCategory object : this.categories.values()) {
            if (!object.hasChanged()) continue;
            return true;
        }
        for (Configuration configuration : this.children.values()) {
            if (!configuration.hasChanged()) continue;
            return true;
        }
        return false;
    }

    private void resetChangedState() {
        this.changed = false;
        for (ConfigCategory object : this.categories.values()) {
            object.resetChangedState();
        }
        for (Configuration configuration : this.children.values()) {
            configuration.resetChangedState();
        }
    }

    public Set<String> getCategoryNames() {
        return ImmutableSet.copyOf(this.categories.keySet());
    }

    static {
        CONFIG_START = Pattern.compile("START: \"([^\\\"]+)\"");
        CONFIG_END = Pattern.compile("END: \"([^\\\"]+)\"");
        allowedProperties = CharMatcher.JAVA_LETTER_OR_DIGIT.or(CharMatcher.anyOf(ALLOWED_CHARS));
        PARENT = null;
        Arrays.fill(configMarkers, false);
        NEW_LINE = System.getProperty("line.separator");
    }

    public static class UnicodeInputStreamReader
    extends Reader {
        private final InputStreamReader input;
        private final String defaultEnc;

        public UnicodeInputStreamReader(InputStream inputStream, String string) throws IOException {
            this.defaultEnc = string;
            String string2 = string;
            byte[] byArray = new byte[4];
            PushbackInputStream pushbackInputStream = new PushbackInputStream(inputStream, byArray.length);
            int n = pushbackInputStream.read(byArray, 0, byArray.length);
            int n2 = 0;
            int n3 = (byArray[0] & 0xFF) << 8 | byArray[1] & 0xFF;
            int n4 = n3 << 8 | byArray[2] & 0xFF;
            int n5 = n4 << 8 | byArray[3] & 0xFF;
            if (n4 == 0xEFBBBF) {
                string2 = Configuration.DEFAULT_ENCODING;
                n2 = 3;
            } else if (n3 == 65279) {
                string2 = "UTF-16BE";
                n2 = 2;
            } else if (n3 == 65534) {
                string2 = "UTF-16LE";
                n2 = 2;
            } else if (n5 == 65279) {
                string2 = "UTF-32BE";
                n2 = 4;
            } else if (n5 == -131072) {
                string2 = "UTF-32LE";
                n2 = 4;
            }
            if (n2 < n) {
                pushbackInputStream.unread(byArray, n2, n - n2);
            }
            this.input = new InputStreamReader((InputStream)pushbackInputStream, string2);
        }

        public String getEncoding() {
            return this.input.getEncoding();
        }

        @Override
        public int read(char[] cArray, int n, int n2) throws IOException {
            return this.input.read(cArray, n, n2);
        }

        @Override
        public void close() throws IOException {
            this.input.close();
        }
    }
}

