package com.michael.hellomichael.loop;

import java.util.Collections;
import java.util.List;

/**
 * handle face task
 */
public class FaceExecutorService {
    private static FaceExecutorService sInstance;

    public interface ResultCallback {

    }

    static {
        sInstance = new FaceExecutorService();
    }

    public static FaceExecutorService getInstance() {
        return sInstance;
    }

    private FaceExecutorService() {
        initManager();
    }

    private void initManager() {



    }

    private final FaceThread mFaceThread = new FaceThread();

    public void submitWork(FaceTask task, ResultCallback callback) {














    }

    public void shutdown() {

    }












}
