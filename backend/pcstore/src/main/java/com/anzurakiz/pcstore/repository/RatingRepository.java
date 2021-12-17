package com.anzurakiz.pcstore.repository;

import com.anzurakiz.pcstore.model.Rating;
import com.anzurakiz.pcstore.model.compositeKeys.RatingId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends JpaRepository<Rating, RatingId> {

}
