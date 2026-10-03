/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.util;

import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmField;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;

public final class OperatorNameConventions {
    @JvmField
    @NotNull
    public static final Name GET_VALUE;
    @JvmField
    @NotNull
    public static final Name SET_VALUE;
    @JvmField
    @NotNull
    public static final Name PROVIDE_DELEGATE;
    @JvmField
    @NotNull
    public static final Name EQUALS;
    @JvmField
    @NotNull
    public static final Name COMPARE_TO;
    @JvmField
    @NotNull
    public static final Name CONTAINS;
    @JvmField
    @NotNull
    public static final Name INVOKE;
    @JvmField
    @NotNull
    public static final Name ITERATOR;
    @JvmField
    @NotNull
    public static final Name GET;
    @JvmField
    @NotNull
    public static final Name SET;
    @JvmField
    @NotNull
    public static final Name NEXT;
    @JvmField
    @NotNull
    public static final Name HAS_NEXT;
    @JvmField
    @NotNull
    public static final Regex COMPONENT_REGEX;
    @JvmField
    @NotNull
    public static final Name AND;
    @JvmField
    @NotNull
    public static final Name OR;
    @JvmField
    @NotNull
    public static final Name INC;
    @JvmField
    @NotNull
    public static final Name DEC;
    @JvmField
    @NotNull
    public static final Name PLUS;
    @JvmField
    @NotNull
    public static final Name MINUS;
    @JvmField
    @NotNull
    public static final Name NOT;
    @JvmField
    @NotNull
    public static final Name UNARY_MINUS;
    @JvmField
    @NotNull
    public static final Name UNARY_PLUS;
    @JvmField
    @NotNull
    public static final Name TIMES;
    @JvmField
    @NotNull
    public static final Name DIV;
    @JvmField
    @NotNull
    public static final Name MOD;
    @JvmField
    @NotNull
    public static final Name REM;
    @JvmField
    @NotNull
    public static final Name RANGE_TO;
    @JvmField
    @NotNull
    public static final Name TIMES_ASSIGN;
    @JvmField
    @NotNull
    public static final Name DIV_ASSIGN;
    @JvmField
    @NotNull
    public static final Name MOD_ASSIGN;
    @JvmField
    @NotNull
    public static final Name REM_ASSIGN;
    @JvmField
    @NotNull
    public static final Name PLUS_ASSIGN;
    @JvmField
    @NotNull
    public static final Name MINUS_ASSIGN;
    @JvmField
    @NotNull
    public static final Set<Name> UNARY_OPERATION_NAMES;
    @JvmField
    @NotNull
    public static final Set<Name> SIMPLE_UNARY_OPERATION_NAMES;
    @JvmField
    @NotNull
    public static final Set<Name> BINARY_OPERATION_NAMES;
    @JvmField
    @NotNull
    public static final Set<Name> ASSIGNMENT_OPERATIONS;
    public static final OperatorNameConventions INSTANCE;

    private OperatorNameConventions() {
        INSTANCE = this;
        GET_VALUE = Name.identifier("getValue");
        SET_VALUE = Name.identifier("setValue");
        PROVIDE_DELEGATE = Name.identifier("provideDelegate");
        EQUALS = Name.identifier("equals");
        COMPARE_TO = Name.identifier("compareTo");
        CONTAINS = Name.identifier("contains");
        INVOKE = Name.identifier("invoke");
        ITERATOR = Name.identifier("iterator");
        GET = Name.identifier("get");
        SET = Name.identifier("set");
        NEXT = Name.identifier("next");
        HAS_NEXT = Name.identifier("hasNext");
        COMPONENT_REGEX = new Regex("component\\d+");
        AND = Name.identifier("and");
        OR = Name.identifier("or");
        INC = Name.identifier("inc");
        DEC = Name.identifier("dec");
        PLUS = Name.identifier("plus");
        MINUS = Name.identifier("minus");
        NOT = Name.identifier("not");
        UNARY_MINUS = Name.identifier("unaryMinus");
        UNARY_PLUS = Name.identifier("unaryPlus");
        TIMES = Name.identifier("times");
        DIV = Name.identifier("div");
        MOD = Name.identifier("mod");
        REM = Name.identifier("rem");
        RANGE_TO = Name.identifier("rangeTo");
        TIMES_ASSIGN = Name.identifier("timesAssign");
        DIV_ASSIGN = Name.identifier("divAssign");
        MOD_ASSIGN = Name.identifier("modAssign");
        REM_ASSIGN = Name.identifier("remAssign");
        PLUS_ASSIGN = Name.identifier("plusAssign");
        MINUS_ASSIGN = Name.identifier("minusAssign");
        UNARY_OPERATION_NAMES = SetsKt.setOf(new Name[]{INC, DEC, UNARY_PLUS, UNARY_MINUS, NOT});
        SIMPLE_UNARY_OPERATION_NAMES = SetsKt.setOf(new Name[]{UNARY_PLUS, UNARY_MINUS, NOT});
        BINARY_OPERATION_NAMES = SetsKt.setOf(new Name[]{TIMES, PLUS, MINUS, DIV, MOD, REM, RANGE_TO});
        ASSIGNMENT_OPERATIONS = SetsKt.setOf(new Name[]{TIMES_ASSIGN, DIV_ASSIGN, MOD_ASSIGN, REM_ASSIGN, PLUS_ASSIGN, MINUS_ASSIGN});
    }

    static {
        new OperatorNameConventions();
    }
}

