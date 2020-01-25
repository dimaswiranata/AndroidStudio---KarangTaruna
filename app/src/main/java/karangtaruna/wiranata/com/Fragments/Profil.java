package karangtaruna.wiranata.com.Fragments;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import karangtaruna.wiranata.com.R;
import karangtaruna.wiranata.com.Utilities.OnOneClickListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class Profil extends Fragment {
    Button btnKontak;


    public Profil() {
        // Required empty public constructor
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profil, container, false);
        btnKontak = view.findViewById(R.id.btn_kontak);

        btnKontak.setOnClickListener(new OnOneClickListener(){
            @Override
            public void onOneClick(View v) {
                Intent moveIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://api.whatsapp.com/send?phone=+6281278042894"));
                startActivity(moveIntent);
            }
        });

        return view;
    }



}
