package com.example.alunos.aulalistviewbaseadapterpicasso;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Tela1 extends AppCompatActivity {

    private EditText etNome;
    private EditText etIdade;
    private EditText etSexo;
    private Button btnOK;
    private ListView lvPessoas;
    //objetos
    private Pessoa p;
    //Array + Adapter
    private ArrayList<Pessoa> pessoas;
    private PessoaAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela1);

        //referencias
        etNome = (EditText) findViewById(R.id.t1_et_nome);
        etIdade = (EditText) findViewById(R.id.t1_et_idade);
        etSexo = (EditText) findViewById(R.id.t1_et_sexo);
        btnOK = (Button) findViewById(R.id.t1_btn_ok);
        lvPessoas = (ListView) findViewById(R.id.t1_lv_pessoas);

        //Adapter + Array + ListView
        pessoas = new ArrayList<>();
        adapter = new PessoaAdapter(Tela1.this,pessoas);
        lvPessoas.setAdapter(adapter);

        //clique do botao
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p = new Pessoa();
                p.setNome(etNome.getText().toString());
                p.setIdade(Integer.parseInt(etIdade.getText().toString()));
                p.setSexo(etSexo.getText().toString());
                //colocando objeto no array
                pessoas.add(p);

                //Notoficando o adapter
                adapter.notifyDataSetChanged();
                Toast.makeText(getBaseContext(), "Pessoa cadastrada com suceso", Toast.LENGTH_LONG).show();
            }
        });

    }//fecha pnCreate
}//fecha class
