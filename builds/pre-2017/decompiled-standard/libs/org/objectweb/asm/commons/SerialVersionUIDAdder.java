/*
 * Decompiled with CFR 0.152.
 */
package org.objectweb.asm.commons;

import java.io.ByteArrayOutputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;

public class SerialVersionUIDAdder
extends ClassVisitor {
    private boolean computeSVUID;
    private boolean hasSVUID;
    private int access;
    private String name;
    private String[] interfaces;
    private Collection<Item> svuidFields = new ArrayList<Item>();
    private boolean hasStaticInitializer;
    private Collection<Item> svuidConstructors = new ArrayList<Item>();
    private Collection<Item> svuidMethods = new ArrayList<Item>();

    public SerialVersionUIDAdder(ClassVisitor cv) {
        this(393216, cv);
        if (this.getClass() != SerialVersionUIDAdder.class) {
            throw new IllegalStateException();
        }
    }

    protected SerialVersionUIDAdder(int api, ClassVisitor cv) {
        super(api, cv);
    }

    @Override
    public void visit(int version, int access, String name2, String signature2, String superName, String[] interfaces) {
        boolean bl = this.computeSVUID = (access & 0x4000) == 0;
        if (this.computeSVUID) {
            this.name = name2;
            this.access = access;
            this.interfaces = new String[interfaces.length];
            System.arraycopy(interfaces, 0, this.interfaces, 0, interfaces.length);
        }
        super.visit(version, access, name2, signature2, superName, interfaces);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name2, String desc, String signature2, String[] exceptions) {
        if (this.computeSVUID) {
            if ("<clinit>".equals(name2)) {
                this.hasStaticInitializer = true;
            }
            int mods = access & 0xD3F;
            if ((access & 2) == 0) {
                if ("<init>".equals(name2)) {
                    this.svuidConstructors.add(new Item(name2, mods, desc));
                } else if (!"<clinit>".equals(name2)) {
                    this.svuidMethods.add(new Item(name2, mods, desc));
                }
            }
        }
        return super.visitMethod(access, name2, desc, signature2, exceptions);
    }

    @Override
    public FieldVisitor visitField(int access, String name2, String desc, String signature2, Object value) {
        if (this.computeSVUID) {
            if ("serialVersionUID".equals(name2)) {
                this.computeSVUID = false;
                this.hasSVUID = true;
            }
            if ((access & 2) == 0 || (access & 0x88) == 0) {
                int mods = access & 0xDF;
                this.svuidFields.add(new Item(name2, mods, desc));
            }
        }
        return super.visitField(access, name2, desc, signature2, value);
    }

    @Override
    public void visitInnerClass(String aname, String outerName, String innerName, int attr_access) {
        if (this.name != null && this.name.equals(aname)) {
            this.access = attr_access;
        }
        super.visitInnerClass(aname, outerName, innerName, attr_access);
    }

    @Override
    public void visitEnd() {
        if (this.computeSVUID && !this.hasSVUID) {
            try {
                this.addSVUID(this.computeSVUID());
            }
            catch (Throwable e) {
                throw new RuntimeException("Error while computing SVUID for " + this.name, e);
            }
        }
        super.visitEnd();
    }

    public boolean hasSVUID() {
        return this.hasSVUID;
    }

    protected void addSVUID(long svuid) {
        FieldVisitor fv = super.visitField(24, "serialVersionUID", "J", null, svuid);
        if (fv != null) {
            fv.visitEnd();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected long computeSVUID() throws IOException {
        FilterOutputStream dos = null;
        long svuid = 0L;
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            dos = new DataOutputStream(bos);
            ((DataOutputStream)dos).writeUTF(this.name.replace('/', '.'));
            int access = this.access;
            if ((access & 0x200) != 0) {
                access = this.svuidMethods.size() > 0 ? access | 0x400 : access & 0xFFFFFBFF;
            }
            ((DataOutputStream)dos).writeInt(access & 0x611);
            Arrays.sort(this.interfaces);
            for (int i = 0; i < this.interfaces.length; ++i) {
                ((DataOutputStream)dos).writeUTF(this.interfaces[i].replace('/', '.'));
            }
            SerialVersionUIDAdder.writeItems(this.svuidFields, (DataOutput)((Object)dos), false);
            if (this.hasStaticInitializer) {
                ((DataOutputStream)dos).writeUTF("<clinit>");
                ((DataOutputStream)dos).writeInt(8);
                ((DataOutputStream)dos).writeUTF("()V");
            }
            SerialVersionUIDAdder.writeItems(this.svuidConstructors, (DataOutput)((Object)dos), true);
            SerialVersionUIDAdder.writeItems(this.svuidMethods, (DataOutput)((Object)dos), true);
            ((DataOutputStream)dos).flush();
            byte[] hashBytes = this.computeSHAdigest(bos.toByteArray());
            for (int i = Math.min(hashBytes.length, 8) - 1; i >= 0; --i) {
                svuid = svuid << 8 | (long)(hashBytes[i] & 0xFF);
            }
        }
        finally {
            if (dos != null) {
                dos.close();
            }
        }
        return svuid;
    }

    protected byte[] computeSHAdigest(byte[] value) {
        try {
            return MessageDigest.getInstance("SHA").digest(value);
        }
        catch (Exception e) {
            throw new UnsupportedOperationException(e.toString());
        }
    }

    private static void writeItems(Collection<Item> itemCollection, DataOutput dos, boolean dotted) throws IOException {
        int size = itemCollection.size();
        Object[] items = itemCollection.toArray(new Item[size]);
        Arrays.sort(items);
        for (int i = 0; i < size; ++i) {
            dos.writeUTF(((Item)items[i]).name);
            dos.writeInt(((Item)items[i]).access);
            dos.writeUTF(dotted ? ((Item)items[i]).desc.replace('/', '.') : ((Item)items[i]).desc);
        }
    }

    private static class Item
    implements Comparable<Item> {
        final String name;
        final int access;
        final String desc;

        Item(String name2, int access, String desc) {
            this.name = name2;
            this.access = access;
            this.desc = desc;
        }

        @Override
        public int compareTo(Item other) {
            int retVal = this.name.compareTo(other.name);
            if (retVal == 0) {
                retVal = this.desc.compareTo(other.desc);
            }
            return retVal;
        }

        public boolean equals(Object o) {
            if (o instanceof Item) {
                return this.compareTo((Item)o) == 0;
            }
            return false;
        }

        public int hashCode() {
            return (this.name + this.desc).hashCode();
        }
    }
}

