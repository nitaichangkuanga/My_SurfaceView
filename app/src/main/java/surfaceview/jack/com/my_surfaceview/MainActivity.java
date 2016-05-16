package surfaceview.jack.com.my_surfaceview;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MainActivity extends AppCompatActivity implements SurfaceHolder.Callback {
    private SurfaceView s;
    private Paint paint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        s = (SurfaceView) findViewById(R.id.s);
        s.getHolder().addCallback(this);
        paint = new Paint();
        paint.setColor(Color.WHITE);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        //画扇形
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <360; i++) {
                    SurfaceHolder holder =  s.getHolder();
                    Canvas canvas = holder.lockCanvas();
                    canvas.drawArc(150,150,350,350,0,i,true,paint);
                    holder.unlockCanvasAndPost(canvas);
                }
            }
        }).start();


    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
