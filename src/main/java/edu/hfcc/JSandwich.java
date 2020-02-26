/*
 * Design application for the Sub Shop.  Using a Combo to hold three sub choices
 * Chicken, Veggie or Roast Beef.
 * Using RadioButton allow user to select either White, Wheat or Rye.
 * Using CheckBox allow using to select following ingredients
 * (Mayo, Lettuce, Tomato, and Cheese)
 * Have a button with text Create Sandwich
 * 
 * After clicking Create Sandwich display 
 * the type of sub, bread and ingredients
 * 
 * The example below show customer selecting
 * Chicken, Rye, Mayo, Cheese and Tomato
 * 
 * The frame should look something like this
 * 
 * 			Welcome to the Sub Shop
 * 
 * Select sub type:  combobox
 * Select bread type:  White   Wheat    Rye
 * Select any ingredients:  Mayo  Lettuce  Tomato Cheese
 * 
 *                 Create Sub
 *                 
 * Thank you for create a Chicken sub on Rye               
 * With Mayo, Cheese and Tomato
 */

package edu.hfcc;


import edu.hfcc.JSandwichFrame;

public class JSandwich {

	
	public static void main (String[] args) {
		
	
        JSandwichFrame combo = new JSandwichFrame("Lauren's Sub Shop");
        
        combo.setVisible(true);
        
	}


}
	
	

