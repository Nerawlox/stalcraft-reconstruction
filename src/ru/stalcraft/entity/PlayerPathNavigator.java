/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  acf
 *  akc
 *  alf
 *  atc
 */
package ru.stalcraft.entity;

import ru.stalcraft.client.player.PlayerClientInfo;
import ru.stalcraft.player.PlayerUtils;

public class PlayerPathNavigator {
    private uf theEntity;
    private abw worldObj;
    private alf currentPath;
    private double speed;
    private int pathSearchRange;
    private boolean noSunPathfind;
    private int totalTicks;
    private int ticksAtLastPos;
    private atc lastPosCheck = atc.a((double)0.0, (double)0.0, (double)0.0);
    private boolean canPassOpenWoodenDoors = true;
    private boolean canPassClosedWoodenDoors;
    private boolean avoidsWater;
    private boolean canSwim;

    public PlayerPathNavigator(uf player, abw par2World) {
        this.theEntity = player;
        this.worldObj = par2World;
        this.pathSearchRange = 32;
        this.canSwim = true;
        this.avoidsWater = false;
    }

    public void setAvoidsWater(boolean par1) {
        this.avoidsWater = par1;
    }

    public boolean getAvoidsWater() {
        return this.avoidsWater;
    }

    public void setBreakDoors(boolean par1) {
        this.canPassClosedWoodenDoors = par1;
    }

    public void setEnterDoors(boolean par1) {
        this.canPassOpenWoodenDoors = par1;
    }

    public boolean getCanBreakDoors() {
        return this.canPassClosedWoodenDoors;
    }

    public void setAvoidSun(boolean par1) {
        this.noSunPathfind = par1;
    }

    public void setSpeed(double par1) {
        this.speed = par1;
    }

    public void setCanSwim(boolean par1) {
        this.canSwim = par1;
    }

    public float getPathSearchRange() {
        return 16.0f;
    }

    public alf getPathToXYZ(double par1, double par3, double par5) {
        return !this.canNavigate() ? null : this.worldObj.a(this.theEntity, ls.c(par1), (int)par3, ls.c(par5), this.getPathSearchRange(), this.canPassOpenWoodenDoors, this.canPassClosedWoodenDoors, this.avoidsWater, this.canSwim);
    }

    public boolean tryMoveToXYZ(double par1, double par3, double par5, double par7) {
        alf pathentity = this.getPathToXYZ(ls.c(par1), (int)par3, ls.c(par5));
        return this.setPath(pathentity, par7);
    }

    public alf getPathToEntityLiving(nn par1Entity) {
        return !this.canNavigate() ? null : this.worldObj.a((nn)this.theEntity, par1Entity, this.getPathSearchRange(), this.canPassOpenWoodenDoors, this.canPassClosedWoodenDoors, this.avoidsWater, this.canSwim);
    }

    public boolean tryMoveToEntityLiving(nn par1Entity, double par2) {
        alf pathentity = this.getPathToEntityLiving(par1Entity);
        return pathentity != null ? this.setPath(pathentity, par2) : false;
    }

    public boolean setPath(alf par1PathEntity, double par2) {
        if (par1PathEntity == null) {
            this.currentPath = null;
            return false;
        }
        if (!par1PathEntity.a(this.currentPath)) {
            this.currentPath = par1PathEntity;
        }
        if (this.noSunPathfind) {
            this.removeSunnyPath();
        }
        if (this.currentPath.d() == 0) {
            return false;
        }
        this.speed = par2;
        atc vec3 = this.getEntityPosition();
        this.ticksAtLastPos = this.totalTicks;
        this.lastPosCheck.c = vec3.c;
        this.lastPosCheck.d = vec3.d;
        this.lastPosCheck.e = vec3.e;
        return true;
    }

    public alf getPath() {
        return this.currentPath;
    }

    public void onUpdateNavigation() {
        ++this.totalTicks;
        if (!this.noPath()) {
            atc vec3;
            if (this.canNavigate()) {
                this.pathFollow();
            }
            if (!this.noPath() && (vec3 = this.currentPath.a((nn)this.theEntity)) != null) {
                ((PlayerClientInfo)PlayerUtils.getInfo((uf)this.theEntity)).moveHelper.setMoveTo(vec3.c, vec3.d, vec3.e, this.speed);
            }
        }
    }

    private void pathFollow() {
        int k2;
        atc vec3 = this.getEntityPosition();
        int i2 = this.currentPath.d();
        for (int f2 = this.currentPath.e(); f2 < this.currentPath.d(); ++f2) {
            if (this.currentPath.a((int)f2).b == (int)vec3.d) continue;
            i2 = f2;
            break;
        }
        float var8 = this.theEntity.O * this.theEntity.O;
        for (k2 = this.currentPath.e(); k2 < i2; ++k2) {
            if (!(vec3.e(this.currentPath.a((nn)this.theEntity, k2)) < (double)var8)) continue;
            this.currentPath.c(k2 + 1);
        }
        k2 = ls.f(this.theEntity.O);
        int l2 = (int)this.theEntity.P + 1;
        int i1 = k2;
        for (int j1 = i2 - 1; j1 >= this.currentPath.e(); --j1) {
            if (!this.isDirectPathBetweenPoints(vec3, this.currentPath.a((nn)this.theEntity, j1), k2, l2, i1)) continue;
            this.currentPath.c(j1);
            break;
        }
        if (this.totalTicks - this.ticksAtLastPos > 100) {
            if (vec3.e(this.lastPosCheck) < 2.25) {
                this.clearPathEntity();
            }
            this.ticksAtLastPos = this.totalTicks;
            this.lastPosCheck.c = vec3.c;
            this.lastPosCheck.d = vec3.d;
            this.lastPosCheck.e = vec3.e;
        }
    }

    public boolean noPath() {
        return this.currentPath == null || this.currentPath.b();
    }

    public void clearPathEntity() {
        this.currentPath = null;
    }

    private atc getEntityPosition() {
        return this.worldObj.V().a(this.theEntity.u, (double)this.getPathableYPos(), this.theEntity.w);
    }

    private int getPathableYPos() {
        if (this.theEntity.H() && this.canSwim) {
            int i2 = (int)this.theEntity.E.b;
            int j2 = this.worldObj.a(ls.c(this.theEntity.u), i2, ls.c(this.theEntity.w));
            int k2 = 0;
            do {
                if (j2 != aqz.F.cF && j2 != aqz.G.cF) {
                    return i2;
                }
                j2 = this.worldObj.a(ls.c(this.theEntity.u), ++i2, ls.c(this.theEntity.w));
            } while (++k2 <= 16);
            return (int)this.theEntity.E.b;
        }
        return (int)(this.theEntity.E.b + 0.5);
    }

    private boolean canNavigate() {
        return this.theEntity.F || this.canSwim && this.isInFluid();
    }

    private boolean isInFluid() {
        return this.theEntity.H() || this.theEntity.J();
    }

    private void removeSunnyPath() {
        if (!this.worldObj.l(ls.c(this.theEntity.u), (int)(this.theEntity.E.b + 0.5), ls.c(this.theEntity.w))) {
            ale pathpoint = null;
            for (int i2 = 0; i2 < this.currentPath.d(); ++i2) {
                pathpoint = this.currentPath.a(i2);
                if (!this.worldObj.l(pathpoint.a, pathpoint.b, pathpoint.c)) continue;
                this.currentPath.b(i2 - 1);
                return;
            }
        }
    }

    private boolean isDirectPathBetweenPoints(atc par1Vec3, atc par2Vec3, int par3, int par4, int par5) {
        int l2 = ls.c(par1Vec3.c);
        int i1 = ls.c(par1Vec3.e);
        double d0 = par2Vec3.c - par1Vec3.c;
        double d1 = par2Vec3.e - par1Vec3.e;
        double d2 = d0 * d0 + d1 * d1;
        if (d2 < 1.0E-8) {
            return false;
        }
        double d3 = 1.0 / Math.sqrt(d2);
        if (!this.isSafeToStandAt(l2, (int)par1Vec3.d, i1, par3 += 2, par4, par5 += 2, par1Vec3, d0 *= d3, d1 *= d3)) {
            return false;
        }
        par3 -= 2;
        par5 -= 2;
        double d4 = 1.0 / Math.abs(d0);
        double d5 = 1.0 / Math.abs(d1);
        double d6 = (double)(l2 * 1) - par1Vec3.c;
        double d7 = (double)(i1 * 1) - par1Vec3.e;
        if (d0 >= 0.0) {
            d6 += 1.0;
        }
        if (d1 >= 0.0) {
            d7 += 1.0;
        }
        d6 /= d0;
        d7 /= d1;
        int j1 = d0 < 0.0 ? -1 : 1;
        int k1 = d1 < 0.0 ? -1 : 1;
        int l1 = ls.c(par2Vec3.c);
        int i2 = ls.c(par2Vec3.e);
        int j2 = l1 - l2;
        int k2 = i2 - i1;
        do {
            if (j2 * j1 <= 0 && k2 * k1 <= 0) {
                return true;
            }
            if (d6 < d7) {
                d6 += d4;
                j2 = l1 - (l2 += j1);
                continue;
            }
            d7 += d5;
            k2 = i2 - (i1 += k1);
        } while (this.isSafeToStandAt(l2, (int)par1Vec3.d, i1, par3, par4, par5, par1Vec3, d0, d1));
        return false;
    }

    private boolean isSafeToStandAt(int par1, int par2, int par3, int par4, int par5, int par6, atc par7Vec3, double par8, double par10) {
        int k1 = par1 - par4 / 2;
        int l1 = par3 - par6 / 2;
        double d2 = 0.0;
        double d3 = 0.0;
        akc material = null;
        if (!this.isPositionClear(k1, par2, l1, par4, par5, par6, par7Vec3, par8, par10)) {
            return false;
        }
        for (int i2 = k1; i2 < k1 + par4; ++i2) {
            for (int j2 = l1; j2 < l1 + par6; ++j2) {
                d2 = (double)i2 + 0.5 - par7Vec3.c;
                d3 = (double)j2 + 0.5 - par7Vec3.e;
                if (!(d2 * par8 + d3 * par10 >= 0.0)) continue;
                int k2 = this.worldObj.a(i2, par2 - 1, j2);
                if (k2 <= 0) {
                    return false;
                }
                material = aqz.s[k2].cU;
                if (material == akc.h && !this.theEntity.H()) {
                    return false;
                }
                if (material != akc.i) continue;
                return false;
            }
        }
        return true;
    }

    private boolean isPositionClear(int par1, int par2, int par3, int par4, int par5, int par6, atc par7Vec3, double par8, double par10) {
        double d2 = 0.0;
        double d3 = 0.0;
        for (int k1 = par1; k1 < par1 + par4; ++k1) {
            for (int l1 = par2; l1 < par2 + par5; ++l1) {
                for (int i2 = par3; i2 < par3 + par6; ++i2) {
                    int j2;
                    d2 = (double)k1 + 0.5 - par7Vec3.c;
                    d3 = (double)i2 + 0.5 - par7Vec3.e;
                    if (!(d2 * par8 + d3 * par10 >= 0.0) || (j2 = this.worldObj.a(k1, l1, i2)) <= 0 || aqz.s[j2].b((acf)this.worldObj, k1, l1, i2)) continue;
                    return false;
                }
            }
        }
        return true;
    }
}

