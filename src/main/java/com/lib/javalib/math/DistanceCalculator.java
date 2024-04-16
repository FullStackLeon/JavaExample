package com.lib.javalib.math;

import static java.lang.System.*;

public class DistanceCalculator {
    // 地球的半径（单位：千米）
    private static final double EARTH_RADIUS = 6371.0;

    // 将角度转换为弧度
    private static double toRadians(double degree) {
        return degree * Math.PI / 180.0;
    }

    // 计算两个经纬度坐标之间的大圆距离（单位：千米）
    public static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        // 将经纬度转换为弧度
        double radLat1 = toRadians(lat1);
        double radLon1 = toRadians(lon1);
        double radLat2 = toRadians(lat2);
        double radLon2 = toRadians(lon2);

        // 计算经纬度之间的差值
        double dLat = radLat2 - radLat1;
        double dLon = radLon2 - radLon1;

        // 应用 Haversine 公式计算大圆距离
        double a = Math.pow(Math.sin(dLat / 2.0), 2.0) +
                Math.cos(radLat1) * Math.cos(radLat2) *
                        Math.pow(Math.sin(dLon / 2.0), 2.0);
        double c = 2.0 * Math.atan2(Math.sqrt(a), Math.sqrt(1.0 - a));

        return EARTH_RADIUS * c;
    }

    public static void main(String[] args) {
        // 起始点的经纬度坐标
        double lat1 = 40.7128; // 纬度
        double lon1 = -74.0060; // 经度

        // 终点的经纬度坐标
        double lat2 = 34.0522; // 纬度
        double lon2 = -118.2437; // 经度

        // 计算起始点和终点之间的距离
        double distance = calculateDistance(lat1, lon1, lat2, lon2);
        out.println("两点之间直线距离：" + distance + " 千米");
    }
}