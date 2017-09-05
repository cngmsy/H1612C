package com.example.bazier2;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import static android.animation.ObjectAnimator.ofFloat;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    RelativeLayout fu;
    float mcurrentPosition[] = new float[2];//x y
    private Button button;
    private ImageView shopimage;
    private TextView textView2;
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        button = (Button) findViewById(R.id.button);
        shopimage = (ImageView) findViewById(R.id.shopimage);
        textView2 = (TextView) findViewById(R.id.textView2);
         fu = (RelativeLayout) findViewById(R.id.fu);
        button.setOnClickListener(this);
        textView2.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                final ImageView iamgeanim = new ImageView(this);
                iamgeanim.setImageResource(R.mipmap.ic_launcher);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(50, 50);
                fu.addView(iamgeanim,layoutParams);
//                Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.scale);
//                iamgeanim.startAnimation(animation);

                //获取父布局的坐标点
                int[] fupositon = new int[2];
                fu.getLocationInWindow(fupositon);

                //获取button坐标点
                int[] btnpositon = new int[2];
                button.getLocationInWindow(btnpositon);

                //获取购物车坐标点
                int[] shopposition = new int[2];
                shopimage.getLocationInWindow(shopposition);

                //获取到开始时的坐标
                int startX=btnpositon[0]-fupositon[0]+button.getWidth()/2;
                int startY=btnpositon[1]-fupositon[1]+button.getHeight()/2;

                //结束时的坐标
                int toX=shopposition[0]-fupositon[0]+shopimage.getWidth()/5;
                int toY=shopposition[1]-fupositon[1];

                //绘制贝塞尔曲线
                final Path path = new Path();
                //开始
                path.moveTo(startX,startY);
                //结束
                path.quadTo((startX+toX)/2,startY,toX,toY);

                final PathMeasure pathMeasure = new PathMeasure(path,true);            //属性动画 实现贝塞尔曲线
                 //让其慢慢缩小
                ObjectAnimator anim = ObjectAnimator.ofFloat(iamgeanim, "scaleX", 3f, 0.5f);
                anim.setDuration(1000);
                anim.start();

                ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, pathMeasure.getLength());
                valueAnimator.setDuration(1000);
                valueAnimator.setInterpolator(new LinearInterpolator());
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float animatedValue = (float) valueAnimator.getAnimatedValue();
                        pathMeasure.getPosTan(animatedValue,mcurrentPosition,null);
                        //设置图片动画的坐标
                        iamgeanim.setTranslationX(mcurrentPosition[0]);
                        iamgeanim.setTranslationY(mcurrentPosition[1]);
                    }
                });
                valueAnimator.start();
                valueAnimator.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {
                        fu.removeView(iamgeanim);
                        i++;
                        textView2.setVisibility(View.VISIBLE);
                        textView2.setText(i+"");

                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                });
                break;
        }
    }
}
