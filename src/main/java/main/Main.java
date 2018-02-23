package main;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import main.Four;
import main.Gun;
import net.minecraft.event.ClickEvent;
@Mod(modid=Main.MOD_ID, name="BRM", version="3.0.0")
public class Main
{


		public static final String MOD_ID = "BRM";


	public static Block one;
	public static Block two;
	public static Block three;
	public static Block four;
	public static Block five;
	public static Block six;
	public static Block bgmones;
	public static Block seven;
	public static Block eight;
	public static Item sampleItem;
	public static Item Gun;
	public static Item Stick;



	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {


		one = new SampleBlock();
		two = new Two();
		three = new Three();
		four = new Four();
		five = new Five();
		six = new Six();
		seven = new Seven();
		eight = new Eight();
		sampleItem = new Item()
				.setCreativeTab(BRMTab)/*クリエイティブのタブ*/
				.setUnlocalizedName("add1")/*システム名の登録*/
				.setTextureName("main:Marble");/*テクスチャの指定*/

		Stick = new ItemSword(Item.ToolMaterial.EMERALD)
				.setCreativeTab(BRMTab)/*クリエイティブのタブ*/
				.setUnlocalizedName("ShieldStick")/*システム名の登録*/
				.setTextureName("main:bien");/*テクスチャの指定*/
		bgmones = (new Bgmone() {
			public void blockActivated(final World world, final int i, final int j, final int k, final EntityPlayer entityplayer) {
				   world.playSoundAtEntity(entityplayer, "main:brmbgm", 1.0F, 1.0F);


			   }
		});

		//ブロックのインスタンス生成

		//ブロックの登録。登録文字列はMOD内で被らなければ何でも良い。
		GameRegistry.registerBlock(one, "blockSample");
		GameRegistry.registerBlock(two, "two");
		GameRegistry.registerBlock(bgmones, "bgmones");
		GameRegistry.registerBlock(three, "three");
		GameRegistry.registerBlock(four, "four");
		GameRegistry.registerBlock(five, "fiveblock");
		GameRegistry.registerBlock(six, "six");
		GameRegistry.registerBlock(seven, "seven");
		GameRegistry.registerBlock(eight, "eight");

		GameRegistry.registerItem(Stick, "stick");
		one.setBlockName("GrayTile");
		two.setBlockName("flooring");
		three.setBlockName("BlackTile");
		four.setBlockName("MarbleBlock");
		main.Gun.load();



	}
	@EventHandler
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityPlayer) {
		System.out.println("Item Has been right clicked");
		EntityArrow entityarrow = new EntityArrow(world, (EntityLivingBase) entityPlayer, 3 * 2.0F);
		entityarrow.setDamage(3 * 2.0F);
		entityarrow.setKnockbackStrength(1);
		world.playSoundAtEntity(entityPlayer, "random.bow", 1.0F, 1.0F / (0.5F * 0.4F + 1.2F) + 3 * 0.5F);
			world.spawnEntityInWorld(entityarrow);
		    world.spawnEntityInWorld(entityarrow);
		    world.spawnEntityInWorld(entityarrow);
		if(itemstack.getItem() == Gun) {

		}
		return itemstack;
	}
	public static final CreativeTabs BRMTab = new CreativeTabMake("BRM") {
		public Item getTabIconItem()
		{

			return sampleItem;
		}
		public String getTranslatedTabLabel()
		{
			return "BRM";
		}
	};
	public void WLoad(net.minecraftforge.event.world.WorldEvent.Load event) {


	}



	public void postInit(FMLPostInitializationEvent event) {



	}
}

