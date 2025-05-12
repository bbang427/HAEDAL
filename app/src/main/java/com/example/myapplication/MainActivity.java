package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText email;
    EditText password;
    Button emailLoginButton;

    FirebaseAuth mAuth=FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 안드로이드 프로그램에서 기본적으로 준비한 코드
        super.onCreate(savedInstanceState);
        // 시스템 바 무시
        EdgeToEdge.enable(this);
        // 내가 현재 엑티비티에서 ~~ 디자인된 화면을 쓰겠다
        setContentView(R.layout.activity_main);

        // 변수랑 뷰를 연결해준다
        email = findViewById(R.id.email_editText);
        password = findViewById(R.id.password_editText);
        emailLoginButton = findViewById(R.id.email_login_button);


        // 버튼.리스너 설정( 리스너 )
        emailLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            // edittextview에서 텍스트 추출
                String emailText = email.getText().toString();
                String passWordText = password.getText().toString();


                mAuth.signInWithEmailAndPassword(emailText, passWordText).addOnCompleteListener(task->{
                    if(task.isSuccessful()){
                        FirebaseUser user = mAuth.getCurrentUser();
                        // 화면변환 activity 변환         context
                        // context란 현재 앱 내에서 내가 어떤 위치에 있는지
                        //                                          context          내가 이동할 클래스
                        Intent intent = new Intent(MainActivity.this, HomeActivity.class);

                        // intent에 있는 정보를 통해서 엑티비티를 실행하겠다
                        startActivity(intent);
                        // 현재 엑티비티는 종료하겠다
                        finish();
                    }
                    else{
                        mAuth.createUserWithEmailAndPassword(emailText,passWordText).addOnCompleteListener(task1->{
                            if(task1.isSuccessful()) {
                                FirebaseUser user = mAuth.getCurrentUser();
                                // 화면변환 activity 변환         context
                                // context란 현재 앱 내에서 내가 어떤 위치에 있는지
                                //                                          context          내가 이동할 클래스
                                Intent intent = new Intent(MainActivity.this, HomeActivity.class);

                                // intent에 있는 정보를 통해서 엑티비티를 실행하겠다
                                startActivity(intent);
                                // 현재 엑티비티는 종료하겠다
                                finish();
                            }
                            else{
                                Toast.makeText(MainActivity.this,"실패",Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
            }
        });
    }
}