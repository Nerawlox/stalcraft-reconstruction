/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.mc.haddon;

import eu.ha3.mc.haddon.PrivateAccessException;
import java.io.File;

public interface Utility {
    public void registerPrivateGetter(String var1, Class var2, int var3, String ... var4);

    public void registerPrivateSetter(String var1, Class var2, int var3, String ... var4);

    public Object getPrivate(Object var1, String var2) throws PrivateAccessException;

    public void setPrivate(Object var1, String var2, Object var3) throws PrivateAccessException;

    @Deprecated
    public Object getPrivateValue(Class var1, Object var2, int var3) throws PrivateAccessException;

    @Deprecated
    public void setPrivateValue(Class var1, Object var2, int var3, Object var4) throws PrivateAccessException;

    @Deprecated
    public Object getPrivateValueLiteral(Class var1, Object var2, String var3, int var4) throws PrivateAccessException;

    @Deprecated
    public void setPrivateValueLiteral(Class var1, Object var2, String var3, int var4, Object var5) throws PrivateAccessException;

    public int getWorldHeight();

    public File getModsFolder();

    public Object getCurrentScreen();

    public boolean isCurrentScreen(Class var1);

    public void closeCurrentScreen();

    public long getClientTick();

    public void printChat(Object ... var1);

    public boolean areKeysDown(int ... var1);

    public void prepareDrawString();

    public void drawString(String var1, float var2, float var3, int var4, int var5, char var6, int var7, int var8, int var9, int var10, boolean var11);
}

