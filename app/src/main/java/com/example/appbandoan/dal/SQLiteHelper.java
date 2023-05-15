package com.example.appbandoan.dal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.example.appbandoan.model.Donhang;
import com.example.appbandoan.model.Giohang;
import com.example.appbandoan.model.Item;
import com.example.appbandoan.model.taikhoan;
import java.util.ArrayList;
import java.util.List;

public class SQLiteHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "login.db";

    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE user(ID INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, password TEXT, email TEXT,gioitinh TEXT,diachi TEXT,sdt TEXT, mota TEXT,chucvi TEXT,tuoi TEXT)");
        db.execSQL("CREATE TABLE monan(ID INTEGER PRIMARY KEY AUTOINCREMENT,username TEXT,img TEXT, title TEXT, category TEXT, price TEXT, diachi TEXT, mota TEXT, date TEXT)");
        db.execSQL("CREATE TABLE thongbao(ID INTEGER PRIMARY KEY AUTOINCREMENT,tieude TEXT, noidung TEXT,mota TEXT, date TEXT)");
        db.execSQL("CREATE TABLE giohang(ID INTEGER PRIMARY KEY AUTOINCREMENT,username TEXT,imgsp TEXT, idsp TEXT,tensp TEXT,giasp TEXT,soluongsp TEXT)");
        db.execSQL("CREATE TABLE donhang(ID INTEGER PRIMARY KEY AUTOINCREMENT,username TEXT, idmonan TEXT,nammonan TEXT,giamonan TEXT,soluongmonan TEXT, diachinhan TEXT,ghichu TEXT, date TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }//longnguyen

    public boolean Insert(String username, String password,String email, String gioitinh, String diachi, String sdt, String tuoi){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        contentValues.put("email", email);
        contentValues.put("gioitinh", gioitinh);
        contentValues.put("diachi", diachi);
        contentValues.put("sdt", sdt);
        contentValues.put("tuoi", tuoi);
        String chucvi="nguoimua";
        String mota="chuaco";
        contentValues.put("mota", mota);
        contentValues.put("chucvi", chucvi);
        long result = sqLiteDatabase.insert("user", null, contentValues);
        if(result == -1){
            return false;
        }else{
            Log.e(" Test "," Luu thanh cong "+" " +username+" "+ password);
            return true;
        }
        //long
        //trung
    }
    public boolean Insertitem(int img,String username,String title,String category,String price,String diachi,String mota,String date){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("img", img);
        contentValues.put("username", username);
        contentValues.put("title", title);
        contentValues.put("category", category);
        contentValues.put("price",price);
        contentValues.put("diachi", diachi);
        contentValues.put("mota", mota);
        contentValues.put("date", date);
        Log.e("Test", img+ " "+title+" "+category+" "+price+" d"+diachi+" " +mota+" "+date);
        long result = sqLiteDatabase.insert("monan", null, contentValues);
        if(result == -1){
            Log.e("Test"," that bai");
            return false;
        }else{
            Log.e("Test"," thanhcong");
            return true;
        }
    }
    public boolean Insertthongbao(String tieude, String noidung, String mota,String date){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("tieude", tieude);
        contentValues.put("noidung", noidung);
        contentValues.put("mota", mota);
        contentValues.put("date",date);
        long result = sqLiteDatabase.insert("thongbao", null, contentValues);
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }
    public boolean Insertgiohang( String username,int imgsp, String idsp, String tensp, String giasp, String soluongsp){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("idsp", idsp);
        contentValues.put("soluongsp", soluongsp);
        contentValues.put("imgsp",imgsp);
        contentValues.put("tensp",tensp);
        contentValues.put("giasp",giasp);
        long result = sqLiteDatabase.insert("giohang", null, contentValues);
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }
    public boolean Inserttdonhang(String username,String idmonan,String nammonan,String giamonan ,String soluongmonan,String diachinhan,String  ghichu,String date) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",username );
        contentValues.put("idmonan", idmonan);
        contentValues.put("nammonan", nammonan);
        contentValues.put("giamonan", giamonan);
        contentValues.put("soluongmonan", soluongmonan);
        contentValues.put("diachinhan", diachinhan);
        contentValues.put("ghichu", ghichu);
        contentValues.put("date", date);
        long result = sqLiteDatabase.insert("donhang", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
        public Boolean CheckUsername(String username){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM user WHERE username=?", new String[]{username});
        if(cursor.getCount() > 0){
            return false;
        }else{
            return true;
        }
    }
    public Boolean CheckPassword(String password){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM user WHERE password=?", new String[]{password});
        if(cursor.getCount() > 0){
            return false;
        }else{
            return true;
        }
    }
    public Boolean CheckLogin(String username, String password){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Log.e("Test ",username+" ddhdhdjh"+password);
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM user WHERE username=? AND password=?", new String[]{username, password});
        if(cursor.getCount() > 0){
            Log.e("Test "," True");
            return true;

        }else{
            Log.e("Test "," False");
            return false;

        }
    }
    public Cursor getData(String sql){
        SQLiteDatabase db=getReadableDatabase();
        return db.rawQuery(sql,null);

    }


    public taikhoan laydatauser(String username){
       taikhoan result=new taikhoan();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.query("user",null,"username=?",new String[]{username},null,null,null);
       if (cursor!=null&&cursor.moveToNext()) {
            int id= cursor.getInt(0);
            String password= cursor.getString(2);
            String email=cursor.getString(3);
            String gioitinh= cursor.getString(4);
            String diachi=cursor.getString(5);
            String sdt=cursor.getString(6);
            String mota=cursor.getString(7);
            String chucvi=cursor.getString(8);
            String tuoi= cursor.getString(9);
            result=new taikhoan(id,email,gioitinh,diachi,sdt,username,password,mota,chucvi,tuoi);
        }
        return  result;
    }
    public String laydiachi(String username){
        String diachi=null;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor rs=db.query("user", new String[]{"diachi"},"username=?",new String[]{username},null,null,null);
        if(rs!=null&&rs.moveToNext()){
            diachi=rs.getString(rs.getColumnIndexOrThrow("diachi"));
        }
        return diachi;
    }
    public String laygioitinh(String username){
        String gioitinh=null;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor rs=db.query("user", new String[]{"gioitinh"},"username=?",new String[]{username},null,null,null);
        if(rs!=null&&rs.moveToNext()){
            gioitinh=rs.getString(rs.getColumnIndexOrThrow("gioitinh"));
        }
        return gioitinh;
    }
    public List<Item> getAll(){
        List<Item> list=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.query("monan",null,null,null,null,null,null);
        while (cursor!=null && cursor.moveToNext()){
            int id=cursor.getInt(0);
            String username=cursor.getString(1);
            int img=cursor.getInt(2);
            String title=cursor.getString(3);
            String category=cursor.getString(4);
            String price=cursor.getString(5);
            String diachi=cursor.getString(6);
            String mota=cursor.getString(7);
            String date=cursor.getString(8);
            Log.e("Test",id+" "+img+" "+title+" "+category+" "+price+" "+diachi+" "+mota+" "+date+" ");
            list.add(new Item(id,img,username,title,category,price,diachi,mota,date));//getallmonan
        }
        return list;
    }
    public List<Item> getAllththeoname(String username){
        List<Item> list=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.query("monan",null,"username=?",new String[]{username},null,null,null);
        while (cursor!=null && cursor.moveToNext()){
            int id=cursor.getInt(0);
            String username1=cursor.getString(1);
            int img=cursor.getInt(2);
            String title=cursor.getString(3);
            String category=cursor.getString(4);
            String price=cursor.getString(5);
            String diachi=cursor.getString(6);
            String mota=cursor.getString(7);
            String date=cursor.getString(8);
            Log.e("Test",id+" "+img+" "+title+" "+category+" "+price+" "+diachi+" "+mota+" "+date+" ");
            list.add(new Item(id,img,username1,title,category,price,diachi,mota,date));//getallmonan
        }
        return list;
    }
    public Item laydatamonan(String id){
        Item item=new Item();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor= db.query("monan",null,"id=?",new String[]{id},null,null,null);
        if(cursor!=null&&cursor.moveToNext()){
            int idsp=cursor.getInt(0);
            String username=cursor.getString(1);
            int img=cursor.getInt(2);
            String title=cursor.getString(3);
            String category=cursor.getString(4);
            String price= cursor.getString(5);
            String diachi= cursor.getString(6);
            String mota=cursor.getString(7);
            String date=cursor.getString(8);
            item=new Item(idsp,username,title,category,price,diachi,mota,date);
        }
        return item;
    }
    public List<Giohang> laydatagiohang(String username){
        List<Giohang> list=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.query("donhang",null,"username=?",new String[]{username},null,null,null);
        while (cursor!=null && cursor.moveToNext()){
            int id=cursor.getInt(0);
            String username1=cursor.getString(1);
            int imgsp=cursor.getInt(2);
            String idsp=cursor.getString(3);
            String tensp=cursor.getString(4);
            String giasp=cursor.getString(5);
            String soluongmonan=cursor.getString(6);
            list.add(new Giohang(id,imgsp,idsp,tensp,giasp,soluongmonan));
        }
        return list;
    }
    public List<Donhang> laydatadonhang(){
        List<Donhang> list=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        String order="data DESC";
        Cursor cursor=db.query("donhang",null,null,null,null,null,order);
        while (cursor!=null && cursor.moveToNext()){
            int id=cursor.getInt(0);
            String username=cursor.getString(1);
            String idmonan=cursor.getString(2);
            String nammonan=cursor.getString(3);
            String giamonan=cursor.getString(4);
            String soluongmonan=cursor.getString(5);
            String diachinhan=cursor.getString(6);
            String ghichu=cursor.getString(7);
            String date=cursor.getString(8);
            list.add(new Donhang(id,username,idmonan,nammonan,giamonan ,soluongmonan,diachinhan,ghichu,date));
        }
        return list;
    }
    public boolean updatecanhan(String username,String email,String tuoi,String gioitinh,String diachi,String sodienthoai){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("tuoi", tuoi);
        contentValues.put("gioitinh", gioitinh);
        contentValues.put("diachi",diachi);
        contentValues.put("sdt",sodienthoai);
        long result = sqLiteDatabase.update("user",contentValues,"username=?",new String[]{username});
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }
    public boolean updatematkhau(String password,String username){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("password", password);
        long result = sqLiteDatabase.update("user",contentValues,"username=?",new String[]{username});
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }
    public boolean updategioitinh(String gioitinh,String username){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("gioitinh", gioitinh);
        long result = sqLiteDatabase.update("user",contentValues,"username=?",new String[]{username});
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }
    public boolean deletegiohang(String username){
        SQLiteDatabase db=this.getWritableDatabase();
        long result=db.delete("giohang","usename=?",new String[]{username});
        if(result==-1) return false;
        else  return true;
    }
    public boolean deletegiohangtheoid(String id){
        SQLiteDatabase db=this.getWritableDatabase();
        long result=db.delete("giohang","idsp=?",new String[]{id});
        if(result==-1) return false;
        else  return true;
    }
    public boolean deletemonan(String id){
        SQLiteDatabase db=this.getWritableDatabase();
        long result=db.delete("monan","id=?",new String[]{id});
        if(result==-1) return false;
        else  return true;
    }
    public boolean deleteuser(String username){
        SQLiteDatabase db=this.getWritableDatabase();
        long result=db.delete("user","username=?",new String[]{username});
        if(result==-1) return false;
        else  return true;
    }


}
