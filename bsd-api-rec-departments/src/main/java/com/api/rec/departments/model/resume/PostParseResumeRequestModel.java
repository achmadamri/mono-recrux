package com.api.rec.departments.model.resume;

import com.api.rec.departments.model.RequestModel;

public class PostParseResumeRequestModel extends RequestModel {
    private String tbrUuid;

    public String getTbrUuid() {
        return tbrUuid;
    }

    public void setTbrUuid(String tbrUuid) {
        this.tbrUuid = tbrUuid;
    }
}
