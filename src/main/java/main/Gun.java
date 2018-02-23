package main;

import net.minecraftforge.common.util.EnumHelper;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.init.Blocks;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.Block;
import main.Main;
import java.util.Random;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class Gun {

	public Gun() {
	}

	public static Item block;
	public static Object instance;

	public static void load() {
		ItemStack stack = new ItemStack(block, 1);
		GameRegistry.addRecipe(stack,
				new Object[]{"XXX", "345", "X7X", Character.valueOf('3'), new ItemStack(Blocks.stone, 1), Character.valueOf('4'),
						new ItemStack(Blocks.stone, 1), Character.valueOf('5'), new ItemStack(Blocks.tnt, 1), Character.valueOf('7'),
						new ItemStack(Blocks.stone, 1),});
	}

	public void generateNether(World world, Random random, int chunkX, int chunkZ) {
	}

	public void generateSurface(World world, Random random, int chunkX, int chunkZ) {
	}

	public int addFuel(ItemStack fuel) {
		return 0;
	}

	public void serverLoad(FMLServerStartingEvent event) {
	}

	public void preInit(FMLPreInitializationEvent event) {
	}

	public void registerRenderers() {
	}

	static {
		Item.ToolMaterial enumt = EnumHelper.addToolMaterial("GUN", 0, 154, 2F, 2, 2);
		block = (new ItemGun() {

			public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entity) {
				float var4 = 1.0F;
				int i = (int) (entity.prevPosX + (entity.posX - entity.prevPosX) * (double) var4);
				int j = (int) (entity.prevPosY + (entity.posY - entity.prevPosY) * (double) var4 + 1.62D - (double) entity.yOffset);
				int k = (int) (entity.prevPosZ + (entity.posZ - entity.prevPosZ) * (double) var4);

				if (true) {
					EntityArrow entityarrow = new EntityArrow(world, (EntityLivingBase) entity, 5 * 2.0F);
					entityarrow.setDamage(8 * 2.0F);
					entityarrow.setKnockbackStrength(1);
					world.playSoundAtEntity(entity, "random.bow", 1.0F, 1.0F / (0.5F * 0.4F + 1.2F) + 3 * 0.5F);
					if (!world.isRemote)
						world.spawnEntityInWorld(entityarrow);
				}

				return itemstack;
			}
		}).setUnlocalizedName("Gun").setTextureName("main:Gun");
		Item.itemRegistry.addObject(423, "Gun", block);

	}

	static class ItemGun extends Item {
		private Block[] blocksEffectiveAgainst = new Block[]{

		};

		// harvest level
		int harvest = 0;

		protected float efficiencyOnProperMaterial;

		protected ItemGun() {
			efficiencyOnProperMaterial = 2;
			setMaxDamage(154);
			setMaxStackSize(1);
			this.setCreativeTab(Main.BRMTab);
		}

		/**
		 * Returns the strength of the stack against a given block. 1.0F base,
		 * (Quality+1)*2 if correct blocktype, 1.5F if sword
		 */
		public float func_150893_a(ItemStack par1ItemStack, Block par2Block) {
			for (int i = 0; i < blocksEffectiveAgainst.length; i++) {
				if (blocksEffectiveAgainst[i] == par2Block) {
					return efficiencyOnProperMaterial;
				}
			}

			return 0.0F;
		}

		/**
		 * Current implementations of this method in child classes do not use
		 * the entry argument beside ev. They just raise the damage on the
		 * stack.
		 */
		public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLiving, EntityLivingBase par3EntityLiving) {
			par1ItemStack.damageItem(2, par3EntityLiving);
			return true;
		}

		public boolean onBlockDestroyed(ItemStack par1ItemStack, World par2World, Block par3, int par4, int par5, int par6,
				EntityLivingBase par7EntityLiving) {
			par1ItemStack.damageItem(1, par7EntityLiving);
			return true;
		}

		/**
		 * Returns True is the item is renderer in full 3D when hold.
		 */
		public boolean isFull3D() {
			return true;
		}

		/**
		 * Return the enchantability factor of the item, most of the time is
		 * based on material.
		 */
		public int getItemEnchantability() {
			// kok se lohk cara
			return 2;
		}

	}
}
