package net.lucasfranken131.modtutorial.item.custom;

import net.lucasfranken131.modtutorial.sound.ModSounds;
import net.lucasfranken131.modtutorial.util.ModTags;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MetalDetectorItem extends Item {
    public MetalDetectorItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if(!pContext.getLevel().isClientSide()) {
            BlockPos position = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            boolean foundBlock = false;

            for(int i=0; i < position.getY() + 64; i++) {
                BlockState state = pContext.getLevel().getBlockState(position.below(i));
                if(isValuableBlock(state)) {
                    outputValuableCoordinates(position.below(i), player, state.getBlock());
                    foundBlock = true;
                    pContext.getLevel().playSeededSound(null, position.getX(), position.getY(), position.getZ(),
                    ModSounds.METAL_DETECTOR_FOUND_ORE.get(), SoundSource.BLOCKS, 1f, 1f, 0);
                    break;
                }
            }
            if(!foundBlock) {
                player.sendSystemMessage(Component.literal("Nenhum minério encontrado."));
            }
        }

        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(), player -> player.broadcastBreakEvent(player.getUsedItemHand()));

        return InteractionResult.SUCCESS;
    }

    private boolean isValuableBlock(BlockState state) {
        return state.is(ModTags.Blocks.METAL_DETECTOR_VALUABLES);
    }

    private void outputValuableCoordinates(BlockPos position, Player player, Block block) {
        player.sendSystemMessage(Component.literal("Achou " + I18n.get(block.getDescriptionId())
                + " em: X " + position.getX() + ", Y " + position.getY() + ", Z " + position.getZ()));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pToolTipComponents, TooltipFlag pIsAdvanced) {
        pToolTipComponents.add(Component.translatable("tooltip.modtutorial.metal_detector.tooltip"));
        super.appendHoverText(pStack, pLevel, pToolTipComponents, pIsAdvanced);
    }
}
