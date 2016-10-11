import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;


/* 
* @author: Jason Nordheim & Jeremy Bollela 
*/ 
public class MyGame {
	
	/* 
	* Main Method 
	*/ 
	public static void main(String[] args) {
		
		
	}// end main method 
	
	
	
	
	/* 
	*  Default Constructor 
	*/  
	public MyGame() {
		JFrame frame = new JFrame(); 
		frame.setTitle("BattleShip"); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.setResizable(false); 
		
	}// end default consturctor
	
	private void initComponent(JFrame f) {
		f.add(new BattleField()); 
	}
	
	public class BattleField extends JPanel {
		private Shape 
			rec01,rec02,rec03,rec04,rec05,rec06,rec07, rec08,
			rec11, rec12, rec13, rec14, rec15, rec16,rec17, rec18,
			rec21, rec22, rec23, rec24, rec25, rec26, rec27, rec28, 
			rec31, rec32, rec33, rec34, rec35, rec36, rec37, rec38, 
			rec41, rec42, rec43, rec44, rec45, rec46, rec47, rec48, 
			rec51, rec52, rec53, rec54, rec55, rec56, rec57, rec58, 
			rec61, rec62, rec63, rec64, rec65, rec66, rec67, rec68,
			rec71, rec72, rec73, rec74, rec75, rec76, rec77, rec78 = new Rectangle2D.Double(10,10,10,10); 
		private ArrayList<Shape> spaces; 
		private Dimension dim; 			
		
		
		
		
		// default constructor 
		public BattleField() {
			spaces = new ArrayList<Shape>(); 
			addRectangles(); 
			addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent me) {
					super.mouseClicked(me); 
					for (Shape s : spaces) {
						
						if (s.contains(me.getPoint())) {// check to see if the mouse 
							// is within the shape when clicked 
							System.out.println("Clicked " + s.getClass().getName()); 
							
						}
					}
				}
			}); 
			
		}
		
		private void addRectangles() {
			// row 1
			spaces.add(rec01); spaces.add(rec02); spaces.add(rec03); spaces.add(rec04); 
			spaces.add(rec05); spaces.add(rec06); spaces.add(rec07); spaces.add(rec08); 
			// row 2 
			spaces.add(rec11); spaces.add(rec12); spaces.add(rec13); spaces.add(rec14); 
			spaces.add(rec15); spaces.add(rec16); spaces.add(rec17); spaces.add(rec18); 
			// row 3 
			spaces.add(rec21); spaces.add(rec22); spaces.add(rec23); spaces.add(rec24); 
			spaces.add(rec25); spaces.add(rec26); spaces.add(rec27); spaces.add(rec28); 
			// row 4 
			spaces.add(rec31); spaces.add(rec32); spaces.add(rec33); spaces.add(rec34); 
			spaces.add(rec35); spaces.add(rec36); spaces.add(rec37); spaces.add(rec38); 
			// row 5  
			spaces.add(rec41); spaces.add(rec42); spaces.add(rec43); spaces.add(rec44); 
			spaces.add(rec45); spaces.add(rec46); spaces.add(rec47); spaces.add(rec48);
			// row 6 
			spaces.add(rec51); spaces.add(rec52); spaces.add(rec53); spaces.add(rec54); 
			spaces.add(rec55); spaces.add(rec56); spaces.add(rec57); spaces.add(rec58); 
			// row 7
			spaces.add(rec61); spaces.add(rec62); spaces.add(rec63); spaces.add(rec64); 
			spaces.add(rec65); spaces.add(rec66); spaces.add(rec67); spaces.add(rec68);
			// row 8 
			spaces.add(rec71); spaces.add(rec72); spaces.add(rec73); spaces.add(rec74); 
			spaces.add(rec75); spaces.add(rec76); spaces.add(rec77); spaces.add(rec78);
		}
		
	}
	protected void paintComponent(Graphics g) {
		super.paintComponent(g); 
		Graphics2D g2d = (Graphics2D) g; 
		for (Shape s : spaces) {
			g2d.draw(s); 
		}
	}
	public Dimension getPreferredSize() {
		return dim; 
	}
	
	private ArrayList<Shape> getSpaces() {
		return spaces; 
	}
	
	
	
	
}// end MyGame