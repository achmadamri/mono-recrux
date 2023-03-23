package com.api.rec.resumescheduler.model.resume;

import com.api.rec.resumescheduler.model.RequestModel;

public class PostUploadResumeRequestModel extends RequestModel {
    private String tbjUuid;

    public String getTbjUuid() {
        return tbjUuid;
    }

    public void setTbjUuid(String tbjUuid) {
        this.tbjUuid = tbjUuid;
    }
}
