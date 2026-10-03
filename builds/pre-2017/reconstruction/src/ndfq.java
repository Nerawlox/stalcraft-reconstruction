/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.effects.client.mcsa.ezfc;
import gloomyfolken.mods.effects.client.mcsa.vjsq;
import gloomyfolken.mods.stalker.player.tupg;
import java.util.HashMap;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;

public class ndfq
extends iefv {
    private static HashMap<brhe, ndfq> _b = new HashMap();
    public final brhe _a;
    private static final String _c = "/assets/stalker/models/backpacks/";

    public ndfq(brhe brhe2) {
        super(_c, brhe2._f, brhe2._g);
        this._a = brhe2;
    }

    public static ndfq _a(brhe brhe2) {
        return _b.get(brhe2);
    }

    public void _a() {
        _b.put(this._a, this);
    }

    public void _a(ItemStack itemStack, ModelBiped modelBiped) {
        GL11.glPushMatrix();
        modelBiped.bipedBody.postRender(0.0625f);
        GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(0.0f, -1.4625f, 0.0f);
        this._e(itemStack).renderAll();
        GL11.glPopMatrix();
    }

    public void _a(ItemStack itemStack, ivtm ivtm2) {
        ezfc._a();
        vjsq._a(ivtm2, tupg._c._a((String)"body")._c);
        ezfc._a(0.0f, -1.4625f, 0.0f);
        this._e((ItemStack)itemStack)._c.renderAll();
        ezfc._b();
    }
}

