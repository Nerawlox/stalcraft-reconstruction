/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.structure.reflect;

import java.lang.reflect.Modifier;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.load.java.JavaVisibilities;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner;
import org.jetbrains.annotations.NotNull;

public interface ReflectJavaModifierListOwner
extends JavaModifierListOwner {
    public int getModifiers();

    @Override
    public boolean isAbstract();

    @Override
    public boolean isStatic();

    @Override
    public boolean isFinal();

    @Override
    @NotNull
    public Visibility getVisibility();

    public static final class DefaultImpls {
        public static boolean isAbstract(ReflectJavaModifierListOwner $this) {
            return Modifier.isAbstract($this.getModifiers());
        }

        public static boolean isStatic(ReflectJavaModifierListOwner $this) {
            return Modifier.isStatic($this.getModifiers());
        }

        public static boolean isFinal(ReflectJavaModifierListOwner $this) {
            return Modifier.isFinal($this.getModifiers());
        }

        @NotNull
        public static Visibility getVisibility(ReflectJavaModifierListOwner $this) {
            Visibility visibility;
            int n = $this.getModifiers();
            int modifiers = n;
            if (Modifier.isPublic(modifiers)) {
                Visibility visibility2 = Visibilities.PUBLIC;
                visibility = visibility2;
                Intrinsics.checkExpressionValueIsNotNull(visibility2, "Visibilities.PUBLIC");
            } else if (Modifier.isPrivate(modifiers)) {
                Visibility visibility3 = Visibilities.PRIVATE;
                visibility = visibility3;
                Intrinsics.checkExpressionValueIsNotNull(visibility3, "Visibilities.PRIVATE");
            } else if (Modifier.isProtected(modifiers)) {
                Visibility visibility4 = Modifier.isStatic(modifiers) ? JavaVisibilities.PROTECTED_STATIC_VISIBILITY : JavaVisibilities.PROTECTED_AND_PACKAGE;
                visibility = visibility4;
                Intrinsics.checkExpressionValueIsNotNull(visibility4, "if (Modifier.isStatic(mo\u2026ies.PROTECTED_AND_PACKAGE");
            } else {
                Visibility visibility5 = JavaVisibilities.PACKAGE_VISIBILITY;
                visibility = visibility5;
                Intrinsics.checkExpressionValueIsNotNull(visibility5, "JavaVisibilities.PACKAGE_VISIBILITY");
            }
            return visibility;
        }
    }
}

