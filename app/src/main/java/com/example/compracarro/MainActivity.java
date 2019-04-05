package com.example.compracarro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroupCarros;
    private CheckBox checkBoxArCondicionado,
            checkBoxPelicula,
            checkBoxSom,
            checkBoxMultimidia;
    private Button buttonCalcular;
    private TextView textViewResultado;

    private List<String> checked = new ArrayList<>();

   private int total;
   private int valorCarro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroupCarros = findViewById(R.id.radioGroupCarros);
        checkBoxArCondicionado = findViewById(R.id.checkBoxArCondicionado);
        checkBoxMultimidia = findViewById(R.id.checkBoxMultimidia);
        checkBoxPelicula = findViewById(R.id.checkBoxPelicula);
        checkBoxSom = findViewById(R.id.checkBoxSom);

        buttonCalcular = findViewById(R.id.buttonCalcular);

        textViewResultado = findViewById(R.id.textViewResultado);



        radioGroupCarros.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // cria um evento
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioButtonChevroletOnix:
                       valorCarro = 45000;
                       textViewResultado.setText("");

                        break;
                    case R.id.radioButtonFordFiesta:
                        valorCarro = 50000;
                        textViewResultado.setText("");

                        break;
                    case R.id.radioButtonHyundaiHb20:
                        valorCarro = 47000;
                        textViewResultado.setText("");
                        break;
                    case R.id.radioButtonToyotaEtios:
                        valorCarro = 40000;
                        textViewResultado.setText("");

                        break;
                    default:
                        textViewResultado.setText("Clique em uma opção");


                }
            }
        });
    }


    public void onClickCalcular(View view) {
        if (checkBoxSom.isChecked()){
            total += 2000;
            checked.add(checkBoxSom.getText().toString());
        }

        if (checkBoxPelicula.isChecked()){
            total += 900;
            checked.add(checkBoxPelicula.getText().toString());
        }
        if (checkBoxMultimidia.isChecked()){
            total += 3000;
            checked.add(checkBoxMultimidia.getText().toString());
        }
        if (checkBoxArCondicionado.isChecked()){
            total += 2000;
            checked.add(checkBoxArCondicionado.getText().toString());
        }
        total = (int) (total + valorCarro);
        textViewResultado.setText("R$" + total +".00");


    }

}



