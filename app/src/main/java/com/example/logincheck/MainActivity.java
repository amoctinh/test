package com.example.logincheck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText edttaikhoan, edtmatkhau;
    Button btndangnhap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
       /* Intent it=new Intent(MainActivity.this,BMI.class);
        startActivity(it);
       */  /* liên kết sang class BMI mở layout bên BMI */

        edttaikhoan = (EditText) findViewById(R.id.edttaikhoan);
        edtmatkhau = (EditText) findViewById(R.id.edtmatkhau);
        btndangnhap = (Button) findViewById(R.id.btndangnhap);



        btndangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tk = edttaikhoan.getText().toString();
                String mk = edtmatkhau.getText().toString();


                if (tk.length() > 0) {

                    if (mk.length() > 6) {


                        Pattern numberPat = Pattern.compile("\\d+");
                        Matcher matcher1 = numberPat.matcher(mk);

                        Pattern stringPat = Pattern.compile("", Pattern.CASE_INSENSITIVE);
                        Matcher matcher2 = stringPat.matcher(mk);

                        if (matcher1.find() && matcher2.find()) {


                            Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
                            Matcher m = p.matcher(mk);
                            boolean b = m.find();
                            if (b) {
                                Toast.makeText(MainActivity.this, "Đăng nhập thành công", Toast.LENGTH_LONG).show();

                                /* liên kết sang class BMI mở layout bên BMI */
                                Intent it = new Intent(MainActivity.this, DangXuat.class);
                                startActivity(it);
                            } else {
                                Toast.makeText(MainActivity.this, "vui lòng nhập mật khẩu có ít nhất 1  ký tự đặc biệt ", Toast.LENGTH_LONG).show();
                            }
                        } else {
                            Toast.makeText(MainActivity.this, "vui lòng nhập mật khẩu có ít nhất 1 chữ số ", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(MainActivity.this, "vui lòng nhập mật khẩu  >6 ký tự  ", Toast.LENGTH_LONG).show();
                    }
                }
                else Toast.makeText(MainActivity.this, "vui lòng nhập tài khoản", Toast.LENGTH_LONG).show();
            }
        });


    }
}