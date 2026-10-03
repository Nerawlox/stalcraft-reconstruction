/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.player;

import net.minecraft.util.ResourceLocation;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.gui.util.GuiContainerNPCInterface;
import noppes.npcs.containers.ContainerNpcExchanger;
import noppes.npcs.roles.RoleExchanger;
import org.lwjgl.opengl.GL11;

public class GuiNpcExchanger
extends GuiContainerNPCInterface {
    private final ResourceLocation resource = new ResourceLocation("customnpcs", "textures/gui/npcexchanger.png");
    private RoleExchanger exchanger;
    private ContainerNpcExchanger container;

    public GuiNpcExchanger(EntityNPCInterface entityNPCInterface, ContainerNpcExchanger containerNpcExchanger) {
        super(entityNPCInterface, containerNpcExchanger);
        this.exchanger = (RoleExchanger)entityNPCInterface.roleInterface;
        this.container = containerNpcExchanger;
        this.closeOnEsc = true;
        this.field_74195_c = 232;
    }

    @Override
    protected void func_74185_a(float f, int n, int n2) {
        this.func_73859_b(0);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.field_73882_e._h._a(this.resource);
        this.func_73729_b(this.field_74198_m, this.field_74197_n, 0, 0, this.field_74194_b, this.field_74195_c);
        GL11.glEnable(32826);
        for (int i = 0; i < 18; ++i) {
            cvzo cvzo2 = this.exchanger.invCurrency.items.get(i);
            cvzo cvzo3 = this.exchanger.invSold.items.get(i);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            if (cvzo2 == null || cvzo3 == null) continue;
            qnon._c();
            int n3 = this.field_74198_m + i % 3 * 45 + 10;
            int n4 = this.field_74197_n + i / 3 * 22 + 8;
            zybc.field_74196_a.func_77015_a(this.field_73886_k, this.field_73882_e._h, cvzo2, n3, n4);
            zybc.field_74196_a.func_77021_b(this.field_73886_k, this.field_73882_e._h, cvzo2, n3, n4);
            qnon._a();
            this.field_73886_k._b("=", n3 + 18, n4 + 4, 0x939393);
        }
        GL11.glDisable(32826);
        super.func_74185_a(f, n, n2);
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        super.func_73863_a(n, n2, f);
        for (int n3 : this.exchanger.invCurrency.items.keySet()) {
            cvzo cvzo2 = this.exchanger.invCurrency.items.get(n3);
            if (cvzo2 == null || this.exchanger.invSold.items.get(n3) == null) continue;
            int n4 = this.field_74198_m + n3 % 3 * 45 + 10;
            int n5 = this.field_74197_n + n3 / 3 * 22 + 8;
            if (n <= n4 || n >= n4 + 16 || n2 <= n5 || n2 >= n5 + 16) continue;
            this.func_74184_a(cvzo2, n, n2);
        }
    }

    @Override
    public void save() {
    }
}

