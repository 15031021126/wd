package com.wd.base_core.untils;

import android.util.Log;

import com.wd.base_core.BuildConfig;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/*
 *@Auther:陈浩
 *@Date: 2019/8/2
 *@Time:11:41
 *@Description:${DESCRIPTION}
 * */public class L {

    private L() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    private static final String TAG = "试验田";
    private static boolean isDebug = BuildConfig.DEBUG;

    // 下面四个是默认tag的函数
    public static void i(String msg) {
        if (!isDebug) return;
        Log.i(TAG, getLocation());
        Log.i(TAG, msg);
    }

    public static void d(String msg) {
        if (!isDebug) return;
        Log.d(TAG, getLocation());
        Log.d(TAG, msg);
    }

    public static void e(String msg) {
        if (!isDebug) return;
        Log.e(TAG, getLocation());
        Log.e(TAG, msg);
    }

    public static void v(String msg) {
        if (!isDebug) return;
        Log.v(TAG, getLocation());
        Log.v(TAG, msg);
    }

    // 下面是传入自定义tag的函数
    public static void i(String tag, String msg) {
        if (!isDebug) return;
        Log.i(tag, getLocation());
        Log.i(tag, msg);
    }

    public static void d(String tag, String msg) {
        if (!isDebug) return;
        Log.d(tag, getLocation());
        Log.d(tag, msg);
    }

    public static void e(String tag, String msg) {
        if (!isDebug) return;
        Log.e(tag, getLocation());
        Log.e(tag, msg);
    }

    public static void v(String tag, String msg) {
        if (!isDebug) return;
        Log.v(tag, getLocation());
        Log.v(tag, msg);
    }

    public static void iJson(String msg) {
        if (!isDebug) return;
        Log.i(TAG, getLocation());
        Log.i(TAG, "\n"+getPrettyJson(msg));
    }

    public static void dJson(String msg) {
        if (!isDebug) return;
        Log.d(TAG, getLocation());
        Log.d(TAG, "\n"+getPrettyJson(msg));
    }

    public static void eJson(String msg) {
        if (!isDebug) return;
        Log.e(TAG, getLocation());
        Log.e(TAG, "\n"+getPrettyJson(msg));
    }

    public static void vJson(String msg) {
        if (!isDebug) return;
        Log.v(TAG, getLocation());
        Log.v(TAG, "\n"+getPrettyJson(msg));
    }

    public static void iJson(String tag, String msg) {
        if (!isDebug) return;
        Log.i(tag, getLocation());
        Log.i(tag, "\n"+getPrettyJson(msg));
    }

    public static void dJson(String tag, String msg) {
        if (!isDebug) return;
        Log.d(tag, getLocation());
        Log.d(tag, "\n"+getPrettyJson(msg));
    }

    public static void eJson(String tag, String msg) {
        if (!isDebug) return;
        Log.e(tag, getLocation());
        Log.e(tag, "\n"+getPrettyJson(msg));
    }

    public static void vJson(String tag, String msg) {
        if (!isDebug) return;
        Log.v(tag, getLocation());
        Log.v(tag, "\n"+getPrettyJson(msg));
    }

    private static StackTraceElement getTargetStackTraceElement() {
        // find the target invoked method
        StackTraceElement targetStackTrace = null;
        boolean shouldTrace = false;
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (StackTraceElement stackTraceElement : stackTrace) {
            boolean isLogMethod = stackTraceElement.getClassName().equals(L.class.getName());
            if (shouldTrace && !isLogMethod) {
                targetStackTrace = stackTraceElement;
                break;
            }
            shouldTrace = isLogMethod;
        }
        return targetStackTrace;
    }

    private static String getLocation(){
        StackTraceElement targetStackTraceElement = getTargetStackTraceElement();
        //实现定位效果的原因是 xxx.java:112  的格式会被自动识别实现定位的效果
        return "(" + targetStackTraceElement.getFileName() + ":" + targetStackTraceElement.getLineNumber() + ")";
    }

    private static String getPrettyJson(String jsonStr) {
        try {
            jsonStr = jsonStr.trim();
            if (jsonStr.startsWith("{")) {
                JSONObject jsonObject = new JSONObject(jsonStr);
                return jsonObject.toString(2);
            }
            if (jsonStr.startsWith("[")) {
                JSONArray jsonArray = new JSONArray(jsonStr);
                return jsonArray.toString(2);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "Invalid Json, Please Check: " + jsonStr;
    }
}
