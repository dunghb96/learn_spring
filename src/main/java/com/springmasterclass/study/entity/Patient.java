package com.springmasterclass.study.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity // Đánh dấu đây là một JPA Entity
@Table(name = "patients") // Ánh xạ với bảng patients trong DB
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Patient { // (1)

    @Id // Khai báo Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto Increment
    private Long id;

    @Column(name = "full_name", nullable = false, length = 100)
    private String fullName;

    @Column(unique = true, length = 12)
    private String citizenId; // Căn cước công dân

    private LocalDateTime createdAt;

    // cascade - hiệu ứng dây chuyền để  chạy insert hoặc update tới các bảng phụ
    // orphanRemoval - tự động sinh ra câu lệnh delete tới các bảng phụ, ngăn data mồ côi

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
//     @BatchSize(size = 20)
    private List<Checkup> checkups = new ArrayList<>();
}