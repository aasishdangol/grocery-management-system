package com.developer.util;

import java.util.Random;
public class ConstantValue {

    private static final String CATE_ID= "CATE";
    private static final String PROD_ID= "PROD";
    private static final String USER_ID= "USER";
    private static final String USE_ID= "UT";
    private static final String SALE_ID ="SALE";

    public static final String generateProductId(){
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        return PROD_ID + String.format("%06d",number);
    }

    public static final String generateCategoryId(){
        Random rd = new Random();
        int number = rd.nextInt(999999);
        return CATE_ID + String.format("%06d", number);
    }
    public static final String generateUserId(){
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        return USER_ID + String.format("%06d",number);
    }
    public static final String generateUserTypeId(){
        Random rmd = new Random();
        int number = rmd.nextInt(999999);
        return USE_ID + String.format("%06d",number);
    }

    public static final String generateSalesId(){
        Random rmd = new Random();
        int number = rmd.nextInt(999999);
        return SALE_ID + String.format("%06d",number);
    }

    public static final String[] getPaymentMethods = {
        "Cash","Card","Phone PAY","Bank"
    };

}
