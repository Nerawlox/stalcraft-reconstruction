/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.util;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.util.AbstractModifierChecks;
import kotlin.reflect.jvm.internal.impl.util.Check;
import kotlin.reflect.jvm.internal.impl.util.Checks;
import kotlin.reflect.jvm.internal.impl.util.IsKPropertyCheck;
import kotlin.reflect.jvm.internal.impl.util.MemberKindCheck;
import kotlin.reflect.jvm.internal.impl.util.NoDefaultAndVarargsCheck;
import kotlin.reflect.jvm.internal.impl.util.OperatorChecks;
import kotlin.reflect.jvm.internal.impl.util.OperatorNameConventions;
import kotlin.reflect.jvm.internal.impl.util.ReturnsCheck;
import kotlin.reflect.jvm.internal.impl.util.ValueParameterCountCheck;
import org.jetbrains.annotations.NotNull;

public final class OperatorChecks
extends AbstractModifierChecks {
    @NotNull
    private static final List<Checks> checks;
    public static final OperatorChecks INSTANCE;

    @Override
    @NotNull
    public List<Checks> getChecks$kotlin_core() {
        return checks;
    }

    private OperatorChecks() {
        INSTANCE = this;
        Checks[] checksArray = new Checks[18];
        Name name2 = OperatorNameConventions.GET;
        Intrinsics.checkExpressionValueIsNotNull(name2, "GET");
        checksArray[0] = new Checks(name2, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, new ValueParameterCountCheck.AtLeast(1)}, null, 4, null);
        Name name3 = OperatorNameConventions.SET;
        Intrinsics.checkExpressionValueIsNotNull(name3, "SET");
        checksArray[1] = new Checks(name3, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, new ValueParameterCountCheck.AtLeast(2)}, (Function1<? super FunctionDescriptor, String>)checks.1.INSTANCE);
        Name name4 = OperatorNameConventions.GET_VALUE;
        Intrinsics.checkExpressionValueIsNotNull(name4, "GET_VALUE");
        checksArray[2] = new Checks(name4, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, NoDefaultAndVarargsCheck.INSTANCE, new ValueParameterCountCheck.AtLeast(2), IsKPropertyCheck.INSTANCE}, null, 4, null);
        Name name5 = OperatorNameConventions.SET_VALUE;
        Intrinsics.checkExpressionValueIsNotNull(name5, "SET_VALUE");
        checksArray[3] = new Checks(name5, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, NoDefaultAndVarargsCheck.INSTANCE, new ValueParameterCountCheck.AtLeast(3), IsKPropertyCheck.INSTANCE}, null, 4, null);
        Name name6 = OperatorNameConventions.PROVIDE_DELEGATE;
        Intrinsics.checkExpressionValueIsNotNull(name6, "PROVIDE_DELEGATE");
        checksArray[4] = new Checks(name6, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, NoDefaultAndVarargsCheck.INSTANCE, new ValueParameterCountCheck.Equals(2), IsKPropertyCheck.INSTANCE}, null, 4, null);
        Name name7 = OperatorNameConventions.INVOKE;
        Intrinsics.checkExpressionValueIsNotNull(name7, "INVOKE");
        checksArray[5] = new Checks(name7, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE}, null, 4, null);
        Name name8 = OperatorNameConventions.CONTAINS;
        Intrinsics.checkExpressionValueIsNotNull(name8, "CONTAINS");
        checksArray[6] = new Checks(name8, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, ValueParameterCountCheck.SingleValueParameter.INSTANCE, NoDefaultAndVarargsCheck.INSTANCE, ReturnsCheck.ReturnsBoolean.INSTANCE}, null, 4, null);
        Name name9 = OperatorNameConventions.ITERATOR;
        Intrinsics.checkExpressionValueIsNotNull(name9, "ITERATOR");
        checksArray[7] = new Checks(name9, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, ValueParameterCountCheck.NoValueParameters.INSTANCE}, null, 4, null);
        Name name10 = OperatorNameConventions.NEXT;
        Intrinsics.checkExpressionValueIsNotNull(name10, "NEXT");
        checksArray[8] = new Checks(name10, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, ValueParameterCountCheck.NoValueParameters.INSTANCE}, null, 4, null);
        Name name11 = OperatorNameConventions.HAS_NEXT;
        Intrinsics.checkExpressionValueIsNotNull(name11, "HAS_NEXT");
        checksArray[9] = new Checks(name11, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, ValueParameterCountCheck.NoValueParameters.INSTANCE, ReturnsCheck.ReturnsBoolean.INSTANCE}, null, 4, null);
        Name name12 = OperatorNameConventions.RANGE_TO;
        Intrinsics.checkExpressionValueIsNotNull(name12, "RANGE_TO");
        checksArray[10] = new Checks(name12, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, ValueParameterCountCheck.SingleValueParameter.INSTANCE, NoDefaultAndVarargsCheck.INSTANCE}, null, 4, null);
        Name name13 = OperatorNameConventions.EQUALS;
        Intrinsics.checkExpressionValueIsNotNull(name13, "EQUALS");
        checksArray[11] = new Checks(name13, new Check[]{MemberKindCheck.Member.INSTANCE}, (Function1<? super FunctionDescriptor, String>)checks.2.INSTANCE);
        Name name14 = OperatorNameConventions.COMPARE_TO;
        Intrinsics.checkExpressionValueIsNotNull(name14, "COMPARE_TO");
        checksArray[12] = new Checks(name14, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, ReturnsCheck.ReturnsInt.INSTANCE, ValueParameterCountCheck.SingleValueParameter.INSTANCE, NoDefaultAndVarargsCheck.INSTANCE}, null, 4, null);
        checksArray[13] = new Checks(OperatorNameConventions.BINARY_OPERATION_NAMES, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, ValueParameterCountCheck.SingleValueParameter.INSTANCE, NoDefaultAndVarargsCheck.INSTANCE}, null, 4, null);
        checksArray[14] = new Checks(OperatorNameConventions.SIMPLE_UNARY_OPERATION_NAMES, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, ValueParameterCountCheck.NoValueParameters.INSTANCE}, null, 4, null);
        checksArray[15] = new Checks((Collection<Name>)CollectionsKt.listOf(new Name[]{OperatorNameConventions.INC, OperatorNameConventions.DEC}), new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE}, (Function1<? super FunctionDescriptor, String>)checks.3.INSTANCE);
        checksArray[16] = new Checks(OperatorNameConventions.ASSIGNMENT_OPERATIONS, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, ReturnsCheck.ReturnsUnit.INSTANCE, ValueParameterCountCheck.SingleValueParameter.INSTANCE, NoDefaultAndVarargsCheck.INSTANCE}, null, 4, null);
        checksArray[17] = new Checks(OperatorNameConventions.COMPONENT_REGEX, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, ValueParameterCountCheck.NoValueParameters.INSTANCE}, null, 4, null);
        checks = CollectionsKt.listOf(checksArray);
    }

    static {
        new OperatorChecks();
    }
}

