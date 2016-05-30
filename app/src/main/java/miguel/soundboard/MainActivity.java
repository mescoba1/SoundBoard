package miguel.soundboard;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner[] = new Spinner[9];
    ArrayAdapter<CharSequence> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //create buttons
        Button b1 = (Button) findViewById(R.id.button);
        Button b2 = (Button) findViewById(R.id.button2);
        Button b3 = (Button) findViewById(R.id.button3);
        Button b4 = (Button) findViewById(R.id.button4);
        Button b5 = (Button) findViewById(R.id.button5);
        Button b6 = (Button) findViewById(R.id.button6);
        Button b7 = (Button) findViewById(R.id.button7);
        Button b8 = (Button) findViewById(R.id.button8);
        Button b9 = (Button) findViewById(R.id.button9);

        addItemsOnSpinners();

        //media player
        MediaPlayer elephant = MediaPlayer.create(this, R.raw.elephant);
        MediaPlayer kitten = MediaPlayer.create(this, R.raw.kitten);
        MediaPlayer rooster = MediaPlayer.create(this, R.raw.rooster);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void addItemsOnSpinners(){

        spinner[0] = (Spinner) findViewById(R.id.spinner);
        spinner[1] = (Spinner) findViewById(R.id.spinner2);
        spinner[2] = (Spinner) findViewById(R.id.spinner3);
        spinner[3] = (Spinner) findViewById(R.id.spinner4);
        spinner[4] = (Spinner) findViewById(R.id.spinner5);
        spinner[5] = (Spinner) findViewById(R.id.spinner6);
        spinner[6] = (Spinner) findViewById(R.id.spinner7);
        spinner[7] = (Spinner) findViewById(R.id.spinner8);
        spinner[8] = (Spinner) findViewById(R.id.spinner9);

        //spinner menu
        List list = new ArrayList();
        list.add("Angry Cat");
        list.add("Angry Dog");
        list.add("Cow");
        list.add("Elephant");
        list.add("Frog");
        list.add("Kitten");
        list.add("Parakeet");
        list.add("Pig");
        list.add("Raccoon");
        list.add("Rooster");
        list.add("T-Rex");

        ArrayAdapter dataAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //link menu to spinner
        for(int i = 0; i < 9; i++){
            spinner[i].setAdapter(dataAdapter);
        }
    }
}
