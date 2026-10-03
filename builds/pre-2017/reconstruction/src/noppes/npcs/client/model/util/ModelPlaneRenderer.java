/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.model.util;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import noppes.npcs.client.model.util.ModelPlane;
import noppes.npcs.client.renderer.EnumPlanePosition;

public class ModelPlaneRenderer
extends ModelRenderer {
    private int textureOffsetX;
    private int textureOffsetY;

    public ModelPlaneRenderer(ModelBase modelBase, int n, int n2) {
        super(modelBase, n, n2);
        this.textureOffsetX = n;
        this.textureOffsetY = n2;
    }

    public void addBackPlane(float f, float f2, float f3, int n, int n2) {
        this.addPlane(f, f2, f3, n, n2, 0, 0.0f, EnumPlanePosition.BACK);
    }

    public void addSidePlane(float f, float f2, float f3, int n, int n2) {
        this.addPlane(f, f2, f3, 0, n, n2, 0.0f, EnumPlanePosition.LEFT);
    }

    public void addTopPlane(float f, float f2, float f3, int n, int n2) {
        this.addPlane(f, f2, f3, n, 0, n2, 0.0f, EnumPlanePosition.TOP);
    }

    public void addBackPlane(float f, float f2, float f3, int n, int n2, float f4) {
        this.addPlane(f, f2, f3, n, n2, 0, f4, EnumPlanePosition.BACK);
    }

    public void addSidePlane(float f, float f2, float f3, int n, int n2, float f4) {
        this.addPlane(f, f2, f3, 0, n, n2, f4, EnumPlanePosition.LEFT);
    }

    public void addTopPlane(float f, float f2, float f3, int n, int n2, float f4) {
        this.addPlane(f, f2, f3, n, 0, n2, f4, EnumPlanePosition.TOP);
    }

    public void addPlane(float f, float f2, float f3, int n, int n2, int n3, float f4, EnumPlanePosition enumPlanePosition) {
        this.cubeList.add(new ModelPlane(this, this.textureOffsetX, this.textureOffsetY, f, f2, f3, n, n2, n3, f4, enumPlanePosition));
    }
}

