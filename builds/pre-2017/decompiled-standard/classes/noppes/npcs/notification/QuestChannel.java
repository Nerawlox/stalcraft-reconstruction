/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.notification;

import gloomyfolken.mods.core.client.gui.engine.Point;
import mods.pda.client.screens.GuiPda;
import noppes.npcs.client.pda.PdaQuests;

public class QuestChannel
extends iuww {
    public QuestChannel() {
        super("\u0417\u0430\u0434\u0430\u0447\u0438", "quests");
    }

    @Override
    public String getInfoText(bqdo bqdo2) {
        switch (bqdo2._d()._j("type")) {
            case "new": {
                return String.format("\u041d\u043e\u0432\u043e\u0435 \u0437\u0430\u0434\u0430\u043d\u0438\u0435 - \"%s\"", bqdo2._d()._j("QuestTitle"));
            }
            case "mail_reward": {
                return "\u041d\u0430\u0433\u0440\u0430\u0434\u0430 \u0437\u0430 \u0437\u0430\u0434\u0430\u043d\u0438\u0435 \"" + bqdo2._d()._j("QuestTitle") + "\" \u043e\u0436\u0438\u0434\u0430\u0435\u0442 \u0432\u0430\u0441 \u0443 \u043a\u0443\u0440\u044c\u0435\u0440\u0430";
            }
        }
        return null;
    }

    @Override
    public Point getIcon(bqdo bqdo2) {
        String string = bqdo2._d()._j("type");
        return string.equals("mail_reward") ? new Point(144, 0) : Point.zeroPoint;
    }

    @Override
    public iuww.kjui getViewType(bqdo bqdo2) {
        return bqdo2._d()._j("type").equals("mail_reward") ? iuww.kjui._c : iuww.kjui._b;
    }

    @Override
    public void onAction(bqdo bqdo2, boolean bl) {
        GuiPda.openPda("quests", guiPda -> new PdaQuests((GuiPda)guiPda, 0, bqdo2._d()._f("QuestId")));
    }
}

