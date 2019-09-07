package com.example.contact.Fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.example.contact.MainActivity;
import com.example.contact.Model.Contact;
import com.example.contact.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileSetting extends AppCompatActivity {

    public static final int PICK_IMAGE = 1;

    private EditText namaEditText, emailEditText;
    private CircleImageView profilePicture;
    private Button saveBtn;
    private Spinner jabatanSpinner;
    private RadioGroup genderRadio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_setting);

        namaEditText = findViewById(R.id.nama_profile);
        emailEditText = findViewById(R.id.email_profile);
        profilePicture = findViewById(R.id.profile_add_picture);
        jabatanSpinner = findViewById(R.id.spinner_profile_jabatan);
        genderRadio = findViewById(R.id.radio_jenis_profile);
        saveBtn = findViewById(R.id.btn_save_profile);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
            }
        });

        profilePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickFromGallery();
            }
        });



    }

    private void insertData() {
        String nama = namaEditText.getText().toString();
        String email = emailEditText.getText().toString();
        int selectedRadio = genderRadio.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(selectedRadio);
        String jenisKelamin = radioButton.getText().toString();
        String jabatan = jabatanSpinner.getSelectedItem().toString();
        Bitmap gambar = ((BitmapDrawable) profilePicture.getDrawable()).getBitmap();
        MainActivity.dataContact.add(new Contact(nama, email, jenisKelamin, jabatan, gambar));
        onBackPressed();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (resultCode == Activity.RESULT_OK)
            switch (requestCode){
                case PICK_IMAGE:
                    //data.getData returns the content URI for the selected Image
                    Uri selectedImage = data.getData();
                    profilePicture.setImageURI(selectedImage);
                    break;
            }

    }

    private void pickFromGallery(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);
    }
}
