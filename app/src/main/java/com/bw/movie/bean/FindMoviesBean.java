package com.bw.movie.bean;

import java.util.List;

/**
 * describe:FindMoviesBean
 * date:2019/11/15
 * author:任(Lenovo)
 * function:
 */
public class FindMoviesBean {

    /**
     * result : {"commentNum":10,"duration":"132分钟","imageUrl":"http://172.17.8.100/images/movie/stills/dwsj/dwsj1.jpg","movieActor":[{"name":"李易峰","photo":"http://172.17.8.100/images/movie/actor/dwsj/liyifeng.jpg","role":"郑开司"},{"name":"迈克尔·道格拉斯","photo":"http://172.17.8.100/images/movie/actor/dwsj/maikeer.jpg","role":"安德森"},{"name":"周冬雨","photo":"http://172.17.8.100/images/movie/actor/dwsj/zhoudongyu.jpg","role":"刘青"}],"movieDirector":[{"name":"韩延","photo":"http://172.17.8.100/images/movie/director/dwsj/1.jpg"}],"movieId":10,"movieType":"动作 / 冒险 / 悬疑","name":"动物世界","placeOrigin":"中国大陆,美国","posterList":["http://172.17.8.100/images/movie/stills/dwsj/dwsj1.jpg","http://172.17.8.100/images/movie/stills/dwsj/dwsj2.jpg","http://172.17.8.100/images/movie/stills/dwsj/dwsj3.jpg","http://172.17.8.100/images/movie/stills/dwsj/dwsj4.jpg","http://172.17.8.100/images/movie/stills/dwsj/dwsj5.jpg","http://172.17.8.100/images/movie/stills/dwsj/dwsj6.jpg"],"releaseTime":1536336000000,"score":9.5,"shortFilmList":[{"imageUrl":"http://172.17.8.100/images/movie/stills/dwsj/dwsj3.jpg","videoUrl":"http://172.17.8.100/video/movie/dwsj/dwsj1.ts"},{"imageUrl":"http://172.17.8.100/images/movie/stills/dwsj/dwsj2.jpg","videoUrl":"http://172.17.8.100/video/movie/dwsj/dwsj2.ts"},{"imageUrl":"http://172.17.8.100/images/movie/stills/dwsj/dwsj4.jpg","videoUrl":"http://172.17.8.100/video/movie/dwsj/dwsj3.ts"}],"summary":"男主角郑开司（李易峰 饰）因被朋友欺骗而背负上数百万的债务，面对重病的母亲和痴心等待的青梅竹马，他决心登上\u201c命运号\u201d游轮，改变自己一事无成的人生。只要能在渡轮上的游戏中获胜，他就将有机会将债务一笔勾销，并给家人带来更好的生活。这场游戏看似简单，参与者只需以标着\u201c石头，剪刀，布\u201d的扑克为道具，赢取对手身上的星星标志。但游轮上的亡命徒们毫无底线的欺诈争夺，却让人性的自私与残酷暴露无遗，局中局、计中计，让游戏场最终沦为\u201c动物世界\u201d斗兽场。面对绝境的郑开司，能否坚守自我底线保持善良本性？能否凭借自己的智慧和坚韧摆脱困境？这是一场自我救赎的残酷游戏，多重考验也将接踵而至。","whetherFollow":2}
     * message : 查询成功
     * status : 0000
     */

    private ResultBean result;
    private String message;
    private String status;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

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

    public static class ResultBean {
        /**
         * commentNum : 10
         * duration : 132分钟
         * imageUrl : http://172.17.8.100/images/movie/stills/dwsj/dwsj1.jpg
         * movieActor : [{"name":"李易峰","photo":"http://172.17.8.100/images/movie/actor/dwsj/liyifeng.jpg","role":"郑开司"},{"name":"迈克尔·道格拉斯","photo":"http://172.17.8.100/images/movie/actor/dwsj/maikeer.jpg","role":"安德森"},{"name":"周冬雨","photo":"http://172.17.8.100/images/movie/actor/dwsj/zhoudongyu.jpg","role":"刘青"}]
         * movieDirector : [{"name":"韩延","photo":"http://172.17.8.100/images/movie/director/dwsj/1.jpg"}]
         * movieId : 10
         * movieType : 动作 / 冒险 / 悬疑
         * name : 动物世界
         * placeOrigin : 中国大陆,美国
         * posterList : ["http://172.17.8.100/images/movie/stills/dwsj/dwsj1.jpg","http://172.17.8.100/images/movie/stills/dwsj/dwsj2.jpg","http://172.17.8.100/images/movie/stills/dwsj/dwsj3.jpg","http://172.17.8.100/images/movie/stills/dwsj/dwsj4.jpg","http://172.17.8.100/images/movie/stills/dwsj/dwsj5.jpg","http://172.17.8.100/images/movie/stills/dwsj/dwsj6.jpg"]
         * releaseTime : 1536336000000
         * score : 9.5
         * shortFilmList : [{"imageUrl":"http://172.17.8.100/images/movie/stills/dwsj/dwsj3.jpg","videoUrl":"http://172.17.8.100/video/movie/dwsj/dwsj1.ts"},{"imageUrl":"http://172.17.8.100/images/movie/stills/dwsj/dwsj2.jpg","videoUrl":"http://172.17.8.100/video/movie/dwsj/dwsj2.ts"},{"imageUrl":"http://172.17.8.100/images/movie/stills/dwsj/dwsj4.jpg","videoUrl":"http://172.17.8.100/video/movie/dwsj/dwsj3.ts"}]
         * summary : 男主角郑开司（李易峰 饰）因被朋友欺骗而背负上数百万的债务，面对重病的母亲和痴心等待的青梅竹马，他决心登上“命运号”游轮，改变自己一事无成的人生。只要能在渡轮上的游戏中获胜，他就将有机会将债务一笔勾销，并给家人带来更好的生活。这场游戏看似简单，参与者只需以标着“石头，剪刀，布”的扑克为道具，赢取对手身上的星星标志。但游轮上的亡命徒们毫无底线的欺诈争夺，却让人性的自私与残酷暴露无遗，局中局、计中计，让游戏场最终沦为“动物世界”斗兽场。面对绝境的郑开司，能否坚守自我底线保持善良本性？能否凭借自己的智慧和坚韧摆脱困境？这是一场自我救赎的残酷游戏，多重考验也将接踵而至。
         * whetherFollow : 2
         */

        private int commentNum;
        private String duration;
        private String imageUrl;
        private int movieId;
        private String movieType;
        private String name;
        private String placeOrigin;
        private long releaseTime;
        private double score;
        private String summary;
        private int whetherFollow;
        private List<MovieActorBean> movieActor;
        private List<MovieDirectorBean> movieDirector;
        private List<String> posterList;
        private List<ShortFilmListBean> shortFilmList;

        public int getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(int commentNum) {
            this.commentNum = commentNum;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public int getMovieId() {
            return movieId;
        }

        public void setMovieId(int movieId) {
            this.movieId = movieId;
        }

        public String getMovieType() {
            return movieType;
        }

        public void setMovieType(String movieType) {
            this.movieType = movieType;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPlaceOrigin() {
            return placeOrigin;
        }

        public void setPlaceOrigin(String placeOrigin) {
            this.placeOrigin = placeOrigin;
        }

        public long getReleaseTime() {
            return releaseTime;
        }

        public void setReleaseTime(long releaseTime) {
            this.releaseTime = releaseTime;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public int getWhetherFollow() {
            return whetherFollow;
        }

        public void setWhetherFollow(int whetherFollow) {
            this.whetherFollow = whetherFollow;
        }

        public List<MovieActorBean> getMovieActor() {
            return movieActor;
        }

        public void setMovieActor(List<MovieActorBean> movieActor) {
            this.movieActor = movieActor;
        }

        public List<MovieDirectorBean> getMovieDirector() {
            return movieDirector;
        }

        public void setMovieDirector(List<MovieDirectorBean> movieDirector) {
            this.movieDirector = movieDirector;
        }

        public List<String> getPosterList() {
            return posterList;
        }

        public void setPosterList(List<String> posterList) {
            this.posterList = posterList;
        }

        public List<ShortFilmListBean> getShortFilmList() {
            return shortFilmList;
        }

        public void setShortFilmList(List<ShortFilmListBean> shortFilmList) {
            this.shortFilmList = shortFilmList;
        }

        public static class MovieActorBean {
            /**
             * name : 李易峰
             * photo : http://172.17.8.100/images/movie/actor/dwsj/liyifeng.jpg
             * role : 郑开司
             */

            private String name;
            private String photo;
            private String role;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }

            public String getRole() {
                return role;
            }

            public void setRole(String role) {
                this.role = role;
            }
        }

        public static class MovieDirectorBean {
            /**
             * name : 韩延
             * photo : http://172.17.8.100/images/movie/director/dwsj/1.jpg
             */

            private String name;
            private String photo;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }
        }

        public static class ShortFilmListBean {
            /**
             * imageUrl : http://172.17.8.100/images/movie/stills/dwsj/dwsj3.jpg
             * videoUrl : http://172.17.8.100/video/movie/dwsj/dwsj1.ts
             */

            private String imageUrl;
            private String videoUrl;

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }

            public String getVideoUrl() {
                return videoUrl;
            }

            public void setVideoUrl(String videoUrl) {
                this.videoUrl = videoUrl;
            }
        }
    }
}
