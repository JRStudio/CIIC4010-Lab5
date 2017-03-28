import java.awt.Color;
import java.awt.Component;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyMouseAdapter extends MouseAdapter {
	private Random generator = new Random();
	private int m1x = generator.nextInt(9) + 1;
	private int m1y = generator.nextInt(9) + 1;
	private int m2x = generator.nextInt(9) + 1;
	private int m2y = generator.nextInt(9) + 1;
	private int m3x = generator.nextInt(9) + 1;
	private int m3y = generator.nextInt(9) + 1;
	private int m4x = generator.nextInt(9) + 1;
	private int m4y = generator.nextInt(9) + 1;
	private int m5x = generator.nextInt(9) + 1;
	private int m5y = generator.nextInt(9) + 1;
	private int m6x = generator.nextInt(9) + 1;
	private int m6y = generator.nextInt(9) + 1;
	private int m7x = generator.nextInt(9) + 1;
	private int m7y = generator.nextInt(9) + 1;
	private int m8x = generator.nextInt(9) + 1;
	private int m8y = generator.nextInt(9) + 1;
	private int m9x = generator.nextInt(9) + 1;
	private int m9y = generator.nextInt(9) + 1;
	private int m10x = generator.nextInt(9) + 1;
	private int m10y = generator.nextInt(9) + 1;
	public void mousePressed(MouseEvent e) {
		switch (e.getButton()) {
		case 1:        //Left mouse button
			Component c = e.getComponent();
			while (!(c instanceof JFrame)) {
				c = c.getParent();
				if (c == null) {
					return;
				}
			}
			JFrame myFrame = (JFrame) c;
			MyPanel myPanel = (MyPanel) myFrame.getContentPane().getComponent(0);
			Insets myInsets = myFrame.getInsets();
			int x1 = myInsets.left;
			int y1 = myInsets.top;
			e.translatePoint(-x1, -y1);
			int x = e.getX();
			int y = e.getY();
			myPanel.x = x;
			myPanel.y = y;
			myPanel.mouseDownGridX = myPanel.getGridX(x, y);
			myPanel.mouseDownGridY = myPanel.getGridY(x, y);
			myPanel.repaint();
			break;
		case 3:        //Right mouse button
			Component r = e.getComponent();
			while (!(r instanceof JFrame)) {
				r = r.getParent();
				if (r == null) {
					return;
				}
			}
			JFrame myFrameR = (JFrame) r;
			MyPanel myPanelR = (MyPanel) myFrameR.getContentPane().getComponent(0);
			Insets myInsetsR = myFrameR.getInsets();
			int x1R = myInsetsR.left;
			int y1R = myInsetsR.top;
			e.translatePoint(-x1R, -y1R);
			int xR = e.getX();
			int yR = e.getY();
			myPanelR.x = xR;
			myPanelR.y = yR;
			myPanelR.mouseDownGridX = myPanelR.getGridX(xR, yR);
			myPanelR.mouseDownGridY = myPanelR.getGridY(xR, yR);
			myPanelR.repaint();	
			break;
		default:    //Some other button (2 = Middle mouse button, etc.)
			//Do nothing
			break;
		}
	}

	public void mouseReleased(MouseEvent e) {
		switch (e.getButton()) {
		case 1:        //Left mouse button
			Component c = e.getComponent();
			while (!(c instanceof JFrame)) {
				c = c.getParent();
				if (c == null) {
					return;
				}
			}
			JFrame myFrame = (JFrame)c;
			MyPanel myPanel = (MyPanel) myFrame.getContentPane().getComponent(0);  //Can also loop among components to find MyPanel
			Insets myInsets = myFrame.getInsets();
			int x1 = myInsets.left;
			int y1 = myInsets.top;
			e.translatePoint(-x1, -y1);
			int x = e.getX();
			int y = e.getY();
			myPanel.x = x;
			myPanel.y = y;

			int gridX = myPanel.getGridX(x, y);
			int gridY = myPanel.getGridY(x, y);
			boolean mine1 = gridX == m1x && gridY == m1y;
			boolean mine2 = gridX == m2x && gridY == m2y;
			boolean mine3 = gridX == m3x && gridY == m3y;
			boolean mine4 = gridX == m4x && gridY == m4y;
			boolean mine5 = gridX == m5x && gridY == m5y;
			boolean mine6 = gridX == m6x && gridY == m6y;
			boolean mine7 = gridX == m7x && gridY == m7y;
			boolean mine8 = gridX == m8x && gridY == m8y;
			boolean mine9 = gridX == m9x && gridY == m9y;
			boolean mine10 = gridX == m10x && gridY == m10y;
			if ((myPanel.mouseDownGridX == -1) || (myPanel.mouseDownGridY == -1)) {
			} else {
				if ((gridX == -1) || (gridY == -1)) {
				} else {
					if ((myPanel.mouseDownGridX != gridX) || (myPanel.mouseDownGridY != gridY)) {
					} else {
						if ((gridX == 0) || (gridY == 0)) {

						}else {
							if (mine1 || mine2 || mine3 || mine4 || mine5 || mine6 || mine7 || mine8 || mine9 || mine10){
								myPanel.colorArray[m1x][m1y] = Color.BLACK;
								myPanel.colorArray[m2x][m2y] = Color.BLACK;
								myPanel.colorArray[m3x][m3y] = Color.BLACK;
								myPanel.colorArray[m4x][m4y] = Color.BLACK;
								myPanel.colorArray[m5x][m5y] = Color.BLACK;
								myPanel.colorArray[m6x][m6y] = Color.BLACK;
								myPanel.colorArray[m7x][m7y] = Color.BLACK;
								myPanel.colorArray[m8x][m8y] = Color.BLACK;
								myPanel.colorArray[m9x][m9y] = Color.BLACK;
								myPanel.colorArray[m10x][m10y] = Color.BLACK;


								myPanel.repaint();
								JFrame frame = new JFrame();
								JOptionPane.showMessageDialog(frame, "GAME OVER!!");
								System.out.println("GAME OVER!!");
								//							}else{
								//								if(myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY].equals(Color.RED)){

							} else {

								myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY] = Color.GRAY;
								myPanel.repaint();
//								if(myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY].equals(myPanel.colorArray[m10x-1][m10y-1])){
//									myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY] = Color.GREEN;
//									myPanel.repaint();
//								}
							}

						}
					}
				}
			}
			//			}
			myPanel.repaint();
			break;
		case 3:        //Right mouse button
			Component r = e.getComponent();
			while (!(r instanceof JFrame)) {
				r = r.getParent();
				if (r == null) {
					return;
				}
			}
			JFrame myFrameR = (JFrame) r;
			MyPanel myPanelR = (MyPanel) myFrameR.getContentPane().getComponent(0);
			Insets myInsetsR = myFrameR.getInsets();
			int x1R = myInsetsR.left;
			int y1R = myInsetsR.top;
			e.translatePoint(-x1R, -y1R);
			int xR = e.getX();
			int yR = e.getY();
			myPanelR.x = xR;
			myPanelR.y = yR;
			myPanelR.mouseDownGridX = myPanelR.getGridX(xR, yR);
			myPanelR.mouseDownGridY = myPanelR.getGridY(xR, yR);
			myPanelR.repaint();	

			myPanelR.colorArray[myPanelR.mouseDownGridX][myPanelR.mouseDownGridY] = Color.RED;
			myPanelR.repaint();
			break;
		default:    //Some other button (2 = Middle mouse button, etc.)
			//Do nothing
			break;
		}

	}
}