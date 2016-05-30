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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinner[] = new Spinner[9];
    private MediaPlayer media[] = new MediaPlayer[11];
    Button buttons[] = new Button[9];
    ArrayAdapter<CharSequence> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        createButtons();
        addItemsOnSpinners();
        createMedia();

        //link item in spinner menu to sound for corresponding button
        /*for(int i = 0; i < 9; i++) {
            spinner[i].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    //media[position];
                }

                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }*/
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


    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
        MediaPlayer temp = media[position];
        //selection.setText(items[position]);
    }

    public void onNothingSelected(AdapterView<?> parent) {
        //selection.setText("");
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
    public void createButtons(){
        //create buttons
        buttons[0]  = (Button) findViewById(R.id.button);
        buttons[1] = (Button) findViewById(R.id.button2);
        buttons[2] = (Button) findViewById(R.id.button3);
        buttons[3]  = (Button) findViewById(R.id.button4);
        buttons[4]  = (Button) findViewById(R.id.button5);
        buttons[5]  = (Button) findViewById(R.id.button6);
        buttons[6]  = (Button) findViewById(R.id.button7);
        buttons[7]  = (Button) findViewById(R.id.button8);
        buttons[8]  = (Button) findViewById(R.id.button9);
    }
    public void createMedia(){
        //media player
        MediaPlayer elephant = MediaPlayer.create(this, R.raw.elephant);
        MediaPlayer kitten = MediaPlayer.create(this, R.raw.kitten);
        MediaPlayer rooster = MediaPlayer.create(this, R.raw.rooster);
        MediaPlayer angryCat = MediaPlayer.create(this, R.raw.angrycat);
        MediaPlayer angryDog = MediaPlayer.create(this, R.raw.angrydog);
        MediaPlayer cow = MediaPlayer.create(this, R.raw.cow);
        MediaPlayer frog = MediaPlayer.create(this, R.raw.frog);
        MediaPlayer parakeet = MediaPlayer.create(this, R.raw.parakeet);
        MediaPlayer pig = MediaPlayer.create(this, R.raw.pig);
        MediaPlayer raccoon = MediaPlayer.create(this, R.raw.raccoon);
        MediaPlayer trex = MediaPlayer.create(this, R.raw.trex);

        //put sounds into one array
        media[0] = angryCat;
        media[1] = angryDog;
        media[2] = cow;
        media[3] = elephant;
        media[4] = frog;
        media[5] = kitten;
        media[6] = parakeet;
        media[7] = pig;
        media[8] = raccoon;
        media[9] = rooster;
        media[10] = trex;
    }
}
