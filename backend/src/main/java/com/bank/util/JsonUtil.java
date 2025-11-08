package com.bank.util;

import com.google.gson.Gson;

public class JsonUtil {
    private static final Gson gson = new Gson();
    public static String toJson(Object obj) { return gson.toJson(obj); }
    public static <T> T fromJson(String json, Class<T> cls) { return gson.fromJson(json, cls); }
}
