/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.matmos.game.system;

import eu.ha3.mc.haddon.Haddon;

public class Chatter {
    private final Haddon mod;
    private final String prefix;

    public Chatter(Haddon haddon, String string) {
        this.mod = haddon;
        this.prefix = string;
    }

    public void printChat(Object ... objectArray) {
        this.printChat(new Object[]{"\u00a7f", this.prefix + ": "}, objectArray);
    }

    public void printChatShort(Object ... objectArray) {
        this.printChat(new Object[]{"\u00a7f", ""}, objectArray);
    }

    protected void printChat(Object[] objectArray, Object ... objectArray2) {
        Object[] objectArray3 = new Object[objectArray.length + objectArray2.length];
        System.arraycopy(objectArray, 0, objectArray3, 0, objectArray.length);
        System.arraycopy(objectArray2, 0, objectArray3, objectArray.length, objectArray2.length);
        this.mod.getUtility().printChat(objectArray3);
    }
}

