package society.doscon.com.doscon;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class TriangleBackgroundViewSec extends View {
    Paint paint;
//    Paint bgPaint;

    public TriangleBackgroundViewSec(Context context) {
        super(context);
        init();
    }

    public TriangleBackgroundViewSec(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TriangleBackgroundViewSec(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setStrokeWidth(1);
        paint.setAntiAlias(true);
        paint.setStrokeCap(Paint.Cap.SQUARE);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(getResources().getColor(R.color.success_flexi));

//        bgPaint= new Paint();
//        bgPaint.setStyle(Paint.Style.FILL);
//        bgPaint.setColor(getResources().getColor(R.color.dark_blue_background));
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int h = getMeasuredHeight();
        int w = getMeasuredWidth();

        Path path = new Path();
        path.moveTo(0, h/2);
        path.lineTo(0, h/2);
        path.lineTo(w/2, 0);
        path.lineTo(w, h/2);
        path.lineTo(w/2, h);
        path.lineTo(0, h/2);
        path.close();
        canvas.drawPath(path,paint);


    }
}
