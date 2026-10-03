/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.entity.player.UseHoeEvent;

public class zhxn
extends tgdv {
    public txfz _a;

    public zhxn(int n, txfz txfz2) {
        super(n);
        this._a = txfz2;
        this.field_77777_bU = 1;
        this.func_77656_e(txfz2._a());
        this.func_77637_a(tgbl.field_78040_i);
    }

    @Override
    public boolean func_77648_a(cvzo cvzo2, EntityPlayer entityPlayer, ozlu ozlu2, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        if (!entityPlayer.func_82247_a(n, n2, n3, n4, cvzo2)) {
            return false;
        }
        UseHoeEvent useHoeEvent = new UseHoeEvent(entityPlayer, cvzo2, ozlu2, n, n2, n3);
        if (MinecraftForge.EVENT_BUS.post(useHoeEvent)) {
            return false;
        }
        if (useHoeEvent.getResult() == Event.Result.ALLOW) {
            cvzo2._a(1, (EntityLivingBase)entityPlayer);
            return true;
        }
        int n5 = ozlu2.func_72798_a(n, n2, n3);
        boolean bl = ozlu2.func_72799_c(n, n2 + 1, n3);
        if (n4 != 0 && bl && (n5 == twgu.field_71980_u.field_71990_ca || n5 == twgu.field_71979_v.field_71990_ca)) {
            twgu twgu2 = twgu.field_72050_aA;
            ozlu2.func_72908_a((float)n + 0.5f, (float)n2 + 0.5f, (float)n3 + 0.5f, twgu2.field_72020_cn._d(), (twgu2.field_72020_cn._a() + 1.0f) / 2.0f, twgu2.field_72020_cn._b() * 0.8f);
            if (ozlu2.field_72995_K) {
                return true;
            }
            ozlu2.func_94575_c(n, n2, n3, twgu2.field_71990_ca);
            cvzo2._a(1, (EntityLivingBase)entityPlayer);
            return true;
        }
        return false;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public boolean func_77662_d() {
        return true;
    }

    public String _a() {
        return this._a.toString();
    }
}

