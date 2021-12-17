package com.anzurakiz.pcstore.repository;

import com.anzurakiz.pcstore.model.PurchaseSummary;
import com.anzurakiz.pcstore.model.compositeKeys.PurchaseSummaryId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseSummaryRepository extends JpaRepository<PurchaseSummary, PurchaseSummaryId> {

}
