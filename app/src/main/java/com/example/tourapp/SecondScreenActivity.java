package com.example.tourapp;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondScreenActivity extends AppCompatActivity {
    Spinner spinnerMoney, spinnerCountryCode;
    String[] moneyName = {"US$", "INDIA(INR)", "EURO(EUR)", "POUND", "BITCOIN"}, countryCode = {"+1", "+91", "040", "826", "+61"};
    int[] moneyImage = {R.drawable.dollar, R.drawable.ruppes, R.drawable.euro, R.drawable.pound, R.drawable.bitcoin}, countryFlag = {R.drawable.usa_flag, R.drawable.india, R.drawable.europ_flag, R.drawable.england, R.drawable.austrlian_flag};

    //All id
    TextView txtBackArrow, txtSaveButton, txtDeleteAccountButton;
    ImageView imgEditIcon;
    ImageView imgPhoto;
    int CAMERA_PICTURE = 132, GALLERY_CAPTURE = 133;
    EditText edtName, edtPhone, edtPasswordOne, edtConfirmPassword, edtEmail;
    String emailvalidation = "@gmail.com";


    private Dialog dialog;
    private Button ShowDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);
        backPage();
        imageEdit();
        spinnerView();
        countryCodeSpinner();
        save();
        delet();
//        customDialog();

    }

//    private void customDialog() {
//        Dialog dialog;
//        imgEditIcon = findViewById(R.id.imgEditIcon);
//        dialog = new Dialog(SecondScreenActivity.this);
//        dialog.setContentView(R.layout.custom_dialog);
//        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        Button btn_okay = findViewById(R.id.btn_okay);
//        Button btn_cancel = findViewById(R.id.btn_cancel);
//
//        btn_okay.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(SecondScreenActivity.this, "Yes", Toast.LENGTH_SHORT).show();
//            }
//        });
//        btn_cancel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(SecondScreenActivity.this, "No", Toast.LENGTH_SHORT).show();
//            }
//        });
//        dialog.show();
//    }

    private void delet() {
        txtDeleteAccountButton = findViewById(R.id.txtDeleteAccountButton);
        txtDeleteAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtName.getText().clear();
                edtPhone.getText().clear();
                edtPasswordOne.getText().clear();
                edtConfirmPassword.getText().clear();
                edtEmail.getText().clear();
                imgPhoto.setImageResource(R.drawable.man_image);
                Toast.makeText(SecondScreenActivity.this, "Your Data deleted", Toast.LENGTH_SHORT).show();

            }
        });


    }

    private void save() {
        txtSaveButton = findViewById(R.id.txtSaveButton);
        edtName = findViewById(R.id.edtName);
        edtPhone = findViewById(R.id.edtPhone);
        edtPasswordOne = findViewById(R.id.edtPasswordOne);
        edtConfirmPassword = findViewById(R.id.edtConfirmPassword);
        edtEmail = findViewById(R.id.edtEmail);

        txtSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String edtname = edtName.getText().toString();
                String edtphone = edtPhone.getText().toString();
                String edtpasswordone = edtPasswordOne.getText().toString();
                String edtconfirmpassword = edtConfirmPassword.getText().toString();
                String edtemail = edtEmail.getText().toString();


                if (edtname.isEmpty()) {
                    Toast.makeText(SecondScreenActivity.this, "Please Enter UserName", Toast.LENGTH_SHORT).show();
                } else if (edtphone.isEmpty()) {
                    Toast.makeText(SecondScreenActivity.this, "Please Enter phone number", Toast.LENGTH_SHORT).show();
                } else if (!(edtphone.length() == 10)) {
                    Toast.makeText(SecondScreenActivity.this, "phone number required 10 digits", Toast.LENGTH_SHORT).show();
                } else if (edtpasswordone.isEmpty()) {
                    Toast.makeText(SecondScreenActivity.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                } else if (!edtconfirmpassword.equals(edtpasswordone)) {
                    Toast.makeText(SecondScreenActivity.this, "Do not match your password", Toast.LENGTH_SHORT).show();
                } else if (edtemail.isEmpty()) {
                    Toast.makeText(SecondScreenActivity.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
                } else if (!edtemail.endsWith(String.valueOf(emailvalidation))) {
                    Toast.makeText(SecondScreenActivity.this, "email not valid", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SecondScreenActivity.this, "Your data Saved", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void imageEdit() {
        imgEditIcon = findViewById(R.id.imgEditIcon);
        imgPhoto = findViewById(R.id.imgPhoto);
        imgEditIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                startActivityForResult(i, GALLERY_CAPTURE);


                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), GALLERY_CAPTURE);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (resultCode == RESULT_OK) {

            // compare the resultCode with the
            // SELECT_PICTURE constant
            if (requestCode == GALLERY_CAPTURE) {
                // Get the url of the image from data
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                    // update the preview image in the layout
                    imgPhoto.setImageURI(selectedImageUri);


                }
            }
        }
        //        if (resultCode == RESULT_OK) {
//
//            if (requestCode == GALLERY_CAPTURE) {
//
//                Uri selectedImageURI = data.getData();
//                if (null != selectedImageURI) {
//                    imgPhoto.setImageURI(selectedImageURI);
//                }
//            }
//        }
        if (requestCode == CAMERA_PICTURE) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imgPhoto.setImageBitmap(photo);
        }
    }


    private void backPage() {
        txtBackArrow = findViewById(R.id.txtBackArrow);
        txtBackArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void countryCodeSpinner() {
        spinnerCountryCode = findViewById(R.id.spinnerCountryCode);
        CustomCountryCodeAdapterClass adapterClass = new CustomCountryCodeAdapterClass(this, R.layout.spinner_country_code, countryCode, countryFlag);
        spinnerCountryCode.setAdapter(adapterClass);
    }

    private void spinnerView() {
        spinnerMoney = findViewById(R.id.spinnerMoney);

        CustomMoneyAdapterClass adapter = new CustomMoneyAdapterClass(this, R.layout.spinner_money_text, moneyName, moneyImage);
        spinnerMoney.setAdapter(adapter);
    }

}


