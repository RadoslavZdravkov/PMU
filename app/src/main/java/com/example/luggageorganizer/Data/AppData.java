package com.example.luggageorganizer.Data;

import static com.example.luggageorganizer.Constants.AppConstants.BABY_NEEDS_CAMEL_CASE;
import static com.example.luggageorganizer.Constants.AppConstants.BASIC_NEEDS_CAMEL_CASE;
import static com.example.luggageorganizer.Constants.AppConstants.BEACH_SUPPLIES_CAMEL_CASE;
import static com.example.luggageorganizer.Constants.AppConstants.CAR_SUPPLIES_CAMEL_CASE;
import static com.example.luggageorganizer.Constants.AppConstants.CLOTHING_CAMEL_CASE;
import static com.example.luggageorganizer.Constants.AppConstants.FOOD_CAMEL_CASE;
import static com.example.luggageorganizer.Constants.AppConstants.HEALTH_CAMEL_CASE;
import static com.example.luggageorganizer.Constants.AppConstants.NEEDS_CAMEL_CASE;
import static com.example.luggageorganizer.Constants.AppConstants.TECHNOLOGY_CAMEL_CASE;

import android.app.Application;
import android.content.Context;

import com.example.luggageorganizer.Database.RoomDB;
import com.example.luggageorganizer.Models.Items;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppData extends Application {
    RoomDB database;
    String category;
    Context context;
    public static final String LAST_VERSION = "LAST_VERSION";
    public static final int NEW_VERSION = 3;

    public AppData(RoomDB database) {
        this.database = database;
    }

    public AppData(RoomDB database, Context context) {
        this.database = database;
        this.context = context;
    }

    public List<Items> getBasicData() {
        String[] items = {"Bank Card", "Passport", "Driver License", "Wallet", "Tickets", "Keys", "Umbrella"};
        return prepareItemsList(BASIC_NEEDS_CAMEL_CASE, items);
    }

    public List<Items> getPersonalCareData() {
        String[] items = {"Toothbrush", "Face Wash", "Face Cream", "Comb"};
        return prepareItemsList(BASIC_NEEDS_CAMEL_CASE, items);
    }

    public List<Items> getBabyNeedsData() {
        String[] items = {"T-shirts", "Boxers", "Jacket"};
        return prepareItemsList(BABY_NEEDS_CAMEL_CASE, items);
    }

    public List<Items> getClothingData() {
        String[] items = {"T-shirts", "Boxers", "Jacket"};
        return prepareItemsList(CLOTHING_CAMEL_CASE, items);
    }

    public List<Items> getHealthData() {
        String[] items = {"Painkillers", "Aspirin", "Paracetamol"};
        return prepareItemsList(HEALTH_CAMEL_CASE, items);
    }

    public List<Items> getTechnologyData() {
        String[] items = {"Ipad", "Laptop", "Camera", "Powerbank", "Drone", "Smartphone"};
        return prepareItemsList(TECHNOLOGY_CAMEL_CASE, items);
    }

    public List<Items> getFoodData() {
        String[] items = {"Sandwiches", "Candies", "Nuts"};
        return prepareItemsList(FOOD_CAMEL_CASE, items);
    }

    public List<Items> getBeachSuppliesData() {
        String[] items = {"Sunglasses", "Suncream", "Towel"};
        return prepareItemsList(BEACH_SUPPLIES_CAMEL_CASE, items);
    }

    public List<Items> getCarSuppliesData() {
        String[] items = {"Car Key", "Insurance"};
        return prepareItemsList(CAR_SUPPLIES_CAMEL_CASE, items);
    }

    public List<Items> getNeedsData() {
        String[] items = {"need1", "need2"};
        return prepareItemsList(NEEDS_CAMEL_CASE, items);
    }

    public List<Items> prepareItemsList(String category, String[] data){
        List<String> list = Arrays.asList(data);
        List<Items> dataList = new ArrayList<>();
        dataList.clear();

        for(String item: list){
            dataList.add(new Items(item, category, false));
        }
        return dataList;
    }

    public List<List<Items>> getAllData(){
        List<List<Items>> listOfAllData = new ArrayList<>();
        listOfAllData.clear();
        listOfAllData.add(getBasicData());
        listOfAllData.add(getPersonalCareData());
        listOfAllData.add(getBabyNeedsData());
        listOfAllData.add(getClothingData());
        listOfAllData.add(getHealthData());
        listOfAllData.add(getTechnologyData());
        listOfAllData.add(getFoodData());
        listOfAllData.add(getBeachSuppliesData());
        listOfAllData.add(getCarSuppliesData());
        listOfAllData.add(getNeedsData());

        return listOfAllData;
    }

    public void persistAllData(){
        List<List<Items>> listOfAllItems = getAllData();
        for(List<Items> list: listOfAllItems){
            for(Items items: list){
                database.mainDao().saveItem(items);
            }
        }
        System.out.println("Data added.");
    }
}
