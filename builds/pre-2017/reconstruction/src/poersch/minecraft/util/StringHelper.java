/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.util;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class StringHelper {
    public static List<String> splitTrimToList(String string, char c) {
        ArrayList<String> arrayList = new ArrayList<String>();
        int n = -1;
        int n2 = -1;
        for (int i = 0; i < string.length(); ++i) {
            if (string.charAt(i) == c) {
                if (n > -1 && n2 >= n) {
                    arrayList.add(string.substring(n, n2 + 1));
                }
                n2 = -1;
                n = -1;
                continue;
            }
            if (Character.isWhitespace(string.charAt(i))) continue;
            if (n == -1) {
                n = i;
            }
            n2 = i;
        }
        if (n > -1 && n2 >= n) {
            arrayList.add(string.substring(n, n2 + 1));
        }
        return arrayList;
    }

    public static String[] splitTrimToArray(String string, char c) {
        List<String> list = StringHelper.splitTrimToList(string, c);
        return list.toArray(new String[list.size()]);
    }

    public static List<Integer> splitTrimIntegerToList(String string, char c) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int n = -1;
        int n2 = -1;
        for (int i = 0; i < string.length(); ++i) {
            if (string.charAt(i) == c) {
                if (n > -1 && n2 >= n) {
                    try {
                        arrayList.add(Integer.parseInt(string.substring(n, n2 + 1)));
                    }
                    catch (Exception exception) {
                        // empty catch block
                    }
                }
                n2 = -1;
                n = -1;
                continue;
            }
            if (Character.isWhitespace(string.charAt(i))) continue;
            if (n == -1) {
                n = i;
            }
            n2 = i;
        }
        if (n > -1 && n2 >= n) {
            try {
                arrayList.add(Integer.parseInt(string.substring(n, n2 + 1)));
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return arrayList;
    }

    public static Integer[] splitTrimIntegerToArray(String string, char c) {
        List<Integer> list = StringHelper.splitTrimIntegerToList(string, c);
        return list.toArray(new Integer[list.size()]);
    }

    public static Map<String, String> readStreamIntoMap(InputStream inputStream, Map<String, String> map) {
        return StringHelper.readStreamIntoMap(inputStream, map, '=', ',', "#");
    }

    public static Map<String, String> readStreamIntoMap(InputStream inputStream, Map<String, String> map, char c, char c2, String string) {
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNext()) {
            String string2;
            List<String> list = StringHelper.splitTrimToList(scanner.nextLine(), c);
            if (list.size() <= 1 || list.get(0).startsWith(string)) continue;
            map.put(list.get(0), (string2 = map.get(list.get(0))) == null ? list.get(1) : string2 + c2 + list.get(1));
        }
        scanner.close();
        return map;
    }
}

