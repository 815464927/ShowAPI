package com.showapi.service.entity;

import java.util.List;

/**
 * Created by song on 2017/2/21.
 * Email：815464927@qq.com
 */

public class WeatherDay {

    /**
     * showapi_res_body : {"area":"深圳","areaid":"101280601","hourList":[{"temperature":"22","time":"201702211000","weather":"多云转阴","weather_code":"02","wind_direction":"东南偏东","wind_power":"4-5 和风  8.0~10.7m/s"},{"temperature":"24","time":"201702211100","weather":"多云转阴","weather_code":"02","wind_direction":"东南偏东","wind_power":"4-5 和风  8.0~10.7m/s"},{"temperature":"23","time":"201702211200","weather":"多云转阴","weather_code":"02","wind_direction":"东南偏东","wind_power":"4-5 和风  8.0~10.7m/s"},{"temperature":"23","time":"201702211300","weather":"雨","weather_code":"301","wind_direction":"东南偏东","wind_power":"4-5 和风  8.0~10.7m/s"},{"temperature":"23","time":"201702211400","weather":"多云转阴","weather_code":"02","wind_direction":"东南偏东","wind_power":"5-6 清风  10.8~13.8m/s"},{"temperature":"22","time":"201702211500","weather":"多云转阴","weather_code":"02","wind_direction":"东南偏东","wind_power":"5-6 清风  10.8~13.8m/s"},{"temperature":"22","time":"201702211600","weather":"雨","weather_code":"301","wind_direction":"东南偏东","wind_power":"4-5 和风  8.0~10.7m/s"},{"temperature":"21","time":"201702211700","weather":"雨","weather_code":"301","wind_direction":"东南偏东","wind_power":"4-5 和风  8.0~10.7m/s"},{"temperature":"20","time":"201702211800","weather":"雨","weather_code":"301","wind_direction":"东南偏东","wind_power":"4-5 和风  8.0~10.7m/s"},{"temperature":"19","time":"201702211900","weather":"多云转阴","weather_code":"02","wind_direction":"东南偏东","wind_power":"3-4 微风  5.5~7.9m/s"},{"temperature":"19","time":"201702212000","weather":"多云转阴","weather_code":"02","wind_direction":"东南偏东","wind_power":"3-4 微风  5.5~7.9m/s"},{"temperature":"19","time":"201702212100","weather":"多云转阴","weather_code":"02","wind_direction":"东南偏东","wind_power":"3-4 微风  5.5~7.9m/s"},{"temperature":"19","time":"201702212200","weather":"多云转阴","weather_code":"02","wind_direction":"东南偏东","wind_power":"0-3级 微风  <5.4m/s"},{"temperature":"19","time":"201702212300","weather":"多云","weather_code":"01","wind_direction":"东南偏东","wind_power":"0-3级 微风  <5.4m/s"},{"temperature":"19","time":"201702220000","weather":"多云转阴","weather_code":"02","wind_direction":"东南偏东","wind_power":"0-3级 微风  <5.4m/s"},{"temperature":"19","time":"201702220100","weather":"雨","weather_code":"301","wind_direction":"东","wind_power":"0-3级 微风  <5.4m/s"},{"temperature":"18","time":"201702220200","weather":"雨","weather_code":"301","wind_direction":"东","wind_power":"0-3级 微风  <5.4m/s"},{"temperature":"18","time":"201702220300","weather":"雨","weather_code":"301","wind_direction":"东","wind_power":"0-3级 微风  <5.4m/s"},{"temperature":"18","time":"201702220400","weather":"雨","weather_code":"301","wind_direction":"东","wind_power":"0-3级 微风  <5.4m/s"},{"temperature":"18","time":"201702220500","weather":"多云","weather_code":"01","wind_direction":"东","wind_power":"0-3级 微风  <5.4m/s"},{"temperature":"18","time":"201702220600","weather":"雨","weather_code":"301","wind_direction":"东南偏东","wind_power":"0-3级 微风  <5.4m/s"},{"temperature":"18","time":"201702220700","weather":"多云转阴","weather_code":"02","wind_direction":"东北偏东","wind_power":"0-3级 微风  <5.4m/s"},{"temperature":"18","time":"201702220800","weather":"多云转阴","weather_code":"02","wind_direction":"东北偏东","wind_power":"0-3级 微风  <5.4m/s"},{"temperature":"18","time":"201702220900","weather":"多云转阴","weather_code":"02","wind_direction":"东北偏东","wind_power":"0-3级 微风  <5.4m/s"}],"ret_code":0}
     * showapi_res_code : 0
     * showapi_res_error :
     */

    private ShowapiResBodyBean showapi_res_body;
    private int showapi_res_code;
    private String showapi_res_error;

    public ShowapiResBodyBean getShowapi_res_body() {
        return showapi_res_body;
    }

    public void setShowapi_res_body(ShowapiResBodyBean showapi_res_body) {
        this.showapi_res_body = showapi_res_body;
    }

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

    public static class ShowapiResBodyBean {
        /**
         * area : 深圳
         * areaid : 101280601
         * hourList : [{"temperature":"22","time":"201702211000","weather":"多云转阴","weather_code":"02","wind_direction":"东南偏东","wind_power":"4-5 和风  8.0~10.7m/s"},{"temperature":"24","time":"201702211100","weather":"多云转阴","weather_code":"02","wind_direction":"东南偏东","wind_power":"4-5 和风  8.0~10.7m/s"},{"temperature":"23","time":"201702211200","weather":"多云转阴","weather_code":"02","wind_direction":"东南偏东","wind_power":"4-5 和风  8.0~10.7m/s"},{"temperature":"23","time":"201702211300","weather":"雨","weather_code":"301","wind_direction":"东南偏东","wind_power":"4-5 和风  8.0~10.7m/s"},{"temperature":"23","time":"201702211400","weather":"多云转阴","weather_code":"02","wind_direction":"东南偏东","wind_power":"5-6 清风  10.8~13.8m/s"},{"temperature":"22","time":"201702211500","weather":"多云转阴","weather_code":"02","wind_direction":"东南偏东","wind_power":"5-6 清风  10.8~13.8m/s"},{"temperature":"22","time":"201702211600","weather":"雨","weather_code":"301","wind_direction":"东南偏东","wind_power":"4-5 和风  8.0~10.7m/s"},{"temperature":"21","time":"201702211700","weather":"雨","weather_code":"301","wind_direction":"东南偏东","wind_power":"4-5 和风  8.0~10.7m/s"},{"temperature":"20","time":"201702211800","weather":"雨","weather_code":"301","wind_direction":"东南偏东","wind_power":"4-5 和风  8.0~10.7m/s"},{"temperature":"19","time":"201702211900","weather":"多云转阴","weather_code":"02","wind_direction":"东南偏东","wind_power":"3-4 微风  5.5~7.9m/s"},{"temperature":"19","time":"201702212000","weather":"多云转阴","weather_code":"02","wind_direction":"东南偏东","wind_power":"3-4 微风  5.5~7.9m/s"},{"temperature":"19","time":"201702212100","weather":"多云转阴","weather_code":"02","wind_direction":"东南偏东","wind_power":"3-4 微风  5.5~7.9m/s"},{"temperature":"19","time":"201702212200","weather":"多云转阴","weather_code":"02","wind_direction":"东南偏东","wind_power":"0-3级 微风  <5.4m/s"},{"temperature":"19","time":"201702212300","weather":"多云","weather_code":"01","wind_direction":"东南偏东","wind_power":"0-3级 微风  <5.4m/s"},{"temperature":"19","time":"201702220000","weather":"多云转阴","weather_code":"02","wind_direction":"东南偏东","wind_power":"0-3级 微风  <5.4m/s"},{"temperature":"19","time":"201702220100","weather":"雨","weather_code":"301","wind_direction":"东","wind_power":"0-3级 微风  <5.4m/s"},{"temperature":"18","time":"201702220200","weather":"雨","weather_code":"301","wind_direction":"东","wind_power":"0-3级 微风  <5.4m/s"},{"temperature":"18","time":"201702220300","weather":"雨","weather_code":"301","wind_direction":"东","wind_power":"0-3级 微风  <5.4m/s"},{"temperature":"18","time":"201702220400","weather":"雨","weather_code":"301","wind_direction":"东","wind_power":"0-3级 微风  <5.4m/s"},{"temperature":"18","time":"201702220500","weather":"多云","weather_code":"01","wind_direction":"东","wind_power":"0-3级 微风  <5.4m/s"},{"temperature":"18","time":"201702220600","weather":"雨","weather_code":"301","wind_direction":"东南偏东","wind_power":"0-3级 微风  <5.4m/s"},{"temperature":"18","time":"201702220700","weather":"多云转阴","weather_code":"02","wind_direction":"东北偏东","wind_power":"0-3级 微风  <5.4m/s"},{"temperature":"18","time":"201702220800","weather":"多云转阴","weather_code":"02","wind_direction":"东北偏东","wind_power":"0-3级 微风  <5.4m/s"},{"temperature":"18","time":"201702220900","weather":"多云转阴","weather_code":"02","wind_direction":"东北偏东","wind_power":"0-3级 微风  <5.4m/s"}]
         * ret_code : 0
         */

        private String area;
        private String areaid;
        private int ret_code;
        private List<HourListBean> hourList;

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getAreaid() {
            return areaid;
        }

        public void setAreaid(String areaid) {
            this.areaid = areaid;
        }

        public int getRet_code() {
            return ret_code;
        }

        public void setRet_code(int ret_code) {
            this.ret_code = ret_code;
        }

        public List<HourListBean> getHourList() {
            return hourList;
        }

        public void setHourList(List<HourListBean> hourList) {
            this.hourList = hourList;
        }

        public static class HourListBean {
            /**
             * temperature : 22
             * time : 201702211000
             * weather : 多云转阴
             * weather_code : 02
             * wind_direction : 东南偏东
             * wind_power : 4-5 和风  8.0~10.7m/s
             */

            private String temperature;
            private String time;
            private String weather;
            private String weather_code;
            private String wind_direction;
            private String wind_power;

            public String getTemperature() {
                return temperature;
            }

            public void setTemperature(String temperature) {
                this.temperature = temperature;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public String getWeather() {
                return weather;
            }

            public void setWeather(String weather) {
                this.weather = weather;
            }

            public String getWeather_code() {
                return weather_code;
            }

            public void setWeather_code(String weather_code) {
                this.weather_code = weather_code;
            }

            public String getWind_direction() {
                return wind_direction;
            }

            public void setWind_direction(String wind_direction) {
                this.wind_direction = wind_direction;
            }

            public String getWind_power() {
                return wind_power;
            }

            public void setWind_power(String wind_power) {
                this.wind_power = wind_power;
            }

            @Override
            public String toString() {
                return "HourListBean{" +
                        "temperature='" + temperature + '\'' +
                        ", time='" + time + '\'' +
                        ", weather='" + weather + '\'' +
                        ", weather_code='" + weather_code + '\'' +
                        ", wind_direction='" + wind_direction + '\'' +
                        ", wind_power='" + wind_power + '\'' +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "ShowapiResBodyBean{" +
                    "area='" + area + '\'' +
                    ", areaid='" + areaid + '\'' +
                    ", ret_code=" + ret_code +
                    ", hourList=" + hourList +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "WeatherDay{" +
                "showapi_res_body=" + showapi_res_body +
                ", showapi_res_code=" + showapi_res_code +
                ", showapi_res_error='" + showapi_res_error + '\'' +
                '}';
    }
}
