/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.mc.haddon.implem;

import eu.ha3.mc.haddon.Identity;
import eu.ha3.mc.haddon.implem.HaddonIdentity;
import eu.ha3.mc.haddon.implem.HaddonImpl;

public class DisabledHaddon
extends HaddonImpl {
    private final String _name;
    private final Identity identity;

    public DisabledHaddon() {
        StackTraceElement[] stackTraceElementArray = Thread.currentThread().getStackTrace();
        this._name = stackTraceElementArray.length > 0 ? stackTraceElementArray[stackTraceElementArray.length - 1].getClassName() + " " + stackTraceElementArray[stackTraceElementArray.length - 1].getMethodName() : "DisabledHaddon";
        this.identity = new HaddonIdentity(this._name, 0, "0.0.0", "http://example.org");
    }

    @Override
    public void onLoad() {
    }

    @Override
    public Identity getIdentity() {
        return this.identity;
    }
}

