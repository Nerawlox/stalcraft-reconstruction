/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.demos.bsp;

import com.bulletphysics.util.ObjectArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.vecmath.Vector3f;

public abstract class BspConverter {
    public void convertBsp(InputStream in) throws IOException {
        String s;
        BufferedReader r = new BufferedReader(new InputStreamReader(in, "UTF-8"));
        ObjectArrayList<Vector3f> vertices = new ObjectArrayList<Vector3f>();
        while ((s = r.readLine()) != null) {
            int count = Integer.parseInt(s);
            vertices.clear();
            for (int i = 0; i < count; ++i) {
                String[] c = r.readLine().split(" ");
                vertices.add(new Vector3f(Float.parseFloat(c[0]), Float.parseFloat(c[1]), Float.parseFloat(c[2])));
            }
            this.addConvexVerticesCollider(vertices);
        }
        r.close();
    }

    public abstract void addConvexVerticesCollider(ObjectArrayList<Vector3f> var1);
}

