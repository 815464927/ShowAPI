package com.showapi.service.entity;

import java.util.List;

/**
 * Created by song on 2017/2/28.
 * Email：815464927@qq.com
 */

public class MeiNv {

    /**
     * showapi_res_code : 0
     * showapi_res_error :
     * showapi_res_body : {"newslist":[{"title":"街拍刚下班的魅力空姐 温柔善良 美丽大方","picUrl":"http://image.hnol.net/c/2017-02/28/08/201702280834333921-5470928.jpg","description":"华声美女","ctime":"2017-02-28 10:00","url":"http://bbs.voc.com.cn/mm/meinv-7672182-0-1.html"},{"title":"[贴图]独步后花园的风韵美女","picUrl":"http://image.hnol.net/c/2017-02/28/08/20170228083753961-4217076.jpg","description":"华声美女","ctime":"2017-02-28 10:00","url":"http://bbs.voc.com.cn/mm/meinv-7672184-0-1.html"},{"title":"养眼美少女 孟晓蓉Yuri \u201c元老级\u201d的ShowGirl最抢眼写真","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2017/02/m.xxxiao.com_36c5f34ae18312e8e70df822a73558bd-683x1024.jpg","description":"美女写真","ctime":"2017-02-28 09:00","url":"http://m.xxxiao.com/123669"},{"title":"唯美少女 左井翼Kico ChinaJoy2016永恒之塔Coser","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2017/02/m.xxxiao.com_ab6a93cdbb5058fcb19f60a1bf67fe5a.jpg","description":"美女写真","ctime":"2017-02-28 09:00","url":"http://m.xxxiao.com/123670"},{"title":"宅男梦想女神 覃霓Niki 草根美女玩家私房自拍美照","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2017/02/m.xxxiao.com_1f27f2203fe7270667bd8c35b983fa15-770x1024.jpg","description":"美女写真","ctime":"2017-02-28 08:00","url":"http://m.xxxiao.com/123658"},{"title":"高雅车模","picUrl":"http://image.hnol.net/c/2017-02/27/10/201702271018436881-3356886.jpg","description":"华声美女","ctime":"2017-02-28 00:00","url":"http://bbs.voc.com.cn/mm/meinv-7670776-0-1.html"},{"title":"【美D共享】♠ 村姑・I辫","picUrl":"http://image.hnol.net/c/2017-02/27/10/201702271001069141-2089977.jpg","description":"华声美女","ctime":"2017-02-27 22:00","url":"http://bbs.voc.com.cn/mm/meinv-7670721-0-1.html"},{"title":"【美D共享】♠ 惠儿写真","picUrl":"http://image.hnol.net/c/2017-02/27/10/201702271012346481-2089977.jpg","description":"华声美女","ctime":"2017-02-27 20:00","url":"http://bbs.voc.com.cn/mm/meinv-7670757-0-1.html"},{"title":"Yuky伊珍 [YouWu尤物馆] 20170125 VOL048 娇小玲珑的邻家软妹子诱人内衣秀","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2017/02/m.xxxiao.com_3de9330219e716cc9a8c944cd152c443-683x1024.jpg","description":"美女写真","ctime":"2017-02-27 20:00","url":"http://m.xxxiao.com/123558"},{"title":"【美D共享】♠ 花儿说","picUrl":"http://image.hnol.net/c/2017-02/27/10/201702271008493521-2089977.jpg","description":"华声美女","ctime":"2017-02-27 19:00","url":"http://bbs.voc.com.cn/mm/meinv-7670746-0-1.html"}],"code":200,"msg":"success"}
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
         * newslist : [{"title":"街拍刚下班的魅力空姐 温柔善良 美丽大方","picUrl":"http://image.hnol.net/c/2017-02/28/08/201702280834333921-5470928.jpg","description":"华声美女","ctime":"2017-02-28 10:00","url":"http://bbs.voc.com.cn/mm/meinv-7672182-0-1.html"},{"title":"[贴图]独步后花园的风韵美女","picUrl":"http://image.hnol.net/c/2017-02/28/08/20170228083753961-4217076.jpg","description":"华声美女","ctime":"2017-02-28 10:00","url":"http://bbs.voc.com.cn/mm/meinv-7672184-0-1.html"},{"title":"养眼美少女 孟晓蓉Yuri \u201c元老级\u201d的ShowGirl最抢眼写真","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2017/02/m.xxxiao.com_36c5f34ae18312e8e70df822a73558bd-683x1024.jpg","description":"美女写真","ctime":"2017-02-28 09:00","url":"http://m.xxxiao.com/123669"},{"title":"唯美少女 左井翼Kico ChinaJoy2016永恒之塔Coser","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2017/02/m.xxxiao.com_ab6a93cdbb5058fcb19f60a1bf67fe5a.jpg","description":"美女写真","ctime":"2017-02-28 09:00","url":"http://m.xxxiao.com/123670"},{"title":"宅男梦想女神 覃霓Niki 草根美女玩家私房自拍美照","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2017/02/m.xxxiao.com_1f27f2203fe7270667bd8c35b983fa15-770x1024.jpg","description":"美女写真","ctime":"2017-02-28 08:00","url":"http://m.xxxiao.com/123658"},{"title":"高雅车模","picUrl":"http://image.hnol.net/c/2017-02/27/10/201702271018436881-3356886.jpg","description":"华声美女","ctime":"2017-02-28 00:00","url":"http://bbs.voc.com.cn/mm/meinv-7670776-0-1.html"},{"title":"【美D共享】♠ 村姑・I辫","picUrl":"http://image.hnol.net/c/2017-02/27/10/201702271001069141-2089977.jpg","description":"华声美女","ctime":"2017-02-27 22:00","url":"http://bbs.voc.com.cn/mm/meinv-7670721-0-1.html"},{"title":"【美D共享】♠ 惠儿写真","picUrl":"http://image.hnol.net/c/2017-02/27/10/201702271012346481-2089977.jpg","description":"华声美女","ctime":"2017-02-27 20:00","url":"http://bbs.voc.com.cn/mm/meinv-7670757-0-1.html"},{"title":"Yuky伊珍 [YouWu尤物馆] 20170125 VOL048 娇小玲珑的邻家软妹子诱人内衣秀","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2017/02/m.xxxiao.com_3de9330219e716cc9a8c944cd152c443-683x1024.jpg","description":"美女写真","ctime":"2017-02-27 20:00","url":"http://m.xxxiao.com/123558"},{"title":"【美D共享】♠ 花儿说","picUrl":"http://image.hnol.net/c/2017-02/27/10/201702271008493521-2089977.jpg","description":"华声美女","ctime":"2017-02-27 19:00","url":"http://bbs.voc.com.cn/mm/meinv-7670746-0-1.html"}]
         * code : 200
         * msg : success
         */

        private int code;
        private String msg;
        private List<NewslistBean> newslist;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public List<NewslistBean> getNewslist() {
            return newslist;
        }

        public void setNewslist(List<NewslistBean> newslist) {
            this.newslist = newslist;
        }

        public static class NewslistBean {
            /**
             * title : 街拍刚下班的魅力空姐 温柔善良 美丽大方
             * picUrl : http://image.hnol.net/c/2017-02/28/08/201702280834333921-5470928.jpg
             * description : 华声美女
             * ctime : 2017-02-28 10:00
             * url : http://bbs.voc.com.cn/mm/meinv-7672182-0-1.html
             */

            private String title;
            private String picUrl;
            private String description;
            private String ctime;
            private String url;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getPicUrl() {
                return picUrl;
            }

            public void setPicUrl(String picUrl) {
                this.picUrl = picUrl;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getCtime() {
                return ctime;
            }

            public void setCtime(String ctime) {
                this.ctime = ctime;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            @Override
            public String toString() {
                return "NewslistBean{" +
                        "ctime='" + ctime + '\'' +
                        ", title='" + title + '\'' +
                        ", picUrl='" + picUrl + '\'' +
                        ", description='" + description + '\'' +
                        ", url='" + url + '\'' +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "ShowapiResBodyBean{" +
                    "code=" + code +
                    ", msg='" + msg + '\'' +
                    ", newslist=" + newslist +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "MeiNv{" +
                "showapi_res_body=" + showapi_res_body +
                ", showapi_res_code=" + showapi_res_code +
                ", showapi_res_error='" + showapi_res_error + '\'' +
                '}';
    }
}
