/*
 * Decompiled with CFR 0.152.
 */
package javax.crypto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.lang.reflect.Constructor;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import javax.crypto.SunJCE_k;
import javax.crypto.SunJCE_l;
import javax.crypto.SunJCE_m;
import javax.crypto.SunJCE_n;
import javax.crypto.SunJCE_o;

class SunJCE_j {
    private Vector a = new Vector();
    private StreamTokenizer b;
    private int c;

    SunJCE_j() {
    }

    void a(Reader reader) throws SunJCE_l, IOException {
        if (!(reader instanceof BufferedReader)) {
            reader = new BufferedReader(reader);
        }
        this.b = new StreamTokenizer(reader);
        this.b.resetSyntax();
        this.b.wordChars(97, 122);
        this.b.wordChars(65, 90);
        this.b.wordChars(46, 46);
        this.b.wordChars(48, 57);
        this.b.wordChars(95, 95);
        this.b.wordChars(36, 36);
        this.b.wordChars(160, 255);
        this.b.whitespaceChars(0, 32);
        this.b.commentChar(47);
        this.b.quoteChar(39);
        this.b.quoteChar(34);
        this.b.lowerCaseMode(false);
        this.b.ordinaryChar(47);
        this.b.slashSlashComments(true);
        this.b.slashStarComments(true);
        this.b.parseNumbers();
        Hashtable hashtable = null;
        this.c = this.b.nextToken();
        while (this.c != -1) {
            if (this.b("grant")) {
                SunJCE_k sunJCE_k = this.a(hashtable);
                if (sunJCE_k != null) {
                    this.a.addElement(sunJCE_k);
                }
            } else {
                throw new SunJCE_l(this.b.lineno(), "expected grant statement");
            }
            this.c(";");
        }
    }

    private SunJCE_k a(Hashtable hashtable) throws SunJCE_l, IOException {
        SunJCE_k sunJCE_k = new SunJCE_k();
        this.c("grant");
        this.c("{");
        while (!this.b("}")) {
            if (this.b("Permission")) {
                SunJCE_m sunJCE_m = this.b(hashtable);
                sunJCE_k.a(sunJCE_m);
                this.c(";");
                continue;
            }
            throw new SunJCE_l(this.b.lineno(), "expected permission entry");
        }
        this.c("}");
        return sunJCE_k;
    }

    private SunJCE_m b(Hashtable hashtable) throws SunJCE_l, IOException {
        SunJCE_m sunJCE_m = new SunJCE_m();
        this.c("Permission");
        sunJCE_m.a = this.c("permission type");
        if (sunJCE_m.a.equals("javax.crypto.CryptoAllPermission")) {
            sunJCE_m.b = "CryptoAllPermission";
            sunJCE_m.d = -1;
            return sunJCE_m;
        }
        if (this.b("\"")) {
            sunJCE_m.b = this.c("quoted string").toUpperCase();
        } else if (this.b("*")) {
            this.c("*");
            sunJCE_m.b = "*";
        } else {
            throw new SunJCE_l(this.b.lineno(), "Missing the algorithm name");
        }
        this.a(",");
        if (this.b("\"")) {
            sunJCE_m.c = this.c("quoted string").toUpperCase();
        }
        this.a(",");
        if (!this.a(sunJCE_m.b, sunJCE_m.c, hashtable)) {
            throw new SunJCE_l(this.b.lineno(), "Inconsistent policy");
        }
        if (this.b("number")) {
            sunJCE_m.d = this.b();
        } else if (this.b("*")) {
            this.c("*");
            sunJCE_m.d = -1;
        } else {
            if (!this.b(";")) {
                throw new SunJCE_l(this.b.lineno(), "Missing the maximum allowable key size");
            }
            sunJCE_m.d = -1;
        }
        this.a(",");
        if (this.b("\"")) {
            String string = this.c("quoted string");
            Vector<Integer> vector = new Vector<Integer>(1);
            while (this.b(",")) {
                this.c(",");
                if (this.b("number")) {
                    vector.addElement(new Integer(this.b()));
                    continue;
                }
                if (this.b("*")) {
                    this.c("*");
                    vector.addElement(new Integer(-1));
                    continue;
                }
                throw new SunJCE_l(this.b.lineno(), "Expecting an integer");
            }
            Object[] objectArray = new Integer[vector.size()];
            vector.copyInto(objectArray);
            sunJCE_m.e = SunJCE_j.a(string, (Integer[])objectArray);
        }
        return sunJCE_m;
    }

    private static final AlgorithmParameterSpec a(String string, Integer[] integerArray) throws SunJCE_l {
        AlgorithmParameterSpec algorithmParameterSpec = null;
        try {
            Class<?> clazz = Class.forName(string);
            Class[] classArray = new Class[integerArray.length];
            int n = 0;
            while (n < integerArray.length) {
                classArray[n] = Integer.TYPE;
                ++n;
            }
            Constructor<?> constructor = clazz.getConstructor(classArray);
            algorithmParameterSpec = (AlgorithmParameterSpec)constructor.newInstance(integerArray);
        }
        catch (Exception exception) {
            throw new SunJCE_l("Cannot call the constructor of " + string + exception);
        }
        return algorithmParameterSpec;
    }

    private boolean a(String string) throws SunJCE_l, IOException {
        if (this.b(string)) {
            this.c(string);
            return true;
        }
        return false;
    }

    private boolean b(String string) {
        boolean bl = false;
        switch (this.c) {
            case -3: {
                if (!string.equalsIgnoreCase(this.b.sval)) break;
                bl = true;
                break;
            }
            case -2: {
                if (!string.equalsIgnoreCase("number")) break;
                bl = true;
                break;
            }
            case 44: {
                if (!string.equals(",")) break;
                bl = true;
                break;
            }
            case 123: {
                if (!string.equals("{")) break;
                bl = true;
                break;
            }
            case 125: {
                if (!string.equals("}")) break;
                bl = true;
                break;
            }
            case 34: {
                if (!string.equals("\"")) break;
                bl = true;
                break;
            }
            case 42: {
                if (!string.equals("*")) break;
                bl = true;
                break;
            }
            case 59: {
                if (!string.equals(";")) break;
                bl = true;
                break;
            }
        }
        return bl;
    }

    private int b() throws SunJCE_l, IOException {
        int n = -1;
        int n2 = this.b.lineno();
        String string = null;
        switch (this.c) {
            case -2: {
                n = (int)this.b.nval;
                if (n < 0) {
                    string = String.valueOf(this.b.nval);
                }
                this.c = this.b.nextToken();
                break;
            }
            default: {
                string = this.b.sval;
            }
        }
        if (n <= 0) {
            throw new SunJCE_l(n2, "a non-negative number", string);
        }
        return n;
    }

    private String c(String string) throws SunJCE_l, IOException {
        String string2 = null;
        switch (this.c) {
            case -2: {
                throw new SunJCE_l(this.b.lineno(), string, "number " + String.valueOf(this.b.nval));
            }
            case -1: {
                throw new SunJCE_l("expected " + string + ", read end of file");
            }
            case -3: {
                if (string.equalsIgnoreCase(this.b.sval)) {
                    this.c = this.b.nextToken();
                    break;
                }
                if (string.equalsIgnoreCase("permission type")) {
                    string2 = this.b.sval;
                    this.c = this.b.nextToken();
                    break;
                }
                throw new SunJCE_l(this.b.lineno(), string, this.b.sval);
            }
            case 34: {
                if (string.equalsIgnoreCase("quoted string")) {
                    string2 = this.b.sval;
                    this.c = this.b.nextToken();
                    break;
                }
                if (string.equalsIgnoreCase("permission type")) {
                    string2 = this.b.sval;
                    this.c = this.b.nextToken();
                    break;
                }
                throw new SunJCE_l(this.b.lineno(), string, this.b.sval);
            }
            case 44: {
                if (string.equals(",")) {
                    this.c = this.b.nextToken();
                    break;
                }
                throw new SunJCE_l(this.b.lineno(), string, ",");
            }
            case 123: {
                if (string.equals("{")) {
                    this.c = this.b.nextToken();
                    break;
                }
                throw new SunJCE_l(this.b.lineno(), string, "{");
            }
            case 125: {
                if (string.equals("}")) {
                    this.c = this.b.nextToken();
                    break;
                }
                throw new SunJCE_l(this.b.lineno(), string, "}");
            }
            case 59: {
                if (string.equals(";")) {
                    this.c = this.b.nextToken();
                    break;
                }
                throw new SunJCE_l(this.b.lineno(), string, ";");
            }
            case 42: {
                if (string.equals("*")) {
                    this.c = this.b.nextToken();
                    break;
                }
                throw new SunJCE_l(this.b.lineno(), string, "*");
            }
            default: {
                throw new SunJCE_l(this.b.lineno(), string, new String(new char[]{(char)this.c}));
            }
        }
        return string2;
    }

    SunJCE_o[] a() {
        Object object;
        Vector<SunJCE_o> vector = new Vector<SunJCE_o>();
        Enumeration enumeration = this.a.elements();
        while (enumeration.hasMoreElements()) {
            object = (SunJCE_k)enumeration.nextElement();
            Enumeration enumeration2 = ((SunJCE_k)object).a();
            while (enumeration2.hasMoreElements()) {
                SunJCE_m sunJCE_m = (SunJCE_m)enumeration2.nextElement();
                if (sunJCE_m.a.equals("javax.crypto.CryptoAllPermission")) {
                    vector.addElement(new SunJCE_n());
                    continue;
                }
                vector.addElement(new SunJCE_o(sunJCE_m.b, sunJCE_m.d, sunJCE_m.e, sunJCE_m.c));
            }
        }
        object = new SunJCE_o[vector.size()];
        vector.copyInto((Object[])object);
        return object;
    }

    private boolean a(String string, String string2, Hashtable hashtable) {
        Vector<String> vector;
        String string3;
        String string4 = string3 = string2 == null ? "none" : string2;
        if (hashtable == null) {
            hashtable = new Hashtable();
            Vector<String> vector2 = new Vector<String>(1);
            vector2.addElement(string3);
            hashtable.put(string, vector2);
            return true;
        }
        if (hashtable.containsKey("CryptoAllPermission")) {
            return false;
        }
        if (hashtable.containsKey(string)) {
            vector = (Vector<String>)hashtable.get(string);
            if (vector.contains(string3)) {
                return false;
            }
        } else {
            vector = new Vector<String>(1);
        }
        vector.addElement(string3);
        hashtable.put(string, vector);
        return true;
    }
}

