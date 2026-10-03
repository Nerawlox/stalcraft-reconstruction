/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.client.model.obj;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import net.minecraft.client.renderer.Tessellator;
import net.minecraftforge.client.model.obj.Face;

@SideOnly(value=Side.CLIENT)
public class GroupObject {
    public String name;
    public ArrayList<Face> faces = new ArrayList();
    public int glDrawingMode;

    public GroupObject() {
        this("");
    }

    public GroupObject(String string) {
        this(string, -1);
    }

    public GroupObject(String string, int n) {
        this.name = string;
        this.glDrawingMode = n;
    }

    public void render() {
        if (this.faces.size() > 0) {
            Tessellator tessellator = Tessellator.instance;
            tessellator.startDrawing(this.glDrawingMode);
            this.render(tessellator);
            tessellator.draw();
        }
    }

    public void render(Tessellator tessellator) {
        if (this.faces.size() > 0) {
            for (Face face : this.faces) {
                face.addFaceForRender(tessellator);
            }
        }
    }
}

