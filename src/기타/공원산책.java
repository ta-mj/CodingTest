package 기타;

public class 공원산책 {
    public static int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        //시작 위치 찾기
        for(int i = 0 ; i < park.length ; i++){
            if(park[i].contains("S")){
                answer[0] = i;
                answer[1] = park[i].indexOf("S");
                break;
            }
        }
        //이동 시작
        for(String route : routes){
            Move(park,route,answer);
        }
        return answer;
    }
    public static void Move(String[] park, String route, int[] loc){
        char dir = route.charAt(0);//방향
        int dis = Character.getNumericValue(route.charAt(2));//거리
        int dis_y = park.length - 1;
        int dis_x = park[0].length() - 1;
        int y_cur = loc[0];
        int x_cur = loc[1];
        outer : switch(dir){
            case 'N':
                if(y_cur - dis < 0){
                    break;
                }
                for(int i = y_cur - 1 ; i >= y_cur - dis ; i--){
                    if(park[i].charAt(x_cur) == 'X'){
                        break outer;
                    }
                }
                loc[0] -= dis;
                break;
            case 'S':
                if(y_cur + dis > dis_y){
                    break;
                }
                for(int i = y_cur + 1 ; i <= y_cur + dis ; i++){
                    if(park[i].charAt(x_cur) == 'X'){
                        break outer;
                    }
                }
                loc[0] += dis;
                break;
            case 'W':
                if(x_cur - dis < 0){
                    break;
                }
                for(int i = x_cur - 1 ; i >= x_cur - dis ; i--){
                    if(park[y_cur].charAt(i) == 'X'){
                        break outer;
                    }
                }
                loc[1] -= dis;
                break;
            case 'E':
                if(x_cur + dis > dis_x){
                    break;
                }
                for(int i = x_cur + 1 ; i <= x_cur + dis ; i++){
                    if(park[y_cur].charAt(i) == 'X'){
                        break outer;
                    }
                }
                loc[1] += dis;
                break;
        }


    }

    public static void main(String args[]){
        String[] park = {"0OO","OOO","XSO"};
        String[] routes = {"E 1","S 2","W 3"};
        int[] result = solution(park,routes);
        System.out.println(result[0] + "," +result[1]);
    }
}
