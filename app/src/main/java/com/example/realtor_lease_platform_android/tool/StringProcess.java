package com.example.realtor_lease_platform_android.tool;

import com.example.realtor_lease_platform_android.define.Constants;
import com.example.realtor_lease_platform_android.role.Config;

public class StringProcess {

    public static String getQueryConfigWhereStringByPK(Config config) {
        return Constants.ID_SQL + "='" + config.getId() + "'";
    }

}
