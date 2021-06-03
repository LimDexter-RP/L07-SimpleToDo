package sg.edu.rp.c346.id20039529.l07_simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText etToDo;
    Button btnAdd;
    Button btnClear;
    ListView lvToDo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etToDo = findViewById(R.id.editTextToDo);
        btnAdd = findViewById(R.id.buttonAdd);
        btnClear = findViewById(R.id.buttonClear);
        lvToDo = findViewById(R.id.ListViewToDo);

        ArrayList <String> alToDo = new ArrayList<>();
        ArrayAdapter<String> aaToDo = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, alToDo);

        lvToDo.setAdapter(aaToDo);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ToDo = etToDo.getText().toString();
                alToDo.add(ToDo);
                aaToDo.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "Item Added", Toast.LENGTH_SHORT).show();
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alToDo.clear();
                aaToDo.notifyDataSetChanged();
                Toast.makeText(MainActivity.this,"Items Cleared", Toast.LENGTH_SHORT).show();
            }
        });
    }
}