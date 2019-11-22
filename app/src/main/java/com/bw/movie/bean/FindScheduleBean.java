package com.bw.movie.bean;

import java.util.List;

/**
 * describe:FindScheduleBean
 * date:2019/11/21
 * author:任(Lenovo)
 * function:
 */
public class FindScheduleBean {


    /**
     * result : [{"beginTime":"16:50:00","endTime":"18:35:00","fare":0.18,"hallId":101,"id":46,"screeningHall":"1号厅"},{"beginTime":"17:00:00","endTime":"18:57:00","fare":0.18,"hallId":102,"id":325,"screeningHall":"杜比厅"},{"beginTime":"17:20:00","endTime":"18:55:00","fare":0.18,"hallId":104,"id":335,"screeningHall":"3号厅"},{"beginTime":"10:20:00","endTime":"12:05:00","fare":0.18,"hallId":104,"id":341,"screeningHall":"3号厅"},{"beginTime":"10:20:00","endTime":"12:05:00","fare":0.18,"hallId":104,"id":353,"screeningHall":"3号厅"}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * beginTime : 16:50:00
         * endTime : 18:35:00
         * fare : 0.18
         * hallId : 101
         * id : 46
         * screeningHall : 1号厅
         */

        private String beginTime;
        private String endTime;
        private double fare;
        private int hallId;
        private int id;
        private String screeningHall;

        public String getBeginTime() {
            return beginTime;
        }

        public void setBeginTime(String beginTime) {
            this.beginTime = beginTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public double getFare() {
            return fare;
        }

        public void setFare(double fare) {
            this.fare = fare;
        }

        public int getHallId() {
            return hallId;
        }

        public void setHallId(int hallId) {
            this.hallId = hallId;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getScreeningHall() {
            return screeningHall;
        }

        public void setScreeningHall(String screeningHall) {
            this.screeningHall = screeningHall;
        }
    }
}
