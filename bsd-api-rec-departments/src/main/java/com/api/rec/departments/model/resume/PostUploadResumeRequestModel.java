package com.api.rec.departments.model.resume;

import com.api.rec.departments.model.RequestModel;

public class PostUploadResumeRequestModel extends RequestModel {
    private String tbjUuid;

    public String getTbjUuid() {
        return tbjUuid;
    }

    public void setTbjUuid(String tbjUuid) {
        this.tbjUuid = tbjUuid;
    }
}
