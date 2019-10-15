# PageMenuView
PageMenuView


# 引入
## Step 1. Add the JitPack repository to your build file
  Add it in your root build.gradle at the end of repositories:
    
    allprojects {
      repositories {
        ...
        maven { url 'https://www.jitpack.io' }
      }
    }

## Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.sinothk:PageMenuView:1.x.1015'
	}

# 使用
## xml
    <?xml version="1.0" encoding="utf-8"?>
    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:background="#FFFFFF"
        android:orientation="vertical">
        <com.sinothk.menu.pageMenu.PageMenuView
            android:id="@+id/pagemenu"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            app:pagemenu_row_count="2"
            app:pagemenu_span_count="4" />
        <com.sinothk.menu.pageMenu.IndicatorView
            android:id="@+id/main_home_entrance_indicator"
            android:layout_width="match_parent"
            android:layout_height="32dp"
            android:layout_gravity="bottom"
            android:layout_marginLeft="16dp"
            android:layout_marginRight="16dp"
            app:gravity="0"
            app:indicatorColor="#668b8989"
            app:indicatorColorSelected="#FF5722"
            app:indicatorWidth="6" />
    </LinearLayout>
    
    <?xml version="1.0" encoding="utf-8"?>
    <FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:gravity="center_horizontal"
            android:orientation="vertical"
            android:padding="6dp">

            <ImageView
                android:id="@+id/entrance_image"
                android:layout_width="wrap_content"
                android:layout_height="0dp"
                android:layout_margin="2dp"
                android:layout_weight="1"
                android:scaleType="fitCenter" />

            <TextView
                android:id="@+id/entrance_name"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_margin="2dp"
                android:singleLine="true"
                android:textColor="#80000000"
                android:textSize="15sp" />
        </LinearLayout>

        <View
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:background="@drawable/selector_trans_divider" />
    </FrameLayout>
    
  ## java
  
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
    
   (){}[https://github.com/sinothk/PageMenuView/blob/master/app/imgs/iamges.png]
    
