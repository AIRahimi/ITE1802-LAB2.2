package no.airahimi.mycalculator;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import org.matheclipse.parser.client.eval.DoubleEvaluator;

public class MainActivity extends AppCompatActivity {

    EditText display;
    DoubleEvaluator engine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        display = findViewById(R.id.tvDisplay);
        engine = new DoubleEvaluator();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.items, menu);
        return true;
    }

    public void buttonClick(View view) {
        switch (view.getId()) {
            //numbers
            case R.id.buttonZero:
                if (!display.getText().toString().equals("0"))
                    display.getText().append("0");
                break;
            case R.id.buttonOne:
                if (display.getText().toString().equals("0"))
                    display.setText("1");
                else
                    display.getText().append("1");
                break;
            case R.id.buttonTwo:
                if (display.getText().toString().equals("0"))
                    display.setText("2");
                else
                display.getText().append("2");
                break;
            case R.id.buttonThree:
                if (display.getText().toString().equals("0"))
                    display.setText("3");
                else
                display.getText().append("3");
                break;
            case R.id.buttonFour:
                if (display.getText().toString().equals("0"))
                    display.setText("4");
                else
                display.getText().append("4");
                break;
            case R.id.buttonFive:
                if (display.getText().toString().equals("0"))
                    display.setText("5");
                else
                display.getText().append("5");
                break;
            case R.id.buttonSix:
                if (display.getText().toString().equals("0"))
                    display.setText("6");
                else
                display.getText().append("6");
                break;
            case R.id.buttonSeven:
                if (display.getText().toString().equals("0"))
                    display.setText("7");
                else
                display.getText().append("7");
                break;
            case R.id.buttonEight:
                if (display.getText().toString().equals("0"))
                    display.setText("8");
                else
                display.getText().append("8");
                break;
            case R.id.buttonNine:
                if (display.getText().toString().equals("0"))
                    display.setText("9");
                else
                display.getText().append("9");
                break;
            //Math
            case R.id.buttonAddition:
                if (Character.isDigit(display.getText().charAt(display.length()-1)) )
                    display.getText().append("+");
                else
                    display.getText().replace(display.length() - 1, display.length(), "+");
                break;
            case R.id.buttonSubtract:
                if (Character.isDigit(display.getText().charAt(display.length()-1)) )
                    display.getText().append("-");
                else
                    display.getText().replace(display.length() - 1, display.length(), "-");
                break;
            case R.id.buttonDivide:
                if (Character.isDigit(display.getText().charAt(display.length()-1)) )
                    display.getText().append("/");
                else
                    display.getText().replace(display.length() - 1, display.length(), "/");
                break;
            case R.id.buttonMultiplicate:
                if (Character.isDigit(display.getText().charAt(display.length()-1)))
                    display.getText().append("*");
                else
                    display.getText().replace(display.length() - 1, display.length(), "*");
                break;
            case R.id.buttonSum:
                if (!Character.isDigit(display.getText().charAt(display.length()-1)))
                    display.getText().replace(display.length() - 1, display.length(), "");

                double sum = engine.evaluate(display.getText().toString());
                if ((sum % 1 == 0)) {
                    display.setText(Integer.toString((int) sum));
                } else {
                    display.setText(Double.toString(sum));
                }
                break;
            //Helpers
            case R.id.buttonClear:
                display.setText("0");
                break;
            case R.id.buttonHelp:
                AlertDialog alertDialog = alert("Help", "You clicked help");
                alertDialog.show();
                break;
            case R.id.buttonQuit:
                this.finish();
                break;

        }
    }

    public AlertDialog alert(String alert, String info) {
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle(alert);
        alertDialog.setMessage(info);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        return alertDialog;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        AlertDialog alertDialog;
        switch (item.getItemId()) {
            case R.id.action_advanced:
                alertDialog = alert("Advanced", "You clicked advanced");
                alertDialog.show();
                return true;
            case R.id.action_unit:
                alertDialog = alert("Unit", "You clicked unit");
                alertDialog.show();
                return true;
            case R.id.action_normal:
                alertDialog = alert("Normal", "You clicked normal");
                alertDialog.show();
                return true;
            case R.id.action_help:
                alertDialog = alert("Help", "You clicked help");
                alertDialog.show();
                return true;
            case R.id.action_quit:
                this.finish();
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
}
