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
import net.minecraft.client.xpzm;
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
        this.field_74195_c = 210;
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
        this.addElement(new McLabel((IAdvancedGui)this, "\u041e\u0440\u0443\u0436\u0438\u0435", new Point(this.field_74198_m * 2 - 100, this.field_74197_n * 2 - 40)));
        this.addElement(new McLabel((IAdvancedGui)this, "\u0411\u0440\u043e\u043d\u044f", new Point(this.field_74198_m * 2 + 190, this.field_74197_n * 2 - 40)));
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 6; ++j) {
                int n = i * 6 + j;
                Point point = new Point(this.field_74198_m * 2 + i * 120 - 50, this.field_74197_n * 2 + j * 36);
                long l = this.settings.weights.getOrDefault(n, Float.valueOf(1.0f)).longValue();
                McNumberField mcNumberField = GuiHelper.createNumberField(this, point, l);
                mcNumberField.setSize(new Dimension(60, 30));
                this.addElement(mcNumberField);
                this.actionManager.registerActionHandler(mcNumberField, GuiActionTextFieldChanged.class, guiActionTextFieldChanged -> this.settings.weights.put(n, Float.valueOf(((McNumberField)guiActionTextFieldChanged.component).getValue())));
            }
        }
    }

    @Override
    protected void func_74185_a(float f, int n, int n2) {
        GL11.glDisable(2896);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        xpzm xpzm2 = xpzm._E();
        htou htou2 = new htou(xpzm2._M, xpzm2._n, xpzm2._o);
        xpzm2._h._a(texture);
        this.func_73729_b(htou2._a() / 2 - this.field_74194_b / 2, htou2._b() / 2 + 1, 0, 0, this.field_74194_b, this.field_74195_c);
        super.func_74185_a(f, n, n2);
    }

    @Override
    public void func_73874_b() {
        super.func_73874_b();
        NoppesUtil.sendData(EnumPacketType.MainmenuInvSave, this.npc.inventory.writeEntityToNBT(new qoac()));
    }
}

