/*
 * Decompiled with CFR 0.152.
 */
package net.smart.moving;

import java.io.PrintStream;
import net.smart.moving.ClimbGap;

public class HandsClimbing {
    public static final int MiddleGrab = 2;
    public static final int UpGrab = 1;
    public static final int NoGrab = 0;
    public static HandsClimbing None = new HandsClimbing(-3);
    public static HandsClimbing Sink = new HandsClimbing(-2);
    public static HandsClimbing TopHold = new HandsClimbing(-1);
    public static HandsClimbing BottomHold = new HandsClimbing(0);
    public static HandsClimbing Up = new HandsClimbing(1);
    public static HandsClimbing FastUp = new HandsClimbing(2);
    private int _value;

    private HandsClimbing(int n) {
        this._value = n;
    }

    public boolean IsRelevant() {
        return this._value > HandsClimbing.None._value;
    }

    public boolean IsUp() {
        return this == Up || this == FastUp;
    }

    public HandsClimbing ToUp() {
        return this == BottomHold ? Up : this;
    }

    public HandsClimbing ToDown() {
        return this == TopHold ? Sink : this;
    }

    public HandsClimbing max(HandsClimbing handsClimbing, ClimbGap climbGap, ClimbGap climbGap2) {
        if (!climbGap2.SkipGaps) {
            climbGap.CanStand |= climbGap2.CanStand;
            climbGap.MustCrawl |= climbGap2.MustCrawl;
        }
        if (this._value < handsClimbing._value) {
            climbGap.BlockId = climbGap2.BlockId;
            climbGap.Meta = climbGap2.Meta;
            climbGap.Direction = climbGap2.Direction;
        }
        return HandsClimbing.get(Math.max(this._value, handsClimbing._value));
    }

    public String toString() {
        return this._value <= HandsClimbing.None._value ? "None" : (this._value == HandsClimbing.Sink._value ? "Sink" : (this._value == HandsClimbing.BottomHold._value ? "BottomHold" : (this._value == HandsClimbing.TopHold._value ? "TopHold" : (this._value == HandsClimbing.Up._value ? "Up" : "FastUp"))));
    }

    public void print(String string) {
        PrintStream printStream = System.err;
        if (string != null) {
            printStream.print(string + " = ");
        }
        printStream.println(this);
    }

    private static HandsClimbing get(int n) {
        return n <= HandsClimbing.None._value ? None : (n == HandsClimbing.Sink._value ? Sink : (n == HandsClimbing.BottomHold._value ? BottomHold : (n == HandsClimbing.TopHold._value ? TopHold : (n == HandsClimbing.Up._value ? Up : FastUp))));
    }
}

