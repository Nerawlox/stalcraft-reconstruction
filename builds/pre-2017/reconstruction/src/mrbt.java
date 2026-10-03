/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.GuiScreenAdvanced;
import gloomyfolken.mods.core.client.gui.engine.IActionHandler;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.action.GuiAction;
import gloomyfolken.mods.core.client.gui.engine.action.GuiActionButtonClick;
import gloomyfolken.mods.core.client.gui.engine.component.McButton;
import gloomyfolken.mods.core.client.gui.engine.component.McLabel;
import gloomyfolken.mods.core.client.gui.engine.component.McNumberField;
import java.awt.Desktop;
import java.net.URL;
import net.minecraft.client.gui.GuiScreen;

public class mrbt
extends GuiScreenAdvanced {
    public mrbt(GuiScreen guiScreen) {
        super(GuiHelper.widgetsRenderer, 300, 180, guiScreen);
    }

    @Override
    public void initGui() {
        GuiHelper.addBackground(this, this.guiLeft, this.guiTop, this.guiWidth, this.guiHeight, true);
        McLabel mcLabel = new McLabel((IAdvancedGui)this, "\u0423\u043a\u0430\u0436\u0438\u0442\u0435 \u0441\u0443\u043c\u043c\u0443:", 0, 0);
        mcLabel.setCentered(this.guiLeft + this.guiWidth / 2, this.guiTop + 26);
        this.addElement(mcLabel);
        final McNumberField mcNumberField = new McNumberField(this, new Point(this.guiLeft + this.guiWidth / 2 - 75, this.guiTop + 50), new Dimension(150, 32));
        mcNumberField.setMinValue(0L);
        mcNumberField.setMaxValue(1000000L);
        this.addElement(mcNumberField);
        this.addElement(new McLabel((IAdvancedGui)this, "\u0440\u0443\u0431.", this.guiLeft + this.guiWidth / 2 + 75 + 10, this.guiTop + 55));
        McButton mcButton = GuiHelper.addButton(this, this.guiLeft + this.guiWidth / 2 - 110, this.guiTop + 110, 220, 40, "\u041f\u043e\u043f\u043e\u043b\u043d\u0438\u0442\u044c \u0447\u0435\u0440\u0435\u0437 UnitPay");
        this.actionManager.registerActionHandler(mcButton, GuiActionButtonClick.class, new IActionHandler(){

            public void processAction(GuiAction guiAction) {
                try {
                    String string = "STALCRAFT";
                    String string2 = mrbt.this.mc._t.username;
                    long l = mcNumberField.getValue();
                    String string3 = String.format("https://unitpay.ru/pay/18923-78fab/qiwi?desc=%s&account=%s&sum=%d", string, string2, l);
                    Desktop.getDesktop().browse(new URL(string3).toURI());
                }
                catch (Throwable throwable) {
                    // empty catch block
                }
            }
        });
    }
}

