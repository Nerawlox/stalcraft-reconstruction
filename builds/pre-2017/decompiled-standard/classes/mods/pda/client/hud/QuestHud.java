/*
 * Decompiled with CFR 0.152.
 */
package mods.pda.client.hud;

import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.font.ExternalFont;
import gloomyfolken.mods.stalker.misc.tupg;
import java.util.Collection;
import mods.pda.MapNpc;
import mods.pda.PdaMod;
import mods.pda.client.PdaClient;
import net.minecraft.client.xpzm;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.ForgeSubscribe;
import noppes.npcs.QuestLogUnit;
import org.lwjgl.opengl.GL11;

public class QuestHud {
    private static Point supplierUv;

    @ForgeSubscribe
    public void onRenderTick(RenderGameOverlayEvent.Post post) {
        if (post.type != RenderGameOverlayEvent.ElementType.ALL) {
            return;
        }
        Collection<QuestLogUnit> collection = PdaMod.getClientPda().questState.values();
        xpzm xpzm2 = xpzm._E();
        boolean bl = !PdaClient.invertedHud.enabled;
        Point point = new Point(bl ? xpzm2._n - 40 : 40, 295);
        int n = 0;
        n += this.drawQuestStatus(collection, bl, point, n);
        this.drawTradepackTask(xpzm2, bl, point, n += 10);
    }

    private int drawQuestStatus(Collection<QuestLogUnit> collection, boolean bl, Point point, int n) {
        for (QuestLogUnit questLogUnit : collection) {
            if (questLogUnit == null || questLogUnit.getQuestId() != PdaMod.instance.quests.getActiveQuest()) continue;
            String string = questLogUnit.getQuestTitle();
            int n2 = bl ? point.x - ExternalFont.tahoma14.getStringWidth(string) * 2 : point.x;
            int n3 = PdaMod.getClientPda().primaryQuests.contains(questLogUnit.getQuestId()) ? 0xFFFF00 : 0x50FF50;
            ExternalFont.tahoma14.renderString(string, n2 / 2, (point.y + n) / 2, n3, true);
            n += 25;
            for (String string2 : questLogUnit.getLocalizedStatuses()) {
                int n4 = bl ? point.x - ExternalFont.tahoma12.getStringWidth(string2) * 2 : point.x;
                ExternalFont.tahoma12.renderString(string2, n4 / 2, (point.y + n) / 2, -1, true);
                n += 20;
            }
        }
        return n;
    }

    private void drawTradepackTask(xpzm xpzm2, boolean bl, Point point, int n) {
        tupg tupg2 = tupg._a(xpzm2._t);
        cvzo cvzo2 = tupg2._c._e();
        if (cvzo2 != null && cvzo2._a() instanceof pjnz && cvzo2._q() != null && cvzo2._q()._c("TradeData")) {
            String string = "\u0414\u043e\u0441\u0442\u0430\u0432\u044c\u0442\u0435 \u043f\u043e\u0441\u044b\u043b\u043a\u0443";
            int n2 = ExternalFont.tahoma14.getStringWidth(string);
            int n3 = bl ? point.x - n2 * 2 : point.x;
            ExternalFont.tahoma14.renderString(string, n3 / 2, (point.y + n) / 2, -27904, true);
            int n4 = bl ? n3 - 23 : n3 + n2 * 2 + 5;
            GL11.glEnable(3042);
            GL11.glColor4f(1.0f, 0.5764706f, 0.0f, 1.0f);
            xpzm._E()._R()._a(MapNpc.ICON_RES);
            Point point2 = supplierUv;
            qozx._a(n4 / 2, (point.y + n + 4) / 2, 9.5, 9.5, point2.x, point2.y, point2.x + 19, point2.y + 19, 128.0, 128.0);
        }
    }

    static {
        Point point = PdaClient.NPC_ICONS_POS.get("trader");
        supplierUv = new Point(point.x * 19, point.y * 19);
    }
}

