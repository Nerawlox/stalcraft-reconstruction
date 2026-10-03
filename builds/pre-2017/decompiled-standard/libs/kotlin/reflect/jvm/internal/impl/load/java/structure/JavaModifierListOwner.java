/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.structure;

import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement;
import org.jetbrains.annotations.NotNull;

public interface JavaModifierListOwner
extends JavaElement {
    public boolean isAbstract();

    public boolean isStatic();

    public boolean isFinal();

    @NotNull
    public Visibility getVisibility();
}

