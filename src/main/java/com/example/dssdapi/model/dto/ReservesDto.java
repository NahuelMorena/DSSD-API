package com.example.dssdapi.model.dto;

import java.util.List;

public class ReservesDto {

    private List<ReserveRequest> reserves;
    public static class ReserveRequest{
        private Long id;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
    }

    public List<ReserveRequest> getReserves() {
        return reserves;
    }

    public void setReserves(List<ReserveRequest> reserves) {
        this.reserves = reserves;
    }
}
