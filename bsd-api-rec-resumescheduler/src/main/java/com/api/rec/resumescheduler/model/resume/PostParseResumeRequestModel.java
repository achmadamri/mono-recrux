package com.api.rec.resumescheduler.model.resume;

import com.api.rec.resumescheduler.model.RequestModel;

public class PostParseResumeRequestModel extends RequestModel {
    private String tbrUuid;

    public String getTbrUuid() {
        return tbrUuid;
    }

    public void setTbrUuid(String tbrUuid) {
        this.tbrUuid = tbrUuid;
    }
}
