package miguel.soundboard;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    MediaPlayer kittenMP;
    private Spinner spinner[] = new Spinner[9];
    ArrayAdapter<CharSequence> adapter;

   // final MediaPlayer  Kitten = MediaPlayer.create(this, R.raw.kitten);
//comment

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
       /* MediaPlayer elephant = MediaPlayer.create(this, R.raw.elephant);
        MediaPlayer rooster = MediaPlayer.create(this, R.raw.rooster); */

        final MediaPlayer kittenMP= MediaPlayer.create(this,R.raw.kitten);
        final MediaPlayer angrykittenMP = MediaPlayer.create(this,R.raw.angrycat);
        final MediaPlayer angrydogMP = MediaPlayer.create(this,R.raw.angrydog);
        final MediaPlayer cowMP = MediaPlayer.create(this,R.raw.cow);
        final MediaPlayer elephantMP = MediaPlayer.create(this,R.raw.elephant);
        final MediaPlayer frogMP = MediaPlayer.create(this,R.raw.frog);
        final MediaPlayer parakeetMP = MediaPlayer.create(this,R.raw.parakeet);
        final MediaPlayer pigMP = MediaPlayer.create(this,R.raw.pig);
        final MediaPlayer racoonMP = MediaPlayer.create(this,R.raw.raccoon);
        final MediaPlayer roosterMP = MediaPlayer.create(this,R.raw.rooster);
        final MediaPlayer trexMP = MediaPlayer.create(this,R.raw.trex);

     /*  final MediaPlayer kittenMP = MediaPlayer.create(this, R.raw.kitten);
        b3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                kittenMP.start();
            }
        });*/ //this way works


       // Button b1 = (Button) findViewById(R.id.button);
       b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                    //startActivity(new Intent("Play"));
                //if(b1.equals(Kitten)){
                    kittenMP.start();
                }



            //}
        });





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

        //each spinner references a button
        spinner[0] = (Spinner) findViewById(R.id.spinner);
        spinner[1] = (Spinner) findViewById(R.id.spinner2);
        spinner[2] = (Spinner) findViewById(R.id.spinner3);
        spinner[3] = (Spinner) findViewById(R.id.spinner4);
        spinner[4] = (Spinner) findViewById(R.id.spinner5);
        spinner[5] = (Spinner) findViewById(R.id.spinner6);
        spinner[6] = (Spinner) findViewById(R.id.spinner7);
        spinner[7] = (Spinner) findViewById(R.id.spinner8);
        spinner[8] = (Spinner) findViewById(R.id.spinner9);

        //added these
       /* Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.file_names, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);*/



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
