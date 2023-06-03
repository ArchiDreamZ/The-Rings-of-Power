package trop;

import net.minecraft.src.*;

public class TROPItemRingDwarf extends Item {
	public TROPItemRingDwarf(int id) {
		super(id);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entity) {
		entity.addPotionEffect(new PotionEffect(Potion.regeneration.getId(), 3600, 2));
		return super.onItemRightClick(itemStack, world, entity);
	}

	@Override
	public void onUpdate(ItemStack itemstack, World world, Entity entity, int par4, boolean par5) {
		if (entity instanceof EntityPlayer) {
			((EntityPlayer) entity).addPotionEffect(new PotionEffect(Potion.digSpeed.getId(), 20, 1));
			((EntityPlayer) entity).addPotionEffect(new PotionEffect(Potion.resistance.getId(), 20, 1));
		}
	}
}
