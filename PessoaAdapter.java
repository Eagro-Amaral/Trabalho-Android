package com.example.alunos.aulalistviewbaseadapterpicasso;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import jp.wasabeef.picasso.transformations.CropCircleTransformation;

/**
 * Created by Alunos on 19/12/2016.
 */

public class PessoaAdapter extends BaseAdapter{

    private Context context;

    private ArrayList<Pessoa> pessoas;
    private LayoutInflater inflater;

    public PessoaAdapter(Context context, ArrayList<Pessoa> pessoas) {
        this.context = context;
        this.pessoas = pessoas;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return pessoas.size();
    }

    @Override
    public Pessoa getItem(int i) {
        return pessoas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        final ViewHolder holder;

        if(view == null){
         view = inflater.inflate(R.layout.linha_pessoa,null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }

        Pessoa p = getItem(i);

        holder.tvNome.setText("Nome: "+p.getNome());
        holder.tvIdade.setText("Idade: "+p.getIdade());

        if(p.getSexo().equalsIgnoreCase("Masculino")){
            Picasso.with(context)
                    .load("https://image.freepik.com/vetores-gratis/icone-de-usuario-do-sexo-masculino_17-810120247.jpg") //pegar URL foto Masculino
                    .transform(new CropCircleTransformation())
                    .placeholder(R.mipmap.ic_launcher)
                    .into(holder.ivImagem);

        }else{
                Picasso.with(context)
                        .load("https://image.freepik.com/icones-gratis/fim-da-mulher-com-simbolo-de-mais-para-a-interface-do-usuario-adicionar-o-botao-do-sexo-feminino_318-39642.jpg") //pegar URL foto Feminino
                        .transform(new CropCircleTransformation())
                        .placeholder(R.mipmap.ic_launcher)
                        .into(holder.ivImagem);
        }//fecha else

        return view;
    }//fecha getView
    static class ViewHolder{
        private ImageView ivImagem;
        private TextView tvNome;
        private TextView tvIdade;
        public ViewHolder(View v ){
            ivImagem = (ImageView) v.findViewById(R.id.lp_iv_imagem);
            tvNome = (TextView) v.findViewById(R.id.lp_tv_nome);
            tvIdade = (TextView) v.findViewById(R.id.lp_tv_idade);

        }//fecha construtor
    }//fecha classe ViewHolder
}//fecha classe PessoaAdapter
