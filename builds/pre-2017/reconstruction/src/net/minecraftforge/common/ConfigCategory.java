/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.common;

import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.Property;

public class ConfigCategory
implements Map<String, Property> {
    private String name;
    private String comment;
    private ArrayList<ConfigCategory> children = new ArrayList();
    private Map<String, Property> properties = new TreeMap<String, Property>();
    public final ConfigCategory parent;
    private boolean changed = false;

    public ConfigCategory(String string) {
        this(string, null);
    }

    public ConfigCategory(String string, ConfigCategory configCategory) {
        this.name = string;
        this.parent = configCategory;
        if (configCategory != null) {
            configCategory.children.add(this);
        }
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof ConfigCategory) {
            ConfigCategory configCategory = (ConfigCategory)object;
            return this.name.equals(configCategory.name) && this.children.equals(configCategory.children);
        }
        return false;
    }

    public String getQualifiedName() {
        return ConfigCategory.getQualifiedName(this.name, this.parent);
    }

    public static String getQualifiedName(String string, ConfigCategory configCategory) {
        return configCategory == null ? string : configCategory.getQualifiedName() + "." + string;
    }

    public ConfigCategory getFirstParent() {
        return this.parent == null ? this : this.parent.getFirstParent();
    }

    public boolean isChild() {
        return this.parent != null;
    }

    public Map<String, Property> getValues() {
        return ImmutableMap.copyOf(this.properties);
    }

    public void setComment(String string) {
        this.comment = string;
    }

    public boolean containsKey(String string) {
        return this.properties.containsKey(string);
    }

    public Property get(String string) {
        return this.properties.get(string);
    }

    private void write(BufferedWriter bufferedWriter, String ... stringArray) throws IOException {
        this.write(bufferedWriter, true, stringArray);
    }

    private void write(BufferedWriter bufferedWriter, boolean bl, String ... stringArray) throws IOException {
        for (int i = 0; i < stringArray.length; ++i) {
            bufferedWriter.write(stringArray[i]);
        }
        if (bl) {
            bufferedWriter.write(Configuration.NEW_LINE);
        }
    }

    public void write(BufferedWriter bufferedWriter, int n) throws IOException {
        Property[] propertyArray;
        String string = this.getIndent(n);
        String string2 = this.getIndent(n + 1);
        String string3 = this.getIndent(n + 2);
        this.write(bufferedWriter, string, "####################");
        this.write(bufferedWriter, string, "# ", this.name);
        if (this.comment != null) {
            this.write(bufferedWriter, string, "#===================");
            propertyArray = Splitter.onPattern("\r?\n");
            for (String object2 : propertyArray.split(this.comment)) {
                this.write(bufferedWriter, string, "# ", object2);
            }
        }
        this.write(bufferedWriter, string, "####################", Configuration.NEW_LINE);
        if (!Configuration.allowedProperties.matchesAllOf(this.name)) {
            this.name = '\"' + this.name + '\"';
        }
        this.write(bufferedWriter, string, this.name, " {");
        propertyArray = this.properties.values().toArray(new Property[this.properties.size()]);
        for (int i = 0; i < propertyArray.length; ++i) {
            Object object;
            Property property = propertyArray[i];
            if (property.comment != null) {
                if (i != 0) {
                    bufferedWriter.newLine();
                }
                object = Splitter.onPattern("\r?\n");
                for (String string4 : ((Splitter)object).split(property.comment)) {
                    this.write(bufferedWriter, string2, "# ", string4);
                }
            }
            if (!Configuration.allowedProperties.matchesAllOf((CharSequence)(object = property.getName()))) {
                object = '\"' + (String)object + '\"';
            }
            if (property.isList()) {
                char c = property.getType().getID();
                this.write(bufferedWriter, new String[]{string2, String.valueOf(c), ":", object, " <"});
                for (String string5 : property.getStringList()) {
                    this.write(bufferedWriter, string3, string5);
                }
                this.write(bufferedWriter, string2, " >");
                continue;
            }
            if (property.getType() == null) {
                this.write(bufferedWriter, new String[]{string2, object, "=", property.getString()});
                continue;
            }
            char c = property.getType().getID();
            this.write(bufferedWriter, new String[]{string2, String.valueOf(c), ":", object, "=", property.getString()});
        }
        for (ConfigCategory configCategory : this.children) {
            configCategory.write(bufferedWriter, n + 1);
        }
        this.write(bufferedWriter, string, "}", Configuration.NEW_LINE);
    }

    private String getIndent(int n) {
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i < n; ++i) {
            stringBuilder.append("    ");
        }
        return stringBuilder.toString();
    }

    public boolean hasChanged() {
        if (this.changed) {
            return true;
        }
        for (Property property : this.properties.values()) {
            if (!property.hasChanged()) continue;
            return true;
        }
        return false;
    }

    void resetChangedState() {
        this.changed = false;
        for (Property property : this.properties.values()) {
            property.resetChangedState();
        }
    }

    @Override
    public int size() {
        return this.properties.size();
    }

    @Override
    public boolean isEmpty() {
        return this.properties.isEmpty();
    }

    @Override
    public boolean containsKey(Object object) {
        return this.properties.containsKey(object);
    }

    @Override
    public boolean containsValue(Object object) {
        return this.properties.containsValue(object);
    }

    @Override
    public Property get(Object object) {
        return this.properties.get(object);
    }

    @Override
    public Property put(String string, Property property) {
        this.changed = true;
        return this.properties.put(string, property);
    }

    @Override
    public Property remove(Object object) {
        this.changed = true;
        return this.properties.remove(object);
    }

    @Override
    public void putAll(Map<? extends String, ? extends Property> map) {
        this.changed = true;
        this.properties.putAll(map);
    }

    @Override
    public void clear() {
        this.changed = true;
        this.properties.clear();
    }

    @Override
    public Set<String> keySet() {
        return this.properties.keySet();
    }

    @Override
    public Collection<Property> values() {
        return this.properties.values();
    }

    @Override
    public Set<Map.Entry<String, Property>> entrySet() {
        return ImmutableSet.copyOf(this.properties.entrySet());
    }

    public Set<ConfigCategory> getChildren() {
        return ImmutableSet.copyOf(this.children);
    }

    public void removeChild(ConfigCategory configCategory) {
        if (this.children.contains(configCategory)) {
            this.children.remove(configCategory);
            this.changed = true;
        }
    }
}

