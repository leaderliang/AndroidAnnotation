package com.android.annotation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.android.annotation.runtime.RuntimeAnnotationProcessor;
import com.android.annotation.runtime.RuntimeBind;

/**
 * @author devliang
 */
public class MainActivity extends AppCompatActivity {

    @RuntimeBind(R.id.tv_content)
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RuntimeAnnotationProcessor.bindView(this);
        mTextView.setText("运行时注解成功");

    }
}
