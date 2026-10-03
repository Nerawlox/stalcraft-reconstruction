/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.misc;

import java.util.HashMap;
import java.util.Map;

public class eifc {
    private static final Map<Character, String> _a = new HashMap<Character, String>();

    public static String _a(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < string.length(); ++i) {
            Character c = Character.valueOf(string.charAt(i));
            String string2 = _a.get(c);
            if (string2 == null) {
                stringBuilder.append(c);
                continue;
            }
            stringBuilder.append(string2);
        }
        return stringBuilder.toString();
    }

    static {
        _a.put(Character.valueOf('\u0410'), "A");
        _a.put(Character.valueOf('\u0411'), "B");
        _a.put(Character.valueOf('\u0412'), "V");
        _a.put(Character.valueOf('\u0413'), "G");
        _a.put(Character.valueOf('\u0414'), "D");
        _a.put(Character.valueOf('\u0415'), "E");
        _a.put(Character.valueOf('\u0401'), "E");
        _a.put(Character.valueOf('\u0416'), "Zh");
        _a.put(Character.valueOf('\u0417'), "Z");
        _a.put(Character.valueOf('\u0418'), "I");
        _a.put(Character.valueOf('\u0419'), "I");
        _a.put(Character.valueOf('\u041a'), "K");
        _a.put(Character.valueOf('\u041b'), "L");
        _a.put(Character.valueOf('\u041c'), "M");
        _a.put(Character.valueOf('\u041d'), "N");
        _a.put(Character.valueOf('\u041e'), "O");
        _a.put(Character.valueOf('\u041f'), "P");
        _a.put(Character.valueOf('\u0420'), "R");
        _a.put(Character.valueOf('\u0421'), "S");
        _a.put(Character.valueOf('\u0422'), "T");
        _a.put(Character.valueOf('\u0423'), "U");
        _a.put(Character.valueOf('\u0424'), "F");
        _a.put(Character.valueOf('\u0425'), "H");
        _a.put(Character.valueOf('\u0426'), "C");
        _a.put(Character.valueOf('\u0427'), "Ch");
        _a.put(Character.valueOf('\u0428'), "Sh");
        _a.put(Character.valueOf('\u0429'), "Sh");
        _a.put(Character.valueOf('\u042a'), "");
        _a.put(Character.valueOf('\u042b'), "Y");
        _a.put(Character.valueOf('\u042c'), "");
        _a.put(Character.valueOf('\u042d'), "E");
        _a.put(Character.valueOf('\u042e'), "U");
        _a.put(Character.valueOf('\u042f'), "Ya");
        _a.put(Character.valueOf('\u0430'), "a");
        _a.put(Character.valueOf('\u0431'), "b");
        _a.put(Character.valueOf('\u0432'), "v");
        _a.put(Character.valueOf('\u0433'), "g");
        _a.put(Character.valueOf('\u0434'), "d");
        _a.put(Character.valueOf('\u0435'), "e");
        _a.put(Character.valueOf('\u0451'), "e");
        _a.put(Character.valueOf('\u0436'), "zh");
        _a.put(Character.valueOf('\u0437'), "z");
        _a.put(Character.valueOf('\u0438'), "i");
        _a.put(Character.valueOf('\u0439'), "i");
        _a.put(Character.valueOf('\u043a'), "k");
        _a.put(Character.valueOf('\u043b'), "l");
        _a.put(Character.valueOf('\u043c'), "m");
        _a.put(Character.valueOf('\u043d'), "n");
        _a.put(Character.valueOf('\u043e'), "o");
        _a.put(Character.valueOf('\u043f'), "p");
        _a.put(Character.valueOf('\u0440'), "r");
        _a.put(Character.valueOf('\u0441'), "s");
        _a.put(Character.valueOf('\u0442'), "t");
        _a.put(Character.valueOf('\u0443'), "u");
        _a.put(Character.valueOf('\u0444'), "f");
        _a.put(Character.valueOf('\u0445'), "h");
        _a.put(Character.valueOf('\u0446'), "c");
        _a.put(Character.valueOf('\u0447'), "ch");
        _a.put(Character.valueOf('\u0448'), "sh");
        _a.put(Character.valueOf('\u0449'), "sh");
        _a.put(Character.valueOf('\u044a'), "");
        _a.put(Character.valueOf('\u044b'), "y");
        _a.put(Character.valueOf('\u044c'), "");
        _a.put(Character.valueOf('\u044d'), "e");
        _a.put(Character.valueOf('\u044e'), "u");
        _a.put(Character.valueOf('\u044f'), "ya");
        _a.put(Character.valueOf(' '), "_");
    }
}

