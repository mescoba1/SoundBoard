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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinner[] = new Spinner[9];
    private MediaPlayer media[] = new MediaPlayer[11];
    private List list = new ArrayList();
    Button buttons[] = new Button[9];
   /* Button play= (Button) findViewById(R.id.button_play);
    Button stop= (Button) findViewById(R.id.button_stop);*/
    //Button pause_button= (Button) findViewById(R.id.button_pause);
    private MediaPlayer currentSound[] = new MediaPlayer[9];
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
        spinnerSelection();

        //button listener
        checkButtons();
        //pause listener
      //  pauseButton();
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
    public void setButtonSound(int i, int position){
        currentSound[i] = media[position];
    }
    public void spinnerSelection(){
        spinner[0].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int index = spinner[0].getSelectedItemPosition();
                Toast.makeText(getBaseContext(), "You chose " + list.get(index), Toast.LENGTH_SHORT).show();
                currentSound[0] = media[index];
            }

            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner[1].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int index = spinner[1].getSelectedItemPosition();
                Toast.makeText(getBaseContext(), "You chose " + list.get(index), Toast.LENGTH_SHORT).show();
                currentSound[1] = media[index];
            }

            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner[2].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int index = spinner[2].getSelectedItemPosition();
                Toast.makeText(getBaseContext(), "You chose " + list.get(index), Toast.LENGTH_SHORT).show();
                currentSound[2] = media[index];
            }

            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner[3].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int index = spinner[3].getSelectedItemPosition();
                Toast.makeText(getBaseContext(), "You chose " + list.get(index), Toast.LENGTH_SHORT).show();
                currentSound[3] = media[index];
            }

            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner[4].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int index = spinner[4].getSelectedItemPosition();
                Toast.makeText(getBaseContext(), "You chose " + list.get(index), Toast.LENGTH_SHORT).show();
                currentSound[4] = media[index];
            }

            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner[5].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int index = spinner[5].getSelectedItemPosition();
                Toast.makeText(getBaseContext(), "You chose " + list.get(index), Toast.LENGTH_SHORT).show();
                currentSound[5] = media[index];
            }

            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner[6].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int index = spinner[6].getSelectedItemPosition();
                Toast.makeText(getBaseContext(), "You chose " + list.get(index), Toast.LENGTH_SHORT).show();
                currentSound[6] = media[index];
            }

            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner[7].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int index = spinner[7].getSelectedItemPosition();
                Toast.makeText(getBaseContext(), "You chose " + list.get(index), Toast.LENGTH_SHORT).show();
                currentSound[7] = media[index];
            }

            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner[8].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int index = spinner[8].getSelectedItemPosition();
                Toast.makeText(getBaseContext(), "You chose " + list.get(index), Toast.LENGTH_SHORT).show();
                currentSound[8] = media[index];
            }

            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    public void checkButtons(){
        buttons[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "playing button 0", Toast.LENGTH_SHORT).show();
                currentSound[0].start();
            }
        });
        buttons[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "playing button 1", Toast.LENGTH_SHORT).show();
                currentSound[1].start();
            }
        });
        buttons[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "playing button 2", Toast.LENGTH_SHORT).show();
                currentSound[2].start();
            }
        });
        buttons[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "playing button 3", Toast.LENGTH_SHORT).show();
                currentSound[3].start();
            }
        });
        buttons[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "playing button 4", Toast.LENGTH_SHORT).show();
                currentSound[4].start();
            }
        });
        buttons[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "playing button 5", Toast.LENGTH_SHORT).show();
                currentSound[5].start();
            }
        });
        buttons[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "playing button 6", Toast.LENGTH_SHORT).show();
                currentSound[6].start();
            }
        });
        buttons[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "playing button 7", Toast.LENGTH_SHORT).show();
                currentSound[7].start();
            }
        });
        buttons[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "playing button 8", Toast.LENGTH_SHORT).show();
                currentSound[8].start();
            }
        });
    }
  /*  public void pauseButton(){
        pause_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(getBaseContext(), "pausing", Toast.LENGTH_SHORT).show();

                currentSound[1].pause();
            }
        });
        play.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //for(int i=0;i<currentSound.length;i++){
                    currentSound[8].start();
                //}

            }
        });
        pause.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
               // for(int i=0;i<currentSound.length;i++){
                    currentSound[8].pause();
               // }

            }
        });
        stop.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
              //  for(int i=0;i<currentSound.length;i++){
                    currentSound[8].stop();
               // }

            }
        });
    }*/


}
