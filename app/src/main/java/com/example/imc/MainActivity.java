package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editTextPeso, editTextAltura;
    private Button botonLimpiar;
    private Button botonSalir;
    private TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextPeso = findViewById(R.id.editTextPeso);
        editTextAltura = findViewById(R.id.editTextAltura);
        Button botonCalcular = findViewById(R.id.botonCalcular);
        botonLimpiar = findViewById(R.id.botonLimpiar);
        botonSalir = findViewById(R.id.botonSalir);
        textViewResultado = findViewById(R.id.textViewResultado);

        botonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularIMC();
            }
        });

        botonLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpiarCampos();
            }
        });

        botonSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void calcularIMC() {
        String pesoString = editTextPeso.getText().toString();
        String alturaString = editTextAltura.getText().toString();

        if (!pesoString.isEmpty() && !alturaString.isEmpty()) {
            float peso = Float.parseFloat(pesoString);
            float altura = Float.parseFloat(alturaString);

            float imc = peso / (altura * altura);

            String resultado;

            if (imc < 18.5) {
                resultado = "Bajo peso";
            } else if (imc >= 18.5 && imc < 25) {
                resultado = "Peso normal";
            } else if (imc >= 25 && imc < 30) {
                resultado = "Sobrepeso";
            } else {
                resultado = "Obesidad";
            }

            textViewResultado.setText("IMC: " + String.format("%.2f", imc) + "\n" + resultado);
        } else {
            textViewResultado.setText("Por favor, ingresa un peso y altura válidos");
        }
    }

    private void limpiarCampos() {
        editTextPeso.setText("");
        editTextAltura.setText("");
        textViewResultado.setText("");
    }
}
