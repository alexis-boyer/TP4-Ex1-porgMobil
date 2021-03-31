package com.example.tp4_ex1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ToutesSaisonFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ToutesSaisonFragment extends Fragment {

    // Les champs utilisés par chaque Fragment
    //Ils sont distincts pour chaque NatureFragment instancié
    private String title;
    private int page;
    /**
     * Pour la sauvegarde et la récupération des données
     * dans un Bundle
     */
    private static final String ARG_SECTION_NUMBER = "numero_page";
    private static final String ARG_SECTION_TITLE = "titre_page";

    /**
     * Retourne une nouvelle instance de ce fragment
     * pour le numéro de section donné.
     */
    public static ToutesSaisonFragment newInstance(int position, String title) {
        ToutesSaisonFragment fragment = new ToutesSaisonFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, position);
        args.putString(ARG_SECTION_TITLE, title);
        fragment.setArguments(args);
        return fragment;
    }

    // retrouver les valeurs des champs à partir du bundle
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt(ARG_SECTION_NUMBER, 0);
        title = getArguments().getString(ARG_SECTION_TITLE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_toutes_saison, container, false);
        TextView tvLabel = (TextView) view.findViewById(R.id.section_label);
        tvLabel.setText(page + " -- " + title);

        ImageView img1 = (ImageView) view.findViewById(R.id.imageView1);
        img1.setImageResource(R.drawable.printemps);

        ImageView img2 = (ImageView) view.findViewById(R.id.imageView2);
        img2.setImageResource(R.drawable.ete);

        ImageView img3 = (ImageView) view.findViewById(R.id.imageView3);
        img3.setImageResource(R.drawable.automne);

        ImageView img4 = (ImageView) view.findViewById(R.id.imageView4);
        img4.setImageResource(R.drawable.hiver);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.singleton.viewPager.setCurrentItem(0);
            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.singleton.viewPager.setCurrentItem(1);
            }
        });

        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.singleton.viewPager.setCurrentItem(2);
            }
        });

        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.singleton.viewPager.setCurrentItem(3);
            }
        });

        return view;
    }
}