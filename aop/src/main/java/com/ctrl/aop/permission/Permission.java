package com.ctrl.aop.permission;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Process;

import androidx.core.app.ActivityCompat;

import java.util.ArrayList;
import java.util.List;

class Permission {

    static boolean checkSelfPermission(Context context, String[] permissions) {
        if (permissions == null)
            throw new IllegalArgumentException("权限为空");
        for (int i = 0; i < permissions.length; i++) {
            if (context.checkPermission(permissions[i], Process.myPid(), Process.myUid())
                    == PackageManager.PERMISSION_DENIED)
                return false;
        }
        return true;
    }

    static void requestPermission(String[] permissions, Activity activity) {
        List<String> permissionList = new ArrayList<>();
        for (int i = 0; i < permissions.length; i++) {
            if (activity.checkPermission(permissions[i], Process.myPid(), Process.myUid())
                    == PackageManager.PERMISSION_DENIED)
                permissionList.add(permissions[i]);
        }
        String[] perStr = new String[permissionList.size()];
        for (int i = 0; i < permissionList.size(); i++) {
            perStr[i] = permissionList.get(i);
        }
        ActivityCompat.requestPermissions(activity, perStr, 0x01);
    }
}
