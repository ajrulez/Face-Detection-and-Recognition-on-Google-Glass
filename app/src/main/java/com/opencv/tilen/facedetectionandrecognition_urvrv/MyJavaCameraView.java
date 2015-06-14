package com.opencv.tilen.facedetectionandrecognition_urvrv;

import android.content.Context;
import android.hardware.Camera;
import android.util.AttributeSet;

import org.opencv.android.JavaCameraView;

import java.util.List;

/**
 * Created by Tilen on 11.6.2015.
 */
public class MyJavaCameraView extends JavaCameraView  {
    public MyJavaCameraView(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    public void setResolution(Camera.Size resolution) {
        disconnectCamera();
        mMaxHeight = resolution.height;
        mMaxWidth = resolution.width;
        connectCamera(getWidth(), getHeight());
    }

    public List<Camera.Size> getResolutionList() {
        return mCamera.getParameters().getSupportedPreviewSizes();
    }

    public List<int[]> getPreviewFpsRangeList()
    {
        return mCamera.getParameters().getSupportedPreviewFpsRange();
    }

    //doesn't work, maybe in future version
    public void setFpsRange(int[] fpsRange)
    {
        Camera.Parameters params = mCamera.getParameters();
        // *1000 - cause are scaled values
        params.setPreviewFpsRange(fpsRange[0], fpsRange[1]);
        mCamera.setParameters(params);
        //mCamera.getParameters().setPreviewFpsRange(fpsRange[0], fpsRange[1]);
        disconnectCamera();
        connectCamera(getWidth(), getHeight());
    }




}