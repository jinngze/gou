package com.example.home.bean;

import java.util.List;

public class Sean {


    /**
     * code : 200
     * msg : success
     * newslist : [{"ctime":"2017-01-02 22:00","description":"华声美女","picUrl":"http://image.hnol.net/c/2017-01/01/17/201701011737488681-2089977.jpg","title":"【美D共享】&#9824; 少女写真","url":"http://bbs.voc.com.cn/mm/meinv-7611691-0-1.html"},{"ctime":"2017-01-02 22:00","description":"华声美女","picUrl":"http://image.hnol.net/c/2017-01/02/14/201701021427319311-5014677.jpg","title":"穿帆布鞋的青涩女生王沫儿SaSa[贴图]","url":"http://bbs.voc.com.cn/mm/meinv-7612190-0-1.html"},{"ctime":"2017-01-02 23:00","description":"华声美女","picUrl":"http://image.hnol.net/c/2016-12/31/10/201612311045048571-2089977.jpg","title":"【美D共享】&#9824; 何梦兮Stacy","url":"http://bbs.voc.com.cn/mm/meinv-7610685-0-1.html"},{"ctime":"2017-01-03 06:00","description":"美女写真","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2016/12/m.xxxiao.com_0d843eed9bb652a911285d0406c2f52d-683x1024.jpg","title":"头条女神 梁芮溪 古灵精怪花季少女芭拉小魔仙校服诱惑","url":"http://m.xxxiao.com/99140"},{"ctime":"2017-01-03 09:00","description":"美女写真","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2016/09/m.xxxiao.com_c74003b9c775a4601eb4cd3a4f63d9ca-683x1024.jpg","title":"奕丹 头条女神 红肚兜大尺度私房诱惑","url":"http://m.xxxiao.com/72874"},{"ctime":"2017-01-03 09:00","description":"华声美女","picUrl":"http://image.hnol.net/c/2017-01/03/08/201701030836313762-4217076.jpg","title":"[贴图]女子外拍","url":"http://bbs.voc.com.cn/mm/meinv-7612785-0-1.html"},{"ctime":"2017-01-03 11:00","description":"华声美女","picUrl":"http://image.hnol.net/c/2017-01/03/10/201701031010258641-4217076.jpg","title":"[贴图]漂亮的婚纱娘子真纯美","url":"http://bbs.voc.com.cn/mm/meinv-7612906-0-1.html"},{"ctime":"2017-01-03 11:00","description":"华声美女","picUrl":"http://image.hnol.net/c/2017-01/03/10/201701031004397641-4217076.jpg","title":"[贴图]青春少女花养美","url":"http://bbs.voc.com.cn/mm/meinv-7612891-0-1.html"},{"ctime":"2017-01-03 12:00","description":"华声美女","picUrl":"http://image.hnol.net/c/2017-01/03/11/20170103112020841-5014678.jpg","title":"清纯可人的女生沈欣雨[贴图]","url":"http://bbs.voc.com.cn/mm/meinv-7613102-0-1.html"},{"ctime":"2017-01-03 16:00","description":"华声美女","picUrl":"http://image.hnol.net/c/2017-01/01/16/20170101164755481-2089977.jpg","title":"【美D共享】&#9824; 秋日靓装","url":"http://bbs.voc.com.cn/mm/meinv-7611632-0-1.html"}]
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
         * ctime : 2017-01-02 22:00
         * description : 华声美女
         * picUrl : http://image.hnol.net/c/2017-01/01/17/201701011737488681-2089977.jpg
         * title : 【美D共享】&#9824; 少女写真
         * url : http://bbs.voc.com.cn/mm/meinv-7611691-0-1.html
         */

        private String ctime;
        private String description;
        private String picUrl;
        private String title;
        private String url;

        public String getCtime() {
            return ctime;
        }

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
