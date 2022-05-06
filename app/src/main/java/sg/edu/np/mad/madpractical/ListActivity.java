package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ImageView midIcon = (ImageView) findViewById(R.id.imageA);
        midIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog alert = createAlert();
                alert.show();
            }
        });
    }

    public AlertDialog createAlert(){
        AlertDialog.Builder builder = new AlertDialog.Builder(ListActivity.this);

        builder.setTitle("Profile");
        builder.setMessage("MADness");
        builder.setCancelable(true);
        builder.setNegativeButton("CLOSE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //action
            }
        });
        builder.setPositiveButton("VIEW", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Random rand = new Random();
                Integer genInt = Math.abs(rand.nextInt());
                Intent act = new Intent(ListActivity.this,MainActivity.class);
                act.putExtra("genInt",genInt);
                startActivity(act);
            }
        });
        AlertDialog alert = builder.create();
        return alert;
    }
}