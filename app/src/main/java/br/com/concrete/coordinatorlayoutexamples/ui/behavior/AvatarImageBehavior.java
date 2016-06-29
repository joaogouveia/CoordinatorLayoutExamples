package br.com.concrete.coordinatorlayoutexamples.ui.behavior;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import br.com.concrete.coordinatorlayoutexamples.R;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by João Gouveia on 29/06/2016.
 */

public class AvatarImageBehavior extends CoordinatorLayout.Behavior<CircleImageView> {

    private final static float MIN_AVATAR_PERCENTAGE_SIZE = 0.3f;
    private final static int EXTRA_FINAL_AVATAR_PADDING = 80;

    private final static String TAG = "behavior";
    private Context mContext;

    private float mCustomFinalYPosition;
    private float mCustomStartXPosition;
    private float mCustomStartToolbarPosition;
    private float mCustomStartHeight;
    private float mCustomFinalHeight;

    private float mAvatarMaxSize;
    private float mFinalLeftAvatarPadding;
    private float mStartPosition;
    private int mStartXPosition;
    private float mStartToolbarPosition;
    private int mStartYPosition;
    private int mFinalYPosition;
    private int mStartHeight;
    private int mFinalXPosition;
    private float mChangeBehaviorPoint;
    private int mChildInitialHeight;
    private int mChildInitialWidth;
    private int diffX;

    public AvatarImageBehavior(Context context, AttributeSet attrs) {
        mContext = context;

        if (attrs != null) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.AvatarImageBehavior);
            mCustomFinalYPosition = a.getDimension(R.styleable.AvatarImageBehavior_finalYPosition, 0);
            mCustomStartXPosition = a.getDimension(R.styleable.AvatarImageBehavior_startXPosition, 0);
            mCustomStartToolbarPosition = a.getDimension(R.styleable.AvatarImageBehavior_startToolbarPosition, 0);
            mCustomStartHeight = a.getDimension(R.styleable.AvatarImageBehavior_startHeight, 0);
            mCustomFinalHeight = a.getDimension(R.styleable.AvatarImageBehavior_finalHeight, 0);

            a.recycle();
        }

        init();

        mFinalLeftAvatarPadding = context.getResources().getDimension(
                R.dimen.spacing_normal);
    }

    private void init() {
        bindDimensions();
    }

    private void bindDimensions() {
        mAvatarMaxSize = mContext.getResources().getDimension(R.dimen.image_width);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, CircleImageView child, View dependency) {
        return dependency instanceof NestedScrollView;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, CircleImageView child, View dependency) {

        if (dependency instanceof NestedScrollView) {
            maybeInitProperties(child, dependency);

            final int maxScrollDistance = (int) (mStartToolbarPosition);
            float expandedPercentageFactor = (dependency.getY() - mContext.getResources().getDimensionPixelOffset(R.dimen.toolbar_custom)) / maxScrollDistance;

            if ((mChildInitialHeight * expandedPercentageFactor) > mCustomFinalHeight) {
                child.setScaleX(expandedPercentageFactor);
                child.setScaleY(expandedPercentageFactor);
            }

        }
        return true;
    }

    private void maybeInitProperties(CircleImageView child, View dependency) {
        if (mStartYPosition == 0)
            mStartYPosition = (int) (dependency.getY());

        if (mFinalYPosition == 0)
            mFinalYPosition = (dependency.getHeight() / 2);

        if (mStartHeight == 0)
            mStartHeight = child.getHeight();

        if (mStartXPosition == 0)
            mStartXPosition = (int) child.getX();

        if (mFinalXPosition == 0)
            mFinalXPosition = mContext.getResources().getDimensionPixelOffset(R.dimen.abc_action_bar_content_inset_material);

        if (mStartToolbarPosition == 0)
            mStartToolbarPosition = dependency.getY()  - mContext.getResources().getDimensionPixelOffset(R.dimen.toolbar_custom);

        if (mChildInitialHeight == 0)
            mChildInitialHeight = child.getHeight();

        if (mChildInitialWidth == 0)
            mChildInitialWidth = dependency.getWidth();

        if (diffX == 0)
            diffX = mStartXPosition - mFinalXPosition;

        if (mChangeBehaviorPoint == 0) {
            mChangeBehaviorPoint = (child.getHeight() - mCustomFinalHeight) / (2f * (mStartYPosition - mFinalYPosition));
        }

    }

}
