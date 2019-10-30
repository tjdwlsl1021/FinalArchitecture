package com.charlezz.javaapp.feature.photo;

import android.arch.lifecycle.LiveData;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PagedList;
import android.content.Context;
import android.database.Cursor;
import android.databinding.BaseObservable;
import android.provider.MediaStore;

import androidx.recyclerview.selection.SelectionTracker;
import lombok.Getter;


@Getter
public class PhotoViewModel extends BaseObservable {

    private LiveData<PagedList<Photo>> photoList;

    public PhotoViewModel(Context context, SelectionTracker<Long> selectionTracker) {
        Cursor cursor = context.getContentResolver().query(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                new String[]{
                        MediaStore.Images.Media.DISPLAY_NAME,
                        MediaStore.Images.Media.DATA
                },
                null,
                null,
                null
        );
        PhotoSourceFactory photoSourceFactory = new PhotoSourceFactory(cursor,selectionTracker);
        photoList = new LivePagedListBuilder<>(photoSourceFactory, 30).build();
    }
}