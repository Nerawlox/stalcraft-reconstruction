/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.client.model.obj;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.Vec3;
import net.minecraftforge.client.model.obj.TextureCoordinate;
import net.minecraftforge.client.model.obj.Vertex;

@SideOnly(value=Side.CLIENT)
public class Face {
    public Vertex[] vertices;
    public Vertex[] vertexNormals;
    public Vertex faceNormal;
    public TextureCoordinate[] textureCoordinates;

    public void addFaceForRender(Tessellator tessellator) {
        this.addFaceForRender(tessellator, 5.0E-4f);
    }

    public void addFaceForRender(Tessellator tessellator, float f) {
        if (this.faceNormal == null) {
            this.faceNormal = this.calculateFaceNormal();
        }
        tessellator.setNormal(this.faceNormal.x, this.faceNormal.y, this.faceNormal.z);
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
                tessellator.addVertexWithUV(this.vertices[i].x, this.vertices[i].y, this.vertices[i].z, this.textureCoordinates[i].u + f4, this.textureCoordinates[i].v + f5);
                continue;
            }
            tessellator.addVertex(this.vertices[i].x, this.vertices[i].y, this.vertices[i].z);
        }
    }

    public Vertex calculateFaceNormal() {
        Vec3 vec3 = Vec3._a(this.vertices[1].x - this.vertices[0].x, this.vertices[1].y - this.vertices[0].y, this.vertices[1].z - this.vertices[0].z);
        Vec3 vec32 = Vec3._a(this.vertices[2].x - this.vertices[0].x, this.vertices[2].y - this.vertices[0].y, this.vertices[2].z - this.vertices[0].z);
        Vec3 vec33 = null;
        vec33 = vec3._c(vec32)._a();
        return new Vertex((float)vec33._c, (float)vec33._d, (float)vec33._e);
    }
}

