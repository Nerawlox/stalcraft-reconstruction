/*
 * Decompiled with CFR 0.152.
 */
package argo.format;

import java.math.BigDecimal;
import java.math.BigInteger;

public final class JsonNumberUtils {
    public static BigDecimal asBigDecimal(String jsonNumberString) {
        return jsonNumberString == null ? null : new BigDecimal(jsonNumberString);
    }

    public static BigInteger asBigInteger(String jsonNumberString) {
        try {
            return jsonNumberString == null ? null : JsonNumberUtils.asBigDecimal(jsonNumberString).toBigIntegerExact();
        }
        catch (ArithmeticException e) {
            throw new NumberFormatException("Given String [" + jsonNumberString + "] was non-integer");
        }
    }

    public static Double asDouble(String jsonNumberString) {
        return jsonNumberString == null ? null : Double.valueOf(JsonNumberUtils.asBigDecimal(jsonNumberString).doubleValue());
    }

    public static Integer asInteger(String jsonNumberString) {
        return jsonNumberString == null ? null : Integer.valueOf(JsonNumberUtils.asBigInteger(jsonNumberString).intValue());
    }
}

