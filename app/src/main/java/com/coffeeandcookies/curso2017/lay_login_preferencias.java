package com.coffeeandcookies.curso2017;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Gonzalo on 31/05/2017.
 */

public class lay_login_preferencias extends AppCompatActivity
{
    EditText editText_usuario;
    EditText editText_pass;
    Button button_login;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lay_login);
        findViews();
        setEvents();
        setUsuario();
    }

    void findViews()
    {
        editText_usuario = (EditText)findViewById(R.id.editText_usuario);
        editText_pass = (EditText)findViewById(R.id.editText_pass);
        button_login = (Button) findViewById(R.id.button_login);
    }

    void setEvents()
    {
        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                //primero verificar si ingreso algo
                if (editText_usuario.getText().toString().length()==0)
                {
                    Toast.makeText(lay_login_preferencias.this, "Ingrese un usuario...", Toast.LENGTH_SHORT).show();
                }
                else
                    if (editText_pass.getText().toString().length()==0)
                    {
                        Toast.makeText(lay_login_preferencias.this, "Ingrese un contra...", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        //segundo verifico que el usuario existe o no...
                        SharedPreferences misPreferencias = getSharedPreferences("usuario", Context.MODE_PRIVATE);
                        String usuarioPreferencias = misPreferencias.getString("user","");
                        if (usuarioPreferencias.equals(""))
                        {
                            Toast.makeText(lay_login_preferencias.this, "Bienvenido...", Toast.LENGTH_SHORT).show();

                            SharedPreferences.Editor editor = misPreferencias.edit();
                            editor.putString("user",editText_usuario.getText().toString());
                            editor.putString("pass",editText_pass.getText().toString());
                            editor.commit();

                            lanzarBienvenida();
                        }
                        else
                        {
                            if (usuarioPreferencias.equals(editText_usuario.getText().toString()))
                            {
                                String passPreferencia = misPreferencias.getString("pass","");
                                if (passPreferencia.equals(editText_pass.getText().toString()))
                                {
                                    lanzarBienvenida();
                                }
                                else
                                {
                                    Toast.makeText(lay_login_preferencias.this, "Mal el pass", Toast.LENGTH_SHORT).show();
                                }
                            }
                            else
                            {
                                Toast.makeText(lay_login_preferencias.this, "Mal el usuario", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
            }
        });
    }

    void lanzarBienvenida()
    {
        Intent intent = new Intent(lay_login_preferencias.this,lay_bienvenido_preferencias.class);
        intent.putExtra("nombre",editText_usuario.getText().toString());
        startActivity(intent);
    }

    void setUsuario()
    {
        SharedPreferences misPreferencias = getSharedPreferences("usuario",Context.MODE_PRIVATE);
        String usuario = misPreferencias.getString("user","");
        if (!usuario.equals(""))
        {
            editText_usuario.setText(usuario);
        }
    }
}
