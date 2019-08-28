package py.edu.facitec.oscar.paises;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText nameEditText;
    EditText codeEditText;
    PaisDao paisDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //inicializamos los componentes del layout
        nameEditText = findViewById(R.id.editTextName);
        codeEditText = findViewById(R.id.editTextCode);
        //inicializamos el dao
        paisDao = new PaisDao(MainActivity.this);

    }

    public void guardarPais(View view) {
        //Validar que no guarde vacio
        //Validar que no se repita
        //Validar que code tenga 3 letras

        Pais pais = new Pais();
        pais.setName(nameEditText.getText().toString());
        pais.setCode(codeEditText.getText().toString());

        if(pais.getName().isEmpty()){
            nameEditText.setError(getString(R.string.error_name));
            return;
        }
        if(pais.getCode().length()!=3){
            codeEditText.setError(getString(R.string.error_code));
            return;
        }

        Pais result = paisDao.guardar(pais);
        if(result==null){
            Toast.makeText(this,R.string.error_unique,Toast.LENGTH_LONG).show();
            //setError en los campos
            return;
        }

        nameEditText.setText(null);
        codeEditText.setText(null);

        List<Pais> paises = paisDao.obtenerTodos();

        Toast.makeText(this, paises.toString(), Toast.LENGTH_LONG).show();

    }
}
