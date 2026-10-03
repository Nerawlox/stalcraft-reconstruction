/*
 * Decompiled with CFR 0.152.
 */
package org.objectweb.asm.util;

import java.util.HashSet;
import org.objectweb.asm.ModuleVisitor;
import org.objectweb.asm.util.CheckClassAdapter;
import org.objectweb.asm.util.CheckMethodAdapter;

public final class CheckModuleAdapter
extends ModuleVisitor {
    private boolean end;
    private final boolean isOpen;
    private final HashSet<String> requireNames = new HashSet();
    private final HashSet<String> exportNames = new HashSet();
    private final HashSet<String> openNames = new HashSet();
    private final HashSet<String> useNames = new HashSet();
    private final HashSet<String> provideNames = new HashSet();

    public CheckModuleAdapter(ModuleVisitor mv, boolean isOpen) {
        super(393216, mv);
        this.isOpen = isOpen;
    }

    @Override
    public void visitRequire(String module, int access, String version) {
        this.checkEnd();
        if (module == null) {
            throw new IllegalArgumentException("require cannot be null");
        }
        CheckModuleAdapter.checkDeclared("requires", this.requireNames, module);
        CheckClassAdapter.checkAccess(access, 36960);
        super.visitRequire(module, access, version);
    }

    @Override
    public void visitExport(String packaze, int access, String ... modules) {
        this.checkEnd();
        if (packaze == null) {
            throw new IllegalArgumentException("packaze cannot be null");
        }
        CheckMethodAdapter.checkInternalName(packaze, "package name");
        CheckModuleAdapter.checkDeclared("exports", this.exportNames, packaze);
        CheckClassAdapter.checkAccess(access, 36864);
        if (modules != null) {
            for (int i = 0; i < modules.length; ++i) {
                if (modules[i] != null) continue;
                throw new IllegalArgumentException("module at index " + i + " cannot be null");
            }
        }
        super.visitExport(packaze, access, modules);
    }

    @Override
    public void visitOpen(String packaze, int access, String ... modules) {
        this.checkEnd();
        if (this.isOpen) {
            throw new IllegalArgumentException("an open module can not use open directive");
        }
        if (packaze == null) {
            throw new IllegalArgumentException("packaze cannot be null");
        }
        CheckMethodAdapter.checkInternalName(packaze, "package name");
        CheckModuleAdapter.checkDeclared("opens", this.openNames, packaze);
        CheckClassAdapter.checkAccess(access, 36864);
        if (modules != null) {
            for (int i = 0; i < modules.length; ++i) {
                if (modules[i] != null) continue;
                throw new IllegalArgumentException("module at index " + i + " cannot be null");
            }
        }
        super.visitOpen(packaze, access, modules);
    }

    @Override
    public void visitUse(String service) {
        this.checkEnd();
        CheckMethodAdapter.checkInternalName(service, "service");
        CheckModuleAdapter.checkDeclared("uses", this.useNames, service);
        super.visitUse(service);
    }

    @Override
    public void visitProvide(String service, String ... providers) {
        this.checkEnd();
        CheckMethodAdapter.checkInternalName(service, "service");
        CheckModuleAdapter.checkDeclared("provides", this.provideNames, service);
        if (providers == null || providers.length == 0) {
            throw new IllegalArgumentException("providers cannot be null or empty");
        }
        for (int i = 0; i < providers.length; ++i) {
            CheckMethodAdapter.checkInternalName(providers[i], "provider");
        }
        super.visitProvide(service, providers);
    }

    @Override
    public void visitEnd() {
        this.checkEnd();
        this.end = true;
        super.visitEnd();
    }

    private void checkEnd() {
        if (this.end) {
            throw new IllegalStateException("Cannot call a visit method after visitEnd has been called");
        }
    }

    private static void checkDeclared(String directive, HashSet<String> names, String name2) {
        if (!names.add(name2)) {
            throw new IllegalArgumentException(directive + " " + name2 + " already declared");
        }
    }
}

