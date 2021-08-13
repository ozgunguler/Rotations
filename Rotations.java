import java.awt.Button;
import java.awt.Color;	
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.event.*; 
import java.awt.geom.Line2D;
	
	public class Rotations extends Frame implements ActionListener, MouseListener { 

		static final int windowWidth = 800;
		static final int windowHeight = 800;
		
		
		int[] x = {500,700,700,500};
		int[] y = {300,300,200,200}; 
		 
		 public static void main(String[] argv)
		 {
			 Rotations rt = new Rotations();
			rt.setSize(windowWidth,windowHeight);
			rt.setVisible(true);
				
		}
		 
		public Rotations() {
		setTitle("Transformations");
		MenuBar menu_bar = new MenuBar();
			
		Menu def = new Menu("File");
		def.add(new MenuItem("Set Default"));
		def.addActionListener(this);
		menu_bar.add(def);
		setMenuBar(menu_bar);
		
	    Panel panel=new Panel();  
	    panel.setBounds(0,40,windowWidth,40);  
		
		Button button_s = new Button();
		button_s.setLabel("Left Bottom - Clockwise");
		button_s.addActionListener(this);
		
		Button button_b = new Button();
		button_b.addActionListener(this);
		button_b.setLabel("Origin - Clockwise");
		
		Button button_c = new Button();
		button_c.addActionListener(this);
		button_c.setLabel("Origin - C.Clockwise");
		panel.add(button_s);
		panel.add(button_b);
		panel.add(button_c);
		
		panel.setBackground(Color.darkGray); 
		add(panel);
		setLayout(null);
		addWindowListener(new MyFinishWindow());
		addMouseListener(this);
		setBackground(Color.pink);
		
		}

		public void paint(Graphics g)
		{
			
			Graphics2D g2d = (Graphics2D) g;
			g2d.setColor(Color.WHITE);
			//x,y,x,y
			Line2D lin = new Line2D.Float(this.getWidth()/2, 0, this.getWidth()/2, this.getHeight());
			g2d.draw(lin);
			Line2D lin2 = new Line2D.Float(0, this.getHeight()/2, this.getWidth(), this.getHeight()/2);		
			g2d.draw(lin2);
			g2d.setColor(Color.darkGray);
			g2d.fillPolygon(x, y, 4);
		}
		
		public class MyFinishWindow extends WindowAdapter
		   {
		     public void windowClosing(WindowEvent e)
		     {
		       System.exit(0);
		     }
		   }
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			String str = arg0.getActionCommand();
			
			
			if(str.equals("Left Bottom - Clockwise")) {
				System.out.println("Button 1 clicked.");
				int tmpx0 = x[0];
				int tmpx1 = x[1];
				int tmpx2 = x[2];
				int tmpx3 = x[3];
		        
		        int tmpy0 = y[0];
		        int tmpy1 = y[1];
		        int tmpy2 = y[2];
		        int tmpy3 = y[3];
		        
				 x[1] = x[0] + tmpy0-tmpy1;
			     y[1] = y[0] + tmpx0-tmpx1;
			     
			     x[2] = x[1] + tmpy1-tmpy2;
			     y[2] = y[1] + tmpx1-tmpx2;
			     
			     x[3] = x[2] + tmpy2-tmpy3;
			     y[3] = y[2] + tmpx2-tmpx3;
				
			
			repaint();
			}
			else if(str.equals("Origin - Clockwise")) {
				System.out.println("Button 2 clicked.");		

				for(int i =0; i<4; i++) {
					
					int tmp = getHeight() - y[i];
					y[i] = x[i];
					x[i] = tmp;
					
			        }
				
				repaint();
			}
			else if(str.equals("Origin - C.Clockwise")) {
				System.out.println("Button 3 clicked.");	

				for(int i =0; i<4; i++) {
					
					int tmp = getWidth() - x[i];
					x[i] = y[i];
					y[i] = tmp;
					
			        }
				
				repaint();
			} else if(str.equals("Set Default")) {
				System.out.println("Defaults.");
				x[0]= 500;
				x[1]= 700;
				x[2]= 700;
				x[3]= 500;
				y[0]= 300;
				y[1]= 300;
				y[2]= 200;
				y[3]= 200;
				
				repaint();
				 
			}
		}
		public void mouseClicked(MouseEvent arg0) {
			int x = arg0.getX();
			int y = arg0.getY();
			repaint();
			// TODO Auto-generated method stub
			
		}
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	}
