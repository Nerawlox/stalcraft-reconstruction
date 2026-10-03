/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.renderer;

public final class ParameterNameRenderingPolicy
extends Enum<ParameterNameRenderingPolicy> {
    public static final /* enum */ ParameterNameRenderingPolicy ALL;
    public static final /* enum */ ParameterNameRenderingPolicy ONLY_NON_SYNTHESIZED;
    public static final /* enum */ ParameterNameRenderingPolicy NONE;
    private static final /* synthetic */ ParameterNameRenderingPolicy[] $VALUES;

    static {
        ParameterNameRenderingPolicy[] parameterNameRenderingPolicyArray = new ParameterNameRenderingPolicy[3];
        ParameterNameRenderingPolicy[] parameterNameRenderingPolicyArray2 = parameterNameRenderingPolicyArray;
        parameterNameRenderingPolicyArray[0] = ALL = new ParameterNameRenderingPolicy();
        parameterNameRenderingPolicyArray[1] = ONLY_NON_SYNTHESIZED = new ParameterNameRenderingPolicy();
        parameterNameRenderingPolicyArray[2] = NONE = new ParameterNameRenderingPolicy();
        $VALUES = parameterNameRenderingPolicyArray;
    }

    public static ParameterNameRenderingPolicy[] values() {
        return (ParameterNameRenderingPolicy[])$VALUES.clone();
    }

    public static ParameterNameRenderingPolicy valueOf(String string) {
        return Enum.valueOf(ParameterNameRenderingPolicy.class, string);
    }
}

