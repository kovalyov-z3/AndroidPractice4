package ru.mirea.kovalyov.loadermanager;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.loader.content.AsyncTaskLoader;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MyLoader extends AsyncTaskLoader<String> {

    String text;

    static String s = "";
    public MyLoader(@NonNull Context context, Bundle bundle) {
        super(context);
        if (bundle != null)
            text = bundle.getString(s);
    }
    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public String loadInBackground() {
        List<String> stringList = Arrays.asList(text.split(""));
        Collections.shuffle(stringList);
        StringBuilder sb = new StringBuilder();
        stringList.forEach(s -> sb.append(s));
        return sb.toString();
    }
}