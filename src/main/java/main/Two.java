package main;


import java.util.Random;
import main.Main;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.SideOnly;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class Two extends Block
{

@SideOnly(Side.CLIENT)
   private IIcon TopIcon;

   @SideOnly(Side.CLIENT)
   private IIcon SideIcon;

   public Two() {
       super(Material.rock);
       setCreativeTab(Main.BRMTab);/*クリエイティブタブの選択*/
       setBlockName("block2");/*システム名の設定*/
       setBlockTextureName("main:White");/*ブロックのテクスチャの指定(複数指定の場合は消してください)*/

   }
}