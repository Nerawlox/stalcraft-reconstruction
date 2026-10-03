/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  acf
 *  ake
 *  aoe
 *  asx
 *  cpw.mods.fml.common.registry.LanguageRegistry
 *  mt
 */
package ru.stalcraft.blocks;

import cpw.mods.fml.common.registry.LanguageRegistry;
import java.util.ArrayList;
import ru.stalcraft.StalkerMain;
import ru.stalcraft.blocks.MaterialMachineGun;
import ru.stalcraft.client.network.ClientPacketSender;
import ru.stalcraft.tile.TileEntityMachineGun;

public class BlockMachineGun
extends aqz
implements aoe {
    public BlockMachineGun(int id) {
        super(id, new MaterialMachineGun(ake.h));
        this.a(StalkerMain.tab);
        this.c("StalkerMachineGun");
        LanguageRegistry.addName((Object)this, (String)"\u041f\u0443\u043b\u0435\u043c\u0435\u0442");
        this.c(3.0f);
        this.a(0.25f, 0.0f, 0.25f, 0.75f, 0.6f, 0.75f);
    }

    @Override
    public boolean c() {
        return false;
    }

    @Override
    public boolean b() {
        return false;
    }

    @Override
    public boolean a_(acf par1IBlockAccess, int par2, int par3, int par4, int par5) {
        return false;
    }

    @Override
    public asx b(abw par1World, int par2, int par3, int par4) {
        return null;
    }

    @Override
    public void a(mt par1IconRegister) {
        this.cW = par1IconRegister.a("stalker:transparent");
    }

    public asp b(abw world) {
        return new TileEntityMachineGun();
    }

    @Override
    public void g(abw par1World, int par2, int par3, int par4, int par5) {
        if (!par1World.I) {
            float f2 = 0.7f;
            ye stack = new ye(this);
            double d0 = (double)(par1World.s.nextFloat() * f2) + (double)(1.0f - f2) * 0.5;
            double d1 = (double)(par1World.s.nextFloat() * f2) + (double)(1.0f - f2) * 0.5;
            double d2 = (double)(par1World.s.nextFloat() * f2) + (double)(1.0f - f2) * 0.5;
            ss entityitem = new ss(par1World, (double)par2 + d0, (double)par3 + d1, (double)par4 + d2, stack);
            entityitem.b = 10;
            par1World.d(entityitem);
        }
    }

    public ArrayList getBlockDropped(abw world, int x2, int y2, int z2, int metadata, int fortune) {
        return new ArrayList();
    }

    @Override
    public void a(abw world, int x2, int y2, int z2, of entity, ye stack) {
        if (entity != null) {
            int direction = ls.c((double)(entity.A * 4.0f / 360.0f) + 0.5) & 3;
            world.b(x2, y2, z2, direction, 3);
        }
    }

    @Override
    public boolean a(abw par1World, int par2, int par3, int par4, uf par5EntityPlayer, int par6, float par7, float par8, float par9) {
        if (par1World.I) {
            ClientPacketSender.sendMachineGunShooter(par2, par3, par4);
        }
        return true;
    }
}

