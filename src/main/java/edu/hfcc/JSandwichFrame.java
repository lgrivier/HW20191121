package edu.hfcc;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Enumeration;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import edu.hfcc.b.ReadItemsFromFile;
import edu.hfcc.b.WriteItemsToFile;


public class JSandwichFrame extends JFrame implements ItemListener,ActionListener{

	private ReadItemsFromFile readItemsFromFile;
	
	ButtonGroup bGroup = new ButtonGroup();
	private JComboBox<String> subType;
	
	private JButton createSub = new JButton("Create Sub");
	private JLabel output = new JLabel();

	final JPanel toppingsPanel = new JPanel();
	final JPanel breadPanel = new JPanel();
	
	
	
	public JSandwichFrame(String title) {
		
		super(title);
		setSize(500,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		readItemsFromFile = new ReadItemsFromFile();

		
		add(createLabelWithFont("Welcome to Lauren's Sub Shop          ", "Arial", Font.BOLD, 16));
		add(new JLabel("                                        Enter sub type:"));
		add(createJComboBox());
		subType.addItemListener(this);
		
		add(new JLabel("                       Enter bread type:"));
		createButtonGroup();
		
		add(new JLabel("                          Enter toppings:"));
		createJCheckBox();
		add(toppingsPanel);
		
		add(createSub);
		add(output);
		createSub.addActionListener(this);
		
	}
	
	private JComboBox<String> createJComboBox() {
		List<String> items = this.readItemsFromFile.createList("comboSubType.txt");
		subType = new JComboBox<>();
		
		for(String item : items) {
			subType.addItem(item);
		}
		
		return subType;
	}
	
	private void createButtonGroup() {
		List<String> items = this.readItemsFromFile.createList("radioBreadType.txt");
		
		for(String item: items) {
			JRadioButton line = new JRadioButton(item,false);
			add(line);
			bGroup.add(line);
		}
		
	}
	
	private void createJCheckBox() {
		
		List<String> items = this.readItemsFromFile.createList("checkToppings.txt");
		
		
		for(String item : items) {
			
			toppingsPanel.add(new JCheckBox(item));
			
		}
		
	}
	
	private static JLabel createLabelWithFont(String labelText, String font, int style, int size) {
		JLabel label = new JLabel(labelText);
		label.setFont(new Font(font, style, size));
		return label;
	}
	

	
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		

		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String subChoice = getSubChoice();
		String breadType = null;
		String finalToppings = "";
		
		
		if(e.getSource()==createSub)  
	     {  
	        Enumeration<AbstractButton> allRadioButton=bGroup.getElements();  
	        while(allRadioButton.hasMoreElements())  
	        {  
	           JRadioButton temp=(JRadioButton)allRadioButton.nextElement();  
	           if(temp.isSelected())  
	           {  
	            breadType = temp.getText();  
	           }  
	        }     
	        
	     }
		
		Component[] component = toppingsPanel.getComponents();
		for (Component c : component) {
	          JCheckBox cb = (JCheckBox) c;
	          if (cb.isSelected())
	            finalToppings = finalToppings  +cb.getText() + " ";
	        }
		
		output.setText("Thank you for creating a " + subChoice + " sub on "+ breadType + " with "  + finalToppings);
		
		StringBuilder subOutput = new StringBuilder();
		subOutput.append("Thank you for creating a ");
		subOutput.append(subChoice);
		subOutput.append(" sub on ");
		subOutput.append(breadType);
		subOutput.append(" with ");
		subOutput.append(finalToppings);
		
		WriteItemsToFile writeItemsToFile = new WriteItemsToFile();
		writeItemsToFile.WriteToFile(subOutput.toString());
		
		
	}



	private String getSubChoice() {
		String subChoice = null;
		if(subType.getSelectedIndex()==0) {
			subChoice = "Chicken";
		}
		else if (subType.getSelectedIndex()==1) {
			subChoice = "Roast Beef";
		}
		else if(subType.getSelectedIndex()==2) {
			subChoice = "Veggie";
		}
		else if(subType.getSelectedIndex()==3) {
			subChoice = "Ham";
		}
		return subChoice;
	}

}
