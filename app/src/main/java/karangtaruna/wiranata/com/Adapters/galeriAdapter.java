package karangtaruna.wiranata.com.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import karangtaruna.wiranata.com.Classes.Galeri;
import karangtaruna.wiranata.com.R;

public class galeriAdapter extends RecyclerView.Adapter<galeriAdapter.CategoryGaleriViewHolder> {

    private Context context;
    private ArrayList<Galeri> galeri;

    public galeriAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<Galeri> getGaleri() {
        return galeri;
    }

    public void setGaleri(ArrayList<Galeri> galeri) {
        this.galeri = galeri;
    }

    @NonNull
    @Override
    public CategoryGaleriViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.item_galeri,viewGroup,false);
        return new galeriAdapter.CategoryGaleriViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryGaleriViewHolder holder, int i) {
        Glide.with(context)
                .load(getGaleri().get(i).getPhoto())
                .into(holder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return getGaleri().size();
    }

    public class CategoryGaleriViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        public CategoryGaleriViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.iv_galeri);
        }
    }
}
