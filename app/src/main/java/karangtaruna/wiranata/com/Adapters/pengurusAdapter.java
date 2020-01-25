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

import karangtaruna.wiranata.com.Classes.Pengurus;
import karangtaruna.wiranata.com.R;

public class pengurusAdapter extends RecyclerView.Adapter<pengurusAdapter.CategoryPengurusViewHolder> {
    private Context context;
    private ArrayList<Pengurus> pengurus;

    public pengurusAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<Pengurus> getPengurus() {
        return pengurus;
    }

    public void setPengurus(ArrayList<Pengurus> pengurus) {
        this.pengurus = pengurus;
    }

    @NonNull
    @Override
    public pengurusAdapter.CategoryPengurusViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_pengurus, viewGroup,false);
        return new pengurusAdapter.CategoryPengurusViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull pengurusAdapter.CategoryPengurusViewHolder categoryPengurusViewHolder, int i) {
        categoryPengurusViewHolder.tvNama.setText(getPengurus().get(i).getNama());
        categoryPengurusViewHolder.tvJabatan.setText(getPengurus().get(i).getJabatan());
        categoryPengurusViewHolder.tvAlamat.setText(getPengurus().get(i).getAlamat());

        Glide.with(context)
                .load(getPengurus().get(i).getPhoto())
                .apply(RequestOptions.overrideOf(60,60))
                .into(categoryPengurusViewHolder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return getPengurus().size();
    }

    public class CategoryPengurusViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama;
        TextView tvJabatan;
        TextView tvAlamat;
        ImageView imgPhoto;
        View lineView;

        public CategoryPengurusViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tv_nama_pengurus);
            tvJabatan = itemView.findViewById(R.id.tv_jabatan);
            tvAlamat = itemView.findViewById(R.id.tv_alamat);
            imgPhoto = itemView.findViewById(R.id.iv_pengurus);
//            lineView = itemView.findViewById(R.id.line_view);
        }
    }
}

