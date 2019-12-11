package com.example.duanbvq.database;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.duanbvq.model.Ghinho;
import com.example.duanbvq.model.OnTap;
import com.example.duanbvq.model.QuyDinh;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class DataBaseHelper1 extends SQLiteOpenHelper {
    private static String TAG = "DataBaseHelper1"; // Tag just for the LogCat window
    //destination path (location) of our database on device
    private static String DB_PATH = "";
    private static String DB_NAME = "ontap.db";// Database name
    private SQLiteDatabase mDataBase;
    private final Context mContext;
    private String TABLE1="ONTAP";
    private String ID="id";
    private String TITLE="title";
    private String TABLE2="QuyDinh";
    private String ID1="id";
    private String THISID="thisid";
    private String TITLE2="title";
    private String CONTENT="content";

    private void copyDataBase() throws IOException {
        InputStream mInput = mContext.getAssets().open(DB_NAME);
        String outFileName = DB_PATH + DB_NAME;
        OutputStream mOutput = new FileOutputStream(outFileName);
        byte[] mBuffer = new byte[1024];
        int mLength;
        while ((mLength = mInput.read(mBuffer)) > 0) {
            mOutput.write(mBuffer, 0, mLength);
        }
        mOutput.flush();
        mOutput.close();
        mInput.close();
    }
    public void createDataBase() {
        //If the database does not exist, copy it from the assets.

        boolean mDataBaseExist = checkDataBase();
        if (!mDataBaseExist) {
            this.getReadableDatabase();
            this.close();
            try {
                //Copy the database from assests
                copyDataBase();
                Log.e(TAG, "createDatabase database created");
            } catch (IOException mIOException) {
                throw new Error("ErrorCopyingDataBase");
            }
        }
    }
    private boolean checkDataBase() {
        File dbFile = new File(DB_PATH + DB_NAME);
        //Log.v("dbFile", dbFile + "   "+ dbFile.exists());
        return dbFile.exists();
    }
    public boolean openDataBase() throws SQLException {
        String mPath = DB_PATH + DB_NAME;
        //Log.v("mPath", mPath);
        mDataBase = SQLiteDatabase.openDatabase(mPath, null, SQLiteDatabase.CREATE_IF_NECESSARY);
        //mDataBase = SQLiteDatabase.openDatabase(mPath, null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
        return mDataBase != null;
    }
    @Override
    public synchronized void close() {
        if (mDataBase != null)
            mDataBase.close();
        super.close();
    }


    public DataBaseHelper1(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, Context mContext) {
        super(context, name, factory, version);
        this.mContext = mContext;
    }

    public DataBaseHelper1(Context context) {
        super(context, DB_NAME, null, 1);
        if (android.os.Build.VERSION.SDK_INT >= 17) {
            DB_PATH = context.getApplicationInfo().dataDir + "/databases/";
        } else {
            DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";
        }
        this.mContext = context;
    }

public ArrayList<OnTap> getAllOnTap(){
    ArrayList<OnTap> onTaps=new ArrayList<>();
    SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
    String SQL = "SELECT * FROM " + TABLE1 ;

    Cursor cursor = sqLiteDatabase.rawQuery(SQL, null);
    Log.e("sdasda",cursor.getCount()+"");
    if (cursor != null) {
        if (cursor.getCount() > 0) {

            cursor.moveToFirst();

            while (!cursor.isAfterLast()) {

                OnTap onTap = new OnTap() ;


                onTap.id=cursor.getInt(cursor.getColumnIndex(ID));
                onTap.title=cursor.getString(cursor.getColumnIndex(TITLE));
                onTaps.add(onTap);

                cursor.moveToNext();

            }
            cursor.close();
        }
    }
    return onTaps;
}
    public ArrayList<QuyDinh> getAllQuyDinh(String id){
        ArrayList<QuyDinh> quyDinhs=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        String SQL = "SELECT * FROM " + TABLE2 +" where id='" + id + "'" ;

        Cursor cursor = sqLiteDatabase.rawQuery(SQL, null);
        Log.e("sdasda",cursor.getCount()+"");
        if (cursor != null) {
            if (cursor.getCount() > 0) {

                cursor.moveToFirst();

                while (!cursor.isAfterLast()) {

                    QuyDinh quyDinh = new QuyDinh();

                    quyDinh.thisid=cursor.getInt(cursor.getColumnIndex(THISID));
                    quyDinh.id=cursor.getInt(cursor.getColumnIndex(ID));
                    quyDinh.title=cursor.getString(cursor.getColumnIndex(TITLE));
                    quyDinh.content=cursor.getString(cursor.getColumnIndex(CONTENT));
                    quyDinhs.add(quyDinh);

                    cursor.moveToNext();

                }
                cursor.close();
            }
        }
        return quyDinhs;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
