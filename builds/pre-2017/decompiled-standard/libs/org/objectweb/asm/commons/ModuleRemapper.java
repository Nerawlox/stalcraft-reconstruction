/*
 * Decompiled with CFR 0.152.
 */
package org.objectweb.asm.commons;

import org.objectweb.asm.ModuleVisitor;
import org.objectweb.asm.commons.Remapper;

public class ModuleRemapper
extends ModuleVisitor {
    private final Remapper remapper;

    public ModuleRemapper(ModuleVisitor mv, Remapper remapper) {
        this(393216, mv, remapper);
    }

    protected ModuleRemapper(int api, ModuleVisitor mv, Remapper remapper) {
        super(api, mv);
        this.remapper = remapper;
    }

    @Override
    public void visitMainClass(String mainClass) {
        super.visitMainClass(this.remapper.mapType(mainClass));
    }

    @Override
    public void visitPackage(String packaze) {
        super.visitPackage(this.remapper.mapPackageName(packaze));
    }

    @Override
    public void visitRequire(String module, int access, String version) {
        super.visitRequire(this.remapper.mapModuleName(module), access, version);
    }

    @Override
    public void visitExport(String packaze, int access, String ... modules) {
        String[] newModules = null;
        if (modules != null) {
            newModules = new String[modules.length];
            for (int i = 0; i < modules.length; ++i) {
                newModules[i] = this.remapper.mapModuleName(modules[i]);
            }
        }
        super.visitExport(this.remapper.mapPackageName(packaze), access, newModules);
    }

    @Override
    public void visitOpen(String packaze, int access, String ... modules) {
        String[] newModules = null;
        if (modules != null) {
            newModules = new String[modules.length];
            for (int i = 0; i < modules.length; ++i) {
                newModules[i] = this.remapper.mapModuleName(modules[i]);
            }
        }
        super.visitOpen(this.remapper.mapPackageName(packaze), access, newModules);
    }

    @Override
    public void visitUse(String service) {
        super.visitUse(this.remapper.mapType(service));
    }

    @Override
    public void visitProvide(String service, String ... providers) {
        String[] newProviders = new String[providers.length];
        for (int i = 0; i < providers.length; ++i) {
            newProviders[i] = this.remapper.mapType(providers[i]);
        }
        super.visitProvide(this.remapper.mapType(service), newProviders);
    }
}

