package com.example.Library.Management.System.Dto;

import com.example.Library.Management.System.Entity.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public record BookDto (
        int id,
        String title,
        String author,
        boolean borrowed,
        User BorrowedBy
){
}
