package com.desarrollo.lab1uni2_asynctask_recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.desarrollo.lab1uni2_asynctask_recyclerview.ADAPTADOR.AdaptadorTitulos;
import com.desarrollo.lab1uni2_asynctask_recyclerview.ENTIDAD.TitulosVo;
import com.desarrollo.lab1uni2_asynctask_recyclerview.FRAGMENTOS.DescripcionTituloFragment;
import com.desarrollo.lab1uni2_asynctask_recyclerview.FRAGMENTOS.ListaTitulosFragment;
import com.desarrollo.lab1uni2_asynctask_recyclerview.INTERFAZ.IComFragments;
import com.desarrollo.lab1uni2_asynctask_recyclerview.NEGOCIOS.ConseguirImagen;
import com.desarrollo.lab1uni2_asynctask_recyclerview.NEGOCIOS.ConseguirLibro;
import com.squareup.picasso.Picasso;

import java.io.IOException;


public class MainActivity extends AppCompatActivity implements IComFragments {

    //IMAGEN
    public String URLIMAGEN = "http://www.thebiblescholar.com/android_awesome.jpg";

    //DATOS DEL LIBRO
    private EditText mImputLibro;
    private TextView mTextoTitulo;
    private TextView mTextoAutor;

    //DATOS PARA LOS FRAGMENTOS
    ListaTitulosFragment ListaFragment;
    DescripcionTituloFragment DescripcionFragment;
    public static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.contenedorFragment) != null){
            if (savedInstanceState != null){
                return;
            }

            ListaFragment = new ListaTitulosFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedorFragment, ListaFragment).commit();
        }

        //PIDIENDO ENLACE A LOS DATOS
        mImputLibro = (EditText) findViewById(R.id.ingresoLibro);
        mTextoTitulo = (TextView) findViewById(R.id.titulo);
        mTextoAutor = (TextView) findViewById(R.id.autorLibro);

    }

    public void buscarLibro(View view) {
        String cadenaBusqueda = mImputLibro.getText().toString();

        if (cadenaBusqueda.equals("")) {
            Toast.makeText(getApplicationContext(), "Texto de busqueda vacio", Toast.LENGTH_SHORT).show();

        } else {
            new ConseguirLibro(mTextoTitulo, mTextoAutor).execute(cadenaBusqueda);
        }
    }

    public static void LlenarTitulos(String titulo, String autores, String descripcionlarga, int imagen) {
        ListaTitulosFragment.RefrescarTitulos(titulo, autores, descripcionlarga, imagen);
        AdaptadorTitulos adapter = new AdaptadorTitulos(ListaTitulosFragment.ListaTitulos, context);
        ListaTitulosFragment.RecyclerTitulos.setAdapter(adapter);
    }


    @Override
    public void enviarLoveLive(TitulosVo titulos) {
        DescripcionFragment = new DescripcionTituloFragment();
        Bundle Frag2 = new Bundle();
        Frag2.putSerializable("objeto", titulos);
        DescripcionFragment.setArguments(Frag2);
        getSupportFragmentManager().beginTransaction().replace(R.id.contenedorFragment, DescripcionFragment).addToBackStack(null).commit();
    }
}
