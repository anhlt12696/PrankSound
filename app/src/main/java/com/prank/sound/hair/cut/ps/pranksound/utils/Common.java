package com.prank.sound.hair.cut.ps.pranksound.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.widget.Toast;

import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import java.io.File;
import java.net.URLConnection;
import java.util.Locale;

import khangtran.preferenceshelper.PrefHelper;

public class Common {

    public static void setLocale(Context context) {
        Locale locale = new Locale(PrefHelper.getStringVal("locale", "en"));
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.setLocale(locale);
        context.getResources().updateConfiguration(configuration, context.getResources().getDisplayMetrics());
    }




}
