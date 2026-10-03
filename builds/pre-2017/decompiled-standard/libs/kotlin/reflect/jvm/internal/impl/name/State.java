/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.name;

final class State
extends Enum<State> {
    public static final /* enum */ State BEGINNING;
    public static final /* enum */ State MIDDLE;
    public static final /* enum */ State AFTER_DOT;
    private static final /* synthetic */ State[] $VALUES;

    static {
        State[] stateArray = new State[3];
        State[] stateArray2 = stateArray;
        stateArray[0] = BEGINNING = new State();
        stateArray[1] = MIDDLE = new State();
        stateArray[2] = AFTER_DOT = new State();
        $VALUES = stateArray;
    }

    public static State[] values() {
        return (State[])$VALUES.clone();
    }

    public static State valueOf(String string) {
        return Enum.valueOf(State.class, string);
    }
}

