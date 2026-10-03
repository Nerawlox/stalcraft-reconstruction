/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.mc.haddon.implem;

import eu.ha3.mc.haddon.Identity;

public class HaddonIdentity
implements Identity {
    protected final String NAME;
    protected final int VERSION;
    protected final String FOR;
    protected final String ADDRESS;

    public HaddonIdentity(String string, int n, String string2, String string3) {
        this.NAME = string;
        this.VERSION = n;
        this.FOR = string2;
        this.ADDRESS = string3;
    }

    @Override
    public String getHaddonName() {
        return this.NAME;
    }

    @Override
    public int getHaddonVersionNumber() {
        return this.VERSION;
    }

    @Override
    public String getHaddonMinecraftVersion() {
        return this.FOR;
    }

    @Override
    public String getHaddonAddress() {
        return this.ADDRESS;
    }

    @Override
    public String getHaddonHumanVersion() {
        return "r" + this.getHaddonVersionNumber() + " for " + this.getHaddonMinecraftVersion();
    }
}

