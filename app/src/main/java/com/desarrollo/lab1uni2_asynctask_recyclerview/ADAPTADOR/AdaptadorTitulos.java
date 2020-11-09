package com.desarrollo.lab1uni2_asynctask_recyclerview.ADAPTADOR;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import androidx.recyclerview.widget.RecyclerView;

import com.desarrollo.lab1uni2_asynctask_recyclerview.ENTIDAD.TitulosVo;
import com.desarrollo.lab1uni2_asynctask_recyclerview.FRAGMENTOS.ListaTitulosFragment;
import com.desarrollo.lab1uni2_asynctask_recyclerview.MainActivity;
import com.desarrollo.lab1uni2_asynctask_recyclerview.NEGOCIOS.ConseguirImagen;
import com.desarrollo.lab1uni2_asynctask_recyclerview.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdaptadorTitulos extends RecyclerView.Adapter<AdaptadorTitulos.TitulosViewHolder> implements View.OnClickListener {

    ArrayList<TitulosVo> ListaTitulos;
    Context context;
    View view;
    private View.OnClickListener listener;

    public AdaptadorTitulos(ArrayList<TitulosVo> listatitulos, Context context) {
        this.ListaTitulos = listatitulos;
        this.context = context;
    }

    @Override
    public void onClick(View v) {

    }

    @NonNull
    @Override
    public TitulosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.titulos_layout, parent, false);
        view.setOnClickListener(this);
        return new TitulosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorTitulos.TitulosViewHolder holder, int position) {
        holder.txtTitulolibro.setText(ListaTitulos.get(position).getTitulo());
        holder.txtDescripcionlibro.setText(ListaTitulos.get(position).getDescripcion());
        holder.txtDescripcionlibrolarga.setText(ListaTitulos.get(position).getDescripcionlarga());
        holder.fotolibro.setImageResource(ListaTitulos.get(position).getImagen());
    }

    @Override
    public int getItemCount() {
        return ListaTitulos.size();
    }

    public class TitulosViewHolder extends RecyclerView.ViewHolder {

        TextView txtTitulolibro, txtDescripcionlibro, txtDescripcionlibrolarga;
        ImageView fotolibro;

        public TitulosViewHolder(View itemView) {
            super(itemView);
            txtTitulolibro = (TextView) itemView.findViewById(R.id.TituloBook);
            txtDescripcionlibro = (TextView) itemView.findViewById(R.id.DescripcionBook);
            txtDescripcionlibrolarga = (TextView) itemView.findViewById(R.id.DescripcionBookLarge);
            fotolibro = (ImageView) itemView.findViewById(R.id.idImagen);
        }
    }
}
