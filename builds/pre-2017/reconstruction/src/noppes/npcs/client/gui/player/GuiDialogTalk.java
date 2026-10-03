/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.player;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.GuiRenderer;
import gloomyfolken.mods.core.client.gui.engine.GuiRendererBuilder;
import gloomyfolken.mods.core.client.gui.engine.GuiScreenAdvanced;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponent;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollPane;
import gloomyfolken.mods.core.client.gui.font.ExternalFont;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.EnumChatFormatting;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.NoppesUtilPlayer;
import noppes.npcs.client.gui.player.IGuiChained;
import noppes.npcs.constants.EnumOptionType;
import noppes.npcs.constants.EnumPlayerPacket;
import noppes.npcs.controllers.Dialog;
import noppes.npcs.controllers.DialogOption;

public class GuiDialogTalk
extends GuiScreenAdvanced
implements IGuiChained {
    private List<DialogLine> replicas = new ArrayList<DialogLine>();
    private List<DialogLine> added = new ArrayList<DialogLine>();
    private EntityNPCInterface npc;
    private Dialog currentDialog;
    private McScrollPane replicasPane;
    private List<Response> responses;
    private int selection = 0;
    private float prevDistance = -1.0f;
    private GuiRenderer italicRenderer = new GuiRendererBuilder(this.renderer).setFontRenderer(ExternalFont.tahoma14Italic).create();
    private boolean enableForceClose = true;
    private GuiScreen chainedScreen;
    private boolean vertPosReset = false;
    public String currentDialogTitle = null;

    public GuiDialogTalk(EntityNPCInterface entityNPCInterface, Dialog dialog) {
        super(new GuiRendererBuilder().setTextureSize(1024, 1024).setFontRenderer(ExternalFont.tahoma14).create());
        this.npc = entityNPCInterface;
        this.currentDialog = dialog;
        this.handleDialog(dialog);
    }

    @Override
    public void initGui() {
        super.initGui();
        this.responses = new ArrayList<Response>();
        this.selection = 0;
        int n = 500;
        int n2 = 500;
        this.vertPosReset = true;
        this.enableForceClose = true;
        for (DialogOption dialogOption : this.currentDialog.options.values()) {
            if (!dialogOption.closeDialog && dialogOption.optionType != EnumOptionType.QuitOption && (dialogOption.optionType != EnumOptionType.DialogOption || dialogOption.dialogId < 0)) continue;
            this.enableForceClose = false;
            break;
        }
        this.createReplicasPane(n, n2);
        this.createSelection(new Point(this.screenWidth / 2 - n / 2 + 18, this.screenHeight / 2 + n2 / 2 - 30), n);
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this.drawDefaultBackground();
        super.drawScreen(n, n2, f);
        GuiComponent guiComponent = this.getElementsList().getElementMouseOver();
        for (Response response : this.responses) {
            if (response != guiComponent) continue;
            this.selection = response.selectionId;
        }
        int n3 = this.screenWidth / 2;
        int n4 = this.screenHeight / 2;
        this.drawHint(n3, n4, f);
        this.renderer.drawRect(n3 - 250, n4 + 210, 500.0, 1.0, -7105645);
        Point point = this.responses.get(this.selection).getLocation().add(-20, 0);
        this.renderer.drawString(">", point.x, point.y, -1);
    }

    private void drawHint(int n, int n2, float f) {
        boolean bl = this.replicasPane.getViewport().getElements().stream().anyMatch(guiComponent -> guiComponent instanceof StreamingReplica && !((StreamingReplica)guiComponent).finished());
        if (bl) {
            double d = Math.abs(Math.sin(((float)ntte._b + f) * 0.1f)) * 0.1;
            int n3 = 0xFFFFFF + ((int)((d + 0.3) * 250.0) << 24);
            ExternalFont.tahoma9.renderString("\u041d\u0430\u0436\u043c\u0438\u0442\u0435 [\u043f\u0440\u043e\u0431\u0435\u043b] \u0447\u0442\u043e\u0431\u044b \u043f\u0440\u043e\u043f\u0443\u0441\u0442\u0438\u0442\u044c...", (n - 250 + 5) / 2, (n2 + 180) / 2, n3);
        }
    }

    @Override
    protected void keyTyped(char c, int n) {
        if (this.enableForceClose && n == 1) {
            this.closeScreen();
            return;
        }
        this.elementsList.keyTyped(c, n);
        int n2 = this.responses.size();
        if (n2 > 0) {
            if (n == 200) {
                this.selection = Math.max(0, --this.selection);
            } else if (n == 208) {
                this.selection = Math.min(n2 - 1, ++this.selection);
            } else if (n == 28) {
                this.triggerSelection(this.selection);
            } else if (n >= 2 && n <= 8 && n - 2 < n2) {
                this.selection = n - 2;
                this.triggerSelection(this.selection);
            }
        }
        if (n == 57) {
            this.skipStreaming();
        }
    }

    private void skipStreaming() {
        for (GuiComponent guiComponent : this.replicasPane.getViewport().getElements()) {
            if (!(guiComponent instanceof StreamingReplica)) continue;
            StreamingReplica streamingReplica = (StreamingReplica)guiComponent;
            streamingReplica.lineId = streamingReplica.lines.size() - 1;
            streamingReplica.lineIndex = ((String)streamingReplica.lines.get(streamingReplica.lineId)).length();
        }
    }

    @Override
    public void updateScreen() {
        super.updateScreen();
        int n = 0;
        for (GuiComponent guiComponent : this.replicasPane.getViewport().getElements()) {
            if (!(guiComponent instanceof StreamingReplica)) continue;
            n += guiComponent.getSize().height;
        }
        if (this.vertPosReset && this.replicasPane.getVerticalScrollBar().enabled()) {
            this.replicasPane.getVerticalScrollBar().pos = 1.0f;
            this.vertPosReset = false;
        }
        this.replicasPane.getViewport().setViewSize(new Dimension(500, n));
        EntityClientPlayerMP entityClientPlayerMP = Minecraft._E()._t;
        if (!entityClientPlayerMP.isEntityAlive()) {
            Minecraft._E()._a((GuiScreen)null);
        }
        float f = entityClientPlayerMP.getDistanceToEntity(this.npc);
        if (this.prevDistance != -1.0f && this.prevDistance - f > 5.0f || f > 100.0f) {
            this.closeScreen();
        } else {
            this.prevDistance = f;
        }
    }

    private void closeDialog() {
        NoppesUtilPlayer.sendData(EnumPlayerPacket.CloseDialog, new Object[0]);
        System.out.println("Sent dialog closing packet");
        NoppesUtilPlayer.sendData(EnumPlayerPacket.CheckQuestCompletion, new Object[0]);
    }

    @Override
    public void closeScreen() {
        super.closeScreen();
        this.closeDialog();
        this.mc._a(this.chainedScreen);
    }

    @Override
    public void onGuiClosed() {
        this.closeDialog();
        super.onGuiClosed();
    }

    private void createReplicasPane(int n, int n2) {
        List<StreamingReplica> list2 = this.getReplicasLines(n - 25);
        int n3 = 0;
        for (StreamingReplica object2 : list2) {
            n3 += object2.getSize().height;
        }
        Point point = new Point(this.screenWidth / 2 - 250, this.screenHeight / 2 - 320);
        Dimension dimension = new Dimension(n, n2);
        Dimension dimension2 = new Dimension(n, n3);
        float f = 0.0f;
        if (this.replicasPane != null && this.replicasPane.getVerticalScrollBar() != null) {
            f = this.replicasPane.getVerticalScrollBar().pos;
        }
        this.replicasPane = GuiHelper.createScrollPane((IAdvancedGui)this, point, dimension, dimension2, false, iedw._j, iedw._k);
        this.replicasPane.getLeftButton().setVisible(false);
        this.replicasPane.getRightButton().setVisible(false);
        this.replicasPane.getHorizontalScrollBar().setVisible(false);
        if (this.replicasPane.getVerticalScrollBar() != null) {
            this.replicasPane.getVerticalScrollBar().pos = f;
            this.replicasPane.getVerticalScrollBar().setSliderLength(16);
        }
        int n4 = 0;
        for (int i = 0; i < list2.size(); ++i) {
            Point point2 = new Point(5, n4);
            StreamingReplica streamingReplica = list2.get(i);
            streamingReplica.setLocation(point2);
            if (streamingReplica.dialogLine.impersonal) {
                streamingReplica.setRenderer(this.italicRenderer);
            }
            this.replicasPane.getViewport().addElement(streamingReplica);
            n4 += streamingReplica.getSize().height;
        }
        this.addElement(this.replicasPane);
    }

    private void createSelection(Point point, int n) {
        int n2 = 0;
        int n3 = 0;
        for (Map.Entry<Integer, DialogOption> entry : this.currentDialog.options.entrySet()) {
            int n4 = entry.getKey();
            DialogOption dialogOption = entry.getValue();
            if (dialogOption.optionType == EnumOptionType.Disabled) continue;
            String string = String.format("%d. %s", n2 + 1, dialogOption.title);
            Response response = new Response(this, point.add(0, n3), n, string, n2, n4);
            this.addElement(response);
            this.responses.add(response);
            n3 += response.getSize().height;
            ++n2;
        }
        if (this.enableForceClose) {
            Response response = new Response(this, point.add(0, n3), n, n2 + 1 + ". \u0417\u0430\u043a\u0440\u044b\u0442\u044c", n2, -1);
            this.addElement(response);
            this.responses.add(response);
        }
    }

    private void triggerSelection(int n) {
        int n2 = this.responses.get(n).optionId;
        if (n2 == -1) {
            this.closeScreen();
        } else {
            this.processOption(n2);
        }
    }

    private void processOption(int n) {
        DialogOption dialogOption = this.currentDialog.options.get(n);
        if (dialogOption != null) {
            if (dialogOption.optionType != EnumOptionType.QuitOption && dialogOption.optionType != EnumOptionType.Disabled) {
                NoppesUtilPlayer.sendData(EnumPlayerPacket.Dialog, this.currentDialog.id, n);
                this.addLine(new DialogLine(Minecraft._E()._t.username, dialogOption.title, false));
                NoppesUtilPlayer.sendData(EnumPlayerPacket.CheckQuestCompletion, new Object[0]);
            }
            if (dialogOption.shouldClose()) {
                this.closeScreen();
            }
            this.mc._N._a("random.click", 1.0f, 1.0f);
        }
    }

    public void handleDialog(Dialog dialog) {
        this.currentDialog = dialog;
        this.currentDialogTitle = dialog != null ? dialog.title : null;
        this.addLine(new DialogLine(dialog.impersonal ? this.getClientName() : this.npc.display.name, dialog.text, dialog.impersonal));
        if (this.replicasPane != null) {
            this.setWorldAndResolution(this.mc, this.screenWidth / 2, this.screenHeight / 2);
        }
    }

    private void addLine(DialogLine dialogLine) {
        this.added.add(dialogLine);
    }

    private List<StreamingReplica> getReplicasLines(int n) {
        ArrayList<StreamingReplica> arrayList = new ArrayList<StreamingReplica>();
        for (DialogLine dialogLine : this.replicas) {
            arrayList.add(new StreamingReplica(this, Point.zeroPoint, new Dimension(n, 0), dialogLine, true));
        }
        for (int i = 0; i < this.added.size(); ++i) {
            DialogLine dialogLine;
            dialogLine = this.added.get(i);
            this.replicas.add(dialogLine);
            arrayList.add(new StreamingReplica(this, Point.zeroPoint, new Dimension(n, 0), dialogLine, i != this.added.size() - 1));
        }
        this.added.clear();
        return arrayList;
    }

    private String getClientName() {
        return Minecraft._E()._t.username;
    }

    @Override
    public void setNextGui(GuiScreen guiScreen) {
        this.chainedScreen = guiScreen;
    }

    @Override
    public GuiScreen getNextGui() {
        return this.chainedScreen;
    }

    private class Response
    extends GuiComponent {
        private int selectionId;
        private int optionId;
        private List<String> lines;

        protected Response(IAdvancedGui iAdvancedGui, Point point, int n, String string, int n2, int n3) {
            super(iAdvancedGui, point, new Dimension(n, 0));
            this.selectionId = n2;
            this.optionId = n3;
            this.lines = this.renderer.wrapString(string, n);
            this.setSize(new Dimension(n, this.lines.size() * (this.renderer.getFontHeight() + 3)));
        }

        @Override
        public void drawComponent(Point point, float f) {
            super.drawComponent(point, f);
            for (int i = 0; i < this.lines.size(); ++i) {
                this.renderer.drawString(this.lines.get(i), this.getLocation().x, this.getLocation().y + i * (this.renderer.getFontHeight() + 3), -1);
            }
        }

        @Override
        public void mouseClicked(Point point, int n) {
            if (this.isMouseInBounds(point) && n == 0) {
                GuiDialogTalk.this.triggerSelection(this.selectionId);
            }
        }
    }

    private class StreamingReplica
    extends GuiComponent {
        private final DialogLine dialogLine;
        private List<String> lines;
        private int lineId;
        private float lineIndex;

        public StreamingReplica(IAdvancedGui iAdvancedGui, Point point, Dimension dimension, DialogLine dialogLine, boolean bl) {
            super(iAdvancedGui, point, dimension);
            this.dialogLine = dialogLine;
            this.lines = this.dialogLine.wrapToWidth(dimension.width);
            if (bl || dialogLine.impersonal) {
                this.lineId = this.lines.size() - 1;
                this.lineIndex = this.lines.get(this.lineId).length();
            } else if (this.lines.size() > 1) {
                this.lineId = 1;
            }
            this.updateSize();
        }

        @Override
        public void tick() {
            String string = this.lines.get(this.lineId);
            if (this.lineIndex >= (float)string.length()) {
                if (this.lineId < this.lines.size() - 1) {
                    ++this.lineId;
                    this.lineIndex = 0.0f;
                }
            } else {
                char c = string.charAt(Math.min(string.length(), (int)this.lineIndex));
                float f = 0.95f;
                if (Character.isWhitespace(c)) {
                    f *= 0.5f;
                } else if (Character.getType(c) == 24) {
                    f = (float)((double)f * 0.35);
                }
                this.lineIndex += f;
            }
            this.updateSize();
        }

        private void updateSize() {
            this.setSize(new Dimension(this.getSize().width, (this.lineId + 1) * (this.renderer.getFontHeight() + 3)));
        }

        @Override
        public void drawComponent(Point point, float f) {
            for (int i = 0; i < Math.min(this.lines.size(), this.lineId + 1); ++i) {
                String string = this.lines.get(i);
                if (i == this.lineId) {
                    string = string.substring(0, Math.min((int)this.lineIndex, string.length()));
                }
                this.renderer.drawString(string, this.getLocation().x, this.getLocation().y + i * (this.renderer.getFontHeight() + 3), -1);
            }
        }

        public boolean finished() {
            return this.lineId == this.lines.size() - 1 && this.lineIndex >= (float)this.lines.get(this.lineId).length();
        }
    }

    private class DialogLine {
        private String author;
        private String text;
        private boolean impersonal;

        public DialogLine(String string, String string2, boolean bl) {
            this.author = string;
            this.text = string2;
            this.impersonal = bl;
        }

        private List<String> wrapToWidth(int n) {
            ArrayList<String> arrayList = new ArrayList<String>();
            String string = String.format("%s%s:\n%s", new Object[]{EnumChatFormatting._o, this.author, this.text});
            for (String string2 : string.split("\n")) {
                GuiRenderer guiRenderer = this.impersonal ? GuiDialogTalk.this.italicRenderer : GuiDialogTalk.this.getRenderer();
                arrayList.addAll(guiRenderer.wrapString(string2, n));
            }
            return arrayList;
        }
    }
}

