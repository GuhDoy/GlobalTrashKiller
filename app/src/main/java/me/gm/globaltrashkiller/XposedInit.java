package me.gm.globaltrashkiller;

import android.content.Context;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class XposedInit implements IXposedHookLoadPackage {

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        XposedHelpers.findAndHookMethod(
                "com.android.providers.media.util.GalleryMediaStore", lpparam.classLoader,
                "initGolbalTrash", Context.class, XC_MethodReplacement.returnConstant(null)
        );
        XposedHelpers.findAndHookMethod(
                "com.android.providers.media.MediaReceiverInjector", lpparam.classLoader,
                "initDragImgsDir", XC_MethodReplacement.returnConstant(null)
        );
    }
}
