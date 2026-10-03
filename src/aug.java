/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  org.lwjgl.opengl.GL11
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.concurrent.Callable;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
class aug
implements Callable {
    final atv a;

    aug(atv par1Minecraft) {
        this.a = par1Minecraft;
    }

    public String a() {
        return GL11.glGetString((int)7937) + " GL version " + GL11.glGetString((int)7938) + ", " + GL11.glGetString((int)7936);
    }

    public Object call() {
        return this.a();
    }
}

