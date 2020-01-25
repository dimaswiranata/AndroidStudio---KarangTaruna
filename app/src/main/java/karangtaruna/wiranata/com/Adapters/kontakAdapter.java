package karangtaruna.wiranata.com.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import karangtaruna.wiranata.com.Classes.Kontak;
import karangtaruna.wiranata.com.R;

public class kontakAdapter extends RecyclerView.Adapter<kontakAdapter.CategoryKontakViewHolder> {

    private Context context;
    private ArrayList<Kontak> kontak;

    public kontakAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<Kontak> getKontak() {
        return kontak;
    }

    public void setKontak(ArrayList<Kontak> kontak) {
        this.kontak = kontak;
    }

    @NonNull
    @Override
    public kontakAdapter.CategoryKontakViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.item_kontak,viewGroup,false);
        return new kontakAdapter.CategoryKontakViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull final kontakAdapter.CategoryKontakViewHolder categoryKontakViewHolder,final int i) {
        categoryKontakViewHolder.tvNama.setText(getKontak().get(i).getNama());
        categoryKontakViewHolder.tvJabatan.setText(getKontak().get(i).getJabatan());

        Glide.with(context)
                .load(getKontak().get(i).getPhoto())
                .apply(RequestOptions.overrideOf(60,60))
                .into(categoryKontakViewHolder.imgPhoto);

        categoryKontakViewHolder.btnHubungi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(itemView.getContext(), team.getMovie(), Toast.LENGTH_SHORT).show();
                Intent whatsapp = new Intent(Intent.ACTION_VIEW, Uri.parse(String.valueOf(kontak.get(i).getWhatsapp())));
                categoryKontakViewHolder.btnHubungi.getContext().startActivity(whatsapp);
            }
        });

    }

    @Override
    public int getItemCount() {
        return getKontak().size();
    }

    public class CategoryKontakViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama;
        TextView tvJabatan;
        ImageView imgPhoto;
        Button btnHubungi;
        public CategoryKontakViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tv_nama_humas);
            tvJabatan = itemView.findViewById(R.id.tv_jabatan_humas);
            imgPhoto = itemView.findViewById(R.id.iv_humas);
            btnHubungi = itemView.findViewById(R.id.btn_hubungi);
        }
    }
}
