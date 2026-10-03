/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.discovery.asm;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import cpw.mods.fml.common.discovery.asm.ASMModParser;
import java.util.ArrayList;
import java.util.Map;
import org.objectweb.asm.Type;

public class ModAnnotation {
    ASMModParser.AnnotationType type;
    Type asmType;
    String member;
    Map<String, Object> values = Maps.newHashMap();
    private ArrayList<Object> arrayList;
    private Object array;
    private String arrayName;
    private ModAnnotation parent;

    public ModAnnotation(ASMModParser.AnnotationType annotationType, Type type, String string) {
        this.type = annotationType;
        this.asmType = type;
        this.member = string;
    }

    public ModAnnotation(ASMModParser.AnnotationType annotationType, Type type, ModAnnotation modAnnotation) {
        this.type = annotationType;
        this.asmType = type;
        this.parent = modAnnotation;
    }

    public String toString() {
        return Objects.toStringHelper("Annotation").add("type", (Object)this.type).add("name", this.asmType.getClassName()).add("member", this.member).add("values", this.values).toString();
    }

    public ASMModParser.AnnotationType getType() {
        return this.type;
    }

    public Type getASMType() {
        return this.asmType;
    }

    public String getMember() {
        return this.member;
    }

    public Map<String, Object> getValues() {
        return this.values;
    }

    public void addArray(String string) {
        this.arrayList = Lists.newArrayList();
        this.arrayName = string;
    }

    public void addProperty(String string, Object object) {
        if (this.arrayList != null) {
            this.arrayList.add(object);
        } else {
            this.values.put(string, object);
        }
    }

    public void addEnumProperty(String string, String string2, String string3) {
        this.values.put(string, new EnumHolder(string2, string3));
    }

    public void endArray() {
        this.values.put(this.arrayName, this.arrayList);
        this.arrayList = null;
    }

    public ModAnnotation addChildAnnotation(String string, String string2) {
        ModAnnotation modAnnotation = new ModAnnotation(ASMModParser.AnnotationType.SUBTYPE, Type.getType(string2), this);
        if (this.arrayList != null) {
            this.arrayList.add(modAnnotation.getValues());
        }
        return modAnnotation;
    }

    public class EnumHolder {
        private String desc;
        private String value;

        public EnumHolder(String string, String string2) {
            this.desc = string;
            this.value = string2;
        }
    }
}

