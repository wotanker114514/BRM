package main;


import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.SideOnly;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import main.Main;
public class Bgmone extends Block
{
   @SideOnly(Side.CLIENT)
   private IIcon TopIcon;

   @SideOnly(Side.CLIENT)
   private IIcon SideIcon;

   public Bgmone() {
       super(Material.rock);
       setCreativeTab(Main.BRMTab);/*クリエイティブタブの選択*/
       setBlockName("bgmblock");/*システム名の設定*/
       setBlockTextureName("main:bgm");/*ブロックのテクスチャの指定(複数指定の場合は消してください)*/


   }

}