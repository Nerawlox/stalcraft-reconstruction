/*
 * Decompiled with CFR 0.152.
 */
package org.objectweb.asm.signature;

public abstract class SignatureVisitor {
    public static final char EXTENDS = '+';
    public static final char SUPER = '-';
    public static final char INSTANCEOF = '=';
    protected final int api;

    public SignatureVisitor(int api) {
        if (api < 262144 || api > 393216) {
            throw new IllegalArgumentException();
        }
        this.api = api;
    }

    public void visitFormalTypeParameter(String name2) {
    }

    public SignatureVisitor visitClassBound() {
        return this;
    }

    public SignatureVisitor visitInterfaceBound() {
        return this;
    }

    public SignatureVisitor visitSuperclass() {
        return this;
    }

    public SignatureVisitor visitInterface() {
        return this;
    }

    public SignatureVisitor visitParameterType() {
        return this;
    }

    public SignatureVisitor visitReturnType() {
        return this;
    }

    public SignatureVisitor visitExceptionType() {
        return this;
    }

    public void visitBaseType(char descriptor2) {
    }

    public void visitTypeVariable(String name2) {
    }

    public SignatureVisitor visitArrayType() {
        return this;
    }

    public void visitClassType(String name2) {
    }

    public void visitInnerClassType(String name2) {
    }

    public void visitTypeArgument() {
    }

    public SignatureVisitor visitTypeArgument(char wildcard) {
        return this;
    }

    public void visitEnd() {
    }
}

