package main;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabMake extends CreativeTabs
{
	public CreativeTabMake(String lable) {
		super(lable);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem()
	{

		return Main.sampleItem;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public String getTranslatedTabLabel()
	{
		return "BRM";
	}

}