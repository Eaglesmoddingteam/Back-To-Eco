package bte.objects.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CustomItem2 extends Item{

	public CustomItem2(String name, int size) {
        setUnlocalizedName(name);
        setRegistryName(name);
        setMaxStackSize(size);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        onclick(worldIn, playerIn, handIn);
        return new ActionResult(EnumActionResult.SUCCESS, new ItemStack(this));
    }

    @SideOnly(Side.CLIENT)
    private void onclick(World worldIn, EntityPlayer playerIn, EnumHand handIn){
        RayTraceResult ray = new RayTraceResult(playerIn);
        Entity entity = ray.entityHit;
        if(entity == null){
        	
        } else
        entity.onKillCommand();
    }
}