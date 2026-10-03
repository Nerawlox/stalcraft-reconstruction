/*
 * Decompiled with CFR 0.152.
 */
package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c3\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2={"Lkotlin/text/ScreenFloatValueRegEx;", "", "()V", "value", "Lkotlin/text/Regex;", "kotlin-stdlib"})
final class ScreenFloatValueRegEx {
    @JvmField
    @NotNull
    public static final Regex value;
    public static final ScreenFloatValueRegEx INSTANCE;

    private ScreenFloatValueRegEx() {
        ScreenFloatValueRegEx screenFloatValueRegEx;
        INSTANCE = this;
        ScreenFloatValueRegEx $receiver = screenFloatValueRegEx = this;
        String Digits = "(\\p{Digit}+)";
        String HexDigits = "(\\p{XDigit}+)";
        String Exp = "[eE][+-]?" + Digits;
        String HexString = "(0[xX]" + HexDigits + "(" + "\\" + ".)?)|" + ("(0[xX]" + HexDigits + "?(" + "\\" + ".)" + HexDigits + ")");
        String Number2 = "(" + Digits + "(" + "\\" + ".)?(" + Digits + "?)(" + Exp + ")?)|" + ("(" + "\\" + ".(" + Digits + ")(" + Exp + ")?)|") + ("((" + HexString + ")[pP][+-]?" + Digits + ")");
        String fpRegex = "[" + "\\" + "x00-" + "\\" + "x20]*[+-]?(NaN|Infinity|((" + Number2 + ")[fFdD]?))[" + "\\" + "x00-" + "\\" + "x20]*";
        value = new Regex(fpRegex);
    }

    static {
        new ScreenFloatValueRegEx();
    }
}

