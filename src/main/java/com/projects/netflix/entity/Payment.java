package com.projects.netflix.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "payments")
@Data
@NoArgsConstructor
public class Payment {

    @Id
    private ObjectId paymentId;

    @NonNull
    private ObjectId userId;

    @NonNull
    private LocalDateTime processedAt;

    @NonNull
    private String paymentStatus;

    @NonNull
    private String paymentMethod;

    @NonNull
    private Float amount;
}
