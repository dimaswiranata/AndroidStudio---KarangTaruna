package karangtaruna.wiranata.com.Fragments;


import android.annotation.SuppressLint;
import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import karangtaruna.wiranata.com.Adapters.kegiatanAdapter;
import karangtaruna.wiranata.com.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Kegiatan extends Fragment {
    private RecyclerView rvKegiatan;
    private String dataNama[];
    private String dataDeskripsi[];
    private TypedArray imgPhoto;

    private ArrayList<karangtaruna.wiranata.com.Classes.Kegiatan> list = new ArrayList<>();


    public Kegiatan() {
        // Required empty public constructor
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        kegiatanAdapter adapter;
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_kegiatan, container, false);
        rvKegiatan = view.findViewById(R.id.rv_kegiatan);
        rvKegiatan.setHasFixedSize(true);

        setArr();
        list.addAll(this.getListData());
        rvKegiatan.setLayoutManager(new LinearLayoutManager(getActivity()));
        kegiatanAdapter KegiatanAdapter = new kegiatanAdapter(getActivity());
        KegiatanAdapter.setKegiatan(list);
        rvKegiatan.setAdapter(KegiatanAdapter);

        return view ;
    }

    public  ArrayList<karangtaruna.wiranata.com.Classes.Kegiatan> getListData(){

        ArrayList<karangtaruna.wiranata.com.Classes.Kegiatan> kegiatans = new ArrayList<>();
        for (int i = 0 ; i < dataNama.length; i++){
            karangtaruna.wiranata.com.Classes.Kegiatan kegiatan = new karangtaruna.wiranata.com.Classes.Kegiatan();
            kegiatan.setPhoto(imgPhoto.getResourceId(i,-1));
            kegiatan.setNama(dataNama[i]);
            kegiatan.setDeskripsi(dataDeskripsi[i]);
            kegiatans.add(kegiatan);
        }

        Log.e("arr", String.valueOf(kegiatans.toArray()));
        return kegiatans;
    }
    private void setArr() {
        dataNama= getActivity().getResources().getStringArray(R.array.data_nama_kegiatan);
        dataDeskripsi =  getActivity().getResources().getStringArray(R.array.data_deskripsi_kegiatan);
        imgPhoto =  getActivity().getResources().obtainTypedArray(R.array.data_photo_kegiatan);
    }

}
