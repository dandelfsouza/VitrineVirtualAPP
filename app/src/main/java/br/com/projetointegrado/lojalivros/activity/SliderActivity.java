package br.com.projetointegrado.lojalivros.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.heinrichreimersoftware.materialintro.app.IntroActivity;
import com.heinrichreimersoftware.materialintro.slide.FragmentSlide;

import br.com.projetointegrado.lojalivros.R;

public class SliderActivity extends IntroActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setButtonBackVisible(true);
        setButtonNextVisible(true);
        setButtonBackFunction(BUTTON_BACK_FUNCTION_BACK);
        setButtonNextFunction(BUTTON_NEXT_FUNCTION_NEXT);
        setButtonNextFunction(BUTTON_NEXT_FUNCTION_NEXT_FINISH);
        setFinishOnTouchOutside(true);
        autoplay(5000, INFINITE);

        addSlide(new FragmentSlide.Builder()
            .background(R.color.colorTwo)
                .fragment(R.layout.intro_1)
                .build()
        );
        addSlide(new FragmentSlide.Builder()
            .background(R.color.colorTwo)
                .fragment(R.layout.intro_2)
                .build()
        );
        addSlide(new FragmentSlide.Builder()
            .background(R.color.colorTwo)
                .fragment(R.layout.intro_3)
                .build()
        );
        addSlide(new FragmentSlide.Builder()
            .background(R.color.colorTwo)
                .fragment(R.layout.intro_4)
                .build()
        );
    }

    public void btLogin(View view){
        startActivity(new Intent(this, LoginActivity.class));
    }

    public void btCad(View view){
        startActivity(new Intent(this, CadastroActivity.class));
    }

    public void btAnonimo(View view){
        startActivity(new Intent(this, InicialActivity.class));
    }

}
