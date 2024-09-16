package com.example.demo.dto;

import com.example.demo.entity.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaginationData {
    private List<Movie> data;
    private int pageNumber;
    private int dataCount;
    private int totalPages;
    private long totalElements;
}
