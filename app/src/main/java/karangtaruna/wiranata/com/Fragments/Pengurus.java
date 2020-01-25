package karangtaruna.wiranata.com.Fragments;


import android.annotation.SuppressLint;
import android.content.Intent;
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

import karangtaruna.wiranata.com.Adapters.pengurusAdapter;
import karangtaruna.wiranata.com.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Pengurus extends Fragment {
    private RecyclerView rvPengurus;
    private String dataNama[];
    private String dataJabatan[];
    private String dataAlamat[];
    private TypedArray imgPhoto;

    private ArrayList<karangtaruna.wiranata.com.Classes.Pengurus> list = new ArrayList<>();

    public Pengurus() {
        // Required empty public constructor
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        pengurusAdapter adapter;
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pengurus, container, false);
        rvPengurus = view.findViewById(R.id.rv_pengurus);
        rvPengurus.setHasFixedSize(true);

        setArr();
        list.addAll(this.getListData());
        rvPengurus.setLayoutManager(new LinearLayoutManager(getActivity()));
        pengurusAdapter PengurusAdapter = new pengurusAdapter(getActivity());
        PengurusAdapter.setPengurus(list);
        rvPengurus.setAdapter(PengurusAdapter);

        return view ;
    }

    public  ArrayList<karangtaruna.wiranata.com.Classes.Pengurus> getListData(){

        ArrayList<karangtaruna.wiranata.com.Classes.Pengurus> penguruses = new ArrayList<>();
        for (int i = 0 ; i < dataNama.length; i++){
            karangtaruna.wiranata.com.Classes.Pengurus pengurus = new karangtaruna.wiranata.com.Classes.Pengurus();
            pengurus.setPhoto(imgPhoto.getResourceId(i,-1));
            pengurus.setNama(dataNama[i]);
            pengurus.setJabatan(dataJabatan[i]);
            pengurus.setAlamat(dataAlamat[i]);
            penguruses.add(pengurus);
        }

        Log.e("arr", String.valueOf(penguruses.toArray()));
        return penguruses;
    }

    private void setArr(){
        dataNama= getActivity().getResources().getStringArray(R.array.data_nama_pengurus);
        dataJabatan =  getActivity().getResources().getStringArray(R.array.data_jabatan_pengurus);
        dataAlamat =  getActivity().getResources().getStringArray(R.array.data_alamat_pengurus);
        imgPhoto =  getActivity().getResources().obtainTypedArray(R.array.data_photo_pengurus);

    }

}
