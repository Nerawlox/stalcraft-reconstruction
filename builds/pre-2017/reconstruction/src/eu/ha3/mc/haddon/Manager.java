/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.mc.haddon;

import eu.ha3.mc.haddon.Utility;
import net.minecraft.client.settings.KeyBinding;

public interface Manager {
    public Utility getUtility();

    public void addKeyBinding(KeyBinding var1, String var2);
}

