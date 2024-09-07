package com.example.appfinanceiro;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btn;
    TextView textView6;
    EditText editText1,editText2,editText3,editText4;
    double capInicial,aplicMensal, taxa;
    double montante;
    int tempAplic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        editText1 = findViewById(R.id.edtTxt1);
        editText2 = findViewById(R.id.edtTxt2);
        editText3 = findViewById(R.id.edtTxt3);
        editText4 = findViewById(R.id.edtTxt4);
        textView6 = findViewById(R.id.textView6);
        btn = findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                capInicial = Double.parseDouble(String.valueOf(editText1.getText()));
                aplicMensal = Double.parseDouble(String.valueOf(editText2.getText()));
                tempAplic= Integer.parseInt(String.valueOf(editText3.getText()));
                taxa = Double.parseDouble(String.valueOf(editText4.getText()));
                montante = capInicial;
                for (int i = 0; i < tempAplic; i++) {
                    montante += aplicMensal; //aplicação + capinicial
                    montante *= (1 + taxa / 100); //capinicial + juros
                }
                String resultado = "R$" + String.valueOf(montante);
                textView6.setText(resultado);
            }
        });
    }
}