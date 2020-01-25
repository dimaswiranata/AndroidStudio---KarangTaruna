package karangtaruna.wiranata.com.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import karangtaruna.wiranata.com.Classes.Kegiatan;
import karangtaruna.wiranata.com.R;

public class kegiatanAdapter extends RecyclerView.Adapter<kegiatanAdapter.CategoryKegiatanViewHolder> {

    private Context context;
    private ArrayList<Kegiatan> kegiatan;

    public kegiatanAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<Kegiatan> getKegiatan() {
        return kegiatan;
    }

    public void setKegiatan(ArrayList<Kegiatan> kegiatan) {
        this.kegiatan = kegiatan;
    }

    @NonNull
    @Override
    public kegiatanAdapter.CategoryKegiatanViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.item_kegiatan,viewGroup,false);
        return new kegiatanAdapter.CategoryKegiatanViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull kegiatanAdapter.CategoryKegiatanViewHolder holder, int i) {
        holder.tvNama.setText(getKegiatan().get(i).getNama());
        holder.tvDeskripsi.setText(getKegiatan().get(i).getDeskripsi());

        Glide.with(context)
                .load(getKegiatan().get(i).getPhoto())
                .into(holder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return getKegiatan().size();
    }

    public class CategoryKegiatanViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama;
        TextView tvDeskripsi;
        ImageView imgPhoto;

        public CategoryKegiatanViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tv_nama_kegiatan);
            tvDeskripsi = itemView.findViewById(R.id.tv_deskripsi_kegiatan);
            imgPhoto = itemView.findViewById(R.id.iv_kegiatan);
        }
    }
}
