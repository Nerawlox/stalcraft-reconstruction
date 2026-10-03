/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.client;

import cpw.mods.fml.common.IFMLHandledException;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(value=Side.CLIENT)
public abstract class CustomModLoadingErrorDisplayException
extends RuntimeException
implements IFMLHandledException {
    public abstract void initGui(hchw var1, qncw var2);

    public abstract void drawScreen(hchw var1, qncw var2, int var3, int var4, float var5);
}

