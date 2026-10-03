/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.global;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiContainerAdvanced;
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.action.GuiActionTextFieldChanged;
import gloomyfolken.mods.core.client.gui.engine.component.McLabel;
import gloomyfolken.mods.core.client.gui.engine.component.McNumberField;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.RandomEquipSettings;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.constants.EnumPacketType;
import noppes.npcs.containers.ContainerRandomEquip;
import org.lwjgl.opengl.GL11;

public class GuiNpcRandomItems
extends GuiContainerAdvanced {
    public static final ResourceLocation texture = new ResourceLocation("customnpcs", "textures/gui/randomequip.png");
    private final RandomEquipSettings settings;
    private final EntityNPCInterface npc;

    public GuiNpcRandomItems(EntityNPCInterface entityNPCInterface, ContainerRandomEquip containerRandomEquip) {
        super(containerRandomEquip, GuiHelper.widgetsRenderer);
        this.npc = entityNPCInterface;
        this.settings = containerRandomEquip.settings;
        this.ySize = 210;
    }

    @Override
    public void initGui() {
        super.initGui();
        this.addElement(new McLabel((IAdvancedGui)this, "\u041e\u0440\u0443\u0436\u0438\u0435", new Point(this.guiLeft * 2 - 100, this.guiTop * 2 - 40)));
        this.addElement(new McLabel((IAdvancedGui)this, "\u0411\u0440\u043e\u043d\u044f", new Point(this.guiLeft * 2 + 190, this.guiTop * 2 - 40)));
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 6; ++j) {
                int n = i * 6 + j;
                Point point = new Point(this.guiLeft * 2 + i * 120 - 50, this.guiTop * 2 + j * 36);
                long l = this.settings.weights.getOrDefault(n, Float.valueOf(1.0f)).longValue();
                McNumberField mcNumberField = GuiHelper.createNumberField(this, point, l);
                mcNumberField.setSize(new Dimension(60, 30));
                this.addElement(mcNumberField);
                this.actionManager.registerActionHandler(mcNumberField, GuiActionTextFieldChanged.class, guiActionTextFieldChanged -> this.settings.weights.put(n, Float.valueOf(((McNumberField)guiActionTextFieldChanged.component).getValue())));
            }
        }
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int n, int n2) {
        GL11.glDisable(2896);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        Minecraft minecraft = Minecraft._E();
        htou htou2 = new htou(minecraft._M, minecraft._n, minecraft._o);
        minecraft._h._a(texture);
        this.drawTexturedModalRect(htou2._a() / 2 - this.xSize / 2, htou2._b() / 2 + 1, 0, 0, this.xSize, this.ySize);
        super.drawGuiContainerBackgroundLayer(f, n, n2);
    }

    @Override
    public void onGuiClosed() {
        super.onGuiClosed();
        NoppesUtil.sendData(EnumPacketType.MainmenuInvSave, this.npc.inventory.writeEntityToNBT(new NBTTagCompound()));
    }
}

