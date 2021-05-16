package com.xuhuaixin.classshoot;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;




public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private LinearLayout loading;
    private ListView lvNews;
    private List<NewsInfo> newsInfos = new ArrayList<>();
    private TextView tv_title;
    private TextView tv_description;
    private TextView tv_type;
    private NewsInfo newsInfo;
    private ImageView siv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        fillLocalData();
    }

    private void fillLocalData() {
        newsInfos.clear();
        newsInfos.addAll(NewsInfoProvider.getInstance().getData());
        loading.setVisibility(View.INVISIBLE);
        lvNews.setAdapter(new NewsAdapter());
    }

    //初始化控件
    private void initView() {
        loading = (LinearLayout) findViewById(R.id.loading);
        lvNews = (ListView) findViewById(R.id.lv_news);
        lvNews.setOnItemClickListener(this);
    }



    //使用AsyncHttpClient访问网络
    private void fillData() {

        //创建AsyncHttpClient实例
        AsyncHttpClient client = new AsyncHttpClient();
        //使用GET方式请求
        client.get(getString(R.string.serverurl), new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int i, org.apache.http.Header[] headers, byte[] bytes) {
                //请求成功

                try {
                    String json = new String(bytes, "utf-8");
                    newsInfos = JsonParse.getNewsInfo(json);
                    if (newsInfos == null) {
                        Toast.makeText(MainActivity.this, "解析失败", Toast.LENGTH_SHORT).show();
                    } else {
                        //更新界面
                        loading.setVisibility(View.INVISIBLE);
                        lvNews.setAdapter(new NewsAdapter());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


            @Override
            public void onFailure(int i, org.apache.http.Header[] headers, byte[] bytes, Throwable throwable) {

            }



        });
    }

    private void startActivity(Class<? extends Activity> c){
        startActivity(new Intent(this ,c));
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 0:
                startActivity(MusicActivity.class);
                break;
            case 1:
                startActivity(VideoActivity.class);
                break;
            case 2:
                startActivity(ImageActivity.class);
                break;
            case 3:

                break;
            case 4:
                Intent i1 = new Intent(this,AnimationActivity.class);
                i1.putExtra("type",1);
                startActivity(i1);
                break;
            case 5:
                Intent i2 = new Intent(this,AnimationActivity.class);
                i2.putExtra("type",2);
                startActivity(i2);
                break;
            case 6:
                startActivity(DrawerActivity.class);
                break;
            case 7:
                break;
        }
    }

    //ListView适配器
    private class NewsAdapter extends BaseAdapter {
        //listview的item数
        @Override
        public int getCount() {
            return newsInfos.size();
        }

        //得到listview条目视图
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = View.inflate(MainActivity.this, R.layout.news_item, null);
            siv = view.findViewById(R.id.siv_icon);
            tv_title = (TextView) view.findViewById(R.id.tv_title);
            tv_description = (TextView) view.findViewById(R.id.tv_description);
            tv_type = (TextView) view.findViewById(R.id.tv_type);
            newsInfo = newsInfos.get(position);
            //SmartImageView加载指定路径图片
            Picasso.get().load(newsInfo.getIcon()).resize(160,120).into(siv);
            //设置新闻标题
            tv_title.setText(newsInfo.getTitle());
            //设置新闻描述
            tv_description.setText(newsInfo.getContent());
            //1.一般新闻 2.专题 3.live
            int type = newsInfo.getType();
            switch (type) {
                //不同新闻类型设置不同的颜色和不同的内容
                case 1:
                    tv_type.setText("评论:" + newsInfo.getComment());
                    break;
                case 2:
                    tv_type.setTextColor(Color.RED);
                    tv_type.setText("专题");
                    break;
                case 3:
                    tv_type.setTextColor(Color.BLUE);
                    tv_type.setText("LIVE");
                    break;
            }
            return view;
        }

        //条目对象
        @Override
        public Object getItem(int position) {
            return null;
        }

        //条目id
        @Override
        public long getItemId(int position) {
            return 0;
        }
    }
}
