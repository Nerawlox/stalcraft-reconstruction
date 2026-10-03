/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.Vec3;
import net.minecraft.util.sajh;
import net.minecraft.village.Village;
import net.minecraft.world.World;

public class rapl {
    public World _a;
    public boolean _b;
    public int _c = -1;
    public int _d;
    public int _e;
    public Village _f;
    public int _g;
    public int _h;
    public int _i;

    public rapl(World world) {
        this._a = world;
    }

    public void _a() {
        boolean bl = false;
        if (bl) {
            if (this._c == 2) {
                this._d = 100;
                return;
            }
        } else {
            if (this._a.isDaytime()) {
                this._c = 0;
                return;
            }
            if (this._c == 2) {
                return;
            }
            if (this._c == 0) {
                float f = this._a.getCelestialAngle(0.0f);
                if ((double)f < 0.5 || (double)f > 0.501) {
                    return;
                }
                this._c = this._a.rand.nextInt(10) == 0 ? 1 : 2;
                this._b = false;
                if (this._c == 2) {
                    return;
                }
            }
        }
        if (!this._b) {
            if (this._b()) {
                this._b = true;
            } else {
                return;
            }
        }
        if (this._e > 0) {
            --this._e;
            return;
        }
        this._e = 2;
        if (this._d > 0) {
            this._c();
            --this._d;
        } else {
            this._c = 2;
        }
    }

    public boolean _b() {
        List list2 = this._a.playerEntities;
        for (EntityPlayer entityPlayer : list2) {
            this._f = this._a.villageCollectionObj._a((int)entityPlayer.posX, (int)entityPlayer.posY, (int)entityPlayer.posZ, 1);
            if (this._f == null || this._f._e() < 10 || this._f._f() < 20 || this._f._g() < 20) continue;
            ChunkCoordinates chunkCoordinates = this._f._c();
            float f = this._f._d();
            boolean bl = false;
            for (int i = 0; i < 10; ++i) {
                this._g = chunkCoordinates._a + (int)((double)(sajh._b(this._a.rand.nextFloat() * (float)Math.PI * 2.0f) * f) * 0.9);
                this._h = chunkCoordinates._b;
                this._i = chunkCoordinates._c + (int)((double)(sajh._a(this._a.rand.nextFloat() * (float)Math.PI * 2.0f) * f) * 0.9);
                bl = false;
                for (Village village : this._a.villageCollectionObj._c()) {
                    if (village == this._f || !village._a(this._g, this._h, this._i)) continue;
                    bl = true;
                    break;
                }
                if (!bl) break;
            }
            if (bl) {
                return false;
            }
            Vec3 vec3 = this._a(this._g, this._h, this._i);
            if (vec3 == null) continue;
            this._e = 0;
            this._d = 20;
            return true;
        }
        return false;
    }

    public boolean _c() {
        EntityZombie entityZombie;
        Vec3 vec3 = this._a(this._g, this._h, this._i);
        if (vec3 == null) {
            return false;
        }
        try {
            entityZombie = new EntityZombie(this._a);
            entityZombie.onSpawnWithEgg(null);
            entityZombie.setVillager(false);
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
        entityZombie.setLocationAndAngles(vec3._c, vec3._d, vec3._e, this._a.rand.nextFloat() * 360.0f, 0.0f);
        this._a.spawnEntityInWorld(entityZombie);
        ChunkCoordinates chunkCoordinates = this._f._c();
        entityZombie.setHomeArea(chunkCoordinates._a, chunkCoordinates._b, chunkCoordinates._c, this._f._d());
        return true;
    }

    public Vec3 _a(int n, int n2, int n3) {
        for (int i = 0; i < 10; ++i) {
            int n4;
            int n5;
            int n6 = n + this._a.rand.nextInt(16) - 8;
            if (!this._f._a(n6, n5 = n2 + this._a.rand.nextInt(6) - 3, n4 = n3 + this._a.rand.nextInt(16) - 8) || !xtbl._a(EnumCreatureType._a, this._a, n6, n5, n4)) continue;
            this._a.getWorldVec3Pool()._a(n6, n5, n4);
        }
        return null;
    }
}

