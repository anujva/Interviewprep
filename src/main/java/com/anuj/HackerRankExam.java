package com.anuj;

import java.util.List;

public class HackerRankExam {

    private static class MovieResult {
        private Integer page;
        private Integer perPage;
        private Integer total;
        private Integer totalPages;
        private List<Movie> data;

        public Integer getPage() {
            return page;
        }

        public void setPage(Integer page) {
            this.page = page;
        }

        public Integer getPerPage() {
            return perPage;
        }

        public void setPerPage(Integer perPage) {
            this.perPage = perPage;
        }

        public Integer getTotal() {
            return total;
        }

        public void setTotal(Integer total) {
            this.total = total;
        }

        public Integer getTotalPages() {
            return totalPages;
        }

        public void setTotalPages(Integer totalPages) {
            this.totalPages = totalPages;
        }

        public List<Movie> getData() {
            return data;
        }

        public void setData(List<Movie> data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "MovieResult{" +
                "page=" + page +
                ", perPage=" + perPage +
                ", total=" + total +
                ", totalPages=" + totalPages +
                ", data=" + data +
                '}';
        }
    }

    private static class Movie {
        private String poster;
        private String title;
        private String type;
        private String year;
        private String imdbID;

        public String getPoster() {
            return poster;
        }

        public void setPoster(String poster) {
            this.poster = poster;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public String getImdbID() {
            return imdbID;
        }

        public void setImdbID(String imdbID) {
            this.imdbID = imdbID;
        }

        @Override
        public String toString() {
            return "Movie{" +
                "poster='" + poster + '\'' +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", year='" + year + '\'' +
                ", imdbID='" + imdbID + '\'' +
                '}';
        }
    }

}
