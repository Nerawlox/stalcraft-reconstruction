/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.config;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedList;
import noppes.npcs.config.ConfigProp;

public class ConfigLoader {
    private boolean updateFile = false;
    private File dir;
    private String fileName;
    private Class configClass;
    private LinkedList configFields;

    public ConfigLoader(Class clazz, File file, String string) {
        Field[] fieldArray;
        if (!file.exists()) {
            file.mkdir();
        }
        this.dir = file;
        this.configClass = clazz;
        this.configFields = new LinkedList();
        this.fileName = string + ".cfg";
        Field[] fieldArray2 = fieldArray = this.configClass.getDeclaredFields();
        int n = fieldArray.length;
        for (int i = 0; i < n; ++i) {
            Field field = fieldArray2[i];
            if (!field.isAnnotationPresent(ConfigProp.class)) continue;
            this.configFields.add(field);
        }
    }

    public void loadConfig() {
        try {
            File file = new File(this.dir, this.fileName);
            HashMap<String, Object> hashMap = new HashMap<String, Object>();
            for (Object object : this.configFields) {
                ConfigProp configProp = ((Field)object).getAnnotation(ConfigProp.class);
                hashMap.put(!configProp.name().isEmpty() ? configProp.name() : ((Field)object).getName(), object);
            }
            if (file.exists()) {
                Object object;
                object = this.parseConfig(file, hashMap);
                for (String string : ((HashMap)object).keySet()) {
                    Field field = (Field)hashMap.get(string);
                    Object v = ((HashMap)object).get(string);
                    if (v.equals(field.get(null))) continue;
                    field.set(null, v);
                }
                for (String string : hashMap.keySet()) {
                    if (((HashMap)object).containsKey(string)) continue;
                    this.updateFile = true;
                }
            } else {
                this.updateFile = true;
            }
        }
        catch (Exception exception) {
            this.updateFile = true;
            System.err.println(exception.getMessage());
        }
        if (this.updateFile) {
            this.updateConfig();
        }
        this.updateFile = false;
    }

    private HashMap parseConfig(File file, HashMap hashMap) throws Exception {
        String string;
        HashMap<String, String> hashMap2 = new HashMap<String, String>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        while ((string = bufferedReader.readLine()) != null) {
            if (string.startsWith("#") || string.length() == 0) continue;
            int n = string.indexOf("=");
            if (n > 0 && n != string.length()) {
                String string2 = string.substring(0, n);
                String string3 = string.substring(n + 1);
                if (!hashMap.containsKey(string2)) {
                    this.updateFile = true;
                    continue;
                }
                Object object = null;
                Class<Object> clazz = ((Field)hashMap.get(string2)).getType();
                if (clazz.isAssignableFrom(String.class)) {
                    object = string3;
                } else if (clazz.isAssignableFrom(Integer.TYPE)) {
                    object = Integer.parseInt(string3);
                } else if (clazz.isAssignableFrom(Short.TYPE)) {
                    object = Short.parseShort(string3);
                } else if (clazz.isAssignableFrom(Byte.TYPE)) {
                    object = Byte.parseByte(string3);
                } else if (clazz.isAssignableFrom(Boolean.TYPE)) {
                    object = Boolean.parseBoolean(string3);
                } else if (clazz.isAssignableFrom(Float.TYPE)) {
                    object = Float.valueOf(Float.parseFloat(string3));
                } else if (clazz.isAssignableFrom(Double.TYPE)) {
                    object = Double.parseDouble(string3);
                }
                if (object == null) continue;
                hashMap2.put(string2, (String)object);
                continue;
            }
            this.updateFile = true;
        }
        bufferedReader.close();
        return hashMap2;
    }

    public void updateConfig() {
        File file = new File(this.dir, this.fileName);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            for (Field field : this.configFields) {
                ConfigProp configProp = field.getAnnotation(ConfigProp.class);
                if (configProp.info().length() != 0) {
                    bufferedWriter.write("#" + configProp.info() + System.getProperty("line.separator"));
                }
                String string = !configProp.name().isEmpty() ? configProp.name() : field.getName();
                try {
                    bufferedWriter.write(string + "=" + field.get(null).toString() + System.getProperty("line.separator"));
                    bufferedWriter.write(System.getProperty("line.separator"));
                }
                catch (IllegalArgumentException illegalArgumentException) {
                    illegalArgumentException.printStackTrace();
                }
                catch (IllegalAccessException illegalAccessException) {
                    illegalAccessException.printStackTrace();
                }
            }
            bufferedWriter.close();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }
}

