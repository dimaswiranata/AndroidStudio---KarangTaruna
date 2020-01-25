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

import karangtaruna.wiranata.com.Adapters.kontakAdapter;
import karangtaruna.wiranata.com.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Kontak extends Fragment {
    private RecyclerView rvKontak;
    private String dataNama[];
    private String dataJabatan[];
    private String dataWhatsapp[];
    private TypedArray imgPhoto;

    private ArrayList<karangtaruna.wiranata.com.Classes.Kontak> list = new ArrayList<>();

    public Kontak() {
        // Required empty public constructor
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        kontakAdapter adapter;
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_kontak, container, false);
        rvKontak = view.findViewById(R.id.rv_kontak);
        rvKontak.setHasFixedSize(true);

        setArr();
        list.addAll(this.getListData());
        rvKontak.setLayoutManager(new LinearLayoutManager(getActivity()));
        kontakAdapter KontaksAdapter = new kontakAdapter(getActivity());
        KontaksAdapter.setKontak(list);
        rvKontak.setAdapter(KontaksAdapter);

        return view ;
    }

    public  ArrayList<karangtaruna.wiranata.com.Classes.Kontak> getListData(){

        ArrayList<karangtaruna.wiranata.com.Classes.Kontak> kontaks = new ArrayList<>();
        for (int i = 0 ; i < dataNama.length; i++){
            karangtaruna.wiranata.com.Classes.Kontak kontak = new karangtaruna.wiranata.com.Classes.Kontak();
            kontak.setPhoto(imgPhoto.getResourceId(i,-1));
            kontak.setNama(dataNama[i]);
            kontak.setJabatan(dataJabatan[i]);
            kontak.setWhatsapp(dataWhatsapp[i]);
            kontaks.add(kontak);
        }

        Log.e("arr", String.valueOf(kontaks.toArray()));
        return kontaks;
    }

    private void setArr(){
        dataNama= getActivity().getResources().getStringArray(R.array.data_nama_humas);
        dataJabatan =  getActivity().getResources().getStringArray(R.array.data_jabatan_humas);
        dataWhatsapp =  getActivity().getResources().getStringArray(R.array.data_whatsapp_humas);
        imgPhoto =  getActivity().getResources().obtainTypedArray(R.array.data_photo_pengurus);
    }

}
