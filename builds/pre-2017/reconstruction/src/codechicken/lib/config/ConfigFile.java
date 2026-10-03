/*
 * Decompiled with CFR 0.152.
 */
package codechicken.lib.config;

import codechicken.lib.config.ConfigTagParent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class ConfigFile
extends ConfigTagParent {
    public File file;
    private boolean loading;
    public static final byte[] lineend = new byte[]{13, 10};

    public ConfigFile(File file) {
        if (!file.exists()) {
            try {
                file.createNewFile();
            }
            catch (IOException iOException) {
                throw new RuntimeException(iOException);
            }
        }
        this.file = file;
        this.newlinemode = 2;
        this.loadConfig();
    }

    private void loadConfig() {
        this.loading = true;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(this.file));
            while (true) {
                bufferedReader.mark(2000);
                String string = bufferedReader.readLine();
                if (string == null || !string.startsWith("#")) break;
                if (this.comment == null || this.comment.equals("")) {
                    this.comment = string.substring(1);
                    continue;
                }
                this.comment = this.comment + "\n" + string.substring(1);
            }
            bufferedReader.reset();
            this.loadChildren(bufferedReader);
            bufferedReader.close();
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
        this.loading = false;
    }

    @Override
    public ConfigFile setComment(String string) {
        super.setComment(string);
        return this;
    }

    @Override
    public ConfigFile setSortMode(int n) {
        super.setSortMode(n);
        return this;
    }

    @Override
    public String getNameQualifier() {
        return "";
    }

    public static String readLine(BufferedReader bufferedReader) throws IOException {
        String string = bufferedReader.readLine();
        if (string != null) {
            return string.replace("\t", "");
        }
        return string;
    }

    public static String formatLine(String string) {
        if ((string = string.replace("\t", "")).startsWith("#")) {
            return string;
        }
        if (string.contains("=")) {
            string = string.substring(0, string.indexOf("=")).replace(" ", "") + string.substring(string.indexOf("="));
            return string;
        }
        string = string.replace(" ", "");
        return string;
    }

    public static void writeLine(PrintWriter printWriter, String string, int n) {
        for (int i = 0; i < n; ++i) {
            printWriter.print('\t');
        }
        printWriter.println(string);
    }

    @Override
    public void saveConfig() {
        PrintWriter printWriter;
        if (this.loading) {
            return;
        }
        try {
            printWriter = new PrintWriter(this.file);
        }
        catch (FileNotFoundException fileNotFoundException) {
            throw new RuntimeException(fileNotFoundException);
        }
        this.writeComment(printWriter, 0);
        ConfigFile.writeLine(printWriter, "", 0);
        this.saveTagTree(printWriter, 0, "");
        printWriter.flush();
        printWriter.close();
    }

    public boolean isLoading() {
        return this.loading;
    }
}

