/*
 * Decompiled with CFR 0.152.
 */
package javax.vecmath;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

class VecMathI18N {
    VecMathI18N() {
    }

    static String getString(String string) {
        String string2;
        try {
            string2 = ResourceBundle.getBundle("javax.vecmath.ExceptionStrings").getString(string);
        }
        catch (MissingResourceException missingResourceException) {
            System.err.println("VecMathI18N: Error looking up: " + string);
            string2 = string;
        }
        return string2;
    }
}

