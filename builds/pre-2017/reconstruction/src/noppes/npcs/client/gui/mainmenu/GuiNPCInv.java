/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.mainmenu;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.inventory.Slot;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.sajh;
import net.minecraft.util.tdpx;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.gui.global.GuiNpcRandomEquip;
import noppes.npcs.client.gui.util.GuiContainerNPCInterface2;
import noppes.npcs.client.gui.util.GuiNpcButton;
import noppes.npcs.client.gui.util.GuiNpcLabel;
import noppes.npcs.client.gui.util.GuiNpcSlider;
import noppes.npcs.client.gui.util.GuiNpcTextField;
import noppes.npcs.client.gui.util.IGuiData;
import noppes.npcs.client.gui.util.NpcTextFieldDecimal;
import noppes.npcs.constants.EnumPacketType;
import noppes.npcs.containers.ContainerNPCInv;
import org.lwjgl.opengl.GL11;

public class GuiNPCInv
extends GuiContainerNPCInterface2
implements IGuiData {
    private static final int GROUPS = 27;
    private HashMap<Integer, Double> chances = new HashMap();
    private Map<Integer, Integer> groups = new HashMap<Integer, Integer>();
    private ContainerNPCInv container;
    private ResourceLocation slot;
    protected boolean npcAccess;

    public GuiNPCInv(EntityNPCInterface entityNPCInterface, ContainerNPCInv containerNPCInv) {
        super(entityNPCInterface, containerNPCInv, 3);
        this.setBackground("npcinv.png");
        this.setBackgroundSize(new Dimension(512, 256), new Dimension(512, 256));
        this.container = containerNPCInv;
        this.ySize = 200;
        this.slot = this.getResource("slot.png");
        NoppesUtil.sendData(EnumPacketType.MainmenuInvGet, new Object[0]);
        NoppesUtil.sendData(EnumPacketType.NpcAccess, new Object[0]);
    }

    @Override
    public void initGui() {
        super.initGui();
        this.addLabel(new GuiNpcLabel(2, "inv.npcInventory", this.guiTop + 191, this.guiLeft + 5, 0x404040));
        this.addLabel(new GuiNpcLabel(3, "inv.inventory", this.guiTop + 8, this.guiLeft + 101, 0x404040));
        this.addButton(new GuiNpcButton(5, this.guiTop + 100, this.guiLeft + 18, 80, 20, new String[]{"\u0421\u043b\u0443\u0447\u0430\u0439\u043d\u043e\u0435 \u0441\u043d\u0430\u0440\u044f\u0436\u0435\u043d\u0438\u0435: \u041d\u0435\u0442", "\u0421\u043b\u0443\u0447\u0430\u0439\u043d\u043e\u0435 \u0441\u043d\u0430\u0440\u044f\u0436\u0435\u043d\u0438\u0435: \u0414\u0430"}, this.npc.inventory.randomEquipSettings.enabled ? 1 : 0));
        if (this.npc.inventory.randomEquipSettings.enabled) {
            this.addButton(new GuiNpcButton(6, this.guiTop + 100, this.guiLeft + 40, 80, 20, "\u041d\u0430\u0441\u0442\u0440\u043e\u0438\u0442\u044c"));
        }
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 8; ++j) {
                double d = 100.0;
                int n = i * 8 + j;
                if (this.npc.inventory.dropchance.containsKey(n)) {
                    double d2 = this.npc.inventory.dropchance.get(n);
                    d = sajh._a((float)d2, 0.0f, 100.0f);
                }
                int n2 = this.guiTop + 210 + i * 72;
                int n3 = this.guiLeft + 16 + j * 22;
                NpcTextFieldDecimal npcTextFieldDecimal = new NpcTextFieldDecimal(n + 2, this, this.fontRenderer, n2, n3, 35, 18, String.format(Locale.ROOT, "%.2f", d));
                this.addTextField(npcTextFieldDecimal);
                npcTextFieldDecimal.numbersOnly = true;
                npcTextFieldDecimal.setMinMaxDefault(0, 100, 0);
                int n4 = sajh._a(this.npc.inventory.dropGroups.getOrDefault(n, 0), 0, 27);
                this.buttonList.add(new GroupSelectionButton(n + 100, n2 + 37, n3, 15, 15, n4));
                this.chances.put(n, d);
                this.groups.put(n, n4);
            }
        }
        if (!this.npcAccess) {
            for (GuiButton guiButton : this.buttonList) {
                guiButton.enabled = false;
            }
            for (GuiNpcTextField guiNpcTextField : this.menu.getAllTextfields()) {
                guiNpcTextField.enabled = false;
            }
        }
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int n, int n2) {
        super.drawGuiContainerBackgroundLayer(f, n, n2);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc._h._a(this.slot);
        for (int i = 4; i <= 6; ++i) {
            Slot slot = this.container.getSlot(i);
            if (!slot.getHasStack()) continue;
            this.drawTexturedModalRect(this.guiTop + slot.xDisplayPosition - 1, this.guiLeft + slot.yDisplayPosition - 1, 0, 0, 20, 20);
        }
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        super.drawScreen(n, n2, f);
        GL11.glEnable(2929);
        int n3 = this.npc.display.showName;
        this.npc.display.showName = 1;
        int n4 = this.guiTop + 20;
        int n5 = this.height / 2 - 145;
        GL11.glEnable(32826);
        GL11.glEnable(2903);
        GL11.glPushMatrix();
        GL11.glTranslatef(n4 + 33, n5 + 131, 50.0f);
        float f2 = 150.0f / (float)this.npc.display.modelSize;
        GL11.glScalef(-f2, f2, f2);
        GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
        float f3 = this.npc.renderYawOffset;
        float f4 = this.npc.rotationYaw;
        float f5 = this.npc.rotationPitch;
        float f6 = (float)(n4 + 33) - (float)n;
        float f7 = (float)(n5 + 131 - 50) - (float)n2;
        GL11.glRotatef(135.0f, 0.0f, 1.0f, 0.0f);
        qnon._b();
        GL11.glRotatef(-135.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-((float)Math.atan(f7 / 40.0f)) * 20.0f, 1.0f, 0.0f, 0.0f);
        this.npc.renderYawOffset = (float)Math.atan(f6 / 40.0f) * 20.0f;
        this.npc.rotationYaw = (float)Math.atan(f6 / 40.0f) * 40.0f;
        this.npc.rotationPitch = -((float)Math.atan(f7 / 40.0f)) * 20.0f;
        this.npc.rotationYawHead = this.npc.rotationYaw;
        GL11.glTranslatef(0.0f, this.npc.yOffset, 0.0f);
        RenderManager._b._l = 180.0f;
        RenderManager._b._a(this.npc, 0.0, 0.0, 0.0, 0.0f, 1.0f);
        this.npc.renderYawOffset = f3;
        this.npc.rotationYaw = f4;
        this.npc.rotationPitch = f5;
        GL11.glPopMatrix();
        qnon._a();
        GL11.glDisable(32826);
        iwya._a(iwya._b);
        GL11.glDisable(3553);
        iwya._a(iwya._a);
        this.npc.display.showName = n3;
    }

    @Override
    protected void actionPerformed(GuiButton guiButton) {
        super.actionPerformed(guiButton);
        if (guiButton.id == 5) {
            this.npc.inventory.randomEquipSettings.enabled = ((GuiNpcButton)guiButton).getValue() == 1;
            this.initGui();
        }
        if (guiButton.id == 6) {
            NoppesUtil.openGUI(this.player, new GuiNpcRandomEquip(this.npc));
        }
    }

    @Override
    public void save() {
        Gui gui;
        for (int i = 0; i < 24; ++i) {
            int n = i + 2;
            gui = this.getTextField(n);
            if (gui == null) continue;
            this.chances.put(i, ((NpcTextFieldDecimal)gui).getDouble());
        }
        for (Object e : this.buttonList) {
            if (!(e instanceof GroupSelectionButton)) continue;
            gui = (GroupSelectionButton)e;
            int n = ((GuiButton)gui).id - 100;
            this.groups.put(n, ((GroupSelectionButton)gui).groupIndex);
        }
        this.npc.inventory.dropchance = this.chances;
        this.npc.inventory.dropGroups = this.groups;
        NoppesUtil.sendData(EnumPacketType.MainmenuInvSave, this.npc.inventory.writeEntityToNBT(new NBTTagCompound()));
    }

    @Override
    public void setGuiData(NBTTagCompound nBTTagCompound) {
        if (nBTTagCompound._c("NpcAccess")) {
            this.npcAccess = nBTTagCompound._o("NpcAccess");
        } else {
            this.npc.inventory.readEntityFromNBT(nBTTagCompound);
        }
        this.initGui();
    }

    @Override
    protected void mouseClicked(int n, int n2, int n3) {
        super.mouseClicked(n, n2, n3);
        if (n3 != 0) {
            for (Object e : this.buttonList) {
                boolean bl;
                if (!(e instanceof GroupSelectionButton)) continue;
                GroupSelectionButton groupSelectionButton = (GroupSelectionButton)e;
                if (!groupSelectionButton.enabled || !(bl = n >= groupSelectionButton.xPosition && n < groupSelectionButton.xPosition + groupSelectionButton.getWidth() && n2 >= groupSelectionButton.yPosition && n2 < groupSelectionButton.yPosition + groupSelectionButton.height)) continue;
                groupSelectionButton.updateGroup(false);
            }
        }
    }

    public void mouseDragged(GuiNpcSlider guiNpcSlider) {
        guiNpcSlider.displayString = tdpx._a("inv.dropChance") + ": " + (int)(guiNpcSlider.sliderValue * 100.0f) + "%";
    }

    public void mousePressed(GuiNpcSlider guiNpcSlider) {
    }

    private static String getTextFor(int n) {
        if (n == 0) {
            return "-";
        }
        return Character.toString((char)(64 + n));
    }

    private class GroupSelectionButton
    extends GuiButton {
        private int groupIndex;

        public GroupSelectionButton(int n, int n2, int n3, int n4, int n5, int n6) {
            super(n, n2, n3, n4, n5, GuiNPCInv.getTextFor(n6));
            this.groupIndex = 0;
            this.groupIndex = n6;
        }

        private void updateGroup(boolean bl) {
            this.groupIndex = bl ? (this.groupIndex + 1) % 27 : (this.groupIndex > 0 ? this.groupIndex - 1 : 26);
            this.displayString = GuiNPCInv.getTextFor(this.groupIndex);
        }

        @Override
        public boolean mousePressed(Minecraft minecraft, int n, int n2) {
            boolean bl = super.mousePressed(minecraft, n, n2);
            if (bl) {
                this.updateGroup(true);
            }
            return bl;
        }

        public int getWidth() {
            return this.width;
        }
    }
}

