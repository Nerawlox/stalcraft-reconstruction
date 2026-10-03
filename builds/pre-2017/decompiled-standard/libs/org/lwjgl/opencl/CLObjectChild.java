/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opencl;

import org.lwjgl.LWJGLUtil;
import org.lwjgl.PointerWrapperAbstract;
import org.lwjgl.opencl.CLObject;
import org.lwjgl.opencl.CLObjectRetainable;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
abstract class CLObjectChild<P extends CLObject>
extends CLObjectRetainable {
    private final P parent;

    protected CLObjectChild(long pointer, P parent) {
        super(pointer);
        if (LWJGLUtil.DEBUG && parent != null && !((PointerWrapperAbstract)parent).isValid()) {
            throw new IllegalStateException("The parent specified is not a valid CL object.");
        }
        this.parent = parent;
    }

    public P getParent() {
        return this.parent;
    }
}

