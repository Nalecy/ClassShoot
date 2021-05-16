package com.xuhuaixin.classshoot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author nalecy
 * @since 2021/5/14
 */
public class NewsInfoProvider {
    private static final NewsInfoProvider ourInstance = new NewsInfoProvider();

    private NewsInfoProvider() {
    }

    public static NewsInfoProvider getInstance() {
        return ourInstance;
    }

    public List<NewsInfo> getData() {
        Random random = new Random();
        List<NewsInfo> data = new ArrayList<>();
        for (int i = 1; i <= 9;i++){
            data.add(new NewsInfo("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1475704080,1567531225&fm=26&gp=0.jpg",
                    "title"+i,
                    "content"+i,
                    i%3+1,
                    random.nextInt()
            ));
        }
        data.get(1).setIcon("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=4011064803,493771095&fm=26&gp=0.jpg");
        data.get(2).setIcon("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3144486528,3918230326&fm=26&gp=0.jpg");
        data.get(3).setIcon("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=549117971,2212175459&fm=26&gp=0.jpg");
        data.get(4).setIcon("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3818849213,1085333911&fm=26&gp=0.jpg");
        data.get(5).setIcon("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3022987737,2379253915&fm=26&gp=0.jpg");
        data.get(6).setIcon("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3303494397,1023859939&fm=26&gp=0.jpg");
        data.get(7).setIcon("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=811305237,1729921144&fm=26&gp=0.jpg");
        data.get(8).setIcon("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3250733235,688128443&fm=26&gp=0.jpg");
        return data;
    }

}
