package com.ctrl.http;

import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static okhttp3.internal.Util.UTF_8;

public class RetrofitUtils {

    private static final String TAG = "RetrofitUtils";
    private static final int DEFAULT_TIME_OUT = 30;//超时时间
    private static final int DEFAULT_READ_TIME_OUT = 30;//读取时间
    private static final int DEFAULT_WRITE_TIME_OUT = 30;//读取时间
    //public static final String BASE_URL = "http://192.168.137.1:8085";//曹阳
    public static final String BASE_URL = "http:/dayuzhang.shuiwu.ctrlcloud.cn";//演示
    //public static final String BASE_URL = "http://guanqu.shuiwu.ctrlcloud.cn";//演示
   // public static final String BASE_URL = "http://112.6.33.87:8085";//线上
    private static Retrofit retrofit;
    private APIService apiService;
    private static RetrofitUtils retrofitUtils;
    private static Gson gson;


    public RetrofitUtils() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder
                .addInterceptor(interceptor)//日志拦截
                .connectTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_READ_TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_WRITE_TIME_OUT, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true);//错误重连
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(builder.build())
                .build();
        apiService = retrofit.create(APIService.class);
    }

    public static RetrofitUtils getInstance() {
        if (retrofitUtils == null) {
            synchronized (Object.class) {
                if (retrofitUtils == null) {
                    retrofitUtils = new RetrofitUtils();
                }
            }
        }
        return retrofitUtils;

    }

    public APIService getApiService() {
        return apiService;
    }

    /**
     * 请求访问拦截器
     */
    private Interceptor interceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            long startTime = System.currentTimeMillis();
            Response response = chain.proceed(chain.request());
            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;
            MediaType mediaType = response.body().contentType();
            String content = response.body().string();
            Log.d(TAG, "----------Request Start----------------");
            printParams(request.body());
            Log.d(TAG, "| " + request.toString() + "===========" + request.headers().toString());
            Log.d(TAG, "| " + content);
            Log.d(TAG, "----------Request End:" + duration + "毫秒----------");
            return response.newBuilder()
                    .body(ResponseBody.create(mediaType, content))
                    .build();
        }
    };

    /**
     * 打印请求参数
     *
     * @param body 请求
     */
    private void printParams(RequestBody body) {
        if (body != null) {
            Buffer buffer = new Buffer();
            try {
                body.writeTo(buffer);
                Charset charset = Charset.forName("UTF-8");
                MediaType contentType = body.contentType();
                if (contentType != null) {
                    charset = contentType.charset(UTF_8);
                }
                String params = buffer.readString(charset);
                Log.d(TAG, "| 请求参数：" + params);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
