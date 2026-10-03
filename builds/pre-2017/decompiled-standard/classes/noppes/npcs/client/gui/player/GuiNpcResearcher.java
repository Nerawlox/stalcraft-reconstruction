/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.player;

import gloomyfolken.mods.core.client.gui.engine.GuiContainerAdvanced;
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.component.McButton;
import gloomyfolken.mods.core.misc.srli;
import net.minecraft.client.xpzm;
import net.minecraft.util.ResourceLocation;
import noppes.npcs.NoppesUtilPlayer;
import noppes.npcs.constants.EnumPlayerPacket;
import noppes.npcs.containers.ContainerNpcResearcher;
import org.lwjgl.opengl.GL11;

public class GuiNpcResearcher
extends GuiContainerAdvanced {
    public static final ResourceLocation texture = new ResourceLocation("customnpcs", "textures/gui/research.png");
    private McButton probeButton;
    private ContainerNpcResearcher researcherContainer;

    public GuiNpcResearcher(ContainerNpcResearcher containerNpcResearcher) {
        super(containerNpcResearcher);
        this.researcherContainer = containerNpcResearcher;
        this.field_74194_b = 175;
        this.field_74195_c = 152;
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
        this.probeButton = GuiHelper.addButton(this, this.screenWidth / 2 - 90, this.screenHeight / 2 - 54, 180, 32, "\u0418\u0441\u0441\u043b\u0435\u0434\u043e\u0432\u0430\u0442\u044c").onClick(guiActionButtonClick -> NoppesUtilPlayer.sendData(EnumPlayerPacket.ProbeItem, new Object[0]));
    }

    @Override
    public void func_73876_c() {
        super.func_73876_c();
        if (this.probeButton != null) {
            cvzo cvzo2 = this.researcherContainer.getSelectedStack();
            this.probeButton.setEnabled(cvzo2 != null && cvzo2._a() instanceof srli && !((srli)((Object)cvzo2._a()))._a(cvzo2));
        }
    }

    @Override
    protected void func_74185_a(float f, int n, int n2) {
        GL11.glDisable(2896);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        xpzm xpzm2 = xpzm._E();
        htou htou2 = new htou(xpzm2._M, xpzm2._n, xpzm2._o);
        xpzm2._h._a(texture);
        this.func_73729_b((htou2._a() - this.field_74194_b) / 2, (htou2._b() - this.field_74195_c) / 2, 0, 0, this.field_74194_b, this.field_74195_c);
        super.func_74185_a(f, n, n2);
    }
}

