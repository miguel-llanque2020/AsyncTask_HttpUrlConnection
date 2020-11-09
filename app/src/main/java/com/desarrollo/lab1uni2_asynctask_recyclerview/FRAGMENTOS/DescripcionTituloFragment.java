package com.desarrollo.lab1uni2_asynctask_recyclerview.FRAGMENTOS;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.desarrollo.lab1uni2_asynctask_recyclerview.ENTIDAD.TitulosVo;
import com.desarrollo.lab1uni2_asynctask_recyclerview.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DescripcionTituloFragment extends Fragment {

    TextView textinfo;

    public DescripcionTituloFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_descripcion_titulo, container, false);

        textinfo = (TextView) vista.findViewById(R.id.informacion);

        Bundle objLL = getArguments();
        TitulosVo mititulo = null;

        if (objLL != null) {
            mititulo= (TitulosVo) objLL.getSerializable("objeto");
            LlenarInformacion(mititulo);
        }
        return vista;
    }

    public void LlenarInformacion(TitulosVo mititulo) {
        textinfo.setText(mititulo.getDescripcion());
    }
}
