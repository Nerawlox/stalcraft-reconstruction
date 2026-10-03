/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import net.minecraft.client.xpzm;
import net.minecraft.entity.amww;
import net.minecraft.util.ResourceLocation;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.client.gui.util.GuiNpcButton;
import noppes.npcs.constants.EnumPacketType;
import noppes.npcs.containers.ContainerMerchantAdd;
import noppes.npcs.events.ItemInteractEvent;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class GuiMerchantAdd
extends zybc {
    private static final ResourceLocation merchantGuiTextures = new ResourceLocation("textures/gui/container/villager.png");
    private amww theIMerchant = ItemInteractEvent.Merchant;
    private pkae nextRecipeButtonIndex;
    private pkae previousRecipeButtonIndex;
    private int currentRecipeIndex;
    private String field_94082_v = wpcz._a("entity.Villager.name");

    public GuiMerchantAdd() {
        super(new ContainerMerchantAdd(xpzm._E()._t.field_71071_by, ItemInteractEvent.Merchant, xpzm._E()._r));
    }

    static ResourceLocation func_110417_h() {
        return merchantGuiTextures;
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
        int n = (this.field_73880_f - this.field_74194_b) / 2;
        int n2 = (this.field_73881_g - this.field_74195_c) / 2;
        this.nextRecipeButtonIndex = new pkae(1, n + 120 + 27, n2 + 24 - 1, true);
        this.field_73887_h.add(this.nextRecipeButtonIndex);
        this.previousRecipeButtonIndex = new pkae(2, n + 36 - 19, n2 + 24 - 1, false);
        this.field_73887_h.add(this.previousRecipeButtonIndex);
        this.field_73887_h.add(new GuiNpcButton(4, n + this.field_74194_b, n2 + 20, 60, 20, "gui.remove"));
        this.field_73887_h.add(new GuiNpcButton(5, n + this.field_74194_b, n2 + 50, 60, 20, "gui.add"));
        this.nextRecipeButtonIndex.field_73742_g = false;
        this.previousRecipeButtonIndex.field_73742_g = false;
    }

    @Override
    protected void func_74189_g(int n, int n2) {
        this.field_73886_k._b(this.field_94082_v, this.field_74194_b / 2 - this.field_73886_k._b(this.field_94082_v) / 2, 6, 0x404040);
        this.field_73886_k._b(wpcz._a("container.inventory"), 8, this.field_74195_c - 96 + 2, 0x404040);
    }

    @Override
    public void func_73876_c() {
        super.func_73876_c();
        ywfi ywfi2 = this.theIMerchant.func_70934_b(this.field_73882_e._t);
        if (ywfi2 != null) {
            this.nextRecipeButtonIndex.field_73742_g = this.currentRecipeIndex < ywfi2.size() - 1;
            this.previousRecipeButtonIndex.field_73742_g = this.currentRecipeIndex > 0;
        }
    }

    @Override
    protected void func_73875_a(jiok jiok2) {
        Object object;
        Object object2;
        boolean bl = false;
        if (jiok2 == this.nextRecipeButtonIndex) {
            ++this.currentRecipeIndex;
            bl = true;
        } else if (jiok2 == this.previousRecipeButtonIndex) {
            --this.currentRecipeIndex;
            bl = true;
        }
        if (jiok2.field_73741_f == 4 && this.currentRecipeIndex < ((ArrayList)(object2 = this.theIMerchant.func_70934_b(this.field_73882_e._t))).size()) {
            ((ArrayList)object2).remove(this.currentRecipeIndex);
            if (this.currentRecipeIndex > 0) {
                --this.currentRecipeIndex;
            }
            NoppesUtil.sendData(EnumPacketType.MerchantUpdate, ItemInteractEvent.Merchant.field_70157_k, object2);
        }
        if (jiok2.field_73741_f == 5) {
            object2 = this.field_74193_d.func_75139_a(0).func_75211_c();
            object = this.field_74193_d.func_75139_a(1).func_75211_c();
            cvzo cvzo2 = this.field_74193_d.func_75139_a(2).func_75211_c();
            if (object2 == null && object != null) {
                object2 = object;
                object = null;
            }
            if (object2 != null && cvzo2 != null) {
                object2 = ((cvzo)object2)._l();
                cvzo2 = cvzo2._l();
                if (object != null) {
                    object = ((cvzo)object)._l();
                }
                ozjk ozjk2 = new ozjk((cvzo)object2, (cvzo)object, cvzo2);
                ozjk2._a(0x7FFFFFF7);
                ywfi ywfi2 = this.theIMerchant.func_70934_b(this.field_73882_e._t);
                ywfi2.add(ozjk2);
                NoppesUtil.sendData(EnumPacketType.MerchantUpdate, ItemInteractEvent.Merchant.field_70157_k, ywfi2);
            }
        }
        if (bl) {
            ((ContainerMerchantAdd)this.field_74193_d).setCurrentRecipeIndex(this.currentRecipeIndex);
            object2 = new ByteArrayOutputStream();
            object = new DataOutputStream((OutputStream)object2);
            try {
                ((DataOutputStream)object).writeInt(this.currentRecipeIndex);
                this.field_73882_e._z()._b(new jjqf("MC|TrSel", ((ByteArrayOutputStream)object2).toByteArray()));
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    @Override
    protected void func_74185_a(float f, int n, int n2) {
        int n3;
        ozjk ozjk2;
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.field_73882_e._R()._a(merchantGuiTextures);
        int n4 = (this.field_73880_f - this.field_74194_b) / 2;
        int n5 = (this.field_73881_g - this.field_74195_c) / 2;
        this.func_73729_b(n4, n5, 0, 0, this.field_74194_b, this.field_74195_c);
        ywfi ywfi2 = this.theIMerchant.func_70934_b(this.field_73882_e._t);
        if (ywfi2 != null && !ywfi2.isEmpty() && (ozjk2 = (ozjk)ywfi2.get(n3 = this.currentRecipeIndex))._f()) {
            this.field_73882_e._R()._a(merchantGuiTextures);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            GL11.glDisable(2896);
            this.func_73729_b(this.field_74198_m + 83, this.field_74197_n + 21, 212, 0, 28, 21);
            this.func_73729_b(this.field_74198_m + 83, this.field_74197_n + 51, 212, 0, 28, 21);
        }
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        super.func_73863_a(n, n2, f);
        ywfi ywfi2 = this.theIMerchant.func_70934_b(this.field_73882_e._t);
        if (ywfi2 != null && !ywfi2.isEmpty()) {
            int n3 = (this.field_73880_f - this.field_74194_b) / 2;
            int n4 = (this.field_73881_g - this.field_74195_c) / 2;
            int n5 = this.currentRecipeIndex;
            ozjk ozjk2 = (ozjk)ywfi2.get(n5);
            GL11.glPushMatrix();
            cvzo cvzo2 = ozjk2._a();
            cvzo cvzo3 = ozjk2._b();
            cvzo cvzo4 = ozjk2._d();
            qnon._c();
            GL11.glDisable(2896);
            GL11.glEnable(32826);
            GL11.glEnable(2903);
            GL11.glEnable(2896);
            zybc.field_74196_a.field_77023_b = 100.0f;
            zybc.field_74196_a.func_82406_b(this.field_73886_k, this.field_73882_e._R(), cvzo2, n3 + 36, n4 + 24);
            zybc.field_74196_a.func_77021_b(this.field_73886_k, this.field_73882_e._R(), cvzo2, n3 + 36, n4 + 24);
            if (cvzo3 != null) {
                zybc.field_74196_a.func_82406_b(this.field_73886_k, this.field_73882_e._R(), cvzo3, n3 + 62, n4 + 24);
                zybc.field_74196_a.func_77021_b(this.field_73886_k, this.field_73882_e._R(), cvzo3, n3 + 62, n4 + 24);
            }
            zybc.field_74196_a.func_82406_b(this.field_73886_k, this.field_73882_e._R(), cvzo4, n3 + 120, n4 + 24);
            zybc.field_74196_a.func_77021_b(this.field_73886_k, this.field_73882_e._R(), cvzo4, n3 + 120, n4 + 24);
            zybc.field_74196_a.field_77023_b = 0.0f;
            GL11.glDisable(2896);
            if (this.func_74188_c(36, 24, 16, 16, n, n2)) {
                this.func_74184_a(cvzo2, n, n2);
            } else if (cvzo3 != null && this.func_74188_c(62, 24, 16, 16, n, n2)) {
                this.func_74184_a(cvzo3, n, n2);
            } else if (this.func_74188_c(120, 24, 16, 16, n, n2)) {
                this.func_74184_a(cvzo4, n, n2);
            }
            GL11.glPopMatrix();
            GL11.glEnable(2896);
            GL11.glEnable(2929);
            qnon._b();
        }
    }

    public amww getIMerchant() {
        return this.theIMerchant;
    }
}

