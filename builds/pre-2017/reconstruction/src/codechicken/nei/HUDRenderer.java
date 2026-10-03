/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import codechicken.core.gui.GuiDraw;
import codechicken.lib.config.ConfigTag;
import codechicken.nei.KeyManager;
import codechicken.nei.NEIClientConfig;
import codechicken.nei.api.ItemInfo;
import codechicken.nei.forge.GuiContainerManager;
import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumMovingObjectType;
import org.lwjgl.opengl.GL11;

public class HUDRenderer
implements KeyManager.IKeyStateTracker {
    @Override
    public void tickKeyStates() {
        if (KeyManager.keyStates.get((Object)"world.highlight_tips").down) {
            ConfigTag configTag;
            configTag.setBooleanValue(!(configTag = NEIClientConfig.getSetting("world.highlight_tips")).getBooleanValue());
        }
    }

    public static void renderOverlay() {
        Minecraft minecraft = Minecraft._E();
        if (minecraft._B == null && minecraft._r != null && !minecraft._M.keyBindPlayerList._e && NEIClientConfig.getBooleanSetting("world.highlight_tips") && minecraft._L != null && minecraft._L._c == EnumMovingObjectType._a) {
            pkix pkix2 = minecraft._r;
            ArrayList<ItemStack> arrayList = ItemInfo.getIdentifierItems(pkix2, minecraft._t, minecraft._L);
            if (arrayList.isEmpty()) {
                return;
            }
            Collections.sort(arrayList, new Comparator<ItemStack>(){

                @Override
                public int compare(ItemStack itemStack, ItemStack itemStack2) {
                    return itemStack2._j() - itemStack._j();
                }
            });
            ItemStack itemStack = arrayList.get(0);
            HUDRenderer.renderOverlay(itemStack, ItemInfo.getText(itemStack, pkix2, minecraft._t, minecraft._L), HUDRenderer.getPositioning());
        }
    }

    public static void renderOverlay(ItemStack itemStack, List<String> list, Point point) {
        int n = 0;
        for (String object2 : list) {
            n = Math.max(n, GuiDraw.getStringWidth(object2) + 29);
        }
        int n2 = Math.max(24, 10 + 10 * list.size());
        Dimension dimension = GuiDraw.displaySize();
        int n3 = (dimension.width - n - 1) * point.x / 10000;
        int n4 = (dimension.height - n2 - 1) * point.y / 10000;
        GL11.glDisable(32826);
        qnon._a();
        GL11.glDisable(2896);
        GL11.glDisable(2929);
        GuiDraw.drawTooltipBox(n3, n4, n, n2);
        int n5 = (n2 - 8 * list.size()) / 2;
        for (int i = 0; i < list.size(); ++i) {
            GuiDraw.drawString(list.get(i), n3 + 24, n4 + n5 + 10 * i, -6250336, true);
        }
        qnon._c();
        GL11.glEnable(32826);
        if (itemStack._a() != null) {
            GuiContainerManager.drawItem(n3 + 5, n4 + n2 / 2 - 8, itemStack);
        }
    }

    private static Point getPositioning() {
        return new Point(NEIClientConfig.getSetting("world.highlight_tips.x").getIntValue(), NEIClientConfig.getSetting("world.highlight_tips.y").getIntValue());
    }

    public static void load() {
        KeyManager.trackers.add(new HUDRenderer());
    }
}

