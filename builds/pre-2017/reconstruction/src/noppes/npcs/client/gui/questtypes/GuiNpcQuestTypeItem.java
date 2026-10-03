/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.questtypes;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.gui.global.GuiNPCManageQuest;
import noppes.npcs.client.gui.util.GuiContainerNPCInterface;
import noppes.npcs.client.gui.util.GuiNpcButton;
import noppes.npcs.client.gui.util.GuiNpcTextField;
import noppes.npcs.client.gui.util.ITextfieldListener;
import noppes.npcs.containers.ContainerNpcQuestTypeItem;
import noppes.npcs.controllers.Quest;
import org.lwjgl.opengl.GL11;

public class GuiNpcQuestTypeItem
extends GuiContainerNPCInterface
implements ITextfieldListener {
    private static final ResourceLocation craftingTableGuiTextures = new ResourceLocation("customnpcs", "textures/gui/followersetup.png");
    private Quest quest = GuiNPCManageQuest.quest;

    public GuiNpcQuestTypeItem(EntityNPCInterface entityNPCInterface, ContainerNpcQuestTypeItem containerNpcQuestTypeItem) {
        super(entityNPCInterface, containerNpcQuestTypeItem);
        this.title = "Quest Item Setup";
        this.ySize = 202;
    }

    @Override
    public void initGui() {
        super.initGui();
        this.addButton(new GuiNpcButton(5, this.guiLeft, this.guiTop + this.ySize, 98, 20, "gui.back"));
    }

    @Override
    public void actionPerformed(GuiButton guiButton) {
        if (guiButton.id == 5) {
            NoppesUtil.openGUI(this.player, GuiNPCManageQuest.Instance);
        }
    }

    @Override
    public void onGuiClosed() {
    }

    @Override
    protected void keyTyped(char c, int n) {
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int n, int n2) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc._h._a(craftingTableGuiTextures);
        int n3 = (this.width - this.xSize) / 2;
        int n4 = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(n3, n4, 0, 0, this.xSize, this.ySize);
        super.drawGuiContainerBackgroundLayer(f, n, n2);
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        super.drawScreen(n, n2, f);
    }

    @Override
    public void save() {
    }

    @Override
    public void unFocused(GuiNpcTextField guiNpcTextField) {
        this.quest.rewardExp = guiNpcTextField.getInteger();
    }
}

