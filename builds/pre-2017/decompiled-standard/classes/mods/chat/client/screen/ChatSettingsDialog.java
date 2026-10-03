/*
 * Decompiled with CFR 0.152.
 */
package mods.chat.client.screen;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.action.GuiActionButtonClick;
import gloomyfolken.mods.core.client.gui.engine.component.McAbstractButton;
import gloomyfolken.mods.core.client.gui.engine.component.McButton;
import gloomyfolken.mods.core.client.gui.engine.component.McCheckBox;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import mods.chat.client.ChatHud;
import mods.chat.client.ChatSettings;
import mods.chat.client.screen.GuiChatActive;
import mods.pda.client.component.dialog.Dialog;
import net.minecraft.client.xpzm;

public class ChatSettingsDialog
extends Dialog {
    private ChatSettings.ChatGroup chatGroup;
    private Map<ugqi, McCheckBox> settings = new HashMap<ugqi, McCheckBox>();
    private Runnable onSubmit;

    public ChatSettingsDialog(IAdvancedGui iAdvancedGui, Point point, Dimension dimension) {
        super(iAdvancedGui, point, dimension);
        this.setTitle("\u041d\u0430\u0441\u0442\u0440\u043e\u0439\u043a\u0438 \u0447\u0430\u0442\u0430");
    }

    @Override
    protected void setupDialog() {
        McAbstractButton mcAbstractButton;
        Object object;
        List<ugqi> list = Arrays.asList(ugqi._c, ugqi._d, ugqi._f, ugqi._e, ugqi._g);
        Point point = new Point(10, this.getSize().height / 3);
        for (int i = 0; i < list.size(); ++i) {
            object = list.get(i);
            mcAbstractButton = this.add(new McCheckBox(this.parent, ((ugqi)((Object)object))._j, point.add(0, 20 * i), GuiChatActive.checkBox));
            this.settings.put((ugqi)((Object)object), (McCheckBox)mcAbstractButton);
        }
        McButton mcButton = this.add(new McButton(this.parent, new Point(10, this.getSize().height - 40), GuiChatActive.buttonStyle, "\u0413\u043e\u0442\u043e\u0432\u043e"));
        mcButton.setSize(new Dimension(100, 27));
        this.parent.getActionManager().registerActionHandler(mcButton, GuiActionButtonClick.class, guiActionButtonClick -> {
            this.submitSettings();
            this.setStatus(false);
        });
        object = this.add(new McButton(this.parent, new Point(120, this.getSize().height - 40), GuiChatActive.buttonStyle, "\u041e\u0442\u043c\u0435\u043d\u0430"));
        ((McAbstractButton)object).setSize(new Dimension(100, 27));
        this.parent.getActionManager().registerActionHandler(object, GuiActionButtonClick.class, guiActionButtonClick -> this.setStatus(false));
        mcAbstractButton = this.add(new McButton(this.parent, new Point(this.getSize().width - 150, this.getSize().height - 40), GuiChatActive.buttonStyle, "\u0421\u0431\u0440\u043e\u0441\u0438\u0442\u044c"));
        mcAbstractButton.setSize(new Dimension(100, 27));
        this.parent.getActionManager().registerActionHandler(mcAbstractButton, GuiActionButtonClick.class, guiActionButtonClick -> this.resetSettings());
    }

    @Override
    protected void drawBackground() {
        this.renderer.bindTexture(ChatHud.texture);
        this.renderer.drawTiledRect(this.getLocation(), new Point(107, 1), this.getSize(), new Dimension(64, 64), 20);
        this.renderer.drawTiledRect(this.getLocation().add(5, 5), new Point(131, 82), new Dimension(this.getSize().width - 18, 27), new Dimension(52, 27), 23, 0);
        xpzm._E()._R()._a(iedw._b);
        this.renderer.drawRect(this.getLocation().add(10, 37), new Dimension(this.getSize().width - 35, 1), 0x64646464);
        this.renderer.drawRect(this.getLocation().add(10, this.getSize().height - 10), new Dimension(this.getSize().width - 35, 1), 0x64646464);
        if (this.chatGroup != null) {
            this.renderer.drawString("\u041d\u0430\u0441\u0442\u0440\u043e\u0439\u043a\u0438 \u043a\u0430\u043d\u0430\u043b\u0430: " + this.chatGroup.getTitle(), this.getLocation().add(10, this.getSize().height / 3 - 30), 0x939393);
        }
    }

    public ChatSettingsDialog setChatGroup(ChatSettings.ChatGroup chatGroup) {
        this.chatGroup = chatGroup;
        this.settings.keySet().forEach(ugqi2 -> this.settings.get(ugqi2).setActive(chatGroup.getTypes().contains(ugqi2)));
        return this;
    }

    public ChatSettings.ChatGroup getChatGroup() {
        return this.chatGroup;
    }

    private void submitSettings() {
        this.chatGroup.clear();
        this.chatGroup.addAll(this.settings.keySet().stream().filter(ugqi2 -> this.settings.get(ugqi2).getActive()).collect(Collectors.toList()));
        this.chatGroup.add(ugqi._a);
        if (this.getOnSubmit() != null) {
            this.getOnSubmit().run();
        }
    }

    public Runnable getOnSubmit() {
        return this.onSubmit;
    }

    public ChatSettingsDialog setOnSubmit(Runnable runnable) {
        this.onSubmit = runnable;
        return this;
    }

    private void resetSettings() {
        this.chatGroup.getTypes().clear();
        this.chatGroup.getTypes().addAll(this.chatGroup.getInitialTypes());
        this.setChatGroup(this.chatGroup);
    }
}

