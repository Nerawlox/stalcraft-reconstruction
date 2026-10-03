/*
 * Decompiled with CFR 0.152.
 */
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.minecraft.util.ResourceLocation;
import org.apache.commons.lang3.StringUtils;

public abstract class jhuw<T extends iess>
extends uytm {
    protected ArrayList<T> meshes = new ArrayList(3);
    protected gpnv inbuiltAnimationLibrary;
    protected float fileVersion;
    protected uyvu quantization;
    protected jywl skeleton;
    protected boolean animated;
    protected int numBones;
    protected boolean hasUvs;
    protected boolean hasNormals;
    protected boolean hasTangents;
    public static final String MTL_EXTENSION = "mcmtl";

    public jhuw(ResourceLocation resourceLocation) {
        super(resourceLocation);
    }

    public wnxc getAnimation(String string) {
        return this.inbuiltAnimationLibrary == null ? null : this.inbuiltAnimationLibrary._a(string);
    }

    protected abstract T createMesh(String var1, String var2, int var3, short[] var4, int var5, int var6, float var7);

    protected void addObject(T t) {
        this.meshes.add(t);
    }

    protected abstract void onModelLoaded(ByteBuffer var1);

    @Override
    protected void load() {
        this.ioTask(this::loadAsync);
    }

    private void loadAsync() {
        try {
            new ssps()._a(this);
        }
        catch (Exception exception) {
            exception.printStackTrace();
            this.release();
            this.mcTask(this::setBroken);
        }
    }

    @Override
    public void release() {
        for (iess iess2 : this.meshes) {
            iess2._d();
        }
        this.meshes.clear();
        this.inbuiltAnimationLibrary = null;
        this.skeleton = null;
    }

    public float getFileVersion() {
        return this.fileVersion;
    }

    public List<wnxc> getAllAnimations() {
        if (this.inbuiltAnimationLibrary == null) {
            return Collections.emptyList();
        }
        return this.inbuiltAnimationLibrary._a();
    }

    public boolean isAnimated() {
        return this.animated;
    }

    public jywl getSkeleton() {
        return this.skeleton;
    }

    public int getNumBones() {
        return this.numBones;
    }

    public boolean hasUvs() {
        return this.hasUvs;
    }

    public boolean hasNormals() {
        return this.hasNormals;
    }

    public boolean hasTangents() {
        return this.hasTangents;
    }

    public gpnv getInbuiltAnimationLibrary() {
        return this.inbuiltAnimationLibrary;
    }

    public uyvu getQuantization() {
        return this.quantization;
    }

    public ArrayList<T> getMeshes() {
        return this.meshes;
    }

    public T getMesh(String string) {
        for (iess iess2 : this.meshes) {
            if (!iess2._l.equals(string)) continue;
            return (T)iess2;
        }
        return null;
    }

    public boolean hasMesh(String string) {
        return this.getMesh(string) != null;
    }

    public boolean hasAnimation(String string) {
        return this.getAnimation(string) != null;
    }

    @Override
    public String toString() {
        return this.location.toString();
    }

    public static ResourceLocation getDefaultMaterialPath(ResourceLocation resourceLocation) {
        return new ResourceLocation(resourceLocation.func_110624_b(), StringUtils.substringBeforeLast(resourceLocation.func_110623_a(), ".") + '.' + MTL_EXTENSION);
    }
}

