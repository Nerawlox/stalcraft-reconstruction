/*
 * Decompiled with CFR 0.152.
 */
package mods.chat.client.screen;

import com.google.common.collect.ObjectArrays;
import gloomyfolken.bundle.common.core.tupg;
import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.GuiRendererBuilder;
import gloomyfolken.mods.core.client.gui.engine.GuiScreenAdvanced;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.action.GuiActionButtonClick;
import gloomyfolken.mods.core.client.gui.engine.action.GuiActionTextFieldChanged;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponent;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponentsList;
import gloomyfolken.mods.core.client.gui.engine.component.McButton;
import gloomyfolken.mods.core.client.gui.engine.component.McCheckBox;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollBar;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollButton;
import gloomyfolken.mods.core.client.gui.engine.component.McTextField;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentButtonStyle;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentCheckboxStyle;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentScrollButtonStyle;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentSliderBarStyle;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentStyle;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentTextfieldStyle;
import gloomyfolken.mods.core.client.gui.font.ExternalFont;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;
import mods.chat.ChatMod;
import mods.chat.client.ChatHud;
import mods.chat.client.ChatSettings;
import mods.chat.client.MessageStorage;
import mods.chat.client.screen.ChatSettingsDialog;
import mods.chat.client.screen.MessagesPane;
import mods.pda.client.screens.GuiPda;
import mods.pda.client.tab.PdaProfile;
import mods.pda.packet.PacketIgnoreAction;
import net.minecraft.client.xpzm;
import net.minecraft.util.ezfc;
import net.minecraft.util.sajh;
import net.minecraftforge.client.ClientCommandHandler;
import org.apache.commons.lang3.StringUtils;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class GuiChatActive
extends GuiScreenAdvanced {
    public static final int CHAT_WIDTH = 450;
    public static final int CHAT_HEIGHT = 250;
    public static final ComponentStyle.StyleStorage CHAT_STYlE = new ComponentStyle.StyleStorage("chat");
    public static final ComponentButtonStyle tabButtonStyle = (ComponentButtonStyle)CHAT_STYlE.getComponentStyle(McButton.class);
    public static final ComponentScrollButtonStyle sliderButtonStyle = (ComponentScrollButtonStyle)CHAT_STYlE.getComponentStyle(McScrollButton.class);
    public static final ComponentSliderBarStyle sliderStyle = (ComponentSliderBarStyle)CHAT_STYlE.getComponentStyle(McScrollBar.class);
    public static final ComponentCheckboxStyle checkBox = (ComponentCheckboxStyle)CHAT_STYlE.getComponentStyle(McCheckBox.class);
    public static final ComponentTextfieldStyle textfieldStyle = (ComponentTextfieldStyle)CHAT_STYlE.getComponentStyle(McTextField.class);
    public static final ComponentButtonStyle buttonStyle = new ComponentButtonStyle(){
        {
            this.setSize(new Dimension(64, 27));
            this.setDefaultUv(66, 95);
            this.setMouseOverUv(66, 123);
            this.setTexture(ChatHud.texture);
            this.setBorderSizeX(18);
            this.setBorderSizeY(9);
            this.setFontColor(new Color(147, 147, 147));
        }
    };
    public static final ComponentButtonStyle settingsButton = new ComponentButtonStyle(){
        {
            this.setSize(new Dimension(17, 17));
            this.setDefaultUv(17, 3);
            this.setMouseOverUv(this.getDefaultUv());
            this.setTexture(ChatHud.texture);
        }
    };
    private MessagesPane messagesPane;
    private McTextField messageField;
    private ChatSettingsDialog dialog;
    private int historyIndex = -1;
    private boolean canUseCompletion = false;
    private boolean awaitingCompletionData = false;
    private int autoCompleteIndex = 0;
    private List<String> completionData = new ArrayList<String>();
    public String defaultText = null;
    private Map<ChatSettings.ChatGroup, McButton> tabButtons = new HashMap<ChatSettings.ChatGroup, McButton>();
    private PlayerInteractionDialog interactionDialog = null;

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
        this.interactionDialog = null;
        if (this.parentScreen != null) {
            GuiHelper.addBackground(this, 0, 0, 0, 0, true);
        }
        this.tabButtons.clear();
        Keyboard.enableRepeatEvents(true);
        this.historyIndex = -1;
        this.canUseCompletion = false;
        this.renderer = new GuiRendererBuilder().setFontRenderer(ExternalFont.tahoma11).setTextureSize(256, 256).create();
        this.messageField = this.creatMessageField(new Point(30, this.screenHeight - 30), new Dimension(410, 27));
        this.addElement(this.messageField);
        this.getActionManager().registerActionHandler(this.messageField, GuiActionTextFieldChanged.class, guiActionTextFieldChanged -> this.updateTextfieldColor());
        this.messagesPane = new MessagesPane(this, new Point(10, this.screenHeight - 250 - 65), new Dimension(450, 249)).setOnNicknameClick(this::onNicknameClicked);
        this.addElement(this.messagesPane);
        this.messagesPane.setup();
        this.setupSettingsButton(new Point(12, this.screenHeight - 25));
        this.populatesMessagesPane();
        this.createTabsButtons();
        this.updateUnreadCounters();
        this.dialog = new ChatSettingsDialog(this, new Point(35, this.screenHeight - 30 - 240), new Dimension(400, 230));
        this.addElement(this.dialog);
        this.dialog.init().setStatus(false);
        if (ChatSettings.SETTINGS.getGroup() == ChatMod.CHAT_PRIVATE) {
            this.messageField.tipText = "\u041d\u0438\u043a: \u0441\u043e\u043e\u0431\u0449\u0435\u043d\u0438\u0435...";
            if (this.defaultText == null) {
                this.insertLastPMReceiver();
            }
        } else {
            this.messageField.tipText = "\u0421\u043e\u043e\u0431\u0449\u0435\u043d\u0438\u0435...";
        }
        if (this.defaultText != null) {
            this.messageField.setText(this.defaultText);
            this.defaultText = null;
        }
        this.updateTextfieldColor();
    }

    private void insertLastPMReceiver() {
        jxsn jxsn3 = MessageStorage.SENT.get(ugqi._g).stream().max(Comparator.comparing(jxsn2 -> jxsn2._e)).orElse(null);
        String string = null;
        if (jxsn3 == null) {
            jxsn3 = MessageStorage.RECEIVED.get(ugqi._g).stream().filter(jxsn2 -> !jxsn2._c.equals(xpzm._E()._t.func_70005_c_())).max(Comparator.comparing(jxsn2 -> jxsn2._e)).orElse(null);
            if (jxsn3 != null) {
                string = jxsn3._c;
            }
        } else {
            int n = jxsn._b(jxsn3._d);
            string = n < 0 ? jxsn3._d.substring(1) : jxsn3._d.substring(1, n);
        }
        if (string != null) {
            this.messageField.setText(string + ": ");
        }
    }

    private void setupSettingsButton(Point point) {
        McButton mcButton = GuiHelper.addButton(this, point, new Dimension(17, 17), settingsButton, "");
        this.getActionManager().registerActionHandler(mcButton, GuiActionButtonClick.class, guiActionButtonClick -> this.dialog.setChatGroup(ChatSettings.SETTINGS.getGroup()).setOnSubmit(() -> this.switchTo(this.dialog.getChatGroup())).setStatus(true));
        this.addElement(mcButton);
    }

    public void drawMessages() {
        GL11.glEnable(3042);
        this.messagesPane.drawComponent(new Point(0, 0), 0.0f);
        GL11.glDisable(3042);
    }

    private void updateTextfieldColor() {
        String string = this.messageField.getText();
        ugqi ugqi3 = Stream.of(ugqi.values()).filter(ugqi2 -> !ugqi2._i.isEmpty() && string.startsWith(ugqi2._i)).findFirst().orElse(null);
        if (string.trim().isEmpty() || ugqi3 == null) {
            ugqi3 = ChatSettings.SETTINGS.getGroup().getSendType();
        }
        this.messageField.setTextColor(ugqi3._k);
    }

    @Override
    protected void func_73864_a(int n, int n2, int n3) {
        if (this.dialog.getVisible()) {
            this.dialog.mouseClicked(n3);
            return;
        }
        if (this.interactionDialog != null) {
            if (this.interactionDialog.isMouseInBounds(new Point(n * 2, n2 * 2))) {
                this.interactionDialog.mouseClicked(n3);
                return;
            }
            this.closeInteractionDialog();
        }
        super.func_73864_a(n, n2, n3);
    }

    @Override
    protected void func_73869_a(char c, int n) {
        super.func_73869_a(c, n);
        if (n == 15) {
            this.completeCommand();
        } else {
            this.canUseCompletion = false;
        }
        if (n == 28) {
            this.sendMessage();
        }
        if (n == 200) {
            this.switchHistory(1);
        } else if (n == 208) {
            this.switchHistory(-1);
        }
    }

    protected void sendMessage() {
        String string = this.messageField.getText().trim();
        if (!string.isEmpty()) {
            String string2;
            ChatSettings.ChatGroup chatGroup = ChatSettings.SETTINGS.getGroup();
            boolean bl = Stream.of(ugqi.values()).filter(ugqi2 -> !ugqi2._i.isEmpty()).anyMatch(ugqi2 -> string.startsWith(ugqi2._i));
            String string3 = string2 = bl ? string : chatGroup.getSendType()._i + string;
            if (!this.field_73882_e._b(string2)) {
                new lmyw(string2).sendToServer();
            }
            ugqi ugqi3 = string2.startsWith(ugqi._g._i) ? ugqi._g : ugqi._a;
            MessageStorage.SENT.add(new jxsn(ugqi3, "", "", string2, System.currentTimeMillis(), tupg._a));
        }
        this.closeScreen();
    }

    protected void onNicknameClicked(String string, Point point) {
        this.interactionDialog = new PlayerInteractionDialog(this, point, string);
        this.addElement(this.interactionDialog);
    }

    protected void openChatWith(String string) {
        this.closeInteractionDialog();
        String string2 = this.messageField.getText();
        int n = GuiChatActive.indexOfAny(string2, ":", " ");
        String string3 = "";
        if (ChatSettings.SETTINGS.getGroup() != ChatMod.CHAT_PRIVATE) {
            if (!string2.startsWith(ugqi._g._i)) {
                string3 = ugqi._g._i + string + ": " + string2;
            } else if (n > 0) {
                string3 = string2.replaceFirst(string2.substring(ugqi._g._i.length(), n), string);
            }
        } else {
            string3 = string2.isEmpty() ? string + ": " : (n > 0 ? string2.replaceFirst(string2.substring(0, n), string) : string + ": " + string2);
        }
        if (!string3.isEmpty() && !string3.equals(string2)) {
            this.messageField.setText(string3);
            this.messageField.setFocused(true);
        }
    }

    private void switchHistory(int n) {
        List<jxsn> list = MessageStorage.SENT.all();
        int n2 = sajh._a(this.historyIndex + n, 0, list.size() - 1);
        if (!list.isEmpty() && n2 != this.historyIndex) {
            this.messageField.setText(list.get((int)(list.size() - 1 - n2))._d);
            this.historyIndex = n2;
        }
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        GL11.glEnable(3042);
        this.renderer.bindTexture(ChatHud.texture);
        this.renderer.drawTiledRect(this.messagesPane.getLocation(), new Point(42, 1), this.messagesPane.getSize(), new Dimension(64, 64), 20);
        this.renderer.drawTiledRect(new Point(10, this.screenHeight - 61), new Point(42, 1), new Dimension(450, 60), new Dimension(64, 64), 20);
        this.renderer.drawTiledRect(this.messagesPane.getLocation().add(5, 5), new Point(1, 2), new Dimension(15, this.messagesPane.getSize().height - 10), new Dimension(15, 64), 4);
        GL11.glDisable(3042);
        super.func_73863_a(n, n2, f);
    }

    @Override
    public void closeScreen() {
        if (ChatMod.instance.chatHud.getChat() == xpzm._E()._B) {
            super.closeScreen();
        }
        this.parentScreen = null;
        Keyboard.enableRepeatEvents(false);
        ChatMod.instance.chatHud.active = false;
    }

    private void populatesMessagesPane() {
        ChatSettings.ChatGroup chatGroup = ChatSettings.SETTINGS.getGroup();
        List<jxsn> list = this.getMessagesForGroup(chatGroup);
        list.sort(Comparator.comparing(jxsn2 -> jxsn2._e));
        list.forEach(jxsn2 -> jxsn2._a(true));
        this.messagesPane.addMessages(list);
    }

    public void handleReceivedMessage(jxsn jxsn2) {
        Set<ugqi> set = ChatSettings.SETTINGS.getGroup().getTypes();
        if (set.contains((Object)jxsn2._a) || jxsn2._a == ugqi._h && set.contains((Object)ugqi._g)) {
            this.messagesPane.addMessage(jxsn2);
            jxsn2._a(true);
        }
        this.updateUnreadCounters();
    }

    private void updateUnreadCounters() {
        for (Map.Entry<ChatSettings.ChatGroup, McButton> entry : this.tabButtons.entrySet()) {
            long l = this.getMessagesForGroup(entry.getKey()).stream().filter(jxsn2 -> !jxsn2._a()).count();
            String string = l < 1L || !entry.getKey().isCountingUnread() ? entry.getKey().getTitle() : String.format("%s (%d)", entry.getKey().getTitle(), l);
            entry.getValue().text = string;
        }
    }

    private List<jxsn> getMessagesForGroup(ChatSettings.ChatGroup chatGroup) {
        List<jxsn> list = MessageStorage.RECEIVED.get(chatGroup.getTypes());
        if (chatGroup.getTypes().contains((Object)ugqi._g)) {
            list.addAll(MessageStorage.RECEIVED.get(ugqi._h));
        }
        return list;
    }

    private McTextField creatMessageField(Point point, Dimension dimension) {
        McTextField mcTextField = new McTextField(this, point, dimension);
        mcTextField.setMaxStringLength(1000);
        mcTextField.setStyle(textfieldStyle);
        mcTextField.setFocused(true);
        mcTextField.setCanLoseFocus(false);
        return mcTextField;
    }

    private void createTabsButtons() {
        ArrayList<ChatSettings.ChatGroup> arrayList = new ArrayList<ChatSettings.ChatGroup>(ChatSettings.SETTINGS.getGroups().values());
        int n = 410 / arrayList.size();
        Point point = new Point(30, this.screenHeight - 60);
        for (int i = 0; i < arrayList.size(); ++i) {
            ChatSettings.ChatGroup chatGroup = (ChatSettings.ChatGroup)arrayList.get(i);
            McButton mcButton = GuiHelper.addButton(this, point.add(n * i, 0), new Dimension(n, 27), tabButtonStyle, chatGroup.getTitle());
            if (chatGroup == ChatSettings.SETTINGS.getGroup()) {
                mcButton.textColor = -1;
            }
            this.getActionManager().registerActionHandler(mcButton, GuiActionButtonClick.class, guiActionButtonClick -> this.switchTo(chatGroup));
            this.tabButtons.put(chatGroup, mcButton);
        }
    }

    private void switchTo(ChatSettings.ChatGroup chatGroup) {
        this.elementsList.clearElements();
        ChatSettings.SETTINGS.setGroup(chatGroup);
        this.func_73866_w_();
    }

    private void completeCommand() {
        boolean bl = false;
        if (this.canUseCompletion) {
            int n = this.messageField.func_73798_a(-1, this.messageField.getCursorPosition(), false);
            if (this.messageField.getText().substring(n).startsWith(ugqi._g._i)) {
                bl = true;
            }
            this.messageField.deleteFromCursor(n - this.messageField.getCursorPosition());
            if (this.autoCompleteIndex >= this.completionData.size()) {
                this.autoCompleteIndex = 0;
            }
        } else {
            int n = this.messageField.func_73798_a(-1, this.messageField.getCursorPosition(), false);
            this.completionData.clear();
            this.autoCompleteIndex = 0;
            String string = this.messageField.getText().substring(n).toLowerCase();
            String string2 = this.messageField.getText().substring(0, this.messageField.getCursorPosition());
            if (string2.startsWith(ugqi._g._i)) {
                string2 = string2.substring(ugqi._g._i.length());
                bl = true;
            }
            this.sendAutoCompleteRequest(string2, string);
            if (this.completionData.isEmpty()) {
                return;
            }
            this.canUseCompletion = true;
            this.messageField.deleteFromCursor(n - this.messageField.getCursorPosition());
        }
        this.messageField.writeText((bl ? ugqi._g._i : "") + ezfc._a(this.completionData.get(this.autoCompleteIndex++)));
    }

    private void sendAutoCompleteRequest(String string, String string2) {
        if (!string.isEmpty()) {
            ClientCommandHandler.instance.autoComplete(string, string2);
            xpzm._E()._t.field_71174_a._b(new hdkt(string));
            this.awaitingCompletionData = true;
        }
    }

    public void handleCompletionData(String[] stringArray) {
        if (this.awaitingCompletionData) {
            this.completionData.clear();
            String[] stringArray2 = ClientCommandHandler.instance.latestAutoComplete;
            if (stringArray2 != null) {
                stringArray = ObjectArrays.concat(stringArray2, stringArray, String.class);
            }
            Stream.of(stringArray).filter(StringUtils::isNotEmpty).forEach(this.completionData::add);
            if (!this.completionData.isEmpty()) {
                this.canUseCompletion = true;
                this.completeCommand();
            }
        }
    }

    private void closeInteractionDialog() {
        if (this.interactionDialog != null) {
            this.removeElement(this.interactionDialog);
            this.interactionDialog = null;
        }
    }

    @Override
    public void func_73874_b() {
        super.func_73874_b();
        Keyboard.enableRepeatEvents(false);
        ChatMod.instance.chatHud.active = false;
    }

    private static int indexOfAny(String string, String string2, String string3) {
        int n = string.indexOf(string2);
        if (n < 0) {
            n = string.indexOf(string3);
        }
        return n;
    }

    private class PlayerInteractionDialog
    extends GuiComponentsList<GuiComponent> {
        PlayerInteractionDialog(IAdvancedGui iAdvancedGui, Point point, String string) {
            super(iAdvancedGui, point, new Dimension(200, 90));
            this.setRenderer(new GuiRendererBuilder(this.renderer).setTextureSize(1024, 1024).create());
            GuiHelper.addButton(this, new Point(10, 10), new Dimension(180, 27), iedw._l, "\u041e\u0442\u043f\u0440\u0430\u0432\u0438\u0442\u044c \u0441\u043e\u043e\u0431\u0449\u0435\u043d\u0438\u0435").onClick(guiActionButtonClick -> GuiChatActive.this.openChatWith(string)).setRenderer(this.renderer);
            GuiHelper.addButton(this, new Point(10, 40), new Dimension(180, 27), iedw._l, "\u041f\u0440\u043e\u0444\u0438\u043b\u044c \u0438\u0433\u0440\u043e\u043a\u0430").onClick(guiActionButtonClick -> GuiPda.openPda("profile", guiPda -> new PdaProfile((IAdvancedGui)guiPda, string))).setRenderer(this.renderer);
            GuiHelper.addButton(this, new Point(10, 70), new Dimension(180, 27), iedw._l, "\u0417\u0430\u0431\u043b\u043e\u043a\u0438\u0440\u043e\u0432\u0430\u0442\u044c").onClick(guiActionButtonClick -> {
                new PacketIgnoreAction(string, true).sendToServer();
                GuiChatActive.this.closeInteractionDialog();
            }).setRenderer(this.renderer).setEnabled(!string.equals(GuiChatActive.this.field_73882_e._t.field_71092_bJ));
        }
    }
}

