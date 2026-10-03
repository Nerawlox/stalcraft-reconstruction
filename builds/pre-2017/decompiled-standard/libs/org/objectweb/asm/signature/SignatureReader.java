/*
 * Decompiled with CFR 0.152.
 */
package org.objectweb.asm.signature;

import org.objectweb.asm.signature.SignatureVisitor;

public class SignatureReader {
    private final String signature;

    public SignatureReader(String signature2) {
        this.signature = signature2;
    }

    public void accept(SignatureVisitor v) {
        int pos;
        String signature2 = this.signature;
        int len = signature2.length();
        if (signature2.charAt(0) == '<') {
            char c;
            pos = 2;
            do {
                int end = signature2.indexOf(58, pos);
                v.visitFormalTypeParameter(signature2.substring(pos - 1, end));
                pos = end + 1;
                c = signature2.charAt(pos);
                if (c == 'L' || c == '[' || c == 'T') {
                    pos = SignatureReader.parseType(signature2, pos, v.visitClassBound());
                }
                while ((c = signature2.charAt(pos++)) == ':') {
                    pos = SignatureReader.parseType(signature2, pos, v.visitInterfaceBound());
                }
            } while (c != '>');
        } else {
            pos = 0;
        }
        if (signature2.charAt(pos) == '(') {
            ++pos;
            while (signature2.charAt(pos) != ')') {
                pos = SignatureReader.parseType(signature2, pos, v.visitParameterType());
            }
            pos = SignatureReader.parseType(signature2, pos + 1, v.visitReturnType());
            while (pos < len) {
                pos = SignatureReader.parseType(signature2, pos + 1, v.visitExceptionType());
            }
        } else {
            pos = SignatureReader.parseType(signature2, pos, v.visitSuperclass());
            while (pos < len) {
                pos = SignatureReader.parseType(signature2, pos, v.visitInterface());
            }
        }
    }

    public void acceptType(SignatureVisitor v) {
        SignatureReader.parseType(this.signature, 0, v);
    }

    private static int parseType(String signature2, int pos, SignatureVisitor v) {
        char c = signature2.charAt(pos++);
        switch (c) {
            case 'B': 
            case 'C': 
            case 'D': 
            case 'F': 
            case 'I': 
            case 'J': 
            case 'S': 
            case 'V': 
            case 'Z': {
                v.visitBaseType(c);
                return pos;
            }
            case '[': {
                return SignatureReader.parseType(signature2, pos, v.visitArrayType());
            }
            case 'T': {
                int end = signature2.indexOf(59, pos);
                v.visitTypeVariable(signature2.substring(pos, end));
                return end + 1;
            }
        }
        int start = pos;
        boolean visited = false;
        boolean inner = false;
        while (true) {
            c = signature2.charAt(pos++);
            block5 : switch (c) {
                case '.': 
                case ';': {
                    String name2;
                    if (!visited) {
                        name2 = signature2.substring(start, pos - 1);
                        if (inner) {
                            v.visitInnerClassType(name2);
                        } else {
                            v.visitClassType(name2);
                        }
                    }
                    if (c == ';') {
                        v.visitEnd();
                        return pos;
                    }
                    start = pos;
                    visited = false;
                    inner = true;
                    break;
                }
                case '<': {
                    String name2 = signature2.substring(start, pos - 1);
                    if (inner) {
                        v.visitInnerClassType(name2);
                    } else {
                        v.visitClassType(name2);
                    }
                    visited = true;
                    block15: while (true) {
                        c = signature2.charAt(pos);
                        switch (c) {
                            case '>': {
                                break block5;
                            }
                            case '*': {
                                ++pos;
                                v.visitTypeArgument();
                                continue block15;
                            }
                            case '+': 
                            case '-': {
                                pos = SignatureReader.parseType(signature2, pos + 1, v.visitTypeArgument(c));
                                continue block15;
                            }
                        }
                        pos = SignatureReader.parseType(signature2, pos, v.visitTypeArgument('='));
                    }
                }
            }
        }
    }
}

