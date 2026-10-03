/*
 * Decompiled with CFR 0.152.
 */
package codechicken.lib.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public class SimpleProperties {
    public HashMap<String, String> propertyMap = new HashMap();
    public File propertyFile;
    public boolean saveOnChange = false;
    public String encoding;
    private boolean loading = false;

    public SimpleProperties(File file, boolean bl, String string) {
        this.propertyFile = file;
        this.saveOnChange = bl;
        this.encoding = string;
    }

    public SimpleProperties(File file, boolean bl) {
        this(file, bl, Charset.defaultCharset().name());
    }

    public SimpleProperties(File file) {
        this(file, true);
    }

    public void load() {
        this.clear();
        this.loading = true;
        try {
            String string;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader((InputStream)new FileInputStream(this.propertyFile), this.encoding));
            while ((string = bufferedReader.readLine()) != null) {
                int n = string.indexOf(61);
                if (n == -1) continue;
                this.setProperty(string.substring(0, n), string.substring(n + 1));
            }
            bufferedReader.close();
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
        this.loading = false;
    }

    public void save() {
        try {
            PrintStream printStream = new PrintStream(this.propertyFile);
            for (Map.Entry<String, String> entry : this.propertyMap.entrySet()) {
                printStream.println(entry.getKey() + "=" + entry.getValue());
            }
            printStream.close();
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    public void clear() {
        this.propertyMap.clear();
    }

    public boolean hasProperty(String string) {
        return this.propertyMap.containsKey(string);
    }

    public void removeProperty(String string) {
        if (this.propertyMap.remove(string) != null && this.saveOnChange && !this.loading) {
            this.save();
        }
    }

    public void setProperty(String string, int n) {
        this.setProperty(string, Integer.toString(n));
    }

    public void setProperty(String string, boolean bl) {
        this.setProperty(string, Boolean.toString(bl));
    }

    public void setProperty(String string, String string2) {
        this.propertyMap.put(string, string2);
        if (this.saveOnChange && !this.loading) {
            this.save();
        }
    }

    public int getProperty(String string, int n) {
        try {
            return Integer.parseInt(this.getProperty(string, Integer.toString(n)));
        }
        catch (NumberFormatException numberFormatException) {
            return n;
        }
    }

    public boolean getProperty(String string, boolean bl) {
        try {
            return Boolean.parseBoolean(this.getProperty(string, Boolean.toString(bl)));
        }
        catch (NumberFormatException numberFormatException) {
            return bl;
        }
    }

    public String getProperty(String string, String string2) {
        String string3 = this.propertyMap.get(string);
        if (string3 == null) {
            this.setProperty(string, string2);
            return string2;
        }
        return string3;
    }

    public String getProperty(String string) {
        return this.propertyMap.get(string);
    }
}

