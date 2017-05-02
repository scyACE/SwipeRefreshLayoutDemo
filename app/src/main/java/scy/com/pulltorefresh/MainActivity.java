package scy.com.pulltorefresh;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshExpandableListView;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.MultipartBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.internal.spdy.Header;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    String str;
    private PullToRefreshListView listView;
    private RefreshLayout swipeRefreshLayout;
    private List mListItems;
    private ArrayAdapter<String> mAdapter;
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.listview);
        swipeRefreshLayout = (RefreshLayout) findViewById(R.id.swiperefreshlayout);
//        listView = (PullToRefreshListView) findViewById(R.id.lv);
        initDatas();
//        mAdapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_1, mListItems);
//        listView.setAdapter(mAdapter);
//        listView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
//            @Override
//            public void onPullDownToRefresh(final PullToRefreshBase<ListView> refreshView) {
//                //创建okHttpClient对象
//                OkHttpClient mOkHttpClient = new OkHttpClient();
//                //创建一个Request
//                final Request request = new Request.Builder()
//                        .url("https://www.baidu.com")
//                        .build();
//                //new call
//                Call call = mOkHttpClient.newCall(request);
//                //请求加入调度
//                call.enqueue(new Callback()
//                {
//                    @Override
//                    public void onFailure(Request request, IOException e)
//                    {
//                    }
//
//                    @Override
//                    public void onResponse(final Response response) throws IOException
//                    {
//                        Log.e("tag", response.body().string() );
//                        runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                listView.onRefreshComplete();
//                            }
//                        });
//                    }
//                });
//            }
//
//            @Override
//            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
//                //创建okHttpClient对象
//                OkHttpClient mOkHttpClient = new OkHttpClient();
//                //创建一个Request
//                final Request request = new Request.Builder()
//                        .url("https://www.taobao.com")
//                        .build();
//                //new call
//                Call call = mOkHttpClient.newCall(request);
//                //请求加入调度
//                call.enqueue(new Callback()
//                {
//                    @Override
//                    public void onFailure(Request request, IOException e)
//                    {
//                    }
//
//                    @Override
//                    public void onResponse(final Response response) throws IOException
//                    {
//                        Log.e("tag", response.body().string() );
//                        runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                listView.onRefreshComplete();
//                            }
//                        });
//                    }
//                });
//            }
//        });
        mAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, mListItems);
        lv.setAdapter(mAdapter);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //创建okHttpClient对象
                OkHttpClient mOkHttpClient = new OkHttpClient();
                //创建一个Request
                final Request request = new Request.Builder()
                        .url("https://www.baidu.com")
                        .build();
                //new call
                Call call = mOkHttpClient.newCall(request);
                //请求加入调度
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Request request, IOException e) {
                    }

                    @Override
                    public void onResponse(final Response response) throws IOException {
                        Log.e("tag", response.body().string());
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                swipeRefreshLayout.setRefreshing(false);
                            }
                        });
                    }
                });

            }
        });
        swipeRefreshLayout.setOnLoadListener(new RefreshLayout.OnLoadListener() {
            @Override
            public void onPageLoad() {
                //创建okHttpClient对象
                OkHttpClient mOkHttpClient = new OkHttpClient();
                //创建一个Request
                final Request request = new Request.Builder()
                        .url("https://www.taobao.com")
                        .build();
                //new call
                Call call = mOkHttpClient.newCall(request);
                //请求加入调度
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Request request, IOException e) {
                    }

                    @Override
                    public void onResponse(final Response response) throws IOException {
                        Log.e("tag", response.body().string());
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                swipeRefreshLayout.setLoading(false);
                            }
                        });
                    }
                });
            }
        });
        final OkHttpClient client = new OkHttpClient();
        RequestBody formBody = new FormEncodingBuilder()
                .add("name", "15545902888")
                .add("password", "123456")
                .add("map_x", "120")
                .add("map_p", "45")
                .add("type", "1")
                .build();
        final Request request = new Request.Builder()
                .url("http://hljmaiyi.ivimoo.com/?g=app&m=public&a=login")
                .post(formBody)
                .build();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Response response = null;
                    try {
                        response = client.newCall(request).execute();
                        if(response.isSuccessful()){
                            final Response finalResponse = response;
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Gson gson = new Gson();
                                    User user = null;
                                    try {
                                        user = gson.fromJson(finalResponse.body().string(),User.class);
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    Log.e("tag", user.toString() );
                                }
                            });

                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }).start();


    }

    private void initDatas() {
        // 初始化数据和数据源
        mListItems = new LinkedList<String>();

        for (int i = 0; i < 20; i++) {
            mListItems.add("" + i);
        }
    }

    public Request getFileRequest(String url, File file, Map<String, String> maps) {
        MultipartBuilder builder = new MultipartBuilder().type(MultipartBuilder.FORM);
        if (maps == null) {
            builder.addPart(Headers.of("Content-Disposition", "form-data; name=\"file\";filename=\"file.jpg\""), RequestBody.create(MediaType.parse("image/png"), file)
            ).build();
        } else {
            for (String key : maps.keySet()) {
                builder.addFormDataPart(key, maps.get(key));
            }

            builder.addPart(Headers.of("Content-Disposition", "form-data; name=\"file\";filename=\"file.jpg\""), RequestBody.create(MediaType.parse("image/png"), file)
            );

        }
        RequestBody body = builder.build();
        return new Request.Builder().url(url).post(body).build();
    }
}
