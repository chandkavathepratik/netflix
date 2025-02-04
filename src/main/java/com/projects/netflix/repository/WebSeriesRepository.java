package com.projects.netflix.repository;

import com.projects.netflix.entity.WebShow;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebSeriesRepository extends MongoRepository<WebShow, ObjectId> {
}
