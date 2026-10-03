/*
 * Decompiled with CFR 0.152.
 */
package codechicken.lib.asm;

import com.google.common.base.Objects;
import cpw.mods.fml.common.asm.transformers.deobf.FMLDeobfuscatingRemapper;
import java.io.IOException;
import net.minecraft.launchwrapper.Launch;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.commons.Remapper;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.FieldInsnNode;
import org.objectweb.asm.tree.FieldNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.TypeInsnNode;

public class ObfMapping {
    public static Remapper runtimeMapper = FMLDeobfuscatingRemapper.INSTANCE;
    public static Remapper mcpMapper = null;
    public static final boolean obfuscated;
    public String s_owner;
    public String s_name;
    public String s_desc;
    public boolean runtime;

    public ObfMapping(String string) {
        this(string, "", "");
    }

    public ObfMapping(String string, String string2, String string3) {
        this.s_owner = string;
        this.s_name = string2;
        this.s_desc = string3;
        if (this.s_owner.contains(".")) {
            throw new IllegalArgumentException(this.s_owner);
        }
        if (mcpMapper != null) {
            this.map(mcpMapper);
        }
    }

    public ObfMapping(ObfMapping obfMapping, String string) {
        this(string, obfMapping.s_name, obfMapping.s_desc);
    }

    public static ObfMapping fromDesc(String string) {
        int n;
        int n2 = string.lastIndexOf(46);
        if (n2 < 0) {
            return new ObfMapping(string, "", "");
        }
        int n3 = n = string.indexOf(40);
        if (n < 0) {
            n = string.indexOf(32);
            n3 = n + 1;
        }
        if (n < 0) {
            n = string.indexOf(58);
            n3 = n + 1;
        }
        if (n < 0) {
            return new ObfMapping(string.substring(0, n2), string.substring(n2 + 1), "");
        }
        return new ObfMapping(string.substring(0, n2), string.substring(n2 + 1, n), string.substring(n3));
    }

    public ObfMapping subclass(String string) {
        return new ObfMapping(this, string);
    }

    public boolean matches(MethodNode methodNode) {
        return this.s_name.equals(methodNode.name) && this.s_desc.equals(methodNode.desc);
    }

    public boolean matches(MethodInsnNode methodInsnNode) {
        return this.s_owner.equals(methodInsnNode.owner) && this.s_name.equals(methodInsnNode.name) && this.s_desc.equals(methodInsnNode.desc);
    }

    public AbstractInsnNode toInsn(int n) {
        if (this.isClass()) {
            return new TypeInsnNode(n, this.s_owner);
        }
        if (this.isMethod()) {
            return new MethodInsnNode(n, this.s_owner, this.s_name, this.s_desc);
        }
        return new FieldInsnNode(n, this.s_owner, this.s_name, this.s_desc);
    }

    public void visitTypeInsn(MethodVisitor methodVisitor, int n) {
        methodVisitor.visitTypeInsn(n, this.s_owner);
    }

    public void visitMethodInsn(MethodVisitor methodVisitor, int n) {
        methodVisitor.visitMethodInsn(n, this.s_owner, this.s_name, this.s_desc);
    }

    public void visitFieldInsn(MethodVisitor methodVisitor, int n) {
        methodVisitor.visitFieldInsn(n, this.s_owner, this.s_name, this.s_desc);
    }

    public boolean isClass(String string) {
        return string.replace('.', '/').equals(this.s_owner);
    }

    public boolean matches(String string, String string2) {
        return this.s_name.equals(string) && this.s_desc.equals(string2);
    }

    public boolean matches(FieldNode fieldNode) {
        return this.s_name.equals(fieldNode.name) && this.s_desc.equals(fieldNode.desc);
    }

    public boolean matches(FieldInsnNode fieldInsnNode) {
        return this.s_owner.equals(fieldInsnNode.owner) && this.s_name.equals(fieldInsnNode.name) && this.s_desc.equals(fieldInsnNode.desc);
    }

    public String javaClass() {
        return this.s_owner.replace('/', '.');
    }

    public boolean equals(Object object) {
        if (!(object instanceof ObfMapping)) {
            return false;
        }
        ObfMapping obfMapping = (ObfMapping)object;
        return this.s_owner.equals(obfMapping.s_owner) && this.s_name.equals(obfMapping.s_name) && this.s_desc.equals(obfMapping.s_desc);
    }

    public int hashCode() {
        return Objects.hashCode(this.s_desc, this.s_name, this.s_owner);
    }

    public String toString() {
        if (this.s_name.length() == 0) {
            return "[" + this.s_owner + "]";
        }
        if (this.s_desc.length() == 0) {
            return "[" + this.s_owner + "." + this.s_name + "]";
        }
        return "[" + (this.isMethod() ? this.methodDesc() : this.fieldDesc()) + "]";
    }

    public String methodDesc() {
        return this.s_owner + "." + this.s_name + this.s_desc;
    }

    public String fieldDesc() {
        return this.s_owner + "." + this.s_name + ":" + this.s_desc;
    }

    public boolean isClass() {
        return this.s_name.length() == 0;
    }

    public boolean isMethod() {
        return this.s_desc.contains("(");
    }

    public boolean isField() {
        return !this.isClass() && !this.isMethod();
    }

    public ObfMapping map(Remapper remapper) {
        if (this.isMethod()) {
            this.s_name = remapper.mapMethodName(this.s_owner, this.s_name, this.s_desc);
        } else if (this.isField()) {
            this.s_name = remapper.mapFieldName(this.s_owner, this.s_name, this.s_desc);
        }
        this.s_owner = remapper.mapType(this.s_owner);
        if (this.isMethod()) {
            this.s_desc = remapper.mapMethodDesc(this.s_desc);
        } else if (this.s_desc.length() > 0) {
            this.s_desc = remapper.mapDesc(this.s_desc);
        }
        return this;
    }

    public ObfMapping toRuntime() {
        if (!this.runtime) {
            this.map(runtimeMapper);
        }
        this.runtime = true;
        return this;
    }

    public ObfMapping copy() {
        return new ObfMapping(this.s_owner, this.s_name, this.s_desc);
    }

    static {
        boolean bl = true;
        try {
            bl = Launch.classLoader.getClassBytes("net.minecraft.world.World") == null;
        }
        catch (IOException iOException) {
            // empty catch block
        }
        obfuscated = bl;
    }
}

