/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.renderer;

import carpentersblocks.renderer.BlockHandlerBase;
import carpentersblocks.util.handler.BlockHandler;
import org.lwjgl.opengl.GL11;

public class BlockHandlerCarpentersPressurePlate
extends BlockHandlerBase {
    @Override
    public void renderInventoryBlock(twgu twgu2, int n, int n2, htvc htvc2) {
        htvf htvf2 = htvc2.__aF;
        GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
        GL11.glTranslatef(-0.5f, -0.5f, -0.5f);
        htvc2._a(0.0, 0.375, 0.0, 1.0, 0.625, 1.0);
        htvf2.func_78382_b();
        htvf2.func_78375_b(0.0f, -1.0f, 0.0f);
        htvc2._a(twgu2, 0.0, 0.0, 0.0, twgu2.func_71851_a(0));
        htvf2.func_78381_a();
        htvf2.func_78382_b();
        htvf2.func_78375_b(0.0f, 1.0f, 0.0f);
        htvc2._b(twgu2, 0.0, 0.0, 0.0, twgu2.func_71851_a(1));
        htvf2.func_78381_a();
        htvf2.func_78382_b();
        htvf2.func_78375_b(0.0f, 0.0f, -1.0f);
        htvc2._c(twgu2, 0.0, 0.0, 0.0, BlockHandler.blockCarpentersBarrier.func_71851_a(2));
        htvf2.func_78381_a();
        htvf2.func_78382_b();
        htvf2.func_78375_b(0.0f, 0.0f, 1.0f);
        htvc2._d(twgu2, 0.0, 0.0, 0.0, BlockHandler.blockCarpentersBarrier.func_71851_a(3));
        htvf2.func_78381_a();
        htvf2.func_78382_b();
        htvf2.func_78375_b(-1.0f, 0.0f, 0.0f);
        htvc2._e(twgu2, 0.0, 0.0, 0.0, BlockHandler.blockCarpentersBarrier.func_71851_a(4));
        htvf2.func_78381_a();
        htvf2.func_78382_b();
        htvf2.func_78375_b(1.0f, 0.0f, 0.0f);
        htvc2._f(twgu2, 0.0, 0.0, 0.0, BlockHandler.blockCarpentersBarrier.func_71851_a(5));
        htvf2.func_78381_a();
        GL11.glTranslatef(0.5f, 0.5f, 0.5f);
    }
}

