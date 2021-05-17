package com.xuhuaixin.classshoot;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class ClassFamilyActivity extends AppCompatActivity {

    private RecyclerView mRv;
    private List<Student> mStudents;
    private StudentAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_family);
        mRv = findViewById(R.id.act_class_family_rv);
        mStudents = GreenDaoManager.getInstance().getStudentDao().loadAll();
        mAdapter = new StudentAdapter(R.layout.item_student);
        mAdapter.setList(mStudents);
        mRv.setLayoutManager(new LinearLayoutManager(this));
        mRv.setAdapter(mAdapter);
    }

}