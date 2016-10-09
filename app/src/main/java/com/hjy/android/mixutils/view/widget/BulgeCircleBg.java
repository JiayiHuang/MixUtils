package com.hjy.android.mixutils.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class BulgeCircleBg extends RelativeLayout {
   private float radius, scaledDensity, borderWidth, moveDownDis;
   private int left, top, right, bottom, lineYPoint;
   private Paint mLinePaint, mWhitePaint;
   private Point pLeftStart, pLeftEnd, pRightStart, pRightEnd;
   private RectF rectF, whiteRectangleRectF;
   private boolean isShowCircle = true;

   public BulgeCircleBg(Context context) {
      this(context, null);
   }

   public BulgeCircleBg(Context context, AttributeSet attrs) {
      this(context, attrs, 0);
   }

   public BulgeCircleBg(Context context, AttributeSet attrs, int defStyleAttr) {
      super(context, attrs, defStyleAttr);
/*
      TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomTabBack);
      isShowCircle = typedArray.getBoolean(R.styleable.CustomTabBack_isHideCircle, false);
*/
      initParams(context);
   }

   private void initParams(Context context) {
      // 所有的数据配置依据是根据xml布局文件相对应的。
      scaledDensity = context.getResources().getDisplayMetrics().scaledDensity;
      moveDownDis = 0 * scaledDensity;
      radius = (33.3333f + 10) * scaledDensity;
//      borderWidth = 2 * scaledDensity;
      borderWidth = 1;
      mLinePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
      mLinePaint.setDither(true);
      mLinePaint.setColor(Color.parseColor("#f0f0f0"));
      mLinePaint.setStyle(Paint.Style.STROKE);
      mLinePaint.setStrokeWidth(borderWidth);

      mWhitePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
      mWhitePaint.setDither(true);
      mWhitePaint.setColor(Color.WHITE);
      mWhitePaint.setStyle(Paint.Style.FILL);

   }

   @Override
   protected void onSizeChanged(int w, int h, int oldw, int oldh) {
      super.onSizeChanged(w, h, oldw, oldh);

      // 120°
      double sqrt3 = Math.sqrt(3);
      lineYPoint = (int) (radius / 2 + moveDownDis);
      pLeftStart = new Point(0, lineYPoint);
      pLeftEnd = new Point((int) ((w - sqrt3 * radius + moveDownDis) / 2), lineYPoint);
      pRightStart = new Point((int) ((w + sqrt3 * radius - moveDownDis / 2) / 2), lineYPoint);
      pRightEnd = new Point(w, lineYPoint);

      left = (int) (w / 2 - radius);
      right = (int) (w / 2 + radius);
      top = (int) (0 + moveDownDis);
      bottom = (int) (2 * radius + moveDownDis);

      rectF = new RectF(left, top, right, bottom);
      whiteRectangleRectF = new RectF(0, lineYPoint, w, h);

   }

   @Override
   protected void onDraw(Canvas canvas) {
      super.onDraw(canvas);
      canvas.save();
      if (isShowCircle) {
         canvas.drawArc(rectF, 210, 120, false, mWhitePaint);
         canvas.drawRect(whiteRectangleRectF, mWhitePaint);

         canvas.drawArc(rectF, 210, 120, false, mLinePaint);
         canvas.drawLine(pLeftStart.x, pLeftStart.y, pLeftEnd.x, pLeftEnd.y, mLinePaint);
         canvas.drawLine(pRightStart.x, pRightStart.y, pRightEnd.x, pRightEnd.y, mLinePaint);
      } else {
         canvas.drawLine(0, lineYPoint, getMeasuredWidth(), lineYPoint, mLinePaint);
         canvas.drawRect(whiteRectangleRectF, mWhitePaint);
      }
   }

/*
   public void setCircleDismiss(boolean dismiss) {
      this.isShowCircle = !dismiss;
      requestLayout();
   }
*/
}
