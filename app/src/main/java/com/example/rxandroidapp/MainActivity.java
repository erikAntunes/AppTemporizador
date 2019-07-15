package com.example.rxandroidapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {

    private TextView contagemTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contagemTextView = findViewById(R.id.contagem_text_view);
        testRX();
    }

    private void testRX(){

        Observable.interval(1, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .take(6)
                .map(numero -> 5 - numero)
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        contagemTextView.setText("Iniciando Contagem");

                    }

                    @Override
                    public void onNext(Long numero) {
                        contagemTextView.setText("Regressiva: "+numero);

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        contagemTextView.setText("FIM");

                    }
                });


    }



    }
