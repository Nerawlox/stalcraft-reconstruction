/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.player;

import gloomyfolken.mods.money.zwat;
import net.minecraft.util.ResourceLocation;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.gui.util.GuiContainerNPCInterface;
import noppes.npcs.containers.ContainerNPCTrader;
import noppes.npcs.roles.RoleTrader;
import org.lwjgl.opengl.GL11;

public class GuiNPCTrader
extends GuiContainerNPCInterface {
    private final ResourceLocation resource = new ResourceLocation("customnpcs", "textures/gui/npctrader.png");
    private RoleTrader role;

    public GuiNPCTrader(EntityNPCInterface entityNPCInterface, ContainerNPCTrader containerNPCTrader) {
        super(entityNPCInterface, containerNPCTrader);
        this.role = (RoleTrader)entityNPCInterface.roleInterface;
        this.closeOnEsc = true;
        this.field_74195_c = 232;
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
    }

    @Override
    protected void func_74185_a(float f, int n, int n2) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.field_73882_e._h._a(this.resource);
        int n3 = (this.field_73880_f - this.field_74194_b) / 2;
        int n4 = (this.field_73881_g - this.field_74195_c) / 2;
        this.func_73729_b(n3, n4, 0, 0, this.field_74194_b, this.field_74195_c);
        this.func_73732_a(this.field_73886_k, "\u0421\u0447\u0435\u0442: " + zwat._a(this.player)._b(), this.field_74198_m + 127, this.field_74197_n + 4, 0xFFFFFF);
        yeso yeso2 = this.getTheSlot(n, n2);
        if (yeso2 != null && yeso2.func_75216_d()) {
            if (yeso2.field_75222_d < 63) {
                int n5 = this.role.sellPrices[yeso2.field_75222_d];
                String string = "\u0426\u0435\u043d\u0430 \u043f\u043e\u043a\u0443\u043f\u043a\u0438: " + n5 + "\u0440\u0443\u0431.";
                this.func_73732_a(this.field_73886_k, string, this.field_74198_m + 48, this.field_74197_n + 4, (long)n5 > zwat._a(this.player)._a() ? 0xAA1111 : 0xFFFFFF);
            } else {
                int n6 = this.role.getBuyPrice(yeso2.func_75211_c());
                if (n6 > 0) {
                    String string = "\u0426\u0435\u043d\u0430 \u043f\u0440\u043e\u0434\u0430\u0436\u0438: " + n6 + "\u0440\u0443\u0431.";
                    this.func_73732_a(this.field_73886_k, string, this.field_74198_m + 48, this.field_74197_n + 4, 0xFFFFFF);
                }
            }
        }
        this.func_73732_a(this.field_73886_k, "\u0427\u0442\u043e\u0431\u044b \u043f\u0440\u043e\u0434\u0430\u0442\u044c \u043f\u0440\u0435\u0434\u043c\u0435\u0442, \u043a\u043b\u0438\u043a\u043d\u0438\u0442\u0435 \u043f\u043e \u043d\u0435\u043c\u0443 \u041f\u041a\u041c", this.field_73880_f / 2, this.field_74197_n - 12, 0xFFFFFF);
    }

    private yeso getTheSlot(int n, int n2) {
        for (int i = 0; i < this.field_74193_d.field_75151_b.size(); ++i) {
            yeso yeso2 = (yeso)this.field_74193_d.field_75151_b.get(i);
            if (!this.func_74188_c(yeso2.field_75223_e, yeso2.field_75221_f, 16, 16, n, n2) || !yeso2.func_111238_b()) continue;
            return yeso2;
        }
        return null;
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        super.func_73863_a(n, n2, f);
    }

    @Override
    public void save() {
    }
}

