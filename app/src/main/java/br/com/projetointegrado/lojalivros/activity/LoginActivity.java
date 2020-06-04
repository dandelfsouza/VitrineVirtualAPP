package br.com.projetointegrado.lojalivros.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import br.com.projetointegrado.lojalivros.R;

public class LoginActivity extends AppCompatActivity {

    EditText email, senha;
    Button cadastro, entrar;
    TextView recuperaSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inicializarComponentes();

        cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, CadastroActivity.class);
                startActivity(intent);
            }
        });

        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, InicialActivity.class);
                startActivity(intent);
            }
        });


    }

    public void inicializarComponentes(){
        email = findViewById(R.id.emailLogin);
        senha = findViewById(R.id.senhaLogin);
        cadastro = findViewById(R.id.btnCriarConta);
        entrar = findViewById(R.id.btnEntrarLogin);
        recuperaSenha = findViewById(R.id.recuperarSenha);


    }
}
