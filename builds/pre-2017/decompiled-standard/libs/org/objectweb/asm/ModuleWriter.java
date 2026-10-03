/*
 * Decompiled with CFR 0.152.
 */
package org.objectweb.asm;

import org.objectweb.asm.ByteVector;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.ModuleVisitor;

final class ModuleWriter
extends ModuleVisitor {
    private final ClassWriter cw;
    int size;
    int attributeCount;
    int attributesSize;
    private final int name;
    private final int access;
    private final int version;
    private int mainClass;
    private int packageCount;
    private ByteVector packages;
    private int requireCount;
    private ByteVector requires;
    private int exportCount;
    private ByteVector exports;
    private int openCount;
    private ByteVector opens;
    private int useCount;
    private ByteVector uses;
    private int provideCount;
    private ByteVector provides;

    ModuleWriter(ClassWriter cw, int name2, int access, int version) {
        super(393216);
        this.cw = cw;
        this.size = 16;
        this.name = name2;
        this.access = access;
        this.version = version;
    }

    @Override
    public void visitMainClass(String mainClass) {
        if (this.mainClass == 0) {
            this.cw.newUTF8("ModuleMainClass");
            ++this.attributeCount;
            this.attributesSize += 8;
        }
        this.mainClass = this.cw.newClass(mainClass);
    }

    @Override
    public void visitPackage(String packaze) {
        if (this.packages == null) {
            this.cw.newUTF8("ModulePackages");
            this.packages = new ByteVector();
            ++this.attributeCount;
            this.attributesSize += 8;
        }
        this.packages.putShort(this.cw.newPackage(packaze));
        ++this.packageCount;
        this.attributesSize += 2;
    }

    @Override
    public void visitRequire(String module, int access, String version) {
        if (this.requires == null) {
            this.requires = new ByteVector();
        }
        this.requires.putShort(this.cw.newModule(module)).putShort(access).putShort(version == null ? 0 : this.cw.newUTF8(version));
        ++this.requireCount;
        this.size += 6;
    }

    @Override
    public void visitExport(String packaze, int access, String ... modules) {
        if (this.exports == null) {
            this.exports = new ByteVector();
        }
        this.exports.putShort(this.cw.newPackage(packaze)).putShort(access);
        if (modules == null) {
            this.exports.putShort(0);
            this.size += 6;
        } else {
            this.exports.putShort(modules.length);
            for (String module : modules) {
                this.exports.putShort(this.cw.newModule(module));
            }
            this.size += 6 + 2 * modules.length;
        }
        ++this.exportCount;
    }

    @Override
    public void visitOpen(String packaze, int access, String ... modules) {
        if (this.opens == null) {
            this.opens = new ByteVector();
        }
        this.opens.putShort(this.cw.newPackage(packaze)).putShort(access);
        if (modules == null) {
            this.opens.putShort(0);
            this.size += 6;
        } else {
            this.opens.putShort(modules.length);
            for (String module : modules) {
                this.opens.putShort(this.cw.newModule(module));
            }
            this.size += 6 + 2 * modules.length;
        }
        ++this.openCount;
    }

    @Override
    public void visitUse(String service) {
        if (this.uses == null) {
            this.uses = new ByteVector();
        }
        this.uses.putShort(this.cw.newClass(service));
        ++this.useCount;
        this.size += 2;
    }

    @Override
    public void visitProvide(String service, String ... providers) {
        if (this.provides == null) {
            this.provides = new ByteVector();
        }
        this.provides.putShort(this.cw.newClass(service));
        this.provides.putShort(providers.length);
        for (String provider : providers) {
            this.provides.putShort(this.cw.newClass(provider));
        }
        ++this.provideCount;
        this.size += 4 + 2 * providers.length;
    }

    @Override
    public void visitEnd() {
    }

    void putAttributes(ByteVector out) {
        if (this.mainClass != 0) {
            out.putShort(this.cw.newUTF8("ModuleMainClass")).putInt(2).putShort(this.mainClass);
        }
        if (this.packages != null) {
            out.putShort(this.cw.newUTF8("ModulePackages")).putInt(2 + 2 * this.packageCount).putShort(this.packageCount).putByteArray(this.packages.data, 0, this.packages.length);
        }
    }

    void put(ByteVector out) {
        out.putInt(this.size);
        out.putShort(this.name).putShort(this.access).putShort(this.version);
        out.putShort(this.requireCount);
        if (this.requires != null) {
            out.putByteArray(this.requires.data, 0, this.requires.length);
        }
        out.putShort(this.exportCount);
        if (this.exports != null) {
            out.putByteArray(this.exports.data, 0, this.exports.length);
        }
        out.putShort(this.openCount);
        if (this.opens != null) {
            out.putByteArray(this.opens.data, 0, this.opens.length);
        }
        out.putShort(this.useCount);
        if (this.uses != null) {
            out.putByteArray(this.uses.data, 0, this.uses.length);
        }
        out.putShort(this.provideCount);
        if (this.provides != null) {
            out.putByteArray(this.provides.data, 0, this.provides.length);
        }
    }
}

