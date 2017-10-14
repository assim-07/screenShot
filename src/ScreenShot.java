import java.awt.Color;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.*;
import java.awt.*;
import java.io.*;
import javax.swing.*;


import java.util.Calendar;


import java.text.SimpleDateFormat;

import javax.imageio.ImageIO;
public class ScreenShot extends JPanel{
	
	
	static final String waterMark="by snapShot Pro";
	final SimpleDateFormat formatter =new SimpleDateFormat("yyyy MM  dd hh mm ss a");

	public void shot()
	{
		try
		{
		
			Calendar time = Calendar.getInstance();
			
		Robot myRobot =new Robot();
		BufferedImage myImage=myRobot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		Graphics gg=myImage.getGraphics();
		gg.setFont(new Font("Gabriola",Font.ITALIC,40));
		gg.setColor(Color.GREEN);
		
		
		
	
 int a =myImage.getHeight()+300;
 int b =myImage.getHeight()-50;
		gg.drawString(waterMark,a,b);
		
		
		ImageIO.write(myImage, "JPG",new File("d://"+formatter.format(time.getTime())+".jpg"));
		
		
		
		}
		catch(Exception e)
		{
			System.out.print("Sucks");
		}
		
	
	}
	// record the video
	public void record()
	{
		
	}

}
