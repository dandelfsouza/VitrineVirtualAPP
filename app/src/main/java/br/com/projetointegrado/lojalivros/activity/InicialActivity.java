package br.com.projetointegrado.lojalivros.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import br.com.projetointegrado.lojalivros.R;

public class InicialActivity extends AppCompatActivity {

    CarouselView carouselView;
    Button categoria, autores, top10, lancamentos, favoritos;
    int[] images = {R.drawable.you, R.drawable.corposocultos, R.drawable.ladykillers, R.drawable.hpbox, R.drawable.maisfortequeomar};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicial);
            init();

            carouselView.setPageCount(images.length);

            carouselView.setImageListener(imageListener);


    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(images[position]);
        }
    };

    public void init(){
        carouselView = findViewById(R.id.cvInicial);
        categoria = findViewById(R.id.categoriaInicial);
        autores = findViewById(R.id.autoresInicial);
        top10 = findViewById(R.id.top10Inicial);
        lancamentos = findViewById(R.id.lancamentosInicial);
        favoritos = findViewById(R.id.favoritosInicial);
    }

}
