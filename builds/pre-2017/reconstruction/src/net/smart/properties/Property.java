/*
 * Decompiled with CFR 0.152.
 */
package net.smart.properties;

import java.io.PrintWriter;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import net.smart.properties.Properties;
import net.smart.properties.Value;

public class Property {
    private static final int printWidth = 69;
    private String comment;
    private String[] header;
    private int gap;
    private boolean explicitlyModified;
    private boolean implicitlyModified;
    private String aquiredString;
    private boolean singular;
    private final int type;
    private String currentVersion;
    private Map versionSources;
    private Map versionDefaults;
    private static int i = 0;
    private static final int Is = i++;
    private static final int And = i++;
    private static final int Or = i++;
    private static final int Not = i++;
    private static final int Plus = i++;
    private static final int EitherOr = i++;
    private static final int Maximum = i++;
    private static final int Minimum = i++;
    private static final int ToKeyName = i++;
    private static final int ToKeyCode = i++;
    private static final int ToBlockConfig = i++;
    public Object value;
    private Value systemValue;
    private Value aquiredValue;
    private Object minValue;
    private Object maxValue;
    private Object local;
    private Object left;
    private int operator;
    private Object right;
    private List depends = null;
    private static final String Current = "";
    private static final String[] CurrentArray = new String[]{""};

    public Property(int n) {
        this.type = n;
    }

    private Property(String string) {
        this(Properties.Key);
        this.set(new Value(string));
    }

    private Property(Object object, int n, Object object2) {
        this(Properties.Operator);
        this.left = object;
        this.operator = n;
        this.right = object2;
    }

    private Property(Object object, int n, Object object2, Object object3) {
        this(Properties.Operator);
        this.local = object;
        this.operator = n;
        this.left = object2;
        this.right = object3;
    }

    public void update(String string) {
        this.value = this.getKeyValue(string);
    }

    public void setValue(Object object) {
        this.value = object;
        this.systemValue = new Value(object);
        this.aquiredValue = new Value(object);
        this.implicitlyModified = false;
        this.explicitlyModified = false;
    }

    public Property singular() {
        this.singular = true;
        return this;
    }

    public Property is(Object object) {
        return new Property(this, Is, object);
    }

    public Property and(Object object) {
        return new Property(this, And, object);
    }

    public Property or(Object object) {
        return new Property(this, Or, object);
    }

    public Property andNot(Property property) {
        return this.and(property.not());
    }

    public Property not() {
        return new Property(this, Not, null);
    }

    public Property plus(Object object) {
        return new Property(this, Plus, object);
    }

    public Property eitherOr(Object object, Object object2) {
        return new Property(this, EitherOr, object, object2);
    }

    public Property maximum(Object object) {
        return new Property(this, Maximum, object);
    }

    public Property minimum(Object object) {
        return new Property(this, Minimum, object);
    }

    public Property toKeyName() {
        return new Property(this, ToKeyName, null);
    }

    public Property toKeyCode(Integer n) {
        return new Property(this, ToKeyCode, null).defaults(n, new String[0]);
    }

    public Property toBlockConfig() {
        return new Property(this, ToBlockConfig, null);
    }

    public Property depends(Property ... propertyArray) {
        if (this.depends == null) {
            this.depends = new LinkedList();
        }
        for (int i = 0; i < propertyArray.length; ++i) {
            this.depends.add(propertyArray[i]);
        }
        return this;
    }

    public Property values(Object object, Object object2, Object object3) {
        return this.defaults(object, new String[0]).range(object2, object3);
    }

    public Property up(Object object, Object object2) {
        return this.defaults(object, new String[0]).min(object2);
    }

    public Property down(Object object, Object object2) {
        return this.defaults(object, new String[0]).max(object2);
    }

    public Property range(Object object, Object object2) {
        return this.min(object).max(object2);
    }

    public Property defaults(Object object, String ... stringArray) {
        this.versionDefaults = this.addVersioned(this.versionDefaults, object, stringArray);
        return this;
    }

    public Property min(Object object) {
        this.minValue = object;
        return this;
    }

    public Property max(Object object) {
        this.maxValue = object;
        return this;
    }

    public Property key(String string, String ... stringArray) {
        if (this.currentVersion == null) {
            this.currentVersion = stringArray != null && stringArray.length > 0 ? stringArray[0] : Current;
        }
        return this.source(new Property(string), stringArray);
    }

    public Property source(Object object, String ... stringArray) {
        this.versionSources = this.addVersioned(this.versionSources, object, stringArray);
        return this;
    }

    public Property comment(String string) {
        this.comment = string;
        return this;
    }

    public Property section(String ... stringArray) {
        this.gap = 1;
        this.header = stringArray;
        return this;
    }

    public Property chapter(String ... stringArray) {
        this.gap = 2;
        this.header = stringArray;
        return this;
    }

    public Property book(String ... stringArray) {
        this.gap = 3;
        this.header = stringArray;
        return this;
    }

    public void reset() {
        this.explicitlyModified = false;
        this.implicitlyModified = false;
        this.value = null;
        this.systemValue = null;
        this.aquiredValue = null;
        this.reset(this.minValue);
        this.reset(this.maxValue);
        this.reset(this.left);
        this.reset(this.right);
        if (this.depends != null) {
            for (int i = 0; i < this.depends.size(); ++i) {
                this.reset(this.depends.get(i));
            }
        }
    }

    private void reset(Object object) {
        if (object instanceof Property) {
            ((Property)object).reset();
        }
    }

    public boolean load(Properties ... propertiesArray) {
        if (this.systemValue != null) {
            return true;
        }
        if (this.type == Properties.Constant) {
            return true;
        }
        if (this.type == Properties.Operator) {
            if (this.operator == EitherOr && (this.getValue(this.left) == null || this.getValue(this.right) == null || this.getValue(this.local) == null)) {
                return false;
            }
            if (!(this.operator != Is && this.operator != And && this.operator != Or && this.operator != Plus && this.operator != Maximum && this.operator != Minimum || this.getValue(this.left) != null && this.getValue(this.right) != null)) {
                return false;
            }
            if ((this.operator == Not || this.operator == ToKeyName || this.operator == ToKeyCode || this.operator == ToBlockConfig) && this.getValue(this.left) == null) {
                return false;
            }
            Value value = null;
            if (this.operator == Is) {
                value = this.getValue(this.left).is(this.getValue(this.right));
            } else if (this.operator == And) {
                value = this.getValue(this.left).and(this.getValue(this.right));
            } else if (this.operator == Or) {
                value = this.getValue(this.left).or(this.getValue(this.right));
            } else if (this.operator == Not) {
                value = this.getValue(this.left).not();
            } else if (this.operator == Plus) {
                value = this.getValue(this.left).plus(this.getValue(this.right));
            } else if (this.operator == EitherOr) {
                value = this.getValue(this.local).eitherOr(this.getValue(this.left), this.getValue(this.right));
            } else if (this.operator == Maximum) {
                value = this.getValue(this.left).maximum(this.getValue(this.right));
            } else if (this.operator == Minimum) {
                value = this.getValue(this.left).minimum(this.getValue(this.right));
            } else if (this.operator == ToKeyName) {
                value = this.getValue(this.left).toKeyName();
            } else if (this.operator == ToKeyCode) {
                value = this.getValue(this.left).toKeyCode();
            } else if (this.operator == ToBlockConfig) {
                value = this.getValue(this.left).toBlockConfig();
            }
            if (value == null) {
                throw new RuntimeException("Unknown operator '" + this.operator + "' found");
            }
            return this.set(this.getValue(value));
        }
        if (propertiesArray != null && this.versionSources != null) {
            if (this.depends != null) {
                for (int i = 0; i < this.depends.size(); ++i) {
                    if (this.getValue(this.depends.get(i)) != null) continue;
                    return false;
                }
            }
            Object object = this.getMinimumValue();
            Value value = this.getValue(object);
            if (object != null && value == null) {
                return false;
            }
            Object object2 = this.getMaximumValue();
            Value value2 = this.getValue(object2);
            if (object2 != null && value2 == null) {
                return false;
            }
            Value value3 = this.getValue(this.getDefaultValue());
            for (int i = 0; i < propertiesArray.length; ++i) {
                Properties properties = propertiesArray[i];
                Object object3 = this.getVersionSource(properties.version);
                if (object3 == null) continue;
                String string = this.getKey(object3);
                Value value4 = this.aquiredValue = string != null ? this.getPropertyValue(properties, string) : this.getValue(object3);
                if (this.aquiredValue != null) {
                    Value value5 = this.aquiredValue.clone();
                    if (this.depends != null) {
                        for (int j = 0; j < this.depends.size(); ++j) {
                            value5.withDependency(this.getValue(this.depends.get(j)), value3);
                        }
                    }
                    if (object != null) {
                        value5.withMinimum(value, value3);
                    }
                    if (object2 != null) {
                        value5.withMaximum(value2, value3);
                    }
                    return this.set(value5);
                }
                if (string != null) continue;
                return false;
            }
            return this.set(value3);
        }
        return false;
    }

    private boolean set(Value value) {
        this.systemValue = value;
        this.update(null);
        return true;
    }

    private Map addVersioned(Map hashtable, Object object, String ... stringArray) {
        if (hashtable == null) {
            hashtable = new Hashtable<String, Object>(1);
        }
        if (stringArray == null || stringArray.length == 0) {
            stringArray = CurrentArray;
        }
        for (int i = 0; i < stringArray.length; ++i) {
            hashtable.put(stringArray[i], object);
        }
        return hashtable;
    }

    public Object getKeyValue(String string) {
        Object object = this.systemValue.get(string);
        if (object == null) {
            object = this.getValue(this.getDefaultValue()).get(null);
        }
        if (object == null) {
            object = Properties.getDefaultValue(this.type);
        }
        return object;
    }

    private Value getValue(Object object) {
        if (object instanceof Property) {
            Property property = (Property)object;
            property.load(null);
            return property.systemValue;
        }
        return object instanceof Value ? (Value)object : new Value(object);
    }

    private Object getDefaultValue(String string) {
        Object object = null;
        if (this.versionDefaults != null) {
            if (string != null) {
                object = this.versionDefaults.get(string);
            }
            if (object == null) {
                object = this.versionDefaults.get(Current);
            }
        }
        if (object == null) {
            object = Properties.getDefaultValue(this.type);
        }
        return object;
    }

    private Object getDefaultValue() {
        return this.getDefaultValue(Current);
    }

    private Object getMinimumValue() {
        return this.minValue != null ? this.minValue : Properties.getMinimumValue(this.type);
    }

    private Object getMaximumValue() {
        return this.maxValue != null ? this.maxValue : Properties.getMaximumValue(this.type);
    }

    private Object getVersionSource(String string) {
        if (this.versionSources == null) {
            return null;
        }
        Object var2_2 = null;
        if (string != null) {
            var2_2 = this.versionSources.get(string);
        }
        if (var2_2 == null) {
            var2_2 = this.versionSources.get(Current);
        }
        return var2_2;
    }

    private Value getPropertyValue(Properties properties, String string) {
        String string2 = properties.getProperty(string);
        if (string2 != null) {
            this.aquiredString = string2;
        }
        String string3 = string2;
        if (string2 != null) {
            string3 = string2.trim();
            this.explicitlyModified = string3.endsWith("!");
            if (this.explicitlyModified) {
                string3 = string3.substring(0, string3.length() - 1);
            }
            string3 = string3.trim();
        }
        Value value = this.parsePropertyValue(string3);
        this.implicitlyModified = string3 != null && (value == null || !value.equals(this.getValue(this.getDefaultValue(properties.version))));
        return !this.explicitlyModified && !this.implicitlyModified ? this.getValue(this.getDefaultValue()) : value;
    }

    private Value parsePropertyValue(String string) {
        return string != null ? new Value(this.type).load(string, this.singular) : null;
    }

    public boolean print(PrintWriter printWriter, String[] stringArray, String string, boolean bl) {
        if (this.isPersistent() && this.systemValue != null) {
            Object object;
            int n;
            if (this.getVersionSource(string) == null) {
                return false;
            }
            int n2 = this.gap + (this.comment == null ? -1 : 1);
            for (n = 0; n < n2; n += 1) {
                printWriter.println();
            }
            if (this.header != null && this.header.length > 0) {
                this.printHeader(printWriter);
            }
            if (this.comment != null && bl) {
                printWriter.print("# ");
                printWriter.print(this.comment);
                printWriter.println();
            }
            if (this.aquiredString == null) {
                this.printValue(printWriter, stringArray, false);
                return true;
            }
            n = 0;
            Object object2 = this.aquiredValue.getUnparsableStrings();
            while (object2 != null && object2.hasNext()) {
                object = (String)object2.next();
                this.printErrorPrefix(printWriter);
                printWriter.print("Could not interpret string \"");
                printWriter.print((String)object);
                printWriter.print("\" as ");
                printWriter.print(Properties.getBaseTypeName(Properties.getBaseType(this.type)));
                printWriter.print(" value, used ");
                printWriter.print(!this.aquiredString.isEmpty() && this.aquiredValue.get(null) != null ? "local" : "system");
                printWriter.print(" default");
                this.printValuePostfix(printWriter, null);
                this.printErrorPostfix(printWriter);
                n = 1;
            }
            object2 = this.getMinimumValue();
            object = this.getValue(object2);
            Object object3 = this.getMaximumValue();
            Value value = this.getValue(object3);
            Iterator iterator2 = Value.GetAllKeys(this.systemValue);
            while (iterator2.hasNext()) {
                String string2 = (String)iterator2.next();
                Object object4 = this.aquiredValue.getStored(string2);
                Object object5 = this.aquiredValue.get(string2);
                Object object6 = this.systemValue.getStored(string2);
                if (object4 != null ? object4.equals(object6) : object5 == null || object5.equals(object6)) continue;
                if (Properties.getBaseType(this.type) == Properties.Boolean && this.depends != null && !this.depends.isEmpty()) {
                    String string3 = null;
                    for (int i = 0; i < this.depends.size(); ++i) {
                        Property property = (Property)this.depends.get(i);
                        String string4 = property.getCurrentKey();
                        if (string4 == null || ((Boolean)property.getKeyValue(string2)).booleanValue()) continue;
                        string3 = string4;
                        break;
                    }
                    this.printWarnPrefix(printWriter);
                    this.printValuePrefix(printWriter, string2);
                    printWriter.print("is ignored because ");
                    if (string3 != null) {
                        printWriter.print("the ");
                        if (string2 == "null") {
                            printWriter.print("default");
                        } else {
                            printWriter.print("\"" + string2 + "\"");
                        }
                        printWriter.print(" value of property \"");
                        printWriter.print(string3);
                        printWriter.print("\" is \"false\"");
                    } else {
                        printWriter.print("one of the restricting expressions evaluated to \"false\"");
                    }
                    this.printWarnPostfix(printWriter);
                    n = 1;
                    continue;
                }
                this.printErrorPrefix(printWriter);
                this.printValuePrefix(printWriter, string2);
                printWriter.print("was out of range, used ");
                if (object != null && object6.equals(((Value)object).get(string2))) {
                    printWriter.print("minimum");
                } else if (value != null && object6.equals(value.get(string2))) {
                    printWriter.print("maximum");
                } else {
                    printWriter.print("in-range");
                }
                this.printValuePostfix(printWriter, string2);
                this.printErrorPostfix(printWriter);
                n = 1;
            }
            this.printValue(printWriter, stringArray, n != 0);
            return true;
        }
        return false;
    }

    private void printValue(PrintWriter printWriter, String[] stringArray, boolean bl) {
        printWriter.print(this.getCurrentKey());
        printWriter.print(":");
        if (this.aquiredString != null && (bl || this.explicitlyModified)) {
            printWriter.print(this.aquiredString);
        } else if (this.implicitlyModified && this.systemValue.equals(this.getValue(this.getDefaultValue()))) {
            printWriter.print(this.aquiredString);
            printWriter.print("!");
        } else {
            this.systemValue.print(printWriter, stringArray);
        }
    }

    private void printHeader(PrintWriter printWriter) {
        String string;
        String string2 = this.header[0];
        String string3 = string = this.header.length > 1 ? this.header[1] : null;
        int n = this.gap == 3 ? 61 : (this.gap == 2 ? 45 : 32);
        this.printSeparation(printWriter, (char)n, 69);
        printWriter.print("# ");
        printWriter.println(string2);
        if (string != null) {
            this.printSeparation(printWriter, '-', string2.length());
            int n2 = 67;
            while (true) {
                int n3;
                printWriter.print("# ");
                if (string.length() <= n2) {
                    printWriter.println(string);
                    break;
                }
                for (n3 = n2; n3 > 0 && string.charAt(n3) != ' '; --n3) {
                }
                printWriter.println(string.substring(0, n3));
                string = string.substring(n3 + 1);
            }
        }
        this.printSeparation(printWriter, (char)n, 69);
        printWriter.println();
    }

    private void printSeparation(PrintWriter printWriter, char c, int n) {
        printWriter.print("# ");
        for (int i = 0; i < n; ++i) {
            printWriter.print(c);
        }
        printWriter.println();
    }

    private void printValuePrefix(PrintWriter printWriter, String string) {
        printWriter.print("Interpreted ");
        if (string != "null") {
            printWriter.print("\"");
            printWriter.print(string);
            printWriter.print("\" ");
        }
        printWriter.print("value \"");
        printWriter.print(this.aquiredValue.get(string));
        printWriter.print("\" ");
    }

    private void printValuePostfix(PrintWriter printWriter, String string) {
        printWriter.print(" value \"");
        printWriter.print(this.aquiredString != null && !this.aquiredString.isEmpty() ? this.getKeyValue(string) : this.getValue(this.getDefaultValue()));
        printWriter.print("\" instead");
    }

    private void printErrorPrefix(PrintWriter printWriter) {
        this.printErrorPrefix(printWriter, false);
    }

    private void printWarnPrefix(PrintWriter printWriter) {
        this.printErrorPrefix(printWriter, true);
    }

    private void printErrorPrefix(PrintWriter printWriter, boolean bl) {
        printWriter.print("#");
        if (!bl) {
            printWriter.print("!!");
        }
        printWriter.print("! ");
    }

    private void printErrorPostfix(PrintWriter printWriter) {
        this.printErrorPostfix(printWriter, false);
    }

    private void printWarnPostfix(PrintWriter printWriter) {
        this.printErrorPostfix(printWriter, true);
    }

    private void printErrorPostfix(PrintWriter printWriter, boolean bl) {
        printWriter.print(" !");
        if (!bl) {
            printWriter.print("!!");
        }
        printWriter.println("#");
    }

    public boolean isPersistent() {
        return this.versionSources != null && this.versionSources.size() > 0;
    }

    public String getCurrentKey() {
        return this.isPersistent() ? this.getKey(this.getVersionSource(this.currentVersion)) : null;
    }

    private String getKey(Object object) {
        if (object instanceof Property) {
            Property property = (Property)object;
            if (property.type == Properties.Key) {
                return (String)property.value;
            }
        }
        return null;
    }

    public String toString() {
        return this.isPersistent() ? this.getCurrentKey() : super.toString();
    }

    public String getKeyValueString(String string) {
        return this.getValueString(this.getKeyValue(string));
    }

    public String getValueString() {
        return this.getValueString(this.value);
    }

    public String getValueString(Object object) {
        return object != null ? this.systemValue.createDisplayString(object) : null;
    }
}

