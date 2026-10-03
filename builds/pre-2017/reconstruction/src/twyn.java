/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.world.World;

@SideOnly(value=Side.CLIENT)
public class twyn
extends TextureAtlasSprite {
    public double _a;
    public double _b;

    public twyn(String string) {
        super(string);
    }

    public void _a() {
        Minecraft minecraft = Minecraft._E();
        if (minecraft._r != null && minecraft._t != null) {
            this._a(minecraft._r, minecraft._t.posX, minecraft._t.posZ, minecraft._t.rotationYaw, false, false);
        } else {
            this._a(null, 0.0, 0.0, 0.0, true, false);
        }
    }

    public void _a(World world, double d, double d2, double d3, boolean bl, boolean bl2) {
    }
}

