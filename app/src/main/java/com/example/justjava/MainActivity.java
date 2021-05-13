/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match the package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.justjava;



import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    /**
     *Declare Global Variables Here
     */
    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the Increment/Plus button is clicked.
     */
    public void increment(View view) {
        quantity++;
        display(quantity);
    }

    /**
     * This method is called when the Decrement/Minus button is clicked.
     */
    public void decrement(View view) {
        if(quantity>0) {
            quantity--;
            display(quantity);
        }
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
       //Get text from the EditText XML
        EditText nameField = (EditText) findViewById(R.id.user_input_name_view);
        String name = nameField.getText().toString();
        Log.v("MainActivity", "Name:"+ name);


        //Figure out if user wants whipped cream
        CheckBox whippedCreamCheckBox = (CheckBox)findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        Log.v("MainActivity", "Has whipped cream:" + hasWhippedCream);

      //Figure out if user wants chocolate topping
        CheckBox chocolateCheckBox = (CheckBox)findViewById(R.id.chocolate);
        boolean hasChocolate = chocolateCheckBox.isChecked();
        Log.v("MainActivity", "Add Chocolate Topping: " + hasChocolate);



        int price = calculatePrice();
        String priceMessage = createOrderSummary(price,hasWhippedCream, hasChocolate, name);
        displayMessage(priceMessage);



    //Display the order summary on the string



    }



    int calculatePrice(){
        int price = quantity * 5;
        return price;

    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }



    /***
     * Create a summary of our order
     * @param price
     * @return priceMessage
     * @param hasWhippedCream is whether or not the user wants Whipped Cream Topping
     * @param name of the customer
     */


    private String createOrderSummary(int price, boolean hasWhippedCream, boolean addChocolate, String name) {
        String priceMessage ="\nName: "+ name;
        priceMessage += "\nThank you for ordering " + quantity + " Coffees!";  //I used the escape key \n to put info on a new line
        priceMessage += "\nAdd Whipped Cream? " + hasWhippedCream;
        priceMessage += "\nAdd Chocolate Topping" + addChocolate;
        priceMessage += "\nAmount Due: $" + price;
        priceMessage += "\n\nYour order will be right up!"; //Double \n escape key for w line separation
        return priceMessage;


    }









}
