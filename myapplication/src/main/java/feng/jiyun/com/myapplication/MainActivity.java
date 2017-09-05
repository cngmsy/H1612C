package feng.jiyun.com.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.widget.ImageView;

import com.allenliu.badgeview.BadgeFactory;
import com.allenliu.badgeview.BadgeView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import tyrantgit.widget.HeartLayout;

public class MainActivity extends AppCompatActivity {

    private ImageView image1;
    private ImageView image2;
    private ImageView image3;
    private ImageView image4;
    private ImageView image5;
    private ImageView image6;
    private HeartLayout heart;
    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initdata();
    }

    private void initdata() {
        //
        BadgeFactory.createDot(this).setBadgeCount(20).bind(image1);
        BadgeFactory.createCircle(this).setBadgeCount(20).bind(image2);
        //方
        BadgeFactory.createRectangle(this).setBadgeCount(20).bind(image3);
        BadgeFactory.createOval(this).setBadgeCount(20).bind(image4);
        //BadgeFactory.createSquare(this).setBadgeCount(20).bind(image5);0        BadgeFactory.createRoundRect(this).setBadgeCount(20).bind(image6);
        BadgeFactory.create(this)
                .setTextColor(Color.WHITE)
                .setWidthAndHeight(25,25)
                .setBadgeBackground(Color.GREEN)
                .setTextSize(10)
                .setBadgeGravity(Gravity.RIGHT|Gravity.TOP)
                .setBadgeCount(20)
                .setShape(BadgeView.SHAPE_CIRCLE)
                .bind(image5);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                heart.post(new Runnable() {
                    @Override
                    public void run() {
                heart.addHeart(randomColor());
                    }
                });
            }
        },500,200);
    }
    private int randomColor() {
        return Color.rgb(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }
    private void initView() {
        image1 = (ImageView) findViewById(R.id.image1);
        image2 = (ImageView) findViewById(R.id.image2);
        image3 = (ImageView) findViewById(R.id.image3);
        image4 = (ImageView) findViewById(R.id.image4);
        image5 = (ImageView) findViewById(R.id.image5);
        image6 = (ImageView) findViewById(R.id.image6);
        heart = (HeartLayout) findViewById(R.id.hrart);
    }
}
