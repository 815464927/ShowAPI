package com.showapi.service;

import com.showapi.service.entity.Company;
import com.showapi.service.entity.ExpressMsg;
import com.showapi.service.entity.JokeGif;
import com.showapi.service.entity.JokePicture;
import com.showapi.service.entity.JokeText;
import com.showapi.service.entity.MeiNv;
import com.showapi.service.entity.Weather;
import com.showapi.service.entity.WeatherDay;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by song on 2017/2/20.
 * Email：815464927@qq.com
 */

public interface RetrofitService {

    /**
     * 获取未来15天天气预报
     * https://route.showapi.com/9-9?area=深圳
     * &areaid=101230506
     * &showapi_appid=11414
     * &showapi_timestamp=20170220141750
     * &showapi_sign=989e3bce0c13747e552f046bc322fd4c
     *
     * @return Weather
     */
    @GET("9-9")
    Observable<Weather> getWeater(@Query("area") String area,
                                  @Query("areaid") String areaid,
                                  @Query("showapi_appid") String showapi_appid,
                                  @Query("showapi_timestamp") String showapi_timestamp,
                                  @Query("showapi_sign") String showapi_sign);


    /**
     * 获取实时天气
     * https://route.showapi.com/9-8?area=深圳
     * &areaid=101230506
     * &showapi_appid=11414
     * &showapi_timestamp=20170221102650
     * &showapi_sign=3B7600E05F13769A76A2C62E5D377E60
     */
    @GET("9-8")
    Observable<WeatherDay> getWeatherDay(@Query("area") String area,
                                         @Query("areaid") String areaid,
                                         @Query("showapi_appid") String showapi_appid,
                                         @Query("showapi_timestamp") String showapi_timestamp,
                                         @Query("showapi_sign") String showapi_sign);

    /**
     * https://route.showapi.com/341-3?
     * maxResult=20
     * &page=1
     * &showapi_appid=11414
     * &showapi_timestamp=20170222162109
     * &showapi_sign=a1cf5245aae56a5cbe43bf172e72d060
     */
    @GET("341-3")
    Observable<JokeGif> getJokeGif(@Query("maxResult") int maxResult,
                                   @Query("page") int page,
                                   @Query("showapi_appid") String showapi_appid,
                                   @Query("showapi_timestamp") String showapi_timestamp,
                                   @Query("showapi_sign") String showapi_sign);

    /**
     * https://route.showapi.com/341-2?
     * maxResult=20
     * &page=
     * &showapi_appid=11414
     * &showapi_timestamp=20170223091438
     * &showapi_sign=b042b138a51c0acfa296c5b247e32740
     */
    @GET("341-2")
    Observable<JokePicture> getJokePicture(@Query("maxResult") int maxResult,
                                           @Query("page") int page,
                                           @Query("showapi_appid") String showapi_appid,
                                           @Query("showapi_timestamp") String showapi_timestamp,
                                           @Query("showapi_sign") String showapi_sign);


    /**
     * https://route.showapi.com/341-1?
     * maxResult=20
     * &page=1
     * &showapi_appid=11414
     * &showapi_timestamp=20170223112641
     * &showapi_sign=f703d7c91d5ba210aed51a0da5df6f14
     */
    @GET("341-1")
    Observable<JokeText> getJokeText(@Query("maxResult") int maxResult,
                                     @Query("page") int page,
                                     @Query("showapi_appid") String showapi_appid,
                                     @Query("showapi_timestamp") String showapi_timestamp,
                                     @Query("showapi_sign") String showapi_sign);

    /**
     * https://route.showapi.com/197-1?
     * num=10     返回条数
     * &page=1    分页
     * &rand=1   随机分配
     * &showapi_appid=11414
     * &showapi_timestamp=20170228110305
     * &showapi_sign=8155a11f22378880b50f0e9297f0a834
     */
    @GET("197-1")
    Observable<MeiNv> getMeiNv(@Query("num") int num,
                               @Query("page") int page,
                               @Query("rand") int rand,
                               @Query("showapi_appid") String showapi_appid,
                               @Query("showapi_timestamp") String showapi_timestamp,
                               @Query("showapi_sign") String showapi_sign);

    /**
     * 根据快递订单查询快递公司
     * https://route.showapi.com/64-21?
     * nu=49790244793
     * &showapi_appid=11414
     * &showapi_timestamp=20170301154649
     * &showapi_sign=769b22ee72e65b946f558074711f1058
     */
    @GET("64-21")
    Observable<Company> getCompanyFormOrder(@Query("nu") String nu,
                                            @Query("showapi_appid") String showapi_appid,
                                            @Query("showapi_timestamp") String showapi_timestamp,
                                            @Query("showapi_sign") String showapi_sign);

    /**
     * 根据快递订单 和 快递公司查询--->物流信息
     * https://route.showapi.com/64-19?
     * com=shunfeng
     * &nu=610349360550
     * &showapi_appid=11414
     * &showapi_timestamp=20170301155156
     * &showapi_sign=a962f0f2922d11ee4ddcfa55760231a7
     */
    @GET("64-19")
    Observable<ExpressMsg> getExpressMesg(@Query("com") String com,
                                          @Query("nu") String nu,
                                          @Query("showapi_appid") String showapi_appid,
                                          @Query("showapi_timestamp") String showapi_timestamp,
                                          @Query("showapi_sign") String showapi_sign);
}
