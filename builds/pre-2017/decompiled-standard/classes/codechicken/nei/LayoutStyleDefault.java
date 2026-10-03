/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import codechicken.core.gui.GuiDraw;
import codechicken.nei.Button;
import codechicken.nei.LayoutManager;
import codechicken.nei.NEIActions;
import codechicken.nei.NEIClientConfig;
import codechicken.nei.NEIClientUtils;
import codechicken.nei.NEIController;
import codechicken.nei.VisiblityData;
import codechicken.nei.api.LayoutStyle;

public abstract class LayoutStyleDefault
extends LayoutStyle {
    @Override
    public void layout(zybc zybc2, VisiblityData visiblityData) {
        int n;
        int n2;
        int n3 = zybc2.field_73880_f;
        int n4 = zybc2.field_73881_g;
        int n5 = zybc2.field_74194_b;
        int n6 = zybc2.field_74198_m;
        this.reset();
        LayoutManager.prev.y = 2;
        LayoutManager.prev.height = 16;
        LayoutManager.prev.width = n6 / 3;
        LayoutManager.prev.x = (n5 + n3) / 2 + 2;
        LayoutManager.next.x = n3 - LayoutManager.prev.width - 2;
        LayoutManager.next.y = LayoutManager.prev.y;
        LayoutManager.next.width = LayoutManager.prev.width;
        LayoutManager.next.height = LayoutManager.prev.height;
        LayoutManager.pageLabel.x = n6 * 3 / 2 + n5 + 1;
        LayoutManager.pageLabel.y = LayoutManager.prev.y + 5;
        LayoutManager.pageLabel.text = "(" + LayoutManager.itemPanel.getPage() + "/" + LayoutManager.itemPanel.getNumPages() + ")";
        LayoutManager.itemPanel.y = LayoutManager.prev.height + LayoutManager.prev.y;
        LayoutManager.itemPanel.x = (n5 + n3) / 2 + 3;
        LayoutManager.itemPanel.width = n3 - 3 - LayoutManager.itemPanel.x;
        LayoutManager.itemPanel.height = n4 - 15 - LayoutManager.itemPanel.y;
        if (!NEIClientConfig.canPerformAction("item")) {
            LayoutManager.itemPanel.height += 15;
        }
        LayoutManager.itemPanel.resize();
        LayoutManager.less.height = 16;
        LayoutManager.less.width = 16;
        LayoutManager.more.height = 16;
        LayoutManager.more.width = 16;
        LayoutManager.less.x = LayoutManager.prev.x;
        LayoutManager.more.x = n3 - LayoutManager.less.width - 2;
        LayoutManager.more.y = LayoutManager.less.y = n4 - LayoutManager.more.height - 2;
        LayoutManager.quantity.x = LayoutManager.less.x + LayoutManager.less.width + 2;
        LayoutManager.quantity.y = LayoutManager.less.y;
        LayoutManager.quantity.width = LayoutManager.more.x - LayoutManager.quantity.x - 2;
        LayoutManager.quantity.height = LayoutManager.less.height;
        LayoutManager.options.x = NEIClientConfig.isEnabled() ? 0 : 6;
        LayoutManager.options.y = NEIClientConfig.isEnabled() ? n4 - 22 : n4 - 28;
        LayoutManager.options.width = 80;
        LayoutManager.options.height = 22;
        LayoutManager.delete.state = 4;
        if (NEIController.deleteMode) {
            LayoutManager.delete.state |= 1;
        } else if (!visiblityData.enableDeleteMode) {
            LayoutManager.delete.state |= 2;
        }
        LayoutManager.rain.state = 4;
        if (NEIClientConfig.disabledActions.contains("rain")) {
            LayoutManager.rain.state |= 2;
        } else if (NEIClientUtils.isRaining()) {
            LayoutManager.rain.state |= 1;
        }
        LayoutManager.gamemode.state = 4;
        if (NEIClientUtils.getGamemode() != 0) {
            LayoutManager.gamemode.state |= 1;
            LayoutManager.gamemode.index = NEIClientUtils.getGamemode() - 1;
        } else if (NEIClientUtils.isValidGamemode("creative")) {
            LayoutManager.gamemode.index = 0;
        } else if (NEIClientUtils.isValidGamemode("creative+")) {
            LayoutManager.gamemode.index = 1;
        } else if (NEIClientUtils.isValidGamemode("adventure")) {
            LayoutManager.gamemode.index = 2;
        }
        LayoutManager.magnet.state = 4 | (NEIClientConfig.getMagnetMode() ? 1 : 0);
        if (NEIClientConfig.canPerformAction("delete")) {
            this.layoutButton(LayoutManager.delete);
        }
        if (NEIClientConfig.canPerformAction("rain")) {
            this.layoutButton(LayoutManager.rain);
        }
        if (NEIClientUtils.isValidGamemode("creative") || NEIClientUtils.isValidGamemode("creative+") || NEIClientUtils.isValidGamemode("adventure")) {
            this.layoutButton(LayoutManager.gamemode);
        }
        if (NEIClientConfig.canPerformAction("magnet")) {
            this.layoutButton(LayoutManager.magnet);
        }
        if (NEIClientConfig.canPerformAction("time")) {
            for (n2 = 0; n2 < 4; ++n2) {
                LayoutManager.timeButtons[n2].state = NEIClientConfig.disabledActions.contains(NEIActions.timeZones[n2]) ? 2 : 0;
                this.layoutButton(LayoutManager.timeButtons[n2]);
            }
        }
        if (NEIClientConfig.canPerformAction("heal")) {
            this.layoutButton(LayoutManager.heal);
        }
        LayoutManager.searchField.y = n4 - LayoutManager.searchField.height - 2;
        LayoutManager.dropDown.height = 20;
        LayoutManager.dropDown.width = LayoutManager.prev.x - LayoutManager.dropDown.x - 3;
        LayoutManager.searchField.height = 20;
        LayoutManager.searchField.width = 150;
        LayoutManager.searchField.x = (n3 - LayoutManager.searchField.width) / 2;
        if (!visiblityData.showItemSection) {
            LayoutManager.dropDown.setDropDown(0);
            LayoutManager.searchField.setFocus(false);
        }
        n2 = 0;
        for (n = 0; n < 7; ++n) {
            LayoutManager.deleteButtons[n].width = 16;
            LayoutManager.deleteButtons[n].height = 16;
            qoac qoac2 = NEIClientConfig.global.nbt._m("statename");
            NEIClientConfig.global.nbt._a("statename", (huhy)qoac2);
            String string = qoac2._j("" + n);
            if (qoac2._b("" + n) == null) {
                string = "" + (n + 1);
                qoac2._a("" + n, string);
            }
            LayoutManager.stateButtons[n].label = string;
            LayoutManager.stateButtons[n].saved = NEIClientConfig.isStateSaved(n);
            int n7 = GuiDraw.getStringWidth(LayoutManager.stateButtons[n].getRenderLabel()) + 26;
            if (n7 + 22 > n6) {
                n7 = n6 - 22;
            }
            if (n7 <= n2) continue;
            n2 = n7;
        }
        for (n = 0; n < 7; ++n) {
            LayoutManager.stateButtons[n].x = 0;
            LayoutManager.stateButtons[n].y = 58 + n * 22;
            LayoutManager.stateButtons[n].height = 20;
            LayoutManager.stateButtons[n].x = 0;
            LayoutManager.stateButtons[n].width = n2;
            LayoutManager.deleteButtons[n].x = LayoutManager.stateButtons[n].width + 3;
            LayoutManager.deleteButtons[n].y = LayoutManager.stateButtons[n].y + 2;
        }
    }

    public abstract void layoutButton(Button var1);
}

