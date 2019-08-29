package com.example.SocialNetworkClone;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

public class UserSelectActivity extends AppCompatActivity {

    Toolbar toolbar;
    TextView toolBarTitle;
    ImageView closeImage;
    ImageView acceptImage;
    RadioGroup radioGroup_item;

    String itemcheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_select);

        CreateWidget();

        /* toolbar icon left */
        closeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Close();
            }
        });

        /* toolbar icon right */
        acceptImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDataChange();
            }
        });

    }

    /* mapping and custom toolbar */
    public void CreateWidget() {
        toolbar = findViewById(R.id.toolbar);

        toolBarTitle = toolbar.findViewById(R.id.toolbarTitle);
        toolBarTitle.setText("User Select");
        closeImage = toolbar.findViewById(R.id.imgStart);
        closeImage.setImageResource(R.drawable.ic_close_x);
        acceptImage = toolbar.findViewById(R.id.reset);
        acceptImage.setImageResource(R.drawable.ic_done_black_24dp);

        radioGroup_item = findViewById(R.id.radioGroup);
    }

    /* close alert dialog custom*/
    public void Close() {
        AlertDialog.Builder builder = new AlertDialog.Builder(UserSelectActivity.this);

        builder.setTitle("Close");
        builder.setIcon(R.drawable.ic_close_x);

        builder.setMessage("Do you want close User Select?");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                onBackPressed();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    /* getdata and passing to feedFragment */
    public void getDataChange() {

        int idItem = radioGroup_item.getCheckedRadioButtonId();
        switch (idItem) {
            case R.id.radioButton_item1:
                itemcheck = "Daniel Nguyen";
                break;
            case  R.id.radioButton_item2:
                itemcheck = "Justin Bieber";
                break;
            case R.id.radioButton_item3:
                itemcheck = "Leonardo Dicaprio";
                break;
        }

        /* create bundle to put data and passing to MainActivity*/
        Intent intent = new Intent(UserSelectActivity.this, MainActivity.class);
        Bundle bundle = new Bundle();

        bundle.putString("id", itemcheck);
        intent.putExtras(bundle);

        startActivity(intent);
        finish();
    }

    /* custom back button */
    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent intent = new Intent(UserSelectActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
