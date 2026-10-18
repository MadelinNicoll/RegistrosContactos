package com.example.registroscontactos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

import com.example.registroscontactos.Contacto;

public class ContactoAdapter extends RecyclerView.Adapter<ContactoAdapter.ContactoViewHolder> {

    private List<com.example.registroscontactos.Contacto> lista;

    public ContactoAdapter(List<com.example.registroscontactos.Contacto> lista) {
        this.lista = lista;
    }

    @NonNull
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contacto, parent, false);
        return new ContactoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactoViewHolder holder, int position) {
        Contacto c = lista.get(position);
        holder.tvNombre.setText(c.getNombre() + " (" + c.getOpcion() + ")");
        holder.tvDetalles.setText(c.getCorreo() + " | Tel: " + c.getTelefono());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder {
        TextView tvNombre, tvDetalles;

        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.tvNombreItem);
            tvDetalles = itemView.findViewById(R.id.tvDetallesItem);
        }
    }
}
