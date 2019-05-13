package com.example.lab3_final;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Dao extends AppCompatActivity {
    private SQLiteDatabase database;

    public Dao(Context context) {
        database = context.openOrCreateDatabase("lab3.db", MODE_PRIVATE, SQLiteCursor::new);
        database.execSQL("CREATE TABLE IF NOT EXISTS data (input TEXT, answer TEXT)");
    }

    public String create(Dto dto) {
        database.execSQL("INSERT INTO data values ('"+dto.text+"', '"+dto.answer+"')");
        return "Data inserted";
    }

    public List<Dto> findAll() {
        List<Dto> resultList = new ArrayList<>();
        Cursor dtoCursor = database.rawQuery("select * from data", null);
        if(dtoCursor.moveToFirst()) {
            do {
                Dto dto = new Dto(dtoCursor.getString(0), dtoCursor.getString(1));
                resultList.add(dto);
            } while (dtoCursor.moveToNext());
        }

        return resultList;
    }


}
