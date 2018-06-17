package com.naiya1.jgs.cashflow;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG="DatabaseHelper";
    private static final String TABLE_NAME="tableName";
    private static final String COL1="customer";
    private static final String COL2="amount";
    //private static final String COL3="transMode";
    //private static final String COL4="Date&Time";


    public DatabaseHelper(Context context){
        super(context,TABLE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable=TABLE_NAME+COL1;
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,int i,int i1){
    db.execSQL(TABLE_NAME);
    onCreate(db);

    }

    public boolean addData(String item){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL2,item);
        Log.d(TAG,item+TABLE_NAME);
        long result=db.insert(TABLE_NAME,null,contentValues);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }
}
