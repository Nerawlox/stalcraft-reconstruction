/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.player;

import gloomyfolken.mods.core.client.gui.engine.ActionManager;
import gloomyfolken.mods.core.client.gui.engine.GuiRenderer;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponent;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponentsList;
import gloomyfolken.mods.core.client.gui.engine.component.McTextArea;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import noppes.npcs.NoppesStringUtils;
import noppes.npcs.NoppesUtilPlayer;
import noppes.npcs.QuestLogData;
import noppes.npcs.client.gui.util.GuiCustomScroll;
import noppes.npcs.client.gui.util.GuiCustomScrollActionListener;
import noppes.npcs.client.gui.util.GuiMenuSideButton;
import noppes.npcs.client.gui.util.GuiPlayerTopMenu;
import noppes.npcs.client.gui.util.IGuiData;
import noppes.npcs.client.gui.util.ITopButtonListener;
import noppes.npcs.constants.EnumPlayerPacket;
import org.lwjgl.opengl.GL11;

public class GuiQuestLog
extends gqjz
implements IAdvancedGui,
GuiCustomScrollActionListener,
IGuiData,
ITopButtonListener {
    private final ResourceLocation resource = new ResourceLocation("customnpcs", "textures/gui/standardbg.png");
    public ActionManager actionManager = new ActionManager(this);
    protected int xSize;
    protected int guiLeft;
    protected int guiTop;
    private EntityPlayer player;
    private GuiCustomScroll scroll;
    private HashMap sideButtons = new HashMap();
    public QuestLogData data = new QuestLogData();
    private boolean noQuests = false;
    private GuiPlayerTopMenu topMenu;
    private int yoffset;
    private GuiComponentsList elementsList = new GuiComponentsList(this);
    private McTextArea textArea;

    public GuiQuestLog(EntityPlayer entityPlayer) {
        this.player = entityPlayer;
        this.xSize = 240;
        NoppesUtilPlayer.sendData(EnumPlayerPacket.QuestLog, new Object[0]);
    }

    @Override
    public void func_73866_w_() {
        this.actionManager.setLoaded(false);
        super.func_73866_w_();
        this.sideButtons.clear();
        this.guiLeft = (this.field_73880_f - this.xSize) / 2;
        this.guiTop = (this.field_73881_g - 176) / 2;
        this.topMenu = new GuiPlayerTopMenu(this.guiLeft + 35, this.guiTop - 17, 2, this.player);
        this.noQuests = false;
        if (this.data.categories.isEmpty()) {
            this.noQuests = true;
        } else {
            ArrayList<String> arrayList = new ArrayList<String>();
            arrayList.addAll(this.data.categories.keySet());
            Collections.sort(arrayList, String.CASE_INSENSITIVE_ORDER);
            int n = 0;
            for (String string : arrayList) {
                if (this.data.selectedCategory.isEmpty()) {
                    this.data.selectedCategory = string;
                }
                this.sideButtons.put(n, new GuiMenuSideButton(n, this.guiLeft - 89, this.guiTop + 2 + n * 21, 90, 22, string));
                ++n;
            }
            ((GuiMenuSideButton)this.sideButtons.get((Object)Integer.valueOf((int)arrayList.indexOf((Object)this.data.selectedCategory)))).active = true;
            this.scroll = new GuiCustomScroll(this, 0);
            this.scroll.setList(this.data.categories.get(this.data.selectedCategory));
            this.scroll.func_73872_a(this.field_73882_e, 350, 250);
            this.scroll.setSize(144, 183);
            this.scroll.guiLeft = this.guiLeft + 6;
            this.scroll.guiTop = this.guiTop + 6;
        }
        this.textArea = new McTextArea(this, (this.guiLeft + 147) * 2, (this.guiTop + 15) * 2, 340, 1000);
        this.textArea.color = 0x404040;
        this.textArea.drawBackground = false;
        this.elementsList.addElement(this.textArea);
        this.actionManager.setLoaded(true);
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        this.func_73873_v_();
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.field_73882_e._h._a(this.resource);
        this.func_73729_b(this.guiLeft, this.guiTop, 0, 0, 252, 195);
        this.func_73729_b(this.guiLeft + 252, this.guiTop, 188, 0, 67, 195);
        super.func_73863_a(n, n2, f);
        this.topMenu.func_73863_a(n, n2, f);
        if (this.noQuests) {
            this.field_73886_k._b("You have no active quests", this.guiLeft + 84, this.guiTop + 80, 0x404040);
        } else {
            for (GuiMenuSideButton guiMenuSideButton : this.sideButtons.values().toArray(new GuiMenuSideButton[this.sideButtons.size()])) {
                guiMenuSideButton.func_73737_a(this.field_73882_e, n, n2);
            }
            this.scroll.func_73863_a(n, n2, f);
            if (this.data.hasSelectedQuest()) {
                this.yoffset = this.guiTop + 5;
                this.drawProgress();
                this.textArea.setLocation(new Point(this.textArea.getLocation().x, this.yoffset * 2 + 8));
            }
        }
        this.elementsList.drawComponent(new Point(n, n2), f);
    }

    @Override
    public void func_73876_c() {
        super.func_73876_c();
        if (this.data.hasSelectedQuest()) {
            this.textArea.setText(NoppesStringUtils.formatText(this.data.getQuestText(), this.player.field_71092_bJ));
        } else {
            this.textArea.setText("");
        }
        this.elementsList.tick();
    }

    private void drawQuestText() {
        this.yoffset = this.guiTop + 5;
        int n = 0;
        this.drawProgress();
        this.yoffset += 4;
        int n2 = this.guiLeft + 150;
        String string = NoppesStringUtils.formatText(this.data.getQuestText(), this.player.field_71092_bJ);
        String string2 = "";
        for (char c : string.toCharArray()) {
            if (c != '\r' && c != '\n') {
                if (this.field_73886_k._b(string2 + c) > 176) {
                    this.field_73886_k._b(string2, n2, this.yoffset + n * this.field_73886_k._c, 0x404040);
                    string2 = "";
                    ++n;
                }
                string2 = string2 + c;
                continue;
            }
            this.field_73886_k._b(string2, n2, this.yoffset + n * this.field_73886_k._c, 0x404040);
            string2 = "";
            ++n;
        }
        this.field_73886_k._b(string2, n2, this.yoffset + n * this.field_73886_k._c, 0x404040);
    }

    private void drawProgress() {
        int n = this.guiLeft + 152;
        for (String string : this.data.getQuestStatus()) {
            this.field_73886_k._b(string, n, this.yoffset, 0x404040);
            this.yoffset += 10;
        }
    }

    protected void drawGuiContainerBackgroundLayer(float f, int n, int n2) {
    }

    @Override
    public void func_73864_a(int n, int n2, int n3) {
        super.func_73864_a(n, n2, n3);
        this.topMenu.func_73864_a(n, n2, n3);
        if (n3 == 0) {
            if (this.scroll != null) {
                this.scroll.func_73864_a(n, n2, n3);
            }
            for (GuiMenuSideButton guiMenuSideButton : this.sideButtons.values().toArray(new GuiMenuSideButton[this.sideButtons.size()])) {
                if (!guiMenuSideButton.func_73736_c(this.field_73882_e, n, n2)) continue;
                this.sideButtonPressed(guiMenuSideButton);
            }
        }
        this.elementsList.mouseClicked(n3);
    }

    private void sideButtonPressed(GuiMenuSideButton guiMenuSideButton) {
        if (!guiMenuSideButton.active) {
            this.field_73882_e._N._a("random.click", 1.0f, 1.0f);
            this.data.selectedCategory = guiMenuSideButton.field_73744_e;
            this.data.selectedQuest = "";
            this.func_73866_w_();
        }
    }

    @Override
    public void customScrollClicked(int n, int n2, int n3, GuiCustomScroll guiCustomScroll) {
        if (guiCustomScroll.hasSelected()) {
            this.data.selectedQuest = guiCustomScroll.getSelected();
        }
    }

    @Override
    protected void func_73869_a(char c, int n) {
        if (n == 1 || n == this.field_73882_e._M.field_74315_B._d) {
            this.field_73882_e._a((gqjz)null);
            this.field_73882_e._o();
        }
        this.elementsList.keyTyped(c, n);
    }

    @Override
    public boolean func_73868_f() {
        return false;
    }

    @Override
    public void setGuiData(qoac qoac2) {
        QuestLogData questLogData = new QuestLogData();
        questLogData.readNBT(qoac2);
        this.data = questLogData;
        this.func_73866_w_();
    }

    @Override
    public gqjz getGui() {
        return this;
    }

    @Override
    public GuiRenderer getRenderer() {
        return GuiComponent.hdRenderer;
    }

    @Override
    public GuiComponentsList getElementsList() {
        return this.elementsList;
    }

    @Override
    public ActionManager getActionManager() {
        return this.actionManager;
    }
}

