/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.client;

import com.google.common.collect.Lists;
import com.google.common.collect.MapDifference;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.registry.ItemData;
import java.util.List;
import java.util.Map;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiYesNo;

public class GuiIdMismatchScreen
extends GuiYesNo {
    private List<String> missingIds = Lists.newArrayList();
    private List<String> mismatchedIds = Lists.newArrayList();
    private boolean allowContinue;

    public GuiIdMismatchScreen(MapDifference<Integer, ItemData> mapDifference, boolean bl) {
        super(null, "ID mismatch", "Should I continue?", 1);
        this.parentScreen = this;
        for (Map.Entry<Integer, ItemData> entry : mapDifference.entriesOnlyOnLeft().entrySet()) {
            this.missingIds.add(String.format("ID %d from Mod %s is missing", entry.getValue().getItemId(), entry.getValue().getModId(), entry.getValue().getItemType()));
        }
        for (Map.Entry<Integer, Object> entry : mapDifference.entriesDiffering().entrySet()) {
            ItemData itemData = (ItemData)((MapDifference.ValueDifference)entry.getValue()).leftValue();
            ItemData itemData2 = (ItemData)((MapDifference.ValueDifference)entry.getValue()).rightValue();
            this.mismatchedIds.add(String.format("ID %d is mismatched between world and game", itemData.getItemId()));
        }
        this.allowContinue = bl;
    }

    @Override
    public void confirmClicked(boolean bl, int n) {
        FMLClientHandler.instance().callbackIdDifferenceResponse(bl);
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this.drawDefaultBackground();
        if (!this.allowContinue && this.buttonList.size() == 2) {
            this.buttonList.remove(0);
        }
        int n3 = Math.max(85 - (this.missingIds.size() + this.mismatchedIds.size()) * 10, 30);
        this.drawCenteredString(this.fontRenderer, "Forge Mod Loader has found ID mismatches", this.width / 2, 10, 0xFFFFFF);
        this.drawCenteredString(this.fontRenderer, "Complete details are in the log file", this.width / 2, 20, 0xFFFFFF);
        int n4 = 20;
        for (String object : this.missingIds) {
            this.drawCenteredString(this.fontRenderer, object, this.width / 2, n3, 0xEEEEEE);
            if (--n4 >= 0 && (n3 += 10) < this.height - 30) continue;
            break;
        }
        if (n4 > 0 && n3 < this.height - 30) {
            for (String string : this.mismatchedIds) {
                this.drawCenteredString(this.fontRenderer, string, this.width / 2, n3, 0xEEEEEE);
                if (--n4 >= 0 && (n3 += 10) < this.height - 30) continue;
                break;
            }
        }
        if (this.allowContinue) {
            this.drawCenteredString(this.fontRenderer, "Do you wish to continue loading?", this.width / 2, this.height - 30, 0xFFFFFF);
        } else {
            this.drawCenteredString(this.fontRenderer, "You cannot connect to this server", this.width / 2, this.height - 30, 0xFFFFFF);
        }
        for (int i = 0; i < this.buttonList.size(); ++i) {
            GuiButton guiButton = (GuiButton)this.buttonList.get(i);
            guiButton.yPosition = this.height - 20;
            if (!this.allowContinue) {
                guiButton.xPosition = this.width / 2 - 75;
                guiButton.displayString = wpcz._a("gui.done");
            }
            guiButton.drawButton(this.mc, n, n2);
        }
    }
}

