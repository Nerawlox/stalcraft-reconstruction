/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.modloader;

import java.lang.reflect.Field;
import java.util.Map;

public class ModProperty {
    private String info;
    private double min;
    private double max;
    private String name;
    private Field field;

    public ModProperty(Field field, String string, Double d, Double d2, String string2) {
        this.field = field;
        this.info = string;
        this.min = d != null ? d : Double.MIN_VALUE;
        this.max = d2 != null ? d2 : Double.MAX_VALUE;
        this.name = string2;
    }

    public ModProperty(Field field, Map<String, Object> map) {
        this(field, (String)map.get("info"), (Double)map.get("min"), (Double)map.get("max"), (String)map.get("name"));
    }

    public String name() {
        return this.name;
    }

    public double min() {
        return this.min;
    }

    public double max() {
        return this.max;
    }

    public String info() {
        return this.info;
    }

    public Field field() {
        return this.field;
    }
}

