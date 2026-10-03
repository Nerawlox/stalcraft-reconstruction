/*
 * Decompiled with CFR 0.152.
 */
package kotlin.jvm.internal;

import kotlin.jvm.internal.FunctionReference;
import kotlin.reflect.KDeclarationContainer;

public class FunctionReferenceImpl
extends FunctionReference {
    private final KDeclarationContainer owner;
    private final String name;
    private final String signature;

    public FunctionReferenceImpl(int arity, KDeclarationContainer owner, String name2, String signature2) {
        super(arity);
        this.owner = owner;
        this.name = name2;
        this.signature = signature2;
    }

    @Override
    public KDeclarationContainer getOwner() {
        return this.owner;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getSignature() {
        return this.signature;
    }
}

