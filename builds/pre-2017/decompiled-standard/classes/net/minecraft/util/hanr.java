/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(value=Side.CLIENT)
public class hanr {
    public final String _a;
    public final String _b;

    public hanr(String string, String string2) {
        if (string == null || string.isEmpty()) {
            string = "MissingName";
            string2 = "NotValid";
            System.out.println("=========================================================");
            System.out.println("Warning the username was not set for this session, typically");
            System.out.println("this means you installed Forge incorrectly. We have set your");
            System.out.println("name to \"MissingName\" and your session to nothing. Please");
            System.out.println("check your instation and post a console log from the launcher");
            System.out.println("when asking for help!");
            System.out.println("=========================================================");
        }
        this._a = string;
        this._b = string2;
    }

    public String _a() {
        return this._a;
    }

    public String _b() {
        return this._b;
    }
}

