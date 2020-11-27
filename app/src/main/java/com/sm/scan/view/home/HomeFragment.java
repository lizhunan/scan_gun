package com.sm.scan.view.home;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.RemoteException;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ctrl.base.view.BaseFragment;
import com.sm.scan.R;
import com.sm.scan.databinding.FragmentHomeBinding;
import com.sm.scan.view.home.qr.QRCodeUtil;
import com.sm.scan.view.home.qr.QRScannerActivity;
import com.sm.scan.viewmodel.CommonViewModel;
import com.sunmi.peripheral.printer.InnerPrinterCallback;
import com.sunmi.peripheral.printer.InnerPrinterException;
import com.sunmi.peripheral.printer.InnerPrinterManager;
import com.sunmi.peripheral.printer.InnerResultCallbcak;
import com.sunmi.peripheral.printer.SunmiPrinterService;

import java.util.Objects;

/**
 * @author lizhunan
 */
public class HomeFragment
        extends BaseFragment<FragmentHomeBinding, CommonViewModel> {

    private InnerPrinterCallback innerPrinterCallback = null;
    private Bitmap bitmap = null;

    public HomeFragment() {

    }

    @Override
    public int setContent() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void setListener() {
        binding.setOnClick(this);
    }

    @Override
    protected void initData() {
        bitmap = QRCodeUtil.createQRCodeBitmap("text 123 测试二维码生成", 500);
        binding.qrIv.setImageBitmap(bitmap);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            if (requestCode == 1) {
                Log.d("sss", "::" + Objects.requireNonNull(data).getStringExtra("result"));
            }
        } catch (Exception ignored) {
        }
    }

    public void scan() {
        startActivityForResult(new Intent(getContext(), QRScannerActivity.class), 1);
    }

    public void print() {
        try {
            InnerPrinterCallback innerPrinterCallback = new InnerPrinterCallback() {
                @Override
                protected void onConnected(SunmiPrinterService service) {
                    try {
                        service.setAlignment(1, innerResultCallbcak);
                        service.setFontSize(36, innerResultCallbcak);
                        service.printText("订单测试\n", innerResultCallbcak);
                        service.printText("----------------\n", innerResultCallbcak);
                        service.setAlignment(0, innerResultCallbcak);
                        service.setFontSize(18, innerResultCallbcak);
                        service.printText("t1\n", innerResultCallbcak);
                        service.setAlignment(2, innerResultCallbcak);
                        service.printText("t1\n", innerResultCallbcak);
                        service.setAlignment(0, innerResultCallbcak);
                        service.printText("t2\n", innerResultCallbcak);
                        service.setAlignment(2, innerResultCallbcak);
                        service.printText("t2\n", innerResultCallbcak);
                        service.setAlignment(0, innerResultCallbcak);
                        service.printText("t3\n", innerResultCallbcak);
                        service.setAlignment(2, innerResultCallbcak);
                        service.printText("t3\n", innerResultCallbcak);
                        service.setAlignment(0, innerResultCallbcak);
                        service.printText("t4\n", innerResultCallbcak);
                        service.setAlignment(2, innerResultCallbcak);
                        service.printText("t4\n", innerResultCallbcak);
                        service.printText("\n", innerResultCallbcak);
                        service.printText("\n", innerResultCallbcak);
                        service.printText("\n", innerResultCallbcak);
                        service.printText("\n", innerResultCallbcak);
                        service.setAlignment(1, innerResultCallbcak);
                        service.printText("----------------\n", innerResultCallbcak);
                      /*  if (bitmap != null) {
                            int src_w = bitmap.getWidth();
                            int src_h = bitmap.getHeight();
                            float scale_w = ((float) 48) / src_w;
                            float scale_h = ((float) 48) / src_h;
                            Matrix matrix = new Matrix();
                            matrix.postScale(scale_w, scale_h);
                            Bitmap dstbmp = Bitmap.createBitmap(bitmap, 0, 0, src_w, src_h, matrix, true);
                            service.printBitmap(bitmap, innerResultCallbcak);
                        }*/
                        service.printQRCode("测试 123 test",4,3,innerResultCallbcak);
                        service.printText("\n", innerResultCallbcak);
                        service.printText("\n", innerResultCallbcak);
                        service.printText("\n", innerResultCallbcak);
                        service.printText("\n", innerResultCallbcak);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                protected void onDisconnected() {

                }
            };
            boolean result = InnerPrinterManager.getInstance().bindService(Objects.requireNonNull(getContext()), innerPrinterCallback);
        } catch (InnerPrinterException e) {
            e.printStackTrace();
        }
    }

    private InnerResultCallbcak innerResultCallbcak = new InnerResultCallbcak() {
        @Override
        public void onRunResult(boolean isSuccess) throws RemoteException {

        }

        @Override
        public void onReturnString(String result) throws RemoteException {

        }

        @Override
        public void onRaiseException(int code, String msg) throws RemoteException {

        }

        @Override
        public void onPrintResult(int code, String msg) throws RemoteException {

        }
    };

}
