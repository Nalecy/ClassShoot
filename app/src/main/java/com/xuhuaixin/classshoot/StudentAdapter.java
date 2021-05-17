package com.xuhuaixin.classshoot;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import org.jetbrains.annotations.NotNull;

/**
 * author:
 * date: 2021/5/17
 */
public class StudentAdapter extends BaseQuickAdapter<Student, BaseViewHolder> {

    public StudentAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, Student student) {
        baseViewHolder.setText(R.id.item_tv_name, student.name)
                        .setText(R.id.item_tv_nativePlace, student.nativePlace);
    }
}
