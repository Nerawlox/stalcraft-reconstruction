/*
 * Decompiled with CFR 0.152.
 */
package net.smart.properties;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import net.minecraft.util.ResourceLocation;
import net.smart.properties.Property;
import net.smart.properties.Value;
import net.smart.utilities.Reflect;

public class Properties
extends java.util.Properties {
    private static final long serialVersionUID = 5319578641402091067L;
    private static int i = 0;
    public static final int Boolean = i++;
    public static final int Unmodified = i++;
    public static final int Modified = i++;
    public static final int Float = i++;
    public static final int Positive = i++;
    public static final int Negative = i++;
    public static final int PositiveFactor = i++;
    public static final int NegativeFactor = i++;
    public static final int IncreasingFactor = i++;
    public static final int DecreasingFactor = i++;
    public static final int Integer = i++;
    public static final int String = i++;
    public static final int Strings = i++;
    public static final int Operator = i++;
    public static final int Constant = i++;
    public static final int Key = i++;
    public static final int StringMap = i++;
    public static final int IntegerMap = i++;
    public final String version;
    private static final Float zero = java.lang.Float.valueOf(0.0f);
    private static final Float one = java.lang.Float.valueOf(1.0f);

    public Properties() {
        this.version = null;
    }

    public Properties(ResourceLocation resourceLocation) {
        this.load(resourceLocation);
        this.version = this.getProperty("move.options.version");
    }

    public Properties(String string, ResourceLocation resourceLocation) {
        this.load(resourceLocation);
        this.version = string;
    }

    protected List getProperties() {
        return this.getProperties(null);
    }

    protected List getProperties(Class clazz) {
        ArrayList arrayList = new ArrayList();
        return clazz != null ? this.addProperties(arrayList, clazz, false) : this.addProperties(arrayList, this.getClass(), true);
    }

    private List addProperties(List list2, Class clazz, boolean bl) {
        if (bl && clazz.getSuperclass() != null) {
            this.addProperties(list2, clazz.getSuperclass(), bl);
        }
        Field[] fieldArray = clazz.getDeclaredFields();
        for (int i = 0; i < fieldArray.length; ++i) {
            fieldArray[i].setAccessible(true);
            Object object = Reflect.GetField(fieldArray[i], this);
            this.addProperties(list2, object);
        }
        return list2;
    }

    private void addProperties(List list2, Object object) {
        if (object instanceof Property) {
            list2.add((Property)object);
        } else if (object instanceof Collection) {
            Iterator iterator2 = ((Collection)object).iterator();
            while (iterator2.hasNext()) {
                this.addProperties(list2, iterator2.next());
            }
        }
    }

    public void write(Properties properties) {
        this.write(properties, null);
    }

    public void write(Properties properties, String string) {
        List list2 = this.getProperties();
        for (int i = 0; i < list2.size(); ++i) {
            Property property = (Property)list2.get(i);
            if (!property.isPersistent()) continue;
            properties.put(property.getCurrentKey(), string == null ? property.getValueString() : property.getKeyValueString(string));
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean load(ResourceLocation resourceLocation) {
        try (InputStream inputStream = uyvo._e(resourceLocation);){
            this.load(inputStream);
            boolean bl = true;
            return bl;
        }
        catch (Exception exception) {
            return false;
        }
    }

    public static int getBaseType(int n) {
        return n != Boolean && n != Unmodified && n != Modified ? (n != Float && n != Positive && n != Negative && n != PositiveFactor && n != NegativeFactor && n != IncreasingFactor && n != DecreasingFactor ? (n == Integer ? Integer : (n == Strings ? Strings : (n == StringMap ? StringMap : (n == IntegerMap ? IntegerMap : String)))) : Float) : Boolean;
    }

    public static String getBaseTypeName(int n) {
        return n == Boolean ? "boolean" : (n == Float ? "floating point" : (n == Integer ? "integer" : "string"));
    }

    public static Object getDefaultValue(int n) {
        return n == Boolean ? java.lang.Boolean.valueOf(false) : (n == Unmodified ? java.lang.Boolean.valueOf(true) : (n == Modified ? java.lang.Boolean.valueOf(false) : (n == Integer ? java.lang.Integer.valueOf(0) : (n == Float ? java.lang.Float.valueOf(0.0f) : (n == Positive ? java.lang.Float.valueOf(0.0f) : (n == Negative ? java.lang.Float.valueOf(0.0f) : (n == PositiveFactor ? java.lang.Float.valueOf(1.0f) : (n == NegativeFactor ? java.lang.Float.valueOf(1.0f) : (n == IncreasingFactor ? java.lang.Float.valueOf(1.0f) : (n == DecreasingFactor ? java.lang.Float.valueOf(1.0f) : (n == String ? "" : (n == Strings ? new String[]{} : (n == StringMap ? new HashMap() : (n == IntegerMap ? new HashMap() : null))))))))))))));
    }

    public static Object getMinimumValue(int n) {
        return n == Positive ? zero : (n == PositiveFactor ? zero : (n == IncreasingFactor ? one : (n == DecreasingFactor ? java.lang.Float.valueOf(0.0f) : null)));
    }

    public static Object getMaximumValue(int n) {
        return n == Negative ? zero : (n == NegativeFactor ? zero : (n == DecreasingFactor ? one : null));
    }

    public static Property Unmodified() {
        return Properties.Property(Unmodified);
    }

    public static Property Unmodified(String string, String ... stringArray) {
        return Properties.Unmodified().key(string, stringArray);
    }

    public static Property Modified() {
        return Properties.Property(Modified);
    }

    public static Property Modified(String string, String ... stringArray) {
        return Properties.Modified().key(string, stringArray);
    }

    public static Property Integer() {
        return Properties.Property(Integer);
    }

    public static Property Integer(String string, String ... stringArray) {
        return Properties.Integer().key(string, stringArray);
    }

    public static Property Float() {
        return Properties.Property(Float);
    }

    public static Property Float(String string, String ... stringArray) {
        return Properties.Float().key(string, stringArray);
    }

    public static Property Positive() {
        return Properties.Property(Positive);
    }

    public static Property Positive(String string, String ... stringArray) {
        return Properties.Positive().key(string, stringArray);
    }

    public static Property Negative() {
        return Properties.Property(Negative);
    }

    public static Property Negative(String string, String ... stringArray) {
        return Properties.Negative().key(string, stringArray);
    }

    public static Property PositiveFactor() {
        return Properties.Property(PositiveFactor);
    }

    public static Property PositiveFactor(String string, String ... stringArray) {
        return Properties.PositiveFactor().key(string, stringArray);
    }

    public static Property NegativeFactor() {
        return Properties.Property(NegativeFactor);
    }

    public static Property NegativeFactor(String string, String ... stringArray) {
        return Properties.NegativeFactor().key(string, stringArray);
    }

    public static Property IncreasingFactor() {
        return Properties.Property(IncreasingFactor);
    }

    public static Property IncreasingFactor(String string, String ... stringArray) {
        return Properties.IncreasingFactor().key(string, stringArray);
    }

    public static Property DecreasingFactor() {
        return Properties.Property(DecreasingFactor);
    }

    public static Property DecreasingFactor(String string, String ... stringArray) {
        return Properties.DecreasingFactor().key(string, stringArray);
    }

    public static Property String() {
        return Properties.Property(String);
    }

    public static Property String(String string, String ... stringArray) {
        return Properties.String().key(string, stringArray);
    }

    public static Property Strings() {
        return Properties.Property(Strings);
    }

    public static Property Strings(String string, String ... stringArray) {
        return Properties.Strings().key(string, stringArray);
    }

    public static Property StringMap() {
        return Properties.Property(StringMap);
    }

    public static Property StringMap(String string, String ... stringArray) {
        return Properties.StringMap().key(string, stringArray);
    }

    public static Property IntegerMap() {
        return Properties.Property(IntegerMap);
    }

    public static Property IntegerMap(String string, String ... stringArray) {
        return Properties.IntegerMap().key(string, stringArray);
    }

    private static Property Property(int n) {
        return new Property(n);
    }

    public Value Value(Boolean bl) {
        return new Value(Boolean).put(bl);
    }

    public Value Value(Float f) {
        return new Value(Float).put(f);
    }

    public Value Value(String string) {
        return new Value(String).put(string);
    }

    protected static String[] concat(String string, String[] stringArray) {
        return Properties.concat(new String[]{string}, stringArray);
    }

    protected static String[] concat(String[] stringArray, String[] stringArray2) {
        int n;
        String[] stringArray3 = new String[stringArray.length + stringArray2.length];
        for (n = 0; n < stringArray.length; ++n) {
            stringArray3[n] = stringArray[n];
        }
        while (n < stringArray3.length) {
            stringArray3[n] = stringArray2[n - stringArray.length];
            ++n;
        }
        return stringArray3;
    }
}

