package com.example.syallbus;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.io.Serializable;

public class MainActivity extends Activity   {
    String selectedBranch;
    String selectedSem;
    StringBuilder file;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapterSpinner = ArrayAdapter.createFromResource(this,
                R.array.Branch, android.R.layout.simple_spinner_item);
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapterSpinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedBranch=spinner.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                selectedBranch=spinner.getSelectedItem().toString();

            }
        });

//spinner

        final Spinner spinnerSem = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.sem, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSem.setAdapter(adapter);
        spinnerSem.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedSem=spinnerSem.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                selectedSem=spinnerSem.getSelectedItem().toString();

            }

        });

        Button submit = (Button) findViewById(R.id.button);
        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                switch (selectedBranch) {
                    case "Computer Science":
                        file=new StringBuilder("computer/");
                        selectedsem(file);
                        break;
                    case "Civil":

                        file=new StringBuilder("civil/");
                        selectedsem(file);
                        break;
                    case "Electrical":
                        file=new StringBuilder("electrical/");
                        selectedsem(file);
                        break;
                    case "Mechnical":
                        file=new StringBuilder("mechnical/");
                        selectedsem(file);
                        break;
                    case "Electronics":
                        file=new StringBuilder("electronics/");
                        selectedsem(file);
                        break;
                    default:
                        file=new StringBuilder("civil/");
                        selectedsem(file);
                        break;
                }
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("branch",selectedBranch);
                intent.putExtra("sem",selectedSem);
                intent.putExtra("file", (Serializable) file);

                startActivity(intent);

            }
        });
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder b1 = new AlertDialog.Builder(MainActivity.this);
        b1.setCancelable(false);
        b1.setMessage("are you sure to exit");
        b1.setPositiveButton("NO", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                startActivity(getIntent());
                MainActivity.this.finish();
            }
        });
        b1.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                MainActivity.this.finish();
            }
        });
        b1.show();
    }


    private StringBuilder selectedsem(StringBuilder sb) {
  switch (selectedSem){
      case "1st semester":
          file.append("1st.txt");
          break;
      case "2nd semester":
          sb.append("2nd.txt");
          break;
      case "3rd semester":
          sb.append("3rd.txt");
          break;
      case "4th semester":
          sb.append("4th.txt");
          break;
      case "5th semester":
          sb.append("5th.txt");
          break;
      case "6th semester":
          sb.append("6th.txt");
          break;
      case "7th semester":
          sb.append("7th.txt");
          break;
      case "8th semester":
          sb.append("8th.txt");
          break;

  }
  return file;
    }

}

