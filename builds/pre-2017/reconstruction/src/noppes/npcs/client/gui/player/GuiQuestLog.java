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
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
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
extends GuiScreen
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
    public void initGui() {
        this.actionManager.setLoaded(false);
        super.initGui();
        this.sideButtons.clear();
        this.guiLeft = (this.width - this.xSize) / 2;
        this.guiTop = (this.height - 176) / 2;
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
            this.scroll.setWorldAndResolution(this.mc, 350, 250);
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
    public void drawScreen(int n, int n2, float f) {
        this.drawDefaultBackground();
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc._h._a(this.resource);
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, 252, 195);
        this.drawTexturedModalRect(this.guiLeft + 252, this.guiTop, 188, 0, 67, 195);
        super.drawScreen(n, n2, f);
        this.topMenu.drawScreen(n, n2, f);
        if (this.noQuests) {
            this.fontRenderer._b("You have no active quests", this.guiLeft + 84, this.guiTop + 80, 0x404040);
        } else {
            for (GuiMenuSideButton guiMenuSideButton : this.sideButtons.values().toArray(new GuiMenuSideButton[this.sideButtons.size()])) {
                guiMenuSideButton.drawButton(this.mc, n, n2);
            }
            this.scroll.drawScreen(n, n2, f);
            if (this.data.hasSelectedQuest()) {
                this.yoffset = this.guiTop + 5;
                this.drawProgress();
                this.textArea.setLocation(new Point(this.textArea.getLocation().x, this.yoffset * 2 + 8));
            }
        }
        this.elementsList.drawComponent(new Point(n, n2), f);
    }

    @Override
    public void updateScreen() {
        super.updateScreen();
        if (this.data.hasSelectedQuest()) {
            this.textArea.setText(NoppesStringUtils.formatText(this.data.getQuestText(), this.player.username));
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
        String string = NoppesStringUtils.formatText(this.data.getQuestText(), this.player.username);
        String string2 = "";
        for (char c : string.toCharArray()) {
            if (c != '\r' && c != '\n') {
                if (this.fontRenderer._b(string2 + c) > 176) {
                    this.fontRenderer._b(string2, n2, this.yoffset + n * this.fontRenderer._c, 0x404040);
                    string2 = "";
                    ++n;
                }
                string2 = string2 + c;
                continue;
            }
            this.fontRenderer._b(string2, n2, this.yoffset + n * this.fontRenderer._c, 0x404040);
            string2 = "";
            ++n;
        }
        this.fontRenderer._b(string2, n2, this.yoffset + n * this.fontRenderer._c, 0x404040);
    }

    private void drawProgress() {
        int n = this.guiLeft + 152;
        for (String string : this.data.getQuestStatus()) {
            this.fontRenderer._b(string, n, this.yoffset, 0x404040);
            this.yoffset += 10;
        }
    }

    protected void drawGuiContainerBackgroundLayer(float f, int n, int n2) {
    }

    @Override
    public void mouseClicked(int n, int n2, int n3) {
        super.mouseClicked(n, n2, n3);
        this.topMenu.mouseClicked(n, n2, n3);
        if (n3 == 0) {
            if (this.scroll != null) {
                this.scroll.mouseClicked(n, n2, n3);
            }
            for (GuiMenuSideButton guiMenuSideButton : this.sideButtons.values().toArray(new GuiMenuSideButton[this.sideButtons.size()])) {
                if (!guiMenuSideButton.mousePressed(this.mc, n, n2)) continue;
                this.sideButtonPressed(guiMenuSideButton);
            }
        }
        this.elementsList.mouseClicked(n3);
    }

    private void sideButtonPressed(GuiMenuSideButton guiMenuSideButton) {
        if (!guiMenuSideButton.active) {
            this.mc._N._a("random.click", 1.0f, 1.0f);
            this.data.selectedCategory = guiMenuSideButton.displayString;
            this.data.selectedQuest = "";
            this.initGui();
        }
    }

    @Override
    public void customScrollClicked(int n, int n2, int n3, GuiCustomScroll guiCustomScroll) {
        if (guiCustomScroll.hasSelected()) {
            this.data.selectedQuest = guiCustomScroll.getSelected();
        }
    }

    @Override
    protected void keyTyped(char c, int n) {
        if (n == 1 || n == this.mc._M.keyBindInventory._d) {
            this.mc._a((GuiScreen)null);
            this.mc._o();
        }
        this.elementsList.keyTyped(c, n);
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

    @Override
    public void setGuiData(NBTTagCompound nBTTagCompound) {
        QuestLogData questLogData = new QuestLogData();
        questLogData.readNBT(nBTTagCompound);
        this.data = questLogData;
        this.initGui();
    }

    @Override
    public GuiScreen getGui() {
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

