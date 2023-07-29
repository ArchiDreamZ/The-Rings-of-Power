package trop;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class TROPItemRingMan extends TROPItemRingBase {
	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> list, TooltipFlag tooltipFlag) {
		for (MobEffect mobEffect : new MobEffect[]{MobEffects.DAMAGE_BOOST, MobEffects.NIGHT_VISION}) {
			list.add(new TranslatableComponent(mobEffect.getDescriptionId()).withStyle(ChatFormatting.DARK_GREEN));
		}
	}

	@Override
	public void inventoryTick(ItemStack itemStack, Level level, Entity entity, int i, boolean b) {
		if (entity instanceof Player player) {
			player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 20, 1));
			player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 220));
		}
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
		player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 3600, 2));
		player.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 3800, 2));
		return super.use(level, player, interactionHand);
	}
}