package br.com.projetointegrado.lojalivros.activity;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import br.com.projetointegrado.lojalivros.R;
import br.com.projetointegrado.lojalivros.database.Banco;
import br.com.projetointegrado.lojalivros.model.Usuario;

public class CadastroActivity extends AppCompatActivity {

    EditText nome, email, senha, confirma_senha;
    Button cadastra, volta;
    SQLiteDatabase db;
    Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        inicializarComponentes();

        cadastra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = openOrCreateDatabase(
                        Banco.banco(),
                        Context.MODE_PRIVATE,
                        null
                );

                //Strings que puxam os dados das caixas de texto
                String nomeT = nome.getText().toString();
                String emailT = email.getText().toString();
                String senhaT = senha.getText().toString();
                String confirmaT = confirma_senha.getText().toString();
                ContentValues dados = new ContentValues();

                if (!nomeT.isEmpty()){
                    if (!emailT.isEmpty()){
                        if (!senhaT.isEmpty()){
                            if (!confirmaT.isEmpty()){
                                dados.put("nome", nomeT);
                                dados.put("email", emailT);
                                dados.put("senha", senhaT);

                                db.insert(Banco.tabelaUsuario(), null, dados);

                                Toast.makeText(getApplicationContext(), "Seja bem vindo, " + usuario.getNome(), Toast.LENGTH_SHORT).show();

                                telaInicial();

                                finish();
                            } else
                                if (senhaT != confirmaT){
                                confirma_senha.setError("A senha não confiz com a confirmação");
                                confirma_senha.requestFocus();
                            } else
                                if (confirmaT.isEmpty()){
                                    confirma_senha.setError("*");
                                }
                        } else {
                            senha.setError("*");
                        }
                    } else {
                        email.setError("*");
                    }
                } else {
                    nome.setError("*");
                }
            }
        });

        volta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CadastroActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }

    public void inicializarComponentes(){
        nome = findViewById(R.id.nomeCadastro);
        email = findViewById(R.id.emailCadastro);
        senha = findViewById(R.id.senhaCadastro);
        confirma_senha = findViewById(R.id.confirmaSenhaCadastro);
        cadastra = findViewById(R.id.btnCadastrar);
        volta = findViewById(R.id.btnVoltar);
    }

    public void telaInicial(){
        startActivity(new Intent(this, InicialActivity.class));
    }
}
