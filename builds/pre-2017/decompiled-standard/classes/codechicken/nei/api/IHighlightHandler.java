/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei.api;

import codechicken.nei.api.ItemInfo;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.hank;

public interface IHighlightHandler {
    public cvzo identifyHighlight(ozlu var1, EntityPlayer var2, hank var3);

    public List<String> handleTextData(cvzo var1, ozlu var2, EntityPlayer var3, hank var4, List<String> var5, ItemInfo.Layout var6);
}

