package com.example.lab1_serializable_getset_elmehdi_arkhis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    //Variable Global

    //Deuxieme block------------------------
    private EditText txtHypothec;
    private EditText txtPretAuto;
    private EditText txtPretPerso;
    private EditText txtCarteCredit;
    private EditText txtPretEtud;
    private EditText txtSoutienEnf;
    private EditText txtChalet;
    private EditText txtMoto;
    private EditText txtElectrom;
    private EditText txtTotalPaieMens;
    private EditText txtRatioEndett;

    private EditText txtTotalRevMens;

    private Button btnCalcul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Deuxieme block------------------------
        txtHypothec = (EditText) findViewById(R.id.txtHypothecID);
        txtPretAuto = (EditText) findViewById(R.id.txtPretAutoID);
        txtPretPerso = (EditText) findViewById(R.id.txtPretPersoID);
        txtCarteCredit = (EditText) findViewById(R.id.txtCarteCreditID);
        txtPretEtud = (EditText) findViewById(R.id.txtPretEtudID);
        txtSoutienEnf = (EditText) findViewById(R.id.txtSoutienEnfID);
        txtChalet = (EditText) findViewById(R.id.txtChaletID);
        txtMoto = (EditText) findViewById(R.id.txtMotoID);
        txtElectrom = (EditText) findViewById(R.id.txtElectromID);
        txtTotalPaieMens = (EditText) findViewById(R.id.txtTotalPaieMensID);
        txtRatioEndett = (EditText) findViewById(R.id.txtRatioEndettID);

        txtTotalRevMens = (EditText) findViewById(R.id.txtTotalRevMensID);

        btnCalcul = (Button) findViewById(R.id.btnCalculID);

        btnCalcul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Recuperer les infos de l'Intent
                RevenueC revenue = (RevenueC) getIntent().getSerializableExtra("a1.revenu");

                //Deuxieme block------------------------
                //Tableau pour verifier le negatif
                double[] tabPaiement = new double[9];
                //Get
                double Hypothec = Double.parseDouble(txtHypothec.getText().toString());
                double PretAuto = Double.parseDouble(txtPretAuto.getText().toString());
                double PretPerso = Double.parseDouble(txtPretPerso.getText().toString());
                double CarteCredit= Double.parseDouble(txtCarteCredit.getText().toString());
                double PretEtud= Double.parseDouble(txtPretEtud.getText().toString());
                double SoutienEnf= Double.parseDouble(txtSoutienEnf.getText().toString());
                double Chalet= Double.parseDouble(txtChalet.getText().toString());
                double Moto= Double.parseDouble(txtMoto.getText().toString());
                double Electrom= Double.parseDouble(txtElectrom.getText().toString());

                tabPaiement[0] = Hypothec;
                tabPaiement[1] = PretAuto;
                tabPaiement[2] = PretPerso;
                tabPaiement[3] = CarteCredit;
                tabPaiement[4] = PretEtud;
                tabPaiement[5] = SoutienEnf;
                tabPaiement[6] = Chalet;
                tabPaiement[7] = Moto;
                tabPaiement[8] = Electrom;

                if(checkerPositif(tabPaiement)==false){
                    return;
                }

                //Set_1
                double TotalRevMens = revenue.revenuTotal(); //Fonction creer dans la class
                //On Pouvait utiliser : double TotalRevMens=getSalMensuel()+getPensAlim()+getRevMens();
                double TotalRevMensRounded = Math.round(TotalRevMens*100.0)/100.0;
                txtTotalRevMens.setText(String.valueOf(TotalRevMensRounded));



                //Set_2
                double TotalPaieMens = Hypothec+PretAuto+PretPerso+CarteCredit+PretEtud+SoutienEnf+Chalet+Moto+Electrom;
                double TotalPaieMensRounded = Math.round(TotalPaieMens*100.0)/100.0;
                txtTotalPaieMens.setText(String.valueOf(TotalPaieMensRounded));

                //Set_3_Ratio
                double RatioEndett= (TotalRevMensRounded/TotalPaieMensRounded)*100.0;
                double RatioEndettRounded = Math.round(RatioEndett*100.0)/100.0;
                txtRatioEndett.setText(String.valueOf(RatioEndettRounded));

            }
        });
    }

    private boolean checkerPositif(double[] _tableau){

        boolean bool = true;

        for(int i=0;i<_tableau.length;i++){

            if(_tableau[i]<0){
                Toast.makeText(MainActivity2.this, "Veuillez Entrer une valeur positif dans le Input numero " + (i+1), Toast.LENGTH_SHORT).show();
                bool = false;
            }
        }

        return bool;
    }

}