/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.ReflectionHelper
 */
package ru.stalcraft;

import cpw.mods.fml.relauncher.ReflectionHelper;

public class Util {
    public static <T, E> void setPrivateValue(Class<? super T> par1, T par2, E par3, String ... par4) {
        try {
            ReflectionHelper.setPrivateValue(par1, par2, par3, (String[])par4);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }
}

