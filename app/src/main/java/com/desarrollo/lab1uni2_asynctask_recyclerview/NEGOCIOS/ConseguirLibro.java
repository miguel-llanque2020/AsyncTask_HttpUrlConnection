package com.desarrollo.lab1uni2_asynctask_recyclerview.NEGOCIOS;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableWrapper;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.desarrollo.lab1uni2_asynctask_recyclerview.FRAGMENTOS.ListaTitulosFragment;
import com.desarrollo.lab1uni2_asynctask_recyclerview.MainActivity;
import com.desarrollo.lab1uni2_asynctask_recyclerview.R;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Pattern;

public class ConseguirLibro extends AsyncTask<String, Void, String> {

    public static String datos = "";
    private TextView mTextoTitulo;
    private TextView mTextoAutor;
    public static String decoder = "";

    public ConseguirLibro(TextView mTextoTitulo, TextView mTextoAutor) {
        this.mTextoTitulo = mTextoTitulo;
        this.mTextoAutor = mTextoAutor;
    }

    @Override
    protected String doInBackground(String... strings) {
        return UtilidadesRed.obtenerInformacionLibro(strings[0]);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        try {
            JSONObject jsonObject = new JSONObject(s);
            JSONArray itemsArray = jsonObject.getJSONArray("items");
            int i = 0;
            String titulo = null;
            String autores = null;
            String subtitle = null;
            String publisher = null;
            String datepublisher = null;
            String urlimagen = null;
            String largedescription = null;

            while ( i < itemsArray.length() && (autores == null && titulo == null && subtitle == null && publisher == null && datepublisher == null)) {
                JSONObject libro = itemsArray.getJSONObject(i);
                JSONObject volumenInfo = libro.getJSONObject("volumeInfo");

                try {
                    titulo = volumenInfo.getString("title");
                    autores = volumenInfo.getString("authors");
                    subtitle = volumenInfo.getString("subtitle");
                    publisher = volumenInfo.getString("publisher");
                    datepublisher = volumenInfo.getString("publishedDate");
                    largedescription = volumenInfo.getString("description");
                    urlimagen = volumenInfo.getString("imageLinks");

                } catch (Exception e) {
                    e.printStackTrace();
                }

                i++;
            }



            if (titulo != null) {

                if (autores != null) {
                    int tamaño = autores.length();
                    int startcadena = 2;
                    int endcadena = tamaño - 2;
                    autores = autores.substring(startcadena, endcadena);
                }

                if (urlimagen != null) {
                    DecodificarURLimagen(urlimagen);
                }


                MainActivity.LlenarTitulos(titulo,
                        subtitle
                        + "\n\nAutor: " + autores
                        + "\n\nEditorial: " + publisher
                        + "\n\nFecha de Publicacion: " + datepublisher
                        + "\n\nURL IMAGEN: " + decoder,

                        "DESCRIPCION: "
                                + "\n\n" + largedescription,
                        R.drawable.ayuda);

            } else {
                MainActivity.LlenarTitulos("No existen resultados para esa busqueda", "error buscando titulo", "",0);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void DecodificarURLimagen(String urlimagen) {

        String urlinicial = "books.google.com/books/content?id=";

        try {
            String[] parts = urlimagen.split(":");
            int finalnum = parts[2].length();
            String urlsecundadria = parts[2].substring(40, finalnum - 13);
            decoder = urlinicial + urlsecundadria;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
