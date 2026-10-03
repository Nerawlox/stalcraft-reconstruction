/*
 * Decompiled with CFR 0.152.
 */
package org.objectweb.asm.util;

import org.objectweb.asm.signature.SignatureVisitor;

public class CheckSignatureAdapter
extends SignatureVisitor {
    public static final int CLASS_SIGNATURE = 0;
    public static final int METHOD_SIGNATURE = 1;
    public static final int TYPE_SIGNATURE = 2;
    private static final int EMPTY = 1;
    private static final int FORMAL = 2;
    private static final int BOUND = 4;
    private static final int SUPER = 8;
    private static final int PARAM = 16;
    private static final int RETURN = 32;
    private static final int SIMPLE_TYPE = 64;
    private static final int CLASS_TYPE = 128;
    private static final int END = 256;
    private final int type;
    private int state;
    private boolean canBeVoid;
    private final SignatureVisitor sv;

    public CheckSignatureAdapter(int type2, SignatureVisitor sv) {
        this(393216, type2, sv);
    }

    protected CheckSignatureAdapter(int api, int type2, SignatureVisitor sv) {
        super(api);
        this.type = type2;
        this.state = 1;
        this.sv = sv;
    }

    @Override
    public void visitFormalTypeParameter(String name2) {
        if (this.type == 2 || this.state != 1 && this.state != 2 && this.state != 4) {
            throw new IllegalStateException();
        }
        this.checkIdentifier(name2, "formal type parameter");
        this.state = 2;
        if (this.sv != null) {
            this.sv.visitFormalTypeParameter(name2);
        }
    }

    @Override
    public SignatureVisitor visitClassBound() {
        if (this.state != 2) {
            throw new IllegalStateException();
        }
        this.state = 4;
        SignatureVisitor v = this.sv == null ? null : this.sv.visitClassBound();
        return new CheckSignatureAdapter(2, v);
    }

    @Override
    public SignatureVisitor visitInterfaceBound() {
        if (this.state != 2 && this.state != 4) {
            throw new IllegalArgumentException();
        }
        SignatureVisitor v = this.sv == null ? null : this.sv.visitInterfaceBound();
        return new CheckSignatureAdapter(2, v);
    }

    @Override
    public SignatureVisitor visitSuperclass() {
        if (this.type != 0 || (this.state & 7) == 0) {
            throw new IllegalArgumentException();
        }
        this.state = 8;
        SignatureVisitor v = this.sv == null ? null : this.sv.visitSuperclass();
        return new CheckSignatureAdapter(2, v);
    }

    @Override
    public SignatureVisitor visitInterface() {
        if (this.state != 8) {
            throw new IllegalStateException();
        }
        SignatureVisitor v = this.sv == null ? null : this.sv.visitInterface();
        return new CheckSignatureAdapter(2, v);
    }

    @Override
    public SignatureVisitor visitParameterType() {
        if (this.type != 1 || (this.state & 0x17) == 0) {
            throw new IllegalArgumentException();
        }
        this.state = 16;
        SignatureVisitor v = this.sv == null ? null : this.sv.visitParameterType();
        return new CheckSignatureAdapter(2, v);
    }

    @Override
    public SignatureVisitor visitReturnType() {
        if (this.type != 1 || (this.state & 0x17) == 0) {
            throw new IllegalArgumentException();
        }
        this.state = 32;
        SignatureVisitor v = this.sv == null ? null : this.sv.visitReturnType();
        CheckSignatureAdapter cv = new CheckSignatureAdapter(2, v);
        cv.canBeVoid = true;
        return cv;
    }

    @Override
    public SignatureVisitor visitExceptionType() {
        if (this.state != 32) {
            throw new IllegalStateException();
        }
        SignatureVisitor v = this.sv == null ? null : this.sv.visitExceptionType();
        return new CheckSignatureAdapter(2, v);
    }

    @Override
    public void visitBaseType(char descriptor2) {
        if (this.type != 2 || this.state != 1) {
            throw new IllegalStateException();
        }
        if (descriptor2 == 'V' ? !this.canBeVoid : "ZCBSIFJD".indexOf(descriptor2) == -1) {
            throw new IllegalArgumentException();
        }
        this.state = 64;
        if (this.sv != null) {
            this.sv.visitBaseType(descriptor2);
        }
    }

    @Override
    public void visitTypeVariable(String name2) {
        if (this.type != 2 || this.state != 1) {
            throw new IllegalStateException();
        }
        this.checkIdentifier(name2, "type variable");
        this.state = 64;
        if (this.sv != null) {
            this.sv.visitTypeVariable(name2);
        }
    }

    @Override
    public SignatureVisitor visitArrayType() {
        if (this.type != 2 || this.state != 1) {
            throw new IllegalStateException();
        }
        this.state = 64;
        SignatureVisitor v = this.sv == null ? null : this.sv.visitArrayType();
        return new CheckSignatureAdapter(2, v);
    }

    @Override
    public void visitClassType(String name2) {
        if (this.type != 2 || this.state != 1) {
            throw new IllegalStateException();
        }
        this.checkClassName(name2, "class name");
        this.state = 128;
        if (this.sv != null) {
            this.sv.visitClassType(name2);
        }
    }

    @Override
    public void visitInnerClassType(String name2) {
        if (this.state != 128) {
            throw new IllegalStateException();
        }
        this.checkIdentifier(name2, "inner class name");
        if (this.sv != null) {
            this.sv.visitInnerClassType(name2);
        }
    }

    @Override
    public void visitTypeArgument() {
        if (this.state != 128) {
            throw new IllegalStateException();
        }
        if (this.sv != null) {
            this.sv.visitTypeArgument();
        }
    }

    @Override
    public SignatureVisitor visitTypeArgument(char wildcard) {
        if (this.state != 128) {
            throw new IllegalStateException();
        }
        if ("+-=".indexOf(wildcard) == -1) {
            throw new IllegalArgumentException();
        }
        SignatureVisitor v = this.sv == null ? null : this.sv.visitTypeArgument(wildcard);
        return new CheckSignatureAdapter(2, v);
    }

    @Override
    public void visitEnd() {
        if (this.state != 128) {
            throw new IllegalStateException();
        }
        this.state = 256;
        if (this.sv != null) {
            this.sv.visitEnd();
        }
    }

    private void checkClassName(String name2, String msg) {
        if (name2 == null || name2.length() == 0) {
            throw new IllegalArgumentException("Invalid " + msg + " (must not be null or empty)");
        }
        for (int i = 0; i < name2.length(); ++i) {
            if (".;[<>:".indexOf(name2.charAt(i)) == -1) continue;
            throw new IllegalArgumentException("Invalid " + msg + " (must not contain . ; [ < > or :): " + name2);
        }
    }

    private void checkIdentifier(String name2, String msg) {
        if (name2 == null || name2.length() == 0) {
            throw new IllegalArgumentException("Invalid " + msg + " (must not be null or empty)");
        }
        for (int i = 0; i < name2.length(); ++i) {
            if (".;[/<>:".indexOf(name2.charAt(i)) == -1) continue;
            throw new IllegalArgumentException("Invalid " + msg + " (must not contain . ; [ / < > or :): " + name2);
        }
    }
}

