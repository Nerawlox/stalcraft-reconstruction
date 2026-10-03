/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.common;

import java.util.ArrayList;

public class Property {
    private String name;
    private String value;
    public String comment;
    private String[] values;
    private final boolean wasRead;
    private final boolean isList;
    private final Type type;
    private boolean changed = false;

    public Property() {
        this.wasRead = false;
        this.type = null;
        this.isList = false;
    }

    public Property(String string, String string2, Type type) {
        this(string, string2, type, false);
    }

    Property(String string, String string2, Type type, boolean bl) {
        this.setName(string);
        this.value = string2;
        this.type = type;
        this.wasRead = bl;
        this.isList = false;
    }

    public Property(String string, String[] stringArray, Type type) {
        this(string, stringArray, type, false);
    }

    Property(String string, String[] stringArray, Type type, boolean bl) {
        this.setName(string);
        this.type = type;
        this.values = stringArray;
        this.wasRead = bl;
        this.isList = true;
    }

    public String getString() {
        return this.value;
    }

    public int getInt() {
        return this.getInt(-1);
    }

    public int getInt(int n) {
        try {
            return Integer.parseInt(this.value);
        }
        catch (NumberFormatException numberFormatException) {
            return n;
        }
    }

    public boolean isIntValue() {
        try {
            Integer.parseInt(this.value);
            return true;
        }
        catch (NumberFormatException numberFormatException) {
            return false;
        }
    }

    public boolean getBoolean(boolean bl) {
        if (this.isBooleanValue()) {
            return Boolean.parseBoolean(this.value);
        }
        return bl;
    }

    public boolean isBooleanValue() {
        return "true".equals(this.value.toLowerCase()) || "false".equals(this.value.toLowerCase());
    }

    public boolean isDoubleValue() {
        try {
            Double.parseDouble(this.value);
            return true;
        }
        catch (NumberFormatException numberFormatException) {
            return false;
        }
    }

    public double getDouble(double d) {
        try {
            return Double.parseDouble(this.value);
        }
        catch (NumberFormatException numberFormatException) {
            return d;
        }
    }

    public String[] getStringList() {
        return this.values;
    }

    public int[] getIntList() {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        String[] objectArray = this.values;
        int n = objectArray.length;
        for (int i = 0; i < n; ++i) {
            String string = objectArray[i];
            try {
                arrayList.add(Integer.parseInt(string));
                continue;
            }
            catch (NumberFormatException numberFormatException) {
                // empty catch block
            }
        }
        int[] nArray = new int[arrayList.size()];
        for (n = 0; n < arrayList.size(); ++n) {
            nArray[n] = (Integer)arrayList.get(n);
        }
        return nArray;
    }

    public boolean isIntList() {
        for (String string : this.values) {
            try {
                Integer.parseInt(string);
            }
            catch (NumberFormatException numberFormatException) {
                return false;
            }
        }
        return true;
    }

    public boolean[] getBooleanList() {
        ArrayList<Boolean> arrayList = new ArrayList<Boolean>();
        String[] objectArray = this.values;
        int n = objectArray.length;
        for (int i = 0; i < n; ++i) {
            String string = objectArray[i];
            try {
                arrayList.add(Boolean.parseBoolean(string));
                continue;
            }
            catch (NumberFormatException numberFormatException) {
                // empty catch block
            }
        }
        boolean[] blArray = new boolean[arrayList.size()];
        for (n = 0; n < arrayList.size(); ++n) {
            blArray[n] = (Boolean)arrayList.get(n);
        }
        return blArray;
    }

    public boolean isBooleanList() {
        for (String string : this.values) {
            if ("true".equalsIgnoreCase(string) || "false".equalsIgnoreCase(string)) continue;
            return false;
        }
        return true;
    }

    public double[] getDoubleList() {
        ArrayList<Double> arrayList = new ArrayList<Double>();
        String[] objectArray = this.values;
        int n = objectArray.length;
        for (int i = 0; i < n; ++i) {
            String string = objectArray[i];
            try {
                arrayList.add(Double.parseDouble(string));
                continue;
            }
            catch (NumberFormatException numberFormatException) {
                // empty catch block
            }
        }
        double[] dArray = new double[arrayList.size()];
        for (n = 0; n < arrayList.size(); ++n) {
            dArray[n] = (Double)arrayList.get(n);
        }
        return dArray;
    }

    public boolean isDoubleList() {
        for (String string : this.values) {
            try {
                Double.parseDouble(string);
            }
            catch (NumberFormatException numberFormatException) {
                return false;
            }
        }
        return true;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String string) {
        this.name = string;
    }

    public boolean wasRead() {
        return this.wasRead;
    }

    public Type getType() {
        return this.type;
    }

    public boolean isList() {
        return this.isList;
    }

    public boolean hasChanged() {
        return this.changed;
    }

    void resetChangedState() {
        this.changed = false;
    }

    public void set(String string) {
        this.value = string;
        this.changed = true;
    }

    public void set(String[] stringArray) {
        this.values = stringArray;
        this.changed = true;
    }

    public void set(int n) {
        this.set(Integer.toString(n));
    }

    public void set(boolean bl) {
        this.set(Boolean.toString(bl));
    }

    public void set(double d) {
        this.set(Double.toString(d));
    }

    public static enum Type {
        STRING,
        INTEGER,
        BOOLEAN,
        DOUBLE;

        private static Type[] values;

        public static Type tryParse(char c) {
            for (int i = 0; i < values.length; ++i) {
                if (values[i].getID() != c) continue;
                return values[i];
            }
            return STRING;
        }

        public char getID() {
            return this.name().charAt(0);
        }

        static {
            values = new Type[]{STRING, INTEGER, BOOLEAN, DOUBLE};
        }
    }
}

