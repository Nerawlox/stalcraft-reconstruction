/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.discovery.asm;

import com.google.common.base.Objects;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.LoaderException;
import cpw.mods.fml.common.discovery.ASMDataTable;
import cpw.mods.fml.common.discovery.ModCandidate;
import cpw.mods.fml.common.discovery.asm.ModAnnotation;
import cpw.mods.fml.common.discovery.asm.ModClassVisitor;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import obf.gloomyfolken.modlist.ModListHooks;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.Type;

public class ASMModParser {
    private Type asmType;
    private int classVersion;
    private Type asmSuperType;
    private LinkedList<ModAnnotation> annotations;
    private String baseModProperties;

    public ASMModParser(InputStream inputStream) throws IOException {
        boolean bl = ModListHooks.init(this, inputStream);
        if (bl) {
            boolean bl2 = bl;
            return;
        }
        this.annotations = Lists.newLinkedList();
        try {
            ClassReader classReader = new ClassReader(inputStream);
            classReader.accept(new ModClassVisitor(this), 0);
        }
        catch (Exception exception) {
            FMLLog.log(Level.SEVERE, exception, "Unable to read a class file correctly", new Object[0]);
            throw new LoaderException(exception);
        }
        ModListHooks.postInit(this, inputStream);
    }

    public void beginNewTypeName(String string, int n, String string2) {
        this.asmType = Type.getObjectType(string);
        this.classVersion = n;
        this.asmSuperType = !Strings.isNullOrEmpty(string2) ? Type.getObjectType(string2) : null;
    }

    public void startClassAnnotation(String string) {
        ModAnnotation modAnnotation = new ModAnnotation(AnnotationType.CLASS, Type.getType(string), this.asmType.getClassName());
        this.annotations.addFirst(modAnnotation);
    }

    public void addAnnotationProperty(String string, Object object) {
        this.annotations.getFirst().addProperty(string, object);
    }

    public void startFieldAnnotation(String string, String string2) {
        ModAnnotation modAnnotation = new ModAnnotation(AnnotationType.FIELD, Type.getType(string2), string);
        this.annotations.addFirst(modAnnotation);
    }

    public String toString() {
        return Objects.toStringHelper("ASMAnnotationDiscoverer").add("className", this.asmType.getClassName()).add("classVersion", this.classVersion).add("superName", this.asmSuperType.getClassName()).add("annotations", this.annotations).add("isBaseMod", this.isBaseMod(Collections.<String>emptyList())).add("baseModProperties", this.baseModProperties).toString();
    }

    public Type getASMType() {
        return this.asmType;
    }

    public int getClassVersion() {
        return this.classVersion;
    }

    public Type getASMSuperType() {
        return this.asmSuperType;
    }

    public LinkedList<ModAnnotation> getAnnotations() {
        return this.annotations;
    }

    public void validate() {
    }

    public boolean isBaseMod(List<String> list) {
        boolean bl = ModListHooks.isBaseMod(this, list);
        if (bl) {
            return false;
        }
        return this.getASMSuperType().equals(Type.getType("LBaseMod;")) || this.getASMSuperType().equals(Type.getType("Lnet/minecraft/src/BaseMod;")) || list.contains(this.getASMSuperType().getClassName());
    }

    public void setBaseModProperties(String string) {
        this.baseModProperties = string;
    }

    public String getBaseModProperties() {
        return this.baseModProperties;
    }

    public void sendToTable(ASMDataTable aSMDataTable, ModCandidate modCandidate) {
        for (ModAnnotation modAnnotation : this.annotations) {
            aSMDataTable.addASMData(modCandidate, modAnnotation.asmType.getClassName(), this.asmType.getClassName(), modAnnotation.member, modAnnotation.values);
        }
    }

    public void addAnnotationArray(String string) {
        this.annotations.getFirst().addArray(string);
    }

    public void addAnnotationEnumProperty(String string, String string2, String string3) {
        this.annotations.getFirst().addEnumProperty(string, string2, string3);
    }

    public void endArray() {
        this.annotations.getFirst().endArray();
    }

    public void addSubAnnotation(String string, String string2) {
        ModAnnotation modAnnotation = this.annotations.getFirst();
        this.annotations.addFirst(modAnnotation.addChildAnnotation(string, string2));
    }

    public void endSubAnnotation() {
        ModAnnotation modAnnotation = this.annotations.removeFirst();
        this.annotations.addLast(modAnnotation);
    }

    public void startMethodAnnotation(String string, String string2, String string3) {
        ModAnnotation modAnnotation = new ModAnnotation(AnnotationType.METHOD, Type.getType(string3), string + string2);
        this.annotations.addFirst(modAnnotation);
    }

    static enum AnnotationType {
        CLASS,
        FIELD,
        METHOD,
        SUBTYPE;

    }
}

