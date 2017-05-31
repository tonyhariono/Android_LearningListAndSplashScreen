package id.co.imastudio.harikeduabelajarlist;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by tOnY-ROG on 5/16/2017.
 */

public class CustomPagerAdapter extends PagerAdapter {
    private Context context;
    private String[] listNama;
    private int[] listGambar;

    // klik kanan > Generate > Constructor > Pilih Semua. OK
    // atau alt + insert


    public CustomPagerAdapter(Context context, String[] listNama, int[] listGambar) {
        this.context = context;
        this.listNama = listNama;
        this.listGambar = listGambar;
    }

    @Override
    public int getCount() {
        return listGambar.length;
        //banyak listnya
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        //layout yang di Item
        return view==(LinearLayout) object;
    }

    //generate > overide method

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        // beda
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView=inflater.inflate(R.layout.item_viewpager,null,true);

        TextView tvnamaBuah=(TextView) itemView.findViewById(R.id.tvPager);
        ImageView ivgambarBuah=(ImageView) itemView.findViewById(R.id.ivPager);

        tvnamaBuah.setText(listNama[position]);
        ivgambarBuah.setImageResource(listGambar[position]);

        //tambahkan addView
        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }
}
