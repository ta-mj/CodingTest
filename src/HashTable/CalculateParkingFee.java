package HashTable;

import java.util.HashMap;
import java.util.Iterator;

/**
 *https://school.programmers.co.kr/learn/courses/30/lessons/92341
 * 주차장의 요금표와 차량이 들어오고(입차) 나간(출차) 기록이 주어졌을 때, 차량별로 주차 요금을 계산하려고 합니다
 */
public class CalculateParkingFee {
    public static void main(String args[]){
        int[] fees = { 180, 5000, 10, 600 };
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        solution(fees,records);
    }
    public static int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        int d_time = fees[0]; int d_fee = fees[1]; int u_time = fees[2]; int u_fee = fees[3];

        HashMap<String,Integer> time_information = new HashMap<>();
        HashMap<String,Integer> fee_information = new HashMap<>();
        for(int i = 0 ; i < records.length ; i++){
            //데이터 정리
            String time = records[i].split(" ")[0];
            String car_num = records[i].split(" ")[1];
            int minute = Integer.parseInt(time.split(":")[0]) * 60
                    + Integer.parseInt(time.split(":")[1]);//시간을 분으로 계산
            boolean in_or_out = records[i].split(" ")[2].equals("IN");
            //처음 들어온 차라면
            if(!time_information.containsKey(car_num)){
                time_information.put(car_num,-minute);
            }
            else{
                //재입차 했을 때
                if(in_or_out){
                    time_information.put(car_num, time_information.get(car_num) - minute);
                }
                //출차 했을 때
                else{
                    time_information.put(car_num, time_information.get(car_num) + minute);
                }
            }
        }
        //출차 안한 차가 있는지 확인 후 요금 계산
        time_information.forEach((key,value)->{
            //출차가 안되었다면
            if(value < 0){
                value += 23*60 + 59;
            }
            //기본 요금
            if(value <= d_time){
                value = d_fee;
            }
            //추가 요금
            else{
                //초과한 시간이 단위시간으로 나누어 떨어질때
                if((value - d_time) % u_time == 0){
                    value = d_fee + (value - d_time) / u_time * u_fee;
                }
                //초과한 시간이 단위시간으로 나누어 떨어지지 않을 때
                else{
                    value = d_fee + ((value - d_time) / u_time + 1) * u_fee;
                }
            }
            System.out.println(key + ":" + value);

        });
        //answer = time_information.values().toArray(new Integer[0]);
        return answer;
    }
}
