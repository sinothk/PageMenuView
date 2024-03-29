package com.sinothk.plugin.menu.pageMenu.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.sinothk.menu.pageMenu.PageMenuView;
import com.sinothk.menu.pageMenu.holder.AbstractHolder;
import com.sinothk.menu.pageMenu.holder.PageMenuViewHolderCreator;
import com.sinothk.menu.pageMenu.view.model.ModelHomeEntrance;
import com.sinothk.menu.pageMenu.view.utils.ScreenUtil;
import com.sinothk.menu.pageMenu.IndicatorView;

import java.util.ArrayList;
import java.util.List;

public class PageMenuViewDemoMainActivity extends AppCompatActivity {

    private List<ModelHomeEntrance> data;
    private IndicatorView indicatorView;
    private PageMenuView<ModelHomeEntrance> pageMenuView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_menu_view_demo_main);

        indicatorView = findViewById(R.id.main_home_entrance_indicator);
        pageMenuView = findViewById(R.id.pagemenu);
        
        initData();

        pageMenuView.setPageDatas(data, new PageMenuViewHolderCreator() {

            @Override
            public int getLayoutId() {
                return R.layout.item_home_entrance;
            }

            @Override
            public AbstractHolder createHolder(View itemView) {
                return new AbstractHolder<ModelHomeEntrance>(itemView) {
                    private TextView entranceNameTextView;
                    private ImageView entranceIconImageView;

                    @Override
                    protected void initView(View itemView) {
                        entranceIconImageView = itemView.findViewById(R.id.entrance_image);
                        entranceNameTextView = itemView.findViewById(R.id.entrance_name);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, (int) ((float) ScreenUtil.getScreenWidth(PageMenuViewDemoMainActivity.this) / 4.0f));
                        itemView.setLayoutParams(layoutParams);
                    }

                    @Override
                    public void bindView(RecyclerView.ViewHolder holder, final ModelHomeEntrance data, int pos) {
                        entranceNameTextView.setText(data.getName());
                        entranceIconImageView.setImageResource(data.getImage());
                        holder.itemView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(PageMenuViewDemoMainActivity.this, data.getName(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                };
            }
        });
        indicatorView.setIndicatorCount(pageMenuView.getPageCount());
        pageMenuView.setOnPageListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                indicatorView.setCurrentIndicator(position);
            }
        });
    }

    private void initData() {
        data = new ArrayList<>();
        data.add(new ModelHomeEntrance("美食", R.drawable.ic_category_0));
        data.add(new ModelHomeEntrance("电影", R.drawable.ic_category_1));
        data.add(new ModelHomeEntrance("酒店住宿", R.drawable.ic_category_2));
        data.add(new ModelHomeEntrance("生活服务", R.drawable.ic_category_3));
        data.add(new ModelHomeEntrance("KTV", R.drawable.ic_category_4));
        data.add(new ModelHomeEntrance("旅游", R.drawable.ic_category_5));
        data.add(new ModelHomeEntrance("学习培训", R.drawable.ic_category_6));
        data.add(new ModelHomeEntrance("汽车服务", R.drawable.ic_category_7));
        data.add(new ModelHomeEntrance("摄影写真", R.drawable.ic_category_8));
        data.add(new ModelHomeEntrance("休闲娱乐", R.drawable.ic_category_10));
        data.add(new ModelHomeEntrance("丽人", R.drawable.ic_category_11));
        data.add(new ModelHomeEntrance("运动健身", R.drawable.ic_category_12));
        data.add(new ModelHomeEntrance("大保健", R.drawable.ic_category_13));
        data.add(new ModelHomeEntrance("团购", R.drawable.ic_category_14));
        data.add(new ModelHomeEntrance("景点", R.drawable.ic_category_16));
        data.add(new ModelHomeEntrance("全部分类", R.drawable.ic_category_15));
    }
}
