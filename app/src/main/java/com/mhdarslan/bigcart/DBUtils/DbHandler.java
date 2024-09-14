package com.mhdarslan.bigcart.DBUtils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.mhdarslan.bigcart.Models.CartModel;

import java.util.ArrayList;
import java.util.List;

public class DbHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "BigCartDb";
    private static final String TABLE_CART = "cart";
    private static final String COL_CART_ID = "cart_id";
    private static final String COL_CART_ITEM_IMAGE = "item_image";
    private static final String COL_CART_ITEM_NAME = "item_name";
    private static final String COL_CART_ITEM_PRICE = "item_price";
    private static final String COL_CART_ITEM_SIZE = "item_size";
    public DbHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_CART_TABLE = "CREATE TABLE " + TABLE_CART + "("
                + COL_CART_ID + " TEXT PRIMARY KEY,"
                + COL_CART_ITEM_IMAGE + " TEXT,"
                + COL_CART_ITEM_NAME + " TEXT,"
                + COL_CART_ITEM_PRICE + " INTEGER,"
                + COL_CART_ITEM_SIZE + " TEXT"
                + ")";


        db.execSQL(CREATE_CART_TABLE);

    }

    public void addCartItems(CartModel cartLisDBModel) {
        SQLiteDatabase db = this.getWritableDatabase();


        ContentValues values = new ContentValues();
        values.put(COL_CART_ID, cartLisDBModel.getId());
        values.put(COL_CART_ITEM_IMAGE, cartLisDBModel.getItemImage());
        values.put(COL_CART_ITEM_NAME, cartLisDBModel.getItemName());
        values.put(COL_CART_ITEM_PRICE, cartLisDBModel.getItemPrice());
        values.put(COL_CART_ITEM_SIZE, cartLisDBModel.getItemSize());

        db.insert(TABLE_CART, null, values);
        db.close();
    }


    public int updateCartItem(CartModel cartLisDBModel) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COL_CART_ID, cartLisDBModel.getId());
        values.put(COL_CART_ITEM_IMAGE, cartLisDBModel.getItemImage());
        values.put(COL_CART_ITEM_NAME, cartLisDBModel.getItemName());
        values.put(COL_CART_ITEM_PRICE, cartLisDBModel.getItemPrice());
        values.put(COL_CART_ITEM_SIZE, cartLisDBModel.getItemSize());

        return db.update(TABLE_CART, values, COL_CART_ID + " = ?",
                new String[]{String.valueOf(cartLisDBModel.getId())});
    }


    public List<CartModel> getCartItems() {
        List<CartModel> cartLisDBModels = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_CART;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;

        try {
            cursor = db.rawQuery(selectQuery, null);

            if (cursor.moveToFirst()) {
                do {
                    CartModel cart = new CartModel();
                    cart.setId(cursor.getString(0));
                    cart.setItemImage(cursor.getInt(1));
                    cart.setItemName(cursor.getString(2));
                    cart.setItemPrice(Double.parseDouble(cursor.getString(3)));
                    cart.setItemSize(cursor.getString(4));

                    cartLisDBModels.add(cart);
                } while (cursor.moveToNext());
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            db.close();
        }
        return cartLisDBModels;
    }

    public void deleteCart() {
        SQLiteDatabase db = this.getWritableDatabase();
        //Delete all records of table
        db.execSQL("DELETE FROM " + TABLE_CART);

        //For go back free space by shrinking sqlite file
        db.execSQL("VACUUM");
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
