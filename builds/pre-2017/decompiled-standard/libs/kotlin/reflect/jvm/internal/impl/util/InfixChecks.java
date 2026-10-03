/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.util;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.reflect.jvm.internal.impl.util.AbstractModifierChecks;
import kotlin.reflect.jvm.internal.impl.util.Check;
import kotlin.reflect.jvm.internal.impl.util.Checks;
import kotlin.reflect.jvm.internal.impl.util.MemberKindCheck;
import kotlin.reflect.jvm.internal.impl.util.NoDefaultAndVarargsCheck;
import kotlin.reflect.jvm.internal.impl.util.ValueParameterCountCheck;
import org.jetbrains.annotations.NotNull;

public final class InfixChecks
extends AbstractModifierChecks {
    @NotNull
    private static final List<Checks> checks;
    public static final InfixChecks INSTANCE;

    @Override
    @NotNull
    public List<Checks> getChecks$kotlin_core() {
        return checks;
    }

    private InfixChecks() {
        INSTANCE = this;
        checks = CollectionsKt.listOf(new Checks(new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, ValueParameterCountCheck.SingleValueParameter.INSTANCE, NoDefaultAndVarargsCheck.INSTANCE}, null, 2, null));
    }

    static {
        new InfixChecks();
    }
}

