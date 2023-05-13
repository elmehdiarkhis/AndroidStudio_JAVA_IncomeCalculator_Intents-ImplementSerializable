package com.example.lab1_serializable_getset_elmehdi_arkhis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Variable Global

    //Premier block------------------------
    private EditText txtSalaireMens;
    private EditText txtPensionAli;
    private EditText txtRevenueMens;



    private Button btnCalcul;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Recuperer les Views

        //Premier block------------------------
        txtSalaireMens = (EditText) findViewById(R.id.txtSalaireMensID);
        txtPensionAli = (EditText) findViewById(R.id.txtPensionAliID);
        txtRevenueMens = (EditText) findViewById(R.id.txtRevenueMensID);


        btnCalcul = (Button) findViewById(R.id.btnCalculID);



        btnCalcul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{
                    //Premier block------------------------
                    //Tableau pour verifier le negatif
                    double[] tabRevenue = new double[3];

                    //Get
                    double SalaireMens = Double.parseDouble(txtSalaireMens.getText().toString());
                    double PensionAli = Double.parseDouble(txtPensionAli.getText().toString());
                    double RevenueMens = Double.parseDouble(txtRevenueMens.getText().toString());

                    tabRevenue[0] = SalaireMens;
                    tabRevenue[1] = PensionAli;
                    tabRevenue[2] = RevenueMens;

                    if(checkerPositif(tabRevenue)==false){
                        return;
                    }

                    RevenueC revenue = new RevenueC(SalaireMens,PensionAli,RevenueMens);

                    //fleche
                    Intent i = new Intent(getApplicationContext(),MainActivity2.class);

                    //Envoyer des infos avec la fleche
                    i.putExtra("a1.revenu",revenue);

                    //Envoyer la fleche
                    startActivity(i);

                    //--------------------------------------

                }catch(Exception ex){
                    Toast.makeText(MainActivity.this, ex.getMessage(), Toast.LENGTH_SHORT).show();
                }


            }
        });


    }

    private boolean checkerPositif(double[] _tableau){

        boolean bool = true;

        for(int i=0;i<_tableau.length;i++){

            if(_tableau[i]<0){
                Toast.makeText(MainActivity.this, "Veuillez Entrer une valeur positif dans le Input numero " + (i+1), Toast.LENGTH_SHORT).show();
                bool = false;
            }
        }

        return bool;
    }
}