/*
 * Decompiled with CFR 0.152.
 */
package net.smart.moving;

import java.io.PrintStream;
import net.smart.moving.ClimbGap;

public class FeetClimbing {
    public static final int DownStep = 1;
    public static final int NoStep = 0;
    public static FeetClimbing None = new FeetClimbing(-3);
    public static FeetClimbing BaseHold = new FeetClimbing(-2);
    public static FeetClimbing BaseWithHands = new FeetClimbing(-1);
    public static FeetClimbing TopWithHands = new FeetClimbing(0);
    public static FeetClimbing SlowUpWithHoldWithoutHands = new FeetClimbing(1);
    public static FeetClimbing SlowUpWithSinkWithoutHands = new FeetClimbing(2);
    public static FeetClimbing FastUp = new FeetClimbing(3);
    private int _value;

    private FeetClimbing(int n) {
        this._value = n;
    }

    public boolean IsRelevant() {
        return this._value > FeetClimbing.None._value;
    }

    public boolean IsIndependentlyRelevant() {
        return this._value > FeetClimbing.BaseWithHands._value;
    }

    public boolean IsUp() {
        return this == SlowUpWithHoldWithoutHands || this == SlowUpWithSinkWithoutHands || this == FastUp;
    }

    public FeetClimbing max(FeetClimbing feetClimbing, ClimbGap climbGap, ClimbGap climbGap2) {
        if (!climbGap2.SkipGaps) {
            climbGap.CanStand |= climbGap2.CanStand;
            climbGap.MustCrawl |= climbGap2.MustCrawl;
        }
        if (this._value < feetClimbing._value) {
            climbGap.BlockId = climbGap2.BlockId;
            climbGap.Meta = climbGap2.Meta;
            climbGap.Direction = climbGap2.Direction;
        }
        return FeetClimbing.get(Math.max(this._value, feetClimbing._value));
    }

    public String toString() {
        return this._value <= FeetClimbing.None._value ? "None" : (this._value == FeetClimbing.BaseHold._value ? "BaseHold" : (this._value == FeetClimbing.BaseWithHands._value ? "BaseWithHands" : (this._value == FeetClimbing.TopWithHands._value ? "TopWithHands" : (this._value == FeetClimbing.SlowUpWithHoldWithoutHands._value ? "SlowUpWithHoldWithoutHands" : (this._value == FeetClimbing.SlowUpWithSinkWithoutHands._value ? "SlowUpWithSinkWithoutHands" : "FastUp")))));
    }

    public void print(String string) {
        PrintStream printStream = System.err;
        if (string != null) {
            printStream.print(string + " = ");
        }
        printStream.println(this);
    }

    private static FeetClimbing get(int n) {
        return n <= FeetClimbing.None._value ? None : (n == FeetClimbing.BaseHold._value ? BaseHold : (n == FeetClimbing.BaseWithHands._value ? BaseWithHands : (n == FeetClimbing.TopWithHands._value ? TopWithHands : (n == FeetClimbing.SlowUpWithHoldWithoutHands._value ? SlowUpWithHoldWithoutHands : (n == FeetClimbing.SlowUpWithSinkWithoutHands._value ? SlowUpWithSinkWithoutHands : FastUp)))));
    }
}

