/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.roles;

import net.minecraft.util.ResourceLocation;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.gui.util.GuiContainerNPCInterface2;
import noppes.npcs.client.gui.util.GuiNpcButton;
import noppes.npcs.constants.EnumPacketType;
import noppes.npcs.containers.ContainerNpcExchangerSetup;
import noppes.npcs.roles.RoleExchanger;
import org.lwjgl.opengl.GL11;

public class GuiNpcExchangerSetup
extends GuiContainerNPCInterface2 {
    public ResourceLocation location = new ResourceLocation("customnpcs", "textures/gui/npcexchangersetup.png");

    public GuiNpcExchangerSetup(EntityNPCInterface entityNPCInterface, ContainerNpcExchangerSetup containerNpcExchangerSetup) {
        super(entityNPCInterface, containerNpcExchangerSetup);
        this.field_74195_c = 180;
        this.setBackground("npctradersetup.png");
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
        this.addButton(new GuiNpcButton(1, this.field_73880_f / 2 - 200, this.field_73881_g / 2 - 75, 100, 20, new String[]{"\u041f\u0440\u043e\u0432\u0435\u0440\u044f\u0442\u044c NBT: \u041d\u0435\u0442", "\u041f\u0440\u043e\u0432\u0435\u0440\u044f\u0442\u044c NBT: \u0414\u0430"}, ((RoleExchanger)this.npc.roleInterface).checkNbt ? 1 : 0));
    }

    @Override
    protected void func_73875_a(jiok jiok2) {
        super.func_73875_a(jiok2);
        if (jiok2.field_73741_f == 1) {
            ((RoleExchanger)this.npc.roleInterface).checkNbt = ((GuiNpcButton)jiok2).getValue() == 1;
        }
    }

    @Override
    protected void func_74185_a(float f, int n, int n2) {
        super.func_74185_a(f, n, n2);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.field_73882_e._h._a(this.location);
        this.func_73729_b(this.field_73880_f / 2 - 20, this.field_73881_g / 2 - 80, 0, 0, 167, 156);
        for (int i = 0; i < 18; ++i) {
            int n3 = this.field_73880_f / 2 + 3 + i % 3 * 59;
            int n4 = this.field_73881_g / 2 - 75 + i / 3 * 22;
            this.field_73886_k._b("=", n3, n4 + 4, 0x404040);
        }
    }

    @Override
    public void save() {
        NoppesUtil.sendData(EnumPacketType.MainmenuAdvancedSave, this.npc.advanced.writeToNBT(new qoac()));
    }
}

