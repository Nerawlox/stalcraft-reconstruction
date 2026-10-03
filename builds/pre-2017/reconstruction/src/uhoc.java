/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.util.Vec3;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.event.ForgeSubscribe;

public class uhoc {
    public static final uhoc _a = new uhoc();
    public boolean _b = false;

    @ForgeSubscribe
    public void _a(MouseEvent mouseEvent) {
        if (!this._b || mouseEvent.button != 1 || !mouseEvent.buttonstate) {
            return;
        }
        Minecraft minecraft = Minecraft._E();
        if (minecraft._t == null || minecraft._r == null) {
            return;
        }
        float f = 200.0f;
        float f2 = 0.2f;
        Vec3 vec3 = minecraft._t.getLookVec();
        for (float f3 = 0.0f; f3 < f; f3 += f2) {
            int n = (int)(vec3._c * (double)f3 + minecraft._t.posX + 0.5);
            int n2 = (int)(vec3._d * (double)f3 + minecraft._t.posY + 0.5);
            int n3 = (int)(vec3._e * (double)f3 + minecraft._t.posZ + 0.5);
            for (int i = n - 1; i < n + 1; ++i) {
                for (int j = n2 - 1; j < n2 + 1; ++j) {
                    for (int k = n3 - 1; k < n3 + 1; ++k) {
                        if (!this._a(i, j, k)) continue;
                        return;
                    }
                }
            }
        }
    }

    private boolean _a(int n, int n2, int n3) {
        pkix pkix2 = Minecraft._E()._r;
        int n4 = pkix2.getBlockId(n, n2, n3);
        if (Block.blocksList[n4] instanceof uyqj) {
            new dxaa(pkix2.provider._i, n, n2, n3).sendToServer();
            return true;
        }
        return false;
    }
}

