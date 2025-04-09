package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "servers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Server {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String server_name;
    private String ipAddress;
    private String website;
    private String runningBranch;
    private String changedBy;
    private String reason;
    private String runningVersion;
    private LocalDate lastUpdated;
}
