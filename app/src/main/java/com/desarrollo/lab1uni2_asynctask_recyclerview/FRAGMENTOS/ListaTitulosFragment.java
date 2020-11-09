package com.desarrollo.lab1uni2_asynctask_recyclerview.FRAGMENTOS;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.desarrollo.lab1uni2_asynctask_recyclerview.ADAPTADOR.AdaptadorTitulos;
import com.desarrollo.lab1uni2_asynctask_recyclerview.ENTIDAD.TitulosVo;
import com.desarrollo.lab1uni2_asynctask_recyclerview.INTERFAZ.IComFragments;
import com.desarrollo.lab1uni2_asynctask_recyclerview.NEGOCIOS.ConseguirLibro;
import com.desarrollo.lab1uni2_asynctask_recyclerview.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListaTitulosFragment extends Fragment {

    public static ArrayList<TitulosVo> ListaTitulos;
    public static RecyclerView RecyclerTitulos;
    Activity activity;
    IComFragments intfragment;

    public ListaTitulosFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista =  inflater.inflate(R.layout.fragment_lista_titulos, container, false);

        ListaTitulos = new ArrayList<>();

        RecyclerTitulos = vista.findViewById(R.id.recyclerId);

        RecyclerTitulos.setLayoutManager(new LinearLayoutManager(getContext()));

        //AdaptadorTitulos adapter = new AdaptadorTitulos(ListaTitulos);
        //RecyclerTitulos.setAdapter(adapter);

        return vista;
    }

    public static void RefrescarTitulos(String titulo, String autores, String descripcionlarga, int imagen) {
        ListaTitulos.clear();
        ListaTitulos.add(new TitulosVo(titulo, autores, descripcionlarga, imagen));
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if(context instanceof Activity){
            this.activity= (Activity) context;
            intfragment= (IComFragments) this.activity;
        }
    }
}
