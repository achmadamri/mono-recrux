package com.api.rec.resume.model.resume;

import com.api.rec.resume.model.RequestModel;

public class PostUploadResumeRequestModel extends RequestModel {
    private String tbjUuid;

    public String getTbjUuid() {
        return tbjUuid;
    }

    public void setTbjUuid(String tbjUuid) {
        this.tbjUuid = tbjUuid;
    }
}
