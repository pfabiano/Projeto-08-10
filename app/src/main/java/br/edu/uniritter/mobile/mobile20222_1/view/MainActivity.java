package br.edu.uniritter.mobile.mobile20222_1.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import br.edu.uniritter.mobile.mobile20222_1.R;
import br.edu.uniritter.mobile.mobile20222_1.adapter.UsersAddapter;
import br.edu.uniritter.mobile.mobile20222_1.model.User;
import br.edu.uniritter.mobile.mobile20222_1.repository.UserRepository;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private final String TAG = "MainActivity";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: começando a bagaça");

        //aqui infla o layout xml
        setContentView(R.layout.activity_main);

        /*(R.id.botao).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Activity2.class);
                startActivity(intent);
            }
        });
        */
        //findViewById(R.id.botao).setOnClickListener( this );
        View.OnClickListener ocl = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: Alguém clicou ocl");
                Intent intent = new Intent(view.getContext(), br.edu.uniritter.mobile.mobile20222_1.view.Activity2.class);
                intent.putExtra("userId", 1);


                startActivity(intent);
            }
        };
        //buscando um elemento visual do layout para manuipulação
        Button bt  = findViewById(R.id.button02);

        findViewById(R.id.button02).setOnClickListener( ocl );
        findViewById(R.id.botao).setOnClickListener(
                (view) -> {
                    Log.d(TAG, "onClick: Alguém clicou lambda");

                    Intent intent = new Intent(view.getContext(), br.edu.uniritter.mobile.mobile20222_1.view.Activity2.class);
                    startActivity(intent);
                });
        RecyclerView rc = findViewById(R.id.recycler1);
        UsersAddapter adapter = new UsersAddapter( UserRepository.getInstance(this).getUsers());
        rc.setAdapter(adapter);
        LinearLayoutManager llm1 = new LinearLayoutManager(this);
        rc.setLayoutManager(llm1);


        //int id = getIntent().getIntExtra("userId",-1);
        //User user = UserRepository.getInstance().getUserById(id);
        //troquei de envio de id int para objeto
        User user = getIntent().getParcelableExtra("userObj");

        TextView tv = (TextView) findViewById(R.id.editTextTextPersonName2);
        tv.setText("bem vindo "+user.getName()+"("+user.getPassword()+")");

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button02) {
            Intent intent = new Intent(view.getContext(), br.edu.uniritter.mobile.mobile20222_1.view.Activity2.class);
            startActivity(intent);
        }
    }
}