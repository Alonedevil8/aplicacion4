package com.example.andres.aplication4;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.Calendar;


public class MainActivity4 extends AppCompatActivity {

    private String usuario, contrasena, recontrasena, correoEl, sexo, hobbies;
    private static String fechanac;

    TextView respuestaid;
    EditText eCorreo, erContrasena, eContrasena, eUsuario;
    RadioButton rmasculino, rfemenino;
    CheckBox futbolid, natacionid, videojid, cineid;
    Spinner lNacimiento;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        respuestaid = (TextView) findViewById(R.id.respuestaid);
        eUsuario = (EditText) findViewById(R.id.eUsuario);
        eContrasena = (EditText) findViewById(R.id.eContrasena);
        erContrasena = (EditText) findViewById(R.id.erContrasena);
        eCorreo = (EditText) findViewById(R.id.eCorreo);
        lNacimiento= (Spinner) findViewById(R.id.lNacimiento);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Ciudad, android.R.layout.simple_spinner_item);

        lNacimiento.setAdapter(adapter);
    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datepicker");
    }


    public void onButtonclicked(View view) {

        usuario = eUsuario.getText().toString();
        contrasena = eContrasena.getText().toString();
        recontrasena = erContrasena.getText().toString();
        correoEl = eCorreo.getText().toString();

        if (contrasena.equals(recontrasena)) {
            respuestaid.setText("usuario: " + usuario + " contraseña: " + contrasena + " correo: " + correoEl + " fecha nacimiento: " + fechanac
            +" lugar de nacimiento: "+lNacimiento+" sexo: "+sexo+" Hobbies: "+hobbies);
        } else
            Toast.makeText(getApplicationContext(), "contraseña no coincide", Toast.LENGTH_SHORT).show();

    }


    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.rmasculino:
                if (checked)
                    sexo = "Masculino";
                break;

            case R.id.rfemenino:
                if (checked)
                    sexo = "Masculino";
                break;
        }
    }


    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {

            case R.id.futbolid:
                if (checked)
                    hobbies = "Futbol";
               break;

            case R.id.natacionid:
                if (checked)
                    hobbies = "Natacion";
                break;

            case R.id.cineid:
                if (checked)
                hobbies = "Cine";
                break;

            case R.id.videojid:
                if (checked)
                hobbies=" Videojuegos";
                break;

        }
    }


    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {


        public Dialog onCreateDialog(Bundle savedInstanceState) {

            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            fechanac = String.valueOf(day) + "/" + String.valueOf(month) + "/" + String.valueOf(year);
        }
    }


}
















