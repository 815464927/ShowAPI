package com.showapi.service.entity;

import java.util.List;

/**
 * Created by song on 2017/3/1.
 * Email：815464927@qq.com
 */

public class ExpressMsg {

    /**
     * showapi_res_code : 0
     * showapi_res_error :
     * showapi_res_body : {"mailNo":"429163422859","update":1488356148560,"updateStr":"2017-03-01 16:15:48","ret_code":0,"flag":true,"status":2,"tel":"021-39777777","data":[{"time":"2017-02-28 17:57:03","context":"[瑞安] [温州市] 快件离开 [瑞安]已发往[沧衡转运中心]"},{"time":"2017-02-28 16:06:24","context":"[瑞安] [温州市] [瑞安]的雅加迪已收件 电话:13376877719"}],"expSpellName":"zhongtong","expTextName":"中通快递"}
     */

    private int showapi_res_code;
    private String showapi_res_error;
    private ShowapiResBodyBean showapi_res_body;

    public int getShowapi_res_code() {
        return showapi_res_code;
    }

    public void setShowapi_res_code(int showapi_res_code) {
        this.showapi_res_code = showapi_res_code;
    }

    public String getShowapi_res_error() {
        return showapi_res_error;
    }

    public void setShowapi_res_error(String showapi_res_error) {
        this.showapi_res_error = showapi_res_error;
    }

    public ShowapiResBodyBean getShowapi_res_body() {
        return showapi_res_body;
    }

    public void setShowapi_res_body(ShowapiResBodyBean showapi_res_body) {
        this.showapi_res_body = showapi_res_body;
    }

    public static class ShowapiResBodyBean {
        /**
         * mailNo : 429163422859
         * update : 1488356148560
         * updateStr : 2017-03-01 16:15:48
         * ret_code : 0
         * flag : true
         * status : 2
         * tel : 021-39777777
         * data : [{"time":"2017-02-28 17:57:03","context":"[瑞安] [温州市] 快件离开 [瑞安]已发往[沧衡转运中心]"},{"time":"2017-02-28 16:06:24","context":"[瑞安] [温州市] [瑞安]的雅加迪已收件 电话:13376877719"}]
         * expSpellName : zhongtong
         * expTextName : 中通快递
         */

        private String mailNo;
        private long update;
        private String updateStr;
        private int ret_code;
        private boolean flag;
        private int status;
        private String tel;
        private String expSpellName;
        private String expTextName;
        private List<DataBean> data;

        public String getMailNo() {
            return mailNo;
        }

        public void setMailNo(String mailNo) {
            this.mailNo = mailNo;
        }

        public long getUpdate() {
            return update;
        }

        public void setUpdate(long update) {
            this.update = update;
        }

        public String getUpdateStr() {
            return updateStr;
        }

        public void setUpdateStr(String updateStr) {
            this.updateStr = updateStr;
        }

        public int getRet_code() {
            return ret_code;
        }

        public void setRet_code(int ret_code) {
            this.ret_code = ret_code;
        }

        public boolean isFlag() {
            return flag;
        }

        public void setFlag(boolean flag) {
            this.flag = flag;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public String getExpSpellName() {
            return expSpellName;
        }

        public void setExpSpellName(String expSpellName) {
            this.expSpellName = expSpellName;
        }

        public String getExpTextName() {
            return expTextName;
        }

        public void setExpTextName(String expTextName) {
            this.expTextName = expTextName;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * time : 2017-02-28 17:57:03
             * context : [瑞安] [温州市] 快件离开 [瑞安]已发往[沧衡转运中心]
             */

            private String time;
            private String context;

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public String getContext() {
                return context;
            }

            public void setContext(String context) {
                this.context = context;
            }

            @Override
            public String toString() {
                return "DataBean{" +
                        "context='" + context + '\'' +
                        ", time='" + time + '\'' +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "ShowapiResBodyBean{" +
                    "data=" + data +
                    ", mailNo='" + mailNo + '\'' +
                    ", update=" + update +
                    ", updateStr='" + updateStr + '\'' +
                    ", ret_code=" + ret_code +
                    ", flag=" + flag +
                    ", status=" + status +
                    ", tel='" + tel + '\'' +
                    ", expSpellName='" + expSpellName + '\'' +
                    ", expTextName='" + expTextName + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "ExpressMsg{" +
                "showapi_res_body=" + showapi_res_body +
                ", showapi_res_code=" + showapi_res_code +
                ", showapi_res_error='" + showapi_res_error + '\'' +
                '}';
    }
}
