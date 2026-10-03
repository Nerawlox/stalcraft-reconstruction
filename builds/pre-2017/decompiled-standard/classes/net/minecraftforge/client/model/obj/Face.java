/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.client.model.obj;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.ofbx;
import net.minecraftforge.client.model.obj.TextureCoordinate;
import net.minecraftforge.client.model.obj.Vertex;

@SideOnly(value=Side.CLIENT)
public class Face {
    public Vertex[] vertices;
    public Vertex[] vertexNormals;
    public Vertex faceNormal;
    public TextureCoordinate[] textureCoordinates;

    public void addFaceForRender(htvf htvf2) {
        this.addFaceForRender(htvf2, 5.0E-4f);
    }

    public void addFaceForRender(htvf htvf2, float f) {
        if (this.faceNormal == null) {
            this.faceNormal = this.calculateFaceNormal();
        }
        htvf2.func_78375_b(this.faceNormal.x, this.faceNormal.y, this.faceNormal.z);
        float f2 = 0.0f;
        float f3 = 0.0f;
        if (this.textureCoordinates != null && this.textureCoordinates.length > 0) {
            for (int i = 0; i < this.textureCoordinates.length; ++i) {
                f2 += this.textureCoordinates[i].u;
                f3 += this.textureCoordinates[i].v;
            }
            f2 /= (float)this.textureCoordinates.length;
            f3 /= (float)this.textureCoordinates.length;
        }
        for (int i = 0; i < this.vertices.length; ++i) {
            if (this.textureCoordinates != null && this.textureCoordinates.length > 0) {
                float f4 = f;
                float f5 = f;
                if (this.textureCoordinates[i].u > f2) {
                    f4 = -f4;
                }
                if (this.textureCoordinates[i].v > f3) {
                    f5 = -f5;
                }
                htvf2.func_78374_a(this.vertices[i].x, this.vertices[i].y, this.vertices[i].z, this.textureCoordinates[i].u + f4, this.textureCoordinates[i].v + f5);
                continue;
            }
            htvf2.func_78377_a(this.vertices[i].x, this.vertices[i].y, this.vertices[i].z);
        }
    }

    public Vertex calculateFaceNormal() {
        ofbx ofbx2 = ofbx._a(this.vertices[1].x - this.vertices[0].x, this.vertices[1].y - this.vertices[0].y, this.vertices[1].z - this.vertices[0].z);
        ofbx ofbx3 = ofbx._a(this.vertices[2].x - this.vertices[0].x, this.vertices[2].y - this.vertices[0].y, this.vertices[2].z - this.vertices[0].z);
        ofbx ofbx4 = null;
        ofbx4 = ofbx2._c(ofbx3)._a();
        return new Vertex((float)ofbx4._c, (float)ofbx4._d, (float)ofbx4._e);
    }
}

