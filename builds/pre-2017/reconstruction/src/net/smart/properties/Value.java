/*
 * Decompiled with CFR 0.152.
 */
package net.smart.properties;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import net.smart.properties.Properties;
import net.smart.utilities.Name;
import net.smart.utilities.Reflect;

public class Value {
    private int type;
    private Object value;
    private Dictionary keyValues;
    private List unparsableStrings;
    public static final String Null = "null";
    private static final List _allkeys = new LinkedList();
    public static final Class keyboard = Reflect.LoadClass(Value.class, new Name("org.lwjgl.input.Keyboard"), false);
    public static final Class mouse = Reflect.LoadClass(Value.class, new Name("org.lwjgl.input.Mouse"), false);
    public static final Method _getKeyName = keyboard != null ? Reflect.GetMethod(keyboard, new Name("getKeyName"), Integer.TYPE) : null;
    public static final Method _getKeyIndex = keyboard != null ? Reflect.GetMethod(keyboard, new Name("getKeyIndex"), String.class) : null;
    public static final Method _getButtonName = mouse != null ? Reflect.GetMethod(mouse, new Name("getButtonName"), Integer.TYPE) : null;
    public static final Method _getButtonIndex = mouse != null ? Reflect.GetMethod(mouse, new Name("getButtonIndex"), String.class) : null;

    public Value(int n) {
        this.type = n;
    }

    public Value(Object object) {
        this.value = object;
    }

    public Value(Value value) {
        this.type = value.type;
        this.value = value.value;
        if (value.keyValues != null) {
            this.keyValues = new Hashtable();
            Enumeration enumeration = value.keyValues.keys();
            while (enumeration.hasMoreElements()) {
                String string = (String)enumeration.nextElement();
                this.keyValues.put(string, value.keyValues.get(string));
            }
        }
    }

    public Value put(Object object) {
        return this.put(null, object);
    }

    public Object get(String string) {
        Object v;
        if (string != null && this.keyValues != null && (v = this.keyValues.get(string)) != null) {
            return v;
        }
        return this.value;
    }

    public Object getStored(String string) {
        return string != null && string != Null ? (this.keyValues != null ? this.keyValues.get(string) : null) : this.value;
    }

    private Object get(String string, Value value) {
        Object object = this.get(string);
        if (object == null && (object = this.value) == null) {
            object = value.value;
        }
        return object;
    }

    public Value put(String string, Object object) {
        if (string != null && string != Null && !string.isEmpty()) {
            if (this.keyValues == null) {
                this.keyValues = new Hashtable();
            }
            this.keyValues.put(string, object);
        } else {
            this.value = object;
        }
        return this;
    }

    public void withDependency(Value value, Value value2) {
        Iterator iterator2 = Value.GetAllKeys(this, value);
        while (iterator2.hasNext()) {
            String string = (String)iterator2.next();
            if (!this.get(string, value2).equals(true) || !value.get(string).equals(false)) continue;
            this.put(string, false);
        }
    }

    public void withMinimum(Value value, Value value2) {
        Iterator iterator2 = Value.GetAllKeys(this, value);
        while (iterator2.hasNext()) {
            String string = (String)iterator2.next();
            this.put(string, Float.valueOf(Math.max(((Float)this.get(string, value2)).floatValue(), ((Float)value.get(string)).floatValue())));
        }
    }

    public void withMaximum(Value value, Value value2) {
        Iterator iterator2 = Value.GetAllKeys(this, value);
        while (iterator2.hasNext()) {
            String string = (String)iterator2.next();
            this.put(string, Float.valueOf(Math.min(((Float)this.get(string, value2)).floatValue(), ((Float)value.get(string)).floatValue())));
        }
    }

    public Value is(Value value) {
        Value value2 = new Value(Properties.Boolean);
        Iterator iterator2 = Value.GetAllKeys(this, value);
        while (iterator2.hasNext()) {
            String string = (String)iterator2.next();
            Object object = this.get(string);
            Object object2 = value.get(string);
            value2.put(string, object == null && object2 == null || object != null && object2 != null && object.equals(object2));
        }
        return value2;
    }

    public Value and(Value value) {
        Value value2 = new Value(Properties.Boolean);
        Iterator iterator2 = Value.GetAllKeys(this, value);
        while (iterator2.hasNext()) {
            String string;
            value2.put(string, (Boolean)this.get(string = (String)iterator2.next()) != false && (Boolean)value.get(string) != false);
        }
        return value2;
    }

    public Value or(Value value) {
        Value value2 = new Value(Properties.Boolean);
        Iterator iterator2 = Value.GetAllKeys(this, value);
        while (iterator2.hasNext()) {
            String string;
            value2.put(string, (Boolean)this.get(string = (String)iterator2.next()) != false || (Boolean)value.get(string) != false);
        }
        return value2;
    }

    public Value not() {
        Value value = new Value(Properties.Boolean);
        Iterator iterator2 = Value.GetAllKeys(this);
        while (iterator2.hasNext()) {
            String string;
            value.put(string, (Boolean)this.get(string = (String)iterator2.next()) == false);
        }
        return value;
    }

    public Value plus(Value value) {
        Value value2 = new Value(Properties.Float);
        Iterator iterator2 = Value.GetAllKeys(this, value);
        while (iterator2.hasNext()) {
            String string = (String)iterator2.next();
            value2.put(string, Float.valueOf(((Float)this.get(string)).floatValue() + ((Float)value.get(string)).floatValue()));
        }
        return value2;
    }

    public Value eitherOr(Value value, Value value2) {
        Value value3 = new Value(Properties.getBaseType(value.type));
        Iterator iterator2 = Value.GetAllKeys(this, value, value2);
        while (iterator2.hasNext()) {
            String string;
            value3.put(string, (Boolean)this.get(string = (String)iterator2.next()) != false ? value.get(string) : value2.get(string));
        }
        return value3;
    }

    public Value maximum(Value value) {
        Value value2 = new Value(Properties.Float);
        Iterator iterator2 = Value.GetAllKeys(this, value);
        while (iterator2.hasNext()) {
            String string = (String)iterator2.next();
            value2.put(string, Float.valueOf(Math.max(((Float)this.get(string)).floatValue(), ((Float)value.get(string)).floatValue())));
        }
        return value2;
    }

    public Value minimum(Value value) {
        Value value2 = new Value(Properties.Float);
        Iterator iterator2 = Value.GetAllKeys(this, value);
        while (iterator2.hasNext()) {
            String string = (String)iterator2.next();
            value2.put(string, Float.valueOf(Math.min(((Float)this.get(string)).floatValue(), ((Float)value.get(string)).floatValue())));
        }
        return value2;
    }

    public Value toKeyName() {
        Value value = new Value(Properties.String);
        Iterator iterator2 = Value.GetAllKeys(this);
        while (iterator2.hasNext()) {
            String string = (String)iterator2.next();
            value.put(string, Value.toKeyName((Integer)this.get(string)));
        }
        return value;
    }

    public Value toKeyCode() {
        Value value = new Value(Properties.Integer);
        Iterator iterator2 = Value.GetAllKeys(this);
        while (iterator2.hasNext()) {
            String string = (String)iterator2.next();
            value.put(string, Value.toKeyCode((String)this.get(string)));
        }
        return value;
    }

    public Value toBlockConfig() {
        Value value = new Value(Properties.Strings);
        Iterator iterator2 = Value.GetAllKeys(this);
        while (iterator2.hasNext()) {
            String string = (String)iterator2.next();
            value.put(string, Value.toBlockConfig((String[])this.get(string)));
        }
        return value;
    }

    public Value clone() {
        return new Value(this);
    }

    public static Iterator GetAllKeys(Value ... valueArray) {
        return Value.GetAllKeys((String[])null, valueArray);
    }

    public static Iterator GetAllKeys(String[] stringArray, Value ... valueArray) {
        Object object;
        int n;
        _allkeys.clear();
        for (n = 0; n < valueArray.length; ++n) {
            Value value = valueArray[n];
            if (value.keyValues == null) continue;
            object = value.keyValues.keys();
            while (object.hasMoreElements()) {
                _allkeys.add(object.nextElement());
            }
        }
        Collections.sort(_allkeys);
        _allkeys.add(0, Null);
        int n2 = 1;
        for (n = 0; stringArray != null && n < stringArray.length; ++n) {
            object = stringArray[n];
            if (object == null || object == Null || !_allkeys.remove(object)) continue;
            _allkeys.add(n2++, object);
        }
        return _allkeys.iterator();
    }

    public boolean equals(Object object) {
        if (!(object instanceof Value)) {
            return false;
        }
        Value value = (Value)object;
        if (this.value == null != (value.value == null)) {
            return false;
        }
        if (this.value != null && !this.valuesEqual(this.value, value.value)) {
            return false;
        }
        if ((this.keyValues == null ? 0 : this.keyValues.size()) != (value.keyValues == null ? 0 : value.keyValues.size())) {
            return false;
        }
        if (this.keyValues != null && this.keyValues.size() != 0) {
            Enumeration enumeration = this.keyValues.keys();
            while (enumeration.hasMoreElements()) {
                String string = (String)enumeration.nextElement();
                Object v = value.keyValues.get(string);
                if (v == null) {
                    return false;
                }
                Object v2 = this.keyValues.get(string);
                if (this.valuesEqual(v2, v)) continue;
                return false;
            }
        }
        return true;
    }

    private boolean valuesEqual(Object object, Object object2) {
        if (!(object instanceof Object[])) {
            return object.equals(object2);
        }
        Object[] objectArray = (Object[])object;
        Object[] objectArray2 = (Object[])object2;
        if (objectArray.length != objectArray2.length) {
            return false;
        }
        for (int i = 0; i < objectArray.length; ++i) {
            if (objectArray[i].equals(objectArray2[i])) continue;
            return false;
        }
        return true;
    }

    public Value load(String string, boolean bl) {
        if (string != null && !bl) {
            String[] stringArray = string.split(";");
            for (int i = 0; i < stringArray.length; ++i) {
                String string2 = stringArray[i];
                int n = string2.indexOf(58);
                String string3 = null;
                String string4 = null;
                if (n > 0) {
                    string3 = string2.substring(0, n);
                    string4 = string2.substring(n + 1);
                } else {
                    string4 = string2;
                }
                Object object = this.parsePropertyElement(string4);
                if (object != null) {
                    this.put(string3, object);
                    continue;
                }
                if (this.unparsableStrings == null) {
                    this.unparsableStrings = new ArrayList();
                }
                this.unparsableStrings.add(string4);
            }
            return this;
        }
        this.value = this.parsePropertyElement(string);
        return this;
    }

    public Iterator getUnparsableStrings() {
        return this.unparsableStrings != null ? this.unparsableStrings.iterator() : null;
    }

    public void print(PrintWriter printWriter, String[] stringArray) {
        boolean bl = true;
        Iterator iterator2 = Value.GetAllKeys(stringArray, this);
        while (iterator2.hasNext()) {
            String string = (String)iterator2.next();
            if (string == Null && this.value == null) continue;
            if (!bl) {
                printWriter.print(";");
            } else {
                bl = false;
            }
            if (string != Null) {
                printWriter.print(string);
                printWriter.print(":");
            }
            this.printDisplayString(printWriter, this.get(string));
        }
    }

    public String toString() {
        StringWriter stringWriter = new StringWriter();
        this.print(new PrintWriter(stringWriter), null);
        return stringWriter.toString();
    }

    public String createDisplayString(Object object) {
        if (!(object instanceof String[]) && !(object instanceof Map)) {
            return this.getDisplayString(object);
        }
        StringWriter stringWriter = new StringWriter();
        this.printDisplayString(new PrintWriter(stringWriter), object);
        return stringWriter.toString();
    }

    private void printDisplayString(PrintWriter printWriter, Object object) {
        if (object instanceof String[]) {
            boolean bl = true;
            String[] stringArray = (String[])object;
            for (int i = 0; i < stringArray.length; ++i) {
                if (bl) {
                    bl = false;
                } else {
                    printWriter.print(",");
                }
                printWriter.print(this.getDisplayString(stringArray[i]));
            }
        } else if (object instanceof Map) {
            boolean bl = true;
            Map map = (Map)object;
            ArrayList<String> arrayList = new ArrayList<String>(map.size());
            for (Object k : map.keySet()) {
                arrayList.add((String)k);
            }
            Collections.sort(arrayList);
            for (int i = 0; i < arrayList.size(); ++i) {
                if (bl) {
                    bl = false;
                } else {
                    printWriter.print(",");
                }
                String string = (String)arrayList.get(i);
                printWriter.print(this.getDisplayString(string));
                printWriter.print(",");
                printWriter.print(this.getDisplayString(map.get(string)));
            }
        } else {
            printWriter.print(this.getDisplayString(object));
        }
    }

    private String getDisplayString(Object object) {
        String string = object.toString();
        if (string.endsWith(".0")) {
            string = string.substring(0, string.length() - 2);
        }
        return string;
    }

    private Object parsePropertyElement(String string) {
        int n = Properties.getBaseType(this.type);
        return n == Properties.Boolean ? Value.tryParseBoolean(string) : (n == Properties.Float ? Value.tryParseFloat(string) : (n == Properties.Integer ? Value.tryParseInteger(string) : (n == Properties.Strings ? Value.tryParseStrings(string) : (n == Properties.StringMap ? this.tryParseStringMap(string) : (n == Properties.IntegerMap ? this.tryParseIntegerMap(string) : (n == Properties.String ? Value.tryParseString(string) : null))))));
    }

    public static Boolean tryParseBoolean(String string) {
        try {
            if (string != null) {
                return string.equals("true") ? true : (string.equals("false") ? Boolean.valueOf(false) : null);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return null;
    }

    public static Float tryParseFloat(String string) {
        try {
            if (string != null) {
                return Float.valueOf(Float.parseFloat(string));
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return null;
    }

    public static Integer tryParseInteger(String string) {
        try {
            if (string != null) {
                return Integer.parseInt(string);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return null;
    }

    public static String tryParseString(String string) {
        return string == null ? null : string;
    }

    public static String[] tryParseStrings(String string) {
        return string == null ? null : (string.isEmpty() ? new String[]{} : string.split(","));
    }

    public Map tryParseStringMap(String string) {
        String[] stringArray = string.split(",");
        HashMap<String, String> hashMap = new HashMap<String, String>();
        for (int i = 0; i < stringArray.length; ++i) {
            String string2 = stringArray[i++];
            if (i >= stringArray.length) continue;
            hashMap.put(string2, stringArray[i]);
        }
        return hashMap;
    }

    public Map tryParseIntegerMap(String string) {
        String[] stringArray = string.split(",");
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        for (int i = 0; i < stringArray.length; ++i) {
            String string2 = stringArray[i++];
            if (i >= stringArray.length) continue;
            hashMap.put(string2, Integer.parseInt(stringArray[i]));
        }
        return hashMap;
    }

    public Value e(Object object) {
        return this.put("e", object);
    }

    public Value m(Object object) {
        return this.put("m", object);
    }

    public Value h(Object object) {
        return this.put("h", object);
    }

    public Value c(Object object) {
        return this.put("c", object);
    }

    public Value a(Object object) {
        return this.put("a", object);
    }

    public static String toKeyName(Integer n) {
        return n == null ? null : (n >= 0 ? (String)Reflect.Invoke(_getKeyName, null, n) : (String)Reflect.Invoke(_getButtonName, null, n + 100));
    }

    private static Integer toKeyCode(String string) {
        if (string == null) {
            return null;
        }
        int n = (Integer)Reflect.Invoke(_getKeyIndex, null, string = string.toUpperCase());
        if (n > 0) {
            return n;
        }
        n = (Integer)Reflect.Invoke(_getButtonIndex, null, string);
        return n >= 0 ? Integer.valueOf(n - 100) : null;
    }

    private static Dictionary toBlockConfig(String[] stringArray) {
        if (stringArray == null) {
            return null;
        }
        Hashtable hashtable = new Hashtable();
        for (int i = 0; i < stringArray.length; ++i) {
            String[] stringArray2 = stringArray[i].split("/");
            if (stringArray2.length <= 0) continue;
            HashSet<Integer> hashSet = new HashSet<Integer>();
            String string = stringArray2[0];
            hashtable.put(string, hashSet);
            if (string.matches("[0-9]+")) {
                hashtable.put(Integer.parseInt(string), hashSet);
            }
            for (int j = 1; j < stringArray2.length; ++j) {
                String string2 = stringArray2[j];
                if (!string2.matches("[0-9]+")) continue;
                hashSet.add(Integer.parseInt(string2));
            }
        }
        return hashtable;
    }
}

