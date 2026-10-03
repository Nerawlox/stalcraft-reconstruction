/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.client.model.obj;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
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
            htvf htvf2 = htvf.field_78398_a;
            htvf2.func_78371_b(this.glDrawingMode);
            this.render(htvf2);
            htvf2.func_78381_a();
        }
    }

    public void render(htvf htvf2) {
        if (this.faces.size() > 0) {
            for (Face face : this.faces) {
                face.addFaceForRender(htvf2);
            }
        }
    }
}

