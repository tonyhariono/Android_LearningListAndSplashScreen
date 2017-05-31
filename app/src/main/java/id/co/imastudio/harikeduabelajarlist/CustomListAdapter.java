package id.co.imastudio.harikeduabelajarlist;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by tOnY-ROG on 5/16/2017.
 */
// alt ENter buat konstruktor

public class CustomListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] namaBuah;
    private final int[] gambarBuah;

    public CustomListAdapter(Activity context1, String[] namaBuah, int[] gambarBuah) {
        super(context1,R.layout.item_buah, namaBuah);
        this.context = context1;
        this.namaBuah = namaBuah;
        this.gambarBuah = gambarBuah;
    }

    // alt+Insert
    // atau klik kanan->generate->override methods
    //pilih getView

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View itemView=inflater.inflate(R.layout.item_buah,null,true);

        TextView tvnamaBuah=(TextView) itemView.findViewById(R.id.tvNamaBuah);
        ImageView ivgambarBuah=(ImageView) itemView.findViewById(R.id.ivBuah);

        tvnamaBuah.setText(namaBuah[position]);
        ivgambarBuah.setImageResource(gambarBuah[position]);

        return itemView;
    }
}
