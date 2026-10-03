/*
 * Decompiled with CFR 0.152.
 */
package org.objectweb.asm.signature;

import org.objectweb.asm.signature.SignatureVisitor;

public class SignatureWriter
extends SignatureVisitor {
    private final StringBuilder buf = new StringBuilder();
    private boolean hasFormals;
    private boolean hasParameters;
    private int argumentStack;

    public SignatureWriter() {
        super(393216);
    }

    @Override
    public void visitFormalTypeParameter(String name2) {
        if (!this.hasFormals) {
            this.hasFormals = true;
            this.buf.append('<');
        }
        this.buf.append(name2);
        this.buf.append(':');
    }

    @Override
    public SignatureVisitor visitClassBound() {
        return this;
    }

    @Override
    public SignatureVisitor visitInterfaceBound() {
        this.buf.append(':');
        return this;
    }

    @Override
    public SignatureVisitor visitSuperclass() {
        this.endFormals();
        return this;
    }

    @Override
    public SignatureVisitor visitInterface() {
        return this;
    }

    @Override
    public SignatureVisitor visitParameterType() {
        this.endFormals();
        if (!this.hasParameters) {
            this.hasParameters = true;
            this.buf.append('(');
        }
        return this;
    }

    @Override
    public SignatureVisitor visitReturnType() {
        this.endFormals();
        if (!this.hasParameters) {
            this.buf.append('(');
        }
        this.buf.append(')');
        return this;
    }

    @Override
    public SignatureVisitor visitExceptionType() {
        this.buf.append('^');
        return this;
    }

    @Override
    public void visitBaseType(char descriptor2) {
        this.buf.append(descriptor2);
    }

    @Override
    public void visitTypeVariable(String name2) {
        this.buf.append('T');
        this.buf.append(name2);
        this.buf.append(';');
    }

    @Override
    public SignatureVisitor visitArrayType() {
        this.buf.append('[');
        return this;
    }

    @Override
    public void visitClassType(String name2) {
        this.buf.append('L');
        this.buf.append(name2);
        this.argumentStack *= 2;
    }

    @Override
    public void visitInnerClassType(String name2) {
        this.endArguments();
        this.buf.append('.');
        this.buf.append(name2);
        this.argumentStack *= 2;
    }

    @Override
    public void visitTypeArgument() {
        if (this.argumentStack % 2 == 0) {
            ++this.argumentStack;
            this.buf.append('<');
        }
        this.buf.append('*');
    }

    @Override
    public SignatureVisitor visitTypeArgument(char wildcard) {
        if (this.argumentStack % 2 == 0) {
            ++this.argumentStack;
            this.buf.append('<');
        }
        if (wildcard != '=') {
            this.buf.append(wildcard);
        }
        return this;
    }

    @Override
    public void visitEnd() {
        this.endArguments();
        this.buf.append(';');
    }

    public String toString() {
        return this.buf.toString();
    }

    private void endFormals() {
        if (this.hasFormals) {
            this.hasFormals = false;
            this.buf.append('>');
        }
    }

    private void endArguments() {
        if (this.argumentStack % 2 != 0) {
            this.buf.append('>');
        }
        this.argumentStack /= 2;
    }
}

