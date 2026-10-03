/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.main.ClientProxy;
import java.util.Random;
import net.minecraft.util.Vec3;
import org.lwjgl.util.vector.Vector3f;

public class mqip
extends iekw {
    public wnhj _a;

    public mqip(wnhj wnhj2) {
        super(wnhj2.worldObj, wnhj2);
        this._a = wnhj2;
        this.setCenter((double)wnhj2.xCoord + 0.5, wnhj2.yCoord, (double)wnhj2.zCoord + 0.5);
        this.setSize(5.0, 1.0, 5.0);
    }

    @Override
    public void tick() {
        super.tick();
        if (this._a._c - this._a._e < 10) {
            Random random = this.world.rand;
            Vec3 vec3 = Vec3._a(this.centerX, this.centerY + 0.5, this.centerZ);
            for (int i = 0; i < 10; ++i) {
                Vector3f vector3f = new Vector3f(random.nextFloat() - 0.5f, random.nextFloat() - 0.5f, random.nextFloat() - 0.5f);
                vector3f.normalise();
                Vec3 vec32 = Vec3._a(vec3._c + (double)vector3f.x, vec3._d + (double)vector3f.y, vec3._e + (double)vector3f.z);
                if (this.world.func_72831_a(vec3, vec32, false, true) != null) continue;
                this.particles.add(new eiri(this, dwpk._h, vec32));
            }
        }
        this.renderDistanceSq = ClientProxy.particleRenderDistance.value * ClientProxy.particleRenderDistance.value;
    }

    public void _a() {
        this.particles.add(new lnfh(this, dwpk._d));
    }

    @Override
    public void reset() {
        super.reset();
    }

    @Override
    public boolean ignoreFrustrumTickCheck() {
        return true;
    }
}

