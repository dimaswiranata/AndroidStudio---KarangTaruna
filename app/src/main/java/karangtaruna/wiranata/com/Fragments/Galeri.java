package karangtaruna.wiranata.com.Fragments;


import android.annotation.SuppressLint;
import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import karangtaruna.wiranata.com.Adapters.galeriAdapter;
import karangtaruna.wiranata.com.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Galeri extends Fragment {
    private RecyclerView rvGaleri;
    private TypedArray imgPhoto;

    private ArrayList<karangtaruna.wiranata.com.Classes.Galeri> list = new ArrayList<>();

    public Galeri() {
        // Required empty public constructor
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        galeriAdapter adapter;
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_galeri, container, false);
        rvGaleri = view.findViewById(R.id.rv_galeri);
        rvGaleri.setHasFixedSize(true);

        setArr();
        list.addAll(this.getListData());
        rvGaleri.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        galeriAdapter GaleriAdapter = new galeriAdapter(getActivity());
        GaleriAdapter.setGaleri(list);
        rvGaleri.setAdapter(GaleriAdapter);

        return view ;
    }

    public  ArrayList<karangtaruna.wiranata.com.Classes.Galeri> getListData(){

        ArrayList<karangtaruna.wiranata.com.Classes.Galeri> galeries = new ArrayList<>();
        for (int i = 0 ; i < imgPhoto.length(); i++){
            karangtaruna.wiranata.com.Classes.Galeri galeri = new karangtaruna.wiranata.com.Classes.Galeri();
            galeri.setPhoto(imgPhoto.getResourceId(i,-1));
            galeries.add(galeri);
        }

        Log.e("arr", String.valueOf(galeries.toArray()));
        return galeries;
    }

    private void setArr(){
        imgPhoto =  getActivity().getResources().obtainTypedArray(R.array.data_photo_galeri);
    }


}
