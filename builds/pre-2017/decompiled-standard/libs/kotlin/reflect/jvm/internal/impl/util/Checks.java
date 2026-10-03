/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.util;

import java.util.Arrays;
import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.util.Check;
import kotlin.reflect.jvm.internal.impl.util.CheckResult;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class Checks {
    @Nullable
    private final Name name;
    @Nullable
    private final Regex regex;
    @Nullable
    private final Collection<Name> nameList;
    @NotNull
    private final Function1<FunctionDescriptor, String> additionalCheck;
    @NotNull
    private final Check[] checks;

    public final boolean isApplicable(@NotNull FunctionDescriptor functionDescriptor) {
        CharSequence charSequence;
        Regex regex;
        Intrinsics.checkParameterIsNotNull(functionDescriptor, "functionDescriptor");
        if (this.name != null && Intrinsics.areEqual(functionDescriptor.getName(), this.name) ^ true) {
            return false;
        }
        if (this.regex != null && !(regex = this.regex).matches(charSequence = (CharSequence)functionDescriptor.getName().asString())) {
            return false;
        }
        return this.nameList == null || !(this.nameList.contains(functionDescriptor.getName()) ^ true);
    }

    @NotNull
    public final CheckResult checkAll(@NotNull FunctionDescriptor functionDescriptor) {
        Intrinsics.checkParameterIsNotNull(functionDescriptor, "functionDescriptor");
        Check[] checkArray = this.checks;
        for (int i = 0; i < checkArray.length; ++i) {
            Check check = checkArray[i];
            String checkResult = check.invoke(functionDescriptor);
            if (checkResult == null) continue;
            return new CheckResult.IllegalSignature(checkResult);
        }
        String additionalCheckResult = this.additionalCheck.invoke(functionDescriptor);
        if (additionalCheckResult != null) {
            return new CheckResult.IllegalSignature(additionalCheckResult);
        }
        return CheckResult.SuccessCheck.INSTANCE;
    }

    @Nullable
    public final Name getName() {
        return this.name;
    }

    @Nullable
    public final Regex getRegex() {
        return this.regex;
    }

    @Nullable
    public final Collection<Name> getNameList() {
        return this.nameList;
    }

    @NotNull
    public final Function1<FunctionDescriptor, String> getAdditionalCheck() {
        return this.additionalCheck;
    }

    @NotNull
    public final Check[] getChecks() {
        return this.checks;
    }

    private Checks(Name name2, Regex regex, Collection<Name> nameList, Function1<? super FunctionDescriptor, String> additionalCheck, Check ... checks2) {
        this.name = name2;
        this.regex = regex;
        this.nameList = nameList;
        this.additionalCheck = additionalCheck;
        this.checks = checks2;
    }

    public Checks(@NotNull Check[] checks2, @NotNull Function1<? super FunctionDescriptor, String> additionalChecks) {
        Intrinsics.checkParameterIsNotNull(checks2, "checks");
        Intrinsics.checkParameterIsNotNull(additionalChecks, "additionalChecks");
        this(null, null, null, additionalChecks, Arrays.copyOf(checks2, checks2.length));
    }

    public /* synthetic */ Checks(Check[] checkArray, Function1 function1, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            function1 = 1.INSTANCE;
        }
        this(checkArray, function1);
    }

    public Checks(@NotNull Name name2, @NotNull Check[] checks2, @NotNull Function1<? super FunctionDescriptor, String> additionalChecks) {
        Intrinsics.checkParameterIsNotNull(name2, "name");
        Intrinsics.checkParameterIsNotNull(checks2, "checks");
        Intrinsics.checkParameterIsNotNull(additionalChecks, "additionalChecks");
        this(name2, null, null, additionalChecks, Arrays.copyOf(checks2, checks2.length));
    }

    public /* synthetic */ Checks(Name name2, Check[] checkArray, Function1 function1, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 4) != 0) {
            function1 = 2.INSTANCE;
        }
        this(name2, checkArray, (Function1<? super FunctionDescriptor, String>)function1);
    }

    public Checks(@NotNull Regex regex, @NotNull Check[] checks2, @NotNull Function1<? super FunctionDescriptor, String> additionalChecks) {
        Intrinsics.checkParameterIsNotNull(regex, "regex");
        Intrinsics.checkParameterIsNotNull(checks2, "checks");
        Intrinsics.checkParameterIsNotNull(additionalChecks, "additionalChecks");
        this(null, regex, null, additionalChecks, Arrays.copyOf(checks2, checks2.length));
    }

    public /* synthetic */ Checks(Regex regex, Check[] checkArray, Function1 function1, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 4) != 0) {
            function1 = 3.INSTANCE;
        }
        this(regex, checkArray, (Function1<? super FunctionDescriptor, String>)function1);
    }

    public Checks(@NotNull Collection<Name> nameList, @NotNull Check[] checks2, @NotNull Function1<? super FunctionDescriptor, String> additionalChecks) {
        Intrinsics.checkParameterIsNotNull(nameList, "nameList");
        Intrinsics.checkParameterIsNotNull(checks2, "checks");
        Intrinsics.checkParameterIsNotNull(additionalChecks, "additionalChecks");
        this(null, null, nameList, additionalChecks, Arrays.copyOf(checks2, checks2.length));
    }

    public /* synthetic */ Checks(Collection collection, Check[] checkArray, Function1 function1, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 4) != 0) {
            function1 = 4.INSTANCE;
        }
        this(collection, checkArray, (Function1<? super FunctionDescriptor, String>)function1);
    }
}

