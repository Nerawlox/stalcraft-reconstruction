/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.player;

import net.minecraft.util.ResourceLocation;
import noppes.npcs.client.gui.util.GuiContainerNPCInterface;
import noppes.npcs.containers.ContainerCarpentryBench;
import org.lwjgl.opengl.GL11;

public class GuiNpcCarpentryBench
extends GuiContainerNPCInterface {
    private final ResourceLocation resource = new ResourceLocation("customnpcs", "textures/gui/anvil.png");
    private ContainerCarpentryBench container;

    public GuiNpcCarpentryBench(ContainerCarpentryBench containerCarpentryBench) {
        super(null, containerCarpentryBench);
        this.container = containerCarpentryBench;
        this.title = "";
        this.field_73885_j = false;
        this.closeOnEsc = true;
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
    }

    @Override
    public void func_73875_a(jiok jiok2) {
        super.func_73875_a(jiok2);
    }

    @Override
    protected void func_74185_a(float f, int n, int n2) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.field_73882_e._h._a(this.resource);
        int n3 = (this.field_73880_f - this.field_74194_b) / 2;
        int n4 = (this.field_73881_g - this.field_74195_c) / 2;
        this.func_73729_b(n3, n4, 0, 0, this.field_74194_b, this.field_74195_c);
        super.func_74185_a(f, n, n2);
    }

    @Override
    public void save() {
    }
}

