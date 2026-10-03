/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.renderer;

public final class OverrideRenderingPolicy
extends Enum<OverrideRenderingPolicy> {
    public static final /* enum */ OverrideRenderingPolicy RENDER_OVERRIDE;
    public static final /* enum */ OverrideRenderingPolicy RENDER_OPEN;
    public static final /* enum */ OverrideRenderingPolicy RENDER_OPEN_OVERRIDE;
    private static final /* synthetic */ OverrideRenderingPolicy[] $VALUES;

    static {
        OverrideRenderingPolicy[] overrideRenderingPolicyArray = new OverrideRenderingPolicy[3];
        OverrideRenderingPolicy[] overrideRenderingPolicyArray2 = overrideRenderingPolicyArray;
        overrideRenderingPolicyArray[0] = RENDER_OVERRIDE = new OverrideRenderingPolicy();
        overrideRenderingPolicyArray[1] = RENDER_OPEN = new OverrideRenderingPolicy();
        overrideRenderingPolicyArray[2] = RENDER_OPEN_OVERRIDE = new OverrideRenderingPolicy();
        $VALUES = overrideRenderingPolicyArray;
    }

    public static OverrideRenderingPolicy[] values() {
        return (OverrideRenderingPolicy[])$VALUES.clone();
    }

    public static OverrideRenderingPolicy valueOf(String string) {
        return Enum.valueOf(OverrideRenderingPolicy.class, string);
    }
}

