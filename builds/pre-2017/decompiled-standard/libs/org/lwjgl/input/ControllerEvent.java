/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.input;

import org.lwjgl.input.Controller;

class ControllerEvent {
    public static final int BUTTON = 1;
    public static final int AXIS = 2;
    public static final int POVX = 3;
    public static final int POVY = 4;
    private Controller source;
    private int index;
    private int type;
    private boolean xaxis;
    private boolean yaxis;
    private long timeStamp;

    ControllerEvent(Controller source, long timeStamp, int type2, int index, boolean xaxis, boolean yaxis) {
        this.source = source;
        this.timeStamp = timeStamp;
        this.type = type2;
        this.index = index;
        this.xaxis = xaxis;
        this.yaxis = yaxis;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public Controller getSource() {
        return this.source;
    }

    public int getControlIndex() {
        return this.index;
    }

    public boolean isButton() {
        return this.type == 1;
    }

    public boolean isAxis() {
        return this.type == 2;
    }

    public boolean isPovY() {
        return this.type == 4;
    }

    public boolean isPovX() {
        return this.type == 3;
    }

    public boolean isXAxis() {
        return this.xaxis;
    }

    public boolean isYAxis() {
        return this.yaxis;
    }

    public String toString() {
        return "[" + this.source + " type=" + this.type + " xaxis=" + this.xaxis + " yaxis=" + this.yaxis + "]";
    }
}

