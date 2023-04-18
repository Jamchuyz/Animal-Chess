

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.util.*;
public class GUI extends JFrame{
	//animal coordinates for the purpose of updating the display of the panels
	//inputs for blue side
	public JButton bA;
	public JButton bW;
	public JButton bS;
	public JButton bD; 
	
	public JTextField bText;
	public JPanel boardPanel;
	//inputs for red side
	public JButton rA;
	public JButton rW;
	public JButton rS;
	public JButton rD; 
	
	public JButton jb;
	
	public JTextField rText;
	
	public JPanel[][] tiles;
	//red icons: Animals
	public JLabel elephantIcon;
	public JLabel tigerIcon;
	public JLabel mouseIcon;
	public JLabel lionIcon;
	public JLabel catIcon;
	public JLabel wolfIcon;
	public JLabel dogIcon;
	public JLabel leopardIcon;
	
	//blue icons: Animals
	public JLabel elephantIcon2;
	public JLabel tigerIcon2;
	public JLabel mouseIcon2;
	public JLabel lionIcon2;
	public JLabel catIcon2;
	public JLabel wolfIcon2;
	public JLabel dogIcon2;
	public JLabel leopardIcon2;
	
	public JLabel trapIcon1;
	public JLabel trapIcon2;
	public JLabel trapIcon3;
	public JLabel trapIcon4;
	public JLabel trapIcon5;
	public JLabel trapIcon6;
	
	public JLabel riverIcon1;
	public JLabel riverIcon2;
	public JLabel riverIcon3;
	public JLabel riverIcon4;
	public JLabel riverIcon5;
	public JLabel riverIcon6;
	public JLabel riverIcon7;
	public JLabel riverIcon8;
	public JLabel riverIcon9;
	public JLabel riverIcon10;
	public JLabel riverIcon11;
	public JLabel riverIcon12;
	
	public JLabel denIcon;
	public JLabel denIcon2;
	
	public int bluePiece;
	public int redPiece;
	
	public boolean blueDen;
	public boolean redDen;
	
	
	public GUI(){
		super("MCO2: Animal Chess");
		bluePiece = 8;
		redPiece = 8;
		
		blueDen = false;
		redDen = false;
		//main frame
		setLayout(new BorderLayout());
		
		initGUI();
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		setSize (800, 800);
		setVisible (true);
	}

	public void initGUI(){
		int i,j;
		//south panel where both inputs for red and blue will be placed
		JPanel southPanel = new JPanel();
		southPanel.setLayout(new BorderLayout());
		//===========================================
		
		rA = new JButton("left");
		rW = new JButton("up");
		rS = new JButton("down");
		rD = new JButton("right"); 
		
		rText = new JTextField(10);
		southPanel.add(rA, BorderLayout.WEST);
		southPanel.add(rW, BorderLayout.NORTH);
		southPanel.add(rS, BorderLayout.SOUTH);
		southPanel.add(rD, BorderLayout.EAST);
		southPanel.add(rText);
		
		//-------------------------------------------
	
		
		//==========================================
			
		//panel where board will be placed
		boardPanel = new JPanel();
		boardPanel.setLayout(new GridLayout(7,9));
	
		
		//Panels for the tiles of the board	
		tiles = new JPanel[7][9];
		for(i = 0; i< 7; i++){
			for(j = 0; j < 9; j++){
				tiles[i][j] = new JPanel();
			}
		}
		
		for(i = 0; i< 7; i++){
			for(j = 0; j < 9; j++){
				tiles[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
				boardPanel.add(tiles[i][j]);
			}
		}
		
		//RED ICONS
		ImageIcon icon1 = new ImageIcon("RedElephant.png");
		icon1.setImage(icon1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));	
		 elephantIcon = new JLabel(icon1);
		 elephantIcon.setName("red elephant");
		
		ImageIcon icon2 = new ImageIcon("RedLion.png");
		icon2.setImage(icon2.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));	
		 lionIcon = new JLabel(icon2);
		lionIcon.setName("red lion");
		
		ImageIcon icon3 = new ImageIcon("RedTiger.png");
		icon3.setImage(icon3.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));	
		tigerIcon = new JLabel(icon3);		
		tigerIcon.setName("red tiger"); 
		 
		ImageIcon icon4 = new ImageIcon("RedLeopard.png");
		icon4.setImage(icon4.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));	
		 leopardIcon = new JLabel(icon4);	
		 leopardIcon.setName("red leopard"); 
		 
		ImageIcon icon5 = new ImageIcon("RedDog.png");
		icon5.setImage(icon5.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));	
		 dogIcon = new JLabel(icon5);
		dogIcon.setName("red dog"); 
		 
		ImageIcon icon6 = new ImageIcon("RedWolf.png");
		icon6.setImage(icon6.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));	
		 wolfIcon = new JLabel(icon6);	
		wolfIcon.setName("red wolf");		 
		 
		ImageIcon icon7 = new ImageIcon("RedCat.png");
		icon7.setImage(icon7.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));	
		 catIcon = new JLabel(icon7);	
		 catIcon.setName("red cat");
		ImageIcon icon8 = new ImageIcon("RedMouse.png");
		icon8.setImage(icon8.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));	
		 mouseIcon = new JLabel(icon8);
		 mouseIcon.setName("red mouse");
		ImageIcon icon17 = new ImageIcon("RedDen.png");
		icon17.setImage(icon17.getImage().getScaledInstance(83, 88, Image.SCALE_DEFAULT));	
		 denIcon = new JLabel(icon17);
		 denIcon.setName("red den");

    //BLUE ICONS
		ImageIcon icon9 = new ImageIcon("BlueElephant.png");
		icon9.setImage(icon9.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));	
		 elephantIcon2 = new JLabel(icon9);
		 elephantIcon2.setName("blue elephant");
		ImageIcon icon10 = new ImageIcon("BlueLion.png");
		icon10.setImage(icon10.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));	
		 lionIcon2 = new JLabel(icon10);
		 lionIcon2.setName("blue lion");
		ImageIcon icon11 = new ImageIcon("BlueTiger.png");
		icon11.setImage(icon11.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));	
		 tigerIcon2 = new JLabel(icon11);
		 tigerIcon2.setName("blue tiger");
		ImageIcon icon12 = new ImageIcon("BlueLeopard.png");
		icon12.setImage(icon12.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));	
		 leopardIcon2 = new JLabel(icon12);
		 leopardIcon2.setName("blue leopard");
		ImageIcon icon13 = new ImageIcon("BlueDog.png");
		icon13.setImage(icon13.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));	
		 dogIcon2 = new JLabel(icon13);
		 dogIcon2.setName("blue dog");
		ImageIcon icon14 = new ImageIcon("BlueWolf.png");
		icon14.setImage(icon14.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));	
		 wolfIcon2 = new JLabel(icon14);
		 wolfIcon2.setName("blue wolf");
		ImageIcon icon15 = new ImageIcon("BlueCat.png");
		icon15.setImage(icon15.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));	
		 catIcon2 = new JLabel(icon15);
		 catIcon2.setName("blue cat");
		ImageIcon icon16 = new ImageIcon("BlueMouse.png");
		icon16.setImage(icon16.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));	
		 mouseIcon2 = new JLabel(icon16);
		 mouseIcon2.setName("blue mouse");
		ImageIcon icon18 = new ImageIcon("BlueDen.png");
		icon18.setImage(icon18.getImage().getScaledInstance(83, 88, Image.SCALE_DEFAULT));	
		 denIcon2 = new JLabel(icon18);
		dogIcon2.setName("blue den");
    //TERRAIN ICONS
		ImageIcon river1 = new ImageIcon("River.png");
		river1.setImage(river1.getImage().getScaledInstance(83, 88, Image.SCALE_DEFAULT));	
		 riverIcon1 = new JLabel(river1);
		ImageIcon river2 = new ImageIcon("River2.png");
		river2.setImage(river2.getImage().getScaledInstance(83, 88, Image.SCALE_DEFAULT));	
		 riverIcon2 = new JLabel(river2);
		ImageIcon river3 = new ImageIcon("River3.png");
		river3.setImage(river3.getImage().getScaledInstance(83, 88, Image.SCALE_DEFAULT));	
		 riverIcon3 = new JLabel(river3);
		ImageIcon river4 = new ImageIcon("River4.png");
		river4.setImage(river4.getImage().getScaledInstance(83, 88, Image.SCALE_DEFAULT));	
		 riverIcon4 = new JLabel(river4);	
		ImageIcon river5 = new ImageIcon("River5.png");
		river5.setImage(river5.getImage().getScaledInstance(83, 88, Image.SCALE_DEFAULT));	
		 riverIcon5 = new JLabel(river5);
		ImageIcon river6 = new ImageIcon("River6.png");
		river6.setImage(river6.getImage().getScaledInstance(83, 88, Image.SCALE_DEFAULT));	
		 riverIcon6 = new JLabel(river6);
		ImageIcon river7 = new ImageIcon("River7.png");
		river7.setImage(river7.getImage().getScaledInstance(83, 88, Image.SCALE_DEFAULT));	
		 riverIcon7 = new JLabel(river7);
		ImageIcon river8 = new ImageIcon("River8.png");
		river8.setImage(river8.getImage().getScaledInstance(83, 88, Image.SCALE_DEFAULT));	
		 riverIcon8 = new JLabel(river8);
		ImageIcon river9 = new ImageIcon("River9.png");
		river9.setImage(river9.getImage().getScaledInstance(83, 88, Image.SCALE_DEFAULT));	
		 riverIcon9 = new JLabel(river9);		
		ImageIcon river10 = new ImageIcon("River10.png");
		river10.setImage(river10.getImage().getScaledInstance(83, 88, Image.SCALE_DEFAULT));	
		 riverIcon10 = new JLabel(river10);		
		ImageIcon river11 = new ImageIcon("River11.png");
		river11.setImage(river11.getImage().getScaledInstance(83, 88, Image.SCALE_DEFAULT));	
		 riverIcon11 = new JLabel(river11);		
		ImageIcon river12 = new ImageIcon("River12.png");
		river12.setImage(river12.getImage().getScaledInstance(83, 88, Image.SCALE_DEFAULT));	
		 riverIcon12 = new JLabel(river12);	
		
		ImageIcon trap1= new ImageIcon("Trap.png");
		trap1.setImage(trap1.getImage().getScaledInstance(83, 88, Image.SCALE_DEFAULT));	
		 trapIcon1 = new JLabel(trap1);
		ImageIcon trap2= new ImageIcon("Trap2.png");
		trap2.setImage(trap2.getImage().getScaledInstance(83, 88, Image.SCALE_DEFAULT));	
		 trapIcon2 = new JLabel(trap2);	
		ImageIcon trap3= new ImageIcon("Trap3.png");
		trap3.setImage(trap3.getImage().getScaledInstance(83, 88, Image.SCALE_DEFAULT));	
		 trapIcon3 = new JLabel(trap3);	
		ImageIcon trap4= new ImageIcon("Trap4.png");
		trap4.setImage(trap4.getImage().getScaledInstance(83, 88, Image.SCALE_DEFAULT));	
		 trapIcon4 = new JLabel(trap4);
		ImageIcon trap5= new ImageIcon("Trap5.png");
		trap5.setImage(trap5.getImage().getScaledInstance(83, 88, Image.SCALE_DEFAULT));	
		 trapIcon5 = new JLabel(trap5);
		ImageIcon trap6= new ImageIcon("Trap6.png");
		trap6.setImage(trap6.getImage().getScaledInstance(83, 88, Image.SCALE_DEFAULT));	
		 trapIcon6 = new JLabel(trap6);
		
		//tiles[0][0].add(trapIcon6);
		
		
		setAnimals();
		add(boardPanel);
		add(southPanel, BorderLayout.SOUTH);
		
	}

	public void setListener (ActionListener listener){
		rD.addActionListener (listener);
		rS.addActionListener (listener);
		rA.addActionListener (listener);
		rW.addActionListener (listener);
		
	}
	
	public void wEnabled(boolean enabled){
		rW.setEnabled(enabled);
	}
	
	public void aEnabled(boolean enabled){
		rA.setEnabled(enabled);
	}
	
	public void sEnabled(boolean enabled){
		rS.setEnabled(enabled);
	}
	
	public void dEnabled(boolean enabled){
		rD.setEnabled(enabled);
	}
	
	public void setTextListener(DocumentListener textListener){
		rText.getDocument().addDocumentListener(textListener);
	}	
	
	public void setAnimalName(String text){
		rText.setText(text);
	}
	
	public String getAnimalName(){
		return rText.getText();
	}
	
	public int getTileAnimalRow(String a){
		int i, j;
		
		for(i = 0; i < 7; i++){
			for(j = 0; j< 9; j++){
				if(a.equalsIgnoreCase(tiles[i][j].getName())){
					System.out.print(" "+ i +" ");
					return i;
				}
			}
		}
		return -1;
	}
	
	public int getTileAnimalCol(String a){
		int i, j;
		
		for(i = 0; i < 7; i++){
			for(j = 0; j< 9; j++){
				if(a.equalsIgnoreCase(tiles[i][j].getName())){
					System.out.println(" "+ j +" ");
					return j;
				}
			}
		}
		return -1;
	}
	
	public void setAnimals(){
		int i, j;
		for(i = 0; i < 7; i++){
			for(j = 0; j < 9; j++){
				if(i == 0 && j == 0){
					//rTiger
					tiles[i][j].add(tigerIcon);
					tiles[i][j].setName("red tiger");
				}else if(i == 0 && j == 2){
					//rElephant
					tiles[i][j].add(elephantIcon);
					tiles[i][j].setName("red elephant");
				}else if(i == 1 && j == 1){
					//rCat
					tiles[i][j].add(catIcon);
					tiles[i][j].setName("red cat");
				}else if(i == 2 && j == 2){
					//rWolf
					tiles[i][j].add(wolfIcon);
					tiles[i][j].setName("red wolf");
				}else if(i == 4 && j == 2){
					//rLeopard
					tiles[i][j].add(leopardIcon);
					tiles[i][j].setName("red leopard");
				}else if(i == 5 && j == 1){
					//rDog
					tiles[i][j].add(dogIcon);
					tiles[i][j].setName("red dog");
				}else if(i == 6 && j == 0){
					//rLion
					tiles[i][j].add(lionIcon);
					tiles[i][j].setName("red lion");
				}else if(i == 6 && j == 2){
					//rMouse
					tiles[i][j].add(mouseIcon);
					tiles[i][j].setName("red mouse");
				}else if(i == 3 && j == 0){
					//rDen
					tiles[i][j].add(denIcon);
					tiles[i][j].setName("red den");
				}else if(i == 6 && j == 8){
					//bTiger
					tiles[i][j].add(tigerIcon2);
					tiles[i][j].setName("blue tiger");
				}else if(i == 6 && j == 6){
					//bElephant
					tiles[i][j].add(elephantIcon2);
					tiles[i][j].setName("blue elephant");
				}else if(i == 5 && j == 7){
					//bCat
					tiles[i][j].add(catIcon2);
					tiles[i][j].setName("blue cat");
				}else if(i == 4 && j == 6){
					//bWolf
					tiles[i][j].add(wolfIcon2);
					tiles[i][j].setName("blue wolf");
				}else if(i == 2 && j == 6){
					//bLeopard
					tiles[i][j].add(leopardIcon2);
					tiles[i][j].setName("blue leopard");
				}else if(i == 1 && j == 7){
					//bDog
					tiles[i][j].add(dogIcon2);
					tiles[i][j].setName("blue dog");
				}else if(i == 0 && j == 8){
					//bLion
					tiles[i][j].add(lionIcon2);
					tiles[i][j].setName("blue lion");
				}else if(i == 0 && j == 6){
					//bMouse
					tiles[i][j].add(mouseIcon2);
					tiles[i][j].setName("blue mouse");
				}else if(i == 3 && j == 8){
					//bDen
					tiles[i][j].add(denIcon2);
					tiles[i][j].setName("blue den");
				}
				//terrains: RIVER
				else if(i == 1 && j == 3){
					//bRiver
					tiles[i][j].add(riverIcon1);
					tiles[i][j].setName("river");
					
				}else if(i == 1 && j == 4){
					//bRiver
					tiles[i][j].add(riverIcon2);
					tiles[i][j].setName("river");
				}else if(i == 1 && j == 5){
					//bRiver
					tiles[i][j].add(riverIcon3);
					tiles[i][j].setName("river");
				}else if(i == 2 && j == 3){
					//bRiver
					tiles[i][j].add(riverIcon4);
					tiles[i][j].setName("river");
				}else if(i == 2 && j == 4){
					//bRiver
					tiles[i][j].add(riverIcon5);
					tiles[i][j].setName("river");
				}else if(i == 2 && j == 5){
					//bRiver
					tiles[i][j].add(riverIcon6);
					tiles[i][j].setName("river");
				}else if(i == 4 && j == 3){
					//bRiver
					tiles[i][j].add(riverIcon7);
					tiles[i][j].setName("river");
				}else if(i == 4 && j == 4){
					//bRiver
					tiles[i][j].add(riverIcon8);
					tiles[i][j].setName("river");
				}else if(i == 4 && j == 5){
					//bRiver
					tiles[i][j].add(riverIcon9);
					tiles[i][j].setName("river");
				}else if(i == 5 && j == 3){
					//bRiver
					tiles[i][j].add(riverIcon10);
					tiles[i][j].setName("river");
				}else if(i == 5 && j == 4){
					//bRiver
					tiles[i][j].add(riverIcon11);
					tiles[i][j].setName("river");
				}else if(i == 5 && j == 5){
					//bRiver
					tiles[i][j].add(riverIcon12);
					tiles[i][j].setName("river");
				}//Terrain: TRAP
				else if(i == 2 && j == 0){
					//TRAP
					tiles[i][j].add(trapIcon1);
					tiles[i][j].setName("trap");
				}else if(i == 2 && j == 8){
					//TRAP
					tiles[i][j].add(trapIcon2);
					tiles[i][j].setName("trap");
				}else if(i == 3 && j == 1){
					//TRAP
					tiles[i][j].add(trapIcon3);
					tiles[i][j].setName("trap");
				}else if(i == 3 && j == 7){
					//TRAP
					tiles[i][j].add(trapIcon4);
					tiles[i][j].setName("trap");
				}else if(i == 4 && j == 0){
					//TRAP
					tiles[i][j].add(trapIcon5);
					tiles[i][j].setName("trap");
				}else if(i == 4 && j == 8){
					//TRAP
					tiles[i][j].add(trapIcon6);
					tiles[i][j].setName("trap");
				}else{
					tiles[i][j].setName("normal");
				}
			}
		}
	}
	
	public void moveW(int i, int j, String a){
		//red
		if(a.equals("red elephant")){
			if((i == 2 && (j == 0 || j == 8))||
				   (i == 3 && (j == 1 || j == 7))||
				   (i == 4 && (j == 0 || j == 8))){
					tiles[i][j].removeAll();
					tiles[i][j].revalidate();
					tiles[i][j].repaint();
					tiles[i][j].setName("trap");		
					tiles[i][j+1].removeAll();
					tiles[i][j+1].revalidate();
					tiles[i][j+1].repaint();
					tiles[i][j+1].add(elephantIcon);
					tiles[i][j+1].setName("red elephant");
					if (i==2 && j==0)
						tiles[i][j].add(trapIcon1);
					else if (i==2 && j==8)
						tiles[i][j].add(trapIcon2);
					else if (i==3 && j==1)
						tiles[i][j].add(trapIcon3);
					else if (i==3 && j==7)
						tiles[i][j].add(trapIcon4);
					else if (i==4 && j==0)
						tiles[i][j].add(trapIcon5);
					else if (i==4 && j==8)
						tiles[i][j].add(trapIcon6);		
			}
			else {
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i-1][j].removeAll();
				tiles[i-1][j].revalidate();
				tiles[i-1][j].repaint();
				tiles[i-1][j].add(elephantIcon);
				tiles[i-1][j].setName("red elephant");
			}
		}else if(a.equals("red lion")){
			if((i == 3 || i == 6) && 
			   (j == 3 || j == 4 || j == 5)){
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i-3][j].removeAll();
				tiles[i-3][j].revalidate();
				tiles[i-3][j].repaint();
				tiles[i-3][j].add(lionIcon);
				tiles[i-3][j].setName("red lion");
			}
			else if((i == 2 && (j == 0 || j == 8))||
				   (i == 3 && (j == 1 || j == 7))||
				   (i == 4 && (j == 0 || j == 8))){
					tiles[i][j].removeAll();
					tiles[i][j].revalidate();
					tiles[i][j].repaint();
					tiles[i][j].setName("trap");		
					tiles[i-1][j].removeAll();
					tiles[i-1][j].revalidate();
					tiles[i-1][j].repaint();
					tiles[i-1][j].add(lionIcon);
					tiles[i-1][j].setName("red lion");
					if (i==2 && j==0)
						tiles[i][j].add(trapIcon1);
					else if (i==2 && j==8)
						tiles[i][j].add(trapIcon2);
					else if (i==3 && j==1)
						tiles[i][j].add(trapIcon3);
					else if (i==3 && j==7)
						tiles[i][j].add(trapIcon4);
					else if (i==4 && j==0)
						tiles[i][j].add(trapIcon5);
					else if (i==4 && j==8)
						tiles[i][j].add(trapIcon6);		
			}
			else{
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i-1][j].removeAll();
				tiles[i-1][j].revalidate();
				tiles[i-1][j].repaint();
				tiles[i-1][j].add(lionIcon);
				tiles[i-1][j].setName("red lion");
			   }
		}else if(a.equals("red tiger")){
			if((i == 3 || i == 6) && 
			   (j == 3 || j == 4 || j == 5)){
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i-3][j].removeAll();
				tiles[i-3][j].revalidate();
				tiles[i-3][j].repaint();
				tiles[i-3][j].add(tigerIcon);
				tiles[i-3][j].setName("red tiger");
			}
			else if((i == 2 && (j == 0 || j == 8))||
				   (i == 3 && (j == 1 || j == 7))||
				   (i == 4 && (j == 0 || j == 8))){
					tiles[i][j].removeAll();
					tiles[i][j].revalidate();
					tiles[i][j].repaint();
					tiles[i][j].setName("trap");		
					tiles[i-1][j].removeAll();
					tiles[i-1][j].revalidate();
					tiles[i-1][j].repaint();
					tiles[i-1][j].add(tigerIcon);
					tiles[i-1][j].setName("red tiger");
					if (i==2 && j==0)
						tiles[i][j].add(trapIcon1);
					else if (i==2 && j==8)
						tiles[i][j].add(trapIcon2);
					else if (i==3 && j==1)
						tiles[i][j].add(trapIcon3);
					else if (i==3 && j==7)
						tiles[i][j].add(trapIcon4);
					else if (i==4 && j==0)
						tiles[i][j].add(trapIcon5);
					else if (i==4 && j==8)
						tiles[i][j].add(trapIcon6);		
			}else{
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i-1][j].removeAll();
				tiles[i-1][j].revalidate();
				tiles[i-1][j].repaint();
				tiles[i-1][j].add(tigerIcon);
				tiles[i-1][j].setName("red tiger");
			   }
		}else if(a.equals("red leopard")){
			if((i == 2 && (j == 0 || j == 8))||
				   (i == 3 && (j == 1 || j == 7))||
				   (i == 4 && (j == 0 || j == 8))){
					tiles[i][j].removeAll();
					tiles[i][j].revalidate();
					tiles[i][j].repaint();
					tiles[i][j].setName("trap");		
					tiles[i-1][j].removeAll();
					tiles[i-1][j].revalidate();
					tiles[i-1][j].repaint();
					tiles[i-1][j].add(leopardIcon);
					tiles[i-1][j].setName("red leopard");
					if (i==2 && j==0)
						tiles[i][j].add(trapIcon1);
					else if (i==2 && j==8)
						tiles[i][j].add(trapIcon2);
					else if (i==3 && j==1)
						tiles[i][j].add(trapIcon3);
					else if (i==3 && j==7)
						tiles[i][j].add(trapIcon4);
					else if (i==4 && j==0)
						tiles[i][j].add(trapIcon5);
					else if (i==4 && j==8)
						tiles[i][j].add(trapIcon6);		
			}
			else {
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i-1][j].removeAll();
				tiles[i-1][j].revalidate();
				tiles[i-1][j].repaint();
				tiles[i-1][j].add(leopardIcon);
				tiles[i-1][j].setName("red leopard");
			}
		}else if(a.equals("red mouse")){
			//in river
			if((i == 1 && (j == 3 || j == 4 || j == 5))||
					(i == 2 && (j == 3 || j == 4 || j == 5))||
					(i == 4 && (j == 3 || j == 4 || j == 5))||
					(i == 5 && (j == 3 || j == 4 || j == 5))){
					tiles[i][j].removeAll();
					tiles[i][j].revalidate();
					tiles[i][j].repaint();
					tiles[i][j].setName("river");		
					tiles[i-1][j].removeAll();
					tiles[i-1][j].revalidate();
					tiles[i-1][j].repaint();
					tiles[i-1][j].add(mouseIcon);
					tiles[i-1][j].setName("red mouse");
					if (i==1 && j==3)
						tiles[i][j].add(riverIcon1);
					else if (i==1 && j==4)
						tiles[i][j].add(riverIcon2);
					else if (i==1 && j==5)
						tiles[i][j].add(riverIcon3);
					else if (i==2 && j==3)
						tiles[i][j].add(riverIcon4);
					else if (i==2 && j==4)
						tiles[i][j].add(riverIcon5);
					else if (i==2 && j==5)
						tiles[i][j].add(riverIcon6);
					else if (i==4 && j==3)
						tiles[i][j].add(riverIcon7);
					else if (i==4 && j==4)
						tiles[i][j].add(riverIcon8);
					else if (i==4 && j==5)
						tiles[i][j].add(riverIcon9);
					else if (i==5 && j==3)
						tiles[i][j].add(riverIcon10);
					else if (i==5 && j==4)
						tiles[i][j].add(riverIcon11);
					else if (i==5 && j==5)
						tiles[i][j].add(riverIcon12);
			}
			else if((i == 2 && (j == 0 || j == 8))||
				   (i == 3 && (j == 1 || j == 7))||
				   (i == 4 && (j == 0 || j == 8))){
					tiles[i][j].removeAll();
					tiles[i][j].revalidate();
					tiles[i][j].repaint();
					tiles[i][j].setName("trap");		
					tiles[i-1][j].removeAll();
					tiles[i-1][j].revalidate();
					tiles[i-1][j].repaint();
					tiles[i-1][j].add(mouseIcon);
					tiles[i-1][j].setName("red mouse");
					if (i==2 && j==0)
						tiles[i][j].add(trapIcon1);
					else if (i==2 && j==8)
						tiles[i][j].add(trapIcon2);
					else if (i==3 && j==1)
						tiles[i][j].add(trapIcon3);
					else if (i==3 && j==7)
						tiles[i][j].add(trapIcon4);
					else if (i==4 && j==0)
						tiles[i][j].add(trapIcon5);
					else if (i==4 && j==8)
						tiles[i][j].add(trapIcon6);		
			}	
			else {			
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i-1][j].removeAll();
				tiles[i-1][j].revalidate();
				tiles[i-1][j].repaint();
				tiles[i-1][j].add(mouseIcon);
				tiles[i-1][j].setName("red mouse");
			}
		}else if(a.equals("red cat")){
			if((i == 2 && (j == 0 || j == 8))||
				   (i == 3 && (j == 1 || j == 7))||
				   (i == 4 && (j == 0 || j == 8))){
					tiles[i][j].removeAll();
					tiles[i][j].revalidate();
					tiles[i][j].repaint();
					tiles[i][j].setName("trap");		
					tiles[i-1][j].removeAll();
					tiles[i-1][j].revalidate();
					tiles[i-1][j].repaint();
					tiles[i-1][j].add(catIcon);
					tiles[i-1][j].setName("red cat");
					if (i==2 && j==0)
						tiles[i][j].add(trapIcon1);
					else if (i==2 && j==8)
						tiles[i][j].add(trapIcon2);
					else if (i==3 && j==1)
						tiles[i][j].add(trapIcon3);
					else if (i==3 && j==7)
						tiles[i][j].add(trapIcon4);
					else if (i==4 && j==0)
						tiles[i][j].add(trapIcon5);
					else if (i==4 && j==8)
						tiles[i][j].add(trapIcon6);		
			}
			else {
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i-1][j].removeAll();
				tiles[i-1][j].revalidate();
				tiles[i-1][j].repaint();
				tiles[i-1][j].add(catIcon);
				tiles[i-1][j].setName("red cat");
			}
		}else if(a.equals("red wolf")){
			if((i == 2 && (j == 0 || j == 8))||
				   (i == 3 && (j == 1 || j == 7))||
				   (i == 4 && (j == 0 || j == 8))){
					tiles[i][j].removeAll();
					tiles[i][j].revalidate();
					tiles[i][j].repaint();
					tiles[i][j].setName("trap");		
					tiles[i-1][j].removeAll();
					tiles[i-1][j].revalidate();
					tiles[i-1][j].repaint();
					tiles[i-1][j].add(wolfIcon);
					tiles[i-1][j].setName("red wolf");
					if (i==2 && j==0)
						tiles[i][j].add(trapIcon1);
					else if (i==2 && j==8)
						tiles[i][j].add(trapIcon2);
					else if (i==3 && j==1)
						tiles[i][j].add(trapIcon3);
					else if (i==3 && j==7)
						tiles[i][j].add(trapIcon4);
					else if (i==4 && j==0)
						tiles[i][j].add(trapIcon5);
					else if (i==4 && j==8)
						tiles[i][j].add(trapIcon6);		
			}
			else {
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i-1][j].removeAll();
				tiles[i-1][j].revalidate();
				tiles[i-1][j].repaint();
				tiles[i-1][j].add(wolfIcon);
				tiles[i-1][j].setName("red wolf");
			}
		}else if(a.equals("red dog")){
			if((i == 2 && (j == 0 || j == 8))||
				   (i == 3 && (j == 1 || j == 7))||
				   (i == 4 && (j == 0 || j == 8))){
					tiles[i][j].removeAll();
					tiles[i][j].revalidate();
					tiles[i][j].repaint();
					tiles[i][j].setName("trap");		
					tiles[i-1][j].removeAll();
					tiles[i-1][j].revalidate();
					tiles[i-1][j].repaint();
					tiles[i-1][j].add(dogIcon);
					tiles[i-1][j].setName("red dog");
					if (i==2 && j==0)
						tiles[i][j].add(trapIcon1);
					else if (i==2 && j==8)
						tiles[i][j].add(trapIcon2);
					else if (i==3 && j==1)
						tiles[i][j].add(trapIcon3);
					else if (i==3 && j==7)
						tiles[i][j].add(trapIcon4);
					else if (i==4 && j==0)
						tiles[i][j].add(trapIcon5);
					else if (i==4 && j==8)
						tiles[i][j].add(trapIcon6);		
			}
			else {
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i-1][j].removeAll();
				tiles[i-1][j].revalidate();
				tiles[i-1][j].repaint();
				tiles[i-1][j].add(dogIcon);
				tiles[i-1][j].setName("red dog");
			}
		}//BLUE
		else if(a.equals("blue elephant")){
			if((i == 2 && (j == 0 || j == 8))||
				   (i == 3 && (j == 1 || j == 7))||
				   (i == 4 && (j == 0 || j == 8))){
					tiles[i][j].removeAll();
					tiles[i][j].revalidate();
					tiles[i][j].repaint();
					tiles[i][j].setName("trap");		
					tiles[i-1][j].removeAll();
					tiles[i-1][j].revalidate();
					tiles[i-1][j].repaint();
					tiles[i-1][j].add(elephantIcon2);
					tiles[i-1][j].setName("blue elephant");
					if (i==2 && j==0)
						tiles[i][j].add(trapIcon1);
					else if (i==2 && j==8)
						tiles[i][j].add(trapIcon2);
					else if (i==3 && j==1)
						tiles[i][j].add(trapIcon3);
					else if (i==3 && j==7)
						tiles[i][j].add(trapIcon4);
					else if (i==4 && j==0)
						tiles[i][j].add(trapIcon5);
					else if (i==4 && j==8)
						tiles[i][j].add(trapIcon6);		
			}
			else {
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i-1][j].removeAll();
				tiles[i-1][j].revalidate();
				tiles[i-1][j].repaint();
				tiles[i-1][j].add(elephantIcon2);
				tiles[i-1][j].setName("blue elephant");
			}
		}else if(a.equals("blue lion")){
			if((i == 3 || i == 6) && 
			   (j == 3 || j == 4 || j == 5)){
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i-3][j].removeAll();
				tiles[i-3][j].revalidate();
				tiles[i-3][j].repaint();
				tiles[i-3][j].add(lionIcon2);
				tiles[i-3][j].setName("blue lion");
			}
			else if((i == 2 && (j == 0 || j == 8))||
				   (i == 3 && (j == 1 || j == 7))||
				   (i == 4 && (j == 0 || j == 8))){
					tiles[i][j].removeAll();
					tiles[i][j].revalidate();
					tiles[i][j].repaint();
					tiles[i][j].setName("trap");		
					tiles[i-1][j].removeAll();
					tiles[i-1][j].revalidate();
					tiles[i-1][j].repaint();
					tiles[i-1][j].add(lionIcon2);
					tiles[i-1][j].setName("blue lion");
					if (i==2 && j==0)
						tiles[i][j].add(trapIcon1);
					else if (i==2 && j==8)
						tiles[i][j].add(trapIcon2);
					else if (i==3 && j==1)
						tiles[i][j].add(trapIcon3);
					else if (i==3 && j==7)
						tiles[i][j].add(trapIcon4);
					else if (i==4 && j==0)
						tiles[i][j].add(trapIcon5);
					else if (i==4 && j==8)
						tiles[i][j].add(trapIcon6);		
			}else{
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i-1][j].removeAll();
				tiles[i-1][j].revalidate();
				tiles[i-1][j].repaint();
				tiles[i-1][j].add(lionIcon2);
				tiles[i-1][j].setName("blue lion");
			   }
		}else if(a.equals("blue tiger")){
			if((i == 3 || i == 6) && 
			   (j == 3 || j == 4 || j == 5)){
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i-3][j].removeAll();
				tiles[i-3][j].revalidate();
				tiles[i-3][j].repaint();
				tiles[i-3][j].add(tigerIcon2);
				tiles[i-3][j].setName("blue tiger");
			}
			else if((i == 2 && (j == 0 || j == 8))||
				   (i == 3 && (j == 1 || j == 7))||
				   (i == 4 && (j == 0 || j == 8))){
					tiles[i][j].removeAll();
					tiles[i][j].revalidate();
					tiles[i][j].repaint();
					tiles[i][j].setName("trap");		
					tiles[i-1][j].removeAll();
					tiles[i-1][j].revalidate();
					tiles[i-1][j].repaint();
					tiles[i-1][j].add(tigerIcon2);
					tiles[i-1][j].setName("blue tiger");
					if (i==2 && j==0)
						tiles[i][j].add(trapIcon1);
					else if (i==2 && j==8)
						tiles[i][j].add(trapIcon2);
					else if (i==3 && j==1)
						tiles[i][j].add(trapIcon3);
					else if (i==3 && j==7)
						tiles[i][j].add(trapIcon4);
					else if (i==4 && j==0)
						tiles[i][j].add(trapIcon5);
					else if (i==4 && j==8)
						tiles[i][j].add(trapIcon6);		
			}else{
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i-1][j].removeAll();
				tiles[i-1][j].revalidate();
				tiles[i-1][j].repaint();
				tiles[i-1][j].add(tigerIcon2);
				tiles[i-1][j].setName("blue tiger");
			   }
		}else if(a.equals("blue leopard")){
			if((i == 2 && (j == 0 || j == 8))||
				   (i == 3 && (j == 1 || j == 7))||
				   (i == 4 && (j == 0 || j == 8))){
					tiles[i][j].removeAll();
					tiles[i][j].revalidate();
					tiles[i][j].repaint();
					tiles[i][j].setName("trap");		
					tiles[i-1][j].removeAll();
					tiles[i-1][j].revalidate();
					tiles[i-1][j].repaint();
					tiles[i-1][j].add(leopardIcon2);
					tiles[i-1][j].setName("blue leopard");
					if (i==2 && j==0)
						tiles[i][j].add(trapIcon1);
					else if (i==2 && j==8)
						tiles[i][j].add(trapIcon2);
					else if (i==3 && j==1)
						tiles[i][j].add(trapIcon3);
					else if (i==3 && j==7)
						tiles[i][j].add(trapIcon4);
					else if (i==4 && j==0)
						tiles[i][j].add(trapIcon5);
					else if (i==4 && j==8)
						tiles[i][j].add(trapIcon6);		
			}
			else {
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i-1][j].removeAll();
				tiles[i-1][j].revalidate();
				tiles[i-1][j].repaint();
				tiles[i-1][j].add(leopardIcon2);
				tiles[i-1][j].setName("blue leopard");
			}
		}else if(a.equals("blue mouse")){
			//in river
			if((i == 1 && (j == 3 || j == 4 || j == 5))||
					(i == 2 && (j == 3 || j == 4 || j == 5))||
					(i == 4 && (j == 3 || j == 4 || j == 5))||
					(i == 5 && (j == 3 || j == 4 || j == 5))){
					tiles[i][j].removeAll();
					tiles[i][j].revalidate();
					tiles[i][j].repaint();
					tiles[i][j].setName("river");		
					tiles[i-1][j].removeAll();
					tiles[i-1][j].revalidate();
					tiles[i-1][j].repaint();
					tiles[i-1][j].add(mouseIcon2);
					tiles[i-1][j].setName("blue mouse");
					if (i==1 && j==3)
						tiles[i][j].add(riverIcon1);
					else if (i==1 && j==4)
						tiles[i][j].add(riverIcon2);
					else if (i==1 && j==5)
						tiles[i][j].add(riverIcon3);
					else if (i==2 && j==3)
						tiles[i][j].add(riverIcon4);
					else if (i==2 && j==4)
						tiles[i][j].add(riverIcon5);
					else if (i==2 && j==5)
						tiles[i][j].add(riverIcon6);
					else if (i==4 && j==3)
						tiles[i][j].add(riverIcon7);
					else if (i==4 && j==4)
						tiles[i][j].add(riverIcon8);
					else if (i==4 && j==5)
						tiles[i][j].add(riverIcon9);
					else if (i==5 && j==3)
						tiles[i][j].add(riverIcon10);
					else if (i==5 && j==4)
						tiles[i][j].add(riverIcon11);
					else if (i==5 && j==5)
						tiles[i][j].add(riverIcon12);
			}
			else if((i == 2 && (j == 0 || j == 8))||
				   (i == 3 && (j == 1 || j == 7))||
				   (i == 4 && (j == 0 || j == 8))){
					tiles[i][j].removeAll();
					tiles[i][j].revalidate();
					tiles[i][j].repaint();
					tiles[i][j].setName("trap");		
					tiles[i-1][j].removeAll();
					tiles[i-1][j].revalidate();
					tiles[i-1][j].repaint();
					tiles[i-1][j].add(mouseIcon2);
					tiles[i-1][j].setName("blue mouse");
					if (i==2 && j==0)
						tiles[i][j].add(trapIcon1);
					else if (i==2 && j==8)
						tiles[i][j].add(trapIcon2);
					else if (i==3 && j==1)
						tiles[i][j].add(trapIcon3);
					else if (i==3 && j==7)
						tiles[i][j].add(trapIcon4);
					else if (i==4 && j==0)
						tiles[i][j].add(trapIcon5);
					else if (i==4 && j==8)
						tiles[i][j].add(trapIcon6);		
			}
			else {
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i-1][j].removeAll();
				tiles[i-1][j].revalidate();
				tiles[i-1][j].repaint();
				tiles[i-1][j].add(mouseIcon2);
				tiles[i-1][j].setName("blue mouse");
			}
		}else if(a.equals("blue cat")){
			if((i == 2 && (j == 0 || j == 8))||
				   (i == 3 && (j == 1 || j == 7))||
				   (i == 4 && (j == 0 || j == 8))){
					tiles[i][j].removeAll();
					tiles[i][j].revalidate();
					tiles[i][j].repaint();
					tiles[i][j].setName("trap");		
					tiles[i-1][j].removeAll();
					tiles[i-1][j].revalidate();
					tiles[i-1][j].repaint();
					tiles[i-1][j].add(catIcon2);
					tiles[i-1][j].setName("blue cat");
					if (i==2 && j==0)
						tiles[i][j].add(trapIcon1);
					else if (i==2 && j==8)
						tiles[i][j].add(trapIcon2);
					else if (i==3 && j==1)
						tiles[i][j].add(trapIcon3);
					else if (i==3 && j==7)
						tiles[i][j].add(trapIcon4);
					else if (i==4 && j==0)
						tiles[i][j].add(trapIcon5);
					else if (i==4 && j==8)
						tiles[i][j].add(trapIcon6);		
			}
			else if((i == 2 && (j == 0 || j == 8))||
				   (i == 3 && (j == 1 || j == 7))||
				   (i == 4 && (j == 0 || j == 8))){
					tiles[i][j].removeAll();
					tiles[i][j].revalidate();
					tiles[i][j].repaint();
					tiles[i][j].setName("trap");		
					tiles[i-1][j].removeAll();
					tiles[i-1][j].revalidate();
					tiles[i-1][j].repaint();
					tiles[i-1][j].add(catIcon2);
					tiles[i-1][j].setName("blue cat");
					if (i==2 && j==0)
						tiles[i][j].add(trapIcon1);
					else if (i==2 && j==8)
						tiles[i][j].add(trapIcon2);
					else if (i==3 && j==1)
						tiles[i][j].add(trapIcon3);
					else if (i==3 && j==7)
						tiles[i][j].add(trapIcon4);
					else if (i==4 && j==0)
						tiles[i][j].add(trapIcon5);
					else if (i==4 && j==8)
						tiles[i][j].add(trapIcon6);		
			}
			else {
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i-1][j].removeAll();
				tiles[i-1][j].revalidate();
				tiles[i-1][j].repaint();
				tiles[i-1][j].add(catIcon2);
				tiles[i-1][j].setName("blue cat");
			}
		}else if(a.equals("blue wolf")){
			if((i == 2 && (j == 0 || j == 8))||
				   (i == 3 && (j == 1 || j == 7))||
				   (i == 4 && (j == 0 || j == 8))){
					tiles[i][j].removeAll();
					tiles[i][j].revalidate();
					tiles[i][j].repaint();
					tiles[i][j].setName("trap");		
					tiles[i-1][j].removeAll();
					tiles[i-1][j].revalidate();
					tiles[i-1][j].repaint();
					tiles[i-1][j].add(wolfIcon2);
					tiles[i-1][j].setName("blue wolf");
					if (i==2 && j==0)
						tiles[i][j].add(trapIcon1);
					else if (i==2 && j==8)
						tiles[i][j].add(trapIcon2);
					else if (i==3 && j==1)
						tiles[i][j].add(trapIcon3);
					else if (i==3 && j==7)
						tiles[i][j].add(trapIcon4);
					else if (i==4 && j==0)
						tiles[i][j].add(trapIcon5);
					else if (i==4 && j==8)
						tiles[i][j].add(trapIcon6);		
			}
			else {
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i-1][j].removeAll();
				tiles[i-1][j].revalidate();
				tiles[i-1][j].repaint();
				tiles[i-1][j].add(wolfIcon2);
				tiles[i-1][j].setName("blue wolf");
			}
		}else if(a.equals("blue dog")){
			if((i == 2 && (j == 0 || j == 8))||
				   (i == 3 && (j == 1 || j == 7))||
				   (i == 4 && (j == 0 || j == 8))){
					tiles[i][j].removeAll();
					tiles[i][j].revalidate();
					tiles[i][j].repaint();
					tiles[i][j].setName("trap");		
					tiles[i-1][j].removeAll();
					tiles[i-1][j].revalidate();
					tiles[i-1][j].repaint();
					tiles[i-1][j].add(dogIcon2);
					tiles[i-1][j].setName("blue dog");
					if (i==2 && j==0)
						tiles[i][j].add(trapIcon1);
					else if (i==2 && j==8)
						tiles[i][j].add(trapIcon2);
					else if (i==3 && j==1)
						tiles[i][j].add(trapIcon3);
					else if (i==3 && j==7)
						tiles[i][j].add(trapIcon4);
					else if (i==4 && j==0)
						tiles[i][j].add(trapIcon5);
					else if (i==4 && j==8)
						tiles[i][j].add(trapIcon6);		
			}
			else {
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i-1][j].removeAll();
				tiles[i-1][j].revalidate();
				tiles[i-1][j].repaint();
				tiles[i-1][j].add(dogIcon2);
				tiles[i-1][j].setName("blue dog");
			}
		}
		
	}
	
	public void moveS(int i, int j, String a){
		//red
		if(a.equals("red elephant")){
			if((i == 2 && (j == 0 || j == 8))||
				   (i == 3 && (j == 1 || j == 7))||
				   (i == 4 && (j == 0 || j == 8))){
					tiles[i][j].removeAll();
					tiles[i][j].revalidate();
					tiles[i][j].repaint();
					tiles[i][j].setName("trap");		
					tiles[i+1][j].removeAll();
					tiles[i+1][j].revalidate();
					tiles[i+1][j].repaint();
					tiles[i+1][j].add(elephantIcon);
					tiles[i+1][j].setName("red elephant");
					if (i==2 && j==0)
						tiles[i][j].add(trapIcon1);
					else if (i==2 && j==8)
						tiles[i][j].add(trapIcon2);
					else if (i==3 && j==1)
						tiles[i][j].add(trapIcon3);
					else if (i==3 && j==7)
						tiles[i][j].add(trapIcon4);
					else if (i==4 && j==0)
						tiles[i][j].add(trapIcon5);
					else if (i==4 && j==8)
						tiles[i][j].add(trapIcon6);		
			}
			else {
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i+1][j].removeAll();
				tiles[i+1][j].revalidate();
				tiles[i+1][j].repaint();
				tiles[i+1][j].add(elephantIcon);
				tiles[i+1][j].setName("red elephant");
			}
		}else if(a.equals("red lion")){
			if((i == 3 || i == 0) && 
			   (j == 3 || j == 4 || j == 5)){
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i+3][j].removeAll();
				tiles[i+3][j].revalidate();
				tiles[i+3][j].repaint();
				tiles[i+3][j].add(lionIcon);
				tiles[i+3][j].setName("red lion");
			}
			else if((i == 2 && (j == 0 || j == 8))||
				   (i == 3 && (j == 1 || j == 7))||
				   (i == 4 && (j == 0 || j == 8))){
					tiles[i][j].removeAll();
					tiles[i][j].revalidate();
					tiles[i][j].repaint();
					tiles[i][j].setName("trap");		
					tiles[i+1][j].removeAll();
					tiles[i+1][j].revalidate();
					tiles[i+1][j].repaint();
					tiles[i+1][j].add(lionIcon);
					tiles[i+1][j].setName("red lion");
					if (i==2 && j==0)
						tiles[i][j].add(trapIcon1);
					else if (i==2 && j==8)
						tiles[i][j].add(trapIcon2);
					else if (i==3 && j==1)
						tiles[i][j].add(trapIcon3);
					else if (i==3 && j==7)
						tiles[i][j].add(trapIcon4);
					else if (i==4 && j==0)
						tiles[i][j].add(trapIcon5);
					else if (i==4 && j==8)
						tiles[i][j].add(trapIcon6);		
			}else{
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i+1][j].removeAll();
				tiles[i+1][j].revalidate();
				tiles[i+1][j].repaint();
				tiles[i+1][j].add(lionIcon);
				tiles[i+1][j].setName("red lion");
			}
		}else if(a.equals("red tiger")){
			if((i == 3 || i == 0) && 
			   (j == 3 || j == 4 || j == 5)){
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i+3][j].removeAll();
				tiles[i+3][j].revalidate();
				tiles[i+3][j].repaint();
				tiles[i+3][j].add(tigerIcon);
				tiles[i+3][j].setName("red tiger");
			}
			else if((i == 2 && (j == 0 || j == 8))||
				   (i == 3 && (j == 1 || j == 7))||
				   (i == 4 && (j == 0 || j == 8))){
					tiles[i][j].removeAll();
					tiles[i][j].revalidate();
					tiles[i][j].repaint();
					tiles[i][j].setName("trap");		
					tiles[i+1][j].removeAll();
					tiles[i+1][j].revalidate();
					tiles[i+1][j].repaint();
					tiles[i+1][j].add(tigerIcon);
					tiles[i+1][j].setName("red tiger");
					if (i==2 && j==0)
						tiles[i][j].add(trapIcon1);
					else if (i==2 && j==8)
						tiles[i][j].add(trapIcon2);
					else if (i==3 && j==1)
						tiles[i][j].add(trapIcon3);
					else if (i==3 && j==7)
						tiles[i][j].add(trapIcon4);
					else if (i==4 && j==0)
						tiles[i][j].add(trapIcon5);
					else if (i==4 && j==8)
						tiles[i][j].add(trapIcon6);		
			}else{
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i+1][j].removeAll();
				tiles[i+1][j].revalidate();
				tiles[i+1][j].repaint();
				tiles[i+1][j].add(tigerIcon);
				tiles[i+1][j].setName("red tiger");
			}
		}else if(a.equals("red leopard")){
			if((i == 2 && (j == 0 || j == 8))||
				   (i == 3 && (j == 1 || j == 7))||
				   (i == 4 && (j == 0 || j == 8))){
					tiles[i][j].removeAll();
					tiles[i][j].revalidate();
					tiles[i][j].repaint();
					tiles[i][j].setName("trap");		
					tiles[i+1][j].removeAll();
					tiles[i+1][j].revalidate();
					tiles[i+1][j].repaint();
					tiles[i+1][j].add(leopardIcon);
					tiles[i+1][j].setName("red leopard");
					if (i==2 && j==0)
						tiles[i][j].add(trapIcon1);
					else if (i==2 && j==8)
						tiles[i][j].add(trapIcon2);
					else if (i==3 && j==1)
						tiles[i][j].add(trapIcon3);
					else if (i==3 && j==7)
						tiles[i][j].add(trapIcon4);
					else if (i==4 && j==0)
						tiles[i][j].add(trapIcon5);
					else if (i==4 && j==8)
						tiles[i][j].add(trapIcon6);		
			}
			else {
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i+1][j].removeAll();
				tiles[i+1][j].revalidate();
				tiles[i+1][j].repaint();
				tiles[i+1][j].add(leopardIcon);
				tiles[i+1][j].setName("red leopard");
			}
		}else if(a.equals("red mouse")){
			//in river
			if((i == 1 && (j == 3 || j == 4 || j == 5))||
					(i == 2 && (j == 3 || j == 4 || j == 5))||
					(i == 4 && (j == 3 || j == 4 || j == 5))||
					(i == 5 && (j == 3 || j == 4 || j == 5))){
					tiles[i][j].removeAll();
					tiles[i][j].revalidate();
					tiles[i][j].repaint();
					tiles[i][j].setName("river");		
					tiles[i+1][j].removeAll();
					tiles[i+1][j].revalidate();
					tiles[i+1][j].repaint();
					tiles[i+1][j].add(mouseIcon);
					tiles[i+1][j].setName("red mouse");
					if (i==1 && j==3)
						tiles[i][j].add(riverIcon1);
					else if (i==1 && j==4)
						tiles[i][j].add(riverIcon2);
					else if (i==1 && j==5)
						tiles[i][j].add(riverIcon3);
					else if (i==2 && j==3)
						tiles[i][j].add(riverIcon4);
					else if (i==2 && j==4)
						tiles[i][j].add(riverIcon5);
					else if (i==2 && j==5)
						tiles[i][j].add(riverIcon6);
					else if (i==4 && j==3)
						tiles[i][j].add(riverIcon7);
					else if (i==4 && j==4)
						tiles[i][j].add(riverIcon8);
					else if (i==4 && j==5)
						tiles[i][j].add(riverIcon9);
					else if (i==5 && j==3)
						tiles[i][j].add(riverIcon10);
					else if (i==5 && j==4)
						tiles[i][j].add(riverIcon11);
					else if (i==5 && j==5)
						tiles[i][j].add(riverIcon12);
			}
			else if((i == 2 && (j == 0 || j == 8))||
				   (i == 3 && (j == 1 || j == 7))||
				   (i == 4 && (j == 0 || j == 8))){
					tiles[i][j].removeAll();
					tiles[i][j].revalidate();
					tiles[i][j].repaint();
					tiles[i][j].setName("trap");		
					tiles[i+1][j].removeAll();
					tiles[i+1][j].revalidate();
					tiles[i+1][j].repaint();
					tiles[i+1][j].add(mouseIcon);
					tiles[i+1][j].setName("red mouse");
					if (i==2 && j==0)
						tiles[i][j].add(trapIcon1);
					else if (i==2 && j==8)
						tiles[i][j].add(trapIcon2);
					else if (i==3 && j==1)
						tiles[i][j].add(trapIcon3);
					else if (i==3 && j==7)
						tiles[i][j].add(trapIcon4);
					else if (i==4 && j==0)
						tiles[i][j].add(trapIcon5);
					else if (i==4 && j==8)
						tiles[i][j].add(trapIcon6);		
			}
			else {
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i+1][j].removeAll();
				tiles[i+1][j].revalidate();
				tiles[i+1][j].repaint();
				tiles[i+1][j].add(mouseIcon);
				tiles[i+1][j].setName("red mouse");
			}
		}else if(a.equals("red cat")){
			if((i == 2 && (j == 0 || j == 8))||
				   (i == 3 && (j == 1 || j == 7))||
				   (i == 4 && (j == 0 || j == 8))){
					tiles[i][j].removeAll();
					tiles[i][j].revalidate();
					tiles[i][j].repaint();
					tiles[i][j].setName("trap");		
					tiles[i+1][j].removeAll();
					tiles[i+1][j].revalidate();
					tiles[i+1][j].repaint();
					tiles[i+1][j].add(catIcon);
					tiles[i+1][j].setName("red cat");
					if (i==2 && j==0)
						tiles[i][j].add(trapIcon1);
					else if (i==2 && j==8)
						tiles[i][j].add(trapIcon2);
					else if (i==3 && j==1)
						tiles[i][j].add(trapIcon3);
					else if (i==3 && j==7)
						tiles[i][j].add(trapIcon4);
					else if (i==4 && j==0)
						tiles[i][j].add(trapIcon5);
					else if (i==4 && j==8)
						tiles[i][j].add(trapIcon6);		
			}
			else {
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i+1][j].removeAll();
				tiles[i+1][j].revalidate();
				tiles[i+1][j].repaint();
				tiles[i+1][j].add(catIcon);
				tiles[i+1][j].setName("red cat");
			}
		}else if(a.equals("red wolf")){
			if((i == 2 && (j == 0 || j == 8))||
				   (i == 3 && (j == 1 || j == 7))||
				   (i == 4 && (j == 0 || j == 8))){
					tiles[i][j].removeAll();
					tiles[i][j].revalidate();
					tiles[i][j].repaint();
					tiles[i][j].setName("trap");		
					tiles[i+1][j].removeAll();
					tiles[i+1][j].revalidate();
					tiles[i+1][j].repaint();
					tiles[i+1][j].add(wolfIcon);
					tiles[i+1][j].setName("red wolf");
					if (i==2 && j==0)
						tiles[i][j].add(trapIcon1);
					else if (i==2 && j==8)
						tiles[i][j].add(trapIcon2);
					else if (i==3 && j==1)
						tiles[i][j].add(trapIcon3);
					else if (i==3 && j==7)
						tiles[i][j].add(trapIcon4);
					else if (i==4 && j==0)
						tiles[i][j].add(trapIcon5);
					else if (i==4 && j==8)
						tiles[i][j].add(trapIcon6);		
			}
			else {
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i+1][j].removeAll();
				tiles[i+1][j].revalidate();
				tiles[i+1][j].repaint();
				tiles[i+1][j].add(wolfIcon);
				tiles[i+1][j].setName("red wolf");
			}
		}else if(a.equals("red dog")){
			if((i == 2 && (j == 0 || j == 8))||
				   (i == 3 && (j == 1 || j == 7))||
				   (i == 4 && (j == 0 || j == 8))){
					tiles[i][j].removeAll();
					tiles[i][j].revalidate();
					tiles[i][j].repaint();
					tiles[i][j].setName("trap");		
					tiles[i+1][j].removeAll();
					tiles[i+1][j].revalidate();
					tiles[i+1][j].repaint();
					tiles[i+1][j].add(dogIcon);
					tiles[i+1][j].setName("red dog");
					if (i==2 && j==0)
						tiles[i][j].add(trapIcon1);
					else if (i==2 && j==8)
						tiles[i][j].add(trapIcon2);
					else if (i==3 && j==1)
						tiles[i][j].add(trapIcon3);
					else if (i==3 && j==7)
						tiles[i][j].add(trapIcon4);
					else if (i==4 && j==0)
						tiles[i][j].add(trapIcon5);
					else if (i==4 && j==8)
						tiles[i][j].add(trapIcon6);		
			} else {
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i+1][j].removeAll();
				tiles[i+1][j].revalidate();
				tiles[i+1][j].repaint();
				tiles[i+1][j].add(dogIcon);
				tiles[i+1][j].setName("red dog");
			}
		}//BLUE
		else if(a.equals("blue elephant")){
			if((i == 2 && (j == 0 || j == 8))||
				   (i == 3 && (j == 1 || j == 7))||
				   (i == 4 && (j == 0 || j == 8))){
					tiles[i][j].removeAll();
					tiles[i][j].revalidate();
					tiles[i][j].repaint();
					tiles[i][j].setName("trap");		
					tiles[i+1][j].removeAll();
					tiles[i+1][j].revalidate();
					tiles[i+1][j].repaint();
					tiles[i+1][j].add(elephantIcon2);
					tiles[i+1][j].setName("blue elephant");
					if (i==2 && j==0)
						tiles[i][j].add(trapIcon1);
					else if (i==2 && j==8)
						tiles[i][j].add(trapIcon2);
					else if (i==3 && j==1)
						tiles[i][j].add(trapIcon3);
					else if (i==3 && j==7)
						tiles[i][j].add(trapIcon4);
					else if (i==4 && j==0)
						tiles[i][j].add(trapIcon5);
					else if (i==4 && j==8)
						tiles[i][j].add(trapIcon6);		
			}
			else {
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i+1][j].removeAll();
				tiles[i+1][j].revalidate();
				tiles[i+1][j].repaint();
				tiles[i+1][j].add(elephantIcon2);
				tiles[i+1][j].setName("blue elephant");
			}
		}else if(a.equals("blue lion")){
			if((i == 3 || i == 0) && 
			   (j == 3 || j == 4 || j == 5)){
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i+3][j].removeAll();
				tiles[i+3][j].revalidate();
				tiles[i+3][j].repaint();
				tiles[i+3][j].add(lionIcon2);
				tiles[i+3][j].setName("blue lion");
			}
			else if((i == 2 && (j == 0 || j == 8))||
				   (i == 3 && (j == 1 || j == 7))||
				   (i == 4 && (j == 0 || j == 8))){
					tiles[i][j].removeAll();
					tiles[i][j].revalidate();
					tiles[i][j].repaint();
					tiles[i][j].setName("trap");		
					tiles[i+1][j].removeAll();
					tiles[i+1][j].revalidate();
					tiles[i+1][j].repaint();
					tiles[i+1][j].add(lionIcon2);
					tiles[i+1][j].setName("blue lion");
					if (i==2 && j==0)
						tiles[i][j].add(trapIcon1);
					else if (i==2 && j==8)
						tiles[i][j].add(trapIcon2);
					else if (i==3 && j==1)
						tiles[i][j].add(trapIcon3);
					else if (i==3 && j==7)
						tiles[i][j].add(trapIcon4);
					else if (i==4 && j==0)
						tiles[i][j].add(trapIcon5);
					else if (i==4 && j==8)
						tiles[i][j].add(trapIcon6);		
			}else{
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i+1][j].removeAll();
				tiles[i+1][j].revalidate();
				tiles[i+1][j].repaint();
				tiles[i+1][j].add(lionIcon2);
				tiles[i+1][j].setName("blue lion");
			}
		}else if(a.equals("blue tiger")){
			if((i == 3 || i == 0) && 
			   (j == 3 || j == 4 || j == 5)){
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i+3][j].removeAll();
				tiles[i+3][j].revalidate();
				tiles[i+3][j].repaint();
				tiles[i+3][j].add(tigerIcon2);
				tiles[i+3][j].setName("blue tiger");
			}
			else if((i == 2 && (j == 0 || j == 8))||
				   (i == 3 && (j == 1 || j == 7))||
				   (i == 4 && (j == 0 || j == 8))){
					tiles[i][j].removeAll();
					tiles[i][j].revalidate();
					tiles[i][j].repaint();
					tiles[i][j].setName("trap");		
					tiles[i+1][j].removeAll();
					tiles[i+1][j].revalidate();
					tiles[i+1][j].repaint();
					tiles[i+1][j].add(tigerIcon2);
					tiles[i+1][j].setName("blue tiger");
					if (i==2 && j==0)
						tiles[i][j].add(trapIcon1);
					else if (i==2 && j==8)
						tiles[i][j].add(trapIcon2);
					else if (i==3 && j==1)
						tiles[i][j].add(trapIcon3);
					else if (i==3 && j==7)
						tiles[i][j].add(trapIcon4);
					else if (i==4 && j==0)
						tiles[i][j].add(trapIcon5);
					else if (i==4 && j==8)
						tiles[i][j].add(trapIcon6);		
			}else{
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i+1][j].removeAll();
				tiles[i+1][j].revalidate();
				tiles[i+1][j].repaint();
				tiles[i+1][j].add(tigerIcon2);
				tiles[i+1][j].setName("blue tiger");
			}
		}else if(a.equals("blue leopard")){
			if((i == 2 && (j == 0 || j == 8))||
				   (i == 3 && (j == 1 || j == 7))||
				   (i == 4 && (j == 0 || j == 8))){
					tiles[i][j].removeAll();
					tiles[i][j].revalidate();
					tiles[i][j].repaint();
					tiles[i][j].setName("trap");		
					tiles[i+1][j].removeAll();
					tiles[i+1][j].revalidate();
					tiles[i+1][j].repaint();
					tiles[i+1][j].add(leopardIcon2);
					tiles[i+1][j].setName("blue leopard");
					if (i==2 && j==0)
						tiles[i][j].add(trapIcon1);
					else if (i==2 && j==8)
						tiles[i][j].add(trapIcon2);
					else if (i==3 && j==1)
						tiles[i][j].add(trapIcon3);
					else if (i==3 && j==7)
						tiles[i][j].add(trapIcon4);
					else if (i==4 && j==0)
						tiles[i][j].add(trapIcon5);
					else if (i==4 && j==8)
						tiles[i][j].add(trapIcon6);		
			}
			else {
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i+1][j].removeAll();
				tiles[i+1][j].revalidate();
				tiles[i+1][j].repaint();
				tiles[i+1][j].add(leopardIcon2);
				tiles[i+1][j].setName("blue leopard");
			}
		}else if(a.equals("blue mouse")){
			//in river
			if((i == 1 && (j == 3 || j == 4 || j == 5))||
					(i == 2 && (j == 3 || j == 4 || j == 5))||
					(i == 4 && (j == 3 || j == 4 || j == 5))||
					(i == 5 && (j == 3 || j == 4 || j == 5))){
					tiles[i][j].removeAll();
					tiles[i][j].revalidate();
					tiles[i][j].repaint();
					tiles[i][j].setName("river");		
					tiles[i+1][j].removeAll();
					tiles[i+1][j].revalidate();
					tiles[i+1][j].repaint();
					tiles[i+1][j].add(mouseIcon2);
					tiles[i+1][j].setName("blue mouse");
					if (i==1 && j==3)
						tiles[i][j].add(riverIcon1);
					else if (i==1 && j==4)
						tiles[i][j].add(riverIcon2);
					else if (i==1 && j==5)
						tiles[i][j].add(riverIcon3);
					else if (i==2 && j==3)
						tiles[i][j].add(riverIcon4);
					else if (i==2 && j==4)
						tiles[i][j].add(riverIcon5);
					else if (i==2 && j==5)
						tiles[i][j].add(riverIcon6);
					else if (i==4 && j==3)
						tiles[i][j].add(riverIcon7);
					else if (i==4 && j==4)
						tiles[i][j].add(riverIcon8);
					else if (i==4 && j==5)
						tiles[i][j].add(riverIcon9);
					else if (i==5 && j==3)
						tiles[i][j].add(riverIcon10);
					else if (i==5 && j==4)
						tiles[i][j].add(riverIcon11);
					else if (i==5 && j==5)
						tiles[i][j].add(riverIcon12);
			}
			else if((i == 2 && (j == 0 || j == 8))||
				   (i == 3 && (j == 1 || j == 7))||
				   (i == 4 && (j == 0 || j == 8))){
					tiles[i][j].removeAll();
					tiles[i][j].revalidate();
					tiles[i][j].repaint();
					tiles[i][j].setName("trap");		
					tiles[i+1][j].removeAll();
					tiles[i+1][j].revalidate();
					tiles[i+1][j].repaint();
					tiles[i+1][j].add(mouseIcon2);
					tiles[i+1][j].setName("blue mouse");
					if (i==2 && j==0)
						tiles[i][j].add(trapIcon1);
					else if (i==2 && j==8)
						tiles[i][j].add(trapIcon2);
					else if (i==3 && j==1)
						tiles[i][j].add(trapIcon3);
					else if (i==3 && j==7)
						tiles[i][j].add(trapIcon4);
					else if (i==4 && j==0)
						tiles[i][j].add(trapIcon5);
					else if (i==4 && j==8)
						tiles[i][j].add(trapIcon6);		
			}
			else {
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i+1][j].removeAll();
				tiles[i+1][j].revalidate();
				tiles[i+1][j].repaint();
				tiles[i+1][j].add(mouseIcon2);
				tiles[i+1][j].setName("blue mouse");
			}
		}else if(a.equals("blue cat")){
			if((i == 2 && (j == 0 || j == 8))||
				   (i == 3 && (j == 1 || j == 7))||
				   (i == 4 && (j == 0 || j == 8))){
					tiles[i][j].removeAll();
					tiles[i][j].revalidate();
					tiles[i][j].repaint();
					tiles[i][j].setName("trap");		
					tiles[i+1][j].removeAll();
					tiles[i+1][j].revalidate();
					tiles[i+1][j].repaint();
					tiles[i+1][j].add(catIcon2);
					tiles[i+1][j].setName("blue cat");
					if (i==2 && j==0)
						tiles[i][j].add(trapIcon1);
					else if (i==2 && j==8)
						tiles[i][j].add(trapIcon2);
					else if (i==3 && j==1)
						tiles[i][j].add(trapIcon3);
					else if (i==3 && j==7)
						tiles[i][j].add(trapIcon4);
					else if (i==4 && j==0)
						tiles[i][j].add(trapIcon5);
					else if (i==4 && j==8)
						tiles[i][j].add(trapIcon6);		
			} else {
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i+1][j].removeAll();
				tiles[i+1][j].revalidate();
				tiles[i+1][j].repaint();
				tiles[i+1][j].add(catIcon2);
				tiles[i+1][j].setName("blue cat");
			}
		}else if(a.equals("blue wolf")){
			if((i == 2 && (j == 0 || j == 8))||
				   (i == 3 && (j == 1 || j == 7))||
				   (i == 4 && (j == 0 || j == 8))){
					tiles[i][j].removeAll();
					tiles[i][j].revalidate();
					tiles[i][j].repaint();
					tiles[i][j].setName("trap");		
					tiles[i+1][j].removeAll();
					tiles[i+1][j].revalidate();
					tiles[i+1][j].repaint();
					tiles[i+1][j].add(wolfIcon2);
					tiles[i+1][j].setName("blue wolf");
					if (i==2 && j==0)
						tiles[i][j].add(trapIcon1);
					else if (i==2 && j==8)
						tiles[i][j].add(trapIcon2);
					else if (i==3 && j==1)
						tiles[i][j].add(trapIcon3);
					else if (i==3 && j==7)
						tiles[i][j].add(trapIcon4);
					else if (i==4 && j==0)
						tiles[i][j].add(trapIcon5);
					else if (i==4 && j==8)
						tiles[i][j].add(trapIcon6);		
			} else {
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i+1][j].removeAll();
				tiles[i+1][j].revalidate();
				tiles[i+1][j].repaint();
				tiles[i+1][j].add(wolfIcon2);
				tiles[i+1][j].setName("blue wolf");
			}
		}else if(a.equals("blue dog")){
			if((i == 2 && (j == 0 || j == 8))||
				   (i == 3 && (j == 1 || j == 7))||
				   (i == 4 && (j == 0 || j == 8))){
					tiles[i][j].removeAll();
					tiles[i][j].revalidate();
					tiles[i][j].repaint();
					tiles[i][j].setName("trap");		
					tiles[i+1][j].removeAll();
					tiles[i+1][j].revalidate();
					tiles[i+1][j].repaint();
					tiles[i+1][j].add(dogIcon2);
					tiles[i+1][j].setName("blue dog");
					if (i==2 && j==0)
						tiles[i][j].add(trapIcon1);
					else if (i==2 && j==8)
						tiles[i][j].add(trapIcon2);
					else if (i==3 && j==1)
						tiles[i][j].add(trapIcon3);
					else if (i==3 && j==7)
						tiles[i][j].add(trapIcon4);
					else if (i==4 && j==0)
						tiles[i][j].add(trapIcon5);
					else if (i==4 && j==8)
						tiles[i][j].add(trapIcon6);		
			}
			else {
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i+1][j].removeAll();
				tiles[i+1][j].revalidate();
				tiles[i+1][j].repaint();
				tiles[i+1][j].add(dogIcon2);
				tiles[i+1][j].setName("blue dog");
			}
		}
		
	}
	
	public void moveA(int i, int j, String a){
		//red
		if(a.equals("red elephant")){
			if((i == 2 && (j == 0 || j == 8))||
				   (i == 3 && (j == 1 || j == 7))||
				   (i == 4 && (j == 0 || j == 8))){
					tiles[i][j].removeAll();
					tiles[i][j].revalidate();
					tiles[i][j].repaint();
					tiles[i][j].setName("trap");		
					tiles[i][j-1].removeAll();
					tiles[i][j-1].revalidate();
					tiles[i][j-1].repaint();
					tiles[i][j-1].add(elephantIcon);
					tiles[i][j-1].setName("red elephant");
					if (i==2 && j==0)
						tiles[i][j].add(trapIcon1);
					else if (i==2 && j==8)
						tiles[i][j].add(trapIcon2);
					else if (i==3 && j==1)
						tiles[i][j].add(trapIcon3);
					else if (i==3 && j==7)
						tiles[i][j].add(trapIcon4);
					else if (i==4 && j==0)
						tiles[i][j].add(trapIcon5);
					else if (i==4 && j==8)
						tiles[i][j].add(trapIcon6);		
			} else {
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i][j-1].removeAll();
				tiles[i][j-1].revalidate();
				tiles[i][j-1].repaint();
				tiles[i][j-1].add(elephantIcon);
				tiles[i][j-1].setName("red elephant");
			}
		}else if(a.equals("red lion")){
			if((i == 1 || i == 2 || i == 4 || i == 5) && 
			   (j == 6)){
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i][j-4].removeAll();
				tiles[i][j-4].revalidate();
				tiles[i][j-4].repaint();
				tiles[i][j-4].add(lionIcon);
				tiles[i][j-4].setName("red lion");
			} else if((i == 2 && (j == 0 || j == 8))||
				   (i == 3 && (j == 1 || j == 7))||
				   (i == 4 && (j == 0 || j == 8))){
					tiles[i][j].removeAll();
					tiles[i][j].revalidate();
					tiles[i][j].repaint();
					tiles[i][j].setName("trap");		
					tiles[i][j-1].removeAll();
					tiles[i][j-1].revalidate();
					tiles[i][j-1].repaint();
					tiles[i][j-1].add(lionIcon);
					tiles[i][j-1].setName("red lion");
					if (i==2 && j==0)
						tiles[i][j].add(trapIcon1);
					else if (i==2 && j==8)
						tiles[i][j].add(trapIcon2);
					else if (i==3 && j==1)
						tiles[i][j].add(trapIcon3);
					else if (i==3 && j==7)
						tiles[i][j].add(trapIcon4);
					else if (i==4 && j==0)
						tiles[i][j].add(trapIcon5);
					else if (i==4 && j==8)
						tiles[i][j].add(trapIcon6);		
			}
			else{
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i][j-1].removeAll();
				tiles[i][j-1].revalidate();
				tiles[i][j-1].repaint();
				tiles[i][j-1].add(lionIcon);
				tiles[i][j-1].setName("red lion");
			}
		}else if(a.equals("red tiger")){
			if((i == 1 || i == 2 || i == 4 || i == 5) && 
			   (j == 6)){
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i][j-4].removeAll();
				tiles[i][j-4].revalidate();
				tiles[i][j-4].repaint();
				tiles[i][j-4].add(tigerIcon);
				tiles[i][j-4].setName("red tiger");
			} else if((i == 2 && (j == 0 || j == 8))||
				   (i == 3 && (j == 1 || j == 7))||
				   (i == 4 && (j == 0 || j == 8))){
					tiles[i][j].removeAll();
					tiles[i][j].revalidate();
					tiles[i][j].repaint();
					tiles[i][j].setName("trap");		
					tiles[i][j-1].removeAll();
					tiles[i][j-1].revalidate();
					tiles[i][j-1].repaint();
					tiles[i][j-1].add(tigerIcon);
					tiles[i][j-1].setName("red tiger");
					if (i==2 && j==0)
						tiles[i][j].add(trapIcon1);
					else if (i==2 && j==8)
						tiles[i][j].add(trapIcon2);
					else if (i==3 && j==1)
						tiles[i][j].add(trapIcon3);
					else if (i==3 && j==7)
						tiles[i][j].add(trapIcon4);
					else if (i==4 && j==0)
						tiles[i][j].add(trapIcon5);
					else if (i==4 && j==8)
						tiles[i][j].add(trapIcon6);		
			} else{
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i][j-1].removeAll();
				tiles[i][j-1].revalidate();
				tiles[i][j-1].repaint();
				tiles[i][j-1].add(tigerIcon);
				tiles[i][j-1].setName("red tiger");
			}
		}else if(a.equals("red leopard")){
			if((i == 2 && (j == 0 || j == 8))||
				   (i == 3 && (j == 1 || j == 7))||
				   (i == 4 && (j == 0 || j == 8))){
					tiles[i][j].removeAll();
					tiles[i][j].revalidate();
					tiles[i][j].repaint();
					tiles[i][j].setName("trap");		
					tiles[i][j-1].removeAll();
					tiles[i][j-1].revalidate();
					tiles[i][j-1].repaint();
					tiles[i][j-1].add(leopardIcon);
					tiles[i][j-1].setName("red leopard");
					if (i==2 && j==0)
						tiles[i][j].add(trapIcon1);
					else if (i==2 && j==8)
						tiles[i][j].add(trapIcon2);
					else if (i==3 && j==1)
						tiles[i][j].add(trapIcon3);
					else if (i==3 && j==7)
						tiles[i][j].add(trapIcon4);
					else if (i==4 && j==0)
						tiles[i][j].add(trapIcon5);
					else if (i==4 && j==8)
						tiles[i][j].add(trapIcon6);		
			}
			else {
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i][j-1].removeAll();
				tiles[i][j-1].revalidate();
				tiles[i][j-1].repaint();
				tiles[i][j-1].add(leopardIcon);
				tiles[i][j-1].setName("red leopard");
			}
		}else if(a.equals("red mouse")){
			//in river
			if((i == 1 && (j == 3 || j == 4 || j == 5))||
					(i == 2 && (j == 3 || j == 4 || j == 5))||
					(i == 4 && (j == 3 || j == 4 || j == 5))||
					(i == 5 && (j == 3 || j == 4 || j == 5))){
					tiles[i][j].removeAll();
					tiles[i][j].revalidate();
					tiles[i][j].repaint();
					tiles[i][j].setName("river");		
					tiles[i][j-1].removeAll();
					tiles[i][j-1].revalidate();
					tiles[i][j-1].repaint();
					tiles[i][j-1].add(mouseIcon);
					tiles[i][j-1].setName("red mouse");
					if (i==1 && j==3)
						tiles[i][j].add(riverIcon1);
					else if (i==1 && j==4)
						tiles[i][j].add(riverIcon2);
					else if (i==1 && j==5)
						tiles[i][j].add(riverIcon3);
					else if (i==2 && j==3)
						tiles[i][j].add(riverIcon4);
					else if (i==2 && j==4)
						tiles[i][j].add(riverIcon5);
					else if (i==2 && j==5)
						tiles[i][j].add(riverIcon6);
					else if (i==4 && j==3)
						tiles[i][j].add(riverIcon7);
					else if (i==4 && j==4)
						tiles[i][j].add(riverIcon8);
					else if (i==4 && j==5)
						tiles[i][j].add(riverIcon9);
					else if (i==5 && j==3)
						tiles[i][j].add(riverIcon10);
					else if (i==5 && j==4)
						tiles[i][j].add(riverIcon11);
					else if (i==5 && j==5)
						tiles[i][j].add(riverIcon12);
			}
			else if((i == 2 && (j == 0 || j == 8))||
				   (i == 3 && (j == 1 || j == 7))||
				   (i == 4 && (j == 0 || j == 8))){
					tiles[i][j].removeAll();
					tiles[i][j].revalidate();
					tiles[i][j].repaint();
					tiles[i][j].setName("trap");		
					tiles[i][j-1].removeAll();
					tiles[i][j-1].revalidate();
					tiles[i][j-1].repaint();
					tiles[i][j-1].add(mouseIcon);
					tiles[i][j-1].setName("red mouse");
					if (i==2 && j==0)
						tiles[i][j].add(trapIcon1);
					else if (i==2 && j==8)
						tiles[i][j].add(trapIcon2);
					else if (i==3 && j==1)
						tiles[i][j].add(trapIcon3);
					else if (i==3 && j==7)
						tiles[i][j].add(trapIcon4);
					else if (i==4 && j==0)
						tiles[i][j].add(trapIcon5);
					else if (i==4 && j==8)
						tiles[i][j].add(trapIcon6);		
			}
			else {
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i][j-1].removeAll();
				tiles[i][j-1].revalidate();
				tiles[i][j-1].repaint();
				tiles[i][j-1].add(mouseIcon);
				tiles[i][j-1].setName("red mouse");
			}
		}else if(a.equals("red cat")){
			if((i == 2 && (j == 0 || j == 8))||
				   (i == 3 && (j == 1 || j == 7))||
				   (i == 4 && (j == 0 || j == 8))){
					tiles[i][j].removeAll();
					tiles[i][j].revalidate();
					tiles[i][j].repaint();
					tiles[i][j].setName("trap");		
					tiles[i][j-1].removeAll();
					tiles[i][j-1].revalidate();
					tiles[i][j-1].repaint();
					tiles[i][j-1].add(catIcon);
					tiles[i][j-1].setName("red cat");
					if (i==2 && j==0)
						tiles[i][j].add(trapIcon1);
					else if (i==2 && j==8)
						tiles[i][j].add(trapIcon2);
					else if (i==3 && j==1)
						tiles[i][j].add(trapIcon3);
					else if (i==3 && j==7)
						tiles[i][j].add(trapIcon4);
					else if (i==4 && j==0)
						tiles[i][j].add(trapIcon5);
					else if (i==4 && j==8)
						tiles[i][j].add(trapIcon6);		
			} else {
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i][j-1].removeAll();
				tiles[i][j-1].revalidate();
				tiles[i][j-1].repaint();
				tiles[i][j-1].add(catIcon);
				tiles[i][j-1].setName("red cat");
			}
		}else if(a.equals("red wolf")){
			if((i == 2 && (j == 0 || j == 8))||
				   (i == 3 && (j == 1 || j == 7))||
				   (i == 4 && (j == 0 || j == 8))){
					tiles[i][j].removeAll();
					tiles[i][j].revalidate();
					tiles[i][j].repaint();
					tiles[i][j].setName("trap");		
					tiles[i][j-1].removeAll();
					tiles[i][j-1].revalidate();
					tiles[i][j-1].repaint();
					tiles[i][j-1].add(wolfIcon);
					tiles[i][j-1].setName("red wolf");
					if (i==2 && j==0)
						tiles[i][j].add(trapIcon1);
					else if (i==2 && j==8)
						tiles[i][j].add(trapIcon2);
					else if (i==3 && j==1)
						tiles[i][j].add(trapIcon3);
					else if (i==3 && j==7)
						tiles[i][j].add(trapIcon4);
					else if (i==4 && j==0)
						tiles[i][j].add(trapIcon5);
					else if (i==4 && j==8)
						tiles[i][j].add(trapIcon6);		
			}
			else {
			tiles[i][j].removeAll();
			tiles[i][j].revalidate();
			tiles[i][j].repaint();
			tiles[i][j].setName("");
			tiles[i][j-1].removeAll();
			tiles[i][j-1].revalidate();
			tiles[i][j-1].repaint();
			tiles[i][j-1].add(wolfIcon);
			tiles[i][j-1].setName("red wolf");
			}
		}else if(a.equals("red dog")){
			if((i == 2 && (j == 0 || j == 8))||
				   (i == 3 && (j == 1 || j == 7))||
				   (i == 4 && (j == 0 || j == 8))){
					tiles[i][j].removeAll();
					tiles[i][j].revalidate();
					tiles[i][j].repaint();
					tiles[i][j].setName("trap");		
					tiles[i][j-1].removeAll();
					tiles[i][j-1].revalidate();
					tiles[i][j-1].repaint();
					tiles[i][j-1].add(dogIcon);
					tiles[i][j-1].setName("red dog");
					if (i==2 && j==0)
						tiles[i][j].add(trapIcon1);
					else if (i==2 && j==8)
						tiles[i][j].add(trapIcon2);
					else if (i==3 && j==1)
						tiles[i][j].add(trapIcon3);
					else if (i==3 && j==7)
						tiles[i][j].add(trapIcon4);
					else if (i==4 && j==0)
						tiles[i][j].add(trapIcon5);
					else if (i==4 && j==8)
						tiles[i][j].add(trapIcon6);		
			}
			else {
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i][j-1].removeAll();
				tiles[i][j-1].revalidate();
				tiles[i][j-1].repaint();
				tiles[i][j-1].add(dogIcon);
				tiles[i][j-1].setName("red dog");
			}
		}//BLUE
		else if(a.equals("blue elephant")){
			if((i == 2 && (j == 0 || j == 8))||
				   (i == 3 && (j == 1 || j == 7))||
				   (i == 4 && (j == 0 || j == 8))){
					tiles[i][j].removeAll();
					tiles[i][j].revalidate();
					tiles[i][j].repaint();
					tiles[i][j].setName("trap");		
					tiles[i][j-1].removeAll();
					tiles[i][j-1].revalidate();
					tiles[i][j-1].repaint();
					tiles[i][j-1].add(elephantIcon2);
					tiles[i][j-1].setName("blue elephant");
					if (i==2 && j==0)
						tiles[i][j].add(trapIcon1);
					else if (i==2 && j==8)
						tiles[i][j].add(trapIcon2);
					else if (i==3 && j==1)
						tiles[i][j].add(trapIcon3);
					else if (i==3 && j==7)
						tiles[i][j].add(trapIcon4);
					else if (i==4 && j==0)
						tiles[i][j].add(trapIcon5);
					else if (i==4 && j==8)
						tiles[i][j].add(trapIcon6);		
			}
			else {
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i][j-1].removeAll();
				tiles[i][j-1].revalidate();
				tiles[i][j-1].repaint();
				tiles[i][j-1].add(elephantIcon2);
				tiles[i][j-1].setName("blue elephant");
			}
		}else if(a.equals("blue lion")){
			if((i == 1 || i == 2 || i == 4 || i == 5) && 
			   (j == 6)){
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i][j-4].removeAll();
				tiles[i][j-4].revalidate();
				tiles[i][j-4].repaint();
				tiles[i][j-4].add(lionIcon2);
				tiles[i][j-4].setName("blue lion");
			} else if((i == 2 && (j == 0 || j == 8))||
				   (i == 3 && (j == 1 || j == 7))||
				   (i == 4 && (j == 0 || j == 8))){
					tiles[i][j].removeAll();
					tiles[i][j].revalidate();
					tiles[i][j].repaint();
					tiles[i][j].setName("trap");		
					tiles[i][j-1].removeAll();
					tiles[i][j-1].revalidate();
					tiles[i][j-1].repaint();
					tiles[i][j-1].add(lionIcon2);
					tiles[i][j-1].setName("blue lion");
					if (i==2 && j==0)
						tiles[i][j].add(trapIcon1);
					else if (i==2 && j==8)
						tiles[i][j].add(trapIcon2);
					else if (i==3 && j==1)
						tiles[i][j].add(trapIcon3);
					else if (i==3 && j==7)
						tiles[i][j].add(trapIcon4);
					else if (i==4 && j==0)
						tiles[i][j].add(trapIcon5);
					else if (i==4 && j==8)
						tiles[i][j].add(trapIcon6);		
			} else{
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i][j-1].removeAll();
				tiles[i][j-1].revalidate();
				tiles[i][j-1].repaint();
				tiles[i][j-1].add(lionIcon2);
				tiles[i][j-1].setName("blue lion");
			}
		}else if(a.equals("blue tiger")){
			if((i == 1 || i == 2 || i == 4 || i == 5) && 
			   (j == 6)){
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i][j-4].removeAll();
				tiles[i][j-4].revalidate();
				tiles[i][j-4].repaint();
				tiles[i][j-4].add(tigerIcon2);
				tiles[i][j-4].setName("blue tiger");
			} else if((i == 2 && (j == 0 || j == 8))||
				   (i == 3 && (j == 1 || j == 7))||
				   (i == 4 && (j == 0 || j == 8))){
					tiles[i][j].removeAll();
					tiles[i][j].revalidate();
					tiles[i][j].repaint();
					tiles[i][j].setName("trap");		
					tiles[i][j-1].removeAll();
					tiles[i][j-1].revalidate();
					tiles[i][j-1].repaint();
					tiles[i][j-1].add(tigerIcon2);
					tiles[i][j-1].setName("blue tiger");
					if (i==2 && j==0)
						tiles[i][j].add(trapIcon1);
					else if (i==2 && j==8)
						tiles[i][j].add(trapIcon2);
					else if (i==3 && j==1)
						tiles[i][j].add(trapIcon3);
					else if (i==3 && j==7)
						tiles[i][j].add(trapIcon4);
					else if (i==4 && j==0)
						tiles[i][j].add(trapIcon5);
					else if (i==4 && j==8)
						tiles[i][j].add(trapIcon6);		
			} else{
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i][j-1].removeAll();
				tiles[i][j-1].revalidate();
				tiles[i][j-1].repaint();
				tiles[i][j-1].add(tigerIcon2);
				tiles[i][j-1].setName("blue tiger");
			}
		}else if(a.equals("blue leopard")){
			if((i == 2 && (j == 0 || j == 8))||
				   (i == 3 && (j == 1 || j == 7))||
				   (i == 4 && (j == 0 || j == 8))){
					tiles[i][j].removeAll();
					tiles[i][j].revalidate();
					tiles[i][j].repaint();
					tiles[i][j].setName("trap");		
					tiles[i][j-1].removeAll();
					tiles[i][j-1].revalidate();
					tiles[i][j-1].repaint();
					tiles[i][j-1].add(leopardIcon2);
					tiles[i][j-1].setName("blue leopard");
					if (i==2 && j==0)
						tiles[i][j].add(trapIcon1);
					else if (i==2 && j==8)
						tiles[i][j].add(trapIcon2);
					else if (i==3 && j==1)
						tiles[i][j].add(trapIcon3);
					else if (i==3 && j==7)
						tiles[i][j].add(trapIcon4);
					else if (i==4 && j==0)
						tiles[i][j].add(trapIcon5);
					else if (i==4 && j==8)
						tiles[i][j].add(trapIcon6);		
			}
			else {
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i][j-1].removeAll();
				tiles[i][j-1].revalidate();
				tiles[i][j-1].repaint();
				tiles[i][j-1].add(leopardIcon2);
				tiles[i][j-1].setName("blue leopard");
			}
		}else if(a.equals("blue mouse")){
			//in river
			if((i == 1 && (j == 3 || j == 4 || j == 5))||
					(i == 2 && (j == 3 || j == 4 || j == 5))||
					(i == 4 && (j == 3 || j == 4 || j == 5))||
					(i == 5 && (j == 3 || j == 4 || j == 5))){
					tiles[i][j].removeAll();
					tiles[i][j].revalidate();
					tiles[i][j].repaint();
					tiles[i][j].setName("river");		
					tiles[i][j-1].removeAll();
					tiles[i][j-1].revalidate();
					tiles[i][j-1].repaint();
					tiles[i][j-1].add(mouseIcon2);
					tiles[i][j-1].setName("blue mouse");
					if (i==1 && j==3)
						tiles[i][j].add(riverIcon1);
					else if (i==1 && j==4)
						tiles[i][j].add(riverIcon2);
					else if (i==1 && j==5)
						tiles[i][j].add(riverIcon3);
					else if (i==2 && j==3)
						tiles[i][j].add(riverIcon4);
					else if (i==2 && j==4)
						tiles[i][j].add(riverIcon5);
					else if (i==2 && j==5)
						tiles[i][j].add(riverIcon6);
					else if (i==4 && j==3)
						tiles[i][j].add(riverIcon7);
					else if (i==4 && j==4)
						tiles[i][j].add(riverIcon8);
					else if (i==4 && j==5)
						tiles[i][j].add(riverIcon9);
					else if (i==5 && j==3)
						tiles[i][j].add(riverIcon10);
					else if (i==5 && j==4)
						tiles[i][j].add(riverIcon11);
					else if (i==5 && j==5)
						tiles[i][j].add(riverIcon12);
			}
			else if((i == 2 && (j == 0 || j == 8))||
				   (i == 3 && (j == 1 || j == 7))||
				   (i == 4 && (j == 0 || j == 8))){
					tiles[i][j].removeAll();
					tiles[i][j].revalidate();
					tiles[i][j].repaint();
					tiles[i][j].setName("trap");		
					tiles[i][j-1].removeAll();
					tiles[i][j-1].revalidate();
					tiles[i][j-1].repaint();
					tiles[i][j-1].add(mouseIcon2);
					tiles[i][j-1].setName("blue mouse");
					if (i==2 && j==0)
						tiles[i][j].add(trapIcon1);
					else if (i==2 && j==8)
						tiles[i][j].add(trapIcon2);
					else if (i==3 && j==1)
						tiles[i][j].add(trapIcon3);
					else if (i==3 && j==7)
						tiles[i][j].add(trapIcon4);
					else if (i==4 && j==0)
						tiles[i][j].add(trapIcon5);
					else if (i==4 && j==8)
						tiles[i][j].add(trapIcon6);		
			}
			else {
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i][j-1].removeAll();
				tiles[i][j-1].revalidate();
				tiles[i][j-1].repaint();
				tiles[i][j-1].add(mouseIcon2);
				tiles[i][j-1].setName("blue mouse");
			}
		}else if(a.equals("blue cat")){
			if((i == 2 && (j == 0 || j == 8))||
				   (i == 3 && (j == 1 || j == 7))||
				   (i == 4 && (j == 0 || j == 8))){
					tiles[i][j].removeAll();
					tiles[i][j].revalidate();
					tiles[i][j].repaint();
					tiles[i][j].setName("trap");		
					tiles[i][j-1].removeAll();
					tiles[i][j-1].revalidate();
					tiles[i][j-1].repaint();
					tiles[i][j-1].add(catIcon2);
					tiles[i][j-1].setName("blue cat");
					if (i==2 && j==0)
						tiles[i][j].add(trapIcon1);
					else if (i==2 && j==8)
						tiles[i][j].add(trapIcon2);
					else if (i==3 && j==1)
						tiles[i][j].add(trapIcon3);
					else if (i==3 && j==7)
						tiles[i][j].add(trapIcon4);
					else if (i==4 && j==0)
						tiles[i][j].add(trapIcon5);
					else if (i==4 && j==8)
						tiles[i][j].add(trapIcon6);		
			} else {
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i][j-1].removeAll();
				tiles[i][j-1].revalidate();
				tiles[i][j-1].repaint();
				tiles[i][j-1].add(catIcon2);
				tiles[i][j-1].setName("blue cat"); 
			}
		}else if(a.equals("blue wolf")){
			if((i == 2 && (j == 0 || j == 8))||
				   (i == 3 && (j == 1 || j == 7))||
				   (i == 4 && (j == 0 || j == 8))){
					tiles[i][j].removeAll();
					tiles[i][j].revalidate();
					tiles[i][j].repaint();
					tiles[i][j].setName("trap");		
					tiles[i][j-1].removeAll();
					tiles[i][j-1].revalidate();
					tiles[i][j-1].repaint();
					tiles[i][j-1].add(wolfIcon2);
					tiles[i][j-1].setName("blue wolf");
					if (i==2 && j==0)
						tiles[i][j].add(trapIcon1);
					else if (i==2 && j==8)
						tiles[i][j].add(trapIcon2);
					else if (i==3 && j==1)
						tiles[i][j].add(trapIcon3);
					else if (i==3 && j==7)
						tiles[i][j].add(trapIcon4);
					else if (i==4 && j==0)
						tiles[i][j].add(trapIcon5);
					else if (i==4 && j==8)
						tiles[i][j].add(trapIcon6);		
			} else {
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i][j-1].removeAll();
				tiles[i][j-1].revalidate();
				tiles[i][j-1].repaint();
				tiles[i][j-1].add(wolfIcon2);
				tiles[i][j-1].setName("blue wolf");
			}
		}else if(a.equals("blue dog")){
			if((i == 2 && (j == 0 || j == 8))||
				   (i == 3 && (j == 1 || j == 7))||
				   (i == 4 && (j == 0 || j == 8))){
					tiles[i][j].removeAll();
					tiles[i][j].revalidate();
					tiles[i][j].repaint();
					tiles[i][j].setName("trap");		
					tiles[i][j-1].removeAll();
					tiles[i][j-1].revalidate();
					tiles[i][j-1].repaint();
					tiles[i][j-1].add(dogIcon2);
					tiles[i][j-1].setName("blue dog");
					if (i==2 && j==0)
						tiles[i][j].add(trapIcon1);
					else if (i==2 && j==8)
						tiles[i][j].add(trapIcon2);
					else if (i==3 && j==1)
						tiles[i][j].add(trapIcon3);
					else if (i==3 && j==7)
						tiles[i][j].add(trapIcon4);
					else if (i==4 && j==0)
						tiles[i][j].add(trapIcon5);
					else if (i==4 && j==8)
						tiles[i][j].add(trapIcon6);		
			} else {
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i][j-1].removeAll();
				tiles[i][j-1].revalidate();
				tiles[i][j-1].repaint();
				tiles[i][j-1].add(dogIcon2);
				tiles[i][j-1].setName("blue dog");
			}
		}
		
	}
		
	public void moveD(int i, int j, String a){
		//red
		if(a.equals("red elephant")){
			if((i == 2 && (j == 0 || j == 8))||
				   (i == 3 && (j == 1 || j == 7))||
				   (i == 4 && (j == 0 || j == 8))){
					tiles[i][j].removeAll();
					tiles[i][j].revalidate();
					tiles[i][j].repaint();
					tiles[i][j].setName("trap");		
					tiles[i][j+1].removeAll();
					tiles[i][j+1].revalidate();
					tiles[i][j+1].repaint();
					tiles[i][j+1].add(elephantIcon);
					tiles[i][j+1].setName("red elephant");
					if (i==2 && j==0)
						tiles[i][j].add(trapIcon1);
					else if (i==2 && j==8)
						tiles[i][j].add(trapIcon2);
					else if (i==3 && j==1)
						tiles[i][j].add(trapIcon3);
					else if (i==3 && j==7)
						tiles[i][j].add(trapIcon4);
					else if (i==4 && j==0)
						tiles[i][j].add(trapIcon5);
					else if (i==4 && j==8)
						tiles[i][j].add(trapIcon6);		
			} else {
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i][j+1].removeAll();
				tiles[i][j+1].revalidate();
				tiles[i][j+1].repaint();
				tiles[i][j+1].add(elephantIcon);
				tiles[i][j+1].setName("red elephant");
			}
		}else if(a.equals("red lion")){
			if((i == 1 || i == 2 || i == 4 || i == 5) && 
			   (j == 2)){
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i][j+4].removeAll();
				tiles[i][j+4].revalidate();
				tiles[i][j+4].repaint();
				tiles[i][j+4].add(lionIcon);
				tiles[i][j+4].setName("red lion");
			} else if((i == 2 && (j == 0 || j == 8))||
				   (i == 3 && (j == 1 || j == 7))||
				   (i == 4 && (j == 0 || j == 8))){
					tiles[i][j].removeAll();
					tiles[i][j].revalidate();
					tiles[i][j].repaint();
					tiles[i][j].setName("trap");		
					tiles[i][j+1].removeAll();
					tiles[i][j+1].revalidate();
					tiles[i][j+1].repaint();
					tiles[i][j+1].add(lionIcon);
					tiles[i][j+1].setName("red lion");
					if (i==2 && j==0)
						tiles[i][j].add(trapIcon1);
					else if (i==2 && j==8)
						tiles[i][j].add(trapIcon2);
					else if (i==3 && j==1)
						tiles[i][j].add(trapIcon3);
					else if (i==3 && j==7)
						tiles[i][j].add(trapIcon4);
					else if (i==4 && j==0)
						tiles[i][j].add(trapIcon5);
					else if (i==4 && j==8)
						tiles[i][j].add(trapIcon6);		
			} else{
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i][j+1].removeAll();
				tiles[i][j+1].revalidate();
				tiles[i][j+1].repaint();
				tiles[i][j+1].add(lionIcon);
				tiles[i][j+1].setName("red lion");
			}
		}else if(a.equals("red tiger")){
			if((i == 1 || i == 2 || i == 4 || i == 5) && 
			   (j == 2)){
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i][j+4].removeAll();
				tiles[i][j+4].revalidate();
				tiles[i][j+4].repaint();
				tiles[i][j+4].add(tigerIcon);
				tiles[i][j+4].setName("red tiger");
			} else if((i == 2 && (j == 0 || j == 8))||
				   (i == 3 && (j == 1 || j == 7))||
				   (i == 4 && (j == 0 || j == 8))){
					tiles[i][j].removeAll();
					tiles[i][j].revalidate();
					tiles[i][j].repaint();
					tiles[i][j].setName("trap");		
					tiles[i][j+1].removeAll();
					tiles[i][j+1].revalidate();
					tiles[i][j+1].repaint();
					tiles[i][j+1].add(tigerIcon);
					tiles[i][j+1].setName("red tiger");
					if (i==2 && j==0)
						tiles[i][j].add(trapIcon1);
					else if (i==2 && j==8)
						tiles[i][j].add(trapIcon2);
					else if (i==3 && j==1)
						tiles[i][j].add(trapIcon3);
					else if (i==3 && j==7)
						tiles[i][j].add(trapIcon4);
					else if (i==4 && j==0)
						tiles[i][j].add(trapIcon5);
					else if (i==4 && j==8)
						tiles[i][j].add(trapIcon6);		
			} else{
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i][j+1].removeAll();
				tiles[i][j+1].revalidate();
				tiles[i][j+1].repaint();
				tiles[i][j+1].add(tigerIcon);
				tiles[i][j+1].setName("red tiger");
			}
		}else if(a.equals("red leopard")){
			if((i == 2 && (j == 0 || j == 8))||
				   (i == 3 && (j == 1 || j == 7))||
				   (i == 4 && (j == 0 || j == 8))){
					tiles[i][j].removeAll();
					tiles[i][j].revalidate();
					tiles[i][j].repaint();
					tiles[i][j].setName("trap");		
					tiles[i][j+1].removeAll();
					tiles[i][j+1].revalidate();
					tiles[i][j+1].repaint();
					tiles[i][j+1].add(leopardIcon);
					tiles[i][j+1].setName("red leopard");
					if (i==2 && j==0)
						tiles[i][j].add(trapIcon1);
					else if (i==2 && j==8)
						tiles[i][j].add(trapIcon2);
					else if (i==3 && j==1)
						tiles[i][j].add(trapIcon3);
					else if (i==3 && j==7)
						tiles[i][j].add(trapIcon4);
					else if (i==4 && j==0)
						tiles[i][j].add(trapIcon5);
					else if (i==4 && j==8)
						tiles[i][j].add(trapIcon6);		
			} else {
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i][j+1].removeAll();
				tiles[i][j+1].revalidate();
				tiles[i][j+1].repaint();
				tiles[i][j+1].add(leopardIcon);
				tiles[i][j+1].setName("red leopard");
			}
		}else if(a.equals("red mouse")){
			//in river
			if((i == 1 && (j == 3 || j == 4 || j == 5))||
					(i == 2 && (j == 3 || j == 4 || j == 5))||
					(i == 4 && (j == 3 || j == 4 || j == 5))||
					(i == 5 && (j == 3 || j == 4 || j == 5))){
					tiles[i][j].removeAll();
					tiles[i][j].revalidate();
					tiles[i][j].repaint();
					tiles[i][j].setName("river");		
					tiles[i][j+1].removeAll();
					tiles[i][j+1].revalidate();
					tiles[i][j+1].repaint();
					tiles[i][j+1].add(mouseIcon);
					tiles[i][j+1].setName("red mouse");
					if (i==1 && j==3)
						tiles[i][j].add(riverIcon1);
					else if (i==1 && j==4)
						tiles[i][j].add(riverIcon2);
					else if (i==1 && j==5)
						tiles[i][j].add(riverIcon3);
					else if (i==2 && j==3)
						tiles[i][j].add(riverIcon4);
					else if (i==2 && j==4)
						tiles[i][j].add(riverIcon5);
					else if (i==2 && j==5)
						tiles[i][j].add(riverIcon6);
					else if (i==4 && j==3)
						tiles[i][j].add(riverIcon7);
					else if (i==4 && j==4)
						tiles[i][j].add(riverIcon8);
					else if (i==4 && j==5)
						tiles[i][j].add(riverIcon9);
					else if (i==5 && j==3)
						tiles[i][j].add(riverIcon10);
					else if (i==5 && j==4)
						tiles[i][j].add(riverIcon11);
					else if (i==5 && j==5)
						tiles[i][j].add(riverIcon12);
			}
			else if((i == 2 && (j == 0 || j == 8))||
				   (i == 3 && (j == 1 || j == 7))||
				   (i == 4 && (j == 0 || j == 8))){
					tiles[i][j].removeAll();
					tiles[i][j].revalidate();
					tiles[i][j].repaint();
					tiles[i][j].setName("trap");		
					tiles[i][j+1].removeAll();
					tiles[i][j+1].revalidate();
					tiles[i][j+1].repaint();
					tiles[i][j+1].add(mouseIcon);
					tiles[i][j+1].setName("red mouse");
					if (i==2 && j==0)
						tiles[i][j].add(trapIcon1);
					else if (i==2 && j==8)
						tiles[i][j].add(trapIcon2);
					else if (i==3 && j==1)
						tiles[i][j].add(trapIcon3);
					else if (i==3 && j==7)
						tiles[i][j].add(trapIcon4);
					else if (i==4 && j==0)
						tiles[i][j].add(trapIcon5);
					else if (i==4 && j==8)
						tiles[i][j].add(trapIcon6);		
			}
			else {
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i][j+1].removeAll();
				tiles[i][j+1].revalidate();
				tiles[i][j+1].repaint();
				tiles[i][j+1].add(mouseIcon);
				tiles[i][j+1].setName("red mouse");
			}
		}else if(a.equals("red cat")){
			if((i == 2 && (j == 0 || j == 8))||
				   (i == 3 && (j == 1 || j == 7))||
				   (i == 4 && (j == 0 || j == 8))){
					tiles[i][j].removeAll();
					tiles[i][j].revalidate();
					tiles[i][j].repaint();
					tiles[i][j].setName("trap");		
					tiles[i][j+1].removeAll();
					tiles[i][j+1].revalidate();
					tiles[i][j+1].repaint();
					tiles[i][j+1].add(catIcon);
					tiles[i][j+1].setName("red cat");
					if (i==2 && j==0)
						tiles[i][j].add(trapIcon1);
					else if (i==2 && j==8)
						tiles[i][j].add(trapIcon2);
					else if (i==3 && j==1)
						tiles[i][j].add(trapIcon3);
					else if (i==3 && j==7)
						tiles[i][j].add(trapIcon4);
					else if (i==4 && j==0)
						tiles[i][j].add(trapIcon5);
					else if (i==4 && j==8)
						tiles[i][j].add(trapIcon6);		
			} else {
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i][j+1].removeAll();
				tiles[i][j+1].revalidate();
				tiles[i][j+1].repaint();
				tiles[i][j+1].add(catIcon);
				tiles[i][j+1].setName("red cat");
			}
		}else if(a.equals("red wolf")){
			if((i == 2 && (j == 0 || j == 8))||
				   (i == 3 && (j == 1 || j == 7))||
				   (i == 4 && (j == 0 || j == 8))){
					tiles[i][j].removeAll();
					tiles[i][j].revalidate();
					tiles[i][j].repaint();
					tiles[i][j].setName("trap");		
					tiles[i][j+1].removeAll();
					tiles[i][j+1].revalidate();
					tiles[i][j+1].repaint();
					tiles[i][j+1].add(wolfIcon);
					tiles[i][j+1].setName("red wolf");
					if (i==2 && j==0)
						tiles[i][j].add(trapIcon1);
					else if (i==2 && j==8)
						tiles[i][j].add(trapIcon2);
					else if (i==3 && j==1)
						tiles[i][j].add(trapIcon3);
					else if (i==3 && j==7)
						tiles[i][j].add(trapIcon4);
					else if (i==4 && j==0)
						tiles[i][j].add(trapIcon5);
					else if (i==4 && j==8)
						tiles[i][j].add(trapIcon6);		
			} else {
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i][j+1].removeAll();
				tiles[i][j+1].revalidate();
				tiles[i][j+1].repaint();
				tiles[i][j+1].add(wolfIcon);
				tiles[i][j+1].setName("red wolf");
			}
		}else if(a.equals("red dog")){
			if((i == 2 && (j == 0 || j == 8))||
				   (i == 3 && (j == 1 || j == 7))||
				   (i == 4 && (j == 0 || j == 8))){
					tiles[i][j].removeAll();
					tiles[i][j].revalidate();
					tiles[i][j].repaint();
					tiles[i][j].setName("trap");		
					tiles[i][j+1].removeAll();
					tiles[i][j+1].revalidate();
					tiles[i][j+1].repaint();
					tiles[i][j+1].add(dogIcon);
					tiles[i][j+1].setName("red dog");
					if (i==2 && j==0)
						tiles[i][j].add(trapIcon1);
					else if (i==2 && j==8)
						tiles[i][j].add(trapIcon2);
					else if (i==3 && j==1)
						tiles[i][j].add(trapIcon3);
					else if (i==3 && j==7)
						tiles[i][j].add(trapIcon4);
					else if (i==4 && j==0)
						tiles[i][j].add(trapIcon5);
					else if (i==4 && j==8)
						tiles[i][j].add(trapIcon6);		
			} else {
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i][j+1].removeAll();
				tiles[i][j+1].revalidate();
				tiles[i][j+1].repaint();
				tiles[i][j+1].add(dogIcon);
				tiles[i][j+1].setName("red dog");
			}
		}//BLUE
		else if(a.equals("blue elephant")){
			if((i == 2 && (j == 0 || j == 8))||
				   (i == 3 && (j == 1 || j == 7))||
				   (i == 4 && (j == 0 || j == 8))){
					tiles[i][j].removeAll();
					tiles[i][j].revalidate();
					tiles[i][j].repaint();
					tiles[i][j].setName("trap");		
					tiles[i][j+1].removeAll();
					tiles[i][j+1].revalidate();
					tiles[i][j+1].repaint();
					tiles[i][j+1].add(elephantIcon2);
					tiles[i][j+1].setName("blue elephant");
					if (i==2 && j==0)
						tiles[i][j].add(trapIcon1);
					else if (i==2 && j==8)
						tiles[i][j].add(trapIcon2);
					else if (i==3 && j==1)
						tiles[i][j].add(trapIcon3);
					else if (i==3 && j==7)
						tiles[i][j].add(trapIcon4);
					else if (i==4 && j==0)
						tiles[i][j].add(trapIcon5);
					else if (i==4 && j==8)
						tiles[i][j].add(trapIcon6);		
			} else {
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i][j+1].removeAll();
				tiles[i][j+1].revalidate();
				tiles[i][j+1].repaint();
				tiles[i][j+1].add(elephantIcon2);
				tiles[i][j+1].setName("blue elephant");
			}
		}else if(a.equals("blue lion")){
			if((i == 1 || i == 2 || i == 4 || i == 5) && 
			   (j == 2)){
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i][j+4].removeAll();
				tiles[i][j+4].revalidate();
				tiles[i][j+4].repaint();
				tiles[i][j+4].add(lionIcon2);
				tiles[i][j+4].setName("blue lion");
			} else if((i == 2 && (j == 0 || j == 8))||
				   (i == 3 && (j == 1 || j == 7))||
				   (i == 4 && (j == 0 || j == 8))){
					tiles[i][j].removeAll();
					tiles[i][j].revalidate();
					tiles[i][j].repaint();
					tiles[i][j].setName("trap");		
					tiles[i][j+1].removeAll();
					tiles[i][j+1].revalidate();
					tiles[i][j+1].repaint();
					tiles[i][j+1].add(lionIcon2);
					tiles[i][j+1].setName("blue lion");
					if (i==2 && j==0)
						tiles[i][j].add(trapIcon1);
					else if (i==2 && j==8)
						tiles[i][j].add(trapIcon2);
					else if (i==3 && j==1)
						tiles[i][j].add(trapIcon3);
					else if (i==3 && j==7)
						tiles[i][j].add(trapIcon4);
					else if (i==4 && j==0)
						tiles[i][j].add(trapIcon5);
					else if (i==4 && j==8)
						tiles[i][j].add(trapIcon6);		
			} else{
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i][j+1].removeAll();
				tiles[i][j+1].revalidate();
				tiles[i][j+1].repaint();
				tiles[i][j+1].add(lionIcon2);
				tiles[i][j+1].setName("blue lion");
			}
		}else if(a.equals("blue tiger")){
			if((i == 1 || i == 2 || i == 4 || i == 5) && 
			   (j == 2)){
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i][j+4].removeAll();
				tiles[i][j+4].revalidate();
				tiles[i][j+4].repaint();
				tiles[i][j+4].add(tigerIcon2);
				tiles[i][j+4].setName("blue tiger");
			} else if((i == 2 && (j == 0 || j == 8))||
				   (i == 3 && (j == 1 || j == 7))||
				   (i == 4 && (j == 0 || j == 8))){
					tiles[i][j].removeAll();
					tiles[i][j].revalidate();
					tiles[i][j].repaint();
					tiles[i][j].setName("trap");		
					tiles[i][j+1].removeAll();
					tiles[i][j+1].revalidate();
					tiles[i][j+1].repaint();
					tiles[i][j+1].add(tigerIcon2);
					tiles[i][j+1].setName("blue tiger");
					if (i==2 && j==0)
						tiles[i][j].add(trapIcon1);
					else if (i==2 && j==8)
						tiles[i][j].add(trapIcon2);
					else if (i==3 && j==1)
						tiles[i][j].add(trapIcon3);
					else if (i==3 && j==7)
						tiles[i][j].add(trapIcon4);
					else if (i==4 && j==0)
						tiles[i][j].add(trapIcon5);
					else if (i==4 && j==8)
						tiles[i][j].add(trapIcon6);		
			} else{
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i][j+1].removeAll();
				tiles[i][j+1].revalidate();
				tiles[i][j+1].repaint();
				tiles[i][j+1].add(tigerIcon2);
				tiles[i][j+1].setName("blue tiger");
			}
		}else if(a.equals("blue leopard")){
			if((i == 2 && (j == 0 || j == 8))||
				   (i == 3 && (j == 1 || j == 7))||
				   (i == 4 && (j == 0 || j == 8))){
					tiles[i][j].removeAll();
					tiles[i][j].revalidate();
					tiles[i][j].repaint();
					tiles[i][j].setName("trap");		
					tiles[i][j+1].removeAll();
					tiles[i][j+1].revalidate();
					tiles[i][j+1].repaint();
					tiles[i][j+1].add(lionIcon2);
					tiles[i][j+1].setName("blue lion");
					if (i==2 && j==0)
						tiles[i][j].add(trapIcon1);
					else if (i==2 && j==8)
						tiles[i][j].add(trapIcon2);
					else if (i==3 && j==1)
						tiles[i][j].add(trapIcon3);
					else if (i==3 && j==7)
						tiles[i][j].add(trapIcon4);
					else if (i==4 && j==0)
						tiles[i][j].add(trapIcon5);
					else if (i==4 && j==8)
						tiles[i][j].add(trapIcon6);		
			} else {
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i][j+1].removeAll();
				tiles[i][j+1].revalidate();
				tiles[i][j+1].repaint();
				tiles[i][j+1].add(leopardIcon2);
				tiles[i][j+1].setName("blue leopard");
			}
		}else if(a.equals("blue mouse")){
			//in river
			if((i == 1 && (j == 3 || j == 4 || j == 5))||
					(i == 2 && (j == 3 || j == 4 || j == 5))||
					(i == 4 && (j == 3 || j == 4 || j == 5))||
					(i == 5 && (j == 3 || j == 4 || j == 5))){
					tiles[i][j].removeAll();
					tiles[i][j].revalidate();
					tiles[i][j].repaint();
					tiles[i][j].setName("river");		
					tiles[i][j+1].removeAll();
					tiles[i][j+1].revalidate();
					tiles[i][j+1].repaint();
					tiles[i][j+1].add(mouseIcon2);
					tiles[i][j+1].setName("blue mouse");
					if (i==1 && j==3)
						tiles[i][j].add(riverIcon1);
					else if (i==1 && j==4)
						tiles[i][j].add(riverIcon2);
					else if (i==1 && j==5)
						tiles[i][j].add(riverIcon3);
					else if (i==2 && j==3)
						tiles[i][j].add(riverIcon4);
					else if (i==2 && j==4)
						tiles[i][j].add(riverIcon5);
					else if (i==2 && j==5)
						tiles[i][j].add(riverIcon6);
					else if (i==4 && j==3)
						tiles[i][j].add(riverIcon7);
					else if (i==4 && j==4)
						tiles[i][j].add(riverIcon8);
					else if (i==4 && j==5)
						tiles[i][j].add(riverIcon9);
					else if (i==5 && j==3)
						tiles[i][j].add(riverIcon10);
					else if (i==5 && j==4)
						tiles[i][j].add(riverIcon11);
					else if (i==5 && j==5)
						tiles[i][j].add(riverIcon12);
			} else if ((i == 2 && (j == 0 || j == 8))||
				   (i == 3 && (j == 1 || j == 7))||
				   (i == 4 && (j == 0 || j == 8))){
					tiles[i][j].removeAll();
					tiles[i][j].revalidate();
					tiles[i][j].repaint();
					tiles[i][j].setName("trap");		
					tiles[i][j+1].removeAll();
					tiles[i][j+1].revalidate();
					tiles[i][j+1].repaint();
					tiles[i][j+1].add(mouseIcon2);
					tiles[i][j+1].setName("blue mouse");
					if (i==2 && j==0)
						tiles[i][j].add(trapIcon1);
					else if (i==2 && j==8)
						tiles[i][j].add(trapIcon2);
					else if (i==3 && j==1)
						tiles[i][j].add(trapIcon3);
					else if (i==3 && j==7)
						tiles[i][j].add(trapIcon4);
					else if (i==4 && j==0)
						tiles[i][j].add(trapIcon5);
					else if (i==4 && j==8)
						tiles[i][j].add(trapIcon6);		
			}
			else {
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i][j+1].removeAll();
				tiles[i][j+1].revalidate();
				tiles[i][j+1].repaint();
				tiles[i][j+1].add(mouseIcon2);
				tiles[i][j+1].setName("blue mouse");
			}
		}else if(a.equals("blue cat")){
			if((i == 2 && (j == 0 || j == 8))||
				   (i == 3 && (j == 1 || j == 7))||
				   (i == 4 && (j == 0 || j == 8))){
					tiles[i][j].removeAll();
					tiles[i][j].revalidate();
					tiles[i][j].repaint();
					tiles[i][j].setName("trap");		
					tiles[i][j+1].removeAll();
					tiles[i][j+1].revalidate();
					tiles[i][j+1].repaint();
					tiles[i][j+1].add(catIcon2);
					tiles[i][j+1].setName("blue cat");
					if (i==2 && j==0)
						tiles[i][j].add(trapIcon1);
					else if (i==2 && j==8)
						tiles[i][j].add(trapIcon2);
					else if (i==3 && j==1)
						tiles[i][j].add(trapIcon3);
					else if (i==3 && j==7)
						tiles[i][j].add(trapIcon4);
					else if (i==4 && j==0)
						tiles[i][j].add(trapIcon5);
					else if (i==4 && j==8)
						tiles[i][j].add(trapIcon6);		
			} else {
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i][j+1].removeAll();
				tiles[i][j+1].revalidate();
				tiles[i][j+1].repaint();
				tiles[i][j+1].add(catIcon2);
				tiles[i][j+1].setName("blue cat");
			}
		}else if(a.equals("blue wolf")){
			if((i == 2 && (j == 0 || j == 8))||
				   (i == 3 && (j == 1 || j == 7))||
				   (i == 4 && (j == 0 || j == 8))){
					tiles[i][j].removeAll();
					tiles[i][j].revalidate();
					tiles[i][j].repaint();
					tiles[i][j].setName("trap");		
					tiles[i][j+1].removeAll();
					tiles[i][j+1].revalidate();
					tiles[i][j+1].repaint();
					tiles[i][j+1].add(wolfIcon2);
					tiles[i][j+1].setName("blue wolf");
					if (i==2 && j==0)
						tiles[i][j].add(trapIcon1);
					else if (i==2 && j==8)
						tiles[i][j].add(trapIcon2);
					else if (i==3 && j==1)
						tiles[i][j].add(trapIcon3);
					else if (i==3 && j==7)
						tiles[i][j].add(trapIcon4);
					else if (i==4 && j==0)
						tiles[i][j].add(trapIcon5);
					else if (i==4 && j==8)
						tiles[i][j].add(trapIcon6);		
			} else {
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i][j+1].removeAll();
				tiles[i][j+1].revalidate();
				tiles[i][j+1].repaint();
				tiles[i][j+1].add(wolfIcon2);
				tiles[i][j+1].setName("blue wolf");
			}
		}else if(a.equals("blue dog")){
			if((i == 2 && (j == 0 || j == 8))||
				   (i == 3 && (j == 1 || j == 7))||
				   (i == 4 && (j == 0 || j == 8))){
					tiles[i][j].removeAll();
					tiles[i][j].revalidate();
					tiles[i][j].repaint();
					tiles[i][j].setName("trap");		
					tiles[i][j+1].removeAll();
					tiles[i][j+1].revalidate();
					tiles[i][j+1].repaint();
					tiles[i][j+1].add(dogIcon2);
					tiles[i][j+1].setName("blue dog");
					if (i==2 && j==0)
						tiles[i][j].add(trapIcon1);
					else if (i==2 && j==8)
						tiles[i][j].add(trapIcon2);
					else if (i==3 && j==1)
						tiles[i][j].add(trapIcon3);
					else if (i==3 && j==7)
						tiles[i][j].add(trapIcon4);
					else if (i==4 && j==0)
						tiles[i][j].add(trapIcon5);
					else if (i==4 && j==8)
						tiles[i][j].add(trapIcon6);		
			} else {
				tiles[i][j].removeAll();
				tiles[i][j].revalidate();
				tiles[i][j].repaint();
				tiles[i][j].setName("");
				tiles[i][j+1].removeAll();
				tiles[i][j+1].revalidate();
				tiles[i][j+1].repaint();
				tiles[i][j+1].add(dogIcon2);
				tiles[i][j+1].setName("blue dog");
			}
		}
		
	}
	
	public boolean rIsValidMove(String a, char c){
		int i, j;
		boolean canJump = false;
		boolean canSwim = false;
		//tile loop
		
		
		String [] split;
		for(i = 0; i < 7; i++){
			for(j=0; j< 9; j++){
				//look for animal tile
				if(a.equals(tiles[i][j].getName())){				
					if(c == 'w' && i > 0){
						if(tiles[i-1][j].getName().equals("river")){
							if(tiles[i][j].getName().equals("red mouse")){
								return true;
							}else if(tiles[i][j].getName().equals("red tiger")){
								if(tiles[i-3][j].getName().equals("normal") || tiles[i-3][j].getName().equals("")){
									return true;
								}else if(tiles[i-3][j].getName().equals("blue elephant")){
									return false;
								}else if(tiles[i-3][j].getName().equals("blue lion")){
									return false;
								}else{
									return true;
								}
							}else if(tiles[i][j].getName().equals("red lion")){
								if(tiles[i-3][j].getName().equals("normal") || tiles[i-3][j].getName().equals("")){
									return true;
								}else if(tiles[i-3][j].getName().equals("blue elephant")){
									return false;
								}else{
									return true;
								}
							}else{
								return false;
							}
						}else if(tiles[i-1][j].getName().equals("normal")){
							return true;
						}else if(tiles[i-1][j].getName().equals("blue den")){
							blueDen = true;
							return true;
						}else if(tiles[i-1][j].getName().equals("trap")){
							return true;
						}//if it encounters anopponent
						else if(tiles[i-1][j].getName().equals("blue elephant")){
							if(tiles[i][j].getName().equals("red mouse")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red elephant")){
								bluePiece--;
								return true;
							}else if((i-1 == 2 || i-1 == 3 || i-1 == 4) && (j == 0 || j ==1)){
								bluePiece--;
								return true;
							}else{
								return false;
							}
						}else if(tiles[i-1][j].getName().equals("blue lion")){
							if(tiles[i][j].getName().equals("red elephant")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red lion")){
								bluePiece--;
								return true;
							}else if((i-1 == 2 || i-1 == 3 || i-1 == 4) && (j == 0 || j ==1)){
								bluePiece--;
								return true;
							}else{
								return false;
							}
						}else if(tiles[i-1][j].getName().equals("blue tiger")){
							if(tiles[i][j].getName().equals("red elephant")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red lion")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red tiger")){
								bluePiece--;
								return true;
							}else if((i-1 == 2 || i-1 == 3 || i-1 == 4) && (j == 0 || j ==1)){
								bluePiece--;
								return true;
							}else{
								return false;
							}
						}else if(tiles[i-1][j].getName().equals("blue leopard")){
							if(tiles[i][j].getName().equals("red elephant")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red lion")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red tiger")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red leopard")){
								bluePiece--;
								return true;
							}else if((i-1 == 2 || i-1 == 3 || i-1 == 4) && (j == 0 || j ==1)){
								bluePiece--;
								return true;
							}else{
								return false;
							}
						}else if(tiles[i-1][j].getName().equals("blue dog")){
							if(tiles[i][j].getName().equals("red elephant")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red lion")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red tiger")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red leopard")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red dog")){
								bluePiece--;
								return true;
							}else if((i-1 == 2 || i-1 == 3 || i-1 == 4) && (j == 0 || j ==1)){
								bluePiece--;
								return true;
							}else{
								return false;
							}
						}else if(tiles[i-1][j].getName().equals("blue wolf")){
							if(tiles[i][j].getName().equals("red elephant")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red lion")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red tiger")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red leopard")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red dog")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red wolf")){
								bluePiece--;
								return true;
							}else if((i-1 == 2 || i-1 == 3 || i-1 == 4) && (j == 0 || j ==1)){
								bluePiece--;
								return true;
							}else{
								return false;
							}
						}else if(tiles[i-1][j].getName().equals("blue cat")){
							if(tiles[i][j].getName().equals("red elephant")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red lion")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red tiger")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red leopard")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red dog")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red wolf")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red cat")){
								bluePiece--;
								return true;
							}else if((i-1 == 2 || i-1 == 3 || i-1 == 4) && (j == 0 || j ==1)){
								bluePiece--;
								return true;
							}else{
								return false;
							}
						}else if(tiles[i-1][j].getName().equals("blue mouse")){								
							if(tiles[i][j].getName().equals("red elephant")){
								return false;
							}else if(tiles[i][j].getName().equals("red lion")){
								if((i-1 == 1 || i-1 == 2 || i-1 == 4|| i-1 == 5)&&(j == 3|| j == 4 || j == 5)){
									return false;
								}else{
								bluePiece--;
									return true;
								}
							}else if(tiles[i][j].getName().equals("red tiger")){
								if((i-1 == 1 || i-1 == 2 || i-1 == 4|| i-1 == 5)&&(j == 3|| j == 4 || j == 5)){
									return false;
								}else{
								bluePiece--;
									return true;
								}
							}else if(tiles[i][j].getName().equals("red leopard")){
								if((i-1 == 1 || i-1 == 2 || i-1 == 4|| i-1 == 5)&&(j == 3|| j == 4 || j == 5)){
									return false;
								}else{
								bluePiece--;
									return true;
								}
							}else if(tiles[i][j].getName().equals("red dog")){
								if((i-1 == 1 || i-1 == 2 || i-1 == 4|| i-1 == 5)&&(j == 3|| j == 4 || j == 5)){
									return false;
								}else{
								bluePiece--;
									return true;
								}
							}else if(tiles[i][j].getName().equals("red wolf")){
								if((i-1 == 1 || i-1 == 2 || i-1 == 4|| i-1 == 5)&&(j == 3|| j == 4 || j == 5)){
									return false;
								}else{
								bluePiece--;
									return true;
								}
							}else if(tiles[i][j].getName().equals("red cat")){
								if((i-1 == 1 || i-1 == 2 || i-1 == 4|| i-1 == 5)&&(j == 3|| j == 4 || j == 5)){
									return false;
								}else{
								bluePiece--;
									return true;
								}
							}else if(tiles[i][j].getName().equals("red mouse")){
								return true;
							}else if((i-1 == 2 || i-1 == 3 || i-1 == 4) && (j == 0 || j ==1)){
								return true;
							}else{
								bluePiece--;
								return false;
							}
						}//if it encounter an ally
						else if(tiles[i-1][j].getName().equals("red elephant")){
							return false;
						}else if(tiles[i-1][j].getName().equals("red lion")){
							return false;
						}else if(tiles[i-1][j].getName().equals("red tiger")){
							return false;
						}else if(tiles[i-1][j].getName().equals("red leopard")){
							return false;
						}else if(tiles[i-1][j].getName().equals("red dog")){
							return false;
						}else if(tiles[i-1][j].getName().equals("red wolf")){
							return false;
						}else if(tiles[i-1][j].getName().equals("red cat")){
							return false;
						}else if(tiles[i-1][j].getName().equals("red mouse")){
							return false;
						}
					}//checks if inbounds
					else if(c == 'a' && j > 0){
						if(tiles[i][j-1].getName().equals("river")){
							if(tiles[i][j].getName().equals("red mouse")){
								return true;
							}else if(tiles[i][j].getName().equals("red tiger")){
								if(tiles[i][j-4].getName().equals("normal") || tiles[i][j-4].getName().equals("")){
									return true;
								}else if(tiles[i][j-4].getName().equals("blue elephant")){
									return false;
								}else if(tiles[i][j-4].getName().equals("blue lion")){
									return false;
								}else{
									return true;
								}
							}else if(tiles[i][j].getName().equals("red lion")){
								if(tiles[i][j-4].getName().equals("normal") || tiles[i][j-4].getName().equals("")){
									return true;
								}else if(tiles[i][j-4].getName().equals("blue elephant")){
									return false;
								}else{
									return true;
								}
							}else{
								return false;
							}
						}else if(tiles[i][j-1].getName().equals("normal")){
							return true;
						}else if(tiles[i][j-1].getName().equals("trap")){
							return true;
						}else if(tiles[i][j-1].getName().equals("blue elephant")){
							if(tiles[i][j].getName().equals("red mouse")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red elephant")){
								bluePiece--;
								return true;
							}else if((i == 2 || i == 3 || i == 4) && (j-1 == 0 || j-1 ==1)){
								bluePiece--;
								return true;
							}else{
								return false;
							}
						}else if(tiles[i][j-1].getName().equals("blue lion")){
							if(tiles[i][j].getName().equals("red elephant")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red lion")){
								bluePiece--;
								return true;
							}else if((i == 2 || i == 3 || i == 4) && (j-1 == 0 || j-1 ==1)){
								bluePiece--;
								return true;
							}else{
								return false;
							}
						}else if(tiles[i][j-1].getName().equals("blue tiger")){
							if(tiles[i][j].getName().equals("red elephant")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red lion")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red tiger")){
								bluePiece--;
								return true;
							}else if((i == 2 || i == 3 || i == 4) && (j-1 == 0 || j-1 ==1)){
								bluePiece--;
								return true;
							}else{
								return false;
							}
						}else if(tiles[i][j-1].getName().equals("blue leopard")){
							if(tiles[i][j].getName().equals("red elephant")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red lion")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red tiger")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red leopard")){
								bluePiece--;
								return true;
							}else if((i == 2 || i == 3 || i == 4) && (j-1 == 0 || j-1 ==1)){
								bluePiece--;
								return true;
							}else{
								return false;
							}
						}else if(tiles[i][j-1].getName().equals("blue dog")){
							if(tiles[i][j].getName().equals("red elephant")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red lion")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red tiger")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red leopard")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red dog")){
								bluePiece--;
								return true;
							}else if((i == 2 || i == 3 || i == 4) && (j-1 == 0 || j-1 ==1)){
								bluePiece--;
								return true;
							}else{
								return false;
							}
						}else if(tiles[i][j-1].getName().equals("blue wolf")){
							if(tiles[i][j].getName().equals("red elephant")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red lion")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red tiger")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red leopard")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red dog")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red wolf")){
								bluePiece--;
								return true;
							}else if((i == 2 || i == 3 || i == 4) && (j-1 == 0 || j-1 ==1)){
								bluePiece--;
								return true;
							}else{
								return false;
							}
						}else if(tiles[i][j-1].getName().equals("blue cat")){
							if(tiles[i][j].getName().equals("red elephant")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red lion")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red tiger")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red leopard")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red dog")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red wolf")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red cat")){
								bluePiece--;
								return true;
							}else if((i == 2 || i == 3 || i == 4) && (j-1 == 0 || j-1 ==1)){
								bluePiece--;
								return true;
							}else{
								return false;
							}
						}else if(tiles[i][j-1].getName().equals("blue mouse")){
							if(tiles[i][j].getName().equals("red elephant")){
								return false;
							}else if(tiles[i][j].getName().equals("red lion")){
								if((i == 1 || i == 2 || i == 4|| i == 5)&&(j-1 == 3|| j-1 == 4 || j-1 == 5)){
									return false;
								}else{
								bluePiece--;
									return true;
								}
							}else if(tiles[i][j].getName().equals("red tiger")){
								if((i == 1 || i == 2 || i == 4|| i == 5)&&(j-1 == 3|| j-1 == 4 || j-1 == 5)){
									return false;
								}else{
								bluePiece--;
									return true;
								}
							}else if(tiles[i][j].getName().equals("red leopard")){
								if((i == 1 || i == 2 || i == 4|| i == 5)&&(j-1 == 3|| j-1 == 4 || j-1 == 5)){
									return false;
								}else{
								bluePiece--;
									return true;
								}
							}else if(tiles[i][j].getName().equals("red dog")){
								if((i == 1 || i == 2 || i == 4|| i == 5)&&(j-1 == 3|| j-1 == 4 || j-1 == 5)){
									return false;
								}else{
								bluePiece--;
									return true;
								}
							}else if(tiles[i][j].getName().equals("red wolf")){
								if((i == 1 || i == 2 || i == 4|| i == 5)&&(j-1 == 3|| j-1 == 4 || j-1 == 5)){
									return false;
								}else{
								bluePiece--;
									return true;
								}
							}else if(tiles[i][j].getName().equals("red cat")){
								if((i == 1 || i == 2 || i == 4|| i == 5)&&(j-1 == 3|| j-1 == 4 || j-1 == 5)){
									return false;
								}else{
								bluePiece--;
									return true;
								}
							}else if(tiles[i][j].getName().equals("red mouse")){
								return true;
							}else if((i == 2 || i == 3 || i == 4) && (j-1 == 0 || j-1 ==1)){
								return true;
							}else{
								bluePiece--;
								return false;
							}
						}//if it encounter an ally
						else if(tiles[i][j-1].getName().equals("red elephant")){
							return false;
						}else if(tiles[i][j-1].getName().equals("red lion")){
							return false;
						}else if(tiles[i][j-1].getName().equals("red tiger")){
							return false;
						}else if(tiles[i][j-1].getName().equals("red leopard")){
							return false;
						}else if(tiles[i][j-1].getName().equals("red dog")){
							return false;
						}else if(tiles[i][j-1].getName().equals("red wolf")){
							return false;
						}else if(tiles[i][j-1].getName().equals("red cat")){
							return false;
						}else if(tiles[i][j-1].getName().equals("red mouse")){
							return false;
						}
					}//checks if inbounds
					else if(c == 's' && i < 7){
						if(tiles[i+1][j].getName().equals("river")){
							if(tiles[i][j].getName().equals("red mouse")){
								return true;
							}else if(tiles[i][j].getName().equals("red tiger")){
								if(tiles[i+3][j].getName().equals("normal") || tiles[i+3][j].getName().equals("")){
									return true;
								}else if(tiles[i+3][j].getName().equals("blue elephant")){
									return false;
								}else if(tiles[i+3][j].getName().equals("blue lion")){
									return false;
								}else{
									return true;
								}
							}else if(tiles[i][j].getName().equals("red lion")){
								if(tiles[i+3][j].getName().equals("normal") || tiles[i+3][j].getName().equals("")){
									return true;
								}else if(tiles[i+3][j].getName().equals("blue elephant")){
									return false;
								}else{
									return true;
								}
							}else{
								return false;
							}
						}else if(tiles[i+1][j].getName().equals("normal")){
							return true;
						}else if(tiles[i+1][j].getName().equals("blue den")){
							blueDen = true;
							return true;
						}else if(tiles[i+1][j].getName().equals("trap")){
							return true;
						}//if it encounters anopponent
						else if(tiles[i+1][j].getName().equals("blue elephant")){
							if(tiles[i][j].getName().equals("red mouse")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red elephant")){
								bluePiece--;
								return true;
							}else if((i+1 == 2 || i+1 == 3 || i+1 == 4) && (j == 0 || j ==1)){
								bluePiece--;
								return true;
							}else{
								return false;
							}
						}else if(tiles[i+1][j].getName().equals("blue lion")){
							if(tiles[i][j].getName().equals("red elephant")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red lion")){
								bluePiece--;
								return true;
							}else if((i+1 == 2 || i+1 == 3 || i+1 == 4) && (j == 0 || j ==1)){
								bluePiece--;
								return true;
							}else{
								return false;
							}
						}else if(tiles[i+1][j].getName().equals("blue tiger")){
							if(tiles[i][j].getName().equals("red elephant")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red lion")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red tiger")){
								bluePiece--;
								return true;
							}else if((i+1 == 2 || i+1 == 3 || i+1 == 4) && (j == 0 || j ==1)){
								bluePiece--;
								return true;
							}else{
								return false;
							}
						}else if(tiles[i+1][j].getName().equals("blue leopard")){
							if(tiles[i][j].getName().equals("red elephant")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red lion")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red tiger")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red leopard")){
								bluePiece--;
								return true;
							}else if((i+1 == 2 || i+1 == 3 || i+1 == 4) && (j == 0 || j ==1)){
								bluePiece--;
								return true;
							}else{
								return false;
							}
						}else if(tiles[i+1][j].getName().equals("blue dog")){
							if(tiles[i][j].getName().equals("red elephant")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red lion")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red tiger")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red leopard")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red dog")){
								bluePiece--;
								return true;
							}else if((i+1 == 2 || i+1 == 3 || i+1 == 4) && (j == 0 || j ==1)){
								bluePiece--;
								return true;
							}else{
								return false;
							}
						}else if(tiles[i+1][j].getName().equals("blue wolf")){
							if(tiles[i][j].getName().equals("red elephant")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red lion")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red tiger")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red leopard")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red dog")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red wolf")){
								bluePiece--;
								return true;
							}else if((i+1 == 2 || i+1 == 3 || i+1 == 4) && (j == 0 || j ==1)){
								bluePiece--;
								return true;
							}else{
								return false;
							}
						}else if(tiles[i+1][j].getName().equals("blue cat")){
							if(tiles[i][j].getName().equals("red elephant")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red lion")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red tiger")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red leopard")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red dog")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red wolf")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red cat")){
								bluePiece--;
								return true;
							}else if((i+1 == 2 || i+1 == 3 || i+1 == 4) && (j == 0 || j ==1)){
								bluePiece--;
								return true;
							}else{
								return false;
							}
						}else if(tiles[i+1][j].getName().equals("blue mouse")){
							if(tiles[i][j].getName().equals("red elephant")){
								return false;
							}else if(tiles[i][j].getName().equals("red lion")){
								if((i+1 == 1 || i+1 == 2 || i+1 == 4|| i+1 == 5)&&(j == 3|| j == 4 || j == 5)){
									return false;
								}else{
								bluePiece--;
									return true;
								}
							}else if(tiles[i][j].getName().equals("red tiger")){
								if((i+1 == 1 || i+1 == 2 || i+1 == 4|| i+1 == 5)&&(j == 3|| j == 4 || j == 5)){
									return false;
								}else{
								bluePiece--;
									return true;
								}
							}else if(tiles[i][j].getName().equals("red leopard")){
								if((i+1 == 1 || i+1 == 2 || i+1 == 4|| i+1 == 5)&&(j == 3|| j == 4 || j == 5)){
									return false;
								}else{
								bluePiece--;
									return true;
								}
							}else if(tiles[i][j].getName().equals("red dog")){
								if((i+1 == 1 || i+1 == 2 || i+1 == 4|| i+1 == 5)&&(j == 3|| j == 4 || j == 5)){
									return false;
								}else{
								bluePiece--;
									return true;
								}
							}else if(tiles[i][j].getName().equals("red wolf")){
								if((i+1 == 1 || i+1 == 2 || i+1 == 4|| i+1 == 5)&&(j == 3|| j == 4 || j == 5)){
									return false;
								}else{
								bluePiece--;
									return true;
								}
							}else if(tiles[i][j].getName().equals("red cat")){
								if((i+1 == 1 || i+1 == 2 || i+1 == 4|| i+1 == 5)&&(j == 3|| j == 4 || j == 5)){
									return false;
								}else{
								bluePiece--;
									return true;
								}
							}else if(tiles[i][j].getName().equals("red mouse")){
								return true;
							}else if((i+1 == 2 || i+1 == 3 || i+1 == 4) && (j == 0 || j ==1)){
								bluePiece--;
								return true;
							}else{
								return false;
							}
						}//if it encounter an ally
						else if(tiles[i+1][j].getName().equals("red elephant")){
							return false;
						}else if(tiles[i+1][j].getName().equals("red lion")){
							return false;
						}else if(tiles[i+1][j].getName().equals("red tiger")){
							return false;
						}else if(tiles[i+1][j].getName().equals("red leopard")){
							return false;
						}else if(tiles[i+1][j].getName().equals("red dog")){
							return false;
						}else if(tiles[i+1][j].getName().equals("red wolf")){
							return false;
						}else if(tiles[i+1][j].getName().equals("red cat")){
							return false;
						}else if(tiles[i+1][j].getName().equals("red mouse")){
							return false;
						}
					}//checks if inbounds
					else if(c == 'd' && j < 9){
						if(tiles[i][j+1].getName().equals("river")){
							if(tiles[i][j].getName().equals("red mouse")){
								return true;
							}else if(tiles[i][j].getName().equals("red tiger")){
								if(tiles[i][j+4].getName().equals("normal") || tiles[i][j+4].getName().equals("")){
									return true;
								}else if(tiles[i][j+4].getName().equals("blue elephant")){
									return false;
								}else if(tiles[i][j+4].getName().equals("blue lion")){
									return false;
								}else{
									return true;
								}
							}else if(tiles[i][j].getName().equals("red lion")){
								if(tiles[i][j+4].getName().equals("normal") || tiles[i][j+4].getName().equals("")){
									return true;
								}else if(tiles[i][j+4].getName().equals("blue elephant")){
									return false;
								}else{
									return true;
								}
							}else{
								return false;
							}
						}else if(tiles[i][j+1].getName().equals("normal")){
							return true;
						}else if(tiles[i][j+1].getName().equals("blue den")){
							blueDen = true;
							return true;
						}else if(tiles[i][j+1].getName().equals("trap")){
							return true;
						}else if(tiles[i][j+1].getName().equals("blue elephant")){
							if(tiles[i][j].getName().equals("red mouse")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red elephant")){
								bluePiece--;
								return true;
							}else if((i == 2 || i == 3 || i == 4) && (j+1 == 0 || j+1 ==1)){
								bluePiece--;
								return true;
							}else{
								return false;
							}
						}else if(tiles[i][j+1].getName().equals("blue lion")){
							if(tiles[i][j].getName().equals("red elephant")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red lion")){
								bluePiece--;
								return true;
							}else if((i == 2 || i == 3 || i == 4) && (j+1 == 0 || j+1 ==1)){
								bluePiece--;
								return true;
							}else{
								return false;
							}
						}else if(tiles[i][j+1].getName().equals("blue tiger")){
							if(tiles[i][j].getName().equals("red elephant")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red lion")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red tiger")){
								bluePiece--;
								return true;
							}else if((i == 2 || i == 3 || i == 4) && (j+1 == 0 || j+1 ==1)){
								bluePiece--;
								return true;
							}else{
								return false;
							}
						}else if(tiles[i][j+1].getName().equals("blue leopard")){
							if(tiles[i][j].getName().equals("red elephant")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red lion")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red tiger")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red leopard")){
								bluePiece--;
								return true;
							}else if((i == 2 || i == 3 || i == 4) && (j+1 == 0 || j+1 ==1)){
								bluePiece--;
								return true;
							}else{
								return false;
							}
						}else if(tiles[i][j+1].getName().equals("blue dog")){
							if(tiles[i][j].getName().equals("red elephant")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red lion")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red tiger")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red leopard")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red dog")){
								bluePiece--;
								return true;
							}else if((i == 2 || i == 3 || i == 4) && (j+1 == 0 || j+1 ==1)){
								bluePiece--;
								return true;
							}else{
								return false;
							}
						}else if(tiles[i][j+1].getName().equals("blue wolf")){
							if(tiles[i][j].getName().equals("red elephant")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red lion")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red tiger")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red leopard")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red dog")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red wolf")){
								bluePiece--;
								return true;
							}else if((i == 2 || i == 3 || i == 4) && (j+1 == 0 || j+1 ==1)){
								bluePiece--;
								return true;
							}else{
								return false;
							}
						}else if(tiles[i][j+1].getName().equals("blue cat")){
							if(tiles[i][j].getName().equals("red elephant")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red lion")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red tiger")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red leopard")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red dog")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red wolf")){
								bluePiece--;
								return true;
							}else if(tiles[i][j].getName().equals("red cat")){
								bluePiece--;
								return true;
							}else if((i == 2 || i == 3 || i == 4) && (j+1 == 0 || j+1 ==1)){
								bluePiece--;
								return true;
							}else{
								return false;
							}
						}else if(tiles[i][j+1].getName().equals("blue mouse")){
							if(tiles[i][j].getName().equals("red elephant")){
								return false;
							}else if(tiles[i][j].getName().equals("red lion")){
								if((i == 1 || i == 2 || i == 4|| i == 5)&&(j+1 == 3|| j+1 == 4 || j+1 == 5)){
									return false;
								}else{
									bluePiece--;
									return true;
								}
							}else if(tiles[i][j].getName().equals("red tiger")){
								if((i == 1 || i == 2 || i == 4|| i == 5)&&(j+1 == 3|| j+1 == 4 || j+1 == 5)){
									return false;
								}else{
									bluePiece--;
									return true;
								}
							}else if(tiles[i][j].getName().equals("red leopard")){
								if((i == 1 || i == 2 || i == 4|| i == 5)&&(j+1 == 3|| j+1 == 4 || j+1 == 5)){
									return false;
								}else{
									bluePiece--;
									return true;
								}
							}else if(tiles[i][j].getName().equals("red dog")){
								if((i == 1 || i == 2 || i == 4|| i == 5)&&(j+1 == 3|| j+1 == 4 || j+1 == 5)){
									return false;
								}else{
									bluePiece--;
									return true;
								}
							}else if(tiles[i][j].getName().equals("red wolf")){
								if((i == 1 || i == 2 || i == 4|| i == 5)&&(j+1 == 3|| j+1 == 4 || j+1 == 5)){
									return false;
								}else{
									bluePiece--;
									return true;
								}
							}else if(tiles[i][j].getName().equals("red cat")){
								if((i == 1 || i == 2 || i == 4|| i == 5)&&(j+1 == 3|| j+1 == 4 || j+1 == 5)){
									return false;
								}else{
									bluePiece--;
									return true;
								}
							}else if(tiles[i][j].getName().equals("red mouse")){
								bluePiece--;
								return true;
							}else if((i == 2 || i == 3 || i == 4) && (j+1 == 0 || j+1 ==1)){
								bluePiece--;
								return true;
							}else{
								return false;
							}
						}//if it encounter an ally
						else if(tiles[i][j+1].getName().equals("red elephant")){
							return false;
						}else if(tiles[i][j+1].getName().equals("red lion")){
							return false;
						}else if(tiles[i][j+1].getName().equals("red tiger")){
							return false;
						}else if(tiles[i][j+1].getName().equals("red leopard")){
							return false;
						}else if(tiles[i][j+1].getName().equals("red dog")){
							return false;
						}else if(tiles[i][j+1].getName().equals("red wolf")){
							return false;
						}else if(tiles[i][j+1].getName().equals("red cat")){
							return false;
						}else if(tiles[i][j+1].getName().equals("red mouse")){
							return false;
						}
					}else if(i == 0 && c == 'w'){
						return false;
					}else if(i == 6 && c == 's'){
						return false;
					}else if(j == 8 && c == 'd'){
						return false;
					}else if(j == 0 && c == 'a'){
						return false;
					}					
				}
			}
		}
		return true;
	}
	
	public boolean bIsValidMove(String a, char c){
		int i, j;
		boolean canJump = false;
		boolean canSwim = false;
		//tile loop
		
		
		String [] split;
		for(i = 0; i < 7; i++){
			for(j=0; j< 9; j++){
				//look for animal tile
				if(a.equals(tiles[i][j].getName())){				
					if(c == 'w' && i > 0){
						if(tiles[i-1][j].getName().equals("river")){
							if(tiles[i][j].getName().equals("blue mouse")){
								return true;
							}else if(tiles[i][j].getName().equals("blue tiger")){
								if(tiles[i-3][j].getName().equals("normal") || tiles[i-3][j].getName().equals("")){
									return true;
								}else if(tiles[i-3][j].getName().equals("red elephant")){
									return false;
								}else if(tiles[i-3][j].getName().equals("red lion")){
									return false;
								}else{
									return true;
								}
							}else if(tiles[i][j].getName().equals("blue lion")){
								if(tiles[i-3][j].getName().equals("normal") || tiles[i-3][j].getName().equals("")){
									return true;
								}else if(tiles[i-3][j].getName().equals("red elephant")){
									return false;
								}else{
									return true;
								}
							}else{
								return false;
							}
						}else if(tiles[i-1][j].getName().equals("normal")){
							return true;
						}else if(tiles[i-1][j].getName().equals("red den")){
							redDen = true;
							return true;
						}else if(tiles[i-1][j].getName().equals("trap")){
							return true;
						}//if it encounters anopponent
						else if(tiles[i-1][j].getName().equals("red elephant")){
							if(tiles[i][j].getName().equals("blue mouse")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue elephant")){
								redPiece--;
								return true;
							}else if((i-1 == 2 || i-1 == 3 || i-1 == 4) && (j == 7 || j == 8)){
								redPiece--;
								return true;
							}else{
								return false;
							}
						}else if(tiles[i-1][j].getName().equals("red lion")){
							if(tiles[i][j].getName().equals("blue elephant")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue lion")){
								redPiece--;
								return true;
							}else if((i-1 == 2 || i-1 == 3 || i-1 == 4) && (j == 7 || j == 8)){
								redPiece--;
								return true;
							}else{
								return false;
							}
						}else if(tiles[i-1][j].getName().equals("red tiger")){
							if(tiles[i][j].getName().equals("blue elephant")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue lion")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue tiger")){
								redPiece--;
								return true;
							}else if((i-1 == 2 || i-1 == 3 || i-1 == 4) && (j == 7 || j == 8)){
								redPiece--;
								return true;
							}else{
								return false;
							}
						}else if(tiles[i-1][j].getName().equals("red leopard")){
							if(tiles[i][j].getName().equals("blue elephant")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue lion")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue tiger")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue leopard")){
								redPiece--;
								return true;
							}else if((i-1 == 2 || i-1 == 3 || i-1 == 4) && (j == 7 || j == 8)){
								redPiece--;
								return true;
							}else{
								return false;
							}
						}else if(tiles[i-1][j].getName().equals("red dog")){
							if(tiles[i][j].getName().equals("blue elephant")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue lion")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue tiger")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue leopard")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue dog")){
								redPiece--;
								return true;
							}else if((i-1 == 2 || i-1 == 3 || i-1 == 4) && (j == 7 || j == 8)){
								redPiece--;
								return true;
							}else{
								return false;
							}
						}else if(tiles[i-1][j].getName().equals("red wolf")){
							if(tiles[i][j].getName().equals("blue elephant")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue lion")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue tiger")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue leopard")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue dog")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue wolf")){
								redPiece--;
								return true;
							}else if((i-1 == 2 || i-1 == 3 || i-1 == 4) && (j == 7 || j == 8)){
								redPiece--;
								return true;
							}else{
								return false;
							}
						}else if(tiles[i-1][j].getName().equals("red cat")){
							if(tiles[i][j].getName().equals("blue elephant")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue lion")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue tiger")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue leopard")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue dog")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue wolf")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue cat")){
								redPiece--;
								return true;
							}else if((i-1 == 2 || i-1 == 3 || i-1 == 4) && (j == 7 || j == 8)){
								redPiece--;
								return true;
							}else{
								return false;
							}
						}else if(tiles[i-1][j].getName().equals("red mouse")){
							if(tiles[i][j].getName().equals("blue elephant")){
								return false;
							}else if(tiles[i][j].getName().equals("blue lion")){
								if((i-1 == 1 || i-1 == 2 || i-1 == 4|| i-1 == 5)&&(j == 3|| j == 4 || j == 5)){
									return false;
								}else{
								redPiece--;
									return true;
								}
							}else if(tiles[i][j].getName().equals("blue tiger")){
								if((i-1 == 1 || i-1 == 2 || i-1 == 4|| i-1 == 5)&&(j == 3|| j == 4 || j == 5)){
									return false;
								}else{
								redPiece--;
									return true;
								}
							}else if(tiles[i][j].getName().equals("blue leopard")){
								if((i-1 == 1 || i-1 == 2 || i-1 == 4|| i-1 == 5)&&(j == 3|| j == 4 || j == 5)){
									return false;
								}else{
									return true;
								}
							}else if(tiles[i][j].getName().equals("blue dog")){
								if((i-1 == 1 || i-1 == 2 || i-1 == 4|| i-1 == 5)&&(j == 3|| j == 4 || j == 5)){
									return false;
								}else{
								redPiece--;
									return true;
								}
							}else if(tiles[i][j].getName().equals("blue wolf")){
								if((i-1 == 1 || i-1 == 2 || i-1 == 4|| i-1 == 5)&&(j == 3|| j == 4 || j == 5)){
									return false;
								}else{
								redPiece--;
									return true;
								}
							}else if(tiles[i][j].getName().equals("blue cat")){
								if((i-1 == 1 || i-1 == 2 || i-1 == 4|| i-1 == 5)&&(j == 3|| j == 4 || j == 5)){
									return false;
								}else{
								redPiece--;
									return true;
								}
							}else if(tiles[i][j].getName().equals("blue mouse")){
								redPiece--;
								return true;
							}else if((i-1 == 2 || i-1 == 3 || i-1 == 4) && (j == 7 || j == 8)){
								redPiece--;
								return true;
							}else{
								return false;
							}
						}//if it encounter an ally
						else if(tiles[i-1][j].getName().equals("blue elephant")){
							return false;
						}else if(tiles[i-1][j].getName().equals("blue lion")){
							return false;
						}else if(tiles[i-1][j].getName().equals("blue tiger")){
							return false;
						}else if(tiles[i-1][j].getName().equals("blue leopard")){
							return false;
						}else if(tiles[i-1][j].getName().equals("blue dog")){
							return false;
						}else if(tiles[i-1][j].getName().equals("blue wolf")){
							return false;
						}else if(tiles[i-1][j].getName().equals("blue cat")){
							return false;
						}else if(tiles[i-1][j].getName().equals("blue mouse")){
							return false;
						}
					}//checks if inbounds
					else if(c == 'a' && j > 0){
						if(tiles[i][j-1].getName().equals("river")){
							if(tiles[i][j].getName().equals("blue mouse")){
								return true;
							}else if(tiles[i][j].getName().equals("blue tiger")){
								if(tiles[i][j-4].getName().equals("normal") || tiles[i][j-4].getName().equals("")){
									return true;
								}else if(tiles[i][j-4].getName().equals("red elephant")){
									return false;
								}else if(tiles[i][j-4].getName().equals("red lion")){
									return false;
								}else{
									return true;
								}
							}else if(tiles[i][j].getName().equals("blue lion")){
								if(tiles[i][j-4].getName().equals("normal") || tiles[i][j-4].getName().equals("")){
									return true;
								}else if(tiles[i][j-4].getName().equals("red elephant")){
									return false;
								}else{
									return true;
								}
							}else{
								return false;
							}
						}else if(tiles[i][j-1].getName().equals("normal")){
							return true;
						}else if(tiles[i][j-1].getName().equals("red den")){
							redDen = true;
							return true;
						}else if(tiles[i][j-1].getName().equals("trap")){
							return true;
						}//if it encounters anopponent
						else if(tiles[i][j-1].getName().equals("red elephant")){
							if(tiles[i][j].getName().equals("blue mouse")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue elephant")){
								redPiece--;
								return true;
							}else if((i == 2 || i == 3 || i == 4) && (j-1 == 7 || j-1 == 8)){
								redPiece--;
								return true;
							}else{
								return false;
							}
						}else if(tiles[i][j-1].getName().equals("red lion")){
							if(tiles[i][j].getName().equals("blue elephant")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue lion")){
								redPiece--;
								return true;
							}else if((i == 2 || i == 3 || i == 4) && (j-1 == 7 || j-1 == 8)){
								redPiece--;
								return true;
							}else{
								return false;
							}
						}else if(tiles[i][j-1].getName().equals("red tiger")){
							if(tiles[i][j].getName().equals("blue elephant")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue lion")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue tiger")){
								redPiece--;
								return true;
							}else if((i == 2 || i == 3 || i == 4) && (j-1 == 7 || j-1 == 8)){
								redPiece--;
								return true;
							}else{
								return false;
							}
						}else if(tiles[i][j-1].getName().equals("red leopard")){
							if(tiles[i][j].getName().equals("blue elephant")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue lion")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue tiger")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue leopard")){
								redPiece--;
								return true;
							}else if((i == 2 || i == 3 || i == 4) && (j-1 == 7 || j-1 == 8)){
								redPiece--;
								return true;
							}else{
								return false;
							}
						}else if(tiles[i][j-1].getName().equals("red dog")){
							if(tiles[i][j].getName().equals("blue elephant")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue lion")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue tiger")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue leopard")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue dog")){
								redPiece--;
								return true;
							}else if((i == 2 || i == 3 || i == 4) && (j-1 == 7 || j-1 == 8)){
								redPiece--;
								return true;
							}else{
								return false;
							}
						}else if(tiles[i][j-1].getName().equals("red wolf")){
							if(tiles[i][j].getName().equals("blue elephant")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue lion")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue tiger")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue leopard")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue dog")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue wolf")){
								redPiece--;
								return true;
							}else if((i == 2 || i == 3 || i == 4) && (j-1 == 7 || j-1 == 8)){
								redPiece--;
								return true;
							}else{
								return false;
							}
						}else if(tiles[i][j-1].getName().equals("red cat")){
							if(tiles[i][j].getName().equals("blue elephant")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue lion")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue tiger")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue leopard")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue dog")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue wolf")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue cat")){
								redPiece--;
								return true;
							}else if((i == 2 || i == 3 || i == 4) && (j-1 == 7 || j-1 == 8)){
								redPiece--;
								return true;
							}else{
								return false;
							}
						}else if(tiles[i][j-1].getName().equals("red mouse")){
							if(tiles[i][j].getName().equals("blue elephant")){
								return false;
							}else if(tiles[i][j].getName().equals("blue lion")){
								if((i == 1 || i == 2 || i == 4|| i == 5)&&(j-1 == 3|| j-1 == 4 || j-1 == 5)){
									return false;
								}else{
								redPiece--;
									return true;
								}
							}else if(tiles[i][j].getName().equals("blue tiger")){
								if((i == 1 || i == 2 || i == 4|| i == 5)&&(j-1 == 3|| j-1 == 4 || j-1 == 5)){
									return false;
								}else{
								redPiece--;
									return true;
								}
							}else if(tiles[i][j].getName().equals("blue leopard")){
								if((i == 1 || i == 2 || i == 4|| i == 5)&&(j-1 == 3|| j-1 == 4 || j-1 == 5)){
									return false;
								}else{
									return true;
								}
							}else if(tiles[i][j].getName().equals("blue dog")){
								if((i == 1 || i == 2 || i == 4|| i == 5)&&(j-1 == 3|| j-1 == 4 || j-1 == 5)){
									return false;
								}else{
								redPiece--;
									return true;
								}
							}else if(tiles[i][j].getName().equals("blue wolf")){
								if((i == 1 || i == 2 || i == 4|| i == 5)&&(j-1 == 3|| j-1 == 4 || j-1 == 5)){
									return false;
								}else{
								redPiece--;
									return true;
								}
							}else if(tiles[i][j].getName().equals("blue cat")){
								if((i == 1 || i == 2 || i == 4|| i == 5)&&(j-1 == 3|| j-1 == 4 || j-1 == 5)){
									return false;
								}else{
								redPiece--;
									return true;
								}
							}else if(tiles[i][j].getName().equals("blue mouse")){
								redPiece--;
								return true;
							}else if((i == 2 || i == 3 || i == 4) && (j-1 == 7 || j-1 == 8)){
								redPiece--;
								return true;
							}else{
								return false;
							}
						}//if it encounter an ally
						else if(tiles[i][j-1].getName().equals("blue elephant")){
							return false;
						}else if(tiles[i][j-1].getName().equals("blue lion")){
							return false;
						}else if(tiles[i][j-1].getName().equals("blue tiger")){
							return false;
						}else if(tiles[i][j-1].getName().equals("blue leopard")){
							return false;
						}else if(tiles[i][j-1].getName().equals("blue dog")){
							return false;
						}else if(tiles[i][j-1].getName().equals("blue wolf")){
							return false;
						}else if(tiles[i][j-1].getName().equals("blue cat")){
							return false;
						}else if(tiles[i][j-1].getName().equals("blue mouse")){
							return false;
						}
					}//checks if inbounds
					else if(c == 's' && i < 7){
						if(tiles[i+1][j].getName().equals("river")){
							if(tiles[i][j].getName().equals("blue mouse")){
								return true;
							}else if(tiles[i][j].getName().equals("blue tiger")){
								if(tiles[i+3][j].getName().equals("normal") || tiles[i+3][j].getName().equals("")){
									return true;
								}else if(tiles[i+3][j].getName().equals("red elephant")){
									return false;
								}else if(tiles[i+3][j].getName().equals("red lion")){
									return false;
								}else{
									return true;
								}
							}else if(tiles[i][j].getName().equals("blue lion")){
								if(tiles[i+3][j].getName().equals("normal") || tiles[i+3][j].getName().equals("")){
									return true;
								}else if(tiles[i+3][j].getName().equals("red elephant")){
									return false;
								}else{
									return true;
								}
							}else{
								return false;
							}
						}else if(tiles[i+1][j].getName().equals("normal")){
							return true;
						}else if(tiles[i+1][j].getName().equals("red den")){
							redDen = true;
							return true;
						}else if(tiles[i+1][j].getName().equals("trap")){
							return true;
						}//if it encounters anopponent
						else if(tiles[i+1][j].getName().equals("red elephant")){
							if(tiles[i][j].getName().equals("blue mouse")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue elephant")){
								redPiece--;
								return true;
							}else if((i+1 == 2 || i+1 == 3 || i+1 == 4) && (j == 7 || j == 8)){
								redPiece--;
								return true;
							}else{
								return false;
							}
						}else if(tiles[i+1][j].getName().equals("red lion")){
							if(tiles[i][j].getName().equals("blue elephant")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue lion")){
								redPiece--;
								return true;
							}else if((i+1 == 2 || i+1 == 3 || i+1 == 4) && (j == 7 || j == 8)){
								redPiece--;
								return true;
							}else{
								return false;
							}
						}else if(tiles[i+1][j].getName().equals("red tiger")){
							if(tiles[i][j].getName().equals("blue elephant")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue lion")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue tiger")){
								redPiece--;
								return true;
							}else if((i+1 == 2 || i+1 == 3 || i+1 == 4) && (j == 7 || j == 8)){
								redPiece--;
								return true;
							}else{
								return false;
							}
						}else if(tiles[i+1][j].getName().equals("red leopard")){
							if(tiles[i][j].getName().equals("blue elephant")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue lion")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue tiger")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue leopard")){
								redPiece--;
								return true;
							}else if((i+1 == 2 || i+1 == 3 || i+1 == 4) && (j == 7 || j == 8)){
								redPiece--;
								return true;
							}else{
								return false;
							}
						}else if(tiles[i+1][j].getName().equals("red dog")){
							if(tiles[i][j].getName().equals("blue elephant")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue lion")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue tiger")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue leopard")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue dog")){
								redPiece--;
								return true;
							}else if((i+1 == 2 || i+1 == 3 || i+1 == 4) && (j == 7 || j == 8)){
								redPiece--;
								return true;
							}else{
								return false;
							}
						}else if(tiles[i+1][j].getName().equals("red wolf")){
							if(tiles[i][j].getName().equals("blue elephant")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue lion")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue tiger")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue leopard")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue dog")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue wolf")){
								redPiece--;
								return true;
							}else if((i+1 == 2 || i+1 == 3 || i+1 == 4) && (j == 7 || j == 8)){
								redPiece--;
								return true;
							}else{
								return false;
							}
						}else if(tiles[i+1][j].getName().equals("red cat")){
							if(tiles[i][j].getName().equals("blue elephant")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue lion")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue tiger")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue leopard")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue dog")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue wolf")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue cat")){
								redPiece--;
								return true;
							}else if((i+1 == 2 || i+1 == 3 || i+1 == 4) && (j == 7 || j == 8)){
								redPiece--;
								return true;
							}else{
								return false;
							}
						}else if(tiles[i+1][j].getName().equals("red mouse")){
							if(tiles[i][j].getName().equals("blue elephant")){
								return false;
							}else if(tiles[i][j].getName().equals("blue lion")){
								if((i+1 == 1 || i+1 == 2 || i+1 == 4|| i+1 == 5)&&(j == 3|| j == 4 || j == 5)){
									return false;
								}else{
								redPiece--;
									return true;
								}
							}else if(tiles[i][j].getName().equals("blue tiger")){
								if((i+1 == 1 || i+1 == 2 || i+1 == 4|| i+1 == 5)&&(j == 3|| j == 4 || j == 5)){
									return false;
								}else{
								redPiece--;
									return true;
								}
							}else if(tiles[i][j].getName().equals("blue leopard")){
								if((i+1 == 1 || i+1 == 2 || i+1 == 4|| i+1 == 5)&&(j == 3|| j == 4 || j == 5)){
									return false;
								}else{
								redPiece--;
									return true;
								}
							}else if(tiles[i][j].getName().equals("blue dog")){
								if((i+1 == 1 || i+1 == 2 || i+1 == 4|| i+1 == 5)&&(j == 3|| j == 4 || j == 5)){
									return false;
								}else{
								redPiece--;
									return true;
								}
							}else if(tiles[i][j].getName().equals("blue wolf")){
								if((i+1 == 1 || i+1 == 2 || i+1 == 4|| i+1 == 5)&&(j == 3|| j == 4 || j == 5)){
									return false;
								}else{
								redPiece--;
									return true;
								}
							}else if(tiles[i][j].getName().equals("blue cat")){
								if((i+1 == 1 || i+1 == 2 || i+1 == 4|| i+1 == 5)&&(j == 3|| j == 4 || j == 5)){
									return false;
								}else{
								redPiece--;
									return true;
								}
							}else if(tiles[i][j].getName().equals("blue mouse")){
								redPiece--;
								return true;
							}else if((i+1 == 2 || i+1 == 3 || i+1 == 4) && (j == 7 || j == 8)){
								redPiece--;
								return true;
							}else{
								return false;
							}
						}//if it encounter an ally
						else if(tiles[i+1][j].getName().equals("blue elephant")){
							return false;
						}else if(tiles[i+1][j].getName().equals("blue lion")){
							return false;
						}else if(tiles[i+1][j].getName().equals("blue tiger")){
							return false;
						}else if(tiles[i+1][j].getName().equals("blue leopard")){
							return false;
						}else if(tiles[i+1][j].getName().equals("blue dog")){
							return false;
						}else if(tiles[i+1][j].getName().equals("blue wolf")){
							return false;
						}else if(tiles[i+1][j].getName().equals("blue cat")){
							return false;
						}else if(tiles[i+1][j].getName().equals("blue mouse")){
							return false;
						}
					}//checks if inbounds
					else if(c == 'd' && j < 9){
						if(tiles[i][j+1].getName().equals("river")){
							if(tiles[i][j].getName().equals("blue mouse")){
								return true;
							}else if(tiles[i][j].getName().equals("blue tiger")){
								if(tiles[i][j+4].getName().equals("normal") || tiles[i][j+4].getName().equals("")){
									return true;
								}else if(tiles[i][j+4].getName().equals("red elephant")){
									return false;
								}else if(tiles[i][j+4].getName().equals("red lion")){
									return false;
								}else{
									return true;
								}
							}else if(tiles[i][j].getName().equals("blue lion")){
								if(tiles[i][j+4].getName().equals("normal") || tiles[i][j+4].getName().equals("")){
									return true;
								}else if(tiles[i][j+4].getName().equals("red elephant")){
									return false;
								}else{
									return true;
								}
							}else{
								return false;
							}
						}else if(tiles[i][j+1].getName().equals("normal")){
							return true;
						}else if(tiles[i][j+1].getName().equals("trap")){
							return true;
						}//if it encounters anopponent
						else if(tiles[i][j+1].getName().equals("red elephant")){
							if(tiles[i][j].getName().equals("blue mouse")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue elephant")){
								redPiece--;
								return true;
							}else if((i == 2 || i == 3 || i == 4) && (j+1 == 7 || j+1 == 8)){
								redPiece--;
								return true;
							}else{
								return false;
							}
						}else if(tiles[i][j+1].getName().equals("red lion")){
							if(tiles[i][j].getName().equals("blue elephant")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue lion")){
								redPiece--;
								return true;
							}else if((i == 2 || i == 3 || i == 4) && (j+1 == 7 || j+1 == 8)){
								redPiece--;
								return true;
							}else{
								return false;
							}
						}else if(tiles[i][j+1].getName().equals("red tiger")){
							if(tiles[i][j].getName().equals("blue elephant")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue lion")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue tiger")){
								redPiece--;
								return true;
							}else if((i == 2 || i == 3 || i == 4) && (j+1 == 7 || j+1 == 8)){
								redPiece--;
								return true;
							}else{
								return false;
							}
						}else if(tiles[i][j+1].getName().equals("red leopard")){
							if(tiles[i][j].getName().equals("blue elephant")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue lion")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue tiger")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue leopard")){
								redPiece--;
								return true;
							}else if((i == 2 || i == 3 || i == 4) && (j+1 == 7 || j+1 == 8)){
								redPiece--;
								return true;
							}else{
								return false;
							}
						}else if(tiles[i][j+1].getName().equals("red dog")){
							if(tiles[i][j].getName().equals("blue elephant")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue lion")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue tiger")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue leopard")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue dog")){
								redPiece--;
								return true;
							}else if((i == 2 || i == 3 || i == 4) && (j+1 == 7 || j+1 == 8)){
								redPiece--;
								return true;
							}else{
								return false;
							}
						}else if(tiles[i][j+1].getName().equals("red wolf")){
							if(tiles[i][j].getName().equals("blue elephant")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue lion")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue tiger")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue leopard")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue dog")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue wolf")){
								redPiece--;
								return true;
							}else if((i == 2 || i == 3 || i == 4) && (j+1 == 7 || j+1 == 8)){
								redPiece--;
								return true;
							}else{
								return false;
							}
						}else if(tiles[i][j+1].getName().equals("red cat")){
							if(tiles[i][j].getName().equals("blue elephant")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue lion")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue tiger")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue leopard")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue dog")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue wolf")){
								redPiece--;
								return true;
							}else if(tiles[i][j].getName().equals("blue cat")){
								redPiece--;
								return true;
							}else if((i == 2 || i == 3 || i == 4) && (j+1 == 7 || j+1 == 8)){
								redPiece--;
								return true;
							}else{
								return false;
							}
						}else if(tiles[i][j+1].getName().equals("red mouse")){
							if(tiles[i][j].getName().equals("blue elephant")){
								return false;
							}else if(tiles[i][j].getName().equals("blue lion")){
								if((i == 1 || i == 2 || i == 4|| i == 5)&&(j+1 == 3|| j+1 == 4 || j+1 == 5)){
									return false;
								}else{
								redPiece--;
									return true;
								}
							}else if(tiles[i][j].getName().equals("blue tiger")){
								if((i == 1 || i == 2 || i == 4|| i == 5)&&(j+1 == 3|| j+1 == 4 || j+1 == 5)){
									return false;
								}else{
								redPiece--;
									return true;
								}
							}else if(tiles[i][j].getName().equals("blue leopard")){
								if((i == 1 || i == 2 || i == 4|| i == 5)&&(j+1 == 3|| j+1 == 4 || j+1 == 5)){
									return false;
								}else{
								redPiece--;
									return true;
								}
							}else if(tiles[i][j].getName().equals("blue dog")){
								if((i == 1 || i == 2 || i == 4|| i == 5)&&(j+1 == 3|| j+1 == 4 || j+1 == 5)){
									return false;
								}else{
								redPiece--;
									return true;
								}
							}else if(tiles[i][j].getName().equals("blue wolf")){
								if((i == 1 || i == 2 || i == 4|| i == 5)&&(j+1 == 3|| j+1 == 4 || j+1 == 5)){
									return false;
								}else{
								redPiece--;
									return true;
								}
							}else if(tiles[i][j].getName().equals("blue cat")){
								if((i == 1 || i == 2 || i == 4|| i == 5)&&(j+1 == 3|| j+1 == 4 || j+1 == 5)){
									return false;
								}else{
								redPiece--;
									return true;
								}
							}else if(tiles[i][j].getName().equals("blue mouse")){
								redPiece--;
								return true;
							}else if((i == 2 || i == 3 || i == 4) && (j+1 == 7 || j+1 == 8)){
								redPiece--;
								return true;
							}else{
								return false;
							}
						}//if it encounter an ally
						else if(tiles[i][j+1].getName().equals("blue elephant")){
							return false;
						}else if(tiles[i][j+1].getName().equals("blue lion")){
							return false;
						}else if(tiles[i][j+1].getName().equals("blue tiger")){
							return false;
						}else if(tiles[i][j+1].getName().equals("blue leopard")){
							return false;
						}else if(tiles[i][j+1].getName().equals("blue dog")){
							return false;
						}else if(tiles[i][j+1].getName().equals("blue wolf")){
							return false;
						}else if(tiles[i][j+1].getName().equals("blue cat")){
							return false;
						}else if(tiles[i][j+1].getName().equals("blue mouse")){
							return false;
						}
					}else if(i == 0 && c == 'w'){
						return false;
					}else if(i == 6 && c == 's'){
						return false;
					}else if(j == 8 && c == 'd'){
						return false;
					}else if(j == 0 && c == 'a'){
						return false;
					}			
				}
			}
		}
		return true;
	}

	public int getRedPiece(){
		return redPiece;
	}
	
	public int getBluePiece(){
		return bluePiece;
	}

	public boolean getRedDen(){
		return redDen;
	}

	public boolean getBlueDen(){
		return blueDen;
	}
}
