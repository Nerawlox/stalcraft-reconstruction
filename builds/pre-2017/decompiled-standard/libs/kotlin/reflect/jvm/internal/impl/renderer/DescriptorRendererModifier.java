/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

public final class DescriptorRendererModifier
extends Enum<DescriptorRendererModifier> {
    public static final /* enum */ DescriptorRendererModifier VISIBILITY;
    public static final /* enum */ DescriptorRendererModifier MODALITY;
    public static final /* enum */ DescriptorRendererModifier OVERRIDE;
    public static final /* enum */ DescriptorRendererModifier ANNOTATIONS;
    public static final /* enum */ DescriptorRendererModifier INNER;
    public static final /* enum */ DescriptorRendererModifier MEMBER_KIND;
    public static final /* enum */ DescriptorRendererModifier DATA;
    public static final /* enum */ DescriptorRendererModifier HEADER;
    public static final /* enum */ DescriptorRendererModifier IMPL;
    private static final /* synthetic */ DescriptorRendererModifier[] $VALUES;
    private final boolean includeByDefault;
    @JvmField
    @NotNull
    public static final Set<DescriptorRendererModifier> DEFAULTS;
    @JvmField
    @NotNull
    public static final Set<DescriptorRendererModifier> ALL;
    public static final Companion Companion;

    /*
     * WARNING - void declaration
     */
    static {
        void var3_3;
        void $receiver$iv$iv;
        VISIBILITY = new DescriptorRendererModifier(true);
        MODALITY = new DescriptorRendererModifier(true);
        OVERRIDE = new DescriptorRendererModifier(true);
        ANNOTATIONS = new DescriptorRendererModifier(false);
        INNER = new DescriptorRendererModifier(true);
        MEMBER_KIND = new DescriptorRendererModifier(true);
        DATA = new DescriptorRendererModifier(true);
        HEADER = new DescriptorRendererModifier(true);
        IMPL = new DescriptorRendererModifier(true);
        $VALUES = new DescriptorRendererModifier[]{VISIBILITY, MODALITY, OVERRIDE, ANNOTATIONS, INNER, MEMBER_KIND, DATA, HEADER, IMPL};
        Companion = new Companion(null);
        Object[] $receiver$iv = (Object[])DescriptorRendererModifier.values();
        DescriptorRendererModifier[] descriptorRendererModifierArray = $VALUES;
        Object[] objectArray = $receiver$iv;
        Collection destination$iv$iv = new ArrayList();
        for (int i = 0; i < ((void)$receiver$iv$iv).length; ++i) {
            void element$iv$iv = $receiver$iv$iv[i];
            DescriptorRendererModifier it = (DescriptorRendererModifier)element$iv$iv;
            if (!it.includeByDefault) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        List list = (List)var3_3;
        DescriptorRendererModifier[] descriptorRendererModifierArray2 = descriptorRendererModifierArray;
        DEFAULTS = CollectionsKt.toSet(list);
        ALL = ArraysKt.toSet((Object[])DescriptorRendererModifier.values());
    }

    public final boolean getIncludeByDefault() {
        return this.includeByDefault;
    }

    protected DescriptorRendererModifier(boolean includeByDefault) {
        this.includeByDefault = includeByDefault;
    }

    public static DescriptorRendererModifier[] values() {
        return (DescriptorRendererModifier[])$VALUES.clone();
    }

    public static DescriptorRendererModifier valueOf(String string) {
        return Enum.valueOf(DescriptorRendererModifier.class, string);
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

