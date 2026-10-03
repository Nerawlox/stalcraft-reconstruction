/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  acf
 *  akc
 *  aoe
 *  ms
 *  mt
 *  net.minecraftforge.fluids.BlockFluidClassic
 *  net.minecraftforge.fluids.Fluid
 */
package ru.stalcraft.blocks;

import java.util.Random;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import ru.stalcraft.AnomalyDrop;
import ru.stalcraft.Config;
import ru.stalcraft.StalkerDamage;
import ru.stalcraft.StalkerMain;
import ru.stalcraft.blocks.MaterialKissel;
import ru.stalcraft.tile.TileEntityAnomaly;
import ru.stalcraft.tile.TileEntityKissel;

public class BlockKisselFluid
extends BlockFluidClassic
implements aoe {
    protected ms stillIcon;
    private AnomalyDrop drop;

    public BlockKisselFluid(int id, Fluid fluid) {
        super(id, fluid, (akc)new MaterialKissel());
        this.c("kisselFluid");
        this.a(StalkerMain.tab);
        this.quantaPerBlock = 0;
        this.cK = true;
        this.drop = new AnomalyDrop(Config.kisselDrop);
    }

    public ms a(int side, int meta) {
        return this.stillIcon;
    }

    public void a(mt register) {
        this.stillIcon = register.a("stalker:kissel_still");
    }

    public boolean canDisplace(acf world, int x2, int y2, int z2) {
        return world.g(x2, y2, z2).d() ? false : super.canDisplace(world, x2, y2, z2);
    }

    public boolean displaceIfPossible(abw world, int x2, int y2, int z2) {
        return world.g(x2, y2, z2).d() ? false : super.displaceIfPossible(world, x2, y2, z2);
    }

    public int getQuantaValue(acf world, int x2, int y2, int z2) {
        return 1;
    }

    public int d() {
        return StalkerMain.kisselRenderId;
    }

    public void a(abw par1World, int par2, int par3, int par4, nn par5Entity) {
        if (!par1World.I && par1World.s.nextFloat() > 0.95f && par5Entity instanceof of && !par5Entity.ar()) {
            TileEntityAnomaly.damageEntityForce((of)par5Entity, StalkerDamage.kissel, Config.kisselDamage, true);
            par1World.a(par5Entity, "stalker:kissel_hit", 1.0f, 1.0f);
        }
        if (par1World.I && !par5Entity.ar() && par5Entity instanceof of) {
            ((TileEntityKissel)par1World.r(par2, par3, par4)).spawnActiveParticles();
        }
    }

    public asp b(abw world) {
        return new TileEntityKissel();
    }

    public void b(abw par1World, int par2, int par3, int par4, Random par5Random) {
        if (par1World.s.nextFloat() < 0.005f) {
            par1World.a((double)par2, (double)par3, (double)par4, "stalker:kissel", 0.5f + par1World.s.nextFloat() * 0.5f, 0.9f + par5Random.nextFloat() * 0.15f, false);
        }
    }

    public int getLightValue(acf world, int x2, int y2, int z2) {
        return 11;
    }

    public void a(abw par1World, int par2, int par3, int par4, Random par5Random) {
        if (!par1World.I) {
            TileEntityAnomaly tile = (TileEntityAnomaly)par1World.r(par2, par3, par4);
            if (tile.lastEjectionId < StalkerMain.getProxy().getEjectionManager().getLastEjectionId()) {
                this.dropItem(par1World, par2, par3, par4, this.drop);
                tile.lastEjectionId = StalkerMain.getProxy().getEjectionManager().getLastEjectionId();
            }
        }
    }

    public void dropItem(abw par1World, int par2, int par3, int par4, AnomalyDrop drop) {
        int droppedId = drop.getDrop(par1World.s);
        if (droppedId != 0 && (droppedId < 32000 && yc.g[droppedId] != null || droppedId < 4096 && aqz.s[droppedId] != null)) {
            float f2 = 0.5f;
            ye stack = new ye(droppedId, 1, 0);
            Random rand = par1World.s;
            ss entityitem = new ss(par1World, (float)par2 + rand.nextFloat(), (float)par3 + rand.nextFloat(), (float)par4 + rand.nextFloat(), stack);
            entityitem.g((rand.nextFloat() - 0.5f) * f2, rand.nextFloat() * f2 / 2.0f, (rand.nextFloat() - 0.5f) * f2);
            entityitem.b = 10;
            par1World.d(entityitem);
        }
    }
}

