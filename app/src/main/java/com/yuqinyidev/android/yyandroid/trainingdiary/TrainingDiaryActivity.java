package com.yuqinyidev.android.yyandroid.trainingdiary;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.yuqinyidev.android.yyandroid.R;
import com.yuqinyidev.android.yyandroid.trainingdiary.presenter.UserPresenter;
import com.yuqinyidev.android.yyandroid.trainingdiary.view.IUserView;

public class TrainingDiaryActivity extends AppCompatActivity implements View.OnClickListener, IUserView {
    UserPresenter presenter;
    EditText id, first, last;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_diary);

        findViewById(R.id.save).setOnClickListener(this);
        findViewById(R.id.load).setOnClickListener(this);
        id = (EditText) findViewById(R.id.id);
        first = (EditText) findViewById(R.id.first);
        last = (EditText) findViewById(R.id.last);

        presenter = new UserPresenter(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.save:
                presenter.saveUser(getID(), getFristName(), getLastName());
                break;
            case R.id.load:
                presenter.loadUser(getID());
                break;
            default:
                break;
        }
    }

    @Override
    public int getID() {
        return new Integer(id.getText().toString());
    }

    @Override
    public String getFristName() {
        return first.getText().toString();
    }

    @Override
    public String getLastName() {
        return last.getText().toString();
    }

    @Override
    public void setFirstName(String firstName) {
        first.setText(firstName);
    }

    @Override
    public void setLastName(String lastName) {
        last.setText(lastName);
    }
}
