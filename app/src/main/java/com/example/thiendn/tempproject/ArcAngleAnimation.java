package com.example.thiendn.tempproject;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by thiendn on 10/24/17.
 */

public class ArcAngleAnimation extends Animation {

    private ArcView arcView;

    private float oldAngle;
    private float newAngle;

    public ArcAngleAnimation(ArcView arcView, int newAngle) {
        this.oldAngle = arcView.getArcAngle();
        this.newAngle = newAngle;
        this.arcView = arcView;
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation transformation) {
        float angle = oldAngle + ((newAngle - oldAngle) * interpolatedTime);
        arcView.setArcAngle(angle);
        arcView.requestLayout();
    }

    public void setNewAngle(int newAngle){
        this.newAngle = newAngle;
    }

    public void setOldAngle(float oldAngle) {
        this.oldAngle = oldAngle;
    }
}
