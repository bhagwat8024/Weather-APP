package com.nagarro.bhagwat.weatherapp.model;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;

import java.util.List;


@Entity(primaryKeys = {"lat","lon"},tableName = "WeatherData")
public class WeatherData {
        private double lat;
        private double lon;
        private String city_name;
        private String state_code;
        private String country_code;
        private String timezone;
        private String station;
        private List<String> sources;
        private double vis;
        private double rh;
        private double dewpt;
        private double wind_dir;
        private String wind_cdir;
        private String wind_cdir_full;
        private double wind_speed;
        private double gust;
        private double temp;
        private double app_temp;
        private double clouds;
        @Embedded private WeatherInfo weather;
        private String datetime;
        private String ob_time;
        private long ts;
        private String sunrise;
        private String sunset;
        private double slp;
        private double pres;
        private double aqi;
        private double uv;
        private double solar_rad;
        private double ghi;
        private double dni;
        private double dhi;
        private double elev_angle;
        private double hour_angle;
        private String pod;
        private double precip;
        private double snow;
        private Long response_id;

    public WeatherData(double lat, double lon, String city_name, String state_code, String country_code, String timezone, String station, List<String> sources, double vis, double rh, double dewpt, double wind_dir, String wind_cdir, String wind_cdir_full, double wind_speed, double gust, double temp, double app_temp, double clouds, WeatherInfo weather, String datetime, String ob_time, long ts, String sunrise, String sunset, double slp, double pres, double aqi, double uv, double solar_rad, double ghi, double dni, double dhi, double elev_angle, double hour_angle, String pod, double precip, double snow, Long response_id) {
        this.lat = lat;
        this.lon = lon;
        this.city_name = city_name;
        this.state_code = state_code;
        this.country_code = country_code;
        this.timezone = timezone;
        this.station = station;
        this.sources = sources;
        this.vis = vis;
        this.rh = rh;
        this.dewpt = dewpt;
        this.wind_dir = wind_dir;
        this.wind_cdir = wind_cdir;
        this.wind_cdir_full = wind_cdir_full;
        this.wind_speed = wind_speed;
        this.gust = gust;
        this.temp = temp;
        this.app_temp = app_temp;
        this.clouds = clouds;
        this.weather = weather;
        this.datetime = datetime;
        this.ob_time = ob_time;
        this.ts = ts;
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.slp = slp;
        this.pres = pres;
        this.aqi = aqi;
        this.uv = uv;
        this.solar_rad = solar_rad;
        this.ghi = ghi;
        this.dni = dni;
        this.dhi = dhi;
        this.elev_angle = elev_angle;
        this.hour_angle = hour_angle;
        this.pod = pod;
        this.precip = precip;
        this.snow = snow;
        this.response_id = response_id;
    }

    public Long getResponse_id() {
        return response_id;
    }

    public void setResponse_id(Long response_id) {
        this.response_id = response_id;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getState_code() {
        return state_code;
    }

    public void setState_code(String state_code) {
        this.state_code = state_code;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public List<String> getSources() {
        return sources;
    }

    public void setSources(List<String> sources) {
        this.sources = sources;
    }

    public double getVis() {
        return vis;
    }

    public void setVis(double vis) {
        this.vis = vis;
    }

    public double getRh() {
        return rh;
    }

    public void setRh(double rh) {
        this.rh = rh;
    }

    public double getDewpt() {
        return dewpt;
    }

    public void setDewpt(double dewpt) {
        this.dewpt = dewpt;
    }

    public double getWind_dir() {
        return wind_dir;
    }

    public void setWind_dir(double wind_dir) {
        this.wind_dir = wind_dir;
    }

    public String getWind_cdir() {
        return wind_cdir;
    }

    public void setWind_cdir(String wind_cdir) {
        this.wind_cdir = wind_cdir;
    }

    public String getWind_cdir_full() {
        return wind_cdir_full;
    }

    public void setWind_cdir_full(String wind_cdir_full) {
        this.wind_cdir_full = wind_cdir_full;
    }

    public double getWind_speed() {
        return wind_speed;
    }

    public void setWind_speed(double wind_speed) {
        this.wind_speed = wind_speed;
    }

    public double getGust() {
        return gust;
    }

    public void setGust(double gust) {
        this.gust = gust;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getApp_temp() {
        return app_temp;
    }

    public void setApp_temp(double app_temp) {
        this.app_temp = app_temp;
    }

    public double getClouds() {
        return clouds;
    }

    public void setClouds(double clouds) {
        this.clouds = clouds;
    }

    public WeatherInfo getWeather() {
        return weather;
    }

    public void setWeather(WeatherInfo weather) {
        this.weather = weather;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getOb_time() {
        return ob_time;
    }

    public void setOb_time(String ob_time) {
        this.ob_time = ob_time;
    }

    public long getTs() {
        return ts;
    }

    public void setTs(long ts) {
        this.ts = ts;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public double getSlp() {
        return slp;
    }

    public void setSlp(double slp) {
        this.slp = slp;
    }

    public double getPres() {
        return pres;
    }

    public void setPres(double pres) {
        this.pres = pres;
    }

    public double getAqi() {
        return aqi;
    }

    public void setAqi(double aqi) {
        this.aqi = aqi;
    }

    public double getUv() {
        return uv;
    }

    public void setUv(double uv) {
        this.uv = uv;
    }

    public double getSolar_rad() {
        return solar_rad;
    }

    public void setSolar_rad(double solar_rad) {
        this.solar_rad = solar_rad;
    }

    public double getGhi() {
        return ghi;
    }

    public void setGhi(double ghi) {
        this.ghi = ghi;
    }

    public double getDni() {
        return dni;
    }

    public void setDni(double dni) {
        this.dni = dni;
    }

    public double getDhi() {
        return dhi;
    }

    public void setDhi(double dhi) {
        this.dhi = dhi;
    }

    public double getElev_angle() {
        return elev_angle;
    }

    public void setElev_angle(double elev_angle) {
        this.elev_angle = elev_angle;
    }

    public double getHour_angle() {
        return hour_angle;
    }

    public void setHour_angle(double hour_angle) {
        this.hour_angle = hour_angle;
    }

    public String getPod() {
        return pod;
    }

    public void setPod(String pod) {
        this.pod = pod;
    }

    public double getPrecip() {
        return precip;
    }

    public void setPrecip(double precip) {
        this.precip = precip;
    }

    public double getSnow() {
        return snow;
    }

    public void setSnow(double snow) {
        this.snow = snow;
    }
}
