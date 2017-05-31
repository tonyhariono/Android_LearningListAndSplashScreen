package id.co.imastudio.harikeduabelajarlist;

import android.media.MediaPlayer;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Langkah 1 Deklarasi Variabel
    ListView list;
    ViewPager pager;

    String[] listbuah = {
            "Jambu",
            "Apel",
            "Alpukat",
            "Ceri",
            "Durian",
            "Manggis",
            "Strawberry"
    };

    int[] listgambarbuah = {
            R.drawable.jambuair,
            R.drawable.apel,
            R.drawable.alpukat,
            R.drawable.ceri,
            R.drawable.durian,
            R.drawable.manggis,
            R.drawable.strawberry

    };

    int[] listmusikbuah = {
            R.raw.jambuair,
            R.raw.apel,
            R.raw.alpukat,
            R.raw.ceri,
            R.raw.durian,
            R.raw.manggis,
            R.raw.strawberry
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.listView1);

        //ArrayAdapter adapter=new ArrayAdapter(MainActivity.this,R.layout.support_simple_spinner_dropdown_item,listbuah);
        CustomListAdapter adapter = new CustomListAdapter(MainActivity.this, listbuah, listgambarbuah);

        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Posisi " + position, Toast.LENGTH_SHORT).show();

                MediaPlayer player = MediaPlayer.create(MainActivity.this, listmusikbuah[position]);
                player.start();

            }
        });

        pager = (ViewPager) findViewById(R.id.viewPager);

        CustomPagerAdapter pagerAdapter = new CustomPagerAdapter(MainActivity.this, listbuah, listgambarbuah);
        pager.setAdapter(pagerAdapter);
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }
}
