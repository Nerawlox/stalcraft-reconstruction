/*
 * Decompiled with CFR 0.152.
 */
package net.sf.kdgcommons.html;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import net.sf.kdgcommons.lang.StringUtil;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class HtmlUtil {
    private static Map<String, Character> entityLookup = new HashMap<String, Character>();

    public static String urlEncode(String string) {
        if (string == null) {
            return "";
        }
        try {
            String string2 = URLEncoder.encode(string, "UTF-8");
            if (string2.indexOf(43) >= 0) {
                string2 = string2.replace("+", "%20");
            }
            return string2;
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new RuntimeException("this JVM doesn't support UTF-8!", unsupportedEncodingException);
        }
    }

    public static String urlDecode(String string) {
        if (string == null) {
            return "";
        }
        try {
            return URLDecoder.decode(string, "UTF-8");
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new RuntimeException("this JVM doesn't support UTF-8!", unsupportedEncodingException);
        }
    }

    public static String escape(String string) {
        if (string == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(string.length() * 5 / 4);
        block7: for (int i = 0; i < string.length(); ++i) {
            char c = string.charAt(i);
            switch (c) {
                case '&': {
                    stringBuilder.append("&amp;");
                    continue block7;
                }
                case '<': {
                    stringBuilder.append("&lt;");
                    continue block7;
                }
                case '>': {
                    stringBuilder.append("&gt;");
                    continue block7;
                }
                case '\'': {
                    stringBuilder.append("&#39;");
                    continue block7;
                }
                case '\"': {
                    stringBuilder.append("&quot;");
                    continue block7;
                }
                default: {
                    if (c < '\u0080') {
                        stringBuilder.append(c);
                        continue block7;
                    }
                    stringBuilder.append("&#x").append(Integer.toString(c, 16).toLowerCase()).append(";");
                }
            }
        }
        return stringBuilder.toString();
    }

    public static String unescape(String string) {
        if (string == null) {
            return "";
        }
        if (string.indexOf(38) < 0) {
            return string;
        }
        StringBuilder stringBuilder = new StringBuilder(string.length());
        int n = 0;
        while (n < string.length()) {
            int n2;
            int n3 = string.indexOf(38, n);
            int n4 = n2 = n3 < 0 ? -1 : string.indexOf(59, n3);
            if (n3 < 0 || n2 < 0) {
                stringBuilder.append(string.substring(n));
                break;
            }
            stringBuilder.append(string.substring(n, n3));
            String string2 = string.substring(n3 + 1, n2);
            if (entityLookup.containsKey(string2)) {
                stringBuilder.append(entityLookup.get(string2).charValue());
            } else if (string2.length() > 1 && string2.charAt(0) == '#') {
                int n5 = 10;
                if ((string2 = string2.substring(1)).charAt(0) == 'x' || string2.charAt(0) == 'X') {
                    string2 = string2.substring(1);
                    n5 = 16;
                }
                char c = (char)(Integer.parseInt(string2, n5) & 0xFFFF);
                stringBuilder.append(c);
            } else {
                stringBuilder.append('&').append(string2).append(';');
            }
            n = n2 + 1;
        }
        return stringBuilder.toString();
    }

    public static void appendAttribute(StringBuilder stringBuilder, String string, Object object) {
        object = object == null ? "" : object;
        stringBuilder.append(" ").append(string).append("='").append(HtmlUtil.escape(object.toString())).append("'");
    }

    public static void appendOptionalAttribute(StringBuilder stringBuilder, String string, Object object) {
        if (object == null) {
            return;
        }
        String string2 = object.toString();
        if (string2.length() > 0) {
            HtmlUtil.appendAttribute(stringBuilder, string, string2);
        }
    }

    public static String buildQueryString(Map<?, ?> map, boolean bl) {
        StringBuilder stringBuilder = new StringBuilder(map.size() * 32);
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            String string;
            String string2 = String.valueOf(entry.getKey());
            String string3 = string = entry.getValue() == null ? "" : String.valueOf(entry.getValue());
            if (StringUtil.isEmpty(string) && bl) continue;
            stringBuilder.append(stringBuilder.length() > 0 ? "&" : "").append(string2).append("=").append(HtmlUtil.urlEncode(string));
        }
        return stringBuilder.toString();
    }

    public static Map<String, String> parseQueryString(String string, boolean bl) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        if (string == null || string.length() == 0) {
            return hashMap;
        }
        if (string.charAt(0) == '?') {
            string = string.substring(1);
        }
        if (string.length() == 0) {
            return hashMap;
        }
        for (String string2 : string.split("&")) {
            int n = string2.indexOf(61);
            if (n < 0) {
                throw new RuntimeException("unparsable parameter: " + string2);
            }
            String string3 = string2.substring(0, n);
            String string4 = string2.substring(n + 1);
            if (string4.length() <= 0 && bl) continue;
            hashMap.put(string3, HtmlUtil.urlDecode(string4));
        }
        return hashMap;
    }

    public static String htmlToText(String string) {
        if (string == null) {
            string = "";
        }
        string = string.replaceAll("[\r\n]+", " ");
        StringBuilder stringBuilder = new StringBuilder(string.trim());
        int n = 0;
        while ((n = stringBuilder.indexOf("<", n)) >= 0) {
            int n2 = stringBuilder.indexOf(">", n);
            if (n2 < 0) {
                stringBuilder.delete(n, stringBuilder.length());
                break;
            }
            String string2 = stringBuilder.substring(n + 1, n2).trim().toUpperCase();
            stringBuilder.delete(n, n2 + 1);
            string2 = string2.replaceAll("\\s+.*", "");
            if (string2.equals("P") || string2.startsWith("BR")) {
                stringBuilder.insert(n, "\n");
                continue;
            }
            if (!string2.equals("LI")) continue;
            stringBuilder.insert(n, "\n* ");
        }
        return stringBuilder.toString();
    }

    static {
        entityLookup.put("AElig", Character.valueOf('\u00c6'));
        entityLookup.put("Aacute", Character.valueOf('\u00c1'));
        entityLookup.put("Acirc", Character.valueOf('\u00c2'));
        entityLookup.put("Agrave", Character.valueOf('\u00c0'));
        entityLookup.put("Aring", Character.valueOf('\u00c5'));
        entityLookup.put("Atilde", Character.valueOf('\u00c3'));
        entityLookup.put("Auml", Character.valueOf('\u00c4'));
        entityLookup.put("Ccedil", Character.valueOf('\u00c7'));
        entityLookup.put("ETH", Character.valueOf('\u00d0'));
        entityLookup.put("Eacute", Character.valueOf('\u00c9'));
        entityLookup.put("Ecirc", Character.valueOf('\u00ca'));
        entityLookup.put("Egrave", Character.valueOf('\u00c8'));
        entityLookup.put("Euml", Character.valueOf('\u00cb'));
        entityLookup.put("Iacute", Character.valueOf('\u00cd'));
        entityLookup.put("Icirc", Character.valueOf('\u00ce'));
        entityLookup.put("Igrave", Character.valueOf('\u00cc'));
        entityLookup.put("Iuml", Character.valueOf('\u00cf'));
        entityLookup.put("Ntilde", Character.valueOf('\u00d1'));
        entityLookup.put("Oacute", Character.valueOf('\u00d3'));
        entityLookup.put("Ocirc", Character.valueOf('\u00d4'));
        entityLookup.put("Ograve", Character.valueOf('\u00d2'));
        entityLookup.put("Oslash", Character.valueOf('\u00d8'));
        entityLookup.put("Otilde", Character.valueOf('\u00d5'));
        entityLookup.put("Ouml", Character.valueOf('\u00d6'));
        entityLookup.put("THORN", Character.valueOf('\u00de'));
        entityLookup.put("Uacute", Character.valueOf('\u00da'));
        entityLookup.put("Ucirc", Character.valueOf('\u00db'));
        entityLookup.put("Ugrave", Character.valueOf('\u00d9'));
        entityLookup.put("Uuml", Character.valueOf('\u00dc'));
        entityLookup.put("Yacute", Character.valueOf('\u00dd'));
        entityLookup.put("aacute", Character.valueOf('\u00e1'));
        entityLookup.put("acirc", Character.valueOf('\u00e2'));
        entityLookup.put("acute", Character.valueOf('\u00b4'));
        entityLookup.put("aelig", Character.valueOf('\u00e6'));
        entityLookup.put("agrave", Character.valueOf('\u00e0'));
        entityLookup.put("amp", Character.valueOf('&'));
        entityLookup.put("apos", Character.valueOf('\''));
        entityLookup.put("aring", Character.valueOf('\u00e5'));
        entityLookup.put("atilde", Character.valueOf('\u00e3'));
        entityLookup.put("auml", Character.valueOf('\u00e4'));
        entityLookup.put("brvbar", Character.valueOf('\u00a6'));
        entityLookup.put("ccedil", Character.valueOf('\u00e7'));
        entityLookup.put("cedil", Character.valueOf('\u00b8'));
        entityLookup.put("cent", Character.valueOf('\u00a2'));
        entityLookup.put("copy", Character.valueOf('\u00a9'));
        entityLookup.put("curren", Character.valueOf('\u00a4'));
        entityLookup.put("deg", Character.valueOf('\u00b0'));
        entityLookup.put("divide", Character.valueOf('\u00f7'));
        entityLookup.put("eacute", Character.valueOf('\u00e9'));
        entityLookup.put("ecirc", Character.valueOf('\u00ea'));
        entityLookup.put("egrave", Character.valueOf('\u00e8'));
        entityLookup.put("eth", Character.valueOf('\u00f0'));
        entityLookup.put("euml", Character.valueOf('\u00eb'));
        entityLookup.put("frac12", Character.valueOf('\u00bd'));
        entityLookup.put("frac14", Character.valueOf('\u00bc'));
        entityLookup.put("frac34", Character.valueOf('\u00be'));
        entityLookup.put("gt", Character.valueOf('>'));
        entityLookup.put("iacute", Character.valueOf('\u00ed'));
        entityLookup.put("icirc", Character.valueOf('\u00ee'));
        entityLookup.put("iexcl", Character.valueOf('\u00a1'));
        entityLookup.put("igrave", Character.valueOf('\u00ec'));
        entityLookup.put("iquest", Character.valueOf('\u00bf'));
        entityLookup.put("iuml", Character.valueOf('\u00ef'));
        entityLookup.put("laquo", Character.valueOf('\u00ab'));
        entityLookup.put("lt", Character.valueOf('<'));
        entityLookup.put("macr", Character.valueOf('\u00af'));
        entityLookup.put("micro", Character.valueOf('\u00b5'));
        entityLookup.put("middot", Character.valueOf('\u00b7'));
        entityLookup.put("nbsp", Character.valueOf('\u00a0'));
        entityLookup.put("not", Character.valueOf('\u00ac'));
        entityLookup.put("ntilde", Character.valueOf('\u00f1'));
        entityLookup.put("oacute", Character.valueOf('\u00f3'));
        entityLookup.put("ocirc", Character.valueOf('\u00f4'));
        entityLookup.put("ograve", Character.valueOf('\u00f2'));
        entityLookup.put("ordf", Character.valueOf('\u00aa'));
        entityLookup.put("ordm", Character.valueOf('\u00ba'));
        entityLookup.put("oslash", Character.valueOf('\u00f8'));
        entityLookup.put("otilde", Character.valueOf('\u00f5'));
        entityLookup.put("ouml", Character.valueOf('\u00f6'));
        entityLookup.put("para", Character.valueOf('\u00b6'));
        entityLookup.put("plusmn", Character.valueOf('\u00b1'));
        entityLookup.put("pound", Character.valueOf('\u00a3'));
        entityLookup.put("quot", Character.valueOf('\"'));
        entityLookup.put("raquo", Character.valueOf('\u00bb'));
        entityLookup.put("reg", Character.valueOf('\u00ae'));
        entityLookup.put("sect", Character.valueOf('\u00a7'));
        entityLookup.put("shy", Character.valueOf('\u00ad'));
        entityLookup.put("sup1", Character.valueOf('\u00b9'));
        entityLookup.put("sup2", Character.valueOf('\u00b2'));
        entityLookup.put("sup3", Character.valueOf('\u00b3'));
        entityLookup.put("szlig", Character.valueOf('\u00df'));
        entityLookup.put("thorn", Character.valueOf('\u00fe'));
        entityLookup.put("times", Character.valueOf('\u00d7'));
        entityLookup.put("uacute", Character.valueOf('\u00fa'));
        entityLookup.put("ucirc", Character.valueOf('\u00fb'));
        entityLookup.put("ugrave", Character.valueOf('\u00f9'));
        entityLookup.put("uml", Character.valueOf('\u00a8'));
        entityLookup.put("uuml", Character.valueOf('\u00fc'));
        entityLookup.put("yacute", Character.valueOf('\u00fd'));
        entityLookup.put("yen", Character.valueOf('\u00a5'));
        entityLookup.put("yuml", Character.valueOf('\u00ff'));
    }
}

