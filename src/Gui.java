import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
public class Gui extends JFrame implements ActionListener{

	Gui()
	{
	
		systemTray();
		
	}
	private ScreenShot myShot =new ScreenShot();
	
	
	
	private void systemTray()
	{
		TrayIcon trayIcon =null;
		if(SystemTray.isSupported())
		{
			SystemTray tray = SystemTray.getSystemTray();
			PopupMenu popup =new PopupMenu();
			MenuItem snap =new MenuItem("Take SnapShot");
			MenuItem open =new MenuItem("Open");
			MenuItem exit =new MenuItem("Exit");
			
			popup.add(open);
			popup.add(snap);
			popup.add(exit);
			
			snap.addActionListener(this);
			exit.addActionListener(this);
			open.addActionListener(this);
			Image myImage =  Toolkit.getDefaultToolkit().getImage("/src/bg_grass.png");
			trayIcon =new TrayIcon(myImage,"SnapShotPro",popup);
			
			try
			{
				tray.add(trayIcon);
				
				
			}catch(AWTException ess)
			{
				System.err.println("unable to add");
			}
		}
		else
		{
			windowss();
		}
	}
	
	private void windowss()
	{
		super.setTitle("SnapShot Pro");
		JTabbedPane pane =new JTabbedPane();
		
		JPanel main =new JPanel();
		JPanel settings =new JPanel();
		JPanel about =new JPanel();
		
		main.setBackground(Color.darkGray);
		settings.setBackground(Color.darkGray);
		about.setBackground(Color.BLUE);
		
		pane.add("Main", main);
        pane.add("Settings",settings);
        pane.add("About",about);
        
        JButton click = new JButton("Snap");
        
        JLabel myLabel =new JLabel("Coded by assim",SwingConstants.CENTER);

        
        
        click.addActionListener(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
        main.add(click);
        about.add(myLabel);
        getContentPane().add(pane);
		
		
		setSize(300,200);
		setVisible(true);
		
		
		
	}
	
	
	public void actionPerformed(ActionEvent es)
	{
		String result= es.getActionCommand();
		
		if(result.equals("Exit"))
		{
		System.exit(0);
		}
		if(result.equals("Take SnapShot")||result.equals("Snap"))
		{
			myShot.shot();
		}
		if(result.equals("Open"))
		{
			windowss();
		}
		
	}
}
