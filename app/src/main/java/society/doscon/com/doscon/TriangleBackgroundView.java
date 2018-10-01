package society.doscon.com.doscon;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class TriangleBackgroundView extends View {
    Paint paint,paint1,paint2;
    Paint bgPaint;

    public TriangleBackgroundView(Context context) {
        super(context);
        init();
    }

    public TriangleBackgroundView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TriangleBackgroundView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint2 = new Paint();
        paint2.setStrokeWidth(1);
        paint2.setAntiAlias(true);
        paint2.setStrokeCap(Paint.Cap.SQUARE);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setColor(getResources().getColor(R.color.colorBtnSubmit));

        paint1 = new Paint();
        paint1.setStrokeWidth(1);
        paint1.setAntiAlias(true);
        paint1.setStrokeCap(Paint.Cap.SQUARE);
        paint1.setStyle(Paint.Style.FILL);
        paint1.setColor(getResources().getColor(R.color.yellow_light_color));

        paint = new Paint();
        paint.setStrokeWidth(1);
        paint.setAntiAlias(true);
        paint.setStrokeCap(Paint.Cap.SQUARE);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(getResources().getColor(R.color.theme_border));

        bgPaint= new Paint();
        bgPaint.setStyle(Paint.Style.FILL);
        bgPaint.setColor(getResources().getColor(R.color.hint_color));
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

        canvas.drawRect(0,0,w,h,bgPaint);

        Path path = new Path();
        path.moveTo(0, h);
        path.lineTo(w, h);
        path.lineTo(0, 0);
        path.lineTo(0, h);
        path.close();
        canvas.drawPath(path,paint);

        Path path1 = new Path();
        path1.moveTo(0, h);
        path1.lineTo(w, 0);
        path1.lineTo(0, 0);
        path1.lineTo(0, h);
        path1.close();
        canvas.drawPath(path1,paint1);

        Path path2 = new Path();
        path2.moveTo(0, 0);
        path2.lineTo(w, h);
        path2.lineTo(w/2, h/2);
        path2.lineTo(0, h);
        path2.close();
        canvas.drawPath(path2,paint2);
    }
}
