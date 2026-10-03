/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.questtypes;

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
    private static final ResourceLocation field_110422_t = new ResourceLocation("customnpcs", "textures/gui/followersetup.png");
    private Quest quest = GuiNPCManageQuest.quest;

    public GuiNpcQuestTypeItem(EntityNPCInterface entityNPCInterface, ContainerNpcQuestTypeItem containerNpcQuestTypeItem) {
        super(entityNPCInterface, containerNpcQuestTypeItem);
        this.title = "Quest Item Setup";
        this.field_74195_c = 202;
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
        this.addButton(new GuiNpcButton(5, this.field_74198_m, this.field_74197_n + this.field_74195_c, 98, 20, "gui.back"));
    }

    @Override
    public void func_73875_a(jiok jiok2) {
        if (jiok2.field_73741_f == 5) {
            NoppesUtil.openGUI(this.player, GuiNPCManageQuest.Instance);
        }
    }

    @Override
    public void func_73874_b() {
    }

    @Override
    protected void func_73869_a(char c, int n) {
    }

    @Override
    protected void func_74185_a(float f, int n, int n2) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.field_73882_e._h._a(field_110422_t);
        int n3 = (this.field_73880_f - this.field_74194_b) / 2;
        int n4 = (this.field_73881_g - this.field_74195_c) / 2;
        this.func_73729_b(n3, n4, 0, 0, this.field_74194_b, this.field_74195_c);
        super.func_74185_a(f, n, n2);
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        super.func_73863_a(n, n2, f);
    }

    @Override
    public void save() {
    }

    @Override
    public void unFocused(GuiNpcTextField guiNpcTextField) {
        this.quest.rewardExp = guiNpcTextField.getInteger();
    }
}

