/*
 * Decompiled with CFR 0.152.
 */
package optifine;

import java.awt.Dimension;
import java.awt.Font;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import optifine.Utils;
import optifine.json.JSONArray;
import optifine.json.JSONObject;
import optifine.json.JSONParser;
import optifine.json.JSONWriter;
import optifine.json.ParseException;

public class Installer {
    public static void main(String[] stringArray) {
        try {
            Installer.doInstall();
        }
        catch (Exception exception) {
            String string = exception.getMessage();
            if (string != null && string.equals("QUIET")) {
                return;
            }
            exception.printStackTrace();
            String string2 = Utils.getExceptionStackTrace(exception);
            string2 = string2.replace("\t", "  ");
            JTextArea jTextArea = new JTextArea(string2);
            jTextArea.setEditable(false);
            Font font = jTextArea.getFont();
            Font font2 = new Font("Monospaced", font.getStyle(), font.getSize());
            jTextArea.setFont(font2);
            JScrollPane jScrollPane = new JScrollPane(jTextArea);
            jScrollPane.setPreferredSize(new Dimension(600, 400));
            JOptionPane.showMessageDialog(null, jScrollPane, "Error", 0);
        }
    }

    public static void doInstall() throws Exception {
        File file = Utils.getWorkingDirectory();
        Utils.dbg("Dir minecraft: " + file);
        File file2 = new File(file, "libraries");
        Utils.dbg("Dir libraries: " + file2);
        File file3 = new File(file, "versions");
        Utils.dbg("Dir versions: " + file3);
        String string = Installer.getOptiFineVersion();
        Utils.dbg("OptiFine Version: " + string);
        String[] stringArray = Utils.tokenize(string, "_");
        String string2 = stringArray[1];
        Utils.dbg("Minecraft Version: " + string2);
        String string3 = Installer.getOptiFineEdition(stringArray);
        Utils.dbg("OptiFine Edition: " + string3);
        Installer.installOptiFineLibrary(string2, string3, file2);
        String string4 = string2 + "-OptiFine_" + string3;
        Utils.dbg("Minecraft_OptiFine Version: " + string4);
        Installer.copyMinecraftVersion(string2, string4, file3);
        Installer.updateJson(file3, string4, file2, string2, string3);
        Installer.updateLauncherJson(file, string4);
    }

    private static void updateLauncherJson(File file, String string) throws IOException, ParseException {
        JSONParser jSONParser = new JSONParser();
        File file2 = new File(file, "launcher_profiles.json");
        String string2 = Utils.readFile(file2);
        JSONObject jSONObject = (JSONObject)jSONParser.parse(string2);
        JSONObject jSONObject2 = (JSONObject)jSONObject.get("profiles");
        JSONObject jSONObject3 = (JSONObject)jSONObject2.get("OptiFine");
        if (jSONObject3 == null) {
            jSONObject3 = new JSONObject();
            jSONObject3.put("name", "OptiFine");
            jSONObject2.put("OptiFine", jSONObject3);
        }
        jSONObject3.put("lastVersionId", string);
        jSONObject.put("selectedProfile", "OptiFine");
        FileWriter fileWriter = new FileWriter(file2);
        JSONWriter jSONWriter = new JSONWriter(fileWriter);
        jSONWriter.writeObject(jSONObject);
        fileWriter.flush();
        fileWriter.close();
    }

    private static void updateJson(File file, String string, File file2, String string2, String string3) throws IOException, ParseException {
        Object object;
        Object object2;
        File file3 = new File(file, string);
        File file4 = new File(file3, string + ".json");
        String string4 = Utils.readFile(file4);
        JSONParser jSONParser = new JSONParser();
        JSONObject jSONObject = (JSONObject)jSONParser.parse(string4);
        jSONObject.put("id", string);
        JSONArray jSONArray = (JSONArray)jSONObject.get("libraries");
        String string5 = (String)jSONObject.get("mainClass");
        if (!string5.startsWith("net.minecraft.launchwrapper.")) {
            string5 = "net.minecraft.launchwrapper.Launch";
            jSONObject.put("mainClass", string5);
            object2 = (String)jSONObject.get("minecraftArguments");
            object2 = (String)object2 + "  --tweakClass optifine.OptiFineTweaker";
            jSONObject.put("minecraftArguments", object2);
            object = new JSONObject();
            ((HashMap)object).put("name", "net.minecraft:launchwrapper:1.7");
            jSONArray.add(0, object);
        }
        object2 = new JSONObject();
        ((HashMap)object2).put("name", "optifine:OptiFine:" + string2 + "_" + string3);
        jSONArray.add(0, object2);
        object = new FileWriter(file4);
        JSONWriter jSONWriter = new JSONWriter((Writer)object);
        jSONWriter.writeObject(jSONObject);
        ((OutputStreamWriter)object).flush();
        ((OutputStreamWriter)object).close();
    }

    public static String getOptiFineEdition(String[] stringArray) {
        if (stringArray.length <= 2) {
            return "";
        }
        String string = "";
        for (int i = 2; i < stringArray.length; ++i) {
            if (i > 2) {
                string = string + "_";
            }
            string = string + stringArray[i];
        }
        return string;
    }

    private static void installOptiFineLibrary(String string, String string2, File file) throws URISyntaxException, IOException {
        URL uRL = Installer.class.getProtectionDomain().getCodeSource().getLocation();
        Utils.dbg("URL: " + uRL);
        URI uRI = uRL.toURI();
        File file2 = new File(uRI);
        File file3 = new File(file, "optifine/OptiFine/" + string + "_" + string2);
        file3.mkdirs();
        File file4 = new File(file3, "OptiFine-" + string + "_" + string2 + ".jar");
        Utils.dbg("Source: " + file2);
        Utils.dbg("Dest: " + file4);
        Utils.copyFile(file2, file4);
    }

    private static void copyMinecraftVersion(String string, String string2, File file) throws IOException {
        File file2 = new File(file, string);
        if (!file2.exists()) {
            Utils.showErrorMessage("Minecraft version not found: " + string);
            throw new RuntimeException("QUIET");
        }
        File file3 = new File(file, string2);
        file3.mkdirs();
        Utils.dbg("Dir version MC: " + file2);
        Utils.dbg("Dir version MC-OF: " + file3);
        File file4 = new File(file2, string + ".jar");
        File file5 = new File(file3, string2 + ".jar");
        Utils.copyFile(file4, file5);
        File file6 = new File(file2, string + ".json");
        File file7 = new File(file3, string2 + ".json");
        Utils.copyFile(file6, file7);
    }

    public static String getOptiFineVersion() throws IOException {
        byte by;
        byte[] byArray;
        byte[] byArray2;
        int n;
        InputStream inputStream = Installer.class.getResourceAsStream("/Config.class");
        if (inputStream == null) {
            inputStream = Installer.class.getResourceAsStream("/VersionThread.class");
        }
        if ((n = Utils.find(byArray2 = Utils.readAll(inputStream), byArray = "OptiFine_".getBytes("ASCII"))) < 0) {
            return null;
        }
        int n2 = n;
        while (n < byArray2.length && (by = byArray2[n]) >= 32 && by <= 122) {
            ++n;
        }
        String string = new String(byArray2, n2, n - n2, "ASCII");
        return string;
    }
}

