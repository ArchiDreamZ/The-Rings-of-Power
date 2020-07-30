package trop;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class TROPItemRingVilia
extends TROPItemRingBase {
    public TROPItemRingVilia() {
    }
    
    public void onUpdate(ItemStack itemstack, World world, Entity entity, int par4, boolean par5) {
        int i = (int)entity.posX;
        int j = (int)entity.posY;
        int k = (int)entity.posZ;
        if (entity instanceof EntityLivingBase) {
            ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(6, 20, 2));
            ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(8, 20, 2));
        }
    }
}

